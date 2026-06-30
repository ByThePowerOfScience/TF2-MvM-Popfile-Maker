package btpos.source.vdfdsl.tf2.itemattributes

import btpos.source.vdfdsl.modeling.*
import btpos.source.vdfdsl.serialization.codecs.*


/**
 * Items: The Sandvich, The Dalokohs Bar, The Buffalo Steak Sandvich, Fishcake, The Robo-Sandvich, Festive Sandvich, The Second Banana, Bonk! Atomic Punch, Crit-a-Cola, Festive Bonk 2014
 */
interface LunchboxAttributes : btpos.source.vdfdsl.tf2.itemattributes.WeaponBaseAttributes, btpos.source.vdfdsl.tf2.itemattributes.IBlockScoped {
	companion object : LunchboxAttributes
	
	/**
	 * In-Game: "Adds +50 max health for 30 seconds"
	 *
	 * 
	 *
	 * 0 = LUNCHBOX_STANDARD.
	 *
	 * 1 = LUNCHBOX_ADDS_MAXHEALTH.
	 *
	 * 2 = LUNCHBOX_ADDS_MINICRITS.
	 *
	 * 3 = LUNCHBOX_STANDARD_ROBO.
	 *
	 * 4 = LUNCHBOX_STANDARD_FESTIVE.
	 *
	 * 5 = LUNCHBOX_ADDS_AMMO (fully implemented).
	 *
	 * 6 = LUNCHBOX_BANANA.
	 *
	 * 7 = LUNCHBOX_FISHCAKE.
	 */
	context(attrs: btpos.source.vdfdsl.modeling.IKeyValueMap)
	var lunchboxAddsMaxhealthBonus: Boolean?
		get() = attrs.getTyped("lunchbox adds maxhealth bonus", _root_ide_package_.btpos.source.vdfdsl.serialization.codecs.NumberSelectorCodec(1))
		set(value) = attrs.setNullable("lunchbox adds maxhealth bonus", value, _root_ide_package_.btpos.source.vdfdsl.serialization.codecs.NumberSelectorCodec(1))
	
	/**
	 * In-Game: "Sets weapon mode #N"
	 *
	 * 
	 *
	 * 0 = LUNCHBOX_STANDARD.
	 *
	 * 1 = LUNCHBOX_ADDS_MAXHEALTH.
	 *
	 * 2 = LUNCHBOX_ADDS_MINICRITS.
	 *
	 * 3 = LUNCHBOX_STANDARD_ROBO.
	 *
	 * 4 = LUNCHBOX_STANDARD_FESTIVE.
	 *
	 * 5 = LUNCHBOX_ADDS_AMMO (fully implemented).
	 *
	 * 6 = LUNCHBOX_BANANA.
	 *
	 * 7 = LUNCHBOX_FISHCAKE.
	 */
	context(attrs: btpos.source.vdfdsl.modeling.IKeyValueMap)
	var lunchboxAddsMinicrits: Boolean?
		get() = attrs.getTyped("lunchbox adds minicrits", _root_ide_package_.btpos.source.vdfdsl.serialization.codecs.NumberSelectorCodec(2))
		set(value) = attrs.setNullable("lunchbox adds minicrits", value, _root_ide_package_.btpos.source.vdfdsl.serialization.codecs.NumberSelectorCodec(2))
	
	/**
	 * In-Game: "N% healing effect"
	 *
	 * 
	 */
	context(attrs: btpos.source.vdfdsl.modeling.IKeyValueMap)
	var lunchboxHealingDecreased: Float?
		get() = attrs.getTyped("lunchbox healing decreased")
		set(value) = attrs.setNullable("lunchbox healing decreased", value)
}

