package btpos.source.vdfdsl.types.populators

import btpos.source.vdfdsl.backing.VDFPrimitive
import btpos.source.vdfdsl.modeling.ExtensibleSubtreeImpl
import btpos.source.vdfdsl.modeling.IExtensibleSubtree.Companion.addField
import btpos.source.vdfdsl.modeling.IExtensibleSubtree.Serializers.notNull
import btpos.source.vdfdsl.modeling.IExtensibleSubtree_VDFRepresentable
import btpos.source.vdfdsl.serialization.IVDFRepresentableValue
import btpos.source.vdfdsl.types.specifics.OutputAction

class WaveSpawnPopulator(_subtree: IExtensibleSubtree_VDFRepresentable = ExtensibleSubtreeImpl()) : AbstractPopulator(_subtree) {
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
			
			/**
			 * When set, this WaveSpawn defines support bots that will continue spawning throughout the wave.
			 */
			val INFINITE = Support("1")
		}
	}
	
	override fun copy() = WaveSpawnPopulator(this.copyInternal())
	
	var template: String? by addField("Template")
	
	var where: String? by addField("Where")
	
	var totalCount: Int? by addField("TotalCount")
	
	var maxActive: Int? by addField("MaxActive")
	
	var spawnCount: Int? by addField("SpawnCount")
	
	var waitBeforeStarting: Number? by addField("WaitBeforeStarting")
	
	var waitBetweenSpawns: Number? by addField("WaitBetweenSpawns")
	
	var waitBetweenSpawnsAfterDeath: Number? by addField("WaitBetweenSpawnsAfterDeath")
	
	var startWaveWarningSound: String? by addField("StartWaveWarningSound")
	
	var startWaveOutput: OutputAction? by addField("StartWaveOutput")
	
	var firstSpawnWarningSound: String? by addField("FirstSpawnWarningSound")
	
	var firstSpawnOutput: OutputAction? by addField("FirstSpawnOutput")
	
	var lastSpawnWarningSound: String? by addField("LastSpawnWarningSound")
	
	var lastSpawnOutput: OutputAction? by addField("LastSpawnOutput")
	
	var doneWarningSound: String? by addField("DoneWarningSound")
	
	var doneOutput: OutputAction? by addField("DoneOutput")
	
	var totalCurrency: Int? by addField("TotalCurrency")
	
	var name: String? by addField("Name")
	
	var waitForAllSpawned: WaveSpawnPopulator? by addField("WaitForAllSpawned", serializer = notNull(WaveSpawnPopulator::name))
	
	var waitForAllDead: WaveSpawnPopulator? by addField("WaitForAllDead", serializer = notNull(WaveSpawnPopulator::name))
	
	var randomSpawn: Boolean? by addField("RandomSpawn")
	/**
	 * { enables support; "Limited" => TotalCount enforced, else => TotalCount ignored }
	 */
	var support: Support? by addField("Support")
}

inline fun WaveSpawn(configure: WaveSpawnPopulator.() -> Unit) = WaveSpawnPopulator().apply(configure)











