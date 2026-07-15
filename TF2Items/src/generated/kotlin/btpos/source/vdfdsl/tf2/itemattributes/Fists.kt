package btpos.source.vdfdsl.tf2.itemattributes

import btpos.source.vdfdsl.modeling.*
import btpos.source.vdfdsl.serialization.codecs.*
import btpos.source.vdfdsl.tf2.itemattributes.impl.*
import java.util.*

/**
 * Items: Stock Fists, The Killing Gloves of Boxing, Warrior's Spirit, Fists of Steel, The Eviction Notice, Apoco-Fists, The Holiday Punch, The Bread Bite, Gloves of Running Urgently MvM
 */
interface FistsAttributes : BaseMeleeAttributes, IBlockScoped {
	companion object : FistsAttributes
	
	/**
	 * 
	 *
	 * UNIMPLEMENTED.
	 *
	 * Note that despite being present in the item schema, this is explicitly COMMENTED OUT of the code, and has no gameplay effects at least.
	 */
	context(attrs: IKeyValueMap)
	var breadglovesProperties: Boolean?
		get() = attrs.getTyped("breadgloves properties", BinaryIntCodec)
		set(value) = attrs.setNullable("breadgloves properties", value, BinaryIntCodec)
}

