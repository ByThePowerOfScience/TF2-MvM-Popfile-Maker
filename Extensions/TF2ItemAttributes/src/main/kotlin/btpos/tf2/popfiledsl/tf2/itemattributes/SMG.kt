package btpos.tf2.popfiledsl.tf2.itemattributes

import btpos.tf2.popfiledsl.modeling.*
import btpos.tf2.popfiledsl.serialization.codecs.*


/**
 * Items: Stock SMG + Reskins
 * 
 */
interface SMGAttributes : BaseGunAttributes {
	companion object : SMGAttributes
	
	
}

inline operator fun SMGAttributes.invoke(scope: SMGAttributes.() -> Unit) {
	this.apply(scope)
}

