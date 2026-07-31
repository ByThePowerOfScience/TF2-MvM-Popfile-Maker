package btpos.source.vdfdsl.tf2.filegeneration.representations.groupings

import btpos.source.vdfdsl.tf2.filegeneration.representations.FakeCodec
import btpos.source.vdfdsl.tf2.filegeneration.representations.ISortedNamedAttribute
import btpos.source.vdfdsl.tf2.filegeneration.representations.NamedAttribute
import btpos.source.vdfdsl.tf2.filegeneration.representations.PropertyBuilder
import btpos.source.vdfdsl.tf2.filegeneration.representations.removeFromCamelCase

class LongAttributeHiLo(
	val lo: NamedAttribute,
	val hi: NamedAttribute,
	override val innateDescription: List<String>
) : ISortedNamedAttribute {
	companion object {
		val re_removeLow = Regex("[_\\s]low?\b")
		
		const val HILO_CLASS = "ItemAttributeLong"
	}
	
	
	override var varName: String = lo.varName.removeFromCamelCase(re_removeLow)
	
	override var notes: List<String> = listOf()
	
	override fun clone() = LongAttributeHiLo(lo.clone() as NamedAttribute, hi.clone() as NamedAttribute, innateDescription)
	
	override fun propertyBuilder(): PropertyBuilder {
		return PropertyBuilder(varName, HILO_CLASS) {
			initializer = "$HILO_CLASS(\n" +
			              "\t${lo.propertyBuilder().initializer},\n" +
			              "\t${hi.propertyBuilder().initializer},\n" +
			              ")"
			docComment += innateDescription
			docComment += notes
		}
	}
	
	override fun getKotlinType(): String {
		return "Long"
	}
	
	override fun setCodec(codec: (NamedAttribute) -> FakeCodec?) {}
}