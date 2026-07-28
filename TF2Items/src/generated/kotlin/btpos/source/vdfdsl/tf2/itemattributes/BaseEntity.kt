package btpos.source.vdfdsl.tf2.itemattributes

import btpos.source.vdfdsl.modeling.*
import btpos.source.vdfdsl.serialization.codecs.*
import btpos.source.vdfdsl.tf2.itemattributes.impl.*
import btpos.source.vdfdsl.tf2.tftypes.*
import java.util.*




interface BaseEntityAttributes : IBlockScoped {
	companion object {
		/**
		 * 
		 *
		 * If true, this item will get kill assist credit in the killfeed.
		 */
		val countsAsAssisterIsSomeKindOfPetThisUpdateIsGoingToBeAwesome = ItemAttributeNamed<Boolean>("counts as assister is some kind of pet this update is going to be awesome")
		
		/**
		 * Bonus:
		 *
		 * 	- In-Game: "N% splash damage fall off"
		 *
		 * 
		 *
		 * Penalty:
		 *
		 * 
		 */
		val dmgFalloff = BonusPenalty(
			ItemAttributeNamed<Float>("dmg falloff decreased"),
			ItemAttributeNamed<Float>("dmg falloff increased")
		)
		
		/**
		 * In-Game: "Spawning and resupply do not affect the Gas meter"
		 *
		 * 
		 *
		 * If true, resupply cabinets and spawning do not fully recharge the meter for this item.  Instead, its "default charge meter value" is used.
		 */
		val itemMeterResupplyDenied = ItemAttributeNamed<Boolean>("item_meter_resupply_denied")
		
		/**
		 * 
		 *
		 * If `TIME` or `COMBO`, checks the `mult_item_meter_charge_rate` attribute for passive recharge rate mult.
		 *
		 * If `DAMAGE` or `COMBO`, checks the `item_meter_damage_for_full_charge` and `mult_item_meter_charge_rate` attribute classes.
		 */
		val itemMeterChargeType = ItemAttributeNamed<TFMeterRechargeType>("item_meter_charge_type")
		
		/**
		 * 
		 *
		 * Amount of meter required to fully charge the item.
		 *
		 * If negative, 0, or not set, does not attempt to fill the meter at all when dealing damage.
		 */
		val itemMeterDamageForFullCharge = ItemAttributeNamed<Float>("item_meter_damage_for_full_charge")
		
		/**
		 * In-Game: "N% faster recharge rate"
		 *
		 * 
		 *
		 * Scale factor for meter gained per second and/or meter gained on dealing damage.
		 */
		val multItemMeterChargeRate = ItemAttributeNamed<Float>("mult_item_meter_charge_rate")
		
		/**
		 * In-Game: "Immune to push force from damage and airblast when spun up"
		 *
		 * 
		 *
		 * Only procs if Heavy and has a spun up minigun.
		 */
		val spunupPushForceImmunity = ItemAttributeNamed<Boolean>("spunup_push_force_immunity")
		
		/**
		 * In-Game: "Normal disguises require (and consume) a full cloak meter"
		 *
		 * 
		 *
		 * If true, disguising requires and consumes an entire cloak meter.
		 */
		val disguiseConsumesCloak = ItemAttributeNamed<Boolean>("mod_disguise_consumes_cloak")
		
		/**
		 * In-Game: "Blocks a single backstab attempt"
		 *
		 * 
		 *
		 * If on a Wearable: the item is "broken", it is given `nodraw`, and the player's secondary weapon's meter is reset.
		 *
		 * If on a weapon, reduces all backstab damage taken by the player for all backstabs without any cooldown. Performs identically to the Mannpower "Resistance" powerup in this respect.
		 */
		val backstabShield = ItemAttributeNamed<Boolean>("backstab shield")
	}

	/**
	 * 
	 *
	 * If true, this item will get kill assist credit in the killfeed.
	 */
	val countsAsAssisterIsSomeKindOfPetThisUpdateIsGoingToBeAwesome: ItemAttribute<Boolean> get() = BaseEntityAttributes.countsAsAssisterIsSomeKindOfPetThisUpdateIsGoingToBeAwesome
	
	/**
	 * Bonus:
	 *
	 * 	- In-Game: "N% splash damage fall off"
	 *
	 * 
	 *
	 * Penalty:
	 *
	 * 
	 */
	val dmgFalloff: ItemAttribute<Float> get() = BaseEntityAttributes.dmgFalloff
	
	/**
	 * In-Game: "Spawning and resupply do not affect the Gas meter"
	 *
	 * 
	 *
	 * If true, resupply cabinets and spawning do not fully recharge the meter for this item.  Instead, its "default charge meter value" is used.
	 */
	val itemMeterResupplyDenied: ItemAttribute<Boolean> get() = BaseEntityAttributes.itemMeterResupplyDenied
	
	/**
	 * 
	 *
	 * If `TIME` or `COMBO`, checks the `mult_item_meter_charge_rate` attribute for passive recharge rate mult.
	 *
	 * If `DAMAGE` or `COMBO`, checks the `item_meter_damage_for_full_charge` and `mult_item_meter_charge_rate` attribute classes.
	 */
	val itemMeterChargeType: ItemAttribute<TFMeterRechargeType> get() = BaseEntityAttributes.itemMeterChargeType
	
	/**
	 * 
	 *
	 * Amount of meter required to fully charge the item.
	 *
	 * If negative, 0, or not set, does not attempt to fill the meter at all when dealing damage.
	 */
	val itemMeterDamageForFullCharge: ItemAttribute<Float> get() = BaseEntityAttributes.itemMeterDamageForFullCharge
	
	/**
	 * In-Game: "N% faster recharge rate"
	 *
	 * 
	 *
	 * Scale factor for meter gained per second and/or meter gained on dealing damage.
	 */
	val multItemMeterChargeRate: ItemAttribute<Float> get() = BaseEntityAttributes.multItemMeterChargeRate
	
	/**
	 * In-Game: "Immune to push force from damage and airblast when spun up"
	 *
	 * 
	 *
	 * Only procs if Heavy and has a spun up minigun.
	 */
	val spunupPushForceImmunity: ItemAttribute<Boolean> get() = BaseEntityAttributes.spunupPushForceImmunity
	
	/**
	 * In-Game: "Normal disguises require (and consume) a full cloak meter"
	 *
	 * 
	 *
	 * If true, disguising requires and consumes an entire cloak meter.
	 */
	val disguiseConsumesCloak: ItemAttribute<Boolean> get() = BaseEntityAttributes.disguiseConsumesCloak
	
	/**
	 * In-Game: "Blocks a single backstab attempt"
	 *
	 * 
	 *
	 * If on a Wearable: the item is "broken", it is given `nodraw`, and the player's secondary weapon's meter is reset.
	 *
	 * If on a weapon, reduces all backstab damage taken by the player for all backstabs without any cooldown. Performs identically to the Mannpower "Resistance" powerup in this respect.
	 */
	val backstabShield: ItemAttribute<Boolean> get() = BaseEntityAttributes.backstabShield

   
}

