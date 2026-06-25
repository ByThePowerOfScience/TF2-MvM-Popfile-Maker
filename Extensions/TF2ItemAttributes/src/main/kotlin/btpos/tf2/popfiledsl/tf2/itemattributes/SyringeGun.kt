package btpos.tf2.popfiledsl.tf2.itemattributes

import btpos.tf2.popfiledsl.modeling.*
import btpos.tf2.popfiledsl.serialization.codecs.*


/**
 * Items: Stock Syringe Gun, The Blutsauger, The Overdose
 * 
 */
abstract class SyringeGunAttributes : BaseGunAttributes() {
	companion object : SyringeGunAttributes() {
		operator fun invoke(scope: SyringeGunAttributes.Companion.() -> Unit) {
			this.apply(scope)
		}
	}
	
	
}

