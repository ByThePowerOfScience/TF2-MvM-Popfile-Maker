package btpos.source.vdfdsl.tf2.itemattributes

import btpos.source.vdfdsl.modeling.*
import btpos.source.vdfdsl.serialization.codecs.*
import btpos.source.vdfdsl.tf2.itemattributes.impl.*
import btpos.source.vdfdsl.tf2.tftypes.*
import java.util.*
import kotlin.time.Duration

interface ChargedSMGAttributes : IBlockScoped, SMGAttributes {
	companion object : IBlockScoped {
		/**
		 * In-Game: "Secondary fire when charged grants mini-crits for N seconds."
		 * 
		 * Minicrit buff duration.
		 */
		val minicritBoostWhenCharged: ItemAttributeNamed<Number> = ItemAttributeNamed("minicrit_boost_when_charged")
	
		/**
		 * Attributes related to max ammo, clip-size, and resupply.
		 */
		private val ammo: AmmoAttributes = AmmoAttributes()
	
		/**
		 * Multipliers governing the damage you deal to different targets.
		 * 
		 * For damage _taken_, see [resistance].
		 */
		private val damage: DamageAttributes = DamageAttributes()
	
		/**
		 * Attributes governing rate-of-fire.
		 */
		private val firing: FiringAttributes = FiringAttributes()
	
		/**
		 * All attributes governing what projectile or bullet this weapon can fire, and how that projectile or bullet acts once fired.
		 * 
		 * Each type of projectile also has a subcategory with every attribute it checks for on the gun that fired it.
		 */
		private val projectiles: ProjectilesAttributes = ProjectilesAttributes()
	
		/**
		 * Attributes related to afterburn.
		 */
		private val afterburn: AfterburnAttributes = AfterburnAttributes()
	
		/**
		 * Attributes related to moving, constructing, and interacting with the Engineer's buildings.
		 */
		private val buildings: BuildingsAttributes = BuildingsAttributes()
	
		/**
		 * Attributes related to dealing or preventing critical hits and mini-crits.
		 */
		private val crits: CritsAttributes = CritsAttributes()
	
		/**
		 * Attributes governing the Demoknight's shield-charge.
		 * 
		 * Some of these attributes are hardcoded to only work on the Demoman. These are noted in their documentation.
		 */
		private val demoCharge: DemoChargeAttributes = DemoChargeAttributes()
	
		/**
		 * Attributes related to the player's HP stat and healing players.
		 */
		private val healthAndHealing: HealthAndHealingAttributes = HealthAndHealingAttributes()
	
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
		 * Attributes related to the collection and passive effects of "heads".
		 * 
		 * While originally made for the Eyelander, this stat is used by many other weapons that track players hit or killed: the Vita-Saw, the Bazaar Bargain, etc.
		 * 
		 * For "revenge crits", like the Frontier Justice, Manmelter, and Diamondback, see [revengeCrits].
		 */
		private val heads: HeadsAttributes = HeadsAttributes()
	
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
		 * Attributes governing either the time taken to reload a weapon's magazine or the cooldown time for weapons that draw directly from reserve ammo like the Sniper Rifle and Flare Gun.
		 */
		private val reloading: ReloadingAttributes = ReloadingAttributes()
	
		/**
		 * Attributes governing how much damage the player takes from various sources.  Also includes the passive and active effects of the Vaccinator on the user.
		 * 
		 * For outgoing damage, see [damage].
		 */
		private val resistance: ResistanceAttributes = ResistanceAttributes()
	
		/**
		 * Attributes governing the collection of "Revenge Crits", guaranteed criticals gained by fulfilling certain requirements.
		 * 
		 * It should be noted that for the most part, these attributes just state whether or not a weapon CAN gain revenge crits. Actually _using_ them is bound to the weapon type, not any attribute.
		 * 
		 * For the collection and usage of "heads", see [heads].
		 */
		private val revengeCrits: RevengeCritsAttributes = RevengeCritsAttributes()
	
		/**
		 * Attributes related to Mad Milk, Jarate, and Gas.
		 * 
		 * This will be empty for most weapons unless a mod adds something.  Notably, "explode on ignite" is available for all weapons.
		 */
		private val statusEffects: StatusEffectsAttributes = StatusEffectsAttributes()
	
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
	
		/**
		 * Attributes governing ragdolls, gibs, and statues.
		 */
		private val ragdolls: RagdollsAttributes = RagdollsAttributes()
	
		private val buffItems: BuffItemsAttributes = BuffItemsAttributes()
	
		private val cloak: CloakAttributes = CloakAttributes()
	
		/**
		 * Attributes related to disguising.
		 */
		private val disguise: DisguiseAttributes = DisguiseAttributes()
	
		private val hud: HudAttributes = HudAttributes()
	
		private val spyOnly: SpyOnlyAttributes = SpyOnlyAttributes()
	}
	
	/**
	 * In-Game: "Secondary fire when charged grants mini-crits for N seconds."
	 * 
	 * Minicrit buff duration.
	 */
	val minicritBoostWhenCharged: ItemAttributeNamed<Number> get() = ChargedSMGAttributes.minicritBoostWhenCharged
	
	/**
	 * Attributes related to max ammo, clip-size, and resupply.
	 */
	override val ammo: AmmoAttributes get() = ChargedSMGAttributes.ammo
	
	/**
	 * Multipliers governing the damage you deal to different targets.
	 * 
	 * For damage _taken_, see [resistance].
	 */
	override val damage: DamageAttributes get() = ChargedSMGAttributes.damage
	
	/**
	 * Attributes governing rate-of-fire.
	 */
	override val firing: FiringAttributes get() = ChargedSMGAttributes.firing
	
	/**
	 * All attributes governing what projectile or bullet this weapon can fire, and how that projectile or bullet acts once fired.
	 * 
	 * Each type of projectile also has a subcategory with every attribute it checks for on the gun that fired it.
	 */
	override val projectiles: ProjectilesAttributes get() = ChargedSMGAttributes.projectiles
	
	/**
	 * Attributes related to afterburn.
	 */
	override val afterburn: AfterburnAttributes get() = ChargedSMGAttributes.afterburn
	
	/**
	 * Attributes related to moving, constructing, and interacting with the Engineer's buildings.
	 */
	override val buildings: BuildingsAttributes get() = ChargedSMGAttributes.buildings
	
	/**
	 * Attributes related to dealing or preventing critical hits and mini-crits.
	 */
	override val crits: CritsAttributes get() = ChargedSMGAttributes.crits
	
	/**
	 * Attributes governing the Demoknight's shield-charge.
	 * 
	 * Some of these attributes are hardcoded to only work on the Demoman. These are noted in their documentation.
	 */
	override val demoCharge: DemoChargeAttributes get() = ChargedSMGAttributes.demoCharge
	
	/**
	 * Attributes related to the player's HP stat and healing players.
	 */
	override val healthAndHealing: HealthAndHealingAttributes get() = ChargedSMGAttributes.healthAndHealing
	
	/**
	 * Attributes governing how much you are pushed when hit by different push sources.
	 */
	override val knockbackReceived: KnockbackReceivedAttributes get() = ChargedSMGAttributes.knockbackReceived
	
	/**
	 * Attributes related to the scoreboard, killfeed, HuD, item descriptions, and interactions with the wider game-state. (including capture rate)
	 */
	override val meta: MetaAttributes get() = ChargedSMGAttributes.meta
	
	/**
	 * Attributes related to rage and items that recharge on a meter/timer.
	 */
	override val meter: MeterAttributes get() = ChargedSMGAttributes.meter
	
	/**
	 * Attributes governing the player's move-speed, jump height, swimming, air-strafing capabilities, and all things mobility-related.
	 */
	override val movement: MovementAttributes get() = ChargedSMGAttributes.movement
	
	/**
	 * Attributes related to the collection and passive effects of "heads".
	 * 
	 * While originally made for the Eyelander, this stat is used by many other weapons that track players hit or killed: the Vita-Saw, the Bazaar Bargain, etc.
	 * 
	 * For "revenge crits", like the Frontier Justice, Manmelter, and Diamondback, see [revengeCrits].
	 */
	override val heads: HeadsAttributes get() = ChargedSMGAttributes.heads
	
	/**
	 * Attributes governing what happens when you hit another player, such as applying conditions or debuffs.
	 * 
	 * @see onKill
	 */
	override val onHit: OnHitAttributes get() = ChargedSMGAttributes.onHit
	
	/**
	 * Attributes governing what happens when you kill another player, usually applying bonuses to yourself.
	 * 
	 * @see onHit
	 */
	override val onKill: OnKillAttributes get() = ChargedSMGAttributes.onKill
	
	/**
	 * Attributes governing either the time taken to reload a weapon's magazine or the cooldown time for weapons that draw directly from reserve ammo like the Sniper Rifle and Flare Gun.
	 */
	override val reloading: ReloadingAttributes get() = ChargedSMGAttributes.reloading
	
	/**
	 * Attributes governing how much damage the player takes from various sources.  Also includes the passive and active effects of the Vaccinator on the user.
	 * 
	 * For outgoing damage, see [damage].
	 */
	override val resistance: ResistanceAttributes get() = ChargedSMGAttributes.resistance
	
	/**
	 * Attributes governing the collection of "Revenge Crits", guaranteed criticals gained by fulfilling certain requirements.
	 * 
	 * It should be noted that for the most part, these attributes just state whether or not a weapon CAN gain revenge crits. Actually _using_ them is bound to the weapon type, not any attribute.
	 * 
	 * For the collection and usage of "heads", see [heads].
	 */
	override val revengeCrits: RevengeCritsAttributes get() = ChargedSMGAttributes.revengeCrits
	
	/**
	 * Attributes related to Mad Milk, Jarate, and Gas.
	 * 
	 * This will be empty for most weapons unless a mod adds something.  Notably, "explode on ignite" is available for all weapons.
	 */
	override val statusEffects: StatusEffectsAttributes get() = ChargedSMGAttributes.statusEffects
	
	/**
	 * Attributes governing taunt speed and the effects of taunts.
	 */
	override val taunting: TauntingAttributes get() = ChargedSMGAttributes.taunting
	
	/**
	 * Attributes governing weapon deploy/holster speed, things that activate when a weapon is deployed, and whether a player can swap weapons at all.
	 */
	override val swapWeapons: SwapWeaponsAttributes get() = ChargedSMGAttributes.swapWeapons
	
	/**
	 * Attributes governing what happens when this player is hit by an enemy.
	 * 
	 * For what happens when _this player_ hits an enemy, see [onHit] and [onKill].
	 */
	override val whenHit: WhenHitAttributes get() = ChargedSMGAttributes.whenHit
	
	/**
	 * Attributes governing ragdolls, gibs, and statues.
	 */
	override val ragdolls: RagdollsAttributes get() = ChargedSMGAttributes.ragdolls
	
	override val buffItems: BuffItemsAttributes get() = ChargedSMGAttributes.buffItems
	
	override val cloak: CloakAttributes get() = ChargedSMGAttributes.cloak
	
	/**
	 * Attributes related to disguising.
	 */
	override val disguise: DisguiseAttributes get() = ChargedSMGAttributes.disguise
	
	override val hud: HudAttributes get() = ChargedSMGAttributes.hud
	
	override val spyOnly: SpyOnlyAttributes get() = ChargedSMGAttributes.spyOnly
	
	open class AmmoAttributes : SMGAttributes.AmmoAttributes() {
		override val clipSize: ClipSizeAttributes = ClipSizeAttributes()
	
		override val modMaxAmmo: MaxAmmoAttributes = MaxAmmoAttributes()
	
		open class ClipSizeAttributes : SMGAttributes.AmmoAttributes.ClipSizeAttributes() 
	
		open class MaxAmmoAttributes : SMGAttributes.AmmoAttributes.MaxAmmoAttributes() 
	}
	
	open class DamageAttributes : SMGAttributes.DamageAttributes() {
		override val alien: AlienAttributes = AlienAttributes()
	
		open class AlienAttributes : SMGAttributes.DamageAttributes.AlienAttributes() 
	}
	
	open class FiringAttributes : SMGAttributes.FiringAttributes() {
		override val fireRate: FireRateAttributes = FireRateAttributes()
	
		open class FireRateAttributes : SMGAttributes.FiringAttributes.FireRateAttributes() 
	}
	
	open class ProjectilesAttributes : SMGAttributes.ProjectilesAttributes() {
		override val bullets: BulletsAttributes = BulletsAttributes()
	
		override val projectilePenetration: ProjectilePenetrationAttributes = ProjectilePenetrationAttributes()
	
		open class BulletsAttributes : SMGAttributes.ProjectilesAttributes.BulletsAttributes() 
	
		open class ProjectilePenetrationAttributes : SMGAttributes.ProjectilesAttributes.ProjectilePenetrationAttributes(), ItemAttribute<Int> 
	}
	
	open class AfterburnAttributes : SMGAttributes.AfterburnAttributes() 
	
	open class BuildingsAttributes : SMGAttributes.BuildingsAttributes() {
		override val sentryGun: SentryGunAttributes = SentryGunAttributes()
	
		override val dispenser: DispenserAttributes = DispenserAttributes()
	
		override val teleporter: TeleporterAttributes = TeleporterAttributes()
	
		open class SentryGunAttributes : SMGAttributes.BuildingsAttributes.SentryGunAttributes() 
	
		open class DispenserAttributes : SMGAttributes.BuildingsAttributes.DispenserAttributes() 
	
		open class TeleporterAttributes : SMGAttributes.BuildingsAttributes.TeleporterAttributes() 
	}
	
	open class CritsAttributes : SMGAttributes.CritsAttributes() 
	
	open class DemoChargeAttributes : SMGAttributes.DemoChargeAttributes() {
		override val multChargeTurnControl: MultChargeTurnControlAttributes = MultChargeTurnControlAttributes()
	
		open class MultChargeTurnControlAttributes : SMGAttributes.DemoChargeAttributes.MultChargeTurnControlAttributes() 
	}
	
	open class HealthAndHealingAttributes : SMGAttributes.HealthAndHealingAttributes() {
		override val healthRegen: HealthRegenAttributes = HealthRegenAttributes()
	
		override val maxHealthAdditiveBonus: MaxHealthAdditiveAttributes = MaxHealthAdditiveAttributes()
	
		open class HealthRegenAttributes : SMGAttributes.HealthAndHealingAttributes.HealthRegenAttributes() 
	
		open class MaxHealthAdditiveAttributes : SMGAttributes.HealthAndHealingAttributes.MaxHealthAdditiveAttributes() 
	}
	
	open class KnockbackReceivedAttributes : SMGAttributes.KnockbackReceivedAttributes() {
		override val damageForceReduction: DamageForceReductionAttributes = DamageForceReductionAttributes()
	
		open class DamageForceReductionAttributes : SMGAttributes.KnockbackReceivedAttributes.DamageForceReductionAttributes() 
	}
	
	open class MetaAttributes : SMGAttributes.MetaAttributes() {
		override val killfeed: KillfeedAttributes = KillfeedAttributes()
	
		override val viewmodel: ViewmodelAttributes = ViewmodelAttributes()
	
		override val items: ItemsAttributes = ItemsAttributes()
	
		override val particles: ParticlesAttributes = ParticlesAttributes()
	
		override val noisemakers: NoisemakersAttributes = NoisemakersAttributes()
	
		override val player: PlayerAttributes = PlayerAttributes()
	
		override val gameplay: GameplayAttributes = GameplayAttributes()
	
		open class KillfeedAttributes : SMGAttributes.MetaAttributes.KillfeedAttributes() 
	
		open class ViewmodelAttributes : SMGAttributes.MetaAttributes.ViewmodelAttributes() 
	
		open class ItemsAttributes : SMGAttributes.MetaAttributes.ItemsAttributes() 
	
		open class ParticlesAttributes : SMGAttributes.MetaAttributes.ParticlesAttributes() 
	
		open class NoisemakersAttributes : SMGAttributes.MetaAttributes.NoisemakersAttributes() 
	
		open class PlayerAttributes : SMGAttributes.MetaAttributes.PlayerAttributes() 
	
		open class GameplayAttributes : SMGAttributes.MetaAttributes.GameplayAttributes() 
	}
	
	open class MeterAttributes : SMGAttributes.MeterAttributes() {
		override val generateRageOnDamage: GenerateRageOnDamageAttributes = GenerateRageOnDamageAttributes()
	
		open class GenerateRageOnDamageAttributes : SMGAttributes.MeterAttributes.GenerateRageOnDamageAttributes() 
	}
	
	open class MovementAttributes : SMGAttributes.MovementAttributes() {
		override val moveSpeed: MoveSpeedAttributes = MoveSpeedAttributes()
	
		override val increasedJumpHeight: jumpHeightAttributes = jumpHeightAttributes()
	
		open class MoveSpeedAttributes : SMGAttributes.MovementAttributes.MoveSpeedAttributes() {
			override val aimingMovespeedIncreased: AimingMovespeedAttributes = AimingMovespeedAttributes()
	
			override val moveSpeedPenalty: MoveSpeedAttributes = MoveSpeedAttributes()
	
			open class AimingMovespeedAttributes : SMGAttributes.MovementAttributes.MoveSpeedAttributes.AimingMovespeedAttributes() 
	
			open class MoveSpeedAttributes : SMGAttributes.MovementAttributes.MoveSpeedAttributes.MoveSpeedAttributes() 
		}
	
		open class jumpHeightAttributes : SMGAttributes.MovementAttributes.jumpHeightAttributes() 
	}
	
	open class HeadsAttributes : SMGAttributes.HeadsAttributes() 
	
	open class OnHitAttributes : SMGAttributes.OnHitAttributes() {
		override val healOnHitForRapidfire: HealOnHitForRapidfireAttributes = HealOnHitForRapidfireAttributes()
	
		override val generateRageOnDamage: GenerateRageOnDamageAttributes = GenerateRageOnDamageAttributes()
	
		override val falling: FallingAttributes = FallingAttributes()
	
		open class HealOnHitForRapidfireAttributes : SMGAttributes.OnHitAttributes.HealOnHitForRapidfireAttributes() 
	
		open class GenerateRageOnDamageAttributes : SMGAttributes.OnHitAttributes.GenerateRageOnDamageAttributes() 
	
		open class FallingAttributes : SMGAttributes.OnHitAttributes.FallingAttributes() 
	}
	
	open class OnKillAttributes : SMGAttributes.OnKillAttributes() 
	
	open class ReloadingAttributes : SMGAttributes.ReloadingAttributes() 
	
	open class ResistanceAttributes : SMGAttributes.ResistanceAttributes() {
		override val dmgTakenFromCritReduced: DmgTakenFromCritReducedAttributes = DmgTakenFromCritReducedAttributes()
	
		override val dmgTakenFromFireReduced: DmgTakenFromFireReducedAttributes = DmgTakenFromFireReducedAttributes()
	
		override val dmgTakenFromBulletsReduced: DmgTakenFromBulletsReducedAttributes = DmgTakenFromBulletsReducedAttributes()
	
		override val vaccinator: VaccinatorAttributes = VaccinatorAttributes()
	
		open class DmgTakenFromCritReducedAttributes : SMGAttributes.ResistanceAttributes.DmgTakenFromCritReducedAttributes() 
	
		open class DmgTakenFromFireReducedAttributes : SMGAttributes.ResistanceAttributes.DmgTakenFromFireReducedAttributes() 
	
		open class DmgTakenFromBulletsReducedAttributes : SMGAttributes.ResistanceAttributes.DmgTakenFromBulletsReducedAttributes() 
	
		open class VaccinatorAttributes : SMGAttributes.ResistanceAttributes.VaccinatorAttributes() 
	}
	
	open class RevengeCritsAttributes : SMGAttributes.RevengeCritsAttributes() 
	
	open class StatusEffectsAttributes : SMGAttributes.StatusEffectsAttributes() 
	
	open class TauntingAttributes : SMGAttributes.TauntingAttributes() 
	
	open class SwapWeaponsAttributes : SMGAttributes.SwapWeaponsAttributes() {
		override val deploy: DeployAttributes = DeployAttributes()
	
		open class DeployAttributes : SMGAttributes.SwapWeaponsAttributes.DeployAttributes() 
	}
	
	open class WhenHitAttributes : SMGAttributes.WhenHitAttributes() 
	
	open class RagdollsAttributes : SMGAttributes.RagdollsAttributes() 
	
	open class BuffItemsAttributes : SMGAttributes.BuffItemsAttributes() 
	
	open class CloakAttributes : SMGAttributes.CloakAttributes() 
	
	open class DisguiseAttributes : SMGAttributes.DisguiseAttributes() 
	
	open class HudAttributes : SMGAttributes.HudAttributes() 
	
	open class SpyOnlyAttributes : SMGAttributes.SpyOnlyAttributes() 
	
	object Inherited : ChargedSMGAttributes 
}