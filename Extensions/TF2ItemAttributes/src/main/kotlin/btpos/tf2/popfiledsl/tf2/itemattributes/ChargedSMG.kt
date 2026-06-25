package btpos.tf2.popfiledsl.tf2.itemattributes

import btpos.tf2.popfiledsl.modeling.*
import btpos.tf2.popfiledsl.serialization.codecs.*


/**
 * Items: The Cleaner's Carbine
 * 
 */
abstract class ChargedSMGAttributes : SMGAttributes() {
	companion object : ChargedSMGAttributes() {
		operator fun invoke(scope: ChargedSMGAttributes.Companion.() -> Unit) {
			this.apply(scope)
		}
	}
	
	/**
	 * Minicrit buff duration
	 */
	context(attrs: IKeyValueMap)
	var minicritBoostWhenCharged: Int?
		get() = attrs.getTyped("minicrit_boost_when_charged")
		set(value) = attrs.setNullable("minicrit_boost_when_charged", value)
}

