package btpos.source.vdfdsl.tf2.itemattributes

import btpos.source.vdfdsl.modeling.*
import btpos.source.vdfdsl.serialization.codecs.*
import btpos.source.vdfdsl.tf2.itemattributes.impl.*
import btpos.source.vdfdsl.tf2.tftypes.*
import java.util.*




interface WrenchAttributes : BaseMeleeAttributes {
	
	companion object {
		/**
		 * In-Game: "Press your reload key to choose to teleport to spawn or your exit teleporter"
		 * 
		 * If set, pressing reload shows the Eureka Effect teleport menu.
		 */
		val altFireTeleportToSpawn: ItemAttributeNamed<Boolean> = ItemAttributeNamed("alt fire teleport to spawn")
	
		val constructionRate: BonusPenalty<Float> = BonusPenalty(
			ItemAttributeNamed("Construction rate increased"),
			ItemAttributeNamed("Construction rate decreased"),
		)
	
		val repairRate: BonusPenalty<Float> = BonusPenalty(
			ItemAttributeNamed("Repair rate increased"),
			ItemAttributeNamed("Repair rate decreased"),
		)
	
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
	 * In-Game: "Press your reload key to choose to teleport to spawn or your exit teleporter"
	 * 
	 * If set, pressing reload shows the Eureka Effect teleport menu.
	 */
	val altFireTeleportToSpawn: ItemAttributeNamed<Boolean> get() = WrenchAttributes.altFireTeleportToSpawn
	
	/**
	 * In-Game: "Replaces the Sentry with a Mini-Sentry"
	 * 
	 * Detonates leveled sentries when equipping a wrench with this attribute.
	 * 
	 * If not in MvM (player is not on team "PVE_DEFENDERS"), detonate minis when unequipping a wrench with this attribute.
	 * 
	 * Removes engineer's glove on his model.
	 * 
	 * Also determines if it's a "PDQ", which obviously builds minisentries.
	 */
	override val wrenchBuildsMinisentry: ItemAttributeNamed<Boolean> get() = super.wrenchBuildsMinisentry
	
	val constructionRate: BonusPenalty<Float> get() = WrenchAttributes.constructionRate
	
	val repairRate: BonusPenalty<Float> get() = WrenchAttributes.repairRate
	
	override val projectilePenetration: ProjectilePenetrationAttributes get() = WrenchAttributes.projectilePenetration
	
	override val damage: DamageAttributes get() = WrenchAttributes.damage
	
	override val fireRate: FireRateAttributes get() = WrenchAttributes.fireRate
	
	override val onHit: OnHitAttributes get() = WrenchAttributes.onHit
	
	override val revengeCrits: RevengeCritsAttributes get() = WrenchAttributes.revengeCrits
	
	override val critVsBurningPlayers: CritVsBurningPlayersAttributes get() = WrenchAttributes.critVsBurningPlayers
	
	override val damageForceReduction: DamageForceReductionAttributes get() = WrenchAttributes.damageForceReduction
	
	override val ragdolls: RagdollsAttributes get() = WrenchAttributes.ragdolls

	
	open class ProjectilePenetrationAttributes : BaseMeleeAttributes.ProjectilePenetrationAttributes() 
	
	
	open class DamageAttributes : BaseMeleeAttributes.DamageAttributes() 
	
	
	open class FireRateAttributes : BaseMeleeAttributes.FireRateAttributes() 
	
	
	open class OnHitAttributes : BaseMeleeAttributes.OnHitAttributes() {
		open val healOnHitForRapidfire: HealOnHitForRapidfireAttributes = HealOnHitForRapidfireAttributes()
	
		open val generateRageOnDamage: GenerateRageOnDamageAttributes = GenerateRageOnDamageAttributes()
	
	
		open class HealOnHitForRapidfireAttributes : BaseMeleeAttributes.OnHitAttributes.HealOnHitForRapidfireAttributes() 
	
	
		open class GenerateRageOnDamageAttributes : BaseMeleeAttributes.OnHitAttributes.GenerateRageOnDamageAttributes() 
	}
	
	
	open class RevengeCritsAttributes : BaseMeleeAttributes.RevengeCritsAttributes() 
	
	
	open class CritVsBurningPlayersAttributes : BaseMeleeAttributes.CritVsBurningPlayersAttributes() 
	
	
	open class DamageForceReductionAttributes : BaseMeleeAttributes.DamageForceReductionAttributes() 
	
	
	open class RagdollsAttributes : BaseMeleeAttributes.RagdollsAttributes() 
}