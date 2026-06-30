package btpos.tf2.popfiledsl.tf2.itemattributes

import btpos.tf2.popfiledsl.modeling.*
import btpos.tf2.popfiledsl.serialization.codecs.*


/**
 * Items: The Air Strike
 */
interface RocketLauncher_AirStrikeAttributes : RocketLauncherAttributes, IBlockScoped {
	companion object : RocketLauncher_AirStrikeAttributes
	
	/**
	 * In-Game: "Clip size increased on kill"
	 *
	 * 
	 *
	 * This attribute is on all weapons, but it's specifically checked for here as well.
	 */
	context(attrs: IKeyValueMap)
	override var clipsizeIncreaseOnKill: Int?
		get() = super.clipsizeIncreaseOnKill
		set(value) { super.clipsizeIncreaseOnKill = value }
}

