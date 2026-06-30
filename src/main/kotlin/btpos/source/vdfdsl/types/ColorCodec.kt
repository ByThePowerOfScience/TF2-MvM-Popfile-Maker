package btpos.source.vdfdsl.types

import btpos.source.vdfdsl.serialization.codecs.Codec
import java.awt.Color

object ColorCodec : Codec<Color, PaintColors> {
	override fun read(data: PaintColors): Color = data.color
	
	override fun write(input: Color): PaintColors  = PaintColors(input)
}