package btpos.source.vdfdsl.tf2.filegeneration.representations.groupings

import btpos.source.vdfdsl.tf2.filegeneration.representations.overrideVarName
import btpos.source.vdfdsl.tf2.filegeneration.representations.FakeCodec
import btpos.source.vdfdsl.tf2.filegeneration.representations.ISortedNamedAttribute
import btpos.source.vdfdsl.tf2.filegeneration.representations.NamedAttribute
import btpos.source.vdfdsl.tf2.filegeneration.representations.PropertyBuilder
import btpos.source.vdfdsl.tf2.filegeneration.representations.removeBonusPenaltyHiddenStuff

/**
 * Different description variants of the same attribute class, all combined into a single little namespace
 */
class PenaltyBonus(
	val penalty: ISortedNamedAttribute? = null,
	val bonus: ISortedNamedAttribute? = null,
	val neutral: ISortedNamedAttribute? = null,
	val hidden: ISortedNamedAttribute? = null,
	val desc: String? = null
) : ISortedNamedAttribute {
	private val list = listOfNotNull(penalty, bonus, neutral, hidden)
	
	override var varName: String = list.first().varName.removeBonusPenaltyHiddenStuff().overrideVarName()
	
	fun copy(
		penalty: ISortedNamedAttribute? = this.penalty,
		bonus: ISortedNamedAttribute? = this.bonus,
		neutral: ISortedNamedAttribute? = this.neutral,
		hidden: ISortedNamedAttribute? = this.hidden,
		desc: String? = this.desc,
		varName: String? = this.varName,
	) = PenaltyBonus(penalty, bonus, neutral, hidden, desc).apply {
		varName?.let {
			this.varName = it
		}
	}
	
	init {
		require(list.size > 1) {
			"PenaltyBonus constructed with only a single element: ${list.first()}"
		}
		
		require(list.zipWithNext { a, b -> a.getKotlinType() == b.getKotlinType() }.all { it }) {
			"Bonus and penalty types do not match, needs an override in btpos/source/vdfdsl/tf2/filegeneration/representations/Overrides.kt\n" +
			"Bonus (${bonus?.getKotlinType()}): $bonus\n" +
			"Penalty (${penalty?.getKotlinType()}): $penalty\n" +
			"Neutral (${neutral?.getKotlinType()}): $neutral\n" +
			"Hidden (${hidden?.getKotlinType()}): $hidden"
		}
	}
	
	
	
	companion object {
		const val BONUSPENALTY = "BonusPenalty"
		const val BONUSNEUTRAL = "BonusNeutral"
		const val PENALTYNEUTRAL = "PenaltyNeutral"
		const val BONUSPENALTYNEUTRAL = "BonusPenaltyNeutral"
		const val BONUSPENALTYHIDDEN = "BonusPenaltyHidden"
		const val BONUSNEUTRALHIDDEN = "BonusNeutralHidden"
		const val PENALTYNEUTRALHIDDEN = "PenaltyNeutralHidden"
		const val BONUSPENALTYNEUTRALHIDDEN = "BonusPenaltyNeutralHidden"
	}
	
	override fun clone(): PenaltyBonus {
		return copy().also {
			it.varName = varName
			it.notes = notes
		}
	}
	
	val classType by lazy {
		return@lazy when {
			bonus != null && penalty != null && neutral != null && hidden != null -> BONUSPENALTYNEUTRALHIDDEN to listOf(bonus, penalty, neutral, hidden)
			bonus != null && penalty != null && neutral != null -> BONUSPENALTYNEUTRAL to listOf(bonus, penalty, neutral)
			penalty != null && neutral != null && hidden != null -> PENALTYNEUTRALHIDDEN to listOf(penalty, neutral, hidden)
			bonus != null && penalty != null && hidden != null -> BONUSPENALTYHIDDEN to listOf(bonus, penalty, hidden)
			bonus != null && neutral != null && hidden != null -> BONUSNEUTRALHIDDEN to listOf(bonus, neutral, hidden)
			bonus != null && penalty != null -> BONUSPENALTY to listOf(bonus, penalty)
			bonus != null && neutral != null -> BONUSNEUTRAL to listOf(bonus, neutral)
			penalty != null && neutral != null -> PENALTYNEUTRAL to listOf(penalty, neutral)
			else -> error("Not enough things: $this")
		}
	}
	
	override fun propertyBuilder(): PropertyBuilder {
		val hiddenAttributeType = if (hidden == null) "" else ", ${hidden.propertyBuilder().kType}"
		
		return PropertyBuilder(varName, "${classType.first}<${getKotlinType()}$hiddenAttributeType>") {
			initializer = "${classType.first}(\n" +
			              classType.second.joinToString(",\n") { it.propertyBuilder().initializer.prependIndent() } + ",\n" +
			              ")"
			
			docComment += innateDescription
			
			docComment += buildList {
				fun doThing(name: String, it: ISortedNamedAttribute?) {
					if (it != null) {
						add(name + ":")
						addAll(it.innateDescription.filter { it.isNotBlank() }.map { if (!it.trimStart().startsWith("- ")) "- $it" else it  }.map { "\t" + it })
					}
				}
				
				doThing("Bonus", bonus)
				doThing("Penalty", penalty)
				doThing("Neutral", neutral)
				doThing("Hidden", hidden)
			}
		}
	}
	
	override var innateDescription: List<String> = emptyList()
	
	override var notes: List<String> = listOf()
		set(value) {
			field = value
			list.forEach { it.notes = value }
		}
	
	override fun getKotlinType(): String {
		return list.first().getKotlinType()
	}
	
	override fun setCodec(codec: (NamedAttribute) -> FakeCodec?) {
		list.forEach { it.setCodec(codec) }
	}
	
	override fun contains(attrName: String): Boolean {
		return list.any { attrName in it }
	}
}