package btpos.source.vdfdsl.modeling

import btpos.source.vdfdsl.serialization.IVDFSerializableKeyValue
import btpos.source.vdfdsl.serialization.VDFKeyValue
import btpos.source.vdfdsl.serialization.VDFSubtree

/**
 * A structure in an MvM popfile, modeled as an extensible map that can contain multiple mappings for a single key.
 *
 * Structs resolve to a [VDFKeyValue] that is a pair of its _identifier_ and its _map_.
 *
 * Structs essentially only differ from normal "key: someMap" entries in that they have their own unchanging key that defines their type.
 */
abstract class AbstractVDFStruct(protected val _subtree: MvMSubtreeImpl = MvMSubtreeImpl()) : IVDFSerializableKeyValue, IExtensibleSubtree by _subtree {
	override fun _serialize(input: VDFSubtree): VDFSubtree = input.withEntry(VDFKeyValue(_structIdentifier, _subtree._vdfRepr))
	
	/**
	 * The key this item is always given in a subtree, used to identify it as a specific kind of structure.
	 */
	abstract val _structIdentifier: Any
}