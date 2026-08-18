package btpos.source.vdfdsl.codegen

import btpos.misc.kt.codegen.KtStatement
import btpos.source.vdfdsl.backing.VDFSubtree

class ExtensibleDecoder<T : KtStatement>(
	/**
	 * The decoder originally defined for this item.
	 */
	val original: SelfNamedDecoder<T>
) : SelfNamedDecoder<T> {
	
	/**
	 * A list of decoders that should be tried before [original].
	 * The first successful parse will be taken, all others will be skipped.
	 *
	 * [original] will only be used to decode the item if none of the decoders in this list can parse the input.
	 */
	val tryBefore: MutableList<SelfNamedDecoder<T>> = ArrayList(0)
	
	
	override fun decode(subtree: VDFSubtree): List<T>? {
		tryBefore.forEach { decoder ->
			val x = decoder.decode(subtree)
			if (!x.isNullOrEmpty())
				return x;
		}
		
		return original.decode(subtree)
	}
}

fun <T : KtStatement> SelfNamedDecoder<T>.extensible(): ExtensibleDecoder<T> {
	return ExtensibleDecoder(this)
}