package btpos.source.vdfdsl.serialization

import btpos.source.vdfdsl.backing.VDFKeyValue
import btpos.source.vdfdsl.backing.VDFSubtree

interface IVDFRepresentableKeyValue : IVDFRepresentable {
	/**
	 * Add this value to the currently-serialized map.
	 *
	 * @param input The current state of the map to be serialized.
	 * @return The new map to be serialized.
	 */
	fun _serialize(input: VDFSubtree): VDFSubtree
}


/**
 * An item that just serializes to a single key-value entry.
 */
interface IVDFRepresentableKeyValueSingle : IVDFRepresentableKeyValue {
	fun popFileEntryRepr(): VDFKeyValue
	
	override fun _serialize(input: VDFSubtree): VDFSubtree {
		return input.withEntry(this.popFileEntryRepr())
	}
}