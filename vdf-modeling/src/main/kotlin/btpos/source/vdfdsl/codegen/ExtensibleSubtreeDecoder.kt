package btpos.source.vdfdsl.codegen

import btpos.misc.kt.codegen.KtExpression
import btpos.source.vdfdsl.backing.VDFKeyValue
import btpos.source.vdfdsl.backing.VDFPrimitive
import btpos.source.vdfdsl.backing.asSubtree
import btpos.misc.kt.codegen.KtStatement
import btpos.misc.kt.codegen.expressions.KtFunctionCall
import btpos.misc.kt.codegen.statements.KtComment
import btpos.source.vdfdsl.backing.VDFObject
import btpos.source.vdfdsl.backing.VDFSubtree
import btpos.source.vdfdsl.backing.VDFValue
import btpos.source.vdfdsl.backing.toFormattedString
import btpos.source.vdfdsl.modeling.IExtensibleSubtree
import btpos.source.vdfdsl.util.forEachWithIter
import kotlin.reflect.KClass

class ExtensibleSubtreeDecoder(val cls: KClass<*>) : ValueDecoder<KtExpression> {
	var shouldCommentLeftovers: Boolean = true
	
	/**
	 * Takes in the items being set on the struct and returns a function call
	 * to some factory method, with any parameters being filled in and the rest being inside the scope block.
	 */
	var factoryMethod: IExtensibleSubtree.Codegen.StructFactoryMethod? = null
	
	val fieldDecoders = mutableMapOf<VDFPrimitive, ValueDecoder<KtStatement>>()
	
	val selfNamedDecoders = mutableListOf<SelfNamedDecoder<KtStatement>>()
	
	private val inheritedFields by lazy {
		IExtensibleSubtree.Codegen.typeHierarchy.getParentsRecursive(cls)
			.mapNotNull { IExtensibleSubtree.Codegen._codegenFieldMappings[it] }
			.toList()
	}
	
	/**
	 * Set of decoders to be run on the input first, in case of a subclass overriding this one.
	 *
	 * That subclass will then automatically inherit fields from this, its parent, through [inheritedFields].
	 */
	val runFirst = mutableListOf<ExtensibleSubtreeDecoder>()
	
	
	
	private val dummyFactoryMethod by lazy {
		System.err.println("No factory method defined for decoder for '${cls.qualifiedName}'. Using default constructor with `apply` block for member assignments.")
		Codegen.basicApplyFactory(cls)
	}
	
	private fun decodeByFieldName(keyvalue: VDFKeyValue, subtree: VDFSubtree): List<KtStatement>? {
		val decoder = this.fieldDecoders[keyvalue.key]
		              ?: inheritedFields.firstNotNullOfOrNull { it.fieldDecoders[keyvalue.key] }
		              ?: return null;
		
		return decoder.decodeValue(keyvalue.value, subtree)
	}
	
	
	
	override fun decodeValue(value: VDFValue, parentSubtree: VDFSubtree): List<KtExpression> {
		return listOfNotNull(decode(value, parentSubtree))
	}
	
	
	fun decode(value: VDFObject, parentSubtree: VDFSubtree): KtFunctionCall? {
		runFirst.forEach {
			val x = it.decode(value, parentSubtree)
			if (x != null)
				return x;
		}
		
		return value.asSubtree?.let { subtree ->
			val factoryMethod = factoryMethod ?: dummyFactoryMethod
			
			val out = ArrayList<KtStatement>()
			val failedParses = mutableListOf<String>()
			
			
			val remainingKeyValues = subtree.deepCopy()
			
			// first, let the self-named ones have a go at the whole subtree,
			// because they do weird and quirky things to the entire thing,
			// possibly having multiple keys for a single object
			run {
				(selfNamedDecoders + inheritedFields.flatMap { it.selfNamedDecoders })
					.forEach { d ->
						d.decode(remainingKeyValues)
							?.let {
								out += it
							}
						
						if (remainingKeyValues.isEmpty())
							return@run;
					}
				
				// now just handle the ones that only care about their field and not whatever else is doing on.
				remainingKeyValues.forEachWithIter { kv ->
					val x = decodeByFieldName(kv, subtree)
					
					if (!x.isNullOrEmpty()) {
						out += x
						remove()
						return@forEachWithIter;
					} else {
						val y = decodeByFieldName(kv, subtree)
					}
					
					if (shouldCommentLeftovers) {
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
			}
			
			factoryMethod(out)
		}
	}
	
	override fun toString(): String {
		return "StructDecoder(type=${cls.qualifiedName})"
	}
}

