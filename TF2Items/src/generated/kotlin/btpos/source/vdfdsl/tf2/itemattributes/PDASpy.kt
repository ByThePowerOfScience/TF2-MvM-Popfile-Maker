package btpos.source.vdfdsl.tf2.itemattributes

import btpos.source.vdfdsl.modeling.*
import btpos.source.vdfdsl.serialization.codecs.*
import btpos.source.vdfdsl.tf2.itemattributes.impl.*
import btpos.source.vdfdsl.tf2.tftypes.*
import java.util.*
import kotlin.time.Duration

interface PDASpyAttributes : IBlockScoped, PDAAttributes {
	companion object : IBlockScoped {
		private val afterburn: AfterburnAttributes = AfterburnAttributes()
	
		private val ammo: AmmoAttributes = AmmoAttributes()
	
		private val buildings: BuildingsAttributes = BuildingsAttributes()
	
		private val crits: CritsAttributes = CritsAttributes()
	
		private val damage: DamageAttributes = DamageAttributes()
	
		private val demoCharge: DemoChargeAttributes = DemoChargeAttributes()
	
		private val firing: FiringAttributes = FiringAttributes()
	
		private val healthAndHealing: HealthAndHealingAttributes = HealthAndHealingAttributes()
	
		private val knockbackReceived: KnockbackReceivedAttributes = KnockbackReceivedAttributes()
	
		private val meta: MetaAttributes = MetaAttributes()
	
		private val meter: MeterAttributes = MeterAttributes()
	
		private val movement: MovementAttributes = MovementAttributes()
	
		private val heads: HeadsAttributes = HeadsAttributes()
	
		private val onHit: OnHitAttributes = OnHitAttributes()
	
		private val onKill: OnKillAttributes = OnKillAttributes()
	
		private val projectiles: ProjectilesAttributes = ProjectilesAttributes()
	
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

	override val afterburn: AfterburnAttributes get() = PDASpyAttributes.afterburn
	
	override val ammo: AmmoAttributes get() = PDASpyAttributes.ammo
	
	override val buildings: BuildingsAttributes get() = PDASpyAttributes.buildings
	
	override val crits: CritsAttributes get() = PDASpyAttributes.crits
	
	override val damage: DamageAttributes get() = PDASpyAttributes.damage
	
	override val demoCharge: DemoChargeAttributes get() = PDASpyAttributes.demoCharge
	
	override val firing: FiringAttributes get() = PDASpyAttributes.firing
	
	override val healthAndHealing: HealthAndHealingAttributes get() = PDASpyAttributes.healthAndHealing
	
	override val knockbackReceived: KnockbackReceivedAttributes get() = PDASpyAttributes.knockbackReceived
	
	override val meta: MetaAttributes get() = PDASpyAttributes.meta
	
	override val meter: MeterAttributes get() = PDASpyAttributes.meter
	
	override val movement: MovementAttributes get() = PDASpyAttributes.movement
	
	override val heads: HeadsAttributes get() = PDASpyAttributes.heads
	
	override val onHit: OnHitAttributes get() = PDASpyAttributes.onHit
	
	override val onKill: OnKillAttributes get() = PDASpyAttributes.onKill
	
	override val projectiles: ProjectilesAttributes get() = PDASpyAttributes.projectiles
	
	override val reloading: ReloadingAttributes get() = PDASpyAttributes.reloading
	
	override val resistance: ResistanceAttributes get() = PDASpyAttributes.resistance
	
	override val revengeCrits: RevengeCritsAttributes get() = PDASpyAttributes.revengeCrits
	
	override val statusEffects: StatusEffectsAttributes get() = PDASpyAttributes.statusEffects
	
	override val taunting: TauntingAttributes get() = PDASpyAttributes.taunting
	
	override val swapWeapons: SwapWeaponsAttributes get() = PDASpyAttributes.swapWeapons
	
	override val whenHit: WhenHitAttributes get() = PDASpyAttributes.whenHit
	
	override val ragdolls: RagdollsAttributes get() = PDASpyAttributes.ragdolls
	
	override val buffItems: BuffItemsAttributes get() = PDASpyAttributes.buffItems
	
	override val cloak: CloakAttributes get() = PDASpyAttributes.cloak
	
	override val disguise: DisguiseAttributes get() = PDASpyAttributes.disguise
	
	override val hud: HudAttributes get() = PDASpyAttributes.hud
	
	override val spyOnly: SpyOnlyAttributes get() = PDASpyAttributes.spyOnly

	open class AfterburnAttributes : PDAAttributes.AfterburnAttributes() 
	
	open class AmmoAttributes : PDAAttributes.AmmoAttributes() {
		override val clipSize: ClipSizeAttributes = ClipSizeAttributes()
	
		override val maxAmmo: MaxAmmoAttributes = MaxAmmoAttributes()
	
		open class ClipSizeAttributes : PDAAttributes.AmmoAttributes.ClipSizeAttributes() 
	
		open class MaxAmmoAttributes : PDAAttributes.AmmoAttributes.MaxAmmoAttributes() 
	}
	
	open class BuildingsAttributes : PDAAttributes.BuildingsAttributes() {
		override val sentryGun: SentryGunAttributes = SentryGunAttributes()
	
		override val dispenser: DispenserAttributes = DispenserAttributes()
	
		override val teleporter: TeleporterAttributes = TeleporterAttributes()
	
		open class SentryGunAttributes : PDAAttributes.BuildingsAttributes.SentryGunAttributes() 
	
		open class DispenserAttributes : PDAAttributes.BuildingsAttributes.DispenserAttributes() 
	
		open class TeleporterAttributes : PDAAttributes.BuildingsAttributes.TeleporterAttributes() 
	}
	
	open class CritsAttributes : PDAAttributes.CritsAttributes() 
	
	open class DamageAttributes : PDAAttributes.DamageAttributes() {
		override val alien: AlienAttributes = AlienAttributes()
	
		open class AlienAttributes : PDAAttributes.DamageAttributes.AlienAttributes() 
	}
	
	open class DemoChargeAttributes : PDAAttributes.DemoChargeAttributes() {
		override val multChargeTurnControl: MultChargeTurnControlAttributes = MultChargeTurnControlAttributes()
	
		open class MultChargeTurnControlAttributes : PDAAttributes.DemoChargeAttributes.MultChargeTurnControlAttributes() 
	}
	
	open class FiringAttributes : PDAAttributes.FiringAttributes() {
		override val fireRate: FireRateAttributes = FireRateAttributes()
	
		open class FireRateAttributes : PDAAttributes.FiringAttributes.FireRateAttributes() 
	}
	
	open class HealthAndHealingAttributes : PDAAttributes.HealthAndHealingAttributes() {
		override val healthRegen: HealthRegenAttributes = HealthRegenAttributes()
	
		override val maxHealthAdditive: MaxHealthAdditiveAttributes = MaxHealthAdditiveAttributes()
	
		open class HealthRegenAttributes : PDAAttributes.HealthAndHealingAttributes.HealthRegenAttributes() 
	
		open class MaxHealthAdditiveAttributes : PDAAttributes.HealthAndHealingAttributes.MaxHealthAdditiveAttributes() 
	}
	
	open class KnockbackReceivedAttributes : PDAAttributes.KnockbackReceivedAttributes() {
		override val damageForceReduction: DamageForceReductionAttributes = DamageForceReductionAttributes()
	
		open class DamageForceReductionAttributes : PDAAttributes.KnockbackReceivedAttributes.DamageForceReductionAttributes() 
	}
	
	open class MetaAttributes : PDAAttributes.MetaAttributes() {
		override val killfeed: KillfeedAttributes = KillfeedAttributes()
	
		override val viewmodel: ViewmodelAttributes = ViewmodelAttributes()
	
		override val items: ItemsAttributes = ItemsAttributes()
	
		override val particles: ParticlesAttributes = ParticlesAttributes()
	
		override val noisemakers: NoisemakersAttributes = NoisemakersAttributes()
	
		override val player: PlayerAttributes = PlayerAttributes()
	
		override val gameplay: GameplayAttributes = GameplayAttributes()
	
		open class KillfeedAttributes : PDAAttributes.MetaAttributes.KillfeedAttributes() 
	
		open class ViewmodelAttributes : PDAAttributes.MetaAttributes.ViewmodelAttributes() 
	
		open class ItemsAttributes : PDAAttributes.MetaAttributes.ItemsAttributes() 
	
		open class ParticlesAttributes : PDAAttributes.MetaAttributes.ParticlesAttributes() 
	
		open class NoisemakersAttributes : PDAAttributes.MetaAttributes.NoisemakersAttributes() 
	
		open class PlayerAttributes : PDAAttributes.MetaAttributes.PlayerAttributes() 
	
		open class GameplayAttributes : PDAAttributes.MetaAttributes.GameplayAttributes() 
	}
	
	open class MeterAttributes : PDAAttributes.MeterAttributes() {
		override val generateRageOnDamage: GenerateRageOnDamageAttributes = GenerateRageOnDamageAttributes()
	
		open class GenerateRageOnDamageAttributes : PDAAttributes.MeterAttributes.GenerateRageOnDamageAttributes() 
	}
	
	open class MovementAttributes : PDAAttributes.MovementAttributes() {
		override val moveSpeed: MoveSpeedAttributes = MoveSpeedAttributes()
	
		override val jumpHeight: jumpHeightAttributes = jumpHeightAttributes()
	
		open class MoveSpeedAttributes : PDAAttributes.MovementAttributes.MoveSpeedAttributes() {
			override val aimingMovespeed: AimingMovespeedAttributes = AimingMovespeedAttributes()
	
			override val moveSpeed: MoveSpeedAttributes = MoveSpeedAttributes()
	
			open class AimingMovespeedAttributes : PDAAttributes.MovementAttributes.MoveSpeedAttributes.AimingMovespeedAttributes() 
	
			open class MoveSpeedAttributes : PDAAttributes.MovementAttributes.MoveSpeedAttributes.MoveSpeedAttributes() 
		}
	
		open class jumpHeightAttributes : PDAAttributes.MovementAttributes.jumpHeightAttributes() 
	}
	
	open class HeadsAttributes : PDAAttributes.HeadsAttributes() 
	
	open class OnHitAttributes : PDAAttributes.OnHitAttributes() {
		override val healOnHitForRapidfire: HealOnHitForRapidfireAttributes = HealOnHitForRapidfireAttributes()
	
		override val generateRageOnDamage: GenerateRageOnDamageAttributes = GenerateRageOnDamageAttributes()
	
		override val falling: FallingAttributes = FallingAttributes()
	
		open class HealOnHitForRapidfireAttributes : PDAAttributes.OnHitAttributes.HealOnHitForRapidfireAttributes() 
	
		open class GenerateRageOnDamageAttributes : PDAAttributes.OnHitAttributes.GenerateRageOnDamageAttributes() 
	
		open class FallingAttributes : PDAAttributes.OnHitAttributes.FallingAttributes() 
	}
	
	open class OnKillAttributes : PDAAttributes.OnKillAttributes() 
	
	open class ProjectilesAttributes : PDAAttributes.ProjectilesAttributes() {
		override val projectilePenetration: ProjectilePenetrationAttributes = ProjectilePenetrationAttributes()
	
		override val bullets: BulletsAttributes = BulletsAttributes()
	
		open class ProjectilePenetrationAttributes : PDAAttributes.ProjectilesAttributes.ProjectilePenetrationAttributes() 
	
		open class BulletsAttributes : PDAAttributes.ProjectilesAttributes.BulletsAttributes() 
	}
	
	open class ReloadingAttributes : PDAAttributes.ReloadingAttributes() 
	
	open class ResistanceAttributes : PDAAttributes.ResistanceAttributes() {
		override val dmgTakenFromCritReduced: DmgTakenFromCritReducedAttributes = DmgTakenFromCritReducedAttributes()
	
		override val dmgTakenFromFireReduced: DmgTakenFromFireReducedAttributes = DmgTakenFromFireReducedAttributes()
	
		override val dmgTakenFromBulletsReduced: DmgTakenFromBulletsReducedAttributes = DmgTakenFromBulletsReducedAttributes()
	
		override val vaccinator: VaccinatorAttributes = VaccinatorAttributes()
	
		open class DmgTakenFromCritReducedAttributes : PDAAttributes.ResistanceAttributes.DmgTakenFromCritReducedAttributes() 
	
		open class DmgTakenFromFireReducedAttributes : PDAAttributes.ResistanceAttributes.DmgTakenFromFireReducedAttributes() 
	
		open class DmgTakenFromBulletsReducedAttributes : PDAAttributes.ResistanceAttributes.DmgTakenFromBulletsReducedAttributes() 
	
		open class VaccinatorAttributes : PDAAttributes.ResistanceAttributes.VaccinatorAttributes() 
	}
	
	open class RevengeCritsAttributes : PDAAttributes.RevengeCritsAttributes() 
	
	open class StatusEffectsAttributes : PDAAttributes.StatusEffectsAttributes() 
	
	open class TauntingAttributes : PDAAttributes.TauntingAttributes() 
	
	open class SwapWeaponsAttributes : PDAAttributes.SwapWeaponsAttributes() {
		override val deploy: DeployAttributes = DeployAttributes()
	
		open class DeployAttributes : PDAAttributes.SwapWeaponsAttributes.DeployAttributes() 
	}
	
	open class WhenHitAttributes : PDAAttributes.WhenHitAttributes() 
	
	open class RagdollsAttributes : PDAAttributes.RagdollsAttributes() 
	
	open class BuffItemsAttributes : PDAAttributes.BuffItemsAttributes() 
	
	open class CloakAttributes : PDAAttributes.CloakAttributes() 
	
	open class DisguiseAttributes : PDAAttributes.DisguiseAttributes() 
	
	open class HudAttributes : PDAAttributes.HudAttributes() 
	
	open class SpyOnlyAttributes : PDAAttributes.SpyOnlyAttributes() 
	
	object Inherited : PDASpyAttributes 
}