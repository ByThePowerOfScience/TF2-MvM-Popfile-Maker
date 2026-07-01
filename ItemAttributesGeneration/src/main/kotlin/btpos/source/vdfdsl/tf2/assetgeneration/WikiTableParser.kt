package btpos.source.vdfdsl.tf2.assetgeneration

import btpos.source.vdfdsl.tf2.assetgeneration.Parser.Companion.map
import btpos.source.vdfdsl.tf2.assetgeneration.Parser.Companion.named
import btpos.source.vdfdsl.tf2.assetgeneration.Parser.Companion.optional
import btpos.source.vdfdsl.tf2.assetgeneration.Parser.Companion.or
import btpos.source.vdfdsl.tf2.assetgeneration.Parser.Companion.plus
import btpos.source.vdfdsl.tf2.assetgeneration.Parser.Companion.star
import btpos.source.vdfdsl.tf2.assetgeneration.Parser.Companion.string
import btpos.source.vdfdsl.tf2.assetgeneration.Parser.Companion.then
import btpos.source.vdfdsl.tf2.assetgeneration.Parser.Companion.thunk
import btpos.source.vdfdsl.tf2.assetgeneration.WikiTableParser.StringOrMap.Companion.toStringOrMap

object WikiTableParser {
	class StringOrMap(val item: Any) {
		val isString
			get() = item is String
		
		val isMap get() = item is Map<*, *>
		
		fun stringOrNull() = item as? String
		
		fun mapOrNull() = item as? Map<String, StringOrMap>
		
		companion object {
			@JvmName("toStringOrMap_String_Map")
			fun Either<String, Map<String, StringOrMap?>>.toStringOrMap(): StringOrMap {
				return StringOrMap(this.left ?: this.right!!)
			}
			@JvmName("toStringOrMap_Map_String")
			fun Either<Map<String, StringOrMap?>, String>.toStringOrMap(): StringOrMap {
				return StringOrMap(this.left ?: this.right!!)
			}
		}
		
		override fun toString(): String {
			return item.toString()
		}
	}
	
	val V1 = Parser.conditional("[^|{}]") {
		it != '|' && it != '{' && it != '}'
	}.plus().named("V1")
	
	
	val K = Parser.conditional("[^\\{\\}=]") { it != '{' && it != '}' && it != '=' && it != '|' }.plus()
	
	val VValues: Parser.Companion.NamedParser<Either<Map<String, StringOrMap?>, String>?> = ((::table::get.thunk() or V1).optional()).named("(?:V1|table|empty)")
	
	val V = Parser.literal('=')
		.then(VValues) { _, j -> j }.named("V")
	
	val kv = Parser.literal('|')
		.then(K.then(V) { i, j -> Pair<String, StringOrMap?>(i, j?.toStringOrMap()) }.named("KV")) { _, j -> j }.star().map { it.toMap() }.named("|KV")
	val doubleopen = Parser.literal('{')
		.then(Parser.literal('{')) { _, _ -> null }.named("{{")
	val doubleclose = Parser.literal('}')
		.then(Parser.literal('}')) { _, _ -> null }.map { null }.named("}}")
	
	val table: Parser<Map<String, StringOrMap?>> by lazy {
		(doubleopen
			.then(K) { _, _ -> null }
			.then(kv) { _, j -> j }
			.then(doubleclose) { i, _ -> i }
				).named("table")
	}
	
	val baseParser = string("{{List of item attributes/Header}}")
		.then(
			(Parser.whitespace.star()
				.then(string("|-")) { _, _ -> null }
				.then(Parser.whitespace.star()) { _, _ -> null }
				.then(::table::get.thunk()) { _, it -> it })
				.plus()
		) { _, it -> it }
		.then((Parser.whitespace.star().then(string("|}")) { _, _ -> null }).optional()) { it, _ -> it }
		
	
//
//	fun parseWiki(): List<NamedAttribute> {
//		val base = baseParser.parse(Path(BuildConfig.WIKI_TABLE_FILE).readText()) ?: error("Failed to parse file.")
//		return base.mapNotNull { it: Map<String, StringOrMap?> ->
//			val id = it["id"]!!
//			val name = it["name"] ?: return@mapNotNull null
//			val desc = it.get("description")?.mapOrNull()?.get("en")?.stringOrNull()
//			val valueType = it["value-type"]
//			val cls = it["class"]
//			val effectType = it["effect-type"]
//			val notes = it.get("notes")?.mapOrNull()?.keys?.toList().orEmpty()
//
//			NamedAttribute(name.stringOrNull()!!, id.stringOrNull()!!.toInt(), desc.orEmpty(), cls?.stringOrNull(), valueType?.stringOrNull(), effectType?.stringOrNull(), notes)
//		}
//	}
}

