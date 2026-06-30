package btpos.tf2.popfiledsl.tf2.itemattributes

import btpos.tf2.popfiledsl.modeling.*
import btpos.tf2.popfiledsl.serialization.codecs.*


/**
 * Items: Stock Fists, The Killing Gloves of Boxing, Warrior's Spirit, Fists of Steel, The Eviction Notice, Apoco-Fists, The Holiday Punch, The Bread Bite, Gloves of Running Urgently MvM
 */
interface FistsAttributes : BaseMeleeAttributes {
	companion object : FistsAttributes
	
	/**
	 * In-Game: "On Kill: +50 health on nearby teammates On Kill: +10% Crit Chance on nearby teammates"
	 *
	 * 
	 *
	 * Used to specify "fist type"
	 */
	context(attrs: IKeyValueMap)
	var fistsHaveRadialBuff: Boolean?
		get() = attrs.getTyped("fists have radial buff", NumberSelectorCodec(1))
		set(value) = attrs.setNullable("fists have radial buff", value, NumberSelectorCodec(1))
	
	/**
	 * 
	 *
	 * UNIMPLEMENTED
	 *
	 * Note that despite being present in the item schema, this is explicitly COMMENTED OUT of the code, and has no gameplay effects at least.
	 */
	context(attrs: IKeyValueMap)
	var breadglovesProperties: Boolean?
		get() = attrs.getTyped("breadgloves properties", BinaryIntCodec)
		set(value) = attrs.setNullable("breadgloves properties", value, BinaryIntCodec)
}

inline operator fun FistsAttributes.invoke(scope: FistsAttributes.() -> Unit) {
	this.apply(scope)
}

