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
		companion object : IBlockScoped {
			/**
			 * In-Game: "Normal disguises require (and consume) a full cloak meter"
			 */
			val disguiseConsumesCloak: ItemAttributeNamed<Boolean> = ItemAttributeNamed("mod_disguise_consumes_cloak")
		}
	
		/**
		 * In-Game: "Normal disguises require (and consume) a full cloak meter"
		 */
		context(attrs: IAttributeContainer)
		open var disguiseConsumesCloak: Boolean? 
			get() = DisguiseAttributes.disguiseConsumesCloak.get()
			set(value) { DisguiseAttributes.disguiseConsumesCloak.set(value) }
	}
	
	open class CritsAttributes : IBlockScoped {
		companion object : IBlockScoped 
	}
	
	open class DamageAttributes : IBlockScoped {
		companion object : IBlockScoped {
			/**
			 * Bonus:
			 * 
			 * 	- In-Game: "N% splash damage fall off"
			 * 
			 * Penalty:
			 */
			val multDmgFalloff: BonusPenalty<Number> = BonusPenalty(
				ItemAttributeNamed("dmg falloff decreased"),
				ItemAttributeNamed("dmg falloff increased"),
			)
		}
	
		/**
		 * Bonus:
		 * 
		 * 	- In-Game: "N% splash damage fall off"
		 * 
		 * Penalty:
		 */
		context(attrs: IAttributeContainer)
		open var multDmgFalloff: Number? 
			get() = DamageAttributes.multDmgFalloff.get()
			set(value) { DamageAttributes.multDmgFalloff.set(value) }
	}
	
	open class MetaAttributes : IBlockScoped {
		companion object : IBlockScoped {
			val killfeed: KillfeedAttributes = KillfeedAttributes()
		}
	
		open val killfeed: KillfeedAttributes = KillfeedAttributes()
	
		open class KillfeedAttributes : IBlockScoped {
			companion object : IBlockScoped {
				/**
				 * If true, this item will get kill assist credit in the killfeed.
				 */
				val countsAsAssister: ItemAttributeNamed<Boolean> = ItemAttributeNamed("counts as assister is some kind of pet this update is going to be awesome")
			}
	
			/**
			 * If true, this item will get kill assist credit in the killfeed.
			 */
			context(attrs: IAttributeContainer)
			open var countsAsAssister: Boolean? 
				get() = KillfeedAttributes.countsAsAssister.get()
				set(value) { KillfeedAttributes.countsAsAssister.set(value) }
		}
	}
	
	open class MeterAttributes : IBlockScoped {
		companion object : IBlockScoped {
			/**
			 * In-Game: "Spawning and resupply do not affect the Gas meter"
			 * 
			 * If true, resupply cabinets and spawning do not fully recharge the meter for this item.  Instead, its "default charge meter value" is used.
			 */
			val itemMeterResupplyDenied: ItemAttributeNamed<Boolean> = ItemAttributeNamed("item_meter_resupply_denied")
	
			/**
			 * If `TIME` or `COMBO`, checks the `mult_item_meter_charge_rate` attribute for passive recharge rate mult.
			 * 
			 * If `DAMAGE` or `COMBO`, checks the `item_meter_damage_for_full_charge` and `mult_item_meter_charge_rate` attribute classes.
			 */
			val itemMeterChargeType: ItemAttributeNamed<TFMeterRechargeType> = ItemAttributeNamed("item_meter_charge_type")
	
			/**
			 * Amount of meter required to fully charge the item.
			 * 
			 * If negative, 0, or not set, does not attempt to fill the meter at all when dealing damage.
			 */
			val itemMeterDamageForFullCharge: ItemAttributeNamed<Number> = ItemAttributeNamed("item_meter_damage_for_full_charge")
	
			/**
			 * In-Game: "N% faster recharge rate"
			 * 
			 * Scale factor for meter gained per second and/or meter gained on dealing damage.
			 */
			val multItemMeterChargeRate: ItemAttributeNamed<Number> = ItemAttributeNamed("mult_item_meter_charge_rate")
		}
	
		/**
		 * In-Game: "Spawning and resupply do not affect the Gas meter"
		 * 
		 * If true, resupply cabinets and spawning do not fully recharge the meter for this item.  Instead, its "default charge meter value" is used.
		 */
		context(attrs: IAttributeContainer)
		open var itemMeterResupplyDenied: Boolean? 
			get() = MeterAttributes.itemMeterResupplyDenied.get()
			set(value) { MeterAttributes.itemMeterResupplyDenied.set(value) }
	
		/**
		 * If `TIME` or `COMBO`, checks the `mult_item_meter_charge_rate` attribute for passive recharge rate mult.
		 * 
		 * If `DAMAGE` or `COMBO`, checks the `item_meter_damage_for_full_charge` and `mult_item_meter_charge_rate` attribute classes.
		 */
		context(attrs: IAttributeContainer)
		open var itemMeterChargeType: TFMeterRechargeType? 
			get() = MeterAttributes.itemMeterChargeType.get()
			set(value) { MeterAttributes.itemMeterChargeType.set(value) }
	
		/**
		 * Amount of meter required to fully charge the item.
		 * 
		 * If negative, 0, or not set, does not attempt to fill the meter at all when dealing damage.
		 */
		context(attrs: IAttributeContainer)
		open var itemMeterDamageForFullCharge: Number? 
			get() = MeterAttributes.itemMeterDamageForFullCharge.get()
			set(value) { MeterAttributes.itemMeterDamageForFullCharge.set(value) }
	
		/**
		 * In-Game: "N% faster recharge rate"
		 * 
		 * Scale factor for meter gained per second and/or meter gained on dealing damage.
		 */
		context(attrs: IAttributeContainer)
		open var multItemMeterChargeRate: Number? 
			get() = MeterAttributes.multItemMeterChargeRate.get()
			set(value) { MeterAttributes.multItemMeterChargeRate.set(value) }
	}
	
	open class KnockbackReceivedAttributes : IBlockScoped {
		companion object : IBlockScoped {
			/**
			 * In-Game: "Immune to push force from damage and airblast when spun up"
			 * 
			 * Only procs if Heavy and has a spun up minigun.
			 */
			val spunupPushForceImmunity: ItemAttributeNamed<Boolean> = ItemAttributeNamed("spunup_push_force_immunity")
		}
	
		/**
		 * In-Game: "Immune to push force from damage and airblast when spun up"
		 * 
		 * Only procs if Heavy and has a spun up minigun.
		 */
		context(attrs: IAttributeContainer)
		open var spunupPushForceImmunity: Boolean? 
			get() = KnockbackReceivedAttributes.spunupPushForceImmunity.get()
			set(value) { KnockbackReceivedAttributes.spunupPushForceImmunity.set(value) }
	}
	
	open class ResistanceAttributes : IBlockScoped {
		companion object : IBlockScoped {
			/**
			 * In-Game: "Blocks a single backstab attempt"
			 * 
			 * If on a Wearable: the item is "broken", it is given `nodraw`, and the player's secondary weapon's meter is reset.
			 * 
			 * If on a weapon, reduces all backstab damage taken by the player for all backstabs without any cooldown. Performs identically to the Mannpower "Resistance" powerup in this respect.
			 */
			val blocksBackstab: ItemAttributeNamed<Boolean> = ItemAttributeNamed("backstab shield")
		}
	
		/**
		 * In-Game: "Blocks a single backstab attempt"
		 * 
		 * If on a Wearable: the item is "broken", it is given `nodraw`, and the player's secondary weapon's meter is reset.
		 * 
		 * If on a weapon, reduces all backstab damage taken by the player for all backstabs without any cooldown. Performs identically to the Mannpower "Resistance" powerup in this respect.
		 */
		context(attrs: IAttributeContainer)
		open var blocksBackstab: Boolean? 
			get() = ResistanceAttributes.blocksBackstab.get()
			set(value) { ResistanceAttributes.blocksBackstab.set(value) }
	}
}