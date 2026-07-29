package btpos.source.vdfdsl.tf2.itemattributes

import btpos.source.vdfdsl.modeling.*
import btpos.source.vdfdsl.serialization.codecs.*
import btpos.source.vdfdsl.tf2.itemattributes.impl.*
import btpos.source.vdfdsl.tf2.tftypes.*
import java.util.*




interface BuffItemAttributes : BaseMeleeAttributes {
	
	companion object {
		val buffType: BuffTypeAttributes = BuffTypeAttributes()
	
		val BuffDuration: VisHidden<Float> = VisHidden(ItemAttributeNamed<Float>("increase buff duration"), ItemAttributeNamed<Float>("increase buff duration HIDDEN"))
	
		val projectilePenetration: ProjectilePenetrationAttributes = ProjectilePenetrationAttributes()
	
		val damage: DamageAttributes = DamageAttributes()
	
		val fireRate: FireRateAttributes = FireRateAttributes()
	
		val onHit: OnHitAttributes = OnHitAttributes()
	
		val revengeCrits: RevengeCritsAttributes = RevengeCritsAttributes()
	
		val critVsBurningPlayers: CritVsBurningPlayersAttributes = CritVsBurningPlayersAttributes()
	
		val damageForceReduction: DamageForceReductionAttributes = DamageForceReductionAttributes()
	
		val ragdolls: RagdollsAttributes = RagdollsAttributes()
	}

	val buffType: BuffTypeAttributes get() = BuffItemAttributes.buffType
	
	val BuffDuration: VisHidden<Float> get() = BuffItemAttributes.BuffDuration
	
	override val projectilePenetration: ProjectilePenetrationAttributes get() = BuffItemAttributes.projectilePenetration
	
	override val damage: DamageAttributes get() = BuffItemAttributes.damage
	
	override val fireRate: FireRateAttributes get() = BuffItemAttributes.fireRate
	
	override val onHit: OnHitAttributes get() = BuffItemAttributes.onHit
	
	override val revengeCrits: RevengeCritsAttributes get() = BuffItemAttributes.revengeCrits
	
	override val critVsBurningPlayers: CritVsBurningPlayersAttributes get() = BuffItemAttributes.critVsBurningPlayers
	
	override val damageForceReduction: DamageForceReductionAttributes get() = BuffItemAttributes.damageForceReduction
	
	override val ragdolls: RagdollsAttributes get() = BuffItemAttributes.ragdolls

	
	open class BuffTypeAttributes : IBlockScoped {
		/**
		 * Sets which banner is used.
		 * 
		 * 0 = Buff Banner.
		 * 
		 * 1 = Battalion's Backup.
		 * 
		 * 2 = Concheror.
		 */
		open val soldierBuffType: ItemAttributeNamed<Int> = ItemAttributeNamed("mod soldier buff type")
	
		/**
		 * Sets which banner is used.
		 * 
		 * 0 = Buff Banner.
		 * 
		 * 1 = Battalion's Backup.
		 * 
		 * 2 = Concheror.
		 */
		open val demoBuffType: ItemAttributeNamed<Int> = ItemAttributeNamed("mod demo buff type")
	}
	
	
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