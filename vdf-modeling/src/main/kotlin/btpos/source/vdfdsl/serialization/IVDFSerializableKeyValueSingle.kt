package btpos.source.vdfdsl.serialization

/**
 * An item that just serializes to a single key-value entry.
 */
interface IVDFSerializableKeyValueSingle : IVDFSerializableKeyValue {
	fun popFileEntryRepr(): VDFKeyValue
	
	override fun _serialize(input: VDFSubtree): VDFSubtree {
		return input.withEntry(this.popFileEntryRepr())
	}
}