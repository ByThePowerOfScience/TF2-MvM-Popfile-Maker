package btpos.source.vdfdsl.tf2.assetgeneration

import btpos.source.vdfdsl.tf2.assetgeneration.representations.ISortedNamedAttribute
import btpos.source.vdfdsl.tf2.assetgeneration.representations.NamedAttribute
import btpos.source.vdfdsl.tf2.assetgeneration.representations.bool
import btpos.source.vdfdsl.tf2.assetgeneration.representations.groupings.HierarchyNamedAttributeScope
import btpos.source.vdfdsl.tf2.assetgeneration.representations.groupings.NamedAttributeScope
import btpos.source.vdfdsl.tf2.assetgeneration.representations.selectorCodec
import kotlin.collections.flatten

object MyNotesFormatted {
	sealed interface IAttrThing {
		operator fun contains(clsName: String): Boolean
		
		fun absorb(classToNamed: Map<String, List<ISortedNamedAttribute>>): List<ISortedNamedAttribute>
	}
	
	private fun String.comma() = this.split(", ")
	
	class AttrClassUsage(val attr_class: String, val kType: String, notes: List<String> = listOf()) : IAttrThing {
		val notes = notes.map { if (!it.endsWith('.')) it + '.' else it }
		
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
								it.codec
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
					AttrClassUsage(
						"weapon_allow_inspect", "Boolean", listOf()
					)
				)
			),
			
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
							"In vanilla, this is indeed only checked on Fire Axes."
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
			
			HierarchyAttrClassScope("Wearable", listOf<IAttrThing>()),
			
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
					)
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
					)
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
			
			HierarchyAttrClassScope("ProjectileEnergyRing", listOf(AttrClassUsage("- On owner: `energy_weapon_penetration`: Boolean"))),
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
						           "- `refill_ammmo`: Boolean\n" +
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
			)
		)
}
