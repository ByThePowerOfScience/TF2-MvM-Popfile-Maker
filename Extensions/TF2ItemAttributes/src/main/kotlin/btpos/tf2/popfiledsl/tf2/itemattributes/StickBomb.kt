package btpos.tf2.popfiledsl.tf2.itemattributes

import btpos.tf2.popfiledsl.modeling.*
import btpos.tf2.popfiledsl.serialization.codecs.*


/**
 * Items: The Ullapool Caber
 * 
 */
abstract class StickBombAttributes : BottleAttributes() {
	companion object : StickBombAttributes() {
		operator fun invoke(scope: StickBombAttributes.Companion.() -> Unit) {
			this.apply(scope)
		}
	}
	
	
	context(attrs: IKeyValueMap)
	var SPELLHalloweenPumpkinExplosions: Boolean?
		get() = attrs.getTyped("SPELL: Halloween pumpkin explosions", BinaryIntCodec)
		set(value) = attrs.setNullable("SPELL: Halloween pumpkin explosions", value, BinaryIntCodec)
}

