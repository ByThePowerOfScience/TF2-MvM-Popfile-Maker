package btpos.source.vdfdsl.serialization

interface IVDFSerializableKeyValue : IVDFSerializable {
	/**
	 * Add this value to the currently-serialized map.
	 *
	 * @param input The current state of the map to be serialized.
	 * @return The new map to be serialized.
	 */
	fun _serialize(input: VDFSubtree): VDFSubtree
}