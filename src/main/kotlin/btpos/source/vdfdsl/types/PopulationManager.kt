package btpos.source.vdfdsl.types

import btpos.source.vdfdsl.backing.VDFSubtree
import btpos.source.vdfdsl.modeling.AbstractVDFStruct
import btpos.source.vdfdsl.modeling.ExtensibleSubtreeImpl
import btpos.source.vdfdsl.modeling.IExtensibleSubtree.Companion.addField
import btpos.source.vdfdsl.modeling.IExtensibleSubtree.Companion.selfNamedList
import btpos.source.vdfdsl.modeling.IExtensibleSubtree_VDFRepresentable
import btpos.source.vdfdsl.tf2.PopFileDSL
import btpos.source.vdfdsl.types.populators.AbstractPopulator
import kotlin.io.path.Path
import kotlin.io.path.bufferedWriter
import kotlin.io.path.createDirectories

@PopFileDSL
class PopulationManager(_subtree: IExtensibleSubtree_VDFRepresentable = ExtensibleSubtreeImpl()) : AbstractVDFStruct(_subtree) {
	override val _structIdentifier: String
		get() = "WaveSchedule"
	
	override fun copy() = PopulationManager(copyInternal())
	
	operator fun AbstractPopulator.unaryPlus() {
		this@PopulationManager.populators += this
	}
	
	
	var populators: List<AbstractPopulator> by selfNamedList()
	
	/**
	 * Default: 0
	 */
	var startingCurrency: Int? by addField("StartingCurrency")
	
	/**
	 * Default: 10
	 */
	var respawnWaveTime: Int? by addField("RespawnWaveTime")
	
	/**
	 * e.g. `"Halloween"`
	 */
	var eventPopFile: String? by addField("EventPopFile")
	
	var fixedRespawnWaveTime: Boolean? by addField("FixedRespawnWaveTime")
	
	/**
	 * Default: 3000
	 */
	var addSentryBusterWhenDamageDealtExceeds: Int? by addField("AddSentryBusterWhenDamageDealtExceeds")
	
	/**
	 * Default: 15
	 */
	var addSentryBusterWhenKillCountExceeds: Int? by addField("AddSentryBusterWhenKillCountExceeds")
	
	var canBotsAttackWhileInSpawnRoom: Boolean? by addField("CanBotsAttackWhileInSpawnRoom", serializer = { if (it) "yes" else "no" })
	
	var advanced: Boolean? by addField("Advanced")
	
	var isEndless: Boolean? by addField("IsEndless")
	
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




fun PopulationManager.writeToFile(fileName: String) {
	Path(fileName).createDirectories().bufferedWriter().use { writer ->
		VDFSubtree(null).also { this._serializeInto(it) }.writeToVDF(writer)
	}
}

