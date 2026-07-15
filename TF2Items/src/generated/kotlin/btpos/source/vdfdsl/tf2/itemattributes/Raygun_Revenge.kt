package btpos.source.vdfdsl.tf2.itemattributes

import btpos.source.vdfdsl.modeling.*
import btpos.source.vdfdsl.serialization.codecs.*
import btpos.source.vdfdsl.tf2.itemattributes.impl.*
import java.util.*

/**
 * Items: NONE (but it's there at least?)
 */
interface Raygun_RevengeAttributes : RayGunAttributes, IBlockScoped {
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

