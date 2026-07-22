package btpos.source.vdfdsl.types.bots

import btpos.source.vdfdsl.serialization.IVDFRepresentableValue_Trivial
import btpos.source.vdfdsl.backing.VDFPrimitive

open class BehaviorModifiers(val name: String) : IVDFRepresentableValue_Trivial {
	companion object {
		@Deprecated("Once valid, no longer valid")
		@JvmField val Idle = BehaviorModifiers("Idle")
		/** Synonym for [TFBotAttributes.Aggressive]*/
		@JvmField val Push = BehaviorModifiers("Push")
		/** Synonym for [TFBotAttributes.Aggressive]*/
		@JvmField val Mobber = BehaviorModifiers("Mobber")
	}
	
	override val _vdfRepr = VDFPrimitive(name)
}
