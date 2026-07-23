This is a list of every item attribute that is applicable for a given item type, even ones that are unimplemented.  Each item type also has the item type it extends from, and a list of the items that use that item type.

# Preface

## First, why don't attributes apply to _every_ weapon?

Attributes aren't actually "modifiers" that "are applied to" a weapon, they're just named settings that each weapon _checks for_ when it does something.  So likewise, any name it _doesn't_ check for won't do anything.

To simplify this a little though, each of TF2's weapons "inherit from" another, more-general, weapon type, which means it copies all of its logic and tacks on a little bit of its own.  This means that anything that inherits from a weapon type will generally work with the attributes its "parent" checks for, but conversely, anything that _doesn't_ inherit from a specific weapon type will generally _not_ check those attributes. (However, it may have its _own_ attributes it checks for, which will be passed on to anything that inherits from _it_.)

You can think of it like this:
- A generic "weapon" looks for attributes like "fire rate multiplier", "damage multiplier" etc.
- A generic "gun" inherits logic from "weapon", so it looks for all of those too.  It also has other gun-specific logic where it looks for some other gun-specific attributes.
- The "stock pistol" inherits from "gun", so it will use any attributes that "gun" uses, which also includes all of the ones from "weapon" because "gun" - its parent - inherits from "weapon".  Anything that then inherits from that "stock pistol" will likewise continue the chain, checking for any attributes that its parent and its parent's parent etc. check for.
- The "flamethrower" inherits from "weapon" directly _without_ inheriting from "gun", meaning it recognizes all attributes from "weapon" (its parent), but not the custom gun-specific ones that "gun" (its sibling) added.  They're siblings, which means they share a parent, but their children are on different branches of the family tree.

This list shows which attributes are checked for by each weapon type, the weapon type each type inherits from, and also gives the purpose for ones that aren't self-explanatory.  
Anything that inherits from a weapon type will - generally - use that attribute in the same way. (Exceptions to this are specifically mentioned in the notes.)



## Definitions:

I use some weird terms here. Here's what they mean:

### Attribute Class
Attributes on the backend have an "attribute class" that converts the easily-understandable entry to some hard value usable by the game.  For example, when you assign the attribute `"fire rate penalty" 0.3` (meaning "reduce fire rate by 30%"), it converts this to `mult_firerate 0.7` ("multiply fire rate by 70%").  `"fire rate penalty"` is the "named attribute", while `mult_firerate` is its "attribute class".

Because it's all an attribute class on the backend, any weapon that recognizes a given attribute class will recognize *any* "named attribute" of that class, regardless of what it's named.  But this also means that since penalties, bonuses, etc. for some stat generally all modify the same class, trying to set a penalty and a bonus of the same stat will likely overwrite one another instead of being added together.

I only list the classes here because that's how they're used in the code.  You can get the "named attributes" from their class names from the [list on the TF2 Wiki](https://wiki.teamfortress.com/wiki/List_of_item_attributes), though there's also a massive list at the very bottom that covers them.

### Data types:
- **Int**: a number without a decimal (example: `2`)
- **Float**: a decimal number (example: `0.2`)
- **String**: a series of characters wrapped in quotes (example: `"it's all ohio"`)
- **Boolean**: a 0 or 1.  `0` = false, `1` = true
- **Percentage**: A number from `0`% to `100`%, which is the *proportion* multiplied by 100 to be more readable.
- **Proportion**: A number from `0.0` to `1.0`, which can be multiplied by a number to take that amount of the number.
  - (`0.5 * number` = `50% of number` = half of it)

### Kill eater
This just means "Strange part", which tracks some statistic.  This isn't actually in the main list, but it's used in the names of a ton of other attributes, so I figured I'd mention it here.


## List Format:

- WeaponType
  - *Inherits from: (WeaponType)*
  - Items: (weapons that directly use this class)
    - Also: (weapons that use a _child_ of this type, but that child doesn't add anything attribute-related, so there's no reason to make a new category just for them.)
  - `checks_this_attribute_class`: DataType
    - Notes on how it's used in the code.
  - On X: `checks_this_attribute_class`: DataType (Specifically looks for the attribute on something _other_ than the weapon doing said check.)



# The Actual List

All descriptions are from their usage in the SDK, but it seems like the SDK is incomplete.  If any descriptions are inaccurate, please leave a comment.


## BaseEntity
- `counts_as_assister`: Boolean
  - If true, this item will get kill assist credit in the killfeed
- `mult_dmg_falloff`: Float
- `item_meter_resupply_denied`: Boolean
  - If true, resupply cabinets and spawning do not fully recharge the meter for this item.  Instead, its "default charge meter value" is used.
- `item_meter_charge_type`: [AttributeMeterType](##AttributeMeterType)
  - If `TIME` or `COMBO`, checks the `mult_item_meter_charge_rate` attribute for passive recharge rate mult.
  - If `DAMAGE` or `COMBO`, checks the `item_meter_damage_for_full_charge` and `mult_item_meter_charge_rate` attribute classes.
- `item_meter_damage_for_full_charge`: Float
  - Amount of meter required to fully charge the item.
  - If negative, 0, or not set, does not attempt to fill the meter at all when dealing damage.
- `mult_item_meter_charge_rate`: Float
  - Scale factor for meter gained per second and/or meter gained on dealing damage.
- `mult_crit_when_health_is_below_percent`: Float
  - Gives crit boost when your health is below this proportion
- `spunup_push_force_immunity`: Boolean
  - Only procs if Heavy and has a spun up minigun
- `mod_disguise_consumes_cloak`: Boolean
  - If true, disguising requires and consumes an entire cloak meter
- `set_blockbackstab_once`: Boolean
  - If on a Wearable: the item is "broken", it is given `nodraw`, and the player's secondary weapon's meter is reset.
  - If on a weapon, reduces all backstab damage taken by the player for all backstabs without any cooldown. Performs identically to the Mannpower "Resistance" powerup in this respect.

## BaseCombatWeapon
- *Inherits from: [BaseEntity](##BaseEntity)*
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
  - `become_fireproof_on_hit_by_fire`: Float
    - Addcond parameter
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
  - Can't be crit-boosted.
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
- `ubercharge_transfer`: Float
  - If `ubercharge_ammo` is set, hitting any other medic with the weapon will transfer this much ubercharge to them.
- `effectbar_recharge_rate`: Float
  - Things like throwable recharge timers, jetpack charging, etc. How much it recharges per... some amount of time.
- `weapon_blocks_healing`: Boolean
  - Prevents mediguns from latching onto you.
- `mult_uberchargerate_for_healer`: Float
  - Multiplier applied to your healer's ubercharge rate
  - NOTE: Only applied if user is outside of the respawn room
- `mod_jump_height_from_weapon`: Float
  - One of the "only when weapon is active" kind of attributes.  These always only work if the weapon that provides them is active, while still allowing other attributes to be globally-applied.
- `add_health_on_radius_damage`: Int
  - Maximum amount of health that can be gained from an AoE damage source.  Health received is multiplied by `damage dealt / base damage of the weapon`, to a max of 100% of the defined value.
- `mod_pierce_resists_absorbs`: Int
- `or_crit_vs_playercond`: Int
  - The weapon's "crit players with X condition" stat.  Each bit of this number specifies a condition that'll cause a forced crit, from [CritConditions](##CritConditions)
- `crit_vs_wet_players`: Boolean
- `or_crit_vs_not_playercond`: Int
  - Crit against players that DON'T have these conditions.
  - Uses same values as above list
- `axtinguisher_properties`: Boolean
  - On hitting a burning player, crit them from behind or minicrit them otherwise.
- `crit_while_airborne`: Boolean
  - Critical hit enemies if the player was launched into the air by an explosion
  - Only works when not in Mannpower mode
- `attack_minicrits_and_consumes_burning`: Boolean
  - Only activates if the weapon deals `DMG_MELEE`
- `air_dash_count`: Int
  - If greater than 0, attacks minicrit while airborne.
  - Only procs on Scout
- `or_minicrit_vs_playercond_burning`: Boolean
  - Minicrits if the damage dealt is NOT `DMG_BURN`
- `mini_crit_airborne`: Boolean
  - Mini-crits targets launched airborne by an explosion
  - Only procs when not in Mannpower mode
- `closerange_backattack_minicrits`: Boolean
  - If true, minicrits targets facing away from the attacker that are within 22.6 HU of the attacker (sqrt 512)
- `minicrits_become_crits`: Boolean
- `mult_dmg_vs_players`: Float
- `mult_dmg_vs_same_class`: Float
- `set_nocrit_vs_nonburning`: Boolean
  - Note: Even prevents criticals when crit-boosted
- `mult_dmg_vs_nonburning`: Float
- `crit_dmg_falloff`: Boolean
  - If true, crits have damage falloff (Ambassador)
- `crits_become_minicrits`: Boolean
- `energy_buff_dmg_taken_multiplier`: Float
  - Increases damage taken while minicrit-boosted by Crit-a-Cola, Buffalo Steak, etc.
- `add_cloak_on_hit`: Int
  - Adds this amount of cloak on hit
  - Only procs on Spy
- `set_dmgtype_ignite`: Boolean
  - Ignites player on hit
- `mult_dmgtaken_from_fire_active`: Float
  - Gain fire resistance only when this weapon is active
- `mult_dmg_vs_burning`: Float
- `mult_dmgtaken_active`: Float
- `dmg_from_melee`: Float
- `dmg_from_ranged`: Float
  - Applies to blast, bullet, buckshot, ignite, and sonic damage types
- `no_self_blast_dmg`: Boolean
- `blast_dmg_to_self`: Float
  - Multiplier applied to blast damage taken from an explosion caused by said entity
- `is_giger_counter`: Boolean
  - Used for killfeed
- `is_australium_item`: Boolean
  - Sets killfeed background gold
- `set_turn_to_gold`: Boolean
  - Sets killfeed background gold
- `mult_health_fromhealers_penalty_active`: Float
  - Attribute class is a flat multiplier applied to health from healers while weapon is active.
- `overheal_fill_rate`: Float
  - Checked on the player that is healing an entity
- `mult_healing_from_medics`: Float
  - Applies to all non-dispenser forms of healing that apply the `TF_COND_HEAL_BUFF` status.
- `mult_wpn_burndmg`: Float
  - Afterburn damage
- `halloween_green_flames`: Boolean
  - Makes afterburn green
- `mad_milk_syringes`: Boolean
  - Duration of 4 seconds, and increases by 0.5 seconds each hit.
- `enables_aoe_heal`: Boolean
  - Makes default weapon taunt perform the Amputator radial healing effect.
- `mult_wpn_burntime`: Float
  - Afterburn duration
- `sniper_fires_tracer`: Boolean
  - Note: Sniper rage forcibly draws a tracer regardless of this setting.
  - Used when firing bullets.
- `sniper_fires_tracer_HIDDEN`: Boolean
  - Same as `sniper_fires_tracer`.
- `mult_dmg_bullet_vs_sentry_target`: Float
- `sniper_penetrate_players_when_charged`: Boolean
- `projectile_penetration`: Int
  - Note: in MvM, Sniper's non-rifles are limited by the projectile penetration limit.
- `penetration_damage_penalty`: Float
- `firing_forward_pull`: Float
  - While firing the weapon, pulls the user forward with this velocity.
- `mult_player_movespeed_resource_level`: Float
  - Multiplier applied to movement speed scaled by ubercharge percentage.
  - Only works if the player using this item is a Medic with a Medigun
- `mult_player_movespeed_active`: Float
  - Multiplier applied to player movement speed only while this is the active weapon.
- `holster_anim_time`: Float
  - If greater than 0 (like with the Thermal Thruster), takes that amount of time to holster BEFORE actually swapping weapons.
- `building_teleporting_pickup`: Int
  - Metal cost to pick up a building at range.
  - Restricted to the default rescue ranger range, but can be used by any weapon.
- `bodyshot_damage_modify`: Float
  - Multiplier applied to bodyshot damage.
- `mult_healing_received`: Float
- `stun_enemies_wielding_same_weapon`: Boolean
- `no_self_blast_dmg`: Boolean
  - Checked on weapon to know whether to play the whistling sound or not.
- `damage_all_connected`: Boolean
  - Damage all players connected to the target by medigun beams.
- `apply_z_velocity_on_damage`: Float
  - Apply this amount of z velocity to players hit with this weapon.
- `apply_look_velocity_on_damage`: Float
  - Apply this amount of velocity in the direction you're facing to players hit with this weapon.
- `explode_on_ignite`: Boolean
  - Applies when *any weapon* with this attribute is in the second loadout slot of the player who covered someone in gas.  This attribute does not specifically check for the Gas Passer.  For example, f a Soldier has a rocket launcher that applies `TF_COND_GAS` and their shotgun in their secondary has this attribute, they'll still explode on ignite.
  - Only the afterburn specifically checks for the Gas Passer.
- `mult_dmgself_push_force`: Float
  - Applies to all self-damage taken from any source.
- `damage_causes_airblast`: Boolean
  - Knocks back attacker when wielder receives damage.
- `damage_blast_push`: Float
  - Push force applied to target when hitting an enemy.
  - Scales by range, to a minimum of 50% of the given value.
- `damage_force_reduction`: Float
  - Attribute class is a flat multiplier applied to push force received from damage.
- `bleeding_duration`: Float
  - Apply bleed on hit.
  - Value is a time in seconds.
- `no_death_from_headshots`: Boolean
  - When a headshot would kill you, reduce health to 1.
- `lifeleech_on_damage`: Float
  - Checked on attacker's active weapon, not the weapon that inflicted the damage.
  - Health gained = this * damage dealt, capped at your maximum overheal amount.
- `explosive_sniper_shot`: Boolean
  - Only applies if in a gamemode with upgrades, but applies to all headshots.
  - Also applies to any hitscan weapon with a `jarate_time` attribute that hit the head.
- `crit_kill_will_gib`: Boolean
- `crit_on_hard_hit`: Boolean
  - If false, this weapon can only gib if it deals blast damage or half-falloff damage.
- `add_onkill_critboost_time`: Int
  - Seconds of crit-boost gained on kill.
  - Note: actual time is `this + 1`.
- `add_onkill_minicritboost_time`: Int
  - Seconds of minicrit-boost gained on kill.
  - Note: actual time is `this + 1`.
- `halloween_death_ghosts`: Boolean
  - Exorcism spell effect
- `restore_health_on_kill`: Int
  - Percentage of health to be restored upon killing an enemy. (e.g. `25` is 25%)
  - Post-heal player health value is capped at 1.5x the player's normal max health.
  - Negative values are ignored.
- `heal_on_kill`: Int
  - Restores this flat amount of health on killing an enemy. Post-heal player health value is capped at the player's maximum overheal.
  - Negative values are NOT ignored.
- `speed_boost_on_kill`: Int
  - `addcond TF_COND_SPEEDBOOST <this>`
- Ragdolls:
  - `freeze_backstab_victim`: Boolean
    - Upon killing an enemy with a backstab, replace their ragdoll with an ice statue.
  - `set_turn_to_gold`: Boolean
    - Saxxy/golden pan effect
  - `ragdolls_become_ash`: Boolean
    - Flamethrower kills
  - `ragdolls_plasma_effect`: Boolean
    - Phlogistinator kills
  - `crit_on_hard_hit`: Boolean
- `mod_maxhealth_drain_rate`: Float
  - Maximum health decrease per tick while weapon is active. (Gloves of Running Urgently)
- `special_taunt`: Boolean
  - If true, prevents holiday taunts from being used.


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
- `override_projectile_type`: [ProjectileType](#ProjectileTypes)
  - If unset, uses the weapon's default projectile type.
- `mod_ammo_per_shot`: Int
  - How much ammo is used per shot. If 0, uses default.
- `projectile_spread_angle`: Float
  - Used when firing pipe bombs.
- `mult_projectile_range`: Float
  - Used when firing any projectile, including pipe bombs
- `grenade_no_spin`: Boolean
  - Don't spin loch n load pills
- `projectile_penetration`: Boolean
  - Also on WeaponBase, but noted here because it's specifically used in Gun's "fire arrow" logic.
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
- `self_mark_for_death`: Boolean
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
  - Used to specify "fist type".
  - 0 = No special behavior.
  - 1 = "Radial Buff" (On kill, forces player to taunt, giving 50 health and +10% crit chance to nearby teammates.  User cannot taunt manually.)
  - 2 = Gloves of Running Urgently (Gives a "penalty for spam-equipping gloves" that isn't present in the SDK as far as I can tell.)
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
    - If not 0, DMG_TYPE is "Pickaxe", else "Shovel"
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
  - Used to specify "bonesaw type". Unused.
- `special_taunt`: Boolean
  - If the player should taunt on right click
- `add_head_on_hit`: Boolean
  - If the player should take a "head" when dealing damage with a melee
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
- Weapons: The Blutsauger, The Overdose
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
  - How many seconds it takes to decloak.
  - Note that values less than or equal to `0.0` become `1.0`
- On player: `mult_cloak_meter_consume_rate`: Float
  - Multiply cloak consumption rate by this value.
- `mult_cloak_meter_regen_rate`: Float
- `mod_cloak_no_regen_from_items`: Boolean
  - Disallows ammo boxes from affecting the cloak meter.
- `NoCloakWhenCloaked`: Boolean
  - If true, cannot receive cloak while cloaked.
- `ReducedCloakFromAmmo`: Float
  - Multiplier applied to cloak gained from ammo boxes.
## PipebombLauncher
- *Inherits from: [BaseGun](#BaseGun)*
- Items: TF_WEAPON_PIPEBOMBLAUNCHER, The Scottish Resistance, Upgradeable TF_WEAPON_PIPEBOMBLAUNCHER, Stickybomb Jumper, Festive Stickybomb Launcher 2011, Silver Botkiller Stickybomb Launcher Mk.I, Gold Botkiller Stickybomb Launcher Mk.I, Rust Botkiller Stickybomb Launcher Mk.I, Blood Botkiller Stickybomb Launcher Mk.I, Carbonado Botkiller Stickybomb Launcher Mk.I, Diamond Botkiller Stickybomb Launcher Mk.I, Silver Botkiller Stickybomb Launcher Mk.II, Gold Botkiller Stickybomb Launcher Mk.II, The Quickiebomb Launcher
- (Stickybomb launchers, Grenade launchers)
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
- `override_projectile_type`: [ProjectileType](#ProjectileTypes)
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
  - If 2 (airburst mode), makes pills shatter on surfaces.  No other values implemented.
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
  - If `1`, alt-fire fires a mad-milked crossbow bolt with a meter. (Meter isn't implemented, but the milk bolt mechanism is.)
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
  - Gain health on backstab. (Conniver's Kunai)
## Sword
- *Inherits from: [BaseMelee](#BaseMelee)*
- The Eyelander, The Scotsman's Skullcutter, The Horseless Headless Horseman's Headtaker, The Claidheamohmor (sic), The Persian Persuader, Nessie's Nine Iron, Festive Eyelander
  - Also: The Half-Zatoichi
- `decapitate_type`: Int
  - More like a boolean.  Doesn't actually determine any kind of decapitation, just if it CAN decapitate.

## Wearable
- *Inherits from: [BaseEntity](##BaseEntity)*
- Items: Cosmetics
  - Also: The Manntreads, The Gunboats
  - Also: The Razorback, Darwin's Danger Shield, The Cozy Camper
  - Also: Ali Baba's Wee Booties, The Bootlegger
- `afterburn_immunity`: Boolean
  - For the base "`Wearable`", only checked on Sniper.
- `duck_badge_level`: Int
  - Determines if ***BONUS DUCKSSSS*** should increment the badge level.
- `player_skin_override`: Int
  - Overrides the skin used for the player. (e.g. Zombie)
## WearableDemoShield
- *Inherits from: [Wearable](#Wearable)*
- Items: The Chargin' Targe, The Splendid Screen, The Tide Turner, Festive Targe 2014
- `attack_not_cancel_charge`: Boolean
- On player: `mod_charge_time`: Float
  - Charge time mult
- On player: `charge_impact_damage`: Float
  - Impact damage mult
- `afterburn_immunity`: Boolean
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
- `override_projectile_type`: [ProjectileType](#ProjectileTypes)
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
- `applies_snare_effect`: Float
  - Multiplier applied to target move-speed on hit
  - Duration is equal to the rifle's `jarate_duration` attribute
- `aiming_no_flinch`: Boolean
  - Prevents flinching from damage when scoped and fully charged.
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
    - `mult_sentry_firerate`: Float
    - `build_small_sentries`: Boolean
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
  - Specifically checked on Crossbow Bolt impacts.
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

## Player
- *Inherits from: [Entity](##Entity)*
- Note: Anything checked for on a player can be applied by *any* item.
- `see_enemy_health`: Boolean
- `hide_enemy_health`: Boolean
  - Always true in MvM
- Spy-only:
  - `set_custom_buildmenu`: Int
  - `override_engineer_object_type`: Int
    - Default = -1
    - If 0, build a catapult
  - `disguise_as_dispenser_on_crouch`: Boolean
- `cannot_swim`: Boolean
  - If the jump button should work while in waist-high water
  - Also makes you sink like a stone in water instead of being able to move freely
- `swimming_mastery`: Boolean
  - If false or not present, move speed is 80% while swimming
- `mod_jump_height`: Float
- `hype_resets_on_jump`: Int
  - The amount to be subtracted from the hype meter when the Scout double-jumps.
- `parachute_attribute`: Boolean
  - Allows the parachute to be deployed
- `parachute_disabled`: Boolean
- `mod_air_control`: Float
  - Sidenote: the jetpack always multiplies your air acceleration by 50%
- `mod_air_control_blast_jump`: Float
  - Specifically while blast-jumping, as opposed to global
- `canteen_specialist`: Int
  - Discounts canteens by 10 * level
- `alien_isolation_xeno_bonus_pos`: Boolean
- `alien_isolation_merc_bonus_pos`: Boolean
- `jarate_backstabber`: Boolean
  - If true, jarates anyone who backstabs this player.
  - Note: does not block backstabs on its own.
- `medigun_bullet_resist_deployed`: Float
  - Multiplier to damage taken if player has  TF_COND_MEDIGUN_UBER_BULLET_RESIST
-  `medigun_bullet_resist_passive`: Float
  - Multiplier to damage taken if player has TF_COND_MEDIGUN_SMALL_BULLET_RESIST
- `medigun_blast_resist_deployed`: Float
  - Multiplier to damage taken if player has TF_COND_MEDIGUN_UBER_BLAST_RESIST
-  `medigun_blast_resist_passive`: Float
  - Multiplier to damage taken if player has TF_COND_MEDIGUN_SMALL_BLAST_RESIST
- `medigun_fire_resist_deployed`: Float
  - Multiplier to damage taken if player has TF_COND_MEDIGUN_UBER_FIRE_RESIST
-  `medigun_fire_resist_passive`: Float
  - Multiplier to damage taken if player has TF_COND_MEDIGUN_SMALL_FIRE_RESIST
- `disguise_no_burn`: Boolean
  - Prevent afterburn while disguised
- `uber_on_damage_taken`: Float
  - Chance to gain invulnerability when hit
- `mult_dmgtaken_from_crit`: Float
- `mult_dmgtaken_from_fire`: Float
- `mult_dmgtaken_from_explosions`: Float
- `mult_dmgtaken_from_bullets`: Float
- `mult_dmgtaken_from_melee`: Float
- `spunup_damage_resistance`: Float
  - Only procs on Heavies that are currently spun up on less than 50% HP
- `mult_dmgtaken`: Float
  - Multiplier to damage taken from all sources.
- `dmg_from_sentry_reduced`: Float
- `generate_rage_on_dmg`: Boolean
  - Only procs on Heavies, multiplies damage by 50% while rage is draining
- `rocket_jump_dmg_reduction`: Float
  - Multiplier applied to damage taken IF: it's blast damage or a flare explosion, the damage was caused by the user (self-damage), the user did not damage other players, and it is not a taunt-kill grenade (Escape Plan, Equalizer)
- `hype_on_damage`: Boolean
  - Adds the amount of damage dealt to the Scout hype meter, to a maximum of 200 damage which adds 50% meter.
- `rage_on_assists`: Float
  - Only procs on Sniper. Gain this amount of rage meter on assists.
- `killstreak_tier`: Int
- `cancel_falling_damage`: Boolean
- `scoreboard_minigame`: Boolean
  - If true, add `kills + captures + defenses + buildingsdestroyed - (3 * deaths)` to player score, on top of the default scoring algorithm
- `add_player_capturevalue`: Int
- `spawn_with_physics_toy`: Int
  - If 1, create a soccer ball on the ground when the player spawns.
- `item_meter_charge_type`: Int
  - If `mult_item_meter_charge_rate` is set, checks this attribute to see what type of meter should be modified, and also only allows it to activate if the active weapon is not a TF_WEAPON_FLAME_BALL
- `mult_health_fromhealers`: Float
- `cloak_blink_time_penalty`: Float
  - Multiplier
- `mod_mark_attacker_for_death`: Float
  - Number of seconds the player who hit this entity should be marked for death.
  - If attacker is affected by `TF_COND_ENERGY_BUFF` (Crit-a-Cola, Cleaner's Carbine, Buffalo Steak, etc.), the attacker receives `TF_COND_MARKEDFORDEATH_SILENT`
- `mod_charge_time`: Float
  - Only applies to Demoman
  - Attribute class is a flat multiplier applied to total charge time when charging
- `charge_recharge_rate`: Float
  - Only applies to Demoman
- `charge_turn_control`: Float
  - Default is 0.45f, and this class is a multiplier applied to it
- `lose_demo_charge_on_damage_when_charging`: Boolean
  - Used to detect the Tide Turner when deciding whether to give you minicrits or crits
- `mult_cloak_rate`: Float
- `set_quiet_unstealth`: Boolean
  - If true, plays `Player.Spy_UnCloakReduced` when decloaking
- `boots_falling_stomp`: Boolean
  - Deal 3x falling damage to player you land on
- `mult_decloak_rate`: Float
- `add_uber_time`: Float
  - Duration in seconds
- `mult_player_aiming_movespeed`: Float
  - Only applies to players that have TF_COND_AIMING
  - If Heavy, default aiming movespeed is 110
  - Else if player is using a compound bow, 160
  - Else 80
- `mult_player_movespeed`: Float
- `mult_player_movespeed_shieldrequired`: Float
- `add_head_on_hit`: Boolean
  - This part is only semi-implemented...
  - Gives extra player movespeed the more heads you have
  - Will not work if the player is not a Medic wielding the VitaSaw.
- `cannot_pick_up_intelligence`: Boolean
- `engy_disposable_sentries`: Int
  - Number of disposable sentries you're allowed to build.
  - Checked when checking if the player can build something.
  - Only works if the "uses upgrades" gamerule is set.
- `mod_teleporter_cost`: Float
  - Multiplier applied to teleporter build cost
- `building_cost_reduction`: Int
  - Overrides the building cost for all buildings
- `override_footstep_sound_set`: FootstepOverride
- `add_jingle_to_footsteps`: Int
  - If 1, use xmas.jingle, if 2 or higher use xmas.jingle_higher
- `halloween_footstep_type`: Int
  - Decimal version of the 4-byte hex code determining color of footsteps (e.g. `0xFFFFFFFF`, but in decimal)
- `no_attack`: Boolean
  - Prevents player from attacking.
- `no_jump`: Boolean
  - Prevents player from jumping.
- `no_duck`: Boolean
  - Prevents player from crouching.
- `cannot_pick_up_buildings`: Boolean
  - Prevents player from picking up buildings.
- `disable_weapon_switch`: Boolean
- `wet_immunity`: Boolean
  - If true, makes the player immune to "wet" status effects: Jarate, Mad Milk, Gas Passer.
- `set_cannot_disguise`: Boolean
- `mult_maxammo_primary`: Int
- `mult_maxammo_secondary`: Int
- `mult_maxammo_metal`: Int
- `mult_maxammo_grenades1`: Int
  - Only used for bat balls
- `set_buff_type`: [BuffType](##BuffType)
  - Note that Phlogistinator's rage has a small cooldown after expiring before it can gain rage again, to prevent the lingering crit flames from immediately filling it up again.
- `mod_buff_duration`: Float
  - Multiplier applied to buff duration.
- `mod_soldier_buff_range`: Float
  - Multiplier applied to the default 450 hammer unit range on banners.
- `weapon_blocks_healing`: Boolean
- `add_health_regen`: Float
  - Amount of health regenerated per regen tick.  Scales by the amount of time since the player last took damage in non-MvM modes.
- `addperc_ammo_regen`: Float
  - Percentage of ammo regenerated every 5 seconds.
- `add_metal_regen`: Int
  - Amount of metal regenerated every 5 seconds.
- `airblast_vulnerability_multiplier`: Float
- `airblast_vertical_vulnerability_multiplier`: Float
- `enable_misc2_noisemaker`: Boolean
  - Uses noise maker when pressing action slot key
- `calling_card_on_kill`: Int
  - Defines the calling card that should be dropped when this player kills another player.
- `sentry_build_rate_multiplier`: Float
- `teleporter_build_rate_multiplier`: Float
  - Also used for dispensers.
- `headshot_damage_modify`: Float
  - Multiplier applied to headshot damage
- `decapitate_type`: Int
  - More like a boolean.  Doesn't actually determine any kind of decapitation, just if it CAN decapitate.
  - Checked on all hitscan attacks.
- `generate_rage_on_dmg`: Boolean
  - Only works on Engineer and Heavy.
  - On Engineer, adds all damage dealt to the rage meter.
  - On Heavy, adds `0.22` * the damage.
- `falling_impact_radius_pushback`: Boolean
  - Requires player to have the `TF_COND_ROCKETPACK` condition.
  - Pushes back nearby players around the landing site.
- `falling_impact_radius_stun`: Boolean
  - If `falling_impact_radius_pushback` is set, this will also stun any enemies in the impact radius.
- `teleport_instead_of_die`: Float
  - Chance to teleport back to spawn upon receiving fatal damage instead of dying.
- `rage_giving_scale`: Float
  - Multiplier applied to rage gained by dealing damage, taking damage, or dealing burn damage.
- `fish_damage_override`: Boolean
  - If the weapon is a Holy Mackerel reskin (AKA either the fish or the Unarmed Combat) and this is set, use the Unarmed Combat "arm hit" killfeed notice instead of the "fish hit" notice.
- `bombinomicon_effect_on_death`: Boolean
- `force_distribute_currency_on_death`: Boolean
  - Only active in MvM.  Automatically collects the money this player would drop on death, as though they were killed by a sniper.
- `drop_health_pack_on_kill`: Boolean
  - Drop a small health pack when killing an enemy.
- `kill_forces_attacker_to_laugh`: Boolean
  - On killing an enemy, schadenfreude
- Deny Resupply
  - "Items that rely on timers to refill ammo use these attributes.  Prevents 'touch supply closet and spam the thing' scenario."
  - `grenades1_resupply_denied`: Boolean
  - `grenades2_resupply_denied`: Boolean
  - `grenades3_resupply_denied`: Boolean
- `mult_metal_pickup`: Float
  - Multiplier applied to metal gained from ammo boxes
- `add_maxhealth_nonbuffed`: Int
  - Additive base-health increase.
- `add_maxhealth`: int
  - Additive maximum health increase only used when overhealing.
- `unlimited_quantity`: Boolean
  - If true, noisemakers are unlimited usage.
- `zombiezombiezombiezombie`: Boolean
  - If true, the zombiezombiezombiezombie skin is equipped.
- `mult_gesture_time`: Float
  - Multiplier applied to taunt speed.
- `cosmetic_taunt_sound`: String
  - Sound to be played when performing a taunt.
- `special_dsp`: Int
  - DSP used when emitting sounds created by this player.
- `head_scale`: Float
- `torso_scale`: Float
- `hand_scale`: Float
- `can_breathe_under_water`: Boolean
- Scout Only:
  - `set_scout_doublejump_disabled`: Boolean
  - `hype_decays_over_time`: Float
    - How much the Scout's hype meter decays every tick
  - `lose_hype_on_take_damage`: Int
    - Amount of hype lost per point of damage taken.
- Demoman Only:
  - `lose_demo_charge_on_damage_when_charging`: Boolean
  - `kill_refills_meter`: Float
    - Amount of Targe-Charge gained on kill.  Scaled by various values.
  - `decapitate_type`: Boolean
    - If true, reduces max health gained from Knockout rune to 20.
- Sniper Only:
  - `mult_aiming_knockback_resistance`: Float
  - `rage_on_kill`: Float
    - Amount of sniper rage gained on kill.
- Medic Only:
  - `healing_mastery`: Int
    - Each level gives +25% of the Medic's passive regen
  - `generate_rage_on_heal`: Boolean
- Spy Only:
  - `add_cloak_on_kill`: Int
    - Amount of cloak gained on kill.
  - `custom_taunt_particle_attr`: Boolean
    - Use Saharan Spy particle effect when performing a stock knife taunt.
## MvM Bot:
- *Inherits from: [Player](##Player)*
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

## tf_weaponbase_rocket
- *Inherits from: [tf_projectile_base](##tf_projectile_base)*
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
- `rocket_specialist`: Int
  - If greater than 0, rocket does not have damage falloff

## tf_projectile_rocket
- *Inherits from: [tf_weaponbase_rocket](##tf_weaponbase_rocket)*
- `halloween_pumpkin_explosions`: Boolean
  - Checks on owner or sentry's owner
## tf_projectile_flare
- *Inherits from: [tf_projectile_base](##tf_projectile_base)*
- Used by: All flare guns
- On launcher: `mult_projectile_speed`: Float
- On launcher: `mult_explosion_radius`: Float
- On launcher:  `mod_projectile_heat_seek_power`: Float
## tf_weaponbase_grenadeproj
- *Inherits from: [tf_projectile_base](##tf_projectile_base)*
- Projectiles: Grenade Launchers, Loose Cannon
- On launcher: `use_large_smoke_explosion`: Boolean
- On launcher: `halloween_pumpkin_explosions`: Boolean
- On launcher: `mult_explosion_radius`: Float
- On owner: `fuse_mult`: Float
## tf_projectile_energyring
- *Inherits from: [tf_projectile_base](##tf_projectile_base)*
- Used by: Righteous Bison, Pomson 6000
- On owner: `energy_weapon_penetration`: Boolean
## tf_projectile_arrow
- *Inherits from: [tf_projectile_base](##tf_projectile_base)*
- Used by: Huntsman, Crusader's Crossbow, Rescue Ranger
- On player: `arrow_heals_buildings`: Boolean
## tf_weapon_grenade_pipebomb
- *Inherits from: [tf_projectile_base](##tf_projectile_base)*
- Used by: All Stickybomb Launchers
- On launcher: `stickybomb_fizzle_time`: Float
- On launcher: `grenade_no_bounce`: Boolean
- On launcher: `sticky_arm_time`: Float
- On launcher: `grenade_damage_reduction_on_world_contact`: Float

# Flames
- `flame_spread_degree`: Float
- `redirected_flame_size_mult`: Float
- `mult_flame_size`: Float
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

# Misc

## PowerUpBottle
- These determine what the canteen does when used.
  - Note: only the first valid attribute in this list is displayed on the player, but setting multiple will have all effects go off at once.
  1. `critboost`: Boolean
  2. `ubercharge`: Boolean
  3. `recall`: Boolean
  4. `refill_ammo`: Boolean
  5. `building_instant_upgrade`: Boolean
- `powerup_duration`: Float
- On player - `canteen_specialist`: Int
  - Adds extra time to the base powerup duration based on level
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
  - If true, the particle only applies to the throwable particle trail.

# Enums
## ProjectileTypes
0. TF_PROJECTILE_NONE,
1. TF_PROJECTILE_BULLET,
2. TF_PROJECTILE_ROCKET,
3. TF_PROJECTILE_PIPEBOMB,
4. TF_PROJECTILE_PIPEBOMB_REMOTE,
5. TF_PROJECTILE_SYRINGE,
6. TF_PROJECTILE_FLARE,
7. TF_PROJECTILE_JAR,
8. TF_PROJECTILE_ARROW,
9. TF_PROJECTILE_FLAME_ROCKET,
10. TF_PROJECTILE_JAR_MILK,
11. TF_PROJECTILE_HEALING_BOLT,
12. TF_PROJECTILE_ENERGY_BALL,
13. TF_PROJECTILE_ENERGY_RING,
14. TF_PROJECTILE_PIPEBOMB_PRACTICE,
15. TF_PROJECTILE_CLEAVER,
16. TF_PROJECTILE_STICKY_BALL,
17. TF_PROJECTILE_CANNONBALL,
18. TF_PROJECTILE_BUILDING_REPAIR_BOLT,
19. TF_PROJECTILE_FESTIVE_ARROW,
20. TF_PROJECTILE_THROWABLE,
21. TF_PROJECTILE_SPELL,
22. TF_PROJECTILE_FESTIVE_JAR,
23. TF_PROJECTILE_FESTIVE_HEALING_BOLT,
24. TF_PROJECTILE_BREADMONSTER_JARATE,
25. TF_PROJECTILE_BREADMONSTER_MADMILK,
26. TF_PROJECTILE_GRAPPLINGHOOK,
27. TF_PROJECTILE_SENTRY_ROCKET,
28. TF_PROJECTILE_BREAD_MONSTER


## BuffType
- 0 = None
  - Will crash if used
- 1 = Buff Banner
  - Increase: OnDamageDealt
- 2 = Battalion's Backup
  - Increase: OnDamageDealt
- 3 = Concheror
  - Increase: OnDamageDealt
  - Amount of meter given by damage multiplied by 1.25x
- 4 = NoHealingDamageBuff (Unused)
  - Increase: OnMedicHealingReceived
- 5 = Phlogistinator
  - Increase: OnBurnDamageDealt
- 6 = Hitman's Heatmaker
  - Increase: OnHeal (likely to prevent him from gaining rage the normal way)
  - Interestingly, this means that if the Sniper can somehow heal his teammates, he *will* gain rage from that.
  - However, the actual weapon uses the `rage_on_kill` and `rage_on_assists` attributes to gain rage.
## AttributeMeterType
- 0 = NONE
- 1 = TIME
- 2 = DAMAGE
- 3 = COMBO

## FootstepOverride
- 0 = Default
- 1 = SoccerCleats
- 2 = HeavyGiant
- 3 = SoldierGiant
- 4 = DemoGiant
- 5 = ScoutGiant
- 6 = PyroGiant
- 7 = SentryBuster
- 8 = TreasureChest
- 9 = Octopus

## CritConditions
- TF_COND_BURNING,					// 1 (1<<0)
  - Currently on fire, whether or not they experience afterburn damage. (Includes Pyros currently caught in flames.)
- TF_COND_AIMING,						// 2 (1<<1)
  - Scoped into a sniper-rifle OR revved-up with a minigun.
- TF_COND_ZOOMED,						// 4 (1<<2)
  - Scoped into a sniper-rifle.
- TF_COND_DISGUISING,					// 8 (...)
  - In the act of disguising, where the cloud of smoke surrounds them.
- TF_COND_DISGUISED,					// 16
  - Currently disguised as another player.
- TF_COND_STEALTHED,					// 32
  - Currently cloaked and fully invisible.
- TF_COND_INVULNERABLE,				// 64
  - Under the effects of a stock Ubercharge.
- TF_COND_TELEPORTED,					// 128
  - Recently teleported by a teleporter, with the ring of light around their feet.
- TF_COND_TAUNTING,					// 256
  - Currently taunting.
- TF_COND_INVULNERABLE_WEARINGOFF,	// 512
  - Under the effects of a stock Ubercharge, where the effect has started to flash to indicate it is about to disappear.
- TF_COND_STEALTHED_BLINK,			// 1024
  - When a cloaked spy is bumped by another player, or the Cloak and Dagger has run out of charge but the spy is still moving.
- TF_COND_SELECTED_TO_TELEPORT,		// 2048
  - When a teleporter has selected this entity to be teleported, and they are experiencing the flash of light and camera distortion leading up to their teleportation.
- TF_COND_CRITBOOSTED,				// 4096
  - Crit-boosted, such as during a Kritzkrieg Ubercharge or after capturing the flag in CTF.
- TF_COND_TMPDAMAGEBONUS,				// 8192
  - Unimplemented.
- TF_COND_FEIGN_DEATH,				// 16384
  - The condition taken on by a player after their Dead Ringer has been triggered, where they are temporarily immune to afterburn or having their cloak blink upon contact with enemies or taking damage.
- TF_COND_PHASE					// 32768
  - The condition taken on by drinking the Bonk! Atomic Punch, where the player is restricted to melee-only, is immune to all damage for the duration, and has their movement speed reduced after it expires based on how much damage they would have taken while the effect was active.
- TF_COND_STUNNED,					// 65536
  - The stun effect applied by the Sandman or `mod_stun_waist_high_airborne`.
- TF_COND_HEALTH_BUFF,	(Player is being healed by a Medi-Gun or Dispenser)			// 131072
  - Applied when a player is being healed over time by a Medi-Gun or dispenser.
- TF_COND_HEALTH_OVERHEALED,			// 262144
  - Applied when a player has overheal.
- TF_COND_URINE,						// 524288
  - Targets take minicrits and are covered in high-tier martial arts.
- TF_COND_ENERGY_BUFF (Minicrit-boosted by Cleaner's Carbine or Crit-a-Cola)			// 1048576
  - Minicrit-boost applied by the Crit-a-Cola, Cleaner's Carbine, and Buffalo Steak Sandvich.  Not applied by the Buff Banner.