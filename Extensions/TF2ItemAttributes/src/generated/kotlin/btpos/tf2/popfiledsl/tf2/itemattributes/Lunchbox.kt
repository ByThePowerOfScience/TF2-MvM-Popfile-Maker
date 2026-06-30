package btpos.tf2.popfiledsl.tf2.itemattributes

import btpos.tf2.popfiledsl.modeling.*
import btpos.tf2.popfiledsl.serialization.codecs.*


/**
 * Items: The Sandvich, The Dalokohs Bar, The Buffalo Steak Sandvich, Fishcake, The Robo-Sandvich, Festive Sandvich, The Second Banana, Bonk! Atomic Punch, Crit-a-Cola, Festive Bonk 2014
 */
interface LunchboxAttributes : WeaponBaseAttributes {
	companion object : LunchboxAttributes
	
	/**
	 * In-Game: "Adds +50 max health for 30 seconds"
	 *
	 * 
	 *
	 * 0 = LUNCHBOX_STANDARD
	 *
	 * Used for both the bonk atomic punch or the sandvich
	 *
	 * 1 = LUNCHBOX_ADDS_MAXHEALTH,
	 *
	 * 2 = LUNCHBOX_ADDS_MINICRITS,
	 *
	 * 3 = LUNCHBOX_STANDARD_ROBO,
	 *
	 * 4 = LUNCHBOX_STANDARD_FESTIVE,
	 *
	 * 5 = LUNCHBOX_ADDS_AMMO,
	 *
	 * Fun fact: LUNCHBOX_ADDS_AMMO is fully implemented
	 */
	context(attrs: IKeyValueMap)
	var lunchboxAddsMaxhealthBonus: Boolean?
		get() = attrs.getTyped("lunchbox adds maxhealth bonus", NumberSelectorCodec(1))
		set(value) = attrs.setNullable("lunchbox adds maxhealth bonus", value, NumberSelectorCodec(1))
	
	/**
	 * In-Game: "Sets weapon mode #N"
	 *
	 * 
	 *
	 * 0 = LUNCHBOX_STANDARD
	 *
	 * Used for both the bonk atomic punch or the sandvich
	 *
	 * 1 = LUNCHBOX_ADDS_MAXHEALTH,
	 *
	 * 2 = LUNCHBOX_ADDS_MINICRITS,
	 *
	 * 3 = LUNCHBOX_STANDARD_ROBO,
	 *
	 * 4 = LUNCHBOX_STANDARD_FESTIVE,
	 *
	 * 5 = LUNCHBOX_ADDS_AMMO,
	 *
	 * Fun fact: LUNCHBOX_ADDS_AMMO is fully implemented
	 */
	context(attrs: IKeyValueMap)
	var lunchboxAddsMinicrits: Boolean?
		get() = attrs.getTyped("lunchbox adds minicrits", NumberSelectorCodec(2))
		set(value) = attrs.setNullable("lunchbox adds minicrits", value, NumberSelectorCodec(2))
	
	/**
	 * In-Game: "N% healing effect"
	 *
	 * 
	 */
	context(attrs: IKeyValueMap)
	var lunchboxHealingDecreased: Float?
		get() = attrs.getTyped("lunchbox healing decreased")
		set(value) = attrs.setNullable("lunchbox healing decreased", value)
}

inline operator fun LunchboxAttributes.invoke(scope: LunchboxAttributes.() -> Unit) {
	this.apply(scope)
}

