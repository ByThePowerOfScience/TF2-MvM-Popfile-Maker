package btpos.source.vdfdsl.types.bots

import btpos.misc.kt.codegen.expressions.KtFunctionCall
import btpos.misc.kt.codegen.expressions.KtLambda
import btpos.misc.kt.codegen.identifiers.KtName
import btpos.misc.kt.codegen.identifiers.StandardNames
import btpos.source.vdfdsl.backing.VDFKeyValue
import btpos.source.vdfdsl.backing.VDFPrimitive
import btpos.source.vdfdsl.backing.VDFSubtree
import btpos.source.vdfdsl.backing.asSubtree
import btpos.source.vdfdsl.codegen.Codegen
import btpos.source.vdfdsl.codegen.CodegenProvider
import btpos.source.vdfdsl.codegen.ValueDecoder
import btpos.source.vdfdsl.modeling.ExtensibleSubtreeImpl
import btpos.source.vdfdsl.modeling.IExtensibleSubtree
import btpos.source.vdfdsl.serialization.IVDFRepresentableKeyValue
import btpos.source.vdfdsl.serialization.IVDFRepresentableValue_Subtree
import btpos.source.vdfdsl.tf2.itemattributes.impl.IBlockScoped
import btpos.source.vdfdsl.types.spawners.ChangeableBotAttributes

/**
 * A single named instance of EventChangeAttributes.  When the event named in [eventName] is fired, all changes defined in this object are applied to the bot this event is defined in.
 */
open class EventChangeAttributesEntry(
	subtree: MutableMap<Any, IVDFRepresentableKeyValue> = mutableMapOf()
) : ExtensibleSubtreeImpl(subtree), ChangeableBotAttributes, IBlockScoped {
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
		    configure: EventChangeAttributesEntry.() -> Unit
		): EventChangeAttributesEntry {
	        return EventChangeAttributesEntry().apply(configure)
	    }
		
		
		init {
			IExtensibleSubtree.Codegen.registerCodegen<EventChangeAttributesEntry> { Codegen.basicBlockScope(::invoke) }
		}
		
		val CODEGEN = IExtensibleSubtree.Codegen.forType<EventChangeAttributesEntry>()
	}
	
	override fun copy() = EventChangeAttributesEntry(_copyInternal())
}


open class EventChangeAttributes(private val eventListeners: MutableMap<String, EventChangeAttributesEntry> = mutableMapOf())
	: IVDFRepresentableValue_Subtree, MutableMap<String, EventChangeAttributesEntry> by eventListeners, IBlockScoped
{
	/**
	 * Set up some attributes to change when the event name used as the [receiver][this] is fired.
	 *
	 * Scope will modify any events that already exist in this container with this name instead of overwriting them.
	 *
	 * Example:
	 * ```kotlin
	 * "MyCoolEvent" {
	 *   ...
	 * }
	 * ```
	 *
	 * @receiver The name of the event to listen for.  When this event is fired, the bot's attributes will be replaced with the ones defined here. All bots start in `Default`.
	 *
	 * As well, if the map has a gate, capturing a gate will invoke bots' `RevertGateBotsBehavior` block if they have one.
	 */
	inline operator fun String.invoke(onEvent: EventChangeAttributesEntry.() -> Unit) {
		computeIfAbsent(this) {
			EventChangeAttributesEntry()
		}.apply(onEvent)
	}
	
	override fun _vdfRepr(parent: VDFSubtree): VDFSubtree {
		val out = VDFSubtree(parent)
		this.eventListeners.forEach { (name, attrs) ->
			out.add(VDFKeyValue(VDFPrimitive(name), attrs._vdfRepr(out), null))
		}
		return out
	}
	
	fun copy() = EventChangeAttributes(eventListeners.mapValuesTo(mutableMapOf()) { it.value.copy() })
	
	
	
	
	companion object {
		inline operator fun invoke(configure: EventChangeAttributes.() -> Unit): EventChangeAttributes {
			return EventChangeAttributes().apply(configure)
		}
		
		
		
		val CODEGEN = CodegenProvider {
			ValueDecoder { obj, parent ->
				fun VDFKeyValue.toStringInvoke(subtree: VDFSubtree): KtFunctionCall {
					// will be a block scope with "EventChangeAttributes.Companion" as the receiver and the lambda with the assignments as the arg.
					// Just need to change the receiver to a string and keep the lambda the same
					val eventChangeBlock = EventChangeAttributesEntry.CODEGEN.get().decode(this, subtree) ?: error("Failed to parse event change attributes")
					eventChangeBlock.callee = StandardNames.INVOKE
					eventChangeBlock.receiver = Codegen.string(key.stringValue)
					
					return eventChangeBlock
				}
				
				val subtree = obj.asSubtree ?: return@ValueDecoder emptyList()
				
				val body = KtLambda()
				subtree.mapTo(body.lines) {
					it.toStringInvoke(subtree)
				}
				
				listOf(KtFunctionCall(KtName("invoke", EventChangeAttributes::class), listOf(body)))
			}
		}
	}
}