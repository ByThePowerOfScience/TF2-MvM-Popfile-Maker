package btpos.source.vdfdsl.tf2.itemattributes

import btpos.source.vdfdsl.modeling.*
import btpos.source.vdfdsl.serialization.codecs.*
import btpos.source.vdfdsl.tf2.itemattributes.impl.*
import btpos.source.vdfdsl.tf2.tftypes.*
import java.util.*
import kotlin.time.Duration

interface CleaverAttributes : IBlockScoped, JarAttributes {
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

	override val projectiles: ProjectilesAttributes get() = CleaverAttributes.projectiles
	
	override val meter: MeterAttributes get() = CleaverAttributes.meter
	
	override val onHit: OnHitAttributes get() = CleaverAttributes.onHit
	
	override val ammo: AmmoAttributes get() = CleaverAttributes.ammo
	
	override val damage: DamageAttributes get() = CleaverAttributes.damage
	
	override val firing: FiringAttributes get() = CleaverAttributes.firing
	
	override val afterburn: AfterburnAttributes get() = CleaverAttributes.afterburn
	
	override val buildings: BuildingsAttributes get() = CleaverAttributes.buildings
	
	override val crits: CritsAttributes get() = CleaverAttributes.crits
	
	override val demoCharge: DemoChargeAttributes get() = CleaverAttributes.demoCharge
	
	override val healthAndHealing: HealthAndHealingAttributes get() = CleaverAttributes.healthAndHealing
	
	override val knockbackReceived: KnockbackReceivedAttributes get() = CleaverAttributes.knockbackReceived
	
	override val meta: MetaAttributes get() = CleaverAttributes.meta
	
	override val movement: MovementAttributes get() = CleaverAttributes.movement
	
	override val heads: HeadsAttributes get() = CleaverAttributes.heads
	
	override val onKill: OnKillAttributes get() = CleaverAttributes.onKill
	
	override val reloading: ReloadingAttributes get() = CleaverAttributes.reloading
	
	override val resistance: ResistanceAttributes get() = CleaverAttributes.resistance
	
	override val revengeCrits: RevengeCritsAttributes get() = CleaverAttributes.revengeCrits
	
	override val statusEffects: StatusEffectsAttributes get() = CleaverAttributes.statusEffects
	
	override val taunting: TauntingAttributes get() = CleaverAttributes.taunting
	
	override val swapWeapons: SwapWeaponsAttributes get() = CleaverAttributes.swapWeapons
	
	override val whenHit: WhenHitAttributes get() = CleaverAttributes.whenHit
	
	override val ragdolls: RagdollsAttributes get() = CleaverAttributes.ragdolls
	
	override val buffItems: BuffItemsAttributes get() = CleaverAttributes.buffItems
	
	override val cloak: CloakAttributes get() = CleaverAttributes.cloak
	
	override val disguise: DisguiseAttributes get() = CleaverAttributes.disguise
	
	override val hud: HudAttributes get() = CleaverAttributes.hud
	
	override val spyOnly: SpyOnlyAttributes get() = CleaverAttributes.spyOnly

	open class ProjectilesAttributes : JarAttributes.ProjectilesAttributes() {
		override val bullets: BulletsAttributes = BulletsAttributes()
	
		override val projectilePenetration: ProjectilePenetrationAttributes = ProjectilePenetrationAttributes()
	
		open class BulletsAttributes : JarAttributes.ProjectilesAttributes.BulletsAttributes() 
	
		open class ProjectilePenetrationAttributes : JarAttributes.ProjectilesAttributes.ProjectilePenetrationAttributes() 
	}
	
	open class MeterAttributes : JarAttributes.MeterAttributes() {
		override val generateRageOnDamage: GenerateRageOnDamageAttributes = GenerateRageOnDamageAttributes()
	
		open class GenerateRageOnDamageAttributes : JarAttributes.MeterAttributes.GenerateRageOnDamageAttributes() 
	}
	
	open class OnHitAttributes : JarAttributes.OnHitAttributes() {
		override val healOnHitForRapidfire: HealOnHitForRapidfireAttributes = HealOnHitForRapidfireAttributes()
	
		override val generateRageOnDamage: GenerateRageOnDamageAttributes = GenerateRageOnDamageAttributes()
	
		override val falling: FallingAttributes = FallingAttributes()
	
		open class HealOnHitForRapidfireAttributes : JarAttributes.OnHitAttributes.HealOnHitForRapidfireAttributes() 
	
		open class GenerateRageOnDamageAttributes : JarAttributes.OnHitAttributes.GenerateRageOnDamageAttributes() 
	
		open class FallingAttributes : JarAttributes.OnHitAttributes.FallingAttributes() 
	}
	
	open class AmmoAttributes : JarAttributes.AmmoAttributes() {
		override val clipSize: ClipSizeAttributes = ClipSizeAttributes()
	
		override val maxAmmo: MaxAmmoAttributes = MaxAmmoAttributes()
	
		open class ClipSizeAttributes : JarAttributes.AmmoAttributes.ClipSizeAttributes() 
	
		open class MaxAmmoAttributes : JarAttributes.AmmoAttributes.MaxAmmoAttributes() 
	}
	
	open class DamageAttributes : JarAttributes.DamageAttributes() {
		override val alien: AlienAttributes = AlienAttributes()
	
		open class AlienAttributes : JarAttributes.DamageAttributes.AlienAttributes() 
	}
	
	open class FiringAttributes : JarAttributes.FiringAttributes() {
		override val fireRate: FireRateAttributes = FireRateAttributes()
	
		open class FireRateAttributes : JarAttributes.FiringAttributes.FireRateAttributes() 
	}
	
	open class AfterburnAttributes : JarAttributes.AfterburnAttributes() 
	
	open class BuildingsAttributes : JarAttributes.BuildingsAttributes() {
		override val sentryGun: SentryGunAttributes = SentryGunAttributes()
	
		override val dispenser: DispenserAttributes = DispenserAttributes()
	
		override val teleporter: TeleporterAttributes = TeleporterAttributes()
	
		open class SentryGunAttributes : JarAttributes.BuildingsAttributes.SentryGunAttributes() 
	
		open class DispenserAttributes : JarAttributes.BuildingsAttributes.DispenserAttributes() 
	
		open class TeleporterAttributes : JarAttributes.BuildingsAttributes.TeleporterAttributes() 
	}
	
	open class CritsAttributes : JarAttributes.CritsAttributes() 
	
	open class DemoChargeAttributes : JarAttributes.DemoChargeAttributes() {
		override val multChargeTurnControl: MultChargeTurnControlAttributes = MultChargeTurnControlAttributes()
	
		open class MultChargeTurnControlAttributes : JarAttributes.DemoChargeAttributes.MultChargeTurnControlAttributes() 
	}
	
	open class HealthAndHealingAttributes : JarAttributes.HealthAndHealingAttributes() {
		override val healthRegen: HealthRegenAttributes = HealthRegenAttributes()
	
		override val maxHealthAdditive: MaxHealthAdditiveAttributes = MaxHealthAdditiveAttributes()
	
		open class HealthRegenAttributes : JarAttributes.HealthAndHealingAttributes.HealthRegenAttributes() 
	
		open class MaxHealthAdditiveAttributes : JarAttributes.HealthAndHealingAttributes.MaxHealthAdditiveAttributes() 
	}
	
	open class KnockbackReceivedAttributes : JarAttributes.KnockbackReceivedAttributes() {
		override val damageForceReduction: DamageForceReductionAttributes = DamageForceReductionAttributes()
	
		open class DamageForceReductionAttributes : JarAttributes.KnockbackReceivedAttributes.DamageForceReductionAttributes() 
	}
	
	open class MetaAttributes : JarAttributes.MetaAttributes() {
		override val killfeed: KillfeedAttributes = KillfeedAttributes()
	
		override val viewmodel: ViewmodelAttributes = ViewmodelAttributes()
	
		override val items: ItemsAttributes = ItemsAttributes()
	
		override val particles: ParticlesAttributes = ParticlesAttributes()
	
		override val noisemakers: NoisemakersAttributes = NoisemakersAttributes()
	
		override val player: PlayerAttributes = PlayerAttributes()
	
		override val gameplay: GameplayAttributes = GameplayAttributes()
	
		open class KillfeedAttributes : JarAttributes.MetaAttributes.KillfeedAttributes() 
	
		open class ViewmodelAttributes : JarAttributes.MetaAttributes.ViewmodelAttributes() 
	
		open class ItemsAttributes : JarAttributes.MetaAttributes.ItemsAttributes() 
	
		open class ParticlesAttributes : JarAttributes.MetaAttributes.ParticlesAttributes() 
	
		open class NoisemakersAttributes : JarAttributes.MetaAttributes.NoisemakersAttributes() 
	
		open class PlayerAttributes : JarAttributes.MetaAttributes.PlayerAttributes() 
	
		open class GameplayAttributes : JarAttributes.MetaAttributes.GameplayAttributes() 
	}
	
	open class MovementAttributes : JarAttributes.MovementAttributes() {
		override val moveSpeed: MoveSpeedAttributes = MoveSpeedAttributes()
	
		override val jumpHeight: jumpHeightAttributes = jumpHeightAttributes()
	
		open class MoveSpeedAttributes : JarAttributes.MovementAttributes.MoveSpeedAttributes() {
			override val aimingMovespeed: AimingMovespeedAttributes = AimingMovespeedAttributes()
	
			override val moveSpeed: MoveSpeedAttributes = MoveSpeedAttributes()
	
			open class AimingMovespeedAttributes : JarAttributes.MovementAttributes.MoveSpeedAttributes.AimingMovespeedAttributes() 
	
			open class MoveSpeedAttributes : JarAttributes.MovementAttributes.MoveSpeedAttributes.MoveSpeedAttributes() 
		}
	
		open class jumpHeightAttributes : JarAttributes.MovementAttributes.jumpHeightAttributes() 
	}
	
	open class HeadsAttributes : JarAttributes.HeadsAttributes() 
	
	open class OnKillAttributes : JarAttributes.OnKillAttributes() 
	
	open class ReloadingAttributes : JarAttributes.ReloadingAttributes() 
	
	open class ResistanceAttributes : JarAttributes.ResistanceAttributes() {
		override val dmgTakenFromCritReduced: DmgTakenFromCritReducedAttributes = DmgTakenFromCritReducedAttributes()
	
		override val dmgTakenFromFireReduced: DmgTakenFromFireReducedAttributes = DmgTakenFromFireReducedAttributes()
	
		override val dmgTakenFromBulletsReduced: DmgTakenFromBulletsReducedAttributes = DmgTakenFromBulletsReducedAttributes()
	
		override val vaccinator: VaccinatorAttributes = VaccinatorAttributes()
	
		open class DmgTakenFromCritReducedAttributes : JarAttributes.ResistanceAttributes.DmgTakenFromCritReducedAttributes() 
	
		open class DmgTakenFromFireReducedAttributes : JarAttributes.ResistanceAttributes.DmgTakenFromFireReducedAttributes() 
	
		open class DmgTakenFromBulletsReducedAttributes : JarAttributes.ResistanceAttributes.DmgTakenFromBulletsReducedAttributes() 
	
		open class VaccinatorAttributes : JarAttributes.ResistanceAttributes.VaccinatorAttributes() 
	}
	
	open class RevengeCritsAttributes : JarAttributes.RevengeCritsAttributes() 
	
	open class StatusEffectsAttributes : JarAttributes.StatusEffectsAttributes() 
	
	open class TauntingAttributes : JarAttributes.TauntingAttributes() 
	
	open class SwapWeaponsAttributes : JarAttributes.SwapWeaponsAttributes() {
		override val deploy: DeployAttributes = DeployAttributes()
	
		open class DeployAttributes : JarAttributes.SwapWeaponsAttributes.DeployAttributes() 
	}
	
	open class WhenHitAttributes : JarAttributes.WhenHitAttributes() 
	
	open class RagdollsAttributes : JarAttributes.RagdollsAttributes() 
	
	open class BuffItemsAttributes : JarAttributes.BuffItemsAttributes() 
	
	open class CloakAttributes : JarAttributes.CloakAttributes() 
	
	open class DisguiseAttributes : JarAttributes.DisguiseAttributes() 
	
	open class HudAttributes : JarAttributes.HudAttributes() 
	
	open class SpyOnlyAttributes : JarAttributes.SpyOnlyAttributes() 
	
	object Inherited : CleaverAttributes 
}