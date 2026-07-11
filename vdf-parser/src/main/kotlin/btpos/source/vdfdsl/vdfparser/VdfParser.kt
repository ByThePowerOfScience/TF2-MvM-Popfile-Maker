@file:Suppress("UnusedImport")

package btpos.source.vdfdsl.vdfparser

import btpos.source.vdfdsl.backing.VDFKeyValue
import btpos.source.vdfdsl.backing.VDFPrimitive
import btpos.source.vdfdsl.backing.VDFRootFile
import btpos.source.vdfdsl.backing.VDFSubtree
import btpos.source.vdfdsl.vdfparser.ParseVDF.VDFVisitor_Comments.commentText
import btpos.source.vdfdsl.vdfparser.antlr.VDFBaseVisitor
import btpos.source.vdfdsl.vdfparser.antlr.VDFLexer
import btpos.source.vdfdsl.vdfparser.antlr.VDFParser
import btpos.source.vdfdsl.vdfparser.leftOrNull
import btpos.source.vdfdsl.vdfparser.rightOrNull
import com.mojang.datafixers.util.Either
import org.antlr.v4.runtime.CharStreams
import org.antlr.v4.runtime.CommonTokenStream
import org.antlr.v4.runtime.ParserRuleContext
import org.antlr.v4.runtime.Token
import org.antlr.v4.runtime.tree.ParseTree
import java.io.InputStream
import kotlin.collections.map
import kotlin.sequences.toList

class StringOrTable private constructor(val item: Any) {
	constructor(s: String) : this(item=s)
	constructor(t: RawTable) : this(item=t)
	
	val isString
		get() = item is String
	
	val isTable get() = !isString
	
	fun stringOrNull() = item as? String
	
	@Suppress("UNCHECKED_CAST")
	fun tableOrNull() = item as? RawTable
	
	override fun toString(): String {
		return item.toString()
	}
}

interface ITable {
	operator fun get(key: String): StringOrTable?
	
	fun getString(key: String) = get(key)?.stringOrNull()
	
	fun getTable(key: String) = get(key)?.tableOrNull()
}

class RawTable(val rawLines: List<RawLine>) : List<RawLine> by rawLines, ITable {
	fun getDiscardingComments(): Sequence<RawKeyValue> {
		return rawLines.asSequence().filterIsInstance<KeyValueWithEndOfLineComment>().map { it.kv }
	}
	
	override operator fun get(key: String): StringOrTable? {
		return getDiscardingComments().firstOrNull { it.key == key }?.value
	}
}

sealed class RawLine

data class PragmaLineWithComment(val pragma: String, val arg: String?, val comment: String?) : RawLine()

data class LineWithOnlyComment(val comment: String) : RawLine()

object EmptyLine : RawLine() {
	override fun toString() = "EmptyLine"
}

sealed class RawKeyValue {
	abstract val key: String
	
	abstract val value: StringOrTable
}

data class RawKeyValueLiteral(
	override val key: String,
	val literalValue: String
) : RawKeyValue() {
	override val value get() = StringOrTable(literalValue)
}

data class RawKeyValue_TableWithSurroundingComments(
	/**
	 * Comment on the same line as the key:
	 * ```
	 * KEY // comment
	 * {
	 * ...
	 * }
	 */
	val keyEOLComment: String?,
	val afterKeyBeforeBraceComments: List<String>,
	/**
	 * The comment after a table's opening brace:
	 *
	 * ```
	 * KEY
	 * { // comment
	 * ...
	 * }
	 * ```
	 */
	val openBracketEOLComment: String?,
	override val key: String,
	val table: RawTable
) : RawKeyValue() {
	override val value = StringOrTable(table)
}

data class KeyValueWithEndOfLineComment(val kv: RawKeyValue, val eolComment: String?) : RawLine()


object ParseVDF {
	object KeyableVisitor : VDFBaseVisitor<String>() {
		override fun visitKeyable(ctx: VDFParser.KeyableContext): String {
			return ctx.LITERAL()?.text ?: ctx.STRING()?.text?.trim('"') ?: ctx.NUMBER()!!.text
		}
	}
	
	inline fun <T> splitPragma(text: String, factory: (String, String) -> T): T {
		return text.run {
			val firstSpace = indexOf(' ')
			if (firstSpace == -1)
				factory(this, "")
			else
				factory(substring(0, firstSpace), substring(firstSpace + 1))
		}
	}
	
	object VDFVisitor_Comments : VDFBaseVisitor<List<RawLine>>() {
		val ParseTree.commentText: String
			get() = this.text?.removePrefix("//").orEmpty()
		
		val Token.commentText: String
			get() = this.text?.removePrefix("//").orEmpty()
		
		
		
		object HeaderLineVisitor : VDFBaseVisitor<RawLine>() {
			override fun visitHeader_allowed_lines(ctx: VDFParser.Header_allowed_linesContext): RawLine {
				val comment = ctx.COMMENT()?.commentText
				
				val pragma = ctx.PRAGMA()?.text
				             ?: return LineWithOnlyComment(comment!!)
				
				return splitPragma(pragma) { prgm, args ->
					PragmaLineWithComment(prgm, args, comment)
				}
			}
			
			
		}
		
		override fun visitRoot(ctx: VDFParser.RootContext): List<RawLine> {
			val outLines = mutableListOf<RawLine>()
			
			ctx.bases.mapTo(outLines) {
				it.accept(HeaderLineVisitor)
			}
			outLines.add(ctx.firstLine.accept(LineVisitor_Raw))
			ctx.rest?.mapTo(outLines) { it.accept(LineVisitor_Raw) }
			return outLines
		}
		
		object LineVisitor_Raw : VDFBaseVisitor<RawLine>() {
			override fun visitLine(ctx: VDFParser.LineContext): RawLine {
				return ctx.keyvalue()?.let { KeyValueWithEndOfLineComment(it.accept(KeyValueVisitor_Raw), ctx.COMMENT()?.text) }
				       ?: ctx.COMMENT()?.let { LineWithOnlyComment(it.commentText) }
				       ?: EmptyLine
			}
		}
		
		object KeyValueVisitor_Raw : VDFBaseVisitor<RawKeyValue>() {
			override fun visitKeyvalue_strings(ctx: VDFParser.Keyvalue_stringsContext): RawKeyValue {
				return RawKeyValueLiteral(ctx.key.accept(KeyableVisitor), ctx.value.accept(KeyableVisitor))
			}
			
			override fun visitKeyvalue_table(ctx: VDFParser.Keyvalue_tableContext): RawKeyValue {
				val keyEOLComment = ctx.keyEOLComment?.firstOrNull()?.commentText
				val commentsAfterKeyBeforeBrace = ctx.keyEOLComment?.drop(1).orEmpty().map { it.commentText }
				val tbl = ctx.table()!!
				val key = ctx.key.accept(KeyableVisitor)
				val openBraceEOLComment = tbl.tableLBracketComment?.commentText
				return RawKeyValue_TableWithSurroundingComments(keyEOLComment, commentsAfterKeyBeforeBrace, openBraceEOLComment, key, tbl.accept(TableVisitor_Raw))
			}
		}
		
		object TableVisitor_Raw : VDFBaseVisitor<RawTable>() {
			override fun visitTable(ctx: VDFParser.TableContext): RawTable {
				return RawTable(ctx.lines.map {
					it.accept(LineVisitor_Raw)
				})
			}
		}
	}
	
	object VDFVisitor_Data : VDFBaseVisitor<VDFRootFile>() {
		override fun visitRoot(ctx: VDFParser.RootContext): VDFRootFile {
			val bases = ctx.bases.mapNotNull {
				it.accept(PragmaVisitor)
			}
			val items = listOfNotNull(ctx.firstLine.accept(LineVisitor)) +
			       ctx.rest.mapNotNull { it.accept(LineVisitor) }
			
			return VDFRootFile(bases, items)
		}
		
		object PragmaVisitor : VDFBaseVisitor<Pair<String, String>>() {
			override fun visitHeader_allowed_lines(ctx: VDFParser.Header_allowed_linesContext): Pair<String, String>? {
				return ctx.PRAGMA()?.text?.let {
					splitPragma(it, ::Pair)
				}
			}
		}
		
		object LineVisitor : VDFBaseVisitor<VDFKeyValue?>() {
			override fun visitLine(ctx: VDFParser.LineContext): VDFKeyValue? {
				return ctx.keyvalue()?.accept(KeyValueVisitor)
			}
		}
		
		object TableVisitor : VDFBaseVisitor<VDFSubtree>() {
			override fun visitTable(ctx: VDFParser.TableContext): VDFSubtree {
				return VDFSubtree(ctx.lines.mapNotNull { it.accept(LineVisitor) })
			}
		}
		
		object KeyValueVisitor : VDFBaseVisitor<VDFKeyValue>() {
			override fun visitKeyvalue_strings(ctx: VDFParser.Keyvalue_stringsContext): VDFKeyValue {
				return VDFKeyValue(VDFPrimitive(ctx.key.accept(KeyableVisitor)), VDFPrimitive(ctx.value.accept(KeyableVisitor)))
			}
			
			override fun visitKeyvalue_table(ctx: VDFParser.Keyvalue_tableContext): VDFKeyValue {
				return VDFKeyValue(VDFPrimitive(ctx.key.accept(KeyableVisitor)), ctx.table().accept(TableVisitor))
			}
		}
	}
	
	private fun parseRaw(input: InputStream): ParserRuleContext {
		val lexer = VDFLexer(CharStreams.fromStream(input));
		val tokens = CommonTokenStream(lexer);
		
		val parser = VDFParser(tokens);
		return parser.root()
	}
	
	/**
	 * Get a full reproduction of the VDF with all non-semantic information, like comments and empty lines.
	 */
	fun directRepresentation(input: InputStream): List<RawLine> {
		return parseRaw(input).accept(VDFVisitor_Comments)
	}
	
	fun parse(input: InputStream): VDFRootFile {
		return parseRaw(input).accept(VDFVisitor_Data)
	}
}