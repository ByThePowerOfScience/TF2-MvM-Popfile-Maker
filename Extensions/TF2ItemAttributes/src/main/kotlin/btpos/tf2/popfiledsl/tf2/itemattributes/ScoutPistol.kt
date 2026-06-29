package btpos.tf2.popfiledsl.tf2.itemattributes

import btpos.tf2.popfiledsl.modeling.*
import btpos.tf2.popfiledsl.serialization.codecs.*


/**
 * Items: The Shortstop, The Winger, Pretty Boy's Pocket Pistol
 * 
 */
interface ScoutPistolAttributes : PistolAttributes {
	companion object : ScoutPistolAttributes
	
	/**
	 * If true, can headshot
	 * 
	 */
	context(attrs: IKeyValueMap)
	var backHeadshot: Boolean?
		get() = attrs.getTyped("back headshot", BinaryIntCodec)
		set(value) = attrs.setNullable("back headshot", value, BinaryIntCodec)
}

inline operator fun ScoutPistolAttributes.invoke(scope: ScoutPistolAttributes.() -> Unit) {
	this.apply(scope)
}

