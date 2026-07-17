package btpos.source.vdfdsl.tf2.rafmod

import btpos.source.vdfdsl.backing.VDFKeyValue
import btpos.source.vdfdsl.backing.VDFSubtree
import btpos.source.vdfdsl.modeling.IExtensibleSubtree.Companion.addField
import btpos.source.vdfdsl.modeling.IExtensibleSubtree.Serializers.compose
import btpos.source.vdfdsl.modeling.IExtensibleSubtree.Serializers.flatListWithKey
import btpos.source.vdfdsl.modeling.IKeyValueMap
import btpos.source.vdfdsl.modeling.KeyValueMapImpl
import btpos.source.vdfdsl.serialization.IVDFRepresentableValue_Subtree
import btpos.source.vdfdsl.serialization.codecs.BinaryIntCodec
import btpos.source.vdfdsl.tf2.rafmod.RafmodConstants.SIGSEGV
import btpos.source.vdfdsl.tf2.rafmod.data.Coord3D
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
	var WavePopulator.waveNumber: Int? by addField("CustomWaveNumber", conditional = SIGSEGV)
	
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
	var WavePopulator.maxWaveNumber: Int? by addField("CustomMaxWaveNumber", conditional = SIGSEGV)
	
	/**
	 * If true, the wave is immediately lost if all RED players are dead at the same time.
	 */
	var WavePopulator.redTeamWipeCausesWaveLoss: Boolean? by addField("RedTeamWipeCausesWaveLoss", conditional = SIGSEGV, serializer = BinaryIntCodec::write)
	
	/**
	 * If true, the wave is immediately lost if all BLU _human_ players are dead at the same time.
	 */
	var WavePopulator.blueTeamWipeCausesWaveLoss: Boolean? by addField("BlueTeamWipeCausesWaveLoss", conditional = SIGSEGV, serializer = BinaryIntCodec::write)
	
	/**
	 * If true, the moment all non-support wavespawns are finished (killed), the wave is immediately **lost**.
	 */
	var WavePopulator.finishingWaveCausesWaveLoss: Boolean? by addField("FinishingWaveCausesWaveLoss", conditional = SIGSEGV, serializer = BinaryIntCodec::write)
	
	// TODO Explanation builder
	
	/**
	 * Attributes set on all players while this wave is active.
	 *
	 * @see playerAttributes
	 */
	var WavePopulator.playerAttributes: KeyValueMapImpl? by addField("PlayerAttributes", conditional = SIGSEGV)
	
	
	/**
	 * Add attributes to all players while this wave is active.
	 *
	 * @see btpos.source.vdfdsl.tf2.itemattributes
	 */
	inline fun WavePopulator.playerAttributes(scope: context (IKeyValueMap) () -> Unit) {
		val attrs = this.playerAttributes ?: run {
			KeyValueMapImpl().also {
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
	var WavePopulator.itemAttributes: List<KeyValueMapImpl> by addField("ItemAttributes", conditional = SIGSEGV, serializer = flatListWithKey(), initialValue = ::listOf)
	
	/**
	 * Add this condition to players when the wave starts.
	 * 
	 * Example:
	 * ```kotlin
	 * playerAddCond = 56
	 * ```
	 */
	var WavePopulator.playerAddCond: Int? by addField("PlayerAddCond", conditional = SIGSEGV)
	
	// TODO add a TFCondition enum
	
	/**
	 * Spawn these templates at these positions once the mission starts.
	 * 
	 * Example:
	 * ```kotlin
	 * spawnedTemplatesAtStart += MyTemplates.SENTRY to Coord3D(0, -800, 500)
	 * ```
	 */
	var WavePopulator.spawnedTemplatesAtStart: List<Pair<PopFileTemplate, Coord3D>> by addField(
		"SpawnTemplate",
		conditional = SIGSEGV,
		serializer = flatListWithKey<IVDFRepresentableValue_Subtree>().compose { list: List<Pair<PopFileTemplate, Coord3D>> ->
			list.map { (template, coord) ->
				IVDFRepresentableValue_Subtree { parent ->
					VDFSubtree(
						parent,
						listOf(
							VDFKeyValue("Name", template.name, null),
							VDFKeyValue("Origin", RafmodSerializers.COORD3D(coord), null)
						)
					)
				}
			}
		},
		initialValue = ::listOf
	)
}

@Suppress("UnusedReceiverParameter")
inline fun WavePopulator.rafmod(scope: RafmodWaveExtensions.() -> Unit) {
	RafmodWaveExtensions.INSTANCE.scope()
}