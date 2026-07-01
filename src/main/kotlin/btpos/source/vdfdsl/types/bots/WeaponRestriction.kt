package btpos.source.vdfdsl.types.bots

import btpos.source.vdfdsl.serialization.IVDFSerializableValue_Primitive

enum class WeaponRestriction : IVDFSerializableValue_Primitive<String> {
	PrimaryOnly,
	SecondaryOnly,
	MeleeOnly;
	
	override val _primitiveRepr = name
}