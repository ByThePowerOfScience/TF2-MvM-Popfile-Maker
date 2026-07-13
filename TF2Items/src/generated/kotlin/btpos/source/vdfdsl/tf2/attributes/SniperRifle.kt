package btpos.source.vdfdsl.tf2.attributes

import btpos.source.vdfdsl.modeling.*
import btpos.source.vdfdsl.serialization.codecs.*
import btpos.source.vdfdsl.tf2.attributes.impl.*
import java.util.*

/**
 * Items: TF_WEAPON_SNIPERRIFLE, Upgradeable TF_WEAPON_SNIPERRIFLE, The Sydney Sleeper, The Machina, Festive Sniper Rifle 2011, The Hitman's Heatmaker, Silver Botkiller Sniper Rifle Mk.I, Gold Botkiller Sniper Rifle Mk.I, The AWPer Hand, Rust Botkiller Sniper Rifle Mk.I, Blood Botkiller Sniper Rifle Mk.I, Carbonado Botkiller Sniper Rifle Mk.I, Diamond Botkiller Sniper Rifle Mk.I, Silver Botkiller Sniper Rifle Mk.II, Gold Botkiller Sniper Rifle Mk.II, Shooting Star, The Bazaar Bargain, The Classic
 */
interface SniperRifleAttributes : BaseGunAttributes, IBlockScoped {
	companion object : SniperRifleAttributes
	
	/**
	 * In-Game: "No headshots"
	 *
	 * 
	 *
	 * 0: Normal.
	 *
	 * 1: Sydney Sleeper.
	 *
	 * 2: Machina.
	 *
	 * 3: Classic.
	 */
	context(attrs: IKeyValueMap)
	var cannotHeadshot: Boolean?
		get() = attrs.getTyped("sniper no headshots", NumberSelectorCodec(1))
		set(value) = attrs.setNullable("sniper no headshots", value, NumberSelectorCodec(1))
	
	/**
	 * 
	 *
	 * Note that Phlogistinator's rage has a small cooldown after expiring before it can gain rage again, to prevent the lingering crit flames from immediately filling it up again.
	 *
	 * If greater than 0, activates rage buff when pressing reload and rage meter is full (or above full).
	 */
	context(attrs: IKeyValueMap)
	override var soldierBuffType: Int?
		get() = super.soldierBuffType
		set(value) { super.soldierBuffType = value }
	
	/**
	 * 
	 *
	 * Note that Phlogistinator's rage has a small cooldown after expiring before it can gain rage again, to prevent the lingering crit flames from immediately filling it up again.
	 *
	 * If greater than 0, activates rage buff when pressing reload and rage meter is full (or above full).
	 */
	context(attrs: IKeyValueMap)
	override var demoBuffType: Int?
		get() = super.demoBuffType
		set(value) { super.demoBuffType = value }
	
	/**
	 * In-Game: "On Full Charge: +N% damage per shot"
	 *
	 * 
	 *
	 * If greater than 1.0, weapon plays cool fully-charged-Machina railgun sound when firing at full charge.
	 */
	context(attrs: IKeyValueMap)
	var fullChargeDamageBonus: Float?
		get() = attrs.getTyped("sniper full charge damage bonus")
		set(value) = attrs.setNullable("sniper full charge damage bonus", value)
	
	/**
	 * In-Game: "+N% faster reload time"
	 *
	 * 
	 *
	 * This is what's used for weapons that draw directly from reserve ammo, like the flare gun and sniper rifle.
	 *
	 * Mult to zoom and unzoom delay on clipless weapons.
	 *
	 * Fun fact: this is also affected by the Precision mannpower powerup.
	 */
	context(attrs: IKeyValueMap)
	override var fasterReloadRate: Float?
		get() = super.fasterReloadRate
		set(value) { super.fasterReloadRate = value }
	
	/**
	 * Bonus:
	 *
	 * 	- In-Game: "+N% charge rate"
	 *
	 * 
	 *
	 * Penalty:
	 *
	 * 	- In-Game: "N% slower power charge"
	 *
	 * 
	 */
	val srifleChargeRate get() = BonusPenalty<Float, Float>("sniper charge per sec", "SRifle Charge rate decreased")
	
	/**
	 * In-Game: "Cannot fire unless zoomed"
	 *
	 * 
	 */
	context(attrs: IKeyValueMap)
	var canOnlyFireWhenZoomed: Boolean?
		get() = attrs.getTyped("sniper only fire zoomed", BinaryIntCodec)
		set(value) = attrs.setNullable("sniper only fire zoomed", value, BinaryIntCodec)
	
	/**
	 * In-Game: "On Full Charge: Projectiles penetrate players"
	 *
	 * 
	 */
	context(attrs: IKeyValueMap)
	override var penetratesWhenFullyCharged: Boolean?
		get() = super.penetratesWhenFullyCharged
		set(value) { super.penetratesWhenFullyCharged = value }
	
	/**
	 * In-Game: "No headshots when not fully charged"
	 *
	 * 
	 */
	context(attrs: IKeyValueMap)
	var cannotHeadshotWithoutFullCharge: Boolean?
		get() = attrs.getTyped("sniper no headshot without full charge", BinaryIntCodec)
		set(value) = attrs.setNullable("sniper no headshot without full charge", value, BinaryIntCodec)
	
	/**
	 * In-Game: "Charge and fire shots independent of zoom"
	 *
	 * 
	 *
	 * Funnily enough, it checks if your FOV is lower than your default FOV to see if you're zoomed.
	 */
	context(attrs: IKeyValueMap)
	var canHeadshotUnscoped: Boolean?
		get() = attrs.getTyped("sniper crit no scope", BinaryIntCodec)
		set(value) = attrs.setNullable("sniper crit no scope", value, BinaryIntCodec)
	
	/**
	 * In-Game: "Increased headshot explosion radius and damage to nearby enemies"
	 *
	 * 
	 *
	 * Only applies if in a gamemode with upgrades, but applies to all headshots.
	 *
	 * Also applies to any hitscan weapon with a `jarate_time` attribute that hit the head.
	 *
	 * On attacker.
	 *
	 * Level of explosive headshot.
	 */
	context(attrs: IKeyValueMap)
	override var explosiveHeadshotLevel: Int?
		get() = super.explosiveHeadshotLevel
		set(value) { super.explosiveHeadshotLevel = value }
	
	/**
	 * In-Game: "On Scoped Hit: Apply Jarate for 2 to N seconds based on charge level. Nature's Call: Scoped headshots always mini-crits and reduce the remaining cooldown of Jarate by 1 second."
	 *
	 * 
	 *
	 * If greater than 0:.
	 *
	 * Makes weapon not eject brass.
	 *
	 * Makes weapon only penetrate non-burning teammates, as opposed to penetrating all teammates.
	 *
	 * Note: Not actually used in Sydney Sleeper Jarate calculation, as far as I could tell.
	 */
	context(attrs: IKeyValueMap)
	var jarateDuration: Int?
		get() = attrs.getTyped("jarate duration")
		set(value) = attrs.setNullable("jarate duration", value)
	
	/**
	 * In-Game: "N% movement speed on targets"
	 *
	 * 
	 *
	 * Multiplier applied to target move-speed on hit.
	 *
	 * Duration is equal to the rifle's `jarate_duration` attribute.
	 */
	context(attrs: IKeyValueMap)
	var appliesSnareEffect: Float?
		get() = attrs.getTyped("applies snare effect")
		set(value) = attrs.setNullable("applies snare effect", value)
	
	/**
	 * In-Game: "No flinching when aiming and fully charged"
	 *
	 * 
	 *
	 * Prevents flinching from damage when scoped and fully charged.
	 */
	context(attrs: IKeyValueMap)
	var aimingNoFlinch: Boolean?
		get() = attrs.getTyped("aiming no flinch", BinaryIntCodec)
		set(value) = attrs.setNullable("aiming no flinch", value, BinaryIntCodec)
}

