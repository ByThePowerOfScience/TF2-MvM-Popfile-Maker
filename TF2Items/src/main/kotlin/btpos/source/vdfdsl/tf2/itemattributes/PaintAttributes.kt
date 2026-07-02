package btpos.source.vdfdsl.tf2.itemattributes

import btpos.source.vdfdsl.modeling.IKeyValueMap
import btpos.source.vdfdsl.serialization.codecs.Codec
import btpos.source.vdfdsl.tf2.items.PaintColors
import java.awt.Color

/**
 * @see PaintColors
 */
context(attrs: IKeyValueMap)
var WearableAttributes.paintColor: Color?
	get() = attrs.getTyped("set item tint rgb", ColorCodec)
	set(value) = attrs.setNullable("set item tint rgb", value, ColorCodec)

/**
 * @see PaintColors
 */
context(attrs: IKeyValueMap)
var WeaponBaseAttributes.paintColor: Color?
	get() = attrs.getTyped("set item tint rgb", ColorCodec)
	set(value) = attrs.setNullable("set item tint rgb", value, ColorCodec)


object ColorCodec : Codec<Color, Any> {
	override fun read(data: Any): Color {
		return PaintColors.intToColor(data as Int)
	}
	
	override fun write(input: Color): Int {
		return PaintColors.rgbToInt(input.red, input.green, input.blue)
	}
}