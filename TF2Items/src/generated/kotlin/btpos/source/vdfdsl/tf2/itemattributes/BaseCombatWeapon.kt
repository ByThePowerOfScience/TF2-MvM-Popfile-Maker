package btpos.source.vdfdsl.tf2.itemattributes

import btpos.source.vdfdsl.modeling.*
import btpos.source.vdfdsl.serialization.codecs.*
import btpos.source.vdfdsl.tf2.itemattributes.impl.*
import btpos.source.vdfdsl.tf2.tftypes.*
import java.util.*
import kotlin.time.Duration

interface BaseCombatWeaponAttributes : IBlockScoped, EconEntityAttributes {
	companion object : IBlockScoped {
		val ammo: AmmoAttributes = AmmoAttributes()
	
		private val meta: MetaAttributes = MetaAttributes()
	
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
	
		private val resistance: ResistanceAttributes = ResistanceAttributes()
	
		private val taunting: TauntingAttributes = TauntingAttributes()
	
		private val swapWeapons: SwapWeaponsAttributes = SwapWeaponsAttributes()
	
		private val whenHit: WhenHitAttributes = WhenHitAttributes()
	
		private val spyOnly: SpyOnlyAttributes = SpyOnlyAttributes()
	
		private val crits: CritsAttributes = CritsAttributes()
	}

	override val ammo: AmmoAttributes get() = BaseCombatWeaponAttributes.ammo
	
	override val meta: MetaAttributes get() = BaseCombatWeaponAttributes.meta
	
	override val buffItems: BuffItemsAttributes get() = BaseCombatWeaponAttributes.buffItems
	
	override val buildings: BuildingsAttributes get() = BaseCombatWeaponAttributes.buildings
	
	override val cloak: CloakAttributes get() = BaseCombatWeaponAttributes.cloak
	
	override val damage: DamageAttributes get() = BaseCombatWeaponAttributes.damage
	
	override val demoCharge: DemoChargeAttributes get() = BaseCombatWeaponAttributes.demoCharge
	
	override val disguise: DisguiseAttributes get() = BaseCombatWeaponAttributes.disguise
	
	override val firing: FiringAttributes get() = BaseCombatWeaponAttributes.firing
	
	override val heads: HeadsAttributes get() = BaseCombatWeaponAttributes.heads
	
	override val healthAndHealing: HealthAndHealingAttributes get() = BaseCombatWeaponAttributes.healthAndHealing
	
	override val hud: HudAttributes get() = BaseCombatWeaponAttributes.hud
	
	override val knockbackReceived: KnockbackReceivedAttributes get() = BaseCombatWeaponAttributes.knockbackReceived
	
	override val meter: MeterAttributes get() = BaseCombatWeaponAttributes.meter
	
	override val movement: MovementAttributes get() = BaseCombatWeaponAttributes.movement
	
	override val onHit: OnHitAttributes get() = BaseCombatWeaponAttributes.onHit
	
	override val onKill: OnKillAttributes get() = BaseCombatWeaponAttributes.onKill
	
	override val resistance: ResistanceAttributes get() = BaseCombatWeaponAttributes.resistance
	
	override val taunting: TauntingAttributes get() = BaseCombatWeaponAttributes.taunting
	
	override val swapWeapons: SwapWeaponsAttributes get() = BaseCombatWeaponAttributes.swapWeapons
	
	override val whenHit: WhenHitAttributes get() = BaseCombatWeaponAttributes.whenHit
	
	override val spyOnly: SpyOnlyAttributes get() = BaseCombatWeaponAttributes.spyOnly
	
	override val crits: CritsAttributes get() = BaseCombatWeaponAttributes.crits

	open class AmmoAttributes : EconEntityAttributes.AmmoAttributes() {
		/**
		 * In-Game: "Uses metal for ammo"
		 * 
		 * Reminder: non-engies start with 100 metal.
		 */
		open val useMetalAmmoType: ItemAttributeNamed<Boolean> = ItemAttributeNamed("mod use metal ammo type")
	
		/**
		 * In-Game: "No reload necessary"
		 * 
		 * In the "DoesReloadSingly" check, this _is_ actually checked, so it's actually _not_ "display-only".
		 * 
		 * If != 1.0 (if present), says the weapon "does not reload one shot at a time".
		 */
		open val noReload_displayOnly: ItemAttributeNamed<Number> = ItemAttributeNamed("mod no reload DISPLAY ONLY")
	
		/**
		 * Checked in `DoesReloadSingly`. If true, weapon does not reload one shot at a time. (e.g. FaN).
		 * 
		 * Note that for the most part, this logic is set inside the weapon itself. The scattergun attribute is the only way to control this with attributes.
		 */
		open val scattergunNoReloadSingle: ItemAttributeNamed<Boolean> = ItemAttributeNamed("scattergun no reload single")
	
		open val clipSize: ClipSizeAttributes = ClipSizeAttributes()
	
		override val maxAmmo: MaxAmmoAttributes = MaxAmmoAttributes()
	
		open class ClipSizeAttributes : IBlockScoped {
			/**
			 * Overwrites the max clipsize to a flat value. Applied before other multipliers.
			 */
			open val maxPrimaryClipOverride: ItemAttributeNamed<Int> = ItemAttributeNamed("mod max primary clip override")
		}
	
		open class MaxAmmoAttributes : EconEntityAttributes.AmmoAttributes.MaxAmmoAttributes() 
	}
	
	open class MetaAttributes : EconEntityAttributes.MetaAttributes() {
		override val items: ItemsAttributes = ItemsAttributes()
	
		override val particles: ParticlesAttributes = ParticlesAttributes()
	
		override val killfeed: KillfeedAttributes = KillfeedAttributes()
	
		override val noisemakers: NoisemakersAttributes = NoisemakersAttributes()
	
		override val player: PlayerAttributes = PlayerAttributes()
	
		override val gameplay: GameplayAttributes = GameplayAttributes()
	
		open class ItemsAttributes : EconEntityAttributes.MetaAttributes.ItemsAttributes() 
	
		open class ParticlesAttributes : EconEntityAttributes.MetaAttributes.ParticlesAttributes() 
	
		open class KillfeedAttributes : EconEntityAttributes.MetaAttributes.KillfeedAttributes() 
	
		open class NoisemakersAttributes : EconEntityAttributes.MetaAttributes.NoisemakersAttributes() 
	
		open class PlayerAttributes : EconEntityAttributes.MetaAttributes.PlayerAttributes() 
	
		open class GameplayAttributes : EconEntityAttributes.MetaAttributes.GameplayAttributes() 
	}
	
	open class BuffItemsAttributes : EconEntityAttributes.BuffItemsAttributes() 
	
	open class BuildingsAttributes : EconEntityAttributes.BuildingsAttributes() {
		override val sentryGun: SentryGunAttributes = SentryGunAttributes()
	
		override val dispenser: DispenserAttributes = DispenserAttributes()
	
		override val teleporter: TeleporterAttributes = TeleporterAttributes()
	
		open class SentryGunAttributes : EconEntityAttributes.BuildingsAttributes.SentryGunAttributes() 
	
		open class DispenserAttributes : EconEntityAttributes.BuildingsAttributes.DispenserAttributes() 
	
		open class TeleporterAttributes : EconEntityAttributes.BuildingsAttributes.TeleporterAttributes() 
	}
	
	open class CloakAttributes : EconEntityAttributes.CloakAttributes() 
	
	open class DamageAttributes : EconEntityAttributes.DamageAttributes() {
		override val alien: AlienAttributes = AlienAttributes()
	
		open class AlienAttributes : EconEntityAttributes.DamageAttributes.AlienAttributes() 
	}
	
	open class DemoChargeAttributes : EconEntityAttributes.DemoChargeAttributes() {
		override val multChargeTurnControl: MultChargeTurnControlAttributes = MultChargeTurnControlAttributes()
	
		open class MultChargeTurnControlAttributes : EconEntityAttributes.DemoChargeAttributes.MultChargeTurnControlAttributes() 
	}
	
	open class DisguiseAttributes : EconEntityAttributes.DisguiseAttributes() 
	
	open class FiringAttributes : EconEntityAttributes.FiringAttributes() 
	
	open class HeadsAttributes : EconEntityAttributes.HeadsAttributes() 
	
	open class HealthAndHealingAttributes : EconEntityAttributes.HealthAndHealingAttributes() {
		override val healthRegen: HealthRegenAttributes = HealthRegenAttributes()
	
		override val maxHealthAdditive: MaxHealthAdditiveAttributes = MaxHealthAdditiveAttributes()
	
		open class HealthRegenAttributes : EconEntityAttributes.HealthAndHealingAttributes.HealthRegenAttributes() 
	
		open class MaxHealthAdditiveAttributes : EconEntityAttributes.HealthAndHealingAttributes.MaxHealthAdditiveAttributes() 
	}
	
	open class HudAttributes : EconEntityAttributes.HudAttributes() 
	
	open class KnockbackReceivedAttributes : EconEntityAttributes.KnockbackReceivedAttributes() 
	
	open class MeterAttributes : EconEntityAttributes.MeterAttributes() {
		override val generateRageOnDamage: GenerateRageOnDamageAttributes = GenerateRageOnDamageAttributes()
	
		open class GenerateRageOnDamageAttributes : EconEntityAttributes.MeterAttributes.GenerateRageOnDamageAttributes() 
	}
	
	open class MovementAttributes : EconEntityAttributes.MovementAttributes() {
		override val jumpHeight: jumpHeightAttributes = jumpHeightAttributes()
	
		override val moveSpeed: MoveSpeedAttributes = MoveSpeedAttributes()
	
		open class jumpHeightAttributes : EconEntityAttributes.MovementAttributes.jumpHeightAttributes() 
	
		open class MoveSpeedAttributes : EconEntityAttributes.MovementAttributes.MoveSpeedAttributes() {
			override val aimingMovespeed: AimingMovespeedAttributes = AimingMovespeedAttributes()
	
			override val moveSpeed: MoveSpeedAttributes = MoveSpeedAttributes()
	
			open class AimingMovespeedAttributes : EconEntityAttributes.MovementAttributes.MoveSpeedAttributes.AimingMovespeedAttributes() 
	
			open class MoveSpeedAttributes : EconEntityAttributes.MovementAttributes.MoveSpeedAttributes.MoveSpeedAttributes() 
		}
	}
	
	open class OnHitAttributes : EconEntityAttributes.OnHitAttributes() {
		override val falling: FallingAttributes = FallingAttributes()
	
		open class FallingAttributes : EconEntityAttributes.OnHitAttributes.FallingAttributes() 
	}
	
	open class OnKillAttributes : EconEntityAttributes.OnKillAttributes() 
	
	open class ResistanceAttributes : EconEntityAttributes.ResistanceAttributes() {
		override val dmgTakenFromCritReduced: DmgTakenFromCritReducedAttributes = DmgTakenFromCritReducedAttributes()
	
		override val dmgTakenFromFireReduced: DmgTakenFromFireReducedAttributes = DmgTakenFromFireReducedAttributes()
	
		override val dmgTakenFromBulletsReduced: DmgTakenFromBulletsReducedAttributes = DmgTakenFromBulletsReducedAttributes()
	
		override val vaccinator: VaccinatorAttributes = VaccinatorAttributes()
	
		open class DmgTakenFromCritReducedAttributes : EconEntityAttributes.ResistanceAttributes.DmgTakenFromCritReducedAttributes() 
	
		open class DmgTakenFromFireReducedAttributes : EconEntityAttributes.ResistanceAttributes.DmgTakenFromFireReducedAttributes() 
	
		open class DmgTakenFromBulletsReducedAttributes : EconEntityAttributes.ResistanceAttributes.DmgTakenFromBulletsReducedAttributes() 
	
		open class VaccinatorAttributes : EconEntityAttributes.ResistanceAttributes.VaccinatorAttributes() 
	}
	
	open class TauntingAttributes : EconEntityAttributes.TauntingAttributes() 
	
	open class SwapWeaponsAttributes : EconEntityAttributes.SwapWeaponsAttributes() 
	
	open class WhenHitAttributes : EconEntityAttributes.WhenHitAttributes() 
	
	open class SpyOnlyAttributes : EconEntityAttributes.SpyOnlyAttributes() 
	
	open class CritsAttributes : EconEntityAttributes.CritsAttributes() 
	
	object Inherited : BaseCombatWeaponAttributes 
}