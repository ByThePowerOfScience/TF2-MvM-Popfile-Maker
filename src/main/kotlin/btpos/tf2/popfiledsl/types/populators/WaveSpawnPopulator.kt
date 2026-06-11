package btpos.tf2.popfiledsl.types.populators

import btpos.tf2.popfiledsl.modeling.IMvMSubtree.Companion.addField
import btpos.tf2.popfiledsl.modeling.IMvMSubtree.Companion.singleStruct
import btpos.tf2.popfiledsl.serialization.IPopFileSerializable
import btpos.tf2.popfiledsl.serialization.codecs.StringLiteralCodec
import btpos.tf2.popfiledsl.types.spawners.BaseSpawner
import btpos.tf2.popfiledsl.types.specifics.OutputAction
import btpos.tf2.popfiledsl.types.specifics.Where

class WaveSpawnPopulator : Populator() {
	override val popFileStructIdentifier: Any
		get() = "WaveSpawn"
	
	class Support(override val popFileRepr: String) : IPopFileSerializable<String> {
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


var WaveSpawnPopulator.template: String? by addField("Template", StringLiteralCodec)
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
var WaveSpawnPopulator.spawner: BaseSpawner? by singleStruct()

/**
 * { enables support; "Limited" => TotalCount enforced, else => TotalCount ignored }
 */
var WaveSpawnPopulator.support: String? by addField("Support")









