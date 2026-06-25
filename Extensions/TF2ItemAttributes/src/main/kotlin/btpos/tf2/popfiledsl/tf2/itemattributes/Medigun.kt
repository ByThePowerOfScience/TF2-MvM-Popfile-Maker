package btpos.tf2.popfiledsl.tf2.itemattributes

import btpos.tf2.popfiledsl.modeling.*
import btpos.tf2.popfiledsl.serialization.codecs.*


/**
 * Items: TF_WEAPON_MEDIGUN, The Kritzkrieg, Upgradeable TF_WEAPON_MEDIGUN, The Quick-Fix, Festive Medigun 2011, Silver Botkiller Medi Gun Mk.I, Gold Botkiller Medi Gun Mk.I, Rust Botkiller Medi Gun Mk.I, Blood Botkiller Medi Gun Mk.I, Carbonado Botkiller Medi Gun Mk.I, Diamond Botkiller Medi Gun Mk.I, Silver Botkiller Medi Gun Mk.II, Gold Botkiller Medi Gun Mk.II, The Vaccinator
 * 
 */
interface MedigunAttributes : BaseGunAttributes {
	companion object : MedigunAttributes
	
	/**
	 * 
	 * Bonus:
	 * 	- Value type: percentage
	 * 	- +N% heal rate
	 * 
	 * Penalty:
	 * 	- Value type: percentage
	 * 	- N% heal rate
	 */
	val healRatePenalty get() = BonusPenalty<Float, Float>("heal rate bonus", "heal rate penalty")
	
	/**
	 * On player
	 * 
	 * Percentage saved on death or dropping weapon (e.g. `25` = 25% uber)
	 * 
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
	 * Determines medigun type
	 * 
	 */
	context(attrs: IKeyValueMap)
	var fistsHaveRadialBuff: Boolean?
		get() = attrs.getTyped("fists have radial buff", NumberSelectorCodec(1))
		set(value) = attrs.setNullable("fists have radial buff", value, NumberSelectorCodec(1))
	
	/**
	 * Determines medigun type
	 * 
	 */
	context(attrs: IKeyValueMap)
	var setCloakIsFeignDeath: Boolean?
		get() = attrs.getTyped("set cloak is feign death", NumberSelectorCodec(2))
		set(value) = attrs.setNullable("set cloak is feign death", value, NumberSelectorCodec(2))
	
	/**
	 * Determines medigun type
	 * 
	 */
	context(attrs: IKeyValueMap)
	var modBatLaunchesBalls: Boolean?
		get() = attrs.getTyped("mod bat launches balls", NumberSelectorCodec(1))
		set(value) = attrs.setNullable("mod bat launches balls", value, NumberSelectorCodec(1))
	
	/**
	 * Determines medigun type
	 * 
	 */
	context(attrs: IKeyValueMap)
	var sniperNoHeadshots: Boolean?
		get() = attrs.getTyped("sniper no headshots", NumberSelectorCodec(1))
		set(value) = attrs.setNullable("sniper no headshots", value, NumberSelectorCodec(1))
	
	/**
	 * Determines medigun type
	 * 
	 */
	context(attrs: IKeyValueMap)
	var setCloakIsMovementBased: Boolean?
		get() = attrs.getTyped("set cloak is movement based", NumberSelectorCodec(1))
		set(value) = attrs.setNullable("set cloak is movement based", value, NumberSelectorCodec(1))
	
	/**
	 * Determines medigun type
	 * 
	 */
	context(attrs: IKeyValueMap)
	var revolverUseHitLocations: Boolean?
		get() = attrs.getTyped("revolver use hit locations", NumberSelectorCodec(1))
		set(value) = attrs.setNullable("revolver use hit locations", value, NumberSelectorCodec(1))
	
	/**
	 * Determines medigun type
	 * 
	 */
	context(attrs: IKeyValueMap)
	var modShovelDamageBoost: Boolean?
		get() = attrs.getTyped("mod shovel damage boost", NumberSelectorCodec(1))
		set(value) = attrs.setNullable("mod shovel damage boost", value, NumberSelectorCodec(1))
	
	/**
	 * Determines medigun type
	 * 
	 */
	context(attrs: IKeyValueMap)
	var lunchboxAddsMaxhealthBonus: Boolean?
		get() = attrs.getTyped("lunchbox adds maxhealth bonus", NumberSelectorCodec(1))
		set(value) = attrs.setNullable("lunchbox adds maxhealth bonus", value, NumberSelectorCodec(1))
	
	/**
	 * Determines medigun type
	 * 
	 */
	context(attrs: IKeyValueMap)
	var lunchboxAddsMinicrits: Boolean?
		get() = attrs.getTyped("lunchbox adds minicrits", NumberSelectorCodec(2))
		set(value) = attrs.setNullable("lunchbox adds minicrits", value, NumberSelectorCodec(2))
	
	/**
	 * Determines medigun type
	 * 
	 */
	context(attrs: IKeyValueMap)
	var modShovelSpeedBoost: Boolean?
		get() = attrs.getTyped("mod shovel speed boost", NumberSelectorCodec(2))
		set(value) = attrs.setNullable("mod shovel speed boost", value, NumberSelectorCodec(2))
	
	/**
	 * Determines medigun type
	 * 
	 */
	context(attrs: IKeyValueMap)
	var modBatLaunchesOrnaments: Boolean?
		get() = attrs.getTyped("mod bat launches ornaments", NumberSelectorCodec(2))
		set(value) = attrs.setNullable("mod bat launches ornaments", value, NumberSelectorCodec(2))
	
	/**
	 * Determines medigun type
	 * 
	 */
	context(attrs: IKeyValueMap)
	var setIcicleKnifeMode: Boolean?
		get() = attrs.getTyped("set icicle knife mode", NumberSelectorCodec(3))
		set(value) = attrs.setNullable("set icicle knife mode", value, NumberSelectorCodec(3))
	
	/**
	 * Determines medigun type
	 * 
	 */
	context(attrs: IKeyValueMap)
	var modFlaregunFiresPelletsWithKnockback: Boolean?
		get() = attrs.getTyped("mod flaregun fires pellets with knockback", NumberSelectorCodec(3))
		set(value) = attrs.setNullable("mod flaregun fires pellets with knockback", value, NumberSelectorCodec(3))
	
	/**
	 * 
	 * Ubercharge type. Each resist uber also has its own entry
	 * 
	 */
	val medigunChargeIsCritBoost get() = MedigunChargeIsCritBoostAttributes
	
	/**
	 * Bonuses are additive, penalties are percentage
	 * 
	 * 
	 * Bonus:
	 * 	- Value type: percentage
	 * 	- +N% max overheal
	 * 
	 * Penalty:
	 * 	- Value type: inverted_percentage
	 * 	- N% max overheal
	 */
	val overhealPenalty get() = BonusPenalty<Float, Float>("overheal bonus", "overheal penalty")
	
	/**
	 * 
	 * Bonus:
	 * 	- Value type: inverted_percentage
	 * 	- +N% longer overheal time
	 * 
	 * Penalty:
	 * 	- Value type: inverted_percentage
	 * 	- N% shorter overheal time
	 */
	val overhealDecayPenalty get() = BonusPenalty<Float, Float>("overheal decay bonus", "overheal decay penalty")
	
	/**
	 * On owner
	 * 
	 * Overheal bonus = overheal bonus + overhealexpert/4 or just overheal bonus, whichever is higher
	 * 
	 * decay mult is same but divided by 2
	 * 
	 */
	context(attrs: IKeyValueMap)
	var overhealExpert: Int?
		get() = attrs.getTyped("overheal expert")
		set(value) = attrs.setNullable("overheal expert", value)
	
	/**
	 * Value type: percentage
	 * 
	 * On owner
	 * 
	 */
	context(attrs: IKeyValueMap)
	var uberchargeOverhealRatePenalty: Float?
		get() = attrs.getTyped("ubercharge overheal rate penalty")
		set(value) = attrs.setNullable("ubercharge overheal rate penalty", value)
	
	/**
	 * On owner
	 * 
	 * 
	 * Bonus:
	 * 	- Value type: percentage
	 * 	- +N% ÜberCharge rate
	 * 
	 * Penalty:
	 * 	- Value type: percentage
	 * 	- N% ÜberCharge rate
	 */
	val uberchargeRatePenalty get() = BonusPenalty<Float, Float>("ubercharge rate bonus", "ubercharge rate penalty")
	
	/**
	 * On owner
	 * 
	 */
	context(attrs: IKeyValueMap)
	var uberDurationBonus: Int?
		get() = attrs.getTyped("uber duration bonus")
		set(value) = attrs.setNullable("uber duration bonus", value)
	
	/**
	 * On owner
	 * 
	 * This is your shield level
	 * 
	 */
	context(attrs: IKeyValueMap)
	var generateRageOnHeal: Int?
		get() = attrs.getTyped("generate rage on heal")
		set(value) = attrs.setNullable("generate rage on heal", value)
}

operator fun MedigunAttributes.invoke(scope: MedigunAttributes.() -> Unit) {
	this.apply(scope)
}

/**
 * 
 * Ubercharge type. Each resist uber also has its own entry
 * 
 */
object MedigunChargeIsCritBoostAttributes {
	operator fun invoke(scope: MedigunChargeIsCritBoostAttributes.() -> Unit) {
		this.apply(scope)
	}
	
	/**
	 * ÜberCharge grants 100% critical chance
	 * 
	 * Ubercharge type. Each resist uber also has its own entry
	 * 
	 */
	context(attrs: IKeyValueMap)
	var medigunChargeIsCritBoost: Int?
		get() = attrs.getTyped("medigun charge is crit boost")
		set(value) = attrs.setNullable("medigun charge is crit boost", value)
	
	/**
	 * Press your reload key to cycle through resist types. While healing, provides you and your target with a constant 10% resistance to the selected damage type.
	 * 
	 * Ubercharge type. Each resist uber also has its own entry
	 * 
	 */
	context(attrs: IKeyValueMap)
	var medigunChargeIsResists: Int?
		get() = attrs.getTyped("medigun charge is resists")
		set(value) = attrs.setNullable("medigun charge is resists", value)
}

