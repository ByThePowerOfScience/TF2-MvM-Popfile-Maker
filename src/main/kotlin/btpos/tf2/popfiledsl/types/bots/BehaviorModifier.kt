package btpos.tf2.popfiledsl.types.bots

import btpos.tf2.popfiledsl.serialization.IPopFileSerializable

enum class BehaviorModifier : IPopFileSerializable<String> {
	@Deprecated("Once valid, no longer valid")
	Idle,
	/** Synonym for [TFBotAttribute.Aggressive]*/
	Push,
	/** Synonym for [TFBotAttribute.Aggressive]*/
	Mobber;
	
	override val _popFileRepr = name
}
