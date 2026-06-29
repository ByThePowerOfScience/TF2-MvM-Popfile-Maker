package btpos.tf2.popfiledsl.attributes

import btpos.tf2.popfiledsl.modeling.IKeyValueMap



val WeaponAttributesContainer.WarPaints
	get() = WarPaintsScope(this)

inline fun WeaponAttributesContainer.WarPaints(configure: WarPaintsScope.() -> Unit) {
	WarPaints.apply(configure)
}