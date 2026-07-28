package btpos.source.vdfdsl.tf2.itemattributes

import btpos.source.vdfdsl.modeling.*
import btpos.source.vdfdsl.serialization.codecs.*
import btpos.source.vdfdsl.tf2.itemattributes.impl.*
import btpos.source.vdfdsl.tf2.tftypes.*
import java.util.*



/**
 * Items: The Sandvich, The Dalokohs Bar, The Buffalo Steak Sandvich, Fishcake, The Robo-Sandvich, Festive Sandvich, The Second Banana, Bonk! Atomic Punch, Crit-a-Cola, Festive Bonk 2014
 */
interface LunchboxAttributes : IBlockScoped {
	companion object {
		/**
		 * In-Game: "Adds +50 max health for 30 seconds"
		 *
		 * 
		 *
		 * 0 = LUNCHBOX_STANDARD.
		 *
		 * Used for both the bonk atomic punch or the sandvich.
		 *
		 * Fun fact: LUNCHBOX_ADDS_AMMO is fully implemented.
		 */
		val lunchboxAddsMaxhealthBonus = ItemAttributeNamed<Boolean>("lunchbox adds maxhealth bonus", NumberSelectorCodec(1))
		
		/**
		 * In-Game: "Sets weapon mode #N"
		 *
		 * 
		 *
		 * 0 = LUNCHBOX_STANDARD.
		 *
		 * Used for both the bonk atomic punch or the sandvich.
		 *
		 * Fun fact: LUNCHBOX_ADDS_AMMO is fully implemented.
		 */
		val lunchboxAddsMinicrits = ItemAttributeNamed<Boolean>("lunchbox adds minicrits", NumberSelectorCodec(2))
		
		/**
		 * In-Game: "N% healing effect"
		 *
		 * 
		 */
		val lunchboxHealingDecreased = ItemAttributeNamed<Float>("lunchbox healing decreased")
	}

	/**
	 * In-Game: "Adds +50 max health for 30 seconds"
	 *
	 * 
	 *
	 * 0 = LUNCHBOX_STANDARD.
	 *
	 * Used for both the bonk atomic punch or the sandvich.
	 *
	 * Fun fact: LUNCHBOX_ADDS_AMMO is fully implemented.
	 */
	val lunchboxAddsMaxhealthBonus: ItemAttribute<Boolean> get() = LunchboxAttributes.lunchboxAddsMaxhealthBonus
	
	/**
	 * In-Game: "Sets weapon mode #N"
	 *
	 * 
	 *
	 * 0 = LUNCHBOX_STANDARD.
	 *
	 * Used for both the bonk atomic punch or the sandvich.
	 *
	 * Fun fact: LUNCHBOX_ADDS_AMMO is fully implemented.
	 */
	val lunchboxAddsMinicrits: ItemAttribute<Boolean> get() = LunchboxAttributes.lunchboxAddsMinicrits
	
	/**
	 * In-Game: "N% healing effect"
	 *
	 * 
	 */
	val lunchboxHealingDecreased: ItemAttribute<Float> get() = LunchboxAttributes.lunchboxHealingDecreased

   
}

