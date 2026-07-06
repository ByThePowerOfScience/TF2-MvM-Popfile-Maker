package btpos.source.vdfdsl.types.bots

import btpos.source.vdfdsl.backing.VDFPrimitive
import btpos.source.vdfdsl.serialization.IVDFRepresentableValue

enum class WeaponRestrictions : IVDFRepresentableValue<VDFPrimitive> {
	PrimaryOnly,
	SecondaryOnly,
	MeleeOnly;
	
	override val _vdfRepr get() = VDFPrimitive(name)
}