//package btpos.tf2.popfiledsl
//
//import btpos.tf2.popfiledsl.Parser.Companion.empty
//import btpos.tf2.popfiledsl.Parser.Companion.literal
//
//@JvmInline value class StringOrMap(val value: Any) {
//	val isString
//		get() = value is String
//	val isMap
//		get() = value is Map<*, *>
//
//	fun stringOrNull(): String? {
//		return value as? String
//	}
//
//	@Suppress("UNCHECKED_CAST")
//	fun mapOrNull(): Map<String, StringOrMap>? {
//		return value as? Map<String, StringOrMap>
//	}
//}
////
////class WikiTableParser : Parser<Map<String, StringOrMap>> {
////	companion object {
////		val doubleOpenBrace = literal('{') * literal('{')
////		val doubleCloseBrace = literal('}') * literal('}')
////
////		val word = Parser.regex("\\w+")
////
////		val table = doubleOpenBrace * keyValue *
////
////		val afterKey = (literal('=') * (word or table)) or (word or table) or empty
////		val keyValue = word * afterKey
////	}
////
////	override fun invoke(input: CopyableStringIterator): Pair<Map<String, StringOrMap>, CopyableStringIterator>? {
////
////	}
////}