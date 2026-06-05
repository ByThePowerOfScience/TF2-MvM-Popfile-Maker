package btpos.tf2.popfiledsl.types.bots

import btpos.tf2.popfiledsl.types.IPopFileItem
import btpos.tf2.popfiledsl.types.PopFileKeyword

enum class BehaviorModifier : IPopFileItem {
	@Deprecated("Once valid, no longer valid")
	Idle,
	/** Synonym for [TFBotAttribute.Aggressive]*/
	Push,
	/** Synonym for [TFBotAttribute.Aggressive]*/
	Mobber;
	
	override val popFileRepr: Any = PopFileKeyword(name)
}
