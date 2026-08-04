package btpos.source.vdfdsl.tf2.itemattributes

import btpos.source.vdfdsl.modeling.*
import btpos.source.vdfdsl.serialization.codecs.*
import btpos.source.vdfdsl.tf2.itemattributes.impl.*
import btpos.source.vdfdsl.tf2.tftypes.*
import java.util.*
import kotlin.time.Duration

interface StickybombLauncherAttributes : IBlockScoped, BaseGunAttributes {
	companion object : IBlockScoped {
		/**
		 * In-Game: "Max charge time decreased by N%"
		 * 
		 * Not actually the "rate", rather the time it takes to fully charge a stickybomb launch when holding MOUSE1.
		 */
		val stickybombChargeRate: ItemAttributeNamed<Number> = ItemAttributeNamed("stickybomb charge rate")
	
		/**
		 * In-Game: "Able to destroy enemy stickybomb"
		 * 
		 * If 1, stickies destroy other stickies.
		 */
		val stickiesDetonateStickies: ItemAttributeNamed<Boolean> = ItemAttributeNamed("stickies detonate stickies")
	
		/**
		 * In-Game: "Up to +N% damage based on charge"
		 * 
		 * damage = `2*basedamage * (this - 1.0) * currentChargeProportion`.
		 */
		val stickybombChargeDamageIncrease: ItemAttributeNamed<Number> = ItemAttributeNamed("stickybomb_charge_damage_increase")
	
		/**
		 * Bonus:
		 * 
		 * 	- In-Game: "+N max stickybombs out"
		 * 
		 * Penalty:
		 * 
		 * 	- In-Game: "N max stickybombs out"
		 */
		val maxStickies: BonusPenalty<Int> = BonusPenalty(
			ItemAttributeNamed("max pipebombs increased"),
			ItemAttributeNamed("max pipebombs decreased"),
		)
	
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
	 * In-Game: "Max charge time decreased by N%"
	 * 
	 * Not actually the "rate", rather the time it takes to fully charge a stickybomb launch when holding MOUSE1.
	 */
	val stickybombChargeRate: ItemAttributeNamed<Number> get() = StickybombLauncherAttributes.stickybombChargeRate
	
	/**
	 * In-Game: "Able to destroy enemy stickybomb"
	 * 
	 * If 1, stickies destroy other stickies.
	 */
	val stickiesDetonateStickies: ItemAttributeNamed<Boolean> get() = StickybombLauncherAttributes.stickiesDetonateStickies
	
	/**
	 * In-Game: "Up to +N% damage based on charge"
	 * 
	 * damage = `2*basedamage * (this - 1.0) * currentChargeProportion`.
	 */
	val stickybombChargeDamageIncrease: ItemAttributeNamed<Number> get() = StickybombLauncherAttributes.stickybombChargeDamageIncrease
	
	/**
	 * Bonus:
	 * 
	 * 	- In-Game: "+N max stickybombs out"
	 * 
	 * Penalty:
	 * 
	 * 	- In-Game: "N max stickybombs out"
	 */
	val maxStickies: BonusPenalty<Int> get() = StickybombLauncherAttributes.maxStickies
	
	override val ammo: AmmoAttributes get() = StickybombLauncherAttributes.ammo
	
	override val damage: DamageAttributes get() = StickybombLauncherAttributes.damage
	
	override val firing: FiringAttributes get() = StickybombLauncherAttributes.firing
	
	override val projectiles: ProjectilesAttributes get() = StickybombLauncherAttributes.projectiles
	
	override val afterburn: AfterburnAttributes get() = StickybombLauncherAttributes.afterburn
	
	override val buildings: BuildingsAttributes get() = StickybombLauncherAttributes.buildings
	
	override val crits: CritsAttributes get() = StickybombLauncherAttributes.crits
	
	override val demoCharge: DemoChargeAttributes get() = StickybombLauncherAttributes.demoCharge
	
	override val healthAndHealing: HealthAndHealingAttributes get() = StickybombLauncherAttributes.healthAndHealing
	
	override val knockbackReceived: KnockbackReceivedAttributes get() = StickybombLauncherAttributes.knockbackReceived
	
	override val meta: MetaAttributes get() = StickybombLauncherAttributes.meta
	
	override val meter: MeterAttributes get() = StickybombLauncherAttributes.meter
	
	override val movement: MovementAttributes get() = StickybombLauncherAttributes.movement
	
	override val heads: HeadsAttributes get() = StickybombLauncherAttributes.heads
	
	override val onHit: OnHitAttributes get() = StickybombLauncherAttributes.onHit
	
	override val onKill: OnKillAttributes get() = StickybombLauncherAttributes.onKill
	
	override val reloading: ReloadingAttributes get() = StickybombLauncherAttributes.reloading
	
	override val resistance: ResistanceAttributes get() = StickybombLauncherAttributes.resistance
	
	override val revengeCrits: RevengeCritsAttributes get() = StickybombLauncherAttributes.revengeCrits
	
	override val statusEffects: StatusEffectsAttributes get() = StickybombLauncherAttributes.statusEffects
	
	override val taunting: TauntingAttributes get() = StickybombLauncherAttributes.taunting
	
	override val swapWeapons: SwapWeaponsAttributes get() = StickybombLauncherAttributes.swapWeapons
	
	override val whenHit: WhenHitAttributes get() = StickybombLauncherAttributes.whenHit
	
	override val ragdolls: RagdollsAttributes get() = StickybombLauncherAttributes.ragdolls
	
	override val buffItems: BuffItemsAttributes get() = StickybombLauncherAttributes.buffItems
	
	override val cloak: CloakAttributes get() = StickybombLauncherAttributes.cloak
	
	override val disguise: DisguiseAttributes get() = StickybombLauncherAttributes.disguise
	
	override val hud: HudAttributes get() = StickybombLauncherAttributes.hud
	
	override val spyOnly: SpyOnlyAttributes get() = StickybombLauncherAttributes.spyOnly

	open class AmmoAttributes : BaseGunAttributes.AmmoAttributes() {
		override val clipSize: ClipSizeAttributes = ClipSizeAttributes()
	
		override val maxAmmo: MaxAmmoAttributes = MaxAmmoAttributes()
	
		open class ClipSizeAttributes : BaseGunAttributes.AmmoAttributes.ClipSizeAttributes() 
	
		open class MaxAmmoAttributes : BaseGunAttributes.AmmoAttributes.MaxAmmoAttributes() 
	}
	
	open class DamageAttributes : BaseGunAttributes.DamageAttributes() {
		override val alien: AlienAttributes = AlienAttributes()
	
		open class AlienAttributes : BaseGunAttributes.DamageAttributes.AlienAttributes() 
	}
	
	open class FiringAttributes : BaseGunAttributes.FiringAttributes() {
		override val fireRate: FireRateAttributes = FireRateAttributes()
	
		open class FireRateAttributes : BaseGunAttributes.FiringAttributes.FireRateAttributes() 
	}
	
	open class ProjectilesAttributes : BaseGunAttributes.ProjectilesAttributes() {
		override val bullets: BulletsAttributes = BulletsAttributes()
	
		override val projectilePenetration: ProjectilePenetrationAttributes = ProjectilePenetrationAttributes()
	
		open class BulletsAttributes : BaseGunAttributes.ProjectilesAttributes.BulletsAttributes() 
	
		open class ProjectilePenetrationAttributes : BaseGunAttributes.ProjectilesAttributes.ProjectilePenetrationAttributes() 
	}
	
	open class AfterburnAttributes : BaseGunAttributes.AfterburnAttributes() 
	
	open class BuildingsAttributes : BaseGunAttributes.BuildingsAttributes() {
		override val sentryGun: SentryGunAttributes = SentryGunAttributes()
	
		override val dispenser: DispenserAttributes = DispenserAttributes()
	
		override val teleporter: TeleporterAttributes = TeleporterAttributes()
	
		open class SentryGunAttributes : BaseGunAttributes.BuildingsAttributes.SentryGunAttributes() 
	
		open class DispenserAttributes : BaseGunAttributes.BuildingsAttributes.DispenserAttributes() 
	
		open class TeleporterAttributes : BaseGunAttributes.BuildingsAttributes.TeleporterAttributes() 
	}
	
	open class CritsAttributes : BaseGunAttributes.CritsAttributes() 
	
	open class DemoChargeAttributes : BaseGunAttributes.DemoChargeAttributes() {
		override val multChargeTurnControl: MultChargeTurnControlAttributes = MultChargeTurnControlAttributes()
	
		open class MultChargeTurnControlAttributes : BaseGunAttributes.DemoChargeAttributes.MultChargeTurnControlAttributes() 
	}
	
	open class HealthAndHealingAttributes : BaseGunAttributes.HealthAndHealingAttributes() {
		override val healthRegen: HealthRegenAttributes = HealthRegenAttributes()
	
		override val maxHealthAdditive: MaxHealthAdditiveAttributes = MaxHealthAdditiveAttributes()
	
		open class HealthRegenAttributes : BaseGunAttributes.HealthAndHealingAttributes.HealthRegenAttributes() 
	
		open class MaxHealthAdditiveAttributes : BaseGunAttributes.HealthAndHealingAttributes.MaxHealthAdditiveAttributes() 
	}
	
	open class KnockbackReceivedAttributes : BaseGunAttributes.KnockbackReceivedAttributes() {
		override val damageForceReduction: DamageForceReductionAttributes = DamageForceReductionAttributes()
	
		open class DamageForceReductionAttributes : BaseGunAttributes.KnockbackReceivedAttributes.DamageForceReductionAttributes() 
	}
	
	open class MetaAttributes : BaseGunAttributes.MetaAttributes() {
		override val killfeed: KillfeedAttributes = KillfeedAttributes()
	
		override val viewmodel: ViewmodelAttributes = ViewmodelAttributes()
	
		override val items: ItemsAttributes = ItemsAttributes()
	
		override val particles: ParticlesAttributes = ParticlesAttributes()
	
		override val noisemakers: NoisemakersAttributes = NoisemakersAttributes()
	
		override val player: PlayerAttributes = PlayerAttributes()
	
		override val gameplay: GameplayAttributes = GameplayAttributes()
	
		open class KillfeedAttributes : BaseGunAttributes.MetaAttributes.KillfeedAttributes() 
	
		open class ViewmodelAttributes : BaseGunAttributes.MetaAttributes.ViewmodelAttributes() 
	
		open class ItemsAttributes : BaseGunAttributes.MetaAttributes.ItemsAttributes() 
	
		open class ParticlesAttributes : BaseGunAttributes.MetaAttributes.ParticlesAttributes() 
	
		open class NoisemakersAttributes : BaseGunAttributes.MetaAttributes.NoisemakersAttributes() 
	
		open class PlayerAttributes : BaseGunAttributes.MetaAttributes.PlayerAttributes() 
	
		open class GameplayAttributes : BaseGunAttributes.MetaAttributes.GameplayAttributes() 
	}
	
	open class MeterAttributes : BaseGunAttributes.MeterAttributes() {
		override val generateRageOnDamage: GenerateRageOnDamageAttributes = GenerateRageOnDamageAttributes()
	
		open class GenerateRageOnDamageAttributes : BaseGunAttributes.MeterAttributes.GenerateRageOnDamageAttributes() 
	}
	
	open class MovementAttributes : BaseGunAttributes.MovementAttributes() {
		override val moveSpeed: MoveSpeedAttributes = MoveSpeedAttributes()
	
		override val jumpHeight: jumpHeightAttributes = jumpHeightAttributes()
	
		open class MoveSpeedAttributes : BaseGunAttributes.MovementAttributes.MoveSpeedAttributes() {
			override val aimingMovespeed: AimingMovespeedAttributes = AimingMovespeedAttributes()
	
			override val moveSpeed: MoveSpeedAttributes = MoveSpeedAttributes()
	
			open class AimingMovespeedAttributes : BaseGunAttributes.MovementAttributes.MoveSpeedAttributes.AimingMovespeedAttributes() 
	
			open class MoveSpeedAttributes : BaseGunAttributes.MovementAttributes.MoveSpeedAttributes.MoveSpeedAttributes() 
		}
	
		open class jumpHeightAttributes : BaseGunAttributes.MovementAttributes.jumpHeightAttributes() 
	}
	
	open class HeadsAttributes : BaseGunAttributes.HeadsAttributes() 
	
	open class OnHitAttributes : BaseGunAttributes.OnHitAttributes() {
		override val healOnHitForRapidfire: HealOnHitForRapidfireAttributes = HealOnHitForRapidfireAttributes()
	
		override val generateRageOnDamage: GenerateRageOnDamageAttributes = GenerateRageOnDamageAttributes()
	
		override val falling: FallingAttributes = FallingAttributes()
	
		open class HealOnHitForRapidfireAttributes : BaseGunAttributes.OnHitAttributes.HealOnHitForRapidfireAttributes() 
	
		open class GenerateRageOnDamageAttributes : BaseGunAttributes.OnHitAttributes.GenerateRageOnDamageAttributes() 
	
		open class FallingAttributes : BaseGunAttributes.OnHitAttributes.FallingAttributes() 
	}
	
	open class OnKillAttributes : BaseGunAttributes.OnKillAttributes() 
	
	open class ReloadingAttributes : BaseGunAttributes.ReloadingAttributes() 
	
	open class ResistanceAttributes : BaseGunAttributes.ResistanceAttributes() {
		override val dmgTakenFromCritReduced: DmgTakenFromCritReducedAttributes = DmgTakenFromCritReducedAttributes()
	
		override val dmgTakenFromFireReduced: DmgTakenFromFireReducedAttributes = DmgTakenFromFireReducedAttributes()
	
		override val dmgTakenFromBulletsReduced: DmgTakenFromBulletsReducedAttributes = DmgTakenFromBulletsReducedAttributes()
	
		override val vaccinator: VaccinatorAttributes = VaccinatorAttributes()
	
		open class DmgTakenFromCritReducedAttributes : BaseGunAttributes.ResistanceAttributes.DmgTakenFromCritReducedAttributes() 
	
		open class DmgTakenFromFireReducedAttributes : BaseGunAttributes.ResistanceAttributes.DmgTakenFromFireReducedAttributes() 
	
		open class DmgTakenFromBulletsReducedAttributes : BaseGunAttributes.ResistanceAttributes.DmgTakenFromBulletsReducedAttributes() 
	
		open class VaccinatorAttributes : BaseGunAttributes.ResistanceAttributes.VaccinatorAttributes() 
	}
	
	open class RevengeCritsAttributes : BaseGunAttributes.RevengeCritsAttributes() 
	
	open class StatusEffectsAttributes : BaseGunAttributes.StatusEffectsAttributes() 
	
	open class TauntingAttributes : BaseGunAttributes.TauntingAttributes() 
	
	open class SwapWeaponsAttributes : BaseGunAttributes.SwapWeaponsAttributes() {
		override val deploy: DeployAttributes = DeployAttributes()
	
		open class DeployAttributes : BaseGunAttributes.SwapWeaponsAttributes.DeployAttributes() 
	}
	
	open class WhenHitAttributes : BaseGunAttributes.WhenHitAttributes() 
	
	open class RagdollsAttributes : BaseGunAttributes.RagdollsAttributes() 
	
	open class BuffItemsAttributes : BaseGunAttributes.BuffItemsAttributes() 
	
	open class CloakAttributes : BaseGunAttributes.CloakAttributes() 
	
	open class DisguiseAttributes : BaseGunAttributes.DisguiseAttributes() 
	
	open class HudAttributes : BaseGunAttributes.HudAttributes() 
	
	open class SpyOnlyAttributes : BaseGunAttributes.SpyOnlyAttributes() 
	
	object Inherited : StickybombLauncherAttributes 
}