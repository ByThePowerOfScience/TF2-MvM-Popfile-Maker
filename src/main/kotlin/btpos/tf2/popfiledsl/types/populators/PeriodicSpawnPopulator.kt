package btpos.tf2.popfiledsl.types.populators

import btpos.tf2.popfiledsl.modeling.AbstractMvMStruct
import btpos.tf2.popfiledsl.modeling.IMvMSubtree.Companion.addField
import btpos.tf2.popfiledsl.modeling.IMvMSubtree.Companion.singleStruct
import btpos.tf2.popfiledsl.types.populators.PeriodicSpawnPopulator.When
import btpos.tf2.popfiledsl.types.spawners.Spawner
import btpos.tf2.popfiledsl.types.specifics.Where

class PeriodicSpawnPopulator : Populator() {
	class When : AbstractMvMStruct() {
		override val _popFileStructIdentifier get() = "When"
		
		var minInterval: Double? by addField("MinInterval")
		
		var maxInterval: Double? by addField("MaxInterval")
	}
	
	override val _popFileStructIdentifier: Any
		get() = "PeriodicSpawn"
}

inline fun Populator.Companion.PeriodicSpawn(configure: PeriodicSpawnPopulator.() -> Unit) = PeriodicSpawnPopulator().apply(configure)

var PeriodicSpawnPopulator.where: Where? by addField("Where")

/**
 * Can be either a [Float] or a [When] instance
 */
var PeriodicSpawnPopulator.`when`: Any? by addField("When")

var PeriodicSpawnPopulator.spawner: Spawner? by singleStruct()