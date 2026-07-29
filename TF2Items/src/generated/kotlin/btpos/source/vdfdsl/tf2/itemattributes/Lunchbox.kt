package btpos.source.vdfdsl.tf2.itemattributes

import btpos.source.vdfdsl.modeling.*
import btpos.source.vdfdsl.serialization.codecs.*
import btpos.source.vdfdsl.tf2.itemattributes.impl.*
import btpos.source.vdfdsl.tf2.tftypes.*
import java.util.*




interface LunchboxAttributes : WeaponBaseAttributes {
	
	companion object {
		/**
		 * In-Game: "Adds +50 max health for 30 seconds"
		 * 
		 * 0 = LUNCHBOX_STANDARD.
		 * 
		 * Used for both the bonk atomic punch or the sandvich.
		 * 
		 * Fun fact: LUNCHBOX_ADDS_AMMO is fully implemented.
		 */
		val lunchboxAddsMaxhealthBonus: ItemAttributeNamed<Boolean> = ItemAttributeNamed("lunchbox adds maxhealth bonus", NumberSelectorCodec(1))
	
		/**
		 * In-Game: "Sets weapon mode #N"
		 * 
		 * 0 = LUNCHBOX_STANDARD.
		 * 
		 * Used for both the bonk atomic punch or the sandvich.
		 * 
		 * Fun fact: LUNCHBOX_ADDS_AMMO is fully implemented.
		 */
		val lunchboxAddsMinicrits: ItemAttributeNamed<Boolean> = ItemAttributeNamed("lunchbox adds minicrits", NumberSelectorCodec(2))
	
		/**
		 * In-Game: "N% healing effect"
		 */
		val lunchboxHealingDecreased: ItemAttributeNamed<Float> = ItemAttributeNamed("lunchbox healing decreased")
	
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
	 * In-Game: "Adds +50 max health for 30 seconds"
	 * 
	 * 0 = LUNCHBOX_STANDARD.
	 * 
	 * Used for both the bonk atomic punch or the sandvich.
	 * 
	 * Fun fact: LUNCHBOX_ADDS_AMMO is fully implemented.
	 */
	val lunchboxAddsMaxhealthBonus: ItemAttributeNamed<Boolean> get() = LunchboxAttributes.lunchboxAddsMaxhealthBonus
	
	/**
	 * In-Game: "Sets weapon mode #N"
	 * 
	 * 0 = LUNCHBOX_STANDARD.
	 * 
	 * Used for both the bonk atomic punch or the sandvich.
	 * 
	 * Fun fact: LUNCHBOX_ADDS_AMMO is fully implemented.
	 */
	val lunchboxAddsMinicrits: ItemAttributeNamed<Boolean> get() = LunchboxAttributes.lunchboxAddsMinicrits
	
	/**
	 * In-Game: "N% healing effect"
	 */
	val lunchboxHealingDecreased: ItemAttributeNamed<Float> get() = LunchboxAttributes.lunchboxHealingDecreased
	
	override val projectilePenetration: ProjectilePenetrationAttributes get() = LunchboxAttributes.projectilePenetration
	
	override val damage: DamageAttributes get() = LunchboxAttributes.damage
	
	override val fireRate: FireRateAttributes get() = LunchboxAttributes.fireRate
	
	override val onHit: OnHitAttributes get() = LunchboxAttributes.onHit
	
	override val revengeCrits: RevengeCritsAttributes get() = LunchboxAttributes.revengeCrits
	
	override val critVsBurningPlayers: CritVsBurningPlayersAttributes get() = LunchboxAttributes.critVsBurningPlayers
	
	override val damageForceReduction: DamageForceReductionAttributes get() = LunchboxAttributes.damageForceReduction
	
	override val ragdolls: RagdollsAttributes get() = LunchboxAttributes.ragdolls

	
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