package btpos.source.vdfdsl.backing

import btpos.source.vdfdsl.serialization.IVDFRepresentableValue

/**
 * A list of keyvalues, wrapped in braces when serialized.
 */
data class VDFSubtree(val entries: Collection<VDFKeyValue> = listOf()) : VDFObject(), IVDFRepresentableValue<VDFSubtree> {
	fun withEntry(entry: VDFKeyValue) = VDFSubtree(entries + entry)
	
	fun withEntries(vararg entries: VDFKeyValue) = VDFSubtree(this.entries + entries)
	
	fun withEntries(entries: Iterable<VDFKeyValue>) = VDFSubtree(this.entries + entries)
	
	operator fun plus(entry: VDFKeyValue) = withEntry(entry)
	
	operator fun plus(entries: Iterable<VDFKeyValue>) = withEntries(entries)
	
	override val _vdfRepr: VDFSubtree
		get() = this
	
	companion object {
		fun makeListKeyValue(item: VDFPrimitive) = VDFKeyValue(item, VDFPrimitive.TRUE)
	}
}

fun VDFSubtree.withListItem(item: VDFObject) = withEntry(VDFKeyValue(item, VDFPrimitive.TRUE))

fun VDFSubtree.withListItems(vararg items: VDFObject) = withEntries(items.map { VDFKeyValue(it, VDFPrimitive.TRUE) })

fun VDFSubtree.withListItems(items: Collection<VDFObject>) = withEntries(items.map { VDFKeyValue(it, VDFPrimitive.TRUE) })