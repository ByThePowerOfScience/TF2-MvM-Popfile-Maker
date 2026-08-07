package btpos.source.vdfdsl.codegen

import btpos.source.vdfdsl.backing.VDFSubtree
import btpos.source.vdfdsl.codegen.kt.KtAssignmentExpression
import btpos.source.vdfdsl.codegen.kt.KtName
import kotlin.collections.iterator
import kotlin.collections.plusAssign
import kotlin.reflect.KClass

class SubtreeFieldDecoder2(val propName: String, val key: String, val valueType: KClass<*>, val operator: String) : SubtreeFieldDecoder {
	val valueDecoder by lazy {
		Decoders.getTypeDecoder(valueType)
	}
	
	override fun decodeField(subtree: VDFSubtree): List<KtAssignmentExpression> {
		val liter = subtree.listIterator()
		
		val out = mutableListOf<KtAssignmentExpression>()
		
		for (kv in liter) {
			if (kv.key.stringValue == key) {
				val x = valueDecoder.decodeValue(kv.value) ?: continue;
				out += KtAssignmentExpression(KtName(propName), x, operator)
				liter.remove()
			}
		}
		
		return out.toList()
	}
	
	override fun toString(): String {
		return "SubtreeFieldDecoder2(operator='$operator', valueType=$valueType, key='$key', propName='$propName')"
	}
	
	override fun equals(other: Any?): Boolean {
		if (this === other) return true
		if (javaClass != other?.javaClass) return false
		
		other as SubtreeFieldDecoder2
		
		if (propName != other.propName) return false
		if (key != other.key) return false
		if (valueType != other.valueType) return false
		if (operator != other.operator) return false
		
		return true
	}
	
	override fun hashCode(): Int {
		var result = propName.hashCode()
		result = 31 * result + key.hashCode()
		result = 31 * result + valueType.hashCode()
		result = 31 * result + operator.hashCode()
		return result
	}
}