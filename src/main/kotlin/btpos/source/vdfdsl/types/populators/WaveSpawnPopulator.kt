package btpos.source.vdfdsl.types.populators

import btpos.source.vdfdsl.backing.VDFPrimitive
import btpos.source.vdfdsl.modeling.AbstractVDFStruct
import btpos.source.vdfdsl.modeling.ExtensibleSubtreeImpl
import btpos.source.vdfdsl.modeling.IExtensibleSubtree.Companion.addField
import btpos.source.vdfdsl.modeling.IExtensibleSubtree.Companion.singleStruct
import btpos.source.vdfdsl.modeling.IExtensibleSubtree.Serializers.notNull
import btpos.source.vdfdsl.serialization.IVDFRepresentableValue
import btpos.source.vdfdsl.serialization.codecs.Codec
import btpos.source.vdfdsl.types.PopulationManager
import btpos.source.vdfdsl.types.populators
import btpos.source.vdfdsl.types.spawners.Spawner
import btpos.source.vdfdsl.types.specifics.OutputAction
import btpos.source.vdfdsl.types.specifics.Where

class WaveSpawnPopulator(_subtree: ExtensibleSubtreeImpl = ExtensibleSubtreeImpl()) : Populator(_subtree) {
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
	
	override fun copy() = WaveSpawnPopulator(this.copyInternal())
}

inline fun Populator.Companion.WaveSpawn(configure: WaveSpawnPopulator.() -> Unit) = WaveSpawnPopulator().apply(configure)
/**
 * Creates and adds a new WaveSpawn populator to the PopulationManager
 */
fun PopulationManager.WaveSpawn(configure: WaveSpawnPopulator.() -> Unit) = WaveSpawnPopulator().apply(configure).also {
	this.populators += it
}

var WaveSpawnPopulator.template: String? by addField("Template")
var WaveSpawnPopulator.where: String? by addField("Where")
var WaveSpawnPopulator.totalCount: Int? by addField("TotalCount")
var WaveSpawnPopulator.maxActive: Int? by addField("MaxActive")
var WaveSpawnPopulator.spawnCount: Int? by addField("SpawnCount")
var WaveSpawnPopulator.waitBeforeStarting: Number? by addField("WaitBeforeStarting")
var WaveSpawnPopulator.waitBetweenSpawns: Number? by addField("WaitBetweenSpawns")
var WaveSpawnPopulator.waitBetweenSpawnsAfterDeath: Number? by addField("WaitBetweenSpawnsAfterDeath")
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

var WaveSpawnPopulator.waitForAllSpawned: WaveSpawnPopulator? by addField("WaitForAllSpawned", serializer = notNull(WaveSpawnPopulator::name))

var WaveSpawnPopulator.waitForAllDead: WaveSpawnPopulator? by addField("WaitForAllDead", serializer = notNull(WaveSpawnPopulator::name))

var WaveSpawnPopulator.randomSpawn: Boolean? by addField("RandomSpawn")
/**
 * { enables support; "Limited" => TotalCount enforced, else => TotalCount ignored }
 */
var WaveSpawnPopulator.support: WaveSpawnPopulator.Support? by addField("Support")









