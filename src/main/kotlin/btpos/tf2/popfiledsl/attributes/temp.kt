@file:Suppress("CanBeParameter")

package btpos.tf2.popfiledsl.attributes

import btpos.tf2.popfiledsl.modeling.BonusPenalty
import btpos.tf2.popfiledsl.modeling.IKeyValueMap
import btpos.tf2.popfiledsl.modeling.KeyValueMapImpl
import btpos.tf2.popfiledsl.modeling.delegate
import btpos.tf2.popfiledsl.serialization.IVDFSerializableValue
import btpos.tf2.popfiledsl.serialization.VDFStringLiteral.Companion.literal
import btpos.tf2.popfiledsl.serialization.codecs.ColorCodec
import java.awt.Color


class DamageAttributes(val _attr: KeyValueMapImpl) {
	/**
	 * N% damage penalty
	 * +N% damage bonus
	 *
	 * percentage
	 */
	val damagePercentMult = _attr.bonusPenalty<Double>("damage bonus".literal(), "damage penalty".literal())
	
	/**
	 * N% damage vs non-stunned players
	 *
	 * percentage
	 */
	var dmgPenaltyVsNonstunned: Double? by _attr.delegate("dmg penalty vs nonstunned".literal())
}

class ClipSizeAttributes(val _attr: KeyValueMapImpl) {
	
	/**
	 * bonus: +N% clip size
	 *
	 * penalty: N% clip size
	 */
	val clipSize = BonusPenalty<Double>(_attr, "clip size bonus".literal(), "clip size penalty".literal())
}

/**
 * Penalty: `N% slower firing speed` - inverted_percentage
 *
 * Bonus: `+N% faster firing speed` - inverted_percentage
 */
context(_attr: IKeyValueMap)
val fireRate
	get() = BonusPenalty<Double>(_attr, "fire rate bonus".literal(), "fire rate penalty".literal())

class HealRateAttributes(val _attr: IKeyValueMap) {
	/**
	 * N% heal rate
	 *
	 * percentage
	 */
	var healRatePenalty: Double? by _attr.delegate("heal rate penalty".literal())
	
	/**
	 * +N% heal rate
	 *
	 * percentage
	 */
	var healRateBonus: Double? by _attr.delegate("heal rate bonus".literal())
}

class ExplosionAttributes(val _attr: IKeyValueMap) {
	/**
	 * +N% explosion radius
	 *
	 * percentage
	 */
	var BlastRadiusIncreased: Double? by _attr.delegate("Blast radius increased".literal())
	
	/**
	 * N% explosion radius
	 *
	 * percentage
	 */
	var BlastRadiusDecreased: Double? by _attr.delegate("Blast radius decreased".literal())
	
}

class ProjectileAttributes(val _attr: IKeyValueMap) {
	/**
	 * +N% projectile range
	 *
	 * percentage
	 */
	var ProjectileRangeIncreased: Double? by _attr.delegate("Projectile range increased".literal())
	
	/**
	 * N% projectile range
	 *
	 * percentage
	 */
	var ProjectileRangeDecreased: Double? by _attr.delegate("Projectile range decreased".literal())
	
	/**
	 * +N% projectile speed
	 *
	 * percentage
	 */
	var ProjectileSpeedIncreased: Double? by _attr.delegate("Projectile speed increased".literal())
	
	/**
	 * N% projectile speed
	 *
	 * percentage
	 */
	var ProjectileSpeedDecreased: Double? by _attr.delegate("Projectile speed decreased".literal())
	
}

class MiscWeaponAttributes(val _attr: IKeyValueMap) {
	/**
	 * No random critical hits
	 *
	 * percentage
	 */
	var noRandomCrits: Double? by _attr.delegate("crit mod disabled".literal())
	
	/**
	 * No random critical hits
	 *
	 * percentage
	 */
	var noRandomCrits_hidden: Double? by _attr.delegate("crit mod disabled hidden".literal())
	
	/**
	 * N% less accurate
	 *
	 * percentage
	 */
	var accuracyPenalty: Double? by _attr.delegate("spread penalty".literal())
	
	/**
	 * N% more accurate
	 *
	 * inverted_percentage
	 */
	var weaponSpreadBonus: Double? by _attr.delegate("weapon spread bonus".literal())
	
	
	/**
	 * +N% bullets per shot
	 *
	 * percentage
	 */
	var bulletsPerShotBonus: Double? by _attr.delegate("bullets per shot bonus".literal())
	
	/**
	 * N% slower reload time
	 *
	 * percentage
	 */
	var ReloadTimeIncreased: Double? by _attr.delegate("Reload time increased".literal())
	
	/**
	 * N% faster reload time
	 *
	 * inverted_percentage
	 */
	var ReloadTimeDecreased: Double? by _attr.delegate("Reload time decreased".literal())
	
}

class AmmoAttributes(val _attr: IKeyValueMap) {
	/**
	 *
	 *
	 * percentage
	 */
	var hiddenSecondaryMaxAmmoPenalty: Double? by _attr.delegate("hidden secondary max ammo penalty".literal())
	
	/**
	 *
	 *
	 * percentage
	 */
	var hiddenPrimaryMaxAmmoBonus: Double? by _attr.delegate("hidden primary max ammo bonus".literal())
	
	
	/**
	 * +N% max secondary ammo on wearer
	 *
	 * percentage
	 */
	var maxammoSecondaryIncreased: Double? by _attr.delegate("maxammo secondary increased".literal())
	
	/**
	 * N% max secondary ammo on wearer
	 *
	 * percentage
	 */
	var maxammoSecondaryReduced: Double? by _attr.delegate("maxammo secondary reduced".literal())
	
	
	/**
	 * +N% max primary ammo on wearer
	 *
	 * percentage
	 */
	var maxammoPrimaryIncreased: Double? by _attr.delegate("maxammo primary increased".literal())
	
	/**
	 * N% max primary ammo on wearer
	 *
	 * percentage
	 */
	var maxammoPrimaryReduced: Double? by _attr.delegate("maxammo primary reduced".literal())
}

class EngineerAttributes(val _attr: IKeyValueMap) {
	/**
	 * +N% max metal on wearer
	 *
	 * percentage
	 */
	var maxammoMetalIncreased: Double? by _attr.delegate("maxammo metal increased".literal())
	
	/**
	 * N% max metal on wearer
	 *
	 * percentage
	 */
	var maxammoMetalReduced: Double? by _attr.delegate("maxammo metal reduced".literal())
	
	
	/**
	 * Construction hit speed boost increased by N%
	 *
	 * percentage
	 */
	var constructionRateIncreased: Double? by _attr.delegate("Construction rate increased".literal())
	
	/**
	 * Construction hit speed boost decreased by N%
	 *
	 * inverted_percentage
	 */
	var ConstructionRateDecreased: Double? by _attr.delegate("Construction rate decreased".literal())
	
	/**
	 * N% faster repair rate
	 *
	 * percentage
	 */
	var RepairRateIncreased: Double? by _attr.delegate("Repair rate increased".literal())
	
	/**
	 * N% slower repair rate
	 *
	 * inverted_percentage
	 */
	var RepairRateDecreased: Double? by _attr.delegate("Repair rate decreased".literal())
	
}

class MedicAttributes(val _attr: KeyValueMapImpl) {
	class Primary(val _attr: IKeyValueMap) {
		/**
		 * On Hit: N% ÜberCharge added
		 *
		 * additive_percentage
		 */
		val addUberChargeOnHit: Double? by _attr.delegate("add uber charge on hit".literal())
	}
	
	class UberCharge(val _attr: IKeyValueMap) {
		/**
		 * ÜberCharge grants 100% critical chance
		 *
		 * additive
		 */
		val medigunChargeIsCritBoost: Boolean? by _attr.delegate("medigun charge is crit boost".literal())
	}
	
	class UberchargeRateAttributes(val _attr: IKeyValueMap) {
		/**
		 * N% ÜberCharge rate
		 *
		 * percentage
		 */
		val uberchargeRatePenalty: Double? by _attr.delegate("ubercharge rate penalty".literal())
		
		/**
		 * +N% ÜberCharge rate
		 *
		 * percentage
		 */
		val uberchargeRateBonus: Double? by _attr.delegate("ubercharge rate bonus".literal())
	}
	
	/**
	 * N% max overheal
	 *
	 * inverted_percentage
	 */
	var overhealPenalty: Double? by _attr.delegate("overheal penalty".literal())
	
}

class OnHitFoeScope(val _attr: KeyValueMapImpl) {
	/**
	 * On Hit: Gain up to +N health
	 *
	 * additive
	 */
	var healOnHit: Int? by _attr.delegate("heal on hit for rapidfire".literal())
	
	
	/**
	 * On Hit: +N% damage bonus
	 *
	 * additive_percentage
	 */
	var gainTempDamageBonus: Double? by _attr.delegate("tmp dmgbuff on hit".literal())
	
	/**
	 * On Hit: N% chance to slow target
	 *
	 * additive_percentage
	 */
	var slowEnemyOnHit: Double? by _attr.delegate("slow enemy on hit".literal())
	
}


class HeavyWeaponsWeaponAttributes(val _attr: IKeyValueMap) {
    class MinigunAttributes(val _attr: IKeyValueMap) {
	    /**
	     * N% slower spin up time
	     *
	     * percentage
	     */
	    val minigunSpinupTimeIncreased: Double? by _attr.delegate("minigun spinup time increased".literal())
	    
	    /**
	     * N% faster spin up time
	     *
	     * inverted_percentage
	     */
	    val minigunSpinupTimeDecreased: Double? by _attr.delegate("minigun spinup time decreased".literal())
    }
}

class DemomanWeaponAttributes(val _attr: IKeyValueMap) {
	/**
	 * +N max stickybombs out
	 *
	 * additive
	 */
	var maxPipebombsIncreased: Int? by _attr.delegate("max pipebombs increased".literal())
	
	/**
	 * N max stickybombs out
	 *
	 * additive
	 */
	var maxPipebombsDecreased: Int? by _attr.delegate("max pipebombs decreased".literal())
	
}

class SpyWeaponAttributes(val _attr: IKeyValueMap) {
	class RevolverAttributes(val _attr: IKeyValueMap) {
		/**
		 * Absorbs N% damage while cloaked
		 *
		 * percentage
		 */
		val absorbDamageWhileCloaked: Double? by _attr.delegate("absorb damage while cloaked".literal())
		
		/**
		 * Crits on headshot
		 *
		 * additive
		 */
		val critsOnHeadshot: Boolean? by _attr.delegate("revolver use hit locations".literal())
	}
	
	class CloakAttributes(val _attr: IKeyValueMap) {
		/**
		 * Cloak Type: Feign Death.
		 * Leave a fake corpse on taking damage and temporarily gain invisibility, speed, and damage resistance.
		 *
		 * additive
		 */
		val setCloakIsFeignDeath: Boolean? by _attr.delegate("set cloak is feign death".literal())
		
		/**
		 * +N% cloak drain rate
		 *
		 * percentage
		 */
		val multCloakMeterConsumeRate: Double? by _attr.delegate("mult cloak meter consume rate".literal())
		
		/**
		 * +N% cloak regen rate
		 *
		 * percentage
		 */
		val multCloakMeterRegenRate: Double? by _attr.delegate("mult cloak meter regen rate".literal())
		
		/**
		 * Cloak Type: Motion Sensitive.
		 * Alt-fire: Turn invisible. Cannot attack while invisible.
		 * Bumping in to enemies will make you slightly visible to enemies.
		 * Cloak drain rate based on movement speed.
		 *
		 * additive
		 */
		val setCloakIsMovementBased: Boolean? by _attr.delegate("set cloak is movement based".literal())
		
		/**
		 * -N% cloak duration
		 *
		 * percentage
		 */
		val cloakConsumeRateIncreased: Double? by _attr.delegate("cloak consume rate increased".literal())
		
		/**
		 * +N% cloak duration
		 *
		 * inverted_percentage
		 */
		val cloakConsumeRateDecreased: Double? by _attr.delegate("cloak consume rate decreased".literal())
		
		/**
		 * +N% cloak regeneration rate
		 *
		 * percentage
		 */
		val cloakRegenRateIncreased: Double? by _attr.delegate("cloak regen rate increased".literal())
		
		/**
		 * N% cloak regeneration rate
		 *
		 * percentage
		 */
		val cloakRegenRateDecreased: Double? by _attr.delegate("cloak regen rate decreased".literal())
		
	}
}

class ScoutWeaponAttributes(val _attr: IKeyValueMap) {
	/**
	 * Alt-Fire: Launches a ball that slows opponents
	 *
	 * additive
	 */
	var modBatLaunchesBalls: Int? by _attr.delegate("mod bat launches balls".literal())
	
	/**
	 * Attrib_Scattergun_NoReloadSingle
	 *
	 * unknown
	 */
	var scattergunNoReloadSingle: Boolean? by _attr.delegate("scattergun no reload single".literal())
	
	/**
	 * Knockback on the target and shooter
	 *
	 * additive
	 */
	var scattergunHasKnockback: Int? by _attr.delegate("scattergun has knockback".literal())
	
}

class SniperWeaponAttributes(val _attr: IKeyValueMap) {
	class RifleAttributes(val _attr: IKeyValueMap) {
		/**
		 * No move speed penalty from zoom
		 *
		 * additive
		 */
		val zoomSpeedModDisabled: Int? by _attr.delegate("zoom speed mod disabled".literal())
		
		/**
		 * N% faster power charge
		 *
		 * percentage
		 */
		val SRifleChargeRateIncreased: Double? by _attr.delegate("SRifle Charge rate increased".literal())
		
		/**
		 * N% slower power charge
		 *
		 * inverted_percentage
		 */
		val SRifleChargeRateDecreased: Double? by _attr.delegate("SRifle Charge rate decreased".literal())
		
		
		/**
		 * +N% charge rate
		 *
		 * percentage
		 */
		val chargeRate: Double? by _attr.delegate("sniper charge per sec".literal())
		
		/**
		 * No headshots
		 *
		 * additive
		 */
		val cannotHeadshot: Int? by _attr.delegate("sniper no headshots".literal())
		
		/**
		 * N% zoom reduction
		 *
		 * percentage
		 */
		val zoomPenalty: Double? by _attr.delegate("sniper zoom penalty".literal())
		
		/**
		 * No zoom or damage charge
		 *
		 * additive
		 */
		val cannotZoomOrCharge: Int? by _attr.delegate("sniper no charge".literal())
	}
	
	
	
	/**
	 * Blocks a single backstab attempt
	 *
	 * additive
	 */
	var backstabShield: Int? by _attr.delegate("backstab shield".literal())
	
}

class OnKillFoeAttributes(val _attr: IKeyValueMap) {
	/**
	 * On Kill: N seconds of 100% critical chance
	 *
	 * additive
	 */
	var critboostOnKill: Int? by _attr.delegate("critboost on kill".literal())
	
}

class BurningPlayerRelatedAttributes(val _attr: KeyValueMapImpl) {
	/**
	 * 100% critical hit vs burning players
	 *
	 * or
	 */
	var critVsBurningPlayers: Boolean? by _attr.delegate("crit vs burning players".literal())
	
	
	/**
	 * N% damage vs non-burning players
	 *
	 * percentage
	 */
	var dmgPenaltyVsNonburning: Double? by _attr.delegate("dmg penalty vs nonburning".literal())
	
	/**
	 * No critical hits vs non-burning players
	 *
	 * additive
	 */
	var noCritVsNonburning: Int? by _attr.delegate("no crit vs nonburning".literal())
	
}

class FlamethrowerAttributes(val _attr: IKeyValueMap) {
	/**
	 * No compression blast
	 *
	 * additive
	 */
	var modFlamethrowerPush: Int? by _attr.delegate("mod flamethrower push".literal())
	
	/**
	 * 100% critical hits from behind
	 *
	 * additive
	 */
	var modFlamethrowerBackCrit: Int? by _attr.delegate("mod flamethrower back crit".literal())
}

class AfterburnAttributes(val _attr: IKeyValueMap) {
	/**
	 * +N% afterburn damage bonus
	 *
	 * percentage
	 */
	var weaponBurnDmgIncreased: Double? by _attr.delegate("weapon burn dmg increased".literal())
	
	/**
	 * N% afterburn damage penalty
	 *
	 * percentage
	 */
	var weaponBurnDmgReduced: Double? by _attr.delegate("weapon burn dmg reduced".literal())
	
	/**
	 * +N% afterburn duration
	 *
	 * percentage
	 */
	var weaponBurnTimeIncreased: Double? by _attr.delegate("weapon burn time increased".literal())
	
	/**
	 * N% afterburn duration
	 *
	 * percentage
	 */
	var weaponBurnTimeReduced: Double? by _attr.delegate("weapon burn time reduced".literal())
}

class UnknownWeaponAttributes(val _attr: IKeyValueMap) {
	/**
	 * Attrib_AltFire_Disabled
	 *
	 * unknown
	 */
	var altFireDisabled: Any? by _attr.delegate("alt-fire disabled".literal())
}


class WarPaintsScope(private val container: IKeyValueMap)  {
	var id: Int?
		get() = container.getTyped("paintkit_proto_def_index".literal())
		set(value) = container.setNullable("paint_kit_proto_def_index".literal(), value)
	
	var wear: Wear?
		get() = container.getTyped("set_item_texture_wear".literal())
		set(value) = container.setNullable("set_item_texture_wear".literal(), value)
	
	class Wear(val id: Double) : IVDFSerializableValue<Double> {
		override val _vdfRepr: Double
			get() = id
		
		companion object {
			val FACTORY_NEW = Wear(0.2)
			//TODO
		}
	}
}


class PaintsScope(container: IKeyValueMap) {
	/**
	 * @see btpos.tf2.popfiledsl.types.PaintColors
	 */
	var color: Color? by container.delegate("item color rgb".literal(), ColorCodec) // god I hate delegates not being inlined.  This is just stupid that I'm making a billion real objects just to not reuse code
}
