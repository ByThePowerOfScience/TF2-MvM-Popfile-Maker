package btpos.source.vdfdsl.types

import btpos.source.vdfdsl.backing.VDFSubtree
import btpos.source.vdfdsl.codegen.Codegen
import btpos.source.vdfdsl.codegen.keyed
import btpos.source.vdfdsl.codegen.map
import btpos.source.vdfdsl.modeling.AbstractVDFStruct
import btpos.source.vdfdsl.modeling.ExtensibleSubtreeImpl
import btpos.source.vdfdsl.modeling.IExtensibleSubtree
import btpos.source.vdfdsl.modeling.IExtensibleSubtree.Companion.addField
import btpos.source.vdfdsl.modeling.IExtensibleSubtree.Companion.merged
import btpos.source.vdfdsl.modeling.IExtensibleSubtree.Companion.selfNamedList
import btpos.source.vdfdsl.modeling.IExtensibleSubtree_VDFRepresentable
import btpos.source.vdfdsl.tf2.PopFileDSL
import btpos.source.vdfdsl.types.populators.AbstractPopulator
import btpos.source.vdfdsl.utils.NestedScope
import kotlin.io.path.Path
import kotlin.io.path.bufferedWriter
import kotlin.io.path.createDirectories
import kotlin.reflect.KFunction

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
	 * Settings controlling details about the mission: starting currency, bots attacking inside the spawn room, etc.
	 */
	val settingsGeneral by merged(MissionSettings())
	
	val settingsRespawn by merged(RespawnSettings())
	
	val settingsSentryBuster by merged(SentryBusterSettings())
	
	open class MissionSettings(subtree: ExtensibleSubtreeImpl = ExtensibleSubtreeImpl()) : NestedScope(subtree) {
		/**
		 * Default: 0
		 */
		var startingCurrency: Int? by addField("StartingCurrency")
		
		/**
		 * e.g. `"Halloween"`
		 */
		var eventPopFile: String? by addField("EventPopFile")
		
		var advanced: Boolean? by addField("Advanced")
		
		var isEndless: Boolean? by addField("IsEndless")
		
		var canBotsAttackWhileInSpawnRoom: Boolean? by addField("CanBotsAttackWhileInSpawnRoom", serializer = { if (this) "yes" else "no" })
		
		
		
		override fun copy() = MissionSettings(copyInternal())
	}
	
	open class RespawnSettings(backing: ExtensibleSubtreeImpl = ExtensibleSubtreeImpl()) : NestedScope(backing) {
		/**
		 * Default: 10
		 */
		var respawnWaveTime: Int? by addField("RespawnWaveTime")
		
		var fixedRespawnWaveTime: Boolean? by addField("FixedRespawnWaveTime")
		
		
		override fun copy() = RespawnSettings(backing.copy())
	}
	
	open class SentryBusterSettings(backing: ExtensibleSubtreeImpl = ExtensibleSubtreeImpl()) : NestedScope(backing) {
		
		/**
		 * Default: 3000
		 */
		var addSentryBusterWhenDamageDealtExceeds: Int? by addField("AddSentryBusterWhenDamageDealtExceeds")
		
		/**
		 * Default: 15
		 */
		var addSentryBusterWhenKillCountExceeds: Int? by addField("AddSentryBusterWhenKillCountExceeds")
		
		
		override fun copy() = SentryBusterSettings(backing.copy())
	}
	
	
	
	
	companion object {
		val CODEGEN = IExtensibleSubtree.Codegen.registerCodegen<PopulationManager> {
			val x: (PopulationManager.() -> Unit) -> PopulationManager = ::WaveSchedule
			Codegen.basicBlockScope(x as KFunction<*>)
		}
		
		val CODEGEN_TYPE = CODEGEN.map { it.keyed("WaveSchedule") }
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




fun PopulationManager.writeToFile(fileName: String) {
	Path(fileName).createDirectories().bufferedWriter().use { writer ->
		VDFSubtree(null).also { this._serializeInto(it) }.writeToVDF(writer)
	}
}

