package btpos.source.vdfdsl.types.bots

import btpos.source.vdfdsl.serialization.IVDFRepresentableValue

enum class WeaponRestriction : IVDFRepresentableValue<String> {
	PrimaryOnly,
	SecondaryOnly,
	MeleeOnly;
	
	override val _vdfRepr get() = name
}