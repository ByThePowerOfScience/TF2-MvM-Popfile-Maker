package btpos.source.vdfdsl.collections

import btpos.source.vdfdsl.backing.VDFKeyValue
import btpos.source.vdfdsl.backing.VDFPrimitive
import btpos.source.vdfdsl.backing.VDFSubtree
import btpos.source.vdfdsl.serialization.IVDFRepresentableKeyValue
import btpos.source.vdfdsl.serialization.IVDFRepresentableValue

/**
 * Serializes to multiple versions of the same key in the same subtree, like this:
 *
 * ```
 * // given [foo, bar]:
 * Item foo
 * Item bar
 * ```
 */
class VDFList_Flat<T : Any> @PublishedApi internal constructor (private val key: String, private val backingList: MutableList<T> = mutableListOf())
	: MutableList<T> by backingList, IVDFRepresentableKeyValue
{
	override fun _serialize(input: VDFSubtree): VDFSubtree {
		val prim = VDFPrimitive(key)
		return input.withEntries(backingList.map { VDFKeyValue(prim, IVDFRepresentableValue.serializeDynamic(it)) })
	}
	
	
	companion object {
	    inline operator fun <reified T : Any> invoke(key: String): VDFList_Flat<T> {
		    IVDFRepresentableValue.requireValueRepresentable(T::class.java)
		    return VDFList_Flat(key)
	    }
	}
}