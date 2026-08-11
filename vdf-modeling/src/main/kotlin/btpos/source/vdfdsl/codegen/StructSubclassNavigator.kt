package btpos.source.vdfdsl.codegen

import btpos.source.vdfdsl.backing.VDFKeyValue
import btpos.source.vdfdsl.backing.VDFPrimitive
import btpos.misc.kt.codegen.KtExpression
import kotlin.reflect.KClass

/**
 * Navigation to direct a keyvalue to the right decoder for that type, where the type is specified by the key itself.
 *
 * For example, when the key is `"TFBot"`, the value is always a `TFBot` instance.
 * There is no case where a `TFBot` instance can be keyed by anything other than the `"TFBot"` key.
 */
class StructSubclassNavigator(
	val typeDecodersByKey: MutableMap<VDFPrimitive, Decoder<KtExpression>> = mutableMapOf(),
) : Decoder<KtExpression> {
	override fun decode(keyvalue: VDFKeyValue): List<KtExpression> {
		return typeDecodersByKey[keyvalue.key]?.decode(keyvalue).orEmpty()
	}
	
	companion object {
		operator fun invoke(vararg mappings: Pair<VDFPrimitive, Any>): StructSubclassNavigator {
			val m = HashMap<VDFPrimitive, Decoder<KtExpression>>()
			mappings.forEach { (prim, v) ->
				m[prim] = when (v) {
					is KClass<*> -> Decoders.forType(v)
					is Decoder<*> -> v as Decoder<KtExpression>
					is CodegenProvider<*> -> v.get() as Decoder<KtExpression>
					else -> throw IllegalArgumentException("Expected KClass or Decoder, got ${v::class.qualifiedName} for $prim = $v")
				}
			}
			return StructSubclassNavigator(m)
		}
		
		@JvmName("invokeString")
		operator fun invoke(vararg mappings: Pair<String, Any>): StructSubclassNavigator {
			return invoke(*mappings.map { pair ->
				VDFPrimitive.Companion(pair.first) to pair.second
			}.toTypedArray())
		}
	}
}