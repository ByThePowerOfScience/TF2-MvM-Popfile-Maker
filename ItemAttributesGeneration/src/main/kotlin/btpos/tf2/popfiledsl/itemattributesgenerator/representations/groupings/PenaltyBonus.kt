package btpos.tf2.popfiledsl.itemattributesgenerator.representations.groupings

import btpos.tf2.popfiledsl.itemattributesgenerator.overrideVarName
import btpos.tf2.popfiledsl.itemattributesgenerator.representations.FakeCodec
import btpos.tf2.popfiledsl.itemattributesgenerator.representations.ISortedNamedAttribute
import btpos.tf2.popfiledsl.itemattributesgenerator.representations.NamedAttribute
import btpos.tf2.popfiledsl.itemattributesgenerator.sanitize

/**
 * Penalty and bonus combined into a single little namespace
 */
data class PenaltyBonus(
	val penalty: ISortedNamedAttribute,
	val bonus: ISortedNamedAttribute,
	val desc: String? = null
) : ISortedNamedAttribute {
	override val varName: String
		get() = penalty.varName.sanitize().overrideVarName()
	
	companion object {
		const val NEITHER_NESTED = "BonusPenalty"
		const val BOTH_NESTED = "BonusPenalty_BothNested"
		const val BONUS_IS_NESTED = "BonusPenalty_BonusNested"
		const val PENALTY_IS_NESTED = "BonusPenalty_PenaltyNested"
		
	}
	
	override fun clone(): ISortedNamedAttribute {
		return PenaltyBonus(penalty.clone(), bonus.clone(), desc)
	}
	
	private val whenThing
		get() = when {
			penalty is NamedAttribute && bonus is NamedAttribute -> 0
			penalty !is NamedAttribute && bonus !is NamedAttribute -> 1
			bonus is NamedAttribute -> 2
			else -> 3
		}
	
	override fun propertyValue(): String {
		val typeParamsString = "<${bonus.getKotlinType()}, ${penalty.getKotlinType()}>"
		
		return if (penalty is NamedAttribute && bonus is NamedAttribute) {
			"$NEITHER_NESTED$typeParamsString(\"${bonus.attrName}\", \"${penalty.attrName}\")"
		} else if (penalty !is NamedAttribute && bonus !is NamedAttribute) {
			"$BOTH_NESTED$typeParamsString(${bonus.propertyValue()}, ${penalty.propertyValue()})"
		} else if (bonus is NamedAttribute) {
			"$PENALTY_IS_NESTED$typeParamsString(\"${bonus.attrName}\", ${penalty.propertyValue()})"
		} else if (penalty is NamedAttribute) {
			"$BONUS_IS_NESTED$typeParamsString(${bonus.propertyValue()}, \"${penalty.attrName}\")"
		} else {
			error("no this won't happen")
		}
	}
	
	
	override fun propertyString(): String {
		return "val $varName get() = ${propertyValue()}"
	}
	
	
	override fun generateTopLevelMembers(): List<String> {
		return penalty.generateTopLevelMembers() + bonus.generateTopLevelMembers()
	}
	
	override val innateDescription: List<String>
		get() = buildList {
			add("Bonus:")
			addAll(bonus.innateDescription.filter { it.isNotBlank() }.map { if (!it.trimStart().startsWith("- ")) "- $it" else it  }.map { "\t" + it })
			add("")
			add("Penalty:")
			addAll(penalty.innateDescription.filter { it.isNotBlank() }.map { if (!it.trimStart().startsWith("- ")) "- $it" else it  }.map { "\t" + it })
		}
	
	override var notes: List<String> = listOf()
		set(value) {
			field = value
			penalty.notes = value
			bonus.notes =value
		}
	
	
	
	
	override fun getKotlinType(): String {
		return when (whenThing) {
			0 -> NEITHER_NESTED
			1 -> BOTH_NESTED
			2 -> BONUS_IS_NESTED
			3 -> PENALTY_IS_NESTED
			else -> error("fuck")
		}
	}
	
	override fun setCodec(codec: (NamedAttribute) -> FakeCodec?) {
		bonus.setCodec(codec)
		penalty.setCodec(codec)
	}
}