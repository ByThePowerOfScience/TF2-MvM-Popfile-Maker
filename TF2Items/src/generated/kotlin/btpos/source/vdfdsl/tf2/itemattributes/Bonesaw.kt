package btpos.source.vdfdsl.tf2.itemattributes

import btpos.source.vdfdsl.modeling.*
import btpos.source.vdfdsl.serialization.codecs.*
import btpos.source.vdfdsl.tf2.itemattributes.impl.*
import btpos.source.vdfdsl.tf2.tftypes.*
import java.util.*




interface BonesawAttributes : BaseMeleeAttributes {
	
	companion object {
		/**
		 * If the player should take a "head" when dealing damage with a melee.
		 */
		val addHeadOnHit: ItemAttributeNamed<Boolean> = ItemAttributeNamed("add head on hit")
	
		/**
		 * In-Game: "Collect the organs of people you hit"
		 */
		val uberchargePreservedOnSpawnMax: ItemAttributeNamed<Float> = ItemAttributeNamed("ubercharge_preserved_on_spawn_max")
	
		/**
		 * In-Game: "Collect the organs of your victims"
		 * 
		 * On kill, take an organ (uses "heads" field like usual).
		 */
		val addHeadOnKill: ItemAttributeNamed<Boolean> = ItemAttributeNamed("add_head_on_kill")
	
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
	 * If the player should taunt on right click.
	 */
	override val specialTaunt: ItemAttributeNamed<Boolean> get() = super.specialTaunt
	
	/**
	 * If the player should take a "head" when dealing damage with a melee.
	 */
	val addHeadOnHit: ItemAttributeNamed<Boolean> get() = BonesawAttributes.addHeadOnHit
	
	/**
	 * In-Game: "Collect the organs of people you hit"
	 */
	val uberchargePreservedOnSpawnMax: ItemAttributeNamed<Float> get() = BonesawAttributes.uberchargePreservedOnSpawnMax
	
	/**
	 * In-Game: "Collect the organs of your victims"
	 * 
	 * On kill, take an organ (uses "heads" field like usual).
	 */
	val addHeadOnKill: ItemAttributeNamed<Boolean> get() = BonesawAttributes.addHeadOnKill
	
	override val projectilePenetration: ProjectilePenetrationAttributes get() = BonesawAttributes.projectilePenetration
	
	override val damage: DamageAttributes get() = BonesawAttributes.damage
	
	override val fireRate: FireRateAttributes get() = BonesawAttributes.fireRate
	
	override val onHit: OnHitAttributes get() = BonesawAttributes.onHit
	
	override val revengeCrits: RevengeCritsAttributes get() = BonesawAttributes.revengeCrits
	
	override val critVsBurningPlayers: CritVsBurningPlayersAttributes get() = BonesawAttributes.critVsBurningPlayers
	
	override val damageForceReduction: DamageForceReductionAttributes get() = BonesawAttributes.damageForceReduction
	
	override val ragdolls: RagdollsAttributes get() = BonesawAttributes.ragdolls

	
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