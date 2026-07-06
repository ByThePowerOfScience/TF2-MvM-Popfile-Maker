package btpos.source.vdfdsl.types

import btpos.source.vdfdsl.modeling.IExtensibleSubtree
import btpos.source.vdfdsl.modeling.IExtensibleSubtree.Companion.addField
import btpos.source.vdfdsl.modeling.IExtensibleSubtree.Companion.multiStruct
import btpos.source.vdfdsl.serialization.IVDFRepresentableKeyValue
import btpos.source.vdfdsl.tf2.PopFileDSL
import btpos.source.vdfdsl.types.populators.MissionPopulator
import btpos.source.vdfdsl.types.populators.Populator
import btpos.source.vdfdsl.types.populators.WavePopulator
import btpos.source.vdfdsl.types.populators.beginAtWave
import btpos.source.vdfdsl.types.populators.runForThisManyWaves

@PopFileDSL
class PopulationManager : IExtensibleSubtree {
	override val _rawEntries: MutableMap<Any, IVDFRepresentableKeyValue> = mutableMapOf()
	
	override val _instantiationSite: Array<StackTraceElement> = Throwable().stackTrace
	
	operator fun Populator.unaryPlus() {
		this@PopulationManager.populators += this
	}
}

typealias WaveSchedule = PopulationManager

inline fun WaveSchedule(configure: PopulationManager.() -> Unit): PopulationManager {
	return PopulationManager().apply(configure)
}

//
///**
// * Add a mission to the root at this wave.
// *
// * Can only be called in the context of a [Wave][WavePopulator].
// *
// * Note: this is currently bugged in Kotlin.
// */
//context(schedule: WaveSchedule)
//fun WavePopulator.addMission(missionPopulator: MissionPopulator) {
//	val currentWaveNumber = schedule.populators.count { it is WavePopulator } + 1
//	val placeInMissions = schedule.populators.indexOfLast { it is MissionPopulator && it.beginAtWave.let { it != null && it < currentWaveNumber } }.let {
//		if (it == -1)
//			0
//		else
//			it
//	}
//	schedule.populators.add(placeInMissions + 1, missionPopulator.apply {
//		// get this wave number
//		beginAtWave = currentWaveNumber
//		runForThisManyWaves = 1
//	})
//}



val PopulationManager.populators: MutableList<Populator> by multiStruct(isRequired = true)

/**
 * Default: 0
 */
var PopulationManager.startingCurrency: Int? by addField("StartingCurrency")

/**
 * Default: 10
 */
var PopulationManager.respawnWaveTime: Int? by addField("RespawnWaveTime")

/**
 * e.g. `"Halloween"`
 */
var PopulationManager.eventPopFile: String? by addField("EventPopFile")
var PopulationManager.fixedRespawnWaveTime: Boolean? by addField("FixedRespawnWaveTime")

/**
 * Default: 3000
 */
var PopulationManager.addSentryBusterWhenDamageDealtExceeds: Int? by addField("AddSentryBusterWhenDamageDealtExceeds")

/**
 * Default: 15
 */
var PopulationManager.addSentryBusterWhenKillCountExceeds: Int? by addField("AddSentryBusterWhenKillCountExceeds")

var PopulationManager.canBotsAttackWhileInSpawnRoom: Boolean? by addField("CanBotsAttackWhileInSpawnRoom", serializer = { if (it) "true" else "false" })

var PopulationManager.advanced: Boolean? by addField("Advanced")
var PopulationManager.isEndless: Boolean? by addField("IsEndless")


