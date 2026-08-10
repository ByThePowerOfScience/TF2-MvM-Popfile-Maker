package btpos.source.vdfdsl.codegen

import btpos.source.vdfdsl.backing.VDFKeyValue
import btpos.source.vdfdsl.backing.VDFPrimitive
import btpos.source.vdfdsl.util.ifNullOrEmpty
import kotlin.reflect.KClass

/**
 * Navigation to direct a keyvalue to the right decoder for that type, where the type is specified by the key itself.
 *
 * For example, when the key is `"TFBot"`, the value is always a `TFBot` instance.
 * There is no case where a `TFBot` instance can be keyed by anything other than the `"TFBot"` key.
 */
class StructSubclassDecoder(val typeDecodersByKey: MutableMap<VDFPrimitive, Decoder<*>> = mutableMapOf(), val ownDecoder: Decoder<*>? = null) : Decoder<IKtCodeGenerator> {
	override fun decode(keyvalue: VDFKeyValue): List<IKtCodeGenerator> {
		return typeDecodersByKey[keyvalue.key]?.decode(keyvalue)
			.ifNullOrEmpty {
				ownDecoder?.decode(keyvalue).orEmpty()
			}
	}
	
	companion object {
		operator fun invoke(vararg mappings: Pair<VDFPrimitive, Any>, ownDecoder: Decoder<*>? = null): StructSubclassDecoder {
			val m = HashMap<VDFPrimitive, Decoder<*>>()
			mappings.forEach { (prim, v) ->
				m[prim] = when (v) {
					is KClass<*> -> Decoders.forType(v)
					is Decoder<*> -> v
					else -> throw IllegalArgumentException("Expected KClass or Decoder, got ${v::class.qualifiedName} for $prim = $v")
				}
			}
			return StructSubclassDecoder(m, ownDecoder)
		}
		
		@JvmName("invokeString")
		operator fun invoke(vararg mappings: Pair<String, Any>, ownDecoder: Decoder<*>? = null): StructSubclassDecoder {
			return invoke(*mappings.map { pair ->
				VDFPrimitive.Companion(pair.first) to pair.second
			}.toTypedArray(), ownDecoder = ownDecoder)
		}
	}
}