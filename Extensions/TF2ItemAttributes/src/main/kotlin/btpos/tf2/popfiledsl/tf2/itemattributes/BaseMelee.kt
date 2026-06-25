package btpos.tf2.popfiledsl.tf2.itemattributes

import btpos.tf2.popfiledsl.modeling.*
import btpos.tf2.popfiledsl.serialization.codecs.*


/**
 * 
 */
interface BaseMeleeAttributes : WeaponBaseAttributes {
	companion object : BaseMeleeAttributes
	
	/**
	 * If true, make weapon deploy and holster 75% slower
	 * 
	 * 
	 * If true, set swing range to 72, else 48
	 * 
	 */
	override context(attrs: IKeyValueMap)
	var isASword: Boolean?
		get() = attrs.getTyped("is_a_sword", BinaryIntCodec)
		set(value) = attrs.setNullable("is_a_sword", value, BinaryIntCodec)
	
	/**
	 * Value type: percentage
	 * 
	 * Multiplier applied to the bounding box of the swing to detect if a player is inside it
	 * 
	 * Yes, it DOES use a bounding box.
	 * 
	 */
	context(attrs: IKeyValueMap)
	var meleeBoundsMultiplier: Float?
		get() = attrs.getTyped("melee bounds multiplier")
		set(value) = attrs.setNullable("melee bounds multiplier", value)
	
	/**
	 * Damage sappers with swing.
	 * 
	 */
	context(attrs: IKeyValueMap)
	var damageAppliesToSappers: Int?
		get() = attrs.getTyped("damage applies to sappers")
		set(value) = attrs.setNullable("damage applies to sappers", value)
	
	/**
	 * Applies speed boost cond to yourself and the teammate you hit
	 * 
	 */
	context(attrs: IKeyValueMap)
	var speedBuffAlly: Boolean?
		get() = attrs.getTyped("speed buff ally", BinaryIntCodec)
		set(value) = attrs.setNullable("speed buff ally", value, BinaryIntCodec)
	
	/**
	 * Idiot.
	 * 
	 */
	context(attrs: IKeyValueMap)
	var hitSelfOnMiss: Boolean?
		get() = attrs.getTyped("hit self on miss", BinaryIntCodec)
		set(value) = attrs.setNullable("hit self on miss", value, BinaryIntCodec)
	
	/**
	 * Used as arg to addcond speedboost
	 * 
	 */
	context(attrs: IKeyValueMap)
	var speedBoostOnHitEnemy: Int?
		get() = attrs.getTyped("speed_boost_on_hit_enemy")
		set(value) = attrs.setNullable("speed_boost_on_hit_enemy", value)
	
	
	context(attrs: IKeyValueMap)
	var critFromBehind: Boolean?
		get() = attrs.getTyped("crit from behind", BinaryIntCodec)
		set(value) = attrs.setNullable("crit from behind", value, BinaryIntCodec)
	
	
	context(attrs: IKeyValueMap)
	var critForcesVictimToLaugh: Boolean?
		get() = attrs.getTyped("crit forces victim to laugh", BinaryIntCodec)
		set(value) = attrs.setNullable("crit forces victim to laugh", value, BinaryIntCodec)
	
	/**
	 * Force enemies to laugh if they're also wielding this weapon.
	 * 
	 */
	context(attrs: IKeyValueMap)
	var tickleEnemiesWieldingSameWeapon: Boolean?
		get() = attrs.getTyped("tickle enemies wielding same weapon", BinaryIntCodec)
		set(value) = attrs.setNullable("tickle enemies wielding same weapon", value, BinaryIntCodec)
	
	
	context(attrs: IKeyValueMap)
	var critDoesNoDamage: Boolean?
		get() = attrs.getTyped("crit does no damage", BinaryIntCodec)
		set(value) = attrs.setNullable("crit does no damage", value, BinaryIntCodec)
	
	/**
	 * Value type: percentage
	 * 
	 * If health < 50%, apply mult.
	 * 
	 */
	context(attrs: IKeyValueMap)
	var dmgBonusWhileHalfDead: Float?
		get() = attrs.getTyped("dmg bonus while half dead")
		set(value) = attrs.setNullable("dmg bonus while half dead", value)
	
	/**
	 * Value type: percentage
	 * 
	 * If health >= 50%, apply mult
	 * 
	 */
	context(attrs: IKeyValueMap)
	var dmgPenaltyWhileHalfAlive: Float?
		get() = attrs.getTyped("dmg penalty while half alive")
		set(value) = attrs.setNullable("dmg penalty while half alive", value)
}

operator fun BaseMeleeAttributes.invoke(scope: BaseMeleeAttributes.() -> Unit) {
	this.apply(scope)
}

