package btpos.source.vdfdsl.tf2.itemattributes

import btpos.source.vdfdsl.tf2.itemattributes.impl.IBlockScoped


/**
 * Items: The Cleaner's Carbine
 */
interface ChargedSMGAttributes : SMGAttributes, IBlockScoped {
	companion object : ChargedSMGAttributes
	
	/**
	 * In-Game: "Secondary fire when charged grants mini-crits for N seconds."
	 *
	 * 
	 *
	 * Minicrit buff duration.
	 */
	context(attrs: btpos.source.vdfdsl.modeling.IKeyValueMap)
	var minicritBoostWhenCharged: Int?
		get() = attrs.getTyped("minicrit_boost_when_charged")
		set(value) = attrs.setNullable("minicrit_boost_when_charged", value)
}

