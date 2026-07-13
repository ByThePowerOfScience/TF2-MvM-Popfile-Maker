package btpos.source.vdfdsl.tf2.attributes

import btpos.source.vdfdsl.modeling.*
import btpos.source.vdfdsl.serialization.codecs.*
import btpos.source.vdfdsl.tf2.attributes.impl.*
import java.util.*

/**
 * Items: Spellbook
 */
interface ThrowableAttributes : JarAttributes, IBlockScoped {
	companion object : ThrowableAttributes
	
	/**
	 * 
	 */
	context(attrs: IKeyValueMap)
	var throwableRechargeTime: Int?
		get() = attrs.getTyped("throwable recharge time")
		set(value) = attrs.setNullable("throwable recharge time", value)
	
	/**
	 * 
	 */
	context(attrs: IKeyValueMap)
	var throwableDetonationTime: Int?
		get() = attrs.getTyped("throwable detonation time")
		set(value) = attrs.setNullable("throwable detonation time", value)
	
	/**
	 * 
	 *
	 * For timed explosions.
	 */
	context(attrs: IKeyValueMap)
	var isThrowablePrimable: Boolean?
		get() = attrs.getTyped("is throwable primable", BinaryIntCodec)
		set(value) = attrs.setNullable("is throwable primable", value, BinaryIntCodec)
	
	/**
	 * 
	 *
	 * For things like distance/power increases.
	 */
	context(attrs: IKeyValueMap)
	var isThrowableChargeable: Boolean?
		get() = attrs.getTyped("is throwable chargeable", BinaryIntCodec)
		set(value) = attrs.setNullable("is throwable chargeable", value, BinaryIntCodec)
}

