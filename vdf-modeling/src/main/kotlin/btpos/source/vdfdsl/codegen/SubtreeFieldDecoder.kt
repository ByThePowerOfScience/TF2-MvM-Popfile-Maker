package btpos.source.vdfdsl.codegen

import btpos.source.vdfdsl.backing.VDFSubtree
import btpos.source.vdfdsl.codegen.kt.KtAssignmentExpression

fun interface SubtreeFieldDecoder : SubtreeDecoder {
	override fun decode(subtree: VDFSubtree): List<IKtCodeGenerator> {
		return decodeField(subtree)
	}
	
	fun decodeField(subtree: VDFSubtree): List<KtAssignmentExpression>
}