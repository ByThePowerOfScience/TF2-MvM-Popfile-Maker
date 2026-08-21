package btpos.source.vdfdsl.types.bots

import btpos.source.vdfdsl.backing.VDFPrimitive
import btpos.source.vdfdsl.codegen.ConstantsDecoder
import btpos.source.vdfdsl.serialization.IVDFRepresentableValue_Trivial
import btpos.source.vdfdsl.tf2.tftypes.TFCondition.Companion.MeleeOnly

open class WeaponRestrictions(val name: String) : IVDFRepresentableValue_Trivial {
	companion object {
		val PrimaryOnly = WeaponRestrictions("PrimaryOnly")
		val SecondaryOnly = WeaponRestrictions("SecondaryOnly")
		val MeleeOnly = WeaponRestrictions("MeleeOnly")
		
		
		val CODEGEN = ConstantsDecoder<WeaponRestrictions>()
	}
	
	override val _vdfRepr = VDFPrimitive(name)
}