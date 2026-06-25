package btpos.tf2.popfiledsl.tf2.itemattributes

import btpos.tf2.popfiledsl.modeling.*
import btpos.tf2.popfiledsl.serialization.codecs.*


/**
 * Items: Stock Shotgun, Reserve Shooter, The Frontier Justice, Festive Frontier Justice, The Widowmaker, The Rescue Ranger
 * 
 */
abstract class ShotgunAttributes : BaseGunAttributes() {
	companion object : ShotgunAttributes() {
		operator fun invoke(scope: ShotgunAttributes.Companion.() -> Unit) {
			this.apply(scope)
		}
	}
	
	
}

