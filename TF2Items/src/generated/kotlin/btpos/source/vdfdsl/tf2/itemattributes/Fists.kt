package btpos.source.vdfdsl.tf2.itemattributes

import btpos.source.vdfdsl.modeling.*
import btpos.source.vdfdsl.serialization.codecs.*
import btpos.source.vdfdsl.tf2.itemattributes.impl.*
import btpos.source.vdfdsl.tf2.tftypes.*
import java.util.*




interface FistsAttributes : BaseMeleeAttributes {
	
	companion object {
		/**
		 * Note that despite being present in the item schema, this is explicitly COMMENTED OUT of the code, and has no gameplay effects at least.
		 */
		val breadglovesProperties: ItemAttributeNamed<Boolean> = ItemAttributeNamed("breadgloves properties")
	
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
	 * Note that despite being present in the item schema, this is explicitly COMMENTED OUT of the code, and has no gameplay effects at least.
	 */
	val breadglovesProperties: ItemAttributeNamed<Boolean> get() = FistsAttributes.breadglovesProperties
	
	override val projectilePenetration: ProjectilePenetrationAttributes get() = FistsAttributes.projectilePenetration
	
	override val damage: DamageAttributes get() = FistsAttributes.damage
	
	override val fireRate: FireRateAttributes get() = FistsAttributes.fireRate
	
	override val onHit: OnHitAttributes get() = FistsAttributes.onHit
	
	override val revengeCrits: RevengeCritsAttributes get() = FistsAttributes.revengeCrits
	
	override val critVsBurningPlayers: CritVsBurningPlayersAttributes get() = FistsAttributes.critVsBurningPlayers
	
	override val damageForceReduction: DamageForceReductionAttributes get() = FistsAttributes.damageForceReduction
	
	override val ragdolls: RagdollsAttributes get() = FistsAttributes.ragdolls

	
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