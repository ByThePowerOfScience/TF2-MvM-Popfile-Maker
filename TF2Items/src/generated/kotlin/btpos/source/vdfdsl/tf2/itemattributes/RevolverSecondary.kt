package btpos.source.vdfdsl.tf2.itemattributes

import btpos.source.vdfdsl.modeling.*
import btpos.source.vdfdsl.serialization.codecs.*
import btpos.source.vdfdsl.tf2.itemattributes.impl.*
import btpos.source.vdfdsl.tf2.tftypes.*
import java.util.*
import kotlin.time.Duration

interface RevolverSecondaryAttributes : IBlockScoped, RevolverAttributes {
	companion object : IBlockScoped {
		private val heads: HeadsAttributes = HeadsAttributes()
	
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

	override val heads: HeadsAttributes get() = RevolverSecondaryAttributes.heads
	
	override val ammo: AmmoAttributes get() = RevolverSecondaryAttributes.ammo
	
	override val damage: DamageAttributes get() = RevolverSecondaryAttributes.damage
	
	override val firing: FiringAttributes get() = RevolverSecondaryAttributes.firing
	
	override val projectiles: ProjectilesAttributes get() = RevolverSecondaryAttributes.projectiles
	
	override val afterburn: AfterburnAttributes get() = RevolverSecondaryAttributes.afterburn
	
	override val buildings: BuildingsAttributes get() = RevolverSecondaryAttributes.buildings
	
	override val crits: CritsAttributes get() = RevolverSecondaryAttributes.crits
	
	override val demoCharge: DemoChargeAttributes get() = RevolverSecondaryAttributes.demoCharge
	
	override val healthAndHealing: HealthAndHealingAttributes get() = RevolverSecondaryAttributes.healthAndHealing
	
	override val knockbackReceived: KnockbackReceivedAttributes get() = RevolverSecondaryAttributes.knockbackReceived
	
	override val meta: MetaAttributes get() = RevolverSecondaryAttributes.meta
	
	override val meter: MeterAttributes get() = RevolverSecondaryAttributes.meter
	
	override val movement: MovementAttributes get() = RevolverSecondaryAttributes.movement
	
	override val onHit: OnHitAttributes get() = RevolverSecondaryAttributes.onHit
	
	override val onKill: OnKillAttributes get() = RevolverSecondaryAttributes.onKill
	
	override val reloading: ReloadingAttributes get() = RevolverSecondaryAttributes.reloading
	
	override val resistance: ResistanceAttributes get() = RevolverSecondaryAttributes.resistance
	
	override val revengeCrits: RevengeCritsAttributes get() = RevolverSecondaryAttributes.revengeCrits
	
	override val statusEffects: StatusEffectsAttributes get() = RevolverSecondaryAttributes.statusEffects
	
	override val taunting: TauntingAttributes get() = RevolverSecondaryAttributes.taunting
	
	override val swapWeapons: SwapWeaponsAttributes get() = RevolverSecondaryAttributes.swapWeapons
	
	override val whenHit: WhenHitAttributes get() = RevolverSecondaryAttributes.whenHit
	
	override val ragdolls: RagdollsAttributes get() = RevolverSecondaryAttributes.ragdolls
	
	override val buffItems: BuffItemsAttributes get() = RevolverSecondaryAttributes.buffItems
	
	override val cloak: CloakAttributes get() = RevolverSecondaryAttributes.cloak
	
	override val disguise: DisguiseAttributes get() = RevolverSecondaryAttributes.disguise
	
	override val hud: HudAttributes get() = RevolverSecondaryAttributes.hud
	
	override val spyOnly: SpyOnlyAttributes get() = RevolverSecondaryAttributes.spyOnly

	open class HeadsAttributes : RevolverAttributes.HeadsAttributes() 
	
	open class AmmoAttributes : RevolverAttributes.AmmoAttributes() {
		override val clipSize: ClipSizeAttributes = ClipSizeAttributes()
	
		override val maxAmmo: MaxAmmoAttributes = MaxAmmoAttributes()
	
		open class ClipSizeAttributes : RevolverAttributes.AmmoAttributes.ClipSizeAttributes() 
	
		open class MaxAmmoAttributes : RevolverAttributes.AmmoAttributes.MaxAmmoAttributes() 
	}
	
	open class DamageAttributes : RevolverAttributes.DamageAttributes() {
		override val alien: AlienAttributes = AlienAttributes()
	
		open class AlienAttributes : RevolverAttributes.DamageAttributes.AlienAttributes() 
	}
	
	open class FiringAttributes : RevolverAttributes.FiringAttributes() {
		override val fireRate: FireRateAttributes = FireRateAttributes()
	
		open class FireRateAttributes : RevolverAttributes.FiringAttributes.FireRateAttributes() 
	}
	
	open class ProjectilesAttributes : RevolverAttributes.ProjectilesAttributes() {
		override val bullets: BulletsAttributes = BulletsAttributes()
	
		override val projectilePenetration: ProjectilePenetrationAttributes = ProjectilePenetrationAttributes()
	
		open class BulletsAttributes : RevolverAttributes.ProjectilesAttributes.BulletsAttributes() 
	
		open class ProjectilePenetrationAttributes : RevolverAttributes.ProjectilesAttributes.ProjectilePenetrationAttributes() 
	}
	
	open class AfterburnAttributes : RevolverAttributes.AfterburnAttributes() 
	
	open class BuildingsAttributes : RevolverAttributes.BuildingsAttributes() {
		override val sentryGun: SentryGunAttributes = SentryGunAttributes()
	
		override val dispenser: DispenserAttributes = DispenserAttributes()
	
		override val teleporter: TeleporterAttributes = TeleporterAttributes()
	
		open class SentryGunAttributes : RevolverAttributes.BuildingsAttributes.SentryGunAttributes() 
	
		open class DispenserAttributes : RevolverAttributes.BuildingsAttributes.DispenserAttributes() 
	
		open class TeleporterAttributes : RevolverAttributes.BuildingsAttributes.TeleporterAttributes() 
	}
	
	open class CritsAttributes : RevolverAttributes.CritsAttributes() 
	
	open class DemoChargeAttributes : RevolverAttributes.DemoChargeAttributes() {
		override val multChargeTurnControl: MultChargeTurnControlAttributes = MultChargeTurnControlAttributes()
	
		open class MultChargeTurnControlAttributes : RevolverAttributes.DemoChargeAttributes.MultChargeTurnControlAttributes() 
	}
	
	open class HealthAndHealingAttributes : RevolverAttributes.HealthAndHealingAttributes() {
		override val healthRegen: HealthRegenAttributes = HealthRegenAttributes()
	
		override val maxHealthAdditive: MaxHealthAdditiveAttributes = MaxHealthAdditiveAttributes()
	
		open class HealthRegenAttributes : RevolverAttributes.HealthAndHealingAttributes.HealthRegenAttributes() 
	
		open class MaxHealthAdditiveAttributes : RevolverAttributes.HealthAndHealingAttributes.MaxHealthAdditiveAttributes() 
	}
	
	open class KnockbackReceivedAttributes : RevolverAttributes.KnockbackReceivedAttributes() {
		override val damageForceReduction: DamageForceReductionAttributes = DamageForceReductionAttributes()
	
		open class DamageForceReductionAttributes : RevolverAttributes.KnockbackReceivedAttributes.DamageForceReductionAttributes() 
	}
	
	open class MetaAttributes : RevolverAttributes.MetaAttributes() {
		override val killfeed: KillfeedAttributes = KillfeedAttributes()
	
		override val viewmodel: ViewmodelAttributes = ViewmodelAttributes()
	
		override val items: ItemsAttributes = ItemsAttributes()
	
		override val particles: ParticlesAttributes = ParticlesAttributes()
	
		override val noisemakers: NoisemakersAttributes = NoisemakersAttributes()
	
		override val player: PlayerAttributes = PlayerAttributes()
	
		override val gameplay: GameplayAttributes = GameplayAttributes()
	
		open class KillfeedAttributes : RevolverAttributes.MetaAttributes.KillfeedAttributes() 
	
		open class ViewmodelAttributes : RevolverAttributes.MetaAttributes.ViewmodelAttributes() 
	
		open class ItemsAttributes : RevolverAttributes.MetaAttributes.ItemsAttributes() 
	
		open class ParticlesAttributes : RevolverAttributes.MetaAttributes.ParticlesAttributes() 
	
		open class NoisemakersAttributes : RevolverAttributes.MetaAttributes.NoisemakersAttributes() 
	
		open class PlayerAttributes : RevolverAttributes.MetaAttributes.PlayerAttributes() 
	
		open class GameplayAttributes : RevolverAttributes.MetaAttributes.GameplayAttributes() 
	}
	
	open class MeterAttributes : RevolverAttributes.MeterAttributes() {
		override val generateRageOnDamage: GenerateRageOnDamageAttributes = GenerateRageOnDamageAttributes()
	
		open class GenerateRageOnDamageAttributes : RevolverAttributes.MeterAttributes.GenerateRageOnDamageAttributes() 
	}
	
	open class MovementAttributes : RevolverAttributes.MovementAttributes() {
		override val moveSpeed: MoveSpeedAttributes = MoveSpeedAttributes()
	
		override val jumpHeight: jumpHeightAttributes = jumpHeightAttributes()
	
		open class MoveSpeedAttributes : RevolverAttributes.MovementAttributes.MoveSpeedAttributes() {
			override val aimingMovespeed: AimingMovespeedAttributes = AimingMovespeedAttributes()
	
			override val moveSpeed: MoveSpeedAttributes = MoveSpeedAttributes()
	
			open class AimingMovespeedAttributes : RevolverAttributes.MovementAttributes.MoveSpeedAttributes.AimingMovespeedAttributes() 
	
			open class MoveSpeedAttributes : RevolverAttributes.MovementAttributes.MoveSpeedAttributes.MoveSpeedAttributes() 
		}
	
		open class jumpHeightAttributes : RevolverAttributes.MovementAttributes.jumpHeightAttributes() 
	}
	
	open class OnHitAttributes : RevolverAttributes.OnHitAttributes() {
		override val healOnHitForRapidfire: HealOnHitForRapidfireAttributes = HealOnHitForRapidfireAttributes()
	
		override val generateRageOnDamage: GenerateRageOnDamageAttributes = GenerateRageOnDamageAttributes()
	
		override val falling: FallingAttributes = FallingAttributes()
	
		open class HealOnHitForRapidfireAttributes : RevolverAttributes.OnHitAttributes.HealOnHitForRapidfireAttributes() 
	
		open class GenerateRageOnDamageAttributes : RevolverAttributes.OnHitAttributes.GenerateRageOnDamageAttributes() 
	
		open class FallingAttributes : RevolverAttributes.OnHitAttributes.FallingAttributes() 
	}
	
	open class OnKillAttributes : RevolverAttributes.OnKillAttributes() 
	
	open class ReloadingAttributes : RevolverAttributes.ReloadingAttributes() 
	
	open class ResistanceAttributes : RevolverAttributes.ResistanceAttributes() {
		override val dmgTakenFromCritReduced: DmgTakenFromCritReducedAttributes = DmgTakenFromCritReducedAttributes()
	
		override val dmgTakenFromFireReduced: DmgTakenFromFireReducedAttributes = DmgTakenFromFireReducedAttributes()
	
		override val dmgTakenFromBulletsReduced: DmgTakenFromBulletsReducedAttributes = DmgTakenFromBulletsReducedAttributes()
	
		override val vaccinator: VaccinatorAttributes = VaccinatorAttributes()
	
		open class DmgTakenFromCritReducedAttributes : RevolverAttributes.ResistanceAttributes.DmgTakenFromCritReducedAttributes() 
	
		open class DmgTakenFromFireReducedAttributes : RevolverAttributes.ResistanceAttributes.DmgTakenFromFireReducedAttributes() 
	
		open class DmgTakenFromBulletsReducedAttributes : RevolverAttributes.ResistanceAttributes.DmgTakenFromBulletsReducedAttributes() 
	
		open class VaccinatorAttributes : RevolverAttributes.ResistanceAttributes.VaccinatorAttributes() 
	}
	
	open class RevengeCritsAttributes : RevolverAttributes.RevengeCritsAttributes() 
	
	open class StatusEffectsAttributes : RevolverAttributes.StatusEffectsAttributes() 
	
	open class TauntingAttributes : RevolverAttributes.TauntingAttributes() 
	
	open class SwapWeaponsAttributes : RevolverAttributes.SwapWeaponsAttributes() {
		override val deploy: DeployAttributes = DeployAttributes()
	
		open class DeployAttributes : RevolverAttributes.SwapWeaponsAttributes.DeployAttributes() 
	}
	
	open class WhenHitAttributes : RevolverAttributes.WhenHitAttributes() 
	
	open class RagdollsAttributes : RevolverAttributes.RagdollsAttributes() 
	
	open class BuffItemsAttributes : RevolverAttributes.BuffItemsAttributes() 
	
	open class CloakAttributes : RevolverAttributes.CloakAttributes() 
	
	open class DisguiseAttributes : RevolverAttributes.DisguiseAttributes() 
	
	open class HudAttributes : RevolverAttributes.HudAttributes() 
	
	open class SpyOnlyAttributes : RevolverAttributes.SpyOnlyAttributes() 
	
	object Inherited : RevolverSecondaryAttributes 
}