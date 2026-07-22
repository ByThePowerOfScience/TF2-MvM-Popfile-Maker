package btpos.source.vdfdsl.tf2.rafmod.bot.tasks


import btpos.source.vdfdsl.backing.VDFPrimitive
import btpos.source.vdfdsl.backing.VDFSubtree
import btpos.source.vdfdsl.backing.addSubtree
import btpos.source.vdfdsl.backing.asSubtree
import btpos.source.vdfdsl.backing.getAll
import btpos.source.vdfdsl.modeling.ExtensibleSubtreeImpl
import btpos.source.vdfdsl.modeling.IExtensibleSubtree.Companion.addField
import btpos.source.vdfdsl.modeling.IExtensibleSubtree.Serializers.selector
import btpos.source.vdfdsl.modeling.IExtensibleSubtree_VDFRepresentable
import btpos.source.vdfdsl.modeling.RequiredFieldNotFoundException
import btpos.source.vdfdsl.tf2.rafmod.RafmodConstants.SIGSEGV
import btpos.source.vdfdsl.types.bots.EventChangeAttributes

private const val EventChangeAttributesKey = "EventChangeAttributes"

/**
 * Periodically changes bot attributes using a block defined in [eventChangeAttributes][btpos.source.vdfdsl.types.spawners.TFBotSpawner.eventChangeAttributes]
 */
open class ChangeAttributesBotExt(subtree: IExtensibleSubtree_VDFRepresentable = ExtensibleSubtreeImpl()) : RafmodPeriodicTask(subtree) {
	override fun copy() = ChangeAttributesBotExt(copyInternal())
	
	override val _structIdentifier get() = "ChangeAttributes"
	
	
	/**
	 * Name of the bot attributes block listed in [eventChangeAttributes][btpos.source.vdfdsl.types.spawners.TFBotSpawner.eventChangeAttributes]
	 *
	 * Example:
	 * ```kotlin
	 * TFBot {
	 *     val myEventChange = EventChangeAttributes("MY_EVENT") {
	 *          // ...
	 *     }
	 *
	 *     eventChangeAttributes += myEventChange
	 *
	 *     +PeriodicChangeAttributes {
	 *          changeBlock = myEventChange
	 *     }
	 * }
	 *
	 *
	 *
	 * ```
	 */
	open var changes: EventChangeAttributes? by addField("Name", conditional = SIGSEGV, serializer = selector(EventChangeAttributes::eventName))
	
	override fun _serializeInto(input: VDFSubtree) {
		super._serializeInto(input)
		
		val changeBlock = this.changes
		                    ?: throw RequiredFieldNotFoundException(this._instantiationSite, IllegalStateException("`changes` block not present!"))
		
		// add change to EventChangeAttributes if not already there
		
		val botAppliedTo = input.parent?.takeIf { bot ->
			bot.parent?.first { it.value == bot }?.key?.stringValue == "TFBot"
		} ?: return;
		
		val parentEventChanges = botAppliedTo.getAll(EventChangeAttributesKey).filterIsInstance<VDFSubtree>()
		
		var toAddTo: VDFSubtree? = null
		if (parentEventChanges.isNotEmpty()) {
			var parentAlreadyContainsThisChange = false
			
			for (eventChange in parentEventChanges.flatten()) {
				if (eventChange.key.stringValue == changeBlock.eventName) {
					parentAlreadyContainsThisChange = true
					
					break;
				}
			}
			
			if (!parentAlreadyContainsThisChange) {
				toAddTo = parentEventChanges[0].asSubtree
			}
		} else {
			toAddTo = botAppliedTo.addSubtree(VDFPrimitive(EventChangeAttributesKey))
		}
		// TODO see if this is even WANTED, cause templates might add stuff that we aren't aware of
		if (toAddTo != null) {
			changeBlock._serializeInto(toAddTo)
		}
	}
}