package btpos.source.vdfdsl.tf2.rafmod.codecs

import btpos.source.vdfdsl.serialization.codecs.Codec
import btpos.source.vdfdsl.tf2.itemattributes.impl.IEnumCustomValue
import btpos.source.vdfdsl.tf2.tftypes.TFCondition

object TFCondCodec_Index : Codec<TFCondition, Any> {
	override fun read(data: Any): TFCondition? {
		return (data as? Int)?.let { TFCondition.valueOf(it) }
	}
	
	override fun write(input: TFCondition): Any {
		return input.index
	}
}

val TFCondIndexSetCodec = SetToIntCodec(TFCondition::index) {
	require(it <= 4) {
		"Attribute can only hold a maximum of 4 conditions."
	}
	8 * it
}

fun <T : Any> SetToIntCodec(
	encodeItem: (T) -> Int,
	bitshift: (index: Int) -> Int
): (Set<T>) -> Int {
	return fun(input: Set<T>): Int {
		var curr = 0
		for ((i, el) in input.withIndex()) {
			curr = curr or (encodeItem(el) shl bitshift(i))
		}
		return curr
	}
}