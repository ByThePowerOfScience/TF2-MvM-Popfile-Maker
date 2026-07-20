package btpos.source.vdfdsl.tf2.rafmod.bot.tasks


import btpos.source.vdfdsl.modeling.ExtensibleSubtreeImpl
import btpos.source.vdfdsl.modeling.IExtensibleSubtree.Companion.addField
import btpos.source.vdfdsl.modeling.IExtensibleSubtree_VDFRepresentable
import btpos.source.vdfdsl.tf2.rafmod.RafmodConstants.SIGSEGV
import btpos.source.vdfdsl.tf2.rafmod.tftypes.TFVoiceCommand

open class VoiceCommandBotExt(subtree: IExtensibleSubtree_VDFRepresentable = ExtensibleSubtreeImpl()) : RafmodPeriodicTask(subtree) {
	override fun copy() = VoiceCommandBotExt(copyInternal())
	
	override val _structIdentifier get() = "VoiceCommand"
	
	/**
	 * The voice command to execute periodically.
	 *
	 * Example:
	 * ```kotlin
	 * voiceCommand = TFVoiceCommand.MEDIC
	 * ```
	 */
	open var voiceCommand: TFVoiceCommand? by addField("Type", conditional = SIGSEGV)
	
	
}

