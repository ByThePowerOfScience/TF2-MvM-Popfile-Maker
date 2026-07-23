package btpos.source.vdfdsl.tf2.itemattributes

import btpos.source.vdfdsl.modeling.*
import btpos.source.vdfdsl.serialization.codecs.*
import btpos.source.vdfdsl.tf2.itemattributes.impl.*
import java.util.*

/**
 * Items: Stickybomb Launcher + Reskins, The Scottish Resistance, Sticky Jumper, The Quickiebomb Launcher
 */
interface StickybombLauncherAttributes : BaseGunAttributes, IBlockScoped {
	companion object : StickybombLauncherAttributes
	
	/**
	 * In-Game: "Max charge time decreased by N%"
	 *
	 * 
	 *
	 * Not actually the "rate", rather the time it takes to fully charge a stickybomb launch when holding MOUSE1.
	 */
	context(attrs: IKeyValueMap)
	var stickybombChargeRate: Number?
		get() = attrs.getTyped("stickybomb charge rate")
		set(value) = attrs.setNullable("stickybomb charge rate", value)
	
	/**
	 * In-Game: "Able to destroy enemy stickybomb"
	 *
	 * 
	 *
	 * If 1, stickies destroy other stickies.
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
	 * damage = `2*basedamage * (this - 1.0) * currentChargeProportion`.
	 */
	context(attrs: IKeyValueMap)
	var stickybombChargeDamageIncrease: Number?
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

