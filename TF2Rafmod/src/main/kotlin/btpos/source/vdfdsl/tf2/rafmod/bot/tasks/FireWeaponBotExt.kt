package btpos.source.vdfdsl.tf2.rafmod.bot.tasks


import btpos.source.vdfdsl.modeling.ExtensibleSubtreeImpl
import btpos.source.vdfdsl.modeling.IExtensibleSubtree.Companion.addField
import btpos.source.vdfdsl.modeling.IExtensibleSubtree.Serializers.durationInSeconds
import btpos.source.vdfdsl.modeling.IExtensibleSubtree_VDFRepresentable
import btpos.source.vdfdsl.tf2.rafmod.RafmodConstants.SIGSEGV
import btpos.source.vdfdsl.tf2.rafmod.types.ButtonInputType
import kotlin.time.Duration

/**
 * Emulates a button press on the bot.
 */
open class FireWeaponBotExt(subtree: IExtensibleSubtree_VDFRepresentable = ExtensibleSubtreeImpl()) : RafmodPeriodicTask(subtree) {
	override fun copy() = FireWeaponBotExt(copyInternal())
	
	override val _structIdentifier get() = "FireWeapon"
	
	/**
	 * How long the emulated button press should be held.
	 * 
	 * Example:
	 * ```kotlin
	 * duration = 0.5.seconds
	 * ```
	 */
	open var duration: Duration? by addField("Duration", conditional = SIGSEGV, serializer = durationInSeconds())
	
	/**
	 * What button should be pressed.
	 * 
	 * Example:
	 * ```kotlin
	 * type = ButtonInputType.MOUSE1 // Clicks
	 * type = ButtonInputType.MOUSE2 // Right-clicks
	 * ```
	 *
	 * @see ButtonInputType.Companion
	 */
	open var type: ButtonInputType? by addField("Type", conditional = SIGSEGV)
}

