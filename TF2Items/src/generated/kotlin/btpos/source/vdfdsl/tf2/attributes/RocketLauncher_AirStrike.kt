package btpos.source.vdfdsl.tf2.attributes

import btpos.source.vdfdsl.modeling.*
import btpos.source.vdfdsl.serialization.codecs.*
import btpos.source.vdfdsl.tf2.attributes.impl.*
import java.util.*

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

