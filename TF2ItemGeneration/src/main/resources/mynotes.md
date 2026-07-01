## BaseCombatWeapon
- `mod_use_metal_ammo_type`: Boolean
    - Reminder: non-engies start with 100 metal.
- `mod_max_primary_clip_override`: Int
    - Overwrites the max clipsize to a flat value. Applied before other multipliers.
- `mod_no_reload_display_only`: Float
    - In the "DoesReloadSingly" check, this _is_ actually checked, so it's actually _not_ "display-only".
    - If != 1.0 (if present), says the weapon "does not reload one shot at a time".
- `set_scattergun_no_reload_single`: Boolean
    - Checked in the same place.  If true, weapon does not reload one shot at a time. (e.g. FaN)
    - Note that for the most part, this logic is set inside the weapon itself. The scattergun thing is weirdly the only way to control this with attributes.
## WeaponBase
- *Inherits from: [BaseCombatWeapon](#BaseCombatWeapon)*
- These attributes are just checked against an arbitrary weapon, which means any weapon can technically have these attributes.
    - `custom_charge_meter`: Boolean
        - if true, do not render demoman's charge meter
        - Note: this might not actually be implemented
    - `ammo_gives_charge`: Boolean
        - If 1, and player has a demoman charge meter, add charge based on ammo pack size
    - `no_primary_ammo_from_dispensers`: Boolean
    - `no_metal_from_dispensers_while_active`: Boolean
    - `mult_dmg_vs_buildings`: Float
- `mult_clipsize`: Float
- `mult_clipsize_upgrade`: Int
- `mult_clipsize_upgrade_atomic`: Int
    - MVM attribute that specifically handles rocket and grenade launchers
    - Note that all three of these are different classes, which means they stack.
- `clipsize_increase_on_kill`: Int
- `wrench_builds_minisentry`: Float(?)
    - cast to an int, used as a boolean, so idk
    - Determines the hand used in the model
- On player: `mult_deploy_time`: Float
- `mult_single_wep_deploy_time`: Float
- `mult_switch_from_wep_deploy_time`: Float
- `mult_rocketjump_deploy_time`: Float
- `is_a_sword`: Boolean
    - If true, make weapon deploy and holster 75% slower
- On player: `mod_medic_healed_deploy_time`: Float
    - Multiplier applied if NOT being healed by a medic
- `force_weapon_switch`: Boolean
    - Should force switch to this item when... something happens.  Probably when your current weapon is unavailable?
- `provide_on_active`: Boolean
    - If true, only applies attributes when weapon is active, and unapplies them when switching off.
    - I think this also means you can't have "only active when holding weapon" and "always active" attributes on the same weapon, since the order you specify attributes in doesn't matter.
- `projectile_penetration`: Int
    - How many players your "projectile" (*including bullets*) should penetrate.
- `mult_bullets_per_shot`: Float
- `mult_dmg`: Float
- `mult_crit_chance`: Float
    - "No random crits" sets this to `0.0`
- `auto_fires_full_clip`: Boolean
- `auto_fires_full_clip_all_at_once`: Boolean
- `can_overload`: Boolean
    - Deals damage to the player when overloaded.
- `mult_postfiredelay`: Float
    - After firing, you wait a bit before you can fire again. That's the "delay".
- `kill_combo_fire_rate_boost`: Float
    - Subtract `this * "kill combo"` from the post-fire delay
- `auto_fires_when_full`: Boolean
- `mult_reload_time`: Float
- `mult_reload_time_hidden`: Float
- `fast_reload`: Float
    - This is what's used for weapons that draw directly from reserve ammo, like the flare gun and sniper rifle.
- On player: `hwn_mult_reload_time`: Float
    - Halloween reload time multiplier.
- `mult_reload_time_while_healed`: Float
- `weapon_allow_inspect`: Boolean (technically float, but treated as boolean in `CanInspect` method)
- On hit enemy:
    - `add_onhit_addammo`: Boolean
    - `extra_damage_on_hit`: Int
        - For every head you have, deal +1% damage.
    - `reveal_cloaked_victim_on_hit`: Boolean
    - `reveal_disguised_victim_on_hit`: Boolean
    - `add_onhit_addhealth`: Int
    - `charge_meter_on_hit`: Float
        - Restores demoman shield charge on hit.
        - Yes, this is on every weapon.
    - `speed_boost_on_hit`: Int
        - Just does `addcond(SPEED_BOOST, speed_boost_on_hit)`
    - `add_onhit_ubercharge`: Float
        - Only procs if on a Medic.
    - `rage_on_hit`: Int
        - Only procs if on a Soldier or Pyro.
    - `boost_on_damage`: Boolean
        - Gain Scout's "hype" meter on hit.  Yeah, this exists for everything, but specifically modifies Scout's "hype" meter, which is only used for the Soda Popper and Baby Face's Blaster.
    - `aoe_heal_chance`: Float
        - Chance to heal allies on hitting an enemy.
    - `crits_on_damage`: Float
        - Chance to gain critboost
    - `stun_on_damage`: Float
        - Chance to stun victim
    - `aoe_blast_on_damage`: Float
        - Stun and bleed victim and others in range
        - Oh ok this is explosive headshot logic
    - `generate_rage_on_dmg`: Boolean
        - Knockback rage on enemy if you're a heavy and your rage is draining
    - `mult_onhit_enemyspeed`: Float
        - Gain speedboost on hit.
    - `mult_onhit_enemyspeed_major`: Float
        - Gain speedboost for N seconds.
    - `mark_for_death`: Boolean
    - `stun_waist_high_airborne`: Boolean
        - Stun airborne targets.
    - `subtract_victim_medigun_charge_onhit`: Int
        - Percentage as an int, e.g. `25` = 25% = 0.25
        - Drain scaled over distance
    - `subtract_victim_cloak_on_hit`: Int
        - Subtracts an actual value
        - Drain still scaled over distance
- On this weapon's owner being hit:
    - `become_fireproof_on_hit_by_fire`: Float, cond parameter
- `provide_on_active`: Boolean
    - Only provide all attributes when weapon is worn
- `centerfire_projectile`: Boolean
    - Again, "projectile" includes bullets.
- `projectile_spread_angle`: Float
    - Ok this time it _doesn't_ include bullets. I think.
- `active_item_health_regen`: Float
    - Cast to an int when healing, idk why this is a float.
- `kill_eater_kill_type`: Int
- `set_silent_killer`: Boolean
- `last_shot_crits`: Boolean
    - When reloading, if you only have 1 round left in your clip, get crit-boosted
- `no_crit_boost`: Boolean
    - Can't be Kritz'd.
- The weapon supports revenge crits if any of these are set:
    - `sapper_kills_collect_crits`: Boolean
    - `extinguish_revenge`: Boolean
    - `sentry_killed_revenge`: Boolean
    - Note that the logic for _gaining_ said crits depends on the weapon. Having one of these set just says it _can_ have them.
- `honorbound`: Boolean
    - Takes 50 health when holstering before it gets a kill.
- `weapon_stattrak_module_scale`: Float
- `min_viewmodel_offset`: String
- `ubercharge_ammo`: Float
    - Uses this much ubercharge per shot instead of ammo if a syringe gun, else just prevents weapon from firing when empty.
- `effectbar_recharge_rate`: Float
    - Things like throwable recharge timers, jetpack charging, etc. How much it recharges per... some amount of time.
- `weapon_blocks_healing`: Boolean
    - Prevents mediguns from latching onto you.
- `mult_uberchargerate_for_healer`: Float
    - Multiplier applied to your healer's ubercharge rate
    - NOTE: Only applied if user is outside of the respawn room
- `mod_jump_height_from_weapon`: Float
    - One of the "only when weapon is active" kind of attributes.  These always only work if the weapon that provides them is active, while still allowing other attributes to be globally-applied.
## BaseGun
- *Inherits from: [WeaponBase](#WeaponBase)*
- Items:
    - Also: The Wrangler, Festive Wrangler, The Giger Counter
- `last_shot_crits`: Boolean
    - If the last shot in your clip should crit.
- On player: `hwn_mult_postfiredelay`: Float
    - Multiplier applied to base fire delay
- `mult_postfiredelay_with_reduced_health`: Float
    - Used with the _old_ Panic Attack.
- `rocketjump_attackrate_bonus`: Float
    - Multiplier to fire delay while player is blast-jumping
- `mul_nonrocketjump_attackrate`: Float
    - Multiplier to fire delay while player is NOT blast-jumping
- `fast_reload`: Float
    - Used if the gun draws directly from the ammo supply without using a clip.
- `keep_disguise_on_attack`: Boolean
    - If true, spies will keep their disguise when attacking with this weapon.
- `override_projectile_type`: Int
    - If unset, uses the weapon's default projectile type.
    - Else use a numbered [projectile type](#ProjectileTypes)
- `mod_ammo_per_shot`: Int
    - How much ammo is used per shot. If 0, uses default.
- `projectile_spread_angle`: Float
    - Used when firing pipe bombs.
- `mult_projectile_range`: Float
    - Used when firing any projectile, including pipe bombs
- `grenade_no_spin`: Boolean
    - Don't spin loch n load pills
- `projectile_penetration`: Boolean
    - Also on WeaponBase, but noted here because it's specifically used in gun's "fire arrow" logic.
- `mult_spread_scale`: Float
    - Modifies bullet spread.
- `panic_attack_negative`: Float
    - Multiplier applied to bullet spread as health gets lower.
- `mult_spread_scales_consecutive`: Float
    - Scales weapon spread when firing consecutive shots, like the _New_ Panic Attack.
- `mult_dmg_disguised`: Float
    - When disguised (only checks if the player has the condition, doesn't check class), multiply damage by this amount.
- `rage_damage`: Float
    - If you're a Soldier or Pyro, increases damage by `(n - 1) * (rage gauge proportion)`
- `medic_healed_damage_bonus`: Float
    - Multiply damage by this value once for each healer you have. (with 2 healers, that's `bonus * bonus`, exponential)
- `accuracy_scales_damage`: Float
    - If the projectile being fired is a bullet, multiply damage by your hit ratio over the past few seconds.
- `last_shot_crits`: Boolean
    - If true, the last shot in your clip crits
-  `mult_spread_scale_first_shot`: Float
    - By default, all guns have perfect accuracy on the first shot, unless this is set.
- `fixed_shot_pattern`: Boolean
    - Enables fixed weapon spread on the weapon as though `tf_use_fixed_weaponspreads` were set.
- `mod_pierce_resists_absorbs`: Boolean
## BaseMelee
- *Inherits from: [WeaponBase](#WeaponBase)*
- Items:
    - Also: Frying Pan, Saxxy, The Conscientious Objector, The Freedom Staff, The Bat Outta Hell, Memory Maker, The Ham Shank, Gold Frying Pan, Necro Smasher, The Crossing Guard, Powerup Strength, Powerup Haste, Powerup Regen, Powerup Resist, Powerup Vampire, Powerup Reflect, Powerup Precision, Powerup Agility, Powerup Knockout, Powerup King, Powerup Plague, Powerup Supernova, Prinny Machete
    - Also: The Hot Hand
    - Also: Kukri, The Tribalman's Shiv, The Bushwacka, The Shahanshah
- `*self_mark_for_death`: Boolean
    - Marked for death when switching to weapon
- `is_a_sword`: Boolean
    - If 1, set swing range to 72, else 48
- `melee_bounds_multiplier`: Float
    - Multiplier applied to the bounding box of the swing to detect if a player is inside it
    - Yes, it DOES use a bounding box. I think. That's what this implies, I guess.
- `set_dmg_apply_to_sapper`: Int
    - Damage sappers with swing
- `speed_buff_ally`: Boolean
    - Applies speed boost cond to yourself and the teammate you hit
- `add_give_health_to_teammate_on_hit`: Int
    - Transfer some amount of health from yourself to your teammate on hitting them.
- `melee_cleave_attack`: Int
    - If greater than 0, hit all targets in swing instead of just the first valid one.
- `hit_self_on_miss`: Boolean
    - Idiot.
- `speed_boost_on_hit_enemy`: Float
    - Used as arg to addcond speedboost
- `crit_from_behind`: Boolean
- `crit_forces_victim_to_laugh`: Boolean
- `tickle_enemies_wielding_same_weapon`: Boolean
    - Force enemies to laugh if they're also wielding this weapon.
- `crit_does_no_damage`: Boolean
    - These past four are Holiday Punch attributes, obviously
- `mult_dmg_bonus_while_half_dead`: Float
    - If health < 50%, apply mult.
- `mult_dmg_penalty_while_half_alive`: Float
    - If health >= 50%, apply mult
    - Shahanshahanshanhansa attributes
- `mult_dmg_with_reduced_health`: Float
    - Apply multiplier scaled by player's current health proportion
    - You'll see later that there's a "Shovel 'Equalizer' mode", but the real logic for that is here.
- `mult_crit_chance`: Float
    - Noted because it's interesting that it's used here too.
## Flamethrower
- *Inherits from: [WeaponBase](#WeaponBase)*
- Items: TF_WEAPON_FLAMETHROWER, The Backburner, Upgradeable TF_WEAPON_FLAMETHROWER, The Degreaser, The Phlogistinator, Festive Flamethrower 2011, The Rainblower, Silver Botkiller Flame Thrower Mk.I, Gold Botkiller Flame Thrower Mk.I, Rust Botkiller Flame Thrower Mk.I, Blood Botkiller Flame Thrower Mk.I, Carbonado Botkiller Flame Thrower Mk.I, Diamond Botkiller Flame Thrower Mk.I, Silver Botkiller Flame Thrower Mk.II, Gold Botkiller Flame Thrower Mk.II, Festive Backburner 2014, The Nostromo Napalmer
- `set_weapon_mode`: Int
    - Determines flame particle effect
    - 1 = phlog
    - 2 = MvM giant pyrobot
    - 3 = rainblower
        - Also makes a bubble wand while taunting
- `set_buff_type`: Int
    - If greater than 0, enables Phlog crits on having full rage
- `airblast_disabled`: Boolean
- `set_charged_airblast`: Boolean
    - Enables charging an airblast for longer for higher push
    - Fun fact: apparently this was going to be a FLAME ROCKET, but got changed later to be an airblast
- `mult_airblast_cost`: Float
- `set_flamethrower_back_crit`: Boolean
- `mult_flame_ammopersec`: Float
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
- `mod_flamethrower_spinup_time`: Float
    - Yes, like a minigun.
- `firing_forward_pull`: Float
    - Actually a Boolean, so a `0.0` or `1.0` value.
    - If true, you get a speedboost while firing your flamethrower.
    - (Oh god, they planned on making a literal W+M1 weapon. Jungle Inferno could've been a _lot_ worse.)
- `deflection_size_multiplier`: Float
    - Scales the reflect hitbox for your airblast
- `extinguish_restores_health`: Int
    - How much health your extinguish restores
- `reverse_airblast`: Boolean
    - If the airblast isn't disallowed from pushing players back, and this is set, airblasting will pull players instead.
- `mult_airblast_cone_scale`: Float
    - Cone used for pushing players
- `airblast_pushback_scale`: Float
- `airblast_vertical_pushback_scale`: Float
- `halloween_green_flames`: Boolean
- On owner:
    - `mult_flame_size`: Float
    - `mult_flame_life`: Float
- `airblast_destroy_projectile`: Boolean
- `airblast_pushback_disabled`: Boolean
## SMG
- *Inherits from: [BaseGun](#BaseGun)*
- Items: Stock SMG
- `set_weapon_mode`: Int
    - If 1, can headshot
## ChargedSMG
- *Inherits from: [SMG](#SMG)*
- Items: The Cleaner's Carbine
- `minicrit_boost_when_charged`: Float
    - Minicrit buff duration
## Sapper
- *Inherits from: [Builder](#Builder)*
- Items: Stock Sapper, The Red-Tape Recorder, Promo Red-Tape Recorder, The Ap-Sap, Festive Sapper, The Snack Attack
- On player: `sapper_degenerates_buildings`: Float
    - How fast the building should reverse construction
- `robo_sapper`: Int
    - When the sapper is applied to a player (including MvM bots):
        - 2 - stun time is 5.5 seconds, radius is 225 hammer units
        - 3 - stuns for 7 seconds, radius is 250 hammer units
        - else stuns for 4 seconds and radius is 200 HU
- `sapper_deploy_time`: Float
    - If greater than 0, the sapper takes time to place (UNIMPLEMENTED)
## Fists
- *Inherits from: [BaseMelee](#BaseMelee)*
- Weapons: Stock Fists, The Killing Gloves of Boxing, Warrior's Spirit, Fists of Steel, The Eviction Notice, Apoco-Fists, The Holiday Punch, The Bread Bite, Gloves of Running Urgently MvM
- `set_weapon_mode`: Int
    - Used to specify "fist type"
- `breadgloves_properties`: Boolean (UNIMPLEMENTED)
    - Note that despite being present in the item schema, this is explicitly COMMENTED OUT of the code, and has no gameplay effects at least.
## Shovel
- *Inherits from: [BaseMelee](#BaseMelee)*
- Items: TF_WEAPON_SHOVEL, The Equalizer, The Pain Train, Upgradeable TF_WEAPON_SHOVEL, The Market Gardener, The Disciplinary Action, The Escape Plan
- `set_weapon_mode`: Int
    - Used to specify "shovel type"
        - 0 = Standard
        - 1 = Equalizer
        - 2 = Escape Plan
        - I do not know what this does.
- `air_jump_on_attack`: Boolean
    - On primary attack, send player flying in the direction they're facing.
## Bottle
- *Inherits from: [BaseMelee](#BaseMelee)*
- Items: TF_WEAPON_BOTTLE, Upgradeable TF_WEAPON_BOTTLE, The Scottish Handshake
## StickBomb
- *Inherits from: [Bottle](#Bottle)*
- Items: The Ullapool Caber
- `halloween_pumpkin_explosions`: Boolean
## FireAxe
- *Inherits from: [BaseMelee](#BaseMelee)*
- Items: TF_WEAPON_FIREAXE, The Axtinguisher, The Homewrecker, Upgradeable TF_WEAPON_FIREAXE, The Powerjack, The Back Scratcher, Sharpened Volcano Fragment, The Postal Pummeler, The Maul, The Third Degree, The Lollichop, Festive Axtinguisher
- `set_dmgtype_ignite`: Boolean
    - Ignite enemies on hit
    - Yeah, sadly this is just checked on fire axes...
## Bonesaw
- *Inherits from: [BaseMelee](#BaseMelee)*
- Items: TF_WEAPON_BONESAW, The Ubersaw, The Vita-Saw, Upgradeable TF_WEAPON_BONESAW, The Amputator, The Solemn Vow, Festive Ubersaw, Festive Bonesaw 2014
- `set_weapon_mode`: Int
    - Used to specify "bonesaw type"
- `special_taunt`: Boolean
    - If the player should taunt on right click
- `add_head_on_hit`: Boolean
    - If the player should take a "head" when dealing damage with a melee
    - Also, is there a "speed modifier" for taking heads??????
- `ubercharge_preserved_on_spawn_max`: Float
- `add_head_on_kill`: Boolean
    - On kill, take an organ (uses "heads" field like usual)
## Minigun
- *Inherits from: [BaseGun](#BaseGun)*
- Weapons: All Stock Minigun skins, Natascha, The Brass Beast, Tomislav
- `minigun_no_spin_sounds`: Boolean
- `mod_minigun_can_holster_while_spinning`: Boolean
- `mult_minigun_spinup_time`: Float
- `attack_projectiles`: Boolean
    - Overridden by "raid gamemode" to 1
- `ring_of_fire_while_aiming`: Int
- `uses_ammo_while_aiming`: Int
    - Amount of ammo drained per second
## Pistol
- *Inherits from: [BaseGun](#BaseGun)*
- Items: TF_WEAPON_PISTOL, TF_WEAPON_PISTOL_SCOUT, TTG Max Pistol, Upgradeable TF_WEAPON_PISTOL, The C.A.P.P.E.R
## ScoutPistol
- *Inherits from: [Pistol](#Pistol)*
- Items: The Shortstop, The Winger, Pretty Boy's Pocket Pistol
- `back_headshot`: Boolean
    - If true, can headshot
## Revolver
- *Inherits from: [BaseGun](#BaseGun)*
- Items: TF_WEAPON_REVOLVER, The Ambassador, TTG Sam Revolver, Upgradeable TF_WEAPON_REVOLVER, L'Etranger, The Enforcer, The Diamondback, Festive Ambassador, Festive Revolver 2014
- `extra_damage_on_hit`: Boolean
    - If true, increases damage by 1% per "head" collected (note: this is not the diamondback's "revenge crit" mechanic)
- `extra_damage_on_hit_penalty`: Int
    - Lowers your head count by this amount every time you fire a shot
## SyringeGun
- *Inherits from: [BaseGun](#BaseGun)*
- Weapons: Stock Syringe Gun, The Blutsauger, The Overdose
-  `set_weapon_mode`: Int
    - Used to specify "syringe type"
## RocketPack
- *Inherits from: [BaseMelee](#BaseMelee)*
- Items: The Thermal Thruster
- `thermal_thruster_air_launch`: Boolean
    - The MvM upgrade that lets you launch while launching
## Invis
- *Inherits from: [WeaponBase](#WeaponBase)*
- Items: TF_WEAPON_INVIS, The Dead Ringer, The Cloak and Dagger, Upgradeable TF_WEAPON_INVIS, The Quackenbirdt
- `set_weapon_mode`: Int
    - Used to specify "invis type"
- `mult_decloak_rate`: Float
    - How many seconds it takes to decloak (or a multiplier?)
    - Note that values less than or equal to `0.0` become `1.0`
- On player: `mult_cloak_meter_consume_rate`: Float
    - Multiply cloak consumption rate by this value.
- `mult_cloak_meter_regen_rate`: Float
## PipebombLauncher
- *Inherits from: [BaseGun](#BaseGun)*
- Items: TF_WEAPON_PIPEBOMBLAUNCHER, The Scottish Resistance, Upgradeable TF_WEAPON_PIPEBOMBLAUNCHER, Stickybomb Jumper, Festive Stickybomb Launcher 2011, Silver Botkiller Stickybomb Launcher Mk.I, Gold Botkiller Stickybomb Launcher Mk.I, Rust Botkiller Stickybomb Launcher Mk.I, Blood Botkiller Stickybomb Launcher Mk.I, Carbonado Botkiller Stickybomb Launcher Mk.I, Diamond Botkiller Stickybomb Launcher Mk.I, Silver Botkiller Stickybomb Launcher Mk.II, Gold Botkiller Stickybomb Launcher Mk.II, The Quickiebomb Launcher
- (Stickybomb launchers, Grenade launchers)
- `stickybomb_charge_rate`: Float
    - Not actually the "rate", rather the time it takes to fully charge a stickybomb launch when holding MOUSE1.
- `set_detonate_mode`: Int
    - If 0, default "detonate all stickies on rclick" mode. If 1, uses Scottish Resistance's "look at sticky to detonate" mechanic.
- `stickies_detonate_stickies`: Boolean
    - If 1, stickies destroy other stickies.
- `stickybomb_charge_damage_increase`: Float
    - damage = `2*basedamage * (this - 1.0) * currentChargeProportion`
- `add_max_pipebombs`: Int
## BuffItem
- *Inherits from: [BaseMelee](#BaseMelee)*
- Items: The Buff Banner, The Battalion's Backup, The Concheror, Festive Buff Banner
- `set_buff_type`: Int
    - Sets which banner is used
    - 0 = Buff Banner
    - 1 = Battalion's Backup
    - 2 = Concheror
- `mod_buff_duration`: Float
    - Multiplier to buff duration
    - Weirdly it just modifies when the "BuffBanner Flag" (the prop) detaches from the player, which means it's actually the _flag_ that does the buffing, lmao
## Wrench
- *Inherits from: [BaseMelee](#BaseMelee)*
- Items: Stock Wrench + Reskins, Golden Wrench, The Southern Hospitality, The Jag, The Eureka Effect
    - Also: The Gunslinger
- `alt_fire_teleport_to_spawn`: Boolean
    - If set, pressing reload shows the Eureka Effect menu
- `wrench_builds_minisentry`: Boolean
    - Detonates leveled sentries when equipping a wrench with this attribute
    - If not in MvM (player is not on team "PVE_DEFENDERS"), detonate minis when unequipping a wrench with this attribute
    - Removes engineer's glove on his model
    - Also determines if it's a "PDQ", which obviously builds minisentries
- `mult_construction_value`: Float
    - Passive build rate multiplier, same as the convar `tf_construction_build_rate_multiplier`
- `mult_repair_value`: Float
    - Multiplier, determines how much health is given per wrench hit
## RocketLauncher
- *Inherits from: [BaseGun](#BaseGun)*
- Items: TF_WEAPON_ROCKETLAUNCHER, Upgradeable TF_WEAPON_ROCKETLAUNCHER, The Black Box, Rocket Jumper, The Liberty Launcher, The Original, Festive Rocket Launcher 2011, The Beggar's Bazooka, Silver Botkiller Rocket Launcher Mk.I, Gold Botkiller Rocket Launcher Mk.I, Rust Botkiller Rocket Launcher Mk.I, Blood Botkiller Rocket Launcher Mk.I, Carbonado Botkiller Rocket Launcher Mk.I, Diamond Botkiller Rocket Launcher Mk.I, Silver Botkiller Rocket Launcher Mk.II, Gold Botkiller Rocket Launcher Mk.II, Festive Black Box
    - Also: The Direct Hit
    - Also: The Cow Mangler 5000 (it's not an EnergyWeapon)
- `override_projectile_type`: Int
    - If unset, uses the weapon's default projectile type.
    - Else it can be used with anything in `ProjectileType_t`, as seen in [BaseGun](#BaseGun)
- `mod_rocket_launch_impulse`: Boolean
    - Allows the player to rocket jump with the projectile. (note that "rocket launcher" is the base for most projectile launchers, including the Crossbow :3)
## RocketLauncher_AirStrike
- *Inherits from: [RocketLauncher](#RocketLauncher)*
- Items: Air Strike
- `clipsize_increase_on_kill`: Int
    - This attribute is on all weapons, but it's specifically checked for here as well.

## GrenadeLauncher
- *Inherits from: [BaseGun](#BaseGun)*
- Items: TF_WEAPON_GRENADELAUNCHER, Upgradeable TF_WEAPON_GRENADELAUNCHER, The Loch-n-Load, Festive Grenade Launcher, The Iron Bomber
    - Also: The Loose Cannon
- `grenade_detonation_damage_penalty`: Float
    - Flat multiplier applied to initial damage
- `mult_projectile_speed`: Float
- `set_detonate_mode`: Int
    - If 0, uses standard "detonate all stickies on rclick". Else, uses Scottish Resistance's "only detonate stickies on crosshair" function.
- `grenade_launcher_mortar_mode`: Float
    - "Mortar" (loose cannon) detonation time length
## Crossbow
- *Inherits from: [RocketLauncher](#RocketLauncher)*
- Items: The Crusader's Crossbow, Festive Crusader's Crossbow
- `mult_reload_time`: Float
- `mult_reload_time_hidden`: Float
- `fast_reload`: Float
    - Honestly I don't know why `fast_reload` is different if it's just going to use the standard reload time mults anyway...
- `fires_milk_bolt`: Boolean
    - If `1`, alt-fire fires a mad-milked crossbow bolt with a meter??? (meter is unimplemented, but milk bolt is)
## RayGun
- *Inherits from: [RocketLauncher](#RocketLauncher)*
- Items: The Righteous Bison
    - Also: The Pomson 6000
- `energy_weapon_no_drain`: Boolean
    - Removes ammo requirement to fire weapon.
## Raygun_Revenge
- *Inherits from: [RayGun](#RayGun)*
- Items: NONE (but it's there at least?)
- `energy_weapon_no_drain`: Boolean
    - Removes ammo requirement to fire weapon.
## Lunchbox
- *Inherits from: [WeaponBase](#WeaponBase)*
- Items: The Sandvich, The Dalokohs Bar, The Buffalo Steak Sandvich, Fishcake, The Robo-Sandvich, Festive Sandvich, The Second Banana
    - Also: Bonk! Atomic Punch, Crit-a-Cola, Festive Bonk 2014
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
## Shotgun
- *Inherits from: [BaseGun](#BaseGun)*
- Items: Stock Shotgun, Reserve Shooter
    - Also: The Frontier Justice, Festive Frontier Justice
    - Also: The Widowmaker
    - Also: The Rescue Ranger
## Scattergun
- *Inherits from: [Shotgun](#Shotgun)*
- Items: TF_WEAPON_SCATTERGUN, The Force-a-Nature, Upgradeable TF_WEAPON_SCATTERGUN, Festive Scattergun 2011, Silver Botkiller Scattergun Mk.I, Gold Botkiller Scattergun Mk.I, Rust Botkiller Scattergun Mk.I, Blood Botkiller Scattergun Mk.I, Carbonado Botkiller Scattergun Mk.I, Diamond Botkiller Scattergun Mk.I, Silver Botkiller Scattergun Mk.II, Gold Botkiller Scattergun Mk.II, Festive Force-a-Nature, The Back Scatter
- `set_scattergun_has_knockback`: Boolean
    - Note: if `scattergun_knockback_mult` is greater than 1.0, this is not necessary.
- `scattergun_knockback_mult`: Float
- `set_scattergun_no_reload_single`: Boolean
    - If 1, reloads entire clip at once.
## ShotgunRevenge
- *Inherits from: [Shotgun](#Shotgun)*
- Items: Frontier Justice
- `sentry_killed_revenge`: Boolean
    - Specifically checked here when it tries to gain revenge crits, which means removing this attribute from the Frontier Justice will remove its ability to gain revenge crits.
## Knife
- *Inherits from: [BaseMelee](#BaseMelee)*
- Items: TF_WEAPON_KNIFE, Upgradeable TF_WEAPON_KNIFE, Your Eternal Reward, Conniver's Kunai, The Big Earner, The Wanga Prick, The Sharp Dresser, The Spy-cicle, Festive Knife 2011, The Black Rose, Stock Botkiller Knives
- `set_weapon_mode`: Int
    - 0: Stock
    - 1: Your Eternal Reward
    - 2: Cloak and Dagger (idk why)
    - 3: Spycicle
- `melts_in_fire`: Boolean
- `set_disguise_on_backstab`: Boolean
- `mult_dmg`: Float
    - Base backstab damage against minibosses is 250 * this proportion.
- On player: `armor_piercing`: Float (**PERCENTAGE**)
    - Spy only does 25% damage against minibosses by default.  The number here is added to that percentage, up to a max of 100% + 25% = 125%
    - Note that this is an actual PERCENTAGE of armor penetrated, not a proportion:  `25.0`, `50.0`, up to `100.0`.
    - Also, with max armor penetration, you apparently do 25% *more* damage against minibosses than you do against regular bots.
- `sanguisuge`: Boolean
    - Gain health on backstab. (Kunai)
## Sword
- *Inherits from: [BaseMelee](#BaseMelee)*
- The Eyelander, The Scotsman's Skullcutter, The Horseless Headless Horseman's Headtaker, The Claidheamohmor (sic), The Persian Persuader, Nessie's Nine Iron, Festive Eyelander
    - Also: The Half-Zatoichi
- `decapitate_type`: Int
    - More like a boolean, doesn't actually determine any kind of decapitation, just if it CAN decapitate.
## Wearable
- Items: Cosmetics
    - Also: The Manntreads and Gunboats? I forgot to check. TODO
## WearableDemoShield
- *Inherits from: [Wearable](#Wearable)*
- Items: The Chargin' Targe, The Splendid Screen, The Tide Turner, Festive Targe 2014
- `attack_not_cancel_charge`: Boolean
- On player: `mod_charge_time`: Float
    - Charge time mult
- On player: `charge_impact_damage`: Float
    - Impact damage mult
## FlareGun
- *Inherits from: [BaseGun](#BaseGun)*
- Items: The Flare Gun, The Scorch Shot, The Detonator
    - Also: The Manmelter
- `set_weapon_mode`: Int
    - 0: Normal
    - 1: Detonator
    - 2: UNUSED
    - 3: Scorch Shot
## Jar
- *Inherits from: [BaseGun](#BaseGun)*
- Items: Jarate, Festive Jarate, The Self-Aware Beauty Mark
    - Also: Mad Milk, Mutated Milk
    - Also: The Flying Guillotine
    - Also: The Gas Passer
    - Also: Unimplemented Spy Decoy Weapon
- `override_projectile_type`: Int
    - Used to select the model
    - Select between `TF_PROJECTILE_FESTIVE_JAR`, `TF_PROJECTILE_BREADMONSTER_JARATE`, and `TF_PROJECTILE_BREADMONSTER_MADMILK`
    - Otherwise uses default for its class
- On player: `applies_snare_effect`: Float
    - If NOT `1.0`, stun the victim
- `extinguish_reduces_cooldown`: Float
    - Subtracts this value from the cooldown
## MechanicalArm
- *Inherits from: [BaseGun](#BaseGun)*
- `mod_ammo_per_shot`: Int
## Throwable
- *Inherits from: [Jar](#Jar)*
- Items: Spellbook
- `throwable_recharge_time`: Float
- `throwable_detonation_time`: Float
- `is_throwable_primable`: Boolean
    - For timed explosions
- `is_throwable_chargeable`: Boolean
    - For things like distance/power increases
## SniperRifle
- *Inherits from: [BaseGun](#BaseGun)*
- Items: TF_WEAPON_SNIPERRIFLE, Upgradeable TF_WEAPON_SNIPERRIFLE, The Sydney Sleeper, The Machina, Festive Sniper Rifle 2011, The Hitman's Heatmaker, Silver Botkiller Sniper Rifle Mk.I, Gold Botkiller Sniper Rifle Mk.I, The AWPer Hand, Rust Botkiller Sniper Rifle Mk.I, Blood Botkiller Sniper Rifle Mk.I, Carbonado Botkiller Sniper Rifle Mk.I, Diamond Botkiller Sniper Rifle Mk.I, Silver Botkiller Sniper Rifle Mk.II, Gold Botkiller Sniper Rifle Mk.II, Shooting Star
    - Also: The Bazaar Bargain
    - Also: The Classic
- `set_weapon_mode`: Int
    - 0: Normal
    - 1: Sydney Sleeper
    - 2: Machina
    - 3: Classic
- `set_buff_type`: Int
    - If greater than 0, activates rage buff when pressing reload and rage meter is full (or above full).
- `sniper_full_charge_damage_bonus`: Float
    - If greater than 1.0, weapon plays cool fully-charged-Machina railgun sound when firing at full charge.
- `fast_reload`: Float
    - Mult to zoom and unzoom delay on clipless weapons
    - Fun fact: this is also affected by the Precision mannpower powerup
- `ability_master_sniper`: Int
    - Mult to zoom/unzoom delay on clipless weapons
        - mult by level: 1=0.6, 2=0.3
    - Mult to charge speed
        - 1=1.5, 2=3.0
- `mult_sniper_charge_per_sec`: Float
- `mult_sniper_charge_per_sec_with_enemy_under_crosshair`: Float
- `sniper_beep_with_enemy_under_crosshair`: Float
    - Cast to an int, treated like a boolean
    - plays `doomsday.warhead` sound when an enemy appears under your crosshair
- `sniper_only_fire_zoomed`: Boolean
- `sniper_penetrate_players_when_charged`: Boolean
- `sniper_no_headshot_without_full_charge`: Boolean
- `sniper_crit_no_scope`: Boolean
    - Funnily enough, it checks if your FOV is lower than your default FOV to see if you're zoomed.
- On attacker: `explosive_sniper_shot`: Int
    - Level of explosive headshot
- `jarate_duration`: Float
    - If greater than 0:
        - Makes weapon not eject brass
        - Makes weapon only penetrate non-burning teammates, as opposed to penetrating all teammates
    - Note: Not actually used in Sydney Sleeper Jarate calculation, as far as I could tell.
## Medigun
- *Inherits from: [BaseGun](#BaseGun)*
- Items: TF_WEAPON_MEDIGUN, The Kritzkrieg, Upgradeable TF_WEAPON_MEDIGUN, The Quick-Fix, Festive Medigun 2011, Silver Botkiller Medi Gun Mk.I, Gold Botkiller Medi Gun Mk.I, Rust Botkiller Medi Gun Mk.I, Blood Botkiller Medi Gun Mk.I, Carbonado Botkiller Medi Gun Mk.I, Diamond Botkiller Medi Gun Mk.I, Silver Botkiller Medi Gun Mk.II, Gold Botkiller Medi Gun Mk.II, The Vaccinator
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
## Builder
- Inherits from: *[WeaponBase](#WeaponBase)*
- Items: TF_WEAPON_BUILDER, TF_WEAPON_BUILDER_SPY, Upgradeable TF_WEAPON_BUILDER_SPY
- On owner: `mark_for_death_on_building_pickup`: Boolean
- `sapper_voice_pak`: Float
    - If 1.0, it's a wheatley sapper
- If building an OBJ_ATTACHMENT_SAPPER on a mode that allows upgrades and it's built on a player (or MvM bot):
    - `robo_sapper`: Boolean
        - Gives the sapper a radius instead of being single-target
## CompoundBow
- *Inherits from: [PipebombLauncher](#PipebombLauncher)*
- Items: The Huntsman, Festive Huntsman, The Fortified Compound
- `fast_reload`: Float
    - Mult applied to reload speed
- `ability_master_sniper`: Int
    - Applies mult to reload speed: 1 = 0.6, 2 = 0.3
    - does not stack with Haste powerup
## Bat
- *Inherits from: [BaseMelee](#BaseMelee)*
- Weapons: TF_WEAPON_BAT, Upgradeable TF_WEAPON_BAT, The Candy Cane, The Boston Basher, Sun-on-a-Stick, The Fan O'War, The Atomizer, Three-Rune Blade, Festive Bat 2011, Batsaber
    - Also: The Sandman (tf_weapon_bat_wood)
    - Also: The Holy Mackerel, Unarmed Combat, Festive Holy Mackerel (tf_weapon_bat_fish)
- `set_weapon_mode`: Int
    - If 0, cannot create a ball
# Entity:
- `cannot_be_backstabbed`: Boolean
- Buildings check their builder for:
    - All buildings:
        - `mod_build_rate`: Float
            - Multiplies building build time by this amount
        - `upgrade_rate_mod`: Int
            - Add x metal to any building hit using player's metal reserve
            - Recall that all players have 100 hidden metal
        - `mult_engy_building_health`: Int
            - Only applied if the building is NOT a disposable sentry
    - Sentry:
        - `mvm_sentry_ammo`: Float
            - Multiplier to max ammo
        - `mult_sentry_range`: Float
        - On owner: `build_small_sentries`: Boolean
            - If true, upgrade metal is only 150 instead of 200
            - Also creates a sentry that's 80% size
    - Dispenser:
        - `mult_dispenser_rate`: Float
            - Dispenser resupply rate
        - `mult_dispenser_radius`: Float
    - Teleporter:
        - `mod_teleporter_speed_boost`: Boolean
            - If true, teleporter adds speed boost condition with arg 4.0 to teleported player
        - `mod_teleporter_cost`: Float
            - Flat mult to metal cost
        - `bidirectional_teleport`: Boolean
        - `mult_teleporter_recharge_rate`: Float
- `cannot_swim`: Boolean
    - Forbids you from floating upwards with the jump button in the water
- `mod_jump_height`: Float
- `mult_health_frompacks`: Float
- `mult_healing_from_medics`: Float
    - Only on crossbow impacts?
- `hype_resets_on_jump`: Int
    - Lose this amount of hype if you airdash
    - Note that this only applies to scout hype, not rage in general
- `parachute_attribute`: Boolean
    - Allows parachute to be deployed
- `parachute_disabled`: Boolean
    - Prevents parachute from being deployed, but still allows it to be retracted.
- `set_custom_buildmenu`: Int
    - Only used if the build menu is actually shown
    - 0 = default
    - 1 = pipboy
- `appear_as_mvm_robot`: Boolean
    - If true, appear as an MvM robot in your hud when selecting a class

# Player
- `see_enemy_health`: Boolean
- `hide_enemy_health`: Boolean
    - Always true in MvM
- Spy-only:
    - `set_custom_buildmenu`: Int
        - You can set a spy build menu??
    - `override_engineer_object_type`: Int
        - Default = -1
        - If 0, build the catapult shown below???
```
s_alternateSpyBuildings[] =
{
	SpyConstructBuildingReplacement_t(
	OBJ_CATAPULT,
	0,
	"spy_trap_active.res",
	"spy_trap_already_built.res",
	"spy_trap_cant_afford.res",
	"spy_trap_unavailable.res",
	"spy_trap_active.res",
	"spy_trap_inactive.res",
	"spy_trap_inactive.res",
	trapSlots[0],
	trapSlots[1]
	),
};
```
# MvM Bot:
- `bot_custom_jump_particle`: Boolean
    - If true, spawns a rocketjump particle whenever the robot jumps
- `bot_medic_uber_health_threshold`: Int
    - Defaults to 50, I guess it's a percentage
- `bot_medic_uber_deploy_delay_duration`: Int
    - Defaults to -1

# Projectiles:
## tf_projectile_base
- `mad_milk_syringes`: Boolean
    - If true, applies mad milk on hit. Yes, this is in the base projectile.

## tf_projectile_rocket
- `halloween_pumpkin_explosions`: Boolean
    - Checks on owner or sentry's owner


## tf_weaponbase_rocket (not sure what the difference is)
- `mini_rockets`: Boolean
    - Uses the "mini rockets" model
- `rocketjump_attackrate_bonus`: Float
    - If set on anything that fires a rocket, the rocket assumes it was fired by the Air Strike and reduces blast radius to 80%
- `mult_projectile_speed`: Float
- `rocket_specialist`: Int
- `halloween_pumpkin_explosions`: Int
    - Does pumpkin bombs particle effect
- `use_large_smoke_explosion`: Int
    - Use the big MvM particle when it explodes
- `mult_explosion_radius`: Float
- `no_self_blast_damage`: Boolean
    - Also uses plunger model
- `mult_explosion_radius`: Float
## tf_projectile_flare
- On launcher: `mult_projectile_speed`: Float
- On launcher: `mult_explosion_radius`: Float
- On launcher:  `mod_projectile_heat_seek_power`: Float
## tf_weaponbase_grenadeproj
- On launcher: `use_large_smoke_explosion`: Boolean
- On launcher: `halloween_pumpkin_explosions`: Boolean
- On launcher: `mult_explosion_radius`: Float
- On owner: `fuse_mult`: Float
## tf_projectile_energyring
- This is for the bison and pomson
- On owner: `energy_weapon_penetration`: Boolean
## tf_projectile_arrow
- On player: `arrow_heals_buildings`: Boolean
## tf_weapon_grenade_pipebomb
- On launcher: `stickybomb_fizzle_time`: Float
- On launcher: `grenade_no_bounce`: Boolean
- On launcher: `sticky_arm_time`: Float
- On launcher: `grenade_damage_reduction_on_world_contact`: Float

# Flames
- `flame_spread_degree`: FLOAT
- `redirected_flame_size_mult`: FLOAT
- `mult_flame_size`: FLOAT
- `mult_end_flame_size`: FLOAT
- `flame_ignore_player_velocity`: FLOAT
- `flame_reflection_add_life_time`: FLOAT
- `reflected_flame_dmg_reduction`: FLOAT
- `max_flame_reflection_count`: INT
- `flame_reflect_on_collision`: INT
- `flame_speed`: FLOAT
- `flame_lifetime`: FLOAT
- `flame_random_life_time_offset`: FLOAT
- `flame_gravity`: FLOAT
- `flame_drag`: FLOAT
- `flame_up_speed`: FLOAT

# Misc

## PowerUpBottle
- These determine what the canteen does when used.
    - Note: only the first valid attribute in this list is displayed on the player, but setting multiple will have all effects go off at once.
      - `critboost`: Boolean
      - `ubercharge`: Boolean
      - `recall`: Boolean
      - `refill_ammmo`: Boolean
      - `building_instant_upgrade`: Boolean
- `powerup_duration`: Float
- On player - `canteen_specialist`: Int
    - Adds extra time to the base powerup duration based on level?
- `powerup_max_charges`: Int
- `set_weapon_mode`: Int
    - If 1, is "base" powerup canteen

## Particles
- `particle_effect_use_head_origin`: Boolean
- `particle_effect_vertical_offset`: Float


## EconEntity
- `is_festivized`: Boolean
    - Attaches festivizer
- `set_attached_particle_static`: Int (index into ItemSchema AttributeControlledParticleSystem)
    - Attaches static particle, such as smoking a pipe
    - Cosmetics can only have one
- `set_attached_particle`: Int (index into ItemSchema AttributeControlledParticleSystem)
    - Dynamic particle systems, such as unusuals
- `throwable_particle_trail_only`: Boolean
    - If false, attaches the `set_attached_particle` to the item itself
    - If true, the particle only applies to the throwable particle trail? Though I don't actually see that occurring anywhere in here

