package btpos.source.vdfdsl.tf2.itemattributes

import btpos.source.vdfdsl.modeling.*
import btpos.source.vdfdsl.serialization.codecs.*
import btpos.source.vdfdsl.tf2.itemattributes.impl.*
import btpos.source.vdfdsl.tf2.tftypes.*
import java.util.*



/**
 * Items: The Shortstop, The Winger, Pretty Boy's Pocket Pistol
 */
interface ScoutPistolAttributes : IBlockScoped {
	companion object {
		/**
		 * 
		 *
		 * If true, can headshot when behind an enemy.
		 */
		val backHeadshot = ItemAttributeNamed<Boolean>("back headshot")
	}

	/**
	 * 
	 *
	 * If true, can headshot when behind an enemy.
	 */
	val backHeadshot: ItemAttribute<Boolean> get() = ScoutPistolAttributes.backHeadshot

   
}

