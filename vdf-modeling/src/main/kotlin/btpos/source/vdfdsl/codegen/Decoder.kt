package btpos.source.vdfdsl.codegen

import btpos.source.vdfdsl.backing.VDFObject
import btpos.source.vdfdsl.backing.VDFPrimitive
import btpos.source.vdfdsl.backing.VDFSubtree
import btpos.source.vdfdsl.backing.asPrimitive
import btpos.source.vdfdsl.backing.asString
import btpos.source.vdfdsl.backing.asSubtree
import btpos.source.vdfdsl.codegen.kt.KtExpression

fun interface Decoder {
	fun decode(obj: VDFObject): List<IKtCodeGenerator>
}

fun interface StringDecoder : ValueDecoder {
	override fun decodeValue(obj: VDFObject): KtExpression? {
		return obj.asPrimitive?.let { decode(it) }
	}
	
	fun decode(it: VDFPrimitive): KtExpression?
	
	companion object {
		val IDENTITY = StringDecoder {
			Codegen.string(it.stringValue)
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
	val values: MutableMap<VDFPrimitive, KtExpression>
	
	var default: StringDecoder?
	
	override fun decode(it: VDFPrimitive): KtExpression? {
		return (values[it] ?: default?.decode(it))
	}
}

open class StringDecoderMapImpl : StringDecoderMap {
	override val values: MutableMap<VDFPrimitive, KtExpression> = mutableMapOf()
	override var default: StringDecoder? = null
}
