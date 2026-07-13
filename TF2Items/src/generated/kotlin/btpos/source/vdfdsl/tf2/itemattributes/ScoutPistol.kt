package btpos.source.vdfdsl.tf2.itemattributes

import btpos.source.vdfdsl.serialization.codecs.BinaryIntCodec
import btpos.source.vdfdsl.tf2.attributes.impl.IBlockScoped


/**
 * Items: The Shortstop, The Winger, Pretty Boy's Pocket Pistol
 */
interface ScoutPistolAttributes : PistolAttributes, IBlockScoped {
	companion object : ScoutPistolAttributes
	
	/**
	 * 
	 *
	 * If true, can headshot.
	 */
	context(attrs: btpos.source.vdfdsl.modeling.IKeyValueMap)
	var backHeadshot: Boolean?
		get() = attrs.getTyped("back headshot", BinaryIntCodec)
		set(value) = attrs.setNullable("back headshot", value, BinaryIntCodec)
}

