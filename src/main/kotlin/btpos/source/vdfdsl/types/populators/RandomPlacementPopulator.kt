package btpos.source.vdfdsl.types.populators

import btpos.source.vdfdsl.modeling.IExtensibleSubtree.Companion.addField
import btpos.source.vdfdsl.modeling.IExtensibleSubtree.Companion.singleStruct
import btpos.source.vdfdsl.types.spawners.Spawner
import btpos.source.vdfdsl.types.specifics.NavArea

class RandomPlacementPopulator : Populator() {
	override val _structIdentifier: String
		get() = "RandomPlacement"
}

inline fun Populator.Companion.RandomPlacement(configure: RandomPlacementPopulator.() -> Unit) = RandomPlacementPopulator().apply(configure)


var RandomPlacementPopulator.count: Int? by addField("Count")

var RandomPlacementPopulator.minimumSeparation: Int? by addField("MinimumSeparation")

var RandomPlacementPopulator.navAreaFilter: NavArea? by addField("NavAreaFilter")

/**
 * Will usually be a [RandomChoice][btpos.source.vdfdsl.types.spawners.RandomChoiceSpawner].
 *
 * [Squad][btpos.source.vdfdsl.types.spawners.SquadSpawner] and [Mob (deprecated)][btpos.source.vdfdsl.types.spawners.MobSpawner] work as well, but there is no practical use for this.
 */
var RandomPlacementPopulator.spawner: Spawner? by singleStruct()
	