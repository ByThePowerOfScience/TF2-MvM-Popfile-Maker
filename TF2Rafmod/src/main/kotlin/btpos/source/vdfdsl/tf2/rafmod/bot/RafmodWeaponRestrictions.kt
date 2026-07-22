package btpos.source.vdfdsl.tf2.rafmod.bot

import btpos.source.vdfdsl.backing.VDFPrimitive
import btpos.source.vdfdsl.serialization.IVDFRepresentableKeyValue
import btpos.source.vdfdsl.tf2.rafmod.RafmodConstants.SIGSEGV
import btpos.source.vdfdsl.types.bots.WeaponRestrictions

/**
 * Rafmod's additions to the [WeaponRestrictions] enum-like.
 */
open class RafmodWeaponRestrictions(name: String) : WeaponRestrictions(name) {
	override fun _toKeyValueRepresentable(key: VDFPrimitive, conditional: String?): IVDFRepresentableKeyValue {
		return super._toKeyValueRepresentable(key, SIGSEGV)
	}
	
	companion object {
		@JvmField val PDAOnly = RafmodWeaponRestrictions("PDAOnly")
		
		@JvmField val BuildingOnly = RafmodWeaponRestrictions("BuildingOnly")
	}
}

val WeaponRestrictions.Companion.PDAOnly get() = RafmodWeaponRestrictions.PDAOnly

val WeaponRestrictions.Companion.BuildingOnly get() = RafmodWeaponRestrictions.BuildingOnly
