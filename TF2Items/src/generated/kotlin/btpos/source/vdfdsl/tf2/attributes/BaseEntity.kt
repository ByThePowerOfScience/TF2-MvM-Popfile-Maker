package btpos.source.vdfdsl.tf2.attributes

import btpos.source.vdfdsl.modeling.*
import btpos.source.vdfdsl.serialization.codecs.*
import btpos.source.vdfdsl.tf2.attributes.impl.*
import java.util.*


interface BaseEntityAttributes : PlayerAttributes, IBlockScoped {
	companion object : BaseEntityAttributes
	
	/**
	 * 
	 *
	 * If true, this item will get kill assist credit in the killfeed.
	 */
	context(attrs: IKeyValueMap)
	var countsAsAssisterIsSomeKindOfPetThisUpdateIsGoingToBeAwesome: Boolean?
		get() = attrs.getTyped("counts as assister is some kind of pet this update is going to be awesome", BinaryIntCodec)
		set(value) = attrs.setNullable("counts as assister is some kind of pet this update is going to be awesome", value, BinaryIntCodec)
	
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
	val dmgFalloff get() = BonusPenalty<Float, Float>("dmg falloff decreased", "dmg falloff increased")
	
	/**
	 * In-Game: "Spawning and resupply do not affect the Gas meter"
	 *
	 * 
	 *
	 * If true, resupply cabinets and spawning do not fully recharge the meter for this item.  Instead, its "default charge meter value" is used.
	 */
	context(attrs: IKeyValueMap)
	var itemMeterResupplyDenied: Boolean?
		get() = attrs.getTyped("item_meter_resupply_denied", BinaryIntCodec)
		set(value) = attrs.setNullable("item_meter_resupply_denied", value, BinaryIntCodec)
	
	/**
	 * 
	 *
	 * If `mult_item_meter_charge_rate` is set, checks this attribute to see what type of meter should be modified, and also only allows it to activate if the active weapon is not a TF_WEAPON_FLAME_BALL.
	 *
	 * If [TIME][AttributeMeterType.TIME] or [AttributeMeterType.COMBO], checks the `mult_item_meter_charge_rate` attribute class for passive recharge rate mult.
	 *
	 * If [DAMAGE][AttributeMeterType.DAMAGE] or [COMBO][AttributeMeterType.COMBO], checks the `item_meter_damage_for_full_charge` and `mult_item_meter_charge_rate` attribute classes.
	 */
	context(attrs: IKeyValueMap)
	override var itemMeterChargeType: Int?
		get() = super.itemMeterChargeType
		set(value) { super.itemMeterChargeType = value }
	
	/**
	 * 
	 *
	 * Amount of meter required to fully charge the item.
	 *
	 * If negative, 0, or not set, does not attempt to fill the meter at all when dealing damage.
	 */
	context(attrs: IKeyValueMap)
	var itemMeterDamageForFullCharge: Int?
		get() = attrs.getTyped("item_meter_damage_for_full_charge")
		set(value) = attrs.setNullable("item_meter_damage_for_full_charge", value)
	
	/**
	 * In-Game: "N% faster recharge rate"
	 *
	 * 
	 *
	 * Scale factor for meter gained per second and/or meter gained on dealing damage.
	 */
	context(attrs: IKeyValueMap)
	var multItemMeterChargeRate: Float?
		get() = attrs.getTyped("mult_item_meter_charge_rate")
		set(value) = attrs.setNullable("mult_item_meter_charge_rate", value)
	
	/**
	 * In-Game: "Immune to push force from damage and airblast when spun up"
	 *
	 * 
	 *
	 * Only procs if Heavy and has a spun up minigun.
	 */
	context(attrs: IKeyValueMap)
	var spunupPushForceImmunity: Boolean?
		get() = attrs.getTyped("spunup_push_force_immunity", BinaryIntCodec)
		set(value) = attrs.setNullable("spunup_push_force_immunity", value, BinaryIntCodec)
	
	/**
	 * In-Game: "Normal disguises require (and consume) a full cloak meter"
	 *
	 * 
	 *
	 * If true, disguising requires and consumes an entire cloak meter.
	 */
	context(attrs: IKeyValueMap)
	var disguiseConsumesCloak: Boolean?
		get() = attrs.getTyped("mod_disguise_consumes_cloak", BinaryIntCodec)
		set(value) = attrs.setNullable("mod_disguise_consumes_cloak", value, BinaryIntCodec)
	
	/**
	 * In-Game: "Blocks a single backstab attempt"
	 *
	 * 
	 *
	 * If on a Wearable: the item is "broken", it is given `nodraw`, and the player's secondary weapon's meter is reset.
	 *
	 * If on a weapon, reduces all backstab damage taken by the player for all backstabs without any cooldown.  Performs identically to the Mannpower "Resistance" powerup in this respect.
	 */
	context(attrs: IKeyValueMap)
	var backstabShield: Boolean?
		get() = attrs.getTyped("backstab shield", BinaryIntCodec)
		set(value) = attrs.setNullable("backstab shield", value, BinaryIntCodec)
}

