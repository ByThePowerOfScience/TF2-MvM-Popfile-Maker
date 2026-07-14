package btpos.source.vdfdsl.backing

import btpos.source.vdfdsl.serialization.IVDFRepresentableValue_Trivial

@ExposedCopyVisibility
data class VDFPrimitive private constructor(val stringValue: String) : VDFObject(), IVDFRepresentableValue_Trivial {
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
		@Suppress("PLATFORM_CLASS_MAPPED_TO_KOTLIN", "RemoveRedundantQualifierName") // Int::class.java => int.class instead of Integer.class
		private val PRIMITIVE_SERIALIZERS = mapOf<Class<*>, (Any) -> VDFPrimitive>(
			java.lang.String::class.java to { VDFPrimitive(s=it as String) },
			java.lang.Integer::class.java to { VDFPrimitive(it as Int) },
			java.lang.Float::class.java to { VDFPrimitive(it as Float) },
			java.lang.Double::class.java to { VDFPrimitive((it as Double).toFloat()) },
			java.lang.Boolean::class.java to { VDFPrimitive(it as Boolean) },
			java.lang.Number::class.java to { VDFPrimitive(it as Number) }
		)
		
		fun tryCreatePrimitive(obj: Any): VDFPrimitive? {
			val javaClass = obj.javaClass
			if (javaClass.isPrimitive) {
				error("Somehow $obj got here as a primitive without being boxed.")
			}
			
			PRIMITIVE_SERIALIZERS.forEach { (k, v) ->
				if (k.isAssignableFrom(javaClass)) {
					return v(obj);
				}
			}
			return null;
		}
		
		
		val TRUE = VDFPrimitive(s="1")
		val FALSE = VDFPrimitive(s="0")
		
	    operator fun invoke(bool: Boolean): VDFPrimitive {
	        return if (bool) TRUE else FALSE
	    }
		
		operator fun invoke(s: String): VDFPrimitive {
			return VDFPrimitive(stringValue = s.intern())
		}
		
		operator fun invoke(n: Number) = when (n) {
			is Int -> VDFPrimitive(n)
			is Float -> VDFPrimitive(n)
			is Double -> VDFPrimitive(n.toFloat())
			else -> VDFPrimitive(stringValue=n.toString()) // longs can't REALLY be serialized as integers, but they can be serialized as strings
		}
		
		operator fun invoke(o: Any) = when (o) {
			is String -> VDFPrimitive(s=o)
			is Number -> VDFPrimitive(o)
			is Boolean -> VDFPrimitive(bool=o)
			else -> throw IllegalArgumentException("Object $o is not a primitive. Valid types: String, Number, Boolean")
		}
		
		fun isPrimitive(cls: Class<*>): Boolean {
			return VDFPrimitive::class.java.isAssignableFrom(cls) || PRIMITIVE_SERIALIZERS.any { it.key.isAssignableFrom(cls) }
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

val VDFPrimitive.intValue get() = this.stringValue.toInt()

val VDFPrimitive.floatValue get() = this.stringValue.toFloat()

