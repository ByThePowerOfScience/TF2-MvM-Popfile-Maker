package btpos.source.vdfdsl.tf2.itemattributes

import btpos.source.vdfdsl.modeling.IKeyValueMap
import btpos.source.vdfdsl.tf2.items.PaintColors

context(attrs: IKeyValueMap)
var paintColor: PaintColors?
	get() = attrs.getTyped("set item tint rgb")
	set(value) = attrs.setNullable("set item tint rgb", value)