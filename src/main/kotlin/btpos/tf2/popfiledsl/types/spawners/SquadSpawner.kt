package btpos.tf2.popfiledsl.types.spawners

import btpos.tf2.popfiledsl.modeling.IMvMSubtree.Companion.multiStruct
import btpos.tf2.popfiledsl.modeling.IMvMSubtree.Companion.addField

class SquadSpawner : BaseSpawner() {
	/*
	Squad
	- float     FormationSize       (default: -1.0)
	- bool      ShouldPreserveSquad (default: 0) [see note 4]
	- subtree[] (spawner)
	 */
	
	var formationSize by addField<Float>("FormationSize")
	
	/**
	 * Note: Squad.ShouldPreserveSquad is parsed correctly, but will cause a spurious error to show up in console; ignore the error
	 */
	var shouldPreserveSquad by addField<Boolean>("ShouldPreserveSquad")
	
	val spawners: MutableList<BaseSpawner> by multiStruct()
	
	override val popFileStructIdentifier: Any
		get() = "Squad"
}