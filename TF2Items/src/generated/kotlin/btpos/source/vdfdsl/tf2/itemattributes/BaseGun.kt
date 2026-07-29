package btpos.source.vdfdsl.tf2.itemattributes

import btpos.source.vdfdsl.modeling.*
import btpos.source.vdfdsl.serialization.codecs.*
import btpos.source.vdfdsl.tf2.itemattributes.impl.*
import btpos.source.vdfdsl.tf2.tftypes.*
import java.util.*




interface BaseGunAttributes : WeaponBaseAttributes {
	
	companion object {
		/**
		 * Multiplier applied to base fire delay.
		 * 
		 * Checked on player.
		 */
		val halloweenFireRateBonus: ItemAttributeNamed<Float> = ItemAttributeNamed("halloween fire rate bonus")
	
		/**
		 * In-Game: "Fire rate increases as health decreases"
		 * 
		 * Used with the _old_ Panic Attack.
		 */
		val fireRateBonusWithReducedHealth: ItemAttributeNamed<Float> = ItemAttributeNamed("fire rate bonus with reduced health")
	
		/**
		 * In-Game: "Increased attack speed and smaller blast radius while blast jumping"
		 * 
		 * Multiplier to fire delay while player is blast-jumping.
		 */
		val rocketjumpAttackrateBonus: ItemAttributeNamed<Float> = ItemAttributeNamed("rocketjump attackrate bonus")
	
		/**
		 * In-Game: "Overrides the projectile fired from the weapon. Takes values from 1 to 26, each representing a different projectile, and not all projectiles work on all weapons"
		 * 
		 * If unset, uses the weapon's default projectile type.
		 */
		val overrideProjectileType: ItemAttributeNamed<TFProjectileType> = ItemAttributeNamed("override projectile type")
	
		/**
		 * In-Game: "Per Shot: -N ammo"
		 * 
		 * How much ammo is used per shot. If 0, uses default.
		 */
		val ammoPerShot: ItemAttributeNamed<Int> = ItemAttributeNamed("mod ammo per shot")
	
		val projectileRange: BonusPenalty<Float> = BonusPenalty(
			ItemAttributeNamed("Projectile range increased"),
			ItemAttributeNamed("Projectile range decreased"),
		)
	
		/**
		 * Don't spin loch n load pills.
		 */
		val grenadeNoSpin: ItemAttributeNamed<Boolean> = ItemAttributeNamed("grenade no spin")
	
		val weaponSpread: BonusPenalty<Float> = BonusPenalty(
			ItemAttributeNamed("weapon spread bonus"),
			ItemAttributeNamed("spread penalty"),
		)
	
		/**
		 * In-Game: "Weapon spread increases as health decreases"
		 * 
		 * Multiplier applied to bullet spread as health gets lower.
		 */
		val multSpreadAsHealthDecreases: ItemAttributeNamed<Float> = ItemAttributeNamed("panic_attack_negative")
	
		/**
		 * In-Game: "Successive shots become less accurate"
		 * 
		 * Scales weapon spread when firing consecutive shots, like the _New_ Panic Attack.
		 */
		val spreadIncreasesOnConsecutiveShots: ItemAttributeNamed<Float> = ItemAttributeNamed("mult_spread_scales_consecutive")
	
		/**
		 * In-Game: "+N% damage bonus while disguised"
		 * 
		 * When disguised (only checks if the player has the condition, doesn't check class), multiply damage by this amount.
		 */
		val damageBonusWhileDisguised: ItemAttributeNamed<Float> = ItemAttributeNamed("damage bonus while disguised")
	
		/**
		 * In-Game: "Gains a damage bonus as rage increases, up to N%"
		 * 
		 * If you're a Soldier or Pyro, increases damage by `(n - 1) * (rage gauge proportion)`.
		 */
		val rageDamageBoost: ItemAttributeNamed<Float> = ItemAttributeNamed("mod rage damage boost")
	
		/**
		 * In-Game: "While a medic is healing you, this weapon's damage is increased by N%"
		 * 
		 * Multiply damage by this value once for each healer you have. (with 2 healers, that's `bonus * bonus`, exponential).
		 */
		val medicHealedDamageBonus: ItemAttributeNamed<Float> = ItemAttributeNamed("mod medic healed damage bonus")
	
		/**
		 * In-Game: "Accuracy scales damage"
		 * 
		 * If the projectile being fired is a bullet, multiply damage by your hit ratio over the past few seconds.
		 */
		val accuracyScalesDamage: ItemAttributeNamed<Float> = ItemAttributeNamed("accuracy scales damage")
	
		/**
		 * By default, all guns have perfect accuracy on the first shot, unless this is set.
		 */
		val multSpreadScaleFirstShot: ItemAttributeNamed<Float> = ItemAttributeNamed("mult_spread_scale_first_shot")
	
		/**
		 * In-Game: "Fires a wide, fixed shot pattern"
		 * 
		 * Enables fixed weapon spread on the weapon as though `tf_use_fixed_weaponspreads` were set.
		 */
		val fixedWeaponSpread: ItemAttributeNamed<Boolean> = ItemAttributeNamed("fixed_shot_pattern")
	
		val projectilePenetration: ProjectilePenetrationAttributes = ProjectilePenetrationAttributes()
	
		val damage: DamageAttributes = DamageAttributes()
	
		val fireRate: FireRateAttributes = FireRateAttributes()
	
		val onHit: OnHitAttributes = OnHitAttributes()
	
		val revengeCrits: RevengeCritsAttributes = RevengeCritsAttributes()
	
		val critVsBurningPlayers: CritVsBurningPlayersAttributes = CritVsBurningPlayersAttributes()
	
		val damageForceReduction: DamageForceReductionAttributes = DamageForceReductionAttributes()
	
		val ragdolls: RagdollsAttributes = RagdollsAttributes()
	}

	/**
	 * Multiplier applied to base fire delay.
	 * 
	 * Checked on player.
	 */
	val halloweenFireRateBonus: ItemAttributeNamed<Float> get() = BaseGunAttributes.halloweenFireRateBonus
	
	/**
	 * In-Game: "Fire rate increases as health decreases"
	 * 
	 * Used with the _old_ Panic Attack.
	 */
	val fireRateBonusWithReducedHealth: ItemAttributeNamed<Float> get() = BaseGunAttributes.fireRateBonusWithReducedHealth
	
	/**
	 * In-Game: "Increased attack speed and smaller blast radius while blast jumping"
	 * 
	 * Multiplier to fire delay while player is blast-jumping.
	 */
	val rocketjumpAttackrateBonus: ItemAttributeNamed<Float> get() = BaseGunAttributes.rocketjumpAttackrateBonus
	
	/**
	 * In-Game: "+N% faster reload time"
	 * 
	 * Used if the gun draws directly from the ammo supply without using a clip.
	 */
	override val fasterReloadRate: ItemAttributeNamed<Float> get() = super.fasterReloadRate
	
	/**
	 * In-Game: "Overrides the projectile fired from the weapon. Takes values from 1 to 26, each representing a different projectile, and not all projectiles work on all weapons"
	 * 
	 * If unset, uses the weapon's default projectile type.
	 */
	val overrideProjectileType: ItemAttributeNamed<TFProjectileType> get() = BaseGunAttributes.overrideProjectileType
	
	/**
	 * In-Game: "Per Shot: -N ammo"
	 * 
	 * How much ammo is used per shot. If 0, uses default.
	 */
	val ammoPerShot: ItemAttributeNamed<Int> get() = BaseGunAttributes.ammoPerShot
	
	/**
	 * In-Game: "+N degrees random projectile deviation"
	 * 
	 * Used when firing pipe bombs.
	 */
	override val projectileSpreadAnglePenalty: ItemAttributeNamed<Float> get() = super.projectileSpreadAnglePenalty
	
	val projectileRange: BonusPenalty<Float> get() = BaseGunAttributes.projectileRange
	
	/**
	 * Don't spin loch n load pills.
	 */
	val grenadeNoSpin: ItemAttributeNamed<Boolean> get() = BaseGunAttributes.grenadeNoSpin
	
	val weaponSpread: BonusPenalty<Float> get() = BaseGunAttributes.weaponSpread
	
	/**
	 * In-Game: "Weapon spread increases as health decreases"
	 * 
	 * Multiplier applied to bullet spread as health gets lower.
	 */
	val multSpreadAsHealthDecreases: ItemAttributeNamed<Float> get() = BaseGunAttributes.multSpreadAsHealthDecreases
	
	/**
	 * In-Game: "Successive shots become less accurate"
	 * 
	 * Scales weapon spread when firing consecutive shots, like the _New_ Panic Attack.
	 */
	val spreadIncreasesOnConsecutiveShots: ItemAttributeNamed<Float> get() = BaseGunAttributes.spreadIncreasesOnConsecutiveShots
	
	/**
	 * In-Game: "+N% damage bonus while disguised"
	 * 
	 * When disguised (only checks if the player has the condition, doesn't check class), multiply damage by this amount.
	 */
	val damageBonusWhileDisguised: ItemAttributeNamed<Float> get() = BaseGunAttributes.damageBonusWhileDisguised
	
	/**
	 * In-Game: "Gains a damage bonus as rage increases, up to N%"
	 * 
	 * If you're a Soldier or Pyro, increases damage by `(n - 1) * (rage gauge proportion)`.
	 */
	val rageDamageBoost: ItemAttributeNamed<Float> get() = BaseGunAttributes.rageDamageBoost
	
	/**
	 * In-Game: "While a medic is healing you, this weapon's damage is increased by N%"
	 * 
	 * Multiply damage by this value once for each healer you have. (with 2 healers, that's `bonus * bonus`, exponential).
	 */
	val medicHealedDamageBonus: ItemAttributeNamed<Float> get() = BaseGunAttributes.medicHealedDamageBonus
	
	/**
	 * In-Game: "Accuracy scales damage"
	 * 
	 * If the projectile being fired is a bullet, multiply damage by your hit ratio over the past few seconds.
	 */
	val accuracyScalesDamage: ItemAttributeNamed<Float> get() = BaseGunAttributes.accuracyScalesDamage
	
	/**
	 * By default, all guns have perfect accuracy on the first shot, unless this is set.
	 */
	val multSpreadScaleFirstShot: ItemAttributeNamed<Float> get() = BaseGunAttributes.multSpreadScaleFirstShot
	
	/**
	 * In-Game: "Fires a wide, fixed shot pattern"
	 * 
	 * Enables fixed weapon spread on the weapon as though `tf_use_fixed_weaponspreads` were set.
	 */
	val fixedWeaponSpread: ItemAttributeNamed<Boolean> get() = BaseGunAttributes.fixedWeaponSpread
	
	/**
	 * In-Game: "Attacks pierce damage resistance effects and bonuses"
	 */
	override val dmgPiercesResistsAbsorbs: ItemAttributeNamed<Boolean> get() = super.dmgPiercesResistsAbsorbs
	
	override val projectilePenetration: ProjectilePenetrationAttributes get() = BaseGunAttributes.projectilePenetration
	
	override val damage: DamageAttributes get() = BaseGunAttributes.damage
	
	override val fireRate: FireRateAttributes get() = BaseGunAttributes.fireRate
	
	override val onHit: OnHitAttributes get() = BaseGunAttributes.onHit
	
	override val revengeCrits: RevengeCritsAttributes get() = BaseGunAttributes.revengeCrits
	
	override val critVsBurningPlayers: CritVsBurningPlayersAttributes get() = BaseGunAttributes.critVsBurningPlayers
	
	override val damageForceReduction: DamageForceReductionAttributes get() = BaseGunAttributes.damageForceReduction
	
	override val ragdolls: RagdollsAttributes get() = BaseGunAttributes.ragdolls

	
	open class ProjectilePenetrationAttributes : WeaponBaseAttributes.ProjectilePenetrationAttributes() 
	
	
	open class DamageAttributes : WeaponBaseAttributes.DamageAttributes() 
	
	
	open class FireRateAttributes : WeaponBaseAttributes.FireRateAttributes() 
	
	
	open class OnHitAttributes : WeaponBaseAttributes.OnHitAttributes() {
		open val healOnHitForRapidfire: HealOnHitForRapidfireAttributes = HealOnHitForRapidfireAttributes()
	
		open val generateRageOnDamage: GenerateRageOnDamageAttributes = GenerateRageOnDamageAttributes()
	
	
		open class HealOnHitForRapidfireAttributes : WeaponBaseAttributes.OnHitAttributes.HealOnHitForRapidfireAttributes() 
	
	
		open class GenerateRageOnDamageAttributes : WeaponBaseAttributes.OnHitAttributes.GenerateRageOnDamageAttributes() 
	}
	
	
	open class RevengeCritsAttributes : WeaponBaseAttributes.RevengeCritsAttributes() 
	
	
	open class CritVsBurningPlayersAttributes : WeaponBaseAttributes.CritVsBurningPlayersAttributes() 
	
	
	open class DamageForceReductionAttributes : WeaponBaseAttributes.DamageForceReductionAttributes() 
	
	
	open class RagdollsAttributes : WeaponBaseAttributes.RagdollsAttributes() 
}