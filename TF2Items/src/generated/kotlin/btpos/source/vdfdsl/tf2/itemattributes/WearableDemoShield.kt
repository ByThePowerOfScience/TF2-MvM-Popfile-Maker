package btpos.source.vdfdsl.tf2.itemattributes

import btpos.source.vdfdsl.modeling.*
import btpos.source.vdfdsl.serialization.codecs.*
import btpos.source.vdfdsl.tf2.itemattributes.impl.*
import btpos.source.vdfdsl.tf2.tftypes.*
import java.util.*
import kotlin.time.Duration

interface WearableDemoShieldAttributes : IBlockScoped, WearableAttributes {
	companion object : IBlockScoped {
		val demoCharge: DemoChargeAttributes = DemoChargeAttributes()
	
		val resistance: ResistanceAttributes = ResistanceAttributes()
	
		private val meta: MetaAttributes = MetaAttributes()
	
		private val ammo: AmmoAttributes = AmmoAttributes()
	
		private val buffItems: BuffItemsAttributes = BuffItemsAttributes()
	
		private val buildings: BuildingsAttributes = BuildingsAttributes()
	
		private val cloak: CloakAttributes = CloakAttributes()
	
		private val damage: DamageAttributes = DamageAttributes()
	
		private val disguise: DisguiseAttributes = DisguiseAttributes()
	
		private val firing: FiringAttributes = FiringAttributes()
	
		private val heads: HeadsAttributes = HeadsAttributes()
	
		private val healthAndHealing: HealthAndHealingAttributes = HealthAndHealingAttributes()
	
		private val hud: HudAttributes = HudAttributes()
	
		private val knockbackReceived: KnockbackReceivedAttributes = KnockbackReceivedAttributes()
	
		private val meter: MeterAttributes = MeterAttributes()
	
		private val movement: MovementAttributes = MovementAttributes()
	
		private val onHit: OnHitAttributes = OnHitAttributes()
	
		private val onKill: OnKillAttributes = OnKillAttributes()
	
		private val taunting: TauntingAttributes = TauntingAttributes()
	
		private val swapWeapons: SwapWeaponsAttributes = SwapWeaponsAttributes()
	
		private val whenHit: WhenHitAttributes = WhenHitAttributes()
	
		private val spyOnly: SpyOnlyAttributes = SpyOnlyAttributes()
	
		private val crits: CritsAttributes = CritsAttributes()
	}

	override val demoCharge: DemoChargeAttributes get() = WearableDemoShieldAttributes.demoCharge
	
	override val resistance: ResistanceAttributes get() = WearableDemoShieldAttributes.resistance
	
	override val meta: MetaAttributes get() = WearableDemoShieldAttributes.meta
	
	override val ammo: AmmoAttributes get() = WearableDemoShieldAttributes.ammo
	
	override val buffItems: BuffItemsAttributes get() = WearableDemoShieldAttributes.buffItems
	
	override val buildings: BuildingsAttributes get() = WearableDemoShieldAttributes.buildings
	
	override val cloak: CloakAttributes get() = WearableDemoShieldAttributes.cloak
	
	override val damage: DamageAttributes get() = WearableDemoShieldAttributes.damage
	
	override val disguise: DisguiseAttributes get() = WearableDemoShieldAttributes.disguise
	
	override val firing: FiringAttributes get() = WearableDemoShieldAttributes.firing
	
	override val heads: HeadsAttributes get() = WearableDemoShieldAttributes.heads
	
	override val healthAndHealing: HealthAndHealingAttributes get() = WearableDemoShieldAttributes.healthAndHealing
	
	override val hud: HudAttributes get() = WearableDemoShieldAttributes.hud
	
	override val knockbackReceived: KnockbackReceivedAttributes get() = WearableDemoShieldAttributes.knockbackReceived
	
	override val meter: MeterAttributes get() = WearableDemoShieldAttributes.meter
	
	override val movement: MovementAttributes get() = WearableDemoShieldAttributes.movement
	
	override val onHit: OnHitAttributes get() = WearableDemoShieldAttributes.onHit
	
	override val onKill: OnKillAttributes get() = WearableDemoShieldAttributes.onKill
	
	override val taunting: TauntingAttributes get() = WearableDemoShieldAttributes.taunting
	
	override val swapWeapons: SwapWeaponsAttributes get() = WearableDemoShieldAttributes.swapWeapons
	
	override val whenHit: WhenHitAttributes get() = WearableDemoShieldAttributes.whenHit
	
	override val spyOnly: SpyOnlyAttributes get() = WearableDemoShieldAttributes.spyOnly
	
	override val crits: CritsAttributes get() = WearableDemoShieldAttributes.crits

	open class DemoChargeAttributes : WearableAttributes.DemoChargeAttributes() {
		open val attackNotCancelCharge: ItemAttributeNamed<Boolean> = ItemAttributeNamed("Attack not cancel charge")
	
		override val chargeTime: VisHidden<Number> get() = super.chargeTime
	
		open val chargeImpactDamage: VisHidden<Number> = VisHidden(ItemAttributeNamed<Number>("charge impact damage increased"), ItemAttributeNamed<Number>("charge impact damage decreased"))
	
		override val multChargeTurnControl: MultChargeTurnControlAttributes = MultChargeTurnControlAttributes()
	
		open class MultChargeTurnControlAttributes : WearableAttributes.DemoChargeAttributes.MultChargeTurnControlAttributes() 
	}
	
	open class ResistanceAttributes : WearableAttributes.ResistanceAttributes() {
		/**
		 * In-Game: "Immune to the effects of afterburn."
		 */
		override val afterburnImmunity: ItemAttributeNamed<Boolean> get() = super.afterburnImmunity
	
		override val dmgTakenFromCritReduced: DmgTakenFromCritReducedAttributes = DmgTakenFromCritReducedAttributes()
	
		override val dmgTakenFromFireReduced: DmgTakenFromFireReducedAttributes = DmgTakenFromFireReducedAttributes()
	
		override val dmgTakenFromBulletsReduced: DmgTakenFromBulletsReducedAttributes = DmgTakenFromBulletsReducedAttributes()
	
		override val vaccinator: VaccinatorAttributes = VaccinatorAttributes()
	
		open class DmgTakenFromCritReducedAttributes : WearableAttributes.ResistanceAttributes.DmgTakenFromCritReducedAttributes() 
	
		open class DmgTakenFromFireReducedAttributes : WearableAttributes.ResistanceAttributes.DmgTakenFromFireReducedAttributes() 
	
		open class DmgTakenFromBulletsReducedAttributes : WearableAttributes.ResistanceAttributes.DmgTakenFromBulletsReducedAttributes() 
	
		open class VaccinatorAttributes : WearableAttributes.ResistanceAttributes.VaccinatorAttributes() 
	}
	
	open class MetaAttributes : WearableAttributes.MetaAttributes() {
		override val player: PlayerAttributes = PlayerAttributes()
	
		override val items: ItemsAttributes = ItemsAttributes()
	
		override val particles: ParticlesAttributes = ParticlesAttributes()
	
		override val killfeed: KillfeedAttributes = KillfeedAttributes()
	
		override val noisemakers: NoisemakersAttributes = NoisemakersAttributes()
	
		override val gameplay: GameplayAttributes = GameplayAttributes()
	
		open class PlayerAttributes : WearableAttributes.MetaAttributes.PlayerAttributes() 
	
		open class ItemsAttributes : WearableAttributes.MetaAttributes.ItemsAttributes() 
	
		open class ParticlesAttributes : WearableAttributes.MetaAttributes.ParticlesAttributes() 
	
		open class KillfeedAttributes : WearableAttributes.MetaAttributes.KillfeedAttributes() 
	
		open class NoisemakersAttributes : WearableAttributes.MetaAttributes.NoisemakersAttributes() 
	
		open class GameplayAttributes : WearableAttributes.MetaAttributes.GameplayAttributes() 
	}
	
	open class AmmoAttributes : WearableAttributes.AmmoAttributes() {
		override val maxAmmo: MaxAmmoAttributes = MaxAmmoAttributes()
	
		open class MaxAmmoAttributes : WearableAttributes.AmmoAttributes.MaxAmmoAttributes() 
	}
	
	open class BuffItemsAttributes : WearableAttributes.BuffItemsAttributes() 
	
	open class BuildingsAttributes : WearableAttributes.BuildingsAttributes() {
		override val sentryGun: SentryGunAttributes = SentryGunAttributes()
	
		override val dispenser: DispenserAttributes = DispenserAttributes()
	
		override val teleporter: TeleporterAttributes = TeleporterAttributes()
	
		open class SentryGunAttributes : WearableAttributes.BuildingsAttributes.SentryGunAttributes() 
	
		open class DispenserAttributes : WearableAttributes.BuildingsAttributes.DispenserAttributes() 
	
		open class TeleporterAttributes : WearableAttributes.BuildingsAttributes.TeleporterAttributes() 
	}
	
	open class CloakAttributes : WearableAttributes.CloakAttributes() 
	
	open class DamageAttributes : WearableAttributes.DamageAttributes() {
		override val alien: AlienAttributes = AlienAttributes()
	
		open class AlienAttributes : WearableAttributes.DamageAttributes.AlienAttributes() 
	}
	
	open class DisguiseAttributes : WearableAttributes.DisguiseAttributes() 
	
	open class FiringAttributes : WearableAttributes.FiringAttributes() 
	
	open class HeadsAttributes : WearableAttributes.HeadsAttributes() 
	
	open class HealthAndHealingAttributes : WearableAttributes.HealthAndHealingAttributes() {
		override val healthRegen: HealthRegenAttributes = HealthRegenAttributes()
	
		override val maxHealthAdditive: MaxHealthAdditiveAttributes = MaxHealthAdditiveAttributes()
	
		open class HealthRegenAttributes : WearableAttributes.HealthAndHealingAttributes.HealthRegenAttributes() 
	
		open class MaxHealthAdditiveAttributes : WearableAttributes.HealthAndHealingAttributes.MaxHealthAdditiveAttributes() 
	}
	
	open class HudAttributes : WearableAttributes.HudAttributes() 
	
	open class KnockbackReceivedAttributes : WearableAttributes.KnockbackReceivedAttributes() 
	
	open class MeterAttributes : WearableAttributes.MeterAttributes() {
		override val generateRageOnDamage: GenerateRageOnDamageAttributes = GenerateRageOnDamageAttributes()
	
		open class GenerateRageOnDamageAttributes : WearableAttributes.MeterAttributes.GenerateRageOnDamageAttributes() 
	}
	
	open class MovementAttributes : WearableAttributes.MovementAttributes() {
		override val jumpHeight: jumpHeightAttributes = jumpHeightAttributes()
	
		override val moveSpeed: MoveSpeedAttributes = MoveSpeedAttributes()
	
		open class jumpHeightAttributes : WearableAttributes.MovementAttributes.jumpHeightAttributes() 
	
		open class MoveSpeedAttributes : WearableAttributes.MovementAttributes.MoveSpeedAttributes() {
			override val aimingMovespeed: AimingMovespeedAttributes = AimingMovespeedAttributes()
	
			override val moveSpeed: MoveSpeedAttributes = MoveSpeedAttributes()
	
			open class AimingMovespeedAttributes : WearableAttributes.MovementAttributes.MoveSpeedAttributes.AimingMovespeedAttributes() 
	
			open class MoveSpeedAttributes : WearableAttributes.MovementAttributes.MoveSpeedAttributes.MoveSpeedAttributes() 
		}
	}
	
	open class OnHitAttributes : WearableAttributes.OnHitAttributes() {
		override val falling: FallingAttributes = FallingAttributes()
	
		open class FallingAttributes : WearableAttributes.OnHitAttributes.FallingAttributes() 
	}
	
	open class OnKillAttributes : WearableAttributes.OnKillAttributes() 
	
	open class TauntingAttributes : WearableAttributes.TauntingAttributes() 
	
	open class SwapWeaponsAttributes : WearableAttributes.SwapWeaponsAttributes() 
	
	open class WhenHitAttributes : WearableAttributes.WhenHitAttributes() 
	
	open class SpyOnlyAttributes : WearableAttributes.SpyOnlyAttributes() 
	
	open class CritsAttributes : WearableAttributes.CritsAttributes() 
	
	object Inherited : WearableDemoShieldAttributes 
}