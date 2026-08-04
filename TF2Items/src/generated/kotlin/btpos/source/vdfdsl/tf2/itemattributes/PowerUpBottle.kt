package btpos.source.vdfdsl.tf2.itemattributes

import btpos.source.vdfdsl.modeling.*
import btpos.source.vdfdsl.serialization.codecs.*
import btpos.source.vdfdsl.tf2.itemattributes.impl.*
import btpos.source.vdfdsl.tf2.tftypes.*
import java.util.*
import kotlin.time.Duration

interface PowerUpBottleAttributes : IBlockScoped, WearableAttributes {
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
	
		private val resistance: ResistanceAttributes = ResistanceAttributes()
	
		private val meta: MetaAttributes = MetaAttributes()
	
		private val ammo: AmmoAttributes = AmmoAttributes()
	
		private val buffItems: BuffItemsAttributes = BuffItemsAttributes()
	
		private val buildings: BuildingsAttributes = BuildingsAttributes()
	
		private val cloak: CloakAttributes = CloakAttributes()
	
		private val damage: DamageAttributes = DamageAttributes()
	
		private val demoCharge: DemoChargeAttributes = DemoChargeAttributes()
	
		private val disguise: DisguiseAttributes = DisguiseAttributes()
	
		private val firing: FiringAttributes = FiringAttributes()
	
		private val heads: HeadsAttributes = HeadsAttributes()
	
		private val healthAndHealing: HealthAndHealingAttributes = HealthAndHealingAttributes()
	
		private val hud: HudAttributes = HudAttributes()
	
		private val knockbackReceived: KnockbackReceivedAttributes = KnockbackReceivedAttributes()
	
		private val meter: MeterAttributes = MeterAttributes()
	
		private val movement: MovementAttributes = MovementAttributes()
	
		private val onHit: OnHitAttributes = OnHitAttributes()
	
		private val onKill: OnKillAttributes = OnKillAttributes()
	
		private val taunting: TauntingAttributes = TauntingAttributes()
	
		private val swapWeapons: SwapWeaponsAttributes = SwapWeaponsAttributes()
	
		private val whenHit: WhenHitAttributes = WhenHitAttributes()
	
		private val spyOnly: SpyOnlyAttributes = SpyOnlyAttributes()
	
		private val crits: CritsAttributes = CritsAttributes()
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
	
	override val ammo: AmmoAttributes get() = PowerUpBottleAttributes.ammo
	
	override val buffItems: BuffItemsAttributes get() = PowerUpBottleAttributes.buffItems
	
	override val buildings: BuildingsAttributes get() = PowerUpBottleAttributes.buildings
	
	override val cloak: CloakAttributes get() = PowerUpBottleAttributes.cloak
	
	override val damage: DamageAttributes get() = PowerUpBottleAttributes.damage
	
	override val demoCharge: DemoChargeAttributes get() = PowerUpBottleAttributes.demoCharge
	
	override val disguise: DisguiseAttributes get() = PowerUpBottleAttributes.disguise
	
	override val firing: FiringAttributes get() = PowerUpBottleAttributes.firing
	
	override val heads: HeadsAttributes get() = PowerUpBottleAttributes.heads
	
	override val healthAndHealing: HealthAndHealingAttributes get() = PowerUpBottleAttributes.healthAndHealing
	
	override val hud: HudAttributes get() = PowerUpBottleAttributes.hud
	
	override val knockbackReceived: KnockbackReceivedAttributes get() = PowerUpBottleAttributes.knockbackReceived
	
	override val meter: MeterAttributes get() = PowerUpBottleAttributes.meter
	
	override val movement: MovementAttributes get() = PowerUpBottleAttributes.movement
	
	override val onHit: OnHitAttributes get() = PowerUpBottleAttributes.onHit
	
	override val onKill: OnKillAttributes get() = PowerUpBottleAttributes.onKill
	
	override val taunting: TauntingAttributes get() = PowerUpBottleAttributes.taunting
	
	override val swapWeapons: SwapWeaponsAttributes get() = PowerUpBottleAttributes.swapWeapons
	
	override val whenHit: WhenHitAttributes get() = PowerUpBottleAttributes.whenHit
	
	override val spyOnly: SpyOnlyAttributes get() = PowerUpBottleAttributes.spyOnly
	
	override val crits: CritsAttributes get() = PowerUpBottleAttributes.crits

	open class TypeAttributes : IBlockScoped {
		/**
		 * In-Game: "Consumable: Become Crit Boosted for 5 seconds (and double your sentry's firing speed)"
		 */
		open val critboost: ItemAttributeNamed<Boolean> = ItemAttributeNamed("critboost")
	
		/**
		 * In-Game: "Consumable: Become Übercharged for 5 seconds (and shield your sentry from damage)"
		 */
		open val ubercharge: ItemAttributeNamed<Boolean> = ItemAttributeNamed("ubercharge")
	
		/**
		 * In-Game: "Consumable: Instantly teleport to spawn"
		 */
		open val recall: ItemAttributeNamed<Boolean> = ItemAttributeNamed("recall")
	
		/**
		 * In-Game: "Consumable: Instantly refill all weapon clips and ammo"
		 */
		open val refillAmmo: ItemAttributeNamed<Boolean> = ItemAttributeNamed("refill_ammo")
	
		/**
		 * In-Game: "Consumable: Instantly upgrade all buildings to max level"
		 */
		open val buildingInstantUpgrade: ItemAttributeNamed<Boolean> = ItemAttributeNamed("building instant upgrade")
	}
	
	open class ResistanceAttributes : WearableAttributes.ResistanceAttributes() {
		override val dmgTakenFromCritReduced: DmgTakenFromCritReducedAttributes = DmgTakenFromCritReducedAttributes()
	
		override val dmgTakenFromFireReduced: DmgTakenFromFireReducedAttributes = DmgTakenFromFireReducedAttributes()
	
		override val dmgTakenFromBulletsReduced: DmgTakenFromBulletsReducedAttributes = DmgTakenFromBulletsReducedAttributes()
	
		override val vaccinator: VaccinatorAttributes = VaccinatorAttributes()
	
		open class DmgTakenFromCritReducedAttributes : WearableAttributes.ResistanceAttributes.DmgTakenFromCritReducedAttributes() 
	
		open class DmgTakenFromFireReducedAttributes : WearableAttributes.ResistanceAttributes.DmgTakenFromFireReducedAttributes() 
	
		open class DmgTakenFromBulletsReducedAttributes : WearableAttributes.ResistanceAttributes.DmgTakenFromBulletsReducedAttributes() 
	
		open class VaccinatorAttributes : WearableAttributes.ResistanceAttributes.VaccinatorAttributes() 
	}
	
	open class MetaAttributes : WearableAttributes.MetaAttributes() {
		override val player: PlayerAttributes = PlayerAttributes()
	
		override val items: ItemsAttributes = ItemsAttributes()
	
		override val particles: ParticlesAttributes = ParticlesAttributes()
	
		override val killfeed: KillfeedAttributes = KillfeedAttributes()
	
		override val noisemakers: NoisemakersAttributes = NoisemakersAttributes()
	
		override val gameplay: GameplayAttributes = GameplayAttributes()
	
		open class PlayerAttributes : WearableAttributes.MetaAttributes.PlayerAttributes() 
	
		open class ItemsAttributes : WearableAttributes.MetaAttributes.ItemsAttributes() 
	
		open class ParticlesAttributes : WearableAttributes.MetaAttributes.ParticlesAttributes() 
	
		open class KillfeedAttributes : WearableAttributes.MetaAttributes.KillfeedAttributes() 
	
		open class NoisemakersAttributes : WearableAttributes.MetaAttributes.NoisemakersAttributes() 
	
		open class GameplayAttributes : WearableAttributes.MetaAttributes.GameplayAttributes() 
	}
	
	open class AmmoAttributes : WearableAttributes.AmmoAttributes() {
		override val maxAmmo: MaxAmmoAttributes = MaxAmmoAttributes()
	
		open class MaxAmmoAttributes : WearableAttributes.AmmoAttributes.MaxAmmoAttributes() 
	}
	
	open class BuffItemsAttributes : WearableAttributes.BuffItemsAttributes() 
	
	open class BuildingsAttributes : WearableAttributes.BuildingsAttributes() {
		override val sentryGun: SentryGunAttributes = SentryGunAttributes()
	
		override val dispenser: DispenserAttributes = DispenserAttributes()
	
		override val teleporter: TeleporterAttributes = TeleporterAttributes()
	
		open class SentryGunAttributes : WearableAttributes.BuildingsAttributes.SentryGunAttributes() 
	
		open class DispenserAttributes : WearableAttributes.BuildingsAttributes.DispenserAttributes() 
	
		open class TeleporterAttributes : WearableAttributes.BuildingsAttributes.TeleporterAttributes() 
	}
	
	open class CloakAttributes : WearableAttributes.CloakAttributes() 
	
	open class DamageAttributes : WearableAttributes.DamageAttributes() {
		override val alien: AlienAttributes = AlienAttributes()
	
		open class AlienAttributes : WearableAttributes.DamageAttributes.AlienAttributes() 
	}
	
	open class DemoChargeAttributes : WearableAttributes.DemoChargeAttributes() {
		override val multChargeTurnControl: MultChargeTurnControlAttributes = MultChargeTurnControlAttributes()
	
		open class MultChargeTurnControlAttributes : WearableAttributes.DemoChargeAttributes.MultChargeTurnControlAttributes() 
	}
	
	open class DisguiseAttributes : WearableAttributes.DisguiseAttributes() 
	
	open class FiringAttributes : WearableAttributes.FiringAttributes() 
	
	open class HeadsAttributes : WearableAttributes.HeadsAttributes() 
	
	open class HealthAndHealingAttributes : WearableAttributes.HealthAndHealingAttributes() {
		override val healthRegen: HealthRegenAttributes = HealthRegenAttributes()
	
		override val maxHealthAdditive: MaxHealthAdditiveAttributes = MaxHealthAdditiveAttributes()
	
		open class HealthRegenAttributes : WearableAttributes.HealthAndHealingAttributes.HealthRegenAttributes() 
	
		open class MaxHealthAdditiveAttributes : WearableAttributes.HealthAndHealingAttributes.MaxHealthAdditiveAttributes() 
	}
	
	open class HudAttributes : WearableAttributes.HudAttributes() 
	
	open class KnockbackReceivedAttributes : WearableAttributes.KnockbackReceivedAttributes() 
	
	open class MeterAttributes : WearableAttributes.MeterAttributes() {
		override val generateRageOnDamage: GenerateRageOnDamageAttributes = GenerateRageOnDamageAttributes()
	
		open class GenerateRageOnDamageAttributes : WearableAttributes.MeterAttributes.GenerateRageOnDamageAttributes() 
	}
	
	open class MovementAttributes : WearableAttributes.MovementAttributes() {
		override val jumpHeight: jumpHeightAttributes = jumpHeightAttributes()
	
		override val moveSpeed: MoveSpeedAttributes = MoveSpeedAttributes()
	
		open class jumpHeightAttributes : WearableAttributes.MovementAttributes.jumpHeightAttributes() 
	
		open class MoveSpeedAttributes : WearableAttributes.MovementAttributes.MoveSpeedAttributes() {
			override val aimingMovespeed: AimingMovespeedAttributes = AimingMovespeedAttributes()
	
			override val moveSpeed: MoveSpeedAttributes = MoveSpeedAttributes()
	
			open class AimingMovespeedAttributes : WearableAttributes.MovementAttributes.MoveSpeedAttributes.AimingMovespeedAttributes() 
	
			open class MoveSpeedAttributes : WearableAttributes.MovementAttributes.MoveSpeedAttributes.MoveSpeedAttributes() 
		}
	}
	
	open class OnHitAttributes : WearableAttributes.OnHitAttributes() {
		override val falling: FallingAttributes = FallingAttributes()
	
		open class FallingAttributes : WearableAttributes.OnHitAttributes.FallingAttributes() 
	}
	
	open class OnKillAttributes : WearableAttributes.OnKillAttributes() 
	
	open class TauntingAttributes : WearableAttributes.TauntingAttributes() 
	
	open class SwapWeaponsAttributes : WearableAttributes.SwapWeaponsAttributes() 
	
	open class WhenHitAttributes : WearableAttributes.WhenHitAttributes() 
	
	open class SpyOnlyAttributes : WearableAttributes.SpyOnlyAttributes() 
	
	open class CritsAttributes : WearableAttributes.CritsAttributes() 
	
	object Inherited : PowerUpBottleAttributes 
}