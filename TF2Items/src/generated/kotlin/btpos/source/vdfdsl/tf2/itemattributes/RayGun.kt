package btpos.source.vdfdsl.tf2.itemattributes

import btpos.source.vdfdsl.modeling.*
import btpos.source.vdfdsl.serialization.codecs.*
import btpos.source.vdfdsl.tf2.itemattributes.impl.*
import btpos.source.vdfdsl.tf2.tftypes.*
import java.util.*




interface RayGunAttributes : RocketLauncherAttributes {
	
	companion object {
		/**
		 * Removes ammo requirement to fire weapon.
		 */
		val energyWeaponNoDrain: ItemAttributeNamed<Boolean> = ItemAttributeNamed("energy weapon no drain")
	}

	/**
	 * Removes ammo requirement to fire weapon.
	 */
	val energyWeaponNoDrain: ItemAttributeNamed<Boolean> get() = RayGunAttributes.energyWeaponNoDrain
}