package btpos.source.vdfdsl.codegen

import btpos.source.vdfdsl.backing.VDFKeyValue
import btpos.source.vdfdsl.backing.VDFObject
import btpos.misc.kt.codegen.KtStatement

/**
 * Doesn't use the key or other information, just a raw value.
 */
fun interface ValueDecoder<out T : KtStatement> : Decoder<T> {
	override fun decode(keyvalue: VDFKeyValue): List<T> {
		return decodeValue(keyvalue.value)
	}
	
	fun decodeValue(obj: VDFObject): List<T>
}