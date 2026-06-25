package btpos.tf2.popfiledsl.tf2.itemattributes

import btpos.tf2.popfiledsl.modeling.*
import btpos.tf2.popfiledsl.serialization.codecs.*


/**
 * Items: TF_WEAPON_SHOVEL, The Equalizer, The Pain Train, Upgradeable TF_WEAPON_SHOVEL, The Market Gardener, The Disciplinary Action, The Escape Plan
 * 
 */
abstract class ShovelAttributes : BaseMeleeAttributes() {
	companion object : ShovelAttributes() {
		operator fun invoke(scope: ShovelAttributes.Companion.() -> Unit) {
			this.apply(scope)
		}
	}
	
	/**
	 * On primary attack, send player flying in the direction they're facing.
	 */
	context(attrs: IKeyValueMap)
	var airJumpOnAttack: Boolean?
		get() = attrs.getTyped("air jump on attack", BinaryIntCodec)
		set(value) = attrs.setNullable("air jump on attack", value, BinaryIntCodec)
}

