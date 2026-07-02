package btpos.source.vdfdsl.backing

import btpos.source.vdfdsl.serialization.IVDFRepresentableValue

data class VDFPrimitive(val stringValue: String) : VDFObject(), IVDFRepresentableValue<VDFPrimitive> {
	constructor(i: Int) : this(i.toString())
	
	constructor(i: Float) : this(i.toString())
	
	override fun writeToVDF(writer: Appendable, indent: Int) {
		writer.append('"').append(stringValue).append('"')
	}
	
	companion object {
		val PRIMITIVE_SERIALIZERS = mapOf<Class<*>, (Any) -> VDFObject>(
			String::class.java to { VDFPrimitive(it as String) },
			Int::class.java to { VDFPrimitive(it as Int) },
			Float::class.java to { VDFPrimitive(it as Float) },
			Double::class.java to { VDFPrimitive((it as Double).toFloat()) },
			Boolean::class.java to { VDFPrimitive(it as Boolean) },
		)
		
		
		val TRUE = VDFPrimitive("1")
		val FALSE = VDFPrimitive("0")
		
	    operator fun invoke(bool: Boolean): VDFPrimitive {
	        return if (bool) TRUE else FALSE
	    }
		
		operator fun invoke(n: Number) = when (n) {
			is Int -> VDFPrimitive(n)
			is Float -> VDFPrimitive(n)
			is Double -> VDFPrimitive(n.toFloat())
			else -> VDFPrimitive(n.toString()) // longs can't REALLY be serialized as integers, but they can be serialized as strings
		}
		
		operator fun invoke(o: Any) = when (o) {
			is String -> VDFPrimitive(o)
			is Number -> VDFPrimitive(o)
			is Boolean -> VDFPrimitive(bool=o)
			else -> throw IllegalArgumentException("Object $o is not a primitive. Valid types: String, Number, Boolean")
		}
		
		fun isPrimitive(cls: Class<*>): Boolean {
			return cls.isAssignableFrom(VDFPrimitive::class.java) || cls in PRIMITIVE_SERIALIZERS
		}
		
		fun requirePrimitive(cls: Class<*>) {
			if (!isPrimitive(cls)) {
				throw IllegalArgumentException("Type ${cls.simpleName} is not serializable to a primitive value.  Valid types: String, Number, Boolean.")
			}
		}
	}
	
	override val _vdfRepr: VDFPrimitive
		get() = this
	
	
}