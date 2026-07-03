package btpos.source.vdfdsl.backing

import btpos.source.vdfdsl.serialization.IVDFRepresentableValue

data class VDFPrimitive(val stringValue: String) : VDFObject(), IVDFRepresentableValue<VDFPrimitive> {
	constructor(i: Int) : this(i.toString())
	
	constructor(i: Float) : this(i.toString())
	
	override fun writeToVDF(writer: Appendable, indent: Int) {
		if (stringValue.none { it.isWhitespace() }) {
			writer.append(stringValue)
		} else {
			writer.append('"').append(stringValue).append('"')
		}
	}
	
	companion object {
		@Suppress("PLATFORM_CLASS_MAPPED_TO_KOTLIN") // Int::class.java => int.class instead of Integer.class
		val PRIMITIVE_SERIALIZERS = mapOf<Class<*>, (Any) -> VDFObject>(
			java.lang.String::class.java to { VDFPrimitive(it as String) },
			java.lang.Integer::class.java to { VDFPrimitive(it as Int) },
			java.lang.Float::class.java to { VDFPrimitive(it as Float) },
			java.lang.Double::class.java to { VDFPrimitive((it as Double).toFloat()) },
			java.lang.Boolean::class.java to { VDFPrimitive(it as Boolean) },
			java.lang.Number::class.java to { VDFPrimitive(it as Number) }
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
			return VDFPrimitive::class.java.isAssignableFrom(cls) || cls in PRIMITIVE_SERIALIZERS
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