package btpos.source.vdfdsl.tf2.itemattributes

import btpos.source.vdfdsl.modeling.*
import btpos.source.vdfdsl.serialization.codecs.*
import btpos.source.vdfdsl.tf2.itemattributes.impl.*
import btpos.source.vdfdsl.tf2.tftypes.*
import java.util.*




interface FlareGunAttributes : BaseGunAttributes {
	
	companion object {
		/**
		 * In-Game: "Flare knocks back target on hit and explodes when it hits the ground. Increased knock back on burning players"
		 * 
		 * 0: Normal.
		 * 
		 * 1: Detonator.
		 * 
		 * 2: Manmelter.
		 * 
		 * 3: Scorch Shot.
		 */
		val flaregunFiresPelletsWithKnockback: ItemAttributeNamed<Boolean> = ItemAttributeNamed("mod flaregun fires pellets with knockback", NumberSelectorCodec(3))
	
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
	 * In-Game: "Flare knocks back target on hit and explodes when it hits the ground. Increased knock back on burning players"
	 * 
	 * 0: Normal.
	 * 
	 * 1: Detonator.
	 * 
	 * 2: Manmelter.
	 * 
	 * 3: Scorch Shot.
	 */
	val flaregunFiresPelletsWithKnockback: ItemAttributeNamed<Boolean> get() = FlareGunAttributes.flaregunFiresPelletsWithKnockback
	
	override val projectilePenetration: ProjectilePenetrationAttributes get() = FlareGunAttributes.projectilePenetration
	
	override val damage: DamageAttributes get() = FlareGunAttributes.damage
	
	override val fireRate: FireRateAttributes get() = FlareGunAttributes.fireRate
	
	override val onHit: OnHitAttributes get() = FlareGunAttributes.onHit
	
	override val revengeCrits: RevengeCritsAttributes get() = FlareGunAttributes.revengeCrits
	
	override val critVsBurningPlayers: CritVsBurningPlayersAttributes get() = FlareGunAttributes.critVsBurningPlayers
	
	override val damageForceReduction: DamageForceReductionAttributes get() = FlareGunAttributes.damageForceReduction
	
	override val ragdolls: RagdollsAttributes get() = FlareGunAttributes.ragdolls

	
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