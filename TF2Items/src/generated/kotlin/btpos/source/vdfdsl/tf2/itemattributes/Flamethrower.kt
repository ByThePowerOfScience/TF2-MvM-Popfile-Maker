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
	
		private val ammo: AmmoAttributes = AmmoAttributes()
	
		private val damage: DamageAttributes = DamageAttributes()
	
		private val firing: FiringAttributes = FiringAttributes()
	
		private val projectiles: ProjectilesAttributes = ProjectilesAttributes()
	
		private val afterburn: AfterburnAttributes = AfterburnAttributes()
	
		private val buildings: BuildingsAttributes = BuildingsAttributes()
	
		private val crits: CritsAttributes = CritsAttributes()
	
		private val demoCharge: DemoChargeAttributes = DemoChargeAttributes()
	
		private val healthAndHealing: HealthAndHealingAttributes = HealthAndHealingAttributes()
	
		private val knockbackReceived: KnockbackReceivedAttributes = KnockbackReceivedAttributes()
	
		private val meta: MetaAttributes = MetaAttributes()
	
		private val meter: MeterAttributes = MeterAttributes()
	
		private val movement: MovementAttributes = MovementAttributes()
	
		private val heads: HeadsAttributes = HeadsAttributes()
	
		private val onHit: OnHitAttributes = OnHitAttributes()
	
		private val onKill: OnKillAttributes = OnKillAttributes()
	
		private val reloading: ReloadingAttributes = ReloadingAttributes()
	
		private val resistance: ResistanceAttributes = ResistanceAttributes()
	
		private val revengeCrits: RevengeCritsAttributes = RevengeCritsAttributes()
	
		private val statusEffects: StatusEffectsAttributes = StatusEffectsAttributes()
	
		private val taunting: TauntingAttributes = TauntingAttributes()
	
		private val swapWeapons: SwapWeaponsAttributes = SwapWeaponsAttributes()
	
		private val whenHit: WhenHitAttributes = WhenHitAttributes()
	
		private val ragdolls: RagdollsAttributes = RagdollsAttributes()
	
		private val disguise: DisguiseAttributes = DisguiseAttributes()
	
		/**
		 * In-Game: "100% critical hits from behind"
		 */
		val flamethrowerBackCrit: ItemAttributeNamed<Boolean> = ItemAttributeNamed("mod flamethrower back crit")
	
		/**
		 * Bonus:
		 * 
		 * 	- In-Game: "N% flamethrower ammo consumed per second"
		 * 
		 * Penalty:
		 * 
		 * 	- In-Game: "+N% flamethrower ammo consumed per second"
		 */
		val flameAmmopersec: BonusPenalty<Number> = BonusPenalty(
			ItemAttributeNamed("flame ammopersec decreased"),
			ItemAttributeNamed("flame ammopersec increased"),
		)
	
		/**
		 * In-Game: "Extinguishing teammates restores N health"
		 * 
		 * How much health your extinguish restores.
		 */
		val extinguishRestoresHealth: ItemAttributeNamed<Int> = ItemAttributeNamed("extinguish restores health")
	
		/**
		 * If greater than 0, enables Phlog crits on having full rage.
		 */
		val soldierBuffType: ItemAttributeNamed<Int> = ItemAttributeNamed("mod soldier buff type")
	
		/**
		 * If greater than 0, enables Phlog crits on having full rage.
		 */
		val demoBuffType: ItemAttributeNamed<Int> = ItemAttributeNamed("mod demo buff type")
	}

	val airblast: AirblastAttributes get() = FlamethrowerAttributes.airblast
	
	override val crits: CritsAttributes get() = FlamethrowerAttributes.crits
	
	override val movement: MovementAttributes get() = FlamethrowerAttributes.movement
	
	override val ammo: AmmoAttributes get() = FlamethrowerAttributes.ammo
	
	override val healthAndHealing: HealthAndHealingAttributes get() = FlamethrowerAttributes.healthAndHealing
	
	val buffType: BuffTypeAttributes get() = FlamethrowerAttributes.buffType
	
	override val firing: FiringAttributes get() = FlamethrowerAttributes.firing
	
	val flames: FlamesAttributes get() = FlamethrowerAttributes.flames
	
	override val damage: DamageAttributes get() = FlamethrowerAttributes.damage
	
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
	
	override val swapWeapons: SwapWeaponsAttributes get() = FlamethrowerAttributes.swapWeapons
	
	override val whenHit: WhenHitAttributes get() = FlamethrowerAttributes.whenHit
	
	override val ragdolls: RagdollsAttributes get() = FlamethrowerAttributes.ragdolls
	
	override val disguise: DisguiseAttributes get() = FlamethrowerAttributes.disguise

	open class AirblastAttributes : IBlockScoped {
		companion object : IBlockScoped {
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
	
			/**
			 * Bonus:
			 * 
			 * 	- In-Game: "N% airblast cost"
			 * 
			 * Penalty:
			 * 
			 * 	- In-Game: "+N% airblast cost"
			 * 
			 * Hidden:
			 */
			val airblastCost: BonusPenaltyHidden<Number, ItemAttributeNamed<Number>> = BonusPenaltyHidden(
				ItemAttributeNamed<Number>("airblast cost decreased"),
				ItemAttributeNamed<Number>("airblast cost increased"),
				ItemAttributeNamed<Number>("airblast cost scale hidden"),
			)
	
			/**
			 * Multiplier for how long after airblasting until you can fire a primary OR secondary attack.
			 * 
			 * Secondary attack delay = 0.75 * this.
			 */
			val multAirblastRefireTime: ItemAttributeNamed<Number> = ItemAttributeNamed("mult airblast refire time")
	
			/**
			 * Scales the reflect hitbox for your airblast.
			 */
			val deflectionSizeMultiplier: ItemAttributeNamed<Number> = ItemAttributeNamed("deflection size multiplier")
	
			/**
			 * In-Game: "+N% airblast push force"
			 */
			val airblastPushbackScale: ItemAttributeNamed<Number> = ItemAttributeNamed("airblast pushback scale")
	
			val airblastVerticalPushbackScale: ItemAttributeNamed<Number> = ItemAttributeNamed("airblast vertical pushback scale")
	
			val airblastDestroyProjectile: ItemAttributeNamed<Boolean> = ItemAttributeNamed("airblast_destroy_projectile")
	
			val airblastPushbackDisabled: ItemAttributeNamed<Boolean> = ItemAttributeNamed("airblast_pushback_disabled")
		}
	
		/**
		 * In-Game: "No airblast"
		 */
		context(attrs: IAttributeContainer)
		open var airblastDisabled: Boolean? 
			get() = AirblastAttributes.airblastDisabled.get()
			set(value) { AirblastAttributes.airblastDisabled.set(value) }
	
		/**
		 * In-Game: "Airblast can now be charged, which will push enemies further"
		 * 
		 * Enables charging an airblast for longer for higher push.
		 * 
		 * Fun fact: apparently this was going to be a FLAME ROCKET, but got changed later to be an airblast.
		 */
		context(attrs: IAttributeContainer)
		open var chargedAirblast: Boolean? 
			get() = AirblastAttributes.chargedAirblast.get()
			set(value) { AirblastAttributes.chargedAirblast.set(value) }
	
		/**
		 * Bonus:
		 * 
		 * 	- In-Game: "N% airblast cost"
		 * 
		 * Penalty:
		 * 
		 * 	- In-Game: "+N% airblast cost"
		 * 
		 * Hidden:
		 */
		context(attrs: IAttributeContainer)
		open var airblastCost: Number? 
			get() = AirblastAttributes.airblastCost.get()
			set(value) { AirblastAttributes.airblastCost.set(value) }
	
		/**
		 * Multiplier for how long after airblasting until you can fire a primary OR secondary attack.
		 * 
		 * Secondary attack delay = 0.75 * this.
		 */
		context(attrs: IAttributeContainer)
		open var multAirblastRefireTime: Number? 
			get() = AirblastAttributes.multAirblastRefireTime.get()
			set(value) { AirblastAttributes.multAirblastRefireTime.set(value) }
	
		/**
		 * Scales the reflect hitbox for your airblast.
		 */
		context(attrs: IAttributeContainer)
		open var deflectionSizeMultiplier: Number? 
			get() = AirblastAttributes.deflectionSizeMultiplier.get()
			set(value) { AirblastAttributes.deflectionSizeMultiplier.set(value) }
	
		/**
		 * In-Game: "+N% airblast push force"
		 */
		context(attrs: IAttributeContainer)
		open var airblastPushbackScale: Number? 
			get() = AirblastAttributes.airblastPushbackScale.get()
			set(value) { AirblastAttributes.airblastPushbackScale.set(value) }
	
		context(attrs: IAttributeContainer)
		open var airblastVerticalPushbackScale: Number? 
			get() = AirblastAttributes.airblastVerticalPushbackScale.get()
			set(value) { AirblastAttributes.airblastVerticalPushbackScale.set(value) }
	
		context(attrs: IAttributeContainer)
		open var airblastDestroyProjectile: Boolean? 
			get() = AirblastAttributes.airblastDestroyProjectile.get()
			set(value) { AirblastAttributes.airblastDestroyProjectile.set(value) }
	
		context(attrs: IAttributeContainer)
		open var airblastPushbackDisabled: Boolean? 
			get() = AirblastAttributes.airblastPushbackDisabled.get()
			set(value) { AirblastAttributes.airblastPushbackDisabled.set(value) }
	}
	
	open class CritsAttributes : BaseGunAttributes.CritsAttributes() {
		companion object : IBlockScoped 
	
		/**
		 * In-Game: "100% critical hits from behind"
		 */
		context(attrs: IAttributeContainer)
		open var flamethrowerBackCrit: Boolean? 
			get() = FlamethrowerAttributes.flamethrowerBackCrit.get()
			set(value) { FlamethrowerAttributes.flamethrowerBackCrit.set(value) }
	}
	
	open class MovementAttributes : BaseGunAttributes.MovementAttributes() {
		companion object : IBlockScoped 
	
		override val moveSpeed: MoveSpeedAttributes = MoveSpeedAttributes()
	
		open class MoveSpeedAttributes : BaseGunAttributes.MovementAttributes.MoveSpeedAttributes() 
	}
	
	open class AmmoAttributes : BaseGunAttributes.AmmoAttributes() {
		companion object : IBlockScoped 
	
		/**
		 * Bonus:
		 * 
		 * 	- In-Game: "N% flamethrower ammo consumed per second"
		 * 
		 * Penalty:
		 * 
		 * 	- In-Game: "+N% flamethrower ammo consumed per second"
		 */
		context(attrs: IAttributeContainer)
		open var flameAmmopersec: Number? 
			get() = FlamethrowerAttributes.flameAmmopersec.get()
			set(value) { FlamethrowerAttributes.flameAmmopersec.set(value) }
	
		override val clipSize: ClipSizeAttributes = ClipSizeAttributes()
	
		open class ClipSizeAttributes : BaseGunAttributes.AmmoAttributes.ClipSizeAttributes() 
	}
	
	open class HealthAndHealingAttributes : BaseGunAttributes.HealthAndHealingAttributes() {
		companion object : IBlockScoped 
	
		/**
		 * In-Game: "Extinguishing teammates restores N health"
		 * 
		 * How much health your extinguish restores.
		 */
		context(attrs: IAttributeContainer)
		open var extinguishRestoresHealth: Int? 
			get() = FlamethrowerAttributes.extinguishRestoresHealth.get()
			set(value) { FlamethrowerAttributes.extinguishRestoresHealth.set(value) }
	}
	
	open class BuffTypeAttributes : IBlockScoped {
		companion object : IBlockScoped 
	
		/**
		 * If greater than 0, enables Phlog crits on having full rage.
		 */
		context(attrs: IAttributeContainer)
		open var soldierBuffType: Int? 
			get() = FlamethrowerAttributes.soldierBuffType.get()
			set(value) { FlamethrowerAttributes.soldierBuffType.set(value) }
	
		/**
		 * If greater than 0, enables Phlog crits on having full rage.
		 */
		context(attrs: IAttributeContainer)
		open var demoBuffType: Int? 
			get() = FlamethrowerAttributes.demoBuffType.get()
			set(value) { FlamethrowerAttributes.demoBuffType.set(value) }
	}
	
	open class FiringAttributes : BaseGunAttributes.FiringAttributes() {
		companion object : IBlockScoped 
	
		override val fireRate: FireRateAttributes = FireRateAttributes()
	
		open class FireRateAttributes : BaseGunAttributes.FiringAttributes.FireRateAttributes() 
	}
	
	open class FlamesAttributes : IBlockScoped {
		companion object : IBlockScoped {
			val flameSpreadDegree: ItemAttributeNamed<Number> = ItemAttributeNamed("flame_spread_degree")
	
			val redirectedFlameSizeMult: ItemAttributeNamed<Number> = ItemAttributeNamed("redirected_flame_size_mult")
	
			/**
			 * Bonus:
			 * 
			 * 	- In-Game: "+N% more flame spread area"
			 * 
			 * Penalty:
			 * 
			 * 	- In-Game: "N% less flame spread area"
			 */
			val flameSize: BonusPenalty<Number> = BonusPenalty(
				ItemAttributeNamed("flame size bonus"),
				ItemAttributeNamed("flame size penalty"),
			)
	
			val multEndFlameSize: ItemAttributeNamed<Number> = ItemAttributeNamed("mult_end_flame_size")
	
			val flameIgnorePlayerVelocity: ItemAttributeNamed<Number> = ItemAttributeNamed("flame_ignore_player_velocity")
	
			val flameReflectionAddLifeTime: ItemAttributeNamed<Number> = ItemAttributeNamed("flame_reflection_add_life_time")
	
			val reflectedFlameDmgReduction: ItemAttributeNamed<Number> = ItemAttributeNamed("reflected_flame_dmg_reduction")
	
			val maxFlameReflectionCount: ItemAttributeNamed<Int> = ItemAttributeNamed("max_flame_reflection_count")
	
			val flameReflectOnCollision: ItemAttributeNamed<Boolean> = ItemAttributeNamed("flame_reflect_on_collision")
	
			val flameSpeed: ItemAttributeNamed<Number> = ItemAttributeNamed("flame_speed")
	
			val flameLifetime: ItemAttributeNamed<Number> = ItemAttributeNamed("flame_lifetime")
	
			val flameRandomLifeTimeOffset: ItemAttributeNamed<Number> = ItemAttributeNamed("flame_random_life_time_offset")
	
			val flameGravity: ItemAttributeNamed<Number> = ItemAttributeNamed("flame_gravity")
	
			val flameDrag: ItemAttributeNamed<Number> = ItemAttributeNamed("flame_drag")
	
			val flameUpSpeed: ItemAttributeNamed<Number> = ItemAttributeNamed("flame_up_speed")
	
			/**
			 * Bonus:
			 * 
			 * 	- In-Game: "+N% more flame distance"
			 * 
			 * Penalty:
			 * 
			 * 	- In-Game: "N% less flame distance"
			 */
			val flameLife: BonusPenalty<Number> = BonusPenalty(
				ItemAttributeNamed("flame life bonus"),
				ItemAttributeNamed("flame life penalty"),
			)
	
			/**
			 * In-Game: "Halloween Fire"
			 */
			val spellHalloweenGreenFlames: ItemAttributeNamed<Boolean> = ItemAttributeNamed("SPELL: Halloween green flames")
		}
	
		context(attrs: IAttributeContainer)
		open var flameSpreadDegree: Number? 
			get() = FlamesAttributes.flameSpreadDegree.get()
			set(value) { FlamesAttributes.flameSpreadDegree.set(value) }
	
		context(attrs: IAttributeContainer)
		open var redirectedFlameSizeMult: Number? 
			get() = FlamesAttributes.redirectedFlameSizeMult.get()
			set(value) { FlamesAttributes.redirectedFlameSizeMult.set(value) }
	
		/**
		 * Bonus:
		 * 
		 * 	- In-Game: "+N% more flame spread area"
		 * 
		 * Penalty:
		 * 
		 * 	- In-Game: "N% less flame spread area"
		 */
		context(attrs: IAttributeContainer)
		open var flameSize: Number? 
			get() = FlamesAttributes.flameSize.get()
			set(value) { FlamesAttributes.flameSize.set(value) }
	
		context(attrs: IAttributeContainer)
		open var multEndFlameSize: Number? 
			get() = FlamesAttributes.multEndFlameSize.get()
			set(value) { FlamesAttributes.multEndFlameSize.set(value) }
	
		context(attrs: IAttributeContainer)
		open var flameIgnorePlayerVelocity: Number? 
			get() = FlamesAttributes.flameIgnorePlayerVelocity.get()
			set(value) { FlamesAttributes.flameIgnorePlayerVelocity.set(value) }
	
		context(attrs: IAttributeContainer)
		open var flameReflectionAddLifeTime: Number? 
			get() = FlamesAttributes.flameReflectionAddLifeTime.get()
			set(value) { FlamesAttributes.flameReflectionAddLifeTime.set(value) }
	
		context(attrs: IAttributeContainer)
		open var reflectedFlameDmgReduction: Number? 
			get() = FlamesAttributes.reflectedFlameDmgReduction.get()
			set(value) { FlamesAttributes.reflectedFlameDmgReduction.set(value) }
	
		context(attrs: IAttributeContainer)
		open var maxFlameReflectionCount: Int? 
			get() = FlamesAttributes.maxFlameReflectionCount.get()
			set(value) { FlamesAttributes.maxFlameReflectionCount.set(value) }
	
		context(attrs: IAttributeContainer)
		open var flameReflectOnCollision: Boolean? 
			get() = FlamesAttributes.flameReflectOnCollision.get()
			set(value) { FlamesAttributes.flameReflectOnCollision.set(value) }
	
		context(attrs: IAttributeContainer)
		open var flameSpeed: Number? 
			get() = FlamesAttributes.flameSpeed.get()
			set(value) { FlamesAttributes.flameSpeed.set(value) }
	
		context(attrs: IAttributeContainer)
		open var flameLifetime: Number? 
			get() = FlamesAttributes.flameLifetime.get()
			set(value) { FlamesAttributes.flameLifetime.set(value) }
	
		context(attrs: IAttributeContainer)
		open var flameRandomLifeTimeOffset: Number? 
			get() = FlamesAttributes.flameRandomLifeTimeOffset.get()
			set(value) { FlamesAttributes.flameRandomLifeTimeOffset.set(value) }
	
		context(attrs: IAttributeContainer)
		open var flameGravity: Number? 
			get() = FlamesAttributes.flameGravity.get()
			set(value) { FlamesAttributes.flameGravity.set(value) }
	
		context(attrs: IAttributeContainer)
		open var flameDrag: Number? 
			get() = FlamesAttributes.flameDrag.get()
			set(value) { FlamesAttributes.flameDrag.set(value) }
	
		context(attrs: IAttributeContainer)
		open var flameUpSpeed: Number? 
			get() = FlamesAttributes.flameUpSpeed.get()
			set(value) { FlamesAttributes.flameUpSpeed.set(value) }
	
		/**
		 * Bonus:
		 * 
		 * 	- In-Game: "+N% more flame distance"
		 * 
		 * Penalty:
		 * 
		 * 	- In-Game: "N% less flame distance"
		 */
		context(attrs: IAttributeContainer)
		open var flameLife: Number? 
			get() = FlamesAttributes.flameLife.get()
			set(value) { FlamesAttributes.flameLife.set(value) }
	
		/**
		 * In-Game: "Halloween Fire"
		 */
		context(attrs: IAttributeContainer)
		open var spellHalloweenGreenFlames: Boolean? 
			get() = FlamesAttributes.spellHalloweenGreenFlames.get()
			set(value) { FlamesAttributes.spellHalloweenGreenFlames.set(value) }
	}
	
	open class DamageAttributes : BaseGunAttributes.DamageAttributes() 
	
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
	
		override val viewmodel: ViewmodelAttributes = ViewmodelAttributes()
	
		override val items: ItemsAttributes = ItemsAttributes()
	
		override val particles: ParticlesAttributes = ParticlesAttributes()
	
		open class KillfeedAttributes : BaseGunAttributes.MetaAttributes.KillfeedAttributes() 
	
		open class ViewmodelAttributes : BaseGunAttributes.MetaAttributes.ViewmodelAttributes() 
	
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
	
	open class SwapWeaponsAttributes : BaseGunAttributes.SwapWeaponsAttributes() {
		override val deploy: DeployAttributes = DeployAttributes()
	
		open class DeployAttributes : BaseGunAttributes.SwapWeaponsAttributes.DeployAttributes() 
	}
	
	open class WhenHitAttributes : BaseGunAttributes.WhenHitAttributes() 
	
	open class RagdollsAttributes : BaseGunAttributes.RagdollsAttributes() 
	
	open class DisguiseAttributes : BaseGunAttributes.DisguiseAttributes() 
}