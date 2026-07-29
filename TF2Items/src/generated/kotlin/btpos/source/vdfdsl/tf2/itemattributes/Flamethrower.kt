package btpos.source.vdfdsl.tf2.itemattributes

import btpos.source.vdfdsl.modeling.*
import btpos.source.vdfdsl.serialization.codecs.*
import btpos.source.vdfdsl.tf2.itemattributes.impl.*
import btpos.source.vdfdsl.tf2.tftypes.*
import java.util.*




interface FlamethrowerAttributes : BaseGunAttributes {
	
	companion object {
		val buffType: BuffTypeAttributes = BuffTypeAttributes()
	
		/**
		 * In-Game: "No airblast"
		 */
		val airblastDisabled: ItemAttributeNamed<Boolean> = ItemAttributeNamed("airblast disabled")
	
		/**
		 * In-Game: "Airblast can now be charged, which will push enemies further"
		 * 
		 * Enables charging an airblast for longer for higher push.
		 * 
		 * Fun fact: apparently this was going to be a FLAME ROCKET, but got changed later to be an airblast.
		 */
		val chargedAirblast: ItemAttributeNamed<Boolean> = ItemAttributeNamed("charged airblast")
	
		val airblastCost: BonusPenaltyHidden<Float, ItemAttributeNamed<Float>> = BonusPenaltyHidden(
			ItemAttributeNamed<Float>("airblast cost decreased"),
			ItemAttributeNamed<Float>("airblast cost increased"),
			ItemAttributeNamed<Float>("airblast cost scale hidden"),
		)
	
		/**
		 * In-Game: "100% critical hits from behind"
		 */
		val flamethrowerBackCrit: ItemAttributeNamed<Boolean> = ItemAttributeNamed("mod flamethrower back crit")
	
		val flameAmmopersec: BonusPenalty<Float> = BonusPenalty(
			ItemAttributeNamed("flame ammopersec decreased"),
			ItemAttributeNamed("flame ammopersec increased"),
		)
	
		/**
		 * Multiplier for how long after airblasting until you can fire a primary OR secondary attack.
		 * 
		 * Secondary attack delay = 0.75 * this.
		 */
		val multAirblastRefireTime: ItemAttributeNamed<Float> = ItemAttributeNamed("mult airblast refire time")
	
		/**
		 * Scales the reflect hitbox for your airblast.
		 */
		val deflectionSizeMultiplier: ItemAttributeNamed<Float> = ItemAttributeNamed("deflection size multiplier")
	
		/**
		 * In-Game: "Extinguishing teammates restores N health"
		 * 
		 * How much health your extinguish restores.
		 */
		val extinguishRestoresHealth: ItemAttributeNamed<Int> = ItemAttributeNamed("extinguish restores health")
	
		/**
		 * In-Game: "+N% airblast push force"
		 */
		val airblastPushbackScale: ItemAttributeNamed<Float> = ItemAttributeNamed("airblast pushback scale")
	
		val airblastVerticalPushbackScale: ItemAttributeNamed<Float> = ItemAttributeNamed("airblast vertical pushback scale")
	
		val flameSize: BonusPenalty<Float> = BonusPenalty(
			ItemAttributeNamed("flame size bonus"),
			ItemAttributeNamed("flame size penalty"),
		)
	
		val flameLife: BonusPenalty<Float> = BonusPenalty(
			ItemAttributeNamed("flame life bonus"),
			ItemAttributeNamed("flame life penalty"),
		)
	
		val airblastDestroyProjectile: ItemAttributeNamed<Boolean> = ItemAttributeNamed("airblast_destroy_projectile")
	
		val airblastPushbackDisabled: ItemAttributeNamed<Boolean> = ItemAttributeNamed("airblast_pushback_disabled")
	
		val flames: FlamesAttributes = FlamesAttributes()
	
		val projectilePenetration: ProjectilePenetrationAttributes = ProjectilePenetrationAttributes()
	
		val damage: DamageAttributes = DamageAttributes()
	
		val fireRate: FireRateAttributes = FireRateAttributes()
	
		val onHit: OnHitAttributes = OnHitAttributes()
	
		val revengeCrits: RevengeCritsAttributes = RevengeCritsAttributes()
	
		val critVsBurningPlayers: CritVsBurningPlayersAttributes = CritVsBurningPlayersAttributes()
	
		val damageForceReduction: DamageForceReductionAttributes = DamageForceReductionAttributes()
	
		val ragdolls: RagdollsAttributes = RagdollsAttributes()
	}

	val buffType: BuffTypeAttributes get() = FlamethrowerAttributes.buffType
	
	/**
	 * In-Game: "No airblast"
	 */
	val airblastDisabled: ItemAttributeNamed<Boolean> get() = FlamethrowerAttributes.airblastDisabled
	
	/**
	 * In-Game: "Airblast can now be charged, which will push enemies further"
	 * 
	 * Enables charging an airblast for longer for higher push.
	 * 
	 * Fun fact: apparently this was going to be a FLAME ROCKET, but got changed later to be an airblast.
	 */
	val chargedAirblast: ItemAttributeNamed<Boolean> get() = FlamethrowerAttributes.chargedAirblast
	
	val airblastCost: BonusPenaltyHidden<Float, ItemAttributeNamed<Float>> get() = FlamethrowerAttributes.airblastCost
	
	/**
	 * In-Game: "100% critical hits from behind"
	 */
	val flamethrowerBackCrit: ItemAttributeNamed<Boolean> get() = FlamethrowerAttributes.flamethrowerBackCrit
	
	val flameAmmopersec: BonusPenalty<Float> get() = FlamethrowerAttributes.flameAmmopersec
	
	/**
	 * Multiplier for how long after airblasting until you can fire a primary OR secondary attack.
	 * 
	 * Secondary attack delay = 0.75 * this.
	 */
	val multAirblastRefireTime: ItemAttributeNamed<Float> get() = FlamethrowerAttributes.multAirblastRefireTime
	
	/**
	 * Scales the reflect hitbox for your airblast.
	 */
	val deflectionSizeMultiplier: ItemAttributeNamed<Float> get() = FlamethrowerAttributes.deflectionSizeMultiplier
	
	/**
	 * In-Game: "Extinguishing teammates restores N health"
	 * 
	 * How much health your extinguish restores.
	 */
	val extinguishRestoresHealth: ItemAttributeNamed<Int> get() = FlamethrowerAttributes.extinguishRestoresHealth
	
	/**
	 * In-Game: "+N% airblast push force"
	 */
	val airblastPushbackScale: ItemAttributeNamed<Float> get() = FlamethrowerAttributes.airblastPushbackScale
	
	val airblastVerticalPushbackScale: ItemAttributeNamed<Float> get() = FlamethrowerAttributes.airblastVerticalPushbackScale
	
	/**
	 * In-Game: "Halloween Fire"
	 */
	override val spellHalloweenGreenFlames: ItemAttributeNamed<Boolean> get() = super.spellHalloweenGreenFlames
	
	val flameSize: BonusPenalty<Float> get() = FlamethrowerAttributes.flameSize
	
	val flameLife: BonusPenalty<Float> get() = FlamethrowerAttributes.flameLife
	
	val airblastDestroyProjectile: ItemAttributeNamed<Boolean> get() = FlamethrowerAttributes.airblastDestroyProjectile
	
	val airblastPushbackDisabled: ItemAttributeNamed<Boolean> get() = FlamethrowerAttributes.airblastPushbackDisabled
	
	val flames: FlamesAttributes get() = FlamethrowerAttributes.flames
	
	override val projectilePenetration: ProjectilePenetrationAttributes get() = FlamethrowerAttributes.projectilePenetration
	
	override val damage: DamageAttributes get() = FlamethrowerAttributes.damage
	
	override val fireRate: FireRateAttributes get() = FlamethrowerAttributes.fireRate
	
	override val onHit: OnHitAttributes get() = FlamethrowerAttributes.onHit
	
	override val revengeCrits: RevengeCritsAttributes get() = FlamethrowerAttributes.revengeCrits
	
	override val critVsBurningPlayers: CritVsBurningPlayersAttributes get() = FlamethrowerAttributes.critVsBurningPlayers
	
	override val damageForceReduction: DamageForceReductionAttributes get() = FlamethrowerAttributes.damageForceReduction
	
	override val ragdolls: RagdollsAttributes get() = FlamethrowerAttributes.ragdolls

	
	open class BuffTypeAttributes : IBlockScoped {
		/**
		 * If greater than 0, enables Phlog crits on having full rage.
		 */
		open val soldierBuffType: ItemAttributeNamed<Int> = ItemAttributeNamed("mod soldier buff type")
	
		/**
		 * If greater than 0, enables Phlog crits on having full rage.
		 */
		open val demoBuffType: ItemAttributeNamed<Int> = ItemAttributeNamed("mod demo buff type")
	}
	
	
	open class FlamesAttributes : IBlockScoped {
		open val flameSpreadDegree: ItemAttributeNamed<Float> = ItemAttributeNamed("flame_spread_degree")
	
		open val redirectedFlameSizeMult: ItemAttributeNamed<Float> = ItemAttributeNamed("redirected_flame_size_mult")
	
		open val flameSize: BonusPenalty<Float> = BonusPenalty(
			ItemAttributeNamed("flame size bonus"),
			ItemAttributeNamed("flame size penalty"),
		)
	
		open val multEndFlameSize: ItemAttributeNamed<Float> = ItemAttributeNamed("mult_end_flame_size")
	
		open val flameIgnorePlayerVelocity: ItemAttributeNamed<Float> = ItemAttributeNamed("flame_ignore_player_velocity")
	
		open val flameReflectionAddLifeTime: ItemAttributeNamed<Float> = ItemAttributeNamed("flame_reflection_add_life_time")
	
		open val reflectedFlameDmgReduction: ItemAttributeNamed<Float> = ItemAttributeNamed("reflected_flame_dmg_reduction")
	
		open val maxFlameReflectionCount: ItemAttributeNamed<Int> = ItemAttributeNamed("max_flame_reflection_count")
	
		open val flameReflectOnCollision: ItemAttributeNamed<Boolean> = ItemAttributeNamed("flame_reflect_on_collision")
	
		open val flameSpeed: ItemAttributeNamed<Float> = ItemAttributeNamed("flame_speed")
	
		open val flameLifetime: ItemAttributeNamed<Float> = ItemAttributeNamed("flame_lifetime")
	
		open val flameRandomLifeTimeOffset: ItemAttributeNamed<Float> = ItemAttributeNamed("flame_random_life_time_offset")
	
		open val flameGravity: ItemAttributeNamed<Float> = ItemAttributeNamed("flame_gravity")
	
		open val flameDrag: ItemAttributeNamed<Float> = ItemAttributeNamed("flame_drag")
	
		open val flameUpSpeed: ItemAttributeNamed<Float> = ItemAttributeNamed("flame_up_speed")
	}
	
	
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