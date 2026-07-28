package btpos.source.vdfdsl.tf2.itemattributes

import btpos.source.vdfdsl.modeling.*
import btpos.source.vdfdsl.serialization.codecs.*
import btpos.source.vdfdsl.tf2.itemattributes.impl.*
import btpos.source.vdfdsl.tf2.tftypes.*
import java.util.*



/**
 * Items: The Eyelander, The Scotsman's Skullcutter, The Horseless Headless Horseman's Headtaker, The Claidheamohmor (sic), The Persian Persuader, Nessie's Nine Iron, Festive Eyelander
 */
interface SwordAttributes : IBlockScoped {
	companion object {
		/**
		 * In-Game: "N% damage penalty"
		 *
		 * 
		 *
		 * More like a boolean.  Doesn't actually determine any kind of decapitation, just if it CAN decapitate.
		 */
		val decapitateType = ItemAttributeNamed<Int>("decapitate type")
	}

	/**
	 * In-Game: "N% damage penalty"
	 *
	 * 
	 *
	 * More like a boolean.  Doesn't actually determine any kind of decapitation, just if it CAN decapitate.
	 */
	val decapitateType: ItemAttribute<Int> get() = SwordAttributes.decapitateType

   
}

