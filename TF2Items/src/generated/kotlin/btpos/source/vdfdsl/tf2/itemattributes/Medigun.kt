package btpos.source.vdfdsl.tf2.itemattributes

import btpos.source.vdfdsl.modeling.*
import btpos.source.vdfdsl.serialization.codecs.*
import btpos.source.vdfdsl.tf2.itemattributes.impl.*
import btpos.source.vdfdsl.tf2.tftypes.*
import java.util.*




interface MedigunAttributes : BaseGunAttributes {
	
	companion object {
		val healRate: BonusPenalty<Float> = BonusPenalty(
			ItemAttributeNamed("heal rate bonus"),
			ItemAttributeNamed("heal rate penalty"),
		)
	
		/**
		 * In-Game: "On death up to N% of your stored ÜberCharge is retained"
		 * 
		 * Percentage saved on death or dropping weapon (e.g. `25` = 25% uber).
		 * 
		 * Checked on player.
		 */
		val preserveUbercharge: ItemAttributeNamed<Int> = ItemAttributeNamed("preserve ubercharge")
	
		/**
		 * In-Game: "+25% heal rate for patient, +25% faster revive rate, and +25% self heal rate, per point"
		 */
		val healingMastery: ItemAttributeNamed<Int> = ItemAttributeNamed("healing mastery")
	
		val giveCrits: GiveCritsAttributes = GiveCritsAttributes()
	
		val overheal: BonusPenalty<Float> = BonusPenalty(
			ItemAttributeNamed("overheal bonus"),
			ItemAttributeNamed("overheal penalty"),
		)
	
		val overhealDecay: OverhealDecayAttributes = OverhealDecayAttributes()
	
		/**
		 * In-Game: "+25% more overheal, +50% longer duration per point"
		 * 
		 * Overheal bonus = overheal bonus + overhealexpert/4 or just overheal bonus, whichever is higher.
		 * 
		 * decay mult is same but divided by 2.
		 * 
		 * Checked on owner.
		 */
		val overhealExpert: ItemAttributeNamed<Float> = ItemAttributeNamed("overheal expert")
	
		/**
		 * In-Game: "N% ÜberCharge rate on Overhealed patients"
		 * 
		 * Checked on owner.
		 */
		val uberchargeOverhealRatePenalty: ItemAttributeNamed<Float> = ItemAttributeNamed("ubercharge overheal rate penalty")
	
		val uberchargeRate: BonusPenalty<Float> = BonusPenalty(
			ItemAttributeNamed("ubercharge rate bonus"),
			ItemAttributeNamed("ubercharge rate penalty"),
		)
	
		/**
		 * In-Game: "Über duration increased N seconds"
		 * 
		 * Checked on owner.
		 */
		val uberDurationBonus: ItemAttributeNamed<Int> = ItemAttributeNamed("uber duration bonus")
	
		/**
		 * In-Game: "Build energy by healing teammates.  When fully charged, press the Special-Attack key to deploy a frontal projectile shield."
		 * 
		 * This is your shield level.
		 * 
		 * Checked on owner.
		 */
		val generateRageOnHeal: ItemAttributeNamed<Int> = ItemAttributeNamed("generate rage on heal")
	
		val projectilePenetration: ProjectilePenetrationAttributes = ProjectilePenetrationAttributes()
	
		val damage: DamageAttributes = DamageAttributes()
	
		val fireRate: FireRateAttributes = FireRateAttributes()
	
		val onHit: OnHitAttributes = OnHitAttributes()
	
		val revengeCrits: RevengeCritsAttributes = RevengeCritsAttributes()
	
		val critVsBurningPlayers: CritVsBurningPlayersAttributes = CritVsBurningPlayersAttributes()
	
		val damageForceReduction: DamageForceReductionAttributes = DamageForceReductionAttributes()
	
		val ragdolls: RagdollsAttributes = RagdollsAttributes()
	}

	val healRate: BonusPenalty<Float> get() = MedigunAttributes.healRate
	
	/**
	 * In-Game: "On death up to N% of your stored ÜberCharge is retained"
	 * 
	 * Percentage saved on death or dropping weapon (e.g. `25` = 25% uber).
	 * 
	 * Checked on player.
	 */
	val preserveUbercharge: ItemAttributeNamed<Int> get() = MedigunAttributes.preserveUbercharge
	
	/**
	 * In-Game: "+25% heal rate for patient, +25% faster revive rate, and +25% self heal rate, per point"
	 */
	val healingMastery: ItemAttributeNamed<Int> get() = MedigunAttributes.healingMastery
	
	val giveCrits: GiveCritsAttributes get() = MedigunAttributes.giveCrits
	
	val overheal: BonusPenalty<Float> get() = MedigunAttributes.overheal
	
	val overhealDecay: OverhealDecayAttributes get() = MedigunAttributes.overhealDecay
	
	/**
	 * In-Game: "+25% more overheal, +50% longer duration per point"
	 * 
	 * Overheal bonus = overheal bonus + overhealexpert/4 or just overheal bonus, whichever is higher.
	 * 
	 * decay mult is same but divided by 2.
	 * 
	 * Checked on owner.
	 */
	val overhealExpert: ItemAttributeNamed<Float> get() = MedigunAttributes.overhealExpert
	
	/**
	 * In-Game: "N% ÜberCharge rate on Overhealed patients"
	 * 
	 * Checked on owner.
	 */
	val uberchargeOverhealRatePenalty: ItemAttributeNamed<Float> get() = MedigunAttributes.uberchargeOverhealRatePenalty
	
	val uberchargeRate: BonusPenalty<Float> get() = MedigunAttributes.uberchargeRate
	
	/**
	 * In-Game: "Über duration increased N seconds"
	 * 
	 * Checked on owner.
	 */
	val uberDurationBonus: ItemAttributeNamed<Int> get() = MedigunAttributes.uberDurationBonus
	
	/**
	 * In-Game: "Build energy by healing teammates.  When fully charged, press the Special-Attack key to deploy a frontal projectile shield."
	 * 
	 * This is your shield level.
	 * 
	 * Checked on owner.
	 */
	val generateRageOnHeal: ItemAttributeNamed<Int> get() = MedigunAttributes.generateRageOnHeal
	
	override val projectilePenetration: ProjectilePenetrationAttributes get() = MedigunAttributes.projectilePenetration
	
	override val damage: DamageAttributes get() = MedigunAttributes.damage
	
	override val fireRate: FireRateAttributes get() = MedigunAttributes.fireRate
	
	override val onHit: OnHitAttributes get() = MedigunAttributes.onHit
	
	override val revengeCrits: RevengeCritsAttributes get() = MedigunAttributes.revengeCrits
	
	override val critVsBurningPlayers: CritVsBurningPlayersAttributes get() = MedigunAttributes.critVsBurningPlayers
	
	override val damageForceReduction: DamageForceReductionAttributes get() = MedigunAttributes.damageForceReduction
	
	override val ragdolls: RagdollsAttributes get() = MedigunAttributes.ragdolls

	
	open class GiveCritsAttributes : IBlockScoped {
		/**
		 * In-Game: "ÜberCharge grants 100% critical chance"
		 * 
		 * Ubercharge type. Each resist uber also has its own entry.
		 */
		open val giveCrits: ItemAttributeNamed<Boolean> = ItemAttributeNamed("medigun charge is crit boost", NumberSelectorCodec(1))
	
		/**
		 * In-Game: "ÜberCharge increases healing to 300% and grants immunity to movement-impairing effects"
		 * 
		 * Ubercharge type. Each resist uber also has its own entry.
		 */
		open val medigunChargeIsMegaheal: ItemAttributeNamed<Int> = ItemAttributeNamed("medigun charge is megaheal")
	
		/**
		 * In-Game: "Press your reload key to cycle through resist types. While healing, provides you and your target with a constant 10% resistance to the selected damage type."
		 * 
		 * Ubercharge type. Each resist uber also has its own entry.
		 */
		open val giveResistanceType: ItemAttributeNamed<Boolean> = ItemAttributeNamed("medigun charge is resists", NumberSelectorCodec(3))
	}
	
	
	open class OverhealDecayAttributes : IBlockScoped {
		/**
		 * In-Game: "N% shorter overheal time"
		 */
		open val overhealDecayPenalty: ItemAttributeNamed<Float> = ItemAttributeNamed("overheal decay penalty")
	
		/**
		 * In-Game: "+N% longer overheal time"
		 */
		open val overhealDecayBonus: ItemAttributeNamed<Float> = ItemAttributeNamed("overheal decay bonus")
	
		/**
		 * In-Game: "Overheal bonus doesn't decay"
		 */
		open val overhealDecayDisabled: ItemAttributeNamed<Float> = ItemAttributeNamed("overheal decay disabled")
	}
	
	
	open class ProjectilePenetrationAttributes : BaseGunAttributes.ProjectilePenetrationAttributes() 
	
	
	open class DamageAttributes : BaseGunAttributes.DamageAttributes() 
	
	
	open class FireRateAttributes : BaseGunAttributes.FireRateAttributes() 
	
	
	open class OnHitAttributes : BaseGunAttributes.OnHitAttributes() {
		open val healOnHitForRapidfire: HealOnHitForRapidfireAttributes = HealOnHitForRapidfireAttributes()
	
		open val generateRageOnDamage: GenerateRageOnDamageAttributes = GenerateRageOnDamageAttributes()
	
	
		open class HealOnHitForRapidfireAttributes : BaseGunAttributes.OnHitAttributes.HealOnHitForRapidfireAttributes() 
	
	
		open class GenerateRageOnDamageAttributes : BaseGunAttributes.OnHitAttributes.GenerateRageOnDamageAttributes() 
	}
	
	
	open class RevengeCritsAttributes : BaseGunAttributes.RevengeCritsAttributes() 
	
	
	open class CritVsBurningPlayersAttributes : BaseGunAttributes.CritVsBurningPlayersAttributes() 
	
	
	open class DamageForceReductionAttributes : BaseGunAttributes.DamageForceReductionAttributes() 
	
	
	open class RagdollsAttributes : BaseGunAttributes.RagdollsAttributes() 
}