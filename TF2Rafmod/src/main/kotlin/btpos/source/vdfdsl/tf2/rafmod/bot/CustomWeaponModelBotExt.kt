package btpos.source.vdfdsl.tf2.rafmod.bot


import btpos.source.vdfdsl.modeling.ExtensibleSubtreeImpl
import btpos.source.vdfdsl.modeling.IExtensibleSubtree.Companion.addField
import btpos.source.vdfdsl.modeling.IExtensibleSubtree.Companion.selfNamedList
import btpos.source.vdfdsl.modeling.IExtensibleSubtree_VDFRepresentable
import btpos.source.vdfdsl.tf2.PopFileDSL
import btpos.source.vdfdsl.tf2.rafmod.RafmodConstants.SIGSEGV
import btpos.source.vdfdsl.tf2.rafmod.types.ItemSlot
import btpos.source.vdfdsl.types.spawners.TFBotSpawner

@PopFileDSL
open class CustomWeaponModelBotExt protected constructor(subtree: IExtensibleSubtree_VDFRepresentable = ExtensibleSubtreeImpl()) : RafmodBotExtension(subtree) {
	constructor(slot: ItemSlot, model: String) : this() {
		this.slot = slot
		this.model = model
	}
	
	override fun copy() = CustomWeaponModelBotExt(copyInternal())
	
	override val _structIdentifier get() = "CustomWeaponModel"
	
	
	/**
	 * The loadout position to replace the weapon model
	 *
	 * Example:
	 * ```kotlin
	 * slot = ItemSlot.PRIMARY
	 * ```
	 */
	open var slot: ItemSlot? by addField("Slot", conditional = SIGSEGV)
	
	/**
	 * The model to replace the item in the given [slot] with.
	 *
	 * Note: The model must be [precached][btpos.source.vdfdsl.tf2.rafmod.RafmodWaveScheduleExtensions.precache] if it isn't part of the current map.  Double-check this if you end up with "ERROR" models.
	 *
	 * Example:
	 * ```kotlin
	 * model = "models/weapons/w_models/w_minigun.mdl"
	 * ```
	 */
	open var model: String? by addField("Model", conditional = SIGSEGV)
}

/**
 * Set a custom weapon model for a specific slot.
 *
 * Alternatively, you can use the [customItemModel] attribute. // TODO
 *
 * Note: The model must be [precached][btpos.source.vdfdsl.tf2.rafmod.RafmodWaveScheduleExtensions.precache] if it isn't part of the current map.  Double-check this if you end up with "ERROR" models.
 *
 * Example:
 * ```kotlin
 * TFBot {
 *     addCustomWeaponModel(ItemSlot.PRIMARY, "models/weapons/w_models/w_minigun.mdl")
 * }
 * ```
 */
fun TFBotSpawner.addCustomWeaponModel(slot: ItemSlot, model: String) {
    this.customWeaponModels += CustomWeaponModelBotExt(slot, model)
}

/**
 * Set a custom weapon model for a specific slot.
 *
 * @see addCustomWeaponModel
 */
var TFBotSpawner.customWeaponModels: List<CustomWeaponModelBotExt> by selfNamedList()

