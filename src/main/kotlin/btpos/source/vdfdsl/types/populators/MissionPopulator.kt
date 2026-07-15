package btpos.source.vdfdsl.types.populators

import btpos.source.vdfdsl.backing.VDFPrimitive
import btpos.source.vdfdsl.modeling.ExtensibleSubtreeImpl
import btpos.source.vdfdsl.modeling.IExtensibleSubtree.Companion.addField
import btpos.source.vdfdsl.modeling.IExtensibleSubtree_VDFRepresentable
import btpos.source.vdfdsl.serialization.IVDFRepresentableValue_Trivial
import btpos.source.vdfdsl.types.spawners.AbstractSpawner

class MissionPopulator(_subtree: IExtensibleSubtree_VDFRepresentable = ExtensibleSubtreeImpl()) : AbstractPopulator(_subtree) {
	override val _structIdentifier: String
		get() = "Mission"
	
	override fun copy() = MissionPopulator(this.copyInternal())
	
	/**
	 * What should be spawned to fulfill this mission.
	 */
	override var spawner: AbstractSpawner?
		get() = super.spawner
		set(value) { super.spawner = value }
	
	
	/**
	 * The name of the `info_teamspawn` entity the bots for this mission should spawn, or one of the [presets][btpos.source.vdfdsl.types.specifics.Where].
	 */
	var where: String? by addField("Where")
	
	/**
	 * The objective of bots spawned by this mission.  See fields in [Objective].
	 */
	var objective: Objective? by addField("Objective")
	
	/**
	 * Delay this mission starting by this many seconds after the start of the [specified wave][beginAtWave].
	 */
	var initialCooldown: Number? by addField("InitialCooldown")
	
	/**
	 * How many seconds should elapse between procs of this mission.
	 */
	var cooldownTime: Number? by addField("CooldownTime")
	
	/**
	 * What wave this mission should start being activated on.
	 */
	var beginAtWave: Int? by addField("BeginAtWave")
	
	/**
	 * How many waves after (and including) [beginAtWave] the mission should run for.
	 */
	var runForThisManyWaves: Int? by addField("RunForThisManyWaves")
	
	/**
	 * How many of the [specified spawner][AbstractPopulator.spawner] should be spawned when this mission procs.
	 */
	var desiredCount: Number? by addField("DesiredCount")
}

data class Objective(val item: String) : IVDFRepresentableValue_Trivial {
	override val _vdfRepr: VDFPrimitive
		get() = VDFPrimitive(item)
	
	companion object {
		val DestroySentries = Objective("DestroySentries")
		val SeekAndDestroy = Objective("SeekAndDestroy")
		val Sniper = Objective("Sniper")
		val Spy = Objective("Spy")
		val Engineer = Objective("Engineer")
	}
}







