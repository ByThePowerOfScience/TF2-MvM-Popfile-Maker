package btpos.source.vdfdsl.tf2.itemattributes

import btpos.source.vdfdsl.serialization.codecs.NumberSelectorCodec
import btpos.source.vdfdsl.tf2.itemattributes.impl.IBlockScoped


/**
 * Items: TF_WEAPON_BAT, Upgradeable TF_WEAPON_BAT, The Candy Cane, The Boston Basher, Sun-on-a-Stick, The Fan O'War, The Atomizer, Three-Rune Blade, Festive Bat 2011, Batsaber, The Sandman (tf_weapon_bat_wood), The Holy Mackerel, Unarmed Combat, Festive Holy Mackerel (tf_weapon_bat_fish)
 */
interface BatAttributes : BaseMeleeAttributes, IBlockScoped {
	companion object : BatAttributes
	
	/**
	 * In-Game: "Alt-Fire: Launches a ball that slows opponents"
	 *
	 * 
	 *
	 * If 0, cannot create a ball.
	 */
	context(attrs: btpos.source.vdfdsl.modeling.IKeyValueMap)
	var batLaunchesBalls: Boolean?
		get() = attrs.getTyped("mod bat launches balls", NumberSelectorCodec(1))
		set(value) = attrs.setNullable("mod bat launches balls", value, NumberSelectorCodec(1))
	
	/**
	 * In-Game: "Alt-Fire: Launches a festive ornament that shatters causing bleed"
	 *
	 * 
	 *
	 * If 0, cannot create a ball.
	 */
	context(attrs: btpos.source.vdfdsl.modeling.IKeyValueMap)
	var batLaunchesOrnaments: Boolean?
		get() = attrs.getTyped("mod bat launches ornaments", NumberSelectorCodec(2))
		set(value) = attrs.setNullable("mod bat launches ornaments", value, NumberSelectorCodec(2))
}

