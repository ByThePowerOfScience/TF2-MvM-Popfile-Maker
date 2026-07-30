package btpos.source.vdfdsl.tf2.itemattributes

import btpos.source.vdfdsl.modeling.*
import btpos.source.vdfdsl.serialization.codecs.*
import btpos.source.vdfdsl.tf2.itemattributes.impl.*
import btpos.source.vdfdsl.tf2.tftypes.*
import java.util.*



interface MvMBotAttributes : PlayerAttributes {
	companion object {
		/**
		 * If true, spawns a rocketjump particle whenever the robot jumps.
		 */
		val customJumpParticle: ItemAttributeNamed<Boolean> = ItemAttributeNamed("bot custom jump particle")
	
		/**
		 * Defaults to 50, I guess it's a percentage.
		 */
		val medicUberHealthThreshold: ItemAttributeNamed<Int> = ItemAttributeNamed("bot medic uber health threshold")
	
		/**
		 * Defaults to -1.
		 */
		val medicUberDeployDelayDuration: ItemAttributeNamed<Int> = ItemAttributeNamed("bot medic uber deploy delay duration")
	
		val ammo: AmmoAttributes = AmmoAttributes()
	
		val buffItems: BuffItemsAttributes = BuffItemsAttributes()
	
		private val buildings: BuildingsAttributes = BuildingsAttributes()
	
		val cloak: CloakAttributes = CloakAttributes()
	
		val damage: DamageAttributes = DamageAttributes()
	
		val demoCharge: DemoChargeAttributes = DemoChargeAttributes()
	
		val disguise: DisguiseAttributes = DisguiseAttributes()
	
		val firing: FiringAttributes = FiringAttributes()
	
		private val healthAndHealing: HealthAndHealingAttributes = HealthAndHealingAttributes()
	
		private val hud: HudAttributes = HudAttributes()
	
		val knockbackReceived: KnockbackReceivedAttributes = KnockbackReceivedAttributes()
	
		private val meta: MetaAttributes = MetaAttributes()
	
		private val meter: MeterAttributes = MeterAttributes()
	
		private val movement: MovementAttributes = MovementAttributes()
	
		val onHit: OnHitAttributes = OnHitAttributes()
	
		val onKill: OnKillAttributes = OnKillAttributes()
	
		private val resistance: ResistanceAttributes = ResistanceAttributes()
	
		val taunting: TauntingAttributes = TauntingAttributes()
	
		val swapWeapons: SwapWeaponsAttributes = SwapWeaponsAttributes()
	
		val whenHit: WhenHitAttributes = WhenHitAttributes()
	
		val heavyOnly: HeavyOnlyAttributes = HeavyOnlyAttributes()
	
		val sniperOnly: SniperOnlyAttributes = SniperOnlyAttributes()
	
		val medicOnly: MedicOnlyAttributes = MedicOnlyAttributes()
	
		val spyOnly: SpyOnlyAttributes = SpyOnlyAttributes()
	}

	/**
	 * If true, spawns a rocketjump particle whenever the robot jumps.
	 */
	val customJumpParticle: ItemAttributeNamed<Boolean> get() = MvMBotAttributes.customJumpParticle
	
	/**
	 * Defaults to 50, I guess it's a percentage.
	 */
	val medicUberHealthThreshold: ItemAttributeNamed<Int> get() = MvMBotAttributes.medicUberHealthThreshold
	
	/**
	 * Defaults to -1.
	 */
	val medicUberDeployDelayDuration: ItemAttributeNamed<Int> get() = MvMBotAttributes.medicUberDeployDelayDuration
	
	override val ammo: AmmoAttributes get() = MvMBotAttributes.ammo
	
	override val buffItems: BuffItemsAttributes get() = MvMBotAttributes.buffItems
	
	override val buildings: BuildingsAttributes get() = MvMBotAttributes.buildings
	
	override val cloak: CloakAttributes get() = MvMBotAttributes.cloak
	
	override val damage: DamageAttributes get() = MvMBotAttributes.damage
	
	override val demoCharge: DemoChargeAttributes get() = MvMBotAttributes.demoCharge
	
	override val disguise: DisguiseAttributes get() = MvMBotAttributes.disguise
	
	override val firing: FiringAttributes get() = MvMBotAttributes.firing
	
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
	
	override val heavyOnly: HeavyOnlyAttributes get() = MvMBotAttributes.heavyOnly
	
	override val sniperOnly: SniperOnlyAttributes get() = MvMBotAttributes.sniperOnly
	
	override val medicOnly: MedicOnlyAttributes get() = MvMBotAttributes.medicOnly
	
	override val spyOnly: SpyOnlyAttributes get() = MvMBotAttributes.spyOnly

	open class AmmoAttributes : PlayerAttributes.AmmoAttributes() {
		override val maxAmmo: MaxAmmoAttributes = MaxAmmoAttributes()
	
		open class MaxAmmoAttributes : PlayerAttributes.AmmoAttributes.MaxAmmoAttributes() 
	}
	
	open class BuffItemsAttributes : PlayerAttributes.BuffItemsAttributes() {
		override val buffType: BuffTypeAttributes = BuffTypeAttributes()
	
		open class BuffTypeAttributes : PlayerAttributes.BuffItemsAttributes.BuffTypeAttributes() 
	}
	
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
	
		open class KillfeedAttributes : PlayerAttributes.MetaAttributes.KillfeedAttributes() 
	
		open class NoisemakersAttributes : PlayerAttributes.MetaAttributes.NoisemakersAttributes() 
	
		open class ItemsAttributes : PlayerAttributes.MetaAttributes.ItemsAttributes() 
	
		open class PlayerAttributes : PlayerAttributes.MetaAttributes.PlayerAttributes() 
	
		open class GameplayAttributes : PlayerAttributes.MetaAttributes.GameplayAttributes() 
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
	
	open class HeavyOnlyAttributes : PlayerAttributes.HeavyOnlyAttributes() {
		override val generateRageOnDamage: GenerateRageOnDamageAttributes = GenerateRageOnDamageAttributes()
	
		open class GenerateRageOnDamageAttributes : PlayerAttributes.HeavyOnlyAttributes.GenerateRageOnDamageAttributes() 
	}
	
	open class SniperOnlyAttributes : PlayerAttributes.SniperOnlyAttributes() 
	
	open class MedicOnlyAttributes : PlayerAttributes.MedicOnlyAttributes() 
	
	open class SpyOnlyAttributes : PlayerAttributes.SpyOnlyAttributes() 
}