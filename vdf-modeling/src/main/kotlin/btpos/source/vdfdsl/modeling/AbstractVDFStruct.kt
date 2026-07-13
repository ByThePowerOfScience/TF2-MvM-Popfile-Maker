package btpos.source.vdfdsl.modeling

import btpos.source.vdfdsl.serialization.IVDFRepresentableKeyValue
import btpos.source.vdfdsl.backing.VDFKeyValue
import btpos.source.vdfdsl.backing.VDFPrimitive
import btpos.source.vdfdsl.backing.VDFSubtree

/**
 * A structure in an MvM popfile, modeled as an extensible map that can contain multiple mappings for a single key.
 *
 * Structs resolve to a [VDFKeyValue] that is a pair of its _identifier_ and its _map_.
 *
 * Structs essentially only differ from normal "key: someMap" entries in that they have their own unchanging key that defines their type.
 */
abstract class AbstractVDFStruct(private val _subtree: IExtensibleSubtree_VDFRepresentable = ExtensibleSubtreeImpl())
	: IVDFRepresentableKeyValue, IExtensibleSubtree by _subtree
{
	override fun _serializeInto(input: VDFSubtree) {
		_subtree._toKeyValueRepresentable(VDFPrimitive(_structIdentifier))._serializeInto(input)
	}
	
	/**
	 * The key this item is always given in a subtree, used to identify it as a specific kind of structure.
	 */
	abstract val _structIdentifier: String
	
	protected fun copyInternal() = _subtree.copy()
	
	abstract override fun copy(): AbstractVDFStruct
}