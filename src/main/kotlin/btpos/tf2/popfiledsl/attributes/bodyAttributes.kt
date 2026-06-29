package btpos.tf2.popfiledsl.attributes

import btpos.tf2.popfiledsl.modeling.IKeyValueMap
import btpos.tf2.popfiledsl.modeling.delegate
import btpos.tf2.popfiledsl.serialization.VDFStringLiteral.Companion.literal

class OverhealAttributes(val _attr: IKeyValueMap) {
	/**
	 * +N% max overheal
	 *
	 * percentage
	 */
	val overhealBonus: Double? by _attr.delegate("overheal bonus".literal())
	
	/**
	 * N% shorter overheal time
	 *
	 * inverted_percentage
	 */
	val overhealDecayPenalty: Double? by _attr.delegate("overheal decay penalty".literal())
	
	
	
	/**
	 * +N% longer overheal time
	 *
	 * inverted_percentage
	 */
	val overhealDecayBonus: Double? by _attr.delegate("overheal decay bonus".literal())
	
	/**
	 * Overheal bonus doesn't decay
	 *
	 * percentage
	 */
	val overhealDecayDisabled: Double? by _attr.delegate("overheal decay disabled".literal())
}

class HealingReceivedAttributes(val _attr: IKeyValueMap) {
	/**
	 * N% health from healers on wearer
	 *
	 * percentage
	 */
	val healthFromHealersReduced: Double? by _attr.delegate("health from healers reduced".literal())
	
	/**
	 * +N% health from healers on wearer
	 *
	 * percentage
	 */
	val healthFromHealersIncreased: Double? by _attr.delegate("health from healers increased".literal())
	
}

class MovementAttributes(val _attr: IKeyValueMap) {
	/**
	 * Disables double jump
	 *
	 * additive
	 */
	val noDoubleJump: Int? by _attr.delegate("no double jump".literal())
	
	/**
	 * N% slower move speed on wearer
	 *
	 * inverted_percentage
	 */
	val moveSpeedPenalty: Double? by _attr.delegate("move speed penalty".literal())
	
	
	/**
	 * +N% faster move speed on wearer
	 *
	 * percentage
	 */
	val moveSpeedBonus: Double? by _attr.delegate("move speed bonus".literal())
}

class MiscBodyAttributes(val _attr: IKeyValueMap) {
	/**
	 * Wearer cannot ignite
	 *
	 * additive
	 */
	val fireRetardant: Boolean? by _attr.delegate("fire retardant".literal())
	
}

class HealthRelatedAttributes(val _attr: IKeyValueMap) {
	/**
	 * +N health regenerated per second on wearer
	 *
	 * additive
	 */
	val healthRegen: Int? by _attr.delegate("health regen".literal())
	
	/**
	 * +N max health on wearer
	 *
	 * additive
	 */
	val maxHealthAdditiveBonus: Int? by _attr.delegate("max health additive bonus".literal())
	
}

class PushForceAttributes(val _attr: IKeyValueMap) {
	/**
	 * +N% self damage force
	 *
	 * percentage
	 */
	val selfDmgPushForceIncreased: Double? by _attr.delegate("self dmg push force increased".literal())
	
	/**
	 * N% self damage force
	 *
	 * percentage
	 */
	val selfDmgPushForceDecreased: Double? by _attr.delegate("self dmg push force decreased".literal())
	
}

class DamageTakenAttributes(val _attr: IKeyValueMap) {
	/**
	 * +N% fire damage resistance on wearer
	 *
	 * inverted_percentage
	 */
	val dmgTakenFromFireReduced: Double? by _attr.delegate("dmg taken from fire reduced".literal())
	
	/**
	 * N% fire damage vulnerability on wearer
	 *
	 * percentage
	 */
	val dmgTakenFromFireIncreased: Double? by _attr.delegate("dmg taken from fire increased".literal())
	
	/**
	 * +N% critical hit damage resistance on wearer
	 *
	 * inverted_percentage
	 */
	val dmgTakenFromCritReduced: Double? by _attr.delegate("dmg taken from crit reduced".literal())
	
	/**
	 * N% critical hit damage vulnerability on wearer
	 *
	 * percentage
	 */
	val dmgTakenFromCritIncreased: Double? by _attr.delegate("dmg taken from crit increased".literal())
	
	/**
	 * +N% explosive damage resistance on wearer
	 *
	 * inverted_percentage
	 */
	val dmgTakenFromBlastReduced: Double? by _attr.delegate("dmg taken from blast reduced".literal())
	
	/**
	 * N% explosive damage vulnerability on wearer
	 *
	 * percentage
	 */
	val dmgTakenFromBlastIncreased: Double? by _attr.delegate("dmg taken from blast increased".literal())
	
	/**
	 * +N% bullet damage resistance on wearer
	 *
	 * inverted_percentage
	 */
	val dmgTakenFromBulletsReduced: Double? by _attr.delegate("dmg taken from bullets reduced".literal())
	
	/**
	 * N% bullet damage vulnerability on wearer
	 *
	 * percentage
	 */
	val dmgTakenFromBulletsIncreased: Double? by _attr.delegate("dmg taken from bullets increased".literal())
	
}