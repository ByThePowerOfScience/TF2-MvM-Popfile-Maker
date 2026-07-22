package btpos.source.vdfdsl.tf2.rafmod.waveschedule

import btpos.source.vdfdsl.backing.VDFKeyValue
import btpos.source.vdfdsl.backing.VDFPrimitive
import btpos.source.vdfdsl.backing.VDFSubtree
import btpos.source.vdfdsl.modeling.IExtensibleSubtree.Companion.addField
import btpos.source.vdfdsl.serialization.IVDFRepresentableValue_Subtree
import btpos.source.vdfdsl.tf2.rafmod.tftypes.TFTeam
import btpos.source.vdfdsl.tf2.rafmod.RafmodConstants.SIGSEGV
import btpos.source.vdfdsl.tf2.rafmod.RafmodSerializers
import btpos.source.vdfdsl.tf2.rafmod.tftypes.TFSpell
import btpos.source.vdfdsl.types.WaveSchedule
import kotlin.collections.map

abstract class RafmodHalloween {
	companion object {
		@PublishedApi @JvmField internal val INSTANCE = object : RafmodHalloween() {}
	}
	
	/**
	 * Enforces Halloween mode, but does not enable wave 666 and zombie bots.
	 */
	open var WaveSchedule.forceHolloween: Boolean? by addField("ForceHoliday", conditional = SIGSEGV, serializer = { if (this) 2 else 0 })
	
	/**
	 * If true, disallows the thriller taunt while Halloween is active.
	 */
	open var WaveSchedule.noThrillerTaunt: Boolean? by addField("NoThrillerTaunt", conditional = SIGSEGV)
	
	/**
	 * If true, player deaths during Halloween will not spawn a crit-pumpkin.
	 */
	open var WaveSchedule.noCritPumpkin: Boolean? by addField("NoCritPumpkin", conditional = SIGSEGV)
	
	/**
	 * If true, ammo boxes and health packs will retain their default model even while a holiday is active.
	 */
	open var WaveSchedule.noHolidayPickups: Boolean? by addField("NoHolidayPickups", conditional = SIGSEGV)
	
	/**
	 * If true, the game will not display "Wave 666" when [eventPopFile][btpos.source.vdfdsl.types.PopulationManager.eventPopFile] is set.
	 */
	open var WaveSchedule.zombiesNoWave666: Boolean? by addField("ZombiesNoWave666", conditional = SIGSEGV)
	
	/**
	 * If true, bots will drop spells on death.
	 */
	open var WaveSchedule.botsDropSpells: Boolean? by addField("BotsDropSpells", conditional = SIGSEGV)
	
	/**
	 * If true, giants will drop rare spells instead of common ones.
	 */
	open var WaveSchedule.giantsDropRareSpells: Boolean? by addField("GiantsDropRareSpells", conditional = SIGSEGV)
	
	/**
	 * Drop chance for common spell books, from `0` to `1`.
	 *
	 * Example:
	 * ```kotlin
	 * spellDropRateCommon = 0.5
	 * ```
	 */
	open var WaveSchedule.spellDropRateCommon: Double? by addField("SpellDropRateCommon", conditional = SIGSEGV)
	
	/**
	 * Drop chance for rare spell books from giants when [giantsDropRareSpells] is set, from `0` to `1`.
	 *
	 * Example:
	 * ```kotlin
	 * spellDropRateGiant = 0.5
	 * ```
	 */
	open var WaveSchedule.spellDropRateGiant: Double? by addField("SpellDropRateGiant", conditional = SIGSEGV)
	
	/**
	 * When set, drop spells only if bots are from the given team.
	 *
	 * Example:
	 * ```kotlin
	 * spellDropForBotsInTeam = TFTeam.BLUE
	 * ```
	 */
	open var WaveSchedule.teamThatDropsSpellsOnDeath: TFTeam? by addField("SpellDropForBotsInTeam", conditional = SIGSEGV, serializer = RafmodSerializers.TFTEAM_NAME)
	
	
	private val SPELL_MAP_SERIALIZER = { list: Iterable<Pair<TFSpell, Int>> ->
		IVDFRepresentableValue_Subtree { parent ->
			VDFSubtree(parent, list.map { (spell, charges) -> VDFKeyValue(spell._vdfRepr, VDFPrimitive(charges), null) })
		}
	}
	/**
	 * Overrides the spells that can be rolled from a common (green) spellbook.
	 *
	 * The value in each pair specifies how many spell charges to give for said spell.
	 *
	 * You can duplicate spells in this list to increase their chance of being rolled.
	 *
	 * Example:
	 * ```kotlin
	 * // Healing Aura and Fireball each have a 50% chance to be rolled from a common spellbook,
	 * // no other spells can be rolled from a common spellbook,
	 * // and they'll each have 3 charges when a player rolls them.
	 * spellBookNormalRoll = listOf(
	 *     TFSpell.`Healing Aura` to 3,
	 *     TFSpell.Fireball to 3
	 * )
	 * ```
	 *
	 * @see TFSpell
	 */
	open var WaveSchedule.spellBookNormalRoll: List<Pair<TFSpell, Int>>? by addField("SpellBookNormalRoll", conditional = SIGSEGV, serializer = SPELL_MAP_SERIALIZER)
	
	/**
	 * Overrides the spells that can be rolled from a rare (purple and sparkly) spellbook.
	 *
	 * The value in each pair specifies how many spell charges to give for said spell.
	 *
	 * You can duplicate spells in this list to increase their chance of being rolled.
	 *
	 * Example:
	 * ```kotlin
	 * // Healing Aura and Fireball each have a 50% chance to be rolled from a common spellbook,
	 * // no other spells can be rolled from a common spellbook,
	 * // and they'll each have 3 charges when a player rolls them.
	 * spellBookRareRoll = listOf(
	 *     TFSpell.`Healing Aura` to 3,
	 *     TFSpell.Fireball to 3
	 * )
	 * ```
	 *
	 * @see TFSpell
	 */
	open var WaveSchedule.spellBookRareRoll: List<Pair<TFSpell, Int>>? by addField("SpellBookNormalRoll", conditional = SIGSEGV, serializer = SPELL_MAP_SERIALIZER)
}