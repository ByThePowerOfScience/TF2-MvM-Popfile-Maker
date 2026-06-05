package btpos.tf2.popfiledsl.types.bots

import btpos.tf2.popfiledsl.serialization.IPopFileItem
import btpos.tf2.popfiledsl.serialization.PopFileKeyword

enum class BotSkill : IPopFileItem<PopFileKeyword> {
	Easy,
	Normal,
	Hard,
	Expert;
	
	override val popFileRepr = PopFileKeyword(name)
}
