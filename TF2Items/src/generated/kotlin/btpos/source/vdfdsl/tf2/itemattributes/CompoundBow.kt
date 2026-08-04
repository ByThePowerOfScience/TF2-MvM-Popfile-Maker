package btpos.source.vdfdsl.tf2.itemattributes

import btpos.source.vdfdsl.modeling.*
import btpos.source.vdfdsl.serialization.codecs.*
import btpos.source.vdfdsl.tf2.itemattributes.impl.*
import btpos.source.vdfdsl.tf2.tftypes.*
import java.util.*
import kotlin.time.Duration

interface CompoundBowAttributes : IBlockScoped, StickybombLauncherAttributes {
	companion object : IBlockScoped {
		/**
		 * In-Game: "+N% faster reload time"
		 * 
		 * Mult applied to reload speed.
		 */
		val fasterReloadRate: ItemAttributeNamed<Number> = ItemAttributeNamed("faster reload rate")
	
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
	 * In-Game: "+N% faster reload time"
	 * 
	 * Mult applied to reload speed.
	 */
	val fasterReloadRate: ItemAttributeNamed<Number> get() = CompoundBowAttributes.fasterReloadRate
	
	/**
	 * Attributes related to max ammo, clip-size, and resupply.
	 */
	override val ammo: AmmoAttributes get() = CompoundBowAttributes.ammo
	
	/**
	 * Multipliers governing the damage you deal to different targets.
	 * 
	 * For damage _taken_, see [resistance].
	 */
	override val damage: DamageAttributes get() = CompoundBowAttributes.damage
	
	/**
	 * Attributes governing rate-of-fire.
	 */
	override val firing: FiringAttributes get() = CompoundBowAttributes.firing
	
	/**
	 * All attributes governing what projectile or bullet this weapon can fire, and how that projectile or bullet acts once fired.
	 * 
	 * Each type of projectile also has a subcategory with every attribute it checks for on the gun that fired it.
	 */
	override val projectiles: ProjectilesAttributes get() = CompoundBowAttributes.projectiles
	
	/**
	 * Attributes related to afterburn.
	 */
	override val afterburn: AfterburnAttributes get() = CompoundBowAttributes.afterburn
	
	/**
	 * Attributes related to moving, constructing, and interacting with the Engineer's buildings.
	 */
	override val buildings: BuildingsAttributes get() = CompoundBowAttributes.buildings
	
	/**
	 * Attributes related to dealing or preventing critical hits and mini-crits.
	 */
	override val crits: CritsAttributes get() = CompoundBowAttributes.crits
	
	/**
	 * Attributes governing the Demoknight's shield-charge.
	 * 
	 * Some of these attributes are hardcoded to only work on the Demoman. These are noted in their documentation.
	 */
	override val demoCharge: DemoChargeAttributes get() = CompoundBowAttributes.demoCharge
	
	/**
	 * Attributes related to the player's HP stat and healing players.
	 */
	override val healthAndHealing: HealthAndHealingAttributes get() = CompoundBowAttributes.healthAndHealing
	
	/**
	 * Attributes governing how much you are pushed when hit by different push sources.
	 */
	override val knockbackReceived: KnockbackReceivedAttributes get() = CompoundBowAttributes.knockbackReceived
	
	/**
	 * Attributes related to the scoreboard, killfeed, HuD, item descriptions, and interactions with the wider game-state. (including capture rate)
	 */
	override val meta: MetaAttributes get() = CompoundBowAttributes.meta
	
	/**
	 * Attributes related to rage and items that recharge on a meter/timer.
	 */
	override val meter: MeterAttributes get() = CompoundBowAttributes.meter
	
	/**
	 * Attributes governing the player's move-speed, jump height, swimming, air-strafing capabilities, and all things mobility-related.
	 */
	override val movement: MovementAttributes get() = CompoundBowAttributes.movement
	
	/**
	 * Attributes related to the collection and passive effects of "heads".
	 * 
	 * While originally made for the Eyelander, this stat is used by many other weapons that track players hit or killed: the Vita-Saw, the Bazaar Bargain, etc.
	 * 
	 * For "revenge crits", like the Frontier Justice, Manmelter, and Diamondback, see [revengeCrits].
	 */
	override val heads: HeadsAttributes get() = CompoundBowAttributes.heads
	
	/**
	 * Attributes governing what happens when you hit another player, such as applying conditions or debuffs.
	 * 
	 * @see onKill
	 */
	override val onHit: OnHitAttributes get() = CompoundBowAttributes.onHit
	
	/**
	 * Attributes governing what happens when you kill another player, usually applying bonuses to yourself.
	 * 
	 * @see onHit
	 */
	override val onKill: OnKillAttributes get() = CompoundBowAttributes.onKill
	
	/**
	 * Attributes governing either the time taken to reload a weapon's magazine or the cooldown time for weapons that draw directly from reserve ammo like the Sniper Rifle and Flare Gun.
	 */
	override val reloading: ReloadingAttributes get() = CompoundBowAttributes.reloading
	
	/**
	 * Attributes governing how much damage the player takes from various sources.  Also includes the passive and active effects of the Vaccinator on the user.
	 * 
	 * For outgoing damage, see [damage].
	 */
	override val resistance: ResistanceAttributes get() = CompoundBowAttributes.resistance
	
	/**
	 * Attributes governing the collection of "Revenge Crits", guaranteed criticals gained by fulfilling certain requirements.
	 * 
	 * It should be noted that for the most part, these attributes just state whether or not a weapon CAN gain revenge crits. Actually _using_ them is bound to the weapon type, not any attribute.
	 * 
	 * For the collection and usage of "heads", see [heads].
	 */
	override val revengeCrits: RevengeCritsAttributes get() = CompoundBowAttributes.revengeCrits
	
	/**
	 * Attributes related to Mad Milk, Jarate, and Gas.
	 * 
	 * This will be empty for most weapons unless a mod adds something.  Notably, "explode on ignite" is available for all weapons.
	 */
	override val statusEffects: StatusEffectsAttributes get() = CompoundBowAttributes.statusEffects
	
	/**
	 * Attributes governing taunt speed and the effects of taunts.
	 */
	override val taunting: TauntingAttributes get() = CompoundBowAttributes.taunting
	
	/**
	 * Attributes governing weapon deploy/holster speed, things that activate when a weapon is deployed, and whether a player can swap weapons at all.
	 */
	override val swapWeapons: SwapWeaponsAttributes get() = CompoundBowAttributes.swapWeapons
	
	/**
	 * Attributes governing what happens when this player is hit by an enemy.
	 * 
	 * For what happens when _this player_ hits an enemy, see [onHit] and [onKill].
	 */
	override val whenHit: WhenHitAttributes get() = CompoundBowAttributes.whenHit
	
	/**
	 * Attributes governing ragdolls, gibs, and statues.
	 */
	override val ragdolls: RagdollsAttributes get() = CompoundBowAttributes.ragdolls
	
	override val buffItems: BuffItemsAttributes get() = CompoundBowAttributes.buffItems
	
	override val cloak: CloakAttributes get() = CompoundBowAttributes.cloak
	
	/**
	 * Attributes related to disguising.
	 */
	override val disguise: DisguiseAttributes get() = CompoundBowAttributes.disguise
	
	override val hud: HudAttributes get() = CompoundBowAttributes.hud
	
	override val spyOnly: SpyOnlyAttributes get() = CompoundBowAttributes.spyOnly
	
	open class AmmoAttributes : StickybombLauncherAttributes.AmmoAttributes() {
		override val clipSize: ClipSizeAttributes = ClipSizeAttributes()
	
		override val modMaxAmmo: MaxAmmoAttributes = MaxAmmoAttributes()
	
		open class ClipSizeAttributes : StickybombLauncherAttributes.AmmoAttributes.ClipSizeAttributes() 
	
		open class MaxAmmoAttributes : StickybombLauncherAttributes.AmmoAttributes.MaxAmmoAttributes() 
	}
	
	open class DamageAttributes : StickybombLauncherAttributes.DamageAttributes() {
		override val alien: AlienAttributes = AlienAttributes()
	
		open class AlienAttributes : StickybombLauncherAttributes.DamageAttributes.AlienAttributes() 
	}
	
	open class FiringAttributes : StickybombLauncherAttributes.FiringAttributes() {
		override val fireRate: FireRateAttributes = FireRateAttributes()
	
		open class FireRateAttributes : StickybombLauncherAttributes.FiringAttributes.FireRateAttributes() 
	}
	
	open class ProjectilesAttributes : StickybombLauncherAttributes.ProjectilesAttributes() {
		override val bullets: BulletsAttributes = BulletsAttributes()
	
		override val projectilePenetration: ProjectilePenetrationAttributes = ProjectilePenetrationAttributes()
	
		open class BulletsAttributes : StickybombLauncherAttributes.ProjectilesAttributes.BulletsAttributes() 
	
		open class ProjectilePenetrationAttributes : StickybombLauncherAttributes.ProjectilesAttributes.ProjectilePenetrationAttributes(), ItemAttribute<Int> 
	}
	
	open class AfterburnAttributes : StickybombLauncherAttributes.AfterburnAttributes() 
	
	open class BuildingsAttributes : StickybombLauncherAttributes.BuildingsAttributes() {
		override val sentryGun: SentryGunAttributes = SentryGunAttributes()
	
		override val dispenser: DispenserAttributes = DispenserAttributes()
	
		override val teleporter: TeleporterAttributes = TeleporterAttributes()
	
		open class SentryGunAttributes : StickybombLauncherAttributes.BuildingsAttributes.SentryGunAttributes() 
	
		open class DispenserAttributes : StickybombLauncherAttributes.BuildingsAttributes.DispenserAttributes() 
	
		open class TeleporterAttributes : StickybombLauncherAttributes.BuildingsAttributes.TeleporterAttributes() 
	}
	
	open class CritsAttributes : StickybombLauncherAttributes.CritsAttributes() 
	
	open class DemoChargeAttributes : StickybombLauncherAttributes.DemoChargeAttributes() {
		override val multChargeTurnControl: MultChargeTurnControlAttributes = MultChargeTurnControlAttributes()
	
		open class MultChargeTurnControlAttributes : StickybombLauncherAttributes.DemoChargeAttributes.MultChargeTurnControlAttributes() 
	}
	
	open class HealthAndHealingAttributes : StickybombLauncherAttributes.HealthAndHealingAttributes() {
		override val healthRegen: HealthRegenAttributes = HealthRegenAttributes()
	
		override val maxHealthAdditiveBonus: MaxHealthAdditiveAttributes = MaxHealthAdditiveAttributes()
	
		open class HealthRegenAttributes : StickybombLauncherAttributes.HealthAndHealingAttributes.HealthRegenAttributes() 
	
		open class MaxHealthAdditiveAttributes : StickybombLauncherAttributes.HealthAndHealingAttributes.MaxHealthAdditiveAttributes() 
	}
	
	open class KnockbackReceivedAttributes : StickybombLauncherAttributes.KnockbackReceivedAttributes() {
		override val damageForceReduction: DamageForceReductionAttributes = DamageForceReductionAttributes()
	
		open class DamageForceReductionAttributes : StickybombLauncherAttributes.KnockbackReceivedAttributes.DamageForceReductionAttributes() 
	}
	
	open class MetaAttributes : StickybombLauncherAttributes.MetaAttributes() {
		override val killfeed: KillfeedAttributes = KillfeedAttributes()
	
		override val viewmodel: ViewmodelAttributes = ViewmodelAttributes()
	
		override val items: ItemsAttributes = ItemsAttributes()
	
		override val particles: ParticlesAttributes = ParticlesAttributes()
	
		override val noisemakers: NoisemakersAttributes = NoisemakersAttributes()
	
		override val player: PlayerAttributes = PlayerAttributes()
	
		override val gameplay: GameplayAttributes = GameplayAttributes()
	
		open class KillfeedAttributes : StickybombLauncherAttributes.MetaAttributes.KillfeedAttributes() 
	
		open class ViewmodelAttributes : StickybombLauncherAttributes.MetaAttributes.ViewmodelAttributes() 
	
		open class ItemsAttributes : StickybombLauncherAttributes.MetaAttributes.ItemsAttributes() 
	
		open class ParticlesAttributes : StickybombLauncherAttributes.MetaAttributes.ParticlesAttributes() 
	
		open class NoisemakersAttributes : StickybombLauncherAttributes.MetaAttributes.NoisemakersAttributes() 
	
		open class PlayerAttributes : StickybombLauncherAttributes.MetaAttributes.PlayerAttributes() 
	
		open class GameplayAttributes : StickybombLauncherAttributes.MetaAttributes.GameplayAttributes() 
	}
	
	open class MeterAttributes : StickybombLauncherAttributes.MeterAttributes() {
		override val generateRageOnDamage: GenerateRageOnDamageAttributes = GenerateRageOnDamageAttributes()
	
		open class GenerateRageOnDamageAttributes : StickybombLauncherAttributes.MeterAttributes.GenerateRageOnDamageAttributes() 
	}
	
	open class MovementAttributes : StickybombLauncherAttributes.MovementAttributes() {
		override val moveSpeed: MoveSpeedAttributes = MoveSpeedAttributes()
	
		override val increasedJumpHeight: jumpHeightAttributes = jumpHeightAttributes()
	
		open class MoveSpeedAttributes : StickybombLauncherAttributes.MovementAttributes.MoveSpeedAttributes() {
			override val aimingMovespeedIncreased: AimingMovespeedAttributes = AimingMovespeedAttributes()
	
			override val moveSpeedPenalty: MoveSpeedAttributes = MoveSpeedAttributes()
	
			open class AimingMovespeedAttributes : StickybombLauncherAttributes.MovementAttributes.MoveSpeedAttributes.AimingMovespeedAttributes() 
	
			open class MoveSpeedAttributes : StickybombLauncherAttributes.MovementAttributes.MoveSpeedAttributes.MoveSpeedAttributes() 
		}
	
		open class jumpHeightAttributes : StickybombLauncherAttributes.MovementAttributes.jumpHeightAttributes() 
	}
	
	open class HeadsAttributes : StickybombLauncherAttributes.HeadsAttributes() 
	
	open class OnHitAttributes : StickybombLauncherAttributes.OnHitAttributes() {
		override val healOnHitForRapidfire: HealOnHitForRapidfireAttributes = HealOnHitForRapidfireAttributes()
	
		override val generateRageOnDamage: GenerateRageOnDamageAttributes = GenerateRageOnDamageAttributes()
	
		override val falling: FallingAttributes = FallingAttributes()
	
		open class HealOnHitForRapidfireAttributes : StickybombLauncherAttributes.OnHitAttributes.HealOnHitForRapidfireAttributes() 
	
		open class GenerateRageOnDamageAttributes : StickybombLauncherAttributes.OnHitAttributes.GenerateRageOnDamageAttributes() 
	
		open class FallingAttributes : StickybombLauncherAttributes.OnHitAttributes.FallingAttributes() 
	}
	
	open class OnKillAttributes : StickybombLauncherAttributes.OnKillAttributes() 
	
	open class ReloadingAttributes : StickybombLauncherAttributes.ReloadingAttributes() 
	
	open class ResistanceAttributes : StickybombLauncherAttributes.ResistanceAttributes() {
		override val dmgTakenFromCritReduced: DmgTakenFromCritReducedAttributes = DmgTakenFromCritReducedAttributes()
	
		override val dmgTakenFromFireReduced: DmgTakenFromFireReducedAttributes = DmgTakenFromFireReducedAttributes()
	
		override val dmgTakenFromBulletsReduced: DmgTakenFromBulletsReducedAttributes = DmgTakenFromBulletsReducedAttributes()
	
		override val vaccinator: VaccinatorAttributes = VaccinatorAttributes()
	
		open class DmgTakenFromCritReducedAttributes : StickybombLauncherAttributes.ResistanceAttributes.DmgTakenFromCritReducedAttributes() 
	
		open class DmgTakenFromFireReducedAttributes : StickybombLauncherAttributes.ResistanceAttributes.DmgTakenFromFireReducedAttributes() 
	
		open class DmgTakenFromBulletsReducedAttributes : StickybombLauncherAttributes.ResistanceAttributes.DmgTakenFromBulletsReducedAttributes() 
	
		open class VaccinatorAttributes : StickybombLauncherAttributes.ResistanceAttributes.VaccinatorAttributes() 
	}
	
	open class RevengeCritsAttributes : StickybombLauncherAttributes.RevengeCritsAttributes() 
	
	open class StatusEffectsAttributes : StickybombLauncherAttributes.StatusEffectsAttributes() 
	
	open class TauntingAttributes : StickybombLauncherAttributes.TauntingAttributes() 
	
	open class SwapWeaponsAttributes : StickybombLauncherAttributes.SwapWeaponsAttributes() {
		override val deploy: DeployAttributes = DeployAttributes()
	
		open class DeployAttributes : StickybombLauncherAttributes.SwapWeaponsAttributes.DeployAttributes() 
	}
	
	open class WhenHitAttributes : StickybombLauncherAttributes.WhenHitAttributes() 
	
	open class RagdollsAttributes : StickybombLauncherAttributes.RagdollsAttributes() 
	
	open class BuffItemsAttributes : StickybombLauncherAttributes.BuffItemsAttributes() 
	
	open class CloakAttributes : StickybombLauncherAttributes.CloakAttributes() 
	
	open class DisguiseAttributes : StickybombLauncherAttributes.DisguiseAttributes() 
	
	open class HudAttributes : StickybombLauncherAttributes.HudAttributes() 
	
	open class SpyOnlyAttributes : StickybombLauncherAttributes.SpyOnlyAttributes() 
	
	object Inherited : CompoundBowAttributes 
}