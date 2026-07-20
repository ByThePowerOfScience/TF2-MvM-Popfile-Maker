package btpos.source.vdfdsl.tf2.rafmod.bot.tasks


import btpos.source.vdfdsl.modeling.ExtensibleSubtreeImpl
import btpos.source.vdfdsl.modeling.IExtensibleSubtree.Companion.addField
import btpos.source.vdfdsl.modeling.IExtensibleSubtree_VDFRepresentable
import btpos.source.vdfdsl.tf2.rafmod.RafmodConstants.SIGSEGV

/**
 * Executes console commands on the client.
 */
open class ClientCommandBotExt(subtree: IExtensibleSubtree_VDFRepresentable = ExtensibleSubtreeImpl()) : RafmodPeriodicTask(subtree) {
	override fun copy() = ClientCommandBotExt(copyInternal())
	
	override val _structIdentifier get() = "ClientCommand"
	
	/**
	 * The console command to execute on this bot. Notable examples are `build 0/1/2/3` and `destroy 0/1/2/3`.
	 *
	 * Example:
	 * ```kotlin
	 * command = "build 0"
	 * ```
	 */
	open var command: String? by addField("Name", conditional = SIGSEGV)
	
	
}