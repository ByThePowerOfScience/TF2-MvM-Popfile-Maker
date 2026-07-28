package btpos.source.vdfdsl.tf2.itemattributes

import btpos.source.vdfdsl.modeling.*
import btpos.source.vdfdsl.serialization.codecs.*
import btpos.source.vdfdsl.tf2.itemattributes.impl.*
import btpos.source.vdfdsl.tf2.tftypes.*
import java.util.*



/**
 * Items: The Righteous Bison, The Pomson 6000
 */
interface ProjectileEnergyRingAttributes : IBlockScoped {
	companion object {
		/**
		 * In-Game: "Projectile penetrates enemy targets"
		 *
		 * 
		 *
		 * Checked on owner.
		 */
		val energyWeaponPenetration = ItemAttributeNamed<Boolean>("energy weapon penetration")
	}

	/**
	 * In-Game: "Projectile penetrates enemy targets"
	 *
	 * 
	 *
	 * Checked on owner.
	 */
	val energyWeaponPenetration: ItemAttribute<Boolean> get() = ProjectileEnergyRingAttributes.energyWeaponPenetration

   
}

