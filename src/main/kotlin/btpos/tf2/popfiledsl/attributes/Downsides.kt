package btpos.tf2.popfiledsl.attributes

import btpos.tf2.popfiledsl.modeling.KeyValueMapImpl
import btpos.tf2.popfiledsl.modeling.delegate
import btpos.tf2.popfiledsl.serialization.PopFileStringLiteral.Companion.literal


class DownsidesScope(attr: KeyValueMapImpl) {
	var FIRERATE_PENALTY: Double? by attr.delegate("fire rate penalty".literal())
}

