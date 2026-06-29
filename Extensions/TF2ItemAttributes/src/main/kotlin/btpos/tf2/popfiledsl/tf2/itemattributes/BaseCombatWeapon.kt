package btpos.tf2.popfiledsl.tf2.itemattributes

import btpos.tf2.popfiledsl.modeling.*
import btpos.tf2.popfiledsl.serialization.codecs.*


/**
 * 
 */
interface BaseCombatWeaponAttributes {
	companion object : BaseCombatWeaponAttributes
	
	/**
	 * Reminder: non-engies start with 100 metal.
	 * 
	 */
	context(attrs: IKeyValueMap)
	var modUseMetalAmmoType: Boolean?
		get() = attrs.getTyped("mod use metal ammo type", BinaryIntCodec)
		set(value) = attrs.setNullable("mod use metal ammo type", value, BinaryIntCodec)
	
	/**
	 * Overwrites the max clipsize to a flat value. Applied before other multipliers.
	 * 
	 */
	context(attrs: IKeyValueMap)
	var modMaxPrimaryClipOverride: Int?
		get() = attrs.getTyped("mod max primary clip override")
		set(value) = attrs.setNullable("mod max primary clip override", value)
	
	/**
	 * In the `DoesReloadSingly` check, this _is_ actually checked, so it's actually _not_ "display-only".
	 * 
	 * If != 1.0 (if present), says the weapon "does not reload one shot at a time".
	 * 
	 */
	context(attrs: IKeyValueMap)
	var modNoReloadDISPLAYONLY: Int?
		get() = attrs.getTyped("mod no reload DISPLAY ONLY")
		set(value) = attrs.setNullable("mod no reload DISPLAY ONLY", value)
	
	/**
	 * Checked in `DoesReloadSingly`.  If true, weapon does not reload one shot at a time. (e.g. FaN)
	 * 
	 * Note that for the most part, this logic is set inside the weapon itself. The scattergun thing is weirdly the only way to control this with attributes.
	 * 
	 */
	context(attrs: IKeyValueMap)
	var scattergunNoReloadSingle: Boolean?
		get() = attrs.getTyped("scattergun no reload single", BinaryIntCodec)
		set(value) = attrs.setNullable("scattergun no reload single", value, BinaryIntCodec)
}

inline operator fun BaseCombatWeaponAttributes.invoke(scope: BaseCombatWeaponAttributes.() -> Unit) {
	this.apply(scope)
}

