package btpos.source.vdfdsl.tf2.itemattributes

import btpos.source.vdfdsl.modeling.*
import btpos.source.vdfdsl.serialization.*
import btpos.source.vdfdsl.serialization.codecs.*
import btpos.source.vdfdsl.tf2.itemattributes.impl.*
import btpos.source.vdfdsl.tf2.tftypes.*
import java.util.*
import kotlin.time.Duration

interface BaseEntityAttributes : IBlockScoped {
	companion object : IBlockScoped {
		/**
		 * Attributes related to disguising.
		 */
		val disguise: DisguiseAttributes = DisguiseAttributes()
	
		/**
		 * Attributes related to dealing or preventing critical hits and mini-crits.
		 */
		val crits: CritsAttributes = CritsAttributes()
	
		/**
		 * Multipliers governing the damage you deal to different targets.
		 * 
		 * For damage _taken_, see [resistance].
		 */
		val damage: DamageAttributes = DamageAttributes()
	
		/**
		 * Attributes related to the scoreboard, killfeed, HuD, item descriptions, and interactions with the wider game-state. (including capture rate)
		 */
		val meta: MetaAttributes = MetaAttributes()
	
		/**
		 * Attributes related to rage and items that recharge on a meter/timer.
		 */
		val meter: MeterAttributes = MeterAttributes()
	
		/**
		 * Attributes governing how much you are pushed when hit by different push sources.
		 */
		val knockbackReceived: KnockbackReceivedAttributes = KnockbackReceivedAttributes()
	
		/**
		 * Attributes governing how much damage the player takes from various sources.  Also includes the passive and active effects of the Vaccinator on the user.
		 * 
		 * For outgoing damage, see [damage].
		 */
		val resistance: ResistanceAttributes = ResistanceAttributes()
	}
	
	/**
	 * Attributes related to disguising.
	 */
	val disguise: DisguiseAttributes get() = BaseEntityAttributes.disguise
	
	/**
	 * Attributes related to dealing or preventing critical hits and mini-crits.
	 */
	val crits: CritsAttributes get() = BaseEntityAttributes.crits
	
	/**
	 * Multipliers governing the damage you deal to different targets.
	 * 
	 * For damage _taken_, see [resistance].
	 */
	val damage: DamageAttributes get() = BaseEntityAttributes.damage
	
	/**
	 * Attributes related to the scoreboard, killfeed, HuD, item descriptions, and interactions with the wider game-state. (including capture rate)
	 */
	val meta: MetaAttributes get() = BaseEntityAttributes.meta
	
	/**
	 * Attributes related to rage and items that recharge on a meter/timer.
	 */
	val meter: MeterAttributes get() = BaseEntityAttributes.meter
	
	/**
	 * Attributes governing how much you are pushed when hit by different push sources.
	 */
	val knockbackReceived: KnockbackReceivedAttributes get() = BaseEntityAttributes.knockbackReceived
	
	/**
	 * Attributes governing how much damage the player takes from various sources.  Also includes the passive and active effects of the Vaccinator on the user.
	 * 
	 * For outgoing damage, see [damage].
	 */
	val resistance: ResistanceAttributes get() = BaseEntityAttributes.resistance
	
	open class DisguiseAttributes : IBlockScoped {
		/**
		 * In-Game: "Normal disguises require (and consume) a full cloak meter"
		 */
		open val disguiseConsumesCloak: ItemAttributeNamed<Boolean> = ItemAttributeNamed("mod_disguise_consumes_cloak")
	}
	
	open class CritsAttributes : IBlockScoped 
	
	open class DamageAttributes : IBlockScoped 
	
	open class MetaAttributes : IBlockScoped {
		open val killfeed: KillfeedAttributes = KillfeedAttributes()
	
		open class KillfeedAttributes : IBlockScoped {
			/**
			 * If true, this item will get kill assist credit in the killfeed.
			 */
			open val countsAsAssister: ItemAttributeNamed<Boolean> = ItemAttributeNamed("counts as assister is some kind of pet this update is going to be awesome")
		}
	}
	
	open class MeterAttributes : IBlockScoped {
		/**
		 * In-Game: "Spawning and resupply do not affect the Gas meter"
		 * 
		 * If true, resupply cabinets and spawning do not fully recharge the meter for this item.  Instead, its "default charge meter value" is used.
		 */
		open val resupplyDenied: ItemAttributeNamed<Boolean> = ItemAttributeNamed("item_meter_resupply_denied")
	
		/**
		 * If `TIME` or `COMBO`, checks the `mult_item_meter_charge_rate` attribute for passive recharge rate mult.
		 * 
		 * If `DAMAGE` or `COMBO`, checks the `item_meter_damage_for_full_charge` and `mult_item_meter_charge_rate` attribute classes.
		 */
		open val chargeType: ItemAttributeNamed<TFMeterRechargeType> = ItemAttributeNamed("item_meter_charge_type")
	
		/**
		 * Amount of meter required to fully charge the item.
		 * 
		 * If negative, 0, or not set, does not attempt to fill the meter at all when dealing damage.
		 */
		open val damageForFullCharge: ItemAttributeNamed<Number> = ItemAttributeNamed("item_meter_damage_for_full_charge")
	
		/**
		 * In-Game: "N% faster recharge rate"
		 * 
		 * Scale factor for meter gained per second and/or meter gained on dealing damage.
		 */
		open val multChargeRate: ItemAttributeNamed<Number> = ItemAttributeNamed("mult_item_meter_charge_rate")
	}
	
	open class KnockbackReceivedAttributes : IBlockScoped {
		/**
		 * In-Game: "Immune to push force from damage and airblast when spun up"
		 * 
		 * Only procs if Heavy and has a spun up minigun.
		 */
		open val spunupPushForceImmunity: ItemAttributeNamed<Number> = ItemAttributeNamed("spunup_push_force_immunity")
	}
	
	open class ResistanceAttributes : IBlockScoped {
		/**
		 * In-Game: "Blocks a single backstab attempt"
		 * 
		 * If on a Wearable: the item is "broken", it is given `nodraw`, and the player's secondary weapon's meter is reset.
		 * 
		 * If on a weapon, reduces all backstab damage taken by the player for all backstabs without any cooldown. Performs identically to the Mannpower "Resistance" powerup in this respect.
		 */
		open val blocksBackstab: ItemAttributeNamed<Boolean> = ItemAttributeNamed("backstab shield")
	}
	
	object Inherited : BaseEntityAttributes 
}