package btpos.source.vdfdsl.tf2.filegeneration

import btpos.source.vdfdsl.backing.VDFObject
import btpos.source.vdfdsl.backing.VDFSubtree
import btpos.source.vdfdsl.backing.asString
import btpos.source.vdfdsl.backing.asSubtree
import btpos.source.vdfdsl.backing.getAll
import btpos.source.vdfdsl.backing.getString
import btpos.source.vdfdsl.backing.getSubtree
import btpos.source.vdfdsl.backing.toMap
import btpos.source.vdfdsl.backing.toMultiMap
import btpos.source.vdfdsl.tf2.filegeneration.TF2ItemGeneration.BuildConfig
import btpos.source.vdfdsl.vdfparser.ParseVDF
import java.io.File
import java.io.InputStream
import java.nio.file.Path
import java.util.LinkedList
import java.util.Queue
import kotlin.io.path.Path
import kotlin.io.path.bufferedWriter
import kotlin.io.path.createDirectories
import kotlin.sequences.asSequence
import kotlin.sequences.mapNotNull


class WeaponDesc private constructor(val weapon_name: String, val item_class: String, /*val attributes: List<Attr>*/) {
	companion object {

		fun getBaseClass(prefab: String, prefabs: Map<String, VDFObject>): String? {
			for (item in prefab.split(" ")) {
				if (!item.startsWith("weapon_"))
					continue;
				val x = prefabs[item]?.asSubtree?.let { it.toMap() } ?: error("No prefab entry for referenced prefab $item")
				if ("item_class" in x) {
					return x["item_class"]?.asString!!
				} else if ("prefab" in x) {
					return getBaseClass(x["prefab"]?.asString!!, prefabs)
				}
			}
			return null;
		}

		operator fun invoke(map: Map<String, VDFObject>, prefabs: Map<String, VDFObject>): WeaponDesc? {
			val name = map["name"]?.asString ?: return null
			val cls = map["item_class"]?.asString
			          ?: map["prefab"]?.let { getBaseClass(it.asString!!, prefabs) }

//			if ("Carbine" in name) {
//				println("class: $cls")
//				println("item_class: ${map["item_class"]!!.asString}")
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

fun Map<String, VDFObject>.getMap(index: String): Map<String, VDFObject>? {
	return this[index]?.asSubtree?.toMap()
}

fun Map<String, VDFObject>.getString(index: String): String? {
	return this[index]?.asString
}


fun getAllItemParentsRecursive(itemTable: VDFSubtree, allPrefabs: Map<String, VDFObject>): Sequence<VDFSubtree> {
	return PrefabParentIterator(itemTable, allPrefabs).asSequence()
}

class PrefabParentIterator(startItem: VDFSubtree, val allPrefabs: Map<String, VDFObject>) : Iterator<VDFSubtree> {
	var startItem: VDFSubtree? = startItem
		private set
	
	val nextPrefabsToCheck: Queue<String> = LinkedList()
	
	override fun hasNext(): Boolean {
		return startItem != null || nextPrefabsToCheck.isNotEmpty()
	}
	
	fun addPrefabsToQueue(itemTable: VDFSubtree) {
		itemTable.getAll("prefab").forEach {
			it.asString?.split(' ')?.let { nextPrefabsToCheck.addAll(it) } ?: error("Not a string: $it")
		}
	}
	
	override fun next(): VDFSubtree {
		if (startItem != null) {
			return startItem!!.also {
				addPrefabsToQueue(it)
				startItem = null
			}
		} else {
			val nextPrefab = nextPrefabsToCheck.poll()
			return allPrefabs[nextPrefab]?.asSubtree?.also {
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
		
	    fun fromItemTable(itemTable: VDFSubtree, allPrefabs: Map<String, VDFObject>): CosmeticDesc? {
			val itemName = itemTable.getString("name") ?: error("No name field found in $itemTable")
			
			return getAllItemParentsRecursive(itemTable, allPrefabs).mapNotNull { item ->
				val itemMap = item.toMultiMap()
				val itemSlot = itemMap["item_slot"]?.single()?.asString?.also {
					when (it) {
						"secondary", "primary", "melee", "action",
							 "pda", "pda2", "building" -> return@mapNotNull null
					};
				}
				
				val usedByClasses = itemMap["used_by_classes"]?.single()?.asSubtree?.map { (k, v) ->
					k.stringValue
				}
				val equipRegions = itemMap["equip_region"]?.single()?.asString?.let { listOf(it) }
				                   ?: itemMap["equip_regions"]?.single()?.run {
									   asString?.split(' ') ?: asSubtree?.mapNotNull { (k, v) -> k.takeIf { v.asString == "1" }?.stringValue }
				                   }
				
				val isPaintable = itemMap["capabilities"]?.single()?.asSubtree?.getString("paintable") == "1"
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

fun getItemSchema(): VDFSubtree {
	val schemaFile =  ClassLoader.getSystemClassLoader().getResourceAsStream("items_game.txt") ?: error("Expected item schema to be at src/main/resources/items_game.txt. Retrieve it at <TF2 folder>/tf/scripts/items/items_game.txt")
	return ParseVDF.parse(schemaFile).getSubtree("items_game") ?: error("No items_game entry found in item schema...")
}

fun main() {
	generateCosmetics(getItemSchema())
}


fun generateAttributesNotes(parsedItemSchema: VDFSubtree, outputFile: Path) {
//	val prefabs = parsedItemSchema.getSubtree("prefabs")!!.single().toMap()
	
	val hierarchy = MyNotesFormatted.hierarchy
	val attrsByClass = MyNotesFormatted.attrsByClass
	
	fun getParentOfTFClass(tfclass: String): MyNotesFormatted.HierarchyAttrClassScope? {
		val parentName = hierarchy.entries.firstOrNull { (_, v) -> tfclass in v }?.key ?: return null;
		
		return attrsByClass.first { it.name == parentName } as MyNotesFormatted.HierarchyAttrClassScope
	}
	
	fun getParentSequence(tfclass: String): Sequence<MyNotesFormatted.HierarchyAttrClassScope> {
		return generateSequence(getParentOfTFClass(tfclass)) { getParentOfTFClass(it.name) }
	}
	
	data class AttrSchema(val name: String, val attr_class: String)
	
	
	fun getHighestParent(attribute_class: String): String {
		var highestOwner = attrsByClass.firstOrNull { attribute_class in it }
		                   ?: return "!!!NOT FOUND!!!";
		
		getParentSequence(highestOwner.name).forEach { parent ->
			if (attribute_class in parent)
				highestOwner = parent
		}
		
		return highestOwner.name
	}
	
	val descriptionsByAttributeName = UsefulWikiTableParser.parseWiki().associate { (attr, desc) ->
		attr.attrName to desc
	}
	
	fun distanceToRoot(tfclass: String): Int {
		if (tfclass == "!!!NOT FOUND!!!") {
			return Int.MAX_VALUE
		}
		return getParentSequence(tfclass).count() + 1
	}
	
	outputFile.bufferedWriter().use { out ->
		val attrs = parsedItemSchema.getSubtree("attributes")!!
			.asSequence()
			.mapNotNull { (_, table) ->
				val table = table.asSubtree!!
				val name = table.getString("name")
				           ?: return@mapNotNull null
				val attrClass = table.getString("attribute_class")
				                ?: return@mapNotNull null
				AttrSchema(name, attrClass)
			}
			.groupBy({ it.attr_class }, { it.name })
			
		attrs.entries
			.groupBy { (attr_class, _) ->
				getHighestParent(attr_class)
			}
			.entries
			.sortedBy { (highestParent, _) -> distanceToRoot(highestParent) }
			.forEach { (parent, classToAttrNames) ->
				out.append("\n## ").append(parent).appendLine()
				getParentSequence(parent).joinToString { it.name }.takeIf { it.isNotEmpty() }?.let {
					out.append("- Inherits from: ").append(it).appendLine()
				}
				
				classToAttrNames.forEach { (attr_class, attrNames) ->
					out.append("- `").append(attr_class).append("`").appendLine()
					attrNames.forEach { namedAttr ->
						out.append("\t- ").append(namedAttr)
						descriptionsByAttributeName[namedAttr]?.let {
							out.append(" - \"").append(it).append('"')
						}
						out.appendLine()
					}
				}
			}
	}
	
}

fun generateCosmetics(parsedItemSchema: VDFSubtree) {
	val prefabs = parsedItemSchema.getSubtree("prefabs")!!.toMap()
	
	val (allCosmetics, allMedals) = parsedItemSchema.getSubtree("items")!!
		.asSequence()
		.mapNotNull { it.value.asSubtree }
		.mapNotNull { CosmeticDesc.fromItemTable(it, prefabs) }
		.groupBy { "medal" in it.equipRegions }
		.let { it[false]!! to it[true]!! }
	
	
	val outDir = Path(BuildConfig.OUT_DIR).resolve(BuildConfig.COSMETICS_TARGET_PACKAGE.replace('.', File.separatorChar)).createDirectories()
	
	fun Appendable.writeObjectHeader(pkg: String, objName: String, vararg imports: String) {
		append("package ").append(pkg)
		append("\n\n")
		imports.forEach {
			append("import ").append(it).append('\n')
		}
		append("\n\n\nobject ").append(objName).append(" {")
		
	}
	
	outDir.resolve("Cosmetics.kt").bufferedWriter().use { writer ->
		writer.writeObjectHeader(basecosmeticspackage, "Cosmetics", itemsimport)
		
		allCosmetics.forEach {
			writer.append("\n\t@JvmField val ").append(it.varname).append(" = TFItemFactory.WEARABLE(\"").append(it.item_name).append("\")")
		}
		
		writer.append("\n}")
	}
	
//	outDir.resolve("CosmeticsMedals.kt").bufferedWriter().use { writer ->
//		writer.writeObjectHeader(basecosmeticspackage, "CosmeticsMedals", itemsimport)
//
//		allMedals.forEach {
//			writer.append("\n\t@JvmField val ").append(it.varname).append(" = TFItemFactory.WEARABLE(\"").append(it.item_name).append("\")")
//		}
//
//		writer.append("\n}")
//	}
	
	// this is why I got a laptop with an insane amount of RAM: so I can do lazy stuff like this in my scripts
	mutableMapOf<String, MutableList<CosmeticDesc>>().let { bySlot ->
		allCosmetics.forEach { cosmetic ->
			if (cosmetic.isHat)
				bySlot.computeIfAbsent("hat") { mutableListOf() }.add(cosmetic)
			else {
				for (slot in cosmetic.equipRegions) {
					bySlot.computeIfAbsent(slot.lowercase()) { mutableListOf() }.add(cosmetic)
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
					writer.writeObjectHeader(basecosmeticspackage + ".byslot", objName, basecosmeticspackage + ".Cosmetics")
					for (cosmetic in cosmetics) {
						writer.append("\n\tval ").append(cosmetic.varname).append(" get() = Cosmetics.").append(cosmetic.varname)
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
			byClassBySlot.computeIfAbsent(tfclass.trim().lowercase()) { mutableMapOf() }.computeIfAbsent(slot.trim().lowercase()) { mutableListOf() }.add(desc)
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
						file.append("\n\t\t\tval ").append(cosm.varname).append(" get() = Cosmetics.").append(cosm.varname)
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