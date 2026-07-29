package btpos.source.vdfdsl.tf2.itemattributes

import btpos.source.vdfdsl.modeling.*
import btpos.source.vdfdsl.serialization.codecs.*
import btpos.source.vdfdsl.tf2.itemattributes.impl.*
import btpos.source.vdfdsl.tf2.tftypes.*
import java.util.*




interface SwordAttributes : BaseMeleeAttributes {
	
	companion object {
		/**
		 * In-Game: "N% damage penalty"
		 * 
		 * More like a boolean.  Doesn't actually determine any kind of decapitation, just if it CAN decapitate.
		 */
		val decapitateType: ItemAttributeNamed<Int> = ItemAttributeNamed("decapitate type")
	
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
	 * In-Game: "N% damage penalty"
	 * 
	 * More like a boolean.  Doesn't actually determine any kind of decapitation, just if it CAN decapitate.
	 */
	val decapitateType: ItemAttributeNamed<Int> get() = SwordAttributes.decapitateType
	
	override val projectilePenetration: ProjectilePenetrationAttributes get() = SwordAttributes.projectilePenetration
	
	override val damage: DamageAttributes get() = SwordAttributes.damage
	
	override val fireRate: FireRateAttributes get() = SwordAttributes.fireRate
	
	override val onHit: OnHitAttributes get() = SwordAttributes.onHit
	
	override val revengeCrits: RevengeCritsAttributes get() = SwordAttributes.revengeCrits
	
	override val critVsBurningPlayers: CritVsBurningPlayersAttributes get() = SwordAttributes.critVsBurningPlayers
	
	override val damageForceReduction: DamageForceReductionAttributes get() = SwordAttributes.damageForceReduction
	
	override val ragdolls: RagdollsAttributes get() = SwordAttributes.ragdolls

	
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