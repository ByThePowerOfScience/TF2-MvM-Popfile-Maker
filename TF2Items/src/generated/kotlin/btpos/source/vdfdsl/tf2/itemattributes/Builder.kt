package btpos.source.vdfdsl.tf2.itemattributes

import btpos.source.vdfdsl.modeling.*
import btpos.source.vdfdsl.serialization.codecs.*
import btpos.source.vdfdsl.tf2.itemattributes.impl.*
import btpos.source.vdfdsl.tf2.tftypes.*
import java.util.*




interface BuilderAttributes : WeaponBaseAttributes {
	
	companion object {
		/**
		 * In-Game: "Self mark for death when hauling buildings"
		 * 
		 * Checked on owner.
		 */
		val markForDeathOnBuildingPickup: ItemAttributeNamed<Boolean> = ItemAttributeNamed("mark for death on building pickup")
	
		/**
		 * If 1.0, it's a wheatley sapper.
		 */
		val sapperVoicePak: ItemAttributeNamed<Float> = ItemAttributeNamed("sapper voice pak")
	
		/**
		 * In-Game: "Increased robot Sapper radius and duration"
		 * 
		 * On base builder: If building an OBJ_ATTACHMENT_SAPPER on a mode that allows upgrades and it's built on a player (or MvM bot), gives the sapper a radius instead of being single-target.
		 */
		val roboSapper: ItemAttributeNamed<Boolean> = ItemAttributeNamed("robo sapper")
	
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
	 * In-Game: "Self mark for death when hauling buildings"
	 * 
	 * Checked on owner.
	 */
	val markForDeathOnBuildingPickup: ItemAttributeNamed<Boolean> get() = BuilderAttributes.markForDeathOnBuildingPickup
	
	/**
	 * If 1.0, it's a wheatley sapper.
	 */
	val sapperVoicePak: ItemAttributeNamed<Float> get() = BuilderAttributes.sapperVoicePak
	
	/**
	 * In-Game: "Increased robot Sapper radius and duration"
	 * 
	 * On base builder: If building an OBJ_ATTACHMENT_SAPPER on a mode that allows upgrades and it's built on a player (or MvM bot), gives the sapper a radius instead of being single-target.
	 */
	val roboSapper: ItemAttributeNamed<Boolean> get() = BuilderAttributes.roboSapper
	
	override val projectilePenetration: ProjectilePenetrationAttributes get() = BuilderAttributes.projectilePenetration
	
	override val damage: DamageAttributes get() = BuilderAttributes.damage
	
	override val fireRate: FireRateAttributes get() = BuilderAttributes.fireRate
	
	override val onHit: OnHitAttributes get() = BuilderAttributes.onHit
	
	override val revengeCrits: RevengeCritsAttributes get() = BuilderAttributes.revengeCrits
	
	override val critVsBurningPlayers: CritVsBurningPlayersAttributes get() = BuilderAttributes.critVsBurningPlayers
	
	override val damageForceReduction: DamageForceReductionAttributes get() = BuilderAttributes.damageForceReduction
	
	override val ragdolls: RagdollsAttributes get() = BuilderAttributes.ragdolls

	
	open class ProjectilePenetrationAttributes : WeaponBaseAttributes.ProjectilePenetrationAttributes() 
	
	
	open class DamageAttributes : WeaponBaseAttributes.DamageAttributes() 
	
	
	open class FireRateAttributes : WeaponBaseAttributes.FireRateAttributes() 
	
	
	open class OnHitAttributes : WeaponBaseAttributes.OnHitAttributes() {
		open val healOnHitForRapidfire: HealOnHitForRapidfireAttributes = HealOnHitForRapidfireAttributes()
	
		open val generateRageOnDamage: GenerateRageOnDamageAttributes = GenerateRageOnDamageAttributes()
	
	
		open class HealOnHitForRapidfireAttributes : WeaponBaseAttributes.OnHitAttributes.HealOnHitForRapidfireAttributes() 
	
	
		open class GenerateRageOnDamageAttributes : WeaponBaseAttributes.OnHitAttributes.GenerateRageOnDamageAttributes() 
	}
	
	
	open class RevengeCritsAttributes : WeaponBaseAttributes.RevengeCritsAttributes() 
	
	
	open class CritVsBurningPlayersAttributes : WeaponBaseAttributes.CritVsBurningPlayersAttributes() 
	
	
	open class DamageForceReductionAttributes : WeaponBaseAttributes.DamageForceReductionAttributes() 
	
	
	open class RagdollsAttributes : WeaponBaseAttributes.RagdollsAttributes() 
}