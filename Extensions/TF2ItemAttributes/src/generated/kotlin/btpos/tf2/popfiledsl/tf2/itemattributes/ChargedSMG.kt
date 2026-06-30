package btpos.tf2.popfiledsl.tf2.itemattributes

import btpos.tf2.popfiledsl.modeling.*
import btpos.tf2.popfiledsl.serialization.codecs.*


/**
 * Items: The Cleaner's Carbine
 */
interface ChargedSMGAttributes : SMGAttributes {
	companion object : ChargedSMGAttributes
	
	/**
	 * In-Game: "Secondary fire when charged grants mini-crits for N seconds."
	 *
	 * 
	 *
	 * Minicrit buff duration
	 */
	context(attrs: IKeyValueMap)
	var minicritBoostWhenCharged: Int?
		get() = attrs.getTyped("minicrit_boost_when_charged")
		set(value) = attrs.setNullable("minicrit_boost_when_charged", value)
}

inline operator fun ChargedSMGAttributes.invoke(scope: ChargedSMGAttributes.() -> Unit) {
	this.apply(scope)
}

