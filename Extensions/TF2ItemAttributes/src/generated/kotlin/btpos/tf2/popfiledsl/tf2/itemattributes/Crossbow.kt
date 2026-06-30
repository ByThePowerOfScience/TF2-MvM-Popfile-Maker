package btpos.tf2.popfiledsl.tf2.itemattributes

import btpos.tf2.popfiledsl.modeling.*
import btpos.tf2.popfiledsl.serialization.codecs.*


/**
 * Items: The Crusader's Crossbow, Festive Crusader's Crossbow
 */
interface CrossbowAttributes : RocketLauncherAttributes {
	companion object : CrossbowAttributes
	
	/**
	 * Bonus:
	 *
	 * 	- In-Game: "N% faster reload time"
	 *
	 * 
	 *
	 * Penalty:
	 *
	 * 	- In-Game: "N% slower reload time"
	 *
	 * 
	 */
	override val reloadTime get() = super.reloadTime
	
	/**
	 * In-Game: "N% slower reload time"
	 *
	 * 
	 */
	context(attrs: IKeyValueMap)
	override var reloadTimeIncreasedHidden: Float?
		get() = super.reloadTimeIncreasedHidden
		set(value) { super.reloadTimeIncreasedHidden = value }
	
	/**
	 * In-Game: "+N% faster reload time"
	 *
	 * 
	 *
	 * This is what's used for weapons that draw directly from reserve ammo, like the flare gun and sniper rifle.
	 */
	context(attrs: IKeyValueMap)
	override var fasterReloadRate: Float?
		get() = super.fasterReloadRate
		set(value) { super.fasterReloadRate = value }
}

inline operator fun CrossbowAttributes.invoke(scope: CrossbowAttributes.() -> Unit) {
	this.apply(scope)
}

