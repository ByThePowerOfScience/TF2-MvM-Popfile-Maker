package btpos.source.vdfdsl.tf2.itemattributes

import btpos.source.vdfdsl.modeling.*
import btpos.source.vdfdsl.serialization.codecs.*
import btpos.source.vdfdsl.tf2.itemattributes.impl.*
import btpos.source.vdfdsl.tf2.tftypes.*
import java.util.*




interface RocketLauncher_AirStrikeAttributes : RocketLauncherAttributes {
	
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
	 * In-Game: "Clip size increased on kill"
	 * 
	 * This attribute is on all weapons, but it's specifically checked for here as well.
	 */
	override val clipsizeIncreaseOnKill: ItemAttributeNamed<Int> get() = super.clipsizeIncreaseOnKill
	
	override val projectilePenetration: ProjectilePenetrationAttributes get() = RocketLauncher_AirStrikeAttributes.projectilePenetration
	
	override val damage: DamageAttributes get() = RocketLauncher_AirStrikeAttributes.damage
	
	override val fireRate: FireRateAttributes get() = RocketLauncher_AirStrikeAttributes.fireRate
	
	override val onHit: OnHitAttributes get() = RocketLauncher_AirStrikeAttributes.onHit
	
	override val revengeCrits: RevengeCritsAttributes get() = RocketLauncher_AirStrikeAttributes.revengeCrits
	
	override val critVsBurningPlayers: CritVsBurningPlayersAttributes get() = RocketLauncher_AirStrikeAttributes.critVsBurningPlayers
	
	override val damageForceReduction: DamageForceReductionAttributes get() = RocketLauncher_AirStrikeAttributes.damageForceReduction
	
	override val ragdolls: RagdollsAttributes get() = RocketLauncher_AirStrikeAttributes.ragdolls

	
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