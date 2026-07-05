package btpos.source.vdfdsl.types.populators

import btpos.source.vdfdsl.backing.VDFPrimitive
import btpos.source.vdfdsl.modeling.ExtensibleSubtreeImpl
import btpos.source.vdfdsl.modeling.IExtensibleSubtree.Companion.addField
import btpos.source.vdfdsl.modeling.IExtensibleSubtree.Companion.singleStruct
import btpos.source.vdfdsl.serialization.IVDFRepresentableValue
import btpos.source.vdfdsl.types.PopulationManager
import btpos.source.vdfdsl.types.populators
import btpos.source.vdfdsl.types.spawners.Spawner

class MissionPopulator(_subtree: ExtensibleSubtreeImpl = ExtensibleSubtreeImpl()) : Populator(_subtree) {
	override val _structIdentifier: String
		get() = "Mission"
	
	override fun copy() = MissionPopulator(this.copyInternal())
	
	
	/**
	 * What should be spawned to fulfill this mission.
	 */
	override var spawner: Spawner?
		get() = super.spawner
		set(value) { super.spawner = value }
}

data class Objective(val item: String) : IVDFRepresentableValue<VDFPrimitive> {
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

/**
 * Define a set of bots that spawn on a cooldown instead of based on the normal wave schedule.
 *
 * Example: sentry busters, snipers, spies.
 */
fun Populator.Companion.Mission(configure: MissionPopulator.() -> Unit) = MissionPopulator().apply(configure)

/**
 * Define a set of bots that spawn on a cooldown instead of based on the normal wave schedule.
 *
 * Example: sentry busters, snipers, spies.
 *
 * @param wave What wave this mission should start proc'ing on.
 * @param runForWaves How many waves this mission should run for, including its start wave.  Defaults to `1`.
 */
fun PopulationManager.Mission(wave: Int? = null, runForWaves: Int = 1, configure: MissionPopulator.() -> Unit): MissionPopulator {
	return MissionPopulator().also {
		if (wave != null)
			it.beginAtWave = wave
		
		it.runForThisManyWaves = runForWaves
	}.apply(configure)
	 .also {
	 	this.populators += it
	 }
}

/**
 * The name of the `info_teamspawn` entity the bots for this mission should spawn, or one of the [presets][btpos.source.vdfdsl.types.specifics.Where].
 */
var MissionPopulator.where: String? by addField("Where")

/**
 * The objective of bots spawned by this mission.  See fields in [Objective].
 */
var MissionPopulator.objective: Objective? by addField("Objective")

/**
 * Delay this mission starting by this many seconds after the start of the [specified wave][beginAtWave].
 */
var MissionPopulator.initialCooldown: Number? by addField("InitialCooldown")

/**
 * How many seconds should elapse between procs of this mission.
 */
var MissionPopulator.cooldownTime: Number? by addField("CooldownTime")

/**
 * What wave this mission should start being activated on.
 */
var MissionPopulator.beginAtWave: Int? by addField("BeginAtWave")

/**
 * How many waves after (and including) [beginAtWave] the mission should run for.
 */
var MissionPopulator.runForThisManyWaves: Int? by addField("RunForThisManyWaves")

/**
 * How many of the [specified spawner][Populator.spawner] should be spawned when this mission procs.
 */
var MissionPopulator.desiredCount: Number? by addField("DesiredCount")









