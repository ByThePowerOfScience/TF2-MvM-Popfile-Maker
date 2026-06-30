package btpos.source.vdfdsl.tf2.itemattributes

import btpos.source.vdfdsl.modeling.*
import btpos.source.vdfdsl.serialization.codecs.*


/**
 * Items: The Shortstop, The Winger, Pretty Boy's Pocket Pistol
 */
interface ScoutPistolAttributes : btpos.source.vdfdsl.tf2.itemattributes.PistolAttributes, btpos.source.vdfdsl.tf2.itemattributes.IBlockScoped {
	companion object : ScoutPistolAttributes
	
	/**
	 * 
	 *
	 * If true, can headshot.
	 */
	context(attrs: btpos.source.vdfdsl.modeling.IKeyValueMap)
	var backHeadshot: Boolean?
		get() = attrs.getTyped("back headshot", _root_ide_package_.btpos.source.vdfdsl.serialization.codecs.BinaryIntCodec)
		set(value) = attrs.setNullable("back headshot", value, _root_ide_package_.btpos.source.vdfdsl.serialization.codecs.BinaryIntCodec)
}

