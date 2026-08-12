package btpos.source.vdfdsl.codegen

import btpos.source.vdfdsl.backing.VDFKeyValue
import btpos.source.vdfdsl.backing.VDFObject
import btpos.source.vdfdsl.backing.VDFPrimitive
import btpos.source.vdfdsl.backing.asSubtree
import btpos.misc.kt.codegen.KtStatement
import btpos.misc.kt.codegen.statements.KtComment
import btpos.misc.kt.codegen.expressions.KtFunctionCall
import btpos.source.vdfdsl.backing.toFormattedString
import btpos.source.vdfdsl.modeling.IExtensibleSubtree
import kotlin.reflect.KClass

class ExtensibleSubtreeDecoder(val cls: KClass<*>) : ValueDecoder<KtFunctionCall> {
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
	
	override fun decodeValue(obj: VDFObject): List<KtFunctionCall> {
		return obj.asSubtree?.let { subtree ->
			val factoryMethod = factoryMethod ?: dummyFactoryMethod
			
			val out = mutableListOf<KtStatement>()
			val failedParses = mutableListOf<String>()
			
			subtree.forEach { kv ->
				val x = decodeByFieldName(kv) ?: decodeSelfNamed(kv)
				
				if (!x.isNullOrEmpty()) {
					out += x
				} else {
					val prev = out.lastOrNull()
					if (prev is KtComment.Block) { // merge into previous block comment
						prev.body += kv.toFormattedString()
					} else {
						val formatted = kv.toFormattedString()
						out += Codegen.blockComment(formatted)
						failedParses += formatted
					}
				}
			}
			
			if (failedParses.isNotEmpty()) {
				System.err.println("Code generator for class ${cls.qualifiedName} failed to decode the following fields:")
				failedParses.forEach {
					System.err.println(it)
					System.err.println()
				}
			}
			
			listOf(factoryMethod(out))
		}.orEmpty()
	}
	
	override fun toString(): String {
		return "StructDecoder(type=${cls.qualifiedName})"
	}
}

