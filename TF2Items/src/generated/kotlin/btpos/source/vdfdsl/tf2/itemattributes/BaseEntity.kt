package btpos.source.vdfdsl.tf2.itemattributes

import btpos.source.vdfdsl.modeling.*
import btpos.source.vdfdsl.serialization.codecs.*
import btpos.source.vdfdsl.tf2.itemattributes.impl.*
import btpos.source.vdfdsl.tf2.tftypes.*
import java.util.*
import kotlin.time.Duration

interface BaseEntityAttributes : IBlockScoped {
	companion object : IBlockScoped {
		val disguise: DisguiseAttributes = DisguiseAttributes()
	
		val crits: CritsAttributes = CritsAttributes()
	
		val damage: DamageAttributes = DamageAttributes()
	
		val meta: MetaAttributes = MetaAttributes()
	
		val meter: MeterAttributes = MeterAttributes()
	
		val knockbackReceived: KnockbackReceivedAttributes = KnockbackReceivedAttributes()
	
		val resistance: ResistanceAttributes = ResistanceAttributes()
	}

	val disguise: DisguiseAttributes get() = BaseEntityAttributes.disguise
	
	val crits: CritsAttributes get() = BaseEntityAttributes.crits
	
	val damage: DamageAttributes get() = BaseEntityAttributes.damage
	
	val meta: MetaAttributes get() = BaseEntityAttributes.meta
	
	val meter: MeterAttributes get() = BaseEntityAttributes.meter
	
	val knockbackReceived: KnockbackReceivedAttributes get() = BaseEntityAttributes.knockbackReceived
	
	val resistance: ResistanceAttributes get() = BaseEntityAttributes.resistance

	open class DisguiseAttributes : IBlockScoped {
		/**
		 * In-Game: "Normal disguises require (and consume) a full cloak meter"
		 */
		open val disguiseConsumesCloak: ItemAttributeNamed<Boolean> = ItemAttributeNamed("mod_disguise_consumes_cloak")
	}
	
	open class CritsAttributes : IBlockScoped 
	
	open class DamageAttributes : IBlockScoped {
		/**
		 * Bonus:
		 * 
		 * 	- In-Game: "N% splash damage fall off"
		 * 
		 * Penalty:
		 */
		open val multDmgFalloff: BonusPenalty<Number> = BonusPenalty(
			ItemAttributeNamed("dmg falloff decreased"),
			ItemAttributeNamed("dmg falloff increased"),
		)
	}
	
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
		open val itemMeterResupplyDenied: ItemAttributeNamed<Boolean> = ItemAttributeNamed("item_meter_resupply_denied")
	
		/**
		 * If `TIME` or `COMBO`, checks the `mult_item_meter_charge_rate` attribute for passive recharge rate mult.
		 * 
		 * If `DAMAGE` or `COMBO`, checks the `item_meter_damage_for_full_charge` and `mult_item_meter_charge_rate` attribute classes.
		 */
		open val itemMeterChargeType: ItemAttributeNamed<TFMeterRechargeType> = ItemAttributeNamed("item_meter_charge_type")
	
		/**
		 * Amount of meter required to fully charge the item.
		 * 
		 * If negative, 0, or not set, does not attempt to fill the meter at all when dealing damage.
		 */
		open val itemMeterDamageForFullCharge: ItemAttributeNamed<Number> = ItemAttributeNamed("item_meter_damage_for_full_charge")
	
		/**
		 * In-Game: "N% faster recharge rate"
		 * 
		 * Scale factor for meter gained per second and/or meter gained on dealing damage.
		 */
		open val multItemMeterChargeRate: ItemAttributeNamed<Number> = ItemAttributeNamed("mult_item_meter_charge_rate")
	}
	
	open class KnockbackReceivedAttributes : IBlockScoped {
		/**
		 * In-Game: "Immune to push force from damage and airblast when spun up"
		 * 
		 * Only procs if Heavy and has a spun up minigun.
		 */
		open val spunupPushForceImmunity: ItemAttributeNamed<Boolean> = ItemAttributeNamed("spunup_push_force_immunity")
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