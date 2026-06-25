package btpos.tf2.popfiledsl.tf2.itemattributes

import btpos.tf2.popfiledsl.modeling.*
import btpos.tf2.popfiledsl.serialization.codecs.*


/**
 * Items: The Sandvich, The Dalokohs Bar, The Buffalo Steak Sandvich, Fishcake, The Robo-Sandvich, Festive Sandvich, The Second Banana, Bonk! Atomic Punch, Crit-a-Cola, Festive Bonk 2014
 * 
 */
abstract class LunchboxAttributes : WeaponBaseAttributes() {
	companion object : LunchboxAttributes() {
		operator fun invoke(scope: LunchboxAttributes.Companion.() -> Unit) {
			this.apply(scope)
		}
	}
	
	/**
	 * Value type: percentage
	 * 
	 */
	context(attrs: IKeyValueMap)
	var lunchboxHealingDecreased: Float?
		get() = attrs.getTyped("lunchbox healing decreased")
		set(value) = attrs.setNullable("lunchbox healing decreased", value)
}

