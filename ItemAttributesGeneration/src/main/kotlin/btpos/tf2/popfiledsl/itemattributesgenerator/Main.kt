package btpos.tf2.popfiledsl.itemattributesgenerator

import btpos.tf2.popfiledsl.itemattributesgenerator.ItemAttributesGeneration.BuildConfig
import java.io.File
import kotlin.collections.mapValues
import kotlin.io.path.Path
import kotlin.io.path.bufferedWriter
import kotlin.io.path.createDirectories
import kotlin.io.path.deleteExisting
import kotlin.io.path.exists
import kotlin.io.path.useDirectoryEntries

data class ObjectInProgress(val name: String, val doc: String, val attrs: MutableList<ISortedNamedAttribute> = mutableListOf())


typealias AttrClassName = String


fun <T : Any, U : Any> Map<T?, U>.filterKeysNotNull(): Map<T, U> {
	return this.filterKeys { it != null } as Map<T, U>
}

fun main() {
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
	
	
	
	/**
	 * Sort all named attributes by their class, group them up into scopes
	 */
	val namedAttributeScopesByClassName: Map<String, List<ISortedNamedAttribute>> =
		UsefulWikiTableParser.parseWiki()
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
				return@mapValues listOf(groupedByPositiveOrNegative.mapValues { (isPos, posOrNegItem) ->
					if (posOrNegItem.isEmpty())
						error("I don't think this should happen but posneg is empty list for $isPos for $attrsForAClass")
					else if (posOrNegItem.size == 1) {
						return@mapValues posOrNegItem.single()
					}
					
					val isHidden = posOrNegItem.groupBy { "hidden" in it.attrName.lowercase() }
					when (isHidden.size) {
						1 -> isHidden.values.first()
							.first()
						2 -> Vis(isHidden[false]!!.first(), isHidden[true]!!.first())
						else -> Custom(posOrNegItem.first().varName, posOrNegItem)
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
	
	val outDir = Path(BuildConfig.GENERATED_FILES_DIR).resolve(BuildConfig.GENERATED_FILE_PACKAGE.replace('.', File.separatorChar)).also {
		if (it.exists())
			it.useDirectoryEntries("*.kt") { it.forEach { it.deleteExisting() } }
		else
			it.createDirectories()
	}
	
	scopes.forEach { scope ->
		outDir.resolve(scope.scopeName + ".kt").run {
			bufferedWriter().use { writer ->
				writer.write("package ${BuildConfig.GENERATED_FILE_PACKAGE}\n\n" +
				             "import btpos.tf2.popfiledsl.modeling.*\n" +
				             "import btpos.tf2.popfiledsl.serialization.codecs.*\n")
				writer.newLine()
				writer.newLine()
				scope.generateTopLevelMembers().forEach { topLevel ->
					writer.write(topLevel)
					writer.newLine()
					writer.newLine()
				}
			}
		}
	}
}