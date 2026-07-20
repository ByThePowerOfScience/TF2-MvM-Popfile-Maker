package btpos.source.vdfdsl.tf2.templates

import btpos.source.vdfdsl.backing.VDFKeyValue
import btpos.source.vdfdsl.backing.VDFPrimitive
import btpos.source.vdfdsl.backing.VDFSubtree
import btpos.source.vdfdsl.backing.asString
import btpos.source.vdfdsl.backing.getRoot
import btpos.source.vdfdsl.serialization.IVDFRepresentableKeyValue
import btpos.source.vdfdsl.serialization.IVDFRepresentableValue

data class PopFileTemplate(
	/**
	 * The name of this template, e.g. `T_TFBot_Jimothy`
	 */
	val name: String,
	/**
	 * The file this is from, e.g. `base.pop`
	 */
	val base: String
) : IVDFRepresentableValue {
	override fun _toKeyValueRepresentable(key: VDFPrimitive, conditional: String?): IVDFRepresentableKeyValue {
		return IVDFRepresentableKeyValue { parent ->
			parent.addBase()
			parent += VDFKeyValue(key, VDFPrimitive(name), conditional)
		}
	}
	
	
	private fun VDFSubtree.addBase() {
		val rootEntries = this.getRoot().entries
		
		if (rootEntries.none { it.key.stringValue == "#base" && it.value.asString == base }) {
			rootEntries.add(0, VDFKeyValue(VDFPrimitive("#base"), VDFPrimitive(base), null))
		}
	}
}