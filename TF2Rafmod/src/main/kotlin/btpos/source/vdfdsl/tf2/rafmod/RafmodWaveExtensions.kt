package btpos.source.vdfdsl.tf2.rafmod

import btpos.source.vdfdsl.backing.VDFKeyValue
import btpos.source.vdfdsl.backing.VDFSubtree
import btpos.source.vdfdsl.modeling.IExtensibleSubtree.Companion.addField
import btpos.source.vdfdsl.modeling.IExtensibleSubtree.Companion.addFieldList
import btpos.source.vdfdsl.modeling.IExtensibleSubtree.Serializers.flatListWithKey
import btpos.source.vdfdsl.modeling.IExtensibleSubtree.Serializers.map
import btpos.source.vdfdsl.modeling.IExtensibleSubtree.Serializers.mapEachCond
import btpos.source.vdfdsl.serialization.IVDFRepresentableValue_Subtree
import btpos.source.vdfdsl.tf2.itemattributes.AttributeContainerImpl
import btpos.source.vdfdsl.tf2.itemattributes.AttributeContainerSubtreeSerializable
import btpos.source.vdfdsl.tf2.itemattributes.IAttributeContainer
import btpos.source.vdfdsl.tf2.rafmod.RafmodConstants.SIGSEGV
import btpos.source.vdfdsl.tf2.rafmod.data.Vec3
import btpos.source.vdfdsl.tf2.templates.PopFileTemplate
import btpos.source.vdfdsl.types.populators.WavePopulator

abstract class RafmodWaveExtensions {
	companion object {
		@PublishedApi @JvmField internal val INSTANCE = object : RafmodWaveExtensions() {}
	}
	
	/**
	 * Displays a custom wave number for this wave. Maximum value: 511
	 * 
	 * Example:
	 * ```kotlin
	 * waveNumber = 419
	 * ```
	 */
	open val WavePopulator.waveNumber by addField<Int>("CustomWaveNumber", conditional = SIGSEGV)
	
	/**
	 * Displays a custom maximum wave count while this wave is active.  0 hides the max wave number in the display.
	 * 
	 * Example:
	 * ```kotlin
	 * maxWaveNumber = 20 // Shows "Wave X/20"
	 *
	 * maxWaveNumber = 0  // Shows "Wave X"
	 * ```
	 */
	open val WavePopulator.maxWaveNumber by addField<Int>("CustomMaxWaveNumber", conditional = SIGSEGV)
	
	/**
	 * If true, the wave is immediately lost if all RED players are dead at the same time.
	 */
	open val WavePopulator.redTeamWipeCausesWaveLoss by addField<Boolean>("RedTeamWipeCausesWaveLoss", conditional = SIGSEGV)
	
	/**
	 * If true, the wave is immediately lost if all BLU _human_ players are dead at the same time.
	 */
	open val WavePopulator.blueTeamWipeCausesWaveLoss by addField<Boolean>("BlueTeamWipeCausesWaveLoss", conditional = SIGSEGV)
	
	/**
	 * If true, the moment all non-support wavespawns are finished (killed), the wave is immediately **lost**.
	 */
	open val WavePopulator.finishingWaveCausesWaveLoss by addField<Boolean>("FinishingWaveCausesWaveLoss", conditional = SIGSEGV)
	
	// TODO Explanation builder
	
	/**
	 * Attributes set on all players while this wave is active.
	 *
	 * @see playerAttributes
	 */
	open val WavePopulator.playerAttributes by addField<IAttributeContainer, _>("PlayerAttributes", conditional = SIGSEGV, serializer = ::AttributeContainerSubtreeSerializable)
	
	
	/**
	 * Add attributes to all players while this wave is active.
	 *
	 * @see btpos.source.vdfdsl.tf2.itemattributes
	 */
	open fun WavePopulator.playerAttributes(scope: context (IAttributeContainer) () -> Unit) {
		val attrs = this.playerAttributes.get() ?: run {
			AttributeContainerImpl().also {
				this.playerAttributes = it
			}
		}
		context (attrs) {
			scope()
		}
	}
	
	/**
	 * Adds attributes to these specified items (when held by players) while this wave is active.
	 *
	 * Example:
	 * ```kotlin
	 * itemAttributes += Weapons.SCOTTISH_RESISTANCE.configureAttributes {
	 *   reloadSpeed.bonus = 0.25
	 * }
	 * ```
	 */
	open val WavePopulator.itemAttributes by addFieldList<IAttributeContainer>("ItemAttributes", conditional = SIGSEGV, serializer = mapEachCond(::AttributeContainerSubtreeSerializable, flatListWithKey()))
	
	/**
	 * Add this condition to players when the wave starts.
	 * 
	 * Example:
	 * ```kotlin
	 * playerAddCond = 56
	 * ```
	 */
	open val WavePopulator.playerAddCond by addField<Int>("PlayerAddCond", conditional = SIGSEGV)
	
	/**
	 * Spawn these templates at these positions once the mission starts.
	 * 
	 * Example:
	 * ```kotlin
	 * spawnedTemplatesAtStart += MyTemplates.SENTRY to Vec3(0, -800, 500)
	 * ```
	 */
	open val WavePopulator.spawnedTemplatesAtStart by addFieldList<Pair<PopFileTemplate, Vec3>>(
		"SpawnTemplate",
		conditional = SIGSEGV,
		serializer = map({ list ->
			list.map { (v, cond) ->
				val (template, coord) = v
				IVDFRepresentableValue_Subtree { parent ->
					VDFSubtree(
						parent,
						listOf(
							VDFKeyValue("Name", template.name, cond),
							VDFKeyValue("Origin", RafmodSerializers.COORD3D(coord), cond)
						)
					)
				}
			}
		}, flatListWithKey<IVDFRepresentableValue_Subtree>())
	)
}

@Suppress("UnusedReceiverParameter")
inline fun WavePopulator.rafmod(scope: RafmodWaveExtensions.() -> Unit) {
	RafmodWaveExtensions.INSTANCE.scope()
}