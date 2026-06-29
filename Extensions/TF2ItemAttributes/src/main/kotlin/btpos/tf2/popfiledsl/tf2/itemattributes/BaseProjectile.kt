package btpos.tf2.popfiledsl.tf2.itemattributes

import btpos.tf2.popfiledsl.modeling.*
import btpos.tf2.popfiledsl.serialization.codecs.*


/**
 * 
 */
interface BaseProjectileAttributes {
	companion object : BaseProjectileAttributes
	
	/**
	 * If true, applies mad milk on hit. Yes, this is in the base projectile.
	 * 
	 */
	context(attrs: IKeyValueMap)
	var madMilkSyringes: Boolean?
		get() = attrs.getTyped("mad milk syringes", BinaryIntCodec)
		set(value) = attrs.setNullable("mad milk syringes", value, BinaryIntCodec)
}

inline operator fun BaseProjectileAttributes.invoke(scope: BaseProjectileAttributes.() -> Unit) {
	this.apply(scope)
}

