package btpos.source.vdfdsl.tf2.itemattributes

import btpos.source.vdfdsl.modeling.*
import btpos.source.vdfdsl.serialization.codecs.*
import btpos.source.vdfdsl.tf2.itemattributes.impl.*
import btpos.source.vdfdsl.tf2.tftypes.*
import java.util.*




interface BaseCombatWeaponAttributes : BaseEntityAttributes {
	
	companion object {
		/**
		 * In-Game: "Uses metal for ammo"
		 * 
		 * Reminder: non-engies start with 100 metal.
		 */
		val useMetalAmmoType: ItemAttributeNamed<Boolean> = ItemAttributeNamed("mod use metal ammo type")
	
		/**
		 * Overwrites the max clipsize to a flat value. Applied before other multipliers.
		 */
		val maxPrimaryClipOverride: ItemAttributeNamed<Int> = ItemAttributeNamed("mod max primary clip override")
	
		/**
		 * In-Game: "No reload necessary"
		 * 
		 * In the "DoesReloadSingly" check, this _is_ actually checked, so it's actually _not_ "display-only".
		 * 
		 * If != 1.0 (if present), says the weapon "does not reload one shot at a time".
		 */
		val noReload_displayOnly: ItemAttributeNamed<Float> = ItemAttributeNamed("mod no reload DISPLAY ONLY")
	
		/**
		 * Checked in the same place.  If true, weapon does not reload one shot at a time. (e.g. FaN).
		 * 
		 * Note that for the most part, this logic is set inside the weapon itself. The scattergun thing is weirdly the only way to control this with attributes.
		 */
		val scattergunNoReloadSingle: ItemAttributeNamed<Boolean> = ItemAttributeNamed("scattergun no reload single")
	}

	/**
	 * In-Game: "Uses metal for ammo"
	 * 
	 * Reminder: non-engies start with 100 metal.
	 */
	val useMetalAmmoType: ItemAttributeNamed<Boolean> get() = BaseCombatWeaponAttributes.useMetalAmmoType
	
	/**
	 * Overwrites the max clipsize to a flat value. Applied before other multipliers.
	 */
	val maxPrimaryClipOverride: ItemAttributeNamed<Int> get() = BaseCombatWeaponAttributes.maxPrimaryClipOverride
	
	/**
	 * In-Game: "No reload necessary"
	 * 
	 * In the "DoesReloadSingly" check, this _is_ actually checked, so it's actually _not_ "display-only".
	 * 
	 * If != 1.0 (if present), says the weapon "does not reload one shot at a time".
	 */
	val noReload_displayOnly: ItemAttributeNamed<Float> get() = BaseCombatWeaponAttributes.noReload_displayOnly
	
	/**
	 * Checked in the same place.  If true, weapon does not reload one shot at a time. (e.g. FaN).
	 * 
	 * Note that for the most part, this logic is set inside the weapon itself. The scattergun thing is weirdly the only way to control this with attributes.
	 */
	val scattergunNoReloadSingle: ItemAttributeNamed<Boolean> get() = BaseCombatWeaponAttributes.scattergunNoReloadSingle
}