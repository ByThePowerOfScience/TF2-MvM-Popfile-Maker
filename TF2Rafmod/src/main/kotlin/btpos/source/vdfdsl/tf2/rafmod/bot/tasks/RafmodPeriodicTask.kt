package btpos.source.vdfdsl.tf2.rafmod.bot.tasks

import btpos.source.vdfdsl.backing.VDFSubtree
import btpos.source.vdfdsl.modeling.ExtensibleSubtreeImpl
import btpos.source.vdfdsl.modeling.IExtensibleSubtree
import btpos.source.vdfdsl.modeling.IExtensibleSubtree_VDFRepresentable
import btpos.source.vdfdsl.serialization.IVDFRepresentableKeyValue
import btpos.source.vdfdsl.tf2.rafmod.RafmodConstants
import btpos.source.vdfdsl.tf2.rafmod.bot.RafmodBotExtension
import kotlin.time.Duration

sealed class RafmodPeriodicTask(subtree: IExtensibleSubtree_VDFRepresentable = ExtensibleSubtreeImpl()) : RafmodBotExtension(subtree) {
	/**
	 * Time before the task starts. (Default: 10 seconds)
	 *
	 * Example:
	 * ```kotlin
	 * delay = 2.seconds
	 * ```
	 */
	open var delay: Duration? by IExtensibleSubtree.Companion.addField("Delay", conditional = RafmodConstants.SIGSEGV)
	
	/**
	 * Time between each execution of this task. (Default: 10 seconds)
	 *
	 * Example:
	 * ```kotlin
	 * cooldown = 1
	 * ```
	 */
	open var cooldown: Duration? by IExtensibleSubtree.addField("Cooldown", conditional = RafmodConstants.SIGSEGV, serializer = IExtensibleSubtree.Serializers.durationInSeconds())
	
	/**
	 * How many times the bot should perform this task in total. (Default: 0 = INFINITE)
	 *
	 * Example:
	 * ```kotlin
	 * timesRepeated = 1
	 * ```
	 */
	open var timesRepeated: Int? by IExtensibleSubtree.Companion.addField("Repeats", conditional = RafmodConstants.SIGSEGV)
	
	open var activationCondition: TaskActivationCondition? by IExtensibleSubtree.Companion.selfNamed()
	
	open fun activationCondition(configure: TaskActivationCondition.() -> Unit) {
		this.activationCondition = TaskActivationCondition().apply(configure)
	}
	
	abstract override fun copy(): RafmodPeriodicTask
	
	
	class TaskActivationCondition(override val _rawEntries: MutableMap<Any, IVDFRepresentableKeyValue> = mutableMapOf(), override val _instantiationSite: Array<StackTraceElement> = Throwable().stackTrace) : IExtensibleSubtree, IVDFRepresentableKeyValue {
		/**
		 * If true, this task activates only when the bot can see a target. (Default: false - "always activate")
		 */
		private var activateOnSeeTarget: Boolean? by IExtensibleSubtree.Companion.addField("IfSeeTarget")
		
		fun ifCanSeeTarget() {
			activateOnSeeTarget = true
		}
		
		/**
		 * If true, this task only activates if the bot does _not_ have a target.
		 */
		private var activateOnNoTarget: Boolean? by IExtensibleSubtree.Companion.addField("IfNoTarget")
		
		/**
		 * If true, this task only activates if the bot does _not_ have a target.
		 */
		fun ifHasNoTarget() {
			activateOnNoTarget = true
		}
		
		/**
		 * If set, the task activates only when the bot's health is below the specified value.
		 *
		 * Example:
		 * ```kotlin
		 * ifHealthBelow(100) // activates when the bot's HP is below 100
		 * ```
		 */
		fun ifHealthBelow(amount: Int) {
			activateIfHealthBelow = amount
		}
		
		private var activateIfHealthBelow: Int? by IExtensibleSubtree.Companion.addField("IfHealthBelow")
		
		/**
		 * If set, the task activates only when the bot's health is above the specified value.
		 *
		 * Example:
		 * ```kotlin
		 * ifHealthAbove(100) // activates when the bot's HP is above 100
		 * ```
		 */
		fun ifHealthAbove(amount: Int) {
			activateIfHealthAbove = amount
		}
		
		private var activateIfHealthAbove: Int? by IExtensibleSubtree.Companion.addField("IfHealthAbove")
		
		
		
		private var maxTargetRange: Int? by IExtensibleSubtree.Companion.addField("MaxTargetRange", conditional = RafmodConstants.SIGSEGV)
		
		/**
		 * If set, the task activates only when the bot's target is within this number of units from the bot.
		 *
		 * Example:
		 * ```kotlin
		 * ifTargetWithinRange(150) // activates when the bot's target is within 150 HU
		 * ```
		 */
		fun ifTargetWithinRange(units: Int) {
			maxTargetRange = units
		}
		private var minTargetRange: Int? by IExtensibleSubtree.Companion.addField("MinTargetRange", conditional = RafmodConstants.SIGSEGV)
		
		/**
		 * If set, the task activates only when the bot's target is further than this number of units from the bot.
		 *
		 * Example:
		 * ```kotlin
		 * ifTargetOutsideRange(150) // activates when the bot's target is over 150 HU away
		 * ```
		 */
		fun ifTargetOutsideRange(units: Int) {
			minTargetRange = units
		}
		
		override fun copy(): TaskActivationCondition {
			return TaskActivationCondition(_rawEntries.toMutableMap(), Throwable().stackTrace)
		}
		
		override fun _serializeInto(input: VDFSubtree) {
			_rawEntries.values.forEach {
				it._serializeInto(input)
			}
		}
	}
}