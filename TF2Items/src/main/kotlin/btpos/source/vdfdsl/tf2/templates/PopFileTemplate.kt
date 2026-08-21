package btpos.source.vdfdsl.tf2.templates

import btpos.misc.kt.codegen.KtExpression
import btpos.source.vdfdsl.backing.VDFKeyValue
import btpos.source.vdfdsl.backing.VDFObject
import btpos.source.vdfdsl.backing.VDFPrimitive
import btpos.source.vdfdsl.backing.VDFSubtree
import btpos.source.vdfdsl.backing.asString
import btpos.source.vdfdsl.backing.getRoot
import btpos.source.vdfdsl.codegen.CodegenProvider
import btpos.source.vdfdsl.codegen.ValueDecoderMulti
import btpos.source.vdfdsl.serialization.IVDFRepresentableKeyValue
import btpos.source.vdfdsl.serialization.IVDFRepresentableValue
import btpos.source.vdfdsl.tf2.templates.PopFileTemplate.Companion.BASE_PRIM

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
		
		if (rootEntries.none { it.key == BASE_PRIM && it.value.asString == base }) {
			rootEntries.add(0, VDFKeyValue(BASE_PRIM, VDFPrimitive(base), null))
		}
	}
	
	companion object {
		/**
		 * Add the code locations of any existing PopFileTemplate instances for a given template
		 */
		val CODEGEN = CodegenProvider {
			ValueDecoderMulti<KtExpression>()
		}
		
		val BASE_PRIM = VDFPrimitive("#base")
	}
}

fun PopFileTemplate.matches(s: VDFObject, parentSubtree: VDFSubtree): Boolean {
	return s is VDFPrimitive && s == VDFPrimitive.notInterned(this.base)
	       && parentSubtree.getRoot().any { it.key == BASE_PRIM && it.value.asString == this.base } // imports this base
}