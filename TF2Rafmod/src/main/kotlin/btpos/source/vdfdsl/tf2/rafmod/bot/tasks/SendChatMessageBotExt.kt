package btpos.source.vdfdsl.tf2.rafmod.bot.tasks


import btpos.source.vdfdsl.modeling.AbstractVDFStruct
import btpos.source.vdfdsl.modeling.ExtensibleSubtreeImpl
import btpos.source.vdfdsl.modeling.IExtensibleSubtree.Companion.addField
import btpos.source.vdfdsl.modeling.IExtensibleSubtree_VDFRepresentable
import btpos.source.vdfdsl.tf2.rafmod.RafmodConstants.SIGSEGV

open class SendChatMessageBotExt(subtree: IExtensibleSubtree_VDFRepresentable = ExtensibleSubtreeImpl()) : RafmodPeriodicTask(subtree) {
	override fun copy() = SendChatMessageBotExt(copyInternal())
	
	override val _structIdentifier get() = "Message"
	
	/**
	 * The message to be displayed in the chat.
	 *
	 * Note: text color can also accept hex codes without a `#` sign, e.g. `FF0000` for "red".
	 *
	 * TODO make this an actual component builder
	 *
	 * Example:
	 * ```kotlin
	 * name = "{red}Hello!" // sends a red `Hello!` to the chat
	 * ```
	 */
	open var name: String? by addField("Name", conditional = SIGSEGV)
	
	
}