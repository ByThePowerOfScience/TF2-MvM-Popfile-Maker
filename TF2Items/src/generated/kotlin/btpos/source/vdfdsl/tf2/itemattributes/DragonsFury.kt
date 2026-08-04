package btpos.source.vdfdsl.tf2.itemattributes

import btpos.source.vdfdsl.modeling.*
import btpos.source.vdfdsl.serialization.codecs.*
import btpos.source.vdfdsl.tf2.itemattributes.impl.*
import btpos.source.vdfdsl.tf2.tftypes.*
import java.util.*
import kotlin.time.Duration

interface DragonsFuryAttributes : IBlockScoped, FlamethrowerAttributes {
	companion object : IBlockScoped {
		private val airblast: AirblastAttributes = AirblastAttributes()
	
		private val crits: CritsAttributes = CritsAttributes()
	
		private val movement: MovementAttributes = MovementAttributes()
	
		private val ammo: AmmoAttributes = AmmoAttributes()
	
		private val healthAndHealing: HealthAndHealingAttributes = HealthAndHealingAttributes()
	
		private val buffType: BuffTypeAttributes = BuffTypeAttributes()
	
		private val firing: FiringAttributes = FiringAttributes()
	
		private val flames: FlamesAttributes = FlamesAttributes()
	
		private val damage: DamageAttributes = DamageAttributes()
	
		private val projectiles: ProjectilesAttributes = ProjectilesAttributes()
	
		private val afterburn: AfterburnAttributes = AfterburnAttributes()
	
		private val buildings: BuildingsAttributes = BuildingsAttributes()
	
		private val demoCharge: DemoChargeAttributes = DemoChargeAttributes()
	
		private val knockbackReceived: KnockbackReceivedAttributes = KnockbackReceivedAttributes()
	
		private val meta: MetaAttributes = MetaAttributes()
	
		private val meter: MeterAttributes = MeterAttributes()
	
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

	override val airblast: AirblastAttributes get() = DragonsFuryAttributes.airblast
	
	override val crits: CritsAttributes get() = DragonsFuryAttributes.crits
	
	override val movement: MovementAttributes get() = DragonsFuryAttributes.movement
	
	override val ammo: AmmoAttributes get() = DragonsFuryAttributes.ammo
	
	override val healthAndHealing: HealthAndHealingAttributes get() = DragonsFuryAttributes.healthAndHealing
	
	override val buffType: BuffTypeAttributes get() = DragonsFuryAttributes.buffType
	
	override val firing: FiringAttributes get() = DragonsFuryAttributes.firing
	
	override val flames: FlamesAttributes get() = DragonsFuryAttributes.flames
	
	override val damage: DamageAttributes get() = DragonsFuryAttributes.damage
	
	override val projectiles: ProjectilesAttributes get() = DragonsFuryAttributes.projectiles
	
	override val afterburn: AfterburnAttributes get() = DragonsFuryAttributes.afterburn
	
	override val buildings: BuildingsAttributes get() = DragonsFuryAttributes.buildings
	
	override val demoCharge: DemoChargeAttributes get() = DragonsFuryAttributes.demoCharge
	
	override val knockbackReceived: KnockbackReceivedAttributes get() = DragonsFuryAttributes.knockbackReceived
	
	override val meta: MetaAttributes get() = DragonsFuryAttributes.meta
	
	override val meter: MeterAttributes get() = DragonsFuryAttributes.meter
	
	override val heads: HeadsAttributes get() = DragonsFuryAttributes.heads
	
	override val onHit: OnHitAttributes get() = DragonsFuryAttributes.onHit
	
	override val onKill: OnKillAttributes get() = DragonsFuryAttributes.onKill
	
	override val reloading: ReloadingAttributes get() = DragonsFuryAttributes.reloading
	
	override val resistance: ResistanceAttributes get() = DragonsFuryAttributes.resistance
	
	override val revengeCrits: RevengeCritsAttributes get() = DragonsFuryAttributes.revengeCrits
	
	override val statusEffects: StatusEffectsAttributes get() = DragonsFuryAttributes.statusEffects
	
	override val taunting: TauntingAttributes get() = DragonsFuryAttributes.taunting
	
	override val swapWeapons: SwapWeaponsAttributes get() = DragonsFuryAttributes.swapWeapons
	
	override val whenHit: WhenHitAttributes get() = DragonsFuryAttributes.whenHit
	
	override val ragdolls: RagdollsAttributes get() = DragonsFuryAttributes.ragdolls
	
	override val buffItems: BuffItemsAttributes get() = DragonsFuryAttributes.buffItems
	
	override val cloak: CloakAttributes get() = DragonsFuryAttributes.cloak
	
	override val disguise: DisguiseAttributes get() = DragonsFuryAttributes.disguise
	
	override val hud: HudAttributes get() = DragonsFuryAttributes.hud
	
	override val spyOnly: SpyOnlyAttributes get() = DragonsFuryAttributes.spyOnly

	open class AirblastAttributes : FlamethrowerAttributes.AirblastAttributes() 
	
	open class CritsAttributes : FlamethrowerAttributes.CritsAttributes() 
	
	open class MovementAttributes : FlamethrowerAttributes.MovementAttributes() {
		override val moveSpeed: MoveSpeedAttributes = MoveSpeedAttributes()
	
		override val jumpHeight: jumpHeightAttributes = jumpHeightAttributes()
	
		open class MoveSpeedAttributes : FlamethrowerAttributes.MovementAttributes.MoveSpeedAttributes() {
			override val aimingMovespeed: AimingMovespeedAttributes = AimingMovespeedAttributes()
	
			override val moveSpeed: MoveSpeedAttributes = MoveSpeedAttributes()
	
			open class AimingMovespeedAttributes : FlamethrowerAttributes.MovementAttributes.MoveSpeedAttributes.AimingMovespeedAttributes() 
	
			open class MoveSpeedAttributes : FlamethrowerAttributes.MovementAttributes.MoveSpeedAttributes.MoveSpeedAttributes() 
		}
	
		open class jumpHeightAttributes : FlamethrowerAttributes.MovementAttributes.jumpHeightAttributes() 
	}
	
	open class AmmoAttributes : FlamethrowerAttributes.AmmoAttributes() {
		override val clipSize: ClipSizeAttributes = ClipSizeAttributes()
	
		override val maxAmmo: MaxAmmoAttributes = MaxAmmoAttributes()
	
		open class ClipSizeAttributes : FlamethrowerAttributes.AmmoAttributes.ClipSizeAttributes() 
	
		open class MaxAmmoAttributes : FlamethrowerAttributes.AmmoAttributes.MaxAmmoAttributes() 
	}
	
	open class HealthAndHealingAttributes : FlamethrowerAttributes.HealthAndHealingAttributes() {
		override val healthRegen: HealthRegenAttributes = HealthRegenAttributes()
	
		override val maxHealthAdditive: MaxHealthAdditiveAttributes = MaxHealthAdditiveAttributes()
	
		open class HealthRegenAttributes : FlamethrowerAttributes.HealthAndHealingAttributes.HealthRegenAttributes() 
	
		open class MaxHealthAdditiveAttributes : FlamethrowerAttributes.HealthAndHealingAttributes.MaxHealthAdditiveAttributes() 
	}
	
	open class BuffTypeAttributes : FlamethrowerAttributes.BuffTypeAttributes() 
	
	open class FiringAttributes : FlamethrowerAttributes.FiringAttributes() {
		override val fireRate: FireRateAttributes = FireRateAttributes()
	
		open class FireRateAttributes : FlamethrowerAttributes.FiringAttributes.FireRateAttributes() 
	}
	
	open class FlamesAttributes : FlamethrowerAttributes.FlamesAttributes() 
	
	open class DamageAttributes : FlamethrowerAttributes.DamageAttributes() {
		override val alien: AlienAttributes = AlienAttributes()
	
		open class AlienAttributes : FlamethrowerAttributes.DamageAttributes.AlienAttributes() 
	}
	
	open class ProjectilesAttributes : FlamethrowerAttributes.ProjectilesAttributes() {
		override val bullets: BulletsAttributes = BulletsAttributes()
	
		override val projectilePenetration: ProjectilePenetrationAttributes = ProjectilePenetrationAttributes()
	
		open class BulletsAttributes : FlamethrowerAttributes.ProjectilesAttributes.BulletsAttributes() 
	
		open class ProjectilePenetrationAttributes : FlamethrowerAttributes.ProjectilesAttributes.ProjectilePenetrationAttributes() 
	}
	
	open class AfterburnAttributes : FlamethrowerAttributes.AfterburnAttributes() 
	
	open class BuildingsAttributes : FlamethrowerAttributes.BuildingsAttributes() {
		override val sentryGun: SentryGunAttributes = SentryGunAttributes()
	
		override val dispenser: DispenserAttributes = DispenserAttributes()
	
		override val teleporter: TeleporterAttributes = TeleporterAttributes()
	
		open class SentryGunAttributes : FlamethrowerAttributes.BuildingsAttributes.SentryGunAttributes() 
	
		open class DispenserAttributes : FlamethrowerAttributes.BuildingsAttributes.DispenserAttributes() 
	
		open class TeleporterAttributes : FlamethrowerAttributes.BuildingsAttributes.TeleporterAttributes() 
	}
	
	open class DemoChargeAttributes : FlamethrowerAttributes.DemoChargeAttributes() {
		override val multChargeTurnControl: MultChargeTurnControlAttributes = MultChargeTurnControlAttributes()
	
		open class MultChargeTurnControlAttributes : FlamethrowerAttributes.DemoChargeAttributes.MultChargeTurnControlAttributes() 
	}
	
	open class KnockbackReceivedAttributes : FlamethrowerAttributes.KnockbackReceivedAttributes() {
		override val damageForceReduction: DamageForceReductionAttributes = DamageForceReductionAttributes()
	
		open class DamageForceReductionAttributes : FlamethrowerAttributes.KnockbackReceivedAttributes.DamageForceReductionAttributes() 
	}
	
	open class MetaAttributes : FlamethrowerAttributes.MetaAttributes() {
		override val killfeed: KillfeedAttributes = KillfeedAttributes()
	
		override val viewmodel: ViewmodelAttributes = ViewmodelAttributes()
	
		override val items: ItemsAttributes = ItemsAttributes()
	
		override val particles: ParticlesAttributes = ParticlesAttributes()
	
		override val noisemakers: NoisemakersAttributes = NoisemakersAttributes()
	
		override val player: PlayerAttributes = PlayerAttributes()
	
		override val gameplay: GameplayAttributes = GameplayAttributes()
	
		open class KillfeedAttributes : FlamethrowerAttributes.MetaAttributes.KillfeedAttributes() 
	
		open class ViewmodelAttributes : FlamethrowerAttributes.MetaAttributes.ViewmodelAttributes() 
	
		open class ItemsAttributes : FlamethrowerAttributes.MetaAttributes.ItemsAttributes() 
	
		open class ParticlesAttributes : FlamethrowerAttributes.MetaAttributes.ParticlesAttributes() 
	
		open class NoisemakersAttributes : FlamethrowerAttributes.MetaAttributes.NoisemakersAttributes() 
	
		open class PlayerAttributes : FlamethrowerAttributes.MetaAttributes.PlayerAttributes() 
	
		open class GameplayAttributes : FlamethrowerAttributes.MetaAttributes.GameplayAttributes() 
	}
	
	open class MeterAttributes : FlamethrowerAttributes.MeterAttributes() {
		override val generateRageOnDamage: GenerateRageOnDamageAttributes = GenerateRageOnDamageAttributes()
	
		open class GenerateRageOnDamageAttributes : FlamethrowerAttributes.MeterAttributes.GenerateRageOnDamageAttributes() 
	}
	
	open class HeadsAttributes : FlamethrowerAttributes.HeadsAttributes() 
	
	open class OnHitAttributes : FlamethrowerAttributes.OnHitAttributes() {
		override val healOnHitForRapidfire: HealOnHitForRapidfireAttributes = HealOnHitForRapidfireAttributes()
	
		override val generateRageOnDamage: GenerateRageOnDamageAttributes = GenerateRageOnDamageAttributes()
	
		override val falling: FallingAttributes = FallingAttributes()
	
		open class HealOnHitForRapidfireAttributes : FlamethrowerAttributes.OnHitAttributes.HealOnHitForRapidfireAttributes() 
	
		open class GenerateRageOnDamageAttributes : FlamethrowerAttributes.OnHitAttributes.GenerateRageOnDamageAttributes() 
	
		open class FallingAttributes : FlamethrowerAttributes.OnHitAttributes.FallingAttributes() 
	}
	
	open class OnKillAttributes : FlamethrowerAttributes.OnKillAttributes() 
	
	open class ReloadingAttributes : FlamethrowerAttributes.ReloadingAttributes() 
	
	open class ResistanceAttributes : FlamethrowerAttributes.ResistanceAttributes() {
		override val dmgTakenFromCritReduced: DmgTakenFromCritReducedAttributes = DmgTakenFromCritReducedAttributes()
	
		override val dmgTakenFromFireReduced: DmgTakenFromFireReducedAttributes = DmgTakenFromFireReducedAttributes()
	
		override val dmgTakenFromBulletsReduced: DmgTakenFromBulletsReducedAttributes = DmgTakenFromBulletsReducedAttributes()
	
		override val vaccinator: VaccinatorAttributes = VaccinatorAttributes()
	
		open class DmgTakenFromCritReducedAttributes : FlamethrowerAttributes.ResistanceAttributes.DmgTakenFromCritReducedAttributes() 
	
		open class DmgTakenFromFireReducedAttributes : FlamethrowerAttributes.ResistanceAttributes.DmgTakenFromFireReducedAttributes() 
	
		open class DmgTakenFromBulletsReducedAttributes : FlamethrowerAttributes.ResistanceAttributes.DmgTakenFromBulletsReducedAttributes() 
	
		open class VaccinatorAttributes : FlamethrowerAttributes.ResistanceAttributes.VaccinatorAttributes() 
	}
	
	open class RevengeCritsAttributes : FlamethrowerAttributes.RevengeCritsAttributes() 
	
	open class StatusEffectsAttributes : FlamethrowerAttributes.StatusEffectsAttributes() 
	
	open class TauntingAttributes : FlamethrowerAttributes.TauntingAttributes() 
	
	open class SwapWeaponsAttributes : FlamethrowerAttributes.SwapWeaponsAttributes() {
		override val deploy: DeployAttributes = DeployAttributes()
	
		open class DeployAttributes : FlamethrowerAttributes.SwapWeaponsAttributes.DeployAttributes() 
	}
	
	open class WhenHitAttributes : FlamethrowerAttributes.WhenHitAttributes() 
	
	open class RagdollsAttributes : FlamethrowerAttributes.RagdollsAttributes() 
	
	open class BuffItemsAttributes : FlamethrowerAttributes.BuffItemsAttributes() 
	
	open class CloakAttributes : FlamethrowerAttributes.CloakAttributes() 
	
	open class DisguiseAttributes : FlamethrowerAttributes.DisguiseAttributes() 
	
	open class HudAttributes : FlamethrowerAttributes.HudAttributes() 
	
	open class SpyOnlyAttributes : FlamethrowerAttributes.SpyOnlyAttributes() 
	
	object Inherited : DragonsFuryAttributes 
}