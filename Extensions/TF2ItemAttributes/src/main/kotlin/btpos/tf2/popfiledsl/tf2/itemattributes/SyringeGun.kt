package btpos.tf2.popfiledsl.tf2.itemattributes

import btpos.tf2.popfiledsl.modeling.*
import btpos.tf2.popfiledsl.serialization.codecs.*


/**
 * Items: Stock Syringe Gun, The Blutsauger, The Overdose
 * 
 */
interface SyringeGunAttributes : BaseGunAttributes {
	companion object : SyringeGunAttributes
	
	
}

inline operator fun SyringeGunAttributes.invoke(scope: SyringeGunAttributes.() -> Unit) {
	this.apply(scope)
}

