package btpos.tf2.popfiledsl.tf2.itemattributes

import btpos.tf2.popfiledsl.modeling.*
import btpos.tf2.popfiledsl.serialization.codecs.*


/**
 * Items: The Short Circuit
 * 
 */
abstract class MechanicalArmAttributes : BaseGunAttributes() {
	companion object : MechanicalArmAttributes() {
		operator fun invoke(scope: MechanicalArmAttributes.Companion.() -> Unit) {
			this.apply(scope)
		}
	}
	
	/**
	 * How much ammo is used per shot. If 0, uses default.
	 * 
	 */
	override context(attrs: IKeyValueMap)
	var modAmmoPerShot: Int?
		get() = attrs.getTyped("mod ammo per shot")
		set(value) = attrs.setNullable("mod ammo per shot", value)
}

