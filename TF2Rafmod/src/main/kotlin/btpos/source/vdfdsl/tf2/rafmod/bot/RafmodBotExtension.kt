package btpos.source.vdfdsl.tf2.rafmod.bot

import btpos.source.vdfdsl.modeling.AbstractVDFStruct
import btpos.source.vdfdsl.modeling.ExtensibleSubtreeImpl
import btpos.source.vdfdsl.modeling.IExtensibleSubtree_VDFRepresentable
import btpos.source.vdfdsl.tf2.PopFileDSL
import btpos.source.vdfdsl.tf2.rafmod.RafmodConstants.SIGSEGV

/**
 * Structs that Rafmod recognizes inside [TFBots][btpos.source.vdfdsl.types.spawners.TFBotSpawner].
 *
 * @see btpos.source.vdfdsl.tf2.rafmod.RafmodBotExtensions
 */
@PopFileDSL
abstract class RafmodBotExtension(subtree: IExtensibleSubtree_VDFRepresentable = ExtensibleSubtreeImpl()) : AbstractVDFStruct(subtree) {
	override val _conditional: String
		get() = SIGSEGV
	
	abstract override fun copy(): RafmodBotExtension
}
