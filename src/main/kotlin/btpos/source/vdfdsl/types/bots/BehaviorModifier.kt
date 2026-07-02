package btpos.source.vdfdsl.types.bots

import btpos.source.vdfdsl.serialization.IVDFRepresentableValue
import btpos.source.vdfdsl.backing.VDFPrimitive

enum class BehaviorModifier : IVDFRepresentableValue<VDFPrimitive> {
	@Deprecated("Once valid, no longer valid")
	Idle,
	/** Synonym for [TFBotAttribute.Aggressive]*/
	Push,
	/** Synonym for [TFBotAttribute.Aggressive]*/
	Mobber;
	
	override val _vdfRepr get() = VDFPrimitive(name)
}
