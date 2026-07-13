package btpos.source.vdfdsl.tf2.itemattributes

import btpos.source.vdfdsl.serialization.codecs.BinaryIntCodec
import btpos.source.vdfdsl.tf2.attributes.impl.IBlockScoped


/**
 * Items: Spellbook
 */
interface ThrowableAttributes : JarAttributes, IBlockScoped {
	companion object : ThrowableAttributes
	
	/**
	 * 
	 */
	context(attrs: btpos.source.vdfdsl.modeling.IKeyValueMap)
	var throwableRechargeTime: Int?
		get() = attrs.getTyped("throwable recharge time")
		set(value) = attrs.setNullable("throwable recharge time", value)
	
	/**
	 * 
	 */
	context(attrs: btpos.source.vdfdsl.modeling.IKeyValueMap)
	var throwableDetonationTime: Int?
		get() = attrs.getTyped("throwable detonation time")
		set(value) = attrs.setNullable("throwable detonation time", value)
	
	/**
	 * 
	 *
	 * For timed explosions.
	 */
	context(attrs: btpos.source.vdfdsl.modeling.IKeyValueMap)
	var isThrowablePrimable: Boolean?
		get() = attrs.getTyped("is throwable primable", BinaryIntCodec)
		set(value) = attrs.setNullable("is throwable primable", value, BinaryIntCodec)
	
	/**
	 * 
	 *
	 * For things like distance/power increases.
	 */
	context(attrs: btpos.source.vdfdsl.modeling.IKeyValueMap)
	var isThrowableChargeable: Boolean?
		get() = attrs.getTyped("is throwable chargeable", BinaryIntCodec)
		set(value) = attrs.setNullable("is throwable chargeable", value, BinaryIntCodec)
}

