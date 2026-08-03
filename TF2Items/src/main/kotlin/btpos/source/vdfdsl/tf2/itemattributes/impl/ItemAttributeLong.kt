package btpos.source.vdfdsl.tf2.itemattributes.impl

import btpos.source.vdfdsl.tf2.itemattributes.IAttributeContainer
import btpos.source.vdfdsl.tf2.itemattributes.ItemAttribute

class ItemAttributeLong(
	private val lowBits: ItemAttribute<Int>,
	private val highBits: ItemAttribute<Int>
) : ItemAttribute<Long> {
	context(attrs: IAttributeContainer)
	override fun set(value: Long?) {
		if (value == null) {
			lowBits.set(null)
			highBits.set(null)
		} else {
			highBits.set((value shr 32).toInt())
			lowBits.set((value and ((1 shl 33) - 1)).toInt())
		}
	}
	
	context(attrs: IAttributeContainer)
	override fun get(): Long? {
		val lo = lowBits.get() ?: return null
		val hi = highBits.get() ?: return null
		return (hi.toLong() shl 32) or lo.toLong()
	}
}