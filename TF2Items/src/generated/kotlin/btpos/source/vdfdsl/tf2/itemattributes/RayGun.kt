package btpos.source.vdfdsl.tf2.itemattributes

import btpos.source.vdfdsl.modeling.*
import btpos.source.vdfdsl.serialization.codecs.*
import btpos.source.vdfdsl.tf2.itemattributes.impl.*
import btpos.source.vdfdsl.tf2.tftypes.*
import java.util.*



/**
 * Items: The Righteous Bison, The Pomson 6000
 */
interface RayGunAttributes : IBlockScoped {
	companion object {
		/**
		 * 
		 *
		 * Removes ammo requirement to fire weapon.
		 */
		val energyWeaponNoDrain = ItemAttributeNamed<Boolean>("energy weapon no drain")
	}

	/**
	 * 
	 *
	 * Removes ammo requirement to fire weapon.
	 */
	val energyWeaponNoDrain: ItemAttribute<Boolean> get() = RayGunAttributes.energyWeaponNoDrain

   
}

