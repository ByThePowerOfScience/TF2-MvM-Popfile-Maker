package btpos.source.vdfdsl.tf2.itemattributes.impl

import btpos.source.vdfdsl.tf2.itemattributes.IAttributeContainer
import btpos.source.vdfdsl.tf2.itemattributes.ItemAttribute
import btpos.source.vdfdsl.tf2.itemattributes.ItemAttributeNamed

open class BonusPenalty<T : Any>(
	/**
	 * The version of this attribute that's called a positive effect in the description.  Does not change the calculation.
	 *
	 * e.g. `fireDelay.bonus = 0.6` is called "+40% firing speed", but it's still a 0.6x multiplier to fire delay.
	 */
	val bonus: ItemAttributeNamed<T>,
	/**
	 * The version of this attribute that's called a negative effect in the description.  Does not change the calculation.
	 *
	 * e.g. `fireDelay.penalty = 1.6` is called "-60% firing speed", but it's still a 1.6x multiplier to fire delay.
	 */
	val penalty: ItemAttributeNamed<T>,
) : ItemAttribute<T> {
	context(attrs: IAttributeContainer)
	override fun assign(value: T?) {
		bonus.assign(value)
	}
	
	context(attrs: IAttributeContainer)
	override fun get(): T? {
		return bonus.get()
	}
}

class BonusPenaltyHidden<T : Any, HIDDEN : ItemAttribute<T>>(
	bonus: ItemAttributeNamed<T>,
	penalty: ItemAttributeNamed<T>,
	
	/**
	 * The version of this attribute that's is not displayed in the description.
	 *
	 * e.g. `fireRate.hidden = 1.6` is a 1.6x multiplier to fire delay, just like `fireRate.bonus` and `fireRate.penalty`.
	 */
	val hidden: HIDDEN
) : BonusPenalty<T>(bonus, penalty)