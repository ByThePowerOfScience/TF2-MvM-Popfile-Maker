package btpos.source.vdfdsl.tf2.itemattributes

import btpos.source.vdfdsl.modeling.*
import btpos.source.vdfdsl.serialization.codecs.*
import btpos.source.vdfdsl.tf2.itemattributes.impl.*
import btpos.source.vdfdsl.tf2.tftypes.*
import java.util.*




interface CrossbowAttributes : RocketLauncherAttributes {
	
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

	override val reloadTime: BonusPenalty<Float> get() = super.reloadTime
	
	/**
	 * In-Game: "N% slower reload time"
	 */
	override val reloadTimeIncreasedHidden: ItemAttributeNamed<Float> get() = super.reloadTimeIncreasedHidden
	
	/**
	 * In-Game: "+N% faster reload time"
	 */
	override val fasterReloadRate: ItemAttributeNamed<Float> get() = super.fasterReloadRate
	
	override val projectilePenetration: ProjectilePenetrationAttributes get() = CrossbowAttributes.projectilePenetration
	
	override val damage: DamageAttributes get() = CrossbowAttributes.damage
	
	override val fireRate: FireRateAttributes get() = CrossbowAttributes.fireRate
	
	override val onHit: OnHitAttributes get() = CrossbowAttributes.onHit
	
	override val revengeCrits: RevengeCritsAttributes get() = CrossbowAttributes.revengeCrits
	
	override val critVsBurningPlayers: CritVsBurningPlayersAttributes get() = CrossbowAttributes.critVsBurningPlayers
	
	override val damageForceReduction: DamageForceReductionAttributes get() = CrossbowAttributes.damageForceReduction
	
	override val ragdolls: RagdollsAttributes get() = CrossbowAttributes.ragdolls

	
	open class ProjectilePenetrationAttributes : RocketLauncherAttributes.ProjectilePenetrationAttributes() 
	
	
	open class DamageAttributes : RocketLauncherAttributes.DamageAttributes() 
	
	
	open class FireRateAttributes : RocketLauncherAttributes.FireRateAttributes() 
	
	
	open class OnHitAttributes : RocketLauncherAttributes.OnHitAttributes() {
		open val healOnHitForRapidfire: HealOnHitForRapidfireAttributes = HealOnHitForRapidfireAttributes()
	
		open val generateRageOnDamage: GenerateRageOnDamageAttributes = GenerateRageOnDamageAttributes()
	
	
		open class HealOnHitForRapidfireAttributes : RocketLauncherAttributes.OnHitAttributes.HealOnHitForRapidfireAttributes() 
	
	
		open class GenerateRageOnDamageAttributes : RocketLauncherAttributes.OnHitAttributes.GenerateRageOnDamageAttributes() 
	}
	
	
	open class RevengeCritsAttributes : RocketLauncherAttributes.RevengeCritsAttributes() 
	
	
	open class CritVsBurningPlayersAttributes : RocketLauncherAttributes.CritVsBurningPlayersAttributes() 
	
	
	open class DamageForceReductionAttributes : RocketLauncherAttributes.DamageForceReductionAttributes() 
	
	
	open class RagdollsAttributes : RocketLauncherAttributes.RagdollsAttributes() 
}