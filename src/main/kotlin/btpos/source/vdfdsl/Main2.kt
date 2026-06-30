package btpos.source.vdfdsl

import btpos.source.vdfdsl.vdfparser.VdfParser
import java.io.FileWriter
import kotlin.io.path.Path
import kotlin.io.path.readText

 ~/2/tf/scripts/items/items_game.txt"


fun VdfParser.Table.toMap(): Map<String, VdfParser.StringOrTable> {
	return associate { it.first to it.second }
}

class WeaponDesc private constructor(val weapon_name: String, val item_class: String, /*val attributes: List<Attr>*/) {
	companion object {

		fun getBaseClass(prefab: String, prefabs: Map<String, VdfParser.StringOrTable>): String? {
			for (item in prefab.split(" ")) {
				if (!item.startsWith("weapon_"))
					continue;
				val x = prefabs[item]?.tableOrNull()?.let { it.toMap() } ?: error("No prefab entry for referenced prefab $item")
				if ("item_class" in x) {
					return x["item_class"]?.stringOrNull()!!
				} else if ("prefab" in x) {
					return getBaseClass(x["prefab"]?.stringOrNull()!!, prefabs)
				}
			}
			return null;
		}

		operator fun invoke(map: Map<String, VdfParser.StringOrTable>, prefabs: Map<String, VdfParser.StringOrTable>): WeaponDesc? {
			val name = map["name"]?.stringOrNull() ?: return null
			val cls = map["item_class"]?.stringOrNull()
			          ?: map["prefab"]?.let { getBaseClass(it.stringOrNull()!!, prefabs) }

//			if ("Carbine" in name) {
//				println("class: $cls")
//				println("item_class: ${map["item_class"]!!.stringOrNull()}")
//				println("prefab: ${map["prefab"]}")
//			}
			if (cls == null)
				return null;
//			val attrs = map["attributes"]
//				?.let {
//					(it as Map<String, Any>).map {
//						Attr(it.toPair().also { if (it.second !is Map<*, *>) throw Exception()
//						} as Pair<String, Map<String, Any>>)
//					}
//				}.orEmpty()
			return WeaponDesc(name, cls)
		}
	}
}


class CosmeticDesc(val item_name: String, val classes: List<String>, val equip_regions: List<String>, ) {
	companion object {
	    operator fun invoke(itemTable: VdfParser.Table, prefabs: Map<String, VdfParser.StringOrTable>): CosmeticDesc? {
			val table = itemTable.toMap()
		   
	    }
	}
}

fun main() {
	val parsedItemSchema = VdfParser.parse(Path(item_schema).readText()).second.tableOrNull()!!
	
	val prefabs = parsedItemSchema.first { it.first == "prefabs" }.second.tableOrNull()!!
		.let { it.toMap() }
	
	val items = parsedItemSchema.first { it.first == "items" }.second.tableOrNull()!!.asSequence().mapNotNull {
		it.second.tableOrNull()?.toMap()
	}
	
	
	
 ~/->
//			parsedItemSchema.first { it.first == "items" }.second.tableOrNull()!!
//				.asSequence()
//				.mapNotNull {
//					CosmeticDesc.invoke()
//				}
//				.groupBy { it.item_class }
//				.forEach { (item_class, weapons) ->
//					outfile.write(item_class + ": " + weapons.joinToString(", ") { it.weapon_name } + "\n")
//				}
		}
}