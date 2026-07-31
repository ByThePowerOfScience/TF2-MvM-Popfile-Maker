package btpos.source.vdfdsl.tf2.itemattributes

import btpos.source.vdfdsl.modeling.*
import btpos.source.vdfdsl.serialization.codecs.*
import btpos.source.vdfdsl.tf2.itemattributes.impl.*
import btpos.source.vdfdsl.tf2.tftypes.*
import java.util.*
import kotlin.time.Duration



interface FlamethrowerAttributes : BaseGunAttributes {
	companion object : IBlockScoped {
		val airblast: AirblastAttributes = AirblastAttributes()
	
		val buffType: BuffTypeAttributes = BuffTypeAttributes()
	
		val flames: FlamesAttributes = FlamesAttributes()
	
		val ammo: AmmoAttributes = AmmoAttributes()
	
		val damage: DamageAttributes = DamageAttributes()
	
		val firing: FiringAttributes = FiringAttributes()
	
		val projectiles: ProjectilesAttributes = ProjectilesAttributes()
	
		val afterburn: AfterburnAttributes = AfterburnAttributes()
	
		val buildings: BuildingsAttributes = BuildingsAttributes()
	
		val crits: CritsAttributes = CritsAttributes()
	
		val demoCharge: DemoChargeAttributes = DemoChargeAttributes()
	
		val healthAndHealing: HealthAndHealingAttributes = HealthAndHealingAttributes()
	
		val knockbackReceived: KnockbackReceivedAttributes = KnockbackReceivedAttributes()
	
		val meta: MetaAttributes = MetaAttributes()
	
		val meter: MeterAttributes = MeterAttributes()
	
		val movement: MovementAttributes = MovementAttributes()
	
		val heads: HeadsAttributes = HeadsAttributes()
	
		val onHit: OnHitAttributes = OnHitAttributes()
	
		val onKill: OnKillAttributes = OnKillAttributes()
	
		val reloading: ReloadingAttributes = ReloadingAttributes()
	
		val resistance: ResistanceAttributes = ResistanceAttributes()
	
		val revengeCrits: RevengeCritsAttributes = RevengeCritsAttributes()
	
		val statusEffects: StatusEffectsAttributes = StatusEffectsAttributes()
	
		val taunting: TauntingAttributes = TauntingAttributes()
	
		val viewmodel: ViewmodelAttributes = ViewmodelAttributes()
	
		val swapWeapons: SwapWeaponsAttributes = SwapWeaponsAttributes()
	
		val whenHit: WhenHitAttributes = WhenHitAttributes()
	
		val ragdolls: RagdollsAttributes = RagdollsAttributes()
	
		val disguise: DisguiseAttributes = DisguiseAttributes()
	}

	val airblast: AirblastAttributes get() = FlamethrowerAttributes.airblast
	
	override val crits: CritsAttributes get() = FlamethrowerAttributes.crits
	
	override val movement: MovementAttributes get() = FlamethrowerAttributes.movement
	
	override val ammo: AmmoAttributes get() = FlamethrowerAttributes.ammo
	
	override val healthAndHealing: HealthAndHealingAttributes get() = FlamethrowerAttributes.healthAndHealing
	
	val buffType: BuffTypeAttributes get() = FlamethrowerAttributes.buffType
	
	val flames: FlamesAttributes get() = FlamethrowerAttributes.flames
	
	override val damage: DamageAttributes get() = FlamethrowerAttributes.damage
	
	override val firing: FiringAttributes get() = FlamethrowerAttributes.firing
	
	override val projectiles: ProjectilesAttributes get() = FlamethrowerAttributes.projectiles
	
	override val afterburn: AfterburnAttributes get() = FlamethrowerAttributes.afterburn
	
	override val buildings: BuildingsAttributes get() = FlamethrowerAttributes.buildings
	
	override val demoCharge: DemoChargeAttributes get() = FlamethrowerAttributes.demoCharge
	
	override val knockbackReceived: KnockbackReceivedAttributes get() = FlamethrowerAttributes.knockbackReceived
	
	override val meta: MetaAttributes get() = FlamethrowerAttributes.meta
	
	override val meter: MeterAttributes get() = FlamethrowerAttributes.meter
	
	override val heads: HeadsAttributes get() = FlamethrowerAttributes.heads
	
	override val onHit: OnHitAttributes get() = FlamethrowerAttributes.onHit
	
	override val onKill: OnKillAttributes get() = FlamethrowerAttributes.onKill
	
	override val reloading: ReloadingAttributes get() = FlamethrowerAttributes.reloading
	
	override val resistance: ResistanceAttributes get() = FlamethrowerAttributes.resistance
	
	override val revengeCrits: RevengeCritsAttributes get() = FlamethrowerAttributes.revengeCrits
	
	override val statusEffects: StatusEffectsAttributes get() = FlamethrowerAttributes.statusEffects
	
	override val taunting: TauntingAttributes get() = FlamethrowerAttributes.taunting
	
	override val viewmodel: ViewmodelAttributes get() = FlamethrowerAttributes.viewmodel
	
	override val swapWeapons: SwapWeaponsAttributes get() = FlamethrowerAttributes.swapWeapons
	
	override val whenHit: WhenHitAttributes get() = FlamethrowerAttributes.whenHit
	
	override val ragdolls: RagdollsAttributes get() = FlamethrowerAttributes.ragdolls
	
	override val disguise: DisguiseAttributes get() = FlamethrowerAttributes.disguise

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
	
		open val airblastCost: BonusPenaltyHidden<Number, ItemAttributeNamed<Number>> = BonusPenaltyHidden(
			ItemAttributeNamed<Number>("airblast cost decreased"),
			ItemAttributeNamed<Number>("airblast cost increased"),
			ItemAttributeNamed<Number>("airblast cost scale hidden"),
		)
	
		/**
		 * Multiplier for how long after airblasting until you can fire a primary OR secondary attack.
		 * 
		 * Secondary attack delay = 0.75 * this.
		 */
		open val multAirblastRefireTime: ItemAttributeNamed<Number> = ItemAttributeNamed("mult airblast refire time")
	
		/**
		 * Scales the reflect hitbox for your airblast.
		 */
		open val deflectionSizeMultiplier: ItemAttributeNamed<Number> = ItemAttributeNamed("deflection size multiplier")
	
		/**
		 * In-Game: "+N% airblast push force"
		 */
		open val airblastPushbackScale: ItemAttributeNamed<Number> = ItemAttributeNamed("airblast pushback scale")
	
		open val airblastVerticalPushbackScale: ItemAttributeNamed<Number> = ItemAttributeNamed("airblast vertical pushback scale")
	
		open val airblastDestroyProjectile: ItemAttributeNamed<Boolean> = ItemAttributeNamed("airblast_destroy_projectile")
	
		open val airblastPushbackDisabled: ItemAttributeNamed<Boolean> = ItemAttributeNamed("airblast_pushback_disabled")
	}
	
	open class CritsAttributes : BaseGunAttributes.CritsAttributes() {
		/**
		 * In-Game: "100% critical hits from behind"
		 */
		open val flamethrowerBackCrit: ItemAttributeNamed<Boolean> = ItemAttributeNamed("mod flamethrower back crit")
	
		override val critVsBurningPlayers: CritVsBurningPlayersAttributes = CritVsBurningPlayersAttributes()
	
		open class CritVsBurningPlayersAttributes : BaseGunAttributes.CritsAttributes.CritVsBurningPlayersAttributes() 
	}
	
	open class MovementAttributes : BaseGunAttributes.MovementAttributes() {
		override val moveSpeed: MoveSpeedAttributes = MoveSpeedAttributes()
	
		open class MoveSpeedAttributes : BaseGunAttributes.MovementAttributes.MoveSpeedAttributes() 
	}
	
	open class AmmoAttributes : BaseGunAttributes.AmmoAttributes() {
		open val flameAmmopersec: BonusPenalty<Number> = BonusPenalty(
			ItemAttributeNamed("flame ammopersec decreased"),
			ItemAttributeNamed("flame ammopersec increased"),
		)
	
		override val clipSize: ClipSizeAttributes = ClipSizeAttributes()
	
		open class ClipSizeAttributes : BaseGunAttributes.AmmoAttributes.ClipSizeAttributes() 
	}
	
	open class HealthAndHealingAttributes : BaseGunAttributes.HealthAndHealingAttributes() {
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
		open val flameSpreadDegree: ItemAttributeNamed<Number> = ItemAttributeNamed("flame_spread_degree")
	
		open val redirectedFlameSizeMult: ItemAttributeNamed<Number> = ItemAttributeNamed("redirected_flame_size_mult")
	
		open val flameSize: BonusPenalty<Number> = BonusPenalty(
			ItemAttributeNamed("flame size bonus"),
			ItemAttributeNamed("flame size penalty"),
		)
	
		open val multEndFlameSize: ItemAttributeNamed<Number> = ItemAttributeNamed("mult_end_flame_size")
	
		open val flameIgnorePlayerVelocity: ItemAttributeNamed<Number> = ItemAttributeNamed("flame_ignore_player_velocity")
	
		open val flameReflectionAddLifeTime: ItemAttributeNamed<Number> = ItemAttributeNamed("flame_reflection_add_life_time")
	
		open val reflectedFlameDmgReduction: ItemAttributeNamed<Number> = ItemAttributeNamed("reflected_flame_dmg_reduction")
	
		open val maxFlameReflectionCount: ItemAttributeNamed<Int> = ItemAttributeNamed("max_flame_reflection_count")
	
		open val flameReflectOnCollision: ItemAttributeNamed<Boolean> = ItemAttributeNamed("flame_reflect_on_collision")
	
		open val flameSpeed: ItemAttributeNamed<Number> = ItemAttributeNamed("flame_speed")
	
		open val flameLifetime: ItemAttributeNamed<Number> = ItemAttributeNamed("flame_lifetime")
	
		open val flameRandomLifeTimeOffset: ItemAttributeNamed<Number> = ItemAttributeNamed("flame_random_life_time_offset")
	
		open val flameGravity: ItemAttributeNamed<Number> = ItemAttributeNamed("flame_gravity")
	
		open val flameDrag: ItemAttributeNamed<Number> = ItemAttributeNamed("flame_drag")
	
		open val flameUpSpeed: ItemAttributeNamed<Number> = ItemAttributeNamed("flame_up_speed")
	
		open val flameLife: BonusPenalty<Number> = BonusPenalty(
			ItemAttributeNamed("flame life bonus"),
			ItemAttributeNamed("flame life penalty"),
		)
	
		/**
		 * In-Game: "Halloween Fire"
		 */
		open val spellHalloweenGreenFlames: ItemAttributeNamed<Boolean> = ItemAttributeNamed("SPELL: Halloween green flames")
	}
	
	open class DamageAttributes : BaseGunAttributes.DamageAttributes() {
		override val damage: DamageAttributes = DamageAttributes()
	
		open class DamageAttributes : BaseGunAttributes.DamageAttributes.DamageAttributes() 
	}
	
	open class FiringAttributes : BaseGunAttributes.FiringAttributes() {
		override val fireRate: FireRateAttributes = FireRateAttributes()
	
		open class FireRateAttributes : BaseGunAttributes.FiringAttributes.FireRateAttributes() {
			override val fireRate: FireRateAttributes = FireRateAttributes()
	
			open class FireRateAttributes : BaseGunAttributes.FiringAttributes.FireRateAttributes.FireRateAttributes() 
		}
	}
	
	open class ProjectilesAttributes : BaseGunAttributes.ProjectilesAttributes() {
		override val bullets: BulletsAttributes = BulletsAttributes()
	
		override val projectilePenetration: ProjectilePenetrationAttributes = ProjectilePenetrationAttributes()
	
		open class BulletsAttributes : BaseGunAttributes.ProjectilesAttributes.BulletsAttributes() 
	
		open class ProjectilePenetrationAttributes : BaseGunAttributes.ProjectilesAttributes.ProjectilePenetrationAttributes() 
	}
	
	open class AfterburnAttributes : BaseGunAttributes.AfterburnAttributes() 
	
	open class BuildingsAttributes : BaseGunAttributes.BuildingsAttributes() 
	
	open class DemoChargeAttributes : BaseGunAttributes.DemoChargeAttributes() 
	
	open class KnockbackReceivedAttributes : BaseGunAttributes.KnockbackReceivedAttributes() {
		override val damageForceReduction: DamageForceReductionAttributes = DamageForceReductionAttributes()
	
		open class DamageForceReductionAttributes : BaseGunAttributes.KnockbackReceivedAttributes.DamageForceReductionAttributes() 
	}
	
	open class MetaAttributes : BaseGunAttributes.MetaAttributes() {
		override val killfeed: KillfeedAttributes = KillfeedAttributes()
	
		override val items: ItemsAttributes = ItemsAttributes()
	
		override val particles: ParticlesAttributes = ParticlesAttributes()
	
		open class KillfeedAttributes : BaseGunAttributes.MetaAttributes.KillfeedAttributes() 
	
		open class ItemsAttributes : BaseGunAttributes.MetaAttributes.ItemsAttributes() 
	
		open class ParticlesAttributes : BaseGunAttributes.MetaAttributes.ParticlesAttributes() 
	}
	
	open class MeterAttributes : BaseGunAttributes.MeterAttributes() 
	
	open class HeadsAttributes : BaseGunAttributes.HeadsAttributes() 
	
	open class OnHitAttributes : BaseGunAttributes.OnHitAttributes() {
		override val healOnHitForRapidfire: HealOnHitForRapidfireAttributes = HealOnHitForRapidfireAttributes()
	
		override val generateRageOnDamage: GenerateRageOnDamageAttributes = GenerateRageOnDamageAttributes()
	
		open class HealOnHitForRapidfireAttributes : BaseGunAttributes.OnHitAttributes.HealOnHitForRapidfireAttributes() 
	
		open class GenerateRageOnDamageAttributes : BaseGunAttributes.OnHitAttributes.GenerateRageOnDamageAttributes() 
	}
	
	open class OnKillAttributes : BaseGunAttributes.OnKillAttributes() 
	
	open class ReloadingAttributes : BaseGunAttributes.ReloadingAttributes() 
	
	open class ResistanceAttributes : BaseGunAttributes.ResistanceAttributes() 
	
	open class RevengeCritsAttributes : BaseGunAttributes.RevengeCritsAttributes() 
	
	open class StatusEffectsAttributes : BaseGunAttributes.StatusEffectsAttributes() 
	
	open class TauntingAttributes : BaseGunAttributes.TauntingAttributes() 
	
	open class ViewmodelAttributes : BaseGunAttributes.ViewmodelAttributes() 
	
	open class SwapWeaponsAttributes : BaseGunAttributes.SwapWeaponsAttributes() {
		override val deploy: DeployAttributes = DeployAttributes()
	
		open class DeployAttributes : BaseGunAttributes.SwapWeaponsAttributes.DeployAttributes() 
	}
	
	open class WhenHitAttributes : BaseGunAttributes.WhenHitAttributes() 
	
	open class RagdollsAttributes : BaseGunAttributes.RagdollsAttributes() 
	
	open class DisguiseAttributes : BaseGunAttributes.DisguiseAttributes() 
}