package btpos.source.vdfdsl.tf2.rafmod.types

import btpos.source.vdfdsl.backing.VDFPrimitive
import btpos.source.vdfdsl.serialization.IVDFRepresentableValue_Trivial

open class ItemSlot(val ordinal: Int) : IVDFRepresentableValue_Trivial {
	companion object {
		@JvmField val PRIMARY = ItemSlot(0)
		@JvmField val SECONDARY = ItemSlot(1)
		@JvmField val MELEE = ItemSlot(2)
		@JvmField val UTILITY = ItemSlot(3)
		@JvmField val BUILDING = ItemSlot(4)
		@JvmField val PDA = ItemSlot(5)
		@JvmField val PDA2 = ItemSlot(6)
	}
	
	override val _vdfRepr = VDFPrimitive(this.ordinal)
}