package btpos.source.vdfdsl.tf2.itemattributes.impl

import btpos.source.vdfdsl.serialization.IVDFRepresentableKeyValue
import btpos.source.vdfdsl.tf2.itemattributes.ItemAttribute
import btpos.source.vdfdsl.tf2.itemattributes.ItemAttributeNamed

private const val INT_BITMASK: Long = (1L shl 33) - 1L

data class ItemAttributeLong(
	val lowBits: ItemAttributeNamed<Int>,
	val highBits: ItemAttributeNamed<Int>
) : ItemAttribute<Long> {
	
	
	override fun serialize(value: Long?): IVDFRepresentableKeyValue {
		val higher = value?.shl(32)?.and(INT_BITMASK)?.toInt()
		val lower = value?.and(INT_BITMASK)?.toInt()
		val lowBits = lowBits.serialize(lower)
		val highBits = highBits.serialize(higher)
		return IVDFRepresentableKeyValue { parent, forcedCond ->
			lowBits._serializeInto(parent, forcedCond)
			highBits._serializeInto(parent, forcedCond)
		}
		
	}
}