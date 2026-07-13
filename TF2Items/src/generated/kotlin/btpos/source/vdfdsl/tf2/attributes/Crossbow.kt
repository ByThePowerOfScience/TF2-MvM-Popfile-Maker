package btpos.source.vdfdsl.tf2.attributes

import btpos.source.vdfdsl.modeling.*
import btpos.source.vdfdsl.serialization.codecs.*
import btpos.source.vdfdsl.tf2.attributes.impl.*
import java.util.*

/**
 * Items: The Crusader's Crossbow, Festive Crusader's Crossbow
 */
interface CrossbowAttributes : RocketLauncherAttributes, IBlockScoped {
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

