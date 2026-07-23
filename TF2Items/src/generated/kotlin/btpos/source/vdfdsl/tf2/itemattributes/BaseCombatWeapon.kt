package btpos.source.vdfdsl.tf2.itemattributes

import btpos.source.vdfdsl.modeling.*
import btpos.source.vdfdsl.serialization.codecs.*
import btpos.source.vdfdsl.tf2.itemattributes.impl.*
import java.util.*


interface BaseCombatWeaponAttributes : BaseEntityAttributes, IBlockScoped {
	companion object : BaseCombatWeaponAttributes
	
	/**
	 * In-Game: "Uses metal for ammo"
	 *
	 * 
	 *
	 * Reminder: non-engies start with 100 metal.
	 */
	context(attrs: IKeyValueMap)
	var useMetalAmmoType: Boolean?
		get() = attrs.getTyped("mod use metal ammo type", BinaryIntCodec)
		set(value) = attrs.setNullable("mod use metal ammo type", value, BinaryIntCodec)
	
	/**
	 * 
	 *
	 * Overwrites the max clipsize to a flat value. Applied before other multipliers.
	 */
	context(attrs: IKeyValueMap)
	var maxPrimaryClipOverride: Int?
		get() = attrs.getTyped("mod max primary clip override")
		set(value) = attrs.setNullable("mod max primary clip override", value)
	
	/**
	 * In-Game: "No reload necessary"
	 *
	 * 
	 *
	 * In the "DoesReloadSingly" check, this _is_ actually checked, so it's actually _not_ "display-only".
	 *
	 * If != 1.0 (if present), says the weapon "does not reload one shot at a time".
	 */
	context(attrs: IKeyValueMap)
	var noReload_displayOnly: Int?
		get() = attrs.getTyped("mod no reload DISPLAY ONLY")
		set(value) = attrs.setNullable("mod no reload DISPLAY ONLY", value)
	
	/**
	 * 
	 *
	 * Checked in the same place.  If true, weapon does not reload one shot at a time. (e.g. FaN).
	 *
	 * Note that for the most part, this logic is set inside the weapon itself. The scattergun thing is weirdly the only way to control this with attributes.
	 */
	context(attrs: IKeyValueMap)
	var scattergunNoReloadSingle: Boolean?
		get() = attrs.getTyped("scattergun no reload single", BinaryIntCodec)
		set(value) = attrs.setNullable("scattergun no reload single", value, BinaryIntCodec)
}

