package btpos.source.vdfdsl.tf2.filegeneration.representations

import btpos.source.vdfdsl.tf2.filegeneration.re_notWordChar
import btpos.source.vdfdsl.tf2.filegeneration.representations.groupings.NamedAttributeScope
import btpos.source.vdfdsl.tf2.filegeneration.representations.mynotes.IAttrThing

object Overrides {
	/**
	 * Attribute name to additional comment
	 */
	val commentOverrides: Map<String, String> = mapOf(
	
	)
}

val removeFromThing = listOf("hidden").map { Regex(it, RegexOption.IGNORE_CASE) }
private val modRegex = Regex("^mod[ _]")
private val re_notWordOrSpace = Regex("[^\\s\\w]")

fun String.sanitizeNamedAttributeName(): String {
	return this.replace(modRegex, "").replace("SPELL", "spell").replace(":", " ").replace(re_notWordOrSpace, "")
}




val overrideVarNames: MutableMap<String, String> = mutableMapOf(
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
	"critModDisabled" to "critChance"
)

val overrideScopeNames = mapOf(
	"MedigunChargeIsCritBoost" to "UberchargeType"
)

val removeFromScopeMembers = mutableMapOf(
	"Meter" to "itemMeter"
)

val addMultPrefix = mutableSetOf(
	"dmgFalloff",
)

private val attrClass_to_createScopeForItsItems = mapOf(
	"set_buff_type" to { it: List<NamedAttribute> ->
		listOf(NamedAttributeScope(
			"BuffType",
			*it.toTypedArray()
		))
	},
).withDefault {
	{ listOf(NamedAttributeScope(it.first().varName.capitalize(), *it.toTypedArray())) }
}

fun overrideScopeMemberNames(scopeName: String, scopeMembers: List<ISortedNamedAttribute>) {
	removeFromScopeMembers[scopeName]?.let { toStrip ->
		scopeMembers.onEach {
			it.varName = it.varName.replace(toStrip, "").replace(toStrip.capitalize(), "")
		}
	}
}

/**
 * Create some combined representation for these attributes in the same attribute class.
 *
 * This is here because we need to override the name with something hand-picked for the scope in [attrClass_to_createScopeForItsItems]
 */
fun fabricateScope(attrClass: String, attrsOfSameClass: List<NamedAttribute>): List<ISortedNamedAttribute> {
	val scopeCtor = attrClass_to_createScopeForItsItems.getValue(attrClass)
	return scopeCtor(attrsOfSameClass)
}

fun String.overrideScopeName() = (overrideScopeNames[this] ?: this)

fun String.overrideVarName(): String {
	if (this in addMultPrefix) {
		return "mult" + this.replaceFirstChar { it.uppercaseChar() }
	}
	return (overrideVarNames[this] ?: this)
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
	return (removeFromPBName + removeFromThing).fold(this) { it, re -> it.replace(re, "") }
}