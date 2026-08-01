package btpos.source.vdfdsl.tf2.itemattributes

import btpos.source.vdfdsl.modeling.*
import btpos.source.vdfdsl.serialization.codecs.*
import btpos.source.vdfdsl.tf2.itemattributes.impl.*
import btpos.source.vdfdsl.tf2.tftypes.*
import java.util.*
import kotlin.time.Duration

interface WeaponBaseAttributes : BaseCombatWeaponAttributes {
	companion object : IBlockScoped {
		val afterburn: AfterburnAttributes = AfterburnAttributes()
	
		val buildings: BuildingsAttributes = BuildingsAttributes()
	
		val demoCharge: DemoChargeAttributes = DemoChargeAttributes()
	
		val firing: FiringAttributes = FiringAttributes()
	
		val healthAndHealing: HealthAndHealingAttributes = HealthAndHealingAttributes()
	
		val movement: MovementAttributes = MovementAttributes()
	
		val heads: HeadsAttributes = HeadsAttributes()
	
		val onHit: OnHitAttributes = OnHitAttributes()
	
		val onKill: OnKillAttributes = OnKillAttributes()
	
		val projectiles: ProjectilesAttributes = ProjectilesAttributes()
	
		val reloading: ReloadingAttributes = ReloadingAttributes()
	
		val revengeCrits: RevengeCritsAttributes = RevengeCritsAttributes()
	
		val statusEffects: StatusEffectsAttributes = StatusEffectsAttributes()
	
		val taunting: TauntingAttributes = TauntingAttributes()
	
		val swapWeapons: SwapWeaponsAttributes = SwapWeaponsAttributes()
	
		val whenHit: WhenHitAttributes = WhenHitAttributes()
	
		val ragdolls: RagdollsAttributes = RagdollsAttributes()
	
		private val ammo: AmmoAttributes = AmmoAttributes()
	
		private val meta: MetaAttributes = MetaAttributes()
	
		private val disguise: DisguiseAttributes = DisguiseAttributes()
	
		private val crits: CritsAttributes = CritsAttributes()
	
		private val damage: DamageAttributes = DamageAttributes()
	
		private val meter: MeterAttributes = MeterAttributes()
	
		private val knockbackReceived: KnockbackReceivedAttributes = KnockbackReceivedAttributes()
	
		private val resistance: ResistanceAttributes = ResistanceAttributes()
	
		/**
		 * In-Game: "On Hit: target is engulfed in flames"
		 * 
		 * Ignites player on hit.
		 */
		val setDamagetypeIgnite: ItemAttributeNamed<Boolean> = ItemAttributeNamed("Set DamageType Ignite")
	
		/**
		 * Bonus:
		 * 
		 * 	- In-Game: "+N% afterburn damage bonus"
		 * 
		 * Penalty:
		 * 
		 * 	- In-Game: "N% afterburn damage penalty"
		 */
		val weaponBurnDmgReduced: BonusPenalty<Number> = BonusPenalty(
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
		val weaponBurnTimeReduced: BonusPenalty<Number> = BonusPenalty(
			ItemAttributeNamed("weapon burn time increased"),
			ItemAttributeNamed("weapon burn time reduced"),
		)
	
		/**
		 * In-Game: "Halloween Fire"
		 * 
		 * Makes afterburn green.
		 */
		val spellHalloweenGreenFlames: ItemAttributeNamed<Boolean> = ItemAttributeNamed("SPELL: Halloween green flames")
	
		/**
		 * In-Game: "No ammo from dispensers when active"
		 */
		val noPrimaryAmmoFromDispensersWhileActive: ItemAttributeNamed<Boolean> = ItemAttributeNamed("no primary ammo from dispensers while active")
	
		/**
		 * In-Game: "No metal from dispensers when active."
		 */
		val noMetalFromDispensersWhileActive: ItemAttributeNamed<Boolean> = ItemAttributeNamed("no metal from dispensers while active")
	
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
		val clipSize: BonusPenaltyHidden<Number, ItemAttributeNamed<Number>> = BonusPenaltyHidden(
			ItemAttributeNamed<Number>("clip size bonus"),
			ItemAttributeNamed<Number>("clip size penalty"),
			ItemAttributeNamed<Number>("clip size penalty HIDDEN"),
		)
	
		/**
		 * In-Game: "+N% clip size"
		 */
		val clipSizeBonusUpgrade: ItemAttributeNamed<Int> = ItemAttributeNamed("clip size bonus upgrade")
	
		/**
		 * In-Game: "+N clip size"
		 * 
		 * MVM attribute that specifically handles rocket and grenade launchers.
		 * 
		 * Note that all three of these are different classes, which means they stack.
		 */
		val clipSizeUpgradeAtomic: ItemAttributeNamed<Int> = ItemAttributeNamed("clip size upgrade atomic")
	
		/**
		 * In-Game: "Clip size increased on kill"
		 */
		val clipsizeIncreaseOnKill: ItemAttributeNamed<Int> = ItemAttributeNamed("clipsize increase on kill")
	
		/**
		 * In-Game: "Alt-Fire: Use N metal to pick up your targeted building from long range"
		 * 
		 * Metal cost to pick up a building at range.
		 * 
		 * Restricted to the default rescue ranger range, but can be used by any weapon.
		 */
		val buildingRescueMetalCost: ItemAttributeNamed<Int> = ItemAttributeNamed("engineer building teleporting pickup")
	
		val multRandomCritChance: VisHidden<Number> = VisHidden(ItemAttributeNamed<Number>("crit mod disabled"), ItemAttributeNamed<Number>("crit mod disabled hidden"))
	
		/**
		 * In-Game: "Cannot be crit boosted"
		 * 
		 * Can't be crit-boosted.
		 */
		val noCritBoost: ItemAttributeNamed<Boolean> = ItemAttributeNamed("no crit boost")
	
		/**
		 * The weapon's "crit players with X condition" stat.
		 */
		val critVsConditions: ItemAttributeNamed<EnumSet<TFCritCondition>> = ItemAttributeNamed("crit vs burning players", EnumSetOrCodec())
	
		/**
		 * In-Game: "100% critical hit vs burning players"
		 * 
		 * The weapon's "crit players with X condition" stat.
		 */
		val critVsBurningPlayers: ItemAttributeNamed<EnumSet<TFCritCondition>> = ItemAttributeNamed("crit vs burning players", EnumSetOrCodec())
	
		/**
		 * In-Game: "100% critical hit vs disguised players"
		 * 
		 * The weapon's "crit players with X condition" stat.
		 */
		val critVsDisguisedPlayers: ItemAttributeNamed<EnumSet<TFCritCondition>> = ItemAttributeNamed("crit vs disguised players", EnumSetOrCodec())
	
		/**
		 * In-Game: "100% critical hit vs wet players"
		 */
		val critVsWetPlayers: ItemAttributeNamed<Boolean> = ItemAttributeNamed("crit vs wet players")
	
		/**
		 * In-Game: "100% critical hit vs non-burning players"
		 * 
		 * Crit against players that DON'T have these conditions.
		 */
		val critVsNonBurningPlayers: ItemAttributeNamed<EnumSet<TFCritCondition>> = ItemAttributeNamed("crit vs non burning players", EnumSetOrCodec())
	
		/**
		 * In-Game: "100% critical hits burning players from behind. Mini-crits burning players from the front."
		 * 
		 * On hitting a burning player, crit them from behind or minicrit them otherwise.
		 */
		val axtinguisherProperties: ItemAttributeNamed<Boolean> = ItemAttributeNamed("axtinguisher properties")
	
		/**
		 * In-Game: "Deals crits while the wielder is rocket jumping"
		 * 
		 * Critical hit enemies if the player was launched into the air by an explosion.
		 * 
		 * Only works when not in Mannpower mode.
		 */
		val critWhileAirborne: ItemAttributeNamed<Boolean> = ItemAttributeNamed("mod crit while airborne")
	
		/**
		 * In-Game: "Mini-crits burning targets and extinguishes them. Damage increases based on remaining duration of afterburn. Killing blows on burning players grant a speed boost."
		 * 
		 * Only activates if the weapon deals `DMG_MELEE`.
		 */
		val attackMinicritsAndConsumesBurning: ItemAttributeNamed<Boolean> = ItemAttributeNamed("attack_minicrits_and_consumes_burning")
	
		/**
		 * In-Game: "100% minicrits vs burning players"
		 * 
		 * Minicrits if the damage dealt is NOT `DMG_BURN`.
		 */
		val minicritVsBurningPlayer: ItemAttributeNamed<Boolean> = ItemAttributeNamed("minicrit vs burning player")
	
		/**
		 * In-Game: "Mini-crits targets launched airborne by explosions, grapple hooks or rocket packs"
		 * 
		 * Mini-crits targets launched airborne by an explosion.
		 * 
		 * Only procs when not in Mannpower mode.
		 */
		val minicritAirborne: ItemAttributeNamed<Boolean> = ItemAttributeNamed("mod mini-crit airborne")
	
		/**
		 * In-Game: "Mini-crits targets when fired at their back from close range"
		 * 
		 * If true, minicrits targets facing away from the attacker that are within 22.6 HU of the attacker (sqrt 512).
		 */
		val closerangeBackattackMinicrits: ItemAttributeNamed<Boolean> = ItemAttributeNamed("closerange backattack minicrits")
	
		/**
		 * In-Game: "Crits whenever it would normally mini-crit"
		 */
		val minicritsBecomeCrits: ItemAttributeNamed<Boolean> = ItemAttributeNamed("minicrits become crits")
	
		/**
		 * In-Game: "No critical hits vs non-burning players"
		 * 
		 * Note: Even prevents criticals when crit-boosted.
		 */
		val noCritVsNonburning: ItemAttributeNamed<Boolean> = ItemAttributeNamed("no crit vs nonburning")
	
		/**
		 * In-Game: "Critical damage is affected by range"
		 * 
		 * If true, crits have damage falloff (Ambassador).
		 */
		val critDmgFalloff: ItemAttributeNamed<Boolean> = ItemAttributeNamed("crit_dmg_falloff")
	
		/**
		 * In-Game: "Minicrits whenever it would normally crit"
		 */
		val critsBecomeMinicrits: ItemAttributeNamed<Boolean> = ItemAttributeNamed("crits_become_minicrits")
	
		val dmgVsBuildings: VisHidden<Number> = VisHidden(ItemAttributeNamed<Number>("dmg bonus vs buildings"), ItemAttributeNamed<Number>("dmg penalty vs buildings"))
	
		/**
		 * In-Game: "N% damage vs players"
		 */
		val dmgPenaltyVsPlayers: ItemAttributeNamed<Number> = ItemAttributeNamed("dmg penalty vs players")
	
		/**
		 * In-Game: "N% damage vs non-burning players"
		 */
		val dmgPenaltyVsNonburning: ItemAttributeNamed<Number> = ItemAttributeNamed("dmg penalty vs nonburning")
	
		/**
		 * In-Game: "N% damage bonus vs burning players"
		 */
		val damageBonusVsBurning: ItemAttributeNamed<Number> = ItemAttributeNamed("damage bonus vs burning")
	
		/**
		 * In-Game: "Attacks pierce damage resistance effects and bonuses"
		 * 
		 * Damage pierces through all resistances, such as Vaccinator ubercharges and the Battalion's Backup.
		 */
		val dmgPiercesResistsAbsorbs: ItemAttributeNamed<Boolean> = ItemAttributeNamed("dmg pierces resists absorbs")
	
		/**
		 * In-Game: "N% increased damage to your sentry's target"
		 */
		val damageBonusBulletVsSentryTarget: ItemAttributeNamed<Number> = ItemAttributeNamed("damage bonus bullet vs sentry target")
	
		/**
		 * In-Game: "N% damage on body shot"
		 * 
		 * Multiplier applied to bodyshot damage.
		 */
		val damagePenaltyOnBodyshot: ItemAttributeNamed<Number> = ItemAttributeNamed("damage penalty on bodyshot")
	
		/**
		 * In-Game: "Melee hits refill  N% of your charge meter."
		 * 
		 * Restores demoman shield charge on hit.
		 */
		val chargeMeterOnHit: ItemAttributeNamed<Number> = ItemAttributeNamed("charge meter on hit")
	
		/**
		 * In-Game: "Ammo boxes collected also give Charge"
		 * 
		 * If true, and player has a demoman charge meter, add charge based on ammo pack size.
		 */
		val ammoPacksGiveDemoknightCharge: ItemAttributeNamed<Boolean> = ItemAttributeNamed("ammo gives charge")
	
		/**
		 * Bonus:
		 * 
		 * 	- In-Game: "Hold Fire to load up to three rockets Release Fire to unleash the barrage"
		 * 
		 * Penalty:
		 */
		val autoFiresFullClip: BonusPenalty<Boolean> = BonusPenalty(
			ItemAttributeNamed("auto fires full clip"),
			ItemAttributeNamed("auto fires full clip penalty"),
		)
	
		val autoFiresFullClipAllAtOnce: ItemAttributeNamed<Boolean> = ItemAttributeNamed("auto fires full clip all at once")
	
		val autoFiresWhenFull: ItemAttributeNamed<Boolean> = ItemAttributeNamed("auto fires when full")
	
		/**
		 * In-Game: "Overloading the chamber will cause a misfire"
		 * 
		 * Deals damage to the player when overloaded.
		 */
		val canOverload: ItemAttributeNamed<Boolean> = ItemAttributeNamed("can overload")
	
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
		val fireRate: BonusPenaltyNeutralHidden<Number, BonusPenalty<Number>> = BonusPenaltyNeutralHidden(
			ItemAttributeNamed<Number>("fire rate bonus"),
			ItemAttributeNamed<Number>("fire rate penalty"),
			ItemAttributeNamed<Number>("melee attack rate bonus"),
			BonusPenalty(
			ItemAttributeNamed<Number>("fire rate bonus HIDDEN"),
			ItemAttributeNamed<Number>("fire rate penalty HIDDEN"),
		),
		)
	
		/**
		 * In-Game: "Blocks healing while in use"
		 * 
		 * Prevents mediguns/dispensers from targeting you and crossbow bolts from healing you while the weapon is active.
		 */
		val weaponBlocksHealing: ItemAttributeNamed<Boolean> = ItemAttributeNamed("mod weapon blocks healing")
	
		/**
		 * Bonus:
		 * 
		 * 	- In-Game: "+N health regenerated per second on wearer"
		 * 
		 * Penalty:
		 * 
		 * 	- In-Game: "N health drained per second on wearer"
		 */
		val passiveHealthRegen: BonusPenalty<Int> = BonusPenalty(
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
		val uberchargeRateBonusForHealer: ItemAttributeNamed<Number> = ItemAttributeNamed("ubercharge rate bonus for healer")
	
		/**
		 * In-Game: "On Hit: Gain up to +N health per attack"
		 * 
		 * Maximum amount of health that can be gained from an AoE damage source.
		 * 
		 * Health received is multiplied by `damage dealt / base damage of the weapon`, to a max of 100% of the defined value.
		 */
		val healOnHit_radial: ItemAttributeNamed<Int> = ItemAttributeNamed("health on radius damage")
	
		/**
		 * In-Game: "N% health from healers on wearer"
		 * 
		 * Attribute class is a flat multiplier applied to health from healers while weapon is active.
		 */
		val multHealthFromHealersWhileActive: ItemAttributeNamed<Number> = ItemAttributeNamed("mult_health_fromhealers_penalty_active")
	
		/**
		 * In-Game: "N% Overheal build rate."
		 * 
		 * Checked on the player that is healing an entity.
		 */
		val multOverhealFillRate: ItemAttributeNamed<Number> = ItemAttributeNamed("overheal fill rate reduced")
	
		/**
		 * In-Game: "N% less healing from Medic sources"
		 * 
		 * Applies to all non-dispenser forms of healing that apply the `TF_COND_HEAL_BUFF` status.
		 */
		val reducedHealingFromMedics: ItemAttributeNamed<Number> = ItemAttributeNamed("reduced_healing_from_medics")
	
		/**
		 * Bonus:
		 * 
		 * 	- In-Game: "+N% bonus healing from all sources"
		 * 
		 * Penalty:
		 * 
		 * 	- In-Game: "N% less healing from all sources"
		 */
		val multHealingReceived: BonusPenalty<Number> = BonusPenalty(
			ItemAttributeNamed("healing received bonus"),
			ItemAttributeNamed("healing received penalty"),
		)
	
		/**
		 * In-Game: "Maximum health is drained while item is active"
		 * 
		 * Maximum health decrease per tick while weapon is active. (Gloves of Running Urgently/Eviction Notice).
		 */
		val maxHealthDrainedWhileActive: ItemAttributeNamed<Number> = ItemAttributeNamed("mod_maxhealth_drain_rate")
	
		/**
		 * Bonus:
		 * 
		 * 	- In-Game: "+N% self damage force"
		 * 
		 * Penalty:
		 * 
		 * 	- In-Game: "N% self damage force"
		 */
		val selfDmgPushForce: BonusPenalty<Number> = BonusPenalty(
			ItemAttributeNamed("self dmg push force increased"),
			ItemAttributeNamed("self dmg push force decreased"),
		)
	
		/**
		 * In-Game: "N% reduction in push force taken from damage"
		 * 
		 * Attribute class is a flat multiplier applied to push force received from damage.
		 */
		val damageForceReduction: ItemAttributeNamed<Number> = ItemAttributeNamed("damage force reduction")
	
		/**
		 * In-Game: "N% increase in push force taken from damage"
		 * 
		 * Attribute class is a flat multiplier applied to push force received from damage.
		 */
		val damageForceIncrease: ItemAttributeNamed<Number> = ItemAttributeNamed("damage force increase")
	
		/**
		 * In-Game: "N% increase in push force taken from damage"
		 * 
		 * Attribute class is a flat multiplier applied to push force received from damage.
		 */
		val damageForceIncreaseHidden: ItemAttributeNamed<Number> = ItemAttributeNamed("damage force increase hidden")
	
		/**
		 * In-Game: "Increase in push force taken from damage and airblast"
		 * 
		 * Attribute class is a flat multiplier applied to push force received from damage.
		 */
		val damageForceIncreaseText: ItemAttributeNamed<Number> = ItemAttributeNamed("damage force increase text")
	
		/**
		 * What "Strange Part" kills with this weapon should contribute to.
		 */
		val killEaterKillType: ItemAttributeNamed<Int> = ItemAttributeNamed("kill eater kill type")
	
		val isGigerCounter: ItemAttributeNamed<Boolean> = ItemAttributeNamed("is giger counter")
	
		/**
		 * Sets killfeed background gold.
		 */
		val isAustraliumItem: ItemAttributeNamed<Boolean> = ItemAttributeNamed("is australium item")
	
		/**
		 * In-Game: "Imbued with an ancient power"
		 * 
		 * Sets killfeed background gold.
		 */
		val turnToGold: ItemAttributeNamed<Boolean> = ItemAttributeNamed("turn to gold")
	
		/**
		 * In-Game: "Silent Killer: No attack noise from backstabs"
		 * 
		 * Kills will not show up in the killfeed.
		 */
		val silentKiller: ItemAttributeNamed<Boolean> = ItemAttributeNamed("silent killer")
	
		val weaponAllowInspect: ItemAttributeNamed<Boolean> = ItemAttributeNamed("weapon_allow_inspect")
	
		val weaponStattrakModuleScale: ItemAttributeNamed<Number> = ItemAttributeNamed("weapon_stattrak_module_scale")
	
		val minViewmodelOffset: ItemAttributeNamed<String> = ItemAttributeNamed("min_viewmodel_offset")
	
		/**
		 * In-Game: "+N% increase in recharge rate"
		 * 
		 * For things like throwable recharge timers, jetpack charging, etc: how much it recharges per second.
		 */
		val effectBarRechargeRateIncreased: ItemAttributeNamed<Number> = ItemAttributeNamed("effect bar recharge rate increased")
	
		/**
		 * In-Game: "+N% greater jump height when active"
		 * 
		 * Only takes effect while this weapon is active.
		 */
		val increasedJumpHeightFromWeapon: ItemAttributeNamed<Number> = ItemAttributeNamed("increased jump height from weapon")
	
		/**
		 * In-Game: "Grants Triple Jump while deployed. Melee attacks mini-crit while airborne."
		 * 
		 * If greater than 0, attacks minicrit while airborne.
		 * 
		 * Only procs on Scout.
		 */
		val airDashCount: ItemAttributeNamed<Int> = ItemAttributeNamed("air dash count")
	
		/**
		 * Multiplier applied to movement speed scaled by ubercharge percentage.
		 * 
		 * Only works if the player using this item is a Medic with a Medigun.
		 */
		val moveSpeedBonusResourceLevel: ItemAttributeNamed<Number> = ItemAttributeNamed("move speed bonus resource level")
	
		/**
		 * In-Game: "+N% faster move speed on wearer"
		 * 
		 * Multiplier applied to player movement speed only while this is the active weapon.
		 */
		val multPlayerMovespeedActive: ItemAttributeNamed<Number> = ItemAttributeNamed("mult_player_movespeed_active")
	
		/**
		 * In-Game: "+N% cloak on hit"
		 * 
		 * Adds this amount of cloak on hit.
		 * 
		 * Only procs on Spy.
		 */
		val addCloakOnHit: ItemAttributeNamed<Int> = ItemAttributeNamed("add cloak on hit")
	
		/**
		 * In-Game: "On Hit: damage dealt is returned as ammo"
		 * 
		 * Gain ammo equivalent to damage dealt on hit.
		 */
		val addOnhitAddammo: ItemAttributeNamed<Boolean> = ItemAttributeNamed("add onhit addammo")
	
		/**
		 * In-Game: "On Hit Spy: Reveal cloaked Spy"
		 */
		val revealCloakedVictimOnHit: ItemAttributeNamed<Boolean> = ItemAttributeNamed("reveal cloaked victim on hit")
	
		/**
		 * In-Game: "On Hit Spy: Reveal disguised Spy"
		 */
		val revealDisguisedVictimOnHit: ItemAttributeNamed<Boolean> = ItemAttributeNamed("reveal disguised victim on hit")
	
		/**
		 * In-Game: "On Hit: Gain a speed boost"
		 * 
		 * Just does `addcond(SPEED_BOOST, speed_boost_on_hit)`.
		 */
		val speedBoostOnHit: ItemAttributeNamed<Int> = ItemAttributeNamed("speed_boost_on_hit")
	
		/**
		 * In-Game: "On Hit: N% ÜberCharge added"
		 * 
		 * Only procs if on a Medic.
		 */
		val addUberChargeOnHit: ItemAttributeNamed<Number> = ItemAttributeNamed("add uber charge on hit")
	
		/**
		 * Bonus:
		 * 
		 * 	- In-Game: "N% rage gained on hit"
		 * 
		 * Penalty:
		 * 
		 * 	- In-Game: "N% rage lost on hit"
		 */
		val rageOnHit: BonusPenalty<Int> = BonusPenalty(
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
		val boostOnDamage: ItemAttributeNamed<Boolean> = ItemAttributeNamed("boost on damage")
	
		/**
		 * In-Game: "On Hit: One target at a time is Marked-For-Death, causing all damage taken to be mini-crits"
		 */
		val markForDeath: ItemAttributeNamed<Boolean> = ItemAttributeNamed("mark for death")
	
		/**
		 * In-Game: "On Hit: If enemy's belt is at or above eye level, stun them for N seconds"
		 * 
		 * Stun airborne targets.
		 */
		val stunWaistHighAirborne: ItemAttributeNamed<Boolean> = ItemAttributeNamed("mod stun waist high airborne")
	
		/**
		 * In-Game: "On Hit: Victim loses up to N% Medigun charge"
		 * 
		 * Percentage as an int, e.g. `25` = 25% = 0.25.
		 * 
		 * Drain scaled over distance.
		 */
		val subtractVictimMedigunChargeOnHit: ItemAttributeNamed<Int> = ItemAttributeNamed("subtract victim medigun charge on hit")
	
		/**
		 * In-Game: "On Hit: Victim loses up to N% cloak"
		 * 
		 * Subtracts an actual value.
		 * 
		 * Drain still scaled over distance.
		 */
		val subtractVictimCloakOnHit: ItemAttributeNamed<Int> = ItemAttributeNamed("subtract victim cloak on hit")
	
		/**
		 * In-Game: "On Hit: N% chance to slow target"
		 * 
		 * Gain speedboost on hit.
		 */
		val slowEnemyOnHit: ItemAttributeNamed<Number> = ItemAttributeNamed("slow enemy on hit")
	
		/**
		 * In-Game: "On Hit: Slow target movement by 40% for Ns"
		 * 
		 * Gain speedboost for N seconds.
		 */
		val slowEnemyOnHitMajor: ItemAttributeNamed<Number> = ItemAttributeNamed("slow enemy on hit major")
	
		/**
		 * In-Game: "Syringes deliver a highly concentrated dose of Mad Milk. Duration increases per hit to a max of 4 seconds."
		 * 
		 * Applies Mad Milk with a duration of 4 seconds, and each subsequent hit on the same target adds 0.5 seconds to the duration.
		 */
		val madMilkSyringes: ItemAttributeNamed<Boolean> = ItemAttributeNamed("mad milk syringes")
	
		/**
		 * In-Game: "Stuns enemies who are also wielding this weapon"
		 */
		val stunEnemiesWieldingSameWeapon: ItemAttributeNamed<Boolean> = ItemAttributeNamed("stun enemies wielding same weapon")
	
		/**
		 * In-Game: "All players connected via Medigun beams are hit"
		 * 
		 * Damage all players connected to the target by medigun beams.
		 */
		val damageAllConnected: ItemAttributeNamed<Boolean> = ItemAttributeNamed("damage all connected")
	
		/**
		 * Apply this amount of z velocity to players hit with this weapon.
		 */
		val applyZVelocityOnDamage: ItemAttributeNamed<Number> = ItemAttributeNamed("apply z velocity on damage")
	
		/**
		 * Apply this amount of velocity in the direction you're facing to players hit with this weapon.
		 */
		val applyLookVelocityOnDamage: ItemAttributeNamed<Number> = ItemAttributeNamed("apply look velocity on damage")
	
		/**
		 * Push force applied to target when hitting an enemy.
		 * 
		 * Scales by range, to a minimum of 50% of the given value.
		 */
		val damageBlastPush: ItemAttributeNamed<Number> = ItemAttributeNamed("damage blast push")
	
		/**
		 * In-Game: "On Hit: Bleed for N seconds"
		 * 
		 * Apply bleed on hit.
		 * 
		 * Value is a time in seconds.
		 */
		val bleedingDuration: ItemAttributeNamed<Number> = ItemAttributeNamed("bleeding duration")
	
		/**
		 * In-Game: "On Hit: Gain up to +N health"
		 * 
		 * Add this amount of health on hit.
		 */
		val healOnHitForRapidfire: ItemAttributeNamed<Int> = ItemAttributeNamed("heal on hit for rapidfire")
	
		/**
		 * In-Game: "On Hit: N health"
		 * 
		 * Add this amount of health on hit.
		 */
		val selfdmgOnHitForRapidfire: ItemAttributeNamed<Int> = ItemAttributeNamed("selfdmg on hit for rapidfire")
	
		/**
		 * In-Game: "On Hit: Gain up to +N health"
		 * 
		 * Add this amount of health on hit.
		 */
		val healOnHitForSlowfire: ItemAttributeNamed<Int> = ItemAttributeNamed("heal on hit for slowfire")
	
		/**
		 * In-Game: "On Hit: N health"
		 * 
		 * Add this amount of health on hit.
		 */
		val selfdmgOnHitForSlowfire: ItemAttributeNamed<Int> = ItemAttributeNamed("selfdmg on hit for slowfire")
	
		/**
		 * In-Game: "Generate Rage by dealing damage.  When fully charged, press the Special-Attack key to activate knockback"
		 * 
		 * Knockback rage on enemy if you're a heavy and your rage is draining.
		 */
		val generateRageOnDamage: ItemAttributeNamed<Boolean> = ItemAttributeNamed("generate rage on damage")
	
		/**
		 * In-Game: "Generate building rescue energy on damage"
		 * 
		 * Knockback rage on enemy if you're a heavy and your rage is draining.
		 */
		val engineerRageOnDmg: ItemAttributeNamed<Boolean> = ItemAttributeNamed("engineer rage on dmg")
	
		/**
		 * In-Game: "On Kill: N seconds of 100% critical chance"
		 * 
		 * Seconds of crit-boost gained on kill.
		 * 
		 * Note: actual time is `this + 1`.
		 */
		val critboostOnKill: ItemAttributeNamed<Int> = ItemAttributeNamed("critboost on kill")
	
		/**
		 * In-Game: "On Kill: Gain Mini-crits for N seconds."
		 * 
		 * Seconds of minicrit-boost gained on kill.
		 * 
		 * Note: actual time is `this + 1`.
		 */
		val minicritboostOnKill: ItemAttributeNamed<Int> = ItemAttributeNamed("minicritboost on kill")
	
		/**
		 * In-Game: "On Kill: Gain N% of base health on kill"
		 * 
		 * Percentage of health to be restored upon killing an enemy. (e.g. `25` is 25%).
		 * 
		 * Post-heal player health value is capped at 1.5x the player's normal max health.
		 * 
		 * Negative values are ignored.
		 */
		val restoreHealthOnKill: ItemAttributeNamed<Int> = ItemAttributeNamed("restore health on kill")
	
		/**
		 * In-Game: "+N health restored on kill"
		 * 
		 * Restores this flat amount of health on killing an enemy. Post-heal player health value is capped at the player's maximum overheal.
		 * 
		 * Negative values are NOT ignored.
		 */
		val healOnKill: ItemAttributeNamed<Int> = ItemAttributeNamed("heal on kill")
	
		/**
		 * In-Game: "Gain a speed boost on kill"
		 */
		val speedBoostOnKill: ItemAttributeNamed<Int> = ItemAttributeNamed("speed_boost_on_kill")
	
		/**
		 * In-Game: "Exorcism"
		 * 
		 * Exorcism spell effect.
		 */
		val spellHalloweenDeathGhosts: ItemAttributeNamed<Boolean> = ItemAttributeNamed("SPELL: Halloween death ghosts")
	
		/**
		 * Note: "Projectile" includes bullets.
		 */
		val centerfireProjectile: ItemAttributeNamed<Boolean> = ItemAttributeNamed("centerfire projectile")
	
		/**
		 * In-Game: "+N degrees random projectile deviation"
		 * 
		 * Does not include bullets.
		 */
		val projectileSpreadAnglePenalty: ItemAttributeNamed<Number> = ItemAttributeNamed("projectile spread angle penalty")
	
		/**
		 * In-Game: "Projectiles penetrate enemy players"
		 * 
		 * How many players your "projectile" (*including bullets*) should penetrate.
		 */
		val projectilePenetration: ItemAttributeNamed<Int> = ItemAttributeNamed("projectile penetration")
	
		/**
		 * In-Game: "Bullets penetrate +N enemies"
		 * 
		 * How many players your "projectile" (*including bullets*) should penetrate.
		 */
		val projectilePenetrationHeavy: ItemAttributeNamed<Int> = ItemAttributeNamed("projectile penetration heavy")
	
		/**
		 * In-Game: "+N% bullets per shot"
		 */
		val bulletsPerShotBonus: ItemAttributeNamed<Number> = ItemAttributeNamed("bullets per shot bonus")
	
		/**
		 * In-Game: "Fires tracer rounds"
		 * 
		 * Note: Sniper rage forcibly draws a tracer regardless of this setting.
		 * 
		 * Used when firing bullets.
		 */
		val sniperFiresTracer: ItemAttributeNamed<Boolean> = ItemAttributeNamed("sniper fires tracer")
	
		/**
		 * In-Game: "Fires tracer rounds"
		 * 
		 * Same as `sniper_fires_tracer`.
		 */
		val sniperFiresTracerHidden: ItemAttributeNamed<Boolean> = ItemAttributeNamed("sniper fires tracer HIDDEN")
	
		/**
		 * In-Game: "On Full Charge: Projectiles penetrate players"
		 */
		val penetratesWhenFullyCharged: ItemAttributeNamed<Boolean> = ItemAttributeNamed("sniper penetrate players when charged")
	
		/**
		 * In-Game: "Increased headshot explosion radius and damage to nearby enemies"
		 * 
		 * Only applies if in a gamemode with upgrades, but applies to all headshots.
		 * 
		 * Also applies to any hitscan weapon with a `jarate_time` attribute that hit the head.
		 */
		val explosiveHeadshotLevel: ItemAttributeNamed<Int> = ItemAttributeNamed("explosive sniper shot")
	
		/**
		 * Bonus:
		 * 
		 * 	- In-Game: "N% faster reload time"
		 * 
		 * Penalty:
		 * 
		 * 	- In-Game: "N% slower reload time"
		 */
		val reloadTime: BonusPenalty<Number> = BonusPenalty(
			ItemAttributeNamed("Reload time decreased"),
			ItemAttributeNamed("Reload time increased"),
		)
	
		/**
		 * In-Game: "N% slower reload time"
		 */
		val reloadTimeIncreasedHidden: ItemAttributeNamed<Number> = ItemAttributeNamed("reload time increased hidden")
	
		/**
		 * In-Game: "+N% faster reload time"
		 * 
		 * This is what's used for weapons that draw directly from reserve ammo, like the flare gun and sniper rifle.
		 */
		val fasterReloadRate: ItemAttributeNamed<Number> = ItemAttributeNamed("faster reload rate")
	
		/**
		 * Halloween reload time multiplier.
		 * 
		 * Checked on player.
		 */
		val halloweenReloadTimeDecreased: ItemAttributeNamed<Number> = ItemAttributeNamed("halloween reload time decreased")
	
		/**
		 * In-Game: "N% faster reload time while being healed"
		 */
		val reloadTimeDecreasedWhileHealed: ItemAttributeNamed<Number> = ItemAttributeNamed("reload time decreased while healed")
	
		/**
		 * In-Game: "On Hit by Fire: Fireproof for 1 second and Afterburn immunity for N seconds"
		 * 
		 * Addcond parameter.
		 */
		val becomeFireproofOnHitByFire: ItemAttributeNamed<Number> = ItemAttributeNamed("become fireproof on hit by fire")
	
		/**
		 * In-Game: "N% damage vulnerability on wearer"
		 */
		val multDmgtakenActive: ItemAttributeNamed<Number> = ItemAttributeNamed("mult_dmgtaken_active")
	
		/**
		 * In-Game: "+N% damage from melee sources while active"
		 * 
		 * Multiplier applied to incoming melee damage.
		 */
		val dmgFromMeleeIncreased: ItemAttributeNamed<Number> = ItemAttributeNamed("dmg from melee increased")
	
		/**
		 * In-Game: "N% damage from ranged sources while active"
		 * 
		 * Multiplier applied to incoming blast, bullet, buckshot, ignite, and sonic damage.
		 */
		val dmgFromRangedReduced: ItemAttributeNamed<Number> = ItemAttributeNamed("dmg from ranged reduced")
	
		/**
		 * In-Game: "No self inflicted blast damage taken"
		 * 
		 * Also forces the "whistling" sound to play when rocket jumping.
		 */
		val noSelfBlastDmg: ItemAttributeNamed<Boolean> = ItemAttributeNamed("no self blast dmg")
	
		/**
		 * In-Game: "+N% damage to self"
		 * 
		 * Multiplier applied to blast damage taken from an explosion caused by said entity.
		 */
		val blastDmgToSelfIncreased: ItemAttributeNamed<Number> = ItemAttributeNamed("blast dmg to self increased")
	
		/**
		 * In-Game: "+N% fire damage resistance while deployed"
		 * 
		 * Resist this proportion of fire damage only while this weapon is active.
		 */
		val dmgTakenFromFireReducedOnActive: ItemAttributeNamed<Number> = ItemAttributeNamed("dmg taken from fire reduced on active")
	
		/**
		 * In-Game: "+N% damage vulnerability while active"
		 * 
		 * Increases damage taken while minicrit-boosted by Crit-a-Cola, Buffalo Steak, etc.
		 */
		val energyBuffDmgTakenMultiplier: ItemAttributeNamed<Number> = ItemAttributeNamed("energy buff dmg taken multiplier")
	
		/**
		 * In-Game: "The wearer cannot be killed by headshots"
		 * 
		 * When a headshot would kill you, reduce health to 1.
		 */
		val setBonusNoDeathFromHeadshots: ItemAttributeNamed<Boolean> = ItemAttributeNamed("SET BONUS: no death from headshots")
	
		/**
		 * In-Game: "Gives one guaranteed critical hit for each building destroyed with your sapper attached or backstab kill"
		 * 
		 * Weapon supports revenge crits if this, `extinguish_revenge`, or `sentry_killed_revenge` is set.
		 */
		val sapperKillsCollectCrits: ItemAttributeNamed<Boolean> = ItemAttributeNamed("sapper kills collect crits")
	
		/**
		 * In-Game: "Alt-Fire: Extinguish teammates to gain guaranteed critical hits"
		 * 
		 * Weapon supports revenge crits if this, `sapper_kills_collect_crits`, or `sentry_killed_revenge` is set.
		 */
		val extinguishEarnsRevengeCrits: ItemAttributeNamed<Boolean> = ItemAttributeNamed("extinguish earns revenge crits")
	
		/**
		 * In-Game: "Gain 2 revenge crits for each sentry kill and 1 for each sentry assist when your sentry is destroyed."
		 * 
		 * Weapon supports revenge crits if this, `sapper_kills_collect_crits`, or `extinguish_revenge` is set.
		 */
		val canGainRevengeCrits: ItemAttributeNamed<Boolean> = ItemAttributeNamed("mod sentry killed revenge")
	
		/**
		 * In-Game: "Ignited enemies explode"
		 * 
		 * Applies when *any weapon* with this attribute is in the second loadout slot of the player who covered someone in gas.  This attribute does not specifically check for the Gas Passer.  For example, if a Soldier has a rocket launcher that applies `TF_COND_GAS` and their shotgun in their secondary has this attribute, they'll still explode on ignite.
		 * 
		 * Only the afterburn specifically checks for the Gas Passer.
		 */
		val explodeOnIgnite: ItemAttributeNamed<Boolean> = ItemAttributeNamed("explode_on_ignite")
	
		/**
		 * In-Game: "Alt-Fire: Applies a healing effect to all nearby teammates"
		 * 
		 * Makes default weapon taunt perform the Amputator radial healing effect.
		 */
		val enablesAoeHeal: ItemAttributeNamed<Boolean> = ItemAttributeNamed("enables aoe heal")
	
		/**
		 * If true, prevents holiday taunts from being used.
		 */
		val specialTaunt: ItemAttributeNamed<Boolean> = ItemAttributeNamed("special taunt")
	
		/**
		 * In-Game: "When weapon is active:"
		 * 
		 * If true, only applies attributes when weapon is active, and unapplies them when switching off.
		 * 
		 * I think this also means you can't have "only active when holding weapon" and "always active" attributes on the same weapon, since the order you specify attributes in doesn't matter.
		 */
		val provideOnActive: ItemAttributeNamed<Boolean> = ItemAttributeNamed("provide on active")
	
		/**
		 * In-Game: "While not being healed by a medic, your weapon switch time is N% longer"
		 * 
		 * Multiplier applied if NOT being healed by a medic.
		 * 
		 * Checked on player.
		 */
		val medicHealedDeployTimePenalty: ItemAttributeNamed<Number> = ItemAttributeNamed("mod medic healed deploy time penalty")
	
		/**
		 * Should force switch to this item when your current weapon is unavailable?.
		 */
		val forceWeaponSwitch: ItemAttributeNamed<Boolean> = ItemAttributeNamed("force weapon switch")
	
		/**
		 * In-Game: "Honorbound: Once drawn sheathing deals 50 damage to yourself unless it kills."
		 * 
		 * Takes 50 health when holstering before it gets a kill.
		 */
		val honorbound: ItemAttributeNamed<Boolean> = ItemAttributeNamed("honorbound")
	
		/**
		 * If greater than 0 (like with the Thermal Thruster), takes that amount of time to holster BEFORE actually swapping weapons.
		 */
		val holsterAnimTime: ItemAttributeNamed<Number> = ItemAttributeNamed("holster_anim_time")
	
		/**
		 * Bonus:
		 * 
		 * 	- In-Game: "N% faster weapon switch"
		 * 
		 * Penalty:
		 * 
		 * 	- In-Game: "N% longer weapon switch"
		 */
		val deployTime: BonusPenalty<Number> = BonusPenalty(
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
		val singleWepDeployTime: BonusPenalty<Number> = BonusPenalty(
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
		val singleWepHolsterTime: BonusPenalty<Number> = BonusPenalty(
			ItemAttributeNamed("switch from wep deploy time decreased"),
			ItemAttributeNamed("single wep holster time increased"),
		)
	
		/**
		 * Knocks back attacker when wielder receives damage.
		 */
		val damageCausesAirblast: ItemAttributeNamed<Boolean> = ItemAttributeNamed("damage causes airblast")
	
		/**
		 * In-Game: "Killing an enemy with a critical hit will dismember your victim. Painfully."
		 */
		val critKillWillGib: ItemAttributeNamed<Boolean> = ItemAttributeNamed("crit kill will gib")
	
		/**
		 * If false, this weapon can only gib if it deals blast damage or over half of its damage falloff.
		 */
		val critOnHardHit: ItemAttributeNamed<Boolean> = ItemAttributeNamed("crit on hard hit")
	
		/**
		 * In-Game: "Backstab turns victim to ice"
		 * 
		 * Upon killing an enemy with a backstab, replace their ragdoll with an ice statue.
		 */
		val freezeBackstabVictim: ItemAttributeNamed<Boolean> = ItemAttributeNamed("freeze backstab victim")
	
		/**
		 * Flamethrower kills.
		 */
		val ragdollsBecomeAsh: ItemAttributeNamed<Boolean> = ItemAttributeNamed("ragdolls become ash")
	
		/**
		 * Phlogistinator kills.
		 */
		val ragdollsPlasmaEffect: ItemAttributeNamed<Boolean> = ItemAttributeNamed("ragdolls plasma effect")
	}

	/**
	 * In-Game: "This Weapon has a large melee range and deploys and holsters slower"
	 * 
	 * If true, make weapon deploy and holster 75% slower.
	 */
	val isASword: ItemAttributeNamed<Boolean> get() = WeaponBaseAttributes.isASword.get()
	
	/**
	 * In-Game: "Replaces the Sentry with a Mini-Sentry"
	 * 
	 * Determines the hand used in the model.
	 */
	val wrenchBuildsMinisentry: ItemAttributeNamed<Boolean> get() = WeaponBaseAttributes.wrenchBuildsMinisentry.get()
	
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
		companion object : IBlockScoped 
	
		/**
		 * In-Game: "On Hit: target is engulfed in flames"
		 * 
		 * Ignites player on hit.
		 */
		context(attrs: IAttributeContainer)
		open var setDamagetypeIgnite: Boolean? 
			get() = WeaponBaseAttributes.setDamagetypeIgnite.get()
			set(value) { WeaponBaseAttributes.setDamagetypeIgnite.set(value) }
	
		/**
		 * Bonus:
		 * 
		 * 	- In-Game: "+N% afterburn damage bonus"
		 * 
		 * Penalty:
		 * 
		 * 	- In-Game: "N% afterburn damage penalty"
		 */
		context(attrs: IAttributeContainer)
		open var weaponBurnDmgReduced: Number? 
			get() = WeaponBaseAttributes.weaponBurnDmgReduced.get()
			set(value) { WeaponBaseAttributes.weaponBurnDmgReduced.set(value) }
	
		/**
		 * Bonus:
		 * 
		 * 	- In-Game: "+N% afterburn duration"
		 * 
		 * Penalty:
		 * 
		 * 	- In-Game: "N% afterburn duration"
		 */
		context(attrs: IAttributeContainer)
		open var weaponBurnTimeReduced: Number? 
			get() = WeaponBaseAttributes.weaponBurnTimeReduced.get()
			set(value) { WeaponBaseAttributes.weaponBurnTimeReduced.set(value) }
	
		/**
		 * In-Game: "Halloween Fire"
		 * 
		 * Makes afterburn green.
		 */
		context(attrs: IAttributeContainer)
		open var spellHalloweenGreenFlames: Boolean? 
			get() = WeaponBaseAttributes.spellHalloweenGreenFlames.get()
			set(value) { WeaponBaseAttributes.spellHalloweenGreenFlames.set(value) }
	}
	
	open class AmmoAttributes : BaseCombatWeaponAttributes.AmmoAttributes() {
		companion object : IBlockScoped 
	
		/**
		 * In-Game: "No ammo from dispensers when active"
		 */
		context(attrs: IAttributeContainer)
		open var noPrimaryAmmoFromDispensersWhileActive: Boolean? 
			get() = WeaponBaseAttributes.noPrimaryAmmoFromDispensersWhileActive.get()
			set(value) { WeaponBaseAttributes.noPrimaryAmmoFromDispensersWhileActive.set(value) }
	
		/**
		 * In-Game: "No metal from dispensers when active."
		 */
		context(attrs: IAttributeContainer)
		open var noMetalFromDispensersWhileActive: Boolean? 
			get() = WeaponBaseAttributes.noMetalFromDispensersWhileActive.get()
			set(value) { WeaponBaseAttributes.noMetalFromDispensersWhileActive.set(value) }
	
		override val clipSize: ClipSizeAttributes = ClipSizeAttributes()
	
		open class ClipSizeAttributes : BaseCombatWeaponAttributes.AmmoAttributes.ClipSizeAttributes() {
			companion object : IBlockScoped 
	
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
			context(attrs: IAttributeContainer)
			open var clipSize: Number? 
				get() = WeaponBaseAttributes.clipSize.get()
				set(value) { WeaponBaseAttributes.clipSize.set(value) }
	
			/**
			 * In-Game: "+N% clip size"
			 */
			context(attrs: IAttributeContainer)
			open var clipSizeBonusUpgrade: Int? 
				get() = WeaponBaseAttributes.clipSizeBonusUpgrade.get()
				set(value) { WeaponBaseAttributes.clipSizeBonusUpgrade.set(value) }
	
			/**
			 * In-Game: "+N clip size"
			 * 
			 * MVM attribute that specifically handles rocket and grenade launchers.
			 * 
			 * Note that all three of these are different classes, which means they stack.
			 */
			context(attrs: IAttributeContainer)
			open var clipSizeUpgradeAtomic: Int? 
				get() = WeaponBaseAttributes.clipSizeUpgradeAtomic.get()
				set(value) { WeaponBaseAttributes.clipSizeUpgradeAtomic.set(value) }
	
			/**
			 * In-Game: "Clip size increased on kill"
			 */
			context(attrs: IAttributeContainer)
			open var clipsizeIncreaseOnKill: Int? 
				get() = WeaponBaseAttributes.clipsizeIncreaseOnKill.get()
				set(value) { WeaponBaseAttributes.clipsizeIncreaseOnKill.set(value) }
		}
	}
	
	open class BuildingsAttributes : IBlockScoped {
		companion object : IBlockScoped 
	
		/**
		 * In-Game: "Alt-Fire: Use N metal to pick up your targeted building from long range"
		 * 
		 * Metal cost to pick up a building at range.
		 * 
		 * Restricted to the default rescue ranger range, but can be used by any weapon.
		 */
		context(attrs: IAttributeContainer)
		open var buildingRescueMetalCost: Int? 
			get() = WeaponBaseAttributes.buildingRescueMetalCost.get()
			set(value) { WeaponBaseAttributes.buildingRescueMetalCost.set(value) }
	}
	
	open class CritsAttributes : BaseCombatWeaponAttributes.CritsAttributes() {
		companion object : IBlockScoped 
	
		context(attrs: IAttributeContainer)
		open var multRandomCritChance: Number? 
			get() = WeaponBaseAttributes.multRandomCritChance.get()
			set(value) { WeaponBaseAttributes.multRandomCritChance.set(value) }
	
		/**
		 * In-Game: "Cannot be crit boosted"
		 * 
		 * Can't be crit-boosted.
		 */
		context(attrs: IAttributeContainer)
		open var noCritBoost: Boolean? 
			get() = WeaponBaseAttributes.noCritBoost.get()
			set(value) { WeaponBaseAttributes.noCritBoost.set(value) }
	
		/**
		 * The weapon's "crit players with X condition" stat.
		 */
		context(attrs: IAttributeContainer)
		open var critVsConditions: EnumSet<TFCritCondition>? 
			get() = WeaponBaseAttributes.critVsConditions.get()
			set(value) { WeaponBaseAttributes.critVsConditions.set(value) }
	
		/**
		 * In-Game: "100% critical hit vs burning players"
		 * 
		 * The weapon's "crit players with X condition" stat.
		 */
		context(attrs: IAttributeContainer)
		open var critVsBurningPlayers: EnumSet<TFCritCondition>? 
			get() = WeaponBaseAttributes.critVsBurningPlayers.get()
			set(value) { WeaponBaseAttributes.critVsBurningPlayers.set(value) }
	
		/**
		 * In-Game: "100% critical hit vs disguised players"
		 * 
		 * The weapon's "crit players with X condition" stat.
		 */
		context(attrs: IAttributeContainer)
		open var critVsDisguisedPlayers: EnumSet<TFCritCondition>? 
			get() = WeaponBaseAttributes.critVsDisguisedPlayers.get()
			set(value) { WeaponBaseAttributes.critVsDisguisedPlayers.set(value) }
	
		/**
		 * In-Game: "100% critical hit vs wet players"
		 */
		context(attrs: IAttributeContainer)
		open var critVsWetPlayers: Boolean? 
			get() = WeaponBaseAttributes.critVsWetPlayers.get()
			set(value) { WeaponBaseAttributes.critVsWetPlayers.set(value) }
	
		/**
		 * In-Game: "100% critical hit vs non-burning players"
		 * 
		 * Crit against players that DON'T have these conditions.
		 */
		context(attrs: IAttributeContainer)
		open var critVsNonBurningPlayers: EnumSet<TFCritCondition>? 
			get() = WeaponBaseAttributes.critVsNonBurningPlayers.get()
			set(value) { WeaponBaseAttributes.critVsNonBurningPlayers.set(value) }
	
		/**
		 * In-Game: "100% critical hits burning players from behind. Mini-crits burning players from the front."
		 * 
		 * On hitting a burning player, crit them from behind or minicrit them otherwise.
		 */
		context(attrs: IAttributeContainer)
		open var axtinguisherProperties: Boolean? 
			get() = WeaponBaseAttributes.axtinguisherProperties.get()
			set(value) { WeaponBaseAttributes.axtinguisherProperties.set(value) }
	
		/**
		 * In-Game: "Deals crits while the wielder is rocket jumping"
		 * 
		 * Critical hit enemies if the player was launched into the air by an explosion.
		 * 
		 * Only works when not in Mannpower mode.
		 */
		context(attrs: IAttributeContainer)
		open var critWhileAirborne: Boolean? 
			get() = WeaponBaseAttributes.critWhileAirborne.get()
			set(value) { WeaponBaseAttributes.critWhileAirborne.set(value) }
	
		/**
		 * In-Game: "Mini-crits burning targets and extinguishes them. Damage increases based on remaining duration of afterburn. Killing blows on burning players grant a speed boost."
		 * 
		 * Only activates if the weapon deals `DMG_MELEE`.
		 */
		context(attrs: IAttributeContainer)
		open var attackMinicritsAndConsumesBurning: Boolean? 
			get() = WeaponBaseAttributes.attackMinicritsAndConsumesBurning.get()
			set(value) { WeaponBaseAttributes.attackMinicritsAndConsumesBurning.set(value) }
	
		/**
		 * In-Game: "100% minicrits vs burning players"
		 * 
		 * Minicrits if the damage dealt is NOT `DMG_BURN`.
		 */
		context(attrs: IAttributeContainer)
		open var minicritVsBurningPlayer: Boolean? 
			get() = WeaponBaseAttributes.minicritVsBurningPlayer.get()
			set(value) { WeaponBaseAttributes.minicritVsBurningPlayer.set(value) }
	
		/**
		 * In-Game: "Mini-crits targets launched airborne by explosions, grapple hooks or rocket packs"
		 * 
		 * Mini-crits targets launched airborne by an explosion.
		 * 
		 * Only procs when not in Mannpower mode.
		 */
		context(attrs: IAttributeContainer)
		open var minicritAirborne: Boolean? 
			get() = WeaponBaseAttributes.minicritAirborne.get()
			set(value) { WeaponBaseAttributes.minicritAirborne.set(value) }
	
		/**
		 * In-Game: "Mini-crits targets when fired at their back from close range"
		 * 
		 * If true, minicrits targets facing away from the attacker that are within 22.6 HU of the attacker (sqrt 512).
		 */
		context(attrs: IAttributeContainer)
		open var closerangeBackattackMinicrits: Boolean? 
			get() = WeaponBaseAttributes.closerangeBackattackMinicrits.get()
			set(value) { WeaponBaseAttributes.closerangeBackattackMinicrits.set(value) }
	
		/**
		 * In-Game: "Crits whenever it would normally mini-crit"
		 */
		context(attrs: IAttributeContainer)
		open var minicritsBecomeCrits: Boolean? 
			get() = WeaponBaseAttributes.minicritsBecomeCrits.get()
			set(value) { WeaponBaseAttributes.minicritsBecomeCrits.set(value) }
	
		/**
		 * In-Game: "No critical hits vs non-burning players"
		 * 
		 * Note: Even prevents criticals when crit-boosted.
		 */
		context(attrs: IAttributeContainer)
		open var noCritVsNonburning: Boolean? 
			get() = WeaponBaseAttributes.noCritVsNonburning.get()
			set(value) { WeaponBaseAttributes.noCritVsNonburning.set(value) }
	
		/**
		 * In-Game: "Critical damage is affected by range"
		 * 
		 * If true, crits have damage falloff (Ambassador).
		 */
		context(attrs: IAttributeContainer)
		open var critDmgFalloff: Boolean? 
			get() = WeaponBaseAttributes.critDmgFalloff.get()
			set(value) { WeaponBaseAttributes.critDmgFalloff.set(value) }
	
		/**
		 * In-Game: "Minicrits whenever it would normally crit"
		 */
		context(attrs: IAttributeContainer)
		open var critsBecomeMinicrits: Boolean? 
			get() = WeaponBaseAttributes.critsBecomeMinicrits.get()
			set(value) { WeaponBaseAttributes.critsBecomeMinicrits.set(value) }
	}
	
	open class DamageAttributes : BaseCombatWeaponAttributes.DamageAttributes() {
		companion object : IBlockScoped 
	
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
		context(attrs: IAttributeContainer)
		open var damage: Number? 
			get() = WeaponBaseAttributes.damage.get()
			set(value) { WeaponBaseAttributes.damage.set(value) }
	
		context(attrs: IAttributeContainer)
		open var dmgVsBuildings: Number? 
			get() = WeaponBaseAttributes.dmgVsBuildings.get()
			set(value) { WeaponBaseAttributes.dmgVsBuildings.set(value) }
	
		/**
		 * In-Game: "N% damage vs players"
		 */
		context(attrs: IAttributeContainer)
		open var dmgPenaltyVsPlayers: Number? 
			get() = WeaponBaseAttributes.dmgPenaltyVsPlayers.get()
			set(value) { WeaponBaseAttributes.dmgPenaltyVsPlayers.set(value) }
	
		/**
		 * In-Game: "N% damage vs non-burning players"
		 */
		context(attrs: IAttributeContainer)
		open var dmgPenaltyVsNonburning: Number? 
			get() = WeaponBaseAttributes.dmgPenaltyVsNonburning.get()
			set(value) { WeaponBaseAttributes.dmgPenaltyVsNonburning.set(value) }
	
		/**
		 * In-Game: "N% damage bonus vs burning players"
		 */
		context(attrs: IAttributeContainer)
		open var damageBonusVsBurning: Number? 
			get() = WeaponBaseAttributes.damageBonusVsBurning.get()
			set(value) { WeaponBaseAttributes.damageBonusVsBurning.set(value) }
	
		/**
		 * In-Game: "Attacks pierce damage resistance effects and bonuses"
		 * 
		 * Damage pierces through all resistances, such as Vaccinator ubercharges and the Battalion's Backup.
		 */
		context(attrs: IAttributeContainer)
		open var dmgPiercesResistsAbsorbs: Boolean? 
			get() = WeaponBaseAttributes.dmgPiercesResistsAbsorbs.get()
			set(value) { WeaponBaseAttributes.dmgPiercesResistsAbsorbs.set(value) }
	
		/**
		 * In-Game: "N% increased damage to your sentry's target"
		 */
		context(attrs: IAttributeContainer)
		open var damageBonusBulletVsSentryTarget: Number? 
			get() = WeaponBaseAttributes.damageBonusBulletVsSentryTarget.get()
			set(value) { WeaponBaseAttributes.damageBonusBulletVsSentryTarget.set(value) }
	
		/**
		 * In-Game: "N% damage on body shot"
		 * 
		 * Multiplier applied to bodyshot damage.
		 */
		context(attrs: IAttributeContainer)
		open var damagePenaltyOnBodyshot: Number? 
			get() = WeaponBaseAttributes.damagePenaltyOnBodyshot.get()
			set(value) { WeaponBaseAttributes.damagePenaltyOnBodyshot.set(value) }
	}
	
	open class DemoChargeAttributes : IBlockScoped {
		companion object : IBlockScoped 
	
		/**
		 * In-Game: "Melee hits refill  N% of your charge meter."
		 * 
		 * Restores demoman shield charge on hit.
		 */
		context(attrs: IAttributeContainer)
		open var chargeMeterOnHit: Number? 
			get() = WeaponBaseAttributes.chargeMeterOnHit.get()
			set(value) { WeaponBaseAttributes.chargeMeterOnHit.set(value) }
	
		/**
		 * In-Game: "Ammo boxes collected also give Charge"
		 * 
		 * If true, and player has a demoman charge meter, add charge based on ammo pack size.
		 */
		context(attrs: IAttributeContainer)
		open var ammoPacksGiveDemoknightCharge: Boolean? 
			get() = WeaponBaseAttributes.ammoPacksGiveDemoknightCharge.get()
			set(value) { WeaponBaseAttributes.ammoPacksGiveDemoknightCharge.set(value) }
	}
	
	open class FiringAttributes : IBlockScoped {
		companion object : IBlockScoped {
			val fireRate: FireRateAttributes = FireRateAttributes()
		}
	
		/**
		 * Bonus:
		 * 
		 * 	- In-Game: "Hold Fire to load up to three rockets Release Fire to unleash the barrage"
		 * 
		 * Penalty:
		 */
		context(attrs: IAttributeContainer)
		open var autoFiresFullClip: Boolean? 
			get() = WeaponBaseAttributes.autoFiresFullClip.get()
			set(value) { WeaponBaseAttributes.autoFiresFullClip.set(value) }
	
		context(attrs: IAttributeContainer)
		open var autoFiresFullClipAllAtOnce: Boolean? 
			get() = WeaponBaseAttributes.autoFiresFullClipAllAtOnce.get()
			set(value) { WeaponBaseAttributes.autoFiresFullClipAllAtOnce.set(value) }
	
		context(attrs: IAttributeContainer)
		open var autoFiresWhenFull: Boolean? 
			get() = WeaponBaseAttributes.autoFiresWhenFull.get()
			set(value) { WeaponBaseAttributes.autoFiresWhenFull.set(value) }
	
		/**
		 * In-Game: "Overloading the chamber will cause a misfire"
		 * 
		 * Deals damage to the player when overloaded.
		 */
		context(attrs: IAttributeContainer)
		open var canOverload: Boolean? 
			get() = WeaponBaseAttributes.canOverload.get()
			set(value) { WeaponBaseAttributes.canOverload.set(value) }
	
		open val fireRate: FireRateAttributes = FireRateAttributes()
	
		open class FireRateAttributes : IBlockScoped {
			companion object : IBlockScoped 
	
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
			context(attrs: IAttributeContainer)
			open var fireRate: Number? 
				get() = WeaponBaseAttributes.fireRate.get()
				set(value) { WeaponBaseAttributes.fireRate.set(value) }
		}
	}
	
	open class HealthAndHealingAttributes : IBlockScoped {
		companion object : IBlockScoped 
	
		/**
		 * In-Game: "Blocks healing while in use"
		 * 
		 * Prevents mediguns/dispensers from targeting you and crossbow bolts from healing you while the weapon is active.
		 */
		context(attrs: IAttributeContainer)
		open var weaponBlocksHealing: Boolean? 
			get() = WeaponBaseAttributes.weaponBlocksHealing.get()
			set(value) { WeaponBaseAttributes.weaponBlocksHealing.set(value) }
	
		/**
		 * Bonus:
		 * 
		 * 	- In-Game: "+N health regenerated per second on wearer"
		 * 
		 * Penalty:
		 * 
		 * 	- In-Game: "N health drained per second on wearer"
		 */
		context(attrs: IAttributeContainer)
		open var passiveHealthRegen: Int? 
			get() = WeaponBaseAttributes.passiveHealthRegen.get()
			set(value) { WeaponBaseAttributes.passiveHealthRegen.set(value) }
	
		/**
		 * In-Game: "+N% ÜberCharge rate for the medic healing you This effect does not work in the respawn room"
		 * 
		 * Multiplier applied to your healer's ubercharge rate.
		 * 
		 * NOTE: Only applied if user is outside of the respawn room.
		 */
		context(attrs: IAttributeContainer)
		open var uberchargeRateBonusForHealer: Number? 
			get() = WeaponBaseAttributes.uberchargeRateBonusForHealer.get()
			set(value) { WeaponBaseAttributes.uberchargeRateBonusForHealer.set(value) }
	
		/**
		 * In-Game: "On Hit: Gain up to +N health per attack"
		 * 
		 * Maximum amount of health that can be gained from an AoE damage source.
		 * 
		 * Health received is multiplied by `damage dealt / base damage of the weapon`, to a max of 100% of the defined value.
		 */
		context(attrs: IAttributeContainer)
		open var healOnHit_radial: Int? 
			get() = WeaponBaseAttributes.healOnHit_radial.get()
			set(value) { WeaponBaseAttributes.healOnHit_radial.set(value) }
	
		/**
		 * In-Game: "N% health from healers on wearer"
		 * 
		 * Attribute class is a flat multiplier applied to health from healers while weapon is active.
		 */
		context(attrs: IAttributeContainer)
		open var multHealthFromHealersWhileActive: Number? 
			get() = WeaponBaseAttributes.multHealthFromHealersWhileActive.get()
			set(value) { WeaponBaseAttributes.multHealthFromHealersWhileActive.set(value) }
	
		/**
		 * In-Game: "N% Overheal build rate."
		 * 
		 * Checked on the player that is healing an entity.
		 */
		context(attrs: IAttributeContainer)
		open var multOverhealFillRate: Number? 
			get() = WeaponBaseAttributes.multOverhealFillRate.get()
			set(value) { WeaponBaseAttributes.multOverhealFillRate.set(value) }
	
		/**
		 * In-Game: "N% less healing from Medic sources"
		 * 
		 * Applies to all non-dispenser forms of healing that apply the `TF_COND_HEAL_BUFF` status.
		 */
		context(attrs: IAttributeContainer)
		open var reducedHealingFromMedics: Number? 
			get() = WeaponBaseAttributes.reducedHealingFromMedics.get()
			set(value) { WeaponBaseAttributes.reducedHealingFromMedics.set(value) }
	
		/**
		 * Bonus:
		 * 
		 * 	- In-Game: "+N% bonus healing from all sources"
		 * 
		 * Penalty:
		 * 
		 * 	- In-Game: "N% less healing from all sources"
		 */
		context(attrs: IAttributeContainer)
		open var multHealingReceived: Number? 
			get() = WeaponBaseAttributes.multHealingReceived.get()
			set(value) { WeaponBaseAttributes.multHealingReceived.set(value) }
	
		/**
		 * In-Game: "Maximum health is drained while item is active"
		 * 
		 * Maximum health decrease per tick while weapon is active. (Gloves of Running Urgently/Eviction Notice).
		 */
		context(attrs: IAttributeContainer)
		open var maxHealthDrainedWhileActive: Number? 
			get() = WeaponBaseAttributes.maxHealthDrainedWhileActive.get()
			set(value) { WeaponBaseAttributes.maxHealthDrainedWhileActive.set(value) }
	}
	
	open class KnockbackReceivedAttributes : BaseCombatWeaponAttributes.KnockbackReceivedAttributes() {
		companion object : IBlockScoped {
			val damageForceReduction: DamageForceReductionAttributes = DamageForceReductionAttributes()
		}
	
		/**
		 * Bonus:
		 * 
		 * 	- In-Game: "+N% self damage force"
		 * 
		 * Penalty:
		 * 
		 * 	- In-Game: "N% self damage force"
		 */
		context(attrs: IAttributeContainer)
		open var selfDmgPushForce: Number? 
			get() = WeaponBaseAttributes.selfDmgPushForce.get()
			set(value) { WeaponBaseAttributes.selfDmgPushForce.set(value) }
	
		open val damageForceReduction: DamageForceReductionAttributes = DamageForceReductionAttributes()
	
		open class DamageForceReductionAttributes : IBlockScoped {
			companion object : IBlockScoped 
	
			/**
			 * In-Game: "N% reduction in push force taken from damage"
			 * 
			 * Attribute class is a flat multiplier applied to push force received from damage.
			 */
			context(attrs: IAttributeContainer)
			open var damageForceReduction: Number? 
				get() = WeaponBaseAttributes.damageForceReduction.get()
				set(value) { WeaponBaseAttributes.damageForceReduction.set(value) }
	
			/**
			 * In-Game: "N% increase in push force taken from damage"
			 * 
			 * Attribute class is a flat multiplier applied to push force received from damage.
			 */
			context(attrs: IAttributeContainer)
			open var damageForceIncrease: Number? 
				get() = WeaponBaseAttributes.damageForceIncrease.get()
				set(value) { WeaponBaseAttributes.damageForceIncrease.set(value) }
	
			/**
			 * In-Game: "N% increase in push force taken from damage"
			 * 
			 * Attribute class is a flat multiplier applied to push force received from damage.
			 */
			context(attrs: IAttributeContainer)
			open var damageForceIncreaseHidden: Number? 
				get() = WeaponBaseAttributes.damageForceIncreaseHidden.get()
				set(value) { WeaponBaseAttributes.damageForceIncreaseHidden.set(value) }
	
			/**
			 * In-Game: "Increase in push force taken from damage and airblast"
			 * 
			 * Attribute class is a flat multiplier applied to push force received from damage.
			 */
			context(attrs: IAttributeContainer)
			open var damageForceIncreaseText: Number? 
				get() = WeaponBaseAttributes.damageForceIncreaseText.get()
				set(value) { WeaponBaseAttributes.damageForceIncreaseText.set(value) }
		}
	}
	
	open class MetaAttributes : BaseCombatWeaponAttributes.MetaAttributes() {
		companion object : IBlockScoped {
			val viewmodel: ViewmodelAttributes = ViewmodelAttributes()
		}
	
		/**
		 * What "Strange Part" kills with this weapon should contribute to.
		 */
		context(attrs: IAttributeContainer)
		open var killEaterKillType: Int? 
			get() = WeaponBaseAttributes.killEaterKillType.get()
			set(value) { WeaponBaseAttributes.killEaterKillType.set(value) }
	
		override val killfeed: KillfeedAttributes = KillfeedAttributes()
	
		open val viewmodel: ViewmodelAttributes = ViewmodelAttributes()
	
		override val items: ItemsAttributes = ItemsAttributes()
	
		override val particles: ParticlesAttributes = ParticlesAttributes()
	
		open class KillfeedAttributes : BaseCombatWeaponAttributes.MetaAttributes.KillfeedAttributes() {
			companion object : IBlockScoped 
	
			context(attrs: IAttributeContainer)
			open var isGigerCounter: Boolean? 
				get() = WeaponBaseAttributes.isGigerCounter.get()
				set(value) { WeaponBaseAttributes.isGigerCounter.set(value) }
	
			/**
			 * Sets killfeed background gold.
			 */
			context(attrs: IAttributeContainer)
			open var isAustraliumItem: Boolean? 
				get() = WeaponBaseAttributes.isAustraliumItem.get()
				set(value) { WeaponBaseAttributes.isAustraliumItem.set(value) }
	
			/**
			 * In-Game: "Imbued with an ancient power"
			 * 
			 * Sets killfeed background gold.
			 */
			context(attrs: IAttributeContainer)
			open var turnToGold: Boolean? 
				get() = WeaponBaseAttributes.turnToGold.get()
				set(value) { WeaponBaseAttributes.turnToGold.set(value) }
	
			/**
			 * In-Game: "Silent Killer: No attack noise from backstabs"
			 * 
			 * Kills will not show up in the killfeed.
			 */
			context(attrs: IAttributeContainer)
			open var silentKiller: Boolean? 
				get() = WeaponBaseAttributes.silentKiller.get()
				set(value) { WeaponBaseAttributes.silentKiller.set(value) }
		}
	
		open class ViewmodelAttributes : IBlockScoped {
			companion object : IBlockScoped 
	
			context(attrs: IAttributeContainer)
			open var weaponAllowInspect: Boolean? 
				get() = WeaponBaseAttributes.weaponAllowInspect.get()
				set(value) { WeaponBaseAttributes.weaponAllowInspect.set(value) }
	
			context(attrs: IAttributeContainer)
			open var weaponStattrakModuleScale: Number? 
				get() = WeaponBaseAttributes.weaponStattrakModuleScale.get()
				set(value) { WeaponBaseAttributes.weaponStattrakModuleScale.set(value) }
	
			context(attrs: IAttributeContainer)
			open var minViewmodelOffset: String? 
				get() = WeaponBaseAttributes.minViewmodelOffset.get()
				set(value) { WeaponBaseAttributes.minViewmodelOffset.set(value) }
		}
	
		open class ItemsAttributes : BaseCombatWeaponAttributes.MetaAttributes.ItemsAttributes() 
	
		open class ParticlesAttributes : BaseCombatWeaponAttributes.MetaAttributes.ParticlesAttributes() 
	}
	
	open class MeterAttributes : BaseCombatWeaponAttributes.MeterAttributes() {
		companion object : IBlockScoped 
	
		/**
		 * In-Game: "+N% increase in recharge rate"
		 * 
		 * For things like throwable recharge timers, jetpack charging, etc: how much it recharges per second.
		 */
		context(attrs: IAttributeContainer)
		open var effectBarRechargeRateIncreased: Number? 
			get() = WeaponBaseAttributes.effectBarRechargeRateIncreased.get()
			set(value) { WeaponBaseAttributes.effectBarRechargeRateIncreased.set(value) }
	}
	
	open class MovementAttributes : IBlockScoped {
		companion object : IBlockScoped {
			val moveSpeed: MoveSpeedAttributes = MoveSpeedAttributes()
		}
	
		/**
		 * In-Game: "+N% greater jump height when active"
		 * 
		 * Only takes effect while this weapon is active.
		 */
		context(attrs: IAttributeContainer)
		open var increasedJumpHeightFromWeapon: Number? 
			get() = WeaponBaseAttributes.increasedJumpHeightFromWeapon.get()
			set(value) { WeaponBaseAttributes.increasedJumpHeightFromWeapon.set(value) }
	
		/**
		 * In-Game: "Grants Triple Jump while deployed. Melee attacks mini-crit while airborne."
		 * 
		 * If greater than 0, attacks minicrit while airborne.
		 * 
		 * Only procs on Scout.
		 */
		context(attrs: IAttributeContainer)
		open var airDashCount: Int? 
			get() = WeaponBaseAttributes.airDashCount.get()
			set(value) { WeaponBaseAttributes.airDashCount.set(value) }
	
		open val moveSpeed: MoveSpeedAttributes = MoveSpeedAttributes()
	
		open class MoveSpeedAttributes : IBlockScoped {
			companion object : IBlockScoped 
	
			/**
			 * Multiplier applied to movement speed scaled by ubercharge percentage.
			 * 
			 * Only works if the player using this item is a Medic with a Medigun.
			 */
			context(attrs: IAttributeContainer)
			open var moveSpeedBonusResourceLevel: Number? 
				get() = WeaponBaseAttributes.moveSpeedBonusResourceLevel.get()
				set(value) { WeaponBaseAttributes.moveSpeedBonusResourceLevel.set(value) }
	
			/**
			 * In-Game: "+N% faster move speed on wearer"
			 * 
			 * Multiplier applied to player movement speed only while this is the active weapon.
			 */
			context(attrs: IAttributeContainer)
			open var multPlayerMovespeedActive: Number? 
				get() = WeaponBaseAttributes.multPlayerMovespeedActive.get()
				set(value) { WeaponBaseAttributes.multPlayerMovespeedActive.set(value) }
		}
	}
	
	open class HeadsAttributes : IBlockScoped {
		companion object : IBlockScoped 
	}
	
	open class OnHitAttributes : IBlockScoped {
		companion object : IBlockScoped {
			val healOnHitForRapidfire: HealOnHitForRapidfireAttributes = HealOnHitForRapidfireAttributes()
	
			val generateRageOnDamage: GenerateRageOnDamageAttributes = GenerateRageOnDamageAttributes()
		}
	
		/**
		 * In-Game: "+N% cloak on hit"
		 * 
		 * Adds this amount of cloak on hit.
		 * 
		 * Only procs on Spy.
		 */
		context(attrs: IAttributeContainer)
		open var addCloakOnHit: Int? 
			get() = WeaponBaseAttributes.addCloakOnHit.get()
			set(value) { WeaponBaseAttributes.addCloakOnHit.set(value) }
	
		/**
		 * In-Game: "On Hit: damage dealt is returned as ammo"
		 * 
		 * Gain ammo equivalent to damage dealt on hit.
		 */
		context(attrs: IAttributeContainer)
		open var addOnhitAddammo: Boolean? 
			get() = WeaponBaseAttributes.addOnhitAddammo.get()
			set(value) { WeaponBaseAttributes.addOnhitAddammo.set(value) }
	
		/**
		 * In-Game: "On Hit Spy: Reveal cloaked Spy"
		 */
		context(attrs: IAttributeContainer)
		open var revealCloakedVictimOnHit: Boolean? 
			get() = WeaponBaseAttributes.revealCloakedVictimOnHit.get()
			set(value) { WeaponBaseAttributes.revealCloakedVictimOnHit.set(value) }
	
		/**
		 * In-Game: "On Hit Spy: Reveal disguised Spy"
		 */
		context(attrs: IAttributeContainer)
		open var revealDisguisedVictimOnHit: Boolean? 
			get() = WeaponBaseAttributes.revealDisguisedVictimOnHit.get()
			set(value) { WeaponBaseAttributes.revealDisguisedVictimOnHit.set(value) }
	
		/**
		 * In-Game: "On Hit: Gain a speed boost"
		 * 
		 * Just does `addcond(SPEED_BOOST, speed_boost_on_hit)`.
		 */
		context(attrs: IAttributeContainer)
		open var speedBoostOnHit: Int? 
			get() = WeaponBaseAttributes.speedBoostOnHit.get()
			set(value) { WeaponBaseAttributes.speedBoostOnHit.set(value) }
	
		/**
		 * In-Game: "On Hit: N% ÜberCharge added"
		 * 
		 * Only procs if on a Medic.
		 */
		context(attrs: IAttributeContainer)
		open var addUberChargeOnHit: Number? 
			get() = WeaponBaseAttributes.addUberChargeOnHit.get()
			set(value) { WeaponBaseAttributes.addUberChargeOnHit.set(value) }
	
		/**
		 * Bonus:
		 * 
		 * 	- In-Game: "N% rage gained on hit"
		 * 
		 * Penalty:
		 * 
		 * 	- In-Game: "N% rage lost on hit"
		 */
		context(attrs: IAttributeContainer)
		open var rageOnHit: Int? 
			get() = WeaponBaseAttributes.rageOnHit.get()
			set(value) { WeaponBaseAttributes.rageOnHit.set(value) }
	
		/**
		 * In-Game: "On Hit: Builds Boost Run speed increased with Boost"
		 * 
		 * Gain Scout's "hype" meter on hit.
		 * 
		 * This exists for everything, but specifically modifies Scout's "hype" meter, which is only used for the Soda Popper and Baby Face's Blaster.
		 */
		context(attrs: IAttributeContainer)
		open var boostOnDamage: Boolean? 
			get() = WeaponBaseAttributes.boostOnDamage.get()
			set(value) { WeaponBaseAttributes.boostOnDamage.set(value) }
	
		/**
		 * In-Game: "On Hit: One target at a time is Marked-For-Death, causing all damage taken to be mini-crits"
		 */
		context(attrs: IAttributeContainer)
		open var markForDeath: Boolean? 
			get() = WeaponBaseAttributes.markForDeath.get()
			set(value) { WeaponBaseAttributes.markForDeath.set(value) }
	
		/**
		 * In-Game: "On Hit: If enemy's belt is at or above eye level, stun them for N seconds"
		 * 
		 * Stun airborne targets.
		 */
		context(attrs: IAttributeContainer)
		open var stunWaistHighAirborne: Boolean? 
			get() = WeaponBaseAttributes.stunWaistHighAirborne.get()
			set(value) { WeaponBaseAttributes.stunWaistHighAirborne.set(value) }
	
		/**
		 * In-Game: "On Hit: Victim loses up to N% Medigun charge"
		 * 
		 * Percentage as an int, e.g. `25` = 25% = 0.25.
		 * 
		 * Drain scaled over distance.
		 */
		context(attrs: IAttributeContainer)
		open var subtractVictimMedigunChargeOnHit: Int? 
			get() = WeaponBaseAttributes.subtractVictimMedigunChargeOnHit.get()
			set(value) { WeaponBaseAttributes.subtractVictimMedigunChargeOnHit.set(value) }
	
		/**
		 * In-Game: "On Hit: Victim loses up to N% cloak"
		 * 
		 * Subtracts an actual value.
		 * 
		 * Drain still scaled over distance.
		 */
		context(attrs: IAttributeContainer)
		open var subtractVictimCloakOnHit: Int? 
			get() = WeaponBaseAttributes.subtractVictimCloakOnHit.get()
			set(value) { WeaponBaseAttributes.subtractVictimCloakOnHit.set(value) }
	
		/**
		 * In-Game: "On Hit: N% chance to slow target"
		 * 
		 * Gain speedboost on hit.
		 */
		context(attrs: IAttributeContainer)
		open var slowEnemyOnHit: Number? 
			get() = WeaponBaseAttributes.slowEnemyOnHit.get()
			set(value) { WeaponBaseAttributes.slowEnemyOnHit.set(value) }
	
		/**
		 * In-Game: "On Hit: Slow target movement by 40% for Ns"
		 * 
		 * Gain speedboost for N seconds.
		 */
		context(attrs: IAttributeContainer)
		open var slowEnemyOnHitMajor: Number? 
			get() = WeaponBaseAttributes.slowEnemyOnHitMajor.get()
			set(value) { WeaponBaseAttributes.slowEnemyOnHitMajor.set(value) }
	
		/**
		 * In-Game: "Syringes deliver a highly concentrated dose of Mad Milk. Duration increases per hit to a max of 4 seconds."
		 * 
		 * Applies Mad Milk with a duration of 4 seconds, and each subsequent hit on the same target adds 0.5 seconds to the duration.
		 */
		context(attrs: IAttributeContainer)
		open var madMilkSyringes: Boolean? 
			get() = WeaponBaseAttributes.madMilkSyringes.get()
			set(value) { WeaponBaseAttributes.madMilkSyringes.set(value) }
	
		/**
		 * In-Game: "Stuns enemies who are also wielding this weapon"
		 */
		context(attrs: IAttributeContainer)
		open var stunEnemiesWieldingSameWeapon: Boolean? 
			get() = WeaponBaseAttributes.stunEnemiesWieldingSameWeapon.get()
			set(value) { WeaponBaseAttributes.stunEnemiesWieldingSameWeapon.set(value) }
	
		/**
		 * In-Game: "All players connected via Medigun beams are hit"
		 * 
		 * Damage all players connected to the target by medigun beams.
		 */
		context(attrs: IAttributeContainer)
		open var damageAllConnected: Boolean? 
			get() = WeaponBaseAttributes.damageAllConnected.get()
			set(value) { WeaponBaseAttributes.damageAllConnected.set(value) }
	
		/**
		 * Apply this amount of z velocity to players hit with this weapon.
		 */
		context(attrs: IAttributeContainer)
		open var applyZVelocityOnDamage: Number? 
			get() = WeaponBaseAttributes.applyZVelocityOnDamage.get()
			set(value) { WeaponBaseAttributes.applyZVelocityOnDamage.set(value) }
	
		/**
		 * Apply this amount of velocity in the direction you're facing to players hit with this weapon.
		 */
		context(attrs: IAttributeContainer)
		open var applyLookVelocityOnDamage: Number? 
			get() = WeaponBaseAttributes.applyLookVelocityOnDamage.get()
			set(value) { WeaponBaseAttributes.applyLookVelocityOnDamage.set(value) }
	
		/**
		 * Push force applied to target when hitting an enemy.
		 * 
		 * Scales by range, to a minimum of 50% of the given value.
		 */
		context(attrs: IAttributeContainer)
		open var damageBlastPush: Number? 
			get() = WeaponBaseAttributes.damageBlastPush.get()
			set(value) { WeaponBaseAttributes.damageBlastPush.set(value) }
	
		/**
		 * In-Game: "On Hit: Bleed for N seconds"
		 * 
		 * Apply bleed on hit.
		 * 
		 * Value is a time in seconds.
		 */
		context(attrs: IAttributeContainer)
		open var bleedingDuration: Number? 
			get() = WeaponBaseAttributes.bleedingDuration.get()
			set(value) { WeaponBaseAttributes.bleedingDuration.set(value) }
	
		open val healOnHitForRapidfire: HealOnHitForRapidfireAttributes = HealOnHitForRapidfireAttributes()
	
		open val generateRageOnDamage: GenerateRageOnDamageAttributes = GenerateRageOnDamageAttributes()
	
		open class HealOnHitForRapidfireAttributes : IBlockScoped {
			companion object : IBlockScoped 
	
			/**
			 * In-Game: "On Hit: Gain up to +N health"
			 * 
			 * Add this amount of health on hit.
			 */
			context(attrs: IAttributeContainer)
			open var healOnHitForRapidfire: Int? 
				get() = WeaponBaseAttributes.healOnHitForRapidfire.get()
				set(value) { WeaponBaseAttributes.healOnHitForRapidfire.set(value) }
	
			/**
			 * In-Game: "On Hit: N health"
			 * 
			 * Add this amount of health on hit.
			 */
			context(attrs: IAttributeContainer)
			open var selfdmgOnHitForRapidfire: Int? 
				get() = WeaponBaseAttributes.selfdmgOnHitForRapidfire.get()
				set(value) { WeaponBaseAttributes.selfdmgOnHitForRapidfire.set(value) }
	
			/**
			 * In-Game: "On Hit: Gain up to +N health"
			 * 
			 * Add this amount of health on hit.
			 */
			context(attrs: IAttributeContainer)
			open var healOnHitForSlowfire: Int? 
				get() = WeaponBaseAttributes.healOnHitForSlowfire.get()
				set(value) { WeaponBaseAttributes.healOnHitForSlowfire.set(value) }
	
			/**
			 * In-Game: "On Hit: N health"
			 * 
			 * Add this amount of health on hit.
			 */
			context(attrs: IAttributeContainer)
			open var selfdmgOnHitForSlowfire: Int? 
				get() = WeaponBaseAttributes.selfdmgOnHitForSlowfire.get()
				set(value) { WeaponBaseAttributes.selfdmgOnHitForSlowfire.set(value) }
		}
	
		open class GenerateRageOnDamageAttributes : IBlockScoped {
			companion object : IBlockScoped 
	
			/**
			 * In-Game: "Generate Rage by dealing damage.  When fully charged, press the Special-Attack key to activate knockback"
			 * 
			 * Knockback rage on enemy if you're a heavy and your rage is draining.
			 */
			context(attrs: IAttributeContainer)
			open var generateRageOnDamage: Boolean? 
				get() = WeaponBaseAttributes.generateRageOnDamage.get()
				set(value) { WeaponBaseAttributes.generateRageOnDamage.set(value) }
	
			/**
			 * In-Game: "Generate building rescue energy on damage"
			 * 
			 * Knockback rage on enemy if you're a heavy and your rage is draining.
			 */
			context(attrs: IAttributeContainer)
			open var engineerRageOnDmg: Boolean? 
				get() = WeaponBaseAttributes.engineerRageOnDmg.get()
				set(value) { WeaponBaseAttributes.engineerRageOnDmg.set(value) }
		}
	}
	
	open class OnKillAttributes : IBlockScoped {
		companion object : IBlockScoped 
	
		/**
		 * In-Game: "On Kill: N seconds of 100% critical chance"
		 * 
		 * Seconds of crit-boost gained on kill.
		 * 
		 * Note: actual time is `this + 1`.
		 */
		context(attrs: IAttributeContainer)
		open var critboostOnKill: Int? 
			get() = WeaponBaseAttributes.critboostOnKill.get()
			set(value) { WeaponBaseAttributes.critboostOnKill.set(value) }
	
		/**
		 * In-Game: "On Kill: Gain Mini-crits for N seconds."
		 * 
		 * Seconds of minicrit-boost gained on kill.
		 * 
		 * Note: actual time is `this + 1`.
		 */
		context(attrs: IAttributeContainer)
		open var minicritboostOnKill: Int? 
			get() = WeaponBaseAttributes.minicritboostOnKill.get()
			set(value) { WeaponBaseAttributes.minicritboostOnKill.set(value) }
	
		/**
		 * In-Game: "On Kill: Gain N% of base health on kill"
		 * 
		 * Percentage of health to be restored upon killing an enemy. (e.g. `25` is 25%).
		 * 
		 * Post-heal player health value is capped at 1.5x the player's normal max health.
		 * 
		 * Negative values are ignored.
		 */
		context(attrs: IAttributeContainer)
		open var restoreHealthOnKill: Int? 
			get() = WeaponBaseAttributes.restoreHealthOnKill.get()
			set(value) { WeaponBaseAttributes.restoreHealthOnKill.set(value) }
	
		/**
		 * In-Game: "+N health restored on kill"
		 * 
		 * Restores this flat amount of health on killing an enemy. Post-heal player health value is capped at the player's maximum overheal.
		 * 
		 * Negative values are NOT ignored.
		 */
		context(attrs: IAttributeContainer)
		open var healOnKill: Int? 
			get() = WeaponBaseAttributes.healOnKill.get()
			set(value) { WeaponBaseAttributes.healOnKill.set(value) }
	
		/**
		 * In-Game: "Gain a speed boost on kill"
		 */
		context(attrs: IAttributeContainer)
		open var speedBoostOnKill: Int? 
			get() = WeaponBaseAttributes.speedBoostOnKill.get()
			set(value) { WeaponBaseAttributes.speedBoostOnKill.set(value) }
	
		/**
		 * In-Game: "Exorcism"
		 * 
		 * Exorcism spell effect.
		 */
		context(attrs: IAttributeContainer)
		open var spellHalloweenDeathGhosts: Boolean? 
			get() = WeaponBaseAttributes.spellHalloweenDeathGhosts.get()
			set(value) { WeaponBaseAttributes.spellHalloweenDeathGhosts.set(value) }
	}
	
	open class ProjectilesAttributes : IBlockScoped {
		companion object : IBlockScoped {
			val projectilePenetration: ProjectilePenetrationAttributes = ProjectilePenetrationAttributes()
	
			val bullets: BulletsAttributes = BulletsAttributes()
		}
	
		/**
		 * Note: "Projectile" includes bullets.
		 */
		context(attrs: IAttributeContainer)
		open var centerfireProjectile: Boolean? 
			get() = WeaponBaseAttributes.centerfireProjectile.get()
			set(value) { WeaponBaseAttributes.centerfireProjectile.set(value) }
	
		/**
		 * In-Game: "+N degrees random projectile deviation"
		 * 
		 * Does not include bullets.
		 */
		context(attrs: IAttributeContainer)
		open var projectileSpreadAnglePenalty: Number? 
			get() = WeaponBaseAttributes.projectileSpreadAnglePenalty.get()
			set(value) { WeaponBaseAttributes.projectileSpreadAnglePenalty.set(value) }
	
		open val projectilePenetration: ProjectilePenetrationAttributes = ProjectilePenetrationAttributes()
	
		open val bullets: BulletsAttributes = BulletsAttributes()
	
		open class ProjectilePenetrationAttributes : IBlockScoped {
			companion object : IBlockScoped 
	
			/**
			 * In-Game: "Projectiles penetrate enemy players"
			 * 
			 * How many players your "projectile" (*including bullets*) should penetrate.
			 */
			context(attrs: IAttributeContainer)
			open var projectilePenetration: Int? 
				get() = WeaponBaseAttributes.projectilePenetration.get()
				set(value) { WeaponBaseAttributes.projectilePenetration.set(value) }
	
			/**
			 * In-Game: "Bullets penetrate +N enemies"
			 * 
			 * How many players your "projectile" (*including bullets*) should penetrate.
			 */
			context(attrs: IAttributeContainer)
			open var projectilePenetrationHeavy: Int? 
				get() = WeaponBaseAttributes.projectilePenetrationHeavy.get()
				set(value) { WeaponBaseAttributes.projectilePenetrationHeavy.set(value) }
		}
	
		open class BulletsAttributes : IBlockScoped {
			companion object : IBlockScoped 
	
			/**
			 * In-Game: "+N% bullets per shot"
			 */
			context(attrs: IAttributeContainer)
			open var bulletsPerShotBonus: Number? 
				get() = WeaponBaseAttributes.bulletsPerShotBonus.get()
				set(value) { WeaponBaseAttributes.bulletsPerShotBonus.set(value) }
	
			/**
			 * In-Game: "Fires tracer rounds"
			 * 
			 * Note: Sniper rage forcibly draws a tracer regardless of this setting.
			 * 
			 * Used when firing bullets.
			 */
			context(attrs: IAttributeContainer)
			open var sniperFiresTracer: Boolean? 
				get() = WeaponBaseAttributes.sniperFiresTracer.get()
				set(value) { WeaponBaseAttributes.sniperFiresTracer.set(value) }
	
			/**
			 * In-Game: "Fires tracer rounds"
			 * 
			 * Same as `sniper_fires_tracer`.
			 */
			context(attrs: IAttributeContainer)
			open var sniperFiresTracerHidden: Boolean? 
				get() = WeaponBaseAttributes.sniperFiresTracerHidden.get()
				set(value) { WeaponBaseAttributes.sniperFiresTracerHidden.set(value) }
	
			/**
			 * In-Game: "On Full Charge: Projectiles penetrate players"
			 */
			context(attrs: IAttributeContainer)
			open var penetratesWhenFullyCharged: Boolean? 
				get() = WeaponBaseAttributes.penetratesWhenFullyCharged.get()
				set(value) { WeaponBaseAttributes.penetratesWhenFullyCharged.set(value) }
	
			/**
			 * In-Game: "Increased headshot explosion radius and damage to nearby enemies"
			 * 
			 * Only applies if in a gamemode with upgrades, but applies to all headshots.
			 * 
			 * Also applies to any hitscan weapon with a `jarate_time` attribute that hit the head.
			 */
			context(attrs: IAttributeContainer)
			open var explosiveHeadshotLevel: Int? 
				get() = WeaponBaseAttributes.explosiveHeadshotLevel.get()
				set(value) { WeaponBaseAttributes.explosiveHeadshotLevel.set(value) }
		}
	}
	
	open class ReloadingAttributes : IBlockScoped {
		companion object : IBlockScoped 
	
		/**
		 * Bonus:
		 * 
		 * 	- In-Game: "N% faster reload time"
		 * 
		 * Penalty:
		 * 
		 * 	- In-Game: "N% slower reload time"
		 */
		context(attrs: IAttributeContainer)
		open var reloadTime: Number? 
			get() = WeaponBaseAttributes.reloadTime.get()
			set(value) { WeaponBaseAttributes.reloadTime.set(value) }
	
		/**
		 * In-Game: "N% slower reload time"
		 */
		context(attrs: IAttributeContainer)
		open var reloadTimeIncreasedHidden: Number? 
			get() = WeaponBaseAttributes.reloadTimeIncreasedHidden.get()
			set(value) { WeaponBaseAttributes.reloadTimeIncreasedHidden.set(value) }
	
		/**
		 * In-Game: "+N% faster reload time"
		 * 
		 * This is what's used for weapons that draw directly from reserve ammo, like the flare gun and sniper rifle.
		 */
		context(attrs: IAttributeContainer)
		open var fasterReloadRate: Number? 
			get() = WeaponBaseAttributes.fasterReloadRate.get()
			set(value) { WeaponBaseAttributes.fasterReloadRate.set(value) }
	
		/**
		 * Halloween reload time multiplier.
		 * 
		 * Checked on player.
		 */
		context(attrs: IAttributeContainer)
		open var halloweenReloadTimeDecreased: Number? 
			get() = WeaponBaseAttributes.halloweenReloadTimeDecreased.get()
			set(value) { WeaponBaseAttributes.halloweenReloadTimeDecreased.set(value) }
	
		/**
		 * In-Game: "N% faster reload time while being healed"
		 */
		context(attrs: IAttributeContainer)
		open var reloadTimeDecreasedWhileHealed: Number? 
			get() = WeaponBaseAttributes.reloadTimeDecreasedWhileHealed.get()
			set(value) { WeaponBaseAttributes.reloadTimeDecreasedWhileHealed.set(value) }
	}
	
	open class ResistanceAttributes : BaseCombatWeaponAttributes.ResistanceAttributes() {
		companion object : IBlockScoped 
	
		/**
		 * In-Game: "On Hit by Fire: Fireproof for 1 second and Afterburn immunity for N seconds"
		 * 
		 * Addcond parameter.
		 */
		context(attrs: IAttributeContainer)
		open var becomeFireproofOnHitByFire: Number? 
			get() = WeaponBaseAttributes.becomeFireproofOnHitByFire.get()
			set(value) { WeaponBaseAttributes.becomeFireproofOnHitByFire.set(value) }
	
		/**
		 * In-Game: "N% damage vulnerability on wearer"
		 */
		context(attrs: IAttributeContainer)
		open var multDmgtakenActive: Number? 
			get() = WeaponBaseAttributes.multDmgtakenActive.get()
			set(value) { WeaponBaseAttributes.multDmgtakenActive.set(value) }
	
		/**
		 * In-Game: "+N% damage from melee sources while active"
		 * 
		 * Multiplier applied to incoming melee damage.
		 */
		context(attrs: IAttributeContainer)
		open var dmgFromMeleeIncreased: Number? 
			get() = WeaponBaseAttributes.dmgFromMeleeIncreased.get()
			set(value) { WeaponBaseAttributes.dmgFromMeleeIncreased.set(value) }
	
		/**
		 * In-Game: "N% damage from ranged sources while active"
		 * 
		 * Multiplier applied to incoming blast, bullet, buckshot, ignite, and sonic damage.
		 */
		context(attrs: IAttributeContainer)
		open var dmgFromRangedReduced: Number? 
			get() = WeaponBaseAttributes.dmgFromRangedReduced.get()
			set(value) { WeaponBaseAttributes.dmgFromRangedReduced.set(value) }
	
		/**
		 * In-Game: "No self inflicted blast damage taken"
		 * 
		 * Also forces the "whistling" sound to play when rocket jumping.
		 */
		context(attrs: IAttributeContainer)
		open var noSelfBlastDmg: Boolean? 
			get() = WeaponBaseAttributes.noSelfBlastDmg.get()
			set(value) { WeaponBaseAttributes.noSelfBlastDmg.set(value) }
	
		/**
		 * In-Game: "+N% damage to self"
		 * 
		 * Multiplier applied to blast damage taken from an explosion caused by said entity.
		 */
		context(attrs: IAttributeContainer)
		open var blastDmgToSelfIncreased: Number? 
			get() = WeaponBaseAttributes.blastDmgToSelfIncreased.get()
			set(value) { WeaponBaseAttributes.blastDmgToSelfIncreased.set(value) }
	
		/**
		 * In-Game: "+N% fire damage resistance while deployed"
		 * 
		 * Resist this proportion of fire damage only while this weapon is active.
		 */
		context(attrs: IAttributeContainer)
		open var dmgTakenFromFireReducedOnActive: Number? 
			get() = WeaponBaseAttributes.dmgTakenFromFireReducedOnActive.get()
			set(value) { WeaponBaseAttributes.dmgTakenFromFireReducedOnActive.set(value) }
	
		/**
		 * In-Game: "+N% damage vulnerability while active"
		 * 
		 * Increases damage taken while minicrit-boosted by Crit-a-Cola, Buffalo Steak, etc.
		 */
		context(attrs: IAttributeContainer)
		open var energyBuffDmgTakenMultiplier: Number? 
			get() = WeaponBaseAttributes.energyBuffDmgTakenMultiplier.get()
			set(value) { WeaponBaseAttributes.energyBuffDmgTakenMultiplier.set(value) }
	
		/**
		 * In-Game: "The wearer cannot be killed by headshots"
		 * 
		 * When a headshot would kill you, reduce health to 1.
		 */
		context(attrs: IAttributeContainer)
		open var setBonusNoDeathFromHeadshots: Boolean? 
			get() = WeaponBaseAttributes.setBonusNoDeathFromHeadshots.get()
			set(value) { WeaponBaseAttributes.setBonusNoDeathFromHeadshots.set(value) }
	}
	
	open class RevengeCritsAttributes : IBlockScoped {
		companion object : IBlockScoped 
	
		/**
		 * In-Game: "Gives one guaranteed critical hit for each building destroyed with your sapper attached or backstab kill"
		 * 
		 * Weapon supports revenge crits if this, `extinguish_revenge`, or `sentry_killed_revenge` is set.
		 */
		context(attrs: IAttributeContainer)
		open var sapperKillsCollectCrits: Boolean? 
			get() = WeaponBaseAttributes.sapperKillsCollectCrits.get()
			set(value) { WeaponBaseAttributes.sapperKillsCollectCrits.set(value) }
	
		/**
		 * In-Game: "Alt-Fire: Extinguish teammates to gain guaranteed critical hits"
		 * 
		 * Weapon supports revenge crits if this, `sapper_kills_collect_crits`, or `sentry_killed_revenge` is set.
		 */
		context(attrs: IAttributeContainer)
		open var extinguishEarnsRevengeCrits: Boolean? 
			get() = WeaponBaseAttributes.extinguishEarnsRevengeCrits.get()
			set(value) { WeaponBaseAttributes.extinguishEarnsRevengeCrits.set(value) }
	
		/**
		 * In-Game: "Gain 2 revenge crits for each sentry kill and 1 for each sentry assist when your sentry is destroyed."
		 * 
		 * Weapon supports revenge crits if this, `sapper_kills_collect_crits`, or `extinguish_revenge` is set.
		 */
		context(attrs: IAttributeContainer)
		open var canGainRevengeCrits: Boolean? 
			get() = WeaponBaseAttributes.canGainRevengeCrits.get()
			set(value) { WeaponBaseAttributes.canGainRevengeCrits.set(value) }
	}
	
	open class StatusEffectsAttributes : IBlockScoped {
		companion object : IBlockScoped 
	
		/**
		 * In-Game: "Ignited enemies explode"
		 * 
		 * Applies when *any weapon* with this attribute is in the second loadout slot of the player who covered someone in gas.  This attribute does not specifically check for the Gas Passer.  For example, if a Soldier has a rocket launcher that applies `TF_COND_GAS` and their shotgun in their secondary has this attribute, they'll still explode on ignite.
		 * 
		 * Only the afterburn specifically checks for the Gas Passer.
		 */
		context(attrs: IAttributeContainer)
		open var explodeOnIgnite: Boolean? 
			get() = WeaponBaseAttributes.explodeOnIgnite.get()
			set(value) { WeaponBaseAttributes.explodeOnIgnite.set(value) }
	}
	
	open class TauntingAttributes : IBlockScoped {
		companion object : IBlockScoped 
	
		/**
		 * In-Game: "Alt-Fire: Applies a healing effect to all nearby teammates"
		 * 
		 * Makes default weapon taunt perform the Amputator radial healing effect.
		 */
		context(attrs: IAttributeContainer)
		open var enablesAoeHeal: Boolean? 
			get() = WeaponBaseAttributes.enablesAoeHeal.get()
			set(value) { WeaponBaseAttributes.enablesAoeHeal.set(value) }
	
		/**
		 * If true, prevents holiday taunts from being used.
		 */
		context(attrs: IAttributeContainer)
		open var specialTaunt: Boolean? 
			get() = WeaponBaseAttributes.specialTaunt.get()
			set(value) { WeaponBaseAttributes.specialTaunt.set(value) }
	}
	
	open class SwapWeaponsAttributes : IBlockScoped {
		companion object : IBlockScoped {
			val deploy: DeployAttributes = DeployAttributes()
		}
	
		/**
		 * In-Game: "When weapon is active:"
		 * 
		 * If true, only applies attributes when weapon is active, and unapplies them when switching off.
		 * 
		 * I think this also means you can't have "only active when holding weapon" and "always active" attributes on the same weapon, since the order you specify attributes in doesn't matter.
		 */
		context(attrs: IAttributeContainer)
		open var provideOnActive: Boolean? 
			get() = WeaponBaseAttributes.provideOnActive.get()
			set(value) { WeaponBaseAttributes.provideOnActive.set(value) }
	
		/**
		 * In-Game: "While not being healed by a medic, your weapon switch time is N% longer"
		 * 
		 * Multiplier applied if NOT being healed by a medic.
		 * 
		 * Checked on player.
		 */
		context(attrs: IAttributeContainer)
		open var medicHealedDeployTimePenalty: Number? 
			get() = WeaponBaseAttributes.medicHealedDeployTimePenalty.get()
			set(value) { WeaponBaseAttributes.medicHealedDeployTimePenalty.set(value) }
	
		/**
		 * Should force switch to this item when your current weapon is unavailable?.
		 */
		context(attrs: IAttributeContainer)
		open var forceWeaponSwitch: Boolean? 
			get() = WeaponBaseAttributes.forceWeaponSwitch.get()
			set(value) { WeaponBaseAttributes.forceWeaponSwitch.set(value) }
	
		/**
		 * In-Game: "Honorbound: Once drawn sheathing deals 50 damage to yourself unless it kills."
		 * 
		 * Takes 50 health when holstering before it gets a kill.
		 */
		context(attrs: IAttributeContainer)
		open var honorbound: Boolean? 
			get() = WeaponBaseAttributes.honorbound.get()
			set(value) { WeaponBaseAttributes.honorbound.set(value) }
	
		/**
		 * If greater than 0 (like with the Thermal Thruster), takes that amount of time to holster BEFORE actually swapping weapons.
		 */
		context(attrs: IAttributeContainer)
		open var holsterAnimTime: Number? 
			get() = WeaponBaseAttributes.holsterAnimTime.get()
			set(value) { WeaponBaseAttributes.holsterAnimTime.set(value) }
	
		open val deploy: DeployAttributes = DeployAttributes()
	
		open class DeployAttributes : IBlockScoped {
			companion object : IBlockScoped 
	
			/**
			 * Bonus:
			 * 
			 * 	- In-Game: "N% faster weapon switch"
			 * 
			 * Penalty:
			 * 
			 * 	- In-Game: "N% longer weapon switch"
			 */
			context(attrs: IAttributeContainer)
			open var deployTime: Number? 
				get() = WeaponBaseAttributes.deployTime.get()
				set(value) { WeaponBaseAttributes.deployTime.set(value) }
	
			/**
			 * Bonus:
			 * 
			 * 	- In-Game: "This weapon deploys N% faster"
			 * 
			 * Penalty:
			 * 
			 * 	- In-Game: "This weapon deploys N% slower"
			 */
			context(attrs: IAttributeContainer)
			open var singleWepDeployTime: Number? 
				get() = WeaponBaseAttributes.singleWepDeployTime.get()
				set(value) { WeaponBaseAttributes.singleWepDeployTime.set(value) }
	
			/**
			 * Bonus:
			 * 
			 * 	- In-Game: "This weapon holsters N% faster"
			 * 
			 * Penalty:
			 * 
			 * 	- In-Game: "This weapon holsters N% slower"
			 */
			context(attrs: IAttributeContainer)
			open var singleWepHolsterTime: Number? 
				get() = WeaponBaseAttributes.singleWepHolsterTime.get()
				set(value) { WeaponBaseAttributes.singleWepHolsterTime.set(value) }
		}
	}
	
	open class WhenHitAttributes : IBlockScoped {
		companion object : IBlockScoped 
	
		/**
		 * Knocks back attacker when wielder receives damage.
		 */
		context(attrs: IAttributeContainer)
		open var damageCausesAirblast: Boolean? 
			get() = WeaponBaseAttributes.damageCausesAirblast.get()
			set(value) { WeaponBaseAttributes.damageCausesAirblast.set(value) }
	}
	
	open class RagdollsAttributes : IBlockScoped {
		companion object : IBlockScoped 
	
		/**
		 * In-Game: "Killing an enemy with a critical hit will dismember your victim. Painfully."
		 */
		context(attrs: IAttributeContainer)
		open var critKillWillGib: Boolean? 
			get() = WeaponBaseAttributes.critKillWillGib.get()
			set(value) { WeaponBaseAttributes.critKillWillGib.set(value) }
	
		/**
		 * If false, this weapon can only gib if it deals blast damage or over half of its damage falloff.
		 */
		context(attrs: IAttributeContainer)
		open var critOnHardHit: Boolean? 
			get() = WeaponBaseAttributes.critOnHardHit.get()
			set(value) { WeaponBaseAttributes.critOnHardHit.set(value) }
	
		/**
		 * In-Game: "Backstab turns victim to ice"
		 * 
		 * Upon killing an enemy with a backstab, replace their ragdoll with an ice statue.
		 */
		context(attrs: IAttributeContainer)
		open var freezeBackstabVictim: Boolean? 
			get() = WeaponBaseAttributes.freezeBackstabVictim.get()
			set(value) { WeaponBaseAttributes.freezeBackstabVictim.set(value) }
	
		/**
		 * In-Game: "Imbued with an ancient power"
		 * 
		 * Saxxy/golden pan effect.
		 */
		context(attrs: IAttributeContainer)
		open var turnToGold: Boolean? 
			get() = WeaponBaseAttributes.turnToGold.get()
			set(value) { WeaponBaseAttributes.turnToGold.set(value) }
	
		/**
		 * Flamethrower kills.
		 */
		context(attrs: IAttributeContainer)
		open var ragdollsBecomeAsh: Boolean? 
			get() = WeaponBaseAttributes.ragdollsBecomeAsh.get()
			set(value) { WeaponBaseAttributes.ragdollsBecomeAsh.set(value) }
	
		/**
		 * Phlogistinator kills.
		 */
		context(attrs: IAttributeContainer)
		open var ragdollsPlasmaEffect: Boolean? 
			get() = WeaponBaseAttributes.ragdollsPlasmaEffect.get()
			set(value) { WeaponBaseAttributes.ragdollsPlasmaEffect.set(value) }
	}
	
	open class DisguiseAttributes : BaseCombatWeaponAttributes.DisguiseAttributes() 
}