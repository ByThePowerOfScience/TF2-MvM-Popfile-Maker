package btpos.source.vdfdsl.tf2.itemattributes

import btpos.source.vdfdsl.modeling.*
import btpos.source.vdfdsl.serialization.codecs.*
import btpos.source.vdfdsl.tf2.itemattributes.impl.*
import btpos.source.vdfdsl.tf2.tftypes.*
import java.util.*



/**
 * Items: The Wrangler, Festive Wrangler, The Giger Counter
 */
interface BaseGunAttributes : IBlockScoped {
	companion object {
		/**
		 * 
		 *
		 * Multiplier applied to base fire delay.
		 *
		 * Checked on player.
		 */
		val halloweenFireRateBonus = ItemAttributeNamed<Float>("halloween fire rate bonus")
		
		/**
		 * In-Game: "Fire rate increases as health decreases"
		 *
		 * 
		 *
		 * Used with the _old_ Panic Attack.
		 */
		val fireRateBonusWithReducedHealth = ItemAttributeNamed<Float>("fire rate bonus with reduced health")
		
		/**
		 * In-Game: "Increased attack speed and smaller blast radius while blast jumping"
		 *
		 * 
		 *
		 * Multiplier to fire delay while player is blast-jumping.
		 */
		val rocketjumpAttackrateBonus = ItemAttributeNamed<Float>("rocketjump attackrate bonus")
		
		/**
		 * In-Game: "+N% faster reload time"
		 *
		 * 
		 *
		 * Used if the gun draws directly from the ammo supply without using a clip.
		 */
		val fasterReloadRate = ItemAttributeNamed<Float>("faster reload rate")
		
		/**
		 * In-Game: "Overrides the projectile fired from the weapon. Takes values from 1 to 26, each representing a different projectile, and not all projectiles work on all weapons"
		 *
		 * 
		 *
		 * If unset, uses the weapon's default projectile type.
		 */
		val overrideProjectileType = ItemAttributeNamed<TFProjectileType>("override projectile type")
		
		/**
		 * In-Game: "Per Shot: -N ammo"
		 *
		 * 
		 *
		 * How much ammo is used per shot. If 0, uses default.
		 */
		val ammoPerShot = ItemAttributeNamed<Int>("mod ammo per shot")
		
		/**
		 * In-Game: "+N degrees random projectile deviation"
		 *
		 * 
		 *
		 * Used when firing pipe bombs.
		 */
		val projectileSpreadAnglePenalty = ItemAttributeNamed<Float>("projectile spread angle penalty")
		
		/**
		 * Bonus:
		 *
		 * 	- In-Game: "+N% projectile range"
		 *
		 * 
		 *
		 * Penalty:
		 *
		 * 	- In-Game: "N% projectile range"
		 *
		 * 
		 *
		 * Used when firing any projectile, including pipe bombs.
		 */
		val projectileRange = BonusPenalty(
			ItemAttributeNamed<Float>("Projectile range increased"),
			ItemAttributeNamed<Float>("Projectile range decreased")
		)
		
		/**
		 * 
		 *
		 * Don't spin loch n load pills.
		 */
		val grenadeNoSpin = ItemAttributeNamed<Boolean>("grenade no spin")
		
		/**
		 * In-Game: "Projectiles penetrate enemy players"
		 *
		 * 
		 *
		 * Also on WeaponBase, but noted here because it's specifically used in Gun's "fire arrow" logic.
		 */
		val projectilePenetration = ItemAttributeNamed<Boolean>("projectile penetration")
		
		/**
		 * In-Game: "Bullets penetrate +N enemies"
		 *
		 * 
		 *
		 * Also on WeaponBase, but noted here because it's specifically used in Gun's "fire arrow" logic.
		 */
		val projectilePenetrationHeavy = ItemAttributeNamed<Boolean>("projectile penetration heavy")
		
		/**
		 * Bonus:
		 *
		 * 	- In-Game: "N% more accurate"
		 *
		 * 
		 *
		 * Penalty:
		 *
		 * 	- In-Game: "N% less accurate"
		 *
		 * 
		 *
		 * Modifies bullet spread.
		 */
		val weaponSpread = BonusPenalty(
			ItemAttributeNamed<Float>("weapon spread bonus"),
			ItemAttributeNamed<Float>("spread penalty")
		)
		
		/**
		 * In-Game: "Weapon spread increases as health decreases"
		 *
		 * 
		 *
		 * Multiplier applied to bullet spread as health gets lower.
		 */
		val multSpreadAsHealthDecreases = ItemAttributeNamed<Float>("panic_attack_negative")
		
		/**
		 * In-Game: "Successive shots become less accurate"
		 *
		 * 
		 *
		 * Scales weapon spread when firing consecutive shots, like the _New_ Panic Attack.
		 */
		val spreadIncreasesOnConsecutiveShots = ItemAttributeNamed<Float>("mult_spread_scales_consecutive")
		
		/**
		 * In-Game: "+N% damage bonus while disguised"
		 *
		 * 
		 *
		 * When disguised (only checks if the player has the condition, doesn't check class), multiply damage by this amount.
		 */
		val damageBonusWhileDisguised = ItemAttributeNamed<Float>("damage bonus while disguised")
		
		/**
		 * In-Game: "Gains a damage bonus as rage increases, up to N%"
		 *
		 * 
		 *
		 * If you're a Soldier or Pyro, increases damage by `(n - 1) * (rage gauge proportion)`.
		 */
		val rageDamageBoost = ItemAttributeNamed<Float>("mod rage damage boost")
		
		/**
		 * In-Game: "While a medic is healing you, this weapon's damage is increased by N%"
		 *
		 * 
		 *
		 * Multiply damage by this value once for each healer you have. (with 2 healers, that's `bonus * bonus`, exponential).
		 */
		val medicHealedDamageBonus = ItemAttributeNamed<Float>("mod medic healed damage bonus")
		
		/**
		 * In-Game: "Accuracy scales damage"
		 *
		 * 
		 *
		 * If the projectile being fired is a bullet, multiply damage by your hit ratio over the past few seconds.
		 */
		val accuracyScalesDamage = ItemAttributeNamed<Float>("accuracy scales damage")
		
		/**
		 * 
		 *
		 * By default, all guns have perfect accuracy on the first shot, unless this is set.
		 */
		val multSpreadScaleFirstShot = ItemAttributeNamed<Float>("mult_spread_scale_first_shot")
		
		/**
		 * In-Game: "Fires a wide, fixed shot pattern"
		 *
		 * 
		 *
		 * Enables fixed weapon spread on the weapon as though `tf_use_fixed_weaponspreads` were set.
		 */
		val fixedWeaponSpread = ItemAttributeNamed<Boolean>("fixed_shot_pattern")
		
		/**
		 * In-Game: "Attacks pierce damage resistance effects and bonuses"
		 *
		 * 
		 */
		val dmgPiercesResistsAbsorbs = ItemAttributeNamed<Boolean>("dmg pierces resists absorbs")
	}

	/**
	 * 
	 *
	 * Multiplier applied to base fire delay.
	 *
	 * Checked on player.
	 */
	val halloweenFireRateBonus: ItemAttribute<Float> get() = BaseGunAttributes.halloweenFireRateBonus
	
	/**
	 * In-Game: "Fire rate increases as health decreases"
	 *
	 * 
	 *
	 * Used with the _old_ Panic Attack.
	 */
	val fireRateBonusWithReducedHealth: ItemAttribute<Float> get() = BaseGunAttributes.fireRateBonusWithReducedHealth
	
	/**
	 * In-Game: "Increased attack speed and smaller blast radius while blast jumping"
	 *
	 * 
	 *
	 * Multiplier to fire delay while player is blast-jumping.
	 */
	val rocketjumpAttackrateBonus: ItemAttribute<Float> get() = BaseGunAttributes.rocketjumpAttackrateBonus
	
	/**
	 * In-Game: "+N% faster reload time"
	 *
	 * 
	 *
	 * Used if the gun draws directly from the ammo supply without using a clip.
	 */
	val fasterReloadRate: ItemAttribute<Float> get() = BaseGunAttributes.fasterReloadRate
	
	/**
	 * In-Game: "Overrides the projectile fired from the weapon. Takes values from 1 to 26, each representing a different projectile, and not all projectiles work on all weapons"
	 *
	 * 
	 *
	 * If unset, uses the weapon's default projectile type.
	 */
	val overrideProjectileType: ItemAttribute<TFProjectileType> get() = BaseGunAttributes.overrideProjectileType
	
	/**
	 * In-Game: "Per Shot: -N ammo"
	 *
	 * 
	 *
	 * How much ammo is used per shot. If 0, uses default.
	 */
	val ammoPerShot: ItemAttribute<Int> get() = BaseGunAttributes.ammoPerShot
	
	/**
	 * In-Game: "+N degrees random projectile deviation"
	 *
	 * 
	 *
	 * Used when firing pipe bombs.
	 */
	val projectileSpreadAnglePenalty: ItemAttribute<Float> get() = BaseGunAttributes.projectileSpreadAnglePenalty
	
	/**
	 * Bonus:
	 *
	 * 	- In-Game: "+N% projectile range"
	 *
	 * 
	 *
	 * Penalty:
	 *
	 * 	- In-Game: "N% projectile range"
	 *
	 * 
	 *
	 * Used when firing any projectile, including pipe bombs.
	 */
	val projectileRange: ItemAttribute<Float> get() = BaseGunAttributes.projectileRange
	
	/**
	 * 
	 *
	 * Don't spin loch n load pills.
	 */
	val grenadeNoSpin: ItemAttribute<Boolean> get() = BaseGunAttributes.grenadeNoSpin
	
	/**
	 * In-Game: "Projectiles penetrate enemy players"
	 *
	 * 
	 *
	 * Also on WeaponBase, but noted here because it's specifically used in Gun's "fire arrow" logic.
	 */
	val projectilePenetration: ItemAttribute<Boolean> get() = BaseGunAttributes.projectilePenetration
	
	/**
	 * In-Game: "Bullets penetrate +N enemies"
	 *
	 * 
	 *
	 * Also on WeaponBase, but noted here because it's specifically used in Gun's "fire arrow" logic.
	 */
	val projectilePenetrationHeavy: ItemAttribute<Boolean> get() = BaseGunAttributes.projectilePenetrationHeavy
	
	/**
	 * Bonus:
	 *
	 * 	- In-Game: "N% more accurate"
	 *
	 * 
	 *
	 * Penalty:
	 *
	 * 	- In-Game: "N% less accurate"
	 *
	 * 
	 *
	 * Modifies bullet spread.
	 */
	val weaponSpread: ItemAttribute<Float> get() = BaseGunAttributes.weaponSpread
	
	/**
	 * In-Game: "Weapon spread increases as health decreases"
	 *
	 * 
	 *
	 * Multiplier applied to bullet spread as health gets lower.
	 */
	val multSpreadAsHealthDecreases: ItemAttribute<Float> get() = BaseGunAttributes.multSpreadAsHealthDecreases
	
	/**
	 * In-Game: "Successive shots become less accurate"
	 *
	 * 
	 *
	 * Scales weapon spread when firing consecutive shots, like the _New_ Panic Attack.
	 */
	val spreadIncreasesOnConsecutiveShots: ItemAttribute<Float> get() = BaseGunAttributes.spreadIncreasesOnConsecutiveShots
	
	/**
	 * In-Game: "+N% damage bonus while disguised"
	 *
	 * 
	 *
	 * When disguised (only checks if the player has the condition, doesn't check class), multiply damage by this amount.
	 */
	val damageBonusWhileDisguised: ItemAttribute<Float> get() = BaseGunAttributes.damageBonusWhileDisguised
	
	/**
	 * In-Game: "Gains a damage bonus as rage increases, up to N%"
	 *
	 * 
	 *
	 * If you're a Soldier or Pyro, increases damage by `(n - 1) * (rage gauge proportion)`.
	 */
	val rageDamageBoost: ItemAttribute<Float> get() = BaseGunAttributes.rageDamageBoost
	
	/**
	 * In-Game: "While a medic is healing you, this weapon's damage is increased by N%"
	 *
	 * 
	 *
	 * Multiply damage by this value once for each healer you have. (with 2 healers, that's `bonus * bonus`, exponential).
	 */
	val medicHealedDamageBonus: ItemAttribute<Float> get() = BaseGunAttributes.medicHealedDamageBonus
	
	/**
	 * In-Game: "Accuracy scales damage"
	 *
	 * 
	 *
	 * If the projectile being fired is a bullet, multiply damage by your hit ratio over the past few seconds.
	 */
	val accuracyScalesDamage: ItemAttribute<Float> get() = BaseGunAttributes.accuracyScalesDamage
	
	/**
	 * 
	 *
	 * By default, all guns have perfect accuracy on the first shot, unless this is set.
	 */
	val multSpreadScaleFirstShot: ItemAttribute<Float> get() = BaseGunAttributes.multSpreadScaleFirstShot
	
	/**
	 * In-Game: "Fires a wide, fixed shot pattern"
	 *
	 * 
	 *
	 * Enables fixed weapon spread on the weapon as though `tf_use_fixed_weaponspreads` were set.
	 */
	val fixedWeaponSpread: ItemAttribute<Boolean> get() = BaseGunAttributes.fixedWeaponSpread
	
	/**
	 * In-Game: "Attacks pierce damage resistance effects and bonuses"
	 *
	 * 
	 */
	val dmgPiercesResistsAbsorbs: ItemAttribute<Boolean> get() = BaseGunAttributes.dmgPiercesResistsAbsorbs

   
}

