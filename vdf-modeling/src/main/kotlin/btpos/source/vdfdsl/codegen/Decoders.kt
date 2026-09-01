package btpos.source.vdfdsl.codegen

import btpos.misc.kt.codegen.KtExpression
import btpos.source.vdfdsl.backing.VDFPrimitive
import btpos.source.vdfdsl.backing.VDFSubtree
import btpos.source.vdfdsl.backing.VDFValue
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
	
	val BOOLEAN = run {
		val yes = VDFPrimitive("yes")
		val no = VDFPrimitive("no")
		
		val tru = Codegen.code("true")
		val fals = Codegen.code("false")
		
		ValueDecoder<KtExpression> { it, _ ->
			it.asPrimitive?.let {
				when (it) {
					VDFPrimitive.TRUE, yes -> tru
					VDFPrimitive.FALSE, no -> fals
					else -> null
				}
			}?.let { listOf(it) }
		}
	}
	
	private val services = ServiceLoader.load(TypeDecoderProvider::class.java)
	
	/**
	 * Return a decoder suitable for evaluating an already-identified type.
	 */
	fun getValueDecoder(type: KClass<*>): ValueDecoder<KtExpression> {
		refreshHierarchy()
		
		return CompositeValueDecoder(type)
	}
	
	val allClassHierarchyGraph = ClassHierarchyGraph()
	
	private inline fun <T : Any, U : Any> findXForTypeAndAllSupertypesInServices(type: KClass<*>, getter: TypeDecoderProvider.(KClass<*>) -> T?, runner: (T) -> U?): U? {
		findXForTypeInServices(type, getter, runner)?.let {
			return it;
		}
		
		for (sup in allClassHierarchyGraph.getParentsRecursive(type)) {
			findXForTypeInServices(sup, getter, runner)?.let {
				return it;
			}
		}
		return null;
	}
	
	private inline fun <T : Any, U : Any> findXForTypeInServices(type: KClass<*>, getter: TypeDecoderProvider.(KClass<*>) -> T?, runner: (T) -> U?): U? {
		var haveFoundMatching = false
		for (el in services) {
			val gotten = el.getter(type)
			             ?: continue;
			haveFoundMatching = true
			val afterRun = runner(gotten)
			               ?: continue;
			return afterRun;
		}
		
		if (!haveFoundMatching)
			System.err.println("No such decoder found for $type")
		else
			System.err.println("No decoder for $type could successfully parse the input")
		
		return null;
	}
	
	private class CompositeValueDecoder(val type: KClass<*>) : ValueDecoder<KtExpression> {
		override fun decodeValue(value: VDFValue, parentSubtree: VDFSubtree): List<KtExpression>? {
			return findXForTypeAndAllSupertypesInServices(
				type,
				{ valueDecoders[it] },
				{ it.decodeValue(value, parentSubtree)?.takeIf { it.isNotEmpty() } }
			) ?: run {
				System.err.println("Failed to parse input $value of type $type")
				null
			}
		}
	}
	
	private class CompositeSelfNamedDecoder(val type: KClass<*>) : SelfNamedDecoder<KtExpression> {
		override fun decode(subtree: VDFSubtree): List<KtExpression>? {
			return findXForTypeAndAllSupertypesInServices(type, { selfNamedDecoders[it] }, { it.decode(subtree)?.takeIf { it.isNotEmpty() } })
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
