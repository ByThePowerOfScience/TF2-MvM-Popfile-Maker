package btpos.source.vdfdsl.tf2.itemattributes

import btpos.source.vdfdsl.modeling.*
import btpos.source.vdfdsl.serialization.codecs.*
import btpos.source.vdfdsl.tf2.itemattributes.impl.*
import btpos.source.vdfdsl.tf2.tftypes.*
import java.util.*
import kotlin.time.Duration

interface Raygun_RevengeAttributes : IBlockScoped, RayGunAttributes {
	companion object : IBlockScoped {
		private val ammo: AmmoAttributes = AmmoAttributes()
	
		private val projectiles: ProjectilesAttributes = ProjectilesAttributes()
	
		private val damage: DamageAttributes = DamageAttributes()
	
		private val firing: FiringAttributes = FiringAttributes()
	
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

	override val ammo: AmmoAttributes get() = Raygun_RevengeAttributes.ammo
	
	override val projectiles: ProjectilesAttributes get() = Raygun_RevengeAttributes.projectiles
	
	override val damage: DamageAttributes get() = Raygun_RevengeAttributes.damage
	
	override val firing: FiringAttributes get() = Raygun_RevengeAttributes.firing
	
	override val afterburn: AfterburnAttributes get() = Raygun_RevengeAttributes.afterburn
	
	override val buildings: BuildingsAttributes get() = Raygun_RevengeAttributes.buildings
	
	override val crits: CritsAttributes get() = Raygun_RevengeAttributes.crits
	
	override val demoCharge: DemoChargeAttributes get() = Raygun_RevengeAttributes.demoCharge
	
	override val healthAndHealing: HealthAndHealingAttributes get() = Raygun_RevengeAttributes.healthAndHealing
	
	override val knockbackReceived: KnockbackReceivedAttributes get() = Raygun_RevengeAttributes.knockbackReceived
	
	override val meta: MetaAttributes get() = Raygun_RevengeAttributes.meta
	
	override val meter: MeterAttributes get() = Raygun_RevengeAttributes.meter
	
	override val movement: MovementAttributes get() = Raygun_RevengeAttributes.movement
	
	override val heads: HeadsAttributes get() = Raygun_RevengeAttributes.heads
	
	override val onHit: OnHitAttributes get() = Raygun_RevengeAttributes.onHit
	
	override val onKill: OnKillAttributes get() = Raygun_RevengeAttributes.onKill
	
	override val reloading: ReloadingAttributes get() = Raygun_RevengeAttributes.reloading
	
	override val resistance: ResistanceAttributes get() = Raygun_RevengeAttributes.resistance
	
	override val revengeCrits: RevengeCritsAttributes get() = Raygun_RevengeAttributes.revengeCrits
	
	override val statusEffects: StatusEffectsAttributes get() = Raygun_RevengeAttributes.statusEffects
	
	override val taunting: TauntingAttributes get() = Raygun_RevengeAttributes.taunting
	
	override val swapWeapons: SwapWeaponsAttributes get() = Raygun_RevengeAttributes.swapWeapons
	
	override val whenHit: WhenHitAttributes get() = Raygun_RevengeAttributes.whenHit
	
	override val ragdolls: RagdollsAttributes get() = Raygun_RevengeAttributes.ragdolls
	
	override val buffItems: BuffItemsAttributes get() = Raygun_RevengeAttributes.buffItems
	
	override val cloak: CloakAttributes get() = Raygun_RevengeAttributes.cloak
	
	override val disguise: DisguiseAttributes get() = Raygun_RevengeAttributes.disguise
	
	override val hud: HudAttributes get() = Raygun_RevengeAttributes.hud
	
	override val spyOnly: SpyOnlyAttributes get() = Raygun_RevengeAttributes.spyOnly

	open class AmmoAttributes : RayGunAttributes.AmmoAttributes() {
		override val clipSize: ClipSizeAttributes = ClipSizeAttributes()
	
		override val maxAmmo: MaxAmmoAttributes = MaxAmmoAttributes()
	
		open class ClipSizeAttributes : RayGunAttributes.AmmoAttributes.ClipSizeAttributes() 
	
		open class MaxAmmoAttributes : RayGunAttributes.AmmoAttributes.MaxAmmoAttributes() 
	}
	
	open class ProjectilesAttributes : RayGunAttributes.ProjectilesAttributes() {
		override val bullets: BulletsAttributes = BulletsAttributes()
	
		override val projectilePenetration: ProjectilePenetrationAttributes = ProjectilePenetrationAttributes()
	
		open class BulletsAttributes : RayGunAttributes.ProjectilesAttributes.BulletsAttributes() 
	
		open class ProjectilePenetrationAttributes : RayGunAttributes.ProjectilesAttributes.ProjectilePenetrationAttributes() 
	}
	
	open class DamageAttributes : RayGunAttributes.DamageAttributes() {
		override val alien: AlienAttributes = AlienAttributes()
	
		open class AlienAttributes : RayGunAttributes.DamageAttributes.AlienAttributes() 
	}
	
	open class FiringAttributes : RayGunAttributes.FiringAttributes() {
		override val fireRate: FireRateAttributes = FireRateAttributes()
	
		open class FireRateAttributes : RayGunAttributes.FiringAttributes.FireRateAttributes() 
	}
	
	open class AfterburnAttributes : RayGunAttributes.AfterburnAttributes() 
	
	open class BuildingsAttributes : RayGunAttributes.BuildingsAttributes() {
		override val sentryGun: SentryGunAttributes = SentryGunAttributes()
	
		override val dispenser: DispenserAttributes = DispenserAttributes()
	
		override val teleporter: TeleporterAttributes = TeleporterAttributes()
	
		open class SentryGunAttributes : RayGunAttributes.BuildingsAttributes.SentryGunAttributes() 
	
		open class DispenserAttributes : RayGunAttributes.BuildingsAttributes.DispenserAttributes() 
	
		open class TeleporterAttributes : RayGunAttributes.BuildingsAttributes.TeleporterAttributes() 
	}
	
	open class CritsAttributes : RayGunAttributes.CritsAttributes() 
	
	open class DemoChargeAttributes : RayGunAttributes.DemoChargeAttributes() {
		override val multChargeTurnControl: MultChargeTurnControlAttributes = MultChargeTurnControlAttributes()
	
		open class MultChargeTurnControlAttributes : RayGunAttributes.DemoChargeAttributes.MultChargeTurnControlAttributes() 
	}
	
	open class HealthAndHealingAttributes : RayGunAttributes.HealthAndHealingAttributes() {
		override val healthRegen: HealthRegenAttributes = HealthRegenAttributes()
	
		override val maxHealthAdditive: MaxHealthAdditiveAttributes = MaxHealthAdditiveAttributes()
	
		open class HealthRegenAttributes : RayGunAttributes.HealthAndHealingAttributes.HealthRegenAttributes() 
	
		open class MaxHealthAdditiveAttributes : RayGunAttributes.HealthAndHealingAttributes.MaxHealthAdditiveAttributes() 
	}
	
	open class KnockbackReceivedAttributes : RayGunAttributes.KnockbackReceivedAttributes() {
		override val damageForceReduction: DamageForceReductionAttributes = DamageForceReductionAttributes()
	
		open class DamageForceReductionAttributes : RayGunAttributes.KnockbackReceivedAttributes.DamageForceReductionAttributes() 
	}
	
	open class MetaAttributes : RayGunAttributes.MetaAttributes() {
		override val killfeed: KillfeedAttributes = KillfeedAttributes()
	
		override val viewmodel: ViewmodelAttributes = ViewmodelAttributes()
	
		override val items: ItemsAttributes = ItemsAttributes()
	
		override val particles: ParticlesAttributes = ParticlesAttributes()
	
		override val noisemakers: NoisemakersAttributes = NoisemakersAttributes()
	
		override val player: PlayerAttributes = PlayerAttributes()
	
		override val gameplay: GameplayAttributes = GameplayAttributes()
	
		open class KillfeedAttributes : RayGunAttributes.MetaAttributes.KillfeedAttributes() 
	
		open class ViewmodelAttributes : RayGunAttributes.MetaAttributes.ViewmodelAttributes() 
	
		open class ItemsAttributes : RayGunAttributes.MetaAttributes.ItemsAttributes() 
	
		open class ParticlesAttributes : RayGunAttributes.MetaAttributes.ParticlesAttributes() 
	
		open class NoisemakersAttributes : RayGunAttributes.MetaAttributes.NoisemakersAttributes() 
	
		open class PlayerAttributes : RayGunAttributes.MetaAttributes.PlayerAttributes() 
	
		open class GameplayAttributes : RayGunAttributes.MetaAttributes.GameplayAttributes() 
	}
	
	open class MeterAttributes : RayGunAttributes.MeterAttributes() {
		override val generateRageOnDamage: GenerateRageOnDamageAttributes = GenerateRageOnDamageAttributes()
	
		open class GenerateRageOnDamageAttributes : RayGunAttributes.MeterAttributes.GenerateRageOnDamageAttributes() 
	}
	
	open class MovementAttributes : RayGunAttributes.MovementAttributes() {
		override val moveSpeed: MoveSpeedAttributes = MoveSpeedAttributes()
	
		override val jumpHeight: jumpHeightAttributes = jumpHeightAttributes()
	
		open class MoveSpeedAttributes : RayGunAttributes.MovementAttributes.MoveSpeedAttributes() {
			override val aimingMovespeed: AimingMovespeedAttributes = AimingMovespeedAttributes()
	
			override val moveSpeed: MoveSpeedAttributes = MoveSpeedAttributes()
	
			open class AimingMovespeedAttributes : RayGunAttributes.MovementAttributes.MoveSpeedAttributes.AimingMovespeedAttributes() 
	
			open class MoveSpeedAttributes : RayGunAttributes.MovementAttributes.MoveSpeedAttributes.MoveSpeedAttributes() 
		}
	
		open class jumpHeightAttributes : RayGunAttributes.MovementAttributes.jumpHeightAttributes() 
	}
	
	open class HeadsAttributes : RayGunAttributes.HeadsAttributes() 
	
	open class OnHitAttributes : RayGunAttributes.OnHitAttributes() {
		override val healOnHitForRapidfire: HealOnHitForRapidfireAttributes = HealOnHitForRapidfireAttributes()
	
		override val generateRageOnDamage: GenerateRageOnDamageAttributes = GenerateRageOnDamageAttributes()
	
		override val falling: FallingAttributes = FallingAttributes()
	
		open class HealOnHitForRapidfireAttributes : RayGunAttributes.OnHitAttributes.HealOnHitForRapidfireAttributes() 
	
		open class GenerateRageOnDamageAttributes : RayGunAttributes.OnHitAttributes.GenerateRageOnDamageAttributes() 
	
		open class FallingAttributes : RayGunAttributes.OnHitAttributes.FallingAttributes() 
	}
	
	open class OnKillAttributes : RayGunAttributes.OnKillAttributes() 
	
	open class ReloadingAttributes : RayGunAttributes.ReloadingAttributes() 
	
	open class ResistanceAttributes : RayGunAttributes.ResistanceAttributes() {
		override val dmgTakenFromCritReduced: DmgTakenFromCritReducedAttributes = DmgTakenFromCritReducedAttributes()
	
		override val dmgTakenFromFireReduced: DmgTakenFromFireReducedAttributes = DmgTakenFromFireReducedAttributes()
	
		override val dmgTakenFromBulletsReduced: DmgTakenFromBulletsReducedAttributes = DmgTakenFromBulletsReducedAttributes()
	
		override val vaccinator: VaccinatorAttributes = VaccinatorAttributes()
	
		open class DmgTakenFromCritReducedAttributes : RayGunAttributes.ResistanceAttributes.DmgTakenFromCritReducedAttributes() 
	
		open class DmgTakenFromFireReducedAttributes : RayGunAttributes.ResistanceAttributes.DmgTakenFromFireReducedAttributes() 
	
		open class DmgTakenFromBulletsReducedAttributes : RayGunAttributes.ResistanceAttributes.DmgTakenFromBulletsReducedAttributes() 
	
		open class VaccinatorAttributes : RayGunAttributes.ResistanceAttributes.VaccinatorAttributes() 
	}
	
	open class RevengeCritsAttributes : RayGunAttributes.RevengeCritsAttributes() 
	
	open class StatusEffectsAttributes : RayGunAttributes.StatusEffectsAttributes() 
	
	open class TauntingAttributes : RayGunAttributes.TauntingAttributes() 
	
	open class SwapWeaponsAttributes : RayGunAttributes.SwapWeaponsAttributes() {
		override val deploy: DeployAttributes = DeployAttributes()
	
		open class DeployAttributes : RayGunAttributes.SwapWeaponsAttributes.DeployAttributes() 
	}
	
	open class WhenHitAttributes : RayGunAttributes.WhenHitAttributes() 
	
	open class RagdollsAttributes : RayGunAttributes.RagdollsAttributes() 
	
	open class BuffItemsAttributes : RayGunAttributes.BuffItemsAttributes() 
	
	open class CloakAttributes : RayGunAttributes.CloakAttributes() 
	
	open class DisguiseAttributes : RayGunAttributes.DisguiseAttributes() 
	
	open class HudAttributes : RayGunAttributes.HudAttributes() 
	
	open class SpyOnlyAttributes : RayGunAttributes.SpyOnlyAttributes() 
	
	object Inherited : Raygun_RevengeAttributes 
}