package btpos.source.vdfdsl.tf2.itemattributes

import btpos.source.vdfdsl.modeling.*
import btpos.source.vdfdsl.serialization.codecs.*


/**
 * Items: Stock Shotgun, Reserve Shooter, The Frontier Justice, Festive Frontier Justice, The Widowmaker, The Rescue Ranger
 */
interface ShotgunAttributes : btpos.source.vdfdsl.tf2.itemattributes.BaseGunAttributes, btpos.source.vdfdsl.tf2.itemattributes.IBlockScoped {
	companion object : ShotgunAttributes
	
	
}

