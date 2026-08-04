package btpos.source.vdfdsl.tf2.itemattributes

import btpos.source.vdfdsl.modeling.*
import btpos.source.vdfdsl.serialization.codecs.*
import btpos.source.vdfdsl.tf2.itemattributes.impl.*
import btpos.source.vdfdsl.tf2.tftypes.*
import java.util.*
import kotlin.time.Duration

interface BatWoodAttributes : IBlockScoped, BatAttributes {
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

	override val crits: CritsAttributes get() = BatWoodAttributes.crits
	
	override val damage: DamageAttributes get() = BatWoodAttributes.damage
	
	override val onHit: OnHitAttributes get() = BatWoodAttributes.onHit
	
	override val swapWeapons: SwapWeaponsAttributes get() = BatWoodAttributes.swapWeapons
	
	override val afterburn: AfterburnAttributes get() = BatWoodAttributes.afterburn
	
	override val ammo: AmmoAttributes get() = BatWoodAttributes.ammo
	
	override val buildings: BuildingsAttributes get() = BatWoodAttributes.buildings
	
	override val demoCharge: DemoChargeAttributes get() = BatWoodAttributes.demoCharge
	
	override val firing: FiringAttributes get() = BatWoodAttributes.firing
	
	override val healthAndHealing: HealthAndHealingAttributes get() = BatWoodAttributes.healthAndHealing
	
	override val knockbackReceived: KnockbackReceivedAttributes get() = BatWoodAttributes.knockbackReceived
	
	override val meta: MetaAttributes get() = BatWoodAttributes.meta
	
	override val meter: MeterAttributes get() = BatWoodAttributes.meter
	
	override val movement: MovementAttributes get() = BatWoodAttributes.movement
	
	override val heads: HeadsAttributes get() = BatWoodAttributes.heads
	
	override val onKill: OnKillAttributes get() = BatWoodAttributes.onKill
	
	override val projectiles: ProjectilesAttributes get() = BatWoodAttributes.projectiles
	
	override val reloading: ReloadingAttributes get() = BatWoodAttributes.reloading
	
	override val resistance: ResistanceAttributes get() = BatWoodAttributes.resistance
	
	override val revengeCrits: RevengeCritsAttributes get() = BatWoodAttributes.revengeCrits
	
	override val statusEffects: StatusEffectsAttributes get() = BatWoodAttributes.statusEffects
	
	override val taunting: TauntingAttributes get() = BatWoodAttributes.taunting
	
	override val whenHit: WhenHitAttributes get() = BatWoodAttributes.whenHit
	
	override val ragdolls: RagdollsAttributes get() = BatWoodAttributes.ragdolls
	
	override val buffItems: BuffItemsAttributes get() = BatWoodAttributes.buffItems
	
	override val cloak: CloakAttributes get() = BatWoodAttributes.cloak
	
	override val disguise: DisguiseAttributes get() = BatWoodAttributes.disguise
	
	override val hud: HudAttributes get() = BatWoodAttributes.hud
	
	override val spyOnly: SpyOnlyAttributes get() = BatWoodAttributes.spyOnly

	open class CritsAttributes : BatAttributes.CritsAttributes() 
	
	open class DamageAttributes : BatAttributes.DamageAttributes() {
		override val alien: AlienAttributes = AlienAttributes()
	
		open class AlienAttributes : BatAttributes.DamageAttributes.AlienAttributes() 
	}
	
	open class OnHitAttributes : BatAttributes.OnHitAttributes() {
		override val healOnHitForRapidfire: HealOnHitForRapidfireAttributes = HealOnHitForRapidfireAttributes()
	
		override val generateRageOnDamage: GenerateRageOnDamageAttributes = GenerateRageOnDamageAttributes()
	
		override val falling: FallingAttributes = FallingAttributes()
	
		open class HealOnHitForRapidfireAttributes : BatAttributes.OnHitAttributes.HealOnHitForRapidfireAttributes() 
	
		open class GenerateRageOnDamageAttributes : BatAttributes.OnHitAttributes.GenerateRageOnDamageAttributes() 
	
		open class FallingAttributes : BatAttributes.OnHitAttributes.FallingAttributes() 
	}
	
	open class SwapWeaponsAttributes : BatAttributes.SwapWeaponsAttributes() {
		override val deploy: DeployAttributes = DeployAttributes()
	
		open class DeployAttributes : BatAttributes.SwapWeaponsAttributes.DeployAttributes() 
	}
	
	open class AfterburnAttributes : BatAttributes.AfterburnAttributes() 
	
	open class AmmoAttributes : BatAttributes.AmmoAttributes() {
		override val clipSize: ClipSizeAttributes = ClipSizeAttributes()
	
		override val maxAmmo: MaxAmmoAttributes = MaxAmmoAttributes()
	
		open class ClipSizeAttributes : BatAttributes.AmmoAttributes.ClipSizeAttributes() 
	
		open class MaxAmmoAttributes : BatAttributes.AmmoAttributes.MaxAmmoAttributes() 
	}
	
	open class BuildingsAttributes : BatAttributes.BuildingsAttributes() {
		override val sentryGun: SentryGunAttributes = SentryGunAttributes()
	
		override val dispenser: DispenserAttributes = DispenserAttributes()
	
		override val teleporter: TeleporterAttributes = TeleporterAttributes()
	
		open class SentryGunAttributes : BatAttributes.BuildingsAttributes.SentryGunAttributes() 
	
		open class DispenserAttributes : BatAttributes.BuildingsAttributes.DispenserAttributes() 
	
		open class TeleporterAttributes : BatAttributes.BuildingsAttributes.TeleporterAttributes() 
	}
	
	open class DemoChargeAttributes : BatAttributes.DemoChargeAttributes() {
		override val multChargeTurnControl: MultChargeTurnControlAttributes = MultChargeTurnControlAttributes()
	
		open class MultChargeTurnControlAttributes : BatAttributes.DemoChargeAttributes.MultChargeTurnControlAttributes() 
	}
	
	open class FiringAttributes : BatAttributes.FiringAttributes() {
		override val fireRate: FireRateAttributes = FireRateAttributes()
	
		open class FireRateAttributes : BatAttributes.FiringAttributes.FireRateAttributes() 
	}
	
	open class HealthAndHealingAttributes : BatAttributes.HealthAndHealingAttributes() {
		override val healthRegen: HealthRegenAttributes = HealthRegenAttributes()
	
		override val maxHealthAdditive: MaxHealthAdditiveAttributes = MaxHealthAdditiveAttributes()
	
		open class HealthRegenAttributes : BatAttributes.HealthAndHealingAttributes.HealthRegenAttributes() 
	
		open class MaxHealthAdditiveAttributes : BatAttributes.HealthAndHealingAttributes.MaxHealthAdditiveAttributes() 
	}
	
	open class KnockbackReceivedAttributes : BatAttributes.KnockbackReceivedAttributes() {
		override val damageForceReduction: DamageForceReductionAttributes = DamageForceReductionAttributes()
	
		open class DamageForceReductionAttributes : BatAttributes.KnockbackReceivedAttributes.DamageForceReductionAttributes() 
	}
	
	open class MetaAttributes : BatAttributes.MetaAttributes() {
		override val killfeed: KillfeedAttributes = KillfeedAttributes()
	
		override val viewmodel: ViewmodelAttributes = ViewmodelAttributes()
	
		override val items: ItemsAttributes = ItemsAttributes()
	
		override val particles: ParticlesAttributes = ParticlesAttributes()
	
		override val noisemakers: NoisemakersAttributes = NoisemakersAttributes()
	
		override val player: PlayerAttributes = PlayerAttributes()
	
		override val gameplay: GameplayAttributes = GameplayAttributes()
	
		open class KillfeedAttributes : BatAttributes.MetaAttributes.KillfeedAttributes() 
	
		open class ViewmodelAttributes : BatAttributes.MetaAttributes.ViewmodelAttributes() 
	
		open class ItemsAttributes : BatAttributes.MetaAttributes.ItemsAttributes() 
	
		open class ParticlesAttributes : BatAttributes.MetaAttributes.ParticlesAttributes() 
	
		open class NoisemakersAttributes : BatAttributes.MetaAttributes.NoisemakersAttributes() 
	
		open class PlayerAttributes : BatAttributes.MetaAttributes.PlayerAttributes() 
	
		open class GameplayAttributes : BatAttributes.MetaAttributes.GameplayAttributes() 
	}
	
	open class MeterAttributes : BatAttributes.MeterAttributes() {
		override val generateRageOnDamage: GenerateRageOnDamageAttributes = GenerateRageOnDamageAttributes()
	
		open class GenerateRageOnDamageAttributes : BatAttributes.MeterAttributes.GenerateRageOnDamageAttributes() 
	}
	
	open class MovementAttributes : BatAttributes.MovementAttributes() {
		override val moveSpeed: MoveSpeedAttributes = MoveSpeedAttributes()
	
		override val jumpHeight: jumpHeightAttributes = jumpHeightAttributes()
	
		open class MoveSpeedAttributes : BatAttributes.MovementAttributes.MoveSpeedAttributes() {
			override val aimingMovespeed: AimingMovespeedAttributes = AimingMovespeedAttributes()
	
			override val moveSpeed: MoveSpeedAttributes = MoveSpeedAttributes()
	
			open class AimingMovespeedAttributes : BatAttributes.MovementAttributes.MoveSpeedAttributes.AimingMovespeedAttributes() 
	
			open class MoveSpeedAttributes : BatAttributes.MovementAttributes.MoveSpeedAttributes.MoveSpeedAttributes() 
		}
	
		open class jumpHeightAttributes : BatAttributes.MovementAttributes.jumpHeightAttributes() 
	}
	
	open class HeadsAttributes : BatAttributes.HeadsAttributes() 
	
	open class OnKillAttributes : BatAttributes.OnKillAttributes() 
	
	open class ProjectilesAttributes : BatAttributes.ProjectilesAttributes() {
		override val projectilePenetration: ProjectilePenetrationAttributes = ProjectilePenetrationAttributes()
	
		override val bullets: BulletsAttributes = BulletsAttributes()
	
		open class ProjectilePenetrationAttributes : BatAttributes.ProjectilesAttributes.ProjectilePenetrationAttributes() 
	
		open class BulletsAttributes : BatAttributes.ProjectilesAttributes.BulletsAttributes() 
	}
	
	open class ReloadingAttributes : BatAttributes.ReloadingAttributes() 
	
	open class ResistanceAttributes : BatAttributes.ResistanceAttributes() {
		override val dmgTakenFromCritReduced: DmgTakenFromCritReducedAttributes = DmgTakenFromCritReducedAttributes()
	
		override val dmgTakenFromFireReduced: DmgTakenFromFireReducedAttributes = DmgTakenFromFireReducedAttributes()
	
		override val dmgTakenFromBulletsReduced: DmgTakenFromBulletsReducedAttributes = DmgTakenFromBulletsReducedAttributes()
	
		override val vaccinator: VaccinatorAttributes = VaccinatorAttributes()
	
		open class DmgTakenFromCritReducedAttributes : BatAttributes.ResistanceAttributes.DmgTakenFromCritReducedAttributes() 
	
		open class DmgTakenFromFireReducedAttributes : BatAttributes.ResistanceAttributes.DmgTakenFromFireReducedAttributes() 
	
		open class DmgTakenFromBulletsReducedAttributes : BatAttributes.ResistanceAttributes.DmgTakenFromBulletsReducedAttributes() 
	
		open class VaccinatorAttributes : BatAttributes.ResistanceAttributes.VaccinatorAttributes() 
	}
	
	open class RevengeCritsAttributes : BatAttributes.RevengeCritsAttributes() 
	
	open class StatusEffectsAttributes : BatAttributes.StatusEffectsAttributes() 
	
	open class TauntingAttributes : BatAttributes.TauntingAttributes() 
	
	open class WhenHitAttributes : BatAttributes.WhenHitAttributes() 
	
	open class RagdollsAttributes : BatAttributes.RagdollsAttributes() 
	
	open class BuffItemsAttributes : BatAttributes.BuffItemsAttributes() 
	
	open class CloakAttributes : BatAttributes.CloakAttributes() 
	
	open class DisguiseAttributes : BatAttributes.DisguiseAttributes() 
	
	open class HudAttributes : BatAttributes.HudAttributes() 
	
	open class SpyOnlyAttributes : BatAttributes.SpyOnlyAttributes() 
	
	object Inherited : BatWoodAttributes 
}