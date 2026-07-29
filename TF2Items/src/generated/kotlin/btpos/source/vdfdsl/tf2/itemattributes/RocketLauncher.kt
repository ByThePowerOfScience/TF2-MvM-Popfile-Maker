package btpos.source.vdfdsl.tf2.itemattributes

import btpos.source.vdfdsl.modeling.*
import btpos.source.vdfdsl.serialization.codecs.*
import btpos.source.vdfdsl.tf2.itemattributes.impl.*
import btpos.source.vdfdsl.tf2.tftypes.*
import java.util.*




interface RocketLauncherAttributes : BaseGunAttributes {
	
	companion object {
		/**
		 * Allows the player to rocket jump with the projectile. (note that "rocket launcher" is the base for most projectile launchers, including the Crossbow :3).
		 */
		val canRocketJumpWithExplosion: ItemAttributeNamed<Boolean> = ItemAttributeNamed("rocket launch impulse")
	
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
	 * In-Game: "Overrides the projectile fired from the weapon. Takes values from 1 to 26, each representing a different projectile, and not all projectiles work on all weapons"
	 * 
	 * If unset, uses the weapon's default projectile type.
	 */
	override val overrideProjectileType: ItemAttributeNamed<TFProjectileType> get() = super.overrideProjectileType
	
	/**
	 * Allows the player to rocket jump with the projectile. (note that "rocket launcher" is the base for most projectile launchers, including the Crossbow :3).
	 */
	val canRocketJumpWithExplosion: ItemAttributeNamed<Boolean> get() = RocketLauncherAttributes.canRocketJumpWithExplosion
	
	override val projectilePenetration: ProjectilePenetrationAttributes get() = RocketLauncherAttributes.projectilePenetration
	
	override val damage: DamageAttributes get() = RocketLauncherAttributes.damage
	
	override val fireRate: FireRateAttributes get() = RocketLauncherAttributes.fireRate
	
	override val onHit: OnHitAttributes get() = RocketLauncherAttributes.onHit
	
	override val revengeCrits: RevengeCritsAttributes get() = RocketLauncherAttributes.revengeCrits
	
	override val critVsBurningPlayers: CritVsBurningPlayersAttributes get() = RocketLauncherAttributes.critVsBurningPlayers
	
	override val damageForceReduction: DamageForceReductionAttributes get() = RocketLauncherAttributes.damageForceReduction
	
	override val ragdolls: RagdollsAttributes get() = RocketLauncherAttributes.ragdolls

	
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