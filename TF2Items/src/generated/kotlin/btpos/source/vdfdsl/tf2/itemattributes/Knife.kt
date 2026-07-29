package btpos.source.vdfdsl.tf2.itemattributes

import btpos.source.vdfdsl.modeling.*
import btpos.source.vdfdsl.serialization.codecs.*
import btpos.source.vdfdsl.tf2.itemattributes.impl.*
import btpos.source.vdfdsl.tf2.tftypes.*
import java.util.*



interface KnifeAttributes : BaseMeleeAttributes {
	companion object {
		/**
		 * 0: Stock.
		 * 
		 * 1: Your Eternal Reward.
		 * 
		 * 2: Cloak and Dagger (idk why).
		 * 
		 * 3: Spycicle.
		 */
		val setIcicleKnifeMode: ItemAttributeNamed<Boolean> = ItemAttributeNamed("set icicle knife mode", NumberSelectorCodec(3))
	
		/**
		 * In-Game: "Melts in fire, regenerates in N seconds and by picking up ammo"
		 */
		val meltsInFire: ItemAttributeNamed<Boolean> = ItemAttributeNamed("melts in fire")
	
		/**
		 * In-Game: "Upon a successful backstab against a human target, you rapidly disguise as your victim"
		 */
		val disguiseOnBackstab: ItemAttributeNamed<Boolean> = ItemAttributeNamed("disguise on backstab")
	
		/**
		 * In-Game: "Increase backstab damage against Giant Robots by N%"
		 * 
		 * Spy only does 25% damage against minibosses by default.  The number here is added to that percentage, up to a max of 100% + 25% = 125%.
		 * 
		 * Note that this is an actual PERCENTAGE of armor penetrated, not a proportion:  `25.0`, `50.0`, up to `100.0`.
		 * 
		 * Also, with max armor penetration, you apparently do 25% *more* damage against minibosses than you do against regular bots.
		 * 
		 * Checked on player.
		 */
		val armorPiercing: ItemAttributeNamed<Float> = ItemAttributeNamed("armor piercing")
	
		/**
		 * In-Game: "On Backstab: Absorbs the health from your victim."
		 * 
		 * Gain health on backstab. (Conniver's Kunai).
		 */
		val gainHealthOnBackstab: ItemAttributeNamed<Boolean> = ItemAttributeNamed("sanguisuge")
	
		val projectilePenetration: ProjectilePenetrationAttributes = ProjectilePenetrationAttributes()
	
		val damage: DamageAttributes = DamageAttributes()
	
		val fireRate: FireRateAttributes = FireRateAttributes()
	
		val onHit: OnHitAttributes = OnHitAttributes()
	
		val revengeCrits: RevengeCritsAttributes = RevengeCritsAttributes()
	
		val critVsBurningPlayers: CritVsBurningPlayersAttributes = CritVsBurningPlayersAttributes()
	
		val damageForceReduction: DamageForceReductionAttributes = DamageForceReductionAttributes()
	
		val ragdolls: RagdollsAttributes = RagdollsAttributes()
	}

	/**
	 * 0: Stock.
	 * 
	 * 1: Your Eternal Reward.
	 * 
	 * 2: Cloak and Dagger (idk why).
	 * 
	 * 3: Spycicle.
	 */
	val setIcicleKnifeMode: ItemAttributeNamed<Boolean> get() = KnifeAttributes.setIcicleKnifeMode
	
	/**
	 * In-Game: "Melts in fire, regenerates in N seconds and by picking up ammo"
	 */
	val meltsInFire: ItemAttributeNamed<Boolean> get() = KnifeAttributes.meltsInFire
	
	/**
	 * In-Game: "Upon a successful backstab against a human target, you rapidly disguise as your victim"
	 */
	val disguiseOnBackstab: ItemAttributeNamed<Boolean> get() = KnifeAttributes.disguiseOnBackstab
	
	override val damage: DamageAttributes get() = KnifeAttributes.damage
	
	/**
	 * In-Game: "Increase backstab damage against Giant Robots by N%"
	 * 
	 * Spy only does 25% damage against minibosses by default.  The number here is added to that percentage, up to a max of 100% + 25% = 125%.
	 * 
	 * Note that this is an actual PERCENTAGE of armor penetrated, not a proportion:  `25.0`, `50.0`, up to `100.0`.
	 * 
	 * Also, with max armor penetration, you apparently do 25% *more* damage against minibosses than you do against regular bots.
	 * 
	 * Checked on player.
	 */
	val armorPiercing: ItemAttributeNamed<Float> get() = KnifeAttributes.armorPiercing
	
	/**
	 * In-Game: "On Backstab: Absorbs the health from your victim."
	 * 
	 * Gain health on backstab. (Conniver's Kunai).
	 */
	val gainHealthOnBackstab: ItemAttributeNamed<Boolean> get() = KnifeAttributes.gainHealthOnBackstab
	
	override val projectilePenetration: ProjectilePenetrationAttributes get() = KnifeAttributes.projectilePenetration
	
	override val fireRate: FireRateAttributes get() = KnifeAttributes.fireRate
	
	override val onHit: OnHitAttributes get() = KnifeAttributes.onHit
	
	override val revengeCrits: RevengeCritsAttributes get() = KnifeAttributes.revengeCrits
	
	override val critVsBurningPlayers: CritVsBurningPlayersAttributes get() = KnifeAttributes.critVsBurningPlayers
	
	override val damageForceReduction: DamageForceReductionAttributes get() = KnifeAttributes.damageForceReduction
	
	override val ragdolls: RagdollsAttributes get() = KnifeAttributes.ragdolls

	open class DamageAttributes : BaseMeleeAttributes.DamageAttributes() {
		/**
		 * In-Game: "N% damage penalty"
		 * 
		 * Base backstab damage against minibosses is 250 * this proportion.
		 */
		override val damagePenalty: ItemAttributeNamed<Float> get() = super.damagePenalty
	
		/**
		 * In-Game: "+N% damage bonus"
		 * 
		 * Base backstab damage against minibosses is 250 * this proportion.
		 */
		override val damageBonus: ItemAttributeNamed<Float> get() = super.damageBonus
	
		/**
		 * In-Game: "+N% damage bonus"
		 * 
		 * Base backstab damage against minibosses is 250 * this proportion.
		 */
		override val damageBonusHidden: ItemAttributeNamed<Float> get() = super.damageBonusHidden
	
		/**
		 * In-Game: "+N% damage bonus"
		 * 
		 * Base backstab damage against minibosses is 250 * this proportion.
		 */
		override val cardDamageBonus: ItemAttributeNamed<Float> get() = super.cardDamageBonus
	}
	
	open class ProjectilePenetrationAttributes : BaseMeleeAttributes.ProjectilePenetrationAttributes() 
	
	open class FireRateAttributes : BaseMeleeAttributes.FireRateAttributes() 
	
	open class OnHitAttributes : BaseMeleeAttributes.OnHitAttributes() {
		override val healOnHitForRapidfire: HealOnHitForRapidfireAttributes = HealOnHitForRapidfireAttributes()
	
		override val generateRageOnDamage: GenerateRageOnDamageAttributes = GenerateRageOnDamageAttributes()
	
		open class HealOnHitForRapidfireAttributes : BaseMeleeAttributes.OnHitAttributes.HealOnHitForRapidfireAttributes() 
	
		open class GenerateRageOnDamageAttributes : BaseMeleeAttributes.OnHitAttributes.GenerateRageOnDamageAttributes() 
	}
	
	open class RevengeCritsAttributes : BaseMeleeAttributes.RevengeCritsAttributes() 
	
	open class CritVsBurningPlayersAttributes : BaseMeleeAttributes.CritVsBurningPlayersAttributes() 
	
	open class DamageForceReductionAttributes : BaseMeleeAttributes.DamageForceReductionAttributes() 
	
	open class RagdollsAttributes : BaseMeleeAttributes.RagdollsAttributes() 
}