package btpos.tf2.popfiledsl.serialization.codecs

import btpos.tf2.popfiledsl.types.PaintColors
import java.awt.Color

object ColorCodec : Codec<Color, PaintColors> {
	override fun read(data: PaintColors): Color = data.color
	
	override fun write(input: Color): PaintColors  = PaintColors(input)
}