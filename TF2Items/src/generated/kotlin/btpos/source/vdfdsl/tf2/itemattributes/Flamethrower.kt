package btpos.source.vdfdsl.tf2.itemattributes

import btpos.source.vdfdsl.modeling.*
import btpos.source.vdfdsl.serialization.codecs.*
import btpos.source.vdfdsl.tf2.itemattributes.impl.*
import btpos.source.vdfdsl.tf2.tftypes.*
import java.util.*
import kotlin.time.Duration

interface FlamethrowerAttributes : IBlockScoped, BaseGunAttributes {
	companion object : IBlockScoped {
		/**
		 * Attributes governing the flamethrower's airblast, including [what it's allowed to do][AirblastAttributes.functionalityFlags], the [direction it pushes][AirblastAttributes.reverseAirblast], and whether it [flings the wielder forward][AirblastAttributes.airblast_dashes].
		 */
		val airblast: AirblastAttributes = AirblastAttributes()
	
		/**
		 * Attributes related to dealing or preventing critical hits and mini-crits.
		 */
		val crits: CritsAttributes = CritsAttributes()
	
		/**
		 * Attributes governing the player's move-speed, jump height, swimming, air-strafing capabilities, and all things mobility-related.
		 */
		val movement: MovementAttributes = MovementAttributes()
	
		/**
		 * Attributes related to max ammo, clip-size, and resupply.
		 */
		val ammo: AmmoAttributes = AmmoAttributes()
	
		/**
		 * Attributes related to the player's HP stat and healing players.
		 */
		val healthAndHealing: HealthAndHealingAttributes = HealthAndHealingAttributes()
	
		val buffType: BuffTypeAttributes = BuffTypeAttributes()
	
		/**
		 * Attributes governing rate-of-fire.
		 */
		val firing: FiringAttributes = FiringAttributes()
	
		/**
		 * Attributes controlling how flames emitted by the flamethrower move and reflect.
		 */
		val flames: FlamesAttributes = FlamesAttributes()
	
		/**
		 * Multipliers governing the damage you deal to different targets.
		 * 
		 * For damage _taken_, see [resistance].
		 */
		private val damage: DamageAttributes = DamageAttributes()
	
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
		 * Attributes governing the Demoknight's shield-charge.
		 * 
		 * Some of these attributes are hardcoded to only work on the Demoman. These are noted in their documentation.
		 */
		private val demoCharge: DemoChargeAttributes = DemoChargeAttributes()
	
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
	 * Attributes governing the flamethrower's airblast, including [what it's allowed to do][AirblastAttributes.functionalityFlags], the [direction it pushes][AirblastAttributes.reverseAirblast], and whether it [flings the wielder forward][AirblastAttributes.airblast_dashes].
	 */
	val airblast: AirblastAttributes get() = FlamethrowerAttributes.airblast
	
	/**
	 * Attributes related to dealing or preventing critical hits and mini-crits.
	 */
	override val crits: CritsAttributes get() = FlamethrowerAttributes.crits
	
	/**
	 * Attributes governing the player's move-speed, jump height, swimming, air-strafing capabilities, and all things mobility-related.
	 */
	override val movement: MovementAttributes get() = FlamethrowerAttributes.movement
	
	/**
	 * Attributes related to max ammo, clip-size, and resupply.
	 */
	override val ammo: AmmoAttributes get() = FlamethrowerAttributes.ammo
	
	/**
	 * Attributes related to the player's HP stat and healing players.
	 */
	override val healthAndHealing: HealthAndHealingAttributes get() = FlamethrowerAttributes.healthAndHealing
	
	val buffType: BuffTypeAttributes get() = FlamethrowerAttributes.buffType
	
	/**
	 * Attributes governing rate-of-fire.
	 */
	override val firing: FiringAttributes get() = FlamethrowerAttributes.firing
	
	/**
	 * Attributes controlling how flames emitted by the flamethrower move and reflect.
	 */
	val flames: FlamesAttributes get() = FlamethrowerAttributes.flames
	
	/**
	 * Multipliers governing the damage you deal to different targets.
	 * 
	 * For damage _taken_, see [resistance].
	 */
	override val damage: DamageAttributes get() = FlamethrowerAttributes.damage
	
	/**
	 * All attributes governing what projectile or bullet this weapon can fire, and how that projectile or bullet acts once fired.
	 * 
	 * Each type of projectile also has a subcategory with every attribute it checks for on the gun that fired it.
	 */
	override val projectiles: ProjectilesAttributes get() = FlamethrowerAttributes.projectiles
	
	/**
	 * Attributes related to afterburn.
	 */
	override val afterburn: AfterburnAttributes get() = FlamethrowerAttributes.afterburn
	
	/**
	 * Attributes related to moving, constructing, and interacting with the Engineer's buildings.
	 */
	override val buildings: BuildingsAttributes get() = FlamethrowerAttributes.buildings
	
	/**
	 * Attributes governing the Demoknight's shield-charge.
	 * 
	 * Some of these attributes are hardcoded to only work on the Demoman. These are noted in their documentation.
	 */
	override val demoCharge: DemoChargeAttributes get() = FlamethrowerAttributes.demoCharge
	
	/**
	 * Attributes governing how much you are pushed when hit by different push sources.
	 */
	override val knockbackReceived: KnockbackReceivedAttributes get() = FlamethrowerAttributes.knockbackReceived
	
	/**
	 * Attributes related to the scoreboard, killfeed, HuD, item descriptions, and interactions with the wider game-state. (including capture rate)
	 */
	override val meta: MetaAttributes get() = FlamethrowerAttributes.meta
	
	/**
	 * Attributes related to rage and items that recharge on a meter/timer.
	 */
	override val meter: MeterAttributes get() = FlamethrowerAttributes.meter
	
	/**
	 * Attributes related to the collection and passive effects of "heads".
	 * 
	 * While originally made for the Eyelander, this stat is used by many other weapons that track players hit or killed: the Vita-Saw, the Bazaar Bargain, etc.
	 * 
	 * For "revenge crits", like the Frontier Justice, Manmelter, and Diamondback, see [revengeCrits].
	 */
	override val heads: HeadsAttributes get() = FlamethrowerAttributes.heads
	
	/**
	 * Attributes governing what happens when you hit another player, such as applying conditions or debuffs.
	 * 
	 * @see onKill
	 */
	override val onHit: OnHitAttributes get() = FlamethrowerAttributes.onHit
	
	/**
	 * Attributes governing what happens when you kill another player, usually applying bonuses to yourself.
	 * 
	 * @see onHit
	 */
	override val onKill: OnKillAttributes get() = FlamethrowerAttributes.onKill
	
	/**
	 * Attributes governing either the time taken to reload a weapon's magazine or the cooldown time for weapons that draw directly from reserve ammo like the Sniper Rifle and Flare Gun.
	 */
	override val reloading: ReloadingAttributes get() = FlamethrowerAttributes.reloading
	
	/**
	 * Attributes governing how much damage the player takes from various sources.  Also includes the passive and active effects of the Vaccinator on the user.
	 * 
	 * For outgoing damage, see [damage].
	 */
	override val resistance: ResistanceAttributes get() = FlamethrowerAttributes.resistance
	
	/**
	 * Attributes governing the collection of "Revenge Crits", guaranteed criticals gained by fulfilling certain requirements.
	 * 
	 * It should be noted that for the most part, these attributes just state whether or not a weapon CAN gain revenge crits. Actually _using_ them is bound to the weapon type, not any attribute.
	 * 
	 * For the collection and usage of "heads", see [heads].
	 */
	override val revengeCrits: RevengeCritsAttributes get() = FlamethrowerAttributes.revengeCrits
	
	/**
	 * Attributes related to Mad Milk, Jarate, and Gas.
	 * 
	 * This will be empty for most weapons unless a mod adds something.  Notably, "explode on ignite" is available for all weapons.
	 */
	override val statusEffects: StatusEffectsAttributes get() = FlamethrowerAttributes.statusEffects
	
	/**
	 * Attributes governing taunt speed and the effects of taunts.
	 */
	override val taunting: TauntingAttributes get() = FlamethrowerAttributes.taunting
	
	/**
	 * Attributes governing weapon deploy/holster speed, things that activate when a weapon is deployed, and whether a player can swap weapons at all.
	 */
	override val swapWeapons: SwapWeaponsAttributes get() = FlamethrowerAttributes.swapWeapons
	
	/**
	 * Attributes governing what happens when this player is hit by an enemy.
	 * 
	 * For what happens when _this player_ hits an enemy, see [onHit] and [onKill].
	 */
	override val whenHit: WhenHitAttributes get() = FlamethrowerAttributes.whenHit
	
	/**
	 * Attributes governing ragdolls, gibs, and statues.
	 */
	override val ragdolls: RagdollsAttributes get() = FlamethrowerAttributes.ragdolls
	
	override val buffItems: BuffItemsAttributes get() = FlamethrowerAttributes.buffItems
	
	override val cloak: CloakAttributes get() = FlamethrowerAttributes.cloak
	
	/**
	 * Attributes related to disguising.
	 */
	override val disguise: DisguiseAttributes get() = FlamethrowerAttributes.disguise
	
	override val hud: HudAttributes get() = FlamethrowerAttributes.hud
	
	override val spyOnly: SpyOnlyAttributes get() = FlamethrowerAttributes.spyOnly
	
	open class AirblastAttributes : IBlockScoped {
		/**
		 * In-Game: "No airblast"
		 */
		open val airblastDisabled: ItemAttributeNamed<Boolean> = ItemAttributeNamed("airblast disabled")
	
		/**
		 * In-Game: "Airblast can now be charged, which will push enemies further"
		 * 
		 * Enables charging an airblast for longer for higher push.
		 * 
		 * Fun fact: apparently this was going to be a FLAME ROCKET, but got changed later to be an airblast.
		 */
		open val chargedAirblast: ItemAttributeNamed<Boolean> = ItemAttributeNamed("charged airblast")
	
		/**
		 * Bonus:
		 * 
		 * 	- In-Game: "N% airblast cost"
		 * 
		 * Penalty:
		 * 
		 * 	- In-Game: "+N% airblast cost"
		 * 
		 * Hidden:
		 */
		open val airblastCost: BonusPenaltyHidden<Number, ItemAttributeNamed<Number>> = BonusPenaltyHidden(
		    ItemAttributeNamed<Number>("airblast cost decreased"),
		    ItemAttributeNamed<Number>("airblast cost increased"),
		    ItemAttributeNamed<Number>("airblast cost scale hidden"),
		)
	
		/**
		 * Multiplier for how long after airblasting until you can fire a primary OR secondary attack.
		 * 
		 * Secondary attack delay = 0.75 * this.
		 */
		open val multAirblastRefireTime: ItemAttributeNamed<Number> = ItemAttributeNamed("mult airblast refire time")
	
		/**
		 * Scales the reflect hitbox for your airblast.
		 */
		open val deflectionSizeMultiplier: ItemAttributeNamed<Number> = ItemAttributeNamed("deflection size multiplier")
	
		/**
		 * In-Game: "+N% airblast push force"
		 */
		open val airblastPushbackScale: ItemAttributeNamed<Number> = ItemAttributeNamed("airblast pushback scale")
	
		open val airblastVerticalPushbackScale: ItemAttributeNamed<Number> = ItemAttributeNamed("airblast vertical pushback scale")
	
		open val airblastDestroyProjectile: ItemAttributeNamed<Boolean> = ItemAttributeNamed("airblast_destroy_projectile")
	
		open val airblastPushbackDisabled: ItemAttributeNamed<Boolean> = ItemAttributeNamed("airblast_pushback_disabled")
	}
	
	open class CritsAttributes : BaseGunAttributes.CritsAttributes() {
		/**
		 * In-Game: "100% critical hits from behind"
		 */
		open val flamethrowerBackCrit: ItemAttributeNamed<Boolean> = ItemAttributeNamed("mod flamethrower back crit")
	}
	
	open class MovementAttributes : BaseGunAttributes.MovementAttributes() {
		override val moveSpeed: MoveSpeedAttributes = MoveSpeedAttributes()
	
		override val increasedJumpHeight: jumpHeightAttributes = jumpHeightAttributes()
	
		open class MoveSpeedAttributes : BaseGunAttributes.MovementAttributes.MoveSpeedAttributes() {
			override val aimingMovespeedIncreased: AimingMovespeedAttributes = AimingMovespeedAttributes()
	
			override val moveSpeedPenalty: MoveSpeedAttributes = MoveSpeedAttributes()
	
			open class AimingMovespeedAttributes : BaseGunAttributes.MovementAttributes.MoveSpeedAttributes.AimingMovespeedAttributes() 
	
			open class MoveSpeedAttributes : BaseGunAttributes.MovementAttributes.MoveSpeedAttributes.MoveSpeedAttributes() 
		}
	
		open class jumpHeightAttributes : BaseGunAttributes.MovementAttributes.jumpHeightAttributes() 
	}
	
	open class AmmoAttributes : BaseGunAttributes.AmmoAttributes() {
		/**
		 * Bonus:
		 * 
		 * 	- In-Game: "N% flamethrower ammo consumed per second"
		 * 
		 * Penalty:
		 * 
		 * 	- In-Game: "+N% flamethrower ammo consumed per second"
		 */
		open val flameAmmopersec: BonusPenalty<Number> = BonusPenalty(
		    ItemAttributeNamed("flame ammopersec decreased"),
		    ItemAttributeNamed("flame ammopersec increased"),
		)
	
		override val clipSize: ClipSizeAttributes = ClipSizeAttributes()
	
		override val modMaxAmmo: MaxAmmoAttributes = MaxAmmoAttributes()
	
		open class ClipSizeAttributes : BaseGunAttributes.AmmoAttributes.ClipSizeAttributes() 
	
		open class MaxAmmoAttributes : BaseGunAttributes.AmmoAttributes.MaxAmmoAttributes() 
	}
	
	open class HealthAndHealingAttributes : BaseGunAttributes.HealthAndHealingAttributes() {
		/**
		 * In-Game: "Extinguishing teammates restores N health"
		 * 
		 * How much health your extinguish restores.
		 */
		open val extinguishRestoresHealth: ItemAttributeNamed<Int> = ItemAttributeNamed("extinguish restores health")
	
		override val healthRegen: HealthRegenAttributes = HealthRegenAttributes()
	
		override val maxHealthAdditiveBonus: MaxHealthAdditiveAttributes = MaxHealthAdditiveAttributes()
	
		open class HealthRegenAttributes : BaseGunAttributes.HealthAndHealingAttributes.HealthRegenAttributes() 
	
		open class MaxHealthAdditiveAttributes : BaseGunAttributes.HealthAndHealingAttributes.MaxHealthAdditiveAttributes() 
	}
	
	open class BuffTypeAttributes : IBlockScoped {
		/**
		 * If greater than 0, enables Phlog crits on having full rage.
		 */
		open val soldierBuffType: ItemAttributeNamed<Int> = ItemAttributeNamed("mod soldier buff type")
	
		/**
		 * If greater than 0, enables Phlog crits on having full rage.
		 */
		open val demoBuffType: ItemAttributeNamed<Int> = ItemAttributeNamed("mod demo buff type")
	}
	
	open class FiringAttributes : BaseGunAttributes.FiringAttributes() {
		override val fireRate: FireRateAttributes = FireRateAttributes()
	
		open class FireRateAttributes : BaseGunAttributes.FiringAttributes.FireRateAttributes() 
	}
	
	open class FlamesAttributes : IBlockScoped {
		open val flameSpreadDegree: ItemAttributeNamed<Number> = ItemAttributeNamed("flame_spread_degree")
	
		open val redirectedFlameSizeMult: ItemAttributeNamed<Number> = ItemAttributeNamed("redirected_flame_size_mult")
	
		/**
		 * Bonus:
		 * 
		 * 	- In-Game: "+N% more flame spread area"
		 * 
		 * Penalty:
		 * 
		 * 	- In-Game: "N% less flame spread area"
		 */
		open val flameSize: BonusPenalty<Number> = BonusPenalty(
		    ItemAttributeNamed("flame size bonus"),
		    ItemAttributeNamed("flame size penalty"),
		)
	
		open val multEndFlameSize: ItemAttributeNamed<Number> = ItemAttributeNamed("mult_end_flame_size")
	
		open val flameIgnorePlayerVelocity: ItemAttributeNamed<Number> = ItemAttributeNamed("flame_ignore_player_velocity")
	
		open val flameReflectionAddLifeTime: ItemAttributeNamed<Number> = ItemAttributeNamed("flame_reflection_add_life_time")
	
		open val reflectedFlameDmgReduction: ItemAttributeNamed<Number> = ItemAttributeNamed("reflected_flame_dmg_reduction")
	
		open val maxFlameReflectionCount: ItemAttributeNamed<Int> = ItemAttributeNamed("max_flame_reflection_count")
	
		open val flameReflectOnCollision: ItemAttributeNamed<Boolean> = ItemAttributeNamed("flame_reflect_on_collision")
	
		open val flameSpeed: ItemAttributeNamed<Number> = ItemAttributeNamed("flame_speed")
	
		open val flameLifetime: ItemAttributeNamed<Number> = ItemAttributeNamed("flame_lifetime")
	
		open val flameRandomLifeTimeOffset: ItemAttributeNamed<Number> = ItemAttributeNamed("flame_random_life_time_offset")
	
		open val flameGravity: ItemAttributeNamed<Number> = ItemAttributeNamed("flame_gravity")
	
		open val flameDrag: ItemAttributeNamed<Number> = ItemAttributeNamed("flame_drag")
	
		open val flameUpSpeed: ItemAttributeNamed<Number> = ItemAttributeNamed("flame_up_speed")
	
		/**
		 * Bonus:
		 * 
		 * 	- In-Game: "+N% more flame distance"
		 * 
		 * Penalty:
		 * 
		 * 	- In-Game: "N% less flame distance"
		 */
		open val flameLife: BonusPenalty<Number> = BonusPenalty(
		    ItemAttributeNamed("flame life bonus"),
		    ItemAttributeNamed("flame life penalty"),
		)
	
		/**
		 * In-Game: "Halloween Fire"
		 */
		open val spellHalloweenGreenFlames: ItemAttributeNamed<Boolean> = ItemAttributeNamed("SPELL: Halloween green flames")
	}
	
	open class DamageAttributes : BaseGunAttributes.DamageAttributes() {
		override val alien: AlienAttributes = AlienAttributes()
	
		open class AlienAttributes : BaseGunAttributes.DamageAttributes.AlienAttributes() 
	}
	
	open class ProjectilesAttributes : BaseGunAttributes.ProjectilesAttributes() {
		override val bullets: BulletsAttributes = BulletsAttributes()
	
		override val projectilePenetration: ProjectilePenetrationAttributes = ProjectilePenetrationAttributes()
	
		open class BulletsAttributes : BaseGunAttributes.ProjectilesAttributes.BulletsAttributes() 
	
		open class ProjectilePenetrationAttributes : BaseGunAttributes.ProjectilesAttributes.ProjectilePenetrationAttributes(), ItemAttribute<Int> 
	}
	
	open class AfterburnAttributes : BaseGunAttributes.AfterburnAttributes() 
	
	open class BuildingsAttributes : BaseGunAttributes.BuildingsAttributes() {
		override val sentryGun: SentryGunAttributes = SentryGunAttributes()
	
		override val dispenser: DispenserAttributes = DispenserAttributes()
	
		override val teleporter: TeleporterAttributes = TeleporterAttributes()
	
		open class SentryGunAttributes : BaseGunAttributes.BuildingsAttributes.SentryGunAttributes() 
	
		open class DispenserAttributes : BaseGunAttributes.BuildingsAttributes.DispenserAttributes() 
	
		open class TeleporterAttributes : BaseGunAttributes.BuildingsAttributes.TeleporterAttributes() 
	}
	
	open class DemoChargeAttributes : BaseGunAttributes.DemoChargeAttributes() {
		override val multChargeTurnControl: MultChargeTurnControlAttributes = MultChargeTurnControlAttributes()
	
		open class MultChargeTurnControlAttributes : BaseGunAttributes.DemoChargeAttributes.MultChargeTurnControlAttributes() 
	}
	
	open class KnockbackReceivedAttributes : BaseGunAttributes.KnockbackReceivedAttributes() {
		override val damageForceReduction: DamageForceReductionAttributes = DamageForceReductionAttributes()
	
		open class DamageForceReductionAttributes : BaseGunAttributes.KnockbackReceivedAttributes.DamageForceReductionAttributes() 
	}
	
	open class MetaAttributes : BaseGunAttributes.MetaAttributes() {
		override val killfeed: KillfeedAttributes = KillfeedAttributes()
	
		override val viewmodel: ViewmodelAttributes = ViewmodelAttributes()
	
		override val items: ItemsAttributes = ItemsAttributes()
	
		override val particles: ParticlesAttributes = ParticlesAttributes()
	
		override val noisemakers: NoisemakersAttributes = NoisemakersAttributes()
	
		override val player: PlayerAttributes = PlayerAttributes()
	
		override val gameplay: GameplayAttributes = GameplayAttributes()
	
		open class KillfeedAttributes : BaseGunAttributes.MetaAttributes.KillfeedAttributes() 
	
		open class ViewmodelAttributes : BaseGunAttributes.MetaAttributes.ViewmodelAttributes() 
	
		open class ItemsAttributes : BaseGunAttributes.MetaAttributes.ItemsAttributes() 
	
		open class ParticlesAttributes : BaseGunAttributes.MetaAttributes.ParticlesAttributes() 
	
		open class NoisemakersAttributes : BaseGunAttributes.MetaAttributes.NoisemakersAttributes() 
	
		open class PlayerAttributes : BaseGunAttributes.MetaAttributes.PlayerAttributes() 
	
		open class GameplayAttributes : BaseGunAttributes.MetaAttributes.GameplayAttributes() 
	}
	
	open class MeterAttributes : BaseGunAttributes.MeterAttributes() {
		override val generateRageOnDamage: GenerateRageOnDamageAttributes = GenerateRageOnDamageAttributes()
	
		open class GenerateRageOnDamageAttributes : BaseGunAttributes.MeterAttributes.GenerateRageOnDamageAttributes() 
	}
	
	open class HeadsAttributes : BaseGunAttributes.HeadsAttributes() 
	
	open class OnHitAttributes : BaseGunAttributes.OnHitAttributes() {
		override val healOnHitForRapidfire: HealOnHitForRapidfireAttributes = HealOnHitForRapidfireAttributes()
	
		override val generateRageOnDamage: GenerateRageOnDamageAttributes = GenerateRageOnDamageAttributes()
	
		override val falling: FallingAttributes = FallingAttributes()
	
		open class HealOnHitForRapidfireAttributes : BaseGunAttributes.OnHitAttributes.HealOnHitForRapidfireAttributes() 
	
		open class GenerateRageOnDamageAttributes : BaseGunAttributes.OnHitAttributes.GenerateRageOnDamageAttributes() 
	
		open class FallingAttributes : BaseGunAttributes.OnHitAttributes.FallingAttributes() 
	}
	
	open class OnKillAttributes : BaseGunAttributes.OnKillAttributes() 
	
	open class ReloadingAttributes : BaseGunAttributes.ReloadingAttributes() 
	
	open class ResistanceAttributes : BaseGunAttributes.ResistanceAttributes() {
		override val dmgTakenFromCritReduced: DmgTakenFromCritReducedAttributes = DmgTakenFromCritReducedAttributes()
	
		override val dmgTakenFromFireReduced: DmgTakenFromFireReducedAttributes = DmgTakenFromFireReducedAttributes()
	
		override val dmgTakenFromBulletsReduced: DmgTakenFromBulletsReducedAttributes = DmgTakenFromBulletsReducedAttributes()
	
		override val vaccinator: VaccinatorAttributes = VaccinatorAttributes()
	
		open class DmgTakenFromCritReducedAttributes : BaseGunAttributes.ResistanceAttributes.DmgTakenFromCritReducedAttributes() 
	
		open class DmgTakenFromFireReducedAttributes : BaseGunAttributes.ResistanceAttributes.DmgTakenFromFireReducedAttributes() 
	
		open class DmgTakenFromBulletsReducedAttributes : BaseGunAttributes.ResistanceAttributes.DmgTakenFromBulletsReducedAttributes() 
	
		open class VaccinatorAttributes : BaseGunAttributes.ResistanceAttributes.VaccinatorAttributes() 
	}
	
	open class RevengeCritsAttributes : BaseGunAttributes.RevengeCritsAttributes() 
	
	open class StatusEffectsAttributes : BaseGunAttributes.StatusEffectsAttributes() 
	
	open class TauntingAttributes : BaseGunAttributes.TauntingAttributes() 
	
	open class SwapWeaponsAttributes : BaseGunAttributes.SwapWeaponsAttributes() {
		override val deploy: DeployAttributes = DeployAttributes()
	
		open class DeployAttributes : BaseGunAttributes.SwapWeaponsAttributes.DeployAttributes() 
	}
	
	open class WhenHitAttributes : BaseGunAttributes.WhenHitAttributes() 
	
	open class RagdollsAttributes : BaseGunAttributes.RagdollsAttributes() 
	
	open class BuffItemsAttributes : BaseGunAttributes.BuffItemsAttributes() 
	
	open class CloakAttributes : BaseGunAttributes.CloakAttributes() 
	
	open class DisguiseAttributes : BaseGunAttributes.DisguiseAttributes() 
	
	open class HudAttributes : BaseGunAttributes.HudAttributes() 
	
	open class SpyOnlyAttributes : BaseGunAttributes.SpyOnlyAttributes() 
	
	object Inherited : FlamethrowerAttributes 
}