package btpos.source.vdfdsl.tf2.itemattributes

import btpos.source.vdfdsl.modeling.*
import btpos.source.vdfdsl.serialization.codecs.*



interface BaseMeleeAttributes : btpos.source.vdfdsl.tf2.itemattributes.WeaponBaseAttributes, btpos.source.vdfdsl.tf2.itemattributes.IBlockScoped {
	companion object : BaseMeleeAttributes
	
	/**
	 * In-Game: "You are Marked-For-Death while active, and for short period after switching weapons"
	 *
	 * 
	 *
	 * Marked for death when switching to weapon.
	 */
	context(attrs: btpos.source.vdfdsl.modeling.IKeyValueMap)
	var selfMarkForDeath: Boolean?
		get() = attrs.getTyped("self mark for death", _root_ide_package_.btpos.source.vdfdsl.serialization.codecs.BinaryIntCodec)
		set(value) = attrs.setNullable("self mark for death", value, _root_ide_package_.btpos.source.vdfdsl.serialization.codecs.BinaryIntCodec)
	
	/**
	 * In-Game: "This Weapon has a large melee range and deploys and holsters slower"
	 *
	 * 
	 *
	 * If true, make weapon deploy and holster 75% slower.
	 *
	 * If true, set swing range to 72, else 48.
	 */
	context(attrs: btpos.source.vdfdsl.modeling.IKeyValueMap)
	override var isASword: Boolean?
		get() = super.isASword
		set(value) { super.isASword = value }
	
	/**
	 * 
	 *
	 * Multiplier applied to the bounding box of the swing to detect if a player is inside it.
	 *
	 * Yes, it DOES use a bounding box.
	 */
	context(attrs: btpos.source.vdfdsl.modeling.IKeyValueMap)
	var meleeBoundsMultiplier: Float?
		get() = attrs.getTyped("melee bounds multiplier")
		set(value) = attrs.setNullable("melee bounds multiplier", value)
	
	/**
	 * In-Game: "Damage removes Sappers"
	 *
	 * 
	 *
	 * Damage sappers with swing.
	 */
	context(attrs: btpos.source.vdfdsl.modeling.IKeyValueMap)
	var damageAppliesToSappers: Int?
		get() = attrs.getTyped("damage applies to sappers")
		set(value) = attrs.setNullable("damage applies to sappers", value)
	
	/**
	 * In-Game: "On Hit Teammate: Boosts both players' speed for several seconds"
	 *
	 * 
	 *
	 * Applies speed boost cond to yourself and the teammate you hit.
	 */
	context(attrs: btpos.source.vdfdsl.modeling.IKeyValueMap)
	var speedBuffAlly: Boolean?
		get() = attrs.getTyped("speed buff ally", _root_ide_package_.btpos.source.vdfdsl.serialization.codecs.BinaryIntCodec)
		set(value) = attrs.setNullable("speed buff ally", value, _root_ide_package_.btpos.source.vdfdsl.serialization.codecs.BinaryIntCodec)
	
	/**
	 * In-Game: "On Miss: Hit yourself. Idiot."
	 *
	 * 
	 *
	 * Idiot.
	 */
	context(attrs: btpos.source.vdfdsl.modeling.IKeyValueMap)
	var hitSelfOnMiss: Boolean?
		get() = attrs.getTyped("hit self on miss", _root_ide_package_.btpos.source.vdfdsl.serialization.codecs.BinaryIntCodec)
		set(value) = attrs.setNullable("hit self on miss", value, _root_ide_package_.btpos.source.vdfdsl.serialization.codecs.BinaryIntCodec)
	
	/**
	 * In-Game: "Gain a speed boost when you hit an enemy player"
	 *
	 * 
	 *
	 * Used as arg to addcond speedboost.
	 */
	context(attrs: btpos.source.vdfdsl.modeling.IKeyValueMap)
	var speedBoostOnHitEnemy: Int?
		get() = attrs.getTyped("speed_boost_on_hit_enemy")
		set(value) = attrs.setNullable("speed_boost_on_hit_enemy", value)
	
	/**
	 * In-Game: "Always critical hit from behind"
	 *
	 * 
	 */
	context(attrs: btpos.source.vdfdsl.modeling.IKeyValueMap)
	var critFromBehind: Boolean?
		get() = attrs.getTyped("crit from behind", _root_ide_package_.btpos.source.vdfdsl.serialization.codecs.BinaryIntCodec)
		set(value) = attrs.setNullable("crit from behind", value, _root_ide_package_.btpos.source.vdfdsl.serialization.codecs.BinaryIntCodec)
	
	/**
	 * In-Game: "Critical hit forces victim to laugh"
	 *
	 * 
	 */
	context(attrs: btpos.source.vdfdsl.modeling.IKeyValueMap)
	var critForcesVictimToLaugh: Boolean?
		get() = attrs.getTyped("crit forces victim to laugh", _root_ide_package_.btpos.source.vdfdsl.serialization.codecs.BinaryIntCodec)
		set(value) = attrs.setNullable("crit forces victim to laugh", value, _root_ide_package_.btpos.source.vdfdsl.serialization.codecs.BinaryIntCodec)
	
	/**
	 * In-Game: "On Hit: Force enemies to laugh who are also wearing this item"
	 *
	 * 
	 *
	 * Force enemies to laugh if they're also wielding this weapon.
	 */
	context(attrs: btpos.source.vdfdsl.modeling.IKeyValueMap)
	var tickleEnemiesWieldingSameWeapon: Boolean?
		get() = attrs.getTyped("tickle enemies wielding same weapon", _root_ide_package_.btpos.source.vdfdsl.serialization.codecs.BinaryIntCodec)
		set(value) = attrs.setNullable("tickle enemies wielding same weapon", value, _root_ide_package_.btpos.source.vdfdsl.serialization.codecs.BinaryIntCodec)
	
	/**
	 * In-Game: "Critical hits do no damage"
	 *
	 * 
	 */
	context(attrs: btpos.source.vdfdsl.modeling.IKeyValueMap)
	var critDoesNoDamage: Boolean?
		get() = attrs.getTyped("crit does no damage", _root_ide_package_.btpos.source.vdfdsl.serialization.codecs.BinaryIntCodec)
		set(value) = attrs.setNullable("crit does no damage", value, _root_ide_package_.btpos.source.vdfdsl.serialization.codecs.BinaryIntCodec)
	
	/**
	 * In-Game: "N% increase in damage when health <50% of max"
	 *
	 * 
	 *
	 * If health < 50%, apply mult.
	 */
	context(attrs: btpos.source.vdfdsl.modeling.IKeyValueMap)
	var dmgBonusWhileHalfDead: Float?
		get() = attrs.getTyped("dmg bonus while half dead")
		set(value) = attrs.setNullable("dmg bonus while half dead", value)
	
	/**
	 * In-Game: "N% decrease in damage when health >50% of max"
	 *
	 * 
	 *
	 * If health >= 50%, apply mult.
	 */
	context(attrs: btpos.source.vdfdsl.modeling.IKeyValueMap)
	var dmgPenaltyWhileHalfAlive: Float?
		get() = attrs.getTyped("dmg penalty while half alive")
		set(value) = attrs.setNullable("dmg penalty while half alive", value)
}

