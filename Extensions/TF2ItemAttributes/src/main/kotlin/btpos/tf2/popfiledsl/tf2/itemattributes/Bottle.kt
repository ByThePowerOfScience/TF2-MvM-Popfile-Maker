package btpos.tf2.popfiledsl.tf2.itemattributes

import btpos.tf2.popfiledsl.modeling.*
import btpos.tf2.popfiledsl.serialization.codecs.*


/**
 * Items: TF_WEAPON_BOTTLE, Upgradeable TF_WEAPON_BOTTLE, The Scottish Handshake
 * 
 */
interface BottleAttributes : BaseMeleeAttributes {
	companion object : BottleAttributes
	
	
}

operator fun BottleAttributes.invoke(scope: BottleAttributes.() -> Unit) {
	this.apply(scope)
}

