package btpos.tf2.popfiledsl.tf2.itemattributes

import btpos.tf2.popfiledsl.modeling.*
import btpos.tf2.popfiledsl.serialization.codecs.*


/**
 * Items: The Wrangler, Festive Wrangler, The Giger Counter
 * 
 */
interface BaseGunAttributes : WeaponBaseAttributes {
	companion object : BaseGunAttributes
	
	/**
	 * If unset, uses the weapon's default projectile type.
	 * 
	 * Else use a numbered [ProjectileType]
	 * 
	 */
	context(attrs: IKeyValueMap)
	var overrideProjectileType: Int?
		get() = attrs.getTyped("override projectile type")
		set(value) = attrs.setNullable("override projectile type", value)
	
	/**
	 * How much ammo is used per shot. If 0, uses default.
	 * 
	 */
	context(attrs: IKeyValueMap)
	var modAmmoPerShot: Int?
		get() = attrs.getTyped("mod ammo per shot")
		set(value) = attrs.setNullable("mod ammo per shot", value)
	
	/**
	 * Used when firing any projectile, including pipe bombs
	 * 
	 * 
	 * Bonus:
	 * 	- Value type: percentage
	 * 	- +N% projectile range
	 * 
	 * Penalty:
	 * 	- Value type: percentage
	 * 	- N% projectile range
	 */
	val projectileRange get() = BonusPenalty<Float, Float>("Projectile range increased", "Projectile range decreased")
	
	/**
	 * Don't spin loch n load pills
	 * 
	 */
	context(attrs: IKeyValueMap)
	var grenadeNoSpin: Boolean?
		get() = attrs.getTyped("grenade no spin", BinaryIntCodec)
		set(value) = attrs.setNullable("grenade no spin", value, BinaryIntCodec)
	
	/**
	 * How many players your "projectile" (*including bullets*) should penetrate.
	 * 
	 * 
	 * Also on WeaponBase, but noted here because it's specifically used in gun's "fire arrow" logic.
	 * 
	 */
	override context(attrs: IKeyValueMap)
	var projectilePenetration: Int?
		get() = attrs.getTyped("projectile penetration")
		set(value) = attrs.setNullable("projectile penetration", value)
	
	/**
	 * How many players your "projectile" (*including bullets*) should penetrate.
	 * 
	 * 
	 * Also on WeaponBase, but noted here because it's specifically used in gun's "fire arrow" logic.
	 * 
	 */
	override context(attrs: IKeyValueMap)
	var projectilePenetrationHeavy: Int?
		get() = attrs.getTyped("projectile penetration heavy")
		set(value) = attrs.setNullable("projectile penetration heavy", value)
	
	/**
	 * Modifies bullet spread.
	 * 
	 * 
	 * Bonus:
	 * 	- Value type: inverted_percentage
	 * 	- N% more accurate
	 * 
	 * Penalty:
	 * 	- Value type: percentage
	 * 	- N% less accurate
	 */
	val spread get() = BonusPenalty<Float, Float>("weapon spread bonus", "spread penalty")
	
	/**
	 * Value type: inverted_percentage
	 * 
	 * Multiplier applied to bullet spread as health gets lower.
	 * 
	 */
	context(attrs: IKeyValueMap)
	var panicAttackNegative: Float?
		get() = attrs.getTyped("panic_attack_negative")
		set(value) = attrs.setNullable("panic_attack_negative", value)
	
	/**
	 * Value type: additive_percentage
	 * 
	 * Scales weapon spread when firing consecutive shots, like the _New_ Panic Attack.
	 * 
	 */
	context(attrs: IKeyValueMap)
	var multSpreadScalesConsecutive: Float?
		get() = attrs.getTyped("mult_spread_scales_consecutive")
		set(value) = attrs.setNullable("mult_spread_scales_consecutive", value)
	
	/**
	 * Value type: percentage
	 * 
	 * When disguised (only checks if the player has the condition, doesn't check class), multiply damage by this amount.
	 * 
	 */
	context(attrs: IKeyValueMap)
	var damageBonusWhileDisguised: Float?
		get() = attrs.getTyped("damage bonus while disguised")
		set(value) = attrs.setNullable("damage bonus while disguised", value)
	
	/**
	 * Value type: percentage
	 * 
	 * If the projectile being fired is a bullet, multiply damage by your hit ratio over the past few seconds.
	 * 
	 */
	context(attrs: IKeyValueMap)
	var accuracyScalesDamage: Float?
		get() = attrs.getTyped("accuracy scales damage")
		set(value) = attrs.setNullable("accuracy scales damage", value)
	
	/**
	 * Enables fixed weapon spread on the weapon as though `tf_use_fixed_weaponspreads` were set.
	 * 
	 */
	context(attrs: IKeyValueMap)
	var fixedShotPattern: Boolean?
		get() = attrs.getTyped("fixed_shot_pattern", BinaryIntCodec)
		set(value) = attrs.setNullable("fixed_shot_pattern", value, BinaryIntCodec)
	
	
	context(attrs: IKeyValueMap)
	var dmgPiercesResistsAbsorbs: Boolean?
		get() = attrs.getTyped("dmg pierces resists absorbs", BinaryIntCodec)
		set(value) = attrs.setNullable("dmg pierces resists absorbs", value, BinaryIntCodec)
}

inline operator fun BaseGunAttributes.invoke(scope: BaseGunAttributes.() -> Unit) {
	this.apply(scope)
}

