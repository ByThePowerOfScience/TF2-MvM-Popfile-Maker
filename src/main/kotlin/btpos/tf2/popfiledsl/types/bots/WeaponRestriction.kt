package btpos.tf2.popfiledsl.types.bots

import btpos.tf2.popfiledsl.serialization.IVDFSerializableValue

enum class WeaponRestriction : IVDFSerializableValue<String> {
	PrimaryOnly,
	SecondaryOnly,
	MeleeOnly;
	
	override val _vdfRepr = name
}