package btpos.tf2.popfiledsl.tf2.itemattributes

import btpos.tf2.popfiledsl.modeling.*
import btpos.tf2.popfiledsl.serialization.codecs.*


/**
 * Items: TF_WEAPON_REVOLVER, The Ambassador, TTG Sam Revolver, Upgradeable TF_WEAPON_REVOLVER, L'Etranger, The Enforcer, The Diamondback, Festive Ambassador, Festive Revolver 2014
 * 
 */
abstract class RevolverAttributes : BaseGunAttributes() {
	companion object : RevolverAttributes() {
		operator fun invoke(scope: RevolverAttributes.Companion.() -> Unit) {
			this.apply(scope)
		}
	}
	
	
}

