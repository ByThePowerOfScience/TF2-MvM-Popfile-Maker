package btpos.source.vdfdsl.tf2.rafmod.bot.tasks

import btpos.source.vdfdsl.modeling.ExtensibleSubtreeImpl
import btpos.source.vdfdsl.modeling.IExtensibleSubtree.Companion.addField
import btpos.source.vdfdsl.modeling.IExtensibleSubtree.Serializers.durationInSeconds
import btpos.source.vdfdsl.modeling.IExtensibleSubtree_VDFRepresentable
import btpos.source.vdfdsl.tf2.rafmod.RafmodConstants.SIGSEGV
import kotlin.time.Duration

/**
 * Makes the bot taunt periodically.
 */
open class TauntBotExt(subtree: IExtensibleSubtree_VDFRepresentable = ExtensibleSubtreeImpl()) : RafmodPeriodicTask(subtree) {
	override fun copy() = TauntBotExt(copyInternal())
	
	override val _structIdentifier get() = "Taunt"
	
	
	/**
	 * Duration of a looping taunt. (Default: 0.1)
	 *
	 * Example:
	 * ```kotlin
	 * duration = 5.seconds
	 * ```
	 */
	open var duration: Duration? by addField("Duration", conditional = SIGSEGV, serializer = durationInSeconds())
	
	/**
	 * If set, uses this item taunt instead of the current weapon's taunt.
	 *
	 * Example:
	 * ```kotlin
	 * tauntName = "Taunt: Kazotsky Kick"
	 * ```
	 */
	open var tauntName: String? by addField("Name", conditional = SIGSEGV)
}