package btpos.tf2.popfiledsl.tf2.itemattributes

import btpos.tf2.popfiledsl.modeling.*
import btpos.tf2.popfiledsl.serialization.codecs.*


/**
 * Items: TF_WEAPON_BAT, Upgradeable TF_WEAPON_BAT, The Candy Cane, The Boston Basher, Sun-on-a-Stick, The Fan O'War, The Atomizer, Three-Rune Blade, Festive Bat 2011, Batsaber, The Sandman (tf_weapon_bat_wood), The Holy Mackerel, Unarmed Combat, Festive Holy Mackerel (tf_weapon_bat_fish)
 * 
 */
abstract class BatAttributes : BaseMeleeAttributes() {
	companion object : BatAttributes() {
		operator fun invoke(scope: BatAttributes.Companion.() -> Unit) {
			this.apply(scope)
		}
	}
	
	
}

