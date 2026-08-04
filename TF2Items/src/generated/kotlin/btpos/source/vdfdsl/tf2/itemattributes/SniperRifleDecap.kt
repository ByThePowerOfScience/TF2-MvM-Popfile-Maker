package btpos.source.vdfdsl.tf2.itemattributes

import btpos.source.vdfdsl.modeling.*
import btpos.source.vdfdsl.serialization.codecs.*
import btpos.source.vdfdsl.tf2.itemattributes.impl.*
import btpos.source.vdfdsl.tf2.tftypes.*
import java.util.*
import kotlin.time.Duration

interface SniperRifleDecapAttributes : IBlockScoped, SniperRifleAttributes {
	companion object : IBlockScoped {
		private val damage: DamageAttributes = DamageAttributes()
	
		private val onHit: OnHitAttributes = OnHitAttributes()
	
		private val sniperChargePerSec: SniperChargePerSecAttributes = SniperChargePerSecAttributes()
	
		private val ammo: AmmoAttributes = AmmoAttributes()
	
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

	override val damage: DamageAttributes get() = SniperRifleDecapAttributes.damage
	
	override val onHit: OnHitAttributes get() = SniperRifleDecapAttributes.onHit
	
	override val sniperChargePerSec: SniperChargePerSecAttributes get() = SniperRifleDecapAttributes.sniperChargePerSec
	
	override val ammo: AmmoAttributes get() = SniperRifleDecapAttributes.ammo
	
	override val firing: FiringAttributes get() = SniperRifleDecapAttributes.firing
	
	override val projectiles: ProjectilesAttributes get() = SniperRifleDecapAttributes.projectiles
	
	override val afterburn: AfterburnAttributes get() = SniperRifleDecapAttributes.afterburn
	
	override val buildings: BuildingsAttributes get() = SniperRifleDecapAttributes.buildings
	
	override val crits: CritsAttributes get() = SniperRifleDecapAttributes.crits
	
	override val demoCharge: DemoChargeAttributes get() = SniperRifleDecapAttributes.demoCharge
	
	override val healthAndHealing: HealthAndHealingAttributes get() = SniperRifleDecapAttributes.healthAndHealing
	
	override val knockbackReceived: KnockbackReceivedAttributes get() = SniperRifleDecapAttributes.knockbackReceived
	
	override val meta: MetaAttributes get() = SniperRifleDecapAttributes.meta
	
	override val meter: MeterAttributes get() = SniperRifleDecapAttributes.meter
	
	override val movement: MovementAttributes get() = SniperRifleDecapAttributes.movement
	
	override val heads: HeadsAttributes get() = SniperRifleDecapAttributes.heads
	
	override val onKill: OnKillAttributes get() = SniperRifleDecapAttributes.onKill
	
	override val reloading: ReloadingAttributes get() = SniperRifleDecapAttributes.reloading
	
	override val resistance: ResistanceAttributes get() = SniperRifleDecapAttributes.resistance
	
	override val revengeCrits: RevengeCritsAttributes get() = SniperRifleDecapAttributes.revengeCrits
	
	override val statusEffects: StatusEffectsAttributes get() = SniperRifleDecapAttributes.statusEffects
	
	override val taunting: TauntingAttributes get() = SniperRifleDecapAttributes.taunting
	
	override val swapWeapons: SwapWeaponsAttributes get() = SniperRifleDecapAttributes.swapWeapons
	
	override val whenHit: WhenHitAttributes get() = SniperRifleDecapAttributes.whenHit
	
	override val ragdolls: RagdollsAttributes get() = SniperRifleDecapAttributes.ragdolls
	
	override val buffItems: BuffItemsAttributes get() = SniperRifleDecapAttributes.buffItems
	
	override val cloak: CloakAttributes get() = SniperRifleDecapAttributes.cloak
	
	override val disguise: DisguiseAttributes get() = SniperRifleDecapAttributes.disguise
	
	override val hud: HudAttributes get() = SniperRifleDecapAttributes.hud
	
	override val spyOnly: SpyOnlyAttributes get() = SniperRifleDecapAttributes.spyOnly

	open class DamageAttributes : SniperRifleAttributes.DamageAttributes() {
		override val alien: AlienAttributes = AlienAttributes()
	
		open class AlienAttributes : SniperRifleAttributes.DamageAttributes.AlienAttributes() 
	}
	
	open class OnHitAttributes : SniperRifleAttributes.OnHitAttributes() {
		override val healOnHitForRapidfire: HealOnHitForRapidfireAttributes = HealOnHitForRapidfireAttributes()
	
		override val generateRageOnDamage: GenerateRageOnDamageAttributes = GenerateRageOnDamageAttributes()
	
		override val falling: FallingAttributes = FallingAttributes()
	
		open class HealOnHitForRapidfireAttributes : SniperRifleAttributes.OnHitAttributes.HealOnHitForRapidfireAttributes() 
	
		open class GenerateRageOnDamageAttributes : SniperRifleAttributes.OnHitAttributes.GenerateRageOnDamageAttributes() 
	
		open class FallingAttributes : SniperRifleAttributes.OnHitAttributes.FallingAttributes() 
	}
	
	open class SniperChargePerSecAttributes : SniperRifleAttributes.SniperChargePerSecAttributes() 
	
	open class AmmoAttributes : SniperRifleAttributes.AmmoAttributes() {
		override val clipSize: ClipSizeAttributes = ClipSizeAttributes()
	
		override val maxAmmo: MaxAmmoAttributes = MaxAmmoAttributes()
	
		open class ClipSizeAttributes : SniperRifleAttributes.AmmoAttributes.ClipSizeAttributes() 
	
		open class MaxAmmoAttributes : SniperRifleAttributes.AmmoAttributes.MaxAmmoAttributes() 
	}
	
	open class FiringAttributes : SniperRifleAttributes.FiringAttributes() {
		override val fireRate: FireRateAttributes = FireRateAttributes()
	
		open class FireRateAttributes : SniperRifleAttributes.FiringAttributes.FireRateAttributes() 
	}
	
	open class ProjectilesAttributes : SniperRifleAttributes.ProjectilesAttributes() {
		override val bullets: BulletsAttributes = BulletsAttributes()
	
		override val projectilePenetration: ProjectilePenetrationAttributes = ProjectilePenetrationAttributes()
	
		open class BulletsAttributes : SniperRifleAttributes.ProjectilesAttributes.BulletsAttributes() 
	
		open class ProjectilePenetrationAttributes : SniperRifleAttributes.ProjectilesAttributes.ProjectilePenetrationAttributes() 
	}
	
	open class AfterburnAttributes : SniperRifleAttributes.AfterburnAttributes() 
	
	open class BuildingsAttributes : SniperRifleAttributes.BuildingsAttributes() {
		override val sentryGun: SentryGunAttributes = SentryGunAttributes()
	
		override val dispenser: DispenserAttributes = DispenserAttributes()
	
		override val teleporter: TeleporterAttributes = TeleporterAttributes()
	
		open class SentryGunAttributes : SniperRifleAttributes.BuildingsAttributes.SentryGunAttributes() 
	
		open class DispenserAttributes : SniperRifleAttributes.BuildingsAttributes.DispenserAttributes() 
	
		open class TeleporterAttributes : SniperRifleAttributes.BuildingsAttributes.TeleporterAttributes() 
	}
	
	open class CritsAttributes : SniperRifleAttributes.CritsAttributes() 
	
	open class DemoChargeAttributes : SniperRifleAttributes.DemoChargeAttributes() {
		override val multChargeTurnControl: MultChargeTurnControlAttributes = MultChargeTurnControlAttributes()
	
		open class MultChargeTurnControlAttributes : SniperRifleAttributes.DemoChargeAttributes.MultChargeTurnControlAttributes() 
	}
	
	open class HealthAndHealingAttributes : SniperRifleAttributes.HealthAndHealingAttributes() {
		override val healthRegen: HealthRegenAttributes = HealthRegenAttributes()
	
		override val maxHealthAdditive: MaxHealthAdditiveAttributes = MaxHealthAdditiveAttributes()
	
		open class HealthRegenAttributes : SniperRifleAttributes.HealthAndHealingAttributes.HealthRegenAttributes() 
	
		open class MaxHealthAdditiveAttributes : SniperRifleAttributes.HealthAndHealingAttributes.MaxHealthAdditiveAttributes() 
	}
	
	open class KnockbackReceivedAttributes : SniperRifleAttributes.KnockbackReceivedAttributes() {
		override val damageForceReduction: DamageForceReductionAttributes = DamageForceReductionAttributes()
	
		open class DamageForceReductionAttributes : SniperRifleAttributes.KnockbackReceivedAttributes.DamageForceReductionAttributes() 
	}
	
	open class MetaAttributes : SniperRifleAttributes.MetaAttributes() {
		override val killfeed: KillfeedAttributes = KillfeedAttributes()
	
		override val viewmodel: ViewmodelAttributes = ViewmodelAttributes()
	
		override val items: ItemsAttributes = ItemsAttributes()
	
		override val particles: ParticlesAttributes = ParticlesAttributes()
	
		override val noisemakers: NoisemakersAttributes = NoisemakersAttributes()
	
		override val player: PlayerAttributes = PlayerAttributes()
	
		override val gameplay: GameplayAttributes = GameplayAttributes()
	
		open class KillfeedAttributes : SniperRifleAttributes.MetaAttributes.KillfeedAttributes() 
	
		open class ViewmodelAttributes : SniperRifleAttributes.MetaAttributes.ViewmodelAttributes() 
	
		open class ItemsAttributes : SniperRifleAttributes.MetaAttributes.ItemsAttributes() 
	
		open class ParticlesAttributes : SniperRifleAttributes.MetaAttributes.ParticlesAttributes() 
	
		open class NoisemakersAttributes : SniperRifleAttributes.MetaAttributes.NoisemakersAttributes() 
	
		open class PlayerAttributes : SniperRifleAttributes.MetaAttributes.PlayerAttributes() 
	
		open class GameplayAttributes : SniperRifleAttributes.MetaAttributes.GameplayAttributes() 
	}
	
	open class MeterAttributes : SniperRifleAttributes.MeterAttributes() {
		override val generateRageOnDamage: GenerateRageOnDamageAttributes = GenerateRageOnDamageAttributes()
	
		open class GenerateRageOnDamageAttributes : SniperRifleAttributes.MeterAttributes.GenerateRageOnDamageAttributes() 
	}
	
	open class MovementAttributes : SniperRifleAttributes.MovementAttributes() {
		override val moveSpeed: MoveSpeedAttributes = MoveSpeedAttributes()
	
		override val jumpHeight: jumpHeightAttributes = jumpHeightAttributes()
	
		open class MoveSpeedAttributes : SniperRifleAttributes.MovementAttributes.MoveSpeedAttributes() {
			override val aimingMovespeed: AimingMovespeedAttributes = AimingMovespeedAttributes()
	
			override val moveSpeed: MoveSpeedAttributes = MoveSpeedAttributes()
	
			open class AimingMovespeedAttributes : SniperRifleAttributes.MovementAttributes.MoveSpeedAttributes.AimingMovespeedAttributes() 
	
			open class MoveSpeedAttributes : SniperRifleAttributes.MovementAttributes.MoveSpeedAttributes.MoveSpeedAttributes() 
		}
	
		open class jumpHeightAttributes : SniperRifleAttributes.MovementAttributes.jumpHeightAttributes() 
	}
	
	open class HeadsAttributes : SniperRifleAttributes.HeadsAttributes() 
	
	open class OnKillAttributes : SniperRifleAttributes.OnKillAttributes() 
	
	open class ReloadingAttributes : SniperRifleAttributes.ReloadingAttributes() 
	
	open class ResistanceAttributes : SniperRifleAttributes.ResistanceAttributes() {
		override val dmgTakenFromCritReduced: DmgTakenFromCritReducedAttributes = DmgTakenFromCritReducedAttributes()
	
		override val dmgTakenFromFireReduced: DmgTakenFromFireReducedAttributes = DmgTakenFromFireReducedAttributes()
	
		override val dmgTakenFromBulletsReduced: DmgTakenFromBulletsReducedAttributes = DmgTakenFromBulletsReducedAttributes()
	
		override val vaccinator: VaccinatorAttributes = VaccinatorAttributes()
	
		open class DmgTakenFromCritReducedAttributes : SniperRifleAttributes.ResistanceAttributes.DmgTakenFromCritReducedAttributes() 
	
		open class DmgTakenFromFireReducedAttributes : SniperRifleAttributes.ResistanceAttributes.DmgTakenFromFireReducedAttributes() 
	
		open class DmgTakenFromBulletsReducedAttributes : SniperRifleAttributes.ResistanceAttributes.DmgTakenFromBulletsReducedAttributes() 
	
		open class VaccinatorAttributes : SniperRifleAttributes.ResistanceAttributes.VaccinatorAttributes() 
	}
	
	open class RevengeCritsAttributes : SniperRifleAttributes.RevengeCritsAttributes() 
	
	open class StatusEffectsAttributes : SniperRifleAttributes.StatusEffectsAttributes() 
	
	open class TauntingAttributes : SniperRifleAttributes.TauntingAttributes() 
	
	open class SwapWeaponsAttributes : SniperRifleAttributes.SwapWeaponsAttributes() {
		override val deploy: DeployAttributes = DeployAttributes()
	
		open class DeployAttributes : SniperRifleAttributes.SwapWeaponsAttributes.DeployAttributes() 
	}
	
	open class WhenHitAttributes : SniperRifleAttributes.WhenHitAttributes() 
	
	open class RagdollsAttributes : SniperRifleAttributes.RagdollsAttributes() 
	
	open class BuffItemsAttributes : SniperRifleAttributes.BuffItemsAttributes() 
	
	open class CloakAttributes : SniperRifleAttributes.CloakAttributes() 
	
	open class DisguiseAttributes : SniperRifleAttributes.DisguiseAttributes() 
	
	open class HudAttributes : SniperRifleAttributes.HudAttributes() 
	
	open class SpyOnlyAttributes : SniperRifleAttributes.SpyOnlyAttributes() 
	
	object Inherited : SniperRifleDecapAttributes 
}