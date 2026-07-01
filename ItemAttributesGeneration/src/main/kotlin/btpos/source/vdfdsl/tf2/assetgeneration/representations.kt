package btpos.source.vdfdsl.tf2.assetgeneration

import btpos.source.vdfdsl.tf2.assetgeneration.representations.groupings.HierarchyNamedAttributeScope

private val spaceUnderscore = Regex("[_\\s]+")
fun String.camelCase(): String {
	val split = this.lowercase().split(spaceUnderscore)
	if (split.size == 1) {
		return this.replaceFirstChar { it.lowercaseChar() }
	}
	val camelCase = split.joinToString("") { it.replaceFirstChar { it.uppercaseChar() } }.replaceFirstChar { it.lowercaseChar() }
	
	return camelCase
}


class ArmoryDesc(val all: List<String>) {
	
	companion object {
	    operator fun invoke(item: String?): ArmoryDesc? {
	        return item?.let { it.split(' ') }?.let { ArmoryDesc(it) }
	    }
	}
	
	val isOnHit get() = "on_hit" in all
	
	val isOnWearer get() = "on_wearer" in all
	
	val isOnActive get() = "on_active" in all
}

val removeFromThing = listOf("hidden").map { Regex(it, RegexOption.IGNORE_CASE) }


val hierarchiesByName = mutableMapOf<String, HierarchyNamedAttributeScope>()

fun String.sanitize(): String {
	return (removeFromPBName + removeFromThing).fold(this) { it, re -> it.replace(re, "") }
}


val overrideVarNames: Map<String, String> = mapOf(
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
	"ammoGivesCharge" to "ammoPacksGiveDemoknightCharge"
)

val overrideScopeNames = mapOf(
	"MedigunChargeIsCritBoost" to "UberchargeType"
)

fun String.overrideScopeName() = (overrideScopeNames[this] ?: this)

fun String.overrideVarName(): String {
	return (overrideVarNames[this] ?: this)
}


val removeFromPBName = listOf("decreased?", "lower(?:ed)?", "increased?", "bonus", "penalty").map { Regex(it, RegexOption.IGNORE_CASE) }

