package btpos.source.vdfdsl.tf2.rafmod.codecs

import btpos.source.vdfdsl.serialization.codecs.Codec
import btpos.source.vdfdsl.tf2.tftypes.TFCondition

object TFCondCodec_Index : Codec<TFCondition, Any> {
	override fun read(data: Any): TFCondition? {
		return (data as? Int)?.let { TFCondition.valueOf(it) }
	}
	
	override fun write(input: TFCondition): Any {
		return input.index
	}
}