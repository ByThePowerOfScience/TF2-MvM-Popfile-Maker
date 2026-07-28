package btpos.source.vdfdsl.tf2.itemattributes

import btpos.source.vdfdsl.modeling.*
import btpos.source.vdfdsl.serialization.codecs.*
import btpos.source.vdfdsl.tf2.itemattributes.impl.*
import btpos.source.vdfdsl.tf2.tftypes.*
import java.util.*



/**
 * Items: tock Fists, The Killing Gloves of Boxing, Warrior's Spirit, Fists of Steel, The Eviction Notice, Apoco-Fists, The Holiday Punch, The Bread Bite, Gloves of Running Urgently MvM
 */
interface FistsAttributes : IBlockScoped {
	companion object {
		/**
		 * 
		 *
		 * Note that despite being present in the item schema, this is explicitly COMMENTED OUT of the code, and has no gameplay effects at least.
		 */
		val breadglovesProperties = ItemAttributeNamed<Boolean>("breadgloves properties")
	}

	/**
	 * 
	 *
	 * Note that despite being present in the item schema, this is explicitly COMMENTED OUT of the code, and has no gameplay effects at least.
	 */
	val breadglovesProperties: ItemAttribute<Boolean> get() = FistsAttributes.breadglovesProperties

   
}

