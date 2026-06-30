package btpos.tf2.popfiledsl.tf2.itemattributes

import btpos.tf2.popfiledsl.modeling.*
import btpos.tf2.popfiledsl.serialization.codecs.*


/**
 * Items: Stock Shotgun, Reserve Shooter, The Frontier Justice, Festive Frontier Justice, The Widowmaker, The Rescue Ranger
 */
interface ShotgunAttributes : BaseGunAttributes {
	companion object : ShotgunAttributes
	
	
}

inline operator fun ShotgunAttributes.invoke(scope: ShotgunAttributes.() -> Unit) {
	this.apply(scope)
}

