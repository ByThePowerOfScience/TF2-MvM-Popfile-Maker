package btpos.tf2.popfiledsl.types.bots

import btpos.tf2.popfiledsl.types.IPopFileItem
import btpos.tf2.popfiledsl.types.PopFileKeyword

enum class BotSkill : IPopFileItem {
	Easy,
	Normal,
	Hard,
	Expert;
	
	override val popFileRepr: Any = PopFileKeyword(name)
}
