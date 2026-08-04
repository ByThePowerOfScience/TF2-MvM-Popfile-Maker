package btpos.source.vdfdsl.tf2.itemattributes

import btpos.source.vdfdsl.modeling.*
import btpos.source.vdfdsl.serialization.codecs.*
import btpos.source.vdfdsl.tf2.itemattributes.impl.*
import btpos.source.vdfdsl.tf2.tftypes.*
import java.util.*
import kotlin.time.Duration

interface ScoutPistolPrimaryAttributes : IBlockScoped, ScoutPistolAttributes {
	companion object : IBlockScoped {
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
	
		private val buffItems: BuffItemsAttributes = BuffItemsAttributes()
	
		private val cloak: CloakAttributes = CloakAttributes()
	
		private val disguise: DisguiseAttributes = DisguiseAttributes()
	
		private val hud: HudAttributes = HudAttributes()
	
		private val spyOnly: SpyOnlyAttributes = SpyOnlyAttributes()
	}

	override val ammo: AmmoAttributes get() = ScoutPistolPrimaryAttributes.ammo
	
	override val damage: DamageAttributes get() = ScoutPistolPrimaryAttributes.damage
	
	override val firing: FiringAttributes get() = ScoutPistolPrimaryAttributes.firing
	
	override val projectiles: ProjectilesAttributes get() = ScoutPistolPrimaryAttributes.projectiles
	
	override val afterburn: AfterburnAttributes get() = ScoutPistolPrimaryAttributes.afterburn
	
	override val buildings: BuildingsAttributes get() = ScoutPistolPrimaryAttributes.buildings
	
	override val crits: CritsAttributes get() = ScoutPistolPrimaryAttributes.crits
	
	override val demoCharge: DemoChargeAttributes get() = ScoutPistolPrimaryAttributes.demoCharge
	
	override val healthAndHealing: HealthAndHealingAttributes get() = ScoutPistolPrimaryAttributes.healthAndHealing
	
	override val knockbackReceived: KnockbackReceivedAttributes get() = ScoutPistolPrimaryAttributes.knockbackReceived
	
	override val meta: MetaAttributes get() = ScoutPistolPrimaryAttributes.meta
	
	override val meter: MeterAttributes get() = ScoutPistolPrimaryAttributes.meter
	
	override val movement: MovementAttributes get() = ScoutPistolPrimaryAttributes.movement
	
	override val heads: HeadsAttributes get() = ScoutPistolPrimaryAttributes.heads
	
	override val onHit: OnHitAttributes get() = ScoutPistolPrimaryAttributes.onHit
	
	override val onKill: OnKillAttributes get() = ScoutPistolPrimaryAttributes.onKill
	
	override val reloading: ReloadingAttributes get() = ScoutPistolPrimaryAttributes.reloading
	
	override val resistance: ResistanceAttributes get() = ScoutPistolPrimaryAttributes.resistance
	
	override val revengeCrits: RevengeCritsAttributes get() = ScoutPistolPrimaryAttributes.revengeCrits
	
	override val statusEffects: StatusEffectsAttributes get() = ScoutPistolPrimaryAttributes.statusEffects
	
	override val taunting: TauntingAttributes get() = ScoutPistolPrimaryAttributes.taunting
	
	override val swapWeapons: SwapWeaponsAttributes get() = ScoutPistolPrimaryAttributes.swapWeapons
	
	override val whenHit: WhenHitAttributes get() = ScoutPistolPrimaryAttributes.whenHit
	
	override val ragdolls: RagdollsAttributes get() = ScoutPistolPrimaryAttributes.ragdolls
	
	override val buffItems: BuffItemsAttributes get() = ScoutPistolPrimaryAttributes.buffItems
	
	override val cloak: CloakAttributes get() = ScoutPistolPrimaryAttributes.cloak
	
	override val disguise: DisguiseAttributes get() = ScoutPistolPrimaryAttributes.disguise
	
	override val hud: HudAttributes get() = ScoutPistolPrimaryAttributes.hud
	
	override val spyOnly: SpyOnlyAttributes get() = ScoutPistolPrimaryAttributes.spyOnly

	open class AmmoAttributes : ScoutPistolAttributes.AmmoAttributes() {
		override val clipSize: ClipSizeAttributes = ClipSizeAttributes()
	
		override val maxAmmo: MaxAmmoAttributes = MaxAmmoAttributes()
	
		open class ClipSizeAttributes : ScoutPistolAttributes.AmmoAttributes.ClipSizeAttributes() 
	
		open class MaxAmmoAttributes : ScoutPistolAttributes.AmmoAttributes.MaxAmmoAttributes() 
	}
	
	open class DamageAttributes : ScoutPistolAttributes.DamageAttributes() {
		override val alien: AlienAttributes = AlienAttributes()
	
		open class AlienAttributes : ScoutPistolAttributes.DamageAttributes.AlienAttributes() 
	}
	
	open class FiringAttributes : ScoutPistolAttributes.FiringAttributes() {
		override val fireRate: FireRateAttributes = FireRateAttributes()
	
		open class FireRateAttributes : ScoutPistolAttributes.FiringAttributes.FireRateAttributes() 
	}
	
	open class ProjectilesAttributes : ScoutPistolAttributes.ProjectilesAttributes() {
		override val bullets: BulletsAttributes = BulletsAttributes()
	
		override val projectilePenetration: ProjectilePenetrationAttributes = ProjectilePenetrationAttributes()
	
		open class BulletsAttributes : ScoutPistolAttributes.ProjectilesAttributes.BulletsAttributes() 
	
		open class ProjectilePenetrationAttributes : ScoutPistolAttributes.ProjectilesAttributes.ProjectilePenetrationAttributes() 
	}
	
	open class AfterburnAttributes : ScoutPistolAttributes.AfterburnAttributes() 
	
	open class BuildingsAttributes : ScoutPistolAttributes.BuildingsAttributes() {
		override val sentryGun: SentryGunAttributes = SentryGunAttributes()
	
		override val dispenser: DispenserAttributes = DispenserAttributes()
	
		override val teleporter: TeleporterAttributes = TeleporterAttributes()
	
		open class SentryGunAttributes : ScoutPistolAttributes.BuildingsAttributes.SentryGunAttributes() 
	
		open class DispenserAttributes : ScoutPistolAttributes.BuildingsAttributes.DispenserAttributes() 
	
		open class TeleporterAttributes : ScoutPistolAttributes.BuildingsAttributes.TeleporterAttributes() 
	}
	
	open class CritsAttributes : ScoutPistolAttributes.CritsAttributes() 
	
	open class DemoChargeAttributes : ScoutPistolAttributes.DemoChargeAttributes() {
		override val multChargeTurnControl: MultChargeTurnControlAttributes = MultChargeTurnControlAttributes()
	
		open class MultChargeTurnControlAttributes : ScoutPistolAttributes.DemoChargeAttributes.MultChargeTurnControlAttributes() 
	}
	
	open class HealthAndHealingAttributes : ScoutPistolAttributes.HealthAndHealingAttributes() {
		override val healthRegen: HealthRegenAttributes = HealthRegenAttributes()
	
		override val maxHealthAdditive: MaxHealthAdditiveAttributes = MaxHealthAdditiveAttributes()
	
		open class HealthRegenAttributes : ScoutPistolAttributes.HealthAndHealingAttributes.HealthRegenAttributes() 
	
		open class MaxHealthAdditiveAttributes : ScoutPistolAttributes.HealthAndHealingAttributes.MaxHealthAdditiveAttributes() 
	}
	
	open class KnockbackReceivedAttributes : ScoutPistolAttributes.KnockbackReceivedAttributes() {
		override val damageForceReduction: DamageForceReductionAttributes = DamageForceReductionAttributes()
	
		open class DamageForceReductionAttributes : ScoutPistolAttributes.KnockbackReceivedAttributes.DamageForceReductionAttributes() 
	}
	
	open class MetaAttributes : ScoutPistolAttributes.MetaAttributes() {
		override val killfeed: KillfeedAttributes = KillfeedAttributes()
	
		override val viewmodel: ViewmodelAttributes = ViewmodelAttributes()
	
		override val items: ItemsAttributes = ItemsAttributes()
	
		override val particles: ParticlesAttributes = ParticlesAttributes()
	
		override val noisemakers: NoisemakersAttributes = NoisemakersAttributes()
	
		override val player: PlayerAttributes = PlayerAttributes()
	
		override val gameplay: GameplayAttributes = GameplayAttributes()
	
		open class KillfeedAttributes : ScoutPistolAttributes.MetaAttributes.KillfeedAttributes() 
	
		open class ViewmodelAttributes : ScoutPistolAttributes.MetaAttributes.ViewmodelAttributes() 
	
		open class ItemsAttributes : ScoutPistolAttributes.MetaAttributes.ItemsAttributes() 
	
		open class ParticlesAttributes : ScoutPistolAttributes.MetaAttributes.ParticlesAttributes() 
	
		open class NoisemakersAttributes : ScoutPistolAttributes.MetaAttributes.NoisemakersAttributes() 
	
		open class PlayerAttributes : ScoutPistolAttributes.MetaAttributes.PlayerAttributes() 
	
		open class GameplayAttributes : ScoutPistolAttributes.MetaAttributes.GameplayAttributes() 
	}
	
	open class MeterAttributes : ScoutPistolAttributes.MeterAttributes() {
		override val generateRageOnDamage: GenerateRageOnDamageAttributes = GenerateRageOnDamageAttributes()
	
		open class GenerateRageOnDamageAttributes : ScoutPistolAttributes.MeterAttributes.GenerateRageOnDamageAttributes() 
	}
	
	open class MovementAttributes : ScoutPistolAttributes.MovementAttributes() {
		override val moveSpeed: MoveSpeedAttributes = MoveSpeedAttributes()
	
		override val jumpHeight: jumpHeightAttributes = jumpHeightAttributes()
	
		open class MoveSpeedAttributes : ScoutPistolAttributes.MovementAttributes.MoveSpeedAttributes() {
			override val aimingMovespeed: AimingMovespeedAttributes = AimingMovespeedAttributes()
	
			override val moveSpeed: MoveSpeedAttributes = MoveSpeedAttributes()
	
			open class AimingMovespeedAttributes : ScoutPistolAttributes.MovementAttributes.MoveSpeedAttributes.AimingMovespeedAttributes() 
	
			open class MoveSpeedAttributes : ScoutPistolAttributes.MovementAttributes.MoveSpeedAttributes.MoveSpeedAttributes() 
		}
	
		open class jumpHeightAttributes : ScoutPistolAttributes.MovementAttributes.jumpHeightAttributes() 
	}
	
	open class HeadsAttributes : ScoutPistolAttributes.HeadsAttributes() 
	
	open class OnHitAttributes : ScoutPistolAttributes.OnHitAttributes() {
		override val healOnHitForRapidfire: HealOnHitForRapidfireAttributes = HealOnHitForRapidfireAttributes()
	
		override val generateRageOnDamage: GenerateRageOnDamageAttributes = GenerateRageOnDamageAttributes()
	
		override val falling: FallingAttributes = FallingAttributes()
	
		open class HealOnHitForRapidfireAttributes : ScoutPistolAttributes.OnHitAttributes.HealOnHitForRapidfireAttributes() 
	
		open class GenerateRageOnDamageAttributes : ScoutPistolAttributes.OnHitAttributes.GenerateRageOnDamageAttributes() 
	
		open class FallingAttributes : ScoutPistolAttributes.OnHitAttributes.FallingAttributes() 
	}
	
	open class OnKillAttributes : ScoutPistolAttributes.OnKillAttributes() 
	
	open class ReloadingAttributes : ScoutPistolAttributes.ReloadingAttributes() 
	
	open class ResistanceAttributes : ScoutPistolAttributes.ResistanceAttributes() {
		override val dmgTakenFromCritReduced: DmgTakenFromCritReducedAttributes = DmgTakenFromCritReducedAttributes()
	
		override val dmgTakenFromFireReduced: DmgTakenFromFireReducedAttributes = DmgTakenFromFireReducedAttributes()
	
		override val dmgTakenFromBulletsReduced: DmgTakenFromBulletsReducedAttributes = DmgTakenFromBulletsReducedAttributes()
	
		override val vaccinator: VaccinatorAttributes = VaccinatorAttributes()
	
		open class DmgTakenFromCritReducedAttributes : ScoutPistolAttributes.ResistanceAttributes.DmgTakenFromCritReducedAttributes() 
	
		open class DmgTakenFromFireReducedAttributes : ScoutPistolAttributes.ResistanceAttributes.DmgTakenFromFireReducedAttributes() 
	
		open class DmgTakenFromBulletsReducedAttributes : ScoutPistolAttributes.ResistanceAttributes.DmgTakenFromBulletsReducedAttributes() 
	
		open class VaccinatorAttributes : ScoutPistolAttributes.ResistanceAttributes.VaccinatorAttributes() 
	}
	
	open class RevengeCritsAttributes : ScoutPistolAttributes.RevengeCritsAttributes() 
	
	open class StatusEffectsAttributes : ScoutPistolAttributes.StatusEffectsAttributes() 
	
	open class TauntingAttributes : ScoutPistolAttributes.TauntingAttributes() 
	
	open class SwapWeaponsAttributes : ScoutPistolAttributes.SwapWeaponsAttributes() {
		override val deploy: DeployAttributes = DeployAttributes()
	
		open class DeployAttributes : ScoutPistolAttributes.SwapWeaponsAttributes.DeployAttributes() 
	}
	
	open class WhenHitAttributes : ScoutPistolAttributes.WhenHitAttributes() 
	
	open class RagdollsAttributes : ScoutPistolAttributes.RagdollsAttributes() 
	
	open class BuffItemsAttributes : ScoutPistolAttributes.BuffItemsAttributes() 
	
	open class CloakAttributes : ScoutPistolAttributes.CloakAttributes() 
	
	open class DisguiseAttributes : ScoutPistolAttributes.DisguiseAttributes() 
	
	open class HudAttributes : ScoutPistolAttributes.HudAttributes() 
	
	open class SpyOnlyAttributes : ScoutPistolAttributes.SpyOnlyAttributes() 
	
	object Inherited : ScoutPistolPrimaryAttributes 
}