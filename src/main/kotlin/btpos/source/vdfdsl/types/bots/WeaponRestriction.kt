package btpos.source.vdfdsl.types.bots

import btpos.source.vdfdsl.serialization.IVDFSerializableValue

enum class WeaponRestriction : IVDFSerializableValue<String> {
	PrimaryOnly,
	SecondaryOnly,
	MeleeOnly;
	
	override val _vdfRepr = name
}