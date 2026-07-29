package btpos.source.vdfdsl.tf2.itemattributes

import btpos.source.vdfdsl.modeling.*
import btpos.source.vdfdsl.serialization.codecs.*
import btpos.source.vdfdsl.tf2.itemattributes.impl.*
import btpos.source.vdfdsl.tf2.tftypes.*
import java.util.*




interface RocketPackAttributes : BaseMeleeAttributes {
	
	companion object {
		/**
		 * In-Game: "Able to re-launch while already in-flight"
		 * 
		 * The MvM upgrade that lets you repeatedly launch without a cooldown.
		 */
		val thermalThrusterAirLaunch: ItemAttributeNamed<Boolean> = ItemAttributeNamed("thermal_thruster_air_launch")
	
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
	 * In-Game: "Able to re-launch while already in-flight"
	 * 
	 * The MvM upgrade that lets you repeatedly launch without a cooldown.
	 */
	val thermalThrusterAirLaunch: ItemAttributeNamed<Boolean> get() = RocketPackAttributes.thermalThrusterAirLaunch
	
	override val projectilePenetration: ProjectilePenetrationAttributes get() = RocketPackAttributes.projectilePenetration
	
	override val damage: DamageAttributes get() = RocketPackAttributes.damage
	
	override val fireRate: FireRateAttributes get() = RocketPackAttributes.fireRate
	
	override val onHit: OnHitAttributes get() = RocketPackAttributes.onHit
	
	override val revengeCrits: RevengeCritsAttributes get() = RocketPackAttributes.revengeCrits
	
	override val critVsBurningPlayers: CritVsBurningPlayersAttributes get() = RocketPackAttributes.critVsBurningPlayers
	
	override val damageForceReduction: DamageForceReductionAttributes get() = RocketPackAttributes.damageForceReduction
	
	override val ragdolls: RagdollsAttributes get() = RocketPackAttributes.ragdolls

	
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