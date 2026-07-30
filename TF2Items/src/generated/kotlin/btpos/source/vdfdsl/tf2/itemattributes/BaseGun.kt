package btpos.source.vdfdsl.tf2.itemattributes

import btpos.source.vdfdsl.modeling.*
import btpos.source.vdfdsl.serialization.codecs.*
import btpos.source.vdfdsl.tf2.itemattributes.impl.*
import btpos.source.vdfdsl.tf2.tftypes.*
import java.util.*



interface BaseGunAttributes : WeaponBaseAttributes {
	companion object {
		val afterburn: AfterburnAttributes = AfterburnAttributes()
	
		private val ammo: AmmoAttributes = AmmoAttributes()
	
		val buildings: BuildingsAttributes = BuildingsAttributes()
	
		private val crits: CritsAttributes = CritsAttributes()
	
		private val damage: DamageAttributes = DamageAttributes()
	
		val demoCharge: DemoChargeAttributes = DemoChargeAttributes()
	
		val firing: FiringAttributes = FiringAttributes()
	
		val healthAndHealing: HealthAndHealingAttributes = HealthAndHealingAttributes()
	
		private val knockbackReceived: KnockbackReceivedAttributes = KnockbackReceivedAttributes()
	
		private val meta: MetaAttributes = MetaAttributes()
	
		private val meter: MeterAttributes = MeterAttributes()
	
		val movement: MovementAttributes = MovementAttributes()
	
		val heads: HeadsAttributes = HeadsAttributes()
	
		val onHit: OnHitAttributes = OnHitAttributes()
	
		val onKill: OnKillAttributes = OnKillAttributes()
	
		val projectiles: ProjectilesAttributes = ProjectilesAttributes()
	
		val reloading: ReloadingAttributes = ReloadingAttributes()
	
		private val resistance: ResistanceAttributes = ResistanceAttributes()
	
		val revengeCrits: RevengeCritsAttributes = RevengeCritsAttributes()
	
		val statusEffects: StatusEffectsAttributes = StatusEffectsAttributes()
	
		val taunting: TauntingAttributes = TauntingAttributes()
	
		val viewmodel: ViewmodelAttributes = ViewmodelAttributes()
	
		val swapWeapons: SwapWeaponsAttributes = SwapWeaponsAttributes()
	
		val whenHit: WhenHitAttributes = WhenHitAttributes()
	
		val ragdolls: RagdollsAttributes = RagdollsAttributes()
	}

	override val ammo: AmmoAttributes get() = BaseGunAttributes.ammo
	
	override val damage: DamageAttributes get() = BaseGunAttributes.damage
	
	override val firing: FiringAttributes get() = BaseGunAttributes.firing
	
	override val projectiles: ProjectilesAttributes get() = BaseGunAttributes.projectiles
	
	override val afterburn: AfterburnAttributes get() = BaseGunAttributes.afterburn
	
	override val buildings: BuildingsAttributes get() = BaseGunAttributes.buildings
	
	override val crits: CritsAttributes get() = BaseGunAttributes.crits
	
	override val demoCharge: DemoChargeAttributes get() = BaseGunAttributes.demoCharge
	
	override val healthAndHealing: HealthAndHealingAttributes get() = BaseGunAttributes.healthAndHealing
	
	override val knockbackReceived: KnockbackReceivedAttributes get() = BaseGunAttributes.knockbackReceived
	
	override val meta: MetaAttributes get() = BaseGunAttributes.meta
	
	override val meter: MeterAttributes get() = BaseGunAttributes.meter
	
	override val movement: MovementAttributes get() = BaseGunAttributes.movement
	
	override val heads: HeadsAttributes get() = BaseGunAttributes.heads
	
	override val onHit: OnHitAttributes get() = BaseGunAttributes.onHit
	
	override val onKill: OnKillAttributes get() = BaseGunAttributes.onKill
	
	override val reloading: ReloadingAttributes get() = BaseGunAttributes.reloading
	
	override val resistance: ResistanceAttributes get() = BaseGunAttributes.resistance
	
	override val revengeCrits: RevengeCritsAttributes get() = BaseGunAttributes.revengeCrits
	
	override val statusEffects: StatusEffectsAttributes get() = BaseGunAttributes.statusEffects
	
	override val taunting: TauntingAttributes get() = BaseGunAttributes.taunting
	
	override val viewmodel: ViewmodelAttributes get() = BaseGunAttributes.viewmodel
	
	override val swapWeapons: SwapWeaponsAttributes get() = BaseGunAttributes.swapWeapons
	
	override val whenHit: WhenHitAttributes get() = BaseGunAttributes.whenHit
	
	override val ragdolls: RagdollsAttributes get() = BaseGunAttributes.ragdolls

	open class AmmoAttributes : WeaponBaseAttributes.AmmoAttributes() {
		/**
		 * In-Game: "Per Shot: -N ammo"
		 * 
		 * How much ammo is used per shot. If 0, uses default.
		 */
		open val ammoPerShot: ItemAttributeNamed<Int> = ItemAttributeNamed("mod ammo per shot")
	
		override val clipSize: ClipSizeAttributes = ClipSizeAttributes()
	
		open class ClipSizeAttributes : WeaponBaseAttributes.AmmoAttributes.ClipSizeAttributes() 
	}
	
	open class DamageAttributes : WeaponBaseAttributes.DamageAttributes() {
		/**
		 * In-Game: "+N% damage bonus while disguised"
		 * 
		 * When disguised (only checks if the player has the condition, doesn't check class), multiply damage by this amount.
		 */
		open val damageBonusWhileDisguised: ItemAttributeNamed<Float> = ItemAttributeNamed("damage bonus while disguised")
	
		/**
		 * In-Game: "Gains a damage bonus as rage increases, up to N%"
		 * 
		 * If you're a Soldier or Pyro, increases damage by `(n - 1) * (rage gauge proportion)`.
		 */
		open val rageDamageBoost: ItemAttributeNamed<Float> = ItemAttributeNamed("mod rage damage boost")
	
		/**
		 * In-Game: "While a medic is healing you, this weapon's damage is increased by N%"
		 * 
		 * Multiply damage by this value once for each healer you have. (with 2 healers, that's `bonus * bonus`, exponential).
		 */
		open val medicHealedDamageBonus: ItemAttributeNamed<Float> = ItemAttributeNamed("mod medic healed damage bonus")
	
		/**
		 * In-Game: "Accuracy scales damage"
		 * 
		 * If the projectile being fired is a bullet, multiply damage by your hit ratio over the past few seconds.
		 */
		open val accuracyScalesDamage: ItemAttributeNamed<Float> = ItemAttributeNamed("accuracy scales damage")
	
		override val damage: DamageAttributes = DamageAttributes()
	
		open class DamageAttributes : WeaponBaseAttributes.DamageAttributes.DamageAttributes() 
	}
	
	open class FiringAttributes : WeaponBaseAttributes.FiringAttributes() {
		override val fireRate: FireRateAttributes = FireRateAttributes()
	
		open class FireRateAttributes : WeaponBaseAttributes.FiringAttributes.FireRateAttributes() {
			/**
			 * Multiplier applied to base fire delay for miniguns.
			 * 
			 * Checked on player.
			 */
			open val halloweenFireRateBonus: ItemAttributeNamed<Float> = ItemAttributeNamed("halloween fire rate bonus")
	
			/**
			 * In-Game: "Fire rate increases as health decreases"
			 * 
			 * Used with the pre-Blue Moon Panic Attack.
			 */
			open val fireRateBonusWithReducedHealth: ItemAttributeNamed<Float> = ItemAttributeNamed("fire rate bonus with reduced health")
	
			/**
			 * In-Game: "Increased attack speed and smaller blast radius while blast jumping"
			 * 
			 * Multiplier to fire delay while player is blast-jumping.
			 */
			open val rocketjumpAttackrateBonus: ItemAttributeNamed<Float> = ItemAttributeNamed("rocketjump attackrate bonus")
	
			override val fireRate: FireRateAttributes = FireRateAttributes()
	
			open class FireRateAttributes : WeaponBaseAttributes.FiringAttributes.FireRateAttributes.FireRateAttributes() 
		}
	}
	
	open class ProjectilesAttributes : WeaponBaseAttributes.ProjectilesAttributes() {
		/**
		 * In-Game: "Overrides the projectile fired from the weapon. Takes values from 1 to 26, each representing a different projectile, and not all projectiles work on all weapons"
		 * 
		 * If unset, uses the weapon's default projectile type.
		 */
		open val overrideProjectileType: ItemAttributeNamed<TFProjectileType> = ItemAttributeNamed("override projectile type")
	
		/**
		 * In-Game: "+N degrees random projectile deviation"
		 * 
		 * Also applicable to stickies.
		 */
		override val projectileSpreadAnglePenalty: ItemAttributeNamed<Float> get() = super.projectileSpreadAnglePenalty
	
		open val projectileRange: BonusPenalty<Float> = BonusPenalty(
			ItemAttributeNamed("Projectile range increased"),
			ItemAttributeNamed("Projectile range decreased"),
		)
	
		/**
		 * Don't do tumble on tumbling projectiles.
		 */
		open val grenadeNoSpin: ItemAttributeNamed<Boolean> = ItemAttributeNamed("grenade no spin")
	
		override val bullets: BulletsAttributes = BulletsAttributes()
	
		override val projectilePenetration: ProjectilePenetrationAttributes = ProjectilePenetrationAttributes()
	
		open class BulletsAttributes : WeaponBaseAttributes.ProjectilesAttributes.BulletsAttributes() {
			open val weaponSpread: BonusPenalty<Float> = BonusPenalty(
				ItemAttributeNamed("weapon spread bonus"),
				ItemAttributeNamed("spread penalty"),
			)
	
			/**
			 * In-Game: "Weapon spread increases as health decreases"
			 * 
			 * Multiplier applied to bullet spread as health gets lower.
			 */
			open val multSpreadAsHealthDecreases: ItemAttributeNamed<Float> = ItemAttributeNamed("panic_attack_negative")
	
			/**
			 * In-Game: "Successive shots become less accurate"
			 * 
			 * Scales weapon spread when firing consecutive shots, like the post-"Blue Moon" Panic Attack.
			 */
			open val spreadIncreasesOnConsecutiveShots: ItemAttributeNamed<Float> = ItemAttributeNamed("mult_spread_scales_consecutive")
	
			/**
			 * By default, all guns have perfect accuracy on the first shot, unless this is set.
			 */
			open val multSpreadScaleFirstShot: ItemAttributeNamed<Float> = ItemAttributeNamed("mult_spread_scale_first_shot")
	
			/**
			 * In-Game: "Fires a wide, fixed shot pattern"
			 * 
			 * Enables fixed weapon spread on the weapon as though `tf_use_fixed_weaponspreads` were set.
			 */
			open val fixedWeaponSpread: ItemAttributeNamed<Boolean> = ItemAttributeNamed("fixed_shot_pattern")
		}
	
		open class ProjectilePenetrationAttributes : WeaponBaseAttributes.ProjectilesAttributes.ProjectilePenetrationAttributes() 
	}
	
	open class AfterburnAttributes : WeaponBaseAttributes.AfterburnAttributes() 
	
	open class BuildingsAttributes : WeaponBaseAttributes.BuildingsAttributes() 
	
	open class CritsAttributes : WeaponBaseAttributes.CritsAttributes() {
		override val critVsBurningPlayers: CritVsBurningPlayersAttributes = CritVsBurningPlayersAttributes()
	
		open class CritVsBurningPlayersAttributes : WeaponBaseAttributes.CritsAttributes.CritVsBurningPlayersAttributes() 
	}
	
	open class DemoChargeAttributes : WeaponBaseAttributes.DemoChargeAttributes() 
	
	open class HealthAndHealingAttributes : WeaponBaseAttributes.HealthAndHealingAttributes() 
	
	open class KnockbackReceivedAttributes : WeaponBaseAttributes.KnockbackReceivedAttributes() {
		override val damageForceReduction: DamageForceReductionAttributes = DamageForceReductionAttributes()
	
		open class DamageForceReductionAttributes : WeaponBaseAttributes.KnockbackReceivedAttributes.DamageForceReductionAttributes() 
	}
	
	open class MetaAttributes : WeaponBaseAttributes.MetaAttributes() {
		override val killfeed: KillfeedAttributes = KillfeedAttributes()
	
		open class KillfeedAttributes : WeaponBaseAttributes.MetaAttributes.KillfeedAttributes() 
	}
	
	open class MeterAttributes : WeaponBaseAttributes.MeterAttributes() 
	
	open class MovementAttributes : WeaponBaseAttributes.MovementAttributes() {
		override val moveSpeed: MoveSpeedAttributes = MoveSpeedAttributes()
	
		open class MoveSpeedAttributes : WeaponBaseAttributes.MovementAttributes.MoveSpeedAttributes() 
	}
	
	open class HeadsAttributes : WeaponBaseAttributes.HeadsAttributes() 
	
	open class OnHitAttributes : WeaponBaseAttributes.OnHitAttributes() {
		override val healOnHitForRapidfire: HealOnHitForRapidfireAttributes = HealOnHitForRapidfireAttributes()
	
		override val generateRageOnDamage: GenerateRageOnDamageAttributes = GenerateRageOnDamageAttributes()
	
		open class HealOnHitForRapidfireAttributes : WeaponBaseAttributes.OnHitAttributes.HealOnHitForRapidfireAttributes() 
	
		open class GenerateRageOnDamageAttributes : WeaponBaseAttributes.OnHitAttributes.GenerateRageOnDamageAttributes() 
	}
	
	open class OnKillAttributes : WeaponBaseAttributes.OnKillAttributes() 
	
	open class ReloadingAttributes : WeaponBaseAttributes.ReloadingAttributes() 
	
	open class ResistanceAttributes : WeaponBaseAttributes.ResistanceAttributes() 
	
	open class RevengeCritsAttributes : WeaponBaseAttributes.RevengeCritsAttributes() 
	
	open class StatusEffectsAttributes : WeaponBaseAttributes.StatusEffectsAttributes() 
	
	open class TauntingAttributes : WeaponBaseAttributes.TauntingAttributes() 
	
	open class ViewmodelAttributes : WeaponBaseAttributes.ViewmodelAttributes() 
	
	open class SwapWeaponsAttributes : WeaponBaseAttributes.SwapWeaponsAttributes() {
		override val deploy: DeployAttributes = DeployAttributes()
	
		open class DeployAttributes : WeaponBaseAttributes.SwapWeaponsAttributes.DeployAttributes() 
	}
	
	open class WhenHitAttributes : WeaponBaseAttributes.WhenHitAttributes() 
	
	open class RagdollsAttributes : WeaponBaseAttributes.RagdollsAttributes() 
}