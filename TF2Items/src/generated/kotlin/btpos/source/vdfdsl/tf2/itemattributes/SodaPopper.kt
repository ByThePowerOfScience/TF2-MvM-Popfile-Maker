package btpos.source.vdfdsl.tf2.itemattributes

import btpos.source.vdfdsl.modeling.*
import btpos.source.vdfdsl.serialization.codecs.*
import btpos.source.vdfdsl.tf2.itemattributes.impl.*
import btpos.source.vdfdsl.tf2.tftypes.*
import java.util.*
import kotlin.time.Duration

interface SodaPopperAttributes : IBlockScoped, ScattergunAttributes {
	companion object : IBlockScoped {
		private val onHit: OnHitAttributes = OnHitAttributes()
	
		private val reloading: ReloadingAttributes = ReloadingAttributes()
	
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
	
		private val onKill: OnKillAttributes = OnKillAttributes()
	
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

	override val onHit: OnHitAttributes get() = SodaPopperAttributes.onHit
	
	override val reloading: ReloadingAttributes get() = SodaPopperAttributes.reloading
	
	override val ammo: AmmoAttributes get() = SodaPopperAttributes.ammo
	
	override val damage: DamageAttributes get() = SodaPopperAttributes.damage
	
	override val firing: FiringAttributes get() = SodaPopperAttributes.firing
	
	override val projectiles: ProjectilesAttributes get() = SodaPopperAttributes.projectiles
	
	override val afterburn: AfterburnAttributes get() = SodaPopperAttributes.afterburn
	
	override val buildings: BuildingsAttributes get() = SodaPopperAttributes.buildings
	
	override val crits: CritsAttributes get() = SodaPopperAttributes.crits
	
	override val demoCharge: DemoChargeAttributes get() = SodaPopperAttributes.demoCharge
	
	override val healthAndHealing: HealthAndHealingAttributes get() = SodaPopperAttributes.healthAndHealing
	
	override val knockbackReceived: KnockbackReceivedAttributes get() = SodaPopperAttributes.knockbackReceived
	
	override val meta: MetaAttributes get() = SodaPopperAttributes.meta
	
	override val meter: MeterAttributes get() = SodaPopperAttributes.meter
	
	override val movement: MovementAttributes get() = SodaPopperAttributes.movement
	
	override val heads: HeadsAttributes get() = SodaPopperAttributes.heads
	
	override val onKill: OnKillAttributes get() = SodaPopperAttributes.onKill
	
	override val resistance: ResistanceAttributes get() = SodaPopperAttributes.resistance
	
	override val revengeCrits: RevengeCritsAttributes get() = SodaPopperAttributes.revengeCrits
	
	override val statusEffects: StatusEffectsAttributes get() = SodaPopperAttributes.statusEffects
	
	override val taunting: TauntingAttributes get() = SodaPopperAttributes.taunting
	
	override val swapWeapons: SwapWeaponsAttributes get() = SodaPopperAttributes.swapWeapons
	
	override val whenHit: WhenHitAttributes get() = SodaPopperAttributes.whenHit
	
	override val ragdolls: RagdollsAttributes get() = SodaPopperAttributes.ragdolls
	
	override val buffItems: BuffItemsAttributes get() = SodaPopperAttributes.buffItems
	
	override val cloak: CloakAttributes get() = SodaPopperAttributes.cloak
	
	override val disguise: DisguiseAttributes get() = SodaPopperAttributes.disguise
	
	override val hud: HudAttributes get() = SodaPopperAttributes.hud
	
	override val spyOnly: SpyOnlyAttributes get() = SodaPopperAttributes.spyOnly

	open class OnHitAttributes : ScattergunAttributes.OnHitAttributes() {
		override val healOnHitForRapidfire: HealOnHitForRapidfireAttributes = HealOnHitForRapidfireAttributes()
	
		override val generateRageOnDamage: GenerateRageOnDamageAttributes = GenerateRageOnDamageAttributes()
	
		override val falling: FallingAttributes = FallingAttributes()
	
		open class HealOnHitForRapidfireAttributes : ScattergunAttributes.OnHitAttributes.HealOnHitForRapidfireAttributes() 
	
		open class GenerateRageOnDamageAttributes : ScattergunAttributes.OnHitAttributes.GenerateRageOnDamageAttributes() 
	
		open class FallingAttributes : ScattergunAttributes.OnHitAttributes.FallingAttributes() 
	}
	
	open class ReloadingAttributes : ScattergunAttributes.ReloadingAttributes() 
	
	open class AmmoAttributes : ScattergunAttributes.AmmoAttributes() {
		override val clipSize: ClipSizeAttributes = ClipSizeAttributes()
	
		override val maxAmmo: MaxAmmoAttributes = MaxAmmoAttributes()
	
		open class ClipSizeAttributes : ScattergunAttributes.AmmoAttributes.ClipSizeAttributes() 
	
		open class MaxAmmoAttributes : ScattergunAttributes.AmmoAttributes.MaxAmmoAttributes() 
	}
	
	open class DamageAttributes : ScattergunAttributes.DamageAttributes() {
		override val alien: AlienAttributes = AlienAttributes()
	
		open class AlienAttributes : ScattergunAttributes.DamageAttributes.AlienAttributes() 
	}
	
	open class FiringAttributes : ScattergunAttributes.FiringAttributes() {
		override val fireRate: FireRateAttributes = FireRateAttributes()
	
		open class FireRateAttributes : ScattergunAttributes.FiringAttributes.FireRateAttributes() 
	}
	
	open class ProjectilesAttributes : ScattergunAttributes.ProjectilesAttributes() {
		override val bullets: BulletsAttributes = BulletsAttributes()
	
		override val projectilePenetration: ProjectilePenetrationAttributes = ProjectilePenetrationAttributes()
	
		open class BulletsAttributes : ScattergunAttributes.ProjectilesAttributes.BulletsAttributes() 
	
		open class ProjectilePenetrationAttributes : ScattergunAttributes.ProjectilesAttributes.ProjectilePenetrationAttributes() 
	}
	
	open class AfterburnAttributes : ScattergunAttributes.AfterburnAttributes() 
	
	open class BuildingsAttributes : ScattergunAttributes.BuildingsAttributes() {
		override val sentryGun: SentryGunAttributes = SentryGunAttributes()
	
		override val dispenser: DispenserAttributes = DispenserAttributes()
	
		override val teleporter: TeleporterAttributes = TeleporterAttributes()
	
		open class SentryGunAttributes : ScattergunAttributes.BuildingsAttributes.SentryGunAttributes() 
	
		open class DispenserAttributes : ScattergunAttributes.BuildingsAttributes.DispenserAttributes() 
	
		open class TeleporterAttributes : ScattergunAttributes.BuildingsAttributes.TeleporterAttributes() 
	}
	
	open class CritsAttributes : ScattergunAttributes.CritsAttributes() 
	
	open class DemoChargeAttributes : ScattergunAttributes.DemoChargeAttributes() {
		override val multChargeTurnControl: MultChargeTurnControlAttributes = MultChargeTurnControlAttributes()
	
		open class MultChargeTurnControlAttributes : ScattergunAttributes.DemoChargeAttributes.MultChargeTurnControlAttributes() 
	}
	
	open class HealthAndHealingAttributes : ScattergunAttributes.HealthAndHealingAttributes() {
		override val healthRegen: HealthRegenAttributes = HealthRegenAttributes()
	
		override val maxHealthAdditive: MaxHealthAdditiveAttributes = MaxHealthAdditiveAttributes()
	
		open class HealthRegenAttributes : ScattergunAttributes.HealthAndHealingAttributes.HealthRegenAttributes() 
	
		open class MaxHealthAdditiveAttributes : ScattergunAttributes.HealthAndHealingAttributes.MaxHealthAdditiveAttributes() 
	}
	
	open class KnockbackReceivedAttributes : ScattergunAttributes.KnockbackReceivedAttributes() {
		override val damageForceReduction: DamageForceReductionAttributes = DamageForceReductionAttributes()
	
		open class DamageForceReductionAttributes : ScattergunAttributes.KnockbackReceivedAttributes.DamageForceReductionAttributes() 
	}
	
	open class MetaAttributes : ScattergunAttributes.MetaAttributes() {
		override val killfeed: KillfeedAttributes = KillfeedAttributes()
	
		override val viewmodel: ViewmodelAttributes = ViewmodelAttributes()
	
		override val items: ItemsAttributes = ItemsAttributes()
	
		override val particles: ParticlesAttributes = ParticlesAttributes()
	
		override val noisemakers: NoisemakersAttributes = NoisemakersAttributes()
	
		override val player: PlayerAttributes = PlayerAttributes()
	
		override val gameplay: GameplayAttributes = GameplayAttributes()
	
		open class KillfeedAttributes : ScattergunAttributes.MetaAttributes.KillfeedAttributes() 
	
		open class ViewmodelAttributes : ScattergunAttributes.MetaAttributes.ViewmodelAttributes() 
	
		open class ItemsAttributes : ScattergunAttributes.MetaAttributes.ItemsAttributes() 
	
		open class ParticlesAttributes : ScattergunAttributes.MetaAttributes.ParticlesAttributes() 
	
		open class NoisemakersAttributes : ScattergunAttributes.MetaAttributes.NoisemakersAttributes() 
	
		open class PlayerAttributes : ScattergunAttributes.MetaAttributes.PlayerAttributes() 
	
		open class GameplayAttributes : ScattergunAttributes.MetaAttributes.GameplayAttributes() 
	}
	
	open class MeterAttributes : ScattergunAttributes.MeterAttributes() {
		override val generateRageOnDamage: GenerateRageOnDamageAttributes = GenerateRageOnDamageAttributes()
	
		open class GenerateRageOnDamageAttributes : ScattergunAttributes.MeterAttributes.GenerateRageOnDamageAttributes() 
	}
	
	open class MovementAttributes : ScattergunAttributes.MovementAttributes() {
		override val moveSpeed: MoveSpeedAttributes = MoveSpeedAttributes()
	
		override val jumpHeight: jumpHeightAttributes = jumpHeightAttributes()
	
		open class MoveSpeedAttributes : ScattergunAttributes.MovementAttributes.MoveSpeedAttributes() {
			override val aimingMovespeed: AimingMovespeedAttributes = AimingMovespeedAttributes()
	
			override val moveSpeed: MoveSpeedAttributes = MoveSpeedAttributes()
	
			open class AimingMovespeedAttributes : ScattergunAttributes.MovementAttributes.MoveSpeedAttributes.AimingMovespeedAttributes() 
	
			open class MoveSpeedAttributes : ScattergunAttributes.MovementAttributes.MoveSpeedAttributes.MoveSpeedAttributes() 
		}
	
		open class jumpHeightAttributes : ScattergunAttributes.MovementAttributes.jumpHeightAttributes() 
	}
	
	open class HeadsAttributes : ScattergunAttributes.HeadsAttributes() 
	
	open class OnKillAttributes : ScattergunAttributes.OnKillAttributes() 
	
	open class ResistanceAttributes : ScattergunAttributes.ResistanceAttributes() {
		override val dmgTakenFromCritReduced: DmgTakenFromCritReducedAttributes = DmgTakenFromCritReducedAttributes()
	
		override val dmgTakenFromFireReduced: DmgTakenFromFireReducedAttributes = DmgTakenFromFireReducedAttributes()
	
		override val dmgTakenFromBulletsReduced: DmgTakenFromBulletsReducedAttributes = DmgTakenFromBulletsReducedAttributes()
	
		override val vaccinator: VaccinatorAttributes = VaccinatorAttributes()
	
		open class DmgTakenFromCritReducedAttributes : ScattergunAttributes.ResistanceAttributes.DmgTakenFromCritReducedAttributes() 
	
		open class DmgTakenFromFireReducedAttributes : ScattergunAttributes.ResistanceAttributes.DmgTakenFromFireReducedAttributes() 
	
		open class DmgTakenFromBulletsReducedAttributes : ScattergunAttributes.ResistanceAttributes.DmgTakenFromBulletsReducedAttributes() 
	
		open class VaccinatorAttributes : ScattergunAttributes.ResistanceAttributes.VaccinatorAttributes() 
	}
	
	open class RevengeCritsAttributes : ScattergunAttributes.RevengeCritsAttributes() 
	
	open class StatusEffectsAttributes : ScattergunAttributes.StatusEffectsAttributes() 
	
	open class TauntingAttributes : ScattergunAttributes.TauntingAttributes() 
	
	open class SwapWeaponsAttributes : ScattergunAttributes.SwapWeaponsAttributes() {
		override val deploy: DeployAttributes = DeployAttributes()
	
		open class DeployAttributes : ScattergunAttributes.SwapWeaponsAttributes.DeployAttributes() 
	}
	
	open class WhenHitAttributes : ScattergunAttributes.WhenHitAttributes() 
	
	open class RagdollsAttributes : ScattergunAttributes.RagdollsAttributes() 
	
	open class BuffItemsAttributes : ScattergunAttributes.BuffItemsAttributes() 
	
	open class CloakAttributes : ScattergunAttributes.CloakAttributes() 
	
	open class DisguiseAttributes : ScattergunAttributes.DisguiseAttributes() 
	
	open class HudAttributes : ScattergunAttributes.HudAttributes() 
	
	open class SpyOnlyAttributes : ScattergunAttributes.SpyOnlyAttributes() 
	
	object Inherited : SodaPopperAttributes 
}