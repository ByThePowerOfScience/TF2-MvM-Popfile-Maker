package btpos.source.vdfdsl.tf2.rafmod.bot.tasks


import btpos.source.vdfdsl.backing.VDFPrimitive
import btpos.source.vdfdsl.modeling.ExtensibleSubtreeImpl
import btpos.source.vdfdsl.modeling.IExtensibleSubtree.Companion.addField
import btpos.source.vdfdsl.modeling.IExtensibleSubtree.Serializers.flatListWithKey
import btpos.source.vdfdsl.modeling.IExtensibleSubtree_VDFRepresentable
import btpos.source.vdfdsl.tf2.rafmod.RafmodConstants.SIGSEGV
import btpos.source.vdfdsl.tf2.rafmod.tftypes.TFSpell
import kotlin.time.Duration

/**
 * Gives bots spells periodically.
 *
 * For bots to use Spells, they must have a Spellbook item equipped, and no [WeaponRestrictions][btpos.source.vdfdsl.types.spawners.weaponRestriction] active.
 */
open class SpellBotExt(subtree: IExtensibleSubtree_VDFRepresentable = ExtensibleSubtreeImpl()) : RafmodPeriodicTask(subtree) {
	override fun copy() = SpellBotExt(copyInternal())
	
	override val _structIdentifier get() = "Spell"
	
	/**
	 * Time before the first spell charges are given. (Default: 10 seconds)
	 */
	override var delay: Duration?
		get() = super.delay
		set(value) { super.delay = value }
	
	/**
	 * Cooldown time between bots being given spells (and possibly changing what spell they're holding if multiple [spells] are set). (Default: 10 seconds)
	 */
	override var cooldown: Duration?
		get() = super.cooldown
		set(value) { super.cooldown = value }
	
	/**
	 * How many times spell charges should be given. (Default: 0 \[infinite])
	 */
	override var timesRepeated: Int?
		get() = super.timesRepeated
		set(value) { super.timesRepeated = value }
	
	/**
	 * How many charges to give the bot whenever this task procs. (Default: 1)
	 *
	 * Example:
	 * ```kotlin
	 * // Give the bot two charges every 5 seconds
	 * cooldown = 5.seconds
	 * numChargesGiven = 2
	 * ```
	 */
	open var numChargesGiven: Int? by addField("Charges", conditional = SIGSEGV)
	
	/**
	 * The maximum number of spell charges a bot can hold onto at any given time. (Default: [numChargesGiven])
	 *
	 * Example:
	 * ```kotlin
	 * maxChargesHeld = 1
	 * ```
	 */
	open var maxChargesHeld: Int? by addField("Limit", conditional = SIGSEGV)
	
	/**
	 * Possible spells to give the bot when this task procs.
	 *
	 * Example:
	 * ```kotlin
	 * spells += TFSpell.Fireball
	 * ```
	 *
	 * @see giveAnySpell
	 * @see giveAnyCommonSpell
	 * @see giveAnyRareSpell
	 */
	open var spells: List<TFSpell> by addField("Type", conditional = SIGSEGV, serializer = flatListWithKey(), initialValue = ::listOf)
	
	
	/**
	 * If true, this task has the possibility of giving the bot ANY spell when this task procs. (Default: false)
	 *
	 * @see spells
	 * @see giveAnyCommonSpell
	 * @see giveAnyRareSpell
	 */
	open var giveAnySpell: Boolean? by addField("Type", conditional = SIGSEGV, serializer = {
		if (this) {
			ALL_SPELLS
		} else null
	})
	
	/**
	 * If true, this task has the possibility of giving the bot any common spell when this task procs. (Default: false)
	 *
	 * @see spells
	 * @see giveAnySpell
	 * @see giveAnyRareSpell
	 */
	open var giveAnyCommonSpell: Boolean? by addField("Type", conditional = SIGSEGV, serializer = {
		if (this) {
			COMMON_SPELLS
		} else null
	})
	/**
	 * If true, this task has the possibility of giving the bot any rare spell when this task procs. (Default: false)
	 *
	 * @see spells
	 * @see giveAnySpell
	 * @see giveAnyCommonSpell
	 */
	open var giveAnyRareSpell: Boolean? by addField("Type", conditional = SIGSEGV, serializer = {
		if (this) {
			RARE_SPELLS
		} else null
	})
	
	
}

private val ALL_SPELLS = VDFPrimitive("All")
private val COMMON_SPELLS = VDFPrimitive("Common")
private val RARE_SPELLS = VDFPrimitive("Rare")