package btpos.tf2.popfiledsl.tf2.itemattributes

import btpos.tf2.popfiledsl.modeling.*
import btpos.tf2.popfiledsl.serialization.codecs.*


/**
 * Items: TF_WEAPON_PIPEBOMBLAUNCHER, The Scottish Resistance, Upgradeable TF_WEAPON_PIPEBOMBLAUNCHER, Stickybomb Jumper, Festive Stickybomb Launcher 2011, Silver Botkiller Stickybomb Launcher Mk.I, Gold Botkiller Stickybomb Launcher Mk.I, Rust Botkiller Stickybomb Launcher Mk.I, Blood Botkiller Stickybomb Launcher Mk.I, Carbonado Botkiller Stickybomb Launcher Mk.I, Diamond Botkiller Stickybomb Launcher Mk.I, Silver Botkiller Stickybomb Launcher Mk.II, Gold Botkiller Stickybomb Launcher Mk.II, The Quickiebomb Launcher
 * 
 */
abstract class PipebombLauncherAttributes : BaseGunAttributes() {
	companion object : PipebombLauncherAttributes() {
		operator fun invoke(scope: PipebombLauncherAttributes.Companion.() -> Unit) {
			this.apply(scope)
		}
	}
	
	/**
	 * Value type: inverted_percentage
	 * 
	 * Not actually the "rate", rather the time it takes to fully charge a stickybomb launch when holding MOUSE1.
	 */
	context(attrs: IKeyValueMap)
	var stickybombChargeRate: Float?
		get() = attrs.getTyped("stickybomb charge rate")
		set(value) = attrs.setNullable("stickybomb charge rate", value)
	
	/**
	 * If 0, default "detonate all stickies on rclick" mode. If true, uses Scottish Resistance's "look at sticky to detonate" mechanic.
	 * 
	 * Bonus:
	 * 
	 * Penalty:
	 */
	val stickyAirBurstMode = BonusPenalty<Int, Int>("sticky detonate mode", "sticky air burst mode")
	
	/**
	 * If true, stickies destroy other stickies.
	 */
	context(attrs: IKeyValueMap)
	var stickiesDetonateStickies: Boolean?
		get() = attrs.getTyped("stickies detonate stickies", BinaryIntCodec)
		set(value) = attrs.setNullable("stickies detonate stickies", value, BinaryIntCodec)
	
	/**
	 * Value type: percentage
	 * 
	 * damage = `2*basedamage * (this - 1.0) * currentChargeProportion`
	 */
	context(attrs: IKeyValueMap)
	var stickybombChargeDamageIncrease: Float?
		get() = attrs.getTyped("stickybomb_charge_damage_increase")
		set(value) = attrs.setNullable("stickybomb_charge_damage_increase", value)
	
	/**
	 * 
	 * Bonus:
	 * 
	 * Penalty:
	 */
	val maxPipebombsDecreased = BonusPenalty<Int, Int>("max pipebombs increased", "max pipebombs decreased")
}

