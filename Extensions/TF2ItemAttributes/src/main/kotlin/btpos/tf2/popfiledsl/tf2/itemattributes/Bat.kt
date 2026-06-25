package btpos.tf2.popfiledsl.tf2.itemattributes

import btpos.tf2.popfiledsl.modeling.*
import btpos.tf2.popfiledsl.serialization.codecs.*


/**
 * Items: TF_WEAPON_BAT, Upgradeable TF_WEAPON_BAT, The Candy Cane, The Boston Basher, Sun-on-a-Stick, The Fan O'War, The Atomizer, Three-Rune Blade, Festive Bat 2011, Batsaber, The Sandman (tf_weapon_bat_wood), The Holy Mackerel, Unarmed Combat, Festive Holy Mackerel (tf_weapon_bat_fish)
 * 
 */
interface BatAttributes : BaseMeleeAttributes {
	companion object : BatAttributes
	
	/**
	 * If 0, cannot create a ball
	 * 
	 */
	context(attrs: IKeyValueMap)
	var modBatLaunchesBalls: Boolean?
		get() = attrs.getTyped("mod bat launches balls", NumberSelectorCodec(1))
		set(value) = attrs.setNullable("mod bat launches balls", value, NumberSelectorCodec(1))
	
	/**
	 * If 0, cannot create a ball
	 * 
	 */
	context(attrs: IKeyValueMap)
	var modBatLaunchesOrnaments: Boolean?
		get() = attrs.getTyped("mod bat launches ornaments", NumberSelectorCodec(2))
		set(value) = attrs.setNullable("mod bat launches ornaments", value, NumberSelectorCodec(2))
}

operator fun BatAttributes.invoke(scope: BatAttributes.() -> Unit) {
	this.apply(scope)
}

