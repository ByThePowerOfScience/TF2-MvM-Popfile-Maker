package btpos.source.vdfdsl.tf2.itemattributes

import btpos.source.vdfdsl.modeling.*
import btpos.source.vdfdsl.serialization.codecs.*
import btpos.source.vdfdsl.tf2.itemattributes.impl.*
import btpos.source.vdfdsl.tf2.tftypes.*
import java.util.*




interface WearableAttributes : BaseEntityAttributes {
	
	companion object {
		/**
		 * In-Game: "Immune to the effects of afterburn."
		 * 
		 * For the base "`Wearable`", only checked on Sniper.
		 */
		val afterburnImmunity: ItemAttributeNamed<Boolean> = ItemAttributeNamed("afterburn immunity")
	
		/**
		 * In-Game: "Duck Power : N / 5"
		 * 
		 * Determines if ***BONUS DUCKSSSS*** should increment the badge level.
		 */
		val duckBadgeLevel: ItemAttributeNamed<Int> = ItemAttributeNamed("duck badge level")
	
		/**
		 * Overrides the skin used for the player. (e.g. Zombie).
		 */
		val playerSkinOverride: ItemAttributeNamed<Int> = ItemAttributeNamed("player skin override")
	}

	/**
	 * In-Game: "Immune to the effects of afterburn."
	 * 
	 * For the base "`Wearable`", only checked on Sniper.
	 */
	val afterburnImmunity: ItemAttributeNamed<Boolean> get() = WearableAttributes.afterburnImmunity
	
	/**
	 * In-Game: "Duck Power : N / 5"
	 * 
	 * Determines if ***BONUS DUCKSSSS*** should increment the badge level.
	 */
	val duckBadgeLevel: ItemAttributeNamed<Int> get() = WearableAttributes.duckBadgeLevel
	
	/**
	 * Overrides the skin used for the player. (e.g. Zombie).
	 */
	val playerSkinOverride: ItemAttributeNamed<Int> get() = WearableAttributes.playerSkinOverride
}