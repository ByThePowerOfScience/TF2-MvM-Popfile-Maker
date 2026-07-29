package btpos.source.vdfdsl.tf2.itemattributes

import btpos.source.vdfdsl.modeling.*
import btpos.source.vdfdsl.serialization.codecs.*
import btpos.source.vdfdsl.tf2.itemattributes.impl.*
import btpos.source.vdfdsl.tf2.tftypes.*
import java.util.*




interface FireAxeAttributes : BaseMeleeAttributes {
	
	companion object {
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
	 * In-Game: "On Hit: target is engulfed in flames"
	 * 
	 * Ignite enemies on hit.
	 */
	override val setDamagetypeIgnite: ItemAttributeNamed<Boolean> get() = super.setDamagetypeIgnite
	
	override val projectilePenetration: ProjectilePenetrationAttributes get() = FireAxeAttributes.projectilePenetration
	
	override val damage: DamageAttributes get() = FireAxeAttributes.damage
	
	override val fireRate: FireRateAttributes get() = FireAxeAttributes.fireRate
	
	override val onHit: OnHitAttributes get() = FireAxeAttributes.onHit
	
	override val revengeCrits: RevengeCritsAttributes get() = FireAxeAttributes.revengeCrits
	
	override val critVsBurningPlayers: CritVsBurningPlayersAttributes get() = FireAxeAttributes.critVsBurningPlayers
	
	override val damageForceReduction: DamageForceReductionAttributes get() = FireAxeAttributes.damageForceReduction
	
	override val ragdolls: RagdollsAttributes get() = FireAxeAttributes.ragdolls

	
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