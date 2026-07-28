package btpos.source.vdfdsl.tf2.itemattributes

import btpos.source.vdfdsl.modeling.*
import btpos.source.vdfdsl.serialization.codecs.*
import btpos.source.vdfdsl.tf2.itemattributes.impl.*
import btpos.source.vdfdsl.tf2.tftypes.*
import java.util.*



/**
 * Items: Stock Knife + Reskins, Your Eternal Reward, Conniver's Kunai, The Big Earner, The Wanga Prick, The Sharp Dresser, The Spy-cicle
 */
interface KnifeAttributes : IBlockScoped {
	companion object {
		/**
		 * 
		 *
		 * 0: Stock.
		 *
		 * 1: Your Eternal Reward.
		 *
		 * 2: Cloak and Dagger (idk why).
		 *
		 * 3: Spycicle.
		 */
		val setIcicleKnifeMode = ItemAttributeNamed<Boolean>("set icicle knife mode", NumberSelectorCodec(3))
		
		/**
		 * In-Game: "Melts in fire, regenerates in N seconds and by picking up ammo"
		 *
		 * 
		 */
		val meltsInFire = ItemAttributeNamed<Boolean>("melts in fire")
		
		/**
		 * In-Game: "Upon a successful backstab against a human target, you rapidly disguise as your victim"
		 *
		 * 
		 */
		val disguiseOnBackstab = ItemAttributeNamed<Boolean>("disguise on backstab")
		
		/**
		 * Bonus:
		 *
		 * 	- Visible:
		 *
		 * 		- In-Game: "+N% damage bonus"
		 *
		 * 	- Hidden:
		 *
		 * 		- In-Game: "+N% damage bonus"
		 *
		 * 
		 *
		 * Penalty:
		 *
		 * 	- In-Game: "N% damage penalty"
		 *
		 * 
		 *
		 * Base backstab damage against minibosses is 250 * this proportion.
		 */
		val damage = BonusPenalty(
			VisHidden("ItemAttributeNamed<Float>("damage bonus")", "ItemAttributeNamed<Float>("damage bonus HIDDEN")"),
			ItemAttributeNamed<Float>("damage penalty")
		)
		
		/**
		 * In-Game: "Increase backstab damage against Giant Robots by N%"
		 *
		 * 
		 *
		 * Spy only does 25% damage against minibosses by default.  The number here is added to that percentage, up to a max of 100% + 25% = 125%.
		 *
		 * Note that this is an actual PERCENTAGE of armor penetrated, not a proportion:  `25.0`, `50.0`, up to `100.0`.
		 *
		 * Also, with max armor penetration, you apparently do 25% *more* damage against minibosses than you do against regular bots.
		 *
		 * Checked on player.
		 */
		val armorPiercing = ItemAttributeNamed<Float>("armor piercing")
		
		/**
		 * In-Game: "On Backstab: Absorbs the health from your victim."
		 *
		 * 
		 *
		 * Gain health on backstab. (Conniver's Kunai).
		 */
		val gainHealthOnBackstab = ItemAttributeNamed<Boolean>("sanguisuge")
	}

	/**
	 * 
	 *
	 * 0: Stock.
	 *
	 * 1: Your Eternal Reward.
	 *
	 * 2: Cloak and Dagger (idk why).
	 *
	 * 3: Spycicle.
	 */
	val setIcicleKnifeMode: ItemAttribute<Boolean> get() = KnifeAttributes.setIcicleKnifeMode
	
	/**
	 * In-Game: "Melts in fire, regenerates in N seconds and by picking up ammo"
	 *
	 * 
	 */
	val meltsInFire: ItemAttribute<Boolean> get() = KnifeAttributes.meltsInFire
	
	/**
	 * In-Game: "Upon a successful backstab against a human target, you rapidly disguise as your victim"
	 *
	 * 
	 */
	val disguiseOnBackstab: ItemAttribute<Boolean> get() = KnifeAttributes.disguiseOnBackstab
	
	/**
	 * Bonus:
	 *
	 * 	- Visible:
	 *
	 * 		- In-Game: "+N% damage bonus"
	 *
	 * 	- Hidden:
	 *
	 * 		- In-Game: "+N% damage bonus"
	 *
	 * 
	 *
	 * Penalty:
	 *
	 * 	- In-Game: "N% damage penalty"
	 *
	 * 
	 *
	 * Base backstab damage against minibosses is 250 * this proportion.
	 */
	val damage: ItemAttribute<Float> get() = KnifeAttributes.damage
	
	/**
	 * In-Game: "Increase backstab damage against Giant Robots by N%"
	 *
	 * 
	 *
	 * Spy only does 25% damage against minibosses by default.  The number here is added to that percentage, up to a max of 100% + 25% = 125%.
	 *
	 * Note that this is an actual PERCENTAGE of armor penetrated, not a proportion:  `25.0`, `50.0`, up to `100.0`.
	 *
	 * Also, with max armor penetration, you apparently do 25% *more* damage against minibosses than you do against regular bots.
	 *
	 * Checked on player.
	 */
	val armorPiercing: ItemAttribute<Float> get() = KnifeAttributes.armorPiercing
	
	/**
	 * In-Game: "On Backstab: Absorbs the health from your victim."
	 *
	 * 
	 *
	 * Gain health on backstab. (Conniver's Kunai).
	 */
	val gainHealthOnBackstab: ItemAttribute<Boolean> get() = KnifeAttributes.gainHealthOnBackstab

   
}

