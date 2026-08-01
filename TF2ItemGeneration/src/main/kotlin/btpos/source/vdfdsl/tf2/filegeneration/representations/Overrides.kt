package btpos.source.vdfdsl.tf2.filegeneration.representations

import btpos.source.vdfdsl.tf2.filegeneration.representations.NamedAttribute.EffectType
import btpos.source.vdfdsl.tf2.filegeneration.representations.groupings.NamedAttributeScope
import btpos.source.vdfdsl.tf2.filegeneration.representations.groupings.PenaltyBonus
import btpos.source.vdfdsl.tf2.filegeneration.representations.groupings.Vis
import kotlin.collections.first
import kotlin.collections.toTypedArray

val removeFromThing = listOf("hidden(\\w)?").map { Regex(it, RegexOption.IGNORE_CASE) }
private val modRegex = Regex("^mod[ _]")
private val re_notWordOrSpace = Regex("[^\\s\\w]")

fun String.sanitizeNamedAttributeName(): String {
	return this.replace(modRegex, "").replace("SPELL", "spell").replace(":", " ").replace(re_notWordOrSpace, "")
}

val overrideAutogenVarNames: MutableMap<String, String> = mutableMapOf(
	"fixedShotPattern" to "fixedWeaponSpread",
	"multSpreadScalesConsecutive" to "spreadIncreasesOnConsecutiveShots",
	"spread" to "weaponSpread",
	"panicAttackNegative" to "multSpreadAsHealthDecreases",
	"noReloadDisplayOnly" to "noReload_displayOnly",
	"sanguisuge" to "gainHealthOnBackstab",
	"medigunChargeIsCritBoost" to "giveCrits",
	"medigunChargeIsResists" to "giveResistanceType",
	"usesAmmoWhileAiming" to "spinupAmmoDrain",
	"minigunNoSpinSounds" to "silentBarrel",
	"botCustomJumpParticle" to "customJumpParticle",
	"botMedicUberHealthThreshold" to "medicUberHealthThreshold",
	"botMedicUberDeployDelayDuration" to "medicUberDeployDelayDuration",
	"particleEffectUseHeadOrigin" to "useHeadOrigin",
	"particleEffectVerticalOffset" to "verticalOffset",
	"maxPipebombs" to "maxStickies",
	"halloweenPumpkinExplosions" to "pumpkinBombs",
	"rocketLaunchImpulse" to "canRocketJumpWithExplosion",
	"sentryKilledRevenge" to "canGainRevengeCrits",
	"shovelDamageBoost" to "isEqualizer",
	"shovelSpeedBoost" to "isEscapePlan",
	"sniperNoHeadshots" to "cannotHeadshot",
	"sniperFullChargeDamageBonus" to "fullChargeDamageBonus",
	"sRifleChargeRate" to "chargeRate",
	"sniperOnlyFireZoomed" to "canOnlyFireWhenZoomed",
	"sniperPenetratePlayersWhenCharged" to "penetratesWhenFullyCharged",
	"sniperNoHeadshotWithoutFullCharge" to "cannotHeadshotWithoutFullCharge",
	"sniperCritNoScope" to "canHeadshotUnscoped",
	"explosiveSniperShot" to "explosiveHeadshotLevel",
	"ammoGivesCharge" to "ammoPacksGiveDemoknightCharge",
	"critModDisabled" to "multRandomCritChance",
	"engineerBuildingTeleportingPickup" to "buildingRescueMetalCost",
	"countsAsAssisterIsSomeKindOfPetThisUpdateIsGoingToBeAwesome" to "countsAsAssister",
	"backstabShield" to "blocksBackstab",
	"activeHealthDegen" to "passiveHealthRegen",
	"healthOnRadiusDamage" to "healOnHit_radial",
	"multHealthFromhealersPenaltyActive" to "multHealthFromHealersWhileActive",
	"overhealFillRateReduced" to "multOverhealFillRate",
	"maxhealthDrainRate" to "maxHealthDrainedWhileActive",
	"dmgBonusWhileHalfDead" to "multDmgWhileHalfDead",
	"dmgPenaltyWhileHalfAlive" to "multDmgWhileHalfAlive",
	"damageAppliesToSappers" to "canDamageSappers"
)

/** Scopename to description lines */
val extraScopeDescriptions = mapOf(
	"afterburn" to listOf("Attributes related to afterburn."),
	"ammo" to listOf("Attributes related to max ammo, clip-size, and resupply."),
	"buildings" to listOf("Attributes related to moving, constructing, and interacting with the Engineer's buildings."),
	"crits" to listOf("Attributes related to dealing or preventing critical hits and mini-crits."),
	"damage" to listOf(
		"Multipliers governing the damage you deal to different targets.",
		"For damage _taken_, see [resistance]."
	),
	"demoCharge" to listOf(
		"Attributes governing the Demoknight's shield-charge.",
		"Some of these attributes are hardcoded to only work on the Demoman. These are noted in their documentation."
	),
	"firing" to listOf("Attributes governing rate-of-fire."),
	"healthAndHealing" to listOf("Attributes related to the player's HP stat and healing players."),
	"knockbackReceived" to listOf("Attributes governing how much you are pushed when hit by different push sources."),
	"meta" to listOf("Attributes related to the scoreboard, killfeed, HuD, item descriptions, and interactions with the wider game-state. (including capture rate)"),
	"meter" to listOf("Attributes related to rage and items that recharge on a meter/timer."),
	"movement" to listOf("Attributes governing the player's move-speed, jump height, swimming, air-strafing capabilities, and all things mobility-related."),
	"heads" to listOf(
		"Attributes related to the collection and passive effects of \"heads\".",
		"While originally made for the Eyelander, this stat is used by many other weapons that track players hit or killed: the Vita-Saw, the Bazaar Bargain, etc.",
		"For \"revenge crits\", like the Frontier Justice, Manmelter, and Diamondback, see [revengeCrits]."
	),
	"onHit" to listOf(
		"Attributes governing what happens when you hit another player, such as applying conditions or debuffs.",
		"@see onKill"
	),
	"onKill" to listOf(
		"Attributes governing what happens when you kill another player, usually applying bonuses to yourself.",
		"@see onHit"
	),
	"projectiles" to listOf(
		"All attributes governing what projectile or bullet this weapon can fire, and how that projectile or bullet acts once fired.",
		"Each type of projectile also has a subcategory with every attribute it checks for on the gun that fired it.",
	),
	"reloading" to listOf("Attributes governing either the time taken to reload a weapon's magazine or the cooldown time for weapons that draw directly from reserve ammo like the Sniper Rifle and Flare Gun."),
	"resistance" to listOf(
		"Attributes governing how much damage the player takes from various sources.  Also includes the passive and active effects of the Vaccinator on the user.",
		"For outgoing damage, see [damage]."
	),
	"revengeCrits" to listOf(
		"Attributes governing the collection of \"Revenge Crits\", guaranteed criticals gained by fulfilling certain requirements.",
		"It should be noted that for the most part, these attributes just state whether or not a weapon CAN gain revenge crits. Actually _using_ them is bound to the weapon type, not any attribute.",
		"For the collection and usage of \"heads\", see [heads]."
	),
	"statusEffects" to listOf(
		"Attributes related to Mad Milk, Jarate, and Gas.",
		"This will be empty for most weapons unless a mod adds something.  Notably, \"explode on ignite\" is available for all weapons."
	),
	"taunting" to listOf("Attributes governing taunt speed and the effects of taunts."),
	"whenHit" to listOf(
		"Attributes governing what happens when this player is hit by an enemy.",
		"For what happens when _this player_ hits an enemy, see [onHit] and [onKill]."
	),
	"ragdolls" to listOf("Attributes governing ragdolls, gibs, and statues."),
	"disguise" to listOf("Attributes related to disguising."),
	"swapWeapons" to listOf("Attributes governing weapon deploy/holster speed, things that activate when a weapon is deployed, and whether a player can swap weapons at all."),
	"flames" to listOf("Attributes controlling how flames emitted by the flamethrower move and reflect."),
	"airblast" to listOf("Attributes governing how the flamethrower's airblast behaves, including "),
	"" to listOf("Attributes "),
	"" to listOf("Attributes "),
) + mapOf(
	"multDmgFalloff" to listOf("Applies to all damage falloff, including blast-radius damage falloff."),
	
)

val overrideAutogeneratedScopeNames = mapOf(
	"MedigunChargeIsCritBoost" to "UberchargeType"
)

/**
 * map of "scope name" to "word to remove from thing"
 */
val stripFromScopeMembersNames = mutableMapOf(
	"Meter" to "itemMeter"
)


/**
 * set of variable names to turn from `it` to `mult${it.capitalize}`
 */
val addMultPrefix = mutableSetOf(
	"dmgFalloff",
	"healingReceived"
)

private val attrClass_to_createScopeForItsItems: Map<String, List<NamedAttribute>.() -> List<ISortedNamedAttribute>>
	get() {
		fun List<NamedAttribute>.select(attr: String): NamedAttribute = first { it.attrName == attr }
		
		return mapOf(
			"set_buff_type" to {
				listOf(
					NamedAttributeScope(
						"BuffType",
						*toTypedArray()
					)
				)
			},
			"mult_dmg" to {
				listOf(
					PenaltyBonus(
						bonus = select("damage bonus"),
						penalty = select("damage penalty"),
						neutral = select("CARD: damage bonus"),
						hidden = select("damage bonus HIDDEN")
					).apply {
						varName = "multDmg"
					}
				)
			},
			"mult_postfiredelay" to {
				listOf(
					PenaltyBonus(
						bonus = select("fire rate bonus"),
						penalty = select("fire rate penalty"),
						hidden = PenaltyBonus(
							bonus = select("fire rate bonus HIDDEN"),
							penalty = select("fire rate penalty HIDDEN")
						),
						neutral = select("melee attack rate bonus")
					).apply {
						notes += first().notes
						varName = "multPostFireDelay"
					}
				)
			}
		)
	}


fun <T : ISortedNamedAttribute> T.postprocess(): T = apply {
	if (this is PenaltyBonus || this is NamedAttributeScope) {
		extraScopeDescriptions[this.varName]?.let {
			this.notes += it
		}
	}
	
	if (this is NamedAttributeScope) {
		stripFromScopeMembersNames[scopeName]?.let { toStrip ->
			attrs.forEach {
				it.varName = it.varName.removeFromCamelCase(toStrip)
			}
		}
		
		this.attrs.forEach {
			it.postprocess()
		}
	}
}

fun postprocessAllScopes(list: List<ISortedNamedAttribute>) {
	list.forEach {
		if (it is NamedAttributeScope) {
			it.postprocess()
			postprocessAllScopes(it.attrs)
		}
	}
}

/**
 * Create some combined representation for these attributes in the same attribute class.
 *
 * This is here because we need to override the name with something hand-picked for the scope in [attrClass_to_createScopeForItsItems]
 */
fun fabricateScope(attrClass: String, attrsOfSameClass: List<NamedAttribute>): List<ISortedNamedAttribute> {
	fun NamedAttributeScope.overrideAutogen() = apply {
		this.scopeName = overrideAutogeneratedScopeNames[scopeName]
		                 ?: scopeName.removeBonusPenaltyHiddenStuff()
	}
	
	fun makeDefaultScope(): NamedAttributeScope {
		return NamedAttributeScope(attrsOfSameClass.first().varName.capitalize(), *attrsOfSameClass.toTypedArray())
	}
	
	fun groupHiddenItemsIntoPenaltyBonus(allHidden: List<NamedAttribute>): ISortedNamedAttribute {
		return when (allHidden.size) {
			1 -> allHidden.single()
			// Make hidden items into a nested PenaltyBonus
			else -> allHidden.groupBy { it.effectType }.let {
				it.values.firstOrNull { it.size > 1 }?.let {
					error("Too many values: $it")
				}
				PenaltyBonus(
					penalty=it[EffectType.Negative]?.single(),
					bonus=it[EffectType.Positive]?.single(),
					neutral=it[EffectType.Neutral]?.single(),
				)
			}
		}
	}
	
	
	//
	attrClass_to_createScopeForItsItems[attrClass]?.let { ctor ->
		return ctor(attrsOfSameClass).onEach { it.postprocess() }
	}
	
	
	val isPos = 0; val isNeg = 1; val isNeu = 2; val isHidden = 3
	val groupedByPosNegNeutral = attrsOfSameClass.groupBy {
		when {
			it.isHidden == true -> isHidden
			else -> when (it.effectType) {
				EffectType.Positive -> isPos
				EffectType.Negative -> isNeg
				EffectType.Neutral -> isNeu
			}
		}
	}
	// If we have multiple bonuses or multiple penalties and they're not just hidden, we should have assigned a custom scope.
	// Fallthrough to just making a default scope.
	if (groupedByPosNegNeutral.size == 1 || groupedByPosNegNeutral.any { it.key != isHidden && it.value.size > 1 }) {
		return listOf(makeDefaultScope().overrideAutogen().postprocess())
	}
	
	/*
	Variants:
	- If there's only 1 attribute in the class, just return that attribute
	- If there's only 1 positive/negative/neutral + some hiddens -> Vis
	- Else if there's some combination of positive, negative, neutral, hidden, make it a PenaltyBonus
		- If there are multiple hidden, make the hidden ALSO a PenaltyBonus
	 */
	return when (groupedByPosNegNeutral.size) {
		1 -> attrsOfSameClass // if they're all one type, just do them separately
		2 -> {
			if (isHidden in groupedByPosNegNeutral) { // if there's just a hidden and a visible, do Vis
				val notHidden = groupedByPosNegNeutral.entries.first { it.key != isHidden }.value.single()
				val hidden = groupedByPosNegNeutral[isHidden]!!.let { allHidden ->
					groupHiddenItemsIntoPenaltyBonus(allHidden)
				}
				
				listOf(Vis(notHidden, hidden, attrClass))
			} else {
				// Else it's a custom PenaltyBonus
				listOf(PenaltyBonus(
					groupedByPosNegNeutral[isNeg]?.single(),
					groupedByPosNegNeutral[isPos]?.single(),
					groupedByPosNegNeutral[isNeu]?.single(),
				))
			}
		}
		else -> {
			listOf(
				PenaltyBonus(
					groupedByPosNegNeutral[isNeg]?.single(),
					groupedByPosNegNeutral[isPos]?.single(),
					groupedByPosNegNeutral[isNeu]?.single(),
					groupedByPosNegNeutral[isHidden]?.let { groupHiddenItemsIntoPenaltyBonus(it) }
				)
			)
		}
	}.onEach {
		if (it is NamedAttributeScope) {
			it.overrideAutogen()
		}
		it.postprocess()
	}
}

fun String.overrideVarName(): String {
	if (this in addMultPrefix) {
		return "mult" + this.replaceFirstChar { it.uppercaseChar() }
	}
	return (overrideAutogenVarNames[this] ?: this)
}


val removeFromPBName = listOf("decreased?", "lower(?:ed)?", "increased?", "bonus", "penalty").map { Regex(it, RegexOption.IGNORE_CASE) }
val attrToSelector = mapOf(
	"Fists" to mapOf("fists have radial buff" to 1),
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

fun String.removeBonusPenaltyHiddenStuff(): String {
	return (removeFromPBName + removeFromThing).fold(this) { it, re -> it.removeFromCamelCase(re) }
}


/**
 * Cache conversion of stuff like `"itemMeter"` to `Regex("[Ii]temMeter")`
 * so we can possibly match the thing in the middle of a word
 */
private val regexCache = HashMap<String, Regex>()

fun String.removeFromCamelCase(toRemove: String): String {
	val re = regexCache.computeIfAbsent(toRemove) {
		Regex(it.replaceFirstChar { c ->
			val alt = if (c.isUpperCase()) c.lowercaseChar() else c.uppercaseChar()
			"[$c$alt]"
		})
	}
	
	return this.removeFromCamelCase(re)
}

fun String.removeFromCamelCase(toRemove: Regex): String {
	if (toRemove.matchesAt(this, 0)) {
		return toRemove.replaceFirst(this, "")
			.replaceFirstChar { it.lowercaseChar() } // make sure beginning isn't left capitalized
	}
	
	return this.replace(toRemove, "")
}