package btpos.source.vdfdsl.tf2.itemattributes

import btpos.source.vdfdsl.modeling.*
import btpos.source.vdfdsl.serialization.codecs.*
import btpos.source.vdfdsl.tf2.itemattributes.impl.*
import java.util.*

/**
 * Items: Stock Shotgun, Reserve Shooter, The Frontier Justice, Festive Frontier Justice, The Widowmaker, The Rescue Ranger
 */
interface ShotgunAttributes : BaseGunAttributes, IBlockScoped {
	companion object : ShotgunAttributes
	
	
}

