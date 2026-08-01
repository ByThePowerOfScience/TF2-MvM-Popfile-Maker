package btpos.source.vdfdsl.tf2.itemattributes

import btpos.source.vdfdsl.modeling.*
import btpos.source.vdfdsl.serialization.codecs.*
import btpos.source.vdfdsl.tf2.itemattributes.impl.*
import btpos.source.vdfdsl.tf2.tftypes.*
import java.util.*
import kotlin.time.Duration

interface MvMBotAttributes : PlayerAttributes {
	companion object : IBlockScoped {
		private val ammo: AmmoAttributes = AmmoAttributes()
	
		private val buffItems: BuffItemsAttributes = BuffItemsAttributes()
	
		private val buildings: BuildingsAttributes = BuildingsAttributes()
	
		private val cloak: CloakAttributes = CloakAttributes()
	
		private val damage: DamageAttributes = DamageAttributes()
	
		private val demoCharge: DemoChargeAttributes = DemoChargeAttributes()
	
		private val disguise: DisguiseAttributes = DisguiseAttributes()
	
		private val firing: FiringAttributes = FiringAttributes()
	
		private val heads: HeadsAttributes = HeadsAttributes()
	
		private val healthAndHealing: HealthAndHealingAttributes = HealthAndHealingAttributes()
	
		private val hud: HudAttributes = HudAttributes()
	
		private val knockbackReceived: KnockbackReceivedAttributes = KnockbackReceivedAttributes()
	
		private val meta: MetaAttributes = MetaAttributes()
	
		private val meter: MeterAttributes = MeterAttributes()
	
		private val movement: MovementAttributes = MovementAttributes()
	
		private val onHit: OnHitAttributes = OnHitAttributes()
	
		private val onKill: OnKillAttributes = OnKillAttributes()
	
		private val resistance: ResistanceAttributes = ResistanceAttributes()
	
		private val taunting: TauntingAttributes = TauntingAttributes()
	
		private val swapWeapons: SwapWeaponsAttributes = SwapWeaponsAttributes()
	
		private val whenHit: WhenHitAttributes = WhenHitAttributes()
	
		private val spyOnly: SpyOnlyAttributes = SpyOnlyAttributes()
	
		private val crits: CritsAttributes = CritsAttributes()
	}

	/**
	 * If true, spawns a rocketjump particle whenever the robot jumps.
	 */
	val customJumpParticle: ItemAttributeNamed<Boolean> get() = MvMBotAttributes.customJumpParticle.get()
	
	/**
	 * Defaults to 50, I guess it's a percentage.
	 */
	val medicUberHealthThreshold: ItemAttributeNamed<Int> get() = MvMBotAttributes.medicUberHealthThreshold.get()
	
	/**
	 * Defaults to -1.
	 */
	val medicUberDeployDelayDuration: ItemAttributeNamed<Int> get() = MvMBotAttributes.medicUberDeployDelayDuration.get()
	
	override val ammo: AmmoAttributes get() = MvMBotAttributes.ammo
	
	override val buffItems: BuffItemsAttributes get() = MvMBotAttributes.buffItems
	
	override val buildings: BuildingsAttributes get() = MvMBotAttributes.buildings
	
	override val cloak: CloakAttributes get() = MvMBotAttributes.cloak
	
	override val damage: DamageAttributes get() = MvMBotAttributes.damage
	
	override val demoCharge: DemoChargeAttributes get() = MvMBotAttributes.demoCharge
	
	override val disguise: DisguiseAttributes get() = MvMBotAttributes.disguise
	
	override val firing: FiringAttributes get() = MvMBotAttributes.firing
	
	override val heads: HeadsAttributes get() = MvMBotAttributes.heads
	
	override val healthAndHealing: HealthAndHealingAttributes get() = MvMBotAttributes.healthAndHealing
	
	override val hud: HudAttributes get() = MvMBotAttributes.hud
	
	override val knockbackReceived: KnockbackReceivedAttributes get() = MvMBotAttributes.knockbackReceived
	
	override val meta: MetaAttributes get() = MvMBotAttributes.meta
	
	override val meter: MeterAttributes get() = MvMBotAttributes.meter
	
	override val movement: MovementAttributes get() = MvMBotAttributes.movement
	
	override val onHit: OnHitAttributes get() = MvMBotAttributes.onHit
	
	override val onKill: OnKillAttributes get() = MvMBotAttributes.onKill
	
	override val resistance: ResistanceAttributes get() = MvMBotAttributes.resistance
	
	override val taunting: TauntingAttributes get() = MvMBotAttributes.taunting
	
	override val swapWeapons: SwapWeaponsAttributes get() = MvMBotAttributes.swapWeapons
	
	override val whenHit: WhenHitAttributes get() = MvMBotAttributes.whenHit
	
	override val spyOnly: SpyOnlyAttributes get() = MvMBotAttributes.spyOnly
	
	override val crits: CritsAttributes get() = MvMBotAttributes.crits

	open class AmmoAttributes : PlayerAttributes.AmmoAttributes() {
		override val maxAmmo: MaxAmmoAttributes = MaxAmmoAttributes()
	
		open class MaxAmmoAttributes : PlayerAttributes.AmmoAttributes.MaxAmmoAttributes() 
	}
	
	open class BuffItemsAttributes : PlayerAttributes.BuffItemsAttributes() 
	
	open class BuildingsAttributes : PlayerAttributes.BuildingsAttributes() {
		override val sentryGun: SentryGunAttributes = SentryGunAttributes()
	
		override val dispenser: DispenserAttributes = DispenserAttributes()
	
		override val teleporter: TeleporterAttributes = TeleporterAttributes()
	
		open class SentryGunAttributes : PlayerAttributes.BuildingsAttributes.SentryGunAttributes() 
	
		open class DispenserAttributes : PlayerAttributes.BuildingsAttributes.DispenserAttributes() 
	
		open class TeleporterAttributes : PlayerAttributes.BuildingsAttributes.TeleporterAttributes() 
	}
	
	open class CloakAttributes : PlayerAttributes.CloakAttributes() 
	
	open class DamageAttributes : PlayerAttributes.DamageAttributes() {
		override val alien: AlienAttributes = AlienAttributes()
	
		open class AlienAttributes : PlayerAttributes.DamageAttributes.AlienAttributes() 
	}
	
	open class DemoChargeAttributes : PlayerAttributes.DemoChargeAttributes() {
		override val multChargeTurnControl: MultChargeTurnControlAttributes = MultChargeTurnControlAttributes()
	
		open class MultChargeTurnControlAttributes : PlayerAttributes.DemoChargeAttributes.MultChargeTurnControlAttributes() 
	}
	
	open class DisguiseAttributes : PlayerAttributes.DisguiseAttributes() 
	
	open class FiringAttributes : PlayerAttributes.FiringAttributes() 
	
	open class HeadsAttributes : PlayerAttributes.HeadsAttributes() 
	
	open class HealthAndHealingAttributes : PlayerAttributes.HealthAndHealingAttributes() {
		override val healthRegen: HealthRegenAttributes = HealthRegenAttributes()
	
		override val maxHealthAdditive: MaxHealthAdditiveAttributes = MaxHealthAdditiveAttributes()
	
		open class HealthRegenAttributes : PlayerAttributes.HealthAndHealingAttributes.HealthRegenAttributes() 
	
		open class MaxHealthAdditiveAttributes : PlayerAttributes.HealthAndHealingAttributes.MaxHealthAdditiveAttributes() 
	}
	
	open class HudAttributes : PlayerAttributes.HudAttributes() 
	
	open class KnockbackReceivedAttributes : PlayerAttributes.KnockbackReceivedAttributes() 
	
	open class MetaAttributes : PlayerAttributes.MetaAttributes() {
		override val killfeed: KillfeedAttributes = KillfeedAttributes()
	
		override val noisemakers: NoisemakersAttributes = NoisemakersAttributes()
	
		override val items: ItemsAttributes = ItemsAttributes()
	
		override val player: PlayerAttributes = PlayerAttributes()
	
		override val gameplay: GameplayAttributes = GameplayAttributes()
	
		override val particles: ParticlesAttributes = ParticlesAttributes()
	
		open class KillfeedAttributes : PlayerAttributes.MetaAttributes.KillfeedAttributes() 
	
		open class NoisemakersAttributes : PlayerAttributes.MetaAttributes.NoisemakersAttributes() 
	
		open class ItemsAttributes : PlayerAttributes.MetaAttributes.ItemsAttributes() 
	
		open class PlayerAttributes : PlayerAttributes.MetaAttributes.PlayerAttributes() 
	
		open class GameplayAttributes : PlayerAttributes.MetaAttributes.GameplayAttributes() 
	
		open class ParticlesAttributes : PlayerAttributes.MetaAttributes.ParticlesAttributes() 
	}
	
	open class MeterAttributes : PlayerAttributes.MeterAttributes() {
		override val generateRageOnDamage: GenerateRageOnDamageAttributes = GenerateRageOnDamageAttributes()
	
		open class GenerateRageOnDamageAttributes : PlayerAttributes.MeterAttributes.GenerateRageOnDamageAttributes() 
	}
	
	open class MovementAttributes : PlayerAttributes.MovementAttributes() {
		override val jumpHeight: jumpHeightAttributes = jumpHeightAttributes()
	
		override val moveSpeed: MoveSpeedAttributes = MoveSpeedAttributes()
	
		open class jumpHeightAttributes : PlayerAttributes.MovementAttributes.jumpHeightAttributes() 
	
		open class MoveSpeedAttributes : PlayerAttributes.MovementAttributes.MoveSpeedAttributes() {
			override val aimingMovespeed: AimingMovespeedAttributes = AimingMovespeedAttributes()
	
			override val moveSpeed: MoveSpeedAttributes = MoveSpeedAttributes()
	
			open class AimingMovespeedAttributes : PlayerAttributes.MovementAttributes.MoveSpeedAttributes.AimingMovespeedAttributes() 
	
			open class MoveSpeedAttributes : PlayerAttributes.MovementAttributes.MoveSpeedAttributes.MoveSpeedAttributes() 
		}
	}
	
	open class OnHitAttributes : PlayerAttributes.OnHitAttributes() {
		override val falling: FallingAttributes = FallingAttributes()
	
		open class FallingAttributes : PlayerAttributes.OnHitAttributes.FallingAttributes() 
	}
	
	open class OnKillAttributes : PlayerAttributes.OnKillAttributes() 
	
	open class ResistanceAttributes : PlayerAttributes.ResistanceAttributes() {
		override val dmgTakenFromCritReduced: DmgTakenFromCritReducedAttributes = DmgTakenFromCritReducedAttributes()
	
		override val dmgTakenFromFireReduced: DmgTakenFromFireReducedAttributes = DmgTakenFromFireReducedAttributes()
	
		override val dmgTakenFromBulletsReduced: DmgTakenFromBulletsReducedAttributes = DmgTakenFromBulletsReducedAttributes()
	
		override val vaccinator: VaccinatorAttributes = VaccinatorAttributes()
	
		open class DmgTakenFromCritReducedAttributes : PlayerAttributes.ResistanceAttributes.DmgTakenFromCritReducedAttributes() 
	
		open class DmgTakenFromFireReducedAttributes : PlayerAttributes.ResistanceAttributes.DmgTakenFromFireReducedAttributes() 
	
		open class DmgTakenFromBulletsReducedAttributes : PlayerAttributes.ResistanceAttributes.DmgTakenFromBulletsReducedAttributes() 
	
		open class VaccinatorAttributes : PlayerAttributes.ResistanceAttributes.VaccinatorAttributes() 
	}
	
	open class TauntingAttributes : PlayerAttributes.TauntingAttributes() 
	
	open class SwapWeaponsAttributes : PlayerAttributes.SwapWeaponsAttributes() 
	
	open class WhenHitAttributes : PlayerAttributes.WhenHitAttributes() 
	
	open class SpyOnlyAttributes : PlayerAttributes.SpyOnlyAttributes() 
	
	open class CritsAttributes : PlayerAttributes.CritsAttributes() 
}