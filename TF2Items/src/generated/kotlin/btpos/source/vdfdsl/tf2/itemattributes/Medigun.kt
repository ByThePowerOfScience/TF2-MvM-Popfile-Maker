package btpos.source.vdfdsl.tf2.itemattributes

import btpos.source.vdfdsl.modeling.*
import btpos.source.vdfdsl.serialization.codecs.*
import btpos.source.vdfdsl.tf2.itemattributes.impl.*
import btpos.source.vdfdsl.tf2.tftypes.*
import java.util.*



/**
 * Items: Stock Medigun + Reskins, The Kritzkrieg, The Quick-Fix, The Vaccinator
 */
interface MedigunAttributes : IBlockScoped {
	companion object {
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
		val healRate = BonusPenalty(
			ItemAttributeNamed<Float>("heal rate bonus"),
			ItemAttributeNamed<Float>("heal rate penalty")
		)
		
		/**
		 * In-Game: "On death up to N% of your stored ÜberCharge is retained"
		 *
		 * 
		 *
		 * Percentage saved on death or dropping weapon (e.g. `25` = 25% uber).
		 *
		 * Checked on player.
		 */
		val preserveUbercharge = ItemAttributeNamed<Int>("preserve ubercharge")
		
		/**
		 * In-Game: "+25% heal rate for patient, +25% faster revive rate, and +25% self heal rate, per point"
		 *
		 * 
		 */
		val healingMastery = ItemAttributeNamed<Int>("healing mastery")
		
		/**
		 * 
		 *
		 * Ubercharge type. Each resist uber also has its own entry.
		 */
		val giveCrits = GiveCritsAttributes()
		
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
		val overheal = BonusPenalty(
			ItemAttributeNamed<Float>("overheal bonus"),
			ItemAttributeNamed<Float>("overheal penalty")
		)
		
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
		val overhealDecay = BonusPenalty(
			ItemAttributeNamed<Float>("overheal decay bonus"),
			ItemAttributeNamed<Float>("overheal decay penalty")
		)
		
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
		val overhealExpert = ItemAttributeNamed<Float>("overheal expert")
		
		/**
		 * In-Game: "N% ÜberCharge rate on Overhealed patients"
		 *
		 * 
		 *
		 * Checked on owner.
		 */
		val uberchargeOverhealRatePenalty = ItemAttributeNamed<Float>("ubercharge overheal rate penalty")
		
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
		val uberchargeRate = BonusPenalty(
			ItemAttributeNamed<Float>("ubercharge rate bonus"),
			ItemAttributeNamed<Float>("ubercharge rate penalty")
		)
		
		/**
		 * In-Game: "Über duration increased N seconds"
		 *
		 * 
		 *
		 * Checked on owner.
		 */
		val uberDurationBonus = ItemAttributeNamed<Int>("uber duration bonus")
		
		/**
		 * In-Game: "Build energy by healing teammates.  When fully charged, press the Special-Attack key to deploy a frontal projectile shield."
		 *
		 * 
		 *
		 * This is your shield level.
		 *
		 * Checked on owner.
		 */
		val generateRageOnHeal = ItemAttributeNamed<Int>("generate rage on heal")
	}

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
	val healRate: ItemAttribute<Float> get() = MedigunAttributes.healRate
	
	/**
	 * In-Game: "On death up to N% of your stored ÜberCharge is retained"
	 *
	 * 
	 *
	 * Percentage saved on death or dropping weapon (e.g. `25` = 25% uber).
	 *
	 * Checked on player.
	 */
	val preserveUbercharge: ItemAttribute<Int> get() = MedigunAttributes.preserveUbercharge
	
	/**
	 * In-Game: "+25% heal rate for patient, +25% faster revive rate, and +25% self heal rate, per point"
	 *
	 * 
	 */
	val healingMastery: ItemAttribute<Int> get() = MedigunAttributes.healingMastery
	
	/**
	 * 
	 *
	 * Ubercharge type. Each resist uber also has its own entry.
	 */
	val giveCrits: ItemAttribute<GiveCrits> get() = MedigunAttributes.giveCrits
	
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
	val overheal: ItemAttribute<Float> get() = MedigunAttributes.overheal
	
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
	val overhealDecay: ItemAttribute<Float> get() = MedigunAttributes.overhealDecay
	
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
	val overhealExpert: ItemAttribute<Float> get() = MedigunAttributes.overhealExpert
	
	/**
	 * In-Game: "N% ÜberCharge rate on Overhealed patients"
	 *
	 * 
	 *
	 * Checked on owner.
	 */
	val uberchargeOverhealRatePenalty: ItemAttribute<Float> get() = MedigunAttributes.uberchargeOverhealRatePenalty
	
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
	val uberchargeRate: ItemAttribute<Float> get() = MedigunAttributes.uberchargeRate
	
	/**
	 * In-Game: "Über duration increased N seconds"
	 *
	 * 
	 *
	 * Checked on owner.
	 */
	val uberDurationBonus: ItemAttribute<Int> get() = MedigunAttributes.uberDurationBonus
	
	/**
	 * In-Game: "Build energy by healing teammates.  When fully charged, press the Special-Attack key to deploy a frontal projectile shield."
	 *
	 * 
	 *
	 * This is your shield level.
	 *
	 * Checked on owner.
	 */
	val generateRageOnHeal: ItemAttribute<Int> get() = MedigunAttributes.generateRageOnHeal

   
open class GiveCritsAttributes : IBlockScoped {
	/**
	 * In-Game: "ÜberCharge grants 100% critical chance"
	 */
	open val giveCrits = ItemAttributeNamed<Boolean>("medigun charge is crit boost", NumberSelectorCodec(1))
	
	/**
	 * In-Game: "Press your reload key to cycle through resist types. While healing, provides you and your target with a constant 10% resistance to the selected damage type."
	 */
	open val giveResistanceType = ItemAttributeNamed<Boolean>("medigun charge is resists", NumberSelectorCodec(3))

	
}
}

