package btpos.source.vdfdsl.types.populators

import btpos.source.vdfdsl.modeling.IExtensibleSubtree.Companion.addField
import btpos.source.vdfdsl.modeling.IExtensibleSubtree.Companion.singleStruct
import btpos.source.vdfdsl.serialization.IVDFSerializableValue
import btpos.source.vdfdsl.types.populators.MissionPopulator.Objective
import btpos.source.vdfdsl.types.spawners.Spawner
import btpos.source.vdfdsl.types.specifics.Where

class MissionPopulator : Populator() {
	override val _structIdentifier: Any
		get() = "Mission"
	
	data class Objective(override val _vdfRepr: Any) : IVDFSerializableValue<Any> {
		companion object {
			val DESTROY_SENTRIES = Objective("DestroySentries")
			val SEEK_AND_DESTROY = Objective("SeekAndDestroy")
			val SNIPER = Objective("Sniper")
			val SPY = Objective("Spy")
			val ENGINEER = Objective("Engineer")
		}
	}
}

fun Populator.Companion.Mission(configure: MissionPopulator.() -> Unit) = MissionPopulator().apply(configure)


var MissionPopulator.where: Where? by addField("Where")

var MissionPopulator.objective: Objective? by addField("Objective")

var MissionPopulator.initialCooldown: Double? by addField("InitialCooldown")

var MissionPopulator.cooldownTime: Double? by addField("CooldownTime")

var MissionPopulator.beginAtWave: Int? by addField("BeginAtWave")

var MissionPopulator.runForThisManyWaves: Int? by addField("RunForThisManyWaves")

var MissionPopulator.desiredCount: Double? by addField("DesiredCount")

var MissionPopulator.spawner: Spawner? by singleStruct()








