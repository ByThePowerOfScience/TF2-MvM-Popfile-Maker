package btpos.source.vdfdsl.tf2.itemattributes

import btpos.source.vdfdsl.modeling.*
import btpos.source.vdfdsl.serialization.codecs.*
import btpos.source.vdfdsl.tf2.itemattributes.impl.*
import btpos.source.vdfdsl.tf2.tftypes.*
import java.util.*



interface FlamethrowerAttributes : BaseGunAttributes {
	companion object {
		val airblast: AirblastAttributes = AirblastAttributes()
	
		val buffType: BuffTypeAttributes = BuffTypeAttributes()
	
		val flames: FlamesAttributes = FlamesAttributes()
	
		private val ammo: AmmoAttributes = AmmoAttributes()
	
		private val damage: DamageAttributes = DamageAttributes()
	
		private val firing: FiringAttributes = FiringAttributes()
	
		private val projectiles: ProjectilesAttributes = ProjectilesAttributes()
	}

	val airblast: AirblastAttributes get() = FlamethrowerAttributes.airblast
	
	override val crits: CritsAttributes get() = super.crits
	
	override val movement: MovementAttributes get() = super.movement
	
	override val ammo: AmmoAttributes get() = FlamethrowerAttributes.ammo
	
	override val healthAndHealing: HealthAndHealingAttributes get() = super.healthAndHealing
	
	val buffType: BuffTypeAttributes get() = FlamethrowerAttributes.buffType
	
	val flames: FlamesAttributes get() = FlamethrowerAttributes.flames
	
	override val damage: DamageAttributes get() = FlamethrowerAttributes.damage
	
	override val firing: FiringAttributes get() = FlamethrowerAttributes.firing
	
	override val projectiles: ProjectilesAttributes get() = FlamethrowerAttributes.projectiles

	open class AirblastAttributes : IBlockScoped {
		/**
		 * In-Game: "No airblast"
		 */
		open val airblastDisabled: ItemAttributeNamed<Boolean> = ItemAttributeNamed("airblast disabled")
	
		/**
		 * In-Game: "Airblast can now be charged, which will push enemies further"
		 * 
		 * Enables charging an airblast for longer for higher push.
		 * 
		 * Fun fact: apparently this was going to be a FLAME ROCKET, but got changed later to be an airblast.
		 */
		open val chargedAirblast: ItemAttributeNamed<Boolean> = ItemAttributeNamed("charged airblast")
	
		open val airblastCost: BonusPenaltyHidden<Float, ItemAttributeNamed<Float>> = BonusPenaltyHidden(
			ItemAttributeNamed<Float>("airblast cost decreased"),
			ItemAttributeNamed<Float>("airblast cost increased"),
			ItemAttributeNamed<Float>("airblast cost scale hidden"),
		)
	
		/**
		 * Multiplier for how long after airblasting until you can fire a primary OR secondary attack.
		 * 
		 * Secondary attack delay = 0.75 * this.
		 */
		open val multAirblastRefireTime: ItemAttributeNamed<Float> = ItemAttributeNamed("mult airblast refire time")
	
		/**
		 * Scales the reflect hitbox for your airblast.
		 */
		open val deflectionSizeMultiplier: ItemAttributeNamed<Float> = ItemAttributeNamed("deflection size multiplier")
	
		/**
		 * In-Game: "+N% airblast push force"
		 */
		open val airblastPushbackScale: ItemAttributeNamed<Float> = ItemAttributeNamed("airblast pushback scale")
	
		open val airblastVerticalPushbackScale: ItemAttributeNamed<Float> = ItemAttributeNamed("airblast vertical pushback scale")
	
		open val airblastDestroyProjectile: ItemAttributeNamed<Boolean> = ItemAttributeNamed("airblast_destroy_projectile")
	
		open val airblastPushbackDisabled: ItemAttributeNamed<Boolean> = ItemAttributeNamed("airblast_pushback_disabled")
	}
	
	open class CritsAttributes : IBlockScoped {
		/**
		 * In-Game: "100% critical hits from behind"
		 */
		open val flamethrowerBackCrit: ItemAttributeNamed<Boolean> = ItemAttributeNamed("mod flamethrower back crit")
	}
	
	open class MovementAttributes : IBlockScoped 
	
	open class AmmoAttributes : BaseGunAttributes.AmmoAttributes() {
		open val flameAmmopersec: BonusPenalty<Float> = BonusPenalty(
			ItemAttributeNamed("flame ammopersec decreased"),
			ItemAttributeNamed("flame ammopersec increased"),
		)
	}
	
	open class HealthAndHealingAttributes : IBlockScoped {
		/**
		 * In-Game: "Extinguishing teammates restores N health"
		 * 
		 * How much health your extinguish restores.
		 */
		open val extinguishRestoresHealth: ItemAttributeNamed<Int> = ItemAttributeNamed("extinguish restores health")
	}
	
	open class BuffTypeAttributes : IBlockScoped {
		open val buffType: BuffTypeAttributes = BuffTypeAttributes()
	
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
	
		open val flameLife: BonusPenalty<Float> = BonusPenalty(
			ItemAttributeNamed("flame life bonus"),
			ItemAttributeNamed("flame life penalty"),
		)
	
		/**
		 * In-Game: "Halloween Fire"
		 */
		open val spellHalloweenGreenFlames: ItemAttributeNamed<Boolean> = ItemAttributeNamed("SPELL: Halloween green flames")
	}
	
	open class DamageAttributes : BaseGunAttributes.DamageAttributes() 
	
	open class FiringAttributes : BaseGunAttributes.FiringAttributes() {
		override val fireRate: FireRateAttributes = FireRateAttributes()
	
		open class FireRateAttributes : BaseGunAttributes.FiringAttributes.FireRateAttributes() 
	}
	
	open class ProjectilesAttributes : BaseGunAttributes.ProjectilesAttributes() {
		override val bullets: BulletsAttributes = BulletsAttributes()
	
		open class BulletsAttributes : BaseGunAttributes.ProjectilesAttributes.BulletsAttributes() 
	}
}