package btpos.source.vdfdsl.tf2.attributes

import btpos.source.vdfdsl.modeling.*
import btpos.source.vdfdsl.serialization.codecs.*
import btpos.source.vdfdsl.tf2.attributes.impl.*
import java.util.*

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
	 * More like a boolean.  Doesn't actually determine any kind of decapitation, just if it CAN decapitate.
	 *
	 * Checked on all hitscan attacks.
	 *
	 * More like a boolean, doesn't actually determine any kind of decapitation, just if it CAN decapitate.
	 */
	context(attrs: IKeyValueMap)
	override var decapitateType: Int?
		get() = super.decapitateType
		set(value) { super.decapitateType = value }
}

