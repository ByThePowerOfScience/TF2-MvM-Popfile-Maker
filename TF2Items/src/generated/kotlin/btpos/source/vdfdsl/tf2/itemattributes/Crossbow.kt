package btpos.source.vdfdsl.tf2.itemattributes

import btpos.source.vdfdsl.modeling.*
import btpos.source.vdfdsl.serialization.codecs.*
import btpos.source.vdfdsl.tf2.itemattributes.impl.*
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
	override var reloadTimeIncreasedHidden: Number?
		get() = super.reloadTimeIncreasedHidden
		set(value) { super.reloadTimeIncreasedHidden = value }
	
	/**
	 * In-Game: "+N% faster reload time"
	 *
	 * 
	 *
	 * Used if the gun draws directly from the ammo supply without using a clip.
	 */
	context(attrs: IKeyValueMap)
	override var fasterReloadRate: Number?
		get() = super.fasterReloadRate
		set(value) { super.fasterReloadRate = value }
}

