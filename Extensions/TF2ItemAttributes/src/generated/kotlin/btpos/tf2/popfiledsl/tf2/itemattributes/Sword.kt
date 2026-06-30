package btpos.tf2.popfiledsl.tf2.itemattributes

import btpos.tf2.popfiledsl.modeling.*
import btpos.tf2.popfiledsl.serialization.codecs.*


/**
 * Items: The Eyelander, The Scotsman's Skullcutter, The Horseless Headless Horseman's Headtaker, The Claidheamohmor (sic), The Persian Persuader, Nessie's Nine Iron, Festive Eyelander, The Half-Zatoichi
 */
interface SwordAttributes : BaseMeleeAttributes, IBlockScoped {
	companion object : SwordAttributes
	
	/**
	 * In-Game: "N% damage penalty"
	 *
	 * 
	 *
	 * More like a boolean, doesn't actually determine any kind of decapitation, just if it CAN decapitate.
	 */
	context(attrs: IKeyValueMap)
	var decapitateType: Int?
		get() = attrs.getTyped("decapitate type")
		set(value) = attrs.setNullable("decapitate type", value)
}

