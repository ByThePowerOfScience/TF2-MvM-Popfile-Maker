package btpos.source.vdfdsl.tf2.itemattributes

import btpos.source.vdfdsl.serialization.codecs.BinaryIntCodec
import btpos.source.vdfdsl.serialization.codecs.NumberSelectorCodec
import btpos.source.vdfdsl.tf2.itemattributes.impl.BonusPenalty
import btpos.source.vdfdsl.tf2.itemattributes.impl.IBlockScoped


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
	context(attrs: btpos.source.vdfdsl.modeling.IKeyValueMap)
	var cannotHeadshot: Boolean?
		get() = attrs.getTyped("sniper no headshots", NumberSelectorCodec(1))
		set(value) = attrs.setNullable("sniper no headshots", value, NumberSelectorCodec(1))
	
	/**
	 * 
	 *
	 * If greater than 0, activates rage buff when pressing reload and rage meter is full (or above full).
	 */
	context(attrs: btpos.source.vdfdsl.modeling.IKeyValueMap)
	var soldierBuffType: Int?
		get() = attrs.getTyped("mod soldier buff type")
		set(value) = attrs.setNullable("mod soldier buff type", value)
	
	/**
	 * 
	 *
	 * If greater than 0, activates rage buff when pressing reload and rage meter is full (or above full).
	 */
	context(attrs: btpos.source.vdfdsl.modeling.IKeyValueMap)
	var demoBuffType: Int?
		get() = attrs.getTyped("mod demo buff type")
		set(value) = attrs.setNullable("mod demo buff type", value)
	
	/**
	 * In-Game: "On Full Charge: +N% damage per shot"
	 *
	 * 
	 *
	 * If greater than 1.0, weapon plays cool fully-charged-Machina railgun sound when firing at full charge.
	 */
	context(attrs: btpos.source.vdfdsl.modeling.IKeyValueMap)
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
	context(attrs: btpos.source.vdfdsl.modeling.IKeyValueMap)
	override var fasterReloadRate: Float?
		get() = super.fasterReloadRate
		set(value) {
			super.fasterReloadRate = value
		}
	
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
	context(attrs: btpos.source.vdfdsl.modeling.IKeyValueMap)
	var canOnlyFireWhenZoomed: Boolean?
		get() = attrs.getTyped("sniper only fire zoomed", BinaryIntCodec)
		set(value) = attrs.setNullable("sniper only fire zoomed", value, BinaryIntCodec)
	
	/**
	 * In-Game: "On Full Charge: Projectiles penetrate players"
	 *
	 * 
	 */
	context(attrs: btpos.source.vdfdsl.modeling.IKeyValueMap)
	var penetratesWhenFullyCharged: Boolean?
		get() = attrs.getTyped("sniper penetrate players when charged", BinaryIntCodec)
		set(value) = attrs.setNullable("sniper penetrate players when charged", value, BinaryIntCodec)
	
	/**
	 * In-Game: "No headshots when not fully charged"
	 *
	 * 
	 */
	context(attrs: btpos.source.vdfdsl.modeling.IKeyValueMap)
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
	context(attrs: btpos.source.vdfdsl.modeling.IKeyValueMap)
	var canHeadshotUnscoped: Boolean?
		get() = attrs.getTyped("sniper crit no scope", BinaryIntCodec)
		set(value) = attrs.setNullable("sniper crit no scope", value, BinaryIntCodec)
	
	/**
	 * In-Game: "Increased headshot explosion radius and damage to nearby enemies"
	 *
	 * 
	 *
	 * On attacker.
	 *
	 * Level of explosive headshot.
	 */
	context(attrs: btpos.source.vdfdsl.modeling.IKeyValueMap)
	var explosiveHeadshotLevel: Int?
		get() = attrs.getTyped("explosive sniper shot")
		set(value) = attrs.setNullable("explosive sniper shot", value)
	
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
	context(attrs: btpos.source.vdfdsl.modeling.IKeyValueMap)
	var jarateDuration: Int?
		get() = attrs.getTyped("jarate duration")
		set(value) = attrs.setNullable("jarate duration", value)
}

