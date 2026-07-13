package btpos.source.vdfdsl.tf2.itemattributes

import btpos.source.vdfdsl.tf2.attributes.impl.IBlockScoped


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
	context(attrs: btpos.source.vdfdsl.modeling.IKeyValueMap)
	override var reloadTimeIncreasedHidden: Float?
		get() = super.reloadTimeIncreasedHidden
		set(value) {
			super.reloadTimeIncreasedHidden = value
		}
	
	/**
	 * In-Game: "+N% faster reload time"
	 *
	 * 
	 *
	 * This is what's used for weapons that draw directly from reserve ammo, like the flare gun and sniper rifle.
	 */
	context(attrs: btpos.source.vdfdsl.modeling.IKeyValueMap)
	override var fasterReloadRate: Float?
		get() = super.fasterReloadRate
		set(value) {
			super.fasterReloadRate = value
		}
}

