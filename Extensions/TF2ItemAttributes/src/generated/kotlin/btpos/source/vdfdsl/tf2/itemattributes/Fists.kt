package btpos.source.vdfdsl.tf2.itemattributes

import btpos.source.vdfdsl.modeling.*
import btpos.source.vdfdsl.serialization.codecs.*


/**
 * Items: Stock Fists, The Killing Gloves of Boxing, Warrior's Spirit, Fists of Steel, The Eviction Notice, Apoco-Fists, The Holiday Punch, The Bread Bite, Gloves of Running Urgently MvM
 */
interface FistsAttributes : btpos.source.vdfdsl.tf2.itemattributes.BaseMeleeAttributes, btpos.source.vdfdsl.tf2.itemattributes.IBlockScoped {
	companion object : FistsAttributes
	
	/**
	 * 
	 *
	 * UNIMPLEMENTED.
	 *
	 * Note that despite being present in the item schema, this is explicitly COMMENTED OUT of the code, and has no gameplay effects at least.
	 */
	context(attrs: btpos.source.vdfdsl.modeling.IKeyValueMap)
	var breadglovesProperties: Boolean?
		get() = attrs.getTyped("breadgloves properties", _root_ide_package_.btpos.source.vdfdsl.serialization.codecs.BinaryIntCodec)
		set(value) = attrs.setNullable("breadgloves properties", value, _root_ide_package_.btpos.source.vdfdsl.serialization.codecs.BinaryIntCodec)
}

