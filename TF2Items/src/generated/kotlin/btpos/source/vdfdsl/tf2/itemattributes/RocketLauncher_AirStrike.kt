package btpos.source.vdfdsl.tf2.itemattributes

import btpos.source.vdfdsl.tf2.itemattributes.impl.IBlockScoped


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
	context(attrs: btpos.source.vdfdsl.modeling.IKeyValueMap)
	override var clipsizeIncreaseOnKill: Int?
		get() = super.clipsizeIncreaseOnKill
		set(value) {
			super.clipsizeIncreaseOnKill = value
		}
}

