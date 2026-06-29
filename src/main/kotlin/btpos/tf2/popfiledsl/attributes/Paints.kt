package btpos.tf2.popfiledsl.attributes

import btpos.tf2.popfiledsl.modeling.IKeyValueMap
import btpos.tf2.popfiledsl.modeling.delegate
import btpos.tf2.popfiledsl.serialization.VDFStringLiteral.Companion.literal
import btpos.tf2.popfiledsl.serialization.codecs.ColorCodec
import java.awt.Color




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