package btpos.source.vdfdsl.tf2.itemattributes

import btpos.source.vdfdsl.modeling.*
import btpos.source.vdfdsl.serialization.codecs.*
import btpos.source.vdfdsl.tf2.itemattributes.impl.*
import java.util.*

/**
 * Items: The Wrangler, Festive Wrangler, The Giger Counter
 */
interface BaseGunAttributes : WeaponBaseAttributes, IBlockScoped {
	companion object : BaseGunAttributes
	
	/**
	 * 
	 *
	 * Multiplier applied to base fire delay.
	 *
	 * Checked on player.
	 */
	context(attrs: IKeyValueMap)
	var halloweenFireRateBonus: Number?
		get() = attrs.getTyped("halloween fire rate bonus")
		set(value) = attrs.setNullable("halloween fire rate bonus", value)
	
	/**
	 * In-Game: "Fire rate increases as health decreases"
	 *
	 * 
	 *
	 * Used with the _old_ Panic Attack.
	 */
	context(attrs: IKeyValueMap)
	var fireRateBonusWithReducedHealth: Number?
		get() = attrs.getTyped("fire rate bonus with reduced health")
		set(value) = attrs.setNullable("fire rate bonus with reduced health", value)
	
	/**
	 * In-Game: "Increased attack speed and smaller blast radius while blast jumping"
	 *
	 * 
	 *
	 * Multiplier to fire delay while player is blast-jumping.
	 */
	context(attrs: IKeyValueMap)
	var rocketjumpAttackrateBonus: Number?
		get() = attrs.getTyped("rocketjump attackrate bonus")
		set(value) = attrs.setNullable("rocketjump attackrate bonus", value)
	
	/**
	 * In-Game: "+N% faster reload time"
	 *
	 * 
	 *
	 * This is what's used for weapons that draw directly from reserve ammo, like the flare gun and sniper rifle.
	 *
	 * Used if the gun draws directly from the ammo supply without using a clip.
	 */
	context(attrs: IKeyValueMap)
	override var fasterReloadRate: Number?
		get() = super.fasterReloadRate
		set(value) { super.fasterReloadRate = value }
	
	/**
	 * In-Game: "Overrides the projectile fired from the weapon. Takes values from 1 to 26, each representing a different projectile, and not all projectiles work on all weapons"
	 *
	 * 
	 *
	 * If unset, uses the weapon's default projectile type.
	 */
	context(attrs: IKeyValueMap)
	var overrideProjectileType: Int?
		get() = attrs.getTyped("override projectile type")
		set(value) = attrs.setNullable("override projectile type", value)
	
	/**
	 * In-Game: "Per Shot: -N ammo"
	 *
	 * 
	 *
	 * How much ammo is used per shot. If 0, uses default.
	 */
	context(attrs: IKeyValueMap)
	var ammoPerShot: Int?
		get() = attrs.getTyped("mod ammo per shot")
		set(value) = attrs.setNullable("mod ammo per shot", value)
	
	/**
	 * In-Game: "+N degrees random projectile deviation"
	 *
	 * 
	 *
	 * Does not include bullets.
	 *
	 * Used when firing pipe bombs.
	 */
	context(attrs: IKeyValueMap)
	override var projectileSpreadAnglePenalty: Int?
		get() = super.projectileSpreadAnglePenalty
		set(value) { super.projectileSpreadAnglePenalty = value }
	
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
	val projectileRange get() = BonusPenalty<Number, Number>("Projectile range increased", "Projectile range decreased")
	
	/**
	 * 
	 *
	 * Don't spin loch n load pills.
	 */
	context(attrs: IKeyValueMap)
	var grenadeNoSpin: Boolean?
		get() = attrs.getTyped("grenade no spin", BinaryIntCodec)
		set(value) = attrs.setNullable("grenade no spin", value, BinaryIntCodec)
	
	/**
	 * In-Game: "Projectiles penetrate enemy players"
	 *
	 * 
	 *
	 * How many players your "projectile" (*including bullets*) should penetrate.
	 *
	 * Also on WeaponBase, but noted here because it's specifically used in Gun's "fire arrow" logic.
	 */
	context(attrs: IKeyValueMap)
	override var projectilePenetration: Boolean?
		get() = super.projectilePenetration
		set(value) { super.projectilePenetration = value }
	
	/**
	 * In-Game: "Bullets penetrate +N enemies"
	 *
	 * 
	 *
	 * How many players your "projectile" (*including bullets*) should penetrate.
	 *
	 * Also on WeaponBase, but noted here because it's specifically used in Gun's "fire arrow" logic.
	 */
	context(attrs: IKeyValueMap)
	override var projectilePenetrationHeavy: Boolean?
		get() = super.projectilePenetrationHeavy
		set(value) { super.projectilePenetrationHeavy = value }
	
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
	val weaponSpread get() = BonusPenalty<Number, Number>("weapon spread bonus", "spread penalty")
	
	/**
	 * In-Game: "Weapon spread increases as health decreases"
	 *
	 * 
	 *
	 * Multiplier applied to bullet spread as health gets lower.
	 */
	context(attrs: IKeyValueMap)
	var multSpreadAsHealthDecreases: Number?
		get() = attrs.getTyped("panic_attack_negative")
		set(value) = attrs.setNullable("panic_attack_negative", value)
	
	/**
	 * In-Game: "Successive shots become less accurate"
	 *
	 * 
	 *
	 * Scales weapon spread when firing consecutive shots, like the _New_ Panic Attack.
	 */
	context(attrs: IKeyValueMap)
	var spreadIncreasesOnConsecutiveShots: Number?
		get() = attrs.getTyped("mult_spread_scales_consecutive")
		set(value) = attrs.setNullable("mult_spread_scales_consecutive", value)
	
	/**
	 * In-Game: "+N% damage bonus while disguised"
	 *
	 * 
	 *
	 * When disguised (only checks if the player has the condition, doesn't check class), multiply damage by this amount.
	 */
	context(attrs: IKeyValueMap)
	var damageBonusWhileDisguised: Number?
		get() = attrs.getTyped("damage bonus while disguised")
		set(value) = attrs.setNullable("damage bonus while disguised", value)
	
	/**
	 * In-Game: "Gains a damage bonus as rage increases, up to N%"
	 *
	 * 
	 *
	 * If you're a Soldier or Pyro, increases damage by `(n - 1) * (rage gauge proportion)`.
	 */
	context(attrs: IKeyValueMap)
	var rageDamageBoost: Number?
		get() = attrs.getTyped("mod rage damage boost")
		set(value) = attrs.setNullable("mod rage damage boost", value)
	
	/**
	 * In-Game: "While a medic is healing you, this weapon's damage is increased by N%"
	 *
	 * 
	 *
	 * Multiply damage by this value once for each healer you have. (with 2 healers, that's `bonus * bonus`, exponential).
	 */
	context(attrs: IKeyValueMap)
	var medicHealedDamageBonus: Number?
		get() = attrs.getTyped("mod medic healed damage bonus")
		set(value) = attrs.setNullable("mod medic healed damage bonus", value)
	
	/**
	 * In-Game: "Accuracy scales damage"
	 *
	 * 
	 *
	 * If the projectile being fired is a bullet, multiply damage by your hit ratio over the past few seconds.
	 */
	context(attrs: IKeyValueMap)
	var accuracyScalesDamage: Number?
		get() = attrs.getTyped("accuracy scales damage")
		set(value) = attrs.setNullable("accuracy scales damage", value)
	
	/**
	 * 
	 *
	 * By default, all guns have perfect accuracy on the first shot, unless this is set.
	 */
	context(attrs: IKeyValueMap)
	var multSpreadScaleFirstShot: Int?
		get() = attrs.getTyped("mult_spread_scale_first_shot")
		set(value) = attrs.setNullable("mult_spread_scale_first_shot", value)
	
	/**
	 * In-Game: "Fires a wide, fixed shot pattern"
	 *
	 * 
	 *
	 * Enables fixed weapon spread on the weapon as though `tf_use_fixed_weaponspreads` were set.
	 */
	context(attrs: IKeyValueMap)
	var fixedWeaponSpread: Boolean?
		get() = attrs.getTyped("fixed_shot_pattern", BinaryIntCodec)
		set(value) = attrs.setNullable("fixed_shot_pattern", value, BinaryIntCodec)
	
	/**
	 * In-Game: "Attacks pierce damage resistance effects and bonuses"
	 *
	 * 
	 */
	context(attrs: IKeyValueMap)
	override var dmgPiercesResistsAbsorbs: Boolean?
		get() = super.dmgPiercesResistsAbsorbs
		set(value) { super.dmgPiercesResistsAbsorbs = value }
}

