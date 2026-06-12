package btpos.tf2.popfiledsl.types.populators

import btpos.tf2.popfiledsl.modeling.IMvMSubtree.Companion.addField
import btpos.tf2.popfiledsl.modeling.IMvMSubtree.Companion.singleStruct
import btpos.tf2.popfiledsl.serialization.IPopFileSerializable
import btpos.tf2.popfiledsl.types.populators.MissionPopulator.Objective
import btpos.tf2.popfiledsl.types.spawners.Spawner
import btpos.tf2.popfiledsl.types.specifics.Where

class MissionPopulator : Populator() {
	override val popFileStructIdentifier: Any
		get() = "Mission"
	
	data class Objective(override val popFileRepr: Any) : IPopFileSerializable<Any> {
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








