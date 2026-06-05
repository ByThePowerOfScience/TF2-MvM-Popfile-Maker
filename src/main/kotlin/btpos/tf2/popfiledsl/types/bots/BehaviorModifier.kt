package btpos.tf2.popfiledsl.types.bots

import btpos.tf2.popfiledsl.serialization.IPopFileItem
import btpos.tf2.popfiledsl.serialization.PopFileKeyword
import kotlin.jvm.java

enum class BehaviorModifier : IPopFileItem<PopFileKeyword> {
	@Deprecated("Once valid, no longer valid")
	Idle,
	/** Synonym for [TFBotAttribute.Aggressive]*/
	Push,
	/** Synonym for [TFBotAttribute.Aggressive]*/
	Mobber;
	
	override val popFileRepr = PopFileKeyword(name)
}
