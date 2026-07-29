package btpos.source.vdfdsl.tf2.itemattributes

import btpos.source.vdfdsl.modeling.*
import btpos.source.vdfdsl.serialization.codecs.*
import btpos.source.vdfdsl.tf2.itemattributes.impl.*
import btpos.source.vdfdsl.tf2.tftypes.*
import java.util.*




interface MechanicalArmAttributes : BaseGunAttributes {
	
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
	 * In-Game: "Per Shot: -N ammo"
	 */
	override val ammoPerShot: ItemAttributeNamed<Int> get() = super.ammoPerShot
	
	override val projectilePenetration: ProjectilePenetrationAttributes get() = MechanicalArmAttributes.projectilePenetration
	
	override val damage: DamageAttributes get() = MechanicalArmAttributes.damage
	
	override val fireRate: FireRateAttributes get() = MechanicalArmAttributes.fireRate
	
	override val onHit: OnHitAttributes get() = MechanicalArmAttributes.onHit
	
	override val revengeCrits: RevengeCritsAttributes get() = MechanicalArmAttributes.revengeCrits
	
	override val critVsBurningPlayers: CritVsBurningPlayersAttributes get() = MechanicalArmAttributes.critVsBurningPlayers
	
	override val damageForceReduction: DamageForceReductionAttributes get() = MechanicalArmAttributes.damageForceReduction
	
	override val ragdolls: RagdollsAttributes get() = MechanicalArmAttributes.ragdolls

	
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