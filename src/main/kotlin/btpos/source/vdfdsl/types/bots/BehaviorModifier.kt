package btpos.source.vdfdsl.types.bots

import btpos.source.vdfdsl.serialization.IVDFSerializableValue

enum class BehaviorModifier : IVDFSerializableValue<String> {
	@Deprecated("Once valid, no longer valid")
	Idle,
	/** Synonym for [TFBotAttribute.Aggressive]*/
	Push,
	/** Synonym for [TFBotAttribute.Aggressive]*/
	Mobber;
	
	override val _vdfRepr = name
}
