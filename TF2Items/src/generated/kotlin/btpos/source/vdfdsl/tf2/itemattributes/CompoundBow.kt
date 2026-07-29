package btpos.source.vdfdsl.tf2.itemattributes

import btpos.source.vdfdsl.modeling.*
import btpos.source.vdfdsl.serialization.codecs.*
import btpos.source.vdfdsl.tf2.itemattributes.impl.*
import btpos.source.vdfdsl.tf2.tftypes.*
import java.util.*




interface CompoundBowAttributes : StickybombLauncherAttributes {
	
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
	 * In-Game: "+N% faster reload time"
	 * 
	 * Mult applied to reload speed.
	 */
	override val fasterReloadRate: ItemAttributeNamed<Float> get() = super.fasterReloadRate
	
	override val projectilePenetration: ProjectilePenetrationAttributes get() = CompoundBowAttributes.projectilePenetration
	
	override val damage: DamageAttributes get() = CompoundBowAttributes.damage
	
	override val fireRate: FireRateAttributes get() = CompoundBowAttributes.fireRate
	
	override val onHit: OnHitAttributes get() = CompoundBowAttributes.onHit
	
	override val revengeCrits: RevengeCritsAttributes get() = CompoundBowAttributes.revengeCrits
	
	override val critVsBurningPlayers: CritVsBurningPlayersAttributes get() = CompoundBowAttributes.critVsBurningPlayers
	
	override val damageForceReduction: DamageForceReductionAttributes get() = CompoundBowAttributes.damageForceReduction
	
	override val ragdolls: RagdollsAttributes get() = CompoundBowAttributes.ragdolls

	
	open class ProjectilePenetrationAttributes : StickybombLauncherAttributes.ProjectilePenetrationAttributes() 
	
	
	open class DamageAttributes : StickybombLauncherAttributes.DamageAttributes() 
	
	
	open class FireRateAttributes : StickybombLauncherAttributes.FireRateAttributes() 
	
	
	open class OnHitAttributes : StickybombLauncherAttributes.OnHitAttributes() {
		open val healOnHitForRapidfire: HealOnHitForRapidfireAttributes = HealOnHitForRapidfireAttributes()
	
		open val generateRageOnDamage: GenerateRageOnDamageAttributes = GenerateRageOnDamageAttributes()
	
	
		open class HealOnHitForRapidfireAttributes : StickybombLauncherAttributes.OnHitAttributes.HealOnHitForRapidfireAttributes() 
	
	
		open class GenerateRageOnDamageAttributes : StickybombLauncherAttributes.OnHitAttributes.GenerateRageOnDamageAttributes() 
	}
	
	
	open class RevengeCritsAttributes : StickybombLauncherAttributes.RevengeCritsAttributes() 
	
	
	open class CritVsBurningPlayersAttributes : StickybombLauncherAttributes.CritVsBurningPlayersAttributes() 
	
	
	open class DamageForceReductionAttributes : StickybombLauncherAttributes.DamageForceReductionAttributes() 
	
	
	open class RagdollsAttributes : StickybombLauncherAttributes.RagdollsAttributes() 
}