package btpos.source.vdfdsl.tf2.itemattributes

import btpos.source.vdfdsl.modeling.*
import btpos.source.vdfdsl.serialization.codecs.*
import btpos.source.vdfdsl.tf2.itemattributes.impl.*
import btpos.source.vdfdsl.tf2.tftypes.*
import java.util.*




interface JarAttributes : BaseGunAttributes {
	
	companion object {
		/**
		 * In-Game: "N% movement speed on targets"
		 * 
		 * If NOT `1.0`, stun the victim.
		 * 
		 * Checked on player.
		 */
		val appliesSnareEffect: ItemAttributeNamed<Float> = ItemAttributeNamed("applies snare effect")
	
		/**
		 * In-Game: "Extinguishing teammates reduces cooldown by N%"
		 * 
		 * Subtracts this value from the cooldown.
		 */
		val extinguishReducesCooldown: ItemAttributeNamed<Float> = ItemAttributeNamed("extinguish reduces cooldown")
	
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
	 * Used to select the model.
	 * 
	 * Select between `TF_PROJECTILE_FESTIVE_JAR`, `TF_PROJECTILE_BREADMONSTER_JARATE`, and `TF_PROJECTILE_BREADMONSTER_MADMILK`.
	 * 
	 * Otherwise uses default for its class.
	 */
	override val overrideProjectileType: ItemAttributeNamed<TFProjectileType> get() = super.overrideProjectileType
	
	/**
	 * In-Game: "N% movement speed on targets"
	 * 
	 * If NOT `1.0`, stun the victim.
	 * 
	 * Checked on player.
	 */
	val appliesSnareEffect: ItemAttributeNamed<Float> get() = JarAttributes.appliesSnareEffect
	
	/**
	 * In-Game: "Extinguishing teammates reduces cooldown by N%"
	 * 
	 * Subtracts this value from the cooldown.
	 */
	val extinguishReducesCooldown: ItemAttributeNamed<Float> get() = JarAttributes.extinguishReducesCooldown
	
	override val projectilePenetration: ProjectilePenetrationAttributes get() = JarAttributes.projectilePenetration
	
	override val damage: DamageAttributes get() = JarAttributes.damage
	
	override val fireRate: FireRateAttributes get() = JarAttributes.fireRate
	
	override val onHit: OnHitAttributes get() = JarAttributes.onHit
	
	override val revengeCrits: RevengeCritsAttributes get() = JarAttributes.revengeCrits
	
	override val critVsBurningPlayers: CritVsBurningPlayersAttributes get() = JarAttributes.critVsBurningPlayers
	
	override val damageForceReduction: DamageForceReductionAttributes get() = JarAttributes.damageForceReduction
	
	override val ragdolls: RagdollsAttributes get() = JarAttributes.ragdolls

	
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