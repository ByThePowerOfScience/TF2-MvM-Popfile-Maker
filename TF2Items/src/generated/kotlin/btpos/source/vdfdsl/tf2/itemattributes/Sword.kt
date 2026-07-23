package btpos.source.vdfdsl.tf2.itemattributes

import btpos.source.vdfdsl.modeling.*
import btpos.source.vdfdsl.serialization.codecs.*
import btpos.source.vdfdsl.tf2.itemattributes.impl.*
import java.util.*

/**
 * Items: The Eyelander, The Scotsman's Skullcutter, The Horseless Headless Horseman's Headtaker, The Claidheamohmor (sic), The Persian Persuader, Nessie's Nine Iron, Festive Eyelander
 */
interface SwordAttributes : BaseMeleeAttributes, IBlockScoped {
	companion object : SwordAttributes
	
	/**
	 * In-Game: "N% damage penalty"
	 *
	 * 
	 *
	 * More like a boolean.  Doesn't actually determine any kind of decapitation, just if it CAN decapitate.
	 */
	context(attrs: IKeyValueMap)
	var decapitateType: Int?
		get() = attrs.getTyped("decapitate type")
		set(value) = attrs.setNullable("decapitate type", value)
}

