package btpos.source.vdfdsl.tf2.itemattributes

import btpos.source.vdfdsl.tf2.itemattributes.impl.IBlockScoped


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
	context(attrs: btpos.source.vdfdsl.modeling.IKeyValueMap)
	var decapitateType: Int?
		get() = attrs.getTyped("decapitate type")
		set(value) = attrs.setNullable("decapitate type", value)
}

