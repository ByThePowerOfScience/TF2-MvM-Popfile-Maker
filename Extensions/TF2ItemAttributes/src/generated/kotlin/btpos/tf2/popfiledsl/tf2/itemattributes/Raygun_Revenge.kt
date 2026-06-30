package btpos.tf2.popfiledsl.tf2.itemattributes

import btpos.tf2.popfiledsl.modeling.*
import btpos.tf2.popfiledsl.serialization.codecs.*


/**
 * Items: NONE (but it's there at least?)
 */
interface Raygun_RevengeAttributes : RayGunAttributes {
	companion object : Raygun_RevengeAttributes
	
	/**
	 * 
	 *
	 * Removes ammo requirement to fire weapon.
	 *
	 * Removes ammo requirement to fire weapon.
	 */
	context(attrs: IKeyValueMap)
	override var energyWeaponNoDrain: Boolean?
		get() = super.energyWeaponNoDrain
		set(value) { super.energyWeaponNoDrain = value }
}

inline operator fun Raygun_RevengeAttributes.invoke(scope: Raygun_RevengeAttributes.() -> Unit) {
	this.apply(scope)
}

