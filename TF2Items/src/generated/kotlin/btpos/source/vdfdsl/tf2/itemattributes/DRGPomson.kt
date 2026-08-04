package btpos.source.vdfdsl.tf2.itemattributes

import btpos.source.vdfdsl.modeling.*
import btpos.source.vdfdsl.serialization.codecs.*
import btpos.source.vdfdsl.tf2.itemattributes.impl.*
import btpos.source.vdfdsl.tf2.tftypes.*
import java.util.*
import kotlin.time.Duration

interface DRGPomsonAttributes : IBlockScoped, RayGunAttributes {
	companion object : IBlockScoped {
		/**
		 * Attributes related to max ammo, clip-size, and resupply.
		 */
		private val ammo: AmmoAttributes = AmmoAttributes()
	
		/**
		 * All attributes governing what projectile or bullet this weapon can fire, and how that projectile or bullet acts once fired.
		 * 
		 * Each type of projectile also has a subcategory with every attribute it checks for on the gun that fired it.
		 */
		private val projectiles: ProjectilesAttributes = ProjectilesAttributes()
	
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
	 * Attributes related to max ammo, clip-size, and resupply.
	 */
	override val ammo: AmmoAttributes get() = DRGPomsonAttributes.ammo
	
	/**
	 * All attributes governing what projectile or bullet this weapon can fire, and how that projectile or bullet acts once fired.
	 * 
	 * Each type of projectile also has a subcategory with every attribute it checks for on the gun that fired it.
	 */
	override val projectiles: ProjectilesAttributes get() = DRGPomsonAttributes.projectiles
	
	/**
	 * Multipliers governing the damage you deal to different targets.
	 * 
	 * For damage _taken_, see [resistance].
	 */
	override val damage: DamageAttributes get() = DRGPomsonAttributes.damage
	
	/**
	 * Attributes governing rate-of-fire.
	 */
	override val firing: FiringAttributes get() = DRGPomsonAttributes.firing
	
	/**
	 * Attributes related to afterburn.
	 */
	override val afterburn: AfterburnAttributes get() = DRGPomsonAttributes.afterburn
	
	/**
	 * Attributes related to moving, constructing, and interacting with the Engineer's buildings.
	 */
	override val buildings: BuildingsAttributes get() = DRGPomsonAttributes.buildings
	
	/**
	 * Attributes related to dealing or preventing critical hits and mini-crits.
	 */
	override val crits: CritsAttributes get() = DRGPomsonAttributes.crits
	
	/**
	 * Attributes governing the Demoknight's shield-charge.
	 * 
	 * Some of these attributes are hardcoded to only work on the Demoman. These are noted in their documentation.
	 */
	override val demoCharge: DemoChargeAttributes get() = DRGPomsonAttributes.demoCharge
	
	/**
	 * Attributes related to the player's HP stat and healing players.
	 */
	override val healthAndHealing: HealthAndHealingAttributes get() = DRGPomsonAttributes.healthAndHealing
	
	/**
	 * Attributes governing how much you are pushed when hit by different push sources.
	 */
	override val knockbackReceived: KnockbackReceivedAttributes get() = DRGPomsonAttributes.knockbackReceived
	
	/**
	 * Attributes related to the scoreboard, killfeed, HuD, item descriptions, and interactions with the wider game-state. (including capture rate)
	 */
	override val meta: MetaAttributes get() = DRGPomsonAttributes.meta
	
	/**
	 * Attributes related to rage and items that recharge on a meter/timer.
	 */
	override val meter: MeterAttributes get() = DRGPomsonAttributes.meter
	
	/**
	 * Attributes governing the player's move-speed, jump height, swimming, air-strafing capabilities, and all things mobility-related.
	 */
	override val movement: MovementAttributes get() = DRGPomsonAttributes.movement
	
	/**
	 * Attributes related to the collection and passive effects of "heads".
	 * 
	 * While originally made for the Eyelander, this stat is used by many other weapons that track players hit or killed: the Vita-Saw, the Bazaar Bargain, etc.
	 * 
	 * For "revenge crits", like the Frontier Justice, Manmelter, and Diamondback, see [revengeCrits].
	 */
	override val heads: HeadsAttributes get() = DRGPomsonAttributes.heads
	
	/**
	 * Attributes governing what happens when you hit another player, such as applying conditions or debuffs.
	 * 
	 * @see onKill
	 */
	override val onHit: OnHitAttributes get() = DRGPomsonAttributes.onHit
	
	/**
	 * Attributes governing what happens when you kill another player, usually applying bonuses to yourself.
	 * 
	 * @see onHit
	 */
	override val onKill: OnKillAttributes get() = DRGPomsonAttributes.onKill
	
	/**
	 * Attributes governing either the time taken to reload a weapon's magazine or the cooldown time for weapons that draw directly from reserve ammo like the Sniper Rifle and Flare Gun.
	 */
	override val reloading: ReloadingAttributes get() = DRGPomsonAttributes.reloading
	
	/**
	 * Attributes governing how much damage the player takes from various sources.  Also includes the passive and active effects of the Vaccinator on the user.
	 * 
	 * For outgoing damage, see [damage].
	 */
	override val resistance: ResistanceAttributes get() = DRGPomsonAttributes.resistance
	
	/**
	 * Attributes governing the collection of "Revenge Crits", guaranteed criticals gained by fulfilling certain requirements.
	 * 
	 * It should be noted that for the most part, these attributes just state whether or not a weapon CAN gain revenge crits. Actually _using_ them is bound to the weapon type, not any attribute.
	 * 
	 * For the collection and usage of "heads", see [heads].
	 */
	override val revengeCrits: RevengeCritsAttributes get() = DRGPomsonAttributes.revengeCrits
	
	/**
	 * Attributes related to Mad Milk, Jarate, and Gas.
	 * 
	 * This will be empty for most weapons unless a mod adds something.  Notably, "explode on ignite" is available for all weapons.
	 */
	override val statusEffects: StatusEffectsAttributes get() = DRGPomsonAttributes.statusEffects
	
	/**
	 * Attributes governing taunt speed and the effects of taunts.
	 */
	override val taunting: TauntingAttributes get() = DRGPomsonAttributes.taunting
	
	/**
	 * Attributes governing weapon deploy/holster speed, things that activate when a weapon is deployed, and whether a player can swap weapons at all.
	 */
	override val swapWeapons: SwapWeaponsAttributes get() = DRGPomsonAttributes.swapWeapons
	
	/**
	 * Attributes governing what happens when this player is hit by an enemy.
	 * 
	 * For what happens when _this player_ hits an enemy, see [onHit] and [onKill].
	 */
	override val whenHit: WhenHitAttributes get() = DRGPomsonAttributes.whenHit
	
	/**
	 * Attributes governing ragdolls, gibs, and statues.
	 */
	override val ragdolls: RagdollsAttributes get() = DRGPomsonAttributes.ragdolls
	
	override val buffItems: BuffItemsAttributes get() = DRGPomsonAttributes.buffItems
	
	override val cloak: CloakAttributes get() = DRGPomsonAttributes.cloak
	
	/**
	 * Attributes related to disguising.
	 */
	override val disguise: DisguiseAttributes get() = DRGPomsonAttributes.disguise
	
	override val hud: HudAttributes get() = DRGPomsonAttributes.hud
	
	override val spyOnly: SpyOnlyAttributes get() = DRGPomsonAttributes.spyOnly
	
	open class AmmoAttributes : RayGunAttributes.AmmoAttributes() {
		override val clipSize: ClipSizeAttributes = ClipSizeAttributes()
	
		override val modMaxAmmo: MaxAmmoAttributes = MaxAmmoAttributes()
	
		open class ClipSizeAttributes : RayGunAttributes.AmmoAttributes.ClipSizeAttributes() 
	
		open class MaxAmmoAttributes : RayGunAttributes.AmmoAttributes.MaxAmmoAttributes() 
	}
	
	open class ProjectilesAttributes : RayGunAttributes.ProjectilesAttributes() {
		override val bullets: BulletsAttributes = BulletsAttributes()
	
		override val projectilePenetration: ProjectilePenetrationAttributes = ProjectilePenetrationAttributes()
	
		open class BulletsAttributes : RayGunAttributes.ProjectilesAttributes.BulletsAttributes() 
	
		open class ProjectilePenetrationAttributes : RayGunAttributes.ProjectilesAttributes.ProjectilePenetrationAttributes(), ItemAttribute<Int> 
	}
	
	open class DamageAttributes : RayGunAttributes.DamageAttributes() {
		override val alien: AlienAttributes = AlienAttributes()
	
		open class AlienAttributes : RayGunAttributes.DamageAttributes.AlienAttributes() 
	}
	
	open class FiringAttributes : RayGunAttributes.FiringAttributes() {
		override val fireRate: FireRateAttributes = FireRateAttributes()
	
		open class FireRateAttributes : RayGunAttributes.FiringAttributes.FireRateAttributes() 
	}
	
	open class AfterburnAttributes : RayGunAttributes.AfterburnAttributes() 
	
	open class BuildingsAttributes : RayGunAttributes.BuildingsAttributes() {
		override val sentryGun: SentryGunAttributes = SentryGunAttributes()
	
		override val dispenser: DispenserAttributes = DispenserAttributes()
	
		override val teleporter: TeleporterAttributes = TeleporterAttributes()
	
		open class SentryGunAttributes : RayGunAttributes.BuildingsAttributes.SentryGunAttributes() 
	
		open class DispenserAttributes : RayGunAttributes.BuildingsAttributes.DispenserAttributes() 
	
		open class TeleporterAttributes : RayGunAttributes.BuildingsAttributes.TeleporterAttributes() 
	}
	
	open class CritsAttributes : RayGunAttributes.CritsAttributes() 
	
	open class DemoChargeAttributes : RayGunAttributes.DemoChargeAttributes() {
		override val multChargeTurnControl: MultChargeTurnControlAttributes = MultChargeTurnControlAttributes()
	
		open class MultChargeTurnControlAttributes : RayGunAttributes.DemoChargeAttributes.MultChargeTurnControlAttributes() 
	}
	
	open class HealthAndHealingAttributes : RayGunAttributes.HealthAndHealingAttributes() {
		override val healthRegen: HealthRegenAttributes = HealthRegenAttributes()
	
		override val maxHealthAdditiveBonus: MaxHealthAdditiveAttributes = MaxHealthAdditiveAttributes()
	
		open class HealthRegenAttributes : RayGunAttributes.HealthAndHealingAttributes.HealthRegenAttributes() 
	
		open class MaxHealthAdditiveAttributes : RayGunAttributes.HealthAndHealingAttributes.MaxHealthAdditiveAttributes() 
	}
	
	open class KnockbackReceivedAttributes : RayGunAttributes.KnockbackReceivedAttributes() {
		override val damageForceReduction: DamageForceReductionAttributes = DamageForceReductionAttributes()
	
		open class DamageForceReductionAttributes : RayGunAttributes.KnockbackReceivedAttributes.DamageForceReductionAttributes() 
	}
	
	open class MetaAttributes : RayGunAttributes.MetaAttributes() {
		override val killfeed: KillfeedAttributes = KillfeedAttributes()
	
		override val viewmodel: ViewmodelAttributes = ViewmodelAttributes()
	
		override val items: ItemsAttributes = ItemsAttributes()
	
		override val particles: ParticlesAttributes = ParticlesAttributes()
	
		override val noisemakers: NoisemakersAttributes = NoisemakersAttributes()
	
		override val player: PlayerAttributes = PlayerAttributes()
	
		override val gameplay: GameplayAttributes = GameplayAttributes()
	
		open class KillfeedAttributes : RayGunAttributes.MetaAttributes.KillfeedAttributes() 
	
		open class ViewmodelAttributes : RayGunAttributes.MetaAttributes.ViewmodelAttributes() 
	
		open class ItemsAttributes : RayGunAttributes.MetaAttributes.ItemsAttributes() 
	
		open class ParticlesAttributes : RayGunAttributes.MetaAttributes.ParticlesAttributes() 
	
		open class NoisemakersAttributes : RayGunAttributes.MetaAttributes.NoisemakersAttributes() 
	
		open class PlayerAttributes : RayGunAttributes.MetaAttributes.PlayerAttributes() 
	
		open class GameplayAttributes : RayGunAttributes.MetaAttributes.GameplayAttributes() 
	}
	
	open class MeterAttributes : RayGunAttributes.MeterAttributes() {
		override val generateRageOnDamage: GenerateRageOnDamageAttributes = GenerateRageOnDamageAttributes()
	
		open class GenerateRageOnDamageAttributes : RayGunAttributes.MeterAttributes.GenerateRageOnDamageAttributes() 
	}
	
	open class MovementAttributes : RayGunAttributes.MovementAttributes() {
		override val moveSpeed: MoveSpeedAttributes = MoveSpeedAttributes()
	
		override val increasedJumpHeight: jumpHeightAttributes = jumpHeightAttributes()
	
		open class MoveSpeedAttributes : RayGunAttributes.MovementAttributes.MoveSpeedAttributes() {
			override val aimingMovespeedIncreased: AimingMovespeedAttributes = AimingMovespeedAttributes()
	
			override val moveSpeedPenalty: MoveSpeedAttributes = MoveSpeedAttributes()
	
			open class AimingMovespeedAttributes : RayGunAttributes.MovementAttributes.MoveSpeedAttributes.AimingMovespeedAttributes() 
	
			open class MoveSpeedAttributes : RayGunAttributes.MovementAttributes.MoveSpeedAttributes.MoveSpeedAttributes() 
		}
	
		open class jumpHeightAttributes : RayGunAttributes.MovementAttributes.jumpHeightAttributes() 
	}
	
	open class HeadsAttributes : RayGunAttributes.HeadsAttributes() 
	
	open class OnHitAttributes : RayGunAttributes.OnHitAttributes() {
		override val healOnHitForRapidfire: HealOnHitForRapidfireAttributes = HealOnHitForRapidfireAttributes()
	
		override val generateRageOnDamage: GenerateRageOnDamageAttributes = GenerateRageOnDamageAttributes()
	
		override val falling: FallingAttributes = FallingAttributes()
	
		open class HealOnHitForRapidfireAttributes : RayGunAttributes.OnHitAttributes.HealOnHitForRapidfireAttributes() 
	
		open class GenerateRageOnDamageAttributes : RayGunAttributes.OnHitAttributes.GenerateRageOnDamageAttributes() 
	
		open class FallingAttributes : RayGunAttributes.OnHitAttributes.FallingAttributes() 
	}
	
	open class OnKillAttributes : RayGunAttributes.OnKillAttributes() 
	
	open class ReloadingAttributes : RayGunAttributes.ReloadingAttributes() 
	
	open class ResistanceAttributes : RayGunAttributes.ResistanceAttributes() {
		override val dmgTakenFromCritReduced: DmgTakenFromCritReducedAttributes = DmgTakenFromCritReducedAttributes()
	
		override val dmgTakenFromFireReduced: DmgTakenFromFireReducedAttributes = DmgTakenFromFireReducedAttributes()
	
		override val dmgTakenFromBulletsReduced: DmgTakenFromBulletsReducedAttributes = DmgTakenFromBulletsReducedAttributes()
	
		override val vaccinator: VaccinatorAttributes = VaccinatorAttributes()
	
		open class DmgTakenFromCritReducedAttributes : RayGunAttributes.ResistanceAttributes.DmgTakenFromCritReducedAttributes() 
	
		open class DmgTakenFromFireReducedAttributes : RayGunAttributes.ResistanceAttributes.DmgTakenFromFireReducedAttributes() 
	
		open class DmgTakenFromBulletsReducedAttributes : RayGunAttributes.ResistanceAttributes.DmgTakenFromBulletsReducedAttributes() 
	
		open class VaccinatorAttributes : RayGunAttributes.ResistanceAttributes.VaccinatorAttributes() 
	}
	
	open class RevengeCritsAttributes : RayGunAttributes.RevengeCritsAttributes() 
	
	open class StatusEffectsAttributes : RayGunAttributes.StatusEffectsAttributes() 
	
	open class TauntingAttributes : RayGunAttributes.TauntingAttributes() 
	
	open class SwapWeaponsAttributes : RayGunAttributes.SwapWeaponsAttributes() {
		override val deploy: DeployAttributes = DeployAttributes()
	
		open class DeployAttributes : RayGunAttributes.SwapWeaponsAttributes.DeployAttributes() 
	}
	
	open class WhenHitAttributes : RayGunAttributes.WhenHitAttributes() 
	
	open class RagdollsAttributes : RayGunAttributes.RagdollsAttributes() 
	
	open class BuffItemsAttributes : RayGunAttributes.BuffItemsAttributes() 
	
	open class CloakAttributes : RayGunAttributes.CloakAttributes() 
	
	open class DisguiseAttributes : RayGunAttributes.DisguiseAttributes() 
	
	open class HudAttributes : RayGunAttributes.HudAttributes() 
	
	open class SpyOnlyAttributes : RayGunAttributes.SpyOnlyAttributes() 
	
	object Inherited : DRGPomsonAttributes 
}