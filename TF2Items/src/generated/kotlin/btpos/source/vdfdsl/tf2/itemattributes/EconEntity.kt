package btpos.source.vdfdsl.tf2.itemattributes

import btpos.source.vdfdsl.modeling.*
import btpos.source.vdfdsl.serialization.codecs.*
import btpos.source.vdfdsl.tf2.itemattributes.impl.*
import btpos.source.vdfdsl.tf2.tftypes.*
import java.util.*
import kotlin.time.Duration

interface EconEntityAttributes : IBlockScoped, PlayerAttributes {
	companion object : IBlockScoped {
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
	
		private val resistance: ResistanceAttributes = ResistanceAttributes()
	
		private val taunting: TauntingAttributes = TauntingAttributes()
	
		private val swapWeapons: SwapWeaponsAttributes = SwapWeaponsAttributes()
	
		private val whenHit: WhenHitAttributes = WhenHitAttributes()
	
		private val spyOnly: SpyOnlyAttributes = SpyOnlyAttributes()
	
		private val crits: CritsAttributes = CritsAttributes()
	}

	override val meta: MetaAttributes get() = EconEntityAttributes.meta
	
	override val ammo: AmmoAttributes get() = EconEntityAttributes.ammo
	
	override val buffItems: BuffItemsAttributes get() = EconEntityAttributes.buffItems
	
	override val buildings: BuildingsAttributes get() = EconEntityAttributes.buildings
	
	override val cloak: CloakAttributes get() = EconEntityAttributes.cloak
	
	override val damage: DamageAttributes get() = EconEntityAttributes.damage
	
	override val demoCharge: DemoChargeAttributes get() = EconEntityAttributes.demoCharge
	
	override val disguise: DisguiseAttributes get() = EconEntityAttributes.disguise
	
	override val firing: FiringAttributes get() = EconEntityAttributes.firing
	
	override val heads: HeadsAttributes get() = EconEntityAttributes.heads
	
	override val healthAndHealing: HealthAndHealingAttributes get() = EconEntityAttributes.healthAndHealing
	
	override val hud: HudAttributes get() = EconEntityAttributes.hud
	
	override val knockbackReceived: KnockbackReceivedAttributes get() = EconEntityAttributes.knockbackReceived
	
	override val meter: MeterAttributes get() = EconEntityAttributes.meter
	
	override val movement: MovementAttributes get() = EconEntityAttributes.movement
	
	override val onHit: OnHitAttributes get() = EconEntityAttributes.onHit
	
	override val onKill: OnKillAttributes get() = EconEntityAttributes.onKill
	
	override val resistance: ResistanceAttributes get() = EconEntityAttributes.resistance
	
	override val taunting: TauntingAttributes get() = EconEntityAttributes.taunting
	
	override val swapWeapons: SwapWeaponsAttributes get() = EconEntityAttributes.swapWeapons
	
	override val whenHit: WhenHitAttributes get() = EconEntityAttributes.whenHit
	
	override val spyOnly: SpyOnlyAttributes get() = EconEntityAttributes.spyOnly
	
	override val crits: CritsAttributes get() = EconEntityAttributes.crits

	open class MetaAttributes : PlayerAttributes.MetaAttributes() {
		override val items: ItemsAttributes = ItemsAttributes()
	
		override val particles: ParticlesAttributes = ParticlesAttributes()
	
		override val killfeed: KillfeedAttributes = KillfeedAttributes()
	
		override val noisemakers: NoisemakersAttributes = NoisemakersAttributes()
	
		override val player: PlayerAttributes = PlayerAttributes()
	
		override val gameplay: GameplayAttributes = GameplayAttributes()
	
		open class ItemsAttributes : PlayerAttributes.MetaAttributes.ItemsAttributes() {
			/**
			 * In-Game: "Festivized"
			 * 
			 * Attaches festivizer.
			 */
			open val isFestivized: ItemAttributeNamed<Boolean> = ItemAttributeNamed("is_festivized")
		}
	
		open class ParticlesAttributes : PlayerAttributes.MetaAttributes.ParticlesAttributes() {
			/**
			 * Attaches static particle, such as smoking a pipe.
			 * 
			 * Cosmetics can only have one.
			 */
			open val attachParticleEffectStatic: ItemAttributeNamed<Int> = ItemAttributeNamed("attach particle effect static")
	
			/**
			 * In-Game: "★ Unusual Effect: N"
			 * 
			 * Dynamic particle systems, such as unusuals.
			 */
			open val attachParticleEffect: ItemAttributeNamed<Int> = ItemAttributeNamed("attach particle effect")
	
			/**
			 * If false, attaches the `set_attached_particle` to the item itself.
			 * 
			 * If true, the particle only applies to the throwable particle trail.
			 */
			open val throwableParticleTrailOnly: ItemAttributeNamed<Boolean> = ItemAttributeNamed("throwable particle trail only")
		}
	
		open class KillfeedAttributes : PlayerAttributes.MetaAttributes.KillfeedAttributes() 
	
		open class NoisemakersAttributes : PlayerAttributes.MetaAttributes.NoisemakersAttributes() 
	
		open class PlayerAttributes : PlayerAttributes.MetaAttributes.PlayerAttributes() 
	
		open class GameplayAttributes : PlayerAttributes.MetaAttributes.GameplayAttributes() 
	}
	
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
	
	object Inherited : EconEntityAttributes 
}