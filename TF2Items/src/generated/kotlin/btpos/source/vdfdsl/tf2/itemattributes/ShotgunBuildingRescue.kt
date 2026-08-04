package btpos.source.vdfdsl.tf2.itemattributes

import btpos.source.vdfdsl.modeling.*
import btpos.source.vdfdsl.serialization.codecs.*
import btpos.source.vdfdsl.tf2.itemattributes.impl.*
import btpos.source.vdfdsl.tf2.tftypes.*
import java.util.*
import kotlin.time.Duration

interface ShotgunBuildingRescueAttributes : IBlockScoped, ShotgunAttributes {
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

	override val ammo: AmmoAttributes get() = ShotgunBuildingRescueAttributes.ammo
	
	override val damage: DamageAttributes get() = ShotgunBuildingRescueAttributes.damage
	
	override val firing: FiringAttributes get() = ShotgunBuildingRescueAttributes.firing
	
	override val projectiles: ProjectilesAttributes get() = ShotgunBuildingRescueAttributes.projectiles
	
	override val afterburn: AfterburnAttributes get() = ShotgunBuildingRescueAttributes.afterburn
	
	override val buildings: BuildingsAttributes get() = ShotgunBuildingRescueAttributes.buildings
	
	override val crits: CritsAttributes get() = ShotgunBuildingRescueAttributes.crits
	
	override val demoCharge: DemoChargeAttributes get() = ShotgunBuildingRescueAttributes.demoCharge
	
	override val healthAndHealing: HealthAndHealingAttributes get() = ShotgunBuildingRescueAttributes.healthAndHealing
	
	override val knockbackReceived: KnockbackReceivedAttributes get() = ShotgunBuildingRescueAttributes.knockbackReceived
	
	override val meta: MetaAttributes get() = ShotgunBuildingRescueAttributes.meta
	
	override val meter: MeterAttributes get() = ShotgunBuildingRescueAttributes.meter
	
	override val movement: MovementAttributes get() = ShotgunBuildingRescueAttributes.movement
	
	override val heads: HeadsAttributes get() = ShotgunBuildingRescueAttributes.heads
	
	override val onHit: OnHitAttributes get() = ShotgunBuildingRescueAttributes.onHit
	
	override val onKill: OnKillAttributes get() = ShotgunBuildingRescueAttributes.onKill
	
	override val reloading: ReloadingAttributes get() = ShotgunBuildingRescueAttributes.reloading
	
	override val resistance: ResistanceAttributes get() = ShotgunBuildingRescueAttributes.resistance
	
	override val revengeCrits: RevengeCritsAttributes get() = ShotgunBuildingRescueAttributes.revengeCrits
	
	override val statusEffects: StatusEffectsAttributes get() = ShotgunBuildingRescueAttributes.statusEffects
	
	override val taunting: TauntingAttributes get() = ShotgunBuildingRescueAttributes.taunting
	
	override val swapWeapons: SwapWeaponsAttributes get() = ShotgunBuildingRescueAttributes.swapWeapons
	
	override val whenHit: WhenHitAttributes get() = ShotgunBuildingRescueAttributes.whenHit
	
	override val ragdolls: RagdollsAttributes get() = ShotgunBuildingRescueAttributes.ragdolls
	
	override val buffItems: BuffItemsAttributes get() = ShotgunBuildingRescueAttributes.buffItems
	
	override val cloak: CloakAttributes get() = ShotgunBuildingRescueAttributes.cloak
	
	override val disguise: DisguiseAttributes get() = ShotgunBuildingRescueAttributes.disguise
	
	override val hud: HudAttributes get() = ShotgunBuildingRescueAttributes.hud
	
	override val spyOnly: SpyOnlyAttributes get() = ShotgunBuildingRescueAttributes.spyOnly

	open class AmmoAttributes : ShotgunAttributes.AmmoAttributes() {
		override val clipSize: ClipSizeAttributes = ClipSizeAttributes()
	
		override val maxAmmo: MaxAmmoAttributes = MaxAmmoAttributes()
	
		open class ClipSizeAttributes : ShotgunAttributes.AmmoAttributes.ClipSizeAttributes() 
	
		open class MaxAmmoAttributes : ShotgunAttributes.AmmoAttributes.MaxAmmoAttributes() 
	}
	
	open class DamageAttributes : ShotgunAttributes.DamageAttributes() {
		override val alien: AlienAttributes = AlienAttributes()
	
		open class AlienAttributes : ShotgunAttributes.DamageAttributes.AlienAttributes() 
	}
	
	open class FiringAttributes : ShotgunAttributes.FiringAttributes() {
		override val fireRate: FireRateAttributes = FireRateAttributes()
	
		open class FireRateAttributes : ShotgunAttributes.FiringAttributes.FireRateAttributes() 
	}
	
	open class ProjectilesAttributes : ShotgunAttributes.ProjectilesAttributes() {
		override val bullets: BulletsAttributes = BulletsAttributes()
	
		override val projectilePenetration: ProjectilePenetrationAttributes = ProjectilePenetrationAttributes()
	
		open class BulletsAttributes : ShotgunAttributes.ProjectilesAttributes.BulletsAttributes() 
	
		open class ProjectilePenetrationAttributes : ShotgunAttributes.ProjectilesAttributes.ProjectilePenetrationAttributes() 
	}
	
	open class AfterburnAttributes : ShotgunAttributes.AfterburnAttributes() 
	
	open class BuildingsAttributes : ShotgunAttributes.BuildingsAttributes() {
		override val sentryGun: SentryGunAttributes = SentryGunAttributes()
	
		override val dispenser: DispenserAttributes = DispenserAttributes()
	
		override val teleporter: TeleporterAttributes = TeleporterAttributes()
	
		open class SentryGunAttributes : ShotgunAttributes.BuildingsAttributes.SentryGunAttributes() 
	
		open class DispenserAttributes : ShotgunAttributes.BuildingsAttributes.DispenserAttributes() 
	
		open class TeleporterAttributes : ShotgunAttributes.BuildingsAttributes.TeleporterAttributes() 
	}
	
	open class CritsAttributes : ShotgunAttributes.CritsAttributes() 
	
	open class DemoChargeAttributes : ShotgunAttributes.DemoChargeAttributes() {
		override val multChargeTurnControl: MultChargeTurnControlAttributes = MultChargeTurnControlAttributes()
	
		open class MultChargeTurnControlAttributes : ShotgunAttributes.DemoChargeAttributes.MultChargeTurnControlAttributes() 
	}
	
	open class HealthAndHealingAttributes : ShotgunAttributes.HealthAndHealingAttributes() {
		override val healthRegen: HealthRegenAttributes = HealthRegenAttributes()
	
		override val maxHealthAdditive: MaxHealthAdditiveAttributes = MaxHealthAdditiveAttributes()
	
		open class HealthRegenAttributes : ShotgunAttributes.HealthAndHealingAttributes.HealthRegenAttributes() 
	
		open class MaxHealthAdditiveAttributes : ShotgunAttributes.HealthAndHealingAttributes.MaxHealthAdditiveAttributes() 
	}
	
	open class KnockbackReceivedAttributes : ShotgunAttributes.KnockbackReceivedAttributes() {
		override val damageForceReduction: DamageForceReductionAttributes = DamageForceReductionAttributes()
	
		open class DamageForceReductionAttributes : ShotgunAttributes.KnockbackReceivedAttributes.DamageForceReductionAttributes() 
	}
	
	open class MetaAttributes : ShotgunAttributes.MetaAttributes() {
		override val killfeed: KillfeedAttributes = KillfeedAttributes()
	
		override val viewmodel: ViewmodelAttributes = ViewmodelAttributes()
	
		override val items: ItemsAttributes = ItemsAttributes()
	
		override val particles: ParticlesAttributes = ParticlesAttributes()
	
		override val noisemakers: NoisemakersAttributes = NoisemakersAttributes()
	
		override val player: PlayerAttributes = PlayerAttributes()
	
		override val gameplay: GameplayAttributes = GameplayAttributes()
	
		open class KillfeedAttributes : ShotgunAttributes.MetaAttributes.KillfeedAttributes() 
	
		open class ViewmodelAttributes : ShotgunAttributes.MetaAttributes.ViewmodelAttributes() 
	
		open class ItemsAttributes : ShotgunAttributes.MetaAttributes.ItemsAttributes() 
	
		open class ParticlesAttributes : ShotgunAttributes.MetaAttributes.ParticlesAttributes() 
	
		open class NoisemakersAttributes : ShotgunAttributes.MetaAttributes.NoisemakersAttributes() 
	
		open class PlayerAttributes : ShotgunAttributes.MetaAttributes.PlayerAttributes() 
	
		open class GameplayAttributes : ShotgunAttributes.MetaAttributes.GameplayAttributes() 
	}
	
	open class MeterAttributes : ShotgunAttributes.MeterAttributes() {
		override val generateRageOnDamage: GenerateRageOnDamageAttributes = GenerateRageOnDamageAttributes()
	
		open class GenerateRageOnDamageAttributes : ShotgunAttributes.MeterAttributes.GenerateRageOnDamageAttributes() 
	}
	
	open class MovementAttributes : ShotgunAttributes.MovementAttributes() {
		override val moveSpeed: MoveSpeedAttributes = MoveSpeedAttributes()
	
		override val jumpHeight: jumpHeightAttributes = jumpHeightAttributes()
	
		open class MoveSpeedAttributes : ShotgunAttributes.MovementAttributes.MoveSpeedAttributes() {
			override val aimingMovespeed: AimingMovespeedAttributes = AimingMovespeedAttributes()
	
			override val moveSpeed: MoveSpeedAttributes = MoveSpeedAttributes()
	
			open class AimingMovespeedAttributes : ShotgunAttributes.MovementAttributes.MoveSpeedAttributes.AimingMovespeedAttributes() 
	
			open class MoveSpeedAttributes : ShotgunAttributes.MovementAttributes.MoveSpeedAttributes.MoveSpeedAttributes() 
		}
	
		open class jumpHeightAttributes : ShotgunAttributes.MovementAttributes.jumpHeightAttributes() 
	}
	
	open class HeadsAttributes : ShotgunAttributes.HeadsAttributes() 
	
	open class OnHitAttributes : ShotgunAttributes.OnHitAttributes() {
		override val healOnHitForRapidfire: HealOnHitForRapidfireAttributes = HealOnHitForRapidfireAttributes()
	
		override val generateRageOnDamage: GenerateRageOnDamageAttributes = GenerateRageOnDamageAttributes()
	
		override val falling: FallingAttributes = FallingAttributes()
	
		open class HealOnHitForRapidfireAttributes : ShotgunAttributes.OnHitAttributes.HealOnHitForRapidfireAttributes() 
	
		open class GenerateRageOnDamageAttributes : ShotgunAttributes.OnHitAttributes.GenerateRageOnDamageAttributes() 
	
		open class FallingAttributes : ShotgunAttributes.OnHitAttributes.FallingAttributes() 
	}
	
	open class OnKillAttributes : ShotgunAttributes.OnKillAttributes() 
	
	open class ReloadingAttributes : ShotgunAttributes.ReloadingAttributes() 
	
	open class ResistanceAttributes : ShotgunAttributes.ResistanceAttributes() {
		override val dmgTakenFromCritReduced: DmgTakenFromCritReducedAttributes = DmgTakenFromCritReducedAttributes()
	
		override val dmgTakenFromFireReduced: DmgTakenFromFireReducedAttributes = DmgTakenFromFireReducedAttributes()
	
		override val dmgTakenFromBulletsReduced: DmgTakenFromBulletsReducedAttributes = DmgTakenFromBulletsReducedAttributes()
	
		override val vaccinator: VaccinatorAttributes = VaccinatorAttributes()
	
		open class DmgTakenFromCritReducedAttributes : ShotgunAttributes.ResistanceAttributes.DmgTakenFromCritReducedAttributes() 
	
		open class DmgTakenFromFireReducedAttributes : ShotgunAttributes.ResistanceAttributes.DmgTakenFromFireReducedAttributes() 
	
		open class DmgTakenFromBulletsReducedAttributes : ShotgunAttributes.ResistanceAttributes.DmgTakenFromBulletsReducedAttributes() 
	
		open class VaccinatorAttributes : ShotgunAttributes.ResistanceAttributes.VaccinatorAttributes() 
	}
	
	open class RevengeCritsAttributes : ShotgunAttributes.RevengeCritsAttributes() 
	
	open class StatusEffectsAttributes : ShotgunAttributes.StatusEffectsAttributes() 
	
	open class TauntingAttributes : ShotgunAttributes.TauntingAttributes() 
	
	open class SwapWeaponsAttributes : ShotgunAttributes.SwapWeaponsAttributes() {
		override val deploy: DeployAttributes = DeployAttributes()
	
		open class DeployAttributes : ShotgunAttributes.SwapWeaponsAttributes.DeployAttributes() 
	}
	
	open class WhenHitAttributes : ShotgunAttributes.WhenHitAttributes() 
	
	open class RagdollsAttributes : ShotgunAttributes.RagdollsAttributes() 
	
	open class BuffItemsAttributes : ShotgunAttributes.BuffItemsAttributes() 
	
	open class CloakAttributes : ShotgunAttributes.CloakAttributes() 
	
	open class DisguiseAttributes : ShotgunAttributes.DisguiseAttributes() 
	
	open class HudAttributes : ShotgunAttributes.HudAttributes() 
	
	open class SpyOnlyAttributes : ShotgunAttributes.SpyOnlyAttributes() 
	
	object Inherited : ShotgunBuildingRescueAttributes 
}