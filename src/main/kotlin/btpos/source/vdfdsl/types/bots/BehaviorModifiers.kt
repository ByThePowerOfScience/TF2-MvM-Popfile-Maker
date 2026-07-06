package btpos.source.vdfdsl.types.bots

import btpos.source.vdfdsl.serialization.IVDFRepresentableValue
import btpos.source.vdfdsl.backing.VDFPrimitive

enum class BehaviorModifiers : IVDFRepresentableValue<VDFPrimitive> {
	@Deprecated("Once valid, no longer valid")
	Idle,
	/** Synonym for [TFBotAttributes.Aggressive]*/
	Push,
	/** Synonym for [TFBotAttributes.Aggressive]*/
	Mobber;
	
	override val _vdfRepr get() = VDFPrimitive(name)
}
