package btpos.tf2.popfiledsl.tf2.itemattributes

import btpos.tf2.popfiledsl.modeling.*
import btpos.tf2.popfiledsl.serialization.codecs.*


/**
 * Items: TF_WEAPON_PISTOL, TF_WEAPON_PISTOL_SCOUT, TTG Max Pistol, Upgradeable TF_WEAPON_PISTOL, The C.A.P.P.E.R
 * 
 */
interface PistolAttributes : BaseGunAttributes {
	companion object : PistolAttributes
	
	
}

operator fun PistolAttributes.invoke(scope: PistolAttributes.() -> Unit) {
	this.apply(scope)
}

