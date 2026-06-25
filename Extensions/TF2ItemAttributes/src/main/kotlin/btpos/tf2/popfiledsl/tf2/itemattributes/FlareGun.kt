package btpos.tf2.popfiledsl.tf2.itemattributes

import btpos.tf2.popfiledsl.modeling.*
import btpos.tf2.popfiledsl.serialization.codecs.*


/**
 * Items: The Flare Gun, The Scorch Shot, The Detonator, The Manmelter
 * 
 */
abstract class FlareGunAttributes : BaseGunAttributes() {
	companion object : FlareGunAttributes() {
		operator fun invoke(scope: FlareGunAttributes.Companion.() -> Unit) {
			this.apply(scope)
		}
	}
	
	
}

