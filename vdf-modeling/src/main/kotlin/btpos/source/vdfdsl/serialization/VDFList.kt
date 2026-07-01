package btpos.source.vdfdsl.serialization

/**
 * Look, technically this doesn't actually exist, but I kinda gotta include this cause otherwise DFU throws a fit
 *
 * There are multiple ways to serialize a list in VDF: a map where the keys are all that are read, or a single key being present with multiple values in the table.
 */
data class VDFList(val items: List<IVDFSerializable>) : IVDFSerializable {
	fun withItem(item: IVDFSerializable) = VDFList(this.items + item)
	
	fun withItems(vararg items: IVDFSerializable) = VDFList(this.items + items)
	
	fun withItems(items: Collection<IVDFSerializable>) = VDFList(this.items + items)
}