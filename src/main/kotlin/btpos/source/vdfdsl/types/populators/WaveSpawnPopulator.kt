package btpos.source.vdfdsl.types.populators

import btpos.source.vdfdsl.backing.VDFPrimitive
import btpos.source.vdfdsl.modeling.IExtensibleSubtree.Companion.addField
import btpos.source.vdfdsl.modeling.IExtensibleSubtree.Companion.singleStruct
import btpos.source.vdfdsl.serialization.IVDFRepresentableValue
import btpos.source.vdfdsl.types.spawners.Spawner
import btpos.source.vdfdsl.types.specifics.OutputAction
import btpos.source.vdfdsl.types.specifics.Where

class WaveSpawnPopulator : Populator() {
	override val _structIdentifier: String
		get() = "WaveSpawn"
	
	class Support(val name: String) : IVDFRepresentableValue<VDFPrimitive> {
		override val _vdfRepr get() = VDFPrimitive(name)
		
		companion object {
			/**
			 * When set, enables support bots, respecting the maximum number of bots set by [WaveSpawner.totalCount][totalCount].
			 */
			val LIMITED = Support("Limited")
			
			/**
			 * When set, enables support bots, **ignoring** the maximum number of bots set by [WaveSpawner.totalCount][totalCount].
			 */
			val IGNORED = Support("Ignored")
		}
	}
}

inline fun Populator.Companion.WaveSpawn(configure: WaveSpawnPopulator.() -> Unit) = WaveSpawnPopulator().apply(configure)


var WaveSpawnPopulator.template: String? by addField("Template")
var WaveSpawnPopulator.where: Where? by addField("Where")
var WaveSpawnPopulator.totalCount: Int? by addField("TotalCount")
var WaveSpawnPopulator.maxActive: Int? by addField("MaxActive")
var WaveSpawnPopulator.spawnCount: Int? by addField("SpawnCount")
var WaveSpawnPopulator.waitBeforeStarting: Double? by addField("WaitBeforeStarting")
var WaveSpawnPopulator.waitBetweenSpawnsAfterDeath: Double? by addField("WaitBetweenSpawnsAfterDeath")
var WaveSpawnPopulator.startWaveWarningSound: String? by addField("StartWaveWarningSound")
var WaveSpawnPopulator.startWaveOutput: OutputAction? by addField("StartWaveOutput")
var WaveSpawnPopulator.firstSpawnWarningSound: String? by addField("FirstSpawnWarningSound")
var WaveSpawnPopulator.firstSpawnOutput: OutputAction? by addField("FirstSpawnOutput")
var WaveSpawnPopulator.lastSpawnWarningSound: String? by addField("LastSpawnWarningSound")
var WaveSpawnPopulator.lastSpawnOutput: OutputAction? by addField("LastSpawnOutput")
var WaveSpawnPopulator.doneWarningSound: String? by addField("DoneWarningSound")
var WaveSpawnPopulator.doneOutput: OutputAction? by addField("DoneOutput")
var WaveSpawnPopulator.totalCurrency: Int? by addField("TotalCurrency")
var WaveSpawnPopulator.name: String? by addField("Name")
var WaveSpawnPopulator.waitForAllSpawned: String? by addField("WaitForAllSpawned")
var WaveSpawnPopulator.waitForAllDead: String? by addField("WaitForAllDead")
var WaveSpawnPopulator.randomSpawn: Boolean? by addField("RandomSpawn")
var WaveSpawnPopulator.spawner: Spawner? by singleStruct(isRequired = true)

/**
 * { enables support; "Limited" => TotalCount enforced, else => TotalCount ignored }
 */
var WaveSpawnPopulator.support: String? by addField("Support")









