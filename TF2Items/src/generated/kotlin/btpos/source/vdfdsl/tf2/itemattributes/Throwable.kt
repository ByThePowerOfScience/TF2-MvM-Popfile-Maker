package btpos.source.vdfdsl.tf2.itemattributes

import btpos.source.vdfdsl.modeling.*
import btpos.source.vdfdsl.serialization.codecs.*
import btpos.source.vdfdsl.tf2.itemattributes.impl.*
import btpos.source.vdfdsl.tf2.tftypes.*
import java.util.*




interface ThrowableAttributes : JarAttributes {
	
	companion object {
		val throwableRechargeTime: ItemAttributeNamed<Float> = ItemAttributeNamed("throwable recharge time")
	
		val throwableDetonationTime: ItemAttributeNamed<Float> = ItemAttributeNamed("throwable detonation time")
	
		/**
		 * For timed explosions.
		 */
		val isThrowablePrimable: ItemAttributeNamed<Boolean> = ItemAttributeNamed("is throwable primable")
	
		/**
		 * For things like distance/power increases.
		 */
		val isThrowableChargeable: ItemAttributeNamed<Boolean> = ItemAttributeNamed("is throwable chargeable")
	
		val projectilePenetration: ProjectilePenetrationAttributes = ProjectilePenetrationAttributes()
	
		val damage: DamageAttributes = DamageAttributes()
	
		val fireRate: FireRateAttributes = FireRateAttributes()
	
		val onHit: OnHitAttributes = OnHitAttributes()
	
		val revengeCrits: RevengeCritsAttributes = RevengeCritsAttributes()
	
		val critVsBurningPlayers: CritVsBurningPlayersAttributes = CritVsBurningPlayersAttributes()
	
		val damageForceReduction: DamageForceReductionAttributes = DamageForceReductionAttributes()
	
		val ragdolls: RagdollsAttributes = RagdollsAttributes()
	}

	val throwableRechargeTime: ItemAttributeNamed<Float> get() = ThrowableAttributes.throwableRechargeTime
	
	val throwableDetonationTime: ItemAttributeNamed<Float> get() = ThrowableAttributes.throwableDetonationTime
	
	/**
	 * For timed explosions.
	 */
	val isThrowablePrimable: ItemAttributeNamed<Boolean> get() = ThrowableAttributes.isThrowablePrimable
	
	/**
	 * For things like distance/power increases.
	 */
	val isThrowableChargeable: ItemAttributeNamed<Boolean> get() = ThrowableAttributes.isThrowableChargeable
	
	override val projectilePenetration: ProjectilePenetrationAttributes get() = ThrowableAttributes.projectilePenetration
	
	override val damage: DamageAttributes get() = ThrowableAttributes.damage
	
	override val fireRate: FireRateAttributes get() = ThrowableAttributes.fireRate
	
	override val onHit: OnHitAttributes get() = ThrowableAttributes.onHit
	
	override val revengeCrits: RevengeCritsAttributes get() = ThrowableAttributes.revengeCrits
	
	override val critVsBurningPlayers: CritVsBurningPlayersAttributes get() = ThrowableAttributes.critVsBurningPlayers
	
	override val damageForceReduction: DamageForceReductionAttributes get() = ThrowableAttributes.damageForceReduction
	
	override val ragdolls: RagdollsAttributes get() = ThrowableAttributes.ragdolls

	
	open class ProjectilePenetrationAttributes : JarAttributes.ProjectilePenetrationAttributes() 
	
	
	open class DamageAttributes : JarAttributes.DamageAttributes() 
	
	
	open class FireRateAttributes : JarAttributes.FireRateAttributes() 
	
	
	open class OnHitAttributes : JarAttributes.OnHitAttributes() {
		open val healOnHitForRapidfire: HealOnHitForRapidfireAttributes = HealOnHitForRapidfireAttributes()
	
		open val generateRageOnDamage: GenerateRageOnDamageAttributes = GenerateRageOnDamageAttributes()
	
	
		open class HealOnHitForRapidfireAttributes : JarAttributes.OnHitAttributes.HealOnHitForRapidfireAttributes() 
	
	
		open class GenerateRageOnDamageAttributes : JarAttributes.OnHitAttributes.GenerateRageOnDamageAttributes() 
	}
	
	
	open class RevengeCritsAttributes : JarAttributes.RevengeCritsAttributes() 
	
	
	open class CritVsBurningPlayersAttributes : JarAttributes.CritVsBurningPlayersAttributes() 
	
	
	open class DamageForceReductionAttributes : JarAttributes.DamageForceReductionAttributes() 
	
	
	open class RagdollsAttributes : JarAttributes.RagdollsAttributes() 
}