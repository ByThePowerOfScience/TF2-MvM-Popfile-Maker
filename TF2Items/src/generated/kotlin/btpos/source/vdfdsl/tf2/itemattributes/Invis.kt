package btpos.source.vdfdsl.tf2.itemattributes

import btpos.source.vdfdsl.modeling.*
import btpos.source.vdfdsl.serialization.codecs.*
import btpos.source.vdfdsl.tf2.itemattributes.impl.*
import btpos.source.vdfdsl.tf2.tftypes.*
import java.util.*




interface InvisAttributes : WeaponBaseAttributes {
	
	companion object {
		/**
		 * In-Game: "Cloak Type: Feign Death. Leave a fake corpse on taking damage and temporarily gain invisibility, speed, and damage resistance."
		 * 
		 * Used to specify "invis type".
		 */
		val setCloakIsFeignDeath: ItemAttributeNamed<Boolean> = ItemAttributeNamed("set cloak is feign death", NumberSelectorCodec(2))
	
		/**
		 * In-Game: "Cloak Type: Motion Sensitive. Alt-fire: Turn invisible. Cannot attack while invisible. Bumping in to enemies will make you slightly visible to enemies. Cloak drain rate based on movement speed."
		 * 
		 * Used to specify "invis type".
		 */
		val setCloakIsMovementBased: ItemAttributeNamed<Boolean> = ItemAttributeNamed("set cloak is movement based", NumberSelectorCodec(1))
	
		/**
		 * How many seconds it takes to decloak.
		 * 
		 * Note that values less than or equal to `0.0` become `1.0`.
		 */
		val multDecloakRate: ItemAttributeNamed<Float> = ItemAttributeNamed("mult decloak rate")
	
		val multCloakMeterConsumeRate: MultCloakMeterConsumeRateAttributes = MultCloakMeterConsumeRateAttributes()
	
		val multCloakMeterRegenRate: MultCloakMeterRegenRateAttributes = MultCloakMeterRegenRateAttributes()
	
		/**
		 * Disallows ammo boxes from affecting the cloak meter.
		 */
		val cloakNoRegenFromItems: ItemAttributeNamed<Boolean> = ItemAttributeNamed("mod_cloak_no_regen_from_items")
	
		/**
		 * In-Game: "No cloak meter from ammo boxes when invisible"
		 * 
		 * If true, cannot receive cloak while cloaked.
		 */
		val noCloakWhenCloaked: ItemAttributeNamed<Boolean> = ItemAttributeNamed("NoCloakWhenCloaked")
	
		/**
		 * In-Game: "N% cloak meter from ammo boxes"
		 * 
		 * Multiplier applied to cloak gained from ammo boxes.
		 */
		val reducedCloakFromAmmo: ItemAttributeNamed<Float> = ItemAttributeNamed("ReducedCloakFromAmmo")
	
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
	 * In-Game: "Cloak Type: Feign Death. Leave a fake corpse on taking damage and temporarily gain invisibility, speed, and damage resistance."
	 * 
	 * Used to specify "invis type".
	 */
	val setCloakIsFeignDeath: ItemAttributeNamed<Boolean> get() = InvisAttributes.setCloakIsFeignDeath
	
	/**
	 * In-Game: "Cloak Type: Motion Sensitive. Alt-fire: Turn invisible. Cannot attack while invisible. Bumping in to enemies will make you slightly visible to enemies. Cloak drain rate based on movement speed."
	 * 
	 * Used to specify "invis type".
	 */
	val setCloakIsMovementBased: ItemAttributeNamed<Boolean> get() = InvisAttributes.setCloakIsMovementBased
	
	/**
	 * How many seconds it takes to decloak.
	 * 
	 * Note that values less than or equal to `0.0` become `1.0`.
	 */
	val multDecloakRate: ItemAttributeNamed<Float> get() = InvisAttributes.multDecloakRate
	
	val multCloakMeterConsumeRate: MultCloakMeterConsumeRateAttributes get() = InvisAttributes.multCloakMeterConsumeRate
	
	val multCloakMeterRegenRate: MultCloakMeterRegenRateAttributes get() = InvisAttributes.multCloakMeterRegenRate
	
	/**
	 * Disallows ammo boxes from affecting the cloak meter.
	 */
	val cloakNoRegenFromItems: ItemAttributeNamed<Boolean> get() = InvisAttributes.cloakNoRegenFromItems
	
	/**
	 * In-Game: "No cloak meter from ammo boxes when invisible"
	 * 
	 * If true, cannot receive cloak while cloaked.
	 */
	val noCloakWhenCloaked: ItemAttributeNamed<Boolean> get() = InvisAttributes.noCloakWhenCloaked
	
	/**
	 * In-Game: "N% cloak meter from ammo boxes"
	 * 
	 * Multiplier applied to cloak gained from ammo boxes.
	 */
	val reducedCloakFromAmmo: ItemAttributeNamed<Float> get() = InvisAttributes.reducedCloakFromAmmo
	
	override val projectilePenetration: ProjectilePenetrationAttributes get() = InvisAttributes.projectilePenetration
	
	override val damage: DamageAttributes get() = InvisAttributes.damage
	
	override val fireRate: FireRateAttributes get() = InvisAttributes.fireRate
	
	override val onHit: OnHitAttributes get() = InvisAttributes.onHit
	
	override val revengeCrits: RevengeCritsAttributes get() = InvisAttributes.revengeCrits
	
	override val critVsBurningPlayers: CritVsBurningPlayersAttributes get() = InvisAttributes.critVsBurningPlayers
	
	override val damageForceReduction: DamageForceReductionAttributes get() = InvisAttributes.damageForceReduction
	
	override val ragdolls: RagdollsAttributes get() = InvisAttributes.ragdolls

	
	open class MultCloakMeterConsumeRateAttributes : IBlockScoped {
		/**
		 * In-Game: "+N% cloak drain rate"
		 * 
		 * Multiply cloak consumption rate by this value.
		 * 
		 * Checked on player.
		 */
		open val multCloakMeterConsumeRate: ItemAttributeNamed<Float> = ItemAttributeNamed("mult cloak meter consume rate")
	
		/**
		 * In-Game: "-N% cloak duration"
		 * 
		 * Multiply cloak consumption rate by this value.
		 * 
		 * Checked on player.
		 */
		open val cloakConsumeRateIncreased: ItemAttributeNamed<Float> = ItemAttributeNamed("cloak consume rate increased")
	
		/**
		 * In-Game: "+N% cloak duration"
		 * 
		 * Multiply cloak consumption rate by this value.
		 * 
		 * Checked on player.
		 */
		open val cloakConsumeRateDecreased: ItemAttributeNamed<Float> = ItemAttributeNamed("cloak consume rate decreased")
	}
	
	
	open class MultCloakMeterRegenRateAttributes : IBlockScoped {
		/**
		 * In-Game: "+N% cloak regen rate"
		 */
		open val multCloakMeterRegenRate: ItemAttributeNamed<Float> = ItemAttributeNamed("mult cloak meter regen rate")
	
		/**
		 * In-Game: "+N% cloak regeneration rate"
		 */
		open val cloakRegenRateIncreased: ItemAttributeNamed<Float> = ItemAttributeNamed("cloak regen rate increased")
	
		/**
		 * In-Game: "N% cloak regeneration rate"
		 */
		open val cloakRegenRateDecreased: ItemAttributeNamed<Float> = ItemAttributeNamed("cloak regen rate decreased")
	}
	
	
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