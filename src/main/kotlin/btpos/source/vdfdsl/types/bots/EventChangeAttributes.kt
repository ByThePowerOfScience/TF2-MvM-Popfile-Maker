package btpos.source.vdfdsl.types.bots

import btpos.source.vdfdsl.modeling.AbstractVDFStruct
import btpos.source.vdfdsl.modeling.ExtensibleSubtreeImpl
import btpos.source.vdfdsl.modeling.IExtensibleSubtree_VDFRepresentable
import btpos.source.vdfdsl.types.spawners.ChangeableBotAttributes

/**
 * A single named instance of EventChangeAttributes.  When the event named in [eventName] is fired, all changes defined in this object are applied to the bot this event is defined in.
 */
open class EventChangeAttributes(
	/**
	 * The name of the event to listen for.  When this event is fired, the bot's attributes will be replaced with the ones defined here.
	 *
	 * All bots start in `Default`.
	 *
	 * As well, if the map has a gate, capturing a gate will invoke bots' `RevertGateBotsBehavior` block if they have one.
	 */
	val eventName: String,
	subtree: IExtensibleSubtree_VDFRepresentable = ExtensibleSubtreeImpl()
) : AbstractVDFStruct(subtree), ChangeableBotAttributes {
	companion object {
		/**
		 * The name of the event all bots start on when spawned.
		 */
		const val DEFAULT = "Default"
		
		/**
		 * Event invoked on all bots whenever a gate is captured.
		 */
		const val ON_GATE_CAPTURE = "RevertGateBotsBehavior"
		
	    inline operator fun invoke(
		    /**
		     * The name of the event to listen for.  When this event is fired, the bot's attributes will be replaced with the ones defined here.
		     *
		     * All bots start in `"Default"`.
		     *
		     * As well, if the map has a gate, capturing a gate will invoke bots' `"RevertGateBotsBehavior"` block if they have one.
		     */
		    eventName: String,
		    configure: EventChangeAttributes.() -> Unit
		): EventChangeAttributes {
	        return EventChangeAttributes(eventName).apply(configure)
	    }
	}
	
	override fun copy() = EventChangeAttributes(eventName, copyInternal())
	
	override val _structIdentifier get() = eventName
}