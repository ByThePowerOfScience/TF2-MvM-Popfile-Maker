package btpos.source.vdfdsl.tf2.itemattributes

import btpos.source.vdfdsl.modeling.*
import btpos.source.vdfdsl.serialization.codecs.*
import btpos.source.vdfdsl.tf2.itemattributes.impl.*
import btpos.source.vdfdsl.tf2.tftypes.*
import java.util.*
import kotlin.time.Duration

interface CompoundBowAttributes : IBlockScoped, StickybombLauncherAttributes {
	companion object : IBlockScoped {
		/**
		 * In-Game: "+N% faster reload time"
		 * 
		 * Mult applied to reload speed.
		 */
		val fasterReloadRate: ItemAttributeNamed<Number> = ItemAttributeNamed("faster reload rate")
	
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

	/**
	 * In-Game: "+N% faster reload time"
	 * 
	 * Mult applied to reload speed.
	 */
	val fasterReloadRate: ItemAttributeNamed<Number> get() = CompoundBowAttributes.fasterReloadRate
	
	override val ammo: AmmoAttributes get() = CompoundBowAttributes.ammo
	
	override val damage: DamageAttributes get() = CompoundBowAttributes.damage
	
	override val firing: FiringAttributes get() = CompoundBowAttributes.firing
	
	override val projectiles: ProjectilesAttributes get() = CompoundBowAttributes.projectiles
	
	override val afterburn: AfterburnAttributes get() = CompoundBowAttributes.afterburn
	
	override val buildings: BuildingsAttributes get() = CompoundBowAttributes.buildings
	
	override val crits: CritsAttributes get() = CompoundBowAttributes.crits
	
	override val demoCharge: DemoChargeAttributes get() = CompoundBowAttributes.demoCharge
	
	override val healthAndHealing: HealthAndHealingAttributes get() = CompoundBowAttributes.healthAndHealing
	
	override val knockbackReceived: KnockbackReceivedAttributes get() = CompoundBowAttributes.knockbackReceived
	
	override val meta: MetaAttributes get() = CompoundBowAttributes.meta
	
	override val meter: MeterAttributes get() = CompoundBowAttributes.meter
	
	override val movement: MovementAttributes get() = CompoundBowAttributes.movement
	
	override val heads: HeadsAttributes get() = CompoundBowAttributes.heads
	
	override val onHit: OnHitAttributes get() = CompoundBowAttributes.onHit
	
	override val onKill: OnKillAttributes get() = CompoundBowAttributes.onKill
	
	override val reloading: ReloadingAttributes get() = CompoundBowAttributes.reloading
	
	override val resistance: ResistanceAttributes get() = CompoundBowAttributes.resistance
	
	override val revengeCrits: RevengeCritsAttributes get() = CompoundBowAttributes.revengeCrits
	
	override val statusEffects: StatusEffectsAttributes get() = CompoundBowAttributes.statusEffects
	
	override val taunting: TauntingAttributes get() = CompoundBowAttributes.taunting
	
	override val swapWeapons: SwapWeaponsAttributes get() = CompoundBowAttributes.swapWeapons
	
	override val whenHit: WhenHitAttributes get() = CompoundBowAttributes.whenHit
	
	override val ragdolls: RagdollsAttributes get() = CompoundBowAttributes.ragdolls
	
	override val buffItems: BuffItemsAttributes get() = CompoundBowAttributes.buffItems
	
	override val cloak: CloakAttributes get() = CompoundBowAttributes.cloak
	
	override val disguise: DisguiseAttributes get() = CompoundBowAttributes.disguise
	
	override val hud: HudAttributes get() = CompoundBowAttributes.hud
	
	override val spyOnly: SpyOnlyAttributes get() = CompoundBowAttributes.spyOnly

	open class AmmoAttributes : StickybombLauncherAttributes.AmmoAttributes() {
		override val clipSize: ClipSizeAttributes = ClipSizeAttributes()
	
		override val maxAmmo: MaxAmmoAttributes = MaxAmmoAttributes()
	
		open class ClipSizeAttributes : StickybombLauncherAttributes.AmmoAttributes.ClipSizeAttributes() 
	
		open class MaxAmmoAttributes : StickybombLauncherAttributes.AmmoAttributes.MaxAmmoAttributes() 
	}
	
	open class DamageAttributes : StickybombLauncherAttributes.DamageAttributes() {
		override val alien: AlienAttributes = AlienAttributes()
	
		open class AlienAttributes : StickybombLauncherAttributes.DamageAttributes.AlienAttributes() 
	}
	
	open class FiringAttributes : StickybombLauncherAttributes.FiringAttributes() {
		override val fireRate: FireRateAttributes = FireRateAttributes()
	
		open class FireRateAttributes : StickybombLauncherAttributes.FiringAttributes.FireRateAttributes() 
	}
	
	open class ProjectilesAttributes : StickybombLauncherAttributes.ProjectilesAttributes() {
		override val bullets: BulletsAttributes = BulletsAttributes()
	
		override val projectilePenetration: ProjectilePenetrationAttributes = ProjectilePenetrationAttributes()
	
		open class BulletsAttributes : StickybombLauncherAttributes.ProjectilesAttributes.BulletsAttributes() 
	
		open class ProjectilePenetrationAttributes : StickybombLauncherAttributes.ProjectilesAttributes.ProjectilePenetrationAttributes() 
	}
	
	open class AfterburnAttributes : StickybombLauncherAttributes.AfterburnAttributes() 
	
	open class BuildingsAttributes : StickybombLauncherAttributes.BuildingsAttributes() {
		override val sentryGun: SentryGunAttributes = SentryGunAttributes()
	
		override val dispenser: DispenserAttributes = DispenserAttributes()
	
		override val teleporter: TeleporterAttributes = TeleporterAttributes()
	
		open class SentryGunAttributes : StickybombLauncherAttributes.BuildingsAttributes.SentryGunAttributes() 
	
		open class DispenserAttributes : StickybombLauncherAttributes.BuildingsAttributes.DispenserAttributes() 
	
		open class TeleporterAttributes : StickybombLauncherAttributes.BuildingsAttributes.TeleporterAttributes() 
	}
	
	open class CritsAttributes : StickybombLauncherAttributes.CritsAttributes() 
	
	open class DemoChargeAttributes : StickybombLauncherAttributes.DemoChargeAttributes() {
		override val multChargeTurnControl: MultChargeTurnControlAttributes = MultChargeTurnControlAttributes()
	
		open class MultChargeTurnControlAttributes : StickybombLauncherAttributes.DemoChargeAttributes.MultChargeTurnControlAttributes() 
	}
	
	open class HealthAndHealingAttributes : StickybombLauncherAttributes.HealthAndHealingAttributes() {
		override val healthRegen: HealthRegenAttributes = HealthRegenAttributes()
	
		override val maxHealthAdditive: MaxHealthAdditiveAttributes = MaxHealthAdditiveAttributes()
	
		open class HealthRegenAttributes : StickybombLauncherAttributes.HealthAndHealingAttributes.HealthRegenAttributes() 
	
		open class MaxHealthAdditiveAttributes : StickybombLauncherAttributes.HealthAndHealingAttributes.MaxHealthAdditiveAttributes() 
	}
	
	open class KnockbackReceivedAttributes : StickybombLauncherAttributes.KnockbackReceivedAttributes() {
		override val damageForceReduction: DamageForceReductionAttributes = DamageForceReductionAttributes()
	
		open class DamageForceReductionAttributes : StickybombLauncherAttributes.KnockbackReceivedAttributes.DamageForceReductionAttributes() 
	}
	
	open class MetaAttributes : StickybombLauncherAttributes.MetaAttributes() {
		override val killfeed: KillfeedAttributes = KillfeedAttributes()
	
		override val viewmodel: ViewmodelAttributes = ViewmodelAttributes()
	
		override val items: ItemsAttributes = ItemsAttributes()
	
		override val particles: ParticlesAttributes = ParticlesAttributes()
	
		override val noisemakers: NoisemakersAttributes = NoisemakersAttributes()
	
		override val player: PlayerAttributes = PlayerAttributes()
	
		override val gameplay: GameplayAttributes = GameplayAttributes()
	
		open class KillfeedAttributes : StickybombLauncherAttributes.MetaAttributes.KillfeedAttributes() 
	
		open class ViewmodelAttributes : StickybombLauncherAttributes.MetaAttributes.ViewmodelAttributes() 
	
		open class ItemsAttributes : StickybombLauncherAttributes.MetaAttributes.ItemsAttributes() 
	
		open class ParticlesAttributes : StickybombLauncherAttributes.MetaAttributes.ParticlesAttributes() 
	
		open class NoisemakersAttributes : StickybombLauncherAttributes.MetaAttributes.NoisemakersAttributes() 
	
		open class PlayerAttributes : StickybombLauncherAttributes.MetaAttributes.PlayerAttributes() 
	
		open class GameplayAttributes : StickybombLauncherAttributes.MetaAttributes.GameplayAttributes() 
	}
	
	open class MeterAttributes : StickybombLauncherAttributes.MeterAttributes() {
		override val generateRageOnDamage: GenerateRageOnDamageAttributes = GenerateRageOnDamageAttributes()
	
		open class GenerateRageOnDamageAttributes : StickybombLauncherAttributes.MeterAttributes.GenerateRageOnDamageAttributes() 
	}
	
	open class MovementAttributes : StickybombLauncherAttributes.MovementAttributes() {
		override val moveSpeed: MoveSpeedAttributes = MoveSpeedAttributes()
	
		override val jumpHeight: jumpHeightAttributes = jumpHeightAttributes()
	
		open class MoveSpeedAttributes : StickybombLauncherAttributes.MovementAttributes.MoveSpeedAttributes() {
			override val aimingMovespeed: AimingMovespeedAttributes = AimingMovespeedAttributes()
	
			override val moveSpeed: MoveSpeedAttributes = MoveSpeedAttributes()
	
			open class AimingMovespeedAttributes : StickybombLauncherAttributes.MovementAttributes.MoveSpeedAttributes.AimingMovespeedAttributes() 
	
			open class MoveSpeedAttributes : StickybombLauncherAttributes.MovementAttributes.MoveSpeedAttributes.MoveSpeedAttributes() 
		}
	
		open class jumpHeightAttributes : StickybombLauncherAttributes.MovementAttributes.jumpHeightAttributes() 
	}
	
	open class HeadsAttributes : StickybombLauncherAttributes.HeadsAttributes() 
	
	open class OnHitAttributes : StickybombLauncherAttributes.OnHitAttributes() {
		override val healOnHitForRapidfire: HealOnHitForRapidfireAttributes = HealOnHitForRapidfireAttributes()
	
		override val generateRageOnDamage: GenerateRageOnDamageAttributes = GenerateRageOnDamageAttributes()
	
		override val falling: FallingAttributes = FallingAttributes()
	
		open class HealOnHitForRapidfireAttributes : StickybombLauncherAttributes.OnHitAttributes.HealOnHitForRapidfireAttributes() 
	
		open class GenerateRageOnDamageAttributes : StickybombLauncherAttributes.OnHitAttributes.GenerateRageOnDamageAttributes() 
	
		open class FallingAttributes : StickybombLauncherAttributes.OnHitAttributes.FallingAttributes() 
	}
	
	open class OnKillAttributes : StickybombLauncherAttributes.OnKillAttributes() 
	
	open class ReloadingAttributes : StickybombLauncherAttributes.ReloadingAttributes() 
	
	open class ResistanceAttributes : StickybombLauncherAttributes.ResistanceAttributes() {
		override val dmgTakenFromCritReduced: DmgTakenFromCritReducedAttributes = DmgTakenFromCritReducedAttributes()
	
		override val dmgTakenFromFireReduced: DmgTakenFromFireReducedAttributes = DmgTakenFromFireReducedAttributes()
	
		override val dmgTakenFromBulletsReduced: DmgTakenFromBulletsReducedAttributes = DmgTakenFromBulletsReducedAttributes()
	
		override val vaccinator: VaccinatorAttributes = VaccinatorAttributes()
	
		open class DmgTakenFromCritReducedAttributes : StickybombLauncherAttributes.ResistanceAttributes.DmgTakenFromCritReducedAttributes() 
	
		open class DmgTakenFromFireReducedAttributes : StickybombLauncherAttributes.ResistanceAttributes.DmgTakenFromFireReducedAttributes() 
	
		open class DmgTakenFromBulletsReducedAttributes : StickybombLauncherAttributes.ResistanceAttributes.DmgTakenFromBulletsReducedAttributes() 
	
		open class VaccinatorAttributes : StickybombLauncherAttributes.ResistanceAttributes.VaccinatorAttributes() 
	}
	
	open class RevengeCritsAttributes : StickybombLauncherAttributes.RevengeCritsAttributes() 
	
	open class StatusEffectsAttributes : StickybombLauncherAttributes.StatusEffectsAttributes() 
	
	open class TauntingAttributes : StickybombLauncherAttributes.TauntingAttributes() 
	
	open class SwapWeaponsAttributes : StickybombLauncherAttributes.SwapWeaponsAttributes() {
		override val deploy: DeployAttributes = DeployAttributes()
	
		open class DeployAttributes : StickybombLauncherAttributes.SwapWeaponsAttributes.DeployAttributes() 
	}
	
	open class WhenHitAttributes : StickybombLauncherAttributes.WhenHitAttributes() 
	
	open class RagdollsAttributes : StickybombLauncherAttributes.RagdollsAttributes() 
	
	open class BuffItemsAttributes : StickybombLauncherAttributes.BuffItemsAttributes() 
	
	open class CloakAttributes : StickybombLauncherAttributes.CloakAttributes() 
	
	open class DisguiseAttributes : StickybombLauncherAttributes.DisguiseAttributes() 
	
	open class HudAttributes : StickybombLauncherAttributes.HudAttributes() 
	
	open class SpyOnlyAttributes : StickybombLauncherAttributes.SpyOnlyAttributes() 
	
	object Inherited : CompoundBowAttributes 
}