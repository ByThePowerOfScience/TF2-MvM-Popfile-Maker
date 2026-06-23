package btpos.tf2.popfiledsl.itemattributesgenerator

import btpos.tf2.popfiledsl.itemattributesgenerator.ItemAttributesGeneration.BuildConfig
import btpos.tf2.popfiledsl.itemattributesgenerator.Parser.Companion.NamedParser
import btpos.tf2.popfiledsl.itemattributesgenerator.Parser.Companion.empty
import btpos.tf2.popfiledsl.itemattributesgenerator.Parser.Companion.literal
import btpos.tf2.popfiledsl.itemattributesgenerator.Parser.Companion.map
import btpos.tf2.popfiledsl.itemattributesgenerator.Parser.Companion.named
import btpos.tf2.popfiledsl.itemattributesgenerator.Parser.Companion.optional
import btpos.tf2.popfiledsl.itemattributesgenerator.Parser.Companion.or
import btpos.tf2.popfiledsl.itemattributesgenerator.Parser.Companion.parse
import btpos.tf2.popfiledsl.itemattributesgenerator.Parser.Companion.plus
import btpos.tf2.popfiledsl.itemattributesgenerator.Parser.Companion.star
import btpos.tf2.popfiledsl.itemattributesgenerator.Parser.Companion.string
import btpos.tf2.popfiledsl.itemattributesgenerator.Parser.Companion.then
import btpos.tf2.popfiledsl.itemattributesgenerator.Parser.Companion.thunk
import btpos.tf2.popfiledsl.itemattributesgenerator.WikiTableParser.StringOrMap.Companion.toStringOrMap
import java.time.chrono.JapaneseEra.values
import kotlin.io.path.Path
import kotlin.io.path.readText
import kotlin.io.path.reader

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
	
	val VValues: NamedParser<Either<Map<String, StringOrMap?>, String>?> = ((::table::get.thunk() or V1).optional()).named("(?:V1|table|empty)")
	
	val V = literal('=').then(VValues) { _, j -> j }.named("V")
	
	val kv = literal('|').then(K.then(V) { i, j -> i to j?.toStringOrMap() }.named("KV")) { _, j -> j }.star().map { it.toMap() }.named("|KV")
	val doubleopen = literal('{').then(literal('{')) { _, _ -> null }.named("{{")
	val doubleclose = literal('}').then(literal('}')) { _, _ -> null }.map { null }.named("}}")
	
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

data class NamedAttribute(
	val namedAttr: String,
	val attrId: Int,
	val englishInGameDesc: String,
	val attrClass: String?,
	val valueType: String?,
	val effectType: String?
)
