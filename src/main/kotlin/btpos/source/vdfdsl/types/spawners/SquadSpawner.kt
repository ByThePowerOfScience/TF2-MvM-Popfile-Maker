package btpos.source.vdfdsl.types.spawners

import btpos.source.vdfdsl.modeling.IExtensibleSubtree.Companion.multiStruct
import btpos.source.vdfdsl.modeling.IExtensibleSubtree.Companion.addField

class SquadSpawner : Spawner() {
	/*
	Squad
	- float     FormationSize       (default: -1.0)
	- bool      ShouldPreserveSquad (default: 0) [see note 4]
	- subtree[] (spawner)
	 */
	
	override val _structIdentifier: Any
		get() = "Squad"
}

fun Spawner.Companion.Squad(configure: SquadSpawner.() -> Unit) = SquadSpawner().apply(configure)

var SquadSpawner.formationSize by addField<Double>("FormationSize")

/**
 * Note: Squad.ShouldPreserveSquad is parsed correctly, but will cause a spurious error to show up in console; ignore the error
 */
var SquadSpawner.shouldPreserveSquad by addField<Boolean>("ShouldPreserveSquad")

val SquadSpawner.spawners: MutableList<Spawner> by multiStruct()