package btpos.source.vdfdsl.tf2.rafmod.bot


import btpos.source.vdfdsl.backing.VDFKeyValue
import btpos.source.vdfdsl.backing.VDFPrimitive
import btpos.source.vdfdsl.backing.VDFSubtree
import btpos.source.vdfdsl.backing.asSubtree
import btpos.source.vdfdsl.backing.getAll
import btpos.source.vdfdsl.modeling.ExtensibleSubtreeImpl
import btpos.source.vdfdsl.modeling.IExtensibleSubtree_VDFRepresentable
import btpos.source.vdfdsl.tf2.items.TFItem

private const val WEAPON_RESIST_KEY = "WeaponResist"

/**
 * Multiplies damage received from weapons.
 */
open class WeaponResistBotExt(subtree: IExtensibleSubtree_VDFRepresentable = ExtensibleSubtreeImpl()) : RafmodBotExtension(subtree) {
	override fun copy() = WeaponResistBotExt(copyInternal())
	
	override val _structIdentifier get() = WEAPON_RESIST_KEY
	
	/**
	 * Multiplies the damage received from a specific weapon by the specified amount.
	 *
	 * Example:
	 * ```kotlin
	 * weaponDamageMults += Weapons.HUO_LONG_HEATER to 10 // Multiplies damage received from specifically the Huo Long Heater by `10`.
	 * ```
	 */
	open var weaponDamageMults: List<Pair<TFItem<*>, Number>> = listOf()
	
	/**
	 * Multiplies damage received from all weapons that use this item class by the specified amount.
	 *
	 * Example:
	 * ```kotlin
	 * itemClassDamageMults += "tf_weapon_flamethrower" to 0.1 // Multiplies damage received from all flamethrowers by 0.1
	 * ```
	 */
	open var itemClassDamageMults: List<Pair<String, Number>> = listOf()
	
	override fun _serializeInto(input: VDFSubtree) {
		super._serializeInto(input)
		
		val weaponResistBlock = input.getAll(WEAPON_RESIST_KEY).first().asSubtree!!
		weaponResistBlock += (itemClassDamageMults.asSequence().map { VDFPrimitive(it.first) to VDFPrimitive(it.second) } + weaponDamageMults.asSequence().map { (item, mult) -> item.namePrimitive to VDFPrimitive(mult) })
			.map { (name, mult) ->
				VDFKeyValue(name, mult, null)
			}
	}
}