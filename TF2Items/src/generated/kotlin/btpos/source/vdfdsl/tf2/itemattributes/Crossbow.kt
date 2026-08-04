package btpos.source.vdfdsl.tf2.itemattributes

import btpos.source.vdfdsl.modeling.*
import btpos.source.vdfdsl.serialization.codecs.*
import btpos.source.vdfdsl.tf2.itemattributes.impl.*
import btpos.source.vdfdsl.tf2.tftypes.*
import java.util.*
import kotlin.time.Duration

interface CrossbowAttributes : IBlockScoped, RocketLauncherAttributes {
	companion object : IBlockScoped {
		val reloading: ReloadingAttributes = ReloadingAttributes()
	
		private val projectiles: ProjectilesAttributes = ProjectilesAttributes()
	
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
	
		private val meter: MeterAttributes = MeterAttributes()
	
		private val movement: MovementAttributes = MovementAttributes()
	
		private val heads: HeadsAttributes = HeadsAttributes()
	
		private val onHit: OnHitAttributes = OnHitAttributes()
	
		private val onKill: OnKillAttributes = OnKillAttributes()
	
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

	override val reloading: ReloadingAttributes get() = CrossbowAttributes.reloading
	
	override val projectiles: ProjectilesAttributes get() = CrossbowAttributes.projectiles
	
	override val ammo: AmmoAttributes get() = CrossbowAttributes.ammo
	
	override val damage: DamageAttributes get() = CrossbowAttributes.damage
	
	override val firing: FiringAttributes get() = CrossbowAttributes.firing
	
	override val afterburn: AfterburnAttributes get() = CrossbowAttributes.afterburn
	
	override val buildings: BuildingsAttributes get() = CrossbowAttributes.buildings
	
	override val crits: CritsAttributes get() = CrossbowAttributes.crits
	
	override val demoCharge: DemoChargeAttributes get() = CrossbowAttributes.demoCharge
	
	override val healthAndHealing: HealthAndHealingAttributes get() = CrossbowAttributes.healthAndHealing
	
	override val knockbackReceived: KnockbackReceivedAttributes get() = CrossbowAttributes.knockbackReceived
	
	override val meta: MetaAttributes get() = CrossbowAttributes.meta
	
	override val meter: MeterAttributes get() = CrossbowAttributes.meter
	
	override val movement: MovementAttributes get() = CrossbowAttributes.movement
	
	override val heads: HeadsAttributes get() = CrossbowAttributes.heads
	
	override val onHit: OnHitAttributes get() = CrossbowAttributes.onHit
	
	override val onKill: OnKillAttributes get() = CrossbowAttributes.onKill
	
	override val resistance: ResistanceAttributes get() = CrossbowAttributes.resistance
	
	override val revengeCrits: RevengeCritsAttributes get() = CrossbowAttributes.revengeCrits
	
	override val statusEffects: StatusEffectsAttributes get() = CrossbowAttributes.statusEffects
	
	override val taunting: TauntingAttributes get() = CrossbowAttributes.taunting
	
	override val swapWeapons: SwapWeaponsAttributes get() = CrossbowAttributes.swapWeapons
	
	override val whenHit: WhenHitAttributes get() = CrossbowAttributes.whenHit
	
	override val ragdolls: RagdollsAttributes get() = CrossbowAttributes.ragdolls
	
	override val buffItems: BuffItemsAttributes get() = CrossbowAttributes.buffItems
	
	override val cloak: CloakAttributes get() = CrossbowAttributes.cloak
	
	override val disguise: DisguiseAttributes get() = CrossbowAttributes.disguise
	
	override val hud: HudAttributes get() = CrossbowAttributes.hud
	
	override val spyOnly: SpyOnlyAttributes get() = CrossbowAttributes.spyOnly

	open class ReloadingAttributes : RocketLauncherAttributes.ReloadingAttributes() {
		/**
		 * Bonus:
		 * 
		 * 	- In-Game: "N% faster reload time"
		 * 
		 * Penalty:
		 * 
		 * 	- In-Game: "N% slower reload time"
		 */
		override val reloadTime: BonusPenalty<Number> get() = super.reloadTime
	
		/**
		 * In-Game: "N% slower reload time"
		 */
		override val reloadTimeIncreasedHidden: ItemAttributeNamed<Number> get() = super.reloadTimeIncreasedHidden
	
		/**
		 * In-Game: "+N% faster reload time"
		 */
		override val fasterReloadRate: ItemAttributeNamed<Number> get() = super.fasterReloadRate
	}
	
	open class ProjectilesAttributes : RocketLauncherAttributes.ProjectilesAttributes() {
		override val bullets: BulletsAttributes = BulletsAttributes()
	
		override val projectilePenetration: ProjectilePenetrationAttributes = ProjectilePenetrationAttributes()
	
		open class BulletsAttributes : RocketLauncherAttributes.ProjectilesAttributes.BulletsAttributes() 
	
		open class ProjectilePenetrationAttributes : RocketLauncherAttributes.ProjectilesAttributes.ProjectilePenetrationAttributes() 
	}
	
	open class AmmoAttributes : RocketLauncherAttributes.AmmoAttributes() {
		override val clipSize: ClipSizeAttributes = ClipSizeAttributes()
	
		override val maxAmmo: MaxAmmoAttributes = MaxAmmoAttributes()
	
		open class ClipSizeAttributes : RocketLauncherAttributes.AmmoAttributes.ClipSizeAttributes() 
	
		open class MaxAmmoAttributes : RocketLauncherAttributes.AmmoAttributes.MaxAmmoAttributes() 
	}
	
	open class DamageAttributes : RocketLauncherAttributes.DamageAttributes() {
		override val alien: AlienAttributes = AlienAttributes()
	
		open class AlienAttributes : RocketLauncherAttributes.DamageAttributes.AlienAttributes() 
	}
	
	open class FiringAttributes : RocketLauncherAttributes.FiringAttributes() {
		override val fireRate: FireRateAttributes = FireRateAttributes()
	
		open class FireRateAttributes : RocketLauncherAttributes.FiringAttributes.FireRateAttributes() 
	}
	
	open class AfterburnAttributes : RocketLauncherAttributes.AfterburnAttributes() 
	
	open class BuildingsAttributes : RocketLauncherAttributes.BuildingsAttributes() {
		override val sentryGun: SentryGunAttributes = SentryGunAttributes()
	
		override val dispenser: DispenserAttributes = DispenserAttributes()
	
		override val teleporter: TeleporterAttributes = TeleporterAttributes()
	
		open class SentryGunAttributes : RocketLauncherAttributes.BuildingsAttributes.SentryGunAttributes() 
	
		open class DispenserAttributes : RocketLauncherAttributes.BuildingsAttributes.DispenserAttributes() 
	
		open class TeleporterAttributes : RocketLauncherAttributes.BuildingsAttributes.TeleporterAttributes() 
	}
	
	open class CritsAttributes : RocketLauncherAttributes.CritsAttributes() 
	
	open class DemoChargeAttributes : RocketLauncherAttributes.DemoChargeAttributes() {
		override val multChargeTurnControl: MultChargeTurnControlAttributes = MultChargeTurnControlAttributes()
	
		open class MultChargeTurnControlAttributes : RocketLauncherAttributes.DemoChargeAttributes.MultChargeTurnControlAttributes() 
	}
	
	open class HealthAndHealingAttributes : RocketLauncherAttributes.HealthAndHealingAttributes() {
		override val healthRegen: HealthRegenAttributes = HealthRegenAttributes()
	
		override val maxHealthAdditive: MaxHealthAdditiveAttributes = MaxHealthAdditiveAttributes()
	
		open class HealthRegenAttributes : RocketLauncherAttributes.HealthAndHealingAttributes.HealthRegenAttributes() 
	
		open class MaxHealthAdditiveAttributes : RocketLauncherAttributes.HealthAndHealingAttributes.MaxHealthAdditiveAttributes() 
	}
	
	open class KnockbackReceivedAttributes : RocketLauncherAttributes.KnockbackReceivedAttributes() {
		override val damageForceReduction: DamageForceReductionAttributes = DamageForceReductionAttributes()
	
		open class DamageForceReductionAttributes : RocketLauncherAttributes.KnockbackReceivedAttributes.DamageForceReductionAttributes() 
	}
	
	open class MetaAttributes : RocketLauncherAttributes.MetaAttributes() {
		override val killfeed: KillfeedAttributes = KillfeedAttributes()
	
		override val viewmodel: ViewmodelAttributes = ViewmodelAttributes()
	
		override val items: ItemsAttributes = ItemsAttributes()
	
		override val particles: ParticlesAttributes = ParticlesAttributes()
	
		override val noisemakers: NoisemakersAttributes = NoisemakersAttributes()
	
		override val player: PlayerAttributes = PlayerAttributes()
	
		override val gameplay: GameplayAttributes = GameplayAttributes()
	
		open class KillfeedAttributes : RocketLauncherAttributes.MetaAttributes.KillfeedAttributes() 
	
		open class ViewmodelAttributes : RocketLauncherAttributes.MetaAttributes.ViewmodelAttributes() 
	
		open class ItemsAttributes : RocketLauncherAttributes.MetaAttributes.ItemsAttributes() 
	
		open class ParticlesAttributes : RocketLauncherAttributes.MetaAttributes.ParticlesAttributes() 
	
		open class NoisemakersAttributes : RocketLauncherAttributes.MetaAttributes.NoisemakersAttributes() 
	
		open class PlayerAttributes : RocketLauncherAttributes.MetaAttributes.PlayerAttributes() 
	
		open class GameplayAttributes : RocketLauncherAttributes.MetaAttributes.GameplayAttributes() 
	}
	
	open class MeterAttributes : RocketLauncherAttributes.MeterAttributes() {
		override val generateRageOnDamage: GenerateRageOnDamageAttributes = GenerateRageOnDamageAttributes()
	
		open class GenerateRageOnDamageAttributes : RocketLauncherAttributes.MeterAttributes.GenerateRageOnDamageAttributes() 
	}
	
	open class MovementAttributes : RocketLauncherAttributes.MovementAttributes() {
		override val moveSpeed: MoveSpeedAttributes = MoveSpeedAttributes()
	
		override val jumpHeight: jumpHeightAttributes = jumpHeightAttributes()
	
		open class MoveSpeedAttributes : RocketLauncherAttributes.MovementAttributes.MoveSpeedAttributes() {
			override val aimingMovespeed: AimingMovespeedAttributes = AimingMovespeedAttributes()
	
			override val moveSpeed: MoveSpeedAttributes = MoveSpeedAttributes()
	
			open class AimingMovespeedAttributes : RocketLauncherAttributes.MovementAttributes.MoveSpeedAttributes.AimingMovespeedAttributes() 
	
			open class MoveSpeedAttributes : RocketLauncherAttributes.MovementAttributes.MoveSpeedAttributes.MoveSpeedAttributes() 
		}
	
		open class jumpHeightAttributes : RocketLauncherAttributes.MovementAttributes.jumpHeightAttributes() 
	}
	
	open class HeadsAttributes : RocketLauncherAttributes.HeadsAttributes() 
	
	open class OnHitAttributes : RocketLauncherAttributes.OnHitAttributes() {
		override val healOnHitForRapidfire: HealOnHitForRapidfireAttributes = HealOnHitForRapidfireAttributes()
	
		override val generateRageOnDamage: GenerateRageOnDamageAttributes = GenerateRageOnDamageAttributes()
	
		override val falling: FallingAttributes = FallingAttributes()
	
		open class HealOnHitForRapidfireAttributes : RocketLauncherAttributes.OnHitAttributes.HealOnHitForRapidfireAttributes() 
	
		open class GenerateRageOnDamageAttributes : RocketLauncherAttributes.OnHitAttributes.GenerateRageOnDamageAttributes() 
	
		open class FallingAttributes : RocketLauncherAttributes.OnHitAttributes.FallingAttributes() 
	}
	
	open class OnKillAttributes : RocketLauncherAttributes.OnKillAttributes() 
	
	open class ResistanceAttributes : RocketLauncherAttributes.ResistanceAttributes() {
		override val dmgTakenFromCritReduced: DmgTakenFromCritReducedAttributes = DmgTakenFromCritReducedAttributes()
	
		override val dmgTakenFromFireReduced: DmgTakenFromFireReducedAttributes = DmgTakenFromFireReducedAttributes()
	
		override val dmgTakenFromBulletsReduced: DmgTakenFromBulletsReducedAttributes = DmgTakenFromBulletsReducedAttributes()
	
		override val vaccinator: VaccinatorAttributes = VaccinatorAttributes()
	
		open class DmgTakenFromCritReducedAttributes : RocketLauncherAttributes.ResistanceAttributes.DmgTakenFromCritReducedAttributes() 
	
		open class DmgTakenFromFireReducedAttributes : RocketLauncherAttributes.ResistanceAttributes.DmgTakenFromFireReducedAttributes() 
	
		open class DmgTakenFromBulletsReducedAttributes : RocketLauncherAttributes.ResistanceAttributes.DmgTakenFromBulletsReducedAttributes() 
	
		open class VaccinatorAttributes : RocketLauncherAttributes.ResistanceAttributes.VaccinatorAttributes() 
	}
	
	open class RevengeCritsAttributes : RocketLauncherAttributes.RevengeCritsAttributes() 
	
	open class StatusEffectsAttributes : RocketLauncherAttributes.StatusEffectsAttributes() 
	
	open class TauntingAttributes : RocketLauncherAttributes.TauntingAttributes() 
	
	open class SwapWeaponsAttributes : RocketLauncherAttributes.SwapWeaponsAttributes() {
		override val deploy: DeployAttributes = DeployAttributes()
	
		open class DeployAttributes : RocketLauncherAttributes.SwapWeaponsAttributes.DeployAttributes() 
	}
	
	open class WhenHitAttributes : RocketLauncherAttributes.WhenHitAttributes() 
	
	open class RagdollsAttributes : RocketLauncherAttributes.RagdollsAttributes() 
	
	open class BuffItemsAttributes : RocketLauncherAttributes.BuffItemsAttributes() 
	
	open class CloakAttributes : RocketLauncherAttributes.CloakAttributes() 
	
	open class DisguiseAttributes : RocketLauncherAttributes.DisguiseAttributes() 
	
	open class HudAttributes : RocketLauncherAttributes.HudAttributes() 
	
	open class SpyOnlyAttributes : RocketLauncherAttributes.SpyOnlyAttributes() 
	
	object Inherited : CrossbowAttributes 
}