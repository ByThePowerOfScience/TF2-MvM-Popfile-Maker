package btpos.source.vdfdsl.codegen

import btpos.source.vdfdsl.backing.VDFSubtree
import btpos.source.vdfdsl.codegen.kt.KtAssignmentExpression
import btpos.source.vdfdsl.codegen.kt.KtName
import kotlin.reflect.KClass

class SelfNamedDecoder(val propName: KtName, val valueType: KClass<*>) : SubtreeFieldDecoder {
	val valueDecoder by lazy {
		Decoders.getSelfNamedDecoder(valueType)
	}
	
	override fun decodeField(subtree: VDFSubtree): List<KtAssignmentExpression> {
		valueDecoder.takeInstances(subtree).let {
			return when (it.size) {
				0 -> emptyList()
				else -> it.map { KtAssignmentExpression(propName, it) } // idk man should we assume it's got multiple values or what
			}
		}
	}
	
	override fun toString(): String {
		return "SelfNamedDecoder(propName=$propName, valueType=$valueType)"
	}
}