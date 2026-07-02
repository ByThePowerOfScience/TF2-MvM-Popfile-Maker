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
	
	override fun writeToVDF(writer: Appendable, indent: Int) {
		writer.append('{')
		entries.forEach {
			writer.writeLine(indent + 1)
			it.writeToVDF(writer, indent + 1)
		}
		writer.writeLine(indent).append('}')
	}
}