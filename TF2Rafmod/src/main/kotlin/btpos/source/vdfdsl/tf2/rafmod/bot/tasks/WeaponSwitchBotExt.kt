package btpos.source.vdfdsl.tf2.rafmod.bot.tasks


import btpos.source.vdfdsl.backing.VDFPrimitive
import btpos.source.vdfdsl.modeling.ExtensibleSubtreeImpl
import btpos.source.vdfdsl.modeling.IExtensibleSubtree.Companion.addField
import btpos.source.vdfdsl.modeling.IExtensibleSubtree_VDFRepresentable
import btpos.source.vdfdsl.serialization.IVDFRepresentableValue_Trivial
import btpos.source.vdfdsl.tf2.rafmod.RafmodConstants.SIGSEGV

/**
 * Periodically switches the weapon equipped by this bot.
 */
open class WeaponSwitchBotExt(subtree: IExtensibleSubtree_VDFRepresentable = ExtensibleSubtreeImpl()) : RafmodPeriodicTask(subtree) {
	override fun copy() = WeaponSwitchBotExt(copyInternal())
	
	override val _structIdentifier get() = "WeaponSwitch"
	
	/**
	 * The weapon slot the bot should switch to.
	 * 
	 * Example:
	 * ```kotlin
	 * type = WeaponType.Primary
	 * ```
	 */
	open var type: Type? by addField("Type", conditional = SIGSEGV)
	
	open class Type(val name: String) : IVDFRepresentableValue_Trivial {
		companion object {
			@JvmField val Primary = Type("Primary")
			@JvmField val Secondary = Type("Secondary")
			@JvmField val Melee = Type("Melee")
			@JvmField val PDA = Type("PDA")
			@JvmField val Building = Type("Building")
		}
		override val _vdfRepr: VDFPrimitive = VDFPrimitive(this.name)
	}
}