package btpos.source.vdfdsl.tf2.itemattributes

import btpos.source.vdfdsl.modeling.*
import btpos.source.vdfdsl.serialization.codecs.*
import btpos.source.vdfdsl.tf2.itemattributes.impl.*
import btpos.source.vdfdsl.tf2.tftypes.*
import java.util.*
import kotlin.time.Duration

interface BreakableSignAttributes : IBlockScoped, BreakableMeleeAttributes {
	companion object : IBlockScoped {
		private val crits: CritsAttributes = CritsAttributes()
	
		private val damage: DamageAttributes = DamageAttributes()
	
		private val onHit: OnHitAttributes = OnHitAttributes()
	
		private val swapWeapons: SwapWeaponsAttributes = SwapWeaponsAttributes()
	
		private val afterburn: AfterburnAttributes = AfterburnAttributes()
	
		private val ammo: AmmoAttributes = AmmoAttributes()
	
		private val buildings: BuildingsAttributes = BuildingsAttributes()
	
		private val demoCharge: DemoChargeAttributes = DemoChargeAttributes()
	
		private val firing: FiringAttributes = FiringAttributes()
	
		private val healthAndHealing: HealthAndHealingAttributes = HealthAndHealingAttributes()
	
		private val knockbackReceived: KnockbackReceivedAttributes = KnockbackReceivedAttributes()
	
		private val meta: MetaAttributes = MetaAttributes()
	
		private val meter: MeterAttributes = MeterAttributes()
	
		private val movement: MovementAttributes = MovementAttributes()
	
		private val heads: HeadsAttributes = HeadsAttributes()
	
		private val onKill: OnKillAttributes = OnKillAttributes()
	
		private val projectiles: ProjectilesAttributes = ProjectilesAttributes()
	
		private val reloading: ReloadingAttributes = ReloadingAttributes()
	
		private val resistance: ResistanceAttributes = ResistanceAttributes()
	
		private val revengeCrits: RevengeCritsAttributes = RevengeCritsAttributes()
	
		private val statusEffects: StatusEffectsAttributes = StatusEffectsAttributes()
	
		private val taunting: TauntingAttributes = TauntingAttributes()
	
		private val whenHit: WhenHitAttributes = WhenHitAttributes()
	
		private val ragdolls: RagdollsAttributes = RagdollsAttributes()
	
		private val buffItems: BuffItemsAttributes = BuffItemsAttributes()
	
		private val cloak: CloakAttributes = CloakAttributes()
	
		private val disguise: DisguiseAttributes = DisguiseAttributes()
	
		private val hud: HudAttributes = HudAttributes()
	
		private val spyOnly: SpyOnlyAttributes = SpyOnlyAttributes()
	}

	override val crits: CritsAttributes get() = BreakableSignAttributes.crits
	
	override val damage: DamageAttributes get() = BreakableSignAttributes.damage
	
	override val onHit: OnHitAttributes get() = BreakableSignAttributes.onHit
	
	override val swapWeapons: SwapWeaponsAttributes get() = BreakableSignAttributes.swapWeapons
	
	override val afterburn: AfterburnAttributes get() = BreakableSignAttributes.afterburn
	
	override val ammo: AmmoAttributes get() = BreakableSignAttributes.ammo
	
	override val buildings: BuildingsAttributes get() = BreakableSignAttributes.buildings
	
	override val demoCharge: DemoChargeAttributes get() = BreakableSignAttributes.demoCharge
	
	override val firing: FiringAttributes get() = BreakableSignAttributes.firing
	
	override val healthAndHealing: HealthAndHealingAttributes get() = BreakableSignAttributes.healthAndHealing
	
	override val knockbackReceived: KnockbackReceivedAttributes get() = BreakableSignAttributes.knockbackReceived
	
	override val meta: MetaAttributes get() = BreakableSignAttributes.meta
	
	override val meter: MeterAttributes get() = BreakableSignAttributes.meter
	
	override val movement: MovementAttributes get() = BreakableSignAttributes.movement
	
	override val heads: HeadsAttributes get() = BreakableSignAttributes.heads
	
	override val onKill: OnKillAttributes get() = BreakableSignAttributes.onKill
	
	override val projectiles: ProjectilesAttributes get() = BreakableSignAttributes.projectiles
	
	override val reloading: ReloadingAttributes get() = BreakableSignAttributes.reloading
	
	override val resistance: ResistanceAttributes get() = BreakableSignAttributes.resistance
	
	override val revengeCrits: RevengeCritsAttributes get() = BreakableSignAttributes.revengeCrits
	
	override val statusEffects: StatusEffectsAttributes get() = BreakableSignAttributes.statusEffects
	
	override val taunting: TauntingAttributes get() = BreakableSignAttributes.taunting
	
	override val whenHit: WhenHitAttributes get() = BreakableSignAttributes.whenHit
	
	override val ragdolls: RagdollsAttributes get() = BreakableSignAttributes.ragdolls
	
	override val buffItems: BuffItemsAttributes get() = BreakableSignAttributes.buffItems
	
	override val cloak: CloakAttributes get() = BreakableSignAttributes.cloak
	
	override val disguise: DisguiseAttributes get() = BreakableSignAttributes.disguise
	
	override val hud: HudAttributes get() = BreakableSignAttributes.hud
	
	override val spyOnly: SpyOnlyAttributes get() = BreakableSignAttributes.spyOnly

	open class CritsAttributes : BreakableMeleeAttributes.CritsAttributes() 
	
	open class DamageAttributes : BreakableMeleeAttributes.DamageAttributes() {
		override val alien: AlienAttributes = AlienAttributes()
	
		open class AlienAttributes : BreakableMeleeAttributes.DamageAttributes.AlienAttributes() 
	}
	
	open class OnHitAttributes : BreakableMeleeAttributes.OnHitAttributes() {
		override val healOnHitForRapidfire: HealOnHitForRapidfireAttributes = HealOnHitForRapidfireAttributes()
	
		override val generateRageOnDamage: GenerateRageOnDamageAttributes = GenerateRageOnDamageAttributes()
	
		override val falling: FallingAttributes = FallingAttributes()
	
		open class HealOnHitForRapidfireAttributes : BreakableMeleeAttributes.OnHitAttributes.HealOnHitForRapidfireAttributes() 
	
		open class GenerateRageOnDamageAttributes : BreakableMeleeAttributes.OnHitAttributes.GenerateRageOnDamageAttributes() 
	
		open class FallingAttributes : BreakableMeleeAttributes.OnHitAttributes.FallingAttributes() 
	}
	
	open class SwapWeaponsAttributes : BreakableMeleeAttributes.SwapWeaponsAttributes() {
		override val deploy: DeployAttributes = DeployAttributes()
	
		open class DeployAttributes : BreakableMeleeAttributes.SwapWeaponsAttributes.DeployAttributes() 
	}
	
	open class AfterburnAttributes : BreakableMeleeAttributes.AfterburnAttributes() 
	
	open class AmmoAttributes : BreakableMeleeAttributes.AmmoAttributes() {
		override val clipSize: ClipSizeAttributes = ClipSizeAttributes()
	
		override val maxAmmo: MaxAmmoAttributes = MaxAmmoAttributes()
	
		open class ClipSizeAttributes : BreakableMeleeAttributes.AmmoAttributes.ClipSizeAttributes() 
	
		open class MaxAmmoAttributes : BreakableMeleeAttributes.AmmoAttributes.MaxAmmoAttributes() 
	}
	
	open class BuildingsAttributes : BreakableMeleeAttributes.BuildingsAttributes() {
		override val sentryGun: SentryGunAttributes = SentryGunAttributes()
	
		override val dispenser: DispenserAttributes = DispenserAttributes()
	
		override val teleporter: TeleporterAttributes = TeleporterAttributes()
	
		open class SentryGunAttributes : BreakableMeleeAttributes.BuildingsAttributes.SentryGunAttributes() 
	
		open class DispenserAttributes : BreakableMeleeAttributes.BuildingsAttributes.DispenserAttributes() 
	
		open class TeleporterAttributes : BreakableMeleeAttributes.BuildingsAttributes.TeleporterAttributes() 
	}
	
	open class DemoChargeAttributes : BreakableMeleeAttributes.DemoChargeAttributes() {
		override val multChargeTurnControl: MultChargeTurnControlAttributes = MultChargeTurnControlAttributes()
	
		open class MultChargeTurnControlAttributes : BreakableMeleeAttributes.DemoChargeAttributes.MultChargeTurnControlAttributes() 
	}
	
	open class FiringAttributes : BreakableMeleeAttributes.FiringAttributes() {
		override val fireRate: FireRateAttributes = FireRateAttributes()
	
		open class FireRateAttributes : BreakableMeleeAttributes.FiringAttributes.FireRateAttributes() 
	}
	
	open class HealthAndHealingAttributes : BreakableMeleeAttributes.HealthAndHealingAttributes() {
		override val healthRegen: HealthRegenAttributes = HealthRegenAttributes()
	
		override val maxHealthAdditive: MaxHealthAdditiveAttributes = MaxHealthAdditiveAttributes()
	
		open class HealthRegenAttributes : BreakableMeleeAttributes.HealthAndHealingAttributes.HealthRegenAttributes() 
	
		open class MaxHealthAdditiveAttributes : BreakableMeleeAttributes.HealthAndHealingAttributes.MaxHealthAdditiveAttributes() 
	}
	
	open class KnockbackReceivedAttributes : BreakableMeleeAttributes.KnockbackReceivedAttributes() {
		override val damageForceReduction: DamageForceReductionAttributes = DamageForceReductionAttributes()
	
		open class DamageForceReductionAttributes : BreakableMeleeAttributes.KnockbackReceivedAttributes.DamageForceReductionAttributes() 
	}
	
	open class MetaAttributes : BreakableMeleeAttributes.MetaAttributes() {
		override val killfeed: KillfeedAttributes = KillfeedAttributes()
	
		override val viewmodel: ViewmodelAttributes = ViewmodelAttributes()
	
		override val items: ItemsAttributes = ItemsAttributes()
	
		override val particles: ParticlesAttributes = ParticlesAttributes()
	
		override val noisemakers: NoisemakersAttributes = NoisemakersAttributes()
	
		override val player: PlayerAttributes = PlayerAttributes()
	
		override val gameplay: GameplayAttributes = GameplayAttributes()
	
		open class KillfeedAttributes : BreakableMeleeAttributes.MetaAttributes.KillfeedAttributes() 
	
		open class ViewmodelAttributes : BreakableMeleeAttributes.MetaAttributes.ViewmodelAttributes() 
	
		open class ItemsAttributes : BreakableMeleeAttributes.MetaAttributes.ItemsAttributes() 
	
		open class ParticlesAttributes : BreakableMeleeAttributes.MetaAttributes.ParticlesAttributes() 
	
		open class NoisemakersAttributes : BreakableMeleeAttributes.MetaAttributes.NoisemakersAttributes() 
	
		open class PlayerAttributes : BreakableMeleeAttributes.MetaAttributes.PlayerAttributes() 
	
		open class GameplayAttributes : BreakableMeleeAttributes.MetaAttributes.GameplayAttributes() 
	}
	
	open class MeterAttributes : BreakableMeleeAttributes.MeterAttributes() {
		override val generateRageOnDamage: GenerateRageOnDamageAttributes = GenerateRageOnDamageAttributes()
	
		open class GenerateRageOnDamageAttributes : BreakableMeleeAttributes.MeterAttributes.GenerateRageOnDamageAttributes() 
	}
	
	open class MovementAttributes : BreakableMeleeAttributes.MovementAttributes() {
		override val moveSpeed: MoveSpeedAttributes = MoveSpeedAttributes()
	
		override val jumpHeight: jumpHeightAttributes = jumpHeightAttributes()
	
		open class MoveSpeedAttributes : BreakableMeleeAttributes.MovementAttributes.MoveSpeedAttributes() {
			override val aimingMovespeed: AimingMovespeedAttributes = AimingMovespeedAttributes()
	
			override val moveSpeed: MoveSpeedAttributes = MoveSpeedAttributes()
	
			open class AimingMovespeedAttributes : BreakableMeleeAttributes.MovementAttributes.MoveSpeedAttributes.AimingMovespeedAttributes() 
	
			open class MoveSpeedAttributes : BreakableMeleeAttributes.MovementAttributes.MoveSpeedAttributes.MoveSpeedAttributes() 
		}
	
		open class jumpHeightAttributes : BreakableMeleeAttributes.MovementAttributes.jumpHeightAttributes() 
	}
	
	open class HeadsAttributes : BreakableMeleeAttributes.HeadsAttributes() 
	
	open class OnKillAttributes : BreakableMeleeAttributes.OnKillAttributes() 
	
	open class ProjectilesAttributes : BreakableMeleeAttributes.ProjectilesAttributes() {
		override val projectilePenetration: ProjectilePenetrationAttributes = ProjectilePenetrationAttributes()
	
		override val bullets: BulletsAttributes = BulletsAttributes()
	
		open class ProjectilePenetrationAttributes : BreakableMeleeAttributes.ProjectilesAttributes.ProjectilePenetrationAttributes() 
	
		open class BulletsAttributes : BreakableMeleeAttributes.ProjectilesAttributes.BulletsAttributes() 
	}
	
	open class ReloadingAttributes : BreakableMeleeAttributes.ReloadingAttributes() 
	
	open class ResistanceAttributes : BreakableMeleeAttributes.ResistanceAttributes() {
		override val dmgTakenFromCritReduced: DmgTakenFromCritReducedAttributes = DmgTakenFromCritReducedAttributes()
	
		override val dmgTakenFromFireReduced: DmgTakenFromFireReducedAttributes = DmgTakenFromFireReducedAttributes()
	
		override val dmgTakenFromBulletsReduced: DmgTakenFromBulletsReducedAttributes = DmgTakenFromBulletsReducedAttributes()
	
		override val vaccinator: VaccinatorAttributes = VaccinatorAttributes()
	
		open class DmgTakenFromCritReducedAttributes : BreakableMeleeAttributes.ResistanceAttributes.DmgTakenFromCritReducedAttributes() 
	
		open class DmgTakenFromFireReducedAttributes : BreakableMeleeAttributes.ResistanceAttributes.DmgTakenFromFireReducedAttributes() 
	
		open class DmgTakenFromBulletsReducedAttributes : BreakableMeleeAttributes.ResistanceAttributes.DmgTakenFromBulletsReducedAttributes() 
	
		open class VaccinatorAttributes : BreakableMeleeAttributes.ResistanceAttributes.VaccinatorAttributes() 
	}
	
	open class RevengeCritsAttributes : BreakableMeleeAttributes.RevengeCritsAttributes() 
	
	open class StatusEffectsAttributes : BreakableMeleeAttributes.StatusEffectsAttributes() 
	
	open class TauntingAttributes : BreakableMeleeAttributes.TauntingAttributes() 
	
	open class WhenHitAttributes : BreakableMeleeAttributes.WhenHitAttributes() 
	
	open class RagdollsAttributes : BreakableMeleeAttributes.RagdollsAttributes() 
	
	open class BuffItemsAttributes : BreakableMeleeAttributes.BuffItemsAttributes() 
	
	open class CloakAttributes : BreakableMeleeAttributes.CloakAttributes() 
	
	open class DisguiseAttributes : BreakableMeleeAttributes.DisguiseAttributes() 
	
	open class HudAttributes : BreakableMeleeAttributes.HudAttributes() 
	
	open class SpyOnlyAttributes : BreakableMeleeAttributes.SpyOnlyAttributes() 
	
	object Inherited : BreakableSignAttributes 
}