package btpos.source.vdfdsl.tf2.itemattributes

import btpos.source.vdfdsl.modeling.*
import btpos.source.vdfdsl.serialization.codecs.*
import btpos.source.vdfdsl.tf2.itemattributes.impl.*
import btpos.source.vdfdsl.tf2.tftypes.*
import java.util.*
import kotlin.time.Duration

interface MvMBotAttributes : IBlockScoped, PlayerAttributes {
	companion object : IBlockScoped {
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
	
		/**
		 * Attributes related to max ammo, clip-size, and resupply.
		 */
		private val ammo: AmmoAttributes = AmmoAttributes()
	
		private val buffItems: BuffItemsAttributes = BuffItemsAttributes()
	
		/**
		 * Attributes related to moving, constructing, and interacting with the Engineer's buildings.
		 */
		private val buildings: BuildingsAttributes = BuildingsAttributes()
	
		private val cloak: CloakAttributes = CloakAttributes()
	
		/**
		 * Multipliers governing the damage you deal to different targets.
		 * 
		 * For damage _taken_, see [resistance].
		 */
		private val damage: DamageAttributes = DamageAttributes()
	
		/**
		 * Attributes governing the Demoknight's shield-charge.
		 * 
		 * Some of these attributes are hardcoded to only work on the Demoman. These are noted in their documentation.
		 */
		private val demoCharge: DemoChargeAttributes = DemoChargeAttributes()
	
		/**
		 * Attributes related to disguising.
		 */
		private val disguise: DisguiseAttributes = DisguiseAttributes()
	
		/**
		 * Attributes governing rate-of-fire.
		 */
		private val firing: FiringAttributes = FiringAttributes()
	
		/**
		 * Attributes related to the collection and passive effects of "heads".
		 * 
		 * While originally made for the Eyelander, this stat is used by many other weapons that track players hit or killed: the Vita-Saw, the Bazaar Bargain, etc.
		 * 
		 * For "revenge crits", like the Frontier Justice, Manmelter, and Diamondback, see [revengeCrits].
		 */
		private val heads: HeadsAttributes = HeadsAttributes()
	
		/**
		 * Attributes related to the player's HP stat and healing players.
		 */
		private val healthAndHealing: HealthAndHealingAttributes = HealthAndHealingAttributes()
	
		private val hud: HudAttributes = HudAttributes()
	
		/**
		 * Attributes governing how much you are pushed when hit by different push sources.
		 */
		private val knockbackReceived: KnockbackReceivedAttributes = KnockbackReceivedAttributes()
	
		/**
		 * Attributes related to the scoreboard, killfeed, HuD, item descriptions, and interactions with the wider game-state. (including capture rate)
		 */
		private val meta: MetaAttributes = MetaAttributes()
	
		/**
		 * Attributes related to rage and items that recharge on a meter/timer.
		 */
		private val meter: MeterAttributes = MeterAttributes()
	
		/**
		 * Attributes governing the player's move-speed, jump height, swimming, air-strafing capabilities, and all things mobility-related.
		 */
		private val movement: MovementAttributes = MovementAttributes()
	
		/**
		 * Attributes governing what happens when you hit another player, such as applying conditions or debuffs.
		 * 
		 * @see onKill
		 */
		private val onHit: OnHitAttributes = OnHitAttributes()
	
		/**
		 * Attributes governing what happens when you kill another player, usually applying bonuses to yourself.
		 * 
		 * @see onHit
		 */
		private val onKill: OnKillAttributes = OnKillAttributes()
	
		/**
		 * Attributes governing how much damage the player takes from various sources.  Also includes the passive and active effects of the Vaccinator on the user.
		 * 
		 * For outgoing damage, see [damage].
		 */
		private val resistance: ResistanceAttributes = ResistanceAttributes()
	
		/**
		 * Attributes governing taunt speed and the effects of taunts.
		 */
		private val taunting: TauntingAttributes = TauntingAttributes()
	
		/**
		 * Attributes governing weapon deploy/holster speed, things that activate when a weapon is deployed, and whether a player can swap weapons at all.
		 */
		private val swapWeapons: SwapWeaponsAttributes = SwapWeaponsAttributes()
	
		/**
		 * Attributes governing what happens when this player is hit by an enemy.
		 * 
		 * For what happens when _this player_ hits an enemy, see [onHit] and [onKill].
		 */
		private val whenHit: WhenHitAttributes = WhenHitAttributes()
	
		private val spyOnly: SpyOnlyAttributes = SpyOnlyAttributes()
	
		/**
		 * Attributes related to dealing or preventing critical hits and mini-crits.
		 */
		private val crits: CritsAttributes = CritsAttributes()
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
	
	/**
	 * Attributes related to max ammo, clip-size, and resupply.
	 */
	override val ammo: AmmoAttributes get() = MvMBotAttributes.ammo
	
	override val buffItems: BuffItemsAttributes get() = MvMBotAttributes.buffItems
	
	/**
	 * Attributes related to moving, constructing, and interacting with the Engineer's buildings.
	 */
	override val buildings: BuildingsAttributes get() = MvMBotAttributes.buildings
	
	override val cloak: CloakAttributes get() = MvMBotAttributes.cloak
	
	/**
	 * Multipliers governing the damage you deal to different targets.
	 * 
	 * For damage _taken_, see [resistance].
	 */
	override val damage: DamageAttributes get() = MvMBotAttributes.damage
	
	/**
	 * Attributes governing the Demoknight's shield-charge.
	 * 
	 * Some of these attributes are hardcoded to only work on the Demoman. These are noted in their documentation.
	 */
	override val demoCharge: DemoChargeAttributes get() = MvMBotAttributes.demoCharge
	
	/**
	 * Attributes related to disguising.
	 */
	override val disguise: DisguiseAttributes get() = MvMBotAttributes.disguise
	
	/**
	 * Attributes governing rate-of-fire.
	 */
	override val firing: FiringAttributes get() = MvMBotAttributes.firing
	
	/**
	 * Attributes related to the collection and passive effects of "heads".
	 * 
	 * While originally made for the Eyelander, this stat is used by many other weapons that track players hit or killed: the Vita-Saw, the Bazaar Bargain, etc.
	 * 
	 * For "revenge crits", like the Frontier Justice, Manmelter, and Diamondback, see [revengeCrits].
	 */
	override val heads: HeadsAttributes get() = MvMBotAttributes.heads
	
	/**
	 * Attributes related to the player's HP stat and healing players.
	 */
	override val healthAndHealing: HealthAndHealingAttributes get() = MvMBotAttributes.healthAndHealing
	
	override val hud: HudAttributes get() = MvMBotAttributes.hud
	
	/**
	 * Attributes governing how much you are pushed when hit by different push sources.
	 */
	override val knockbackReceived: KnockbackReceivedAttributes get() = MvMBotAttributes.knockbackReceived
	
	/**
	 * Attributes related to the scoreboard, killfeed, HuD, item descriptions, and interactions with the wider game-state. (including capture rate)
	 */
	override val meta: MetaAttributes get() = MvMBotAttributes.meta
	
	/**
	 * Attributes related to rage and items that recharge on a meter/timer.
	 */
	override val meter: MeterAttributes get() = MvMBotAttributes.meter
	
	/**
	 * Attributes governing the player's move-speed, jump height, swimming, air-strafing capabilities, and all things mobility-related.
	 */
	override val movement: MovementAttributes get() = MvMBotAttributes.movement
	
	/**
	 * Attributes governing what happens when you hit another player, such as applying conditions or debuffs.
	 * 
	 * @see onKill
	 */
	override val onHit: OnHitAttributes get() = MvMBotAttributes.onHit
	
	/**
	 * Attributes governing what happens when you kill another player, usually applying bonuses to yourself.
	 * 
	 * @see onHit
	 */
	override val onKill: OnKillAttributes get() = MvMBotAttributes.onKill
	
	/**
	 * Attributes governing how much damage the player takes from various sources.  Also includes the passive and active effects of the Vaccinator on the user.
	 * 
	 * For outgoing damage, see [damage].
	 */
	override val resistance: ResistanceAttributes get() = MvMBotAttributes.resistance
	
	/**
	 * Attributes governing taunt speed and the effects of taunts.
	 */
	override val taunting: TauntingAttributes get() = MvMBotAttributes.taunting
	
	/**
	 * Attributes governing weapon deploy/holster speed, things that activate when a weapon is deployed, and whether a player can swap weapons at all.
	 */
	override val swapWeapons: SwapWeaponsAttributes get() = MvMBotAttributes.swapWeapons
	
	/**
	 * Attributes governing what happens when this player is hit by an enemy.
	 * 
	 * For what happens when _this player_ hits an enemy, see [onHit] and [onKill].
	 */
	override val whenHit: WhenHitAttributes get() = MvMBotAttributes.whenHit
	
	override val spyOnly: SpyOnlyAttributes get() = MvMBotAttributes.spyOnly
	
	/**
	 * Attributes related to dealing or preventing critical hits and mini-crits.
	 */
	override val crits: CritsAttributes get() = MvMBotAttributes.crits
	
	open class AmmoAttributes : PlayerAttributes.AmmoAttributes() {
		override val modMaxAmmo: MaxAmmoAttributes = MaxAmmoAttributes()
	
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
	
		override val maxHealthAdditiveBonus: MaxHealthAdditiveAttributes = MaxHealthAdditiveAttributes()
	
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
		override val increasedJumpHeight: jumpHeightAttributes = jumpHeightAttributes()
	
		override val moveSpeed: MoveSpeedAttributes = MoveSpeedAttributes()
	
		open class jumpHeightAttributes : PlayerAttributes.MovementAttributes.jumpHeightAttributes() 
	
		open class MoveSpeedAttributes : PlayerAttributes.MovementAttributes.MoveSpeedAttributes() {
			override val aimingMovespeedIncreased: AimingMovespeedAttributes = AimingMovespeedAttributes()
	
			override val moveSpeedPenalty: MoveSpeedAttributes = MoveSpeedAttributes()
	
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
	
	object Inherited : MvMBotAttributes 
}