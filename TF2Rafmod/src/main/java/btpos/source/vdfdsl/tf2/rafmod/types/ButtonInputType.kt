package btpos.source.vdfdsl.tf2.rafmod.types

import btpos.source.vdfdsl.backing.VDFPrimitive
import btpos.source.vdfdsl.serialization.IVDFRepresentableValue_Trivial

class ButtonInputType(override val _vdfRepr: VDFPrimitive) : IVDFRepresentableValue_Trivial {
	constructor(name: String) : this(VDFPrimitive.Companion(name))
	
	companion object {
		/**
		 * Emulates a left-click/MOUSE1 action.
		 *
		 * Note: Can be paired with [SuppressFire][btpos.source.vdfdsl.types.bots.TFBotAttributes.SuppressFire] to control when a bot attacks.
		 */
		@JvmField val MOUSE1 = ButtonInputType("Primary")
		
		/**
		 * Emulates a right-click/MOUSE2 action.
		 */
		@JvmField val MOUSE2 = ButtonInputType("Secondary")
		
		/**
		 * Emulates a middle-click/"MOUSE3" action.
		 */
		@JvmField val MOUSE3 = ButtonInputType("Special")
		@JvmField val RELOAD = ButtonInputType("Reload")
		
		/**
		 * Emulates a spacebar action.
		 */
		@JvmField val JUMP = ButtonInputType("Jump")
		
		/**
		 * Emulates a CTRL press.
		 *
		 * Note: Requires `noCrouchButtonRelease = true` in [TFBot][btpos.source.vdfdsl.types.spawners.TFBotSpawner].
		 */
		@JvmField val CROUCH = ButtonInputType("Crouch")
		
		/**
		 * Emulates an "H" press.  Uses your action-slot item, e.g. canteens.
		 *
		 * Note: Can be paired with [SuppressCanteenUse][RafmodBotAttributes.SuppressCanteenUse] to time canteen usage.
		 */
		@JvmField val ACTIONSLOT = ButtonInputType("Action")
	}
}