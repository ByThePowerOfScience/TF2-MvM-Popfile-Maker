package btpos.source.vdfdsl.tf2.rafmod.bot

import btpos.source.vdfdsl.modeling.ExtensibleSubtreeImpl
import btpos.source.vdfdsl.modeling.IExtensibleSubtree
import btpos.source.vdfdsl.modeling.IExtensibleSubtree_VDFRepresentable
import btpos.source.vdfdsl.tf2.rafmod.RafmodConstants
import btpos.source.vdfdsl.tf2.rafmod.bot.tasks.RafmodPeriodicTask
import btpos.source.vdfdsl.tf2.tftypes.TFCondition
import btpos.source.vdfdsl.utils.toSeconds
import kotlin.time.Duration

/**
 * Adds a condition to a bot.
 */
open class AddCondBotExt(subtree: IExtensibleSubtree_VDFRepresentable = ExtensibleSubtreeImpl()) : RafmodBotExtension(subtree) {
	override fun copy() = AddCondBotExt(copyInternal())
	
	override val _structIdentifier get() = "AddCond"
	
	/**
	 * The condition to apply.
	 *
	 * Example:
	 * ```kotlin
	 * condition = TFCondition.Urine
	 * ```
	 */
	open var condition: TFCondition? by IExtensibleSubtree.addField("Name", conditional = RafmodConstants.SIGSEGV, serializer = TFCondition::TF_COND_primitive)
	
	/**
	 * Number of seconds after the bot spawns before the condition is applied. (Default: 0 seconds / instant)
	 *
	 * Example:
	 * ```kotlin
	 * delay = 2.seconds
	 * ```
	 */
	open var delay: Duration? by IExtensibleSubtree.Companion.addField("Delay", conditional = RafmodConstants.SIGSEGV)
	
	
	/**
	 * How long this condition should be applied for. (Default: [infinite duration][Duration.Companion.INFINITE])
	 *
	 * Example:
	 * ```kotlin
	 * duration = 99.seconds
	 *
	 * duration = Duration.INFINITE // condition is never removed
	 * ```
	 *
	 * @see Duration.Companion.INFINITE
	 */
	open var duration: Duration? by IExtensibleSubtree.Companion.addField("Duration", conditional = RafmodConstants.SIGSEGV, serializer = {
		if (this == Duration.INFINITE)
			-1
		else
			this.toSeconds()
	})
	
	/**
	 * When set, the condition is applied only when the bot's health is below the specified value.
	 *
	 * Example:
	 * ```kotlin
	 * ifHealthBelow = 100
	 * ```
	 */
	open var ifHealthBelow: Int? by IExtensibleSubtree.Companion.addField("IfHealthBelow", conditional = RafmodConstants.SIGSEGV)
	
	/**
	 * When set, the condition is applied only when the bot's health is above the specified value.
	 *
	 * Example:
	 * ```kotlin
	 * ifHealthAbove = 100
	 * ```
	 */
	open var ifHealthAbove: Int? by IExtensibleSubtree.Companion.addField("IfHealthAbove", conditional = RafmodConstants.SIGSEGV)
	
	
}