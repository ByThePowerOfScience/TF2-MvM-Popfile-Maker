package btpos.source.vdfdsl.tf2.itemattributes

import btpos.source.vdfdsl.modeling.*
import btpos.source.vdfdsl.serialization.codecs.*
import btpos.source.vdfdsl.tf2.itemattributes.impl.*
import btpos.source.vdfdsl.tf2.tftypes.*
import java.util.*



/**
 * Items: TF_WEAPON_INVIS, The Dead Ringer, The Cloak and Dagger, Upgradeable TF_WEAPON_INVIS, The Quackenbirdt, The Enthusiast's Timepiece
 */
interface InvisAttributes : IBlockScoped {
	companion object {
		/**
		 * In-Game: "Cloak Type: Feign Death. Leave a fake corpse on taking damage and temporarily gain invisibility, speed, and damage resistance."
		 *
		 * 
		 *
		 * Used to specify "invis type".
		 */
		val setCloakIsFeignDeath = ItemAttributeNamed<Boolean>("set cloak is feign death", NumberSelectorCodec(2))
		
		/**
		 * In-Game: "Cloak Type: Motion Sensitive. Alt-fire: Turn invisible. Cannot attack while invisible. Bumping in to enemies will make you slightly visible to enemies. Cloak drain rate based on movement speed."
		 *
		 * 
		 *
		 * Used to specify "invis type".
		 */
		val setCloakIsMovementBased = ItemAttributeNamed<Boolean>("set cloak is movement based", NumberSelectorCodec(1))
		
		/**
		 * 
		 *
		 * How many seconds it takes to decloak.
		 *
		 * Note that values less than or equal to `0.0` become `1.0`.
		 */
		val multDecloakRate = ItemAttributeNamed<Float>("mult decloak rate")
		
		/**
		 * Bonus:
		 *
		 * 	- In-Game: "+N% cloak duration"
		 *
		 * 
		 *
		 * Penalty:
		 *
		 * 	- In-Game: "+N% cloak drain rate"
		 *
		 * 
		 *
		 * Multiply cloak consumption rate by this value.
		 *
		 * Checked on player.
		 */
		val multCloakMeterConsumeRate = BonusPenalty(
			ItemAttributeNamed<Float>("cloak consume rate decreased"),
			ItemAttributeNamed<Float>("mult cloak meter consume rate")
		)
		
		/**
		 * Bonus:
		 *
		 * 	- In-Game: "+N% cloak regen rate"
		 *
		 * 
		 *
		 * Penalty:
		 *
		 * 	- In-Game: "N% cloak regeneration rate"
		 *
		 * 
		 */
		val cloakRegenRate = BonusPenalty(
			ItemAttributeNamed<Float>("mult cloak meter regen rate"),
			ItemAttributeNamed<Float>("cloak regen rate decreased")
		)
		
		/**
		 * 
		 *
		 * Disallows ammo boxes from affecting the cloak meter.
		 */
		val cloakNoRegenFromItems = ItemAttributeNamed<Boolean>("mod_cloak_no_regen_from_items")
		
		/**
		 * In-Game: "No cloak meter from ammo boxes when invisible"
		 *
		 * 
		 *
		 * If true, cannot receive cloak while cloaked.
		 */
		val noCloakWhenCloaked = ItemAttributeNamed<Boolean>("NoCloakWhenCloaked")
		
		/**
		 * In-Game: "N% cloak meter from ammo boxes"
		 *
		 * 
		 *
		 * Multiplier applied to cloak gained from ammo boxes.
		 */
		val reducedCloakFromAmmo = ItemAttributeNamed<Float>("ReducedCloakFromAmmo")
	}

	/**
	 * In-Game: "Cloak Type: Feign Death. Leave a fake corpse on taking damage and temporarily gain invisibility, speed, and damage resistance."
	 *
	 * 
	 *
	 * Used to specify "invis type".
	 */
	val setCloakIsFeignDeath: ItemAttribute<Boolean> get() = InvisAttributes.setCloakIsFeignDeath
	
	/**
	 * In-Game: "Cloak Type: Motion Sensitive. Alt-fire: Turn invisible. Cannot attack while invisible. Bumping in to enemies will make you slightly visible to enemies. Cloak drain rate based on movement speed."
	 *
	 * 
	 *
	 * Used to specify "invis type".
	 */
	val setCloakIsMovementBased: ItemAttribute<Boolean> get() = InvisAttributes.setCloakIsMovementBased
	
	/**
	 * 
	 *
	 * How many seconds it takes to decloak.
	 *
	 * Note that values less than or equal to `0.0` become `1.0`.
	 */
	val multDecloakRate: ItemAttribute<Float> get() = InvisAttributes.multDecloakRate
	
	/**
	 * Bonus:
	 *
	 * 	- In-Game: "+N% cloak duration"
	 *
	 * 
	 *
	 * Penalty:
	 *
	 * 	- In-Game: "+N% cloak drain rate"
	 *
	 * 
	 *
	 * Multiply cloak consumption rate by this value.
	 *
	 * Checked on player.
	 */
	val multCloakMeterConsumeRate: ItemAttribute<Float> get() = InvisAttributes.multCloakMeterConsumeRate
	
	/**
	 * Bonus:
	 *
	 * 	- In-Game: "+N% cloak regen rate"
	 *
	 * 
	 *
	 * Penalty:
	 *
	 * 	- In-Game: "N% cloak regeneration rate"
	 *
	 * 
	 */
	val cloakRegenRate: ItemAttribute<Float> get() = InvisAttributes.cloakRegenRate
	
	/**
	 * 
	 *
	 * Disallows ammo boxes from affecting the cloak meter.
	 */
	val cloakNoRegenFromItems: ItemAttribute<Boolean> get() = InvisAttributes.cloakNoRegenFromItems
	
	/**
	 * In-Game: "No cloak meter from ammo boxes when invisible"
	 *
	 * 
	 *
	 * If true, cannot receive cloak while cloaked.
	 */
	val noCloakWhenCloaked: ItemAttribute<Boolean> get() = InvisAttributes.noCloakWhenCloaked
	
	/**
	 * In-Game: "N% cloak meter from ammo boxes"
	 *
	 * 
	 *
	 * Multiplier applied to cloak gained from ammo boxes.
	 */
	val reducedCloakFromAmmo: ItemAttribute<Float> get() = InvisAttributes.reducedCloakFromAmmo

   
}

