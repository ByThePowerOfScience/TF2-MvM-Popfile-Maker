package btpos.source.vdfdsl.tf2.rafmod.bot


import btpos.source.vdfdsl.modeling.ExtensibleSubtreeImpl
import btpos.source.vdfdsl.modeling.IExtensibleSubtree.Companion.addField
import btpos.source.vdfdsl.modeling.IExtensibleSubtree_VDFRepresentable
import btpos.source.vdfdsl.tf2.rafmod.RafmodConstants.SIGSEGV
import btpos.source.vdfdsl.tf2.rafmod.bot.tasks.RafmodPeriodicTask
import btpos.source.vdfdsl.tf2.tftypes.TFCondition
import btpos.source.vdfdsl.utils.toSeconds
import kotlin.time.Duration

/**
 * Adds conditions to players on hit.
 *
 * Alternatively, use the [RafmodItemAttributes.addCondOnHit] attribute.
 */
open class DamageAppliesCondBotExt(subtree: IExtensibleSubtree_VDFRepresentable = ExtensibleSubtreeImpl()) : RafmodBotExtension(subtree) {
	override fun copy() = DamageAppliesCondBotExt(copyInternal())
	
	override val _structIdentifier get() = "DamageAppliesCond"
	
	/**
	 * The condition to apply to players when hit by this bot.
	 *
	 * Example:
	 * ```kotlin
	 * condition = TFCondition.Urine
	 * ```
	 */
	open var condition: TFCondition? by addField("Name", conditional = SIGSEGV, serializer = TFCondition::index)
	
	/**
	 * How long the condition should be applied to the hit player. (Default: [infinite duration][Duration.INFINITE])
	 *
	 * Example:
	 * ```kotlin
	 * duration = 99.seconds
	 *
	 * duration = Duration.INFINITE // condition will never be removed
	 * ```
	 * @see Duration.INFINITE
	 */
	open var duration: Duration? by addField("Duration", conditional = SIGSEGV, serializer = {
		if (this == Duration.INFINITE)
			-1
		else
			this.toSeconds()
	})
}