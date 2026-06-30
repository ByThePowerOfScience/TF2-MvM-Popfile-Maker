package btpos.source.vdfdsl.itemattributesgenerator

import btpos.source.vdfdsl.itemattributesgenerator.ItemAttributesGeneration.BuildConfig
import btpos.source.vdfdsl.itemattributesgenerator.representations.ISortedNamedAttribute
import btpos.source.vdfdsl.itemattributesgenerator.representations.NamedAttribute
import btpos.source.vdfdsl.itemattributesgenerator.representations.groupings.PenaltyBonus
import btpos.source.vdfdsl.itemattributesgenerator.representations.groupings.NamedAttributeScope
import btpos.source.vdfdsl.itemattributesgenerator.representations.groupings.Vis
import btpos.source.vdfdsl.itemattributesgenerator.representations.selectorCodec
import btpos.source.vdfdsl.vdfparser.VdfParser
import btpos.source.vdfdsl.vdfparser.component1
import btpos.source.vdfdsl.vdfparser.component2
import java.io.File
import kotlin.collections.first
import kotlin.collections.fold
import kotlin.collections.mapValues
import kotlin.collections.single
import kotlin.collections.toTypedArray
import kotlin.io.path.Path
import kotlin.io.path.bufferedWriter
import kotlin.io.path.createDirectories
import kotlin.io.path.deleteExisting
import kotlin.io.path.exists
import kotlin.io.path.useDirectoryEntries
import kotlin.let

data class ObjectInProgress(val name: String, val doc: String, val attrs: MutableList<ISortedNamedAttribute> = mutableListOf())


typealias AttrClassName = String


fun <T : Any, U : Any> Map<T?, U>.filterKeysNotNull(): Map<T, U> {
	return this.filterKeys { it != null } as Map<T, U>
}

fun main() {
	generateItemAttributes()
}

fun convertAttributesFromSchema(inGameDescriptionsByAttributeName: Map<String, String>): List<NamedAttribute> {
	return ClassLoader.getSystemClassLoader()
		.getResourceAsStream("attributes.txt")!!
		.readAllBytes()
		.toString(Charsets.UTF_8)
		.let {
			VdfParser.parse(it).second.tableOrNull()!!
		}.map { (id, schema) ->
			val schema: Map<String, String?> = schema.tableOrNull()!!.associate { it.first to it.second.stringOrNull() }.withDefault { "" }
			val name: String by schema
			val attribute_class: String by schema
			val description_string: String? = inGameDescriptionsByAttributeName[name]
			val description_format: String by schema
			val hidden by schema
			val effect_type by schema
			val armory_desc by schema
			val stored_as_integer by schema
			
			NamedAttribute(
				attrName = name,
				inGameDesc = description_string,
				attrType = description_format.removePrefix("value_is_"),
				className = attribute_class,
				effectType = effect_type,
				armory_desc = ArmoryDesc(armory_desc)
			)
		}
}


fun generateItemAttributes() {
	/*
	
	- From the wiki:
		- Named attributes with in-game description, attr class,
	- From the notes:
		- Attribute classes with in-code descriptions
	
	What we're doing:
	- Match all named attributes to the weapon type they inherit from
	- Group all attr classes by their weapon type
	- Each weapon type will be an object that inherits from its parent
	- We don't care about the attrclasses for anything except matching the named attributes against the scope they're supposed to go into, which is done based on attr class
	 */
	
	
	val UNKNOWN_SCOPE = MyNotesFormatted.AttrClassScope("Uncategorized")
	
	val attrClassesByBaseClassFromNotes = MyNotesFormatted.attrsByClass
	
	// get all attributes, but with the descriptions from the ones used in-game
	val allAlreadyFoundAttributeNames = UsefulWikiTableParser.parseWiki().associate { it.first.attrName to it.second }.filterValues { it != null && !it.startsWith("Attrib_") } as Map<String, String>
	
	val allNamedAttributes = convertAttributesFromSchema(allAlreadyFoundAttributeNames)
	
	/**
	 * Sort all named attributes by their class, group them up into scopes
	 */
	val namedAttributeScopesByClassName: Map<String, List<ISortedNamedAttribute>> =
			allNamedAttributes
			.filter { it.className != "set_detonate_mode" } // doing these by hand in additionalWeaponModes.kt
			.onEach {
				when (it.attrName) {
					"medigun charge is crit boost" -> it.setCodec { selectorCodec(1) }
					"medigun charge is resists" -> it.setCodec { selectorCodec(3) }
				}
			}
			.groupBy { it.className }
			.mapValues<_, _, List<ISortedNamedAttribute>> { (clsName, attrsForAClass) ->
				if (clsName == "set_weapon_mode")
					return@mapValues attrsForAClass
				
				if (attrsForAClass.size == 1)
					return@mapValues attrsForAClass
				
				
				val groupedByPositiveOrNegative = attrsForAClass.groupBy { it.positiveOrNegative }
				if (groupedByPositiveOrNegative.size == 1) {
					return@mapValues groupedByPositiveOrNegative.values.single()
				}
				return@mapValues listOf(groupedByPositiveOrNegative.mapValues { (isPos, posOrNegItems) ->
					if (posOrNegItems.isEmpty())
						error("I don't think this should happen but posneg is empty list for $isPos for $attrsForAClass")
					else if (posOrNegItems.size == 1) {
						return@mapValues posOrNegItems.single()
					}
					
					val isHidden = posOrNegItems.groupBy { "hidden" in it.attrName.lowercase() }
					when (isHidden.size) {
						1 -> isHidden.values.first()
							.first()
						2 -> Vis(isHidden[false]!!.first(), isHidden[true]!!.first())
						else -> NamedAttributeScope(posOrNegItems.first().varName.let { removeFromPBName.fold(it) { it, re -> it.replace(re, "") } }, *posOrNegItems.toTypedArray())
					}
				}
					.let { sortedByIsPositive ->
						if (sortedByIsPositive.size == 1) {
							return@let sortedByIsPositive.values.single()
						}
						// convert this into a PenaltyBonus
						if (true in sortedByIsPositive && false in sortedByIsPositive && null !in sortedByIsPositive) {
							PenaltyBonus(
								sortedByIsPositive[false]!!,
								sortedByIsPositive[true]!!
							)
						} else {
							NamedAttributeScope(sortedByIsPositive.values.first().varName.capitalize(), *sortedByIsPositive.values.toTypedArray())
						}
					})
			}
	
	
	

	val scopes = attrClassesByBaseClassFromNotes.mapNotNull { baseClassScope ->
		baseClassScope.absorb(namedAttributeScopesByClassName).singleOrNull() as NamedAttributeScope?
	}
	
	val outDir = Path(BuildConfig.OUT_DIR).resolve(BuildConfig.TARGET_PACKAGE.replace('.', File.separatorChar)).also {
		if (it.exists())
			it.useDirectoryEntries("*.kt") { it.forEach { it.deleteExisting() } }
		else
			it.createDirectories()
	}
	
	scopes.forEach { scope ->
		outDir.resolve(scope.scopeName + ".kt")
			.bufferedWriter()
			.use { writer ->
				writer.write(
					"package ${BuildConfig.TARGET_PACKAGE}\n\n" +
					"import btpos.source.vdfdsl.modeling.*\n" +
					"import btpos.source.vdfdsl.serialization.codecs.*\n"
				)
				writer.newLine()
				writer.newLine()
				scope.generateTopLevelMembers()
					.forEach { topLevel ->
						writer.write(topLevel)
						writer.newLine()
						writer.newLine()
					}
			}
	}
}