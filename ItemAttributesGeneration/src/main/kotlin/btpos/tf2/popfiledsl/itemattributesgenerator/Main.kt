package btpos.tf2.popfiledsl.itemattributesgenerator

import kotlin.collections.mapValues

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
	val hierarchy = MyNotesFormatted.hierarchy
	
	/**
	 * Sort all named attributes by their class, group them up into scopes
	 */
	val namedAttributeScopesByClassName: Map<String, ISortedNamedAttribute> =
		UsefulWikiTableParser.parseWiki()
			.groupBy { it.className }
			.mapValues<_, _, ISortedNamedAttribute> { (_, attrsForAClass) ->
				if (attrsForAClass.size == 1)
					return@mapValues attrsForAClass.first()
				
				attrsForAClass.groupBy { it.positiveOrNegative }
					.mapValues { (isPos, posOrNegItem) ->
						if (posOrNegItem.isEmpty())
							error("I don't think this should happen but posneg is empty list for $isPos for $attrsForAClass")
						else if (posOrNegItem.size == 1) {
							return@mapValues posOrNegItem.first()
						}
						
						val isHidden = posOrNegItem.groupBy { "hidden" in it.attrName.lowercase() }
						when (isHidden.size) {
							1 -> isHidden.values.first().first()
							2 -> Vis(isHidden[false]!!.first(), isHidden[true]!!.first())
							else -> Custom(posOrNegItem.first().varName, posOrNegItem)
						}
					}
					.let { sortedByIsPositive ->
						// convert this into a PenaltyBonus
						if (true in sortedByIsPositive && false in sortedByIsPositive && null !in sortedByIsPositive) {
							PenaltyBonus(
								sortedByIsPositive[false]?.varName ?: sortedByIsPositive[true]?.varName ?: error("No var name for $sortedByIsPositive"),
								sortedByIsPositive[false]!!,
								sortedByIsPositive[true]!!
							)
						} else {
							NamedAttributeScope(sortedByIsPositive.values.first().varName!!.capitalize(), *sortedByIsPositive.values.toTypedArray())
						}
					}
			}
	

	val scopes = attrClassesByBaseClassFromNotes.mapNotNull { baseClassScope ->
		baseClassScope.absorb(namedAttributeScopesByClassName)
	}

	println(scopes.first().generateTopLevelMembers())
}