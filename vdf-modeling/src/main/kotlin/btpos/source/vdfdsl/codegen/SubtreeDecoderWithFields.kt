package btpos.source.vdfdsl.codegen

import btpos.source.vdfdsl.backing.VDFObject
import btpos.source.vdfdsl.backing.VDFPrimitive
import btpos.source.vdfdsl.backing.asSubtree
import btpos.source.vdfdsl.codegen.kt.KtExpression
import btpos.source.vdfdsl.codegen.kt.KtFunctionCall
import btpos.source.vdfdsl.codegen.kt.KtName
import btpos.source.vdfdsl.modeling.IExtensibleSubtree
import btpos.source.vdfdsl.util.forEachWithIter
import kotlin.reflect.KClass

class SubtreeDecoderWithFields(val cls: KClass<*>) : ValueDecoder<KtExpression> {
	/**
	 * Takes in the items being set on the struct and returns a function call
	 * to some factory method, with any parameters being filled in and the rest being inside the scope block.
	 */
	var factoryMethod: IExtensibleSubtree.Codegen.StructFactoryMethod? = null
	
	val fieldDecoders = mutableMapOf<VDFPrimitive, Decoder<KtExpression>>()
	
	val selfNamedDecoders = mutableListOf<Decoder<KtExpression>>()
	
	private val dummyFactoryMethod by lazy {
		System.err.println("No factory method defined for decoder for '${cls.qualifiedName}'. Using default constructor with `apply` block for member assignments.")
		Codegen.basicApplyFactory(cls)
	}
	
	override fun decodeValue(obj: VDFObject): List<KtExpression> {
		return obj.asSubtree?.let { subtree ->
			val factoryMethod = factoryMethod ?: dummyFactoryMethod
			
			val out = mutableListOf<KtExpression>()
			
			val unconsumedKeyValues = subtree.toMutableList() // make copy cause we're removing stuff from it
			
			unconsumedKeyValues.forEachWithIter { kv ->
				val x = fieldDecoders[kv.key]?.let { decoder ->
					decoder.decode(kv).takeIf { it.isNotEmpty() }
				} ?: selfNamedDecoders.firstNotNullOfOrNull { decoder ->
					decoder.decode(kv).takeIf { it.isNotEmpty() }
				}
				
				if (x != null) {
					out += x
					remove()
				}
			}
			
			if (unconsumedKeyValues.isNotEmpty()) {
				out += Codegen.blockComment(buildString {
					unconsumedKeyValues.forEach {
						it.writeToVDF(this)
					}
				})
			}
			
			listOf(factoryMethod(out))
		}.orEmpty()
	}
	
	override fun toString(): String {
		return "StructDecoder(factoryMethod=$factoryMethod, fieldDecoders=$fieldDecoders)"
	}
}

