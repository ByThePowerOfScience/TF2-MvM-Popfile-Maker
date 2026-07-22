package btpos.source.vdfdsl.tf2.rafmod.bot.tasks


import btpos.source.vdfdsl.modeling.ExtensibleSubtreeImpl
import btpos.source.vdfdsl.modeling.IExtensibleSubtree.Companion.addField
import btpos.source.vdfdsl.modeling.IExtensibleSubtree_VDFRepresentable
import btpos.source.vdfdsl.tf2.rafmod.RafmodConstants.SIGSEGV
import btpos.source.vdfdsl.tf2.tftypes.TFCondition
import btpos.source.vdfdsl.utils.toSeconds
import kotlin.time.Duration

/**
 * Adds a condition to a bot.
 */
open class AddCondBotExt(subtree: IExtensibleSubtree_VDFRepresentable = ExtensibleSubtreeImpl()) : RafmodPeriodicTask(subtree) {
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
	open var condition: TFCondition? by addField("Name", conditional = SIGSEGV, serializer = TFCondition::index)
	
	/**
	 * The delay after the bot spawns before the condition is applied to them. (Default: 0 seconds / instantly)
	 */
	override var delay: Duration?
		get() = super.delay
		set(value) { super.delay = value }
	
	/**
	 * How long the condition should be applied every time this task procs. (Default: [infinite duration][Duration.INFINITE])
	 *
	 * Example:
	 * ```kotlin
	 * duration = 99.seconds
	 *
	 * duration = Duration.INFINITE // condition is never removed
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