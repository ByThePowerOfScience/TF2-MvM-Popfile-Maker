package btpos.source.vdfdsl.types.populators

import btpos.source.vdfdsl.backing.VDFPrimitive
import btpos.source.vdfdsl.modeling.AbstractVDFStruct
import btpos.source.vdfdsl.modeling.ExtensibleSubtreeImpl
import btpos.source.vdfdsl.modeling.IExtensibleSubtree.Companion.addField
import btpos.source.vdfdsl.modeling.IExtensibleSubtree.Companion.singleStruct
import btpos.source.vdfdsl.serialization.IVDFRepresentableValue
import btpos.source.vdfdsl.types.PopulationManager
import btpos.source.vdfdsl.types.populators
import btpos.source.vdfdsl.types.spawners.Spawner
import btpos.source.vdfdsl.types.specifics.Where

class MissionPopulator(_subtree: ExtensibleSubtreeImpl = ExtensibleSubtreeImpl()) : Populator(_subtree) {
	override val _structIdentifier: String
		get() = "Mission"
	
	override fun copy() = MissionPopulator(this.copyInternal())
}

data class Objective(val item: String) : IVDFRepresentableValue<VDFPrimitive> {
	override val _vdfRepr: VDFPrimitive
		get() = VDFPrimitive(item)
	
	companion object {
		val DESTROY_SENTRIES = Objective("DestroySentries")
		val SEEK_AND_DESTROY = Objective("SeekAndDestroy")
		val SNIPER = Objective("Sniper")
		val SPY = Objective("Spy")
		val ENGINEER = Objective("Engineer")
	}
}

fun Populator.Companion.Mission(configure: MissionPopulator.() -> Unit) = MissionPopulator().apply(configure)

/**
 * Creates and adds a new Mission populator to the PopulationManager
 */
fun PopulationManager.Mission(configure: MissionPopulator.() -> Unit) = MissionPopulator().apply(configure).also {
	this.populators += it
}

var MissionPopulator.where: Where? by addField("Where")

var MissionPopulator.objective: Objective? by addField("Objective")

var MissionPopulator.initialCooldown: Number? by addField("InitialCooldown")

var MissionPopulator.cooldownTime: Number? by addField("CooldownTime")

var MissionPopulator.beginAtWave: Int? by addField("BeginAtWave")

var MissionPopulator.runForThisManyWaves: Int? by addField("RunForThisManyWaves")

var MissionPopulator.desiredCount: Number? by addField("DesiredCount")

var MissionPopulator.spawner: Spawner? by singleStruct()








