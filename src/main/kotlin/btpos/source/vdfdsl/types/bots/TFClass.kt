package btpos.source.vdfdsl.types.bots

import btpos.source.vdfdsl.backing.VDFPrimitive
import btpos.source.vdfdsl.serialization.IVDFRepresentableValue

enum class TFClass : IVDFRepresentableValue<VDFPrimitive> {
	Scout,
	Soldier,
	Pyro,
	Demoman,
	HeavyWeapons,
	Engineer,
	Medic,
	Sniper,
	Spy;
	
	override val _vdfRepr: VDFPrimitive
		get() = VDFPrimitive(name)
	
	override fun toString(): String = name
}