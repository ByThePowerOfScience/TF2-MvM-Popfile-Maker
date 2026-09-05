package btpos.source.vdfdsl.types.populators

import btpos.source.vdfdsl.backing.VDFPrimitive
import btpos.source.vdfdsl.codegen.Codegen
import btpos.source.vdfdsl.codegen.CodegenProvider
import btpos.source.vdfdsl.codegen.ValueDecoderMulti
import btpos.source.vdfdsl.codegen.StringDecoderMap
import btpos.misc.kt.codegen.KtExpression
import btpos.misc.kt.codegen.identifiers.KtName
import btpos.source.vdfdsl.modeling.ExtensibleSubtreeImpl
import btpos.source.vdfdsl.modeling.IExtensibleSubtree
import btpos.source.vdfdsl.modeling.IExtensibleSubtree.Companion.addField
import btpos.source.vdfdsl.modeling.IExtensibleSubtree.Serializers.durationInSeconds
import btpos.source.vdfdsl.modeling.IExtensibleSubtree_VDFRepresentable
import btpos.source.vdfdsl.serialization.IVDFRepresentableValue_Trivial
import btpos.source.vdfdsl.types.spawners.AbstractSpawner
import btpos.source.vdfdsl.types.specifics.Where
import btpos.source.vdfdsl.utils.toSeconds
import kotlin.time.Duration

class MissionPopulator(_subtree: IExtensibleSubtree_VDFRepresentable = ExtensibleSubtreeImpl()) : AbstractPopulator(_subtree) {
	override val _structIdentifier: String
		get() = "Mission"
	
	override fun copy() = MissionPopulator(this.copyInternal())
	
	/**
	 * What should be spawned to fulfill this mission.
	 */
	override val spawner get() = super.spawner
	
	
	/**
	 * The name of the `info_teamspawn` entity the bots for this mission should spawn, or one of the [presets][Where].
	 */
	val where by addField<String>("Where")
	
	/**
	 * The objective of bots spawned by this mission.  See fields in [Objective].
	 */
	val objective by addField<Objective>("Objective")
	
	/**
	 * Delay this mission starting by this much time after the start of the [specified wave][beginAtWave].
	 */
	val initialCooldown by addField<Duration>("InitialCooldown", serializer = durationInSeconds())
	
	/**
	 * How long should elapse between procs of this mission.
	 */
	val cooldownTime by addField<Duration>("CooldownTime", serializer = durationInSeconds())
	
	/**
	 * What wave this mission should start being activated on.
	 */
	val beginAtWave by addField<Int>("BeginAtWave")
	
	/**
	 * How many waves after (and including) [beginAtWave] the mission should run for.
	 */
	val runForThisManyWaves by addField<Int>("RunForThisManyWaves")
	
	/**
	 * How many of the [specified spawner][AbstractPopulator.spawner] should be spawned when this mission procs.
	 */
	val desiredCount by addField<Number>("DesiredCount")
	
	companion object {
		val CODEGEN = IExtensibleSubtree.Codegen.registerCodegen<MissionPopulator>(
			customFieldDecoders = {
				mapOf(
					"Where" to Where.CODEGEN,
					"Objective" to Objective.CODEGEN
				)
			},
			factoryMethod = {
				Codegen.basicBlockScope(
					Populators::Mission,
					mapOf(
						MissionPopulator::beginAtWave.name to "waveNumber",
						MissionPopulator::runForThisManyWaves.name to "runForWaves"
					)
				)
			}
		)
	}
}


open class Objective(val item: String) : IVDFRepresentableValue_Trivial {
	override val _vdfRepr: VDFPrimitive
		get() = VDFPrimitive(item)
	
	companion object {
		val DestroySentries = Objective("DestroySentries")
		val SeekAndDestroy = Objective("SeekAndDestroy")
		val Sniper = Objective("Sniper")
		val Spy = Objective("Spy")
		val Engineer = Objective("Engineer")
		
		
		
		val CODEGEN: CodegenProvider<ValueDecoderMulti<KtExpression>> = CodegenProvider {
			StringDecoderMap (
				listOf(
					Objective::DestroySentries,
					Objective::SeekAndDestroy,
					Objective::Sniper,
					Objective::Spy,
					Objective::Engineer
				).map { it.name to KtName(it) }
			)
		}
	}
}







