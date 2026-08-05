package btpos.source.vdfdsl.tf2.itemattributes

import btpos.source.vdfdsl.modeling.*
import btpos.source.vdfdsl.serialization.*
import btpos.source.vdfdsl.serialization.codecs.*
import btpos.source.vdfdsl.tf2.itemattributes.impl.*
import btpos.source.vdfdsl.tf2.tftypes.*
import java.util.*
import kotlin.time.Duration

interface MedigunAttributes : IBlockScoped, BaseGunAttributes {
	companion object : IBlockScoped {
		/**
		 * Bonus:
		 * 
		 * 	- In-Game: "+N% heal rate"
		 * 
		 * Penalty:
		 * 
		 * 	- In-Game: "N% heal rate"
		 */
		val multMedigunHealrate: BonusPenalty<Number> = BonusPenalty(
		    ItemAttributeNamed("heal rate bonus"),
		    ItemAttributeNamed("heal rate penalty"),
		)
	
		/**
		 * In-Game: "On death up to N% of your stored ÜberCharge is retained"
		 * 
		 * Percentage saved on death or dropping weapon (e.g. `25` = 25% uber).
		 * 
		 * Checked on player.
		 */
		val preserveUbercharge: ItemAttributeNamed<Int> = ItemAttributeNamed("preserve ubercharge")
	
		/**
		 * In-Game: "+25% heal rate for patient, +25% faster revive rate, and +25% self heal rate, per point"
		 */
		val healingMastery: ItemAttributeNamed<Int> = ItemAttributeNamed("healing mastery")
	
		/**
		 * Ubercharge type. Each resist uber also has its own entry.
		 */
		val setChargeType: SetChargeTypeAttributes = SetChargeTypeAttributes()
	
		/**
		 * Bonus:
		 * 
		 * 	- In-Game: "+N% max overheal"
		 * 
		 * Penalty:
		 * 
		 * 	- In-Game: "N% max overheal"
		 */
		val multMedigunOverhealAmount: BonusPenalty<Number> = BonusPenalty(
		    ItemAttributeNamed("overheal bonus"),
		    ItemAttributeNamed("overheal penalty"),
		)
	
		val multMedigunOverhealDecay: MultMedigunOverhealDecayAttributes = MultMedigunOverhealDecayAttributes()
	
		/**
		 * In-Game: "+25% more overheal, +50% longer duration per point"
		 * 
		 * Overheal bonus = overheal bonus + overhealexpert/4 or just overheal bonus, whichever is higher.
		 * 
		 * decay mult is same but divided by 2.
		 * 
		 * Checked on owner.
		 */
		val overhealExpert: ItemAttributeNamed<Number> = ItemAttributeNamed("overheal expert")
	
		/**
		 * In-Game: "N% ÜberCharge rate on Overhealed patients"
		 * 
		 * Checked on owner.
		 */
		val uberchargeOverhealRatePenalty: ItemAttributeNamed<Number> = ItemAttributeNamed("ubercharge overheal rate penalty")
	
		/**
		 * Bonus:
		 * 
		 * 	- In-Game: "+N% ÜberCharge rate"
		 * 
		 * Penalty:
		 * 
		 * 	- In-Game: "N% ÜberCharge rate"
		 */
		val multMedigunUberchargerate: BonusPenalty<Number> = BonusPenalty(
		    ItemAttributeNamed("ubercharge rate bonus"),
		    ItemAttributeNamed("ubercharge rate penalty"),
		)
	
		/**
		 * In-Game: "Über duration increased N seconds"
		 * 
		 * Checked on owner.
		 */
		val uberDurationBonus: ItemAttributeNamed<Int> = ItemAttributeNamed("uber duration bonus")
	
		/**
		 * In-Game: "Build energy by healing teammates.  When fully charged, press the Special-Attack key to deploy a frontal projectile shield."
		 * 
		 * This is your shield level.
		 * 
		 * Checked on owner.
		 */
		val generateRageOnHeal: ItemAttributeNamed<Int> = ItemAttributeNamed("generate rage on heal")
	
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
	 * Bonus:
	 * 
	 * 	- In-Game: "+N% heal rate"
	 * 
	 * Penalty:
	 * 
	 * 	- In-Game: "N% heal rate"
	 */
	val multMedigunHealrate: BonusPenalty<Number> get() = MedigunAttributes.multMedigunHealrate
	
	/**
	 * In-Game: "On death up to N% of your stored ÜberCharge is retained"
	 * 
	 * Percentage saved on death or dropping weapon (e.g. `25` = 25% uber).
	 * 
	 * Checked on player.
	 */
	val preserveUbercharge: ItemAttributeNamed<Int> get() = MedigunAttributes.preserveUbercharge
	
	/**
	 * In-Game: "+25% heal rate for patient, +25% faster revive rate, and +25% self heal rate, per point"
	 */
	val healingMastery: ItemAttributeNamed<Int> get() = MedigunAttributes.healingMastery
	
	/**
	 * Ubercharge type. Each resist uber also has its own entry.
	 */
	val setChargeType: SetChargeTypeAttributes get() = MedigunAttributes.setChargeType
	
	/**
	 * Bonus:
	 * 
	 * 	- In-Game: "+N% max overheal"
	 * 
	 * Penalty:
	 * 
	 * 	- In-Game: "N% max overheal"
	 */
	val multMedigunOverhealAmount: BonusPenalty<Number> get() = MedigunAttributes.multMedigunOverhealAmount
	
	val multMedigunOverhealDecay: MultMedigunOverhealDecayAttributes get() = MedigunAttributes.multMedigunOverhealDecay
	
	/**
	 * In-Game: "+25% more overheal, +50% longer duration per point"
	 * 
	 * Overheal bonus = overheal bonus + overhealexpert/4 or just overheal bonus, whichever is higher.
	 * 
	 * decay mult is same but divided by 2.
	 * 
	 * Checked on owner.
	 */
	val overhealExpert: ItemAttributeNamed<Number> get() = MedigunAttributes.overhealExpert
	
	/**
	 * In-Game: "N% ÜberCharge rate on Overhealed patients"
	 * 
	 * Checked on owner.
	 */
	val uberchargeOverhealRatePenalty: ItemAttributeNamed<Number> get() = MedigunAttributes.uberchargeOverhealRatePenalty
	
	/**
	 * Bonus:
	 * 
	 * 	- In-Game: "+N% ÜberCharge rate"
	 * 
	 * Penalty:
	 * 
	 * 	- In-Game: "N% ÜberCharge rate"
	 */
	val multMedigunUberchargerate: BonusPenalty<Number> get() = MedigunAttributes.multMedigunUberchargerate
	
	/**
	 * In-Game: "Über duration increased N seconds"
	 * 
	 * Checked on owner.
	 */
	val uberDurationBonus: ItemAttributeNamed<Int> get() = MedigunAttributes.uberDurationBonus
	
	/**
	 * In-Game: "Build energy by healing teammates.  When fully charged, press the Special-Attack key to deploy a frontal projectile shield."
	 * 
	 * This is your shield level.
	 * 
	 * Checked on owner.
	 */
	val generateRageOnHeal: ItemAttributeNamed<Int> get() = MedigunAttributes.generateRageOnHeal
	
	/**
	 * Attributes related to max ammo, clip-size, and resupply.
	 */
	override val ammo: AmmoAttributes get() = MedigunAttributes.ammo
	
	/**
	 * Multipliers governing the damage you deal to different targets.
	 * 
	 * For damage _taken_, see [resistance].
	 */
	override val damage: DamageAttributes get() = MedigunAttributes.damage
	
	/**
	 * Attributes governing rate-of-fire.
	 */
	override val firing: FiringAttributes get() = MedigunAttributes.firing
	
	/**
	 * All attributes governing what projectile or bullet this weapon can fire, and how that projectile or bullet acts once fired.
	 * 
	 * Each type of projectile also has a subcategory with every attribute it checks for on the gun that fired it.
	 */
	override val projectiles: ProjectilesAttributes get() = MedigunAttributes.projectiles
	
	/**
	 * Attributes related to afterburn.
	 */
	override val afterburn: AfterburnAttributes get() = MedigunAttributes.afterburn
	
	/**
	 * Attributes related to moving, constructing, and interacting with the Engineer's buildings.
	 */
	override val buildings: BuildingsAttributes get() = MedigunAttributes.buildings
	
	/**
	 * Attributes related to dealing or preventing critical hits and mini-crits.
	 */
	override val crits: CritsAttributes get() = MedigunAttributes.crits
	
	/**
	 * Attributes governing the Demoknight's shield-charge.
	 * 
	 * Some of these attributes are hardcoded to only work on the Demoman. These are noted in their documentation.
	 */
	override val demoCharge: DemoChargeAttributes get() = MedigunAttributes.demoCharge
	
	/**
	 * Attributes related to the player's HP stat and healing players.
	 */
	override val healthAndHealing: HealthAndHealingAttributes get() = MedigunAttributes.healthAndHealing
	
	/**
	 * Attributes governing how much you are pushed when hit by different push sources.
	 */
	override val knockbackReceived: KnockbackReceivedAttributes get() = MedigunAttributes.knockbackReceived
	
	/**
	 * Attributes related to the scoreboard, killfeed, HuD, item descriptions, and interactions with the wider game-state. (including capture rate)
	 */
	override val meta: MetaAttributes get() = MedigunAttributes.meta
	
	/**
	 * Attributes related to rage and items that recharge on a meter/timer.
	 */
	override val meter: MeterAttributes get() = MedigunAttributes.meter
	
	/**
	 * Attributes governing the player's move-speed, jump height, swimming, air-strafing capabilities, and all things mobility-related.
	 */
	override val movement: MovementAttributes get() = MedigunAttributes.movement
	
	/**
	 * Attributes related to the collection and passive effects of "heads".
	 * 
	 * While originally made for the Eyelander, this stat is used by many other weapons that track players hit or killed: the Vita-Saw, the Bazaar Bargain, etc.
	 * 
	 * For "revenge crits", like the Frontier Justice, Manmelter, and Diamondback, see [revengeCrits].
	 */
	override val heads: HeadsAttributes get() = MedigunAttributes.heads
	
	/**
	 * Attributes governing what happens when you hit another player, such as applying conditions or debuffs.
	 * 
	 * @see onKill
	 */
	override val onHit: OnHitAttributes get() = MedigunAttributes.onHit
	
	/**
	 * Attributes governing what happens when you kill another player, usually applying bonuses to yourself.
	 * 
	 * @see onHit
	 */
	override val onKill: OnKillAttributes get() = MedigunAttributes.onKill
	
	/**
	 * Attributes governing either the time taken to reload a weapon's magazine or the cooldown time for weapons that draw directly from reserve ammo like the Sniper Rifle and Flare Gun.
	 */
	override val reloading: ReloadingAttributes get() = MedigunAttributes.reloading
	
	/**
	 * Attributes governing how much damage the player takes from various sources.  Also includes the passive and active effects of the Vaccinator on the user.
	 * 
	 * For outgoing damage, see [damage].
	 */
	override val resistance: ResistanceAttributes get() = MedigunAttributes.resistance
	
	/**
	 * Attributes governing the collection of "Revenge Crits", guaranteed criticals gained by fulfilling certain requirements.
	 * 
	 * It should be noted that for the most part, these attributes just state whether or not a weapon CAN gain revenge crits. Actually _using_ them is bound to the weapon type, not any attribute.
	 * 
	 * For the collection and usage of "heads", see [heads].
	 */
	override val revengeCrits: RevengeCritsAttributes get() = MedigunAttributes.revengeCrits
	
	/**
	 * Attributes related to Mad Milk, Jarate, and Gas.
	 * 
	 * This will be empty for most weapons unless a mod adds something.  Notably, "explode on ignite" is available for all weapons.
	 */
	override val statusEffects: StatusEffectsAttributes get() = MedigunAttributes.statusEffects
	
	/**
	 * Attributes governing taunt speed and the effects of taunts.
	 */
	override val taunting: TauntingAttributes get() = MedigunAttributes.taunting
	
	/**
	 * Attributes governing weapon deploy/holster speed, things that activate when a weapon is deployed, and whether a player can swap weapons at all.
	 */
	override val swapWeapons: SwapWeaponsAttributes get() = MedigunAttributes.swapWeapons
	
	/**
	 * Attributes governing what happens when this player is hit by an enemy.
	 * 
	 * For what happens when _this player_ hits an enemy, see [onHit] and [onKill].
	 */
	override val whenHit: WhenHitAttributes get() = MedigunAttributes.whenHit
	
	/**
	 * Attributes governing ragdolls, gibs, and statues.
	 */
	override val ragdolls: RagdollsAttributes get() = MedigunAttributes.ragdolls
	
	override val buffItems: BuffItemsAttributes get() = MedigunAttributes.buffItems
	
	override val cloak: CloakAttributes get() = MedigunAttributes.cloak
	
	/**
	 * Attributes related to disguising.
	 */
	override val disguise: DisguiseAttributes get() = MedigunAttributes.disguise
	
	override val hud: HudAttributes get() = MedigunAttributes.hud
	
	override val spyOnly: SpyOnlyAttributes get() = MedigunAttributes.spyOnly
	
	open class SetChargeTypeAttributes : IBlockScoped {
		/**
		 * In-Game: "ÜberCharge grants 100% critical chance"
		 * 
		 * Ubercharge type. Each resist uber also has its own entry.
		 */
		open val giveCrits: ItemAttributeNamed<Boolean> = ItemAttributeNamed("medigun charge is crit boost", NumberSelectorCodec(1))
	
		/**
		 * In-Game: "ÜberCharge increases healing to 300% and grants immunity to movement-impairing effects"
		 * 
		 * Ubercharge type. Each resist uber also has its own entry.
		 */
		open val medigunChargeIsMegaheal: ItemAttributeNamed<Int> = ItemAttributeNamed("medigun charge is megaheal")
	
		/**
		 * In-Game: "Press your reload key to cycle through resist types. While healing, provides you and your target with a constant 10% resistance to the selected damage type."
		 * 
		 * Ubercharge type. Each resist uber also has its own entry.
		 */
		open val giveResistanceType: ItemAttributeNamed<Boolean> = ItemAttributeNamed("medigun charge is resists", NumberSelectorCodec(3))
	}
	
	open class MultMedigunOverhealDecayAttributes : IBlockScoped {
		/**
		 * In-Game: "N% shorter overheal time"
		 */
		open val overhealDecayPenalty: ItemAttributeNamed<Number> = ItemAttributeNamed("overheal decay penalty")
	
		/**
		 * In-Game: "+N% longer overheal time"
		 */
		open val overhealDecayBonus: ItemAttributeNamed<Number> = ItemAttributeNamed("overheal decay bonus")
	
		/**
		 * In-Game: "Overheal bonus doesn't decay"
		 */
		open val overhealDecayDisabled: ItemAttributeNamed<Number> = ItemAttributeNamed("overheal decay disabled")
	}
	
	open class AmmoAttributes : BaseGunAttributes.AmmoAttributes() {
		override val clipSize: ClipSizeAttributes = ClipSizeAttributes()
	
		override val multMaxAmmo: MaxAmmoAttributes = MaxAmmoAttributes()
	
		open class ClipSizeAttributes : BaseGunAttributes.AmmoAttributes.ClipSizeAttributes() 
	
		open class MaxAmmoAttributes : BaseGunAttributes.AmmoAttributes.MaxAmmoAttributes() 
	}
	
	open class DamageAttributes : BaseGunAttributes.DamageAttributes() {
		override val alien: AlienAttributes = AlienAttributes()
	
		open class AlienAttributes : BaseGunAttributes.DamageAttributes.AlienAttributes() 
	}
	
	open class FiringAttributes : BaseGunAttributes.FiringAttributes() {
		override val fireRate: FireRateAttributes = FireRateAttributes()
	
		open class FireRateAttributes : BaseGunAttributes.FiringAttributes.FireRateAttributes() 
	}
	
	open class ProjectilesAttributes : BaseGunAttributes.ProjectilesAttributes() {
		override val bullets: BulletsAttributes = BulletsAttributes()
	
		/**
		 * How many players your "projectile" (*including bullets*) should penetrate.
		 */
		override val penetration: ProjectilePenetrationAttributes = ProjectilePenetrationAttributes()
	
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
	
	open class CritsAttributes : BaseGunAttributes.CritsAttributes() 
	
	open class DemoChargeAttributes : BaseGunAttributes.DemoChargeAttributes() {
		/**
		 * Default is 0.45f, and this is a multiplier applied to it.
		 */
		override val multChargeTurnControl: ChargeTurnControlAttributes = ChargeTurnControlAttributes()
	
		open class ChargeTurnControlAttributes : BaseGunAttributes.DemoChargeAttributes.ChargeTurnControlAttributes(), ItemAttribute<Number> 
	}
	
	open class HealthAndHealingAttributes : BaseGunAttributes.HealthAndHealingAttributes() {
		/**
		 * Amount of health regenerated per regen tick.  Scales by the amount of time since the player last took damage in non-MvM modes.
		 */
		override val healthRegenPerSecond: AddHealthRegenAttributes = AddHealthRegenAttributes()
	
		/**
		 * Additive maximum health increase. Influences the player's overheal cap.
		 */
		override val addMaxHealth: AddMaxhealthAttributes = AddMaxhealthAttributes()
	
		open class AddHealthRegenAttributes : BaseGunAttributes.HealthAndHealingAttributes.AddHealthRegenAttributes(), ItemAttribute<Int> 
	
		open class AddMaxhealthAttributes : BaseGunAttributes.HealthAndHealingAttributes.AddMaxhealthAttributes(), ItemAttribute<Int> 
	}
	
	open class KnockbackReceivedAttributes : BaseGunAttributes.KnockbackReceivedAttributes() {
		/**
		 * Attribute class is a flat multiplier applied to push force received from damage.
		 */
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
		/**
		 * Only works on Engineer and Heavy.
		 * 
		 * On Engineer, adds all damage dealt to the rage meter.
		 * 
		 * On Heavy, adds `0.22` * the damage to the meter, and reduces damage by 50% while the meter is draining.
		 */
		override val generateRageOnDmg: GenerateRageOnDmgAttributes = GenerateRageOnDmgAttributes()
	
		open class GenerateRageOnDmgAttributes : BaseGunAttributes.MeterAttributes.GenerateRageOnDmgAttributes(), ItemAttribute<Boolean> 
	}
	
	open class MovementAttributes : BaseGunAttributes.MovementAttributes() {
		override val moveSpeed: MoveSpeedAttributes = MoveSpeedAttributes()
	
		override val multJumpHeight: ModJumpHeightAttributes = ModJumpHeightAttributes()
	
		open class MoveSpeedAttributes : BaseGunAttributes.MovementAttributes.MoveSpeedAttributes() {
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
	
			open class MultPlayerAimingMovespeedAttributes : BaseGunAttributes.MovementAttributes.MoveSpeedAttributes.MultPlayerAimingMovespeedAttributes() 
	
			open class MultPlayerMovespeedAttributes : BaseGunAttributes.MovementAttributes.MoveSpeedAttributes.MultPlayerMovespeedAttributes(), ItemAttribute<Number> 
		}
	
		open class ModJumpHeightAttributes : BaseGunAttributes.MovementAttributes.ModJumpHeightAttributes(), ItemAttribute<Number> 
	}
	
	open class HeadsAttributes : BaseGunAttributes.HeadsAttributes() 
	
	open class OnHitAttributes : BaseGunAttributes.OnHitAttributes() {
		/**
		 * Add this amount of health on hit.
		 */
		override val addOnhitAddhealth: AddOnhitAddhealthAttributes = AddOnhitAddhealthAttributes()
	
		/**
		 * Knockback rage on enemy if you're a heavy and your rage is draining.
		 */
		override val generateRageOnDmg: GenerateRageOnDmgAttributes = GenerateRageOnDmgAttributes()
	
		override val falling: FallingAttributes = FallingAttributes()
	
		open class AddOnhitAddhealthAttributes : BaseGunAttributes.OnHitAttributes.AddOnhitAddhealthAttributes() 
	
		open class GenerateRageOnDmgAttributes : BaseGunAttributes.OnHitAttributes.GenerateRageOnDmgAttributes(), ItemAttribute<Boolean> 
	
		open class FallingAttributes : BaseGunAttributes.OnHitAttributes.FallingAttributes() 
	}
	
	open class OnKillAttributes : BaseGunAttributes.OnKillAttributes() 
	
	open class ReloadingAttributes : BaseGunAttributes.ReloadingAttributes() 
	
	open class ResistanceAttributes : BaseGunAttributes.ResistanceAttributes() {
		override val multDmgTakenCrits: MultDmgtakenFromCritAttributes = MultDmgtakenFromCritAttributes()
	
		override val multDmgTakenFire: MultDmgtakenFromFireAttributes = MultDmgtakenFromFireAttributes()
	
		override val multDmgTakenBullets: MultDmgtakenFromBulletsAttributes = MultDmgtakenFromBulletsAttributes()
	
		override val vaccinator: VaccinatorAttributes = VaccinatorAttributes()
	
		open class MultDmgtakenFromCritAttributes : BaseGunAttributes.ResistanceAttributes.MultDmgtakenFromCritAttributes(), ItemAttribute<Number> 
	
		open class MultDmgtakenFromFireAttributes : BaseGunAttributes.ResistanceAttributes.MultDmgtakenFromFireAttributes(), ItemAttribute<Number> 
	
		open class MultDmgtakenFromBulletsAttributes : BaseGunAttributes.ResistanceAttributes.MultDmgtakenFromBulletsAttributes(), ItemAttribute<Number> 
	
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
	
	object Inherited : MedigunAttributes 
}