package btpos.tf2.popfiledsl.tf2.itemattributes

import btpos.tf2.popfiledsl.modeling.*
import btpos.tf2.popfiledsl.serialization.codecs.*


/**
 * Items: The Crusader's Crossbow, Festive Crusader's Crossbow
 * 
 */
abstract class CrossbowAttributes : RocketLauncherAttributes() {
	companion object : CrossbowAttributes() {
		operator fun invoke(scope: CrossbowAttributes.Companion.() -> Unit) {
			this.apply(scope)
		}
	}
	
	/**
	 * 
	 * Bonus:
	 * 	Value type: inverted_percentage
	 * 	
	 * 
	 * Penalty:
	 * 	Value type: percentage
	 * 	
	 * 
	 * 
	 * Bonus:
	 * 	Value type: inverted_percentage
	 * 	
	 * 
	 * Penalty:
	 * 	Value type: percentage
	 * 	
	 */
	override val ReloadTimeIncreased = BonusPenalty<Float, Float>("Reload time decreased", "Reload time increased")
	
	/**
	 * Value type: percentage
	 * 
	 * 
	 * Value type: percentage
	 * 
	 */
	override context(attrs: IKeyValueMap)
	var reloadTimeIncreasedHidden: Float?
		get() = attrs.getTyped("reload time increased hidden")
		set(value) = attrs.setNullable("reload time increased hidden", value)
	
	/**
	 * Value type: inverted_percentage
	 * 
	 * This is what's used for weapons that draw directly from reserve ammo, like the flare gun and sniper rifle.
	 * 
	 * Value type: inverted_percentage
	 * 
	 * Honestly I don't know why `fast_reload` is different if it's just going to use the standard reload time mults anyway...
	 */
	override context(attrs: IKeyValueMap)
	var fasterReloadRate: Float?
		get() = attrs.getTyped("faster reload rate")
		set(value) = attrs.setNullable("faster reload rate", value)
}

