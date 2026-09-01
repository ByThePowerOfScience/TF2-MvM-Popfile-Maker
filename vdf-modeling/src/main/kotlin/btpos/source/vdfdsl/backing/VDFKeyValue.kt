package btpos.source.vdfdsl.backing

import btpos.source.vdfdsl.serialization.IVDFRepresentableKeyValue

/**
 * A basic key-value pair: a name, and something assigned to that name.
 *
 * These are often members of a [VDFSubtree] that represents some scope.
 *
 * Note: structs are represented as keyvalues with a [VDFSubtree] as a value,
 * as they only differ from the standard "name: value" format in that they name _themselves_.
 */
data class VDFKeyValue(val key: VDFPrimitive, val value: VDFValue, val conditional: String? = null) : VDFObject(), IVDFRepresentableKeyValue {
	constructor(key: String, value: String, conditional: String? = null) : this(VDFPrimitive(key), VDFPrimitive(value), conditional)
	
	override fun _serializeInto(input: VDFSubtree, forcedConditional: String?) {
		input += this.let {
			if (forcedConditional != null) {
				it.copy(conditional = forcedConditional)
			} else
				it
		}
	}
	
	override fun writeToVDF(writer: Appendable, indent: Int) {
		key.writeToVDF(writer, indent)
		conditional?.let { writer.append(" [").append(it).append(']') }
		when (value) {
			is VDFSubtree -> {
				writer.writeLine(indent)
				value.writeToVDF(writer, indent)
			}
			else -> {
				writer.append(' ')
				value.writeToVDF(writer, indent)
			}
		}
	}
	
	override fun toString(): String {
		return "VDFKeyValue(key=$key, value=$value${conditional?.let{ ", conditional=$it" }.orEmpty()})"
	}
	
	override fun <DATA, RET> accept(visitor: VDFVisitor<DATA, RET>, data: DATA): RET {
		return visitor.visitKeyValue(this, data)
	}
	
	override fun <DATA> acceptChildren(visitor: VDFVisitor<DATA, *>, data: DATA) {
		this.key.accept(visitor, data)
		this.value.accept(visitor, data)
	}
	
	override fun deepCopy(parent: VDFSubtree?) = VDFKeyValue(key.deepCopy(parent), value.deepCopy(parent), conditional)
	
	companion object {
		/**
		 * Factory for easy "Only make the entry if the value is set"
		 */
		fun orNull(key: VDFPrimitive, value: VDFValue?, conditional: String?): VDFKeyValue? {
	        if (value == null)
				return null
			
			return VDFKeyValue(key, value, conditional)
	    }
	}
}