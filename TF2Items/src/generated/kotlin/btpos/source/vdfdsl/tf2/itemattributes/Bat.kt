package btpos.source.vdfdsl.tf2.itemattributes

import btpos.source.vdfdsl.modeling.*
import btpos.source.vdfdsl.serialization.codecs.*
import btpos.source.vdfdsl.tf2.itemattributes.impl.*
import btpos.source.vdfdsl.tf2.tftypes.*
import java.util.*




interface BatAttributes : BaseMeleeAttributes {
	
	companion object {
		/**
		 * In-Game: "Alt-Fire: Launches a ball that slows opponents"
		 * 
		 * If 0, cannot create a ball.
		 */
		val batLaunchesBalls: ItemAttributeNamed<Boolean> = ItemAttributeNamed("mod bat launches balls", NumberSelectorCodec(1))
	
		/**
		 * In-Game: "Alt-Fire: Launches a festive ornament that shatters causing bleed"
		 * 
		 * If 0, cannot create a ball.
		 */
		val batLaunchesOrnaments: ItemAttributeNamed<Boolean> = ItemAttributeNamed("mod bat launches ornaments", NumberSelectorCodec(2))
	
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
	 * In-Game: "Alt-Fire: Launches a ball that slows opponents"
	 * 
	 * If 0, cannot create a ball.
	 */
	val batLaunchesBalls: ItemAttributeNamed<Boolean> get() = BatAttributes.batLaunchesBalls
	
	/**
	 * In-Game: "Alt-Fire: Launches a festive ornament that shatters causing bleed"
	 * 
	 * If 0, cannot create a ball.
	 */
	val batLaunchesOrnaments: ItemAttributeNamed<Boolean> get() = BatAttributes.batLaunchesOrnaments
	
	override val projectilePenetration: ProjectilePenetrationAttributes get() = BatAttributes.projectilePenetration
	
	override val damage: DamageAttributes get() = BatAttributes.damage
	
	override val fireRate: FireRateAttributes get() = BatAttributes.fireRate
	
	override val onHit: OnHitAttributes get() = BatAttributes.onHit
	
	override val revengeCrits: RevengeCritsAttributes get() = BatAttributes.revengeCrits
	
	override val critVsBurningPlayers: CritVsBurningPlayersAttributes get() = BatAttributes.critVsBurningPlayers
	
	override val damageForceReduction: DamageForceReductionAttributes get() = BatAttributes.damageForceReduction
	
	override val ragdolls: RagdollsAttributes get() = BatAttributes.ragdolls

	
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