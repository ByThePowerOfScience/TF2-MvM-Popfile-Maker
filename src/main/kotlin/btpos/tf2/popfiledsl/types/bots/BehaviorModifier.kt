package btpos.tf2.popfiledsl.types.bots

import btpos.tf2.popfiledsl.serialization.IVDFSerializableValue

enum class BehaviorModifier : IVDFSerializableValue<String> {
	@Deprecated("Once valid, no longer valid")
	Idle,
	/** Synonym for [TFBotAttribute.Aggressive]*/
	Push,
	/** Synonym for [TFBotAttribute.Aggressive]*/
	Mobber;
	
	override val _vdfRepr = name
}
