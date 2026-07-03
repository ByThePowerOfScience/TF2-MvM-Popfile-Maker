package btpos.source.vdfdsl.types.populators

import btpos.source.vdfdsl.modeling.ExtensibleSubtreeImpl
import btpos.source.vdfdsl.modeling.IExtensibleSubtree.Companion.addField
import btpos.source.vdfdsl.modeling.IExtensibleSubtree.Companion.singleStruct
import btpos.source.vdfdsl.types.PopulationManager
import btpos.source.vdfdsl.types.populators
import btpos.source.vdfdsl.types.spawners.Spawner
import btpos.source.vdfdsl.types.spawners.TankSpawner
import btpos.source.vdfdsl.types.specifics.NavArea

class RandomPlacementPopulator(_subtree: ExtensibleSubtreeImpl = ExtensibleSubtreeImpl()) : Populator(_subtree) {
	override val _structIdentifier: String
		get() = "RandomPlacement"
	
	override fun copy() = RandomPlacementPopulator(copyInternal())
}

inline fun Populator.Companion.RandomPlacement(configure: RandomPlacementPopulator.() -> Unit) = RandomPlacementPopulator().apply(configure)
/**
 * Creates and adds a new RandomPlacement populator to the PopulationManager
 */
fun PopulationManager.RandomPlacement(configure: RandomPlacementPopulator.() -> Unit) = RandomPlacementPopulator().apply(configure).also {
	this.populators += it
}

var RandomPlacementPopulator.count: Int? by addField("Count")

var RandomPlacementPopulator.minimumSeparation: Int? by addField("MinimumSeparation")

var RandomPlacementPopulator.navAreaFilter: NavArea? by addField("NavAreaFilter")

/**
 * Will usually be a [RandomChoice][btpos.source.vdfdsl.types.spawners.RandomChoiceSpawner].
 *
 * [Squad][btpos.source.vdfdsl.types.spawners.SquadSpawner] and [Mob (deprecated)][btpos.source.vdfdsl.types.spawners.MobSpawner] work as well, but there is no practical use for this.
 */
var RandomPlacementPopulator.spawner: Spawner? by singleStruct()
	