package btpos.tf2.popfiledsl.tf2.itemattributes

import btpos.tf2.popfiledsl.modeling.*
import btpos.tf2.popfiledsl.serialization.codecs.*


/**
 * 
 */
abstract class WearableAttributes {
	companion object : WearableAttributes() {
		operator fun invoke(scope: WearableAttributes.Companion.() -> Unit) {
			this.apply(scope)
		}
	}
	
	
}

