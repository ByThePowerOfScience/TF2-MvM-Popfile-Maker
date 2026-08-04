package btpos.source.vdfdsl.tf2.itemattributes

import btpos.source.vdfdsl.modeling.*
import btpos.source.vdfdsl.serialization.codecs.*
import btpos.source.vdfdsl.tf2.itemattributes.impl.*
import btpos.source.vdfdsl.tf2.tftypes.*
import java.util.*
import kotlin.time.Duration

interface WearableAttributes : IBlockScoped, EconEntityAttributes {
	companion object : IBlockScoped {
		val resistance: ResistanceAttributes = ResistanceAttributes()
	
		val meta: MetaAttributes = MetaAttributes()
	
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

	override val resistance: ResistanceAttributes get() = WearableAttributes.resistance
	
	override val meta: MetaAttributes get() = WearableAttributes.meta
	
	override val ammo: AmmoAttributes get() = WearableAttributes.ammo
	
	override val buffItems: BuffItemsAttributes get() = WearableAttributes.buffItems
	
	override val buildings: BuildingsAttributes get() = WearableAttributes.buildings
	
	override val cloak: CloakAttributes get() = WearableAttributes.cloak
	
	override val damage: DamageAttributes get() = WearableAttributes.damage
	
	override val demoCharge: DemoChargeAttributes get() = WearableAttributes.demoCharge
	
	override val disguise: DisguiseAttributes get() = WearableAttributes.disguise
	
	override val firing: FiringAttributes get() = WearableAttributes.firing
	
	override val heads: HeadsAttributes get() = WearableAttributes.heads
	
	override val healthAndHealing: HealthAndHealingAttributes get() = WearableAttributes.healthAndHealing
	
	override val hud: HudAttributes get() = WearableAttributes.hud
	
	override val knockbackReceived: KnockbackReceivedAttributes get() = WearableAttributes.knockbackReceived
	
	override val meter: MeterAttributes get() = WearableAttributes.meter
	
	override val movement: MovementAttributes get() = WearableAttributes.movement
	
	override val onHit: OnHitAttributes get() = WearableAttributes.onHit
	
	override val onKill: OnKillAttributes get() = WearableAttributes.onKill
	
	override val taunting: TauntingAttributes get() = WearableAttributes.taunting
	
	override val swapWeapons: SwapWeaponsAttributes get() = WearableAttributes.swapWeapons
	
	override val whenHit: WhenHitAttributes get() = WearableAttributes.whenHit
	
	override val spyOnly: SpyOnlyAttributes get() = WearableAttributes.spyOnly
	
	override val crits: CritsAttributes get() = WearableAttributes.crits

	open class ResistanceAttributes : EconEntityAttributes.ResistanceAttributes() {
		/**
		 * In-Game: "Immune to the effects of afterburn."
		 * 
		 * For the base "`Wearable`", only checked on Sniper.
		 */
		open val afterburnImmunity: ItemAttributeNamed<Boolean> = ItemAttributeNamed("afterburn immunity")
	
		override val dmgTakenFromCritReduced: DmgTakenFromCritReducedAttributes = DmgTakenFromCritReducedAttributes()
	
		override val dmgTakenFromFireReduced: DmgTakenFromFireReducedAttributes = DmgTakenFromFireReducedAttributes()
	
		override val dmgTakenFromBulletsReduced: DmgTakenFromBulletsReducedAttributes = DmgTakenFromBulletsReducedAttributes()
	
		override val vaccinator: VaccinatorAttributes = VaccinatorAttributes()
	
		open class DmgTakenFromCritReducedAttributes : EconEntityAttributes.ResistanceAttributes.DmgTakenFromCritReducedAttributes() 
	
		open class DmgTakenFromFireReducedAttributes : EconEntityAttributes.ResistanceAttributes.DmgTakenFromFireReducedAttributes() 
	
		open class DmgTakenFromBulletsReducedAttributes : EconEntityAttributes.ResistanceAttributes.DmgTakenFromBulletsReducedAttributes() 
	
		open class VaccinatorAttributes : EconEntityAttributes.ResistanceAttributes.VaccinatorAttributes() 
	}
	
	open class MetaAttributes : EconEntityAttributes.MetaAttributes() {
		override val player: PlayerAttributes = PlayerAttributes()
	
		override val items: ItemsAttributes = ItemsAttributes()
	
		override val particles: ParticlesAttributes = ParticlesAttributes()
	
		override val killfeed: KillfeedAttributes = KillfeedAttributes()
	
		override val noisemakers: NoisemakersAttributes = NoisemakersAttributes()
	
		override val gameplay: GameplayAttributes = GameplayAttributes()
	
		open class PlayerAttributes : EconEntityAttributes.MetaAttributes.PlayerAttributes() {
			/**
			 * Overrides the skin used for the player. (e.g. Zombie).
			 */
			open val playerSkinOverride: ItemAttributeNamed<Int> = ItemAttributeNamed("player skin override")
		}
	
		open class ItemsAttributes : EconEntityAttributes.MetaAttributes.ItemsAttributes() {
			/**
			 * In-Game: "Duck Power : N / 5"
			 * 
			 * Determines if ***BONUS DUCKSSSS*** should increment the badge level.
			 */
			open val duckBadgeLevel: ItemAttributeNamed<Int> = ItemAttributeNamed("duck badge level")
		}
	
		open class ParticlesAttributes : EconEntityAttributes.MetaAttributes.ParticlesAttributes() 
	
		open class KillfeedAttributes : EconEntityAttributes.MetaAttributes.KillfeedAttributes() 
	
		open class NoisemakersAttributes : EconEntityAttributes.MetaAttributes.NoisemakersAttributes() 
	
		open class GameplayAttributes : EconEntityAttributes.MetaAttributes.GameplayAttributes() 
	}
	
	open class AmmoAttributes : EconEntityAttributes.AmmoAttributes() {
		override val maxAmmo: MaxAmmoAttributes = MaxAmmoAttributes()
	
		open class MaxAmmoAttributes : EconEntityAttributes.AmmoAttributes.MaxAmmoAttributes() 
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
	
	open class TauntingAttributes : EconEntityAttributes.TauntingAttributes() 
	
	open class SwapWeaponsAttributes : EconEntityAttributes.SwapWeaponsAttributes() 
	
	open class WhenHitAttributes : EconEntityAttributes.WhenHitAttributes() 
	
	open class SpyOnlyAttributes : EconEntityAttributes.SpyOnlyAttributes() 
	
	open class CritsAttributes : EconEntityAttributes.CritsAttributes() 
	
	object Inherited : WearableAttributes 
}