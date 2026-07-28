package btpos.source.vdfdsl.tf2.itemattributes

import btpos.source.vdfdsl.modeling.*
import btpos.source.vdfdsl.serialization.codecs.*
import btpos.source.vdfdsl.tf2.itemattributes.impl.*
import btpos.source.vdfdsl.tf2.tftypes.*
import java.util.*



/**
 * Items: Stock Scattergun + Reskins, The Force-a-Nature, The Back Scatter, The Soda Popper, The Baby Face's Blaster
 */
interface ScattergunAttributes : IBlockScoped {
	companion object {
		/**
		 * In-Game: "Knockback on the target and shooter"
		 *
		 * 
		 *
		 * Note: if `scattergun_knockback_mult` is greater than 1.0, this is not necessary.
		 */
		val scattergunHasKnockback = ItemAttributeNamed<Boolean>("scattergun has knockback")
		
		/**
		 * 
		 */
		val scattergunKnockbackMult = ItemAttributeNamed<Float>("scattergun knockback mult")
		
		/**
		 * 
		 *
		 * If 1, reloads entire clip at once.
		 */
		val scattergunNoReloadSingle = ItemAttributeNamed<Boolean>("scattergun no reload single")
	}

	/**
	 * In-Game: "Knockback on the target and shooter"
	 *
	 * 
	 *
	 * Note: if `scattergun_knockback_mult` is greater than 1.0, this is not necessary.
	 */
	val scattergunHasKnockback: ItemAttribute<Boolean> get() = ScattergunAttributes.scattergunHasKnockback
	
	/**
	 * 
	 */
	val scattergunKnockbackMult: ItemAttribute<Float> get() = ScattergunAttributes.scattergunKnockbackMult
	
	/**
	 * 
	 *
	 * If 1, reloads entire clip at once.
	 */
	val scattergunNoReloadSingle: ItemAttribute<Boolean> get() = ScattergunAttributes.scattergunNoReloadSingle

   
}

