package btpos.tf2.popfiledsl.itemattributesgenerator

import btpos.tf2.popfiledsl.itemattributesgenerator.filterKeysNotNull
import kotlin.collections.map

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
	
	
	val hierarchy = MyNotesFormatted.hierarchy
	
	val UNKNOWN_SCOPE = MyNotesFormatted.AttrClassScope("Uncategorized")
	
	val attrClassesByBaseClassFromNotes = MyNotesFormatted.attrsByClass
	
	val namedAttrsFromWiki =
		UsefulWikiTableParser.parseWiki().groupBy { it.className }
	

	val scopes = namedAttrsFromWiki.flatMap { (clsName, attrs) ->
		// get the scope containing this attribute
		(attrClassesByBaseClassFromNotes.firstOrNull { (clsName in it) } ?: UNKNOWN_SCOPE).absorb(namedAttrsFromWiki)
	}

	println(scopes.first().generateTopLevelMembers())
}