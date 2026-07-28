package btpos.source.vdfdsl.tf2.itemattributes

import btpos.source.vdfdsl.modeling.*
import btpos.source.vdfdsl.serialization.codecs.*
import btpos.source.vdfdsl.tf2.itemattributes.impl.*
import btpos.source.vdfdsl.tf2.tftypes.*
import java.util.*



/**
 * Items: Cosmetics, The Manntreads, The Gunboats, The Razorback, Darwin's Danger Shield, The Cozy Camper, Ali Baba's Wee Booties, The Bootlegger
 */
interface WearableAttributes : IBlockScoped {
	companion object {
		/**
		 * In-Game: "Immune to the effects of afterburn."
		 *
		 * 
		 *
		 * For the base "`Wearable`", only checked on Sniper.
		 */
		val afterburnImmunity = ItemAttributeNamed<Boolean>("afterburn immunity")
		
		/**
		 * In-Game: "Duck Power : N / 5"
		 *
		 * 
		 *
		 * Determines if ***BONUS DUCKSSSS*** should increment the badge level.
		 */
		val duckBadgeLevel = ItemAttributeNamed<Int>("duck badge level")
		
		/**
		 * 
		 *
		 * Overrides the skin used for the player. (e.g. Zombie).
		 */
		val playerSkinOverride = ItemAttributeNamed<Int>("player skin override")
	}

	/**
	 * In-Game: "Immune to the effects of afterburn."
	 *
	 * 
	 *
	 * For the base "`Wearable`", only checked on Sniper.
	 */
	val afterburnImmunity: ItemAttribute<Boolean> get() = WearableAttributes.afterburnImmunity
	
	/**
	 * In-Game: "Duck Power : N / 5"
	 *
	 * 
	 *
	 * Determines if ***BONUS DUCKSSSS*** should increment the badge level.
	 */
	val duckBadgeLevel: ItemAttribute<Int> get() = WearableAttributes.duckBadgeLevel
	
	/**
	 * 
	 *
	 * Overrides the skin used for the player. (e.g. Zombie).
	 */
	val playerSkinOverride: ItemAttribute<Int> get() = WearableAttributes.playerSkinOverride

   
}

