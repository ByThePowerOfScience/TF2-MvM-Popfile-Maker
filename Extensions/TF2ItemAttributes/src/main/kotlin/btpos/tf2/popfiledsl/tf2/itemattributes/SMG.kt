package btpos.tf2.popfiledsl.tf2.itemattributes

import btpos.tf2.popfiledsl.modeling.*
import btpos.tf2.popfiledsl.serialization.codecs.*


/**
 * Items: Stock SMG + Reskins
 * 
 */
abstract class SMGAttributes : BaseGunAttributes() {
	companion object : SMGAttributes() {
		operator fun invoke(scope: SMGAttributes.Companion.() -> Unit) {
			this.apply(scope)
		}
	}
	
	
}

