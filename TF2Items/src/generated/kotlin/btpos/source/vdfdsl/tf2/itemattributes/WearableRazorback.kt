package btpos.source.vdfdsl.tf2.itemattributes

import btpos.source.vdfdsl.modeling.*
import btpos.source.vdfdsl.serialization.codecs.*
import btpos.source.vdfdsl.tf2.itemattributes.impl.*
import btpos.source.vdfdsl.tf2.tftypes.*
import java.util.*
import kotlin.time.Duration

interface WearableRazorbackAttributes : IBlockScoped, WearableAttributes {
	companion object : IBlockScoped {
		private val resistance: ResistanceAttributes = ResistanceAttributes()
	
		private val meta: MetaAttributes = MetaAttributes()
	
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

	override val resistance: ResistanceAttributes get() = WearableRazorbackAttributes.resistance
	
	override val meta: MetaAttributes get() = WearableRazorbackAttributes.meta
	
	override val ammo: AmmoAttributes get() = WearableRazorbackAttributes.ammo
	
	override val buffItems: BuffItemsAttributes get() = WearableRazorbackAttributes.buffItems
	
	override val buildings: BuildingsAttributes get() = WearableRazorbackAttributes.buildings
	
	override val cloak: CloakAttributes get() = WearableRazorbackAttributes.cloak
	
	override val damage: DamageAttributes get() = WearableRazorbackAttributes.damage
	
	override val demoCharge: DemoChargeAttributes get() = WearableRazorbackAttributes.demoCharge
	
	override val disguise: DisguiseAttributes get() = WearableRazorbackAttributes.disguise
	
	override val firing: FiringAttributes get() = WearableRazorbackAttributes.firing
	
	override val heads: HeadsAttributes get() = WearableRazorbackAttributes.heads
	
	override val healthAndHealing: HealthAndHealingAttributes get() = WearableRazorbackAttributes.healthAndHealing
	
	override val hud: HudAttributes get() = WearableRazorbackAttributes.hud
	
	override val knockbackReceived: KnockbackReceivedAttributes get() = WearableRazorbackAttributes.knockbackReceived
	
	override val meter: MeterAttributes get() = WearableRazorbackAttributes.meter
	
	override val movement: MovementAttributes get() = WearableRazorbackAttributes.movement
	
	override val onHit: OnHitAttributes get() = WearableRazorbackAttributes.onHit
	
	override val onKill: OnKillAttributes get() = WearableRazorbackAttributes.onKill
	
	override val taunting: TauntingAttributes get() = WearableRazorbackAttributes.taunting
	
	override val swapWeapons: SwapWeaponsAttributes get() = WearableRazorbackAttributes.swapWeapons
	
	override val whenHit: WhenHitAttributes get() = WearableRazorbackAttributes.whenHit
	
	override val spyOnly: SpyOnlyAttributes get() = WearableRazorbackAttributes.spyOnly
	
	override val crits: CritsAttributes get() = WearableRazorbackAttributes.crits

	open class ResistanceAttributes : WearableAttributes.ResistanceAttributes() {
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
	
	open class DemoChargeAttributes : WearableAttributes.DemoChargeAttributes() {
		override val multChargeTurnControl: MultChargeTurnControlAttributes = MultChargeTurnControlAttributes()
	
		open class MultChargeTurnControlAttributes : WearableAttributes.DemoChargeAttributes.MultChargeTurnControlAttributes() 
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
	
	object Inherited : WearableRazorbackAttributes 
}