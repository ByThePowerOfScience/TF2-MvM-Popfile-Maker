@file:Suppress("UnusedImport")

package btpos.source.vdfdsl.vdfparser

import btpos.source.vdfdsl.backing.VDFKeyValue
import btpos.source.vdfdsl.backing.VDFPrimitive
import btpos.source.vdfdsl.backing.VDFSubtree
import btpos.source.vdfdsl.vdfparser.antlr.VDFBaseVisitor
import btpos.source.vdfdsl.vdfparser.antlr.VDFLexer
import btpos.source.vdfdsl.vdfparser.antlr.VDFParser
import org.antlr.v4.runtime.CharStreams
import org.antlr.v4.runtime.CommonTokenStream
import org.antlr.v4.runtime.ParserRuleContext
import org.antlr.v4.runtime.Token
import org.antlr.v4.runtime.tree.ParseTree
import java.io.InputStream
import kotlin.collections.map

class StringOrTable private constructor(val item: Any) {
	constructor(s: String) : this(item=s)
	constructor(t: RawTable) : this(item=t)
	
	val isString
		get() = item is String
	
	val isTable get() = !isString
	
	fun stringOrNull() = item as? String
	
	@Suppress("UNCHECKED_CAST")
	fun subtreeOrNull() = item as? RawTable
	
	override fun toString(): String {
		return item.toString()
	}
}

interface IRawVDFItem {
	fun printRaw(indent: Int): String
	
	fun formatEolComment(string: String?): String {
		return string?.let { " // " + it }.orEmpty()
	}
}

class RawTable(val rawLines: List<RawLine>) : List<RawLine> by rawLines, IRawVDFItem {
	fun getDiscardingComments(): Sequence<RawKeyValue> {
		return rawLines.asSequence().filterIsInstance<KeyValueWithEndOfLineComment>().map { it.kv }
	}
	
	operator fun get(key: String): StringOrTable? {
		return getDiscardingComments().firstOrNull { it.key == key }?.value
	}
	
	override fun printRaw(indent: Int): String {
		return "{\n\t" + rawLines.joinToString("\n\t") { it.printRaw(1) } + "\n}".prependIndent("\t".repeat(indent))
	}
	
	fun getString(key: String) = get(key)?.stringOrNull()
	
	fun getTable(key: String) = get(key)?.subtreeOrNull()
}

sealed class RawLine : IRawVDFItem

data class PragmaLineWithComment(val pragma: String, val arg: String?, val comment: String?) : RawLine() {
	override fun printRaw(indent: Int): String {
		return "#$pragma $arg" + formatEolComment(comment)
	}
}

data class LineWithOnlyComment(val comment: String) : RawLine() {
	override fun printRaw(indent: Int): String {
		return "// " + comment
	}
}

object EmptyLine : RawLine() {
	override fun toString() = "EmptyLine"
	
	override fun printRaw(indent: Int): String {
		return ""
	}
}

sealed class RawKeyValue : IRawVDFItem {
	abstract val key: String
	
	abstract val value: StringOrTable
	
	fun wrapStringIfNeeded(str: String): String {
		if (str.any { it.isWhitespace() }) {
			return '"' + str + '"'
		} else {
			return str
		}
	}
}

data class RawKeyValueLiteral(
	override val key: String,
	val literalValue: String
) : RawKeyValue() {
	override val value get() = StringOrTable(literalValue)
	
	override fun printRaw(indent: Int): String {
		return "${wrapStringIfNeeded(key)} ${wrapStringIfNeeded(literalValue)}"
	}
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
	/**
	 * Comments between the key and the opening brace:
	 * ```
	 * KEY
	 * // comment
	 * // comment
	 * {
	 *  ...
	 * }
	 * ```
	 */
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
	
	override fun printRaw(indent: Int): String {
		val betweenKeyBraceComment = afterKeyBeforeBraceComments.joinToString("\n") { formatEolComment(it) }.takeIf { it.isNotBlank() }?.let { "\n" + it }.orEmpty()
		
		return """${wrapStringIfNeeded(key)}${formatEolComment(keyEOLComment)}${betweenKeyBraceComment}
{${formatEolComment(openBracketEOLComment)}
	${table.rawLines.joinToString("\n\t") { it.printRaw(indent + 1) }}
}""".trimIndent().lineSequence().joinToString("\n" + "\t".repeat(indent))
	}
}

data class KeyValueWithEndOfLineComment(val kv: RawKeyValue, val eolComment: String?) : RawLine() {
	override fun printRaw(indent: Int): String {
		return kv.printRaw(indent) + formatEolComment(eolComment)
	}
}


object ParseVDF {
	object KeyableVisitor : VDFBaseVisitor<String>() {
		override fun visitKeyable(ctx: VDFParser.KeyableContext): String {
			return ctx.LITERAL()?.text ?: ctx.STRING().text.trim('"')
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
		
		
		
		
		override fun visitRoot(ctx: VDFParser.RootContext): List<RawLine> {
			
			
			return ctx.lines.map  { it.accept(LineVisitor_Raw) }
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
	
	object VDFVisitor_Data : VDFBaseVisitor<VDFSubtree>() {
		override fun visitRoot(ctx: VDFParser.RootContext): VDFSubtree {
			val lineVis = LineVisitor(null)
			val items = ctx.lines.mapNotNull { it.accept(lineVis) }
			
			return VDFSubtree(null, items.toMutableList())
		}
		
		
		class LineVisitor(val parent: VDFSubtree?) : VDFBaseVisitor<VDFKeyValue?>() {
			override fun visitLine(ctx: VDFParser.LineContext): VDFKeyValue? {
				return ctx.keyvalue()?.accept(KeyValueVisitor(parent))
			}
		}
		
		class TableVisitor(val parent: VDFSubtree?) : VDFBaseVisitor<VDFSubtree>() {
			override fun visitTable(ctx: VDFParser.TableContext): VDFSubtree {
				val self = VDFSubtree(parent)
				self += ctx.lines.mapNotNull { it.accept(LineVisitor(self)) }
				return self
			}
		}
		
		class KeyValueVisitor(val parent: VDFSubtree?) : VDFBaseVisitor<VDFKeyValue>() {
			override fun visitKeyvalue_strings(ctx: VDFParser.Keyvalue_stringsContext): VDFKeyValue {
				return VDFKeyValue(VDFPrimitive(ctx.key.accept(KeyableVisitor)), VDFPrimitive(ctx.value.accept(KeyableVisitor)), ctx.CONDITIONAL()?.text)
			}
			
			override fun visitKeyvalue_table(ctx: VDFParser.Keyvalue_tableContext): VDFKeyValue {
				return VDFKeyValue(VDFPrimitive(ctx.key.accept(KeyableVisitor)), ctx.table().accept(TableVisitor(parent)), ctx.CONDITIONAL()?.text)
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
	
	fun parse(input: InputStream): VDFSubtree {
		return parseRaw(input).accept(VDFVisitor_Data)
	}
}