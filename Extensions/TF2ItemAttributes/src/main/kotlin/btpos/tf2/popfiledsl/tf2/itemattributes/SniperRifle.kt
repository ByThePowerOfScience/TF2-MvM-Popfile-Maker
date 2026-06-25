package btpos.tf2.popfiledsl.tf2.itemattributes

import btpos.tf2.popfiledsl.modeling.*
import btpos.tf2.popfiledsl.serialization.codecs.*


/**
 * Items: TF_WEAPON_SNIPERRIFLE, Upgradeable TF_WEAPON_SNIPERRIFLE, The Sydney Sleeper, The Machina, Festive Sniper Rifle 2011, The Hitman's Heatmaker, Silver Botkiller Sniper Rifle Mk.I, Gold Botkiller Sniper Rifle Mk.I, The AWPer Hand, Rust Botkiller Sniper Rifle Mk.I, Blood Botkiller Sniper Rifle Mk.I, Carbonado Botkiller Sniper Rifle Mk.I, Diamond Botkiller Sniper Rifle Mk.I, Silver Botkiller Sniper Rifle Mk.II, Gold Botkiller Sniper Rifle Mk.II, Shooting Star, The Bazaar Bargain, The Classic
 * 
 */
abstract class SniperRifleAttributes : BaseGunAttributes() {
	companion object : SniperRifleAttributes() {
		operator fun invoke(scope: SniperRifleAttributes.Companion.() -> Unit) {
			this.apply(scope)
		}
	}
	
	/**
	 * If greater than 0, activates rage buff when pressing reload and rage meter is full (or above full).
	 */
	context(attrs: IKeyValueMap)
	var modSoldierBuffType: Int?
		get() = attrs.getTyped("mod soldier buff type")
		set(value) = attrs.setNullable("mod soldier buff type", value)
	
	/**
	 * Value type: percentage
	 * 
	 * If greater than 1.0, weapon plays cool fully-charged-Machina railgun sound when firing at full charge.
	 */
	context(attrs: IKeyValueMap)
	var sniperFullChargeDamageBonus: Float?
		get() = attrs.getTyped("sniper full charge damage bonus")
		set(value) = attrs.setNullable("sniper full charge damage bonus", value)
	
	/**
	 * Value type: inverted_percentage
	 * 
	 * This is what's used for weapons that draw directly from reserve ammo, like the flare gun and sniper rifle.
	 * 
	 * Value type: inverted_percentage
	 * 
	 * Mult to zoom and unzoom delay on clipless weapons
	 * Fun fact: this is also affected by the Precision mannpower powerup
	 */
	override context(attrs: IKeyValueMap)
	var fasterReloadRate: Float?
		get() = attrs.getTyped("faster reload rate")
		set(value) = attrs.setNullable("faster reload rate", value)
	
	/**
	 * 
	 * Bonus:
	 * 	Value type: percentage
	 * 	
	 * 
	 * Penalty:
	 * 	Value type: inverted_percentage
	 * 	
	 */
	val SRifleChargeRateDecreased = BonusPenalty<Float, Float>("sniper charge per sec", "SRifle Charge rate decreased")
	
	
	context(attrs: IKeyValueMap)
	var sniperOnlyFireZoomed: Boolean?
		get() = attrs.getTyped("sniper only fire zoomed", BinaryIntCodec)
		set(value) = attrs.setNullable("sniper only fire zoomed", value, BinaryIntCodec)
	
	
	context(attrs: IKeyValueMap)
	var sniperPenetratePlayersWhenCharged: Boolean?
		get() = attrs.getTyped("sniper penetrate players when charged", BinaryIntCodec)
		set(value) = attrs.setNullable("sniper penetrate players when charged", value, BinaryIntCodec)
	
	
	context(attrs: IKeyValueMap)
	var sniperNoHeadshotWithoutFullCharge: Boolean?
		get() = attrs.getTyped("sniper no headshot without full charge", BinaryIntCodec)
		set(value) = attrs.setNullable("sniper no headshot without full charge", value, BinaryIntCodec)
	
	/**
	 * Funnily enough, it checks if your FOV is lower than your default FOV to see if you're zoomed.
	 */
	context(attrs: IKeyValueMap)
	var sniperCritNoScope: Boolean?
		get() = attrs.getTyped("sniper crit no scope", BinaryIntCodec)
		set(value) = attrs.setNullable("sniper crit no scope", value, BinaryIntCodec)
	
	/**
	 * On attacker
	 * Level of explosive headshot
	 */
	context(attrs: IKeyValueMap)
	var explosiveSniperShot: Int?
		get() = attrs.getTyped("explosive sniper shot")
		set(value) = attrs.setNullable("explosive sniper shot", value)
	
	/**
	 * If greater than 0:
	 * Makes weapon not eject brass
	 * Makes weapon only penetrate non-burning teammates, as opposed to penetrating all teammates
	 * Note: Not actually used in Sydney Sleeper Jarate calculation, as far as I could tell.
	 */
	context(attrs: IKeyValueMap)
	var jarateDuration: Int?
		get() = attrs.getTyped("jarate duration")
		set(value) = attrs.setNullable("jarate duration", value)
}

