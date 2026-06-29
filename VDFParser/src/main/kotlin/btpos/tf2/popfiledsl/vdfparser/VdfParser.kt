@file:Suppress("UnusedImport")

package btpos.tf2.popfiledsl.vdfparser

import btpos.tf2.popfiledsl.vdfparser.Parser.Companion.conditional
import btpos.tf2.popfiledsl.vdfparser.Parser.Companion.discard
import btpos.tf2.popfiledsl.vdfparser.Parser.Companion.literal
import btpos.tf2.popfiledsl.vdfparser.Parser.Companion.map
import btpos.tf2.popfiledsl.vdfparser.Parser.Companion.named
import btpos.tf2.popfiledsl.vdfparser.Parser.Companion.optional
import btpos.tf2.popfiledsl.vdfparser.Parser.Companion.or
import btpos.tf2.popfiledsl.vdfparser.Parser.Companion.parse
import btpos.tf2.popfiledsl.vdfparser.Parser.Companion.parseOrThrow
import btpos.tf2.popfiledsl.vdfparser.Parser.Companion.plus

import btpos.tf2.popfiledsl.vdfparser.Parser.Companion.provideDelegate
import btpos.tf2.popfiledsl.vdfparser.Parser.Companion.star
import btpos.tf2.popfiledsl.vdfparser.Parser.Companion.string
import btpos.tf2.popfiledsl.vdfparser.Parser.Companion.then
import btpos.tf2.popfiledsl.vdfparser.Parser.Companion.thunk
import btpos.tf2.popfiledsl.vdfparser.Parser.Companion.whitespace
import btpos.tf2.popfiledsl.vdfparser.Parser.Companion.wordChar
import btpos.tf2.popfiledsl.vdfparser.VdfParser.StringOrTable.Companion.toStringOrTable
import com.mojang.datafixers.util.Either
import com.mojang.datafixers.util.Either.left
import com.mojang.datafixers.util.Either.right
import com.mojang.datafixers.util.Pair


object VdfParser {
	
	class StringOrTable(val item: Any) {
		val isString
			get() = item is String
		
		val isMap get() = item is Map<*, *>
		
		fun stringOrNull() = item as? String
		
		@Suppress("UNCHECKED_CAST")
		fun tableOrNull() = item as? Table
		
		companion object {
			@JvmName("toStringOrMap_String_Map_notnull")
			fun Either<String, Table>.toStringOrTable(): StringOrTable {
				return StringOrTable(this.leftOrNull ?: this.rightOrNull!!)
			}
			
			@JvmName("toStringOrMap_Map_String_notnull")
			fun Either<Table, String>.toStringOrTable(): StringOrTable {
				return StringOrTable(this.leftOrNull ?: this.rightOrNull!!)
			}
		}
		
		override fun toString(): String {
			return item.toString()
		}
	}
	
	typealias Table = List<KeyValue>
	
	typealias KeyValue = Pair<String, StringOrTable>
	
	typealias Line = Either<KeyValueWithLineComment, LineWithOnlyComment>
	
	data class KeyValueWithLineComment(val keyvalue: KeyValue, val comment: String?)
	
	data class LineWithOnlyComment(val comment: String?)
	
	val quote = literal('"').discard()
	val anySpaces = whitespace.star().discard()
	
	val newline = literal('\n').discard()
	
	
	val openbrace = literal('{').discard()
	val closebrace = literal('}').discard()
	val doubleSlash = string("//").discard()
	
	val notQuote = conditional("[^\"]", dontEscapeName = true) { it != '"' }
	
	val anySpacesNotNewline = conditional("notnewline") { it != '\n' && it.isWhitespace() }.star().discard()
	
	val L: Parser<String> by (quote.then(notQuote.star().map { it.replace("\n", " ") } then quote)) or ((wordChar or literal('.')).plus())
	
	val C: Parser<String> by doubleSlash then conditional("[^\n]") { it != '\n' }.star()
	
	typealias TableWithBracketComment = Pair<String?, Table>
	
	val V_T: Parser<Table> by
		(anySpaces
//				then (C then newline then anySpaces).optional().named("(?:C\\n\\s*)?", useRawName = true)
				then ::T::get.thunk())
	
	/** @return Either a literal value or a table (with a possible comment after the opening '{')  */
	val V1 by ((L or V_T))
	
	/** Key to either a literal value or a table with a comment after the opening '{' */
	val KV by (L then anySpaces then V1).map { it.let { (k, v) -> KeyValue(k, v.toStringOrTable()) } }
	
	
	val LINE: Parser<KeyValue> by KV /*(KV.optional() then anySpacesNotNewline)
		.then(C.optional()) { kv, c ->
			if (kv == null)
				return@then right<KeyValueWithLineComment, LineWithOnlyComment>(LineWithOnlyComment(c))
			
			val (key, value) = kv
			value.map ({ literalValue ->
				Pair(StringOrTable(literalValue), c)
			}, { (possiblecommentafterbracket, table) ->
				Pair(StringOrTable(table), possiblecommentafterbracket + c)
			}).let { left(KeyValueWithLineComment(KeyValue(key, it.first), it.second)) }
		}*/
	
	val T: Parser<Table> by lazy {
		(anySpaces then openbrace then anySpaces
				   then (KV then anySpaces).star()
				   then anySpaces then closebrace)
			.named("T")
			.map { it.filterNotNull() }
	}
	
	
	val BASE by (anySpaces then KV) //.then((newline then anySpaces then LINE).star()) { i1, i2 -> listOf(i1) + i2 }
	
	
	
/*
BASE -> (\\s* (KV | C) '\n')*
KV -> L V1
V1 -> \\s* (V_L | V_T) \s* C? '\n'
V_L -> L
V_T -> \s* (C '\n' \s*)? T       // line comments must always end with a newline. 
C -> '//' ([^\n]*)

L -> " L1 | \\w+                     // also convert \n to single space
L1 -> \\w+ L2
L2 -> "

T -> \s* { \\s* T1
T1 -> (T2 \\s*)* }
T2 -> KV | C | empty
 */
	fun parse(vdfFile: String): KeyValue {
		return BASE.parseOrThrow(vdfFile)
	}
}