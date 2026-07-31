package btpos.source.vdfdsl.tf2.itemattributes

import btpos.source.vdfdsl.modeling.*
import btpos.source.vdfdsl.serialization.codecs.*
import btpos.source.vdfdsl.tf2.itemattributes.impl.*
import btpos.source.vdfdsl.tf2.tftypes.*
import java.util.*
import kotlin.time.Duration

interface PowerUpBottleAttributes : WearableAttributes {
	companion object : IBlockScoped {
		val type: TypeAttributes = TypeAttributes()
	
		/**
		 * In-Game: "Each charge lasts N seconds"
		 */
		val powerupDuration: ItemAttributeNamed<Number> = ItemAttributeNamed("powerup duration")
	
		/**
		 * In-Game: "Share Canteens with your heal target. +1 duration, -10 price per point (minimum cost: 5)"
		 * 
		 * Adds extra time to the base powerup duration based on level.
		 * 
		 * Checked on player.
		 */
		val canteenSpecialist: ItemAttributeNamed<Int> = ItemAttributeNamed("canteen specialist")
	
		/**
		 * In-Game: "Holds a maximum of N charges"
		 */
		val powerupMaxCharges: ItemAttributeNamed<Int> = ItemAttributeNamed("powerup max charges")
	
		val resistance: ResistanceAttributes = ResistanceAttributes()
	
		val meta: MetaAttributes = MetaAttributes()
	
		val disguise: DisguiseAttributes = DisguiseAttributes()
	
		val crits: CritsAttributes = CritsAttributes()
	
		val damage: DamageAttributes = DamageAttributes()
	
		val meter: MeterAttributes = MeterAttributes()
	
		val knockbackReceived: KnockbackReceivedAttributes = KnockbackReceivedAttributes()
	}

	val type: TypeAttributes get() = PowerUpBottleAttributes.type
	
	/**
	 * In-Game: "Each charge lasts N seconds"
	 */
	val powerupDuration: ItemAttributeNamed<Number> get() = PowerUpBottleAttributes.powerupDuration
	
	/**
	 * In-Game: "Share Canteens with your heal target. +1 duration, -10 price per point (minimum cost: 5)"
	 * 
	 * Adds extra time to the base powerup duration based on level.
	 * 
	 * Checked on player.
	 */
	val canteenSpecialist: ItemAttributeNamed<Int> get() = PowerUpBottleAttributes.canteenSpecialist
	
	/**
	 * In-Game: "Holds a maximum of N charges"
	 */
	val powerupMaxCharges: ItemAttributeNamed<Int> get() = PowerUpBottleAttributes.powerupMaxCharges
	
	override val resistance: ResistanceAttributes get() = PowerUpBottleAttributes.resistance
	
	override val meta: MetaAttributes get() = PowerUpBottleAttributes.meta
	
	override val disguise: DisguiseAttributes get() = PowerUpBottleAttributes.disguise
	
	override val crits: CritsAttributes get() = PowerUpBottleAttributes.crits
	
	override val damage: DamageAttributes get() = PowerUpBottleAttributes.damage
	
	override val meter: MeterAttributes get() = PowerUpBottleAttributes.meter
	
	override val knockbackReceived: KnockbackReceivedAttributes get() = PowerUpBottleAttributes.knockbackReceived

	open class TypeAttributes : IBlockScoped {
		companion object : IBlockScoped {
			/**
			 * In-Game: "Consumable: Become Crit Boosted for 5 seconds (and double your sentry's firing speed)"
			 */
			val critboost: ItemAttributeNamed<Boolean> = ItemAttributeNamed("critboost")
	
			/**
			 * In-Game: "Consumable: Become Übercharged for 5 seconds (and shield your sentry from damage)"
			 */
			val ubercharge: ItemAttributeNamed<Boolean> = ItemAttributeNamed("ubercharge")
	
			/**
			 * In-Game: "Consumable: Instantly teleport to spawn"
			 */
			val recall: ItemAttributeNamed<Boolean> = ItemAttributeNamed("recall")
	
			/**
			 * In-Game: "Consumable: Instantly refill all weapon clips and ammo"
			 */
			val refillAmmo: ItemAttributeNamed<Boolean> = ItemAttributeNamed("refill_ammo")
	
			/**
			 * In-Game: "Consumable: Instantly upgrade all buildings to max level"
			 */
			val buildingInstantUpgrade: ItemAttributeNamed<Boolean> = ItemAttributeNamed("building instant upgrade")
		}
	
		/**
		 * In-Game: "Consumable: Become Crit Boosted for 5 seconds (and double your sentry's firing speed)"
		 */
		context(attrs: IAttributeContainer)
		open var critboost: Boolean? 
			get() = TypeAttributes.critboost.get()
			set(value) { TypeAttributes.critboost.set(value) }
	
		/**
		 * In-Game: "Consumable: Become Übercharged for 5 seconds (and shield your sentry from damage)"
		 */
		context(attrs: IAttributeContainer)
		open var ubercharge: Boolean? 
			get() = TypeAttributes.ubercharge.get()
			set(value) { TypeAttributes.ubercharge.set(value) }
	
		/**
		 * In-Game: "Consumable: Instantly teleport to spawn"
		 */
		context(attrs: IAttributeContainer)
		open var recall: Boolean? 
			get() = TypeAttributes.recall.get()
			set(value) { TypeAttributes.recall.set(value) }
	
		/**
		 * In-Game: "Consumable: Instantly refill all weapon clips and ammo"
		 */
		context(attrs: IAttributeContainer)
		open var refillAmmo: Boolean? 
			get() = TypeAttributes.refillAmmo.get()
			set(value) { TypeAttributes.refillAmmo.set(value) }
	
		/**
		 * In-Game: "Consumable: Instantly upgrade all buildings to max level"
		 */
		context(attrs: IAttributeContainer)
		open var buildingInstantUpgrade: Boolean? 
			get() = TypeAttributes.buildingInstantUpgrade.get()
			set(value) { TypeAttributes.buildingInstantUpgrade.set(value) }
	}
	
	open class ResistanceAttributes : WearableAttributes.ResistanceAttributes() 
	
	open class MetaAttributes : WearableAttributes.MetaAttributes() {
		override val player: PlayerAttributes = PlayerAttributes()
	
		override val items: ItemsAttributes = ItemsAttributes()
	
		override val particles: ParticlesAttributes = ParticlesAttributes()
	
		override val killfeed: KillfeedAttributes = KillfeedAttributes()
	
		open class PlayerAttributes : WearableAttributes.MetaAttributes.PlayerAttributes() 
	
		open class ItemsAttributes : WearableAttributes.MetaAttributes.ItemsAttributes() 
	
		open class ParticlesAttributes : WearableAttributes.MetaAttributes.ParticlesAttributes() 
	
		open class KillfeedAttributes : WearableAttributes.MetaAttributes.KillfeedAttributes() 
	}
	
	open class DisguiseAttributes : WearableAttributes.DisguiseAttributes() 
	
	open class CritsAttributes : WearableAttributes.CritsAttributes() 
	
	open class DamageAttributes : WearableAttributes.DamageAttributes() 
	
	open class MeterAttributes : WearableAttributes.MeterAttributes() 
	
	open class KnockbackReceivedAttributes : WearableAttributes.KnockbackReceivedAttributes() 
}