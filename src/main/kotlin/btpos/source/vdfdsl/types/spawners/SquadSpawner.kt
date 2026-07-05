package btpos.source.vdfdsl.types.spawners

import btpos.source.vdfdsl.modeling.ExtensibleSubtreeImpl
import btpos.source.vdfdsl.modeling.IExtensibleSubtree.Companion.multiStruct
import btpos.source.vdfdsl.modeling.IExtensibleSubtree.Companion.addField
import btpos.source.vdfdsl.types.populators.Populator

class SquadSpawner(_subtree: ExtensibleSubtreeImpl = ExtensibleSubtreeImpl()) : Spawner(_subtree) {
	/*
	Squad
	- float     FormationSize       (default: -1.0)
	- bool      ShouldPreserveSquad (default: 0) [see note 4]
	- subtree[] (spawner)
	 */
	
	override val _structIdentifier: String
		get() = "Squad"
	
	override fun copy() = SquadSpawner(copyInternal())
}

fun Spawner.Companion.Squad(configure: SquadSpawner.() -> Unit) = SquadSpawner().apply(configure)

fun Populator.Squad(configure: SquadSpawner.() -> Unit) = Spawner.Squad(configure).also {
	this.spawner = it
}

var SquadSpawner.formationSize: Double? by addField("FormationSize")

/**
 * Note: Squad.ShouldPreserveSquad is parsed correctly, but will cause a spurious error to show up in console; ignore the error
 */
var SquadSpawner.shouldPreserveSquad: Boolean? by addField("ShouldPreserveSquad")

val SquadSpawner.spawners: MutableList<Spawner> by multiStruct()