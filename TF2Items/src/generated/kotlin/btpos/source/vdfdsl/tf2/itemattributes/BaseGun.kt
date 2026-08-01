package btpos.source.vdfdsl.tf2.itemattributes

import btpos.source.vdfdsl.modeling.*
import btpos.source.vdfdsl.serialization.codecs.*
import btpos.source.vdfdsl.tf2.itemattributes.impl.*
import btpos.source.vdfdsl.tf2.tftypes.*
import java.util.*
import kotlin.time.Duration

interface BaseGunAttributes : WeaponBaseAttributes {
	companion object : IBlockScoped {
		private val afterburn: AfterburnAttributes = AfterburnAttributes()
	
		private val ammo: AmmoAttributes = AmmoAttributes()
	
		private val buildings: BuildingsAttributes = BuildingsAttributes()
	
		private val crits: CritsAttributes = CritsAttributes()
	
		private val damage: DamageAttributes = DamageAttributes()
	
		private val demoCharge: DemoChargeAttributes = DemoChargeAttributes()
	
		private val firing: FiringAttributes = FiringAttributes()
	
		private val healthAndHealing: HealthAndHealingAttributes = HealthAndHealingAttributes()
	
		private val knockbackReceived: KnockbackReceivedAttributes = KnockbackReceivedAttributes()
	
		private val meta: MetaAttributes = MetaAttributes()
	
		private val meter: MeterAttributes = MeterAttributes()
	
		private val movement: MovementAttributes = MovementAttributes()
	
		private val heads: HeadsAttributes = HeadsAttributes()
	
		private val onHit: OnHitAttributes = OnHitAttributes()
	
		private val onKill: OnKillAttributes = OnKillAttributes()
	
		private val projectiles: ProjectilesAttributes = ProjectilesAttributes()
	
		private val reloading: ReloadingAttributes = ReloadingAttributes()
	
		private val resistance: ResistanceAttributes = ResistanceAttributes()
	
		private val revengeCrits: RevengeCritsAttributes = RevengeCritsAttributes()
	
		private val statusEffects: StatusEffectsAttributes = StatusEffectsAttributes()
	
		private val taunting: TauntingAttributes = TauntingAttributes()
	
		private val swapWeapons: SwapWeaponsAttributes = SwapWeaponsAttributes()
	
		private val whenHit: WhenHitAttributes = WhenHitAttributes()
	
		private val ragdolls: RagdollsAttributes = RagdollsAttributes()
	
		private val disguise: DisguiseAttributes = DisguiseAttributes()
	
		/**
		 * In-Game: "Per Shot: -N ammo"
		 * 
		 * How much ammo is used per shot. If 0, uses default.
		 */
		val ammoPerShot: ItemAttributeNamed<Int> = ItemAttributeNamed("mod ammo per shot")
	
		/**
		 * In-Game: "+N% damage bonus while disguised"
		 * 
		 * When disguised (only checks if the player has the condition, doesn't check class), multiply damage by this amount.
		 */
		val damageBonusWhileDisguised: ItemAttributeNamed<Number> = ItemAttributeNamed("damage bonus while disguised")
	
		/**
		 * In-Game: "Gains a damage bonus as rage increases, up to N%"
		 * 
		 * If you're a Soldier or Pyro, increases damage by `(n - 1) * (rage gauge proportion)`.
		 */
		val rageDamageBoost: ItemAttributeNamed<Number> = ItemAttributeNamed("mod rage damage boost")
	
		/**
		 * In-Game: "While a medic is healing you, this weapon's damage is increased by N%"
		 * 
		 * Multiply damage by this value once for each healer you have. (with 2 healers, that's `bonus * bonus`, exponential).
		 */
		val medicHealedDamageBonus: ItemAttributeNamed<Number> = ItemAttributeNamed("mod medic healed damage bonus")
	
		/**
		 * In-Game: "Accuracy scales damage"
		 * 
		 * If the projectile being fired is a bullet, multiply damage by your hit ratio over the past few seconds.
		 */
		val accuracyScalesDamage: ItemAttributeNamed<Number> = ItemAttributeNamed("accuracy scales damage")
	
		/**
		 * Multiplier applied to base fire delay for miniguns.
		 * 
		 * Checked on player.
		 */
		val halloweenFireRateBonus: ItemAttributeNamed<Number> = ItemAttributeNamed("halloween fire rate bonus")
	
		/**
		 * In-Game: "Fire rate increases as health decreases"
		 * 
		 * Used with the pre-Blue Moon Panic Attack.
		 */
		val fireRateBonusWithReducedHealth: ItemAttributeNamed<Number> = ItemAttributeNamed("fire rate bonus with reduced health")
	
		/**
		 * In-Game: "Increased attack speed and smaller blast radius while blast jumping"
		 * 
		 * Multiplier to fire delay while player is blast-jumping.
		 * 
		 * If set on anything that fires a rocket, the rocket assumes it was fired by the Air Strike and reduces blast radius to 80% of its normal range.
		 */
		val rocketjumpAttackrateBonus: ItemAttributeNamed<Number> = ItemAttributeNamed("rocketjump attackrate bonus")
	
		/**
		 * In-Game: "Overrides the projectile fired from the weapon. Takes values from 1 to 26, each representing a different projectile, and not all projectiles work on all weapons"
		 * 
		 * If unset, uses the weapon's default projectile type.
		 */
		val overrideProjectileType: ItemAttributeNamed<TFProjectileType> = ItemAttributeNamed("override projectile type")
	
		/**
		 * Bonus:
		 * 
		 * 	- In-Game: "+N% projectile range"
		 * 
		 * Penalty:
		 * 
		 * 	- In-Game: "N% projectile range"
		 */
		val projectileRange: BonusPenalty<Number> = BonusPenalty(
			ItemAttributeNamed("Projectile range increased"),
			ItemAttributeNamed("Projectile range decreased"),
		)
	
		/**
		 * Don't do tumble on tumbling projectiles.
		 */
		val grenadeNoSpin: ItemAttributeNamed<Boolean> = ItemAttributeNamed("grenade no spin")
	
		/**
		 * Bonus:
		 * 
		 * 	- In-Game: "N% more accurate"
		 * 
		 * Penalty:
		 * 
		 * 	- In-Game: "N% less accurate"
		 */
		val weaponSpread: BonusPenalty<Number> = BonusPenalty(
			ItemAttributeNamed("weapon spread bonus"),
			ItemAttributeNamed("spread penalty"),
		)
	
		/**
		 * In-Game: "Weapon spread increases as health decreases"
		 * 
		 * Multiplier applied to bullet spread as health gets lower.
		 */
		val multSpreadAsHealthDecreases: ItemAttributeNamed<Number> = ItemAttributeNamed("panic_attack_negative")
	
		/**
		 * In-Game: "Successive shots become less accurate"
		 * 
		 * Scales weapon spread when firing consecutive shots, like the post-"Blue Moon" Panic Attack.
		 */
		val spreadIncreasesOnConsecutiveShots: ItemAttributeNamed<Number> = ItemAttributeNamed("mult_spread_scales_consecutive")
	
		/**
		 * By default, all guns have perfect accuracy on the first shot, unless this is set.
		 */
		val multSpreadScaleFirstShot: ItemAttributeNamed<Number> = ItemAttributeNamed("mult_spread_scale_first_shot")
	
		/**
		 * In-Game: "Fires a wide, fixed shot pattern"
		 * 
		 * Enables fixed weapon spread on the weapon as though `tf_use_fixed_weaponspreads` were set.
		 */
		val fixedWeaponSpread: ItemAttributeNamed<Boolean> = ItemAttributeNamed("fixed_shot_pattern")
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
	
	override val swapWeapons: SwapWeaponsAttributes get() = BaseGunAttributes.swapWeapons
	
	override val whenHit: WhenHitAttributes get() = BaseGunAttributes.whenHit
	
	override val ragdolls: RagdollsAttributes get() = BaseGunAttributes.ragdolls
	
	override val disguise: DisguiseAttributes get() = BaseGunAttributes.disguise

	open class AmmoAttributes : WeaponBaseAttributes.AmmoAttributes() {
		companion object : IBlockScoped 
	
		/**
		 * In-Game: "Per Shot: -N ammo"
		 * 
		 * How much ammo is used per shot. If 0, uses default.
		 */
		context(attrs: IAttributeContainer)
		open var ammoPerShot: Int? 
			get() = BaseGunAttributes.ammoPerShot.get()
			set(value) { BaseGunAttributes.ammoPerShot.set(value) }
	
		override val clipSize: ClipSizeAttributes = ClipSizeAttributes()
	
		open class ClipSizeAttributes : WeaponBaseAttributes.AmmoAttributes.ClipSizeAttributes() 
	}
	
	open class DamageAttributes : WeaponBaseAttributes.DamageAttributes() {
		companion object : IBlockScoped 
	
		/**
		 * In-Game: "+N% damage bonus while disguised"
		 * 
		 * When disguised (only checks if the player has the condition, doesn't check class), multiply damage by this amount.
		 */
		context(attrs: IAttributeContainer)
		open var damageBonusWhileDisguised: Number? 
			get() = BaseGunAttributes.damageBonusWhileDisguised.get()
			set(value) { BaseGunAttributes.damageBonusWhileDisguised.set(value) }
	
		/**
		 * In-Game: "Gains a damage bonus as rage increases, up to N%"
		 * 
		 * If you're a Soldier or Pyro, increases damage by `(n - 1) * (rage gauge proportion)`.
		 */
		context(attrs: IAttributeContainer)
		open var rageDamageBoost: Number? 
			get() = BaseGunAttributes.rageDamageBoost.get()
			set(value) { BaseGunAttributes.rageDamageBoost.set(value) }
	
		/**
		 * In-Game: "While a medic is healing you, this weapon's damage is increased by N%"
		 * 
		 * Multiply damage by this value once for each healer you have. (with 2 healers, that's `bonus * bonus`, exponential).
		 */
		context(attrs: IAttributeContainer)
		open var medicHealedDamageBonus: Number? 
			get() = BaseGunAttributes.medicHealedDamageBonus.get()
			set(value) { BaseGunAttributes.medicHealedDamageBonus.set(value) }
	
		/**
		 * In-Game: "Accuracy scales damage"
		 * 
		 * If the projectile being fired is a bullet, multiply damage by your hit ratio over the past few seconds.
		 */
		context(attrs: IAttributeContainer)
		open var accuracyScalesDamage: Number? 
			get() = BaseGunAttributes.accuracyScalesDamage.get()
			set(value) { BaseGunAttributes.accuracyScalesDamage.set(value) }
	}
	
	open class FiringAttributes : WeaponBaseAttributes.FiringAttributes() {
		companion object : IBlockScoped 
	
		override val fireRate: FireRateAttributes = FireRateAttributes()
	
		open class FireRateAttributes : WeaponBaseAttributes.FiringAttributes.FireRateAttributes() {
			companion object : IBlockScoped 
	
			/**
			 * Multiplier applied to base fire delay for miniguns.
			 * 
			 * Checked on player.
			 */
			context(attrs: IAttributeContainer)
			open var halloweenFireRateBonus: Number? 
				get() = BaseGunAttributes.halloweenFireRateBonus.get()
				set(value) { BaseGunAttributes.halloweenFireRateBonus.set(value) }
	
			/**
			 * In-Game: "Fire rate increases as health decreases"
			 * 
			 * Used with the pre-Blue Moon Panic Attack.
			 */
			context(attrs: IAttributeContainer)
			open var fireRateBonusWithReducedHealth: Number? 
				get() = BaseGunAttributes.fireRateBonusWithReducedHealth.get()
				set(value) { BaseGunAttributes.fireRateBonusWithReducedHealth.set(value) }
	
			/**
			 * In-Game: "Increased attack speed and smaller blast radius while blast jumping"
			 * 
			 * Multiplier to fire delay while player is blast-jumping.
			 * 
			 * If set on anything that fires a rocket, the rocket assumes it was fired by the Air Strike and reduces blast radius to 80% of its normal range.
			 */
			context(attrs: IAttributeContainer)
			open var rocketjumpAttackrateBonus: Number? 
				get() = BaseGunAttributes.rocketjumpAttackrateBonus.get()
				set(value) { BaseGunAttributes.rocketjumpAttackrateBonus.set(value) }
		}
	}
	
	open class ProjectilesAttributes : WeaponBaseAttributes.ProjectilesAttributes() {
		companion object : IBlockScoped 
	
		/**
		 * In-Game: "Overrides the projectile fired from the weapon. Takes values from 1 to 26, each representing a different projectile, and not all projectiles work on all weapons"
		 * 
		 * If unset, uses the weapon's default projectile type.
		 */
		context(attrs: IAttributeContainer)
		open var overrideProjectileType: TFProjectileType? 
			get() = BaseGunAttributes.overrideProjectileType.get()
			set(value) { BaseGunAttributes.overrideProjectileType.set(value) }
	
		/**
		 * In-Game: "+N degrees random projectile deviation"
		 * 
		 * Also applicable to stickies.
		 */
		context(attrs: IAttributeContainer)
		override var projectileSpreadAnglePenalty: Number? 
			get() = super.projectileSpreadAnglePenalty
			set(value) { super.projectileSpreadAnglePenalty = value }
	
		/**
		 * Bonus:
		 * 
		 * 	- In-Game: "+N% projectile range"
		 * 
		 * Penalty:
		 * 
		 * 	- In-Game: "N% projectile range"
		 */
		context(attrs: IAttributeContainer)
		open var projectileRange: Number? 
			get() = BaseGunAttributes.projectileRange.get()
			set(value) { BaseGunAttributes.projectileRange.set(value) }
	
		/**
		 * Don't do tumble on tumbling projectiles.
		 */
		context(attrs: IAttributeContainer)
		open var grenadeNoSpin: Boolean? 
			get() = BaseGunAttributes.grenadeNoSpin.get()
			set(value) { BaseGunAttributes.grenadeNoSpin.set(value) }
	
		override val bullets: BulletsAttributes = BulletsAttributes()
	
		override val projectilePenetration: ProjectilePenetrationAttributes = ProjectilePenetrationAttributes()
	
		open class BulletsAttributes : WeaponBaseAttributes.ProjectilesAttributes.BulletsAttributes() {
			companion object : IBlockScoped 
	
			/**
			 * Bonus:
			 * 
			 * 	- In-Game: "N% more accurate"
			 * 
			 * Penalty:
			 * 
			 * 	- In-Game: "N% less accurate"
			 */
			context(attrs: IAttributeContainer)
			open var weaponSpread: Number? 
				get() = BaseGunAttributes.weaponSpread.get()
				set(value) { BaseGunAttributes.weaponSpread.set(value) }
	
			/**
			 * In-Game: "Weapon spread increases as health decreases"
			 * 
			 * Multiplier applied to bullet spread as health gets lower.
			 */
			context(attrs: IAttributeContainer)
			open var multSpreadAsHealthDecreases: Number? 
				get() = BaseGunAttributes.multSpreadAsHealthDecreases.get()
				set(value) { BaseGunAttributes.multSpreadAsHealthDecreases.set(value) }
	
			/**
			 * In-Game: "Successive shots become less accurate"
			 * 
			 * Scales weapon spread when firing consecutive shots, like the post-"Blue Moon" Panic Attack.
			 */
			context(attrs: IAttributeContainer)
			open var spreadIncreasesOnConsecutiveShots: Number? 
				get() = BaseGunAttributes.spreadIncreasesOnConsecutiveShots.get()
				set(value) { BaseGunAttributes.spreadIncreasesOnConsecutiveShots.set(value) }
	
			/**
			 * By default, all guns have perfect accuracy on the first shot, unless this is set.
			 */
			context(attrs: IAttributeContainer)
			open var multSpreadScaleFirstShot: Number? 
				get() = BaseGunAttributes.multSpreadScaleFirstShot.get()
				set(value) { BaseGunAttributes.multSpreadScaleFirstShot.set(value) }
	
			/**
			 * In-Game: "Fires a wide, fixed shot pattern"
			 * 
			 * Enables fixed weapon spread on the weapon as though `tf_use_fixed_weaponspreads` were set.
			 */
			context(attrs: IAttributeContainer)
			open var fixedWeaponSpread: Boolean? 
				get() = BaseGunAttributes.fixedWeaponSpread.get()
				set(value) { BaseGunAttributes.fixedWeaponSpread.set(value) }
		}
	
		open class ProjectilePenetrationAttributes : WeaponBaseAttributes.ProjectilesAttributes.ProjectilePenetrationAttributes() 
	}
	
	open class AfterburnAttributes : WeaponBaseAttributes.AfterburnAttributes() 
	
	open class BuildingsAttributes : WeaponBaseAttributes.BuildingsAttributes() 
	
	open class CritsAttributes : WeaponBaseAttributes.CritsAttributes() 
	
	open class DemoChargeAttributes : WeaponBaseAttributes.DemoChargeAttributes() 
	
	open class HealthAndHealingAttributes : WeaponBaseAttributes.HealthAndHealingAttributes() 
	
	open class KnockbackReceivedAttributes : WeaponBaseAttributes.KnockbackReceivedAttributes() {
		override val damageForceReduction: DamageForceReductionAttributes = DamageForceReductionAttributes()
	
		open class DamageForceReductionAttributes : WeaponBaseAttributes.KnockbackReceivedAttributes.DamageForceReductionAttributes() 
	}
	
	open class MetaAttributes : WeaponBaseAttributes.MetaAttributes() {
		override val killfeed: KillfeedAttributes = KillfeedAttributes()
	
		override val viewmodel: ViewmodelAttributes = ViewmodelAttributes()
	
		override val items: ItemsAttributes = ItemsAttributes()
	
		override val particles: ParticlesAttributes = ParticlesAttributes()
	
		open class KillfeedAttributes : WeaponBaseAttributes.MetaAttributes.KillfeedAttributes() 
	
		open class ViewmodelAttributes : WeaponBaseAttributes.MetaAttributes.ViewmodelAttributes() 
	
		open class ItemsAttributes : WeaponBaseAttributes.MetaAttributes.ItemsAttributes() 
	
		open class ParticlesAttributes : WeaponBaseAttributes.MetaAttributes.ParticlesAttributes() 
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
	
	open class SwapWeaponsAttributes : WeaponBaseAttributes.SwapWeaponsAttributes() {
		override val deploy: DeployAttributes = DeployAttributes()
	
		open class DeployAttributes : WeaponBaseAttributes.SwapWeaponsAttributes.DeployAttributes() 
	}
	
	open class WhenHitAttributes : WeaponBaseAttributes.WhenHitAttributes() 
	
	open class RagdollsAttributes : WeaponBaseAttributes.RagdollsAttributes() 
	
	open class DisguiseAttributes : WeaponBaseAttributes.DisguiseAttributes() 
}