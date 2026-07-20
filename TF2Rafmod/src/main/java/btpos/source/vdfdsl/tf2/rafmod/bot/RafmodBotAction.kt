package btpos.source.vdfdsl.tf2.rafmod.bot

import btpos.source.vdfdsl.backing.VDFPrimitive
import btpos.source.vdfdsl.modeling.IExtensibleSubtree.Companion.addField
import btpos.source.vdfdsl.serialization.IVDFRepresentableValue_Trivial
import btpos.source.vdfdsl.tf2.rafmod.RafmodConstants.SIGSEGV
import btpos.source.vdfdsl.types.spawners.TFBotSpawner

/**
 * Overrides default bot AI.  A defunct keyvalue in vanilla, reimplemented in Rafmod.
 */
class RafmodBotAction(override val _vdfRepr: VDFPrimitive) : IVDFRepresentableValue_Trivial {
	constructor(stringValue: String) : this(VDFPrimitive(stringValue))
	
	companion object {
		/**
		 * Default action
		 */
		@JvmField val DEFAULT = RafmodBotAction("Default")
		
		/**
		 * Uses generic bomb fetching AI, default action for most bots except Spy, Medic, Engineer or Mission bots
		 */
		@JvmField val FETCH_FLAG = RafmodBotAction("FetchFlag")
		
		/**
		 * As above, but ignores bot escort limit
		 */
		@JvmField val ESCORT_FLAG = RafmodBotAction("EscortFlag")
		
		/**
		 * Pushes to capture point (or hatch in MvM). Similar to BehaviorModfiers Push and its aliases.
		 */
		@JvmField val PUSH_TO_CAPTURE_POINT = RafmodBotAction("PushToCapturePoint")
		
		/**
		 * Chases down random player targets
		 */
		@JvmField val MOBBER = RafmodBotAction("Mobber")
		
		/**
		 * Uses spy AI, teleports behind players, but does not use disguises or cloak.
		 */
		@JvmField val SPY = RafmodBotAction("Spy")
		
		/**
		 * Uses mission sniper AI
		 */
		@JvmField val SNIPER = RafmodBotAction("Sniper")
		
		/**
		 * Uses sentry buster AI, but targets players instead. Might crash servers
		 */
		@JvmField val SUICIDE_BOMBER = RafmodBotAction("SuicideBomber")
		
		/**
		 * Sit in spawn and wait
		 */
		@JvmField val IDLE = RafmodBotAction("Idle")
		
		/**
		 * Sit at spawn position, until an active threat is in vision
		 */
		@JvmField val PASSIVE = RafmodBotAction("Passive")
		
		/**
		 * Use medic AI
		 */
		@JvmField val MEDIC = RafmodBotAction("Medic")
	}
}

/**
 * Overrides the default bot AI.
 *
 * Example:
 * ```kotlin
 * action = RafmodBotAction.IDLE
 * ```
 */
var TFBotSpawner.action: RafmodBotAction? by addField("Action", conditional = SIGSEGV)

