package btpos.source.vdfdsl.tf2.rafmod.types

import btpos.source.vdfdsl.backing.VDFPrimitive
import btpos.source.vdfdsl.serialization.IVDFRepresentableValue_Trivial

enum class ItemSlot : IVDFRepresentableValue_Trivial {
	PRIMARY,
	SECONDARY,
	MELEE,
	UTILITY,
	BUILDING,
	PDA,
	PDA2;
	
	override val _vdfRepr = VDFPrimitive(this.ordinal)
}