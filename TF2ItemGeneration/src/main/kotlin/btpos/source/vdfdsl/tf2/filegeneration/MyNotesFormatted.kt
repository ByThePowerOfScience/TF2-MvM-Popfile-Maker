package btpos.source.vdfdsl.tf2.filegeneration

import btpos.source.vdfdsl.tf2.filegeneration.representations.FakeCodec
import btpos.source.vdfdsl.tf2.filegeneration.representations.ISortedNamedAttribute
import btpos.source.vdfdsl.tf2.filegeneration.representations.NamedAttribute
import btpos.source.vdfdsl.tf2.filegeneration.representations.bool
import btpos.source.vdfdsl.tf2.filegeneration.representations.groupings.HierarchyNamedAttributeScope
import btpos.source.vdfdsl.tf2.filegeneration.representations.groupings.NamedAttributeScope
import btpos.source.vdfdsl.tf2.filegeneration.representations.selectorCodec
import kotlin.collections.flatten

// TODO: change attribute interfaces to be specifically THEIR attributes, and then add an "inherited" variant that's used for the item scopes, that way people will only see the attributes for a specific type when they do for example BuffItemAttributes.XXX


object MyNotesFormatted {
	sealed interface IAttrThing {
		operator fun contains(clsName: String): Boolean
		
		operator fun get(clsName: String): AttrClassUsage?
		
		fun absorb(classToNamed: Map<String, List<ISortedNamedAttribute>>): List<ISortedNamedAttribute>
	}
	
	private fun String.comma() = this.split(", ")
	
	class AttrClassUsage(val attr_class: String, val kType: String, notes: List<String> = listOf()) : IAttrThing {
		val notes = notes.map { if (!it.endsWith('.')) it + '.' else it }
		
		
		override fun get(clsName: String): AttrClassUsage? {
			if (this.attr_class == clsName)
				return this
			return null
		}
		companion object {
			val attrRegex = Regex("""^\s*-\s*(?:On (\w+):)?\s*`(\w+)`: (\w+)(\s*\W.+)?$""")
			val noteRegex = Regex("""^\s*-\s*(\w.+)$""")
			val linkRegex = Regex("""\[\w+]\(#(\w+)\)""")
			
			operator fun invoke(string: String, notes: List<String> = listOf()): AttrClassUsage {
				val (onWhat, cls, type, _extratypeinfo) = attrRegex.matchEntire(string)?.destructured
				                                          ?: error("Failed to parse attr entry for $string")
				
				return AttrClassUsage(cls, type, notes.map { noteRegex.matchEntire(it)!!.groupValues[1] })
			}
			
			operator fun invoke(string: String): AttrClassUsage {
				val split = string.split("\n")
				val (onWhat, name, type, _) = attrRegex.matchEntire(split[0])?.destructured
				                              ?: error("Failed to match attr entry ${split[0]}")
				val notes = split.drop(1)
					.mapNotNull {
						noteRegex.matchEntire(it)?.groupValues[1]
					}
					.run {
						onWhat.takeIf { !it.isEmpty() }
							?.let {
								this + "Checked on $onWhat"
							} ?: this
					}
				
				return AttrClassUsage(name, type, notes)
			}
			
			val attrToSelector = mapOf(
//				"Fists" to mapOf("fists have radial buff" to 1),
				"Invis" to mapOf(
					"set cloak is movement based" to 1,
					"set cloak is feign death" to 2
				),
				"Bat" to mapOf(
					"mod bat launches balls" to 1,
					"mod bat launches ornaments" to 2
				),
				"Revolver" to mapOf("revolver use hit locations" to 1),
				"Shovel" to mapOf(
					"mod shovel damage boost" to 1,
					"mod shovel speed boost" to 2
				),
				"Lunchbox" to mapOf(
					"lunchbox adds maxhealth bonus" to 1,
					"lunchbox adds minicrits" to 2
				),
				"SniperRifle" to mapOf("sniper no headshots" to 1),
				"Knife" to mapOf("set icicle knife mode" to 3),
				"FlareGun" to mapOf("mod flaregun fires pellets with knockback" to 3)
			)
			
			val customCodecs = mapOf(
				"or_crit_vs_not_playercond" to FakeCodec("EnumSet<TFCritCondition>", "EnumSetOrCodec()"),
				"or_crit_vs_playercond" to FakeCodec("EnumSet<TFCritCondition>", "EnumSetOrCodec()"),
			)
		}
		
		override fun contains(clsName: String): Boolean {
			return attr_class == clsName
		}
		
		
		override fun absorb(classToNamed: Map<String, List<ISortedNamedAttribute>>): List<ISortedNamedAttribute> {
			return classToNamed[attr_class]?.map { attr ->
				attr.clone()
					.apply {
						setCodec {
							if (attr_class == "set_weapon_mode") {
								selectorCodec(
									attrToSelector.values.flatMap { it.entries }
										.find { (k, v) -> k == it.attrName }?.value
									?: error("no selector found for ${it.attrName}")
								)
							} else if (kType == "Boolean") {
								bool
							} else {
								customCodecs[it.className] ?: it.codec
							}
						}
						notes = this@AttrClassUsage.notes
					}
			}
				.orEmpty()
		}
	}
	
	
	open class AttrClassScope(val name: String, val attrClassesOrNestedScopes: List<IAttrThing>, applicableWeapons: List<Any> = listOf()) : IAttrThing {
		val applicableWeapons = applicableWeapons.map { if (it is String) it.split(", ") else it as List<String> }
		
		constructor(name: String, vararg attrs: IAttrThing, applicableWeapons: List<Any> = listOf()) : this(name, attrs.asList(), applicableWeapons)
		
		override operator fun contains(clsName: String): Boolean {
			return attrClassesOrNestedScopes.any { clsName in it }
		}
		
		override fun get(clsName: String): AttrClassUsage? {
			return attrClassesOrNestedScopes.firstNotNullOfOrNull { it[clsName] }
		}
		
		/**
		 * Turn this nested scoped mess of CLASSES into a nested scoped mess of NAMED ATTRIBUTES
		 */
		override fun absorb(classToNamed: Map<String, List<ISortedNamedAttribute>>): List<ISortedNamedAttribute> {
			val mapped = attrClassesOrNestedScopes.flatMap { it.absorb(classToNamed) }
			return listOf(NamedAttributeScope(this.name, *mapped.toTypedArray()))
		}
	}
	
	class HierarchyAttrClassScope(name: String, attrClassesOrNestedScopes: List<IAttrThing>, applicableWeapons: List<Any> = listOf()) : AttrClassScope(name, attrClassesOrNestedScopes, applicableWeapons) {
		override fun absorb(classToNamed: Map<String, List<ISortedNamedAttribute>>): List<ISortedNamedAttribute> {
			val classToNamed = classToNamed.toMutableMap()
				.also { map ->
					val applicableWeaponModeAttrs = AttrClassUsage.attrToSelector[this.name]?.keys ?: emptySet()
					if (applicableWeaponModeAttrs.isEmpty()) {
						map.remove("set_weapon_mode")
					} else {
						map["set_weapon_mode"]?.let { weaponModeAttrs ->
							map["set_weapon_mode"] = weaponModeAttrs.filter { it is NamedAttribute && it.attrName in applicableWeaponModeAttrs }
						}
					}
				}
			val mapped = attrClassesOrNestedScopes.flatMap { it.absorb(classToNamed) }
			return listOf(
				HierarchyNamedAttributeScope(
					this.name, getParent(this.name), *mapped.toTypedArray(), _note = applicableWeapons.takeIf { it.isNotEmpty() }
						?.flatten()
						?.joinToString(", ")
						?.let { "Items: $it" })
			)
		}
	}
	
	fun getParent(weaponType: String): String? {
		return hierarchy.entries.firstOrNull { weaponType in it.value }?.key
	}
	
	val hierarchy = mapOf(
		"Entity" to listOf("Player"),
		"Player" to listOf("BaseEntity"),
		
		"BaseEntity" to listOf("BaseCombatWeapon", "Wearable", "EconEntity"),
		
		Pair("BaseCombatWeapon", listOf("WeaponBase")),
		
		Pair(
			"WeaponBase", listOf(
				"BaseGun",
				"BaseMelee",
				"Flamethrower",
				"Invis",
				"Lunchbox",
				"Builder",
				"ProjectileGrenade"
			)
		),
		
		Pair(
			"BaseGun", listOf(
				"SMG",
				"Minigun",
				"Pistol",
				"Revolver",
				"SyringeGun",
				"StickybombLauncher",
				"RocketLauncher",
				"GrenadeLauncher",
				"Jar",
				"MechanicalArm",
				"Shotgun",
				"FlareGun",
				"SniperRifle",
				"Medigun"
			)
		),
		
		Pair("SMG", listOf("ChargedSMG")),
		
		Pair("Pistol", listOf("ScoutPistol")),
		
		Pair("Shotgun", listOf("Scattergun", "ShotgunRevenge")),
		
		Pair("Bottle", listOf("StickBomb")),
		
		Pair("Jar", listOf("Throwable")),
		
		Pair("Builder", listOf("Sapper")),
		
		Pair(
			"BaseMelee", listOf(
				"Fists",
				"Shovel",
				"Bottle",
				"FireAxe",
				"Bonesaw",
				"RocketPack",
				"BuffItem",
				"Wrench",
				"Knife",
				"Sword",
				"Bat"
			)
		),
		
		Pair("StickybombLauncher", listOf("CompoundBow")),
		
		Pair(
			"RocketLauncher", listOf(
				"RocketLauncher_AirStrike",
				"Crossbow",
				"RayGun"
			)
		),
		
		Pair("RayGun", listOf("Raygun_Revenge")),
		
		Pair("Wearable", listOf("WearableDemoShield", "PowerUpBottle")),
		
		"Entity" to listOf("MvMBot", "Player"),
		
		"BaseProjectile" to listOf(
			"BaseRocket",
			"ProjectileEnergyRing"
		),
		
		"BaseRocket" to listOf("ProjectileRocket", "ProjectileFlare", "ProjectileArrow"),
		
		"ProjectileGrenade" to listOf("ProjectilePipebomb")
	)
	
	val attrsByClass: List<AttrClassScope>
		get() = listOf(
			HierarchyAttrClassScope(
				"BaseCombatWeapon", listOf(
					AttrClassUsage(
						"mod_use_metal_ammo_type", "Boolean", listOf(
							"Reminder: non-engies start with 100 metal."
						)
					),
					AttrClassUsage(
						"mod_max_primary_clip_override", "Int", listOf(
							"Overwrites the max clipsize to a flat value. Applied before other multipliers."
						)
					),
					AttrClassUsage(
						"mod_no_reload_display_only", "Float", listOf(
							"In the `DoesReloadSingly` check, this _is_ actually checked, so it's actually _not_ \"display-only\".",
							"If != 1.0 (if present), says the weapon \"does not reload one shot at a time\"."
						)
					),
					AttrClassUsage(
						"set_scattergun_no_reload_single", "Boolean", listOf(
							"Checked in `DoesReloadSingly`.  If true, weapon does not reload one shot at a time. (e.g. FaN)",
							"Note that for the most part, this logic is set inside the weapon itself. The scattergun thing is weirdly the only way to control this with attributes."
						)
					)
				)
			),
			
			HierarchyAttrClassScope(
				"BaseEntity", """- `counts_as_assister`: Boolean
	- If true, this item will get kill assist credit in the killfeed
- `mult_dmg_falloff`: Float
- `item_meter_resupply_denied`: Boolean
	- If true, resupply cabinets and spawning do not fully recharge the meter for this item.  Instead, its "default charge meter value" is used.
- `item_meter_charge_type`: AttributeMeterType
	- If [TIME][AttributeMeterType.TIME] or [AttributeMeterType.COMBO], checks the `mult_item_meter_charge_rate` attribute class for passive recharge rate mult.
	- If [DAMAGE][AttributeMeterType.DAMAGE] or [COMBO][AttributeMeterType.COMBO], checks the `item_meter_damage_for_full_charge` and `mult_item_meter_charge_rate` attribute classes.
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
	- If on a weapon, reduces all backstab damage taken by the player for all backstabs without any cooldown.  Performs identically to the Mannpower "Resistance" powerup in this respect.""".notesToAttrClassUsages()
			),
			
			HierarchyAttrClassScope(
				"WeaponBase", listOf(
					AttrClassUsage(
						"custom_charge_meter", "Boolean", listOf(
							"if true, do not render demoman's charge meter",
							"Note: this might not actually be implemented"
						)
					),
					AttrClassUsage(
						"ammo_gives_charge", "Boolean", listOf(
							"If true, and player has a demoman charge meter, add charge based on ammo pack size"
						)
					),
					AttrClassUsage("no_primary_ammo_from_dispensers", "Boolean", listOf()),
					AttrClassUsage("no_metal_from_dispensers_while_active", "Boolean", listOf()),
					AttrClassUsage("mult_dmg_vs_buildings", "Float", listOf()),
					AttrClassUsage("mult_clipsize", "Float", listOf()),
					AttrClassUsage("mult_clipsize_upgrade", "Int", listOf("Stacks with [clipSize]")),
					AttrClassUsage(
						"mult_clipsize_upgrade_atomic", "Int", listOf(
							"MVM attribute that specifically handles rocket and grenade launchers",
							"Note that [clipSize], [clipSizeBonusUpgrade], and [clipSizeUpgradeAtomic] all stack with one another."
						)
					),
					AttrClassUsage("clipsize_increase_on_kill", "Int", listOf()),
					AttrClassUsage(
						"wrench_builds_minisentry", "Boolean", listOf(
							"Determines the hand used in the model"
						)
					),
					AttrClassUsage(
						"mult_deploy_time", "Float", listOf(
							"Checked on player"
						)
					),
					AttrClassUsage("mult_single_wep_deploy_time", "Float", listOf()),
					AttrClassUsage("mult_switch_from_wep_deploy_time", "Float", listOf()),
					AttrClassUsage("mult_rocketjump_deploy_time", "Float", listOf()),
					AttrClassUsage(
						"is_a_sword", "Boolean", listOf(
							"If true, make weapon deploy and holster 75% slower"
						)
					),
					AttrClassUsage(
						"mod_medic_healed_deploy_time", "Float", listOf(
							"On player",
							"Multiplier applied if NOT being healed by a medic"
						)
					),
					AttrClassUsage(
						"force_weapon_switch", "Boolean", listOf(
							"Should force switch to this item on some condition."
						)
					),
					AttrClassUsage(
						"provide_on_active", "Boolean", listOf(
							"If true, only applies attributes when weapon is active, and unapplies them when switching off.",
							"This also means you can't have \"only active when holding weapon\" and \"always active\" attributes on the same weapon (excluding the specific attributes that are _always_ \"only when active\"), since the order you specify attributes in doesn't matter."
						)
					),
					AttrClassUsage(
						"projectile_penetration", "Int", listOf(
							"How many players your \"projectile\" (*including bullets*) should penetrate."
						)
					),
					AttrClassUsage("mult_bullets_per_shot", "Float", listOf()),
					AttrClassUsage("mult_dmg", "Float", listOf()),
					AttrClassUsage(
						"mult_crit_chance", "Float", listOf(
							"\"No random crits\" sets this to `0.0`"
						)
					),
					AttrClassUsage("auto_fires_full_clip", "Boolean", listOf()),
					AttrClassUsage("auto_fires_full_clip_all_at_once", "Boolean", listOf()),
					AttrClassUsage(
						"can_overload", "Boolean", listOf(
							"Deals damage to the player when overloaded."
						)
					),
					AttrClassUsage(
						"mult_postfiredelay", "Float", listOf(
							"After firing, you wait a bit before you can fire again. That's the \"delay\"."
						)
					),
					AttrClassUsage(
						"kill_combo_fire_rate_boost", "Float", listOf(
							"Subtract `this * \"kill combo\"` from the post-fire delay"
						)
					),
					AttrClassUsage("auto_fires_when_full", "Boolean", listOf()),
					AttrClassUsage("mult_reload_time", "Float", listOf()),
					AttrClassUsage("mult_reload_time_hidden", "Float", listOf()),
					AttrClassUsage(
						"fast_reload", "Float", listOf(
							"This is what's used for weapons that draw directly from reserve ammo, like the flare gun and sniper rifle."
						)
					),
					AttrClassUsage(
						"hwn_mult_reload_time", "Float", listOf(
							"On player",
							"Halloween reload time multiplier."
						)
					),
					AttrClassUsage("mult_reload_time_while_healed", "Float", listOf()),
					AttrClassUsage("weapon_allow_inspect", "Boolean", listOf()),
					AttrClassScope(
						"OnHit",
						"""- `add_onhit_addammo`: Boolean
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
	- Drain still scaled over distance""".notesToAttrClassUsages()
					),
					*(("""- `become_fireproof_on_hit_by_fire`: Float
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
	- Can't be crit-boosted
- `sapper_kills_collect_crits`: Boolean
	- The weapon supports revenge crits if this, `extinguish_revenge`, or `sentry_killed_revenge` are set.
	- Note that the logic for _gaining_ said crits depends on the weapon. Having one of these set just says it _can_ have them.
- `extinguish_revenge`: Boolean
	- The weapon supports revenge crits if this, `sapper_kills_collect_crits`, or `sentry_killed_revenge` are set.
	- Note that the logic for _gaining_ said crits depends on the weapon. Having one of these set just says it _can_ have them.
- `sentry_killed_revenge`: Boolean
	- The weapon supports revenge crits if this, `extinguish_revenge`, or `sapper_kills_collect_crits` are set.
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
- `mod_pierce_resists_absorbs`: Boolean
- `or_crit_vs_playercond`: EnumSet<TFCritCondition>
	- The weapon's "crit players with X condition" stat.  Each bit of this number specifies a condition that'll cause a forced crit, from [CritConditions][#CritConditions]
- `crit_vs_wet_players`: Boolean
- `or_crit_vs_not_playercond`: EnumSet<TFCritCondition>
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
	- Only procs if the damage dealt is NOT `DMG_BURN`
- `mini_crit_airborne`: Boolean
	- Mini-crits targets launched airborne by an explosion
	- Only procs when not in Mannpower mode
- `closerange_backattack_minicrits`: Boolean
	- If true, minicrits targets facing away from the attacker that are within 22.6 HU of the attacker (sqrt 512)
- `minicrits_become_crits`: Boolean
- `mult_dmg_vs_players`: Float
- `mult_dmg_vs_same_class`: Float
- `set_nocrit_vs_nonburning`: Boolean
	- Note: prevents criticals even when crit-boosted
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
	- Applies to all non-dispenser forms of healing that apply the TF_COND_HEAL_BUFF status.
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
- `explosive_sniper_shot`: Int
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
- `mod_maxhealth_drain_rate`: Float
	- Maximum health decrease per tick while weapon is active. (Gloves of Running Urgently)
- `special_taunt`: Boolean
	- If true, prevents holiday taunts from being used.""".notesToAttrClassUsages() + AttrClassScope("Ragdolls", """- `freeze_backstab_victim`: Boolean
	- Upon killing an enemy with a backstab, replace their ragdoll with an ice statue.
- `set_turn_to_gold`: Boolean
	- Saxxy/golden pan effect
- `ragdolls_become_ash`: Boolean
	- Flamethrower kills
- `ragdolls_plasma_effect`: Boolean
	- Phlogistinator kills
- `crit_on_hard_hit`: Boolean""".notesToAttrClassUsages())).toTypedArray())
			)),
			
			HierarchyAttrClassScope(
				"BaseGun", listOf(
					AttrClassUsage(
						"keep_disguise_on_attack", "Boolean", listOf(
							"If true, spies will keep their disguise when attacking with this weapon."
						)
					),
					AttrClassUsage(
						"override_projectile_type", "ProjectileType", listOf(
							"If unset, uses the weapon's default projectile type.",
							"Else use a numbered [ProjectileType]"
						)
					),
					AttrClassUsage(
						"mod_ammo_per_shot", "Int", listOf(
							"How much ammo is used per shot. If 0, uses default."
						)
					),
					AttrClassUsage(
						"mult_projectile_range", "Float", listOf(
							"Used when firing any projectile, including pipe bombs"
						)
					),
					AttrClassUsage(
						"grenade_no_spin", "Boolean", listOf(
							"Don't spin loch n load pills"
						)
					),
					AttrClassUsage(
						"projectile_penetration", "Int", listOf(
							"Also on WeaponBase, but noted here because it's specifically used in gun's \"fire arrow\" logic."
						)
					),
					AttrClassUsage(
						"mult_spread_scale", "Float", listOf(
							"Modifies bullet spread."
						)
					),
					AttrClassUsage(
						"panic_attack_negative", "Float", listOf(
							"Multiplier applied to bullet spread as health gets lower."
						)
					),
					AttrClassUsage(
						"mult_spread_scales_consecutive", "Float", listOf(
							"Scales weapon spread when firing consecutive shots, like the _New_ Panic Attack."
						)
					),
					AttrClassUsage(
						"mult_dmg_disguised", "Float", listOf(
							"When disguised (only checks if the player has the condition, doesn't check class), multiply damage by this amount."
						)
					),
					AttrClassUsage(
						"accuracy_scales_damage", "Float", listOf(
							"If the projectile being fired is a bullet, multiply damage by your hit ratio over the past few seconds."
						)
					),
					AttrClassUsage(
						"fixed_shot_pattern", "Boolean", listOf(
							"Enables fixed weapon spread on the weapon as though `tf_use_fixed_weaponspreads` were set."
						)
					),
					AttrClassUsage("mod_pierce_resists_absorbs", "Boolean", listOf())
				), listOf("The Wrangler, Festive Wrangler, The Giger Counter".split(", "))
			),
			
			HierarchyAttrClassScope(
				"BaseMelee", listOf(
					AttrClassUsage(
						"self_mark_for_death", "Boolean", listOf(
							"Marked for death when switching to weapon"
						)
					),
					AttrClassUsage(
						"is_a_sword", "Boolean", listOf(
							"If true, set swing range to 72, else 48"
						)
					),
					AttrClassUsage(
						"melee_bounds_multiplier", "Float", listOf(
							"Multiplier applied to the bounding box of the swing to detect if a player is inside it",
							"Yes, it DOES use a bounding box."
						)
					),
					AttrClassUsage(
						"set_dmg_apply_to_sapper", "Int", listOf(
							"Damage sappers with swing."
						)
					),
					AttrClassUsage(
						"speed_buff_ally", "Boolean", listOf(
							"Applies speed boost cond to yourself and the teammate you hit"
						)
					),
					AttrClassUsage(
						"add_give_health_to_teammate_on_hit", "Int", listOf(
							"Transfer some amount of health from yourself to your teammate on hitting them."
						)
					),
					AttrClassUsage(
						"melee_cleave_attack", "Int", listOf(
							"If greater than 0, hit all targets in swing instead of just the first valid one."
						)
					),
					AttrClassUsage(
						"hit_self_on_miss", "Boolean", listOf(
							"Idiot."
						)
					),
					AttrClassUsage(
						"speed_boost_on_hit_enemy", "Float", listOf(
							"Used as arg to addcond speedboost"
						)
					),
					AttrClassUsage("crit_from_behind", "Boolean", listOf()),
					AttrClassUsage("crit_forces_victim_to_laugh", "Boolean", listOf()),
					AttrClassUsage(
						"tickle_enemies_wielding_same_weapon", "Boolean", listOf(
							"Force enemies to laugh if they're also wielding this weapon."
						)
					),
					AttrClassUsage(
						"crit_does_no_damage", "Boolean", listOf(
						)
					),
					AttrClassUsage(
						"mult_dmg_bonus_while_half_dead", "Float", listOf(
							"If health < 50%, apply mult."
						)
					),
					AttrClassUsage(
						"mult_dmg_penalty_while_half_alive", "Float", listOf(
							"If health >= 50%, apply mult"
						)
					),
					AttrClassUsage(
						"mult_dmg_with_reduced_health", "Float", listOf(
							"Apply multiplier scaled by player's current health proportion",
							"You'll see later that there's a \"Shovel 'Equalizer' mode\", but the real logic for that is here."
						)
					)
				)
			),
			
			HierarchyAttrClassScope(
				"Flamethrower", listOf(
					AttrClassUsage(
						"set_weapon_mode", "Int", listOf(
							"Determines flame particle effect",
							"1 = phlog",
							"2 = MvM giant pyrobot",
							"3 = rainblower (Also makes a bubble wand while taunting)"
						)
					),
					AttrClassUsage(
						"set_buff_type", "Int", listOf(
							"If greater than 0, enables Phlog crits on having full rage"
						)
					),
					AttrClassUsage("airblast_disabled", "Boolean", listOf()),
					AttrClassUsage(
						"set_charged_airblast", "Boolean", listOf(
							"Enables charging an airblast for longer for higher push",
						)
					),
					AttrClassUsage("mult_airblast_cost", "Float", listOf()),
					AttrClassUsage("set_flamethrower_back_crit", "Boolean", listOf()),
					AttrClassUsage("mult_flame_ammopersec", "Float", listOf()),
					AttrClassUsage(
						"airblast_functionality_flags", "Int", listOf(
							"If 0, can do all kinds of airblast as long as airblasting itself isn't disabled.",
							"If not 0, can only do whatever functionalities of airblasting are specified by the number. (add any values below to combine them)",
							"1 = PUSHBACK",
							"2 = PUT_OUT_TEAMMATES",
							"4 = REFLECT_PROJECTILES",
							"8 = PUSHBACK_STUN (requires PUSHBACK)",
							"16 = PUSHBACK_VIEW_PUNCH (requires PUSHBACK)"
						)
					),
					AttrClassUsage(
						"airblast_dashes", "Boolean", listOf(
							"If true, fly into the direction you're looking when you airblast.  Will not reflect projectiles."
						)
					),
					AttrClassUsage(
						"mult_airblast_refire_time", "Float", listOf(
							"How long after airblasting until you can fire a primary OR secondary attack"
						)
					),
					AttrClassUsage(
						"mult_airblast_primary_refire_time", "Float", listOf(
							"How long before you can use your flamethrower again after airblasting.",
						)
					),
					AttrClassUsage(
						"mod_flamethrower_spinup_time", "Float", listOf(
							"Yes, like a minigun."
						)
					),
					AttrClassUsage(
						"firing_forward_pull", "Float", listOf(
							"Actually a Boolean, so a `0.0` or `1.0` value.",
							"If true, you get a speedboost while firing your flamethrower.",
						)
					),
					AttrClassUsage(
						"deflection_size_multiplier", "Float", listOf(
							"Scales the reflect hitbox for your airblast"
						)
					),
					AttrClassUsage(
						"extinguish_restores_health", "Int", listOf(
							"How much health your extinguish restores"
						)
					),
					AttrClassUsage(
						"reverse_airblast", "Boolean", listOf(
							"If the airblast isn't disallowed from pushing players back, and this is set, airblasting will pull players instead."
						)
					),
					AttrClassUsage(
						"mult_airblast_cone_scale", "Float", listOf(
							"Cone used for pushing players"
						)
					),
					AttrClassUsage("airblast_pushback_scale", "Float", listOf()),
					AttrClassUsage("airblast_vertical_pushback_scale", "Float", listOf()),
					AttrClassUsage("halloween_green_flames", "Boolean", listOf()),
					AttrClassUsage(
						"mult_flame_size", "Float", listOf(
							"Checked on owner"
						)
					),
					AttrClassUsage(
						"mult_flame_life", "Float", listOf(
							"Checked on owner"
						)
					),
					AttrClassUsage("airblast_destroy_projectile", "Boolean", listOf()),
					AttrClassUsage("airblast_pushback_disabled", "Boolean", listOf()),
					AttrClassScope(
						"Flame", ("- `flame_spread_degree`: FLOAT\n" +
						          "- `redirected_flame_size_mult`: FLOAT\n" +
						          "- `mult_flame_size`: FLOAT\n" +
						          "- `mult_end_flame_size`: FLOAT\n" +
						          "- `flame_ignore_player_velocity`: FLOAT\n" +
						          "- `flame_reflection_add_life_time`: FLOAT\n" +
						          "- `reflected_flame_dmg_reduction`: FLOAT\n" +
						          "- `max_flame_reflection_count`: INT\n" +
						          "- `flame_reflect_on_collision`: Boolean\n" +
						          "- `flame_speed`: FLOAT\n" +
						          "- `flame_lifetime`: FLOAT\n" +
						          "- `flame_random_life_time_offset`: FLOAT\n" +
						          "- `flame_gravity`: FLOAT\n" +
						          "- `flame_drag`: FLOAT\n" +
						          "- `flame_up_speed`: FLOAT").split("\n")
							.map {
								it.replace("FLOAT", "Float")
									.replace("INT", "Int")
							}
							.map(AttrClassUsage::invoke)
					),
				), listOf("TF_WEAPON_FLAMETHROWER, The Backburner, Upgradeable TF_WEAPON_FLAMETHROWER, The Degreaser, The Phlogistinator, Festive Flamethrower 2011, The Rainblower, Silver Botkiller Flame Thrower Mk.I, Gold Botkiller Flame Thrower Mk.I, Rust Botkiller Flame Thrower Mk.I, Blood Botkiller Flame Thrower Mk.I, Carbonado Botkiller Flame Thrower Mk.I, Diamond Botkiller Flame Thrower Mk.I, Silver Botkiller Flame Thrower Mk.II, Gold Botkiller Flame Thrower Mk.II, Festive Backburner 2014, The Nostromo Napalmer".split(", "))
			),
			
			HierarchyAttrClassScope(
				"SMG", listOf(
					AttrClassUsage(
						"set_weapon_mode", "Int", listOf(
							"If 1, can headshot"
						)
					)
				), listOf("Stock SMG + Reskins".split(", "))
			),
			
			HierarchyAttrClassScope(
				"ChargedSMG", listOf(
					AttrClassUsage(
						"minicrit_boost_when_charged", "Float", listOf(
							"Minicrit buff duration"
						)
					)
				), listOf("The Cleaner's Carbine".split(", "))
			),
			
			HierarchyAttrClassScope(
				"Sapper", listOf(
					AttrClassUsage(
						"sapper_degenerates_buildings", "Float", listOf(
							"On player",
							"How fast the building should reverse construction"
						)
					),
					AttrClassUsage(
						"robo_sapper", "Int", listOf(
							"When the sapper is applied to a player (including MvM bots):",
							"2 - stun time is 5.5 seconds, radius is 225 hammer units",
							"3 - stuns for 7 seconds, radius is 250 hammer units",
							"else stuns for 4 seconds and radius is 200 HU"
						)
					),
					AttrClassUsage(
						"sapper_deploy_time", "Float", listOf(
							"If greater than 0, the sapper takes time to place (UNIMPLEMENTED)"
						)
					)
				), listOf("Stock Sapper, The Red-Tape Recorder, Promo Red-Tape Recorder, The Ap-Sap, Festive Sapper, The Snack Attack".split(", "))
			),
			
			HierarchyAttrClassScope(
				"Fists", listOf(
					AttrClassUsage(
						"set_weapon_mode", "Int", listOf()
					),
					AttrClassUsage(
						"breadgloves_properties", "Boolean", listOf(
							"UNIMPLEMENTED",
							"Note that despite being present in the item schema, this is explicitly COMMENTED OUT of the code, and has no gameplay effects at least."
						)
					)
				), listOf("Stock Fists, The Killing Gloves of Boxing, Warrior's Spirit, Fists of Steel, The Eviction Notice, Apoco-Fists, The Holiday Punch, The Bread Bite, Gloves of Running Urgently MvM".split(", "))
			),
			
			HierarchyAttrClassScope(
				"Shovel", listOf(
					AttrClassUsage(
						"set_weapon_mode", "Int", listOf(
							"Solely determines the \"damage type\" of the weapon, with any custom values setting it to \"pickaxe\" and the default being determined by the weapon itself."
						)
					),
					AttrClassUsage(
						"air_jump_on_attack", "Boolean", listOf(
							"On primary attack, send player flying in the direction they're facing."
						)
					),
				), listOf("TF_WEAPON_SHOVEL, The Equalizer, The Pain Train, Upgradeable TF_WEAPON_SHOVEL, The Market Gardener, The Disciplinary Action, The Escape Plan".split(", "))
			),
			HierarchyAttrClassScope("Bottle", emptyList<IAttrThing>(), listOf("TF_WEAPON_BOTTLE, Upgradeable TF_WEAPON_BOTTLE, The Scottish Handshake".comma())),
			
			HierarchyAttrClassScope(
				"StickBomb", listOf(
					AttrClassUsage("halloween_pumpkin_explosions", "Boolean", listOf())
				), listOf(listOf("The Ullapool Caber"))
			),
			
			HierarchyAttrClassScope(
				"FireAxe", listOf(
					AttrClassUsage(
						"set_dmgtype_ignite", "Boolean", listOf(
							"Ignite enemies on hit.",
						)
					)
				), listOf("TF_WEAPON_FIREAXE, The Axtinguisher, The Homewrecker, Upgradeable TF_WEAPON_FIREAXE, The Powerjack, The Back Scratcher, Sharpened Volcano Fragment, The Postal Pummeler, The Maul, The Third Degree, The Lollichop, Festive Axtinguisher".comma())
			),
			
			HierarchyAttrClassScope(
				"Bonesaw", listOf(
					AttrClassUsage(
						"set_weapon_mode", "Int", listOf(
							"Used to specify \"bonesaw type\". Unused in the SDK."
						)
					),
					AttrClassUsage(
						"special_taunt", "Boolean", listOf(
							"If true, the player will taunt on right click."
						)
					),
					AttrClassUsage(
						"add_head_on_hit", "Boolean", listOf(
							"If the player should take a \"head\" when dealing damage with a melee.",
						)
					),
					AttrClassUsage("ubercharge_preserved_on_spawn_max", "Float", listOf()),
					AttrClassUsage(
						"add_head_on_kill", "Boolean", listOf(
							"On kill, take an organ (uses \"heads\" field like usual)."
						)
					)
				), listOf("TF_WEAPON_BONESAW, The Ubersaw, The Vita-Saw, Upgradeable TF_WEAPON_BONESAW, The Amputator, The Solemn Vow, Festive Ubersaw, Festive Bonesaw 2014".comma())
			),
			
			HierarchyAttrClassScope(
				"Minigun", listOf(
					AttrClassUsage("minigun_no_spin_sounds", "Boolean", listOf()),
					AttrClassUsage("mod_minigun_can_holster_while_spinning", "Boolean", listOf()),
					AttrClassUsage("mult_minigun_spinup_time", "Float", listOf()),
					AttrClassUsage(
						"attack_projectiles", "Boolean", listOf()
					),
					AttrClassUsage("ring_of_fire_while_aiming", "Int", listOf()),
					AttrClassUsage(
						"uses_ammo_while_aiming", "Int", listOf(
							"Amount of ammo drained per second"
						)
					)
				), listOf("All Stock Minigun skins, Natascha, The Brass Beast, Tomislav".comma())
			),
			
			HierarchyAttrClassScope("Pistol", listOf<IAttrThing>(), listOf("TF_WEAPON_PISTOL, TF_WEAPON_PISTOL_SCOUT, TTG Max Pistol, Upgradeable TF_WEAPON_PISTOL, The C.A.P.P.E.R".comma())),
			
			HierarchyAttrClassScope(
				"ScoutPistol", listOf(
					AttrClassUsage(
						"back_headshot", "Boolean", listOf(
							"If true, can headshot"
						)
					)
				), listOf("The Shortstop, The Winger, Pretty Boy's Pocket Pistol".comma())
			),
			
			HierarchyAttrClassScope(
				"Revolver", listOf(
					AttrClassUsage(
						"extra_damage_on_hit", "Boolean", listOf(
							"If true, increases damage by 1% per \"head\" collected (note: this is not the diamondback's \"revenge crit\" mechanic)"
						)
					),
					AttrClassUsage(
						"extra_damage_on_hit_penalty", "Int", listOf(
							"Lowers your head count by this amount every time you fire a shot"
						)
					)
				), listOf("TF_WEAPON_REVOLVER, The Ambassador, TTG Sam Revolver, Upgradeable TF_WEAPON_REVOLVER, L'Etranger, The Enforcer, The Diamondback, Festive Ambassador, Festive Revolver 2014".comma())
			),
			
			HierarchyAttrClassScope(
				"SyringeGun", listOf(
					AttrClassUsage(
						"set_weapon_mode", "Int", listOf(
							"Used to specify \"syringe type\". Unused in the SDK."
						)
					)
				), listOf("Stock Syringe Gun, The Blutsauger, The Overdose".comma())
			),
			
			HierarchyAttrClassScope(
				"RocketPack", listOf(
					AttrClassUsage(
						"thermal_thruster_air_launch", "Boolean", listOf(
							"The MvM upgrade that lets you launch while launching"
						)
					)
				), listOf(listOf("The Thermal Thruster"))
			),
			
			HierarchyAttrClassScope(
				"Invis", listOf(
					AttrClassUsage(
						"set_weapon_mode", "Int", listOf()
					),
					AttrClassUsage(
						"mult_decloak_rate", "Float", listOf(
							"How many seconds it takes to decloak (or a multiplier)",
							"Note that values less than or equal to `0.0` become `1.0`"
						)
					),
					AttrClassUsage(
						"mult_cloak_meter_consume_rate", "Float", listOf(
							"On player",
							"Multiply cloak consumption rate by this value."
						)
					),
					AttrClassUsage("- `mod_cloak_no_regen_from_items`: Boolean\n" +
					               "\t- Disallows ammo boxes from affecting the cloak meter."),
					AttrClassUsage("- `NoCloakWhenCloaked`: Boolean\n" +
					               "\t- If true, cannot receive cloak while cloaked."),
					AttrClassUsage("- `ReducedCloakFromAmmo`: Float\n" +
					               "\t- Multiplier applied to cloak gained from ammo boxes."),
					AttrClassUsage("mult_cloak_meter_regen_rate", "Float", listOf())
				), listOf("TF_WEAPON_INVIS, The Dead Ringer, The Cloak and Dagger, Upgradeable TF_WEAPON_INVIS, The Quackenbirdt".comma())
			),
			
			HierarchyAttrClassScope(
				"StickybombLauncher", listOf(
					AttrClassUsage(
						"stickybomb_charge_rate", "Float", listOf(
							"Not actually the \"rate\", rather the time it takes to fully charge a stickybomb launch when holding MOUSE1."
						)
					),
					AttrClassUsage(
						"set_detonate_mode", "Int", listOf(
							"0 = default \"detonate all stickies on rclick\" mode.\n" +
							"1 = Scottish Resistance's \"look at sticky to detonate\" mechanic.\n" +
							"2 = Stickybombs fizzle after 2 seconds."
						)
					),
					AttrClassUsage(
						"stickies_detonate_stickies", "Boolean", listOf(
							"If true, stickies destroy other stickies."
						)
					),
					AttrClassUsage(
						"stickybomb_charge_damage_increase", "Float", listOf(
							"damage = `2*basedamage * (this - 1.0) * currentChargeProportion`"
						)
					),
					AttrClassUsage("add_max_pipebombs", "Int", listOf())
				), listOf("TF_WEAPON_StickybombLauncher, The Scottish Resistance, Upgradeable TF_WEAPON_StickybombLauncher, Stickybomb Jumper, Festive Stickybomb Launcher 2011, Silver Botkiller Stickybomb Launcher Mk.I, Gold Botkiller Stickybomb Launcher Mk.I, Rust Botkiller Stickybomb Launcher Mk.I, Blood Botkiller Stickybomb Launcher Mk.I, Carbonado Botkiller Stickybomb Launcher Mk.I, Diamond Botkiller Stickybomb Launcher Mk.I, Silver Botkiller Stickybomb Launcher Mk.II, Gold Botkiller Stickybomb Launcher Mk.II, The Quickiebomb Launcher".comma())
			),
			
			HierarchyAttrClassScope(
				"BuffItem", listOf(
					AttrClassUsage(
						"set_buff_type", "Int", listOf(
							"Sets which banner is used",
							"0 = Buff Banner",
							"1 = Battalion's Backup",
							"2 = Concheror",
							"3 = Parachute",
							"Note that the Base Jumper specifically checks the buff type of the user, and if it is not 'parachute', cancels its animation."
						)
					),
					AttrClassUsage(
						"mod_buff_duration", "Float", listOf(
							"Multiplier to buff duration.",
							"Actually just read by the \"BuffBanner _Flag_\" (the prop) for when it should detach from the player, and it's actually the _flag_ that does the buffing."
						)
					)
				), listOf("The Buff Banner, The Battalion's Backup, The Concheror, Festive Buff Banner".comma())
			),
			
			HierarchyAttrClassScope(
				"Wrench", listOf(
					AttrClassUsage(
						"alt_fire_teleport_to_spawn", "Boolean", listOf(
							"If set, pressing reload shows the Eureka Effect menu"
						)
					),
					AttrClassUsage(
						"wrench_builds_minisentry", "Boolean", listOf(
							"Detonates leveled sentries when equipping a wrench with this attribute",
							"If not in MvM (player is not on team \"PVE_DEFENDERS\"), detonate minis when unequipping a wrench with this attribute",
							"Removes engineer's glove on his model",
							"Also determines if it's a \"PDQ\", which obviously builds minisentries"
						)
					),
					AttrClassUsage(
						"mult_construction_value", "Float", listOf(
							"Passive build rate multiplier, same as the convar `tf_construction_build_rate_multiplier`"
						)
					),
					AttrClassUsage(
						"mult_reScope_value", "Float", listOf(
							"Multiplier, determines how much health is given per wrench hit"
						)
					)
				), listOf("Stock Wrench + Reskins, Golden Wrench, The Southern Hospitality, The Jag, The Eureka Effect".comma(), listOf("The Gunslinger"))
			),
			HierarchyAttrClassScope(
				"RocketLauncher", listOf(
					AttrClassUsage(
						"override_projectile_type", "Int", listOf()
					),
					AttrClassUsage(
						"mod_rocket_launch_impulse", "Boolean", listOf(
							"Allows the player to rocket jump with the projectile. (note that \"rocket launcher\" is the base for most projectile launchers, including the Crossbow :3)"
						)
					)
				), listOf("TF_WEAPON_ROCKETLAUNCHER, Upgradeable TF_WEAPON_ROCKETLAUNCHER, The Black Box, Rocket Jumper, The Liberty Launcher, The Original, Festive Rocket Launcher 2011, The Beggar's Bazooka, Silver Botkiller Rocket Launcher Mk.I, Gold Botkiller Rocket Launcher Mk.I, Rust Botkiller Rocket Launcher Mk.I, Blood Botkiller Rocket Launcher Mk.I, Carbonado Botkiller Rocket Launcher Mk.I, Diamond Botkiller Rocket Launcher Mk.I, Silver Botkiller Rocket Launcher Mk.II, Gold Botkiller Rocket Launcher Mk.II, Festive Black Box".comma())
			),
			
			HierarchyAttrClassScope(
				"RocketLauncher_AirStrike", listOf(
					AttrClassUsage(
						"clipsize_increase_on_kill", "Int", listOf(
							"This attribute is on all weapons, but it's specifically checked for here as well."
						)
					)
				), listOf(listOf("The Air Strike"))
			),
			
			HierarchyAttrClassScope(
				"GrenadeLauncher", listOf(
					AttrClassUsage(
						"grenade_detonation_damage_penalty", "Float", listOf(
							"Flat multiplier applied to initial damage"
						)
					),
					AttrClassUsage("mult_projectile_speed", "Float", listOf()),
					AttrClassUsage(
						"set_detonate_mode", "Int", listOf(
							"If 2, pills shatter on contact with surfaces. Else does nothing."
						)
					),
					AttrClassUsage(
						"grenade_launcher_mortar_mode", "Float", listOf(
							"\"Mortar\" (loose cannon) detonation time length"
						)
					)
				), listOf("TF_WEAPON_GRENADELAUNCHER, Upgradeable TF_WEAPON_GRENADELAUNCHER, The Loch-n-Load, Festive Grenade Launcher, The Iron Bomber".comma(), listOf("The Loose Cannon"))
			),
			
			HierarchyAttrClassScope(
				"Crossbow", listOf(
					AttrClassUsage("mult_reload_time", "Float", listOf()),
					AttrClassUsage("mult_reload_time_hidden", "Float", listOf()),
					AttrClassUsage(
						"fast_reload", "Float", listOf(
						)
					),
					AttrClassUsage(
						"fires_milk_bolt", "Boolean", listOf(
							"If true, alt-fire fires a mad-milked crossbow bolt. (meter is unimplemented, but milk bolt is)"
						)
					)
				), listOf("The Crusader's Crossbow, Festive Crusader's Crossbow".comma())
			),
			
			HierarchyAttrClassScope(
				"RayGun", listOf(
					AttrClassUsage(
						"energy_weapon_no_drain", "Boolean", listOf(
							"Removes ammo requirement to fire weapon."
						)
					)
				), listOf(listOf("The Righteous Bison"), listOf("The Pomson 6000"))
			),
			
			HierarchyAttrClassScope(
				"Raygun_Revenge", listOf(
					AttrClassUsage(
						"energy_weapon_no_drain", "Boolean", listOf(
							"Removes ammo requirement to fire weapon."
						)
					)
				), listOf(listOf("NONE (but it's there at least?)"))
			),
			
			HierarchyAttrClassScope(
				"Lunchbox", listOf(
					AttrClassUsage(
						"set_weapon_mode", "Int", listOf(
							"0 = LUNCHBOX_STANDARD",
							"1 = LUNCHBOX_ADDS_MAXHEALTH",
							"2 = LUNCHBOX_ADDS_MINICRITS",
							"3 = LUNCHBOX_STANDARD_ROBO",
							"4 = LUNCHBOX_STANDARD_FESTIVE",
							"5 = LUNCHBOX_ADDS_AMMO (fully implemented)",
							"6 = LUNCHBOX_BANANA",
							"7 = LUNCHBOX_FISHCAKE",
						)
					),
					AttrClassUsage("lunchbox_healing_scale", "Float", listOf())
				), listOf("The Sandvich, The Dalokohs Bar, The Buffalo Steak Sandvich, Fishcake, The Robo-Sandvich, Festive Sandvich, The Second Banana".comma(), "Bonk! Atomic Punch, Crit-a-Cola, Festive Bonk 2014".comma())
			),
			
			HierarchyAttrClassScope("Shotgun", emptyList<IAttrThing>(), listOf("Stock Shotgun, Reserve Shooter".comma(), "The Frontier Justice, Festive Frontier Justice".comma(), listOf("The Widowmaker"), listOf("The Rescue Ranger"))),
			
			HierarchyAttrClassScope(
				"Scattergun", listOf(
					AttrClassUsage(
						"set_scattergun_has_knockback", "Boolean", listOf(
							"Note: if `scattergun_knockback_mult` is greater than 1.0, this is not necessary."
						)
					),
					AttrClassUsage("scattergun_knockback_mult", "Float", listOf()),
					AttrClassUsage(
						"set_scattergun_no_reload_single", "Boolean", listOf(
							"If true, reloads entire clip at once."
						)
					)
				), listOf("TF_WEAPON_SCATTERGUN, The Force-a-Nature, Upgradeable TF_WEAPON_SCATTERGUN, Festive Scattergun 2011, Silver Botkiller Scattergun Mk.I, Gold Botkiller Scattergun Mk.I, Rust Botkiller Scattergun Mk.I, Blood Botkiller Scattergun Mk.I, Carbonado Botkiller Scattergun Mk.I, Diamond Botkiller Scattergun Mk.I, Silver Botkiller Scattergun Mk.II, Gold Botkiller Scattergun Mk.II, Festive Force-a-Nature, The Back Scatter".comma())
			),
			
			HierarchyAttrClassScope(
				"ShotgunRevenge", listOf(
					AttrClassUsage(
						"sentry_killed_revenge", "Boolean", listOf(
							"Specifically checked here when it tries to gain revenge crits, which means removing this attribute from the Frontier Justice will remove its ability to gain revenge crits."
						)
					)
				), listOf("Frontier Justice")
			),
			
			HierarchyAttrClassScope(
				"Knife", listOf(
					AttrClassUsage(
						"set_weapon_mode", "Int", listOf(
							"0: Stock",
							"1: Your Eternal Reward",
							"2: Cloak and Dagger (UNCHECKED)",
							"3: Spycicle",
							"The 'Your Eternal Reward' setting is used by sentries to not target spies after a stab, and the 'Spycicle' setting is used to display the recharge meter."
						)
					),
					AttrClassUsage("melts_in_fire", "Boolean", listOf()),
					AttrClassUsage("set_disguise_on_backstab", "Boolean", listOf()),
					AttrClassUsage(
						"mult_dmg", "Float", listOf(
							"Base backstab damage against minibosses is `250 * <this proportion>`."
						)
					),
					AttrClassUsage(
						"armor_piercing", "Float", listOf(
							"On player",
							"Spy only does 25% damage against minibosses by default.  The number here is added to that percentage, up to a max of 100% + 25% = 125%",
							"Note that this is an actual PERCENTAGE of armor penetrated, not a proportion:  `25.0`, `50.0`, up to `100.0`.",
							"Also, with max armor penetration, you apparently do 25% *more* damage against minibosses than you do against regular bots."
						)
					),
					AttrClassUsage(
						"sanguisuge", "Boolean", listOf(
							"Gain health on backstab. (Kunai)"
						)
					)
				), listOf("TF_WEAPON_KNIFE, Upgradeable TF_WEAPON_KNIFE, Your Eternal Reward, Conniver's Kunai, The Big Earner, The Wanga Prick, The Sharp Dresser, The Spy-cicle, Festive Knife 2011, The Black Rose, Stock Botkiller Knives")
			),
			
			HierarchyAttrClassScope(
				"Sword", listOf(
					AttrClassUsage(
						"decapitate_type", "Int", listOf(
							"More like a boolean, doesn't actually determine any kind of decapitation, just if it CAN decapitate."
						)
					)
				), listOf("The Eyelander, The Scotsman's Skullcutter, The Horseless Headless Horseman's Headtaker, The Claidheamohmor (sic), The Persian Persuader, Nessie's Nine Iron, Festive Eyelander", "The Half-Zatoichi")
			),
			
			HierarchyAttrClassScope("Wearable", listOf<IAttrThing>(
				AttrClassUsage("- `duck_badge_level`: Int\n" +
				               "\t- Determines if ***BONUS DUCKSSSS*** should increment the badge level."),
				AttrClassUsage("- `player_skin_override`: Int\n" +
				               "\t- Overrides the skin used when disguising as this player")
			)),
			
			HierarchyAttrClassScope(
				"WearableDemoShield", listOf(
					AttrClassUsage("attack_not_cancel_charge", "Boolean", listOf()),
					AttrClassUsage(
						"mod_charge_time", "Float", listOf(
							"On player",
							"Charge time mult"
						)
					),
					AttrClassUsage(
						"charge_impact_damage", "Float", listOf(
							"On player",
							"Impact damage mult"
						)
					),
					AttrClassUsage("- `afterburn_immunity`: Boolean")
				), listOf("The Chargin' Targe, The Splendid Screen, The Tide Turner, Festive Targe 2014")
			),
			HierarchyAttrClassScope(
				"FlareGun", listOf(
					AttrClassUsage(
						"set_weapon_mode", "Int", listOf(
							"0: Normal",
							"1: Detonator",
							"2: Manmelter",
							"3: Scorch Shot"
						)
					)
				), listOf("The Flare Gun, The Scorch Shot, The Detonator", "The Manmelter")
			),
			
			HierarchyAttrClassScope(
				"Jar", listOf(
					AttrClassUsage(
						"override_projectile_type", "Int", listOf(
							"Used to select the model",
							"Select between `TF_PROJECTILE_FESTIVE_JAR`, `TF_PROJECTILE_BREADMONSTER_JARATE`, and `TF_PROJECTILE_BREADMONSTER_MADMILK`",
							"Otherwise uses default for its class"
						)
					),
					AttrClassUsage(
						"applies_snare_effect", "Float", listOf(
							"On player",
							"If NOT `1.0`, stun the victim"
						)
					),
					AttrClassUsage(
						"extinguish_reduces_cooldown", "Float", listOf(
							"Subtracts this value from the cooldown"
						)
					)
				), listOf(
					"Jarate, Festive Jarate, The Self-Aware Beauty Mark",
					"Mad Milk, Mutated Milk",
					"The Flying Guillotine",
					"The Gas Passer",
					"Unimplemented Spy Decoy Weapon",
				)
			),
			
			HierarchyAttrClassScope(
				"MechanicalArm", listOf(
					AttrClassUsage("mod_ammo_per_shot", "Int", listOf())
				), listOf("The Short Circuit")
			),
			
			HierarchyAttrClassScope(
				"Throwable", listOf(
					AttrClassUsage("throwable_recharge_time", "Float", listOf()),
					AttrClassUsage("throwable_detonation_time", "Float", listOf()),
					AttrClassUsage(
						"is_throwable_primable", "Boolean", listOf(
							"For timed explosions"
						)
					),
					AttrClassUsage(
						"is_throwable_chargeable", "Boolean", listOf(
							"For things like distance/power increases"
						)
					)
				), listOf("Spellbook")
			),
			
			HierarchyAttrClassScope(
				"SniperRifle", listOf(
					AttrClassUsage(
						"set_weapon_mode", "Int", listOf(
							"0: Normal",
							"1: Sydney Sleeper",
							"2: Machina",
							"3: Classic"
						)
					),
					AttrClassUsage(
						"set_buff_type", "Int", listOf(
							"If greater than 0, activates rage buff when pressing reload and rage meter is full (or above full)."
						)
					),
					AttrClassUsage(
						"sniper_full_charge_damage_bonus", "Float", listOf(
							"If greater than 1.0, weapon plays cool fully-charged-Machina railgun sound when firing at full charge."
						)
					),
					AttrClassUsage(
						"fast_reload", "Float", listOf(
							"Mult to zoom and unzoom delay on clipless weapons",
							"Fun fact: this is also affected by the Precision mannpower powerup"
						)
					),
					AttrClassUsage(
						"ability_master_sniper", "Int", listOf(
							"Mult to zoom/unzoom delay on clipless weapons",
							"mult by level: 1=0.6, 2=0.3",
							"Mult to charge speed",
							"1=1.5, 2=3.0"
						)
					),
					AttrClassUsage("mult_sniper_charge_per_sec", "Float", listOf()),
					AttrClassUsage("mult_sniper_charge_per_sec_with_enemy_under_crosshair", "Float", listOf()),
					AttrClassUsage(
						"sniper_beep_with_enemy_under_crosshair", "Float", listOf(
							"Cast to an int, treated like a boolean",
							"plays `doomsday.warhead` sound when an enemy appears under your crosshair"
						)
					),
					AttrClassUsage("sniper_only_fire_zoomed", "Boolean", listOf()),
					AttrClassUsage("sniper_penetrate_players_when_charged", "Boolean", listOf()),
					AttrClassUsage("sniper_no_headshot_without_full_charge", "Boolean", listOf()),
					AttrClassUsage(
						"sniper_crit_no_scope", "Boolean", listOf(
							"Funnily enough, it checks if your FOV is lower than your default FOV to see if you're zoomed."
						)
					),
					AttrClassUsage(
						"explosive_sniper_shot", "Int", listOf(
							"On attacker",
							"Level of explosive headshot"
						)
					),
					AttrClassUsage(
						"jarate_duration", "Float", listOf(
							"If greater than 0:",
							"Makes weapon not eject brass",
							"Makes weapon only penetrate non-burning teammates, as opposed to penetrating all teammates",
							"Note: Not actually used in Sydney Sleeper Jarate calculation, as far as I could tell."
						)
					),
					AttrClassUsage("- `applies_snare_effect`: Float\n" +
					               "\t- Multiplier applied to target move-speed on hit\n" +
					               "\t- Duration is equal to the rifle's `jarate_duration` attribute"),
					AttrClassUsage("- `aiming_no_flinch`: Boolean\n" +
					               "\t- Prevents flinching from damage when scoped and fully charged.")
				), listOf("TF_WEAPON_SNIPERRIFLE, Upgradeable TF_WEAPON_SNIPERRIFLE, The Sydney Sleeper, The Machina, Festive Sniper Rifle 2011, The Hitman's Heatmaker, Silver Botkiller Sniper Rifle Mk.I, Gold Botkiller Sniper Rifle Mk.I, The AWPer Hand, Rust Botkiller Sniper Rifle Mk.I, Blood Botkiller Sniper Rifle Mk.I, Carbonado Botkiller Sniper Rifle Mk.I, Diamond Botkiller Sniper Rifle Mk.I, Silver Botkiller Sniper Rifle Mk.II, Gold Botkiller Sniper Rifle Mk.II, Shooting Star", "The Bazaar Bargain", "The Classic")
			),
			
			HierarchyAttrClassScope(
				"Medigun", listOf(
					AttrClassUsage("mult_medigun_healrate", "Float", listOf()),
					AttrClassUsage(
						"preserve_ubercharge", "Int", listOf(
							"On player",
							"Percentage saved on death or dropping weapon (e.g. `25` = 25% uber)"
						)
					),
					AttrClassUsage("healing_mastery", "Int", listOf()),
					AttrClassUsage(
						"set_weapon_mode", "Int", listOf(
							"Determines medigun type"
						)
					),
					AttrClassUsage(
						"set_charge_type", "Int", listOf(
							"Ubercharge type. Each resist uber also has its own entry"
						)
					),
					AttrClassUsage(
						"medic_machinery_beam", "Boolean", listOf(
							"Allows medigun to target buildings"
						)
					),
					AttrClassUsage(
						"mult_medigun_overheal_amount", "Float", listOf(
							"Bonuses are additive, penalties are percentage"
						)
					),
					AttrClassUsage("mult_medigun_overheal_decay", "Float", listOf()),
					AttrClassUsage(
						"overheal_expert", "Float", listOf(
							"On owner",
							"Overheal bonus = overheal bonus + overhealexpert/4 or just overheal bonus, whichever is higher",
							"decay mult is same but divided by 2"
						)
					),
					AttrClassUsage(
						"permanent_medic_shield", "Boolean", listOf(
							"UNIMPLEMENTED",
							"Only allowed in MvM"
						)
					),
					AttrClassUsage(
						"mult_medigun_overheal_uberchargerate", "Float", listOf(
							"On owner"
						)
					),
					AttrClassUsage(
						"mult_medigun_uberchargerate", "Float", listOf(
							"On owner"
						)
					),
					AttrClassUsage(
						"add_uber_time", "Int", listOf(
							"On owner"
						)
					),
					AttrClassUsage(
						"generate_rage_on_heal", "Int", listOf(
							"On owner",
							"This is your shield level"
						)
					)
				), listOf("TF_WEAPON_MEDIGUN, The Kritzkrieg, Upgradeable TF_WEAPON_MEDIGUN, The Quick-Fix, Festive Medigun 2011, Silver Botkiller Medi Gun Mk.I, Gold Botkiller Medi Gun Mk.I, Rust Botkiller Medi Gun Mk.I, Blood Botkiller Medi Gun Mk.I, Carbonado Botkiller Medi Gun Mk.I, Diamond Botkiller Medi Gun Mk.I, Silver Botkiller Medi Gun Mk.II, Gold Botkiller Medi Gun Mk.II, The Vaccinator")
			),
			
			HierarchyAttrClassScope(
				"Builder", listOf(
					AttrClassUsage(
						"mark_for_death_on_building_pickup", "Boolean", listOf(
							"On owner"
						)
					),
					AttrClassUsage(
						"sapper_voice_pak", "Float", listOf(
							"If true.0, it's a wheatley sapper"
						)
					),
					AttrClassUsage(
						"robo_sapper", "Int", listOf(
							"If building an OBJ_ATTACHMENT_SAPPER on a mode that allows upgrades and it's built on a player (or MvM bot):",
							"Gives the sapper a radius instead of being single-target"
						)
					)
				), listOf("Engineer PDA, Sapper")
			),
			
			HierarchyAttrClassScope(
				"CompoundBow", listOf(
					AttrClassUsage(
						"fast_reload", "Float", listOf(
							"Mult applied to reload speed"
						)
					),
					AttrClassUsage(
						"ability_master_sniper", "Int", listOf(
							"Applies mult to reload speed: 1 = 0.6, 2 = 0.3",
							"does not stack with Haste powerup"
						)
					)
				), listOf("The Huntsman, Festive Huntsman, The Fortified Compound")
			),
			
			HierarchyAttrClassScope(
				"Bat", listOf(
					AttrClassUsage(
						"set_weapon_mode", "Int", listOf(
							"If 0, cannot create a ball"
						)
					)
				), listOf("TF_WEAPON_BAT, Upgradeable TF_WEAPON_BAT, The Candy Cane, The Boston Basher, Sun-on-a-Stick, The Fan O'War, The Atomizer, Three-Rune Blade, Festive Bat 2011, Batsaber", "The Sandman (tf_weapon_bat_wood)", "The Holy Mackerel, Unarmed Combat, Festive Holy Mackerel (tf_weapon_bat_fish)")
			),
			
			HierarchyAttrClassScope(
				"Entity", listOf(
					AttrClassUsage("cannot_be_backstabbed", "Boolean"),
					AttrClassScope(
						"Buildings",
						AttrClassScope(
							"AllBuildings",
							AttrClassUsage("mod_build_rate", "Float", listOf("Multiplies building build time by this amount")),
							AttrClassUsage("- `upgrade_rate_mod`: Int", listOf("- Add x metal to any building hit using player's metal reserve", "- Recall that all players have 100 hidden metal")),
							AttrClassUsage("- `mult_engy_building_health`: Int", listOf("- Only applied if the building is NOT a disposable sentry")),
						),
						AttrClassScope(
							"Sentry",
							AttrClassUsage("- `mvm_sentry_ammo`: Float", listOf("- Multiplier to max ammo")),
							AttrClassUsage("- `mult_sentry_range`: Float", listOf()),
							AttrClassUsage("- `build_small_sentries`: Boolean", listOf(" - If true, creates a sentry that's 80% size that upgrades with 150 metal instead of 200.")),
						),
						AttrClassScope(
							"Dispenser",
							AttrClassUsage("- `mult_dispenser_rate`: Float", listOf("- Dispenser resupply rate")),
							AttrClassUsage("- `mult_dispenser_radius`: Float", listOf()),
						),
						AttrClassScope(
							"Teleporter",
							AttrClassUsage("- `mod_teleporter_speed_boost`: Boolean", listOf("- If true, teleporter adds speed boost condition with arg 4.0 to teleported player")),
							AttrClassUsage(" - `mod_teleporter_cost`: Float", listOf("   - Flat mult to metal cost to upgrade teleporter")),
							AttrClassUsage("- `bidirectional_teleport`: Boolean", listOf()),
							AttrClassUsage("- `mult_teleporter_recharge_rate`: Float", listOf()),
							
							),
					),
					AttrClassUsage("- `cannot_swim`: Boolean"),
					AttrClassUsage("- `mod_jump_height`: Float"),
					AttrClassUsage("- `mult_health_frompacks`: Float"),
					AttrClassUsage("- `mult_healing_from_medics`: Float", listOf("- Only on crossbow impacts")),
					AttrClassUsage("- `hype_resets_on_jump`: Int", listOf("- Lose this amount of hype if you airdash", " - Note that this only applies to scout hype, not rage in general")),
					AttrClassUsage("- `parachute_attribute`: Boolean", listOf("- Allows parachute to be deployed")),
					AttrClassUsage("- `parachute_disabled`: Boolean", listOf("- Prevents parachute from being deployed, but still allows it to be retracted.")),
					AttrClassUsage("- `set_custom_buildmenu`: Int", listOf("- Only used if the build menu is actually shown", "- 0 = default", "- 1 = pipboy")),
					AttrClassUsage("- `appear_as_mvm_robot`: Boolean", listOf("- If true, appear as an MvM robot in your hud when selecting a class")),
				)
			),
			HierarchyAttrClassScope(
				"Player", listOf(
					AttrClassUsage("see_enemy_health", "Boolean"),
					AttrClassUsage("hide_enemy_health", "Boolean", listOf("Always true in MvM")),
					AttrClassScope(
						"SpyOnly",
						AttrClassUsage("set_custom_buildmenu", "Int", listOf()),
						AttrClassUsage("override_engineer_object_type", "Int", listOf("Default = -1", "If 0, build a catapult.")),
					),
				)
			),
			
			HierarchyAttrClassScope(
				"MvMBot", listOf(
					AttrClassUsage("bot_custom_jump_particle", "Boolean", listOf("If true, spawns a rocketjump particle whenever the robot jumps")),
					AttrClassUsage("bot_medic_uber_health_threshold", "Int", listOf("Defaults to 50, I guess it's a percentage")),
					AttrClassUsage("bot_medic_uber_deploy_delay_duration", "Int", listOf("Defaults to -1")),
					
					)
			),
			
			HierarchyAttrClassScope(
				"BaseProjectile", listOf(
					AttrClassUsage(
						"- `mad_milk_syringes`: Boolean\n" +
						"    - If true, applies mad milk on hit. Yes, this is in the base projectile.\n"
					)
				)
			),
			HierarchyAttrClassScope(
				"BaseRocket", listOf(
					AttrClassUsage(
						"- `mini_rockets`: Boolean\n" +
						"    - Uses the \"mini rockets\" model"
					),
					AttrClassUsage(
						"- `rocketjump_attackrate_bonus`: Float\n" +
						"    - If set on anything that fires a rocket, the rocket assumes it was fired by the Air Strike and reduces blast radius to 80%"
					),
					AttrClassUsage("- `mult_projectile_speed`: Float"),
					AttrClassUsage("- `rocket_specialist`: Int"),
					AttrClassUsage(
						"- `halloween_pumpkin_explosions`: Boolean\n" +
						"    - Does pumpkin bombs particle effect"
					),
					AttrClassUsage(
						"- `use_large_smoke_explosion`: Int\n" +
						"    - Use the big MvM particle when it explodes"
					),
					AttrClassUsage("- `mult_explosion_radius`: Float"),
					AttrClassUsage(
						"- `no_self_blast_damage`: Boolean\n" +
						"    - Also uses plunger model"
					),
					AttrClassUsage("- `mult_explosion_radius`: Float"),
					AttrClassUsage("- `rocket_specialist`: Int\n" +
					               "\t- If greater than 0, rocket does not have damage falloff")
				)
			),
			HierarchyAttrClassScope(
				"ProjectileRocket", listOf(
					AttrClassUsage(
						"- `halloween_pumpkin_explosions`: Boolean\n" +
						"    - Checks on owner or sentry's owner"
					)
				)
			),
			HierarchyAttrClassScope(
				"ProjectileFlare", ("- On launcher: `mult_projectile_speed`: Float\n" +
				                    "- On launcher: `mult_explosion_radius`: Float\n" +
				                    "- On launcher:  `mod_projectile_heat_seek_power`: Float").split("\n")
					.map { AttrClassUsage(it) }),
			HierarchyAttrClassScope(
				"ProjectileGrenade", ("- On launcher: `use_large_smoke_explosion`: Boolean\n" +
				                      "- On launcher: `halloween_pumpkin_explosions`: Boolean\n" +
				                      "- On launcher: `mult_explosion_radius`: Float\n" +
				                      "- On owner: `fuse_mult`: Float").split("\n")
					.map { AttrClassUsage(it) }),
			
			HierarchyAttrClassScope("ProjectileEnergyRing", listOf(AttrClassUsage("- On player: `energy_weapon_penetration`: Boolean"))),
			HierarchyAttrClassScope("ProjectileArrow", listOf(AttrClassUsage("- On player: `arrow_heals_buildings`: Boolean"))),
			
			HierarchyAttrClassScope(
				"ProjectilePipebomb", ("- On launcher: `stickybomb_fizzle_time`: Float\n" +
				                       "- On launcher: `grenade_no_bounce`: Boolean\n" +
				                       "- On launcher: `sticky_arm_time`: Float\n" +
				                       "- On launcher: `grenade_damage_reduction_on_world_contact`: Float").split("\n")
					.map { AttrClassUsage(it) }),
			
			
			HierarchyAttrClassScope(
				"PowerUpBottle", listOf(
					AttrClassUsage("- `powerup_duration`: Float\n"),
					AttrClassUsage(
						"- On player: `canteen_specialist`: Int\n" +
						"    - Adds extra time to the base powerup duration based on level."
					),
					AttrClassUsage("- `powerup_max_charges`: Int"),
					AttrClassUsage(
						"- `set_weapon_mode`: Int\n" +
						"    - If 1, is \"base\" powerup canteen"
					),
					AttrClassScope(
						"Type", *(("- `critboost`: Boolean\n" +
						           "- `ubercharge`: Boolean\n" +
						           "- `recall`: Boolean\n" +
						           "- `refill_ammo`: Boolean\n" +
						           "- `building_instant_upgrade`: Boolean").split("\n")
							.map { AttrClassUsage(it) }
							.toTypedArray())
					))
			),
			
			AttrClassScope(
				"Particles", ("- `particle_effect_use_head_origin`: Boolean\n" +
				              "- `particle_effect_vertical_offset`: Float").split("\n")
					.map(AttrClassUsage::invoke)
			),
			
			AttrClassScope(
				"EconEntity", listOf(
					AttrClassUsage(
						"- `is_festivized`: Boolean\n" +
						"    - Attaches festivizer"
					),
					AttrClassUsage(
						"- `set_attached_particle_static`: Int\n" +
						"- (index into ItemSchema AttributeControlledParticleSystem)\n" +
						"    - Attaches static particle, such as smoking a pipe\n" +
						"    - Cosmetics can only have one"
					),
					AttrClassUsage(
						"- `set_attached_particle`: Int\n" +
						" - (index into ItemSchema AttributeControlledParticleSystem)\n" +
						"    - Dynamic particle systems, such as unusuals"
					),
					AttrClassUsage(
						"- `throwable_particle_trail_only`: Boolean\n" +
						"    - If false, attaches the `set_attached_particle` to the item itself\n" +
						"    - If true, the particle only applies to the throwable particle trail. (If it's implemented, it's not in the SDK.)"
					),
				)
			),
			
			HierarchyAttrClassScope(
				"Entity",
				"""- `cannot_be_backstabbed`: Boolean
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
	- If true, appear as an MvM robot in your hud when selecting a class""".notesToAttrClassUsages() +
				AttrClassScope("Buildings",
					
						"""- `mod_build_rate`: Float
	- Multiplies building build time by this amount
- `upgrade_rate_mod`: Int
	- Add x metal to any building hit using player's metal reserve
	- Recall that all players have 100 hidden metal
- `mult_engy_building_health`: Int
	- Only applied if the building is NOT a disposable sentry""".notesToAttrClassUsages() +
						AttrClassScope("SentryGun", """- `mvm_sentry_ammo`: Float
	- Multiplier to max ammo
- `mult_sentry_range`: Float
- `mult_sentry_firerate`: Float
- `build_small_sentries`: Boolean
	- If true, creates a sentry that's 80% size whose upgrade metal is only 150 instead of 200""".notesToAttrClassUsages() +
						AttrClassScope("Dispenser", """- `mult_dispenser_rate`: Float
	- Dispenser resupply rate
- `mult_dispenser_radius`: Float""".notesToAttrClassUsages()) +
						AttrClassScope("Teleporter", """- `mod_teleporter_speed_boost`: Boolean
	- If true, teleporter adds speed boost condition with arg 4.0 to teleported player
- `mod_teleporter_cost`: Float
	- Flat mult to metal cost to build
- `bidirectional_teleport`: Boolean
- `mult_teleporter_recharge_rate`: Float""".notesToAttrClassUsages()))
				)
			),
			
			HierarchyAttrClassScope(
				"Player",
				"""- `cannot_swim`: Boolean
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
	- This attribute class is a multiplier to the amount of time, not a flat amount of time.
- `mod_mark_attacker_for_death`: Float
	- Number of seconds the player who hit this entity should be marked for death.
	- If attacker is affected by `TF_COND_ENERGY_BUFF` (Crit-a-Cola, Cleaner's Carbine, Buffalo Steak, etc.), the attacker receives `TF_COND_MARKEDFORDEATH_SILENT`
- `charge_turn_control`: Float
	- Default is 0.45f, and this class is a multiplier applied to it
- `lose_demo_charge_on_damage_when_charging`: Boolean
	- Used to detect the Tide Turner when deciding whether to give you minicrits or crits
- `mult_cloak_rate`: Float
- `mult_decloak_rate`: Float
- `set_quiet_unstealth`: Boolean
	- If true, plays `Player.Spy_UnCloakReduced` when decloaking
- `boots_falling_stomp`: Boolean
	- Deal 3x falling damage to player you land on
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
- `set_scout_doublejump_disabled`: Boolean
- `wet_immunity`: Boolean
- `set_cannot_disguise`: Boolean
- `mult_maxammo_primary`: Int
- `mult_maxammo_secondary`: Int
- `mult_maxammo_metal`: Int
- `mult_maxammo_grenades1`: Int
	- Only used for bat balls
- `set_buff_type`: BuffType
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
- `grenades1_resupply_denied`: Boolean
	- "Items that rely on timers to refill ammo use these attributes.  Prevents 'touch supply closet and spam the thing' scenario."
- `grenades2_resupply_denied`: Boolean
	- "Items that rely on timers to refill ammo use these attributes.  Prevents 'touch supply closet and spam the thing' scenario."
- `grenades3_resupply_denied`: Boolean
	- "Items that rely on timers to refill ammo use these attributes.  Prevents 'touch supply closet and spam the thing' scenario."
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
- `can_breathe_under_water`: Boolean""".notesToAttrClassUsages() + AttrClassScope(
					"DemomanOnly",
					"""- `mod_charge_time`: Float
	- Attribute class is a flat multiplier applied to total charge time when charging
- `charge_recharge_rate`: Float
	- Multiplier to charge gained over time.
- `lose_demo_charge_on_damage_when_charging`: Boolean
- `kill_refills_meter`: Float
	- Amount of Targe-Charge gained on kill.  Scaled by various values.
- `decapitate_type`: Boolean
	- If true, reduces max health gained from Knockout rune to 20.""".notesToAttrClassUsages()
				) + AttrClassScope("ScoutOnly", """- `set_scout_doublejump_disabled`: Boolean
- `hype_decays_over_time`: Float
	- How much the Scout's hype meter decays every tick
- `lose_hype_on_take_damage`: Int
	- Amount of hype lost per point of damage taken.""".notesToAttrClassUsages()) + AttrClassScope("SniperOnly", """- `mult_aiming_knockback_resistance`: Float
- `rage_on_kill`: Float
	- Amount of sniper rage gained on kill.""".notesToAttrClassUsages()) + AttrClassScope("MedicOnly", """- `healing_mastery`: Int
	- Each level gives +25% of the Medic's passive regen
- `generate_rage_on_heal`: Boolean
""".notesToAttrClassUsages() + AttrClassScope("SpyOnly", """- `add_cloak_on_kill`: Int
	- Amount of cloak gained on kill.
- `custom_taunt_particle_attr`: Boolean
	- Use Saharan Spy particle effect when performing a stock knife taunt.""".notesToAttrClassUsages())),
			)
		)
}

private fun String.notesToAttrClassUsages(): List<MyNotesFormatted.IAttrThing> {
	return this.split("\n-").mapIndexed { i, it -> MyNotesFormatted.AttrClassUsage((if (i > 0) "-" else "") + it) }
}
