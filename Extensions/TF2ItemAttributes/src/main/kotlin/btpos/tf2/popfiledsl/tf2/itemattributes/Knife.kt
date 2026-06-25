package btpos.tf2.popfiledsl.tf2.itemattributes

import btpos.tf2.popfiledsl.modeling.*
import btpos.tf2.popfiledsl.serialization.codecs.*


/**
 * Items: TF_WEAPON_KNIFE, Upgradeable TF_WEAPON_KNIFE, Your Eternal Reward, Conniver's Kunai, The Big Earner, The Wanga Prick, The Sharp Dresser, The Spy-cicle, Festive Knife 2011, The Black Rose, Stock Botkiller Knives
 * 
 */
abstract class KnifeAttributes : BaseMeleeAttributes() {
	companion object : KnifeAttributes() {
		operator fun invoke(scope: KnifeAttributes.Companion.() -> Unit) {
			this.apply(scope)
		}
	}
	
	
	context(attrs: IKeyValueMap)
	var meltsInFire: Boolean?
		get() = attrs.getTyped("melts in fire", BinaryIntCodec)
		set(value) = attrs.setNullable("melts in fire", value, BinaryIntCodec)
	
	
	context(attrs: IKeyValueMap)
	var disguiseOnBackstab: Boolean?
		get() = attrs.getTyped("disguise on backstab", BinaryIntCodec)
		set(value) = attrs.setNullable("disguise on backstab", value, BinaryIntCodec)
	
	/**
	 * 
	 * Bonus:
	 * 	Visible:
	 * 		Value type: percentage
	 * 		
	 * 		+N% damage bonus
	 * 		
	 * 	
	 * 	Hidden:
	 * 		Value type: percentage
	 * 		
	 * 		+N% damage bonus
	 * 		
	 * 
	 * Penalty:
	 * 	Value type: percentage
	 * 	
	 * 
	 * Base backstab damage against minibosses is 250 * this proportion.
	 * 
	 * Bonus:
	 * 	Visible:
	 * 		Value type: percentage
	 * 		
	 * 		+N% damage bonus
	 * 		
	 * 	
	 * 	Hidden:
	 * 		Value type: percentage
	 * 		
	 * 		+N% damage bonus
	 * 		
	 * 
	 * Penalty:
	 * 	Value type: percentage
	 * 	
	 */
	override val damagePenalty = BonusPenalty_BonusNested<VisHidden<Float, Float>, Float>(VisHidden<Float, Float>("damage bonus", "damage bonus HIDDEN"), "damage penalty")
	
	/**
	 * On player
	 * Spy only does 25% damage against minibosses by default.  The number here is added to that percentage, up to a max of 100% + 25% = 125%
	 * Note that this is an actual PERCENTAGE of armor penetrated, not a proportion:  `25.0`, `50.0`, up to `100.0`.
	 * Also, with max armor penetration, you apparently do 25% *more* damage against minibosses than you do against regular bots.
	 */
	context(attrs: IKeyValueMap)
	var armorPiercing: Int?
		get() = attrs.getTyped("armor piercing")
		set(value) = attrs.setNullable("armor piercing", value)
	
	/**
	 * Gain health on backstab. (Kunai)
	 */
	context(attrs: IKeyValueMap)
	var sanguisuge: Boolean?
		get() = attrs.getTyped("sanguisuge", BinaryIntCodec)
		set(value) = attrs.setNullable("sanguisuge", value, BinaryIntCodec)
}

