package btpos.source.vdfdsl.tf2.itemattributes

import btpos.source.vdfdsl.tf2.itemattributes.impl.*
import btpos.source.vdfdsl.tf2.tftypes.*
import java.util.*

interface WeaponBaseAttributes : IBlockScoped, BaseCombatWeaponAttributes {
	companion object : IBlockScoped {
		/**
		 * In-Game: "This Weapon has a large melee range and deploys and holsters slower"
		 * 
		 * If true, make weapon deploy and holster 75% slower.
		 */
		val isASword: ItemAttributeNamed<Boolean> = ItemAttributeNamed("is_a_sword")
	
		/**
		 * In-Game: "Replaces the Sentry with a Mini-Sentry"
		 * 
		 * Determines the hand used in the model.
		 */
		val wrenchBuildsMinisentry: ItemAttributeNamed<Boolean> = ItemAttributeNamed("mod wrench builds minisentry")
	
		val afterburn: AfterburnAttributes = AfterburnAttributes()
	
		val ammo: AmmoAttributes = AmmoAttributes()
	
		val buildings: BuildingsAttributes = BuildingsAttributes()
	
		val crits: CritsAttributes = CritsAttributes()
	
		val damage: DamageAttributes = DamageAttributes()
	
		val demoCharge: DemoChargeAttributes = DemoChargeAttributes()
	
		val firing: FiringAttributes = FiringAttributes()
	
		val healthAndHealing: HealthAndHealingAttributes = HealthAndHealingAttributes()
	
		val knockbackReceived: KnockbackReceivedAttributes = KnockbackReceivedAttributes()
	
		val meta: MetaAttributes = MetaAttributes()
	
		val meter: MeterAttributes = MeterAttributes()
	
		val movement: MovementAttributes = MovementAttributes()
	
		val heads: HeadsAttributes = HeadsAttributes()
	
		val onHit: OnHitAttributes = OnHitAttributes()
	
		val onKill: OnKillAttributes = OnKillAttributes()
	
		val projectiles: ProjectilesAttributes = ProjectilesAttributes()
	
		val reloading: ReloadingAttributes = ReloadingAttributes()
	
		val resistance: ResistanceAttributes = ResistanceAttributes()
	
		val revengeCrits: RevengeCritsAttributes = RevengeCritsAttributes()
	
		val statusEffects: StatusEffectsAttributes = StatusEffectsAttributes()
	
		val taunting: TauntingAttributes = TauntingAttributes()
	
		val swapWeapons: SwapWeaponsAttributes = SwapWeaponsAttributes()
	
		val whenHit: WhenHitAttributes = WhenHitAttributes()
	
		val ragdolls: RagdollsAttributes = RagdollsAttributes()
	
		private val disguise: DisguiseAttributes = DisguiseAttributes()
	}

	/**
	 * In-Game: "This Weapon has a large melee range and deploys and holsters slower"
	 * 
	 * If true, make weapon deploy and holster 75% slower.
	 */
	val isASword: ItemAttributeNamed<Boolean> get() = WeaponBaseAttributes.isASword
	
	/**
	 * In-Game: "Replaces the Sentry with a Mini-Sentry"
	 * 
	 * Determines the hand used in the model.
	 */
	val wrenchBuildsMinisentry: ItemAttributeNamed<Boolean> get() = WeaponBaseAttributes.wrenchBuildsMinisentry
	
	val afterburn: AfterburnAttributes get() = WeaponBaseAttributes.afterburn
	
	override val ammo: AmmoAttributes get() = WeaponBaseAttributes.ammo
	
	val buildings: BuildingsAttributes get() = WeaponBaseAttributes.buildings
	
	override val crits: CritsAttributes get() = WeaponBaseAttributes.crits
	
	override val damage: DamageAttributes get() = WeaponBaseAttributes.damage
	
	val demoCharge: DemoChargeAttributes get() = WeaponBaseAttributes.demoCharge
	
	val firing: FiringAttributes get() = WeaponBaseAttributes.firing
	
	val healthAndHealing: HealthAndHealingAttributes get() = WeaponBaseAttributes.healthAndHealing
	
	override val knockbackReceived: KnockbackReceivedAttributes get() = WeaponBaseAttributes.knockbackReceived
	
	override val meta: MetaAttributes get() = WeaponBaseAttributes.meta
	
	override val meter: MeterAttributes get() = WeaponBaseAttributes.meter
	
	val movement: MovementAttributes get() = WeaponBaseAttributes.movement
	
	val heads: HeadsAttributes get() = WeaponBaseAttributes.heads
	
	val onHit: OnHitAttributes get() = WeaponBaseAttributes.onHit
	
	val onKill: OnKillAttributes get() = WeaponBaseAttributes.onKill
	
	val projectiles: ProjectilesAttributes get() = WeaponBaseAttributes.projectiles
	
	val reloading: ReloadingAttributes get() = WeaponBaseAttributes.reloading
	
	override val resistance: ResistanceAttributes get() = WeaponBaseAttributes.resistance
	
	val revengeCrits: RevengeCritsAttributes get() = WeaponBaseAttributes.revengeCrits
	
	val statusEffects: StatusEffectsAttributes get() = WeaponBaseAttributes.statusEffects
	
	val taunting: TauntingAttributes get() = WeaponBaseAttributes.taunting
	
	val swapWeapons: SwapWeaponsAttributes get() = WeaponBaseAttributes.swapWeapons
	
	val whenHit: WhenHitAttributes get() = WeaponBaseAttributes.whenHit
	
	val ragdolls: RagdollsAttributes get() = WeaponBaseAttributes.ragdolls
	
	override val disguise: DisguiseAttributes get() = WeaponBaseAttributes.disguise

	open class AfterburnAttributes : IBlockScoped {
		/**
		 * In-Game: "On Hit: target is engulfed in flames"
		 * 
		 * Ignites player on hit.
		 */
		open val setDamagetypeIgnite: ItemAttributeNamed<Boolean> = ItemAttributeNamed("Set DamageType Ignite")
	
		/**
		 * Bonus:
		 * 
		 * 	- In-Game: "+N% afterburn damage bonus"
		 * 
		 * Penalty:
		 * 
		 * 	- In-Game: "N% afterburn damage penalty"
		 */
		open val weaponBurnDmgReduced: BonusPenalty<Number> = BonusPenalty(
			ItemAttributeNamed("weapon burn dmg increased"),
			ItemAttributeNamed("weapon burn dmg reduced"),
		)
	
		/**
		 * Bonus:
		 * 
		 * 	- In-Game: "+N% afterburn duration"
		 * 
		 * Penalty:
		 * 
		 * 	- In-Game: "N% afterburn duration"
		 */
		open val weaponBurnTimeReduced: BonusPenalty<Number> = BonusPenalty(
			ItemAttributeNamed("weapon burn time increased"),
			ItemAttributeNamed("weapon burn time reduced"),
		)
	
		/**
		 * In-Game: "Halloween Fire"
		 * 
		 * Makes afterburn green.
		 */
		open val spellHalloweenGreenFlames: ItemAttributeNamed<Boolean> = ItemAttributeNamed("SPELL: Halloween green flames")
	}
	
	open class AmmoAttributes : BaseCombatWeaponAttributes.AmmoAttributes() {
		/**
		 * In-Game: "No ammo from dispensers when active"
		 */
		open val noPrimaryAmmoFromDispensersWhileActive: ItemAttributeNamed<Boolean> = ItemAttributeNamed("no primary ammo from dispensers while active")
	
		/**
		 * In-Game: "No metal from dispensers when active."
		 */
		open val noMetalFromDispensersWhileActive: ItemAttributeNamed<Boolean> = ItemAttributeNamed("no metal from dispensers while active")
	
		override val clipSize: ClipSizeAttributes = ClipSizeAttributes()
	
		open class ClipSizeAttributes : BaseCombatWeaponAttributes.AmmoAttributes.ClipSizeAttributes() {
			/**
			 * Bonus:
			 * 
			 * 	- In-Game: "+N% clip size"
			 * 
			 * Penalty:
			 * 
			 * 	- In-Game: "N% clip size"
			 * 
			 * Hidden:
			 * 
			 * 	- In-Game: "N% clip size"
			 */
			open val clipSize: BonusPenaltyHidden<Number, ItemAttributeNamed<Number>> = BonusPenaltyHidden(
				ItemAttributeNamed<Number>("clip size bonus"),
				ItemAttributeNamed<Number>("clip size penalty"),
				ItemAttributeNamed<Number>("clip size penalty HIDDEN"),
			)
	
			/**
			 * In-Game: "+N% clip size"
			 */
			open val clipSizeBonusUpgrade: ItemAttributeNamed<Int> = ItemAttributeNamed("clip size bonus upgrade")
	
			/**
			 * In-Game: "+N clip size"
			 * 
			 * MVM attribute that specifically handles rocket and grenade launchers.
			 * 
			 * Note that all three of these are different classes, which means they stack.
			 */
			open val clipSizeUpgradeAtomic: ItemAttributeNamed<Int> = ItemAttributeNamed("clip size upgrade atomic")
	
			/**
			 * In-Game: "Clip size increased on kill"
			 */
			open val clipsizeIncreaseOnKill: ItemAttributeNamed<Int> = ItemAttributeNamed("clipsize increase on kill")
		}
	}
	
	open class BuildingsAttributes : IBlockScoped {
		/**
		 * In-Game: "Alt-Fire: Use N metal to pick up your targeted building from long range"
		 * 
		 * Metal cost to pick up a building at range.
		 * 
		 * Restricted to the default rescue ranger range, but can be used by any weapon.
		 */
		open val buildingRescueMetalCost: ItemAttributeNamed<Int> = ItemAttributeNamed("engineer building teleporting pickup")
	}
	
	open class CritsAttributes : BaseCombatWeaponAttributes.CritsAttributes() {
		open val multRandomCritChance: VisHidden<Number> = VisHidden(ItemAttributeNamed<Number>("crit mod disabled"), ItemAttributeNamed<Number>("crit mod disabled hidden"))
	
		/**
		 * In-Game: "Cannot be crit boosted"
		 * 
		 * Can't be crit-boosted.
		 */
		open val noCritBoost: ItemAttributeNamed<Boolean> = ItemAttributeNamed("no crit boost")
	
		/**
		 * The weapon's "crit players with X condition" stat.
		 */
		open val critVsConditions: ItemAttributeNamed<EnumSet<TFCritCondition>> = ItemAttributeNamed("crit vs burning players", EnumSetOrCodec())
	
		/**
		 * In-Game: "100% critical hit vs burning players"
		 * 
		 * The weapon's "crit players with X condition" stat.
		 */
		open val critVsBurningPlayers: ItemAttributeNamed<EnumSet<TFCritCondition>> = ItemAttributeNamed("crit vs burning players", EnumSetOrCodec())
	
		/**
		 * In-Game: "100% critical hit vs disguised players"
		 * 
		 * The weapon's "crit players with X condition" stat.
		 */
		open val critVsDisguisedPlayers: ItemAttributeNamed<EnumSet<TFCritCondition>> = ItemAttributeNamed("crit vs disguised players", EnumSetOrCodec())
	
		/**
		 * In-Game: "100% critical hit vs wet players"
		 */
		open val critVsWetPlayers: ItemAttributeNamed<Boolean> = ItemAttributeNamed("crit vs wet players")
	
		/**
		 * In-Game: "100% critical hit vs non-burning players"
		 * 
		 * Crit against players that DON'T have these conditions.
		 */
		open val critVsNonBurningPlayers: ItemAttributeNamed<EnumSet<TFCritCondition>> = ItemAttributeNamed("crit vs non burning players", EnumSetOrCodec())
	
		/**
		 * In-Game: "100% critical hits burning players from behind. Mini-crits burning players from the front."
		 * 
		 * On hitting a burning player, crit them from behind or minicrit them otherwise.
		 */
		open val axtinguisherProperties: ItemAttributeNamed<Boolean> = ItemAttributeNamed("axtinguisher properties")
	
		/**
		 * In-Game: "Deals crits while the wielder is rocket jumping"
		 * 
		 * Critical hit enemies if the player was launched into the air by an explosion.
		 * 
		 * Only works when not in Mannpower mode.
		 */
		open val critWhileAirborne: ItemAttributeNamed<Boolean> = ItemAttributeNamed("mod crit while airborne")
	
		/**
		 * In-Game: "Mini-crits burning targets and extinguishes them. Damage increases based on remaining duration of afterburn. Killing blows on burning players grant a speed boost."
		 * 
		 * Only activates if the weapon deals `DMG_MELEE`.
		 */
		open val attackMinicritsAndConsumesBurning: ItemAttributeNamed<Boolean> = ItemAttributeNamed("attack_minicrits_and_consumes_burning")
	
		/**
		 * In-Game: "100% minicrits vs burning players"
		 * 
		 * Minicrits if the damage dealt is NOT `DMG_BURN`.
		 */
		open val minicritVsBurningPlayer: ItemAttributeNamed<Boolean> = ItemAttributeNamed("minicrit vs burning player")
	
		/**
		 * In-Game: "Mini-crits targets launched airborne by explosions, grapple hooks or rocket packs"
		 * 
		 * Mini-crits targets launched airborne by an explosion.
		 * 
		 * Only procs when not in Mannpower mode.
		 */
		open val minicritAirborne: ItemAttributeNamed<Boolean> = ItemAttributeNamed("mod mini-crit airborne")
	
		/**
		 * In-Game: "Mini-crits targets when fired at their back from close range"
		 * 
		 * If true, minicrits targets facing away from the attacker that are within 22.6 HU of the attacker (sqrt 512).
		 */
		open val closerangeBackattackMinicrits: ItemAttributeNamed<Boolean> = ItemAttributeNamed("closerange backattack minicrits")
	
		/**
		 * In-Game: "Crits whenever it would normally mini-crit"
		 */
		open val minicritsBecomeCrits: ItemAttributeNamed<Boolean> = ItemAttributeNamed("minicrits become crits")
	
		/**
		 * In-Game: "No critical hits vs non-burning players"
		 * 
		 * Note: Even prevents criticals when crit-boosted.
		 */
		open val noCritVsNonburning: ItemAttributeNamed<Boolean> = ItemAttributeNamed("no crit vs nonburning")
	
		/**
		 * In-Game: "Critical damage is affected by range"
		 * 
		 * If true, crits have damage falloff (Ambassador).
		 */
		open val critDmgFalloff: ItemAttributeNamed<Boolean> = ItemAttributeNamed("crit_dmg_falloff")
	
		/**
		 * In-Game: "Minicrits whenever it would normally crit"
		 */
		open val critsBecomeMinicrits: ItemAttributeNamed<Boolean> = ItemAttributeNamed("crits_become_minicrits")
	}
	
	open class DamageAttributes : BaseCombatWeaponAttributes.DamageAttributes() {
		/**
		 * Bonus:
		 * 
		 * 	- In-Game: "+N% damage bonus"
		 * 
		 * Penalty:
		 * 
		 * 	- In-Game: "N% damage penalty"
		 * 
		 * Neutral:
		 * 
		 * 	- In-Game: "+N% damage bonus"
		 * 
		 * Hidden:
		 * 
		 * 	- In-Game: "+N% damage bonus"
		 */
		open val damage: BonusPenaltyNeutralHidden<Number, ItemAttributeNamed<Number>> = BonusPenaltyNeutralHidden(
			ItemAttributeNamed<Number>("damage bonus"),
			ItemAttributeNamed<Number>("damage penalty"),
			ItemAttributeNamed<Number>("CARD: damage bonus"),
			ItemAttributeNamed<Number>("damage bonus HIDDEN"),
		)
	
		open val dmgVsBuildings: VisHidden<Number> = VisHidden(ItemAttributeNamed<Number>("dmg bonus vs buildings"), ItemAttributeNamed<Number>("dmg penalty vs buildings"))
	
		/**
		 * In-Game: "N% damage vs players"
		 */
		open val dmgPenaltyVsPlayers: ItemAttributeNamed<Number> = ItemAttributeNamed("dmg penalty vs players")
	
		/**
		 * In-Game: "N% damage vs non-burning players"
		 */
		open val dmgPenaltyVsNonburning: ItemAttributeNamed<Number> = ItemAttributeNamed("dmg penalty vs nonburning")
	
		/**
		 * In-Game: "N% damage bonus vs burning players"
		 */
		open val damageBonusVsBurning: ItemAttributeNamed<Number> = ItemAttributeNamed("damage bonus vs burning")
	
		/**
		 * In-Game: "Attacks pierce damage resistance effects and bonuses"
		 * 
		 * Damage pierces through all resistances, such as Vaccinator ubercharges and the Battalion's Backup.
		 */
		open val dmgPiercesResistsAbsorbs: ItemAttributeNamed<Boolean> = ItemAttributeNamed("dmg pierces resists absorbs")
	
		/**
		 * In-Game: "N% increased damage to your sentry's target"
		 */
		open val damageBonusBulletVsSentryTarget: ItemAttributeNamed<Number> = ItemAttributeNamed("damage bonus bullet vs sentry target")
	
		/**
		 * In-Game: "N% damage on body shot"
		 * 
		 * Multiplier applied to bodyshot damage.
		 */
		open val damagePenaltyOnBodyshot: ItemAttributeNamed<Number> = ItemAttributeNamed("damage penalty on bodyshot")
	}
	
	open class DemoChargeAttributes : IBlockScoped {
		/**
		 * In-Game: "Melee hits refill  N% of your charge meter."
		 * 
		 * Restores demoman shield charge on hit.
		 */
		open val chargeMeterOnHit: ItemAttributeNamed<Number> = ItemAttributeNamed("charge meter on hit")
	
		/**
		 * In-Game: "Ammo boxes collected also give Charge"
		 * 
		 * If true, and player has a demoman charge meter, add charge based on ammo pack size.
		 */
		open val ammoPacksGiveDemoknightCharge: ItemAttributeNamed<Boolean> = ItemAttributeNamed("ammo gives charge")
	}
	
	open class FiringAttributes : IBlockScoped {
		/**
		 * Bonus:
		 * 
		 * 	- In-Game: "Hold Fire to load up to three rockets Release Fire to unleash the barrage"
		 * 
		 * Penalty:
		 */
		open val autoFiresFullClip: BonusPenalty<Boolean> = BonusPenalty(
			ItemAttributeNamed("auto fires full clip"),
			ItemAttributeNamed("auto fires full clip penalty"),
		)
	
		open val autoFiresFullClipAllAtOnce: ItemAttributeNamed<Boolean> = ItemAttributeNamed("auto fires full clip all at once")
	
		open val autoFiresWhenFull: ItemAttributeNamed<Boolean> = ItemAttributeNamed("auto fires when full")
	
		/**
		 * In-Game: "Overloading the chamber will cause a misfire"
		 * 
		 * Deals damage to the player when overloaded.
		 */
		open val canOverload: ItemAttributeNamed<Boolean> = ItemAttributeNamed("can overload")
	
		open val fireRate: FireRateAttributes = FireRateAttributes()
	
		open class FireRateAttributes : IBlockScoped {
			/**
			 * Bonus:
			 * 
			 * 	- In-Game: "+N% faster firing speed"
			 * 
			 * Penalty:
			 * 
			 * 	- In-Game: "N% slower firing speed"
			 * 
			 * Neutral:
			 * 
			 * 	- In-Game: "+N% faster melee attack speed"
			 * 
			 * Hidden:
			 * 
			 * 	- Bonus:
			 * 
			 * 		- In-Game: "+N% faster firing speed"
			 * 
			 * 	- Penalty:
			 */
			open val fireRate: BonusPenaltyNeutralHidden<Number, BonusPenalty<Number>> = BonusPenaltyNeutralHidden(
				ItemAttributeNamed<Number>("fire rate bonus"),
				ItemAttributeNamed<Number>("fire rate penalty"),
				ItemAttributeNamed<Number>("melee attack rate bonus"),
				BonusPenalty(
				ItemAttributeNamed<Number>("fire rate bonus HIDDEN"),
				ItemAttributeNamed<Number>("fire rate penalty HIDDEN"),
			),
			)
		}
	}
	
	open class HealthAndHealingAttributes : IBlockScoped {
		/**
		 * In-Game: "Blocks healing while in use"
		 * 
		 * Prevents mediguns/dispensers from targeting you and crossbow bolts from healing you while the weapon is active.
		 */
		open val weaponBlocksHealing: ItemAttributeNamed<Boolean> = ItemAttributeNamed("mod weapon blocks healing")
	
		/**
		 * Bonus:
		 * 
		 * 	- In-Game: "+N health regenerated per second on wearer"
		 * 
		 * Penalty:
		 * 
		 * 	- In-Game: "N health drained per second on wearer"
		 */
		open val passiveHealthRegen: BonusPenalty<Int> = BonusPenalty(
			ItemAttributeNamed("active health regen"),
			ItemAttributeNamed("active health degen"),
		)
	
		/**
		 * In-Game: "+N% ÜberCharge rate for the medic healing you This effect does not work in the respawn room"
		 * 
		 * Multiplier applied to your healer's ubercharge rate.
		 * 
		 * NOTE: Only applied if user is outside of the respawn room.
		 */
		open val uberchargeRateBonusForHealer: ItemAttributeNamed<Number> = ItemAttributeNamed("ubercharge rate bonus for healer")
	
		/**
		 * In-Game: "On Hit: Gain up to +N health per attack"
		 * 
		 * Maximum amount of health that can be gained from an AoE damage source.
		 * 
		 * Health received is multiplied by `damage dealt / base damage of the weapon`, to a max of 100% of the defined value.
		 */
		open val healOnHit_radial: ItemAttributeNamed<Int> = ItemAttributeNamed("health on radius damage")
	
		/**
		 * In-Game: "N% health from healers on wearer"
		 * 
		 * Attribute class is a flat multiplier applied to health from healers while weapon is active.
		 */
		open val multHealthFromHealersWhileActive: ItemAttributeNamed<Number> = ItemAttributeNamed("mult_health_fromhealers_penalty_active")
	
		/**
		 * In-Game: "N% Overheal build rate."
		 * 
		 * Checked on the player that is healing an entity.
		 */
		open val multOverhealFillRate: ItemAttributeNamed<Number> = ItemAttributeNamed("overheal fill rate reduced")
	
		/**
		 * In-Game: "N% less healing from Medic sources"
		 * 
		 * Applies to all non-dispenser forms of healing that apply the `TF_COND_HEAL_BUFF` status.
		 */
		open val reducedHealingFromMedics: ItemAttributeNamed<Number> = ItemAttributeNamed("reduced_healing_from_medics")
	
		/**
		 * Bonus:
		 * 
		 * 	- In-Game: "+N% bonus healing from all sources"
		 * 
		 * Penalty:
		 * 
		 * 	- In-Game: "N% less healing from all sources"
		 */
		open val multHealingReceived: BonusPenalty<Number> = BonusPenalty(
			ItemAttributeNamed("healing received bonus"),
			ItemAttributeNamed("healing received penalty"),
		)
	
		/**
		 * In-Game: "Maximum health is drained while item is active"
		 * 
		 * Maximum health decrease per tick while weapon is active. (Gloves of Running Urgently/Eviction Notice).
		 */
		open val maxHealthDrainedWhileActive: ItemAttributeNamed<Number> = ItemAttributeNamed("mod_maxhealth_drain_rate")
	}
	
	open class KnockbackReceivedAttributes : BaseCombatWeaponAttributes.KnockbackReceivedAttributes() {
		/**
		 * Bonus:
		 * 
		 * 	- In-Game: "+N% self damage force"
		 * 
		 * Penalty:
		 * 
		 * 	- In-Game: "N% self damage force"
		 */
		open val selfDmgPushForce: BonusPenalty<Number> = BonusPenalty(
			ItemAttributeNamed("self dmg push force increased"),
			ItemAttributeNamed("self dmg push force decreased"),
		)
	
		open val damageForceReduction: DamageForceReductionAttributes = DamageForceReductionAttributes()
	
		open class DamageForceReductionAttributes : IBlockScoped {
			/**
			 * In-Game: "N% reduction in push force taken from damage"
			 * 
			 * Attribute class is a flat multiplier applied to push force received from damage.
			 */
			open val damageForceReduction: ItemAttributeNamed<Number> = ItemAttributeNamed("damage force reduction")
	
			/**
			 * In-Game: "N% increase in push force taken from damage"
			 * 
			 * Attribute class is a flat multiplier applied to push force received from damage.
			 */
			open val damageForceIncrease: ItemAttributeNamed<Number> = ItemAttributeNamed("damage force increase")
	
			/**
			 * In-Game: "N% increase in push force taken from damage"
			 * 
			 * Attribute class is a flat multiplier applied to push force received from damage.
			 */
			open val damageForceIncreaseHidden: ItemAttributeNamed<Number> = ItemAttributeNamed("damage force increase hidden")
	
			/**
			 * In-Game: "Increase in push force taken from damage and airblast"
			 * 
			 * Attribute class is a flat multiplier applied to push force received from damage.
			 */
			open val damageForceIncreaseText: ItemAttributeNamed<Number> = ItemAttributeNamed("damage force increase text")
		}
	}
	
	open class MetaAttributes : BaseCombatWeaponAttributes.MetaAttributes() {
		/**
		 * What "Strange Part" kills with this weapon should contribute to.
		 */
		open val killEaterKillType: ItemAttributeNamed<Int> = ItemAttributeNamed("kill eater kill type")
	
		override val killfeed: KillfeedAttributes = KillfeedAttributes()
	
		open val viewmodel: ViewmodelAttributes = ViewmodelAttributes()
	
		override val items: ItemsAttributes = ItemsAttributes()
	
		override val particles: ParticlesAttributes = ParticlesAttributes()
	
		open class KillfeedAttributes : BaseCombatWeaponAttributes.MetaAttributes.KillfeedAttributes() {
			open val isGigerCounter: ItemAttributeNamed<Boolean> = ItemAttributeNamed("is giger counter")
	
			/**
			 * Sets killfeed background gold.
			 */
			open val isAustraliumItem: ItemAttributeNamed<Boolean> = ItemAttributeNamed("is australium item")
	
			/**
			 * In-Game: "Imbued with an ancient power"
			 * 
			 * Sets killfeed background gold.
			 */
			open val turnToGold: ItemAttributeNamed<Boolean> = ItemAttributeNamed("turn to gold")
	
			/**
			 * In-Game: "Silent Killer: No attack noise from backstabs"
			 * 
			 * Kills will not show up in the killfeed.
			 */
			open val silentKiller: ItemAttributeNamed<Boolean> = ItemAttributeNamed("silent killer")
		}
	
		open class ViewmodelAttributes : IBlockScoped {
			open val weaponAllowInspect: ItemAttributeNamed<Boolean> = ItemAttributeNamed("weapon_allow_inspect")
	
			open val weaponStattrakModuleScale: ItemAttributeNamed<Number> = ItemAttributeNamed("weapon_stattrak_module_scale")
	
			open val minViewmodelOffset: ItemAttributeNamed<String> = ItemAttributeNamed("min_viewmodel_offset")
		}
	
		open class ItemsAttributes : BaseCombatWeaponAttributes.MetaAttributes.ItemsAttributes() 
	
		open class ParticlesAttributes : BaseCombatWeaponAttributes.MetaAttributes.ParticlesAttributes() 
	}
	
	open class MeterAttributes : BaseCombatWeaponAttributes.MeterAttributes() {
		/**
		 * In-Game: "+N% increase in recharge rate"
		 * 
		 * For things like throwable recharge timers, jetpack charging, etc: how much it recharges per second.
		 */
		open val effectBarRechargeRateIncreased: ItemAttributeNamed<Number> = ItemAttributeNamed("effect bar recharge rate increased")
	}
	
	open class MovementAttributes : IBlockScoped {
		/**
		 * In-Game: "+N% greater jump height when active"
		 * 
		 * Only takes effect while this weapon is active.
		 */
		open val increasedJumpHeightFromWeapon: ItemAttributeNamed<Number> = ItemAttributeNamed("increased jump height from weapon")
	
		/**
		 * In-Game: "Grants Triple Jump while deployed. Melee attacks mini-crit while airborne."
		 * 
		 * If greater than 0, attacks minicrit while airborne.
		 * 
		 * Only procs on Scout.
		 */
		open val airDashCount: ItemAttributeNamed<Int> = ItemAttributeNamed("air dash count")
	
		open val moveSpeed: MoveSpeedAttributes = MoveSpeedAttributes()
	
		open class MoveSpeedAttributes : IBlockScoped {
			/**
			 * Multiplier applied to movement speed scaled by ubercharge percentage.
			 * 
			 * Only works if the player using this item is a Medic with a Medigun.
			 */
			open val moveSpeedBonusResourceLevel: ItemAttributeNamed<Number> = ItemAttributeNamed("move speed bonus resource level")
	
			/**
			 * In-Game: "+N% faster move speed on wearer"
			 * 
			 * Multiplier applied to player movement speed only while this is the active weapon.
			 */
			open val multPlayerMovespeedActive: ItemAttributeNamed<Number> = ItemAttributeNamed("mult_player_movespeed_active")
		}
	}
	
	open class HeadsAttributes : IBlockScoped 
	
	open class OnHitAttributes : IBlockScoped {
		/**
		 * In-Game: "+N% cloak on hit"
		 * 
		 * Adds this amount of cloak on hit.
		 * 
		 * Only procs on Spy.
		 */
		open val addCloakOnHit: ItemAttributeNamed<Int> = ItemAttributeNamed("add cloak on hit")
	
		/**
		 * In-Game: "On Hit: damage dealt is returned as ammo"
		 * 
		 * Gain ammo equivalent to damage dealt on hit.
		 */
		open val addOnhitAddammo: ItemAttributeNamed<Boolean> = ItemAttributeNamed("add onhit addammo")
	
		/**
		 * In-Game: "On Hit Spy: Reveal cloaked Spy"
		 */
		open val revealCloakedVictimOnHit: ItemAttributeNamed<Boolean> = ItemAttributeNamed("reveal cloaked victim on hit")
	
		/**
		 * In-Game: "On Hit Spy: Reveal disguised Spy"
		 */
		open val revealDisguisedVictimOnHit: ItemAttributeNamed<Boolean> = ItemAttributeNamed("reveal disguised victim on hit")
	
		open val healOnHitForRapidfire: HealOnHitForRapidfireAttributes = HealOnHitForRapidfireAttributes()
	
		/**
		 * In-Game: "On Hit: Gain a speed boost"
		 * 
		 * Just does `addcond(SPEED_BOOST, speed_boost_on_hit)`.
		 */
		open val speedBoostOnHit: ItemAttributeNamed<Int> = ItemAttributeNamed("speed_boost_on_hit")
	
		/**
		 * In-Game: "On Hit: N% ÜberCharge added"
		 * 
		 * Only procs if on a Medic.
		 */
		open val addUberChargeOnHit: ItemAttributeNamed<Number> = ItemAttributeNamed("add uber charge on hit")
	
		/**
		 * Bonus:
		 * 
		 * 	- In-Game: "N% rage gained on hit"
		 * 
		 * Penalty:
		 * 
		 * 	- In-Game: "N% rage lost on hit"
		 */
		open val rageOnHit: BonusPenalty<Int> = BonusPenalty(
			ItemAttributeNamed("mod rage on hit bonus"),
			ItemAttributeNamed("mod rage on hit penalty"),
		)
	
		/**
		 * In-Game: "On Hit: Builds Boost Run speed increased with Boost"
		 * 
		 * Gain Scout's "hype" meter on hit.
		 * 
		 * This exists for everything, but specifically modifies Scout's "hype" meter, which is only used for the Soda Popper and Baby Face's Blaster.
		 */
		open val boostOnDamage: ItemAttributeNamed<Boolean> = ItemAttributeNamed("boost on damage")
	
		open val generateRageOnDamage: GenerateRageOnDamageAttributes = GenerateRageOnDamageAttributes()
	
		/**
		 * In-Game: "On Hit: One target at a time is Marked-For-Death, causing all damage taken to be mini-crits"
		 */
		open val markForDeath: ItemAttributeNamed<Boolean> = ItemAttributeNamed("mark for death")
	
		/**
		 * In-Game: "On Hit: If enemy's belt is at or above eye level, stun them for N seconds"
		 * 
		 * Stun airborne targets.
		 */
		open val stunWaistHighAirborne: ItemAttributeNamed<Boolean> = ItemAttributeNamed("mod stun waist high airborne")
	
		/**
		 * In-Game: "On Hit: Victim loses up to N% Medigun charge"
		 * 
		 * Percentage as an int, e.g. `25` = 25% = 0.25.
		 * 
		 * Drain scaled over distance.
		 */
		open val subtractVictimMedigunChargeOnHit: ItemAttributeNamed<Int> = ItemAttributeNamed("subtract victim medigun charge on hit")
	
		/**
		 * In-Game: "On Hit: Victim loses up to N% cloak"
		 * 
		 * Subtracts an actual value.
		 * 
		 * Drain still scaled over distance.
		 */
		open val subtractVictimCloakOnHit: ItemAttributeNamed<Int> = ItemAttributeNamed("subtract victim cloak on hit")
	
		/**
		 * In-Game: "On Hit: N% chance to slow target"
		 * 
		 * Gain speedboost on hit.
		 */
		open val slowEnemyOnHit: ItemAttributeNamed<Number> = ItemAttributeNamed("slow enemy on hit")
	
		/**
		 * In-Game: "On Hit: Slow target movement by 40% for Ns"
		 * 
		 * Gain speedboost for N seconds.
		 */
		open val slowEnemyOnHitMajor: ItemAttributeNamed<Number> = ItemAttributeNamed("slow enemy on hit major")
	
		/**
		 * In-Game: "Syringes deliver a highly concentrated dose of Mad Milk. Duration increases per hit to a max of 4 seconds."
		 * 
		 * Applies Mad Milk with a duration of 4 seconds, and each subsequent hit on the same target adds 0.5 seconds to the duration.
		 */
		open val madMilkSyringes: ItemAttributeNamed<Boolean> = ItemAttributeNamed("mad milk syringes")
	
		/**
		 * In-Game: "Stuns enemies who are also wielding this weapon"
		 */
		open val stunEnemiesWieldingSameWeapon: ItemAttributeNamed<Boolean> = ItemAttributeNamed("stun enemies wielding same weapon")
	
		/**
		 * In-Game: "All players connected via Medigun beams are hit"
		 * 
		 * Damage all players connected to the target by medigun beams.
		 */
		open val damageAllConnected: ItemAttributeNamed<Boolean> = ItemAttributeNamed("damage all connected")
	
		/**
		 * Apply this amount of z velocity to players hit with this weapon.
		 */
		open val applyZVelocityOnDamage: ItemAttributeNamed<Number> = ItemAttributeNamed("apply z velocity on damage")
	
		/**
		 * Apply this amount of velocity in the direction you're facing to players hit with this weapon.
		 */
		open val applyLookVelocityOnDamage: ItemAttributeNamed<Number> = ItemAttributeNamed("apply look velocity on damage")
	
		/**
		 * Push force applied to target when hitting an enemy.
		 * 
		 * Scales by range, to a minimum of 50% of the given value.
		 */
		open val damageBlastPush: ItemAttributeNamed<Number> = ItemAttributeNamed("damage blast push")
	
		/**
		 * In-Game: "On Hit: Bleed for N seconds"
		 * 
		 * Apply bleed on hit.
		 * 
		 * Value is a time in seconds.
		 */
		open val bleedingDuration: ItemAttributeNamed<Number> = ItemAttributeNamed("bleeding duration")
	
		open class HealOnHitForRapidfireAttributes : IBlockScoped {
			/**
			 * In-Game: "On Hit: Gain up to +N health"
			 * 
			 * Add this amount of health on hit.
			 */
			open val healOnHitForRapidfire: ItemAttributeNamed<Int> = ItemAttributeNamed("heal on hit for rapidfire")
	
			/**
			 * In-Game: "On Hit: N health"
			 * 
			 * Add this amount of health on hit.
			 */
			open val selfdmgOnHitForRapidfire: ItemAttributeNamed<Int> = ItemAttributeNamed("selfdmg on hit for rapidfire")
	
			/**
			 * In-Game: "On Hit: Gain up to +N health"
			 * 
			 * Add this amount of health on hit.
			 */
			open val healOnHitForSlowfire: ItemAttributeNamed<Int> = ItemAttributeNamed("heal on hit for slowfire")
	
			/**
			 * In-Game: "On Hit: N health"
			 * 
			 * Add this amount of health on hit.
			 */
			open val selfdmgOnHitForSlowfire: ItemAttributeNamed<Int> = ItemAttributeNamed("selfdmg on hit for slowfire")
		}
	
		open class GenerateRageOnDamageAttributes : IBlockScoped {
			/**
			 * In-Game: "Generate Rage by dealing damage.  When fully charged, press the Special-Attack key to activate knockback"
			 * 
			 * Knockback rage on enemy if you're a heavy and your rage is draining.
			 */
			open val generateRageOnDamage: ItemAttributeNamed<Boolean> = ItemAttributeNamed("generate rage on damage")
	
			/**
			 * In-Game: "Generate building rescue energy on damage"
			 * 
			 * Knockback rage on enemy if you're a heavy and your rage is draining.
			 */
			open val engineerRageOnDmg: ItemAttributeNamed<Boolean> = ItemAttributeNamed("engineer rage on dmg")
		}
	}
	
	open class OnKillAttributes : IBlockScoped {
		/**
		 * In-Game: "On Kill: N seconds of 100% critical chance"
		 * 
		 * Seconds of crit-boost gained on kill.
		 * 
		 * Note: actual time is `this + 1`.
		 */
		open val critboostOnKill: ItemAttributeNamed<Int> = ItemAttributeNamed("critboost on kill")
	
		/**
		 * In-Game: "On Kill: Gain Mini-crits for N seconds."
		 * 
		 * Seconds of minicrit-boost gained on kill.
		 * 
		 * Note: actual time is `this + 1`.
		 */
		open val minicritboostOnKill: ItemAttributeNamed<Int> = ItemAttributeNamed("minicritboost on kill")
	
		/**
		 * In-Game: "On Kill: Gain N% of base health on kill"
		 * 
		 * Percentage of health to be restored upon killing an enemy. (e.g. `25` is 25%).
		 * 
		 * Post-heal player health value is capped at 1.5x the player's normal max health.
		 * 
		 * Negative values are ignored.
		 */
		open val restoreHealthOnKill: ItemAttributeNamed<Int> = ItemAttributeNamed("restore health on kill")
	
		/**
		 * In-Game: "+N health restored on kill"
		 * 
		 * Restores this flat amount of health on killing an enemy. Post-heal player health value is capped at the player's maximum overheal.
		 * 
		 * Negative values are NOT ignored.
		 */
		open val healOnKill: ItemAttributeNamed<Int> = ItemAttributeNamed("heal on kill")
	
		/**
		 * In-Game: "Gain a speed boost on kill"
		 */
		open val speedBoostOnKill: ItemAttributeNamed<Int> = ItemAttributeNamed("speed_boost_on_kill")
	
		/**
		 * In-Game: "Exorcism"
		 * 
		 * Exorcism spell effect.
		 */
		open val spellHalloweenDeathGhosts: ItemAttributeNamed<Boolean> = ItemAttributeNamed("SPELL: Halloween death ghosts")
	}
	
	open class ProjectilesAttributes : IBlockScoped {
		open val projectilePenetration: ProjectilePenetrationAttributes = ProjectilePenetrationAttributes()
	
		/**
		 * Note: "Projectile" includes bullets.
		 */
		open val centerfireProjectile: ItemAttributeNamed<Boolean> = ItemAttributeNamed("centerfire projectile")
	
		/**
		 * In-Game: "+N degrees random projectile deviation"
		 * 
		 * Does not include bullets.
		 */
		open val projectileSpreadAnglePenalty: ItemAttributeNamed<Number> = ItemAttributeNamed("projectile spread angle penalty")
	
		open val bullets: BulletsAttributes = BulletsAttributes()
	
		open class ProjectilePenetrationAttributes : IBlockScoped {
			/**
			 * In-Game: "Projectiles penetrate enemy players"
			 * 
			 * How many players your "projectile" (*including bullets*) should penetrate.
			 */
			open val projectilePenetration: ItemAttributeNamed<Int> = ItemAttributeNamed("projectile penetration")
	
			/**
			 * In-Game: "Bullets penetrate +N enemies"
			 * 
			 * How many players your "projectile" (*including bullets*) should penetrate.
			 */
			open val projectilePenetrationHeavy: ItemAttributeNamed<Int> = ItemAttributeNamed("projectile penetration heavy")
		}
	
		open class BulletsAttributes : IBlockScoped {
			/**
			 * In-Game: "+N% bullets per shot"
			 */
			open val bulletsPerShotBonus: ItemAttributeNamed<Number> = ItemAttributeNamed("bullets per shot bonus")
	
			/**
			 * In-Game: "Fires tracer rounds"
			 * 
			 * Note: Sniper rage forcibly draws a tracer regardless of this setting.
			 * 
			 * Used when firing bullets.
			 */
			open val sniperFiresTracer: ItemAttributeNamed<Boolean> = ItemAttributeNamed("sniper fires tracer")
	
			/**
			 * In-Game: "Fires tracer rounds"
			 * 
			 * Same as `sniper_fires_tracer`.
			 */
			open val sniperFiresTracerHidden: ItemAttributeNamed<Boolean> = ItemAttributeNamed("sniper fires tracer HIDDEN")
	
			/**
			 * In-Game: "On Full Charge: Projectiles penetrate players"
			 */
			open val penetratesWhenFullyCharged: ItemAttributeNamed<Boolean> = ItemAttributeNamed("sniper penetrate players when charged")
	
			/**
			 * In-Game: "Increased headshot explosion radius and damage to nearby enemies"
			 * 
			 * Only applies if in a gamemode with upgrades, but applies to all headshots.
			 * 
			 * Also applies to any hitscan weapon with a `jarate_time` attribute that hit the head.
			 */
			open val explosiveHeadshotLevel: ItemAttributeNamed<Int> = ItemAttributeNamed("explosive sniper shot")
		}
	}
	
	open class ReloadingAttributes : IBlockScoped {
		/**
		 * Bonus:
		 * 
		 * 	- In-Game: "N% faster reload time"
		 * 
		 * Penalty:
		 * 
		 * 	- In-Game: "N% slower reload time"
		 */
		open val reloadTime: BonusPenalty<Number> = BonusPenalty(
			ItemAttributeNamed("Reload time decreased"),
			ItemAttributeNamed("Reload time increased"),
		)
	
		/**
		 * In-Game: "N% slower reload time"
		 */
		open val reloadTimeIncreasedHidden: ItemAttributeNamed<Number> = ItemAttributeNamed("reload time increased hidden")
	
		/**
		 * In-Game: "+N% faster reload time"
		 * 
		 * This is what's used for weapons that draw directly from reserve ammo, like the flare gun and sniper rifle.
		 */
		open val fasterReloadRate: ItemAttributeNamed<Number> = ItemAttributeNamed("faster reload rate")
	
		/**
		 * Halloween reload time multiplier.
		 * 
		 * Checked on player.
		 */
		open val halloweenReloadTimeDecreased: ItemAttributeNamed<Number> = ItemAttributeNamed("halloween reload time decreased")
	
		/**
		 * In-Game: "N% faster reload time while being healed"
		 */
		open val reloadTimeDecreasedWhileHealed: ItemAttributeNamed<Number> = ItemAttributeNamed("reload time decreased while healed")
	}
	
	open class ResistanceAttributes : BaseCombatWeaponAttributes.ResistanceAttributes() {
		/**
		 * In-Game: "On Hit by Fire: Fireproof for 1 second and Afterburn immunity for N seconds"
		 * 
		 * Addcond parameter.
		 */
		open val becomeFireproofOnHitByFire: ItemAttributeNamed<Number> = ItemAttributeNamed("become fireproof on hit by fire")
	
		/**
		 * In-Game: "N% damage vulnerability on wearer"
		 */
		open val multDmgtakenActive: ItemAttributeNamed<Number> = ItemAttributeNamed("mult_dmgtaken_active")
	
		/**
		 * In-Game: "+N% damage from melee sources while active"
		 * 
		 * Multiplier applied to incoming melee damage.
		 */
		open val dmgFromMeleeIncreased: ItemAttributeNamed<Number> = ItemAttributeNamed("dmg from melee increased")
	
		/**
		 * In-Game: "N% damage from ranged sources while active"
		 * 
		 * Multiplier applied to incoming blast, bullet, buckshot, ignite, and sonic damage.
		 */
		open val dmgFromRangedReduced: ItemAttributeNamed<Number> = ItemAttributeNamed("dmg from ranged reduced")
	
		/**
		 * In-Game: "No self inflicted blast damage taken"
		 * 
		 * Also forces the "whistling" sound to play when rocket jumping.
		 */
		open val noSelfBlastDmg: ItemAttributeNamed<Boolean> = ItemAttributeNamed("no self blast dmg")
	
		/**
		 * In-Game: "+N% damage to self"
		 * 
		 * Multiplier applied to blast damage taken from an explosion caused by said entity.
		 */
		open val blastDmgToSelfIncreased: ItemAttributeNamed<Number> = ItemAttributeNamed("blast dmg to self increased")
	
		/**
		 * In-Game: "+N% fire damage resistance while deployed"
		 * 
		 * Resist this proportion of fire damage only while this weapon is active.
		 */
		open val dmgTakenFromFireReducedOnActive: ItemAttributeNamed<Number> = ItemAttributeNamed("dmg taken from fire reduced on active")
	
		/**
		 * In-Game: "+N% damage vulnerability while active"
		 * 
		 * Increases damage taken while minicrit-boosted by Crit-a-Cola, Buffalo Steak, etc.
		 */
		open val energyBuffDmgTakenMultiplier: ItemAttributeNamed<Number> = ItemAttributeNamed("energy buff dmg taken multiplier")
	
		/**
		 * In-Game: "The wearer cannot be killed by headshots"
		 * 
		 * When a headshot would kill you, reduce health to 1.
		 */
		open val setBonusNoDeathFromHeadshots: ItemAttributeNamed<Boolean> = ItemAttributeNamed("SET BONUS: no death from headshots")
	}
	
	open class RevengeCritsAttributes : IBlockScoped {
		/**
		 * In-Game: "Gives one guaranteed critical hit for each building destroyed with your sapper attached or backstab kill"
		 * 
		 * Weapon supports revenge crits if this, `extinguish_revenge`, or `sentry_killed_revenge` is set.
		 */
		open val sapperKillsCollectCrits: ItemAttributeNamed<Boolean> = ItemAttributeNamed("sapper kills collect crits")
	
		/**
		 * In-Game: "Alt-Fire: Extinguish teammates to gain guaranteed critical hits"
		 * 
		 * Weapon supports revenge crits if this, `sapper_kills_collect_crits`, or `sentry_killed_revenge` is set.
		 */
		open val extinguishEarnsRevengeCrits: ItemAttributeNamed<Boolean> = ItemAttributeNamed("extinguish earns revenge crits")
	
		/**
		 * In-Game: "Gain 2 revenge crits for each sentry kill and 1 for each sentry assist when your sentry is destroyed."
		 * 
		 * Weapon supports revenge crits if this, `sapper_kills_collect_crits`, or `extinguish_revenge` is set.
		 */
		open val canGainRevengeCrits: ItemAttributeNamed<Boolean> = ItemAttributeNamed("mod sentry killed revenge")
	}
	
	open class StatusEffectsAttributes : IBlockScoped {
		/**
		 * In-Game: "Ignited enemies explode"
		 * 
		 * Applies when *any weapon* with this attribute is in the second loadout slot of the player who covered someone in gas.  This attribute does not specifically check for the Gas Passer.  For example, if a Soldier has a rocket launcher that applies `TF_COND_GAS` and their shotgun in their secondary has this attribute, they'll still explode on ignite.
		 * 
		 * Only the afterburn specifically checks for the Gas Passer.
		 */
		open val explodeOnIgnite: ItemAttributeNamed<Boolean> = ItemAttributeNamed("explode_on_ignite")
	}
	
	open class TauntingAttributes : IBlockScoped {
		/**
		 * In-Game: "Alt-Fire: Applies a healing effect to all nearby teammates"
		 * 
		 * Makes default weapon taunt perform the Amputator radial healing effect.
		 */
		open val enablesAoeHeal: ItemAttributeNamed<Boolean> = ItemAttributeNamed("enables aoe heal")
	
		/**
		 * If true, prevents holiday taunts from being used.
		 */
		open val specialTaunt: ItemAttributeNamed<Boolean> = ItemAttributeNamed("special taunt")
	}
	
	open class SwapWeaponsAttributes : IBlockScoped {
		/**
		 * In-Game: "When weapon is active:"
		 * 
		 * If true, only applies attributes when weapon is active, and unapplies them when switching off.
		 * 
		 * I think this also means you can't have "only active when holding weapon" and "always active" attributes on the same weapon, since the order you specify attributes in doesn't matter.
		 */
		open val provideOnActive: ItemAttributeNamed<Boolean> = ItemAttributeNamed("provide on active")
	
		/**
		 * In-Game: "While not being healed by a medic, your weapon switch time is N% longer"
		 * 
		 * Multiplier applied if NOT being healed by a medic.
		 * 
		 * Checked on player.
		 */
		open val medicHealedDeployTimePenalty: ItemAttributeNamed<Number> = ItemAttributeNamed("mod medic healed deploy time penalty")
	
		/**
		 * Should force switch to this item when your current weapon is unavailable?.
		 */
		open val forceWeaponSwitch: ItemAttributeNamed<Boolean> = ItemAttributeNamed("force weapon switch")
	
		/**
		 * In-Game: "Honorbound: Once drawn sheathing deals 50 damage to yourself unless it kills."
		 * 
		 * Takes 50 health when holstering before it gets a kill.
		 */
		open val honorbound: ItemAttributeNamed<Boolean> = ItemAttributeNamed("honorbound")
	
		/**
		 * If greater than 0 (like with the Thermal Thruster), takes that amount of time to holster BEFORE actually swapping weapons.
		 */
		open val holsterAnimTime: ItemAttributeNamed<Number> = ItemAttributeNamed("holster_anim_time")
	
		open val deploy: DeployAttributes = DeployAttributes()
	
		open class DeployAttributes : IBlockScoped {
			/**
			 * Bonus:
			 * 
			 * 	- In-Game: "N% faster weapon switch"
			 * 
			 * Penalty:
			 * 
			 * 	- In-Game: "N% longer weapon switch"
			 */
			open val deployTime: BonusPenalty<Number> = BonusPenalty(
				ItemAttributeNamed("deploy time decreased"),
				ItemAttributeNamed("deploy time increased"),
			)
	
			/**
			 * Bonus:
			 * 
			 * 	- In-Game: "This weapon deploys N% faster"
			 * 
			 * Penalty:
			 * 
			 * 	- In-Game: "This weapon deploys N% slower"
			 */
			open val singleWepDeployTime: BonusPenalty<Number> = BonusPenalty(
				ItemAttributeNamed("single wep deploy time decreased"),
				ItemAttributeNamed("single wep deploy time increased"),
			)
	
			/**
			 * Bonus:
			 * 
			 * 	- In-Game: "This weapon holsters N% faster"
			 * 
			 * Penalty:
			 * 
			 * 	- In-Game: "This weapon holsters N% slower"
			 */
			open val singleWepHolsterTime: BonusPenalty<Number> = BonusPenalty(
				ItemAttributeNamed("switch from wep deploy time decreased"),
				ItemAttributeNamed("single wep holster time increased"),
			)
		}
	}
	
	open class WhenHitAttributes : IBlockScoped {
		/**
		 * Knocks back attacker when wielder receives damage.
		 */
		open val damageCausesAirblast: ItemAttributeNamed<Boolean> = ItemAttributeNamed("damage causes airblast")
	}
	
	open class RagdollsAttributes : IBlockScoped {
		/**
		 * In-Game: "Killing an enemy with a critical hit will dismember your victim. Painfully."
		 */
		open val critKillWillGib: ItemAttributeNamed<Boolean> = ItemAttributeNamed("crit kill will gib")
	
		/**
		 * If false, this weapon can only gib if it deals blast damage or over half of its damage falloff.
		 */
		open val critOnHardHit: ItemAttributeNamed<Boolean> = ItemAttributeNamed("crit on hard hit")
	
		/**
		 * In-Game: "Backstab turns victim to ice"
		 * 
		 * Upon killing an enemy with a backstab, replace their ragdoll with an ice statue.
		 */
		open val freezeBackstabVictim: ItemAttributeNamed<Boolean> = ItemAttributeNamed("freeze backstab victim")
	
		/**
		 * In-Game: "Imbued with an ancient power"
		 * 
		 * Saxxy/golden pan effect.
		 */
		open val turnToGold: ItemAttributeNamed<Boolean> = ItemAttributeNamed("turn to gold")
	
		/**
		 * Flamethrower kills.
		 */
		open val ragdollsBecomeAsh: ItemAttributeNamed<Boolean> = ItemAttributeNamed("ragdolls become ash")
	
		/**
		 * Phlogistinator kills.
		 */
		open val ragdollsPlasmaEffect: ItemAttributeNamed<Boolean> = ItemAttributeNamed("ragdolls plasma effect")
	}
	
	open class DisguiseAttributes : BaseCombatWeaponAttributes.DisguiseAttributes() 
}