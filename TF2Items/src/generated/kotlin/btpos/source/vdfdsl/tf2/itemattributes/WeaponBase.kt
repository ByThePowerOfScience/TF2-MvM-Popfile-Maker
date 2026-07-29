package btpos.source.vdfdsl.tf2.itemattributes

import btpos.source.vdfdsl.modeling.*
import btpos.source.vdfdsl.serialization.codecs.*
import btpos.source.vdfdsl.tf2.itemattributes.impl.*
import btpos.source.vdfdsl.tf2.tftypes.*
import java.util.*




interface WeaponBaseAttributes : BaseCombatWeaponAttributes {
	
	companion object {
		/**
		 * In-Game: "Ammo boxes collected also give Charge"
		 * 
		 * If true, and player has a demoman charge meter, add charge based on ammo pack size.
		 */
		val ammoPacksGiveDemoknightCharge: ItemAttributeNamed<Boolean> = ItemAttributeNamed("ammo gives charge")
	
		/**
		 * In-Game: "No ammo from dispensers when active"
		 */
		val noPrimaryAmmoFromDispensersWhileActive: ItemAttributeNamed<Boolean> = ItemAttributeNamed("no primary ammo from dispensers while active")
	
		/**
		 * In-Game: "No metal from dispensers when active."
		 */
		val noMetalFromDispensersWhileActive: ItemAttributeNamed<Boolean> = ItemAttributeNamed("no metal from dispensers while active")
	
		val dmgVsBuildings: VisHidden<Float> = VisHidden(ItemAttributeNamed<Float>("dmg bonus vs buildings"), ItemAttributeNamed<Float>("dmg penalty vs buildings"))
	
		val clipSize: BonusPenaltyHidden<Float, ItemAttributeNamed<Float>> = BonusPenaltyHidden(
			ItemAttributeNamed<Float>("clip size bonus"),
			ItemAttributeNamed<Float>("clip size penalty"),
			ItemAttributeNamed<Float>("clip size penalty HIDDEN"),
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
		 * In-Game: "Replaces the Sentry with a Mini-Sentry"
		 * 
		 * Determines the hand used in the model.
		 */
		val wrenchBuildsMinisentry: ItemAttributeNamed<Boolean> = ItemAttributeNamed("mod wrench builds minisentry")
	
		val deployTime: BonusPenalty<Float> = BonusPenalty(
			ItemAttributeNamed("deploy time decreased"),
			ItemAttributeNamed("deploy time increased"),
		)
	
		val singleWepDeployTime: BonusPenalty<Float> = BonusPenalty(
			ItemAttributeNamed("single wep deploy time decreased"),
			ItemAttributeNamed("single wep deploy time increased"),
		)
	
		val singleWepHolsterTime: BonusPenalty<Float> = BonusPenalty(
			ItemAttributeNamed("switch from wep deploy time decreased"),
			ItemAttributeNamed("single wep holster time increased"),
		)
	
		/**
		 * In-Game: "This Weapon has a large melee range and deploys and holsters slower"
		 * 
		 * If true, make weapon deploy and holster 75% slower.
		 */
		val isASword: ItemAttributeNamed<Boolean> = ItemAttributeNamed("is_a_sword")
	
		/**
		 * In-Game: "While not being healed by a medic, your weapon switch time is N% longer"
		 * 
		 * Multiplier applied if NOT being healed by a medic.
		 * 
		 * Checked on player.
		 */
		val medicHealedDeployTimePenalty: ItemAttributeNamed<Float> = ItemAttributeNamed("mod medic healed deploy time penalty")
	
		/**
		 * Should force switch to this item when... something happens.  Probably when your current weapon is unavailable?.
		 */
		val forceWeaponSwitch: ItemAttributeNamed<Boolean> = ItemAttributeNamed("force weapon switch")
	
		/**
		 * In-Game: "When weapon is active:"
		 * 
		 * If true, only applies attributes when weapon is active, and unapplies them when switching off.
		 * 
		 * I think this also means you can't have "only active when holding weapon" and "always active" attributes on the same weapon, since the order you specify attributes in doesn't matter.
		 */
		val provideOnActive: ItemAttributeNamed<Boolean> = ItemAttributeNamed("provide on active")
	
		val projectilePenetration: ProjectilePenetrationAttributes = ProjectilePenetrationAttributes()
	
		/**
		 * In-Game: "+N% bullets per shot"
		 */
		val bulletsPerShotBonus: ItemAttributeNamed<Float> = ItemAttributeNamed("bullets per shot bonus")
	
		val damage: DamageAttributes = DamageAttributes()
	
		val critChance: VisHidden<Float> = VisHidden(ItemAttributeNamed<Float>("crit mod disabled"), ItemAttributeNamed<Float>("crit mod disabled hidden"))
	
		val autoFiresFullClip: BonusPenalty<Boolean> = BonusPenalty(
			ItemAttributeNamed("auto fires full clip"),
			ItemAttributeNamed("auto fires full clip penalty"),
		)
	
		val autoFiresFullClipAllAtOnce: ItemAttributeNamed<Boolean> = ItemAttributeNamed("auto fires full clip all at once")
	
		/**
		 * In-Game: "Overloading the chamber will cause a misfire"
		 * 
		 * Deals damage to the player when overloaded.
		 */
		val canOverload: ItemAttributeNamed<Boolean> = ItemAttributeNamed("can overload")
	
		val fireRate: FireRateAttributes = FireRateAttributes()
	
		val autoFiresWhenFull: ItemAttributeNamed<Boolean> = ItemAttributeNamed("auto fires when full")
	
		val reloadTime: BonusPenalty<Float> = BonusPenalty(
			ItemAttributeNamed("Reload time decreased"),
			ItemAttributeNamed("Reload time increased"),
		)
	
		/**
		 * In-Game: "N% slower reload time"
		 */
		val reloadTimeIncreasedHidden: ItemAttributeNamed<Float> = ItemAttributeNamed("reload time increased hidden")
	
		/**
		 * In-Game: "+N% faster reload time"
		 * 
		 * This is what's used for weapons that draw directly from reserve ammo, like the flare gun and sniper rifle.
		 */
		val fasterReloadRate: ItemAttributeNamed<Float> = ItemAttributeNamed("faster reload rate")
	
		/**
		 * Halloween reload time multiplier.
		 * 
		 * Checked on player.
		 */
		val halloweenReloadTimeDecreased: ItemAttributeNamed<Float> = ItemAttributeNamed("halloween reload time decreased")
	
		/**
		 * In-Game: "N% faster reload time while being healed"
		 */
		val reloadTimeDecreasedWhileHealed: ItemAttributeNamed<Float> = ItemAttributeNamed("reload time decreased while healed")
	
		val weaponAllowInspect: ItemAttributeNamed<Boolean> = ItemAttributeNamed("weapon_allow_inspect")
	
		val onHit: OnHitAttributes = OnHitAttributes()
	
		/**
		 * In-Game: "On Hit by Fire: Fireproof for 1 second and Afterburn immunity for N seconds"
		 * 
		 * Addcond parameter.
		 */
		val becomeFireproofOnHitByFire: ItemAttributeNamed<Float> = ItemAttributeNamed("become fireproof on hit by fire")
	
		val centerfireProjectile: ItemAttributeNamed<Boolean> = ItemAttributeNamed("centerfire projectile")
	
		/**
		 * In-Game: "+N degrees random projectile deviation"
		 * 
		 * Does not include bullets.
		 */
		val projectileSpreadAnglePenalty: ItemAttributeNamed<Float> = ItemAttributeNamed("projectile spread angle penalty")
	
		val activeHealthDegen: BonusPenalty<Float> = BonusPenalty(
			ItemAttributeNamed("active health regen"),
			ItemAttributeNamed("active health degen"),
		)
	
		/**
		 * Strange part kills with this weapon should contribute to.
		 */
		val killEaterKillType: ItemAttributeNamed<Int> = ItemAttributeNamed("kill eater kill type")
	
		/**
		 * In-Game: "Silent Killer: No attack noise from backstabs"
		 * 
		 * Kills will not show up in the killfeed.
		 */
		val silentKiller: ItemAttributeNamed<Boolean> = ItemAttributeNamed("silent killer")
	
		/**
		 * In-Game: "Cannot be crit boosted"
		 * 
		 * Can't be crit-boosted.
		 */
		val noCritBoost: ItemAttributeNamed<Boolean> = ItemAttributeNamed("no crit boost")
	
		val revengeCrits: RevengeCritsAttributes = RevengeCritsAttributes()
	
		/**
		 * In-Game: "Honorbound: Once drawn sheathing deals 50 damage to yourself unless it kills."
		 * 
		 * Takes 50 health when holstering before it gets a kill.
		 */
		val honorbound: ItemAttributeNamed<Boolean> = ItemAttributeNamed("honorbound")
	
		val weaponStattrakModuleScale: ItemAttributeNamed<Float> = ItemAttributeNamed("weapon_stattrak_module_scale")
	
		val minViewmodelOffset: ItemAttributeNamed<String> = ItemAttributeNamed("min_viewmodel_offset")
	
		/**
		 * In-Game: "+N% increase in recharge rate"
		 * 
		 * Things like throwable recharge timers, jetpack charging, etc. How much it recharges per... some amount of time.
		 */
		val effectBarRechargeRateIncreased: ItemAttributeNamed<Float> = ItemAttributeNamed("effect bar recharge rate increased")
	
		/**
		 * In-Game: "Blocks healing while in use"
		 * 
		 * Prevents mediguns from latching onto you.
		 */
		val weaponBlocksHealing: ItemAttributeNamed<Boolean> = ItemAttributeNamed("mod weapon blocks healing")
	
		/**
		 * In-Game: "+N% ÜberCharge rate for the medic healing you This effect does not work in the respawn room"
		 * 
		 * Multiplier applied to your healer's ubercharge rate.
		 * 
		 * NOTE: Only applied if user is outside of the respawn room.
		 */
		val uberchargeRateBonusForHealer: ItemAttributeNamed<Float> = ItemAttributeNamed("ubercharge rate bonus for healer")
	
		/**
		 * In-Game: "+N% greater jump height when active"
		 * 
		 * One of the "only when weapon is active" kind of attributes.  These always only work if the weapon that provides them is active, while still allowing other attributes to be globally-applied.
		 */
		val increasedJumpHeightFromWeapon: ItemAttributeNamed<Float> = ItemAttributeNamed("increased jump height from weapon")
	
		/**
		 * In-Game: "On Hit: Gain up to +N health per attack"
		 * 
		 * Maximum amount of health that can be gained from an AoE damage source.  Health received is multiplied by `damage dealt / base damage of the weapon`, to a max of 100% of the defined value.
		 */
		val healthOnRadiusDamage: ItemAttributeNamed<Int> = ItemAttributeNamed("health on radius damage")
	
		/**
		 * In-Game: "Attacks pierce damage resistance effects and bonuses"
		 */
		val dmgPiercesResistsAbsorbs: ItemAttributeNamed<Boolean> = ItemAttributeNamed("dmg pierces resists absorbs")
	
		val critVsBurningPlayers: CritVsBurningPlayersAttributes = CritVsBurningPlayersAttributes()
	
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
		 * In-Game: "Grants Triple Jump while deployed. Melee attacks mini-crit while airborne."
		 * 
		 * If greater than 0, attacks minicrit while airborne.
		 * 
		 * Only procs on Scout.
		 */
		val airDashCount: ItemAttributeNamed<Int> = ItemAttributeNamed("air dash count")
	
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
		val miniCritAirborne: ItemAttributeNamed<Boolean> = ItemAttributeNamed("mod mini-crit airborne")
	
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
		 * In-Game: "N% damage vs players"
		 */
		val dmgPenaltyVsPlayers: ItemAttributeNamed<Float> = ItemAttributeNamed("dmg penalty vs players")
	
		/**
		 * In-Game: "No critical hits vs non-burning players"
		 * 
		 * Note: Even prevents criticals when crit-boosted.
		 */
		val noCritVsNonburning: ItemAttributeNamed<Boolean> = ItemAttributeNamed("no crit vs nonburning")
	
		/**
		 * In-Game: "N% damage vs non-burning players"
		 */
		val dmgPenaltyVsNonburning: ItemAttributeNamed<Float> = ItemAttributeNamed("dmg penalty vs nonburning")
	
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
	
		/**
		 * In-Game: "+N% damage vulnerability while active"
		 * 
		 * Increases damage taken while minicrit-boosted by Crit-a-Cola, Buffalo Steak, etc.
		 */
		val energyBuffDmgTakenMultiplier: ItemAttributeNamed<Float> = ItemAttributeNamed("energy buff dmg taken multiplier")
	
		/**
		 * In-Game: "+N% cloak on hit"
		 * 
		 * Adds this amount of cloak on hit.
		 * 
		 * Only procs on Spy.
		 */
		val addCloakOnHit: ItemAttributeNamed<Int> = ItemAttributeNamed("add cloak on hit")
	
		/**
		 * In-Game: "On Hit: target is engulfed in flames"
		 * 
		 * Ignites player on hit.
		 */
		val setDamagetypeIgnite: ItemAttributeNamed<Boolean> = ItemAttributeNamed("Set DamageType Ignite")
	
		/**
		 * In-Game: "+N% fire damage resistance while deployed"
		 * 
		 * Gain fire resistance only when this weapon is active.
		 */
		val dmgTakenFromFireReducedOnActive: ItemAttributeNamed<Float> = ItemAttributeNamed("dmg taken from fire reduced on active")
	
		/**
		 * In-Game: "N% damage bonus vs burning players"
		 */
		val damageBonusVsBurning: ItemAttributeNamed<Float> = ItemAttributeNamed("damage bonus vs burning")
	
		/**
		 * In-Game: "N% damage vulnerability on wearer"
		 */
		val multDmgtakenActive: ItemAttributeNamed<Float> = ItemAttributeNamed("mult_dmgtaken_active")
	
		/**
		 * In-Game: "+N% damage from melee sources while active"
		 */
		val dmgFromMeleeIncreased: ItemAttributeNamed<Float> = ItemAttributeNamed("dmg from melee increased")
	
		/**
		 * In-Game: "N% damage from ranged sources while active"
		 * 
		 * Applies to blast, bullet, buckshot, ignite, and sonic damage types.
		 */
		val dmgFromRangedReduced: ItemAttributeNamed<Float> = ItemAttributeNamed("dmg from ranged reduced")
	
		/**
		 * In-Game: "No self inflicted blast damage taken"
		 */
		val noSelfBlastDmg: ItemAttributeNamed<Boolean> = ItemAttributeNamed("no self blast dmg")
	
		/**
		 * In-Game: "+N% damage to self"
		 * 
		 * Multiplier applied to blast damage taken from an explosion caused by said entity.
		 */
		val blastDmgToSelfIncreased: ItemAttributeNamed<Float> = ItemAttributeNamed("blast dmg to self increased")
	
		/**
		 * Used for killfeed.
		 */
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
		 * In-Game: "N% health from healers on wearer"
		 * 
		 * Attribute class is a flat multiplier applied to health from healers while weapon is active.
		 */
		val multHealthFromhealersPenaltyActive: ItemAttributeNamed<Float> = ItemAttributeNamed("mult_health_fromhealers_penalty_active")
	
		/**
		 * In-Game: "N% Overheal build rate."
		 * 
		 * Checked on the player that is healing an entity.
		 */
		val overhealFillRateReduced: ItemAttributeNamed<Float> = ItemAttributeNamed("overheal fill rate reduced")
	
		/**
		 * In-Game: "N% less healing from Medic sources"
		 * 
		 * Applies to all non-dispenser forms of healing that apply the `TF_COND_HEAL_BUFF` status.
		 */
		val reducedHealingFromMedics: ItemAttributeNamed<Float> = ItemAttributeNamed("reduced_healing_from_medics")
	
		val weaponBurnDmgReduced: BonusPenalty<Float> = BonusPenalty(
			ItemAttributeNamed("weapon burn dmg increased"),
			ItemAttributeNamed("weapon burn dmg reduced"),
		)
	
		/**
		 * In-Game: "Halloween Fire"
		 * 
		 * Makes afterburn green.
		 */
		val spellHalloweenGreenFlames: ItemAttributeNamed<Boolean> = ItemAttributeNamed("SPELL: Halloween green flames")
	
		/**
		 * In-Game: "Syringes deliver a highly concentrated dose of Mad Milk. Duration increases per hit to a max of 4 seconds."
		 * 
		 * Duration of 4 seconds, and increases by 0.5 seconds each hit.
		 */
		val madMilkSyringes: ItemAttributeNamed<Boolean> = ItemAttributeNamed("mad milk syringes")
	
		/**
		 * In-Game: "Alt-Fire: Applies a healing effect to all nearby teammates"
		 * 
		 * Makes default weapon taunt perform the Amputator radial healing effect.
		 */
		val enablesAoeHeal: ItemAttributeNamed<Boolean> = ItemAttributeNamed("enables aoe heal")
	
		val weaponBurnTimeReduced: BonusPenalty<Float> = BonusPenalty(
			ItemAttributeNamed("weapon burn time increased"),
			ItemAttributeNamed("weapon burn time reduced"),
		)
	
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
		 * In-Game: "N% increased damage to your sentry's target"
		 */
		val damageBonusBulletVsSentryTarget: ItemAttributeNamed<Float> = ItemAttributeNamed("damage bonus bullet vs sentry target")
	
		/**
		 * In-Game: "On Full Charge: Projectiles penetrate players"
		 */
		val penetratesWhenFullyCharged: ItemAttributeNamed<Boolean> = ItemAttributeNamed("sniper penetrate players when charged")
	
		/**
		 * Multiplier applied to movement speed scaled by ubercharge percentage.
		 * 
		 * Only works if the player using this item is a Medic with a Medigun.
		 */
		val moveSpeedBonusResourceLevel: ItemAttributeNamed<Float> = ItemAttributeNamed("move speed bonus resource level")
	
		/**
		 * In-Game: "+N% faster move speed on wearer"
		 * 
		 * Multiplier applied to player movement speed only while this is the active weapon.
		 */
		val multPlayerMovespeedActive: ItemAttributeNamed<Float> = ItemAttributeNamed("mult_player_movespeed_active")
	
		/**
		 * If greater than 0 (like with the Thermal Thruster), takes that amount of time to holster BEFORE actually swapping weapons.
		 */
		val holsterAnimTime: ItemAttributeNamed<Float> = ItemAttributeNamed("holster_anim_time")
	
		/**
		 * In-Game: "Alt-Fire: Use N metal to pick up your targeted building from long range"
		 * 
		 * Metal cost to pick up a building at range.
		 * 
		 * Restricted to the default rescue ranger range, but can be used by any weapon.
		 */
		val engineerBuildingTeleportingPickup: ItemAttributeNamed<Int> = ItemAttributeNamed("engineer building teleporting pickup")
	
		/**
		 * In-Game: "N% damage on body shot"
		 * 
		 * Multiplier applied to bodyshot damage.
		 */
		val damagePenaltyOnBodyshot: ItemAttributeNamed<Float> = ItemAttributeNamed("damage penalty on bodyshot")
	
		val healingReceived: BonusPenalty<Float> = BonusPenalty(
			ItemAttributeNamed("healing received bonus"),
			ItemAttributeNamed("healing received penalty"),
		)
	
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
		val applyZVelocityOnDamage: ItemAttributeNamed<Float> = ItemAttributeNamed("apply z velocity on damage")
	
		/**
		 * Apply this amount of velocity in the direction you're facing to players hit with this weapon.
		 */
		val applyLookVelocityOnDamage: ItemAttributeNamed<Float> = ItemAttributeNamed("apply look velocity on damage")
	
		/**
		 * In-Game: "Ignited enemies explode"
		 * 
		 * Applies when *any weapon* with this attribute is in the second loadout slot of the player who covered someone in gas.  This attribute does not specifically check for the Gas Passer.  For example, f a Soldier has a rocket launcher that applies `TF_COND_GAS` and their shotgun in their secondary has this attribute, they'll still explode on ignite.
		 * 
		 * Only the afterburn specifically checks for the Gas Passer.
		 */
		val explodeOnIgnite: ItemAttributeNamed<Boolean> = ItemAttributeNamed("explode_on_ignite")
	
		val selfDmgPushForce: BonusPenalty<Float> = BonusPenalty(
			ItemAttributeNamed("self dmg push force increased"),
			ItemAttributeNamed("self dmg push force decreased"),
		)
	
		/**
		 * Knocks back attacker when wielder receives damage.
		 */
		val damageCausesAirblast: ItemAttributeNamed<Boolean> = ItemAttributeNamed("damage causes airblast")
	
		/**
		 * Push force applied to target when hitting an enemy.
		 * 
		 * Scales by range, to a minimum of 50% of the given value.
		 */
		val damageBlastPush: ItemAttributeNamed<Float> = ItemAttributeNamed("damage blast push")
	
		val damageForceReduction: DamageForceReductionAttributes = DamageForceReductionAttributes()
	
		/**
		 * In-Game: "On Hit: Bleed for N seconds"
		 * 
		 * Apply bleed on hit.
		 * 
		 * Value is a time in seconds.
		 */
		val bleedingDuration: ItemAttributeNamed<Float> = ItemAttributeNamed("bleeding duration")
	
		/**
		 * In-Game: "The wearer cannot be killed by headshots"
		 * 
		 * When a headshot would kill you, reduce health to 1.
		 */
		val setBonusNoDeathFromHeadshots: ItemAttributeNamed<Boolean> = ItemAttributeNamed("SET BONUS: no death from headshots")
	
		/**
		 * In-Game: "Increased headshot explosion radius and damage to nearby enemies"
		 * 
		 * Only applies if in a gamemode with upgrades, but applies to all headshots.
		 * 
		 * Also applies to any hitscan weapon with a `jarate_time` attribute that hit the head.
		 */
		val explosiveHeadshotLevel: ItemAttributeNamed<Boolean> = ItemAttributeNamed("explosive sniper shot")
	
		/**
		 * In-Game: "Killing an enemy with a critical hit will dismember your victim. Painfully."
		 */
		val critKillWillGib: ItemAttributeNamed<Boolean> = ItemAttributeNamed("crit kill will gib")
	
		/**
		 * If false, this weapon can only gib if it deals blast damage or half-falloff damage.
		 */
		val critOnHardHit: ItemAttributeNamed<Boolean> = ItemAttributeNamed("crit on hard hit")
	
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
		 * In-Game: "Exorcism"
		 * 
		 * Exorcism spell effect.
		 */
		val spellHalloweenDeathGhosts: ItemAttributeNamed<Boolean> = ItemAttributeNamed("SPELL: Halloween death ghosts")
	
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
		 * In-Game: "Maximum health is drained while item is active"
		 * 
		 * Maximum health decrease per tick while weapon is active. (Gloves of Running Urgently/Eviction Notice).
		 */
		val maxhealthDrainRate: ItemAttributeNamed<Float> = ItemAttributeNamed("mod_maxhealth_drain_rate")
	
		/**
		 * If true, prevents holiday taunts from being used.
		 */
		val specialTaunt: ItemAttributeNamed<Boolean> = ItemAttributeNamed("special taunt")
	
		val ragdolls: RagdollsAttributes = RagdollsAttributes()
	}

	/**
	 * In-Game: "Ammo boxes collected also give Charge"
	 * 
	 * If true, and player has a demoman charge meter, add charge based on ammo pack size.
	 */
	val ammoPacksGiveDemoknightCharge: ItemAttributeNamed<Boolean> get() = WeaponBaseAttributes.ammoPacksGiveDemoknightCharge
	
	/**
	 * In-Game: "No ammo from dispensers when active"
	 */
	val noPrimaryAmmoFromDispensersWhileActive: ItemAttributeNamed<Boolean> get() = WeaponBaseAttributes.noPrimaryAmmoFromDispensersWhileActive
	
	/**
	 * In-Game: "No metal from dispensers when active."
	 */
	val noMetalFromDispensersWhileActive: ItemAttributeNamed<Boolean> get() = WeaponBaseAttributes.noMetalFromDispensersWhileActive
	
	val dmgVsBuildings: VisHidden<Float> get() = WeaponBaseAttributes.dmgVsBuildings
	
	val clipSize: BonusPenaltyHidden<Float, ItemAttributeNamed<Float>> get() = WeaponBaseAttributes.clipSize
	
	/**
	 * In-Game: "+N% clip size"
	 */
	val clipSizeBonusUpgrade: ItemAttributeNamed<Int> get() = WeaponBaseAttributes.clipSizeBonusUpgrade
	
	/**
	 * In-Game: "+N clip size"
	 * 
	 * MVM attribute that specifically handles rocket and grenade launchers.
	 * 
	 * Note that all three of these are different classes, which means they stack.
	 */
	val clipSizeUpgradeAtomic: ItemAttributeNamed<Int> get() = WeaponBaseAttributes.clipSizeUpgradeAtomic
	
	/**
	 * In-Game: "Clip size increased on kill"
	 */
	val clipsizeIncreaseOnKill: ItemAttributeNamed<Int> get() = WeaponBaseAttributes.clipsizeIncreaseOnKill
	
	/**
	 * In-Game: "Replaces the Sentry with a Mini-Sentry"
	 * 
	 * Determines the hand used in the model.
	 */
	val wrenchBuildsMinisentry: ItemAttributeNamed<Boolean> get() = WeaponBaseAttributes.wrenchBuildsMinisentry
	
	val deployTime: BonusPenalty<Float> get() = WeaponBaseAttributes.deployTime
	
	val singleWepDeployTime: BonusPenalty<Float> get() = WeaponBaseAttributes.singleWepDeployTime
	
	val singleWepHolsterTime: BonusPenalty<Float> get() = WeaponBaseAttributes.singleWepHolsterTime
	
	/**
	 * In-Game: "This Weapon has a large melee range and deploys and holsters slower"
	 * 
	 * If true, make weapon deploy and holster 75% slower.
	 */
	val isASword: ItemAttributeNamed<Boolean> get() = WeaponBaseAttributes.isASword
	
	/**
	 * In-Game: "While not being healed by a medic, your weapon switch time is N% longer"
	 * 
	 * Multiplier applied if NOT being healed by a medic.
	 * 
	 * Checked on player.
	 */
	val medicHealedDeployTimePenalty: ItemAttributeNamed<Float> get() = WeaponBaseAttributes.medicHealedDeployTimePenalty
	
	/**
	 * Should force switch to this item when... something happens.  Probably when your current weapon is unavailable?.
	 */
	val forceWeaponSwitch: ItemAttributeNamed<Boolean> get() = WeaponBaseAttributes.forceWeaponSwitch
	
	/**
	 * In-Game: "When weapon is active:"
	 * 
	 * If true, only applies attributes when weapon is active, and unapplies them when switching off.
	 * 
	 * I think this also means you can't have "only active when holding weapon" and "always active" attributes on the same weapon, since the order you specify attributes in doesn't matter.
	 */
	val provideOnActive: ItemAttributeNamed<Boolean> get() = WeaponBaseAttributes.provideOnActive
	
	val projectilePenetration: ProjectilePenetrationAttributes get() = WeaponBaseAttributes.projectilePenetration
	
	/**
	 * In-Game: "+N% bullets per shot"
	 */
	val bulletsPerShotBonus: ItemAttributeNamed<Float> get() = WeaponBaseAttributes.bulletsPerShotBonus
	
	val damage: DamageAttributes get() = WeaponBaseAttributes.damage
	
	val critChance: VisHidden<Float> get() = WeaponBaseAttributes.critChance
	
	val autoFiresFullClip: BonusPenalty<Boolean> get() = WeaponBaseAttributes.autoFiresFullClip
	
	val autoFiresFullClipAllAtOnce: ItemAttributeNamed<Boolean> get() = WeaponBaseAttributes.autoFiresFullClipAllAtOnce
	
	/**
	 * In-Game: "Overloading the chamber will cause a misfire"
	 * 
	 * Deals damage to the player when overloaded.
	 */
	val canOverload: ItemAttributeNamed<Boolean> get() = WeaponBaseAttributes.canOverload
	
	val fireRate: FireRateAttributes get() = WeaponBaseAttributes.fireRate
	
	val autoFiresWhenFull: ItemAttributeNamed<Boolean> get() = WeaponBaseAttributes.autoFiresWhenFull
	
	val reloadTime: BonusPenalty<Float> get() = WeaponBaseAttributes.reloadTime
	
	/**
	 * In-Game: "N% slower reload time"
	 */
	val reloadTimeIncreasedHidden: ItemAttributeNamed<Float> get() = WeaponBaseAttributes.reloadTimeIncreasedHidden
	
	/**
	 * In-Game: "+N% faster reload time"
	 * 
	 * This is what's used for weapons that draw directly from reserve ammo, like the flare gun and sniper rifle.
	 */
	val fasterReloadRate: ItemAttributeNamed<Float> get() = WeaponBaseAttributes.fasterReloadRate
	
	/**
	 * Halloween reload time multiplier.
	 * 
	 * Checked on player.
	 */
	val halloweenReloadTimeDecreased: ItemAttributeNamed<Float> get() = WeaponBaseAttributes.halloweenReloadTimeDecreased
	
	/**
	 * In-Game: "N% faster reload time while being healed"
	 */
	val reloadTimeDecreasedWhileHealed: ItemAttributeNamed<Float> get() = WeaponBaseAttributes.reloadTimeDecreasedWhileHealed
	
	val weaponAllowInspect: ItemAttributeNamed<Boolean> get() = WeaponBaseAttributes.weaponAllowInspect
	
	val onHit: OnHitAttributes get() = WeaponBaseAttributes.onHit
	
	/**
	 * In-Game: "On Hit by Fire: Fireproof for 1 second and Afterburn immunity for N seconds"
	 * 
	 * Addcond parameter.
	 */
	val becomeFireproofOnHitByFire: ItemAttributeNamed<Float> get() = WeaponBaseAttributes.becomeFireproofOnHitByFire
	
	val centerfireProjectile: ItemAttributeNamed<Boolean> get() = WeaponBaseAttributes.centerfireProjectile
	
	/**
	 * In-Game: "+N degrees random projectile deviation"
	 * 
	 * Does not include bullets.
	 */
	val projectileSpreadAnglePenalty: ItemAttributeNamed<Float> get() = WeaponBaseAttributes.projectileSpreadAnglePenalty
	
	val activeHealthDegen: BonusPenalty<Float> get() = WeaponBaseAttributes.activeHealthDegen
	
	/**
	 * Strange part kills with this weapon should contribute to.
	 */
	val killEaterKillType: ItemAttributeNamed<Int> get() = WeaponBaseAttributes.killEaterKillType
	
	/**
	 * In-Game: "Silent Killer: No attack noise from backstabs"
	 * 
	 * Kills will not show up in the killfeed.
	 */
	val silentKiller: ItemAttributeNamed<Boolean> get() = WeaponBaseAttributes.silentKiller
	
	/**
	 * In-Game: "Cannot be crit boosted"
	 * 
	 * Can't be crit-boosted.
	 */
	val noCritBoost: ItemAttributeNamed<Boolean> get() = WeaponBaseAttributes.noCritBoost
	
	val revengeCrits: RevengeCritsAttributes get() = WeaponBaseAttributes.revengeCrits
	
	/**
	 * In-Game: "Honorbound: Once drawn sheathing deals 50 damage to yourself unless it kills."
	 * 
	 * Takes 50 health when holstering before it gets a kill.
	 */
	val honorbound: ItemAttributeNamed<Boolean> get() = WeaponBaseAttributes.honorbound
	
	val weaponStattrakModuleScale: ItemAttributeNamed<Float> get() = WeaponBaseAttributes.weaponStattrakModuleScale
	
	val minViewmodelOffset: ItemAttributeNamed<String> get() = WeaponBaseAttributes.minViewmodelOffset
	
	/**
	 * In-Game: "+N% increase in recharge rate"
	 * 
	 * Things like throwable recharge timers, jetpack charging, etc. How much it recharges per... some amount of time.
	 */
	val effectBarRechargeRateIncreased: ItemAttributeNamed<Float> get() = WeaponBaseAttributes.effectBarRechargeRateIncreased
	
	/**
	 * In-Game: "Blocks healing while in use"
	 * 
	 * Prevents mediguns from latching onto you.
	 */
	val weaponBlocksHealing: ItemAttributeNamed<Boolean> get() = WeaponBaseAttributes.weaponBlocksHealing
	
	/**
	 * In-Game: "+N% ÜberCharge rate for the medic healing you This effect does not work in the respawn room"
	 * 
	 * Multiplier applied to your healer's ubercharge rate.
	 * 
	 * NOTE: Only applied if user is outside of the respawn room.
	 */
	val uberchargeRateBonusForHealer: ItemAttributeNamed<Float> get() = WeaponBaseAttributes.uberchargeRateBonusForHealer
	
	/**
	 * In-Game: "+N% greater jump height when active"
	 * 
	 * One of the "only when weapon is active" kind of attributes.  These always only work if the weapon that provides them is active, while still allowing other attributes to be globally-applied.
	 */
	val increasedJumpHeightFromWeapon: ItemAttributeNamed<Float> get() = WeaponBaseAttributes.increasedJumpHeightFromWeapon
	
	/**
	 * In-Game: "On Hit: Gain up to +N health per attack"
	 * 
	 * Maximum amount of health that can be gained from an AoE damage source.  Health received is multiplied by `damage dealt / base damage of the weapon`, to a max of 100% of the defined value.
	 */
	val healthOnRadiusDamage: ItemAttributeNamed<Int> get() = WeaponBaseAttributes.healthOnRadiusDamage
	
	/**
	 * In-Game: "Attacks pierce damage resistance effects and bonuses"
	 */
	val dmgPiercesResistsAbsorbs: ItemAttributeNamed<Boolean> get() = WeaponBaseAttributes.dmgPiercesResistsAbsorbs
	
	val critVsBurningPlayers: CritVsBurningPlayersAttributes get() = WeaponBaseAttributes.critVsBurningPlayers
	
	/**
	 * In-Game: "100% critical hit vs wet players"
	 */
	val critVsWetPlayers: ItemAttributeNamed<Boolean> get() = WeaponBaseAttributes.critVsWetPlayers
	
	/**
	 * In-Game: "100% critical hit vs non-burning players"
	 * 
	 * Crit against players that DON'T have these conditions.
	 */
	val critVsNonBurningPlayers: ItemAttributeNamed<EnumSet<TFCritCondition>> get() = WeaponBaseAttributes.critVsNonBurningPlayers
	
	/**
	 * In-Game: "100% critical hits burning players from behind. Mini-crits burning players from the front."
	 * 
	 * On hitting a burning player, crit them from behind or minicrit them otherwise.
	 */
	val axtinguisherProperties: ItemAttributeNamed<Boolean> get() = WeaponBaseAttributes.axtinguisherProperties
	
	/**
	 * In-Game: "Deals crits while the wielder is rocket jumping"
	 * 
	 * Critical hit enemies if the player was launched into the air by an explosion.
	 * 
	 * Only works when not in Mannpower mode.
	 */
	val critWhileAirborne: ItemAttributeNamed<Boolean> get() = WeaponBaseAttributes.critWhileAirborne
	
	/**
	 * In-Game: "Mini-crits burning targets and extinguishes them. Damage increases based on remaining duration of afterburn. Killing blows on burning players grant a speed boost."
	 * 
	 * Only activates if the weapon deals `DMG_MELEE`.
	 */
	val attackMinicritsAndConsumesBurning: ItemAttributeNamed<Boolean> get() = WeaponBaseAttributes.attackMinicritsAndConsumesBurning
	
	/**
	 * In-Game: "Grants Triple Jump while deployed. Melee attacks mini-crit while airborne."
	 * 
	 * If greater than 0, attacks minicrit while airborne.
	 * 
	 * Only procs on Scout.
	 */
	val airDashCount: ItemAttributeNamed<Int> get() = WeaponBaseAttributes.airDashCount
	
	/**
	 * In-Game: "100% minicrits vs burning players"
	 * 
	 * Minicrits if the damage dealt is NOT `DMG_BURN`.
	 */
	val minicritVsBurningPlayer: ItemAttributeNamed<Boolean> get() = WeaponBaseAttributes.minicritVsBurningPlayer
	
	/**
	 * In-Game: "Mini-crits targets launched airborne by explosions, grapple hooks or rocket packs"
	 * 
	 * Mini-crits targets launched airborne by an explosion.
	 * 
	 * Only procs when not in Mannpower mode.
	 */
	val miniCritAirborne: ItemAttributeNamed<Boolean> get() = WeaponBaseAttributes.miniCritAirborne
	
	/**
	 * In-Game: "Mini-crits targets when fired at their back from close range"
	 * 
	 * If true, minicrits targets facing away from the attacker that are within 22.6 HU of the attacker (sqrt 512).
	 */
	val closerangeBackattackMinicrits: ItemAttributeNamed<Boolean> get() = WeaponBaseAttributes.closerangeBackattackMinicrits
	
	/**
	 * In-Game: "Crits whenever it would normally mini-crit"
	 */
	val minicritsBecomeCrits: ItemAttributeNamed<Boolean> get() = WeaponBaseAttributes.minicritsBecomeCrits
	
	/**
	 * In-Game: "N% damage vs players"
	 */
	val dmgPenaltyVsPlayers: ItemAttributeNamed<Float> get() = WeaponBaseAttributes.dmgPenaltyVsPlayers
	
	/**
	 * In-Game: "No critical hits vs non-burning players"
	 * 
	 * Note: Even prevents criticals when crit-boosted.
	 */
	val noCritVsNonburning: ItemAttributeNamed<Boolean> get() = WeaponBaseAttributes.noCritVsNonburning
	
	/**
	 * In-Game: "N% damage vs non-burning players"
	 */
	val dmgPenaltyVsNonburning: ItemAttributeNamed<Float> get() = WeaponBaseAttributes.dmgPenaltyVsNonburning
	
	/**
	 * In-Game: "Critical damage is affected by range"
	 * 
	 * If true, crits have damage falloff (Ambassador).
	 */
	val critDmgFalloff: ItemAttributeNamed<Boolean> get() = WeaponBaseAttributes.critDmgFalloff
	
	/**
	 * In-Game: "Minicrits whenever it would normally crit"
	 */
	val critsBecomeMinicrits: ItemAttributeNamed<Boolean> get() = WeaponBaseAttributes.critsBecomeMinicrits
	
	/**
	 * In-Game: "+N% damage vulnerability while active"
	 * 
	 * Increases damage taken while minicrit-boosted by Crit-a-Cola, Buffalo Steak, etc.
	 */
	val energyBuffDmgTakenMultiplier: ItemAttributeNamed<Float> get() = WeaponBaseAttributes.energyBuffDmgTakenMultiplier
	
	/**
	 * In-Game: "+N% cloak on hit"
	 * 
	 * Adds this amount of cloak on hit.
	 * 
	 * Only procs on Spy.
	 */
	val addCloakOnHit: ItemAttributeNamed<Int> get() = WeaponBaseAttributes.addCloakOnHit
	
	/**
	 * In-Game: "On Hit: target is engulfed in flames"
	 * 
	 * Ignites player on hit.
	 */
	val setDamagetypeIgnite: ItemAttributeNamed<Boolean> get() = WeaponBaseAttributes.setDamagetypeIgnite
	
	/**
	 * In-Game: "+N% fire damage resistance while deployed"
	 * 
	 * Gain fire resistance only when this weapon is active.
	 */
	val dmgTakenFromFireReducedOnActive: ItemAttributeNamed<Float> get() = WeaponBaseAttributes.dmgTakenFromFireReducedOnActive
	
	/**
	 * In-Game: "N% damage bonus vs burning players"
	 */
	val damageBonusVsBurning: ItemAttributeNamed<Float> get() = WeaponBaseAttributes.damageBonusVsBurning
	
	/**
	 * In-Game: "N% damage vulnerability on wearer"
	 */
	val multDmgtakenActive: ItemAttributeNamed<Float> get() = WeaponBaseAttributes.multDmgtakenActive
	
	/**
	 * In-Game: "+N% damage from melee sources while active"
	 */
	val dmgFromMeleeIncreased: ItemAttributeNamed<Float> get() = WeaponBaseAttributes.dmgFromMeleeIncreased
	
	/**
	 * In-Game: "N% damage from ranged sources while active"
	 * 
	 * Applies to blast, bullet, buckshot, ignite, and sonic damage types.
	 */
	val dmgFromRangedReduced: ItemAttributeNamed<Float> get() = WeaponBaseAttributes.dmgFromRangedReduced
	
	/**
	 * In-Game: "No self inflicted blast damage taken"
	 */
	val noSelfBlastDmg: ItemAttributeNamed<Boolean> get() = WeaponBaseAttributes.noSelfBlastDmg
	
	/**
	 * In-Game: "+N% damage to self"
	 * 
	 * Multiplier applied to blast damage taken from an explosion caused by said entity.
	 */
	val blastDmgToSelfIncreased: ItemAttributeNamed<Float> get() = WeaponBaseAttributes.blastDmgToSelfIncreased
	
	/**
	 * Used for killfeed.
	 */
	val isGigerCounter: ItemAttributeNamed<Boolean> get() = WeaponBaseAttributes.isGigerCounter
	
	/**
	 * Sets killfeed background gold.
	 */
	val isAustraliumItem: ItemAttributeNamed<Boolean> get() = WeaponBaseAttributes.isAustraliumItem
	
	/**
	 * In-Game: "Imbued with an ancient power"
	 * 
	 * Sets killfeed background gold.
	 */
	val turnToGold: ItemAttributeNamed<Boolean> get() = WeaponBaseAttributes.turnToGold
	
	/**
	 * In-Game: "N% health from healers on wearer"
	 * 
	 * Attribute class is a flat multiplier applied to health from healers while weapon is active.
	 */
	val multHealthFromhealersPenaltyActive: ItemAttributeNamed<Float> get() = WeaponBaseAttributes.multHealthFromhealersPenaltyActive
	
	/**
	 * In-Game: "N% Overheal build rate."
	 * 
	 * Checked on the player that is healing an entity.
	 */
	val overhealFillRateReduced: ItemAttributeNamed<Float> get() = WeaponBaseAttributes.overhealFillRateReduced
	
	/**
	 * In-Game: "N% less healing from Medic sources"
	 * 
	 * Applies to all non-dispenser forms of healing that apply the `TF_COND_HEAL_BUFF` status.
	 */
	val reducedHealingFromMedics: ItemAttributeNamed<Float> get() = WeaponBaseAttributes.reducedHealingFromMedics
	
	val weaponBurnDmgReduced: BonusPenalty<Float> get() = WeaponBaseAttributes.weaponBurnDmgReduced
	
	/**
	 * In-Game: "Halloween Fire"
	 * 
	 * Makes afterburn green.
	 */
	val spellHalloweenGreenFlames: ItemAttributeNamed<Boolean> get() = WeaponBaseAttributes.spellHalloweenGreenFlames
	
	/**
	 * In-Game: "Syringes deliver a highly concentrated dose of Mad Milk. Duration increases per hit to a max of 4 seconds."
	 * 
	 * Duration of 4 seconds, and increases by 0.5 seconds each hit.
	 */
	val madMilkSyringes: ItemAttributeNamed<Boolean> get() = WeaponBaseAttributes.madMilkSyringes
	
	/**
	 * In-Game: "Alt-Fire: Applies a healing effect to all nearby teammates"
	 * 
	 * Makes default weapon taunt perform the Amputator radial healing effect.
	 */
	val enablesAoeHeal: ItemAttributeNamed<Boolean> get() = WeaponBaseAttributes.enablesAoeHeal
	
	val weaponBurnTimeReduced: BonusPenalty<Float> get() = WeaponBaseAttributes.weaponBurnTimeReduced
	
	/**
	 * In-Game: "Fires tracer rounds"
	 * 
	 * Note: Sniper rage forcibly draws a tracer regardless of this setting.
	 * 
	 * Used when firing bullets.
	 */
	val sniperFiresTracer: ItemAttributeNamed<Boolean> get() = WeaponBaseAttributes.sniperFiresTracer
	
	/**
	 * In-Game: "Fires tracer rounds"
	 * 
	 * Same as `sniper_fires_tracer`.
	 */
	val sniperFiresTracerHidden: ItemAttributeNamed<Boolean> get() = WeaponBaseAttributes.sniperFiresTracerHidden
	
	/**
	 * In-Game: "N% increased damage to your sentry's target"
	 */
	val damageBonusBulletVsSentryTarget: ItemAttributeNamed<Float> get() = WeaponBaseAttributes.damageBonusBulletVsSentryTarget
	
	/**
	 * In-Game: "On Full Charge: Projectiles penetrate players"
	 */
	val penetratesWhenFullyCharged: ItemAttributeNamed<Boolean> get() = WeaponBaseAttributes.penetratesWhenFullyCharged
	
	/**
	 * Multiplier applied to movement speed scaled by ubercharge percentage.
	 * 
	 * Only works if the player using this item is a Medic with a Medigun.
	 */
	val moveSpeedBonusResourceLevel: ItemAttributeNamed<Float> get() = WeaponBaseAttributes.moveSpeedBonusResourceLevel
	
	/**
	 * In-Game: "+N% faster move speed on wearer"
	 * 
	 * Multiplier applied to player movement speed only while this is the active weapon.
	 */
	val multPlayerMovespeedActive: ItemAttributeNamed<Float> get() = WeaponBaseAttributes.multPlayerMovespeedActive
	
	/**
	 * If greater than 0 (like with the Thermal Thruster), takes that amount of time to holster BEFORE actually swapping weapons.
	 */
	val holsterAnimTime: ItemAttributeNamed<Float> get() = WeaponBaseAttributes.holsterAnimTime
	
	/**
	 * In-Game: "Alt-Fire: Use N metal to pick up your targeted building from long range"
	 * 
	 * Metal cost to pick up a building at range.
	 * 
	 * Restricted to the default rescue ranger range, but can be used by any weapon.
	 */
	val engineerBuildingTeleportingPickup: ItemAttributeNamed<Int> get() = WeaponBaseAttributes.engineerBuildingTeleportingPickup
	
	/**
	 * In-Game: "N% damage on body shot"
	 * 
	 * Multiplier applied to bodyshot damage.
	 */
	val damagePenaltyOnBodyshot: ItemAttributeNamed<Float> get() = WeaponBaseAttributes.damagePenaltyOnBodyshot
	
	val healingReceived: BonusPenalty<Float> get() = WeaponBaseAttributes.healingReceived
	
	/**
	 * In-Game: "Stuns enemies who are also wielding this weapon"
	 */
	val stunEnemiesWieldingSameWeapon: ItemAttributeNamed<Boolean> get() = WeaponBaseAttributes.stunEnemiesWieldingSameWeapon
	
	/**
	 * In-Game: "All players connected via Medigun beams are hit"
	 * 
	 * Damage all players connected to the target by medigun beams.
	 */
	val damageAllConnected: ItemAttributeNamed<Boolean> get() = WeaponBaseAttributes.damageAllConnected
	
	/**
	 * Apply this amount of z velocity to players hit with this weapon.
	 */
	val applyZVelocityOnDamage: ItemAttributeNamed<Float> get() = WeaponBaseAttributes.applyZVelocityOnDamage
	
	/**
	 * Apply this amount of velocity in the direction you're facing to players hit with this weapon.
	 */
	val applyLookVelocityOnDamage: ItemAttributeNamed<Float> get() = WeaponBaseAttributes.applyLookVelocityOnDamage
	
	/**
	 * In-Game: "Ignited enemies explode"
	 * 
	 * Applies when *any weapon* with this attribute is in the second loadout slot of the player who covered someone in gas.  This attribute does not specifically check for the Gas Passer.  For example, f a Soldier has a rocket launcher that applies `TF_COND_GAS` and their shotgun in their secondary has this attribute, they'll still explode on ignite.
	 * 
	 * Only the afterburn specifically checks for the Gas Passer.
	 */
	val explodeOnIgnite: ItemAttributeNamed<Boolean> get() = WeaponBaseAttributes.explodeOnIgnite
	
	val selfDmgPushForce: BonusPenalty<Float> get() = WeaponBaseAttributes.selfDmgPushForce
	
	/**
	 * Knocks back attacker when wielder receives damage.
	 */
	val damageCausesAirblast: ItemAttributeNamed<Boolean> get() = WeaponBaseAttributes.damageCausesAirblast
	
	/**
	 * Push force applied to target when hitting an enemy.
	 * 
	 * Scales by range, to a minimum of 50% of the given value.
	 */
	val damageBlastPush: ItemAttributeNamed<Float> get() = WeaponBaseAttributes.damageBlastPush
	
	val damageForceReduction: DamageForceReductionAttributes get() = WeaponBaseAttributes.damageForceReduction
	
	/**
	 * In-Game: "On Hit: Bleed for N seconds"
	 * 
	 * Apply bleed on hit.
	 * 
	 * Value is a time in seconds.
	 */
	val bleedingDuration: ItemAttributeNamed<Float> get() = WeaponBaseAttributes.bleedingDuration
	
	/**
	 * In-Game: "The wearer cannot be killed by headshots"
	 * 
	 * When a headshot would kill you, reduce health to 1.
	 */
	val setBonusNoDeathFromHeadshots: ItemAttributeNamed<Boolean> get() = WeaponBaseAttributes.setBonusNoDeathFromHeadshots
	
	/**
	 * In-Game: "Increased headshot explosion radius and damage to nearby enemies"
	 * 
	 * Only applies if in a gamemode with upgrades, but applies to all headshots.
	 * 
	 * Also applies to any hitscan weapon with a `jarate_time` attribute that hit the head.
	 */
	val explosiveHeadshotLevel: ItemAttributeNamed<Boolean> get() = WeaponBaseAttributes.explosiveHeadshotLevel
	
	/**
	 * In-Game: "Killing an enemy with a critical hit will dismember your victim. Painfully."
	 */
	val critKillWillGib: ItemAttributeNamed<Boolean> get() = WeaponBaseAttributes.critKillWillGib
	
	/**
	 * If false, this weapon can only gib if it deals blast damage or half-falloff damage.
	 */
	val critOnHardHit: ItemAttributeNamed<Boolean> get() = WeaponBaseAttributes.critOnHardHit
	
	/**
	 * In-Game: "On Kill: N seconds of 100% critical chance"
	 * 
	 * Seconds of crit-boost gained on kill.
	 * 
	 * Note: actual time is `this + 1`.
	 */
	val critboostOnKill: ItemAttributeNamed<Int> get() = WeaponBaseAttributes.critboostOnKill
	
	/**
	 * In-Game: "On Kill: Gain Mini-crits for N seconds."
	 * 
	 * Seconds of minicrit-boost gained on kill.
	 * 
	 * Note: actual time is `this + 1`.
	 */
	val minicritboostOnKill: ItemAttributeNamed<Int> get() = WeaponBaseAttributes.minicritboostOnKill
	
	/**
	 * In-Game: "Exorcism"
	 * 
	 * Exorcism spell effect.
	 */
	val spellHalloweenDeathGhosts: ItemAttributeNamed<Boolean> get() = WeaponBaseAttributes.spellHalloweenDeathGhosts
	
	/**
	 * In-Game: "On Kill: Gain N% of base health on kill"
	 * 
	 * Percentage of health to be restored upon killing an enemy. (e.g. `25` is 25%).
	 * 
	 * Post-heal player health value is capped at 1.5x the player's normal max health.
	 * 
	 * Negative values are ignored.
	 */
	val restoreHealthOnKill: ItemAttributeNamed<Int> get() = WeaponBaseAttributes.restoreHealthOnKill
	
	/**
	 * In-Game: "+N health restored on kill"
	 * 
	 * Restores this flat amount of health on killing an enemy. Post-heal player health value is capped at the player's maximum overheal.
	 * 
	 * Negative values are NOT ignored.
	 */
	val healOnKill: ItemAttributeNamed<Int> get() = WeaponBaseAttributes.healOnKill
	
	/**
	 * In-Game: "Gain a speed boost on kill"
	 */
	val speedBoostOnKill: ItemAttributeNamed<Int> get() = WeaponBaseAttributes.speedBoostOnKill
	
	/**
	 * In-Game: "Maximum health is drained while item is active"
	 * 
	 * Maximum health decrease per tick while weapon is active. (Gloves of Running Urgently/Eviction Notice).
	 */
	val maxhealthDrainRate: ItemAttributeNamed<Float> get() = WeaponBaseAttributes.maxhealthDrainRate
	
	/**
	 * If true, prevents holiday taunts from being used.
	 */
	val specialTaunt: ItemAttributeNamed<Boolean> get() = WeaponBaseAttributes.specialTaunt
	
	val ragdolls: RagdollsAttributes get() = WeaponBaseAttributes.ragdolls

	
	open class ProjectilePenetrationAttributes {
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
	
	
	open class DamageAttributes {
		/**
		 * In-Game: "N% damage penalty"
		 */
		open val damagePenalty: ItemAttributeNamed<Float> = ItemAttributeNamed("damage penalty")
	
		/**
		 * In-Game: "+N% damage bonus"
		 */
		open val damageBonus: ItemAttributeNamed<Float> = ItemAttributeNamed("damage bonus")
	
		/**
		 * In-Game: "+N% damage bonus"
		 */
		open val damageBonusHidden: ItemAttributeNamed<Float> = ItemAttributeNamed("damage bonus HIDDEN")
	
		/**
		 * In-Game: "+N% damage bonus"
		 */
		open val cardDamageBonus: ItemAttributeNamed<Float> = ItemAttributeNamed("CARD: damage bonus")
	}
	
	
	open class FireRateAttributes {
		/**
		 * In-Game: "N% slower firing speed"
		 * 
		 * After firing, you wait a bit before you can fire again. That's the "delay".
		 */
		open val fireRatePenalty: ItemAttributeNamed<Float> = ItemAttributeNamed("fire rate penalty")
	
		/**
		 * In-Game: "+N% faster firing speed"
		 * 
		 * After firing, you wait a bit before you can fire again. That's the "delay".
		 */
		open val fireRateBonus: ItemAttributeNamed<Float> = ItemAttributeNamed("fire rate bonus")
	
		/**
		 * After firing, you wait a bit before you can fire again. That's the "delay".
		 */
		open val fireRatePenaltyHidden: ItemAttributeNamed<Float> = ItemAttributeNamed("fire rate penalty HIDDEN")
	
		/**
		 * In-Game: "+N% faster firing speed"
		 * 
		 * After firing, you wait a bit before you can fire again. That's the "delay".
		 */
		open val fireRateBonusHidden: ItemAttributeNamed<Float> = ItemAttributeNamed("fire rate bonus HIDDEN")
	
		/**
		 * In-Game: "+N% faster melee attack speed"
		 * 
		 * After firing, you wait a bit before you can fire again. That's the "delay".
		 */
		open val meleeAttackRateBonus: ItemAttributeNamed<Float> = ItemAttributeNamed("melee attack rate bonus")
	}
	
	
	open class OnHitAttributes {
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
	
		/**
		 * In-Game: "Melee hits refill  N% of your charge meter."
		 * 
		 * Restores demoman shield charge on hit.
		 */
		open val chargeMeterOnHit: ItemAttributeNamed<Float> = ItemAttributeNamed("charge meter on hit")
	
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
		open val addUberChargeOnHit: ItemAttributeNamed<Float> = ItemAttributeNamed("add uber charge on hit")
	
		open val rageOnHit: BonusPenalty<Int> = BonusPenalty(
			ItemAttributeNamed("mod rage on hit bonus"),
			ItemAttributeNamed("mod rage on hit penalty"),
		)
	
		/**
		 * In-Game: "On Hit: Builds Boost Run speed increased with Boost"
		 * 
		 * Gain Scout's "hype" meter on hit.  Yeah, this exists for everything, but specifically modifies Scout's "hype" meter, which is only used for the Soda Popper and Baby Face's Blaster.
		 */
		open val boostOnDamage: ItemAttributeNamed<Boolean> = ItemAttributeNamed("boost on damage")
	
		/**
		 * In-Game: "On Hit: N% chance to slow target"
		 * 
		 * Gain speedboost on hit.
		 */
		open val slowEnemyOnHit: ItemAttributeNamed<Float> = ItemAttributeNamed("slow enemy on hit")
	
		/**
		 * In-Game: "On Hit: Slow target movement by 40% for Ns"
		 * 
		 * Gain speedboost for N seconds.
		 */
		open val slowEnemyOnHitMajor: ItemAttributeNamed<Float> = ItemAttributeNamed("slow enemy on hit major")
	
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
	
		open val healOnHitForRapidfire: HealOnHitForRapidfireAttributes = HealOnHitForRapidfireAttributes()
	
		open val generateRageOnDamage: GenerateRageOnDamageAttributes = GenerateRageOnDamageAttributes()
	
	
		open class HealOnHitForRapidfireAttributes {
			/**
			 * In-Game: "On Hit: Gain up to +N health"
			 */
			open val healOnHitForRapidfire: ItemAttributeNamed<Int> = ItemAttributeNamed("heal on hit for rapidfire")
	
			/**
			 * In-Game: "On Hit: N health"
			 */
			open val selfdmgOnHitForRapidfire: ItemAttributeNamed<Int> = ItemAttributeNamed("selfdmg on hit for rapidfire")
	
			/**
			 * In-Game: "On Hit: Gain up to +N health"
			 */
			open val healOnHitForSlowfire: ItemAttributeNamed<Int> = ItemAttributeNamed("heal on hit for slowfire")
	
			/**
			 * In-Game: "On Hit: N health"
			 */
			open val selfdmgOnHitForSlowfire: ItemAttributeNamed<Int> = ItemAttributeNamed("selfdmg on hit for slowfire")
		}
	
	
		open class GenerateRageOnDamageAttributes {
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
	
	
	open class RevengeCritsAttributes {
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
	
	
	open class CritVsBurningPlayersAttributes {
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
		 * In-Game: "100% critical hit vs stunned players"
		 * 
		 * The weapon's "crit players with X condition" stat.
		 */
		open val critVsStunnedPlayers: ItemAttributeNamed<EnumSet<TFCritCondition>> = ItemAttributeNamed("crit vs stunned players", EnumSetOrCodec())
	}
	
	
	open class DamageForceReductionAttributes {
		/**
		 * In-Game: "N% reduction in push force taken from damage"
		 * 
		 * Attribute class is a flat multiplier applied to push force received from damage.
		 */
		open val damageForceReduction: ItemAttributeNamed<Float> = ItemAttributeNamed("damage force reduction")
	
		/**
		 * In-Game: "N% increase in push force taken from damage"
		 * 
		 * Attribute class is a flat multiplier applied to push force received from damage.
		 */
		open val damageForceIncrease: ItemAttributeNamed<Float> = ItemAttributeNamed("damage force increase")
	
		/**
		 * In-Game: "N% increase in push force taken from damage"
		 * 
		 * Attribute class is a flat multiplier applied to push force received from damage.
		 */
		open val damageForceIncreaseHidden: ItemAttributeNamed<Float> = ItemAttributeNamed("damage force increase hidden")
	
		/**
		 * In-Game: "Increase in push force taken from damage and airblast"
		 * 
		 * Attribute class is a flat multiplier applied to push force received from damage.
		 */
		open val damageForceIncreaseText: ItemAttributeNamed<Float> = ItemAttributeNamed("damage force increase text")
	}
	
	
	open class RagdollsAttributes {
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
	
		open val critOnHardHit: ItemAttributeNamed<Boolean> = ItemAttributeNamed("crit on hard hit")
	}
}