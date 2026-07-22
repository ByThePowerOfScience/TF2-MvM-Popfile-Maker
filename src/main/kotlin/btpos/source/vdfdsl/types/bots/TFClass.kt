package btpos.source.vdfdsl.types.bots

import btpos.source.vdfdsl.backing.VDFPrimitive
import btpos.source.vdfdsl.serialization.IVDFRepresentableValue_Trivial

open class TFClass(val name: String) : IVDFRepresentableValue_Trivial {
	companion object {
		@JvmField val Scout = TFClass("Scout")
		@JvmField val Soldier = TFClass("Soldier")
		@JvmField val Pyro = TFClass("Pyro")
		@JvmField val Demoman = TFClass("Demoman")
		@JvmField val HeavyWeapons = TFClass("HeavyWeapons")
		@JvmField val Engineer = TFClass("Engineer")
		@JvmField val Medic = TFClass("Medic")
		@JvmField val Sniper = TFClass("Sniper")
		@JvmField val Spy = TFClass("Spy")
	}
	
	
	
	override val _vdfRepr: VDFPrimitive = VDFPrimitive(name)
	
	override fun toString(): String = name
}