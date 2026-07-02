package btpos.source.vdfdsl.collections

import btpos.source.vdfdsl.backing.VDFKeyValue
import btpos.source.vdfdsl.backing.VDFObject
import btpos.source.vdfdsl.backing.VDFPrimitive
import btpos.source.vdfdsl.backing.VDFSubtree
import btpos.source.vdfdsl.serialization.IVDFRepresentableKeyValue
import btpos.source.vdfdsl.serialization.IVDFRepresentableValue
import btpos.source.vdfdsl.serialization.IVDFRepresentableValue.Companion.requireValueRepresentable

/**
 * A list represented as a subtree, with the keys being the items in the list and its values being ignored. (usually `"1"`)
 *
 * ```
 * // given [item1, item2, item3]:
 * "my_items"
 * {
 *   "item1" "1"
 *   "item2" "1"
 *   "item3" "1"
 * }
 */
class VDFList_Map<T : Any> @PublishedApi internal constructor(private val dummyValue: VDFObject = VDFPrimitive.TRUE, val backingList: MutableList<T> = mutableListOf())
	: MutableList<T> by backingList, IVDFRepresentableValue<VDFSubtree>
{
	override val _vdfRepr: VDFSubtree
		get() = VDFSubtree(backingList.map { VDFKeyValue(VDFPrimitive(it), dummyValue) })
	
	companion object {
		/**
		 * @param dummyValue The value given to each key, usually ignored. Defaults to `"1"`.
		 */
	    inline operator fun <reified T : Any> invoke(dummyValue: VDFObject = VDFPrimitive.TRUE): VDFList_Map<T> {
			VDFPrimitive.requirePrimitive(T::class.java)
		    return VDFList_Map<T>(dummyValue)
	    }
	}
}