package btpos.tf2.popfiledsl.tf2.itemattributes

import btpos.tf2.popfiledsl.modeling.*
import btpos.tf2.popfiledsl.serialization.codecs.*


/**
 * 
 */
abstract class ProjectileEnergyRingAttributes : BaseProjectileAttributes() {
	companion object : ProjectileEnergyRingAttributes() {
		operator fun invoke(scope: ProjectileEnergyRingAttributes.Companion.() -> Unit) {
			this.apply(scope)
		}
	}
	
	/**
	 * Checked on owner
	 */
	context(attrs: IKeyValueMap)
	var energyWeaponPenetration: Boolean?
		get() = attrs.getTyped("energy weapon penetration", BinaryIntCodec)
		set(value) = attrs.setNullable("energy weapon penetration", value, BinaryIntCodec)
}

