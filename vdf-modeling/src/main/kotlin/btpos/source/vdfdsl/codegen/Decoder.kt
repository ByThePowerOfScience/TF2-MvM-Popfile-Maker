package btpos.source.vdfdsl.codegen

import btpos.source.vdfdsl.backing.VDFObject
import btpos.source.vdfdsl.backing.VDFSubtree
import btpos.source.vdfdsl.backing.asString
import btpos.source.vdfdsl.backing.asSubtree

open class DecoderCollector {
	val items = mutableListOf<IKtCodeGenerator>()
}

fun interface Decoder {
	fun decode(obj: VDFObject): List<IKtCodeGenerator>
}

fun interface StringDecoder : Decoder {
	override fun decode(obj: VDFObject): List<IKtCodeGenerator> {
		return obj.asString?.let { decode(it) }.orEmpty()
	}
	
	fun decode(it: String): List<IKtCodeGenerator>
	
	companion object {
		val IDENTITY = StringDecoder {
			listOf(Codegen.string(it))
		}
	}
}

fun interface SubtreeDecoder : Decoder {
	override fun decode(obj: VDFObject): List<IKtCodeGenerator> {
		return obj.asSubtree?.let { decode(it) }.orEmpty()
	}
	
	fun decode(subtree: VDFSubtree): List<IKtCodeGenerator>
}


interface StringDecoderMap : StringDecoder {
	val values: MutableMap<String, List<IKtCodeGenerator>>
	
	var default: StringDecoder?
	
	override fun decode(it: String): List<IKtCodeGenerator> {
		val lc = it.lowercase()
		return (values[lc] ?: default?.decode(lc)).orEmpty()
	}
}

open class StringDecoderMapImpl : StringDecoderMap {
	override val values: MutableMap<String, List<IKtCodeGenerator>> = mutableMapOf()
	override var default: StringDecoder? = null
}


/**
 * Can read the subtree itself and take keyvaleus from it.
 */
interface StructDecoder : SubtreeDecoder {
	val decoders: MutableList<SubtreeDecoder>
	
	var remainderDecoder: SubtreeDecoder?
	
	
	override fun decode(subtree: VDFSubtree): List<IKtCodeGenerator> {
		return decoders.flatMap {
			it.decode(subtree)
		} + if (subtree.isNotEmpty()) {
			remainderDecoder?.decode(subtree)
				?: throw DecoderException("No remainder decoder set, but unrecognized values found.\n" +
				                          "Leftover values: ${subtree.entries}")
		} else emptyList()
	}
}

open class StructDecoderImpl(
	decoders: Iterable<SubtreeDecoder>,
	override var remainderDecoder: SubtreeDecoder? = null
) : StructDecoder {
	constructor(
		vararg decoders: SubtreeDecoder,
		remainderDecoder: SubtreeDecoder? = null
	) : this(decoders.asList(), remainderDecoder)
	
	override val decoders = decoders.toMutableList()
}


fun interface MapDecoder {
	fun decode(subtree: VDFSubtree): List<IKtCodeGenerator>
}

/**
 * Let's just hardcode this first, then we'll see about actually doing it better
 */
object MissionDecoder {

}