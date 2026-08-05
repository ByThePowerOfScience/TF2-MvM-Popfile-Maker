package btpos.source.vdfdsl.tf2.itemattributes

import btpos.source.vdfdsl.modeling.*
import btpos.source.vdfdsl.serialization.*
import btpos.source.vdfdsl.serialization.codecs.*
import btpos.source.vdfdsl.tf2.itemattributes.impl.*
import btpos.source.vdfdsl.tf2.tftypes.*
import java.util.*
import kotlin.time.Duration

interface RevolverSecondaryAttributes : IBlockScoped, RevolverAttributes {
	companion object : IBlockScoped {
		/**
		 * Attributes related to the collection and passive effects of "heads".
		 * 
		 * While originally made for the Eyelander, this stat is used by many other weapons that track players hit or killed: the Vita-Saw, the Bazaar Bargain, etc.
		 * 
		 * For "revenge crits", like the Frontier Justice, Manmelter, and Diamondback, see [revengeCrits].
		 */
		private val heads: HeadsAttributes = HeadsAttributes()
	
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
	 * Attributes related to the collection and passive effects of "heads".
	 * 
	 * While originally made for the Eyelander, this stat is used by many other weapons that track players hit or killed: the Vita-Saw, the Bazaar Bargain, etc.
	 * 
	 * For "revenge crits", like the Frontier Justice, Manmelter, and Diamondback, see [revengeCrits].
	 */
	override val heads: HeadsAttributes get() = RevolverSecondaryAttributes.heads
	
	/**
	 * Attributes related to max ammo, clip-size, and resupply.
	 */
	override val ammo: AmmoAttributes get() = RevolverSecondaryAttributes.ammo
	
	/**
	 * Multipliers governing the damage you deal to different targets.
	 * 
	 * For damage _taken_, see [resistance].
	 */
	override val damage: DamageAttributes get() = RevolverSecondaryAttributes.damage
	
	/**
	 * Attributes governing rate-of-fire.
	 */
	override val firing: FiringAttributes get() = RevolverSecondaryAttributes.firing
	
	/**
	 * All attributes governing what projectile or bullet this weapon can fire, and how that projectile or bullet acts once fired.
	 * 
	 * Each type of projectile also has a subcategory with every attribute it checks for on the gun that fired it.
	 */
	override val projectiles: ProjectilesAttributes get() = RevolverSecondaryAttributes.projectiles
	
	/**
	 * Attributes related to afterburn.
	 */
	override val afterburn: AfterburnAttributes get() = RevolverSecondaryAttributes.afterburn
	
	/**
	 * Attributes related to moving, constructing, and interacting with the Engineer's buildings.
	 */
	override val buildings: BuildingsAttributes get() = RevolverSecondaryAttributes.buildings
	
	/**
	 * Attributes related to dealing or preventing critical hits and mini-crits.
	 */
	override val crits: CritsAttributes get() = RevolverSecondaryAttributes.crits
	
	/**
	 * Attributes governing the Demoknight's shield-charge.
	 * 
	 * Some of these attributes are hardcoded to only work on the Demoman. These are noted in their documentation.
	 */
	override val demoCharge: DemoChargeAttributes get() = RevolverSecondaryAttributes.demoCharge
	
	/**
	 * Attributes related to the player's HP stat and healing players.
	 */
	override val healthAndHealing: HealthAndHealingAttributes get() = RevolverSecondaryAttributes.healthAndHealing
	
	/**
	 * Attributes governing how much you are pushed when hit by different push sources.
	 */
	override val knockbackReceived: KnockbackReceivedAttributes get() = RevolverSecondaryAttributes.knockbackReceived
	
	/**
	 * Attributes related to the scoreboard, killfeed, HuD, item descriptions, and interactions with the wider game-state. (including capture rate)
	 */
	override val meta: MetaAttributes get() = RevolverSecondaryAttributes.meta
	
	/**
	 * Attributes related to rage and items that recharge on a meter/timer.
	 */
	override val meter: MeterAttributes get() = RevolverSecondaryAttributes.meter
	
	/**
	 * Attributes governing the player's move-speed, jump height, swimming, air-strafing capabilities, and all things mobility-related.
	 */
	override val movement: MovementAttributes get() = RevolverSecondaryAttributes.movement
	
	/**
	 * Attributes governing what happens when you hit another player, such as applying conditions or debuffs.
	 * 
	 * @see onKill
	 */
	override val onHit: OnHitAttributes get() = RevolverSecondaryAttributes.onHit
	
	/**
	 * Attributes governing what happens when you kill another player, usually applying bonuses to yourself.
	 * 
	 * @see onHit
	 */
	override val onKill: OnKillAttributes get() = RevolverSecondaryAttributes.onKill
	
	/**
	 * Attributes governing either the time taken to reload a weapon's magazine or the cooldown time for weapons that draw directly from reserve ammo like the Sniper Rifle and Flare Gun.
	 */
	override val reloading: ReloadingAttributes get() = RevolverSecondaryAttributes.reloading
	
	/**
	 * Attributes governing how much damage the player takes from various sources.  Also includes the passive and active effects of the Vaccinator on the user.
	 * 
	 * For outgoing damage, see [damage].
	 */
	override val resistance: ResistanceAttributes get() = RevolverSecondaryAttributes.resistance
	
	/**
	 * Attributes governing the collection of "Revenge Crits", guaranteed criticals gained by fulfilling certain requirements.
	 * 
	 * It should be noted that for the most part, these attributes just state whether or not a weapon CAN gain revenge crits. Actually _using_ them is bound to the weapon type, not any attribute.
	 * 
	 * For the collection and usage of "heads", see [heads].
	 */
	override val revengeCrits: RevengeCritsAttributes get() = RevolverSecondaryAttributes.revengeCrits
	
	/**
	 * Attributes related to Mad Milk, Jarate, and Gas.
	 * 
	 * This will be empty for most weapons unless a mod adds something.  Notably, "explode on ignite" is available for all weapons.
	 */
	override val statusEffects: StatusEffectsAttributes get() = RevolverSecondaryAttributes.statusEffects
	
	/**
	 * Attributes governing taunt speed and the effects of taunts.
	 */
	override val taunting: TauntingAttributes get() = RevolverSecondaryAttributes.taunting
	
	/**
	 * Attributes governing weapon deploy/holster speed, things that activate when a weapon is deployed, and whether a player can swap weapons at all.
	 */
	override val swapWeapons: SwapWeaponsAttributes get() = RevolverSecondaryAttributes.swapWeapons
	
	/**
	 * Attributes governing what happens when this player is hit by an enemy.
	 * 
	 * For what happens when _this player_ hits an enemy, see [onHit] and [onKill].
	 */
	override val whenHit: WhenHitAttributes get() = RevolverSecondaryAttributes.whenHit
	
	/**
	 * Attributes governing ragdolls, gibs, and statues.
	 */
	override val ragdolls: RagdollsAttributes get() = RevolverSecondaryAttributes.ragdolls
	
	override val buffItems: BuffItemsAttributes get() = RevolverSecondaryAttributes.buffItems
	
	override val cloak: CloakAttributes get() = RevolverSecondaryAttributes.cloak
	
	/**
	 * Attributes related to disguising.
	 */
	override val disguise: DisguiseAttributes get() = RevolverSecondaryAttributes.disguise
	
	override val hud: HudAttributes get() = RevolverSecondaryAttributes.hud
	
	override val spyOnly: SpyOnlyAttributes get() = RevolverSecondaryAttributes.spyOnly
	
	open class HeadsAttributes : RevolverAttributes.HeadsAttributes() 
	
	open class AmmoAttributes : RevolverAttributes.AmmoAttributes() {
		override val clipSize: ClipSizeAttributes = ClipSizeAttributes()
	
		override val multMaxAmmo: MaxAmmoAttributes = MaxAmmoAttributes()
	
		open class ClipSizeAttributes : RevolverAttributes.AmmoAttributes.ClipSizeAttributes() 
	
		open class MaxAmmoAttributes : RevolverAttributes.AmmoAttributes.MaxAmmoAttributes() 
	}
	
	open class DamageAttributes : RevolverAttributes.DamageAttributes() {
		override val alien: AlienAttributes = AlienAttributes()
	
		open class AlienAttributes : RevolverAttributes.DamageAttributes.AlienAttributes() 
	}
	
	open class FiringAttributes : RevolverAttributes.FiringAttributes() {
		override val fireRate: FireRateAttributes = FireRateAttributes()
	
		open class FireRateAttributes : RevolverAttributes.FiringAttributes.FireRateAttributes() 
	}
	
	open class ProjectilesAttributes : RevolverAttributes.ProjectilesAttributes() {
		override val bullets: BulletsAttributes = BulletsAttributes()
	
		/**
		 * How many players your "projectile" (*including bullets*) should penetrate.
		 */
		override val penetration: ProjectilePenetrationAttributes = ProjectilePenetrationAttributes()
	
		open class BulletsAttributes : RevolverAttributes.ProjectilesAttributes.BulletsAttributes() 
	
		open class ProjectilePenetrationAttributes : RevolverAttributes.ProjectilesAttributes.ProjectilePenetrationAttributes(), ItemAttribute<Int> 
	}
	
	open class AfterburnAttributes : RevolverAttributes.AfterburnAttributes() 
	
	open class BuildingsAttributes : RevolverAttributes.BuildingsAttributes() {
		override val sentryGun: SentryGunAttributes = SentryGunAttributes()
	
		override val dispenser: DispenserAttributes = DispenserAttributes()
	
		override val teleporter: TeleporterAttributes = TeleporterAttributes()
	
		open class SentryGunAttributes : RevolverAttributes.BuildingsAttributes.SentryGunAttributes() 
	
		open class DispenserAttributes : RevolverAttributes.BuildingsAttributes.DispenserAttributes() 
	
		open class TeleporterAttributes : RevolverAttributes.BuildingsAttributes.TeleporterAttributes() 
	}
	
	open class CritsAttributes : RevolverAttributes.CritsAttributes() 
	
	open class DemoChargeAttributes : RevolverAttributes.DemoChargeAttributes() {
		/**
		 * Default is 0.45f, and this is a multiplier applied to it.
		 */
		override val multChargeTurnControl: ChargeTurnControlAttributes = ChargeTurnControlAttributes()
	
		open class ChargeTurnControlAttributes : RevolverAttributes.DemoChargeAttributes.ChargeTurnControlAttributes(), ItemAttribute<Number> 
	}
	
	open class HealthAndHealingAttributes : RevolverAttributes.HealthAndHealingAttributes() {
		/**
		 * Amount of health regenerated per regen tick.  Scales by the amount of time since the player last took damage in non-MvM modes.
		 */
		override val healthRegenPerSecond: AddHealthRegenAttributes = AddHealthRegenAttributes()
	
		/**
		 * Additive maximum health increase. Influences the player's overheal cap.
		 */
		override val addMaxHealth: AddMaxhealthAttributes = AddMaxhealthAttributes()
	
		open class AddHealthRegenAttributes : RevolverAttributes.HealthAndHealingAttributes.AddHealthRegenAttributes(), ItemAttribute<Int> 
	
		open class AddMaxhealthAttributes : RevolverAttributes.HealthAndHealingAttributes.AddMaxhealthAttributes(), ItemAttribute<Int> 
	}
	
	open class KnockbackReceivedAttributes : RevolverAttributes.KnockbackReceivedAttributes() {
		/**
		 * Attribute class is a flat multiplier applied to push force received from damage.
		 */
		override val damageForceReduction: DamageForceReductionAttributes = DamageForceReductionAttributes()
	
		open class DamageForceReductionAttributes : RevolverAttributes.KnockbackReceivedAttributes.DamageForceReductionAttributes() 
	}
	
	open class MetaAttributes : RevolverAttributes.MetaAttributes() {
		override val killfeed: KillfeedAttributes = KillfeedAttributes()
	
		override val viewmodel: ViewmodelAttributes = ViewmodelAttributes()
	
		override val items: ItemsAttributes = ItemsAttributes()
	
		override val particles: ParticlesAttributes = ParticlesAttributes()
	
		override val noisemakers: NoisemakersAttributes = NoisemakersAttributes()
	
		override val player: PlayerAttributes = PlayerAttributes()
	
		override val gameplay: GameplayAttributes = GameplayAttributes()
	
		open class KillfeedAttributes : RevolverAttributes.MetaAttributes.KillfeedAttributes() 
	
		open class ViewmodelAttributes : RevolverAttributes.MetaAttributes.ViewmodelAttributes() 
	
		open class ItemsAttributes : RevolverAttributes.MetaAttributes.ItemsAttributes() 
	
		open class ParticlesAttributes : RevolverAttributes.MetaAttributes.ParticlesAttributes() 
	
		open class NoisemakersAttributes : RevolverAttributes.MetaAttributes.NoisemakersAttributes() 
	
		open class PlayerAttributes : RevolverAttributes.MetaAttributes.PlayerAttributes() 
	
		open class GameplayAttributes : RevolverAttributes.MetaAttributes.GameplayAttributes() 
	}
	
	open class MeterAttributes : RevolverAttributes.MeterAttributes() {
		/**
		 * Only works on Engineer and Heavy.
		 * 
		 * On Engineer, adds all damage dealt to the rage meter.
		 * 
		 * On Heavy, adds `0.22` * the damage to the meter, and reduces damage by 50% while the meter is draining.
		 */
		override val generateRageOnDmg: GenerateRageOnDmgAttributes = GenerateRageOnDmgAttributes()
	
		open class GenerateRageOnDmgAttributes : RevolverAttributes.MeterAttributes.GenerateRageOnDmgAttributes(), ItemAttribute<Boolean> 
	}
	
	open class MovementAttributes : RevolverAttributes.MovementAttributes() {
		override val moveSpeed: MoveSpeedAttributes = MoveSpeedAttributes()
	
		override val multJumpHeight: ModJumpHeightAttributes = ModJumpHeightAttributes()
	
		open class MoveSpeedAttributes : RevolverAttributes.MovementAttributes.MoveSpeedAttributes() {
			/**
			 * Only applies to players that have TF_COND_AIMING.
			 * 
			 * If Heavy, default aiming movespeed is 110.
			 * 
			 * Else if player is using a compound bow, 160.
			 * 
			 * Else 80.
			 */
			override val multPlayerAimingMovespeed: MultPlayerAimingMovespeedAttributes = MultPlayerAimingMovespeedAttributes()
	
			override val multMoveSpeed: MultPlayerMovespeedAttributes = MultPlayerMovespeedAttributes()
	
			open class MultPlayerAimingMovespeedAttributes : RevolverAttributes.MovementAttributes.MoveSpeedAttributes.MultPlayerAimingMovespeedAttributes() 
	
			open class MultPlayerMovespeedAttributes : RevolverAttributes.MovementAttributes.MoveSpeedAttributes.MultPlayerMovespeedAttributes(), ItemAttribute<Number> 
		}
	
		open class ModJumpHeightAttributes : RevolverAttributes.MovementAttributes.ModJumpHeightAttributes(), ItemAttribute<Number> 
	}
	
	open class OnHitAttributes : RevolverAttributes.OnHitAttributes() {
		/**
		 * Add this amount of health on hit.
		 */
		override val addOnhitAddhealth: AddOnhitAddhealthAttributes = AddOnhitAddhealthAttributes()
	
		/**
		 * Knockback rage on enemy if you're a heavy and your rage is draining.
		 */
		override val generateRageOnDmg: GenerateRageOnDmgAttributes = GenerateRageOnDmgAttributes()
	
		override val falling: FallingAttributes = FallingAttributes()
	
		open class AddOnhitAddhealthAttributes : RevolverAttributes.OnHitAttributes.AddOnhitAddhealthAttributes() 
	
		open class GenerateRageOnDmgAttributes : RevolverAttributes.OnHitAttributes.GenerateRageOnDmgAttributes(), ItemAttribute<Boolean> 
	
		open class FallingAttributes : RevolverAttributes.OnHitAttributes.FallingAttributes() 
	}
	
	open class OnKillAttributes : RevolverAttributes.OnKillAttributes() 
	
	open class ReloadingAttributes : RevolverAttributes.ReloadingAttributes() 
	
	open class ResistanceAttributes : RevolverAttributes.ResistanceAttributes() {
		override val multDmgTakenCrits: MultDmgtakenFromCritAttributes = MultDmgtakenFromCritAttributes()
	
		override val multDmgTakenFire: MultDmgtakenFromFireAttributes = MultDmgtakenFromFireAttributes()
	
		override val multDmgTakenBullets: MultDmgtakenFromBulletsAttributes = MultDmgtakenFromBulletsAttributes()
	
		override val vaccinator: VaccinatorAttributes = VaccinatorAttributes()
	
		open class MultDmgtakenFromCritAttributes : RevolverAttributes.ResistanceAttributes.MultDmgtakenFromCritAttributes(), ItemAttribute<Number> 
	
		open class MultDmgtakenFromFireAttributes : RevolverAttributes.ResistanceAttributes.MultDmgtakenFromFireAttributes(), ItemAttribute<Number> 
	
		open class MultDmgtakenFromBulletsAttributes : RevolverAttributes.ResistanceAttributes.MultDmgtakenFromBulletsAttributes(), ItemAttribute<Number> 
	
		open class VaccinatorAttributes : RevolverAttributes.ResistanceAttributes.VaccinatorAttributes() 
	}
	
	open class RevengeCritsAttributes : RevolverAttributes.RevengeCritsAttributes() 
	
	open class StatusEffectsAttributes : RevolverAttributes.StatusEffectsAttributes() 
	
	open class TauntingAttributes : RevolverAttributes.TauntingAttributes() 
	
	open class SwapWeaponsAttributes : RevolverAttributes.SwapWeaponsAttributes() {
		override val deploy: DeployAttributes = DeployAttributes()
	
		open class DeployAttributes : RevolverAttributes.SwapWeaponsAttributes.DeployAttributes() 
	}
	
	open class WhenHitAttributes : RevolverAttributes.WhenHitAttributes() 
	
	open class RagdollsAttributes : RevolverAttributes.RagdollsAttributes() 
	
	open class BuffItemsAttributes : RevolverAttributes.BuffItemsAttributes() 
	
	open class CloakAttributes : RevolverAttributes.CloakAttributes() 
	
	open class DisguiseAttributes : RevolverAttributes.DisguiseAttributes() 
	
	open class HudAttributes : RevolverAttributes.HudAttributes() 
	
	open class SpyOnlyAttributes : RevolverAttributes.SpyOnlyAttributes() 
	
	object Inherited : RevolverSecondaryAttributes 
}