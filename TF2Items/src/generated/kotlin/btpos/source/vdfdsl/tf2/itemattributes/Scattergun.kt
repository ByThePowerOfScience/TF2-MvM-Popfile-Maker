package btpos.source.vdfdsl.tf2.itemattributes

import btpos.source.vdfdsl.modeling.*
import btpos.source.vdfdsl.serialization.codecs.*
import btpos.source.vdfdsl.tf2.itemattributes.impl.*
import btpos.source.vdfdsl.tf2.tftypes.*
import java.util.*




interface ScattergunAttributes : ShotgunAttributes {
	
	companion object {
		/**
		 * In-Game: "Knockback on the target and shooter"
		 * 
		 * Note: if `scattergun_knockback_mult` is greater than 1.0, this is not necessary.
		 */
		val scattergunHasKnockback: ItemAttributeNamed<Boolean> = ItemAttributeNamed("scattergun has knockback")
	
		val scattergunKnockbackMult: ItemAttributeNamed<Float> = ItemAttributeNamed("scattergun knockback mult")
	}

	/**
	 * In-Game: "Knockback on the target and shooter"
	 * 
	 * Note: if `scattergun_knockback_mult` is greater than 1.0, this is not necessary.
	 */
	val scattergunHasKnockback: ItemAttributeNamed<Boolean> get() = ScattergunAttributes.scattergunHasKnockback
	
	val scattergunKnockbackMult: ItemAttributeNamed<Float> get() = ScattergunAttributes.scattergunKnockbackMult
	
	/**
	 * If 1, reloads entire clip at once.
	 */
	override val scattergunNoReloadSingle: ItemAttributeNamed<Boolean> get() = super.scattergunNoReloadSingle
}