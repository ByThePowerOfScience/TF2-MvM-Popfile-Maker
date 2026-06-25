package btpos.tf2.popfiledsl.tf2.itemattributes

import btpos.tf2.popfiledsl.modeling.*
import btpos.tf2.popfiledsl.serialization.codecs.*


/**
 * Items: TF_WEAPON_MEDIGUN, The Kritzkrieg, Upgradeable TF_WEAPON_MEDIGUN, The Quick-Fix, Festive Medigun 2011, Silver Botkiller Medi Gun Mk.I, Gold Botkiller Medi Gun Mk.I, Rust Botkiller Medi Gun Mk.I, Blood Botkiller Medi Gun Mk.I, Carbonado Botkiller Medi Gun Mk.I, Diamond Botkiller Medi Gun Mk.I, Silver Botkiller Medi Gun Mk.II, Gold Botkiller Medi Gun Mk.II, The Vaccinator
 * 
 */
abstract class MedigunAttributes : BaseGunAttributes() {
	companion object : MedigunAttributes() {
		operator fun invoke(scope: MedigunAttributes.Companion.() -> Unit) {
			this.apply(scope)
		}
	}
	
	/**
	 * 
	 * Bonus:
	 * 	Value type: percentage
	 * 	
	 * 
	 * Penalty:
	 * 	Value type: percentage
	 * 	
	 */
	val healRatePenalty = BonusPenalty<Float, Float>("heal rate bonus", "heal rate penalty")
	
	/**
	 * On player
	 * Percentage saved on death or dropping weapon (e.g. `25` = 25% uber)
	 */
	context(attrs: IKeyValueMap)
	var preserveUbercharge: Int?
		get() = attrs.getTyped("preserve ubercharge")
		set(value) = attrs.setNullable("preserve ubercharge", value)
	
	
	context(attrs: IKeyValueMap)
	var healingMastery: Int?
		get() = attrs.getTyped("healing mastery")
		set(value) = attrs.setNullable("healing mastery", value)
	
	/**
	 * 
	 * Ubercharge type. Each resist uber also has its own entry
	 */
	val medigunChargeIsCritBoost get() = MedigunChargeIsCritBoostAttributes
	
	/**
	 * Bonuses are additive, penalties are percentage
	 * 
	 * Bonus:
	 * 	Value type: percentage
	 * 	
	 * 
	 * Penalty:
	 * 	Value type: inverted_percentage
	 * 	
	 */
	val overhealPenalty = BonusPenalty<Float, Float>("overheal bonus", "overheal penalty")
	
	/**
	 * 
	 * Bonus:
	 * 	Value type: inverted_percentage
	 * 	
	 * 
	 * Penalty:
	 * 	Value type: inverted_percentage
	 * 	
	 */
	val overhealDecayPenalty = BonusPenalty<Float, Float>("overheal decay bonus", "overheal decay penalty")
	
	/**
	 * On owner
	 * Overheal bonus = overheal bonus + overhealexpert/4 or just overheal bonus, whichever is higher
	 * decay mult is same but divided by 2
	 */
	context(attrs: IKeyValueMap)
	var overhealExpert: Int?
		get() = attrs.getTyped("overheal expert")
		set(value) = attrs.setNullable("overheal expert", value)
	
	/**
	 * Value type: percentage
	 * 
	 * On owner
	 */
	context(attrs: IKeyValueMap)
	var uberchargeOverhealRatePenalty: Float?
		get() = attrs.getTyped("ubercharge overheal rate penalty")
		set(value) = attrs.setNullable("ubercharge overheal rate penalty", value)
	
	/**
	 * On owner
	 * 
	 * Bonus:
	 * 	Value type: percentage
	 * 	
	 * 
	 * Penalty:
	 * 	Value type: percentage
	 * 	
	 */
	val uberchargeRatePenalty = BonusPenalty<Float, Float>("ubercharge rate bonus", "ubercharge rate penalty")
	
	/**
	 * On owner
	 */
	context(attrs: IKeyValueMap)
	var uberDurationBonus: Int?
		get() = attrs.getTyped("uber duration bonus")
		set(value) = attrs.setNullable("uber duration bonus", value)
	
	/**
	 * On owner
	 * This is your shield level
	 */
	context(attrs: IKeyValueMap)
	var generateRageOnHeal: Int?
		get() = attrs.getTyped("generate rage on heal")
		set(value) = attrs.setNullable("generate rage on heal", value)
}

/**
 * 
 * Ubercharge type. Each resist uber also has its own entry
 */
object MedigunChargeIsCritBoostAttributes {
	operator fun invoke(scope: MedigunChargeIsCritBoostAttributes.() -> Unit) {
		this.apply(scope)
	}
	
	/**
	 * ÜberCharge grants 100% critical chance
	 * 
	 * Ubercharge type. Each resist uber also has its own entry
	 */
	context(attrs: IKeyValueMap)
	var medigunChargeIsCritBoost: Int?
		get() = attrs.getTyped("medigun charge is crit boost")
		set(value) = attrs.setNullable("medigun charge is crit boost", value)
	
	/**
	 * Press your reload key to cycle through resist types. While healing, provides you and your target with a constant 10% resistance to the selected damage type.
	 * 
	 * Ubercharge type. Each resist uber also has its own entry
	 */
	context(attrs: IKeyValueMap)
	var medigunChargeIsResists: Int?
		get() = attrs.getTyped("medigun charge is resists")
		set(value) = attrs.setNullable("medigun charge is resists", value)
}

