package btpos.source.vdfdsl.tf2.itemattributes

import btpos.source.vdfdsl.modeling.*
import btpos.source.vdfdsl.serialization.codecs.*
import btpos.source.vdfdsl.tf2.itemattributes.impl.*
import java.util.*

/**
 * Items: TF_WEAPON_MEDIGUN, The Kritzkrieg, Upgradeable TF_WEAPON_MEDIGUN, The Quick-Fix, Festive Medigun 2011, Silver Botkiller Medi Gun Mk.I, Gold Botkiller Medi Gun Mk.I, Rust Botkiller Medi Gun Mk.I, Blood Botkiller Medi Gun Mk.I, Carbonado Botkiller Medi Gun Mk.I, Diamond Botkiller Medi Gun Mk.I, Silver Botkiller Medi Gun Mk.II, Gold Botkiller Medi Gun Mk.II, The Vaccinator
 */
interface MedigunAttributes : BaseGunAttributes, IBlockScoped {
	companion object : MedigunAttributes
	
	/**
	 * Bonus:
	 *
	 * 	- In-Game: "+N% heal rate"
	 *
	 * 
	 *
	 * Penalty:
	 *
	 * 	- In-Game: "N% heal rate"
	 *
	 * 
	 */
	val healRate get() = BonusPenalty<Number, Number>("heal rate bonus", "heal rate penalty")
	
	/**
	 * In-Game: "On death up to N% of your stored ÜberCharge is retained"
	 *
	 * 
	 *
	 * On player.
	 *
	 * Percentage saved on death or dropping weapon (e.g. `25` = 25% uber).
	 */
	context(attrs: IKeyValueMap)
	var preserveUbercharge: Int?
		get() = attrs.getTyped("preserve ubercharge")
		set(value) = attrs.setNullable("preserve ubercharge", value)
	
	/**
	 * In-Game: "+25% heal rate for patient, +25% faster revive rate, and +25% self heal rate, per point"
	 *
	 * 
	 */
	context(attrs: IKeyValueMap)
	var healingMastery: Int?
		get() = attrs.getTyped("healing mastery")
		set(value) = attrs.setNullable("healing mastery", value)
	
	/**
	 * 
	 *
	 * Ubercharge type. Each resist uber also has its own entry.
	 */
	val giveCrits get() = GiveCritsAttributes
	
	/**
	 * Bonus:
	 *
	 * 	- In-Game: "+N% max overheal"
	 *
	 * 
	 *
	 * Penalty:
	 *
	 * 	- In-Game: "N% max overheal"
	 *
	 * 
	 *
	 * Bonuses are additive, penalties are percentage.
	 */
	val overheal get() = BonusPenalty<Number, Number>("overheal bonus", "overheal penalty")
	
	/**
	 * Bonus:
	 *
	 * 	- In-Game: "+N% longer overheal time"
	 *
	 * 
	 *
	 * Penalty:
	 *
	 * 	- In-Game: "N% shorter overheal time"
	 *
	 * 
	 */
	val overhealDecay get() = BonusPenalty<Number, Number>("overheal decay bonus", "overheal decay penalty")
	
	/**
	 * In-Game: "+25% more overheal, +50% longer duration per point"
	 *
	 * 
	 *
	 * On owner.
	 *
	 * Overheal bonus = overheal bonus + overhealexpert/4 or just overheal bonus, whichever is higher.
	 *
	 * decay mult is same but divided by 2.
	 */
	context(attrs: IKeyValueMap)
	var overhealExpert: Int?
		get() = attrs.getTyped("overheal expert")
		set(value) = attrs.setNullable("overheal expert", value)
	
	/**
	 * In-Game: "N% ÜberCharge rate on Overhealed patients"
	 *
	 * 
	 *
	 * On owner.
	 */
	context(attrs: IKeyValueMap)
	var uberchargeOverhealRatePenalty: Number?
		get() = attrs.getTyped("ubercharge overheal rate penalty")
		set(value) = attrs.setNullable("ubercharge overheal rate penalty", value)
	
	/**
	 * Bonus:
	 *
	 * 	- In-Game: "+N% ÜberCharge rate"
	 *
	 * 
	 *
	 * Penalty:
	 *
	 * 	- In-Game: "N% ÜberCharge rate"
	 *
	 * 
	 *
	 * On owner.
	 */
	val uberchargeRate get() = BonusPenalty<Number, Number>("ubercharge rate bonus", "ubercharge rate penalty")
	
	/**
	 * In-Game: "Über duration increased N seconds"
	 *
	 * 
	 *
	 * Duration in seconds.
	 *
	 * On owner.
	 */
	context(attrs: IKeyValueMap)
	override var uberDurationBonus: Int?
		get() = super.uberDurationBonus
		set(value) { super.uberDurationBonus = value }
	
	/**
	 * In-Game: "Build energy by healing teammates.  When fully charged, press the Special-Attack key to deploy a frontal projectile shield."
	 *
	 * 
	 *
	 * On owner.
	 *
	 * This is your shield level.
	 */
	context(attrs: IKeyValueMap)
	var generateRageOnHeal: Int?
		get() = attrs.getTyped("generate rage on heal")
		set(value) = attrs.setNullable("generate rage on heal", value)
}


object GiveCritsAttributes {
	inline operator fun invoke(scope: GiveCritsAttributes.() -> Unit) {
		this.apply(scope)
	}
	/**
	 * In-Game: "ÜberCharge grants 100% critical chance"
	 */
	context(attrs: IKeyValueMap)
	var giveCrits: Boolean?
		get() = attrs.getTyped("medigun charge is crit boost", NumberSelectorCodec(1))
		set(value) = attrs.setNullable("medigun charge is crit boost", value, NumberSelectorCodec(1))
	
	/**
	 * In-Game: "Press your reload key to cycle through resist types. While healing, provides you and your target with a constant 10% resistance to the selected damage type."
	 */
	context(attrs: IKeyValueMap)
	var giveResistanceType: Boolean?
		get() = attrs.getTyped("medigun charge is resists", NumberSelectorCodec(3))
		set(value) = attrs.setNullable("medigun charge is resists", value, NumberSelectorCodec(3))
}

