package btpos.source.vdfdsl.tf2.itemattributes

import btpos.source.vdfdsl.modeling.*
import btpos.source.vdfdsl.serialization.codecs.*


/**
 * Items: The Short Circuit
 */
interface MechanicalArmAttributes : btpos.source.vdfdsl.tf2.itemattributes.BaseGunAttributes, btpos.source.vdfdsl.tf2.itemattributes.IBlockScoped {
	companion object : MechanicalArmAttributes
	
	/**
	 * In-Game: "Per Shot: -N ammo"
	 *
	 * 
	 *
	 * How much ammo is used per shot. If 0, uses default.
	 */
	context(attrs: btpos.source.vdfdsl.modeling.IKeyValueMap)
	override var ammoPerShot: Int?
		get() = super.ammoPerShot
		set(value) { super.ammoPerShot = value }
}

