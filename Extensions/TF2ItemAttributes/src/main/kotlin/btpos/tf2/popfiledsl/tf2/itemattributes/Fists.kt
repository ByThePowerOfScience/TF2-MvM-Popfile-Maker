package btpos.tf2.popfiledsl.tf2.itemattributes

import btpos.tf2.popfiledsl.modeling.*
import btpos.tf2.popfiledsl.serialization.codecs.*


/**
 * Items: Stock Fists, The Killing Gloves of Boxing, Warrior's Spirit, Fists of Steel, The Eviction Notice, Apoco-Fists, The Holiday Punch, The Bread Bite, Gloves of Running Urgently MvM
 * 
 */
abstract class FistsAttributes : BaseMeleeAttributes() {
	companion object : FistsAttributes() {
		operator fun invoke(scope: FistsAttributes.Companion.() -> Unit) {
			this.apply(scope)
		}
	}
	
	/**
	 * UNIMPLEMENTED
	 * Note that despite being present in the item schema, this is explicitly COMMENTED OUT of the code, and has no gameplay effects at least.
	 */
	context(attrs: IKeyValueMap)
	var breadglovesProperties: Boolean?
		get() = attrs.getTyped("breadgloves properties", BinaryIntCodec)
		set(value) = attrs.setNullable("breadgloves properties", value, BinaryIntCodec)
}

