package btpos.tf2.popfiledsl.attributes

import btpos.tf2.popfiledsl.modeling.IKeyValueMap
import btpos.tf2.popfiledsl.modeling.delegate
import btpos.tf2.popfiledsl.serialization.PopFileStringLiteral.Companion.literal
import btpos.tf2.popfiledsl.serialization.codecs.ColorCodec
import java.awt.Color


class PaintsScope(container: IKeyValueMap) {
	/**
	 * @see btpos.tf2.popfiledsl.types.PaintColors
	 */
	var color: Color? by container.delegate("item color rgb".literal(), ColorCodec) // god I hate delegates not being inlined.  This is just stupid that I'm making a billion real objects just to not reuse code
}

val WeaponAttributesContainer.paints
	get() = PaintsScope(this)

inline fun WeaponAttributesContainer.paints(configure: PaintsScope.() -> Unit) {
	paints.apply(configure)
}

val ItemAttributesContainer.paints
	get() = PaintsScope(this)

inline fun ItemAttributesContainer.paints(configure: PaintsScope.() -> Unit) {
	paints.apply(configure)
}