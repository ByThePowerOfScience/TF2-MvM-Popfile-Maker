package btpos.source.vdfdsl.tf2.itemattributes.impl

import btpos.source.vdfdsl.serialization.codecs.Codec
import java.util.EnumSet

class EnumSetOrCodec<T>(val enumClass: Class<T>) : Codec<EnumSet<T>, Any> where T : Enum<T>, T : IEnumCustomValue {
	override fun read(data: Any): EnumSet<T> {
		val data = data as Int
		return enumClass.enumConstants.filterTo(EnumSet.noneOf(enumClass)) { it.value and data != 0 }
	}
	
	override fun write(input: EnumSet<T>): Int {
		return input.fold(0) { i, t -> i or t.value }
	}
	
	companion object {
	    inline operator fun <reified T> invoke(): EnumSetOrCodec<T> where T : Enum<T>, T : IEnumCustomValue {
	        return EnumSetOrCodec(T::class.java)
	    }
	}
}