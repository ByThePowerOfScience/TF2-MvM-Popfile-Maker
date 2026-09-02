package btpos.source.vdfdsl.codegen

import btpos.misc.kt.codegen.KtStatement
import btpos.source.vdfdsl.backing.VDFPrimitive
import btpos.source.vdfdsl.backing.VDFValue
import btpos.source.vdfdsl.util.compacted
import btpos.source.vdfdsl.util.forEachWithLazyIter

/**
 * Decoder that transforms a single object into its deserialized type.
 *
 * We assume this decoder was dispatched based on the key, leaving only the value to be deserialized into the code.
 *
 * Also has access to the parent subtree to allow support for types that serialize into and deserialize from multiple keyvalues.
 * Any keyvalues from the parent that are consumed by this decoder should be _removed_ from said subtree.
 *
 * The parent subtree must not be modified unless the value is successfully decoded.
 * Any failures must leave the parent unchanged, so cache anything you're evaluating and only remove from it if it worked.
 */
fun interface ValueDecoder<out T : KtStatement> {
	fun decodeValue(value: VDFValue, parentSubtree: WeirdMutableIterableSubtree): List<T>?
}


fun <T : KtStatement> ValueDecoder<T>.keyed(key: String) = keyed(VDFPrimitive(key))
fun <T : KtStatement> ValueDecoder<T>.keyed(key: VDFPrimitive): SelfNamedDecoder<T> {
	return SelfNamedDecoder { subtree ->
		val out = ArrayList<T>()
		subtree.forEachWithLazyIter { kv ->
			if (kv.key == key) {
				val ret = this@keyed.decodeValue(kv.value, subtree)
				if (ret.isNullOrEmpty())
					return@forEachWithLazyIter;
				out += ret
				remove()
			}
		}
		out.compacted()
	}
}