package btpos.source.vdfdsl.tf2.itemattributes

import btpos.source.vdfdsl.modeling.*
import btpos.source.vdfdsl.serialization.codecs.*
import btpos.source.vdfdsl.tf2.itemattributes.impl.*
import btpos.source.vdfdsl.tf2.tftypes.*
import java.util.*
import kotlin.time.Duration

interface CannonAttributes : IBlockScoped, GrenadeLauncherAttributes {
	companion object : IBlockScoped {
		private val projectiles: ProjectilesAttributes = ProjectilesAttributes()
	
		private val damage: DamageAttributes = DamageAttributes()
	
		private val ammo: AmmoAttributes = AmmoAttributes()
	
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

	override val projectiles: ProjectilesAttributes get() = CannonAttributes.projectiles
	
	override val damage: DamageAttributes get() = CannonAttributes.damage
	
	override val ammo: AmmoAttributes get() = CannonAttributes.ammo
	
	override val firing: FiringAttributes get() = CannonAttributes.firing
	
	override val afterburn: AfterburnAttributes get() = CannonAttributes.afterburn
	
	override val buildings: BuildingsAttributes get() = CannonAttributes.buildings
	
	override val crits: CritsAttributes get() = CannonAttributes.crits
	
	override val demoCharge: DemoChargeAttributes get() = CannonAttributes.demoCharge
	
	override val healthAndHealing: HealthAndHealingAttributes get() = CannonAttributes.healthAndHealing
	
	override val knockbackReceived: KnockbackReceivedAttributes get() = CannonAttributes.knockbackReceived
	
	override val meta: MetaAttributes get() = CannonAttributes.meta
	
	override val meter: MeterAttributes get() = CannonAttributes.meter
	
	override val movement: MovementAttributes get() = CannonAttributes.movement
	
	override val heads: HeadsAttributes get() = CannonAttributes.heads
	
	override val onHit: OnHitAttributes get() = CannonAttributes.onHit
	
	override val onKill: OnKillAttributes get() = CannonAttributes.onKill
	
	override val reloading: ReloadingAttributes get() = CannonAttributes.reloading
	
	override val resistance: ResistanceAttributes get() = CannonAttributes.resistance
	
	override val revengeCrits: RevengeCritsAttributes get() = CannonAttributes.revengeCrits
	
	override val statusEffects: StatusEffectsAttributes get() = CannonAttributes.statusEffects
	
	override val taunting: TauntingAttributes get() = CannonAttributes.taunting
	
	override val swapWeapons: SwapWeaponsAttributes get() = CannonAttributes.swapWeapons
	
	override val whenHit: WhenHitAttributes get() = CannonAttributes.whenHit
	
	override val ragdolls: RagdollsAttributes get() = CannonAttributes.ragdolls
	
	override val buffItems: BuffItemsAttributes get() = CannonAttributes.buffItems
	
	override val cloak: CloakAttributes get() = CannonAttributes.cloak
	
	override val disguise: DisguiseAttributes get() = CannonAttributes.disguise
	
	override val hud: HudAttributes get() = CannonAttributes.hud
	
	override val spyOnly: SpyOnlyAttributes get() = CannonAttributes.spyOnly

	open class ProjectilesAttributes : GrenadeLauncherAttributes.ProjectilesAttributes() {
		override val bullets: BulletsAttributes = BulletsAttributes()
	
		override val projectilePenetration: ProjectilePenetrationAttributes = ProjectilePenetrationAttributes()
	
		open class BulletsAttributes : GrenadeLauncherAttributes.ProjectilesAttributes.BulletsAttributes() 
	
		open class ProjectilePenetrationAttributes : GrenadeLauncherAttributes.ProjectilesAttributes.ProjectilePenetrationAttributes() 
	}
	
	open class DamageAttributes : GrenadeLauncherAttributes.DamageAttributes() {
		override val alien: AlienAttributes = AlienAttributes()
	
		open class AlienAttributes : GrenadeLauncherAttributes.DamageAttributes.AlienAttributes() 
	}
	
	open class AmmoAttributes : GrenadeLauncherAttributes.AmmoAttributes() {
		override val clipSize: ClipSizeAttributes = ClipSizeAttributes()
	
		override val maxAmmo: MaxAmmoAttributes = MaxAmmoAttributes()
	
		open class ClipSizeAttributes : GrenadeLauncherAttributes.AmmoAttributes.ClipSizeAttributes() 
	
		open class MaxAmmoAttributes : GrenadeLauncherAttributes.AmmoAttributes.MaxAmmoAttributes() 
	}
	
	open class FiringAttributes : GrenadeLauncherAttributes.FiringAttributes() {
		override val fireRate: FireRateAttributes = FireRateAttributes()
	
		open class FireRateAttributes : GrenadeLauncherAttributes.FiringAttributes.FireRateAttributes() 
	}
	
	open class AfterburnAttributes : GrenadeLauncherAttributes.AfterburnAttributes() 
	
	open class BuildingsAttributes : GrenadeLauncherAttributes.BuildingsAttributes() {
		override val sentryGun: SentryGunAttributes = SentryGunAttributes()
	
		override val dispenser: DispenserAttributes = DispenserAttributes()
	
		override val teleporter: TeleporterAttributes = TeleporterAttributes()
	
		open class SentryGunAttributes : GrenadeLauncherAttributes.BuildingsAttributes.SentryGunAttributes() 
	
		open class DispenserAttributes : GrenadeLauncherAttributes.BuildingsAttributes.DispenserAttributes() 
	
		open class TeleporterAttributes : GrenadeLauncherAttributes.BuildingsAttributes.TeleporterAttributes() 
	}
	
	open class CritsAttributes : GrenadeLauncherAttributes.CritsAttributes() 
	
	open class DemoChargeAttributes : GrenadeLauncherAttributes.DemoChargeAttributes() {
		override val multChargeTurnControl: MultChargeTurnControlAttributes = MultChargeTurnControlAttributes()
	
		open class MultChargeTurnControlAttributes : GrenadeLauncherAttributes.DemoChargeAttributes.MultChargeTurnControlAttributes() 
	}
	
	open class HealthAndHealingAttributes : GrenadeLauncherAttributes.HealthAndHealingAttributes() {
		override val healthRegen: HealthRegenAttributes = HealthRegenAttributes()
	
		override val maxHealthAdditive: MaxHealthAdditiveAttributes = MaxHealthAdditiveAttributes()
	
		open class HealthRegenAttributes : GrenadeLauncherAttributes.HealthAndHealingAttributes.HealthRegenAttributes() 
	
		open class MaxHealthAdditiveAttributes : GrenadeLauncherAttributes.HealthAndHealingAttributes.MaxHealthAdditiveAttributes() 
	}
	
	open class KnockbackReceivedAttributes : GrenadeLauncherAttributes.KnockbackReceivedAttributes() {
		override val damageForceReduction: DamageForceReductionAttributes = DamageForceReductionAttributes()
	
		open class DamageForceReductionAttributes : GrenadeLauncherAttributes.KnockbackReceivedAttributes.DamageForceReductionAttributes() 
	}
	
	open class MetaAttributes : GrenadeLauncherAttributes.MetaAttributes() {
		override val killfeed: KillfeedAttributes = KillfeedAttributes()
	
		override val viewmodel: ViewmodelAttributes = ViewmodelAttributes()
	
		override val items: ItemsAttributes = ItemsAttributes()
	
		override val particles: ParticlesAttributes = ParticlesAttributes()
	
		override val noisemakers: NoisemakersAttributes = NoisemakersAttributes()
	
		override val player: PlayerAttributes = PlayerAttributes()
	
		override val gameplay: GameplayAttributes = GameplayAttributes()
	
		open class KillfeedAttributes : GrenadeLauncherAttributes.MetaAttributes.KillfeedAttributes() 
	
		open class ViewmodelAttributes : GrenadeLauncherAttributes.MetaAttributes.ViewmodelAttributes() 
	
		open class ItemsAttributes : GrenadeLauncherAttributes.MetaAttributes.ItemsAttributes() 
	
		open class ParticlesAttributes : GrenadeLauncherAttributes.MetaAttributes.ParticlesAttributes() 
	
		open class NoisemakersAttributes : GrenadeLauncherAttributes.MetaAttributes.NoisemakersAttributes() 
	
		open class PlayerAttributes : GrenadeLauncherAttributes.MetaAttributes.PlayerAttributes() 
	
		open class GameplayAttributes : GrenadeLauncherAttributes.MetaAttributes.GameplayAttributes() 
	}
	
	open class MeterAttributes : GrenadeLauncherAttributes.MeterAttributes() {
		override val generateRageOnDamage: GenerateRageOnDamageAttributes = GenerateRageOnDamageAttributes()
	
		open class GenerateRageOnDamageAttributes : GrenadeLauncherAttributes.MeterAttributes.GenerateRageOnDamageAttributes() 
	}
	
	open class MovementAttributes : GrenadeLauncherAttributes.MovementAttributes() {
		override val moveSpeed: MoveSpeedAttributes = MoveSpeedAttributes()
	
		override val jumpHeight: jumpHeightAttributes = jumpHeightAttributes()
	
		open class MoveSpeedAttributes : GrenadeLauncherAttributes.MovementAttributes.MoveSpeedAttributes() {
			override val aimingMovespeed: AimingMovespeedAttributes = AimingMovespeedAttributes()
	
			override val moveSpeed: MoveSpeedAttributes = MoveSpeedAttributes()
	
			open class AimingMovespeedAttributes : GrenadeLauncherAttributes.MovementAttributes.MoveSpeedAttributes.AimingMovespeedAttributes() 
	
			open class MoveSpeedAttributes : GrenadeLauncherAttributes.MovementAttributes.MoveSpeedAttributes.MoveSpeedAttributes() 
		}
	
		open class jumpHeightAttributes : GrenadeLauncherAttributes.MovementAttributes.jumpHeightAttributes() 
	}
	
	open class HeadsAttributes : GrenadeLauncherAttributes.HeadsAttributes() 
	
	open class OnHitAttributes : GrenadeLauncherAttributes.OnHitAttributes() {
		override val healOnHitForRapidfire: HealOnHitForRapidfireAttributes = HealOnHitForRapidfireAttributes()
	
		override val generateRageOnDamage: GenerateRageOnDamageAttributes = GenerateRageOnDamageAttributes()
	
		override val falling: FallingAttributes = FallingAttributes()
	
		open class HealOnHitForRapidfireAttributes : GrenadeLauncherAttributes.OnHitAttributes.HealOnHitForRapidfireAttributes() 
	
		open class GenerateRageOnDamageAttributes : GrenadeLauncherAttributes.OnHitAttributes.GenerateRageOnDamageAttributes() 
	
		open class FallingAttributes : GrenadeLauncherAttributes.OnHitAttributes.FallingAttributes() 
	}
	
	open class OnKillAttributes : GrenadeLauncherAttributes.OnKillAttributes() 
	
	open class ReloadingAttributes : GrenadeLauncherAttributes.ReloadingAttributes() 
	
	open class ResistanceAttributes : GrenadeLauncherAttributes.ResistanceAttributes() {
		override val dmgTakenFromCritReduced: DmgTakenFromCritReducedAttributes = DmgTakenFromCritReducedAttributes()
	
		override val dmgTakenFromFireReduced: DmgTakenFromFireReducedAttributes = DmgTakenFromFireReducedAttributes()
	
		override val dmgTakenFromBulletsReduced: DmgTakenFromBulletsReducedAttributes = DmgTakenFromBulletsReducedAttributes()
	
		override val vaccinator: VaccinatorAttributes = VaccinatorAttributes()
	
		open class DmgTakenFromCritReducedAttributes : GrenadeLauncherAttributes.ResistanceAttributes.DmgTakenFromCritReducedAttributes() 
	
		open class DmgTakenFromFireReducedAttributes : GrenadeLauncherAttributes.ResistanceAttributes.DmgTakenFromFireReducedAttributes() 
	
		open class DmgTakenFromBulletsReducedAttributes : GrenadeLauncherAttributes.ResistanceAttributes.DmgTakenFromBulletsReducedAttributes() 
	
		open class VaccinatorAttributes : GrenadeLauncherAttributes.ResistanceAttributes.VaccinatorAttributes() 
	}
	
	open class RevengeCritsAttributes : GrenadeLauncherAttributes.RevengeCritsAttributes() 
	
	open class StatusEffectsAttributes : GrenadeLauncherAttributes.StatusEffectsAttributes() 
	
	open class TauntingAttributes : GrenadeLauncherAttributes.TauntingAttributes() 
	
	open class SwapWeaponsAttributes : GrenadeLauncherAttributes.SwapWeaponsAttributes() {
		override val deploy: DeployAttributes = DeployAttributes()
	
		open class DeployAttributes : GrenadeLauncherAttributes.SwapWeaponsAttributes.DeployAttributes() 
	}
	
	open class WhenHitAttributes : GrenadeLauncherAttributes.WhenHitAttributes() 
	
	open class RagdollsAttributes : GrenadeLauncherAttributes.RagdollsAttributes() 
	
	open class BuffItemsAttributes : GrenadeLauncherAttributes.BuffItemsAttributes() 
	
	open class CloakAttributes : GrenadeLauncherAttributes.CloakAttributes() 
	
	open class DisguiseAttributes : GrenadeLauncherAttributes.DisguiseAttributes() 
	
	open class HudAttributes : GrenadeLauncherAttributes.HudAttributes() 
	
	open class SpyOnlyAttributes : GrenadeLauncherAttributes.SpyOnlyAttributes() 
	
	object Inherited : CannonAttributes 
}