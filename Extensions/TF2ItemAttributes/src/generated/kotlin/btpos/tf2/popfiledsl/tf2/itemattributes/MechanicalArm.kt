package btpos.tf2.popfiledsl.tf2.itemattributes

import btpos.tf2.popfiledsl.modeling.*
import btpos.tf2.popfiledsl.serialization.codecs.*


/**
 * Items: The Short Circuit
 */
interface MechanicalArmAttributes : BaseGunAttributes {
	companion object : MechanicalArmAttributes
	
	/**
	 * In-Game: "Per Shot: -N ammo"
	 *
	 * 
	 *
	 * How much ammo is used per shot. If 0, uses default.
	 */
	context(attrs: IKeyValueMap)
	override var ammoPerShot: Int?
		get() = super.ammoPerShot
		set(value) { super.ammoPerShot = value }
}

inline operator fun MechanicalArmAttributes.invoke(scope: MechanicalArmAttributes.() -> Unit) {
	this.apply(scope)
}

