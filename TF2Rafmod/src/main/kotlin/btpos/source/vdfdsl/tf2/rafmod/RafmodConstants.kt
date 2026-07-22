package btpos.source.vdfdsl.tf2.rafmod

import btpos.source.vdfdsl.backing.VDFPrimitive
import btpos.source.vdfdsl.backing.VDFPrimitive.Companion.invoke
import btpos.source.vdfdsl.serialization.codecs.BinaryIntCodec

internal object RafmodConstants {
	const val SIGSEGV = $$"$SIGSEGV"
	
	
	val FIELD_ITEM = VDFPrimitive("Item")
	val FIELD_NAME = VDFPrimitive("Name")
	val FIELD_VALUE = VDFPrimitive("Value")
	
	val VALUE_PLAYER = VDFPrimitive("Player")
	val VALUE_ACTIVE = VDFPrimitive("Active")
}