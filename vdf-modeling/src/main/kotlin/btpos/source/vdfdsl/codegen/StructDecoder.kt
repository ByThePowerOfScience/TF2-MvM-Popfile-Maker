package btpos.source.vdfdsl.codegen

import btpos.source.vdfdsl.backing.VDFKeyValue
import btpos.source.vdfdsl.backing.VDFObject
import btpos.source.vdfdsl.backing.VDFPrimitive
import btpos.source.vdfdsl.backing.VDFSubtree
import btpos.source.vdfdsl.backing.asSubtree
import btpos.source.vdfdsl.codegen.kt.KtAssignmentExpression
import btpos.source.vdfdsl.codegen.kt.KtExpression
import btpos.source.vdfdsl.codegen.kt.KtFunctionCall
import kotlin.reflect.KClass

class StructDecoder(
	/**
	 * Takes in the items being set on the struct and returns a function call
	 * to some factory method, with any parameters being filled in and the rest being inside the scope block.
	 */
	val factoryMethod: (fields: List<KtAssignmentExpression>) -> KtFunctionCall
) : ValueDecoder {
	val fieldDecoders = mutableSetOf<SubtreeFieldDecoder>()
	
	override fun decodeValue(obj: VDFObject): KtExpression? {
		return obj.asSubtree?.let { subtree ->
			val code = fieldDecoders.flatMap {
				it.decodeField(subtree)
			}
			
			if (subtree.isNotEmpty()) {
				throw DecoderException("Not all fields consumed by decoders!\nUnprocessed: ${subtree.entries.joinToString(", ") { it.key.stringValue } }")
			}
			
			factoryMethod(code)
		}
	}
	
	override fun toString(): String {
		return "StructDecoder(factoryMethod=$factoryMethod, fieldDecoders=$fieldDecoders)"
	}
	
	
}

class StructSubclassDecoder(val entries: MutableMap<VDFPrimitive, ValueDecoder> = mutableMapOf()) {
	fun takeInstances(subtree: VDFSubtree): List<KtExpression> {
		val out = mutableListOf<KtExpression>()
		
		val liter = subtree.listIterator()
		for (kv in liter) {
			entries[kv.key]?.let {
				out += it.decodeValue(kv.value) ?: continue;
				
				liter.remove()
			}
		}
		
		return out
	}
	
	companion object {
		operator fun invoke(vararg mappings: Pair<VDFPrimitive, Any>): StructSubclassDecoder {
			val m = HashMap<VDFPrimitive, ValueDecoder>()
			mappings.forEach { (prim, v) ->
				m[prim] = when (v) {
					is KClass<*> -> Decoders.getTypeDecoder(v)
					is ValueDecoder -> v
					else -> throw IllegalArgumentException("Expected KClass or ValueDecoder, got ${v::class.qualifiedName} for $prim = $v")
				}
			}
			return StructSubclassDecoder(m)
		}
		
		@JvmName("invokeString")
		operator fun invoke(vararg mappings: Pair<String, Any>): StructSubclassDecoder {
			return invoke(*mappings.map { pair ->
				VDFPrimitive(pair.first) to pair.second
			}.toTypedArray())
		}
	}
}