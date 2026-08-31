package btpos.source.vdfdsl.codegen

import btpos.misc.kt.codegen.KtExpression
import btpos.misc.kt.codegen.KtStatement
import btpos.source.vdfdsl.backing.VDFObject
import btpos.source.vdfdsl.backing.VDFPrimitive
import btpos.source.vdfdsl.backing.VDFSubtree
import btpos.source.vdfdsl.backing.asPrimitive
import btpos.source.vdfdsl.codegen.services.TypeDecoderProvider
import btpos.source.vdfdsl.util.ClassHierarchyGraph
import java.util.ServiceLoader
import kotlin.reflect.KClass

object Decoders {
	val DURATION = StringDecoder { str ->
		str.stringValue.toDoubleOrNull()?.let {
			Codegen.code("$str.seconds", "kotlin.time.Duration")
		}
	}
	
	val NUMBER = StringDecoder { str ->
		str.stringValue.toDoubleOrNull()?.run {
			Codegen.code(str.stringValue)
		}
	}
	
	val INT = StringDecoder { str ->
		str.stringValue.toIntOrNull()?.run {
			Codegen.code(str.stringValue)
		}
	}
	
	val BOOLEAN = ValueDecoder<KtExpression> { it, _ ->
		it.asPrimitive?.let {
			when (it) {
				VDFPrimitive.TRUE, VDFPrimitive.notInterned("yes") -> Codegen.code("true")
				VDFPrimitive.FALSE, VDFPrimitive.notInterned("no") -> Codegen.code("false")
				else -> null
			}
		}?.let { listOf(it) }
	}
	
	private val services = ServiceLoader.load(TypeDecoderProvider::class.java)
	
	/**
	 * Return a decoder suitable for evaluating an already-identified type.
	 */
	fun getValueDecoder(type: KClass<*>): ValueDecoder<KtExpression> {
		refreshHierarchy()
		
		return CompositeValueDecoder(type)
	}
	
	private val allClassHierarchyGraph = ClassHierarchyGraph()
	// TODO make subclasses automatically defer to superclasses
	
	
	private class CompositeValueDecoder(val type: KClass<*>) : ValueDecoder<KtExpression> {
		override fun decodeValue(value: VDFObject, parentSubtree: VDFSubtree): List<KtExpression>? {
			return (sequenceOf(type) + allClassHierarchyGraph.getParentsRecursive(type))
				.firstNotNullOfOrNull { cls ->
					services.firstNotNullOfOrNull {
						it.valueDecoders[cls]
							?.decodeValue(value, parentSubtree)
							?.takeIf { it.isNotEmpty() }
					}
				}
		}
	}
	
	private class CompositeSelfNamedDecoder(val type: KClass<*>) : SelfNamedDecoder<KtExpression> {
		override fun decode(subtree: VDFSubtree): List<KtExpression>? {
			return (sequenceOf(type) + allClassHierarchyGraph.getParentsRecursive(type))
				.firstNotNullOfOrNull { cls ->
					services.firstNotNullOfOrNull {
						it.selfNamedDecoders[cls]
							?.decode(subtree)
							?.takeIf { it.isNotEmpty() }
					}
				}
		}
	}
	
	private fun refreshHierarchy() {
		services.forEach {
			it.selfNamedDecoders.keys.forEach(allClassHierarchyGraph::add)
			it.valueDecoders.keys.forEach(allClassHierarchyGraph::add)
		}
	}
	
	/**
	 * Return a decoder suitable for evaluating instances of this self-named type
	 */
	fun getDecoder(type: KClass<*>): SelfNamedDecoder<KtExpression> {
		refreshHierarchy()
		
		return CompositeSelfNamedDecoder(type)
	}
//
//	fun getValueDecoderBestFit(obj: Any): ValueDecoder<KtExpression> {
//		allClassHierarchyGraph.add(obj::class)
//		return ValueDecoder { value, parent ->
//			allClassHierarchyGraph.getParentsRecursive(obj::class).firstNotNullOfOrNull { getValueDecoder(it)?.decodeValue(value, parent) }
//		}
//	}
	
	
	fun getDecoderOrThrow(type: KClass<*>): SelfNamedDecoder<KtExpression> {
		return getDecoder(type)
		       ?: error("No decoder(s) defined for '${type}'.")
	}
}
