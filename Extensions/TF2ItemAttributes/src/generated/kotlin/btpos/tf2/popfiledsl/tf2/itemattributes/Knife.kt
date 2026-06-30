package btpos.tf2.popfiledsl.tf2.itemattributes

import btpos.tf2.popfiledsl.modeling.*
import btpos.tf2.popfiledsl.serialization.codecs.*


/**
 * Items: TF_WEAPON_KNIFE, Upgradeable TF_WEAPON_KNIFE, Your Eternal Reward, Conniver's Kunai, The Big Earner, The Wanga Prick, The Sharp Dresser, The Spy-cicle, Festive Knife 2011, The Black Rose, Stock Botkiller Knives
 */
interface KnifeAttributes : BaseMeleeAttributes {
	companion object : KnifeAttributes
	
	/**
	 * 
	 *
	 * 0: Stock
	 *
	 * 1: Your Eternal Reward
	 *
	 * 2: Cloak and Dagger (idk why)
	 *
	 * 3: Spycicle
	 */
	context(attrs: IKeyValueMap)
	var setIcicleKnifeMode: Boolean?
		get() = attrs.getTyped("set icicle knife mode", NumberSelectorCodec(3))
		set(value) = attrs.setNullable("set icicle knife mode", value, NumberSelectorCodec(3))
	
	/**
	 * In-Game: "Melts in fire, regenerates in N seconds and by picking up ammo"
	 *
	 * 
	 */
	context(attrs: IKeyValueMap)
	var meltsInFire: Boolean?
		get() = attrs.getTyped("melts in fire", BinaryIntCodec)
		set(value) = attrs.setNullable("melts in fire", value, BinaryIntCodec)
	
	/**
	 * In-Game: "Upon a successful backstab against a human target, you rapidly disguise as your victim"
	 *
	 * 
	 */
	context(attrs: IKeyValueMap)
	var disguiseOnBackstab: Boolean?
		get() = attrs.getTyped("disguise on backstab", BinaryIntCodec)
		set(value) = attrs.setNullable("disguise on backstab", value, BinaryIntCodec)
	
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
	override val damage get() = super.damage
	
	/**
	 * In-Game: "Increase backstab damage against Giant Robots by N%"
	 *
	 * 
	 *
	 * On player
	 *
	 * Spy only does 25% damage against minibosses by default.  The number here is added to that percentage, up to a max of 100% + 25% = 125%
	 *
	 * Note that this is an actual PERCENTAGE of armor penetrated, not a proportion:  `25.0`, `50.0`, up to `100.0`.
	 *
	 * Also, with max armor penetration, you apparently do 25% *more* damage against minibosses than you do against regular bots.
	 */
	context(attrs: IKeyValueMap)
	var armorPiercing: Int?
		get() = attrs.getTyped("armor piercing")
		set(value) = attrs.setNullable("armor piercing", value)
	
	/**
	 * In-Game: "On Backstab: Absorbs the health from your victim."
	 *
	 * 
	 *
	 * Gain health on backstab. (Kunai)
	 */
	context(attrs: IKeyValueMap)
	var gainHealthOnBackstab: Boolean?
		get() = attrs.getTyped("sanguisuge", BinaryIntCodec)
		set(value) = attrs.setNullable("sanguisuge", value, BinaryIntCodec)
}

inline operator fun KnifeAttributes.invoke(scope: KnifeAttributes.() -> Unit) {
	this.apply(scope)
}

