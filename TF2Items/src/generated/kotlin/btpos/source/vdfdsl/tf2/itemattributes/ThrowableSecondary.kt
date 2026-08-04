package btpos.source.vdfdsl.tf2.itemattributes

import btpos.source.vdfdsl.modeling.*
import btpos.source.vdfdsl.serialization.codecs.*
import btpos.source.vdfdsl.tf2.itemattributes.impl.*
import btpos.source.vdfdsl.tf2.tftypes.*
import java.util.*
import kotlin.time.Duration

interface ThrowableSecondaryAttributes : IBlockScoped, ThrowableAttributes {
	companion object : IBlockScoped {
		private val projectiles: ProjectilesAttributes = ProjectilesAttributes()
	
		private val meter: MeterAttributes = MeterAttributes()
	
		private val onHit: OnHitAttributes = OnHitAttributes()
	
		private val ammo: AmmoAttributes = AmmoAttributes()
	
		private val damage: DamageAttributes = DamageAttributes()
	
		private val firing: FiringAttributes = FiringAttributes()
	
		private val afterburn: AfterburnAttributes = AfterburnAttributes()
	
		private val buildings: BuildingsAttributes = BuildingsAttributes()
	
		private val crits: CritsAttributes = CritsAttributes()
	
		private val demoCharge: DemoChargeAttributes = DemoChargeAttributes()
	
		private val healthAndHealing: HealthAndHealingAttributes = HealthAndHealingAttributes()
	
		private val knockbackReceived: KnockbackReceivedAttributes = KnockbackReceivedAttributes()
	
		private val meta: MetaAttributes = MetaAttributes()
	
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

	override val projectiles: ProjectilesAttributes get() = ThrowableSecondaryAttributes.projectiles
	
	override val meter: MeterAttributes get() = ThrowableSecondaryAttributes.meter
	
	override val onHit: OnHitAttributes get() = ThrowableSecondaryAttributes.onHit
	
	override val ammo: AmmoAttributes get() = ThrowableSecondaryAttributes.ammo
	
	override val damage: DamageAttributes get() = ThrowableSecondaryAttributes.damage
	
	override val firing: FiringAttributes get() = ThrowableSecondaryAttributes.firing
	
	override val afterburn: AfterburnAttributes get() = ThrowableSecondaryAttributes.afterburn
	
	override val buildings: BuildingsAttributes get() = ThrowableSecondaryAttributes.buildings
	
	override val crits: CritsAttributes get() = ThrowableSecondaryAttributes.crits
	
	override val demoCharge: DemoChargeAttributes get() = ThrowableSecondaryAttributes.demoCharge
	
	override val healthAndHealing: HealthAndHealingAttributes get() = ThrowableSecondaryAttributes.healthAndHealing
	
	override val knockbackReceived: KnockbackReceivedAttributes get() = ThrowableSecondaryAttributes.knockbackReceived
	
	override val meta: MetaAttributes get() = ThrowableSecondaryAttributes.meta
	
	override val movement: MovementAttributes get() = ThrowableSecondaryAttributes.movement
	
	override val heads: HeadsAttributes get() = ThrowableSecondaryAttributes.heads
	
	override val onKill: OnKillAttributes get() = ThrowableSecondaryAttributes.onKill
	
	override val reloading: ReloadingAttributes get() = ThrowableSecondaryAttributes.reloading
	
	override val resistance: ResistanceAttributes get() = ThrowableSecondaryAttributes.resistance
	
	override val revengeCrits: RevengeCritsAttributes get() = ThrowableSecondaryAttributes.revengeCrits
	
	override val statusEffects: StatusEffectsAttributes get() = ThrowableSecondaryAttributes.statusEffects
	
	override val taunting: TauntingAttributes get() = ThrowableSecondaryAttributes.taunting
	
	override val swapWeapons: SwapWeaponsAttributes get() = ThrowableSecondaryAttributes.swapWeapons
	
	override val whenHit: WhenHitAttributes get() = ThrowableSecondaryAttributes.whenHit
	
	override val ragdolls: RagdollsAttributes get() = ThrowableSecondaryAttributes.ragdolls
	
	override val buffItems: BuffItemsAttributes get() = ThrowableSecondaryAttributes.buffItems
	
	override val cloak: CloakAttributes get() = ThrowableSecondaryAttributes.cloak
	
	override val disguise: DisguiseAttributes get() = ThrowableSecondaryAttributes.disguise
	
	override val hud: HudAttributes get() = ThrowableSecondaryAttributes.hud
	
	override val spyOnly: SpyOnlyAttributes get() = ThrowableSecondaryAttributes.spyOnly

	open class ProjectilesAttributes : ThrowableAttributes.ProjectilesAttributes() {
		override val bullets: BulletsAttributes = BulletsAttributes()
	
		override val projectilePenetration: ProjectilePenetrationAttributes = ProjectilePenetrationAttributes()
	
		open class BulletsAttributes : ThrowableAttributes.ProjectilesAttributes.BulletsAttributes() 
	
		open class ProjectilePenetrationAttributes : ThrowableAttributes.ProjectilesAttributes.ProjectilePenetrationAttributes() 
	}
	
	open class MeterAttributes : ThrowableAttributes.MeterAttributes() {
		override val generateRageOnDamage: GenerateRageOnDamageAttributes = GenerateRageOnDamageAttributes()
	
		open class GenerateRageOnDamageAttributes : ThrowableAttributes.MeterAttributes.GenerateRageOnDamageAttributes() 
	}
	
	open class OnHitAttributes : ThrowableAttributes.OnHitAttributes() {
		override val healOnHitForRapidfire: HealOnHitForRapidfireAttributes = HealOnHitForRapidfireAttributes()
	
		override val generateRageOnDamage: GenerateRageOnDamageAttributes = GenerateRageOnDamageAttributes()
	
		override val falling: FallingAttributes = FallingAttributes()
	
		open class HealOnHitForRapidfireAttributes : ThrowableAttributes.OnHitAttributes.HealOnHitForRapidfireAttributes() 
	
		open class GenerateRageOnDamageAttributes : ThrowableAttributes.OnHitAttributes.GenerateRageOnDamageAttributes() 
	
		open class FallingAttributes : ThrowableAttributes.OnHitAttributes.FallingAttributes() 
	}
	
	open class AmmoAttributes : ThrowableAttributes.AmmoAttributes() {
		override val clipSize: ClipSizeAttributes = ClipSizeAttributes()
	
		override val maxAmmo: MaxAmmoAttributes = MaxAmmoAttributes()
	
		open class ClipSizeAttributes : ThrowableAttributes.AmmoAttributes.ClipSizeAttributes() 
	
		open class MaxAmmoAttributes : ThrowableAttributes.AmmoAttributes.MaxAmmoAttributes() 
	}
	
	open class DamageAttributes : ThrowableAttributes.DamageAttributes() {
		override val alien: AlienAttributes = AlienAttributes()
	
		open class AlienAttributes : ThrowableAttributes.DamageAttributes.AlienAttributes() 
	}
	
	open class FiringAttributes : ThrowableAttributes.FiringAttributes() {
		override val fireRate: FireRateAttributes = FireRateAttributes()
	
		open class FireRateAttributes : ThrowableAttributes.FiringAttributes.FireRateAttributes() 
	}
	
	open class AfterburnAttributes : ThrowableAttributes.AfterburnAttributes() 
	
	open class BuildingsAttributes : ThrowableAttributes.BuildingsAttributes() {
		override val sentryGun: SentryGunAttributes = SentryGunAttributes()
	
		override val dispenser: DispenserAttributes = DispenserAttributes()
	
		override val teleporter: TeleporterAttributes = TeleporterAttributes()
	
		open class SentryGunAttributes : ThrowableAttributes.BuildingsAttributes.SentryGunAttributes() 
	
		open class DispenserAttributes : ThrowableAttributes.BuildingsAttributes.DispenserAttributes() 
	
		open class TeleporterAttributes : ThrowableAttributes.BuildingsAttributes.TeleporterAttributes() 
	}
	
	open class CritsAttributes : ThrowableAttributes.CritsAttributes() 
	
	open class DemoChargeAttributes : ThrowableAttributes.DemoChargeAttributes() {
		override val multChargeTurnControl: MultChargeTurnControlAttributes = MultChargeTurnControlAttributes()
	
		open class MultChargeTurnControlAttributes : ThrowableAttributes.DemoChargeAttributes.MultChargeTurnControlAttributes() 
	}
	
	open class HealthAndHealingAttributes : ThrowableAttributes.HealthAndHealingAttributes() {
		override val healthRegen: HealthRegenAttributes = HealthRegenAttributes()
	
		override val maxHealthAdditive: MaxHealthAdditiveAttributes = MaxHealthAdditiveAttributes()
	
		open class HealthRegenAttributes : ThrowableAttributes.HealthAndHealingAttributes.HealthRegenAttributes() 
	
		open class MaxHealthAdditiveAttributes : ThrowableAttributes.HealthAndHealingAttributes.MaxHealthAdditiveAttributes() 
	}
	
	open class KnockbackReceivedAttributes : ThrowableAttributes.KnockbackReceivedAttributes() {
		override val damageForceReduction: DamageForceReductionAttributes = DamageForceReductionAttributes()
	
		open class DamageForceReductionAttributes : ThrowableAttributes.KnockbackReceivedAttributes.DamageForceReductionAttributes() 
	}
	
	open class MetaAttributes : ThrowableAttributes.MetaAttributes() {
		override val killfeed: KillfeedAttributes = KillfeedAttributes()
	
		override val viewmodel: ViewmodelAttributes = ViewmodelAttributes()
	
		override val items: ItemsAttributes = ItemsAttributes()
	
		override val particles: ParticlesAttributes = ParticlesAttributes()
	
		override val noisemakers: NoisemakersAttributes = NoisemakersAttributes()
	
		override val player: PlayerAttributes = PlayerAttributes()
	
		override val gameplay: GameplayAttributes = GameplayAttributes()
	
		open class KillfeedAttributes : ThrowableAttributes.MetaAttributes.KillfeedAttributes() 
	
		open class ViewmodelAttributes : ThrowableAttributes.MetaAttributes.ViewmodelAttributes() 
	
		open class ItemsAttributes : ThrowableAttributes.MetaAttributes.ItemsAttributes() 
	
		open class ParticlesAttributes : ThrowableAttributes.MetaAttributes.ParticlesAttributes() 
	
		open class NoisemakersAttributes : ThrowableAttributes.MetaAttributes.NoisemakersAttributes() 
	
		open class PlayerAttributes : ThrowableAttributes.MetaAttributes.PlayerAttributes() 
	
		open class GameplayAttributes : ThrowableAttributes.MetaAttributes.GameplayAttributes() 
	}
	
	open class MovementAttributes : ThrowableAttributes.MovementAttributes() {
		override val moveSpeed: MoveSpeedAttributes = MoveSpeedAttributes()
	
		override val jumpHeight: jumpHeightAttributes = jumpHeightAttributes()
	
		open class MoveSpeedAttributes : ThrowableAttributes.MovementAttributes.MoveSpeedAttributes() {
			override val aimingMovespeed: AimingMovespeedAttributes = AimingMovespeedAttributes()
	
			override val moveSpeed: MoveSpeedAttributes = MoveSpeedAttributes()
	
			open class AimingMovespeedAttributes : ThrowableAttributes.MovementAttributes.MoveSpeedAttributes.AimingMovespeedAttributes() 
	
			open class MoveSpeedAttributes : ThrowableAttributes.MovementAttributes.MoveSpeedAttributes.MoveSpeedAttributes() 
		}
	
		open class jumpHeightAttributes : ThrowableAttributes.MovementAttributes.jumpHeightAttributes() 
	}
	
	open class HeadsAttributes : ThrowableAttributes.HeadsAttributes() 
	
	open class OnKillAttributes : ThrowableAttributes.OnKillAttributes() 
	
	open class ReloadingAttributes : ThrowableAttributes.ReloadingAttributes() 
	
	open class ResistanceAttributes : ThrowableAttributes.ResistanceAttributes() {
		override val dmgTakenFromCritReduced: DmgTakenFromCritReducedAttributes = DmgTakenFromCritReducedAttributes()
	
		override val dmgTakenFromFireReduced: DmgTakenFromFireReducedAttributes = DmgTakenFromFireReducedAttributes()
	
		override val dmgTakenFromBulletsReduced: DmgTakenFromBulletsReducedAttributes = DmgTakenFromBulletsReducedAttributes()
	
		override val vaccinator: VaccinatorAttributes = VaccinatorAttributes()
	
		open class DmgTakenFromCritReducedAttributes : ThrowableAttributes.ResistanceAttributes.DmgTakenFromCritReducedAttributes() 
	
		open class DmgTakenFromFireReducedAttributes : ThrowableAttributes.ResistanceAttributes.DmgTakenFromFireReducedAttributes() 
	
		open class DmgTakenFromBulletsReducedAttributes : ThrowableAttributes.ResistanceAttributes.DmgTakenFromBulletsReducedAttributes() 
	
		open class VaccinatorAttributes : ThrowableAttributes.ResistanceAttributes.VaccinatorAttributes() 
	}
	
	open class RevengeCritsAttributes : ThrowableAttributes.RevengeCritsAttributes() 
	
	open class StatusEffectsAttributes : ThrowableAttributes.StatusEffectsAttributes() 
	
	open class TauntingAttributes : ThrowableAttributes.TauntingAttributes() 
	
	open class SwapWeaponsAttributes : ThrowableAttributes.SwapWeaponsAttributes() {
		override val deploy: DeployAttributes = DeployAttributes()
	
		open class DeployAttributes : ThrowableAttributes.SwapWeaponsAttributes.DeployAttributes() 
	}
	
	open class WhenHitAttributes : ThrowableAttributes.WhenHitAttributes() 
	
	open class RagdollsAttributes : ThrowableAttributes.RagdollsAttributes() 
	
	open class BuffItemsAttributes : ThrowableAttributes.BuffItemsAttributes() 
	
	open class CloakAttributes : ThrowableAttributes.CloakAttributes() 
	
	open class DisguiseAttributes : ThrowableAttributes.DisguiseAttributes() 
	
	open class HudAttributes : ThrowableAttributes.HudAttributes() 
	
	open class SpyOnlyAttributes : ThrowableAttributes.SpyOnlyAttributes() 
	
	object Inherited : ThrowableSecondaryAttributes 
}