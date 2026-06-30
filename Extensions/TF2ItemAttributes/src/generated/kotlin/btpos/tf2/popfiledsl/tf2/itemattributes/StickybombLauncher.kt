package btpos.tf2.popfiledsl.tf2.itemattributes

import btpos.tf2.popfiledsl.modeling.*
import btpos.tf2.popfiledsl.serialization.codecs.*


/**
 * Items: TF_WEAPON_StickybombLauncher, The Scottish Resistance, Upgradeable TF_WEAPON_StickybombLauncher, Stickybomb Jumper, Festive Stickybomb Launcher 2011, Silver Botkiller Stickybomb Launcher Mk.I, Gold Botkiller Stickybomb Launcher Mk.I, Rust Botkiller Stickybomb Launcher Mk.I, Blood Botkiller Stickybomb Launcher Mk.I, Carbonado Botkiller Stickybomb Launcher Mk.I, Diamond Botkiller Stickybomb Launcher Mk.I, Silver Botkiller Stickybomb Launcher Mk.II, Gold Botkiller Stickybomb Launcher Mk.II, The Quickiebomb Launcher
 */
interface StickybombLauncherAttributes : BaseGunAttributes {
	companion object : StickybombLauncherAttributes
	
	/**
	 * In-Game: "Max charge time decreased by N%"
	 *
	 * 
	 *
	 * Not actually the "rate", rather the time it takes to fully charge a stickybomb launch when holding MOUSE1.
	 */
	context(attrs: IKeyValueMap)
	var stickybombChargeRate: Float?
		get() = attrs.getTyped("stickybomb charge rate")
		set(value) = attrs.setNullable("stickybomb charge rate", value)
	
	/**
	 * In-Game: "Able to destroy enemy stickybomb"
	 *
	 * 
	 *
	 * If true, stickies destroy other stickies.
	 */
	context(attrs: IKeyValueMap)
	var stickiesDetonateStickies: Boolean?
		get() = attrs.getTyped("stickies detonate stickies", BinaryIntCodec)
		set(value) = attrs.setNullable("stickies detonate stickies", value, BinaryIntCodec)
	
	/**
	 * In-Game: "Up to +N% damage based on charge"
	 *
	 * 
	 *
	 * damage = `2*basedamage * (this - 1.0) * currentChargeProportion`
	 */
	context(attrs: IKeyValueMap)
	var stickybombChargeDamageIncrease: Float?
		get() = attrs.getTyped("stickybomb_charge_damage_increase")
		set(value) = attrs.setNullable("stickybomb_charge_damage_increase", value)
	
	/**
	 * Bonus:
	 *
	 * 	- In-Game: "+N max stickybombs out"
	 *
	 * 
	 *
	 * Penalty:
	 *
	 * 	- In-Game: "N max stickybombs out"
	 *
	 * 
	 */
	val maxStickies get() = BonusPenalty<Int, Int>("max pipebombs increased", "max pipebombs decreased")
}

inline operator fun StickybombLauncherAttributes.invoke(scope: StickybombLauncherAttributes.() -> Unit) {
	this.apply(scope)
}

