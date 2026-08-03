package btpos.source.vdfdsl.tf2.itemattributes.impl

import btpos.source.vdfdsl.tf2.itemattributes.ItemAttribute
import btpos.source.vdfdsl.tf2.itemattributes.ItemAttributeNamed

open class BonusPenalty<T : Any>(
	override val bonus: ItemAttributeNamed<T>,
	override val penalty: ItemAttributeNamed<T>,
) : BPBonus<T>, BPPenalty<T>, ItemAttribute<T> by bonus

open class BonusNeutral<T : Any>(
	override val bonus: ItemAttributeNamed<T>,
	override val neutral: ItemAttributeNamed<T>
) : BPBonus<T>, BPNeutral<T>, ItemAttribute<T> by bonus

open class BonusPenaltyNeutral<T : Any>(
	bonus: ItemAttributeNamed<T>,
	penalty: ItemAttributeNamed<T>,
	override val neutral: ItemAttributeNamed<T>
) : BonusPenalty<T>(bonus, penalty), BPNeutral<T>


open class BonusPenaltyHidden<T : Any, HIDDEN : ItemAttribute<T>>(
	bonus: ItemAttributeNamed<T>,
	penalty: ItemAttributeNamed<T>,
	override val hidden: HIDDEN
) : BonusPenalty<T>(bonus, penalty), BPHidden<T, HIDDEN>


open class BonusNeutralHidden<T : Any, HIDDEN : ItemAttribute<T>>(
	bonus: ItemAttributeNamed<T>,
	neutral: ItemAttributeNamed<T>,
	override val hidden: HIDDEN
) : BonusNeutral<T>(bonus, neutral), BPHidden<T, HIDDEN>

open class BonusPenaltyNeutralHidden<T : Any, HIDDEN : ItemAttribute<T>>(
	bonus: ItemAttributeNamed<T>,
	penalty: ItemAttributeNamed<T>,
	neutral: ItemAttributeNamed<T>,
	override val hidden: HIDDEN
) : BonusPenaltyNeutral<T>(bonus, penalty, neutral), BPHidden<T, HIDDEN>

open class PenaltyNeutral<T : Any>(
	override val penalty: ItemAttributeNamed<T>,
	override val neutral: ItemAttributeNamed<T>
) : BPPenalty<T>, BPNeutral<T>, ItemAttribute<T> by penalty


open class PenaltyNeutralHidden<T : Any, HIDDEN : ItemAttribute<T>>(
	penalty: ItemAttributeNamed<T>,
	neutral: ItemAttributeNamed<T>,
	override val hidden: HIDDEN
) : PenaltyNeutral<T>(penalty, neutral), BPHidden<T, HIDDEN>



interface BPBonus<T : Any> {
	/**
	 * The version of this attribute that's called a positive effect in the description.  Does not change the calculation.
	 *
	 * e.g. `multFireDelay.bonus = 0.4` is called "+60% firing speed", but it's still a 0.4x multiplier to fire delay.
	 */
	val bonus: ItemAttributeNamed<T>
}

interface BPPenalty<T : Any> {
	/**
	 * The version of this attribute that's called a negative effect in the description.  Does not change the calculation.
	 *
	 * e.g. `multFireDelay.penalty = 1.6` is called "-60% firing speed", but it's still a 1.6x multiplier to fire delay.
	 */
	val penalty: ItemAttributeNamed<T>
}

interface BPNeutral<T : Any> {
	/**
	 * The version of this attribute that's called a neutral effect (white text) in the description.  The calculation for the stat is exactly the same as any other.
	 */
	val neutral: ItemAttributeNamed<T>
}

interface BPHidden<T : Any, HIDDEN : ItemAttribute<T>> {
	/**
	 * The version of this attribute that's is not displayed in the description.
	 *
	 * e.g. `multFireDelay.hidden = 1.6` is a 1.6x multiplier to fire delay, just like `multFireDelay.bonus` and `multFireDelay.penalty`.
	 */
	val hidden: HIDDEN
}