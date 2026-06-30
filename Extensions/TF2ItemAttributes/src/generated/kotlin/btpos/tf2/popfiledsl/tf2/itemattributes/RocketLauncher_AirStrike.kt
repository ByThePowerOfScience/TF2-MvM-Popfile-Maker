package btpos.tf2.popfiledsl.tf2.itemattributes

import btpos.tf2.popfiledsl.modeling.*
import btpos.tf2.popfiledsl.serialization.codecs.*


/**
 * Items: The Air Strike
 */
interface RocketLauncher_AirStrikeAttributes : RocketLauncherAttributes {
	companion object : RocketLauncher_AirStrikeAttributes
	
	/**
	 * In-Game: "Clip size increased on kill"
	 *
	 * 
	 *
	 * This attribute is on all weapons, but it's specifically checked for here as well.
	 */
	override context(attrs: IKeyValueMap)
	var clipsizeIncreaseOnKill: Int?
		get() = attrs.getTyped("clipsize increase on kill")
		set(value) = attrs.setNullable("clipsize increase on kill", value)
}

inline operator fun RocketLauncher_AirStrikeAttributes.invoke(scope: RocketLauncher_AirStrikeAttributes.() -> Unit) {
	this.apply(scope)
}

