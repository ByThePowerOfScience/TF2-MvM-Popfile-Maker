package btpos.source.vdfdsl.tf2.itemattributes

import btpos.source.vdfdsl.modeling.*
import btpos.source.vdfdsl.serialization.codecs.*
import btpos.source.vdfdsl.tf2.itemattributes.impl.*
import java.util.*

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
	context(attrs: IKeyValueMap)
	var backHeadshot: Boolean?
		get() = attrs.getTyped("back headshot", BinaryIntCodec)
		set(value) = attrs.setNullable("back headshot", value, BinaryIntCodec)
}

