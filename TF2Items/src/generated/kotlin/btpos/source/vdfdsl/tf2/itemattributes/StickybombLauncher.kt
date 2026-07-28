package btpos.source.vdfdsl.tf2.itemattributes

import btpos.source.vdfdsl.modeling.*
import btpos.source.vdfdsl.serialization.codecs.*
import btpos.source.vdfdsl.tf2.itemattributes.impl.*
import btpos.source.vdfdsl.tf2.tftypes.*
import java.util.*



/**
 * Items: Stickybomb Launcher + Reskins, The Scottish Resistance, Sticky Jumper, The Quickiebomb Launcher
 */
interface StickybombLauncherAttributes : IBlockScoped {
	companion object {
		/**
		 * In-Game: "Max charge time decreased by N%"
		 *
		 * 
		 *
		 * Not actually the "rate", rather the time it takes to fully charge a stickybomb launch when holding MOUSE1.
		 */
		val stickybombChargeRate = ItemAttributeNamed<Float>("stickybomb charge rate")
		
		/**
		 * In-Game: "Able to destroy enemy stickybomb"
		 *
		 * 
		 *
		 * If 1, stickies destroy other stickies.
		 */
		val stickiesDetonateStickies = ItemAttributeNamed<Boolean>("stickies detonate stickies")
		
		/**
		 * In-Game: "Up to +N% damage based on charge"
		 *
		 * 
		 *
		 * damage = `2*basedamage * (this - 1.0) * currentChargeProportion`.
		 */
		val stickybombChargeDamageIncrease = ItemAttributeNamed<Float>("stickybomb_charge_damage_increase")
		
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
		val maxStickies = BonusPenalty(
			ItemAttributeNamed<Int>("max pipebombs increased"),
			ItemAttributeNamed<Int>("max pipebombs decreased")
		)
	}

	/**
	 * In-Game: "Max charge time decreased by N%"
	 *
	 * 
	 *
	 * Not actually the "rate", rather the time it takes to fully charge a stickybomb launch when holding MOUSE1.
	 */
	val stickybombChargeRate: ItemAttribute<Float> get() = StickybombLauncherAttributes.stickybombChargeRate
	
	/**
	 * In-Game: "Able to destroy enemy stickybomb"
	 *
	 * 
	 *
	 * If 1, stickies destroy other stickies.
	 */
	val stickiesDetonateStickies: ItemAttribute<Boolean> get() = StickybombLauncherAttributes.stickiesDetonateStickies
	
	/**
	 * In-Game: "Up to +N% damage based on charge"
	 *
	 * 
	 *
	 * damage = `2*basedamage * (this - 1.0) * currentChargeProportion`.
	 */
	val stickybombChargeDamageIncrease: ItemAttribute<Float> get() = StickybombLauncherAttributes.stickybombChargeDamageIncrease
	
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
	val maxStickies: ItemAttribute<Int> get() = StickybombLauncherAttributes.maxStickies

   
}

