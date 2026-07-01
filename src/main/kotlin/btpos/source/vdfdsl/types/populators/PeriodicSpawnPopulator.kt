package btpos.source.vdfdsl.types.populators

import btpos.source.vdfdsl.modeling.AbstractVDFStruct
import btpos.source.vdfdsl.modeling.IExtensibleSubtree.Companion.addField
import btpos.source.vdfdsl.modeling.IExtensibleSubtree.Companion.singleStruct
import btpos.source.vdfdsl.types.populators.PeriodicSpawnPopulator.When
import btpos.source.vdfdsl.types.spawners.Spawner
import btpos.source.vdfdsl.types.specifics.Where

class PeriodicSpawnPopulator : Populator() {
	class When : AbstractVDFStruct() {
		override val _structIdentifier get() = "When"
		
		var minInterval: Double? by addField("MinInterval")
		
		var maxInterval: Double? by addField("MaxInterval")
	}
	
	override val _structIdentifier: Any
		get() = "PeriodicSpawn"
}

inline fun Populator.Companion.PeriodicSpawn(configure: PeriodicSpawnPopulator.() -> Unit) = PeriodicSpawnPopulator().apply(configure)

var PeriodicSpawnPopulator.where: Where? by addField("Where")

/**
 * Can be either a [Float] or a [When] instance
 */
var PeriodicSpawnPopulator.`when`: Any? by addField("When")

var PeriodicSpawnPopulator.spawner: Spawner? by singleStruct()