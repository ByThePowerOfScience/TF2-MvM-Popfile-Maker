package btpos.source.vdfdsl.serialization

@JvmRecord
data class VDFPrimitive(val value: Any) : IVDFSerializable {
	init {
		require(value is Number || value is String || value is Boolean) {
			"Invalid primitive: primitive values may only be Number, String, or Boolean."
		}
	}
}