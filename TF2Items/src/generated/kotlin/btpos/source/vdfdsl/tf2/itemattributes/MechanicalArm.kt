package btpos.source.vdfdsl.tf2.itemattributes

import btpos.source.vdfdsl.modeling.*
import btpos.source.vdfdsl.serialization.codecs.*
import btpos.source.vdfdsl.tf2.itemattributes.impl.*
import btpos.source.vdfdsl.tf2.tftypes.*
import java.util.*



/**
 * Items: The Short Circuit
 */
interface MechanicalArmAttributes : IBlockScoped {
	companion object {
		/**
		 * In-Game: "Per Shot: -N ammo"
		 *
		 * 
		 */
		val ammoPerShot = ItemAttributeNamed<Int>("mod ammo per shot")
	}

	/**
	 * In-Game: "Per Shot: -N ammo"
	 *
	 * 
	 */
	val ammoPerShot: ItemAttribute<Int> get() = MechanicalArmAttributes.ammoPerShot

   
}

