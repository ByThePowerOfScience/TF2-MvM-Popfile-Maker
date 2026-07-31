package btpos.source.vdfdsl.tf2.itemattributes

import btpos.source.vdfdsl.serialization.codecs.Codec
import btpos.source.vdfdsl.tf2.items.PaintColors
import java.awt.Color


object ColorCodec : Codec<Color, Any> {
	override fun read(data: Any): Color {
		return PaintColors.intToColor(data as Int)
	}
	
	override fun write(input: Color): Int {
		return PaintColors.rgbToInt(input.red, input.green, input.blue)
	}
}