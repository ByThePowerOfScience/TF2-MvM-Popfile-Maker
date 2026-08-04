package btpos.source.vdfdsl.tf2.itemattributes

import btpos.source.vdfdsl.modeling.*
import btpos.source.vdfdsl.serialization.codecs.*
import btpos.source.vdfdsl.tf2.itemattributes.impl.*
import btpos.source.vdfdsl.tf2.tftypes.*
import java.util.*
import kotlin.time.Duration

interface GrenadeGasAttributes : IBlockScoped, WeaponBaseGrenadeAttributes {
	companion object : IBlockScoped {
		/**
		 * Attributes related to afterburn.
		 */
		private val afterburn: AfterburnAttributes = AfterburnAttributes()
	
		/**
		 * Attributes related to max ammo, clip-size, and resupply.
		 */
		private val ammo: AmmoAttributes = AmmoAttributes()
	
		/**
		 * Attributes related to moving, constructing, and interacting with the Engineer's buildings.
		 */
		private val buildings: BuildingsAttributes = BuildingsAttributes()
	
		/**
		 * Attributes related to dealing or preventing critical hits and mini-crits.
		 */
		private val crits: CritsAttributes = CritsAttributes()
	
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
		 * Attributes governing rate-of-fire.
		 */
		private val firing: FiringAttributes = FiringAttributes()
	
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
		 * All attributes governing what projectile or bullet this weapon can fire, and how that projectile or bullet acts once fired.
		 * 
		 * Each type of projectile also has a subcategory with every attribute it checks for on the gun that fired it.
		 */
		private val projectiles: ProjectilesAttributes = ProjectilesAttributes()
	
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
	 * Attributes related to afterburn.
	 */
	override val afterburn: AfterburnAttributes get() = GrenadeGasAttributes.afterburn
	
	/**
	 * Attributes related to max ammo, clip-size, and resupply.
	 */
	override val ammo: AmmoAttributes get() = GrenadeGasAttributes.ammo
	
	/**
	 * Attributes related to moving, constructing, and interacting with the Engineer's buildings.
	 */
	override val buildings: BuildingsAttributes get() = GrenadeGasAttributes.buildings
	
	/**
	 * Attributes related to dealing or preventing critical hits and mini-crits.
	 */
	override val crits: CritsAttributes get() = GrenadeGasAttributes.crits
	
	/**
	 * Multipliers governing the damage you deal to different targets.
	 * 
	 * For damage _taken_, see [resistance].
	 */
	override val damage: DamageAttributes get() = GrenadeGasAttributes.damage
	
	/**
	 * Attributes governing the Demoknight's shield-charge.
	 * 
	 * Some of these attributes are hardcoded to only work on the Demoman. These are noted in their documentation.
	 */
	override val demoCharge: DemoChargeAttributes get() = GrenadeGasAttributes.demoCharge
	
	/**
	 * Attributes governing rate-of-fire.
	 */
	override val firing: FiringAttributes get() = GrenadeGasAttributes.firing
	
	/**
	 * Attributes related to the player's HP stat and healing players.
	 */
	override val healthAndHealing: HealthAndHealingAttributes get() = GrenadeGasAttributes.healthAndHealing
	
	/**
	 * Attributes governing how much you are pushed when hit by different push sources.
	 */
	override val knockbackReceived: KnockbackReceivedAttributes get() = GrenadeGasAttributes.knockbackReceived
	
	/**
	 * Attributes related to the scoreboard, killfeed, HuD, item descriptions, and interactions with the wider game-state. (including capture rate)
	 */
	override val meta: MetaAttributes get() = GrenadeGasAttributes.meta
	
	/**
	 * Attributes related to rage and items that recharge on a meter/timer.
	 */
	override val meter: MeterAttributes get() = GrenadeGasAttributes.meter
	
	/**
	 * Attributes governing the player's move-speed, jump height, swimming, air-strafing capabilities, and all things mobility-related.
	 */
	override val movement: MovementAttributes get() = GrenadeGasAttributes.movement
	
	/**
	 * Attributes related to the collection and passive effects of "heads".
	 * 
	 * While originally made for the Eyelander, this stat is used by many other weapons that track players hit or killed: the Vita-Saw, the Bazaar Bargain, etc.
	 * 
	 * For "revenge crits", like the Frontier Justice, Manmelter, and Diamondback, see [revengeCrits].
	 */
	override val heads: HeadsAttributes get() = GrenadeGasAttributes.heads
	
	/**
	 * Attributes governing what happens when you hit another player, such as applying conditions or debuffs.
	 * 
	 * @see onKill
	 */
	override val onHit: OnHitAttributes get() = GrenadeGasAttributes.onHit
	
	/**
	 * Attributes governing what happens when you kill another player, usually applying bonuses to yourself.
	 * 
	 * @see onHit
	 */
	override val onKill: OnKillAttributes get() = GrenadeGasAttributes.onKill
	
	/**
	 * All attributes governing what projectile or bullet this weapon can fire, and how that projectile or bullet acts once fired.
	 * 
	 * Each type of projectile also has a subcategory with every attribute it checks for on the gun that fired it.
	 */
	override val projectiles: ProjectilesAttributes get() = GrenadeGasAttributes.projectiles
	
	/**
	 * Attributes governing either the time taken to reload a weapon's magazine or the cooldown time for weapons that draw directly from reserve ammo like the Sniper Rifle and Flare Gun.
	 */
	override val reloading: ReloadingAttributes get() = GrenadeGasAttributes.reloading
	
	/**
	 * Attributes governing how much damage the player takes from various sources.  Also includes the passive and active effects of the Vaccinator on the user.
	 * 
	 * For outgoing damage, see [damage].
	 */
	override val resistance: ResistanceAttributes get() = GrenadeGasAttributes.resistance
	
	/**
	 * Attributes governing the collection of "Revenge Crits", guaranteed criticals gained by fulfilling certain requirements.
	 * 
	 * It should be noted that for the most part, these attributes just state whether or not a weapon CAN gain revenge crits. Actually _using_ them is bound to the weapon type, not any attribute.
	 * 
	 * For the collection and usage of "heads", see [heads].
	 */
	override val revengeCrits: RevengeCritsAttributes get() = GrenadeGasAttributes.revengeCrits
	
	/**
	 * Attributes related to Mad Milk, Jarate, and Gas.
	 * 
	 * This will be empty for most weapons unless a mod adds something.  Notably, "explode on ignite" is available for all weapons.
	 */
	override val statusEffects: StatusEffectsAttributes get() = GrenadeGasAttributes.statusEffects
	
	/**
	 * Attributes governing taunt speed and the effects of taunts.
	 */
	override val taunting: TauntingAttributes get() = GrenadeGasAttributes.taunting
	
	/**
	 * Attributes governing weapon deploy/holster speed, things that activate when a weapon is deployed, and whether a player can swap weapons at all.
	 */
	override val swapWeapons: SwapWeaponsAttributes get() = GrenadeGasAttributes.swapWeapons
	
	/**
	 * Attributes governing what happens when this player is hit by an enemy.
	 * 
	 * For what happens when _this player_ hits an enemy, see [onHit] and [onKill].
	 */
	override val whenHit: WhenHitAttributes get() = GrenadeGasAttributes.whenHit
	
	/**
	 * Attributes governing ragdolls, gibs, and statues.
	 */
	override val ragdolls: RagdollsAttributes get() = GrenadeGasAttributes.ragdolls
	
	override val buffItems: BuffItemsAttributes get() = GrenadeGasAttributes.buffItems
	
	override val cloak: CloakAttributes get() = GrenadeGasAttributes.cloak
	
	/**
	 * Attributes related to disguising.
	 */
	override val disguise: DisguiseAttributes get() = GrenadeGasAttributes.disguise
	
	override val hud: HudAttributes get() = GrenadeGasAttributes.hud
	
	override val spyOnly: SpyOnlyAttributes get() = GrenadeGasAttributes.spyOnly
	
	open class AfterburnAttributes : WeaponBaseGrenadeAttributes.AfterburnAttributes() 
	
	open class AmmoAttributes : WeaponBaseGrenadeAttributes.AmmoAttributes() {
		override val clipSize: ClipSizeAttributes = ClipSizeAttributes()
	
		override val modMaxAmmo: MaxAmmoAttributes = MaxAmmoAttributes()
	
		open class ClipSizeAttributes : WeaponBaseGrenadeAttributes.AmmoAttributes.ClipSizeAttributes() 
	
		open class MaxAmmoAttributes : WeaponBaseGrenadeAttributes.AmmoAttributes.MaxAmmoAttributes() 
	}
	
	open class BuildingsAttributes : WeaponBaseGrenadeAttributes.BuildingsAttributes() {
		override val sentryGun: SentryGunAttributes = SentryGunAttributes()
	
		override val dispenser: DispenserAttributes = DispenserAttributes()
	
		override val teleporter: TeleporterAttributes = TeleporterAttributes()
	
		open class SentryGunAttributes : WeaponBaseGrenadeAttributes.BuildingsAttributes.SentryGunAttributes() 
	
		open class DispenserAttributes : WeaponBaseGrenadeAttributes.BuildingsAttributes.DispenserAttributes() 
	
		open class TeleporterAttributes : WeaponBaseGrenadeAttributes.BuildingsAttributes.TeleporterAttributes() 
	}
	
	open class CritsAttributes : WeaponBaseGrenadeAttributes.CritsAttributes() 
	
	open class DamageAttributes : WeaponBaseGrenadeAttributes.DamageAttributes() {
		override val alien: AlienAttributes = AlienAttributes()
	
		open class AlienAttributes : WeaponBaseGrenadeAttributes.DamageAttributes.AlienAttributes() 
	}
	
	open class DemoChargeAttributes : WeaponBaseGrenadeAttributes.DemoChargeAttributes() {
		override val multChargeTurnControl: MultChargeTurnControlAttributes = MultChargeTurnControlAttributes()
	
		open class MultChargeTurnControlAttributes : WeaponBaseGrenadeAttributes.DemoChargeAttributes.MultChargeTurnControlAttributes() 
	}
	
	open class FiringAttributes : WeaponBaseGrenadeAttributes.FiringAttributes() {
		override val fireRate: FireRateAttributes = FireRateAttributes()
	
		open class FireRateAttributes : WeaponBaseGrenadeAttributes.FiringAttributes.FireRateAttributes() 
	}
	
	open class HealthAndHealingAttributes : WeaponBaseGrenadeAttributes.HealthAndHealingAttributes() {
		override val healthRegen: HealthRegenAttributes = HealthRegenAttributes()
	
		override val maxHealthAdditiveBonus: MaxHealthAdditiveAttributes = MaxHealthAdditiveAttributes()
	
		open class HealthRegenAttributes : WeaponBaseGrenadeAttributes.HealthAndHealingAttributes.HealthRegenAttributes() 
	
		open class MaxHealthAdditiveAttributes : WeaponBaseGrenadeAttributes.HealthAndHealingAttributes.MaxHealthAdditiveAttributes() 
	}
	
	open class KnockbackReceivedAttributes : WeaponBaseGrenadeAttributes.KnockbackReceivedAttributes() {
		override val damageForceReduction: DamageForceReductionAttributes = DamageForceReductionAttributes()
	
		open class DamageForceReductionAttributes : WeaponBaseGrenadeAttributes.KnockbackReceivedAttributes.DamageForceReductionAttributes() 
	}
	
	open class MetaAttributes : WeaponBaseGrenadeAttributes.MetaAttributes() {
		override val killfeed: KillfeedAttributes = KillfeedAttributes()
	
		override val viewmodel: ViewmodelAttributes = ViewmodelAttributes()
	
		override val items: ItemsAttributes = ItemsAttributes()
	
		override val particles: ParticlesAttributes = ParticlesAttributes()
	
		override val noisemakers: NoisemakersAttributes = NoisemakersAttributes()
	
		override val player: PlayerAttributes = PlayerAttributes()
	
		override val gameplay: GameplayAttributes = GameplayAttributes()
	
		open class KillfeedAttributes : WeaponBaseGrenadeAttributes.MetaAttributes.KillfeedAttributes() 
	
		open class ViewmodelAttributes : WeaponBaseGrenadeAttributes.MetaAttributes.ViewmodelAttributes() 
	
		open class ItemsAttributes : WeaponBaseGrenadeAttributes.MetaAttributes.ItemsAttributes() 
	
		open class ParticlesAttributes : WeaponBaseGrenadeAttributes.MetaAttributes.ParticlesAttributes() 
	
		open class NoisemakersAttributes : WeaponBaseGrenadeAttributes.MetaAttributes.NoisemakersAttributes() 
	
		open class PlayerAttributes : WeaponBaseGrenadeAttributes.MetaAttributes.PlayerAttributes() 
	
		open class GameplayAttributes : WeaponBaseGrenadeAttributes.MetaAttributes.GameplayAttributes() 
	}
	
	open class MeterAttributes : WeaponBaseGrenadeAttributes.MeterAttributes() {
		override val generateRageOnDamage: GenerateRageOnDamageAttributes = GenerateRageOnDamageAttributes()
	
		open class GenerateRageOnDamageAttributes : WeaponBaseGrenadeAttributes.MeterAttributes.GenerateRageOnDamageAttributes() 
	}
	
	open class MovementAttributes : WeaponBaseGrenadeAttributes.MovementAttributes() {
		override val moveSpeed: MoveSpeedAttributes = MoveSpeedAttributes()
	
		override val increasedJumpHeight: jumpHeightAttributes = jumpHeightAttributes()
	
		open class MoveSpeedAttributes : WeaponBaseGrenadeAttributes.MovementAttributes.MoveSpeedAttributes() {
			override val aimingMovespeedIncreased: AimingMovespeedAttributes = AimingMovespeedAttributes()
	
			override val moveSpeedPenalty: MoveSpeedAttributes = MoveSpeedAttributes()
	
			open class AimingMovespeedAttributes : WeaponBaseGrenadeAttributes.MovementAttributes.MoveSpeedAttributes.AimingMovespeedAttributes() 
	
			open class MoveSpeedAttributes : WeaponBaseGrenadeAttributes.MovementAttributes.MoveSpeedAttributes.MoveSpeedAttributes() 
		}
	
		open class jumpHeightAttributes : WeaponBaseGrenadeAttributes.MovementAttributes.jumpHeightAttributes() 
	}
	
	open class HeadsAttributes : WeaponBaseGrenadeAttributes.HeadsAttributes() 
	
	open class OnHitAttributes : WeaponBaseGrenadeAttributes.OnHitAttributes() {
		override val healOnHitForRapidfire: HealOnHitForRapidfireAttributes = HealOnHitForRapidfireAttributes()
	
		override val generateRageOnDamage: GenerateRageOnDamageAttributes = GenerateRageOnDamageAttributes()
	
		override val falling: FallingAttributes = FallingAttributes()
	
		open class HealOnHitForRapidfireAttributes : WeaponBaseGrenadeAttributes.OnHitAttributes.HealOnHitForRapidfireAttributes() 
	
		open class GenerateRageOnDamageAttributes : WeaponBaseGrenadeAttributes.OnHitAttributes.GenerateRageOnDamageAttributes() 
	
		open class FallingAttributes : WeaponBaseGrenadeAttributes.OnHitAttributes.FallingAttributes() 
	}
	
	open class OnKillAttributes : WeaponBaseGrenadeAttributes.OnKillAttributes() 
	
	open class ProjectilesAttributes : WeaponBaseGrenadeAttributes.ProjectilesAttributes() {
		override val projectilePenetration: ProjectilePenetrationAttributes = ProjectilePenetrationAttributes()
	
		override val bullets: BulletsAttributes = BulletsAttributes()
	
		open class ProjectilePenetrationAttributes : WeaponBaseGrenadeAttributes.ProjectilesAttributes.ProjectilePenetrationAttributes(), ItemAttribute<Int> 
	
		open class BulletsAttributes : WeaponBaseGrenadeAttributes.ProjectilesAttributes.BulletsAttributes() 
	}
	
	open class ReloadingAttributes : WeaponBaseGrenadeAttributes.ReloadingAttributes() 
	
	open class ResistanceAttributes : WeaponBaseGrenadeAttributes.ResistanceAttributes() {
		override val dmgTakenFromCritReduced: DmgTakenFromCritReducedAttributes = DmgTakenFromCritReducedAttributes()
	
		override val dmgTakenFromFireReduced: DmgTakenFromFireReducedAttributes = DmgTakenFromFireReducedAttributes()
	
		override val dmgTakenFromBulletsReduced: DmgTakenFromBulletsReducedAttributes = DmgTakenFromBulletsReducedAttributes()
	
		override val vaccinator: VaccinatorAttributes = VaccinatorAttributes()
	
		open class DmgTakenFromCritReducedAttributes : WeaponBaseGrenadeAttributes.ResistanceAttributes.DmgTakenFromCritReducedAttributes() 
	
		open class DmgTakenFromFireReducedAttributes : WeaponBaseGrenadeAttributes.ResistanceAttributes.DmgTakenFromFireReducedAttributes() 
	
		open class DmgTakenFromBulletsReducedAttributes : WeaponBaseGrenadeAttributes.ResistanceAttributes.DmgTakenFromBulletsReducedAttributes() 
	
		open class VaccinatorAttributes : WeaponBaseGrenadeAttributes.ResistanceAttributes.VaccinatorAttributes() 
	}
	
	open class RevengeCritsAttributes : WeaponBaseGrenadeAttributes.RevengeCritsAttributes() 
	
	open class StatusEffectsAttributes : WeaponBaseGrenadeAttributes.StatusEffectsAttributes() 
	
	open class TauntingAttributes : WeaponBaseGrenadeAttributes.TauntingAttributes() 
	
	open class SwapWeaponsAttributes : WeaponBaseGrenadeAttributes.SwapWeaponsAttributes() {
		override val deploy: DeployAttributes = DeployAttributes()
	
		open class DeployAttributes : WeaponBaseGrenadeAttributes.SwapWeaponsAttributes.DeployAttributes() 
	}
	
	open class WhenHitAttributes : WeaponBaseGrenadeAttributes.WhenHitAttributes() 
	
	open class RagdollsAttributes : WeaponBaseGrenadeAttributes.RagdollsAttributes() 
	
	open class BuffItemsAttributes : WeaponBaseGrenadeAttributes.BuffItemsAttributes() 
	
	open class CloakAttributes : WeaponBaseGrenadeAttributes.CloakAttributes() 
	
	open class DisguiseAttributes : WeaponBaseGrenadeAttributes.DisguiseAttributes() 
	
	open class HudAttributes : WeaponBaseGrenadeAttributes.HudAttributes() 
	
	open class SpyOnlyAttributes : WeaponBaseGrenadeAttributes.SpyOnlyAttributes() 
	
	object Inherited : GrenadeGasAttributes 
}