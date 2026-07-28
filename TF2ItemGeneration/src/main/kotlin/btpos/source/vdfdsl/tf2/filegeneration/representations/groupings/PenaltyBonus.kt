package btpos.source.vdfdsl.tf2.filegeneration.representations.groupings

import btpos.source.vdfdsl.tf2.filegeneration.representations.ClassBuilder
import btpos.source.vdfdsl.tf2.filegeneration.representations.overrideVarName
import btpos.source.vdfdsl.tf2.filegeneration.representations.FakeCodec
import btpos.source.vdfdsl.tf2.filegeneration.representations.ISortedNamedAttribute
import btpos.source.vdfdsl.tf2.filegeneration.representations.NamedAttribute
import btpos.source.vdfdsl.tf2.filegeneration.representations.PropertyBuilder
import btpos.source.vdfdsl.tf2.filegeneration.sanitize

/**
 * Penalty and bonus combined into a single little namespace
 */
data class PenaltyBonus(
	val penalty: ISortedNamedAttribute,
	val bonus: ISortedNamedAttribute,
	val hidden: ISortedNamedAttribute?,
	val desc: String? = null
) : ISortedNamedAttribute {
	override val varName: String
		get() = penalty.varName.sanitize().overrideVarName()
	
	init {
		require(bonus.getKotlinType() == penalty.getKotlinType()) {
			"Bonus and penalty types do not match, needs an override in btpos/source/vdfdsl/tf2/filegeneration/representations/Overrides.kt\n" +
			"Bonus (${bonus.getKotlinType()}): $bonus\n" +
			"Penalty (${penalty.getKotlinType()}): $penalty"
		}
	}
	
	
	
	companion object {
		const val NEITHER_NESTED = "BonusPenalty"
	}
	
	override fun clone(): ISortedNamedAttribute {
		return PenaltyBonus(penalty.clone(), bonus.clone(), desc)
	}
	
	val propertyBuilder by lazy {
		PropertyBuilder(varName, "$NEITHER_NESTED<${getKotlinType()}>") {
			initializer = "$NEITHER_NESTED(\n" +
			              "\t${bonus.propertyBuilder().initializer},\n" +
			              "\t${penalty.propertyBuilder().initializer}\n" +
			              ")"
		}
	}
	override fun propertyBuilder(): PropertyBuilder {
		return propertyBuilder
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
		return bonus.getKotlinType()
	}
	
	override fun setCodec(codec: (NamedAttribute) -> FakeCodec?) {
		bonus.setCodec(codec)
		penalty.setCodec(codec)
	}
}