package btpos.tf2.popfiledsl.tf2.itemattributes

import btpos.tf2.popfiledsl.modeling.*
import btpos.tf2.popfiledsl.serialization.codecs.*



interface WearableAttributes {
	companion object : WearableAttributes
	
	
}

inline operator fun WearableAttributes.invoke(scope: WearableAttributes.() -> Unit) {
	this.apply(scope)
}

