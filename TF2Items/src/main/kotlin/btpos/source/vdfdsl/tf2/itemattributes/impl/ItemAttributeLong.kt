package btpos.source.vdfdsl.tf2.itemattributes.impl

import btpos.source.vdfdsl.backing.VDFKeyValue
import btpos.source.vdfdsl.serialization.IVDFRepresentableKeyValue
import btpos.source.vdfdsl.serialization.IVDFRepresentableValue
import btpos.source.vdfdsl.tf2.itemattributes.ItemAttribute

private const val INT_BITMASK: Long = (1L shl 33) - 1L

open class ItemAttributeLong(
	protected val lowBits: ItemAttribute<Int>,
	protected val highBits: ItemAttribute<Int>
) : ItemAttribute<Long> {
	
	
	override fun serialize(value: Long?): IVDFRepresentableKeyValue {
		val higher = value?.shl(32)?.and(INT_BITMASK)?.toInt()
		val lower = value?.and(INT_BITMASK)?.toInt()
		val lowBits = lowBits.serialize(lower)
		val highBits = highBits.serialize(higher)
		return IVDFRepresentableKeyValue { parent ->
			lowBits._serializeInto(parent)
			highBits._serializeInto(parent)
		}
		
	}
}