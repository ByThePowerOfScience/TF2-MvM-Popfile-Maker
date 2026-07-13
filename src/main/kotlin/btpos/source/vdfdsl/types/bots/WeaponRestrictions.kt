package btpos.source.vdfdsl.types.bots

import btpos.source.vdfdsl.backing.VDFPrimitive
import btpos.source.vdfdsl.serialization.IVDFRepresentableValue_Trivial

enum class WeaponRestrictions : IVDFRepresentableValue_Trivial {
	PrimaryOnly,
	SecondaryOnly,
	MeleeOnly;
	
	override val _vdfRepr get() = VDFPrimitive(name)
}