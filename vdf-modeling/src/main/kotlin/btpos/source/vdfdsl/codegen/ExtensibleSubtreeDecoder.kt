package btpos.source.vdfdsl.codegen

import btpos.source.vdfdsl.backing.VDFKeyValue
import btpos.source.vdfdsl.backing.VDFObject
import btpos.source.vdfdsl.backing.VDFPrimitive
import btpos.source.vdfdsl.backing.asSubtree
import btpos.misc.kt.codegen.KtExpression
import btpos.misc.kt.codegen.KtStatement
import btpos.source.vdfdsl.modeling.IExtensibleSubtree
import btpos.source.vdfdsl.util.forEachWithIter
import kotlin.reflect.KClass

class ExtensibleSubtreeDecoder(val cls: KClass<*>) : ValueDecoder<KtExpression> {
	/**
	 * Takes in the items being set on the struct and returns a function call
	 * to some factory method, with any parameters being filled in and the rest being inside the scope block.
	 */
	var factoryMethod: IExtensibleSubtree.Codegen.StructFactoryMethod? = null
	
	val fieldDecoders = mutableMapOf<VDFPrimitive, Decoder<KtStatement>>()
	
	val selfNamedDecoders = mutableListOf<Decoder<KtStatement>>()
	
	val inheritedFields by lazy {
		IExtensibleSubtree.Codegen.typeHierarchy.getParentsRecursive(cls)
			.mapNotNull { IExtensibleSubtree.Codegen._codegenFieldMappings[it] }
			.toList()
	}
	
	private val dummyFactoryMethod by lazy {
		System.err.println("No factory method defined for decoder for '${cls.qualifiedName}'. Using default constructor with `apply` block for member assignments.")
		Codegen.basicApplyFactory(cls)
	}
	
	fun decodeByFieldName(keyvalue: VDFKeyValue): List<KtStatement>? {
		val decoder = this.fieldDecoders[keyvalue.key]
		              ?: inheritedFields.firstNotNullOfOrNull { it.fieldDecoders[keyvalue.key] }
		              ?: return null;
		
		return decoder.decode(keyvalue)
	}
	
	fun decodeSelfNamed(keyvalue: VDFKeyValue): List<KtStatement>? {
		return (this.selfNamedDecoders.asSequence() +
		        inheritedFields.asSequence().flatMap { it.selfNamedDecoders })
			.firstNotNullOfOrNull { decoder ->
				decoder.decode(keyvalue).takeIf { it.isNotEmpty() }
			}
	}
	
	override fun decodeValue(obj: VDFObject): List<KtExpression> {
		return obj.asSubtree?.let { subtree ->
			val factoryMethod = factoryMethod ?: dummyFactoryMethod
			
			val out = mutableListOf<KtStatement>()
			
			val unconsumedKeyValues = subtree.toMutableList() // make copy cause we're removing stuff from it
			
			unconsumedKeyValues.forEachWithIter { kv ->
				val x = decodeByFieldName(kv) ?: decodeSelfNamed(kv)
				
				if (!x.isNullOrEmpty()) {
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

