package btpos.source.vdfdsl.tf2.rafmod.bot.tasks


import btpos.source.vdfdsl.modeling.ExtensibleSubtreeImpl
import btpos.source.vdfdsl.modeling.IExtensibleSubtree.Companion.addField
import btpos.source.vdfdsl.modeling.IExtensibleSubtree_VDFRepresentable
import btpos.source.vdfdsl.tf2.rafmod.RafmodConstants.SIGSEGV

open class FireInputBotExt(subtree: IExtensibleSubtree_VDFRepresentable = ExtensibleSubtreeImpl()) : RafmodPeriodicTask(subtree) {
	override fun copy() = FireInputBotExt(copyInternal())

	override val _structIdentifier get() = "FireInput"
	
	/**
	 * The name of the entity to fire an input on. `!self` and `!activator` both target the bot this FireInput block is on.
	 *
	 * Example:
	 * ```kotlin
	 * targetEntity = "random_color_case"
	 * ```
	 */
	open var targetEntity: String? by addField("Target", conditional = SIGSEGV)
	
	/**
	 * The input to fire on the [targeted entity][targetEntity].
	 *
	 * Example:
	 * ```kotlin
	 * action = "PickRandom"
	 * ```
	 */
	open var action: String? by addField("Action", conditional = SIGSEGV)
	
	/**
	 * How many times the bot should perform this task in total.
	 *
	 * NOTE: DEFAULTS TO 0/INFINITE.  Set to `1` to only fire an input once.
	 *
	 * Example:
	 * ```kotlin
	 * timesRepeated = 1
	 * ```
	 */
	override var timesRepeated: Int?
		get() = super.timesRepeated
		set(value) { super.timesRepeated = value }
}