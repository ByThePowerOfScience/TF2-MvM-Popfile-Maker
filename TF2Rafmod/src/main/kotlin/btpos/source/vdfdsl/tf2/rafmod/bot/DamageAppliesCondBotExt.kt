package btpos.source.vdfdsl.tf2.rafmod.bot


import btpos.source.vdfdsl.backing.VDFKeyValue
import btpos.source.vdfdsl.backing.VDFPrimitive
import btpos.source.vdfdsl.backing.VDFSubtree
import btpos.source.vdfdsl.modeling.IExtensibleSubtree.Companion.addField
import btpos.source.vdfdsl.modeling.IExtensibleSubtree.Serializers.flatListWithKey
import btpos.source.vdfdsl.modeling.IExtensibleSubtree.Serializers.map
import btpos.source.vdfdsl.serialization.IVDFRepresentableValue_Subtree
import btpos.source.vdfdsl.tf2.rafmod.RafmodConstants.FIELD_NAME
import btpos.source.vdfdsl.tf2.rafmod.RafmodConstants.SIGSEGV
import btpos.source.vdfdsl.tf2.tftypes.TFCondition
import btpos.source.vdfdsl.types.spawners.TFBotSpawner
import btpos.source.vdfdsl.utils.toSeconds
import kotlin.time.Duration

/**
 * Apply these conditions with these durations when this bot hits a player.
 *
 * Example:
 * ```kotlin
 * damageAppliesConditions += TFCondition.Urine to 3.seconds
 * damageAppliesConditions += mapOf(
 *     TFCondition.Invulnerable to Duration.INFINITE,
 *     TFCondition.CritBoosted to 2.minutes
 * )
 * ```
 *
 * @see Duration.INFINITE
 */
val TFBotSpawner.damageAppliesConditions by addField<Map<TFCondition, Duration>, _>(
	"DamageAppliesCond",
	conditional = SIGSEGV,
	initialValue = { mapOf() },
	serializer = map(
		{ it.entries },
		mapEach (
			{ (cond, duration): Map.Entry<TFCondition, Duration> ->
				val duration = if (duration.isInfinite()) {
					-1
				} else duration.toSeconds()
				IVDFRepresentableValue_Subtree { parent ->
					VDFSubtree(parent, mutableListOf(
						VDFKeyValue(FIELD_NAME, cond.TF_COND_primitive),
						VDFKeyValue(VDFPrimitive("Duration"), VDFPrimitive(duration))
					))
				}
			},
			flatListWithKey<IVDFRepresentableValue_Subtree>()
		)
	)
)

