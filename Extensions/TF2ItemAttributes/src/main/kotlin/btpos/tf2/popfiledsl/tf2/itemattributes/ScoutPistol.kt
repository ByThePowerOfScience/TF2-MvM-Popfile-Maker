package btpos.tf2.popfiledsl.tf2.itemattributes

import btpos.tf2.popfiledsl.modeling.*
import btpos.tf2.popfiledsl.serialization.codecs.*


/**
 * Items: The Shortstop, The Winger, Pretty Boy's Pocket Pistol
 * 
 */
abstract class ScoutPistolAttributes : PistolAttributes() {
	companion object : ScoutPistolAttributes() {
		operator fun invoke(scope: ScoutPistolAttributes.Companion.() -> Unit) {
			this.apply(scope)
		}
	}
	
	/**
	 * If true, can headshot
	 */
	context(attrs: IKeyValueMap)
	var backHeadshot: Boolean?
		get() = attrs.getTyped("back headshot", BinaryIntCodec)
		set(value) = attrs.setNullable("back headshot", value, BinaryIntCodec)
}

