package btpos.tf2.popfiledsl.tf2.itemattributes

import btpos.tf2.popfiledsl.modeling.*
import btpos.tf2.popfiledsl.serialization.codecs.*


/**
 * 
 */
abstract class BaseProjectileAttributes {
	companion object : BaseProjectileAttributes() {
		operator fun invoke(scope: BaseProjectileAttributes.Companion.() -> Unit) {
			this.apply(scope)
		}
	}
	
	/**
	 *     - If true, applies mad milk on hit. Yes, this is in the base projectile.
	 */
	context(attrs: IKeyValueMap)
	var madMilkSyringes: Boolean?
		get() = attrs.getTyped("mad milk syringes", BinaryIntCodec)
		set(value) = attrs.setNullable("mad milk syringes", value, BinaryIntCodec)
}

