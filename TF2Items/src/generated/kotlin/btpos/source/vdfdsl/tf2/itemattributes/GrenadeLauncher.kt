package btpos.source.vdfdsl.tf2.itemattributes

import btpos.source.vdfdsl.modeling.*
import btpos.source.vdfdsl.serialization.codecs.*
import btpos.source.vdfdsl.tf2.itemattributes.impl.*
import btpos.source.vdfdsl.tf2.tftypes.*
import java.util.*




interface GrenadeLauncherAttributes : BaseGunAttributes {
	
	companion object {
		/**
		 * In-Game: "N% damage on grenades that explode on timer"
		 * 
		 * Flat multiplier applied to initial damage.
		 */
		val grenadeDetonationDamagePenalty: ItemAttributeNamed<Float> = ItemAttributeNamed("grenade detonation damage penalty")
	
		val projectileSpeed: BonusPenaltyHidden<Float, ItemAttributeNamed<Float>> = BonusPenaltyHidden(
			ItemAttributeNamed<Float>("Projectile speed increased"),
			ItemAttributeNamed<Float>("Projectile speed decreased"),
			ItemAttributeNamed<Float>("Projectile speed increased HIDDEN"),
		)
	
		/**
		 * In-Game: "Cannonballs have a fuse time of 1 second; fuses can be primed to explode earlier by holding down the fire key."
		 */
		val grenadeLauncherMortarMode: ItemAttributeNamed<Float> = ItemAttributeNamed("grenade launcher mortar mode")
	
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
	 * In-Game: "N% damage on grenades that explode on timer"
	 * 
	 * Flat multiplier applied to initial damage.
	 */
	val grenadeDetonationDamagePenalty: ItemAttributeNamed<Float> get() = GrenadeLauncherAttributes.grenadeDetonationDamagePenalty
	
	val projectileSpeed: BonusPenaltyHidden<Float, ItemAttributeNamed<Float>> get() = GrenadeLauncherAttributes.projectileSpeed
	
	/**
	 * In-Game: "Cannonballs have a fuse time of 1 second; fuses can be primed to explode earlier by holding down the fire key."
	 */
	val grenadeLauncherMortarMode: ItemAttributeNamed<Float> get() = GrenadeLauncherAttributes.grenadeLauncherMortarMode
	
	override val projectilePenetration: ProjectilePenetrationAttributes get() = GrenadeLauncherAttributes.projectilePenetration
	
	override val damage: DamageAttributes get() = GrenadeLauncherAttributes.damage
	
	override val fireRate: FireRateAttributes get() = GrenadeLauncherAttributes.fireRate
	
	override val onHit: OnHitAttributes get() = GrenadeLauncherAttributes.onHit
	
	override val revengeCrits: RevengeCritsAttributes get() = GrenadeLauncherAttributes.revengeCrits
	
	override val critVsBurningPlayers: CritVsBurningPlayersAttributes get() = GrenadeLauncherAttributes.critVsBurningPlayers
	
	override val damageForceReduction: DamageForceReductionAttributes get() = GrenadeLauncherAttributes.damageForceReduction
	
	override val ragdolls: RagdollsAttributes get() = GrenadeLauncherAttributes.ragdolls

	
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