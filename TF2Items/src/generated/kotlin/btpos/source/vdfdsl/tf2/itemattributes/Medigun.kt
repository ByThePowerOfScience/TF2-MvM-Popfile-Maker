package btpos.source.vdfdsl.tf2.itemattributes

import btpos.source.vdfdsl.modeling.*
import btpos.source.vdfdsl.serialization.codecs.*
import btpos.source.vdfdsl.tf2.itemattributes.impl.*
import java.util.*

/**
 * Items: Stock Medigun + Reskins, The Kritzkrieg, The Quick-Fix, The Vaccinator
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
	 * Percentage saved on death or dropping weapon (e.g. `25` = 25% uber).
	 *
	 * Checked on player.
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
	 * Overheal bonus = overheal bonus + overhealexpert/4 or just overheal bonus, whichever is higher.
	 *
	 * decay mult is same but divided by 2.
	 *
	 * Checked on owner.
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
	 * Checked on owner.
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
	 * Checked on owner.
	 */
	val uberchargeRate get() = BonusPenalty<Number, Number>("ubercharge rate bonus", "ubercharge rate penalty")
	
	/**
	 * In-Game: "Über duration increased N seconds"
	 *
	 * 
	 *
	 * Checked on owner.
	 */
	context(attrs: IKeyValueMap)
	var uberDurationBonus: Int?
		get() = attrs.getTyped("uber duration bonus")
		set(value) = attrs.setNullable("uber duration bonus", value)
	
	/**
	 * In-Game: "Build energy by healing teammates.  When fully charged, press the Special-Attack key to deploy a frontal projectile shield."
	 *
	 * 
	 *
	 * This is your shield level.
	 *
	 * Checked on owner.
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

