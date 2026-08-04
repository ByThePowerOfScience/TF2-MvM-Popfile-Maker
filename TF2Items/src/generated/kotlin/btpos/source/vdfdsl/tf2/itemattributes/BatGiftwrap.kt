package btpos.source.vdfdsl.tf2.itemattributes

import btpos.source.vdfdsl.modeling.*
import btpos.source.vdfdsl.serialization.codecs.*
import btpos.source.vdfdsl.tf2.itemattributes.impl.*
import btpos.source.vdfdsl.tf2.tftypes.*
import java.util.*
import kotlin.time.Duration

interface BatGiftwrapAttributes : IBlockScoped, BatWoodAttributes {
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

	override val crits: CritsAttributes get() = BatGiftwrapAttributes.crits
	
	override val damage: DamageAttributes get() = BatGiftwrapAttributes.damage
	
	override val onHit: OnHitAttributes get() = BatGiftwrapAttributes.onHit
	
	override val swapWeapons: SwapWeaponsAttributes get() = BatGiftwrapAttributes.swapWeapons
	
	override val afterburn: AfterburnAttributes get() = BatGiftwrapAttributes.afterburn
	
	override val ammo: AmmoAttributes get() = BatGiftwrapAttributes.ammo
	
	override val buildings: BuildingsAttributes get() = BatGiftwrapAttributes.buildings
	
	override val demoCharge: DemoChargeAttributes get() = BatGiftwrapAttributes.demoCharge
	
	override val firing: FiringAttributes get() = BatGiftwrapAttributes.firing
	
	override val healthAndHealing: HealthAndHealingAttributes get() = BatGiftwrapAttributes.healthAndHealing
	
	override val knockbackReceived: KnockbackReceivedAttributes get() = BatGiftwrapAttributes.knockbackReceived
	
	override val meta: MetaAttributes get() = BatGiftwrapAttributes.meta
	
	override val meter: MeterAttributes get() = BatGiftwrapAttributes.meter
	
	override val movement: MovementAttributes get() = BatGiftwrapAttributes.movement
	
	override val heads: HeadsAttributes get() = BatGiftwrapAttributes.heads
	
	override val onKill: OnKillAttributes get() = BatGiftwrapAttributes.onKill
	
	override val projectiles: ProjectilesAttributes get() = BatGiftwrapAttributes.projectiles
	
	override val reloading: ReloadingAttributes get() = BatGiftwrapAttributes.reloading
	
	override val resistance: ResistanceAttributes get() = BatGiftwrapAttributes.resistance
	
	override val revengeCrits: RevengeCritsAttributes get() = BatGiftwrapAttributes.revengeCrits
	
	override val statusEffects: StatusEffectsAttributes get() = BatGiftwrapAttributes.statusEffects
	
	override val taunting: TauntingAttributes get() = BatGiftwrapAttributes.taunting
	
	override val whenHit: WhenHitAttributes get() = BatGiftwrapAttributes.whenHit
	
	override val ragdolls: RagdollsAttributes get() = BatGiftwrapAttributes.ragdolls
	
	override val buffItems: BuffItemsAttributes get() = BatGiftwrapAttributes.buffItems
	
	override val cloak: CloakAttributes get() = BatGiftwrapAttributes.cloak
	
	override val disguise: DisguiseAttributes get() = BatGiftwrapAttributes.disguise
	
	override val hud: HudAttributes get() = BatGiftwrapAttributes.hud
	
	override val spyOnly: SpyOnlyAttributes get() = BatGiftwrapAttributes.spyOnly

	open class CritsAttributes : BatWoodAttributes.CritsAttributes() 
	
	open class DamageAttributes : BatWoodAttributes.DamageAttributes() {
		override val alien: AlienAttributes = AlienAttributes()
	
		open class AlienAttributes : BatWoodAttributes.DamageAttributes.AlienAttributes() 
	}
	
	open class OnHitAttributes : BatWoodAttributes.OnHitAttributes() {
		override val healOnHitForRapidfire: HealOnHitForRapidfireAttributes = HealOnHitForRapidfireAttributes()
	
		override val generateRageOnDamage: GenerateRageOnDamageAttributes = GenerateRageOnDamageAttributes()
	
		override val falling: FallingAttributes = FallingAttributes()
	
		open class HealOnHitForRapidfireAttributes : BatWoodAttributes.OnHitAttributes.HealOnHitForRapidfireAttributes() 
	
		open class GenerateRageOnDamageAttributes : BatWoodAttributes.OnHitAttributes.GenerateRageOnDamageAttributes() 
	
		open class FallingAttributes : BatWoodAttributes.OnHitAttributes.FallingAttributes() 
	}
	
	open class SwapWeaponsAttributes : BatWoodAttributes.SwapWeaponsAttributes() {
		override val deploy: DeployAttributes = DeployAttributes()
	
		open class DeployAttributes : BatWoodAttributes.SwapWeaponsAttributes.DeployAttributes() 
	}
	
	open class AfterburnAttributes : BatWoodAttributes.AfterburnAttributes() 
	
	open class AmmoAttributes : BatWoodAttributes.AmmoAttributes() {
		override val clipSize: ClipSizeAttributes = ClipSizeAttributes()
	
		override val maxAmmo: MaxAmmoAttributes = MaxAmmoAttributes()
	
		open class ClipSizeAttributes : BatWoodAttributes.AmmoAttributes.ClipSizeAttributes() 
	
		open class MaxAmmoAttributes : BatWoodAttributes.AmmoAttributes.MaxAmmoAttributes() 
	}
	
	open class BuildingsAttributes : BatWoodAttributes.BuildingsAttributes() {
		override val sentryGun: SentryGunAttributes = SentryGunAttributes()
	
		override val dispenser: DispenserAttributes = DispenserAttributes()
	
		override val teleporter: TeleporterAttributes = TeleporterAttributes()
	
		open class SentryGunAttributes : BatWoodAttributes.BuildingsAttributes.SentryGunAttributes() 
	
		open class DispenserAttributes : BatWoodAttributes.BuildingsAttributes.DispenserAttributes() 
	
		open class TeleporterAttributes : BatWoodAttributes.BuildingsAttributes.TeleporterAttributes() 
	}
	
	open class DemoChargeAttributes : BatWoodAttributes.DemoChargeAttributes() {
		override val multChargeTurnControl: MultChargeTurnControlAttributes = MultChargeTurnControlAttributes()
	
		open class MultChargeTurnControlAttributes : BatWoodAttributes.DemoChargeAttributes.MultChargeTurnControlAttributes() 
	}
	
	open class FiringAttributes : BatWoodAttributes.FiringAttributes() {
		override val fireRate: FireRateAttributes = FireRateAttributes()
	
		open class FireRateAttributes : BatWoodAttributes.FiringAttributes.FireRateAttributes() 
	}
	
	open class HealthAndHealingAttributes : BatWoodAttributes.HealthAndHealingAttributes() {
		override val healthRegen: HealthRegenAttributes = HealthRegenAttributes()
	
		override val maxHealthAdditive: MaxHealthAdditiveAttributes = MaxHealthAdditiveAttributes()
	
		open class HealthRegenAttributes : BatWoodAttributes.HealthAndHealingAttributes.HealthRegenAttributes() 
	
		open class MaxHealthAdditiveAttributes : BatWoodAttributes.HealthAndHealingAttributes.MaxHealthAdditiveAttributes() 
	}
	
	open class KnockbackReceivedAttributes : BatWoodAttributes.KnockbackReceivedAttributes() {
		override val damageForceReduction: DamageForceReductionAttributes = DamageForceReductionAttributes()
	
		open class DamageForceReductionAttributes : BatWoodAttributes.KnockbackReceivedAttributes.DamageForceReductionAttributes() 
	}
	
	open class MetaAttributes : BatWoodAttributes.MetaAttributes() {
		override val killfeed: KillfeedAttributes = KillfeedAttributes()
	
		override val viewmodel: ViewmodelAttributes = ViewmodelAttributes()
	
		override val items: ItemsAttributes = ItemsAttributes()
	
		override val particles: ParticlesAttributes = ParticlesAttributes()
	
		override val noisemakers: NoisemakersAttributes = NoisemakersAttributes()
	
		override val player: PlayerAttributes = PlayerAttributes()
	
		override val gameplay: GameplayAttributes = GameplayAttributes()
	
		open class KillfeedAttributes : BatWoodAttributes.MetaAttributes.KillfeedAttributes() 
	
		open class ViewmodelAttributes : BatWoodAttributes.MetaAttributes.ViewmodelAttributes() 
	
		open class ItemsAttributes : BatWoodAttributes.MetaAttributes.ItemsAttributes() 
	
		open class ParticlesAttributes : BatWoodAttributes.MetaAttributes.ParticlesAttributes() 
	
		open class NoisemakersAttributes : BatWoodAttributes.MetaAttributes.NoisemakersAttributes() 
	
		open class PlayerAttributes : BatWoodAttributes.MetaAttributes.PlayerAttributes() 
	
		open class GameplayAttributes : BatWoodAttributes.MetaAttributes.GameplayAttributes() 
	}
	
	open class MeterAttributes : BatWoodAttributes.MeterAttributes() {
		override val generateRageOnDamage: GenerateRageOnDamageAttributes = GenerateRageOnDamageAttributes()
	
		open class GenerateRageOnDamageAttributes : BatWoodAttributes.MeterAttributes.GenerateRageOnDamageAttributes() 
	}
	
	open class MovementAttributes : BatWoodAttributes.MovementAttributes() {
		override val moveSpeed: MoveSpeedAttributes = MoveSpeedAttributes()
	
		override val jumpHeight: jumpHeightAttributes = jumpHeightAttributes()
	
		open class MoveSpeedAttributes : BatWoodAttributes.MovementAttributes.MoveSpeedAttributes() {
			override val aimingMovespeed: AimingMovespeedAttributes = AimingMovespeedAttributes()
	
			override val moveSpeed: MoveSpeedAttributes = MoveSpeedAttributes()
	
			open class AimingMovespeedAttributes : BatWoodAttributes.MovementAttributes.MoveSpeedAttributes.AimingMovespeedAttributes() 
	
			open class MoveSpeedAttributes : BatWoodAttributes.MovementAttributes.MoveSpeedAttributes.MoveSpeedAttributes() 
		}
	
		open class jumpHeightAttributes : BatWoodAttributes.MovementAttributes.jumpHeightAttributes() 
	}
	
	open class HeadsAttributes : BatWoodAttributes.HeadsAttributes() 
	
	open class OnKillAttributes : BatWoodAttributes.OnKillAttributes() 
	
	open class ProjectilesAttributes : BatWoodAttributes.ProjectilesAttributes() {
		override val projectilePenetration: ProjectilePenetrationAttributes = ProjectilePenetrationAttributes()
	
		override val bullets: BulletsAttributes = BulletsAttributes()
	
		open class ProjectilePenetrationAttributes : BatWoodAttributes.ProjectilesAttributes.ProjectilePenetrationAttributes() 
	
		open class BulletsAttributes : BatWoodAttributes.ProjectilesAttributes.BulletsAttributes() 
	}
	
	open class ReloadingAttributes : BatWoodAttributes.ReloadingAttributes() 
	
	open class ResistanceAttributes : BatWoodAttributes.ResistanceAttributes() {
		override val dmgTakenFromCritReduced: DmgTakenFromCritReducedAttributes = DmgTakenFromCritReducedAttributes()
	
		override val dmgTakenFromFireReduced: DmgTakenFromFireReducedAttributes = DmgTakenFromFireReducedAttributes()
	
		override val dmgTakenFromBulletsReduced: DmgTakenFromBulletsReducedAttributes = DmgTakenFromBulletsReducedAttributes()
	
		override val vaccinator: VaccinatorAttributes = VaccinatorAttributes()
	
		open class DmgTakenFromCritReducedAttributes : BatWoodAttributes.ResistanceAttributes.DmgTakenFromCritReducedAttributes() 
	
		open class DmgTakenFromFireReducedAttributes : BatWoodAttributes.ResistanceAttributes.DmgTakenFromFireReducedAttributes() 
	
		open class DmgTakenFromBulletsReducedAttributes : BatWoodAttributes.ResistanceAttributes.DmgTakenFromBulletsReducedAttributes() 
	
		open class VaccinatorAttributes : BatWoodAttributes.ResistanceAttributes.VaccinatorAttributes() 
	}
	
	open class RevengeCritsAttributes : BatWoodAttributes.RevengeCritsAttributes() 
	
	open class StatusEffectsAttributes : BatWoodAttributes.StatusEffectsAttributes() 
	
	open class TauntingAttributes : BatWoodAttributes.TauntingAttributes() 
	
	open class WhenHitAttributes : BatWoodAttributes.WhenHitAttributes() 
	
	open class RagdollsAttributes : BatWoodAttributes.RagdollsAttributes() 
	
	open class BuffItemsAttributes : BatWoodAttributes.BuffItemsAttributes() 
	
	open class CloakAttributes : BatWoodAttributes.CloakAttributes() 
	
	open class DisguiseAttributes : BatWoodAttributes.DisguiseAttributes() 
	
	open class HudAttributes : BatWoodAttributes.HudAttributes() 
	
	open class SpyOnlyAttributes : BatWoodAttributes.SpyOnlyAttributes() 
	
	object Inherited : BatGiftwrapAttributes 
}