package btpos.source.vdfdsl.tf2.filegeneration

import btpos.source.vdfdsl.tf2.filegeneration.TF2ItemGeneration.BuildConfig
import btpos.source.vdfdsl.vdfparser.VdfParser
import btpos.source.vdfdsl.vdfparser.component1
import btpos.source.vdfdsl.vdfparser.component2
import java.io.File
import java.util.LinkedList
import java.util.Queue
import kotlin.io.path.Path
import kotlin.io.path.bufferedWriter
import kotlin.io.path.createDirectories
import kotlin.io.path.createDirectory
import kotlin.io.path.exists
import kotlin.io.path.readText



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

fun Map<String, VdfParser.StringOrTable>.getMap(index: String): Map<String, VdfParser.StringOrTable>? {
	return this[index]?.tableOrNull()?.toMap()
}

fun Map<String, VdfParser.StringOrTable>.getString(index: String): String? {
	return this[index]?.stringOrNull()
}

val VdfParser.Table.prefabs get() = firstOrNull { it.first == "prefab" }?.second?.stringOrNull()

operator fun VdfParser.Table.get(index: String): VdfParser.StringOrTable? = this.firstOrNull { it.first == index }?.second



fun getAllItemParentsRecursive(itemTable: VdfParser.Table, allPrefabs: Map<String, VdfParser.StringOrTable>): Sequence<VdfParser.Table> {
	return PrefabParentIterator(itemTable, allPrefabs).asSequence()
}

class PrefabParentIterator(startItem: VdfParser.Table, val allPrefabs: Map<String, VdfParser.StringOrTable>) : Iterator<VdfParser.Table> {
	var startItem: VdfParser.Table? = startItem
		private set
	
	val nextPrefabsToCheck: Queue<String> = LinkedList()
	
	override fun hasNext(): Boolean {
		return startItem != null || nextPrefabsToCheck.isNotEmpty()
	}
	
	fun addPrefabsToQueue(itemTable: VdfParser.Table) {
		itemTable.prefabs?.split(' ')?.let { nextPrefabsToCheck.addAll(it) }
	}
	
	override fun next(): VdfParser.Table {
		if (startItem != null) {
			return startItem!!.also {
				addPrefabsToQueue(it)
				startItem = null
			}
		} else {
			val nextPrefab = nextPrefabsToCheck.poll()
			return allPrefabs[nextPrefab]?.tableOrNull()?.also {
				addPrefabsToQueue(it)
			} ?: error("No prefab found: $nextPrefab")
		}
	}
	
}

val re_notWordChar = Regex("\\W")
data class CosmeticDesc(
	val item_name: String,
	val equipRegions: Set<String>,
	val itemSlots: Set<String>,
	val usedByClasses: Set<String>,
	val isPaintable: Boolean,
) {
	val varname = item_name.uppercase().replace(" ", "_").replace(re_notWordChar, "")
	
	val isAllClass = usedByClasses.size == 9
	
	val isHat = itemSlots.contains("hat")
	
	companion object {
		data class TempRecord(val equipRegions: List<String>?, val itemSlot: String?, val equipClass: List<String>?, val paintable: Boolean)
		
		data class TempRecordCollector(val equipRegions: MutableList<String> = mutableListOf(), val itemSlots: MutableList<String> = mutableListOf(), val equipClass: MutableList<String> = mutableListOf(), var isPaintable: Boolean = false) {
			var hasChanged = false
			
			fun consume(tempRecord: TempRecord): TempRecordCollector {
				tempRecord.equipRegions?.let {
					hasChanged = true
					equipRegions.addAll(it)
				}
				tempRecord.equipClass?.let {
					hasChanged = true
					this.equipClass.addAll(it)
				}
				tempRecord.itemSlot?.let {
					hasChanged = true
					this.itemSlots.add(it)
				}
				
				this.isPaintable = this.isPaintable || tempRecord.paintable
				return this;
			}
			
			fun init(name: String): CosmeticDesc? {
				if (!hasChanged || equipRegions.isEmpty())
					return null;
				return CosmeticDesc(name, equipRegions.toSet(), itemSlots.toSet(), equipClass.toSet(), isPaintable)
			}
		}
		
	    fun fromItemTable(itemTable: VdfParser.Table, allPrefabs: Map<String, VdfParser.StringOrTable>): CosmeticDesc? {
			val itemName = itemTable["name"]?.stringOrNull() ?: error("No name field found in $itemTable")
			
			return getAllItemParentsRecursive(itemTable, allPrefabs).mapNotNull { item ->
				val itemMap = item.toMap()
				val itemSlot = itemMap["item_slot"]?.stringOrNull()?.also {
					when (it) {
						"secondary", "primary", "melee", "action",
							 "pda", "pda2", "building" -> return@mapNotNull null
					};
				}
				
				val usedByClasses = itemMap["used_by_classes"]?.tableOrNull()?.map { (k, v) ->
					k
				}
				val equipRegions = itemMap.getString("equip_region")?.let { listOf(it) }
				                   ?: itemMap["equip_regions"]?.run {
									   stringOrNull()?.split(' ') ?: tableOrNull()?.mapNotNull { (k, v) -> k.takeIf { v.stringOrNull() == "1" } }
				                   }
				
				val isPaintable = itemMap.getMap("capabilities")?.getString("paintable") == "1"
				if (usedByClasses == null && equipRegions == null && !isPaintable)
					null
				else
					TempRecord(equipRegions, itemSlot, usedByClasses, isPaintable)
			}.fold(TempRecordCollector()) { acc, record ->
				acc.consume(record)
			}.init(itemName)
	    }
	}
}

private const val basecosmeticspackage = BuildConfig.COSMETICS_TARGET_PACKAGE

const val itemsimport = BuildConfig.ITEM_FACTORY_LOCATION

fun getItemSchema(): String {
	val itemSchema = ClassLoader.getPlatformClassLoader().getResourceAsStream("items_game.txt") ?: error("Expected item schema to be in resources folder named items_game.txt. Retrieve it at <TF2 folder>/tf/scripts/items/items_game.txt")
	return itemSchema.bufferedReader().use { it.readText() }
}

fun main() {
	val parsedItemSchema = VdfParser.parse(getItemSchema()).second.tableOrNull()!!
	
	val prefabs = parsedItemSchema.first { it.first == "prefabs" }.second.tableOrNull()!!
		.let { it.toMap() }
	
	val (allCosmetics, allMedals) = parsedItemSchema.first { it.first == "items" }.second.tableOrNull()!!.asSequence().mapNotNull {
		it.second.tableOrNull()
	}.mapNotNull {
		CosmeticDesc.fromItemTable(it, prefabs)
	}.groupBy { "medal" in it.equipRegions }.let { it[false]!! to it[true]!! }
	
	
	val outDir = Path(BuildConfig.OUT_DIR).resolve(BuildConfig.ATTRIBUTES_TARGET_PACKAGE.replace('.', File.separatorChar)).createDirectories()
	
	fun Appendable.writeObjectHeader(pkg: String, objName: String, vararg imports: String) {
		append("package ").append(pkg)
		append("\n\n")
		imports.forEach {
			append("import ").append(it).append('\n')
		}
		append("\n\n\nobject ").append(objName).append(" {")
		
	}
	
	outDir.resolve("AllCosmetics.kt").bufferedWriter().use { writer ->
		writer.writeObjectHeader(basecosmeticspackage, "AllCosmetics", itemsimport)
		
		allCosmetics.forEach {
			writer.append("\n\t@JvmField val ").append(it.varname).append(" = TFItemFactory.WEARABLE(\"").append(it.item_name).append("\")")
		}
		
		writer.append("\n}")
	}
	
	outDir.resolve("CosmeticsMedals.kt").bufferedWriter().use { writer ->
		writer.writeObjectHeader(basecosmeticspackage, "CosmeticsMedals", itemsimport)
		
		allCosmetics.forEach {
			writer.append("\n\t@JvmField val ").append(it.varname).append(" = TFItemFactory.WEARABLE(\"").append(it.item_name).append("\")")
		}
		
		writer.append("\n}")
	}
	
	// this is why I got a laptop with an insane amount of RAM: so I can do lazy stuff like this in my scripts
	mutableMapOf<String, MutableList<CosmeticDesc>>().let { bySlot ->
		allCosmetics.forEach { cosmetic ->
			if (cosmetic.isHat)
				bySlot.computeIfAbsent("hat") { mutableListOf() }.add(cosmetic)
			else {
				for (slot in cosmetic.equipRegions) {
					bySlot.computeIfAbsent(slot) { mutableListOf() }.add(cosmetic)
				}
			}
		}
		
		val out = outDir.resolve("byslot").createDirectories()
		
		outDir.resolve("CosmeticsBySlot.kt").bufferedWriter().use { navigator ->
			navigator.writeObjectHeader(basecosmeticspackage, "CosmeticsBySlot", basecosmeticspackage + ".byslot.*", itemsimport)
			
			bySlot.forEach { (slot, cosmetics) ->
				val slotname = slot.camelCase().replaceFirstChar { it.uppercaseChar() }
				val objName = "CosmeticsBySlot_" + slotname
				out.resolve(objName + ".kt").bufferedWriter().use { writer ->
					writer.writeObjectHeader(basecosmeticspackage + ".byslot", objName, basecosmeticspackage + ".AllCosmetics")
					for (cosmetic in cosmetics) {
						writer.append("\n\tval ").append(cosmetic.varname).append(" get() = AllCosmetics.").append(cosmetic.varname)
					}
					writer.append("\n}")
				}
				
				navigator.append("\n\tval ").append(slotname).append(" get() = ").append(objName)
			}
			
			navigator.write("\n}")
		}
	}
	
	
	// by class -> by slot
	mutableMapOf<String, MutableMap<String, MutableList<CosmeticDesc>>>().let { byClassBySlot ->
		fun putCosmetic(tfclass: String, slot: String, desc: CosmeticDesc) {
			byClassBySlot.computeIfAbsent(tfclass) { mutableMapOf() }.computeIfAbsent(slot) { mutableListOf() }.add(desc)
		}
		
		allCosmetics.forEach { cosm ->
			if ("medal" in cosm.equipRegions)
				return@forEach;
			val equippableClasses = if (cosm.isAllClass) {
				listOf("all_class")
			} else {
				cosm.usedByClasses
			}
			
			val equippableSlots = if (cosm.isHat) listOf("hat") else cosm.equipRegions
			
			equippableClasses.forEach { cls ->
				equippableSlots.forEach { slot ->
					putCosmetic(cls, slot, cosm)
				}
			}
		}
		
		
		outDir.resolve("CosmeticsByClass.kt").bufferedWriter().use { file ->
			file.writeObjectHeader(basecosmeticspackage, "CosmeticsByClass")
			
			byClassBySlot.forEach { (cls, byslot) ->
				val className = cls.camelCase().capitalize()
				
				file.append("\n\tobject ").append(className).append(" {")
				
				byslot.forEach { (slot, cosmetics) ->
					val slotName = slot.camelCase().capitalize()
					file.append("\n\t\tobject ").append(slotName).append(" {")
					
					cosmetics.forEach { cosm ->
						file.append("\n\t\t\tval ").append(cosm.varname).append(" get() = AllCosmetics.").append(cosm.varname)
					}
					
					file.append("\n\t\t}")
				}
				
				file.append("\n\t}\n")
			}
			
			file.append("\n}")
		}
		
	}
	
	// do one big file with all cosmetics for searching by name
	// then files sorted by slot, linking to that one big file
	// then sorted by class and slot, also linking to that one big file
}