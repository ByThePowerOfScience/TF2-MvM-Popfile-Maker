package btpos.source.vdfdsl.types.populators

import btpos.misc.kt.codegen.KtExpression
import btpos.misc.kt.codegen.expressions.KtFunctionCall
import btpos.misc.kt.codegen.identifiers.KtName
import btpos.source.vdfdsl.backing.VDFPrimitive
import btpos.source.vdfdsl.backing.asString
import btpos.source.vdfdsl.codegen.Codegen
import btpos.source.vdfdsl.codegen.CodegenProvider
import btpos.source.vdfdsl.codegen.ConstantsDecoder
import btpos.source.vdfdsl.codegen.ValueDecoder
import btpos.source.vdfdsl.codegen.map
import btpos.source.vdfdsl.codegen.orElse
import btpos.source.vdfdsl.modeling.ExtensibleSubtreeImpl
import btpos.source.vdfdsl.modeling.IExtensibleSubtree
import btpos.source.vdfdsl.modeling.IExtensibleSubtree.Companion.addField
import btpos.source.vdfdsl.modeling.IExtensibleSubtree.Serializers.getField
import btpos.source.vdfdsl.modeling.IExtensibleSubtree.Serializers.map
import btpos.source.vdfdsl.modeling.IExtensibleSubtree.Serializers.notNull
import btpos.source.vdfdsl.modeling.IExtensibleSubtree_VDFRepresentable
import btpos.source.vdfdsl.serialization.IVDFRepresentableValue_Trivial
import btpos.source.vdfdsl.tf2.templates.PopFileTemplate
import btpos.source.vdfdsl.types.specifics.OutputAction
import kotlin.to

class WaveSpawnPopulator(_subtree: IExtensibleSubtree_VDFRepresentable = ExtensibleSubtreeImpl()) : AbstractPopulator(_subtree) {
	override val _structIdentifier: String
		get() = "WaveSpawn"
	
	override fun copy() = WaveSpawnPopulator(this.copyInternal())
	
	val template by addField<PopFileTemplate>("Template")
	
	val where by addField<String>("Where")
	
	val totalCount by addField<Int>("TotalCount")
	
	val maxActive by addField<Int>("MaxActive")
	
	val spawnCount by addField<Int>("SpawnCount")
	
	/**
	 * How many seconds after its spawning condition is fulfilled (if unspecified, that's the start of the wave) that these bots should start spawning.
	 *
	 * @see waitForAllSpawned
	 * @see waitForAllDead
	 */
	val waitBeforeStarting by addField<Number>("WaitBeforeStarting")
	
	val waitBetweenSpawns by addField<Number>("WaitBetweenSpawns")
	
	val waitBetweenSpawnsAfterDeath by addField<Number>("WaitBetweenSpawnsAfterDeath")
	
	val startWaveWarningSound by addField<String>("StartWaveWarningSound")
	
	val startWaveOutput by addField<OutputAction>("StartWaveOutput")
	
	val firstSpawnWarningSound by addField<String>("FirstSpawnWarningSound")
	
	val firstSpawnOutput by addField<OutputAction>("FirstSpawnOutput")
	
	val lastSpawnWarningSound by addField<String>("LastSpawnWarningSound")
	
	val lastSpawnOutput by addField<OutputAction>("LastSpawnOutput")
	
	val doneWarningSound by addField<String>("DoneWarningSound")
	
	val doneOutput by addField<OutputAction>("DoneOutput")
	
	val totalCurrency by addField<Int>("TotalCurrency")
	
	val name by addField<String>("Name")
	
	val waitForAllSpawned by addField<WaveSpawnPopulator>("WaitForAllSpawned", serializer = getField(WaveSpawnPopulator::name))
	
	val waitForAllDead by addField<WaveSpawnPopulator>("WaitForAllDead", serializer = getField(WaveSpawnPopulator::name))
	
	val randomSpawn by addField<Boolean>("RandomSpawn")
	
	/**
	 * { enables support; "Limited" => TotalCount enforced, else => TotalCount ignored }
	 */
	val support by addField<Support>("Support")
	
	
	companion object {
		val CODEGEN = IExtensibleSubtree.Codegen.registerCodegen<WaveSpawnPopulator>(customFieldDecoders = {
			val todo = CodegenProvider {
				ValueDecoder<KtExpression> { value, _ ->
					if (value.asString == null)
						null
					else
						listOf(KtFunctionCall(KtName("TODO"), mutableListOf(Codegen.string("Reference the WaveSpawn '${value.asString}' variable here."))))
				}
			}
			mapOf(
				WaveSpawnPopulator::waitForAllDead.name to todo,
				WaveSpawnPopulator::waitForAllSpawned.name to todo,
			)
		}) {
			Codegen.basicBlockScope(::WaveSpawn, mapOf(WaveSpawnPopulator::name.name to "name"))
		}
	}
	
	open class Support(val name: String) : IVDFRepresentableValue_Trivial {
		override val _vdfRepr = VDFPrimitive(name)
		
		companion object {
			/**
			 * When set, enables support bots, respecting the maximum number of bots set by [WaveSpawner.totalCount][totalCount].
			 */
			@JvmField val LIMITED = Support("Limited")
			
			/**
			 * When set, enables support bots, **ignoring** the maximum number of bots set by [WaveSpawner.totalCount][totalCount].
			 */
			@JvmField val IGNORED = Support("Ignored")
			
			/**
			 * When set, this WaveSpawn defines support bots that will continue spawning throughout the wave.
			 */
			@JvmField val INFINITE = Support("1")
			
			val CODEGEN = ConstantsDecoder<Support>()
		}
	}
}

inline fun WaveSpawn(name: String? = null, configure: WaveSpawnPopulator.() -> Unit) = WaveSpawnPopulator().apply { name?.let { this.name = it } }.apply(configure)











