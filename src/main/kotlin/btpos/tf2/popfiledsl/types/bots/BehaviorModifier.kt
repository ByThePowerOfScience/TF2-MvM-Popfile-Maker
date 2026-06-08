package btpos.tf2.popfiledsl.types.bots

import btpos.tf2.popfiledsl.serialization.IPopFileRepresentable

enum class BehaviorModifier : IPopFileRepresentable<String> {
	@Deprecated("Once valid, no longer valid")
	Idle,
	/** Synonym for [TFBotAttribute.Aggressive]*/
	Push,
	/** Synonym for [TFBotAttribute.Aggressive]*/
	Mobber;
	
	override val popFileRepr = name
}
