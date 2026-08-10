package btpos.source.vdfdsl.tf2.filegeneration

import btpos.source.vdfdsl.tf2.filegeneration.representations.FakeCodec
import btpos.source.vdfdsl.tf2.filegeneration.representations.ISortedNamedAttribute
import btpos.source.vdfdsl.tf2.filegeneration.representations.NamedAttribute
import btpos.source.vdfdsl.tf2.filegeneration.representations.groupings.LongAttributeHiLo
import btpos.source.vdfdsl.tf2.filegeneration.representations.groupings.NamedAttributeScope
import btpos.source.vdfdsl.tf2.filegeneration.representations.mynotes.AttrClassScope
import btpos.source.vdfdsl.tf2.filegeneration.representations.mynotes.AttrClassUsage
import btpos.source.vdfdsl.tf2.filegeneration.representations.mynotes.HierarchyAttrClassScope
import btpos.source.vdfdsl.tf2.filegeneration.representations.mynotes.IAttrClassScope
import btpos.source.vdfdsl.tf2.filegeneration.representations.mynotes.IAttrThing


private const val DEMOCHARGE = "DemoCharge"

private const val AMMO_CLIPSIZE = "ClipSize"

private const val WEAPONSWITCH = "SwapWeapons"
private const val WEAPONSWITCH_DEPLOY = "Deploy"

private const val PROJECTILES = "Projectiles"

private const val PROJECTILES_BULLETS = "Bullets"

private const val DAMAGE = "Damage"
private const val METER = "Meter"
private const val CRITS = "Crits"
private const val MISC = "Misc"
private const val AMMO = "Ammo"
private const val KNOCKBACK_RECEIVED = "KnockbackReceived"

private const val FIRING = "Firing"

private const val RELOADING = "Reloading"

private const val ONHIT = "OnHit"

private const val BODY = "Body"

private const val META = "Meta"

private const val META_VIEWMODEL = "Viewmodel"

private const val RESISTANCE = "Resistance"

private const val HEALTH = "HealthAndHealing"

private const val MOVEMENT = "Movement"

private const val REVENGECRITS = "RevengeCrits"

private const val META_KILLFEED = "Killfeed"

private const val TAUNTING = "Taunting"

private const val WHENHIT = "WhenHit"

private const val ONKILL = "OnKill"

private const val AFTERBURN = "Afterburn"

private const val BUILDINGS = "Buildings"

private const val STATUSEFFECTS = "StatusEffects"

private const val RAGDOLLS = "Ragdolls"

private const val FIRING_FIRINGSPEED = "FireRate"

private const val HEADS = "Heads"

private const val RIFLECHARGE = "RifleCharge"

private const val BUILDINGS_SENTRY = "SentryGun"

private const val BUILDINGS_DISPENSER = "Dispenser"

private const val BUILDINGS_TELEPORTER = "Teleporter"

private const val DISGUISE = "Disguise"

private const val HUD = "Hud"

private const val META_GAMEPLAY = "Gameplay"

private const val BUFFITEMS = "BuffItems"

private const val META_PLAYER = "Player"

private const val META_ITEMSTATS = "Items"

private const val MOVEMENT_MOVESPEED = "MoveSpeed"

private const val CLOAK = "Cloak"

private const val AMMO_MAXAMMO = "MaxAmmo"

private const val META_NOISEMAKER = "Noisemakers"

private const val META_PARTICLES = "Particles"

private const val FLAMES = "Flames"

object SDKNotes {
	fun getParent(name: String): String? {
		return hierarchy.getParent(name)
	}
	
	val hierarchy = TFClassHierarchy(
		"BaseEntity" to listOf(
			
			"Player" to listOf(
				"MvMBot", // technically doesn't exist, but it's mainly just to
				"EconEntity" to listOf( // inherit all player attributes for all weapons
					"Wearable",
					"BaseCombatWeapon" to listOf("WeaponBase"),
				),
			)
		),
		
		
		"WeaponBase" to listOf(
			"WeaponBaseGrenade",
			"Invis",
			"BaseMelee",
			"BaseGun",
			"Lunchbox" to listOf(
				"LunchboxDrink"
			),
			"PDA" to listOf(
				"PDAEngineerBuild",
				"PDAEngineerDestroy",
				"PDASpy",
			),
			"Builder" to listOf(
				"Sapper"
			),
			
			"PassTimeGun",
			"ProjectileGrenade"
		),
		
		// Unused
		"WeaponBaseGrenade" to listOf(
			"GrenadeEMP",
			"GrenadeHeal",
			"GrenadeNapalm",
			"GrenadeNormal",
			"GrenadeSmokeBomb",
			"GrenadeCaltrop",
			"GrenadeNail",
			"GrenadeMirv",
			"GrenadeGas",
		),
		
		"BaseGun" to listOf(
			"SMG" to listOf(
				"ChargedSMG"
			),
			"Tranq",
			"SyringeGun",
			"Revolver" to listOf(
				"RevolverSecondary"
			),
			"StickybombLauncher" to listOf(
				"CompoundBow"
			),
			"LaserPointer",
			"Pistol" to listOf(
				"ScoutPistol" to listOf(
					"ScoutPistolPrimary",
					"ScoutPistolSecondary"
				)
			),
			"MechanicalArm",
			"FlareGun" to listOf(
				"FlareGunRevenge"
			),
			"Shotgun" to listOf(
				"Scattergun" to listOf(
					"SodaPopper",
					"PEPBrawlerBlaster"
				),
				"ShotgunRevenge",
				"ShotgunBuildingRescue"
			),
			"GrenadeLauncher" to listOf(
				"Cannon"
			),
			"Minigun",
			"Jar" to listOf(
				"Throwable" to listOf(
					"SpellBook",
					"ThrowablePrimary",
					"ThrowableSecondary",
					"ThrowableMelee",
					"ThrowableUtility"
				),
				"Decoy",
				"JarMilk",
				"Cleaver",
				"JarGas",
			),
			"Flamethrower" to listOf(
				"DragonsFury"
			),
			"RocketLauncher" to listOf(
				"RocketLauncher_AirStrike",
				"RocketLauncher_DirectHit",
				"RocketLauncher_Mortar",
				"Crossbow",
				"RayGun" to listOf(
					"Raygun_Revenge",
					"DRGPomson"
				),
				"ParticleCannon",
				"GrapplingHook",
			),
			"SniperRifle" to listOf(
				"SniperRifleDecap",
				"SniperRifleClassic"
			),
			"Medigun",
			"Nailgun"
		),
		
		"BaseMelee" to listOf(
			"Flag",
			"Slap",
			"Sword",
			"Knife",
			"Club",
			"Bat" to listOf(
				"BatFish",
				"BatWood" to listOf("BatGiftwrap"),
			),
			"Boomerang",
			"BuffItem" to listOf("Parachute"),
			"FireAxe",
			"Crowbar",
			"Bonesaw",
			"Shovel",
			"Wrench" to listOf("RobotArm"),
			"Fists",
			"RocketPack",
			"BreakableMelee" to listOf(
				"Bottle",
				"BreakableSign",
				"StickBomb"
			),
		),
		
		"BaseProjectile" to listOf(
			"BaseRocket" to listOf(
				"ProjectileArrow" to listOf(
					"ProjectileHealingBolt",
					"ProjectileGrapplingHook"
				),
				"ProjectileRocket" to listOf(
					"ProjectileMechanicalArmOrb",
					"ProjectileSentryRocket",
					"ProjectileSpellFireball" to listOf(
						"ProjectileSpellLightningOrb",
					),
					"ProjectileDragonsFury"
				),
				"ProjectileEnergyBall"
			),
			"ProjectileEnergyRing",
			"ProjectileFlare",
			"ProjectileSyringe"
		),
		
		"BaseGrenadeProjectile" to listOf(
			"ProjectileStickybomb" to listOf(
				"ProjectileJar" to listOf(
					"ProjectileJarMilk",
					"ProjectileCleaver",
					"ProjectileSpellBats" to listOf(
						"ProjectileSpellSpawnZombie",
						"ProjectileSpellSpawnHorde",
						"ProjectileSpellPumpkin" to listOf(
							"ProjectileSpellKartPumpkin"
						),
						"ProjectileSpellMirv" to listOf(
							"ProjectileSpellKartMirv"
						),
						"ProjectileSpellSpawnBoss",
						"ProjectileSpellMeteorShower",
						"ProjectileSpellTransposeTeleport",
						"ProjectileSpellKartBats",
					),
				)
			)
		),
		
		"Wearable" to listOf(
			"PDAExpansionDispenser",
			"PDAExpansionTeleporter",
			"WearableDemoShield",
			"WearableRazorback",
			"PowerUpBottle",
			"WearableCampaignItem",
			"WearableLevelableItem",
			"WearableRobotArm",
			"WearableVM",
		),
	)
	
	
	
	
	val attrsByClass: List<IAttrClassScope> get() = listOf(
		HierarchyAttrClassScope(
			"BaseEntity",
			AttrClassScope(
				DISGUISE,
				"""
					- `mod_disguise_consumes_cloak`: Boolean
				""".trimIndent()
			),
			AttrClassScope(
				CRITS,
				"""
					- `mult_crit_when_health_is_below_percent`: Float
						- Gives crit boost when your health is below this proportion
				""".trimIndent()
			),
			AttrClassScope(
				DAMAGE,
				
			),
			AttrClassScope(
				META,
				AttrClassScope(
					META_KILLFEED,
					"""
						- `counts_as_assister`: Boolean
							- If true, this item will get kill assist credit in the killfeed
					""".trimIndent()
				),
			),
			AttrClassScope(
				METER,
				"""
					- `item_meter_resupply_denied`: Boolean
						- If true, resupply cabinets and spawning do not fully recharge the meter for this item.  Instead, its "default charge meter value" is used.
					- `item_meter_charge_type`: TFMeterRechargeType
						- If `TIME` or `COMBO`, checks the `mult_item_meter_charge_rate` attribute for passive recharge rate mult.
						- If `DAMAGE` or `COMBO`, checks the `item_meter_damage_for_full_charge` and `mult_item_meter_charge_rate` attribute classes.
					- `item_meter_damage_for_full_charge`: Float
						- Amount of meter required to fully charge the item.
						- If negative, 0, or not set, does not attempt to fill the meter at all when dealing damage.
					- `mult_item_meter_charge_rate`: Float
						- Scale factor for meter gained per second and/or meter gained on dealing damage.
				""".trimIndent()
			),
			AttrClassScope(
				KNOCKBACK_RECEIVED,
				"""
					- `spunup_push_force_immunity`: Boolean
						- Only procs if Heavy and has a spun up minigun
				""".trimIndent()
			),
			AttrClassScope(
				RESISTANCE,
				"""
					- `set_blockbackstab_once`: Boolean
						- If on a Wearable: the item is "broken", it is given `nodraw`, and the player's secondary weapon's meter is reset.
						- If on a weapon, reduces all backstab damage taken by the player for all backstabs without any cooldown. Performs identically to the Mannpower "Resistance" powerup in this respect.
				""".trimIndent()
			),
		),
		HierarchyAttrClassScope(
			"BaseCombatWeapon",
			AttrClassScope(
				AMMO,
				"""
					- `mod_use_metal_ammo_type`: Boolean
						- Reminder: non-engies start with 100 metal.
					- `mod_no_reload_display_only`: Float
						- In the "DoesReloadSingly" check, this _is_ actually checked, so it's actually _not_ "display-only".
						- If != 1.0 (if present), says the weapon "does not reload one shot at a time".
					- `set_scattergun_no_reload_single`: Boolean
						- Checked in `DoesReloadSingly`. If true, weapon does not reload one shot at a time. (e.g. FaN)
						- Note that for the most part, this logic is set inside the weapon itself. The scattergun attribute is the only way to control this with attributes.
				""".trimIndent(),
				AttrClassScope(
					AMMO_CLIPSIZE,
					"""
						- `mod_max_primary_clip_override`: Int
							- Overwrites the max clipsize to a flat value. Applied before other multipliers.
					""".trimIndent()
				)
			)
		),
		
		
		
		
		HierarchyAttrClassScope(
			"WeaponBase",
			"""
			- `is_a_sword`: Boolean
				- If true, make weapon deploy and holster 75% slower
			- `wrench_builds_minisentry`: Boolean
				- Determines the hand used in the model
			""".trimIndent(),
			AttrClassScope(
				AFTERBURN,
				"""
				- `set_dmgtype_ignite`: Boolean
					- Ignites player on hit
				- `mult_wpn_burndmg`: Float
					- Mult afterburn damage
				- `mult_wpn_burntime`: Float
					- Afterburn duration
				- `halloween_green_flames`: Boolean
					- Makes afterburn green
				""".trimIndent()
			),
			AttrClassScope(
				AMMO,
				"""
					- `no_primary_ammo_from_dispensers`: Boolean
					- `no_metal_from_dispensers_while_active`: Boolean
					- `ubercharge_ammo`: Float
						- Uses this much ubercharge per shot instead of ammo if a syringe gun, else just prevents weapon from firing when empty.
					- `ubercharge_transfer`: Float
						- If [ubercharge_ammo] is set, hitting any other Medic with the weapon will transfer this much ubercharge percent to them. (percent, not proportion)
				""".trimIndent(),
				AttrClassScope(
					AMMO_CLIPSIZE,
					"""
						- `mult_clipsize`: Float
						- `mult_clipsize_upgrade`: Int
						- `mult_clipsize_upgrade_atomic`: Int
							- MVM attribute that specifically handles rocket and grenade launchers
							- Note that all three of these are different classes, which means they stack.
						- `clipsize_increase_on_kill`: Int
					""".trimIndent()
				)
			),
			AttrClassScope(
				BUILDINGS,
				"""
				- `building_teleporting_pickup`: Int
					- Metal cost to pick up a building at range.
					- Restricted to the default rescue ranger range, but can be used by any weapon.
				""".trimIndent()
			),
			AttrClassScope(
				CRITS,
				"""
					- `mult_crit_chance`: Float
						- "No random crits" sets this to `0.0`
					- `last_shot_crits`: Boolean
						- When reloading, if you only have 1 round left in your clip, get crit-boosted
					- `no_crit_boost`: Boolean
						- Can't be crit-boosted.
					- `or_crit_vs_playercond`: Int
						- The weapon's "crit players with X condition" stat.
					- `crit_vs_wet_players`: Boolean
					- `or_crit_vs_not_playercond`: Int
						- Crit against players that DON'T have these conditions.
					- `axtinguisher_properties`: Boolean
						- On hitting a burning player, crit them from behind or minicrit them otherwise.
					- `crit_while_airborne`: Boolean
						- Critical hit enemies if the player was launched into the air by an explosion
						- Only works when not in Mannpower mode
					- `attack_minicrits_and_consumes_burning`: Boolean
						- Only activates if the weapon deals `DMG_MELEE`
					- `or_minicrit_vs_playercond_burning`: Boolean
						- Minicrits if the damage dealt is NOT `DMG_BURN`
					- `mini_crit_airborne`: Boolean
						- Mini-crits targets launched airborne by an explosion
						- Only procs when not in Mannpower mode
					- `closerange_backattack_minicrits`: Boolean
						- If true, minicrits targets facing away from the attacker that are within 22.6 HU of the attacker (sqrt 512)
					- `minicrits_become_crits`: Boolean
					- `set_nocrit_vs_nonburning`: Boolean
						- Note: Even prevents criticals when crit-boosted
					- `crit_dmg_falloff`: Boolean
						- If true, crits have damage falloff (Ambassador)
					- `crits_become_minicrits`: Boolean
				""".trimIndent()
			),
			AttrClassScope(
				DAMAGE,
				"""
					- `mult_dmg`: Float
					- `mult_dmg_vs_buildings`: Float
					- `mult_dmg_vs_players`: Float
					- `mult_dmg_vs_same_class`: Float
					- `mult_dmg_vs_nonburning`: Float
					- `mult_dmg_vs_burning`: Float
					- `mod_pierce_resists_absorbs`: Boolean
						- Damage pierces through all resistances, such as Vaccinator ubercharges and the Battalion's Backup.
					- `mult_dmg_bullet_vs_sentry_target`: Float
					- `bodyshot_damage_modify`: Float
						- Multiplier applied to bodyshot damage.
				
				""".trimIndent()
			),
			AttrClassScope(
				DEMOCHARGE,
				"""
					- `charge_meter_on_hit`: Float
						- Restores demoman shield charge on hit.
					- `custom_charge_meter`: Boolean
						- If true, do not render demoman's charge meter
						- Note: this might not actually be implemented
					- `ammo_gives_charge`: Boolean
						- If true, and player has a demoman charge meter, add charge based on ammo pack size
				""".trimIndent()
			),
			AttrClassScope(
				FIRING,
				"""
					- `auto_fires_full_clip`: Boolean
					- `auto_fires_full_clip_all_at_once`: Boolean
					- `auto_fires_when_full`: Boolean
					- `can_overload`: Boolean
						- Deals damage to the player when overloaded.
					- `kill_combo_fire_rate_boost`: Float
						- Subtract `this * "kill combo"` (number of the same class killed in a row) from the post-fire delay
				""".trimIndent(),
				AttrClassScope(
					FIRING_FIRINGSPEED,
					"""
					- `mult_postfiredelay`: Float
						- Multiplier applied to the cooldown time between shots. Values less than 1.0 increase firing speed, and values greater reduce it.
					""".trimIndent()
				),
				
			),
			AttrClassScope(
				HEALTH,
				"""
				- `weapon_blocks_healing`: Boolean
					- Prevents mediguns/dispensers from targeting you and crossbow bolts from healing you while the weapon is active.
				- `active_item_health_regen`: Int
					- Amount of health restored per heal tick while this weapon is active.
				- `mult_uberchargerate_for_healer`: Float
					- Multiplier applied to your healer's ubercharge rate
					- NOTE: Only applied if user is outside of the respawn room
				- `add_health_on_radius_damage`: Int
					- Maximum amount of health that can be gained from an AoE damage source.
					- Health received is multiplied by `damage dealt / base damage of the weapon`, to a max of 100% of the defined value.
				- `mult_health_fromhealers_penalty_active`: Float
					- Attribute class is a flat multiplier applied to health from healers while weapon is active.
				- `overheal_fill_rate`: Float
					- Checked on the player that is healing an entity
				- `mult_healing_from_medics`: Float
					- Applies to all non-dispenser forms of healing that apply the `TF_COND_HEAL_BUFF` status.
				- `mult_healing_received`: Float
					- Multiplier applied to healing from all sources
				- `mod_maxhealth_drain_rate`: Float
					- Maximum health decrease per tick while weapon is active. (Gloves of Running Urgently/Eviction Notice)
				
				""".trimIndent()
			),
			AttrClassScope(
				KNOCKBACK_RECEIVED,
				"""
				- `mult_dmgself_push_force`: Float
					- Flat multiplier applied to push damage taken from self-damage.
				- `damage_force_reduction`: Float
					- Attribute class is a flat multiplier applied to push force received from damage.
				""".trimIndent()
			),
			
			AttrClassScope(
				META,
				"""
				- `kill_eater_kill_type`: Int
					- What "Strange Part" kills with this weapon should contribute to.
				""".trimIndent(),
				AttrClassScope(
					META_KILLFEED,
					"""
					- `is_giger_counter`: Boolean
					- `is_australium_item`: Boolean
						- Sets killfeed background gold
					- `set_turn_to_gold`: Boolean
						- Sets killfeed background gold
					- `set_silent_killer`: Boolean
						- Kills will not show up in the killfeed.
					""".trimIndent()
				),
				AttrClassScope(
					META_VIEWMODEL,
					"""
					- `weapon_allow_inspect`: Boolean
					- `weapon_stattrak_module_scale`: Float
					- `min_viewmodel_offset`: String
					""".trimIndent()
				),
				notes= listOf("Related to the killfeed, scoreboard, and other non-gameplay elements.")
			),
			AttrClassScope(
				METER,
				"""
				- `effectbar_recharge_rate`: Float
					- For things like throwable recharge timers, jetpack charging, etc: how much it recharges per second.
				""".trimIndent()
			),
			AttrClassScope(
				MOVEMENT,
				"""
				- `mod_jump_height_from_weapon`: Float
					- Only takes effect while this weapon is active.
				- `air_dash_count`: Int
					- If greater than 0, attacks minicrit while airborne.
					- Only procs on Scout
				- `firing_forward_pull`: Float
					- While firing the weapon, pulls the user forward with this velocity.
				""".trimIndent(),
				AttrClassScope(
					MOVEMENT_MOVESPEED,
					"""
						- `mult_player_movespeed_resource_level`: Float
							- Multiplier applied to movement speed scaled by ubercharge percentage.
							- Only works if the player using this item is a Medic with a Medigun
						- `mult_player_movespeed_active`: Float
							- Multiplier applied to player movement speed only while this is the active weapon.
					""".trimIndent()
				),
			),
			AttrClassScope(
				HEADS,
				"""
				- `extra_damage_on_hit`: Int
					- Gain this many heads on hitting an enemy.
					- On Revolvers specifically: for every head you have, deal +1% damage.
				""".trimIndent()
			),
			
			AttrClassScope(
				ONHIT,
				"""
					- `add_cloak_on_hit`: Int
						- Adds this amount of cloak on hit
						- Only procs on Spy
					- `add_onhit_addammo`: Boolean
						- Gain ammo equivalent to damage dealt on hit.
					- `reveal_cloaked_victim_on_hit`: Boolean
					- `reveal_disguised_victim_on_hit`: Boolean
					- `add_onhit_addhealth`: Int
						- Add this amount of health on hit
					- `speed_boost_on_hit`: Int
						- Just does `addcond(SPEED_BOOST, speed_boost_on_hit)`
					- `add_onhit_ubercharge`: Float
						- Only procs if on a Medic.
					- `rage_on_hit`: Int
						- Only procs if on a Soldier or Pyro.
					- `boost_on_damage`: Boolean
						- Gain Scout's "hype" meter on hit.
						- This exists for everything, but specifically modifies Scout's "hype" meter, which is only used for the Soda Popper and Baby Face's Blaster.
					- `aoe_heal_chance`: Float
						- Chance to heal allies on hitting an enemy.
					- `crits_on_damage`: Float
						- Chance to gain critboost
					- `stun_on_damage`: Float
						- Chance to stun victim
					- `aoe_blast_on_damage`: Float
						- Stun and bleed victim and others in range
					- `generate_rage_on_dmg`: Boolean
						- Knockback rage on enemy if you're a heavy and your rage is draining
					- `mark_for_death`: Boolean
					- `stun_waist_high_airborne`: Boolean
						- Stun airborne targets.
					- `subtract_victim_medigun_charge_onhit`: Int
						- Percentage as an int, e.g. `25` = 25% = 0.25
						- Drain scaled over distance
					- `subtract_victim_cloak_on_hit`: Int
						- Subtracts an actual value
						- Drain still scaled over distance
					- `mult_onhit_enemyspeed`: Float
						- Gain speedboost on hit.
					- `mult_onhit_enemyspeed_major`: Float
						- Gain speedboost for N seconds.
					- `mad_milk_syringes`: Boolean
						- Applies Mad Milk with a duration of 4 seconds, and each subsequent hit on the same target adds 0.5 seconds to the duration.
					- `stun_enemies_wielding_same_weapon`: Boolean
					- `damage_all_connected`: Boolean
						- Damage all players connected to the target by medigun beams.
					- `apply_z_velocity_on_damage`: Float
						- Apply this amount of z velocity to players hit with this weapon.
					- `apply_look_velocity_on_damage`: Float
						- Apply this amount of velocity in the direction you're facing to players hit with this weapon.
					- `damage_blast_push`: Float
						- Push force applied to target when hitting an enemy.
						- Scales by range, to a minimum of 50% of the given value.
					- `bleeding_duration`: Float
						- Apply bleed on hit.
						- Value is a time in seconds.
					- `lifeleech_on_damage`: Float
						- NOTE: Checked on the active weapon, not the weapon that inflicted the damage.
						- Health gained = `this * damage dealt`, capped at your maximum overheal amount.
					
				""".trimIndent()
			),
			
			AttrClassScope(
				ONKILL,
				"""
				- `add_onkill_critboost_time`: Int
					- Seconds of crit-boost gained on kill.
					- Note: actual time is `this + 1`.
				- `add_onkill_minicritboost_time`: Int
					- Seconds of minicrit-boost gained on kill.
					- Note: actual time is `this + 1`.
				- `restore_health_on_kill`: Int
					- Percentage of health to be restored upon killing an enemy. (e.g. `25` is 25%)
					- Post-heal player health value is capped at 1.5x the player's normal max health.
					- Negative values are ignored.
				- `heal_on_kill`: Int
					- Restores this flat amount of health on killing an enemy. Post-heal player health value is capped at the player's maximum overheal.
					- Negative values are NOT ignored.
				- `speed_boost_on_kill`: Int
					- `addcond TF_COND_SPEEDBOOST <this>`
				- `halloween_death_ghosts`: Boolean
					- Exorcism spell effect
				
				""".trimIndent()
			),
			AttrClassScope(
				PROJECTILES,
				"""
					- `mult_dmg_falloff`: Float
						- Falloff from the center of a blast-radius.
					- `projectile_penetration`: Int
						- How many players your "projectile" (*including bullets*) should penetrate.
					- `centerfire_projectile`: Boolean
						- Note: "Projectile" includes bullets.
					- `projectile_spread_angle`: Float
						- Does not include bullets.
					- `projectile_penetration`: Int
						- Note: in MvM, Sniper's non-rifles are limited by the projectile penetration limit.
					- `penetration_damage_penalty`: Float
						- Damage multiplier applied to bullet/projectile damage for each person penetrated.
						- Can also be a buff if above 1.
				""".trimIndent(),
				AttrClassScope(
					PROJECTILES_BULLETS,
					"""
					- `mult_bullets_per_shot`: Float
					- `sniper_fires_tracer`: Boolean
						- Note: Sniper rage forcibly draws a tracer regardless of this setting.
						- Used when firing bullets.
					- `sniper_fires_tracer_HIDDEN`: Boolean
						- Same as `sniper_fires_tracer`.
					- `sniper_penetrate_players_when_charged`: Boolean
					- `explosive_sniper_shot`: Int
						- Only applies if in a gamemode with upgrades, but applies to all headshots.
						- Also applies to any hitscan weapon with a `jarate_time` attribute that hit the head.
					""".trimIndent()
				),
			),
			
			AttrClassScope(
				RELOADING,
				"""
					- `mult_reload_time`: Float
					- `mult_reload_time_hidden`: Float
					- `fast_reload`: Float
						- This is what's used for weapons that draw directly from reserve ammo, like the flare gun and sniper rifle.
					- On player: `hwn_mult_reload_time`: Float
						- Halloween reload time multiplier.
					- `mult_reload_time_while_healed`: Float
				""".trimIndent()
			),
			AttrClassScope(
				RESISTANCE,
				"""
				- `become_fireproof_on_hit_by_fire`: Float
					- Addcond parameter
				- `mult_dmgtaken_active`: Float
				- `dmg_from_melee`: Float
					- Multiplier applied to incoming melee damage
				- `dmg_from_ranged`: Float
					- Multiplier applied to incoming blast, bullet, buckshot, ignite, and sonic damage
				- `no_self_blast_dmg`: Boolean
					- Also forces the "whistling" sound to play when rocket jumping.
				- `blast_dmg_to_self`: Float
					- Multiplier applied to blast damage taken from an explosion caused by said entity
				- `mult_dmgtaken_from_fire_active`: Float
					- Resist this proportion of fire damage only while this weapon is active
				- `energy_buff_dmg_taken_multiplier`: Float
					- Increases damage taken while minicrit-boosted by Crit-a-Cola, Buffalo Steak, etc.
				- `no_death_from_headshots`: Boolean
					- When a headshot would kill you, reduce health to 1.
				
				""".trimIndent()
			),
			AttrClassScope(
				REVENGECRITS,
				"""
					- `sapper_kills_collect_crits`: Boolean
						- Weapon supports revenge crits if this, `extinguish_revenge`, or `sentry_killed_revenge` is set.
					- `extinguish_revenge`: Boolean
						- Weapon supports revenge crits if this, `sapper_kills_collect_crits`, or `sentry_killed_revenge` is set.
					- `sentry_killed_revenge`: Boolean
						- Weapon supports revenge crits if this, `sapper_kills_collect_crits`, or `extinguish_revenge` is set.
				""".trimIndent()
			),
			AttrClassScope(
				STATUSEFFECTS,
				"""
				- `explode_on_ignite`: Boolean
					- Applies when *any weapon* with this attribute is in the second loadout slot of the player who covered someone in gas.  This attribute does not specifically check for the Gas Passer.  For example, if a Soldier has a rocket launcher that applies `TF_COND_GAS` and their shotgun in their secondary has this attribute, they'll still explode on ignite.
					- Only the afterburn specifically checks for the Gas Passer.
				
				""".trimIndent()
			),
			
			AttrClassScope(
				TAUNTING,
				"""
				- `enables_aoe_heal`: Boolean
					- Makes default weapon taunt perform the Amputator radial healing effect.
				- `special_taunt`: Boolean
					- If true, prevents holiday taunts from being used.
				""".trimIndent()
			),
			
			
			AttrClassScope(
				WEAPONSWITCH,
				"""
					- `provide_on_active`: Boolean
						- If true, only applies attributes when weapon is active, and unapplies them when switching off.
						- I think this also means you can't have "only active when holding weapon" and "always active" attributes on the same weapon, since the order you specify attributes in doesn't matter.
					- On player: `mod_medic_healed_deploy_time`: Float
						- Multiplier applied if NOT being healed by a medic
					- `force_weapon_switch`: Boolean
						- Should force switch to this item when your current weapon is unavailable?
					- `honorbound`: Boolean
						- Takes 50 health when holstering before it gets a kill.
					- `holster_anim_time`: Float
						- If greater than 0 (like with the Thermal Thruster), takes that amount of time to holster BEFORE actually swapping weapons.
				""".trimIndent(),
				AttrClassScope(
					WEAPONSWITCH_DEPLOY,
					"""
						- On player: `mult_deploy_time`: Float
						- `mult_single_wep_deploy_time`: Float
						- `mult_switch_from_wep_deploy_time`: Float
						- `mult_rocketjump_deploy_time`: Float
					""".trimIndent(),
					notes = listOf("@see isASword")
				)
			),
			AttrClassScope(
				WHENHIT,
				"""
				- `damage_causes_airblast`: Boolean
					- Knocks back attacker when wielder receives damage.
				""".trimIndent()
			),
			AttrClassScope(
				RAGDOLLS,
				"""
					- `crit_kill_will_gib`: Boolean
					- `crit_on_hard_hit`: Boolean
						- If false, this weapon can only gib if it deals blast damage or over half of its damage falloff.
					- `freeze_backstab_victim`: Boolean
						- Upon killing an enemy with a backstab, replace their ragdoll with an ice statue.
					- `set_turn_to_gold`: Boolean
						- Saxxy/golden pan effect
					- `ragdolls_become_ash`: Boolean
						- Flamethrower kills
					- `ragdolls_plasma_effect`: Boolean
						- Phlogistinator kills
				""".trimIndent()
			)
		),
		
		HierarchyAttrClassScope(
			"BaseGun",
			AttrClassScope(
				AMMO,
				"""
				- `mod_ammo_per_shot`: Int
					- How much ammo is used per shot. If 0, uses default.
				""".trimIndent()
			),
			AttrClassScope(
				DAMAGE,
				"""
				- `mult_dmg_disguised`: Float
					- When disguised (only checks if the player has the condition, doesn't check class), multiply damage by this amount.
				- `rage_damage`: Float
					- If you're a Soldier or Pyro, increases damage by `(n - 1) * (rage gauge proportion)`
				- `medic_healed_damage_bonus`: Float
					- Multiply damage by this value once for each healer you have. (with 2 healers, that's `bonus * bonus`, exponential)
				- `accuracy_scales_damage`: Float
					- If the projectile being fired is a bullet, multiply damage by your hit ratio over the past few seconds.
				""".trimIndent()
			),
			
			AttrClassScope(
				FIRING,
				"""
					- `keep_disguise_on_attack`: Boolean
						- If true, spies will keep their disguise when attacking with this weapon.
				""".trimIndent(),
				AttrClassScope(
					FIRING_FIRINGSPEED,
					"""
					- On player: `hwn_mult_postfiredelay`: Float
						- Multiplier applied to base fire delay for miniguns
					- `mult_postfiredelay_with_reduced_health`: Float
						- Used with the pre-Blue Moon Panic Attack.
					- `rocketjump_attackrate_bonus`: Float
						- Multiplier to fire delay while player is blast-jumping
						- If set on anything that fires a rocket, the rocket assumes it was fired by the Air Strike and reduces blast radius to 80% of its normal range
					- `mul_nonrocketjump_attackrate`: Float
						- Multiplier to fire delay while player is NOT blast-jumping
					""".trimIndent()
				),
			),
			AttrClassScope(
				PROJECTILES,
				"""
				- `override_projectile_type`: TFProjectileType
					- If unset, uses the weapon's default projectile type.
				- `projectile_spread_angle`: Float
					- Also applicable to stickies.
				- `mult_projectile_range`: Float
				- `grenade_no_spin`: Boolean
					- Don't do tumble on tumbling projectiles.
				""".trimIndent(),
				AttrClassScope(
					PROJECTILES_BULLETS,
					"""
					- `mult_spread_scale`: Float
						- Modifies bullet spread.
					- `panic_attack_negative`: Float
						- Multiplier applied to bullet spread as health gets lower.
					- `mult_spread_scales_consecutive`: Float
						- Scales weapon spread when firing consecutive shots, like the post-"Blue Moon" Panic Attack.
					- `mult_spread_scale_first_shot`: Float
						- By default, all guns have perfect accuracy on the first shot, unless this is set.
					- `fixed_shot_pattern`: Boolean
						- Enables fixed weapon spread on the weapon as though `tf_use_fixed_weaponspreads` were set.
					""".trimIndent()
				)
				
			),
			applicableWeapons = listOf("The Wrangler, Festive Wrangler, The Giger Counter")
		),
		
		HierarchyAttrClassScope(
			"BaseMelee",
			AttrClassScope(
				CRITS,
				"""
				- `crit_from_behind`: Boolean
				- `crit_forces_victim_to_laugh`: Boolean
				- `crit_does_no_damage`: Boolean
				""".trimIndent()
			),
			AttrClassScope(
				DAMAGE,
				"""
				- `mult_dmg_bonus_while_half_dead`: Float
					- If health < 50%, apply mult.
				- `mult_dmg_penalty_while_half_alive`: Float
					- If health >= 50%, apply mult
				- `mult_dmg_with_reduced_health`: Float
					- Apply multiplier that is divided by the player's current health proportion.
				""".trimIndent()
			),
			
			AttrClassScope(
				ONHIT,
				"""
				- `speed_buff_ally`: Boolean
					- Applies speed boost condition to yourself and the teammate you hit
				- `add_give_health_to_teammate_on_hit`: Int
					- Transfer this amount of health from yourself to your teammate on hitting them.
				- `speed_boost_on_hit_enemy`: Duration
					- Value is how long the speed boost condition should be applied.
				- `tickle_enemies_wielding_same_weapon`: Boolean
					- Force enemies to laugh if they're also wielding this weapon.
				
				""".trimIndent()
			),
			
			AttrClassScope(
				WEAPONSWITCH,
				"""
				- `self_mark_for_death`: Boolean
				""".trimIndent()
			),
			"""
				- `set_dmg_apply_to_sapper`: Boolean
					- Damage applies to hit sappers.  The amount of damage dealt is determined by [DamageAttributes.dmgVsBuildings].
				- `is_a_sword`: Boolean
					- If true, set swing range to 72, else 48
					- If true, make weapon deploy and holster 75% slower. (This part can be used on all weapons. See $WEAPONSWITCH.$WEAPONSWITCH_DEPLOY)
				- `melee_bounds_multiplier`: Float
					- Multiplier applied to the bounding box of the swing to detect if a player is inside it.
				- `melee_cleave_attack`: Int
					- If greater than 0, hit all targets in swing instead of just the first valid one.
				- `hit_self_on_miss`: Boolean
			""".trimIndent(),
			applicableWeapons = listOf(
				"Frying Pan, Saxxy, The Conscientious Objector, The Freedom Staff, The Bat Outta Hell, Memory Maker, The Ham Shank, Gold Frying Pan, Necro Smasher, The Crossing Guard, Powerup Strength, Powerup Haste, Powerup Regen, Powerup Resist, Powerup Vampire, Powerup Reflect, Powerup Precision, Powerup Agility, Powerup Knockout, Powerup King, Powerup Plague, Powerup Supernova, Prinny Machete",
				"The Hot Hand",
				"Kukri, The Tribalman's Shiv, The Bushwacka, The Shahanshah"
			)
		),
		
		HierarchyAttrClassScope(
			"Flamethrower",
			AttrClassScope(
				"Airblast",
				"""
				- `airblast_disabled`: Boolean
				- `set_charged_airblast`: Boolean
					- Enables charging an airblast for longer for higher push
					- Fun fact: apparently this was going to be a FLAME ROCKET, but got changed later to be an airblast
				- `mult_airblast_cost`: Float
				- `airblast_functionality_flags`: Int
					- If 0, can do all kinds of airblast as long as airblasting itself isn't disabled.
					- If not 0, can only do whatever functionalities of airblasting are specified by the number. (add any values below to combine them)
						- 1 = PUSHBACK
						- 2 = PUT_OUT_TEAMMATES
						- 4 = REFLECT_PROJECTILES
						- 8 = PUSHBACK_STUN (requires PUSHBACK)
						- 16 = PUSHBACK_VIEW_PUNCH (requires PUSHBACK)
				- `airblast_dashes`: Boolean
					- If true, fly into the direction you're looking when you airblast.  Will not reflect projectiles.
				- `mult_airblast_refire_time`: Float
					- Multiplier for how long after airblasting until you can fire a primary OR secondary attack
					- Secondary attack delay = 0.75 * this
				- `mult_airblast_primary_refire_time`: Float
					- Multiplier for how long before you can use your flamethrower again after airblasting.
					- Primary attack delay = refire_time * primary_refire_time
				- `deflection_size_multiplier`: Float
					- Scales the reflect hitbox for your airblast
				- `reverse_airblast`: Boolean
					- If the airblast isn't disallowed from pushing players back, and this is set, airblasting will pull players instead.
				- `mult_airblast_cone_scale`: Float
					- Cone used for pushing players
				- `airblast_pushback_scale`: Float
				- `airblast_vertical_pushback_scale`: Float
				- `airblast_destroy_projectile`: Boolean
				- `airblast_pushback_disabled`: Boolean
				""".trimIndent()
			),
			AttrClassScope(
				CRITS,
				"""
				- `set_flamethrower_back_crit`: Boolean
				""".trimIndent()
			),
			AttrClassScope(
				MOVEMENT,
				"""
				- `firing_forward_pull`: Boolean
					- If true, you get a speedboost while firing your flamethrower.
				""".trimIndent()
			),
			AttrClassScope(
				AMMO,
				"""
				- `mult_flame_ammopersec`: Float
				""".trimIndent()
			),
			AttrClassScope(
				HEALTH,
				"""
				- `extinguish_restores_health`: Int
					- How much health your extinguish restores
				""".trimIndent()
			),
			AttrClassScope(
				"BuffType",
				"""
				- `set_buff_type`: Int
					- If greater than 0, enables Phlog crits on having full rage
				""".trimIndent()
			),
			AttrClassScope(
				FIRING,
				"""
				- `mod_flamethrower_spinup_time`: Duration
					- If not 0, how long it should take between pressing `+attack` and the flames appearing, like revving up a minigun.
				""".trimIndent(),
			),
			AttrClassScope(
				FLAMES,
				"""
				- `flame_spread_degree`: Float
				- `redirected_flame_size_mult`: Float
				- `mult_flame_size`: Float
					- Also checked on owner
				- `mult_end_flame_size`: Float
				- `flame_ignore_player_velocity`: Float
				- `flame_reflection_add_life_time`: Float
				- `reflected_flame_dmg_reduction`: Float
				- `max_flame_reflection_count`: Int
				- `flame_reflect_on_collision`: Boolean
				- `flame_speed`: Float
				- `flame_lifetime`: Float
				- `flame_random_life_time_offset`: Float
				- `flame_gravity`: Float
				- `flame_drag`: Float
				- `flame_up_speed`: Float
				- On owner: `mult_flame_life`: Float
				- `halloween_green_flames`: Boolean
				""".trimIndent()
			),
			applicableWeapons = listOf(
				"Stock Flamethrower + Reskins, The Backburner, The Degreaser, The Phlogistinator, The Rainblower, The Dragon's Fury"
			)
		),
		
		HierarchyAttrClassScope(
			"SMG",
			"""
				- `set_weapon_mode`: Int
					- If 1, can headshot
			""".trimIndent().notesToAttrClassUsages(),
			applicableWeapons = listOf("Stock SMG + Reskins")
		),
		
		
		HierarchyAttrClassScope(
			"ChargedSMG",
			"""
				- `minicrit_boost_when_charged`: Float
					- Minicrit buff duration
			""".trimIndent().notesToAttrClassUsages(),
			applicableWeapons = listOf("The Cleaner's Carbine")
		),
		
		
		HierarchyAttrClassScope(
			"Sapper",
			"""
				- On player: `sapper_degenerates_buildings`: Float
					- How fast the building should reverse construction
				- `robo_sapper`: Int
					- When the sapper is applied to a player (including MvM bots):
						- 2 - stun time is 5.5 seconds, radius is 225 hammer units
						- 3 - stuns for 7 seconds, radius is 250 hammer units
						- else stuns for 4 seconds and radius is 200 HU
			""".trimIndent().notesToAttrClassUsages(),
			applicableWeapons = listOf("Stock Sapper, The Red-Tape Recorder, Promo Red-Tape Recorder, The Ap-Sap, Festive Sapper, The Snack Attack")
		),
		
		HierarchyAttrClassScope(
			"Fists",
			"""
				- `breadgloves_properties`: Boolean (UNIMPLEMENTED)
					- Note that despite being present in the item schema, this is explicitly COMMENTED OUT of the code, and has no gameplay effects at least.
			""".trimIndent().notesToAttrClassUsages(),
			applicableWeapons = listOf("tock Fists, The Killing Gloves of Boxing, Warrior's Spirit, Fists of Steel, The Eviction Notice, Apoco-Fists, The Holiday Punch, The Bread Bite, Gloves of Running Urgently MvM")
		),
		
		
		HierarchyAttrClassScope(
			"Shovel",
			"""
			- `set_weapon_mode`: Int
				- Used to specify "shovel type"
					- 0 = Standard
					- 1 = Equalizer
					- 2 = Escape Plan
					- If not 0, DMG_TYPE is "Pickaxe", else "Shovel"
			- `air_jump_on_attack`: Boolean
				- On primary attack, send player flying in the direction they're facing.
			""".trimIndent().notesToAttrClassUsages(),
			applicableWeapons = listOf("TF_WEAPON_SHOVEL, The Equalizer, The Pain Train, Upgradeable TF_WEAPON_SHOVEL, The Market Gardener, The Disciplinary Action, The Escape Plan")
		),
		
		HierarchyAttrClassScope(
			"StickBomb",
			listOf(AttrClassUsage("- `halloween_pumpkin_explosions`: Boolean")),
			applicableWeapons = listOf("The Ullapool Caber")
		),
		
		HierarchyAttrClassScope(
			"FireAxe",
			"""
			- `set_dmgtype_ignite`: Boolean
				- Ignite enemies on hit
			""".trimIndent().notesToAttrClassUsages(),
			applicableWeapons = listOf("TF_WEAPON_FIREAXE, The Axtinguisher, The Homewrecker, Upgradeable TF_WEAPON_FIREAXE, The Powerjack, The Back Scratcher, Sharpened Volcano Fragment, The Postal Pummeler, The Maul, The Third Degree, The Lollichop, Festive Axtinguisher")
		),
		
		HierarchyAttrClassScope(
			"Bonesaw",
			AttrClassScope(
				HEADS,
				"""
				- `add_head_on_kill`: Boolean
					- On kill, take an organ (uses "heads" field like usual)
				- `add_head_on_hit`: Boolean
					- If the player should take a "head" when dealing damage with a melee
				""".trimIndent()
			),
			AttrClassScope(
				TAUNTING,
				"""
				- `special_taunt`: Boolean
					- If set, the player will taunt on right click
				""".trimIndent()
			),
			
			"""
			- `set_weapon_mode`: Int
				- Used to specify "bonesaw type". Unused.
			- `ubercharge_preserved_on_spawn_max`: Float
			""".trimIndent().notesToAttrClassUsages(),
			applicableWeapons = listOf("TF_WEAPON_BONESAW, The Ubersaw, The Vita-Saw, Upgradeable TF_WEAPON_BONESAW, The Amputator, The Solemn Vow, Festive Ubersaw, Festive Bonesaw 2014")
		),
		
		HierarchyAttrClassScope(
			"Minigun",
			AttrClassScope(
				AMMO,
				"""
				- `uses_ammo_while_aiming`: Int
					- Amount of ammo drained per second
				""".trimIndent()
			),
			
			"""
				- `minigun_no_spin_sounds`: Boolean
				- `mod_minigun_can_holster_while_spinning`: Boolean
				- `mult_minigun_spinup_time`: Float
				- `attack_projectiles`: Boolean
					- Overridden by "raid gamemode" to 1
				- `ring_of_fire_while_aiming`: Int
			""".trimIndent().notesToAttrClassUsages(),
			applicableWeapons = listOf("Stock Minigun + Reskins, Natascha, The Brass Beast, Tomislav")
		),
		
		HierarchyAttrClassScope(
			"Pistol",
			listOf(),
			applicableWeapons = listOf("TF_WEAPON_PISTOL, TF_WEAPON_PISTOL_SCOUT, TTG Max Pistol, Upgradeable TF_WEAPON_PISTOL, The C.A.P.P.E.R")
		),
		
		HierarchyAttrClassScope(
			"ScoutPistol",
			"""
				- `back_headshot`: Boolean
					- If true, can headshot when behind an enemy
			""".trimIndent().notesToAttrClassUsages(),
			applicableWeapons = listOf("The Shortstop, The Winger, Pretty Boy's Pocket Pistol")
		),
		
		HierarchyAttrClassScope(
			"Revolver",
			AttrClassScope(
				HEADS,
				"""
				- `extra_damage_on_hit`: Boolean
					- If true, increases damage by 1% per "head" collected (note: this is not the diamondback's "revenge crit" mechanic)
				- `extra_damage_on_hit_penalty`: Int
					- Lowers your head count by this amount every time you fire a shot
				""".trimIndent()
			),
			applicableWeapons = listOf("TF_WEAPON_REVOLVER, The Ambassador, TTG Sam Revolver, Upgradeable TF_WEAPON_REVOLVER, L'Etranger, The Enforcer, The Diamondback, Festive Ambassador, Festive Revolver 2014")
		),
		
		HierarchyAttrClassScope(
			"SyringeGun",
			"""
				- `set_weapon_mode`: Int
					- Used to specify "syringe type". (Unused)
			""".trimIndent(),
			applicableWeapons = listOf("Stock Syringe Gun, The Blutsauger, The Overdose"),
		),
		
		HierarchyAttrClassScope(
			"RocketPack",
			"""
			- `thermal_thruster_air_launch`: Boolean
				- The MvM upgrade that lets you repeatedly launch without a cooldown.
			""".trimIndent(),
			applicableWeapons = listOf("The Thermal Thruster")
		),
		
		
		HierarchyAttrClassScope(
			"Invis",
			"""
			- `set_weapon_mode`: Int
				- Used to specify "invis type"
			""".trimIndent(),
			AttrClassScope(
				CLOAK,
				"""
					- `mult_decloak_rate`: Number
						- Note that values less than or equal to 0 become 1
					- On player: `mult_cloak_meter_consume_rate`: Float
						- Multiply cloak consumed per second by this value.
					- `mult_cloak_meter_regen_rate`: Float
					- `mod_cloak_no_regen_from_items`: Boolean
						- Disallows ammo boxes from affecting the cloak meter.
					- `NoCloakWhenCloaked`: Boolean
						- If true, cannot receive cloak while cloaked.
					- `ReducedCloakFromAmmo`: Float
						- Multiplier applied to cloak gained from ammo boxes.
				""".trimIndent()
			),
			applicableWeapons = listOf("TF_WEAPON_INVIS, The Dead Ringer, The Cloak and Dagger, Upgradeable TF_WEAPON_INVIS, The Quackenbirdt, The Enthusiast's Timepiece")
		),
		
		HierarchyAttrClassScope(
			"StickybombLauncher",
			"""
			- `stickybomb_charge_rate`: Float
				- Not actually the "rate", rather the time it takes to fully charge a stickybomb launch when holding MOUSE1.
			- `set_detonate_mode`: Int
				- 0 = Default "detonate all stickies on rclick" mode.
				- 1 = Scottish Resistance's "look at stickies to detonate" mechanic.
				- 2 = Old Quickiebomb Launcher's "stickies fizzle after 2 seconds" mechanic.
			- `stickies_detonate_stickies`: Boolean
				- If 1, stickies destroy other stickies.
			- `stickybomb_charge_damage_increase`: Float
				- damage = `2*basedamage * (this - 1.0) * currentChargeProportion`
			- `add_max_pipebombs`: Int
			""".trimIndent(),
			applicableWeapons = listOf("Stickybomb Launcher + Reskins, The Scottish Resistance, Sticky Jumper, The Quickiebomb Launcher")
		),
		
		HierarchyAttrClassScope(
			"BuffItem",
			AttrClassScope(
				BUFFITEMS,
				"""
					- `set_buff_type`: Int
						- Sets which banner is used
						- 0 = Buff Banner
						- 1 = Battalion's Backup
						- 2 = Concheror
					- `mod_buff_duration`: Float
						- Multiplier to buff duration
				""".trimIndent()
			),
			applicableWeapons = listOf("The Buff Banner, The Battalion's Backup, The Concheror, Festive Buff Banner, The B.A.S.E Jumper")
		),
		
		HierarchyAttrClassScope(
			"Wrench",
			AttrClassScope(
				BUILDINGS,
				"""
					- `mult_construction_value`: Float
						- Passive build-speed multiplier, same as the convar `tf_construction_build_rate_multiplier`.
					- `mult_repair_value`: Float
						- Multiplier to how much health is given per wrench hit.
				""".trimIndent(),
				AttrClassScope(
					BUILDINGS_SENTRY,
					"""
						- `wrench_builds_minisentry`: Boolean
							- Sentry built is a minisentry.
							- Detonates leveled sentries when equipping a wrench with this attribute.
							- If not in MvM (player is not on team "PVE_DEFENDERS"), detonate minis when unequipping a wrench with this attribute.
							- Removes engineer's glove on his model.
					""".trimIndent()
				),
			),
			"""
			- `alt_fire_teleport_to_spawn`: Boolean
				- If set, pressing reload shows the Eureka Effect teleport menu.
			""".trimIndent(),
			applicableWeapons = listOf(
				"Stock Wrench + Reskins, Golden Wrench, The Southern Hospitality, The Jag, The Eureka Effect",
				"The Gunslinger"
			)
		),
		HierarchyAttrClassScope(
			"RocketLauncher",
			AttrClassScope(
				PROJECTILES,
				"""
				- `mod_rocket_launch_impulse`: Boolean
					- Allows the player to rocket jump with the projectile. (note that "rocket launcher" is the base for most projectile launchers, including the Crossbow.)
				""".trimIndent()
			),
			applicableWeapons = listOf(
				"Stock Rocket Launcher + Reskins + The Original, The Black Box + Festive, Rocket Jumper, The Liberty Launcher, The Beggar's Bazooka",
				"The Direct Hit",
				"The Cow Mangler 5000"
			)
		),
		
		HierarchyAttrClassScope(
			"RocketLauncher_AirStrike",
			AttrClassScope(
				AMMO,
				AttrClassScope(
					AMMO_CLIPSIZE,
					"""
					- `clipsize_increase_on_kill`: Int
						- This attribute is on all weapons, but it's specifically checked for on the Air Strike.
					""".trimIndent()
				),
			),
			applicableWeapons = listOf("The Air Strike")
		),
		
		HierarchyAttrClassScope(
			"GrenadeLauncher",
			AttrClassScope(
				PROJECTILES,
				"""
					- `mult_projectile_speed`: Float
				""".trimIndent()
			),
			AttrClassScope(
				DAMAGE,
				"""
					- `grenade_detonation_damage_penalty`: Float
						- Flat multiplier applied to initial damage
				""".trimIndent()
			),
			"""
			- `set_detonate_mode`: Int
				- If 2 (airburst mode), makes pills shatter on surfaces.  No other values implemented.
			- `grenade_launcher_mortar_mode`: Duration
				- "Mortar" (loose cannon) detonation time length
			""".trimIndent(),
			applicableWeapons = listOf("Stock Grenade Launcher + Reskins, The Loch-n-Load, The Iron Bomber", "The Loose Cannon")
		),
		
		HierarchyAttrClassScope(
			"Crossbow",
			AttrClassScope(
				RELOADING,
				"""
					- `mult_reload_time`: Float
					- `mult_reload_time_hidden`: Float
					- `fast_reload`: Float
				""".trimIndent()
			),
			"""
			- `fires_milk_bolt`: Boolean
				- If `true`, alt-fire fires a mad-milked crossbow bolt with a meter. (Meter isn't implemented, but the milk bolt mechanism is.)
			""".trimIndent(),
			applicableWeapons = listOf("The Crusader's Crossbow, Festive Crusader's Crossbow")
		),
		
		HierarchyAttrClassScope(
			"RayGun",
			AttrClassScope(
				AMMO,
				"""
					- `energy_weapon_no_drain`: Boolean
						- Removes ammo requirement to fire weapon.
				""".trimIndent()
			),
			applicableWeapons = listOf("The Righteous Bison", "The Pomson 6000")
		),
		
		HierarchyAttrClassScope(
			"Lunchbox",
			"""
			- `set_weapon_mode`: Int
				- 0 = LUNCHBOX_STANDARD
					- Used for both the bonk atomic punch or the sandvich
				1. LUNCHBOX_ADDS_MAXHEALTH,
				2. LUNCHBOX_ADDS_MINICRITS,
				3. LUNCHBOX_STANDARD_ROBO,
				4. LUNCHBOX_STANDARD_FESTIVE,
				5. LUNCHBOX_ADDS_AMMO,
					- Fun fact: LUNCHBOX_ADDS_AMMO is fully implemented
			- `lunchbox_healing_scale`: Float
			""".trimIndent(),
			applicableWeapons = listOf("The Sandvich, The Dalokohs Bar, The Buffalo Steak Sandvich, Fishcake, The Robo-Sandvich, Festive Sandvich, The Second Banana", "Bonk! Atomic Punch, Crit-a-Cola, Festive Bonk 2014")
		),
		
		HierarchyAttrClassScope(
			"Shotgun",
			listOf(),
			applicableWeapons = listOf(
				"Stock Shotgun + Reskins, Reserve Shooter",
				"The Widowmaker",
				"The Rescue Ranger")
		),
		
		HierarchyAttrClassScope(
			"ShotgunRevenge",
			AttrClassScope(
				REVENGECRITS,
				"""
				- `sentry_killed_revenge`: Boolean
					- Specifically checked here when it tries to gain revenge crits, which means removing this attribute from the Frontier Justice will remove its ability to gain revenge crits.
				""".trimIndent(),
			),
			
			applicableWeapons = listOf("The Frontier Justice")
		),
		
		HierarchyAttrClassScope(
			"Scattergun",
			AttrClassScope(
				ONHIT,
				"""
					- `set_scattergun_has_knockback`: Boolean
						- Note: if `scattergun_knockback_mult` is greater than 1.0, this is not necessary.
					- `scattergun_knockback_mult`: Float
				""".trimIndent()
			),
			AttrClassScope(
				RELOADING,
				"""
					- `set_scattergun_no_reload_single`: Boolean
						- If 1, reloads entire clip at once.
				""".trimIndent()
			),
			applicableWeapons = listOf("Stock Scattergun + Reskins, The Force-a-Nature, The Back Scatter", "The Soda Popper", "The Baby Face's Blaster")
		),
		
		
		HierarchyAttrClassScope(
			"Knife",
			AttrClassScope(
				DAMAGE,
				"""
					- `mult_dmg`: Float
						- Base backstab damage against minibosses is 250 * this proportion.
					- On player: `armor_piercing`: Float (**PERCENTAGE**)
						- Spy only does 25% damage against minibosses by default.  The number here is added to that percentage, up to a max of 100% + 25% = 125%
						- Note that this is an actual PERCENTAGE of armor penetrated, not a proportion:  `25.0`, `50.0`, up to `100.0`.
						- Also, with max armor penetration, you apparently do 25% *more* damage against minibosses than you do against regular bots.
				""".trimIndent()
			),
			AttrClassScope(
				HEALTH,
				"""
					- `sanguisuge`: Boolean
						- Gain health on backstab.
				""".trimIndent()
			),
			AttrClassScope(
				DISGUISE,
				"""
					- `set_disguise_on_backstab`: Boolean
				""".trimIndent()
			),
			"""
			- `set_weapon_mode`: Int
				- 0: Stock
				- 1: Your Eternal Reward
				- 2: Cloak and Dagger (idk why)
				- 3: Spycicle
			- `melts_in_fire`: Boolean
			""".trimIndent(),
			applicableWeapons = listOf("Stock Knife + Reskins, Your Eternal Reward, Conniver's Kunai, The Big Earner, The Wanga Prick, The Sharp Dresser, The Spy-cicle")
		),
		
		HierarchyAttrClassScope(
			"Sword",
			AttrClassScope(
				ONKILL,
				"""
					- `decapitate_type`: Int
						- More like a boolean.  Doesn't actually determine any kind of decapitation, just if it CAN decapitate.
						- If greater than 0 on Demoman, reduces max health gained from the Knockout rune to 20.
				""".trimIndent()
			),
			applicableWeapons = listOf("The Eyelander, The Scotsman's Skullcutter, The Horseless Headless Horseman's Headtaker, The Claidheamohmor (sic), The Persian Persuader, Nessie's Nine Iron, Festive Eyelander")
		),
		
		HierarchyAttrClassScope(
			"Wearable",
			AttrClassScope(
				RESISTANCE,
				"""
					- `afterburn_immunity`: Boolean
						- For the base "`Wearable`", only checked on Sniper.
				""".trimIndent()
			),
			AttrClassScope(
				META,
				AttrClassScope(
					META_PLAYER,
					"""
						- `player_skin_override`: Int
							- Overrides the skin used for the player. (e.g. Zombie)
					""".trimIndent()
				),
				AttrClassScope(
					META_ITEMSTATS,
					"""
						- `duck_badge_level`: Int
							- Determines if ***BONUS DUCKSSSS*** should increment the badge level.
					""".trimIndent()
				),
			),
			applicableWeapons = listOf("Cosmetics", "The Manntreads, The Gunboats", "The Razorback, Darwin's Danger Shield, The Cozy Camper", "Ali Baba's Wee Booties, The Bootlegger")
		),
		
		HierarchyAttrClassScope(
			"WearableDemoShield",
			AttrClassScope(
				DEMOCHARGE,
				"""
				- `attack_not_cancel_charge`: Boolean
				- On player: `mod_charge_time`: Float
					- Charge time mult
				- On player: `charge_impact_damage`: Float
					- Impact damage mult
				""".trimIndent()
			),
			AttrClassScope(
				RESISTANCE,
				"""
					- `afterburn_immunity`: Boolean
				""".trimIndent()
			),
			applicableWeapons = listOf("The Chargin' Targe, The Splendid Screen, The Tide Turner, Festive Targe 2014")
		),
		
		HierarchyAttrClassScope(
			"FlareGun",
			"""
			- `set_weapon_mode`: Int
				- 0: Normal
				- 1: Detonator
				- 2: Manmelter
				- 3: Scorch Shot
			""".trimIndent(),
			applicableWeapons = listOf("The Flare Gun, The Scorch Shot, The Detonator", "The Manmelter")
		),
		
		HierarchyAttrClassScope(
			"Jar",
			AttrClassScope(
				PROJECTILES,
				"""
					- `override_projectile_type`: TFProjectileType
						- Used to select the model
						- Select between `TF_PROJECTILE_FESTIVE_JAR`, `TF_PROJECTILE_BREADMONSTER_JARATE`, and `TF_PROJECTILE_BREADMONSTER_MADMILK`
						- Otherwise uses default for its class
				""".trimIndent()
			),
			AttrClassScope(
				METER,
				"""
					- `extinguish_reduces_cooldown`: Float
						- Subtracts this value from the cooldown
				""".trimIndent()
			),
			AttrClassScope(
				ONHIT,
				"""
					- On player: `applies_snare_effect`: Float
						- If NOT `1.0`, stun the victim
				""".trimIndent()
			),
			applicableWeapons = listOf(
				"Jarate, Festive Jarate, The Self-Aware Beauty Mark",
				"Mad Milk, Mutated Milk",
				"The Flying Guillotine",
				"The Gas Passer",
				"Unimplemented Spy Decoy Weapon"
			)
		),
		
		HierarchyAttrClassScope(
			"MechanicalArm",
			applicableWeapons = listOf("The Short Circuit")
		),
		
		HierarchyAttrClassScope(
			"Throwable",
			"""
			- `throwable_recharge_time`: Float
			- `throwable_detonation_time`: Float
			- `is_throwable_primable`: Boolean
				- For timed explosions
			- `is_throwable_chargeable`: Boolean
				- For things like distance/power increases
			""".trimIndent(),
			applicableWeapons = listOf("Spellbook")
		),
		
		HierarchyAttrClassScope(
			"SniperRifle",
			AttrClassScope(
				DAMAGE,
				"""
					- `sniper_full_charge_damage_bonus`: Float
						- If greater than 1.0, weapon plays cool fully-charged-Machina railgun sound when firing at full charge.
				""".trimIndent()
			),
			AttrClassScope(
				ONHIT,
				"""
					- `applies_snare_effect`: Float
						- Multiplier applied to target move-speed on hit
						- Duration is equal to the rifle's `jarate_duration` attribute
				""".trimIndent()
			),
			"""
			- `set_weapon_mode`: Int
				- 0: Normal
				- 1: Sydney Sleeper
				- 2: Machina
				- 3: Classic
			- `set_buff_type`: Int
				- If greater than 0, activates rage buff when pressing reload and rage meter is full (or above full).
			- `mult_sniper_charge_per_sec`: Float
			- `mult_sniper_charge_per_sec_with_enemy_under_crosshair`: Float
			- `fast_reload`: Float
				- Mult to zoom and unzoom delay on clipless weapons
				- Fun fact: this is also affected by the Precision mannpower powerup
			- `ability_master_sniper`: Int
				- Mult to zoom/unzoom delay on clipless weapons
					- mult by level: 1=0.6, 2=0.3
				- Mult to charge speed
					- 1=1.5, 2=3.0
			- `sniper_beep_with_enemy_under_crosshair`: Float
				- Cast to an int, treated like a boolean
				- plays `doomsday.warhead` sound when an enemy appears under your crosshair
			- `sniper_only_fire_zoomed`: Boolean
			- `sniper_penetrate_players_when_charged`: Boolean
			- `sniper_no_headshot_without_full_charge`: Boolean
			- `sniper_crit_no_scope`: Boolean
				- Whether the rifle can headshot without being zoomed.
				- Funnily enough, it checks if your FOV is lower than your default FOV to see if you're zoomed.
			- On attacker: `explosive_sniper_shot`: Int
				- Level of explosive headshot
			- `jarate_duration`: Float
				- If greater than 0:
					- Makes weapon not eject brass
					- Makes weapon only penetrate non-burning teammates, as opposed to penetrating all teammates
				- Note: Not actually used in Sydney Sleeper Jarate calculation, as far as I could tell.
			- `aiming_no_flinch`: Boolean
				- Prevents flinching from damage when scoped and fully charged.
			""".trimIndent(),
			applicableWeapons = listOf(
				"Stock Sniper Rifle + Reskins, The Sydney Sleeper, The Machina, The Hitman's Heatmaker, Shooting Star",
				"The Bazaar Bargain",
				"The Classic"
			)
		),
		
		HierarchyAttrClassScope(
			"Medigun",
			"""
			- `mult_medigun_healrate`: Float
			- On player: `preserve_ubercharge`: Int
				- Percentage saved on death or dropping weapon (e.g. `25` = 25% uber)
			- `healing_mastery`: Int
			- `set_weapon_mode`: Int
				- Determines medigun type
			- `set_charge_type`: Int
				- Ubercharge type. Each resist uber also has its own entry
			- `medic_machinery_beam`: Boolean
				- Allows medigun to target buildings
			- `mult_medigun_overheal_amount`: Float
				- Bonuses are additive, penalties are percentage
			- `mult_medigun_overheal_decay`: Float
			- On owner: `overheal_expert`: Float
				- Overheal bonus = overheal bonus + overhealexpert/4 or just overheal bonus, whichever is higher
				- decay mult is same but divided by 2
			- `permanent_medic_shield`: Boolean (UNIMPLEMENTED)
				- Only allowed in MvM
			- On owner: `mult_medigun_overheal_uberchargerate`: Float
			- On owner: `mult_medigun_uberchargerate`: Float
			- On owner: `add_uber_time`: Int
			- On owner: `generate_rage_on_heal`: Int
				- This is your shield level
			""".trimIndent(),
			applicableWeapons = listOf("Stock Medigun + Reskins, The Kritzkrieg, The Quick-Fix, The Vaccinator")
		),
		
		HierarchyAttrClassScope(
			"Builder",
			"""
			- On owner: `mark_for_death_on_building_pickup`: Boolean
			- `sapper_voice_pak`: Float
				- If 1.0, it's a wheatley sapper
			- `robo_sapper`: Int
				- If greater than 0 on base builder: If building an OBJ_ATTACHMENT_SAPPER on a mode that allows upgrades and it's built on a player (or MvM bot), gives the sapper a radius instead of being single-target
			""".trimIndent(),
			applicableWeapons = listOf("Construction PDA, Unimplemented Spy PDA")
		),
		
		HierarchyAttrClassScope(
			"CompoundBow",
			"""
			- `fast_reload`: Float
				- Mult applied to reload speed
			- `ability_master_sniper`: Int
				- Applies mult to reload speed: 1 = 0.6, 2 = 0.3
				- Does not stack with Haste powerup
			""".trimIndent(),
			applicableWeapons = listOf("The Huntsman, Festive Huntsman, The Fortified Compound")
		),
		
		HierarchyAttrClassScope(
			"Bat",
			"""
			- `set_weapon_mode`: Int
				- If 0, cannot create a ball
			""".trimIndent(),
			applicableWeapons = listOf("TF_WEAPON_BAT, Upgradeable TF_WEAPON_BAT, The Candy Cane, The Boston Basher, Sun-on-a-Stick, The Fan O'War, The Atomizer, Three-Rune Blade, Festive Bat 2011, Batsaber")
		),
		
		
		
		/// Player attributes
		HierarchyAttrClassScope(
			"Player",
			AttrClassScope(
				AMMO,
				"""
					- `grenades1_resupply_denied`: Boolean
					- `grenades2_resupply_denied`: Boolean
					- `grenades3_resupply_denied`: Boolean
					- `addperc_ammo_regen`: Float
						- Percentage of ammo regenerated every 5 seconds.
					- `mult_metal_pickup`: Float
						- Multiplier applied to metal gained from ammo boxes
					- `add_metal_regen`: Int
						- Amount of metal regenerated every 5 seconds.
				""".trimIndent(),
				AttrClassScope(
					AMMO_MAXAMMO,
					"""
						- `mult_maxammo_primary`: Int
						- `mult_maxammo_secondary`: Int
						- `mult_maxammo_metal`: Int
						- `mult_maxammo_grenades1`: Int
							- Only used for bat balls
					""".trimIndent()
				),
			),
			AttrClassScope(
				BUFFITEMS,
				"""
					- `set_buff_type`: Int
						- Note that Phlogistinator's rage has a small cooldown after expiring before it can gain rage again, to prevent the lingering crit flames from immediately filling it up again.
					- `mod_buff_duration`: Float
						- Multiplier applied to buff duration.
					- `mod_soldier_buff_range`: Float
						- Multiplier applied to the default 450 hammer unit range on banners.
				""".trimIndent()
			),
			AttrClassScope(
				BUILDINGS,
				"""
					- `mod_build_rate`: Float
						- Multiplies building build time by this amount
					- `upgrade_rate_mod`: Int
						- Multiplier to the amount of metal given to any building hit by this player, using player's metal reserve
						- Recall that all players have 100 hidden metal
					- `mult_engy_building_health`: Float
						- Only applied if the building is NOT a disposable sentry
					- `cannot_pick_up_buildings`: Boolean
						- Prevents player from picking up buildings.
					- `building_cost_reduction`: Int
						- Multiplier to the metal required to construct a building.
				""".trimIndent(),
				AttrClassScope(
					BUILDINGS_SENTRY,
					"""
						- `sentry_build_rate_multiplier`: Float
						- `mvm_sentry_ammo`: Float
							- Multiplier to max ammo
						- `mult_sentry_range`: Float
						- `mult_sentry_firerate`: Float
						- `build_small_sentries`: Boolean
							- If true, upgrade metal is only 150 instead of 200
							- Also creates a sentry that's 80% size
						- `engy_disposable_sentries`: Int
							- Number of disposable sentries you're allowed to build.
							- Checked when checking if the player can build something.
							- Only works if the "uses upgrades" gamerule is set.
					""".trimIndent(),
				),
				AttrClassScope(
					BUILDINGS_DISPENSER,
					"""
						- `mult_dispenser_rate`: Float
							- Dispenser resupply rate for health, ammo, and metal
						- `mult_dispenser_radius`: Float
						- `teleporter_build_rate_multiplier`: Float
							- Multiplier applied to passive build time for dispensers and teleporters.
					""".trimIndent()
				),
				AttrClassScope(
					BUILDINGS_TELEPORTER,
					"""
						- `mod_teleporter_speed_boost`: Boolean
							- If true, teleporter adds speed boost condition with arg 4.0 to teleported player
						- `bidirectional_teleport`: Boolean
						- `mult_teleporter_recharge_rate`: Float
						- `mod_teleporter_cost`: Float
							- Multiplier applied to teleporter construction cost
						- `teleporter_build_rate_multiplier`: Float
							- Multiplier applied to passive build time for dispensers and teleporters.
					""".trimIndent()
				)
			),
			AttrClassScope(
				CLOAK,
				"""
					- `cloak_blink_time_penalty`: Float
						- Multiplier
					- `mult_cloak_rate`: Float
					- `set_quiet_unstealth`: Boolean
						- If true, plays `Player.Spy_UnCloakReduced` when decloaking
					- `mult_decloak_rate`: Float
				""".trimIndent()
			),
			AttrClassScope(
				DAMAGE,
				"""
					- `boots_falling_stomp`: Boolean
						- Deal 3x falling damage to player you land on
					- `headshot_damage_modify`: Float
						- Multiplier applied to headshot damage
				""".trimIndent(),
				AttrClassScope(
					"Alien",
					"""
						- `alien_isolation_xeno_bonus_pos`: Boolean
							- Deal extra damage to players wearing the Alien set.
						- `alien_isolation_merc_bonus_pos`: Boolean
							- Deal extra damage to players wearing the Xenomorph set.
					""".trimIndent()
				),
			),
			AttrClassScope(
				DEMOCHARGE,
				"""
					- `charge_turn_control`: Float
						- Default is 0.45f, and this is a multiplier applied to it
					- `lose_demo_charge_on_damage_when_charging`: Boolean
						- Used to detect the Tide Turner when deciding whether to give you minicrits or crits
					- `kill_refills_meter`: Float
						- Amount of targe-charge meter gained on kill.  Scaled by various values.
					- `mod_charge_time`: Float
						- Only applies to Demoman, even if a targe is equipped on another class.
						- Flat multiplier applied to total charge time when charging
					- `charge_recharge_rate`: Float
						- Only applies to Demoman
				""".trimIndent()
			),
			AttrClassScope(
				DISGUISE,
				"""
				- `disguise_no_burn`: Boolean
					- Prevent afterburn while disguised
				- `set_cannot_disguise`: Boolean
				- `disguise_as_dispenser_on_crouch`: Boolean
					- While crouched, use the Dispenser model.
					- Hardcoded in vanilla for Spy.
				""".trimIndent()
			),
			AttrClassScope(
				FIRING,
				"""
					- `no_attack`: Boolean
						- Prevents player from attacking.
				""".trimIndent()
			),
			AttrClassScope(
				HEADS,
				"""
					- `add_head_on_hit`: Boolean
						- This attribute only works on players that are a Medic wielding the Vitasaw. For the all-class version, see `extra_damage_on_hit` (unimplemented in vanilla, accessible via Rafmod).
						- Gives extra player movespeed the more heads you have. (Partially implemented.)
						- Will not work if the player is not a Medic wielding the VitaSaw.
			    """.trimIndent()
			),
			AttrClassScope(
				HEALTH,
				"""
					- `healing_mastery`: Int
						- On Medic only, each level raises the Medic's passive regen by 25% of its normal value.
					- `mult_health_frompacks`: Float
					- `mult_healing_from_medics`: Float
						- Specifically checked on Crossbow Bolt impacts.
					- `mult_health_fromhealers`: Float
						- Applies to all heal-beam sources of healing: Dispensers, Mediguns
					- `weapon_blocks_healing`: Boolean
						- If set, this player may not be targeted by heal-beams or healed from Crossbow impacts.
					- `add_health_regen`: Int
						- Amount of health regenerated per regen tick.  Scales by the amount of time since the player last took damage in non-MvM modes.
					- `add_maxhealth_nonbuffed`: Int
						- Additive maximum health increase that does not influence the player's overheal cap. See also: [addMaxHealth]
					- `add_maxhealth`: Int
						- Additive maximum health increase. Influences the player's overheal cap.
				""".trimIndent()
			),
			AttrClassScope(
				HUD,
				"""
					- `set_custom_buildmenu`: Int
						- Only used if the build menu is actually shown.
						- 0 = default
						- 1 = pipboy
						- Works on Engineer and Spy (if you can give him a build menu)
					- `appear_as_mvm_robot`: Boolean
						- If true, appear as an MvM robot in your hud when selecting a class. (Not fully implemented.)
					- `see_enemy_health`: Boolean
					- `hide_enemy_health`: Boolean
						- Always true in MvM
				""".trimIndent()
			),
			AttrClassScope(
				KNOCKBACK_RECEIVED,
				"""
					- `airblast_vulnerability_multiplier`: Float
					- `airblast_vertical_vulnerability_multiplier`: Float
					- `mult_aiming_knockback_resistance`: Float
						- Only works on Sniper.
				""".trimIndent()
			),
			
			AttrClassScope(
				META,
				"""
					- `scoreboard_minigame`: Boolean
						- If true, add `kills + captures + defenses + buildingsdestroyed - (3 * deaths)` to player score, on top of the default scoring algorithm
					- `spawn_with_physics_toy`: Int
						- If 1, create a soccer ball on the ground when the player spawns.
					- `calling_card_on_kill`: Int
						- Defines the calling card that should be dropped when this player kills another player.
				""".trimIndent(),
				AttrClassScope(
					META_KILLFEED,
					"""
						- `fish_damage_override`: Boolean
							- If the weapon is a Holy Mackerel reskin (AKA either the fish or the Unarmed Combat) and this is set, use the Unarmed Combat "arm hit" killfeed notice instead of the "fish hit" notice.
					""".trimIndent()
				),
				AttrClassScope(
					META_NOISEMAKER,
					"""
						- `enable_misc2_noisemaker`: Boolean
							- Uses noise maker when pressing action slot key
						- `unlimited_quantity`: Boolean
							- If true, noisemakers are unlimited usage.
					""".trimIndent()
				),
				AttrClassScope(
					META_ITEMSTATS,
					"""
						- `killstreak_tier`: Int
						
					""".trimIndent()
				),
				AttrClassScope(
					META_PLAYER,
					"""
						- `add_jingle_to_footsteps`: Int
							- If 1, use xmas.jingle, if 2 or higher use xmas.jingle_higher
						- `halloween_footstep_type`: Int
							- Decimal version of the 4-byte hex code determining color of footsteps (e.g. `0xFFFFFFFF`, but in decimal)
						- `override_footstep_sound_set`: FootstepOverride
						- `bombinomicon_effect_on_death`: Boolean
						- `zombiezombiezombiezombie`: Boolean
							- If true, the Voodoo-Cursed Soul skin is equipped.
						- `head_scale`: Float
						- `torso_scale`: Float
						- `hand_scale`: Float
						- `special_dsp`: Int
							- DSP used when emitting sounds created by this player.
					""".trimIndent()
				),
				AttrClassScope(
					META_GAMEPLAY,
					"""
						- `add_player_capturevalue`: Int
						- `canteen_specialist`: Int
							- Discounts canteens by 10 * level
						- `cannot_pick_up_intelligence`: Boolean
						- `force_distribute_currency_on_death`: Boolean
							- Only works in MvM. Automatically collects the money this player would drop on death, as though they were killed by a sniper.
					""".trimIndent()
				),
				AttrClassScope(
					META_PARTICLES,
					"""
					- `particle_effect_use_head_origin`: Boolean
					- `particle_effect_vertical_offset`: Float
					""".trimIndent()
				),
			),
			AttrClassScope(
				METER,
				"""
					- `generate_rage_on_heal`: Boolean
						- Gain shield meter from damage healed. Only works on Medic.
					- `rage_on_kill`: Float
						- Amount of Sniper rage gained on kill.  Only works on Sniper.
					- `hype_resets_on_jump`: Int
						- Lose this amount of hype if you airdash
						- Note that this only applies to scout hype, not rage in general
					- `generate_rage_on_dmg`: Boolean
						- Only works on Engineer and Heavy.
						- On Engineer, adds all damage dealt to the rage meter.
						- On Heavy, adds `0.22` * the damage to the meter, and reduces damage by 50% while the meter is draining.
					- `rage_giving_scale`: Float
						- Multiplier applied to rage gained by dealing damage, taking damage, or dealing burn damage.
					- `hype_on_damage`: Boolean
						- Adds the amount of damage dealt to the Scout hype meter, to a maximum of 200 damage which adds 50% meter.
					- `rage_on_assists`: Float
						- Only procs on Sniper. Gain this amount of rage meter on assists.
					- `hype_resets_on_jump`: Int
						- The amount to be subtracted from the hype meter when the Scout double-jumps.
					- `item_meter_charge_type`: TFMeterRechargeType
						- If `mult_item_meter_charge_rate` is set, checks this attribute to see what type of meter should be modified, and also only allows it to activate if the active weapon is not a TF_WEAPON_FLAMEBALL
					- `hype_decays_over_time`: Float
						- How much the Scout's hype meter decays every tick
					- `lose_hype_on_take_damage`: Int
						- Amount of hype lost per point of damage taken.
				""".trimIndent(),
			),
			AttrClassScope(
				MOVEMENT,
				"""
					- `cannot_swim`: Boolean
						- Forbids you from floating upwards with the jump button in the water
					- `mod_jump_height`: Float
					- `parachute_attribute`: Boolean
						- Allows parachute to be deployed. Parachute prop only appears if the BASE Jumper is equipped, but the functionality is the same regardless.
					- `parachute_disabled`: Boolean
						- Prevents parachute from being deployed, but still allows it to be retracted.
					- `cannot_swim`: Boolean
						- If the jump button should work while in waist-high water
						- Also makes you sink like a stone in water instead of being able to move freely
					- `swimming_mastery`: Boolean
						- If false or not present, move speed is 80% while swimming
					- `mod_air_control`: Float
						- Note: the jetpack condition always multiplies your air acceleration by 50%
					- `mod_air_control_blast_jump`: Float
						- Specifically while blast-jumping, as opposed to global
					- `can_breathe_under_water`: Boolean
					- `no_jump`: Boolean
						- Prevents player from jumping.
					- `no_duck`: Boolean
						- Prevents player from crouching.
					- `set_scout_doublejump_disabled`: Boolean
					
				""".trimIndent(),
				AttrClassScope(
					MOVEMENT_MOVESPEED,
					"""
						- `mult_player_aiming_movespeed`: Float
							- Only applies to players that have TF_COND_AIMING
							- If Heavy, default aiming movespeed is 110
							- Else if player is using a compound bow, 160
							- Else 80
						- `mult_player_movespeed`: Float
						- `mult_player_movespeed_shieldrequired`: Float
					""".trimIndent()
				),
			),
			AttrClassScope(
				ONHIT,
				AttrClassScope(
					"Falling",
					"""
						- `falling_impact_radius_pushback`: Boolean
							- Requires player to have the `TF_COND_ROCKETPACK` condition.
							- Pushes back nearby players around the landing site.
						- `falling_impact_radius_stun`: Boolean
							- If `falling_impact_radius_pushback` is set, this will also stun any enemies in the impact radius.
					""".trimIndent()
				),
			),
			AttrClassScope(
				ONKILL,
				"""
				- `drop_health_pack_on_kill`: Boolean
					- Drop a small health pack when killing an enemy.
				- `kill_forces_attacker_to_laugh`: Boolean
					- On killing an enemy, schadenfreude
				- `decapitate_type`: Int
					- More like a boolean.  Doesn't actually determine any kind of decapitation, just if it CAN decapitate.
					- Checked on all hitscan attacks, including melee swings.
				- `add_cloak_on_kill`: Int
					- Value: amount of cloak gained on kill.
					- Only works on Spy.
				""".trimIndent()
			),
			AttrClassScope(
				RESISTANCE,
				"""
				- `mult_dmgtaken_from_crit`: Float
				- `mult_dmgtaken_from_fire`: Float
				- `mult_dmgtaken_from_explosions`: Float
				- `mult_dmgtaken_from_bullets`: Float
				- `mult_dmgtaken_from_melee`: Float
				- `mult_dmgtaken`: Float
					- Multiplier to damage taken from all sources.
				- `dmg_from_sentry_reduced`: Float
				- `rocket_jump_dmg_reduction`: Float
					- Multiplier applied to damage taken IF: it's blast damage or a flare explosion, the damage was caused by the user (self-damage), the user did not damage other players, and it is not a taunt-kill grenade (Escape Plan, Equalizer)
				- `cancel_falling_damage`: Boolean
				- `wet_immunity`: Boolean
					- Cannot have "wet" statuses applied: Jarate, Mad Milk, Gas
				- `spunup_damage_resistance`: Float
					- Only procs on Heavies that are currently spun up on less than 50% HP
				""".trimIndent(),
				AttrClassScope(
					"Vaccinator",
					"""
						- `medigun_bullet_resist_deployed`: Float
							- Multiplier to damage taken if player has TF_COND_MEDIGUN_UBER_BULLET_RESIST
						- `medigun_bullet_resist_passive`: Float
							- Multiplier to damage taken if player has TF_COND_MEDIGUN_SMALL_BULLET_RESIST
						- `medigun_blast_resist_deployed`: Float
							- Multiplier to damage taken if player has TF_COND_MEDIGUN_UBER_BLAST_RESIST
						- `medigun_blast_resist_passive`: Float
							- Multiplier to damage taken if player has TF_COND_MEDIGUN_SMALL_BLAST_RESIST
						- `medigun_fire_resist_deployed`: Float
							- Multiplier to damage taken if player has TF_COND_MEDIGUN_UBER_FIRE_RESIST
						- `medigun_fire_resist_passive`: Float
							- Multiplier to damage taken if player has TF_COND_MEDIGUN_SMALL_FIRE_RESIST
					""".trimIndent()
				),
			),
			AttrClassScope(
				TAUNTING,
				"""
					- `mult_gesture_time`: Float
						- Multiplier applied to taunt speed.
					- `cosmetic_taunt_sound`: String
						- Sound to be played when performing a taunt.
					- `custom_taunt_particle_attr`: Boolean
						- Use Saharan Spy particle effect when performing a stock knife taunt.  Only works on Spy.
				""".trimIndent()
			),
			AttrClassScope(
				WEAPONSWITCH,
				"""
					- `disable_weapon_switch`: Boolean
				""".trimIndent()
			),
			AttrClassScope(
				WHENHIT,
				"""
					- `uber_on_damage_taken`: Float
						- Chance to gain stock uber effect when hit
					- `mod_mark_attacker_for_death`: Float
						- Number of seconds the player who hit this entity should be marked for death.
						- If attacker is affected by `TF_COND_ENERGY_BUFF` (Crit-a-Cola, Cleaner's Carbine, Buffalo Steak, etc.), the attacker receives `TF_COND_MARKEDFORDEATH_SILENT`
					- `jarate_backstabber`: Boolean
						- If true, jarates anyone who backstabs this player.
						- Note: does not block backstabs on its own.
					- `teleport_instead_of_die`: Float
						- Chance to teleport back to spawn upon receiving fatal damage instead of dying.
				""".trimIndent()
			),
			AttrClassScope(
				RESISTANCE,
				"""
					- `cannot_be_backstabbed`: Boolean
				""".trimIndent()
			),
			
			AttrClassScope(
				"SpyOnly",
				"""
				- `override_engineer_object_type`: Int
					- Default = -1
					- If 0, Spy can build a catapult
				""".trimIndent()
			)
		),
		HierarchyAttrClassScope(
			"MvMBot",
			"""
			- `bot_custom_jump_particle`: Boolean
				- If true, spawns a rocketjump particle whenever the robot jumps
			- `bot_medic_uber_health_threshold`: Int
				- Defaults to 50, I guess it's a percentage
			- `bot_medic_uber_deploy_delay_duration`: Int
				- Defaults to -1
			""".trimIndent(),
		),
		
		HierarchyAttrClassScope(
			"BaseProjectile",
			"""
			- `mad_milk_syringes`: Boolean
				- If true, applies mad milk to hit target for 4 seconds, with successive hits adding 0.5 seconds to the effect time per shot.
			""".trimIndent(),
		),
		
		HierarchyAttrClassScope(
			"BaseRocket",
			"""
			- `mini_rockets`: Boolean
				- Uses the "mini rockets" model
			- `rocketjump_attackrate_bonus`: Float
			- `mult_projectile_speed`: Float
			- `rocket_specialist`: Int
			- `halloween_pumpkin_explosions`: Boolean
				- Does pumpkin bombs particle effect
			- `use_large_smoke_explosion`: Int
				- Use the big MvM particle when it explodes
			- `mult_explosion_radius`: Float
			- `no_self_blast_damage`: Boolean
				- Also uses plunger model
			- `mult_explosion_radius`: Float
			- `rocket_specialist`: Int
				- If greater than 0, rocket does not have damage falloff
			""".trimIndent(),
		),
		
		HierarchyAttrClassScope(
			"ProjectileRocket",
			"""
			- `halloween_pumpkin_explosions`: Boolean
				- Checks on owner or sentry's owner
			""".trimIndent(),
		),
		
		HierarchyAttrClassScope(
			"ProjectileFlare",
			"""
			- On launcher: `mult_projectile_speed`: Float
			- On launcher: `mult_explosion_radius`: Float
			- On launcher: `mod_projectile_heat_seek_power`: Float
			""".trimIndent(),
			applicableWeapons = listOf("The Flare Gun, The Detonator, The Manmelter, The Scorch Shot")
		),
		
		HierarchyAttrClassScope(
			"ProjectileGrenade",
			"""
			- On launcher: `use_large_smoke_explosion`: Boolean
			- On launcher: `halloween_pumpkin_explosions`: Boolean
			- On launcher: `mult_explosion_radius`: Float
			- On owner: `fuse_mult`: Float
			""".trimIndent(),
			applicableWeapons = listOf("Stock Grenade Launcher, The Iron Bomber, The Loose Cannon")
		),
		
		HierarchyAttrClassScope(
			"ProjectileEnergyRing",
			"""
			- On owner: `energy_weapon_penetration`: Boolean
			""".trimIndent(),
			applicableWeapons = listOf("The Righteous Bison, The Pomson 6000")
		),
		
		HierarchyAttrClassScope(
			"ProjectileArrow",
			"""
			- On player: `arrow_heals_buildings`: Boolean
			""".trimIndent(),
			applicableWeapons = listOf("The Huntsman, The Crusader's Crossbow, The Rescue Ranger")
		),
		
		HierarchyAttrClassScope(
			"ProjectileStickybomb",
			"""
			- On launcher: `stickybomb_fizzle_time`: Float
			- On launcher: `grenade_no_bounce`: Boolean
			- On launcher: `sticky_arm_time`: Float
			- On launcher: `grenade_damage_reduction_on_world_contact`: Float
			""".trimIndent(),
		),
		
		
		HierarchyAttrClassScope(
			"PowerUpBottle",
			AttrClassScope(
				"Type",
				"""
				- `critboost`: Boolean
				- `ubercharge`: Boolean
				- `recall`: Boolean
				- `refill_ammo`: Boolean
				- `building_instant_upgrade`: Boolean
				""".trimIndent()
			),
			"""
				- `powerup_duration`: Float
				- On player: `canteen_specialist`: Int
					- Adds extra time to the base powerup duration based on level
				- `powerup_max_charges`: Int
				- `set_weapon_mode`: Int
					- If 1, is "base" powerup canteen
			""".trimIndent()
		),
		
		
		
		HierarchyAttrClassScope(
			"EconEntity",
			AttrClassScope(
				META,
				AttrClassScope(
					META_ITEMSTATS,
					"""
						- `is_festivized`: Boolean
							- Attaches festivizer
				    """.trimIndent()
				),
				AttrClassScope(
					META_PARTICLES,
					"""
						- `set_attached_particle_static`: Int (index into ItemSchema AttributeControlledParticleSystem)
							- Attaches static particle, such as smoking a pipe
							- Cosmetics can only have one.
						- `set_attached_particle`: Int (index into ItemSchema AttributeControlledParticleSystem)
							- Dynamic particle systems, such as unusuals
						- `throwable_particle_trail_only`: Boolean
							- If false, attaches the `set_attached_particle` to the item itself
							- If true, the particle only applies to the throwable particle trail.
				    """.trimIndent()
				),
			),
		),
	)
	
	val specificallyCheckedAttributes: List<Pair<String, List<ISortedNamedAttribute>>> get() {
		operator fun String.invoke(kType: String, notes: List<String> = listOf(), codec: FakeCodec? = null): NamedAttribute {
			return NamedAttribute(
				this,
				"",
				"",
				null,
				null
			).apply {
				this.notes = notes
				this.forceType = kType
				codec?.let { this.setCodec { codec } }
			}
		}
		
		fun LoHi(lo: String, hi: String, notes: List<String> = listOf()): LongAttributeHiLo {
			return LongAttributeHiLo(lo("Int"), hi("Int"), notes)
		}
		
		val DURATION_IN_SECONDS = FakeCodec("Duration", "DURATION_IN_SECONDS")
		return listOf<Pair<String, List<ISortedNamedAttribute>>>(
			"EconEntity" to listOf(
				NamedAttributeScope(
					"WarPaints",
					"paintkit_proto_def_index"("Int", notes=listOf("Value: War Paint index")),
					"set_item_texture_wear"("WarPaintsAttributes.Wear"),
					"texture_wear_default"("WarPaintsAttributes.Wear"),
					LoHi("custom_paintkit_seed_lo", "custom_paintkit_seed_hi")
				),
				NamedAttributeScope(
					META,
					NamedAttributeScope(
						META_GAMEPLAY,
						"allowed in medieval mode"("Boolean"),
						
					),
					NamedAttributeScope(
						META_NOISEMAKER,
						"duck badge level"("Int", notes=listOf("Determines how fast the duck noisemaker can be activated."))
					),
					NamedAttributeScope(
						META_ITEMSTATS,
						"weapon_uses_stattrak_module"("Boolean"),
//						LoHi("quest loaner id low", "quest loaner id hi"),
//						"expiration date"("Date", codec=FakeCodec("DateTo")),
						"item name text override"("String"),
						"quality text override"("String"),
						"set item tint RGB"("java.awt.Color", codec=FakeCodec("Color", "ColorCodec")),
						"set item tint RGB 2"("java.awt.Color", codec=FakeCodec("Color", "ColorCodec"), notes=listOf("Used for team-color paints.")),
					),
					NamedAttributeScope(
						META_PARTICLES,
						"attach particle effect"("Int", notes=listOf("Value: particle index")),
						"hat only unusual effect"("Int", notes=listOf("Value: particle index")),
						"taunt only unusual effect"("Int", notes=listOf("Value: particle index")),
						"taunt attach particle index"("Int", notes=listOf("Value: particle index")),
					)
				),
				NamedAttributeScope(
					TAUNTING,
					"taunt is press and hold"("Boolean"),
					"taunt mimic"("Boolean", notes=listOf("Check if this taunt can be mimicked by other players.")),
					"taunt success sound"("Sound"),
					"taunt success sound offset"("Duration", codec= DURATION_IN_SECONDS),
					"taunt success sound loop"("String"),
					"taunt success sound loop offset"("Duration", codec= DURATION_IN_SECONDS),
					"taunt attack name"("String"),
					"taunt attack time"("Duration", codec=DURATION_IN_SECONDS)
				),
			),
			"Wearable" to listOf(
				NamedAttributeScope(
					META,
					"additional halloween response criteria name"("String"),
				)
			),
			"ProjectileSyringe" to listOf(
				"projectile particle name"("String", notes=listOf("Sets the projectile trail."))
			),
			"BaseGun" to listOf(
				"custom projectile model"("String", notes=listOf("Value is the path to a projectile model. Models must be precached."))
			),
			"PowerUpBottle" to listOf(
				"powerup charges"("Int", notes=listOf("The current number of charges in the canteen."))
			),
			"Flamethrower" to listOf(
				NamedAttributeScope(
					FLAMES,
					"fire particle blue"("String"),
					"fire particle blue crit"("String"),
					"fire particle red"("String"),
					"fire particle red crit"("String"),
				)
			),
			"BaseEntity" to listOf(
				NamedAttributeScope(
					METER,
					"meter_label"("String")
				),
			),
			"MvMBot" to listOf(
				NamedAttributeScope(
					HEALTH,
					"health regen"("Int", notes=listOf("Health regained per second when the bomb carrier is at stage 2 of self-upgrading."))
				)
			),
			"Player" to listOf(
				NamedAttributeScope(
					TAUNTING,
					"taunt force weapon slot"("String", notes=listOf("Taunting force-equips a certain weapon slot"))
				)
			),
			"Jar" to listOf(
				NamedAttributeScope(
					PROJECTILES,
					"projectile entity name"("String")
				)
			)
		)
	}
	
	val attributeClassesAlsoChecked = listOf(
		"no_attack",
		"no_jump",
		"no_duck"
	)
	
	/*
	strange_attr_set_t g_KillEaterAttr[] =
	{
		strange_attr_set_t( "kill eater",			"kill eater score type",		"strange restriction type 1",		"strange restriction value 1",		false ),
		strange_attr_set_t( "kill eater 2",			"kill eater score type 2",		"strange restriction type 2",		"strange restriction value 2",		false ),
		strange_attr_set_t( "kill eater 3",			"kill eater score type 3",		"strange restriction type 3",		"strange restriction value 3",		false ),
	
		// assumption: all of the user-customizable attributes will follow all of the schema-specified attributes
		strange_attr_set_t( "kill eater user 1",	"kill eater user score type 1",	"strange restriction user type 1",	"strange restriction user value 1",	true ),
		strange_attr_set_t( "kill eater user 2",	"kill eater user score type 2", "strange restriction user type 2",	"strange restriction user value 2",	true ),
		strange_attr_set_t( "kill eater user 3",	"kill eater user score type 3", "strange restriction user type 3",	"strange restriction user value 3",	true ),
	};
	 */
}

fun String.notesToAttrClassUsages(): List<IAttrThing> {
	return this.lineSequence()
		.filter { it.isNotBlank() }
		.joinToString("\n")
		.splitToSequence("\n-")
		.mapIndexed { i, it ->
			AttrClassUsage((if (i > 0 && !it.startsWith("-")) "-" else "") + it.trim('\t'))
		}
		.toList()
}
