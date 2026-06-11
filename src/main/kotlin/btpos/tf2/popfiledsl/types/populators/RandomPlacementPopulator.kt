package btpos.tf2.popfiledsl.types.populators

import btpos.tf2.popfiledsl.modeling.IMvMSubtree.Companion.addField
import btpos.tf2.popfiledsl.modeling.IMvMSubtree.Companion.singleStruct
import btpos.tf2.popfiledsl.types.spawners.BaseSpawner
import btpos.tf2.popfiledsl.types.specifics.NavArea

class RandomPlacementPopulator : PopulatorBase() {
	override val popFileStructIdentifier: Any
		get() = "RandomPlacement"
}

inline fun Populators.RandomPlacement(configure: RandomPlacementPopulator.() -> Unit) = RandomPlacementPopulator().apply(configure)


var RandomPlacementPopulator.count: Int? by addField("Count")

var RandomPlacementPopulator.minimumSeparation: Int? by addField("MinimumSeparation")

var RandomPlacementPopulator.navAreaFilter: NavArea? by addField("NavAreaFilter")

/**
 * Will usually be a [RandomChoice][btpos.tf2.popfiledsl.types.spawners.RandomChoiceSpawner].
 *
 * [Squad][btpos.tf2.popfiledsl.types.spawners.SquadSpawner] and [Mob (deprecated)][btpos.tf2.popfiledsl.types.spawners.MobSpawner] work as well, but there is no practical use for this.
 */
var RandomPlacementPopulator.spawner: BaseSpawner? by singleStruct()
	