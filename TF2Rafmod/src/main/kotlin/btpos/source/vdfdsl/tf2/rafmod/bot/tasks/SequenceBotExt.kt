package btpos.source.vdfdsl.tf2.rafmod.bot.tasks


import btpos.source.vdfdsl.modeling.AbstractVDFStruct
import btpos.source.vdfdsl.modeling.ExtensibleSubtreeImpl
import btpos.source.vdfdsl.modeling.IExtensibleSubtree.Companion.addField
import btpos.source.vdfdsl.modeling.IExtensibleSubtree_VDFRepresentable
import btpos.source.vdfdsl.tf2.rafmod.RafmodConstants.SIGSEGV

/**
 * Display a sequence animation with a name. Not every animation is supported.
 */
open class SequenceBotExt(subtree: IExtensibleSubtree_VDFRepresentable = ExtensibleSubtreeImpl()) : RafmodPeriodicTask(subtree) {
	override fun copy() = SequenceBotExt(copyInternal())
	
	override val _structIdentifier get() = "Sequence"
	
	/**
	 * The name of the sequence to run.
	 *
	 * Sequence names can be found using HLMV, which is available by default in your Team Fortress 2/bin folder (which is one folder out from your `/tf/` folder), or in the Hammer++ Model Browser tool.
	 *
	 * Example:
	 * ```kotlin
	 * sequenceToRun = "Run_MELEE"
	 * ```
	 */
	open var sequenceToRun: String? by addField("Name", conditional = SIGSEGV)
	
	
}