package btpos.source.vdfdsl.serialization

/**
 * Marker class, so we can wrap the collection of pairs in braces when serializing.
 */
data class VDFSubtree(val entries: Collection<VDFKeyValue> = listOf()) : IVDFSerializable {
	fun withEntry(entry: VDFKeyValue) = VDFSubtree(entries + entry)
	
	fun withEntries(vararg entries: VDFKeyValue) = VDFSubtree(this.entries + entries)
	
	fun withEntries(entries: Iterable<VDFKeyValue>) = VDFSubtree(this.entries + entries)
	
	operator fun plus(entry: VDFKeyValue) = withEntry(entry)
	
	
	operator fun plus(entries: Iterable<VDFKeyValue>) = withEntries(entries)
}