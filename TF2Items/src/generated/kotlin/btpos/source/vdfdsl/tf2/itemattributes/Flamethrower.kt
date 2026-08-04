package btpos.source.vdfdsl.tf2.itemattributes

import btpos.source.vdfdsl.modeling.*
import btpos.source.vdfdsl.serialization.codecs.*
import btpos.source.vdfdsl.tf2.itemattributes.impl.*
import btpos.source.vdfdsl.tf2.tftypes.*
import java.util.*
import kotlin.time.Duration

interface FlamethrowerAttributes : IBlockScoped, BaseGunAttributes {
	companion object : IBlockScoped {
		val airblast: AirblastAttributes = AirblastAttributes()
	
		val crits: CritsAttributes = CritsAttributes()
	
		val movement: MovementAttributes = MovementAttributes()
	
		val ammo: AmmoAttributes = AmmoAttributes()
	
		val healthAndHealing: HealthAndHealingAttributes = HealthAndHealingAttributes()
	
		val buffType: BuffTypeAttributes = BuffTypeAttributes()
	
		val firing: FiringAttributes = FiringAttributes()
	
		val flames: FlamesAttributes = FlamesAttributes()
	
		private val damage: DamageAttributes = DamageAttributes()
	
		private val projectiles: ProjectilesAttributes = ProjectilesAttributes()
	
		private val afterburn: AfterburnAttributes = AfterburnAttributes()
	
		private val buildings: BuildingsAttributes = BuildingsAttributes()
	
		private val demoCharge: DemoChargeAttributes = DemoChargeAttributes()
	
		private val knockbackReceived: KnockbackReceivedAttributes = KnockbackReceivedAttributes()
	
		private val meta: MetaAttributes = MetaAttributes()
	
		private val meter: MeterAttributes = MeterAttributes()
	
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
	
		private val buffItems: BuffItemsAttributes = BuffItemsAttributes()
	
		private val cloak: CloakAttributes = CloakAttributes()
	
		private val disguise: DisguiseAttributes = DisguiseAttributes()
	
		private val hud: HudAttributes = HudAttributes()
	
		private val spyOnly: SpyOnlyAttributes = SpyOnlyAttributes()
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
	
	override val buffItems: BuffItemsAttributes get() = FlamethrowerAttributes.buffItems
	
	override val cloak: CloakAttributes get() = FlamethrowerAttributes.cloak
	
	override val disguise: DisguiseAttributes get() = FlamethrowerAttributes.disguise
	
	override val hud: HudAttributes get() = FlamethrowerAttributes.hud
	
	override val spyOnly: SpyOnlyAttributes get() = FlamethrowerAttributes.spyOnly

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
	}
	
	open class MovementAttributes : BaseGunAttributes.MovementAttributes() {
		override val moveSpeed: MoveSpeedAttributes = MoveSpeedAttributes()
	
		override val jumpHeight: jumpHeightAttributes = jumpHeightAttributes()
	
		open class MoveSpeedAttributes : BaseGunAttributes.MovementAttributes.MoveSpeedAttributes() {
			override val aimingMovespeed: AimingMovespeedAttributes = AimingMovespeedAttributes()
	
			override val moveSpeed: MoveSpeedAttributes = MoveSpeedAttributes()
	
			open class AimingMovespeedAttributes : BaseGunAttributes.MovementAttributes.MoveSpeedAttributes.AimingMovespeedAttributes() 
	
			open class MoveSpeedAttributes : BaseGunAttributes.MovementAttributes.MoveSpeedAttributes.MoveSpeedAttributes() 
		}
	
		open class jumpHeightAttributes : BaseGunAttributes.MovementAttributes.jumpHeightAttributes() 
	}
	
	open class AmmoAttributes : BaseGunAttributes.AmmoAttributes() {
		/**
		 * Bonus:
		 * 
		 * 	- In-Game: "N% flamethrower ammo consumed per second"
		 * 
		 * Penalty:
		 * 
		 * 	- In-Game: "+N% flamethrower ammo consumed per second"
		 */
		open val flameAmmopersec: BonusPenalty<Number> = BonusPenalty(
			ItemAttributeNamed("flame ammopersec decreased"),
			ItemAttributeNamed("flame ammopersec increased"),
		)
	
		override val clipSize: ClipSizeAttributes = ClipSizeAttributes()
	
		override val maxAmmo: MaxAmmoAttributes = MaxAmmoAttributes()
	
		open class ClipSizeAttributes : BaseGunAttributes.AmmoAttributes.ClipSizeAttributes() 
	
		open class MaxAmmoAttributes : BaseGunAttributes.AmmoAttributes.MaxAmmoAttributes() 
	}
	
	open class HealthAndHealingAttributes : BaseGunAttributes.HealthAndHealingAttributes() {
		/**
		 * In-Game: "Extinguishing teammates restores N health"
		 * 
		 * How much health your extinguish restores.
		 */
		open val extinguishRestoresHealth: ItemAttributeNamed<Int> = ItemAttributeNamed("extinguish restores health")
	
		override val healthRegen: HealthRegenAttributes = HealthRegenAttributes()
	
		override val maxHealthAdditive: MaxHealthAdditiveAttributes = MaxHealthAdditiveAttributes()
	
		open class HealthRegenAttributes : BaseGunAttributes.HealthAndHealingAttributes.HealthRegenAttributes() 
	
		open class MaxHealthAdditiveAttributes : BaseGunAttributes.HealthAndHealingAttributes.MaxHealthAdditiveAttributes() 
	}
	
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
	
	open class FiringAttributes : BaseGunAttributes.FiringAttributes() {
		override val fireRate: FireRateAttributes = FireRateAttributes()
	
		open class FireRateAttributes : BaseGunAttributes.FiringAttributes.FireRateAttributes() 
	}
	
	open class FlamesAttributes : IBlockScoped {
		open val flameSpreadDegree: ItemAttributeNamed<Number> = ItemAttributeNamed("flame_spread_degree")
	
		open val redirectedFlameSizeMult: ItemAttributeNamed<Number> = ItemAttributeNamed("redirected_flame_size_mult")
	
		/**
		 * Bonus:
		 * 
		 * 	- In-Game: "+N% more flame spread area"
		 * 
		 * Penalty:
		 * 
		 * 	- In-Game: "N% less flame spread area"
		 */
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
	
		/**
		 * Bonus:
		 * 
		 * 	- In-Game: "+N% more flame distance"
		 * 
		 * Penalty:
		 * 
		 * 	- In-Game: "N% less flame distance"
		 */
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
		override val alien: AlienAttributes = AlienAttributes()
	
		open class AlienAttributes : BaseGunAttributes.DamageAttributes.AlienAttributes() 
	}
	
	open class ProjectilesAttributes : BaseGunAttributes.ProjectilesAttributes() {
		override val bullets: BulletsAttributes = BulletsAttributes()
	
		override val projectilePenetration: ProjectilePenetrationAttributes = ProjectilePenetrationAttributes()
	
		open class BulletsAttributes : BaseGunAttributes.ProjectilesAttributes.BulletsAttributes() 
	
		open class ProjectilePenetrationAttributes : BaseGunAttributes.ProjectilesAttributes.ProjectilePenetrationAttributes() 
	}
	
	open class AfterburnAttributes : BaseGunAttributes.AfterburnAttributes() 
	
	open class BuildingsAttributes : BaseGunAttributes.BuildingsAttributes() {
		override val sentryGun: SentryGunAttributes = SentryGunAttributes()
	
		override val dispenser: DispenserAttributes = DispenserAttributes()
	
		override val teleporter: TeleporterAttributes = TeleporterAttributes()
	
		open class SentryGunAttributes : BaseGunAttributes.BuildingsAttributes.SentryGunAttributes() 
	
		open class DispenserAttributes : BaseGunAttributes.BuildingsAttributes.DispenserAttributes() 
	
		open class TeleporterAttributes : BaseGunAttributes.BuildingsAttributes.TeleporterAttributes() 
	}
	
	open class DemoChargeAttributes : BaseGunAttributes.DemoChargeAttributes() {
		override val multChargeTurnControl: MultChargeTurnControlAttributes = MultChargeTurnControlAttributes()
	
		open class MultChargeTurnControlAttributes : BaseGunAttributes.DemoChargeAttributes.MultChargeTurnControlAttributes() 
	}
	
	open class KnockbackReceivedAttributes : BaseGunAttributes.KnockbackReceivedAttributes() {
		override val damageForceReduction: DamageForceReductionAttributes = DamageForceReductionAttributes()
	
		open class DamageForceReductionAttributes : BaseGunAttributes.KnockbackReceivedAttributes.DamageForceReductionAttributes() 
	}
	
	open class MetaAttributes : BaseGunAttributes.MetaAttributes() {
		override val killfeed: KillfeedAttributes = KillfeedAttributes()
	
		override val viewmodel: ViewmodelAttributes = ViewmodelAttributes()
	
		override val items: ItemsAttributes = ItemsAttributes()
	
		override val particles: ParticlesAttributes = ParticlesAttributes()
	
		override val noisemakers: NoisemakersAttributes = NoisemakersAttributes()
	
		override val player: PlayerAttributes = PlayerAttributes()
	
		override val gameplay: GameplayAttributes = GameplayAttributes()
	
		open class KillfeedAttributes : BaseGunAttributes.MetaAttributes.KillfeedAttributes() 
	
		open class ViewmodelAttributes : BaseGunAttributes.MetaAttributes.ViewmodelAttributes() 
	
		open class ItemsAttributes : BaseGunAttributes.MetaAttributes.ItemsAttributes() 
	
		open class ParticlesAttributes : BaseGunAttributes.MetaAttributes.ParticlesAttributes() 
	
		open class NoisemakersAttributes : BaseGunAttributes.MetaAttributes.NoisemakersAttributes() 
	
		open class PlayerAttributes : BaseGunAttributes.MetaAttributes.PlayerAttributes() 
	
		open class GameplayAttributes : BaseGunAttributes.MetaAttributes.GameplayAttributes() 
	}
	
	open class MeterAttributes : BaseGunAttributes.MeterAttributes() {
		override val generateRageOnDamage: GenerateRageOnDamageAttributes = GenerateRageOnDamageAttributes()
	
		open class GenerateRageOnDamageAttributes : BaseGunAttributes.MeterAttributes.GenerateRageOnDamageAttributes() 
	}
	
	open class HeadsAttributes : BaseGunAttributes.HeadsAttributes() 
	
	open class OnHitAttributes : BaseGunAttributes.OnHitAttributes() {
		override val healOnHitForRapidfire: HealOnHitForRapidfireAttributes = HealOnHitForRapidfireAttributes()
	
		override val generateRageOnDamage: GenerateRageOnDamageAttributes = GenerateRageOnDamageAttributes()
	
		override val falling: FallingAttributes = FallingAttributes()
	
		open class HealOnHitForRapidfireAttributes : BaseGunAttributes.OnHitAttributes.HealOnHitForRapidfireAttributes() 
	
		open class GenerateRageOnDamageAttributes : BaseGunAttributes.OnHitAttributes.GenerateRageOnDamageAttributes() 
	
		open class FallingAttributes : BaseGunAttributes.OnHitAttributes.FallingAttributes() 
	}
	
	open class OnKillAttributes : BaseGunAttributes.OnKillAttributes() 
	
	open class ReloadingAttributes : BaseGunAttributes.ReloadingAttributes() 
	
	open class ResistanceAttributes : BaseGunAttributes.ResistanceAttributes() {
		override val dmgTakenFromCritReduced: DmgTakenFromCritReducedAttributes = DmgTakenFromCritReducedAttributes()
	
		override val dmgTakenFromFireReduced: DmgTakenFromFireReducedAttributes = DmgTakenFromFireReducedAttributes()
	
		override val dmgTakenFromBulletsReduced: DmgTakenFromBulletsReducedAttributes = DmgTakenFromBulletsReducedAttributes()
	
		override val vaccinator: VaccinatorAttributes = VaccinatorAttributes()
	
		open class DmgTakenFromCritReducedAttributes : BaseGunAttributes.ResistanceAttributes.DmgTakenFromCritReducedAttributes() 
	
		open class DmgTakenFromFireReducedAttributes : BaseGunAttributes.ResistanceAttributes.DmgTakenFromFireReducedAttributes() 
	
		open class DmgTakenFromBulletsReducedAttributes : BaseGunAttributes.ResistanceAttributes.DmgTakenFromBulletsReducedAttributes() 
	
		open class VaccinatorAttributes : BaseGunAttributes.ResistanceAttributes.VaccinatorAttributes() 
	}
	
	open class RevengeCritsAttributes : BaseGunAttributes.RevengeCritsAttributes() 
	
	open class StatusEffectsAttributes : BaseGunAttributes.StatusEffectsAttributes() 
	
	open class TauntingAttributes : BaseGunAttributes.TauntingAttributes() 
	
	open class SwapWeaponsAttributes : BaseGunAttributes.SwapWeaponsAttributes() {
		override val deploy: DeployAttributes = DeployAttributes()
	
		open class DeployAttributes : BaseGunAttributes.SwapWeaponsAttributes.DeployAttributes() 
	}
	
	open class WhenHitAttributes : BaseGunAttributes.WhenHitAttributes() 
	
	open class RagdollsAttributes : BaseGunAttributes.RagdollsAttributes() 
	
	open class BuffItemsAttributes : BaseGunAttributes.BuffItemsAttributes() 
	
	open class CloakAttributes : BaseGunAttributes.CloakAttributes() 
	
	open class DisguiseAttributes : BaseGunAttributes.DisguiseAttributes() 
	
	open class HudAttributes : BaseGunAttributes.HudAttributes() 
	
	open class SpyOnlyAttributes : BaseGunAttributes.SpyOnlyAttributes() 
	
	object Inherited : FlamethrowerAttributes 
}