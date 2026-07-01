package btpos.source.vdfdsl.tf2.itemattributes

import btpos.source.vdfdsl.tf2.itemattributes.impl.IBlockScoped


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
	context(attrs: btpos.source.vdfdsl.modeling.IKeyValueMap)
	override var energyWeaponNoDrain: Boolean?
		get() = super.energyWeaponNoDrain
		set(value) {
			super.energyWeaponNoDrain = value
		}
}

