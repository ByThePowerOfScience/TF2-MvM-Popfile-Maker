package btpos.source.vdfdsl.tf2.itemattributes

import btpos.source.vdfdsl.modeling.*
import btpos.source.vdfdsl.serialization.codecs.*


/**
 * Items: TF_WEAPON_KNIFE, Upgradeable TF_WEAPON_KNIFE, Your Eternal Reward, Conniver's Kunai, The Big Earner, The Wanga Prick, The Sharp Dresser, The Spy-cicle, Festive Knife 2011, The Black Rose, Stock Botkiller Knives
 */
interface KnifeAttributes : btpos.source.vdfdsl.tf2.itemattributes.BaseMeleeAttributes, btpos.source.vdfdsl.tf2.itemattributes.IBlockScoped {
	companion object : KnifeAttributes
	
	/**
	 * 
	 *
	 * 0: Stock.
	 *
	 * 1: Your Eternal Reward.
	 *
	 * 2: Cloak and Dagger (UNCHECKED).
	 *
	 * 3: Spycicle.
	 *
	 * The 'Your Eternal Reward' setting is used by sentries to not target spies after a stab, and the 'Spycicle' setting is used to display the recharge meter.
	 */
	context(attrs: btpos.source.vdfdsl.modeling.IKeyValueMap)
	var setIcicleKnifeMode: Boolean?
		get() = attrs.getTyped("set icicle knife mode", _root_ide_package_.btpos.source.vdfdsl.serialization.codecs.NumberSelectorCodec(3))
		set(value) = attrs.setNullable("set icicle knife mode", value, _root_ide_package_.btpos.source.vdfdsl.serialization.codecs.NumberSelectorCodec(3))
	
	/**
	 * In-Game: "Melts in fire, regenerates in N seconds and by picking up ammo"
	 *
	 * 
	 */
	context(attrs: btpos.source.vdfdsl.modeling.IKeyValueMap)
	var meltsInFire: Boolean?
		get() = attrs.getTyped("melts in fire", _root_ide_package_.btpos.source.vdfdsl.serialization.codecs.BinaryIntCodec)
		set(value) = attrs.setNullable("melts in fire", value, _root_ide_package_.btpos.source.vdfdsl.serialization.codecs.BinaryIntCodec)
	
	/**
	 * In-Game: "Upon a successful backstab against a human target, you rapidly disguise as your victim"
	 *
	 * 
	 */
	context(attrs: btpos.source.vdfdsl.modeling.IKeyValueMap)
	var disguiseOnBackstab: Boolean?
		get() = attrs.getTyped("disguise on backstab", _root_ide_package_.btpos.source.vdfdsl.serialization.codecs.BinaryIntCodec)
		set(value) = attrs.setNullable("disguise on backstab", value, _root_ide_package_.btpos.source.vdfdsl.serialization.codecs.BinaryIntCodec)
	
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
	 * Base backstab damage against minibosses is `250 * <this proportion>`.
	 */
	override val damage get() = super.damage
	
	/**
	 * In-Game: "Increase backstab damage against Giant Robots by N%"
	 *
	 * 
	 *
	 * On player.
	 *
	 * Spy only does 25% damage against minibosses by default.  The number here is added to that percentage, up to a max of 100% + 25% = 125%.
	 *
	 * Note that this is an actual PERCENTAGE of armor penetrated, not a proportion:  `25.0`, `50.0`, up to `100.0`.
	 *
	 * Also, with max armor penetration, you apparently do 25% *more* damage against minibosses than you do against regular bots.
	 */
	context(attrs: btpos.source.vdfdsl.modeling.IKeyValueMap)
	var armorPiercing: Int?
		get() = attrs.getTyped("armor piercing")
		set(value) = attrs.setNullable("armor piercing", value)
	
	/**
	 * In-Game: "On Backstab: Absorbs the health from your victim."
	 *
	 * 
	 *
	 * Gain health on backstab. (Kunai).
	 */
	context(attrs: btpos.source.vdfdsl.modeling.IKeyValueMap)
	var gainHealthOnBackstab: Boolean?
		get() = attrs.getTyped("sanguisuge", _root_ide_package_.btpos.source.vdfdsl.serialization.codecs.BinaryIntCodec)
		set(value) = attrs.setNullable("sanguisuge", value, _root_ide_package_.btpos.source.vdfdsl.serialization.codecs.BinaryIntCodec)
}

