package btpos.source.vdfdsl.tf2.itemattributes

import btpos.source.vdfdsl.backing.VDFPrimitive
import btpos.source.vdfdsl.serialization.IVDFRepresentableValue_Trivial
import btpos.source.vdfdsl.tf2.itemattributes.impl.IBlockScoped

object WarPaintsAttributes : IBlockScoped {
	class Wear(val id: Double) : IVDFRepresentableValue_Trivial {
		override val _vdfRepr: VDFPrimitive
			get() = VDFPrimitive(id.toFloat())
		
		companion object {
			val FACTORY_NEW = Wear(0.2)
			val MINIMAL_WEAR = Wear(0.4)
			val FIELD_TESTED = Wear(0.6)
			val WELL_WORN = Wear(0.8)
			val BATTLE_SCARRED = Wear(1.0)
		}
	}
}