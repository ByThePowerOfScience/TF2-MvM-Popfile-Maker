package btpos.source.vdfdsl.codegen

import btpos.source.vdfdsl.backing.VDFPrimitive
import btpos.misc.kt.codegen.KtExpression
import btpos.source.vdfdsl.util.forEachWithIter
import kotlin.reflect.KClass

/**
 * Navigation to direct a keyvalue to the right decoder for that type, where the type is specified by the key itself.
 *
 * For example, when the key is `"TFBot"`, the value is always a `TFBot` instance.
 * There is no case where a `TFBot` instance can be keyed by anything other than the `"TFBot"` key.
 *
 * To add new subclasses, add their entries to [typeDecodersByKey].
 */
class StructSubclassNavigator(
	val typeDecodersByKey: MutableMap<VDFPrimitive, SelfNamedDecoder<KtExpression>> = mutableMapOf(),
) : SelfNamedDecoder<KtExpression> {
	
	override fun decode(subtree: SafeRemovalVDFSubtree): List<KtExpression> {
		return buildList {
			subtree.forEachWithIter { kv ->
				typeDecodersByKey[kv.key]?.decode(subtree)?.let {
					addAll(it)
				}
			}
		}
	}
	
	companion object {
		operator fun invoke(vararg mappings: Pair<VDFPrimitive, Any>): StructSubclassNavigator {
			val m = HashMap<VDFPrimitive, SelfNamedDecoder<KtExpression>>()
			mappings.forEach { (prim, v) ->
				m[prim] = parseAny(v, prim)
			}
			return StructSubclassNavigator(m)
		}
		
		private fun parseAny(any: Any, prim: VDFPrimitive): SelfNamedDecoder<KtExpression> {
			return when (any) {
			is KClass<*> -> Decoders.getDecoderOrThrow(any)
				is SelfNamedDecoder<*> -> any as SelfNamedDecoder<KtExpression>
				is ValueDecoder<*> -> (any as ValueDecoder<KtExpression>).keyed(prim)
				is CodegenProvider<*> -> parseAny(any.get(), prim)
				else -> throw IllegalArgumentException("Expected KClass, SelfNamedDecoder, or ValueDecoder. Got ${any::class.qualifiedName} for $prim = $any")
			}
		}
		
		@JvmName("invokeString")
		operator fun invoke(vararg mappings: Pair<String, Any>): StructSubclassNavigator {
			return invoke(*mappings.map { pair ->
				VDFPrimitive.Companion(pair.first) to pair.second
			}.toTypedArray())
		}
	}
}