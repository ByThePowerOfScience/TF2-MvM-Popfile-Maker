package btpos.source.vdfdsl.tf2.itemattributes

import btpos.source.vdfdsl.modeling.*
import btpos.source.vdfdsl.serialization.codecs.*
import btpos.source.vdfdsl.tf2.itemattributes.impl.*
import btpos.source.vdfdsl.tf2.tftypes.*
import java.util.*
import kotlin.time.Duration

interface GrenadeHealAttributes : IBlockScoped, WeaponBaseGrenadeAttributes {
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

	override val afterburn: AfterburnAttributes get() = GrenadeHealAttributes.afterburn
	
	override val ammo: AmmoAttributes get() = GrenadeHealAttributes.ammo
	
	override val buildings: BuildingsAttributes get() = GrenadeHealAttributes.buildings
	
	override val crits: CritsAttributes get() = GrenadeHealAttributes.crits
	
	override val damage: DamageAttributes get() = GrenadeHealAttributes.damage
	
	override val demoCharge: DemoChargeAttributes get() = GrenadeHealAttributes.demoCharge
	
	override val firing: FiringAttributes get() = GrenadeHealAttributes.firing
	
	override val healthAndHealing: HealthAndHealingAttributes get() = GrenadeHealAttributes.healthAndHealing
	
	override val knockbackReceived: KnockbackReceivedAttributes get() = GrenadeHealAttributes.knockbackReceived
	
	override val meta: MetaAttributes get() = GrenadeHealAttributes.meta
	
	override val meter: MeterAttributes get() = GrenadeHealAttributes.meter
	
	override val movement: MovementAttributes get() = GrenadeHealAttributes.movement
	
	override val heads: HeadsAttributes get() = GrenadeHealAttributes.heads
	
	override val onHit: OnHitAttributes get() = GrenadeHealAttributes.onHit
	
	override val onKill: OnKillAttributes get() = GrenadeHealAttributes.onKill
	
	override val projectiles: ProjectilesAttributes get() = GrenadeHealAttributes.projectiles
	
	override val reloading: ReloadingAttributes get() = GrenadeHealAttributes.reloading
	
	override val resistance: ResistanceAttributes get() = GrenadeHealAttributes.resistance
	
	override val revengeCrits: RevengeCritsAttributes get() = GrenadeHealAttributes.revengeCrits
	
	override val statusEffects: StatusEffectsAttributes get() = GrenadeHealAttributes.statusEffects
	
	override val taunting: TauntingAttributes get() = GrenadeHealAttributes.taunting
	
	override val swapWeapons: SwapWeaponsAttributes get() = GrenadeHealAttributes.swapWeapons
	
	override val whenHit: WhenHitAttributes get() = GrenadeHealAttributes.whenHit
	
	override val ragdolls: RagdollsAttributes get() = GrenadeHealAttributes.ragdolls
	
	override val buffItems: BuffItemsAttributes get() = GrenadeHealAttributes.buffItems
	
	override val cloak: CloakAttributes get() = GrenadeHealAttributes.cloak
	
	override val disguise: DisguiseAttributes get() = GrenadeHealAttributes.disguise
	
	override val hud: HudAttributes get() = GrenadeHealAttributes.hud
	
	override val spyOnly: SpyOnlyAttributes get() = GrenadeHealAttributes.spyOnly

	open class AfterburnAttributes : WeaponBaseGrenadeAttributes.AfterburnAttributes() 
	
	open class AmmoAttributes : WeaponBaseGrenadeAttributes.AmmoAttributes() {
		override val clipSize: ClipSizeAttributes = ClipSizeAttributes()
	
		override val maxAmmo: MaxAmmoAttributes = MaxAmmoAttributes()
	
		open class ClipSizeAttributes : WeaponBaseGrenadeAttributes.AmmoAttributes.ClipSizeAttributes() 
	
		open class MaxAmmoAttributes : WeaponBaseGrenadeAttributes.AmmoAttributes.MaxAmmoAttributes() 
	}
	
	open class BuildingsAttributes : WeaponBaseGrenadeAttributes.BuildingsAttributes() {
		override val sentryGun: SentryGunAttributes = SentryGunAttributes()
	
		override val dispenser: DispenserAttributes = DispenserAttributes()
	
		override val teleporter: TeleporterAttributes = TeleporterAttributes()
	
		open class SentryGunAttributes : WeaponBaseGrenadeAttributes.BuildingsAttributes.SentryGunAttributes() 
	
		open class DispenserAttributes : WeaponBaseGrenadeAttributes.BuildingsAttributes.DispenserAttributes() 
	
		open class TeleporterAttributes : WeaponBaseGrenadeAttributes.BuildingsAttributes.TeleporterAttributes() 
	}
	
	open class CritsAttributes : WeaponBaseGrenadeAttributes.CritsAttributes() 
	
	open class DamageAttributes : WeaponBaseGrenadeAttributes.DamageAttributes() {
		override val alien: AlienAttributes = AlienAttributes()
	
		open class AlienAttributes : WeaponBaseGrenadeAttributes.DamageAttributes.AlienAttributes() 
	}
	
	open class DemoChargeAttributes : WeaponBaseGrenadeAttributes.DemoChargeAttributes() {
		override val multChargeTurnControl: MultChargeTurnControlAttributes = MultChargeTurnControlAttributes()
	
		open class MultChargeTurnControlAttributes : WeaponBaseGrenadeAttributes.DemoChargeAttributes.MultChargeTurnControlAttributes() 
	}
	
	open class FiringAttributes : WeaponBaseGrenadeAttributes.FiringAttributes() {
		override val fireRate: FireRateAttributes = FireRateAttributes()
	
		open class FireRateAttributes : WeaponBaseGrenadeAttributes.FiringAttributes.FireRateAttributes() 
	}
	
	open class HealthAndHealingAttributes : WeaponBaseGrenadeAttributes.HealthAndHealingAttributes() {
		override val healthRegen: HealthRegenAttributes = HealthRegenAttributes()
	
		override val maxHealthAdditive: MaxHealthAdditiveAttributes = MaxHealthAdditiveAttributes()
	
		open class HealthRegenAttributes : WeaponBaseGrenadeAttributes.HealthAndHealingAttributes.HealthRegenAttributes() 
	
		open class MaxHealthAdditiveAttributes : WeaponBaseGrenadeAttributes.HealthAndHealingAttributes.MaxHealthAdditiveAttributes() 
	}
	
	open class KnockbackReceivedAttributes : WeaponBaseGrenadeAttributes.KnockbackReceivedAttributes() {
		override val damageForceReduction: DamageForceReductionAttributes = DamageForceReductionAttributes()
	
		open class DamageForceReductionAttributes : WeaponBaseGrenadeAttributes.KnockbackReceivedAttributes.DamageForceReductionAttributes() 
	}
	
	open class MetaAttributes : WeaponBaseGrenadeAttributes.MetaAttributes() {
		override val killfeed: KillfeedAttributes = KillfeedAttributes()
	
		override val viewmodel: ViewmodelAttributes = ViewmodelAttributes()
	
		override val items: ItemsAttributes = ItemsAttributes()
	
		override val particles: ParticlesAttributes = ParticlesAttributes()
	
		override val noisemakers: NoisemakersAttributes = NoisemakersAttributes()
	
		override val player: PlayerAttributes = PlayerAttributes()
	
		override val gameplay: GameplayAttributes = GameplayAttributes()
	
		open class KillfeedAttributes : WeaponBaseGrenadeAttributes.MetaAttributes.KillfeedAttributes() 
	
		open class ViewmodelAttributes : WeaponBaseGrenadeAttributes.MetaAttributes.ViewmodelAttributes() 
	
		open class ItemsAttributes : WeaponBaseGrenadeAttributes.MetaAttributes.ItemsAttributes() 
	
		open class ParticlesAttributes : WeaponBaseGrenadeAttributes.MetaAttributes.ParticlesAttributes() 
	
		open class NoisemakersAttributes : WeaponBaseGrenadeAttributes.MetaAttributes.NoisemakersAttributes() 
	
		open class PlayerAttributes : WeaponBaseGrenadeAttributes.MetaAttributes.PlayerAttributes() 
	
		open class GameplayAttributes : WeaponBaseGrenadeAttributes.MetaAttributes.GameplayAttributes() 
	}
	
	open class MeterAttributes : WeaponBaseGrenadeAttributes.MeterAttributes() {
		override val generateRageOnDamage: GenerateRageOnDamageAttributes = GenerateRageOnDamageAttributes()
	
		open class GenerateRageOnDamageAttributes : WeaponBaseGrenadeAttributes.MeterAttributes.GenerateRageOnDamageAttributes() 
	}
	
	open class MovementAttributes : WeaponBaseGrenadeAttributes.MovementAttributes() {
		override val moveSpeed: MoveSpeedAttributes = MoveSpeedAttributes()
	
		override val jumpHeight: jumpHeightAttributes = jumpHeightAttributes()
	
		open class MoveSpeedAttributes : WeaponBaseGrenadeAttributes.MovementAttributes.MoveSpeedAttributes() {
			override val aimingMovespeed: AimingMovespeedAttributes = AimingMovespeedAttributes()
	
			override val moveSpeed: MoveSpeedAttributes = MoveSpeedAttributes()
	
			open class AimingMovespeedAttributes : WeaponBaseGrenadeAttributes.MovementAttributes.MoveSpeedAttributes.AimingMovespeedAttributes() 
	
			open class MoveSpeedAttributes : WeaponBaseGrenadeAttributes.MovementAttributes.MoveSpeedAttributes.MoveSpeedAttributes() 
		}
	
		open class jumpHeightAttributes : WeaponBaseGrenadeAttributes.MovementAttributes.jumpHeightAttributes() 
	}
	
	open class HeadsAttributes : WeaponBaseGrenadeAttributes.HeadsAttributes() 
	
	open class OnHitAttributes : WeaponBaseGrenadeAttributes.OnHitAttributes() {
		override val healOnHitForRapidfire: HealOnHitForRapidfireAttributes = HealOnHitForRapidfireAttributes()
	
		override val generateRageOnDamage: GenerateRageOnDamageAttributes = GenerateRageOnDamageAttributes()
	
		override val falling: FallingAttributes = FallingAttributes()
	
		open class HealOnHitForRapidfireAttributes : WeaponBaseGrenadeAttributes.OnHitAttributes.HealOnHitForRapidfireAttributes() 
	
		open class GenerateRageOnDamageAttributes : WeaponBaseGrenadeAttributes.OnHitAttributes.GenerateRageOnDamageAttributes() 
	
		open class FallingAttributes : WeaponBaseGrenadeAttributes.OnHitAttributes.FallingAttributes() 
	}
	
	open class OnKillAttributes : WeaponBaseGrenadeAttributes.OnKillAttributes() 
	
	open class ProjectilesAttributes : WeaponBaseGrenadeAttributes.ProjectilesAttributes() {
		override val projectilePenetration: ProjectilePenetrationAttributes = ProjectilePenetrationAttributes()
	
		override val bullets: BulletsAttributes = BulletsAttributes()
	
		open class ProjectilePenetrationAttributes : WeaponBaseGrenadeAttributes.ProjectilesAttributes.ProjectilePenetrationAttributes() 
	
		open class BulletsAttributes : WeaponBaseGrenadeAttributes.ProjectilesAttributes.BulletsAttributes() 
	}
	
	open class ReloadingAttributes : WeaponBaseGrenadeAttributes.ReloadingAttributes() 
	
	open class ResistanceAttributes : WeaponBaseGrenadeAttributes.ResistanceAttributes() {
		override val dmgTakenFromCritReduced: DmgTakenFromCritReducedAttributes = DmgTakenFromCritReducedAttributes()
	
		override val dmgTakenFromFireReduced: DmgTakenFromFireReducedAttributes = DmgTakenFromFireReducedAttributes()
	
		override val dmgTakenFromBulletsReduced: DmgTakenFromBulletsReducedAttributes = DmgTakenFromBulletsReducedAttributes()
	
		override val vaccinator: VaccinatorAttributes = VaccinatorAttributes()
	
		open class DmgTakenFromCritReducedAttributes : WeaponBaseGrenadeAttributes.ResistanceAttributes.DmgTakenFromCritReducedAttributes() 
	
		open class DmgTakenFromFireReducedAttributes : WeaponBaseGrenadeAttributes.ResistanceAttributes.DmgTakenFromFireReducedAttributes() 
	
		open class DmgTakenFromBulletsReducedAttributes : WeaponBaseGrenadeAttributes.ResistanceAttributes.DmgTakenFromBulletsReducedAttributes() 
	
		open class VaccinatorAttributes : WeaponBaseGrenadeAttributes.ResistanceAttributes.VaccinatorAttributes() 
	}
	
	open class RevengeCritsAttributes : WeaponBaseGrenadeAttributes.RevengeCritsAttributes() 
	
	open class StatusEffectsAttributes : WeaponBaseGrenadeAttributes.StatusEffectsAttributes() 
	
	open class TauntingAttributes : WeaponBaseGrenadeAttributes.TauntingAttributes() 
	
	open class SwapWeaponsAttributes : WeaponBaseGrenadeAttributes.SwapWeaponsAttributes() {
		override val deploy: DeployAttributes = DeployAttributes()
	
		open class DeployAttributes : WeaponBaseGrenadeAttributes.SwapWeaponsAttributes.DeployAttributes() 
	}
	
	open class WhenHitAttributes : WeaponBaseGrenadeAttributes.WhenHitAttributes() 
	
	open class RagdollsAttributes : WeaponBaseGrenadeAttributes.RagdollsAttributes() 
	
	open class BuffItemsAttributes : WeaponBaseGrenadeAttributes.BuffItemsAttributes() 
	
	open class CloakAttributes : WeaponBaseGrenadeAttributes.CloakAttributes() 
	
	open class DisguiseAttributes : WeaponBaseGrenadeAttributes.DisguiseAttributes() 
	
	open class HudAttributes : WeaponBaseGrenadeAttributes.HudAttributes() 
	
	open class SpyOnlyAttributes : WeaponBaseGrenadeAttributes.SpyOnlyAttributes() 
	
	object Inherited : GrenadeHealAttributes 
}