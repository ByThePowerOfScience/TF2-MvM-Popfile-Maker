package btpos.source.vdfdsl.backing

import btpos.source.vdfdsl.serialization.IVDFRepresentableValue

data class VDFPrimitive(val stringValue: String) : VDFObject(), IVDFRepresentableValue<VDFPrimitive> {
	
	constructor(i: Int) : this(i.toString())
	
	constructor(i: Float) : this(i.toString())
	
	
	
	companion object {
		val TRUE = VDFPrimitive("1")
		val FALSE = VDFPrimitive("0")
		
	    operator fun invoke(bool: Boolean): VDFPrimitive {
	        return if (bool) TRUE else FALSE
	    }
		
		
		fun fromNumber(n: Number) = when (n) {
			is Int -> VDFPrimitive(n)
			is Float -> VDFPrimitive(n)
			is Double -> VDFPrimitive(n.toFloat())
			else -> VDFPrimitive(n.toString()) // longs can't REALLY be serialized as integers, but they can be serialized as strings
		}
	}
	
	override val _vdfRepr: VDFPrimitive
		get() = this
	
	
	val booleanValue: Boolean?
		get() = stringValue.singleOrNull()?.takeIf { it == '1' || it == '0' }?.let { it == '1' }

	val numberValue: Number?
		get() {
			var numDots = 0

			stringValue.forEach {
				if (it == '.') {
					++numDots
				} else if (!it.isDigit()) {
					return null;
				}
			}

			return when (numDots) {
				0 -> stringValue.toInt()
				1 -> stringValue.toFloat()
				else -> null
			}
		}
}