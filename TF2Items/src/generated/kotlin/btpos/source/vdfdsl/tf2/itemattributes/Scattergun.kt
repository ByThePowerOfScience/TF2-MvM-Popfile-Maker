package btpos.source.vdfdsl.tf2.itemattributes

import btpos.source.vdfdsl.modeling.*
import btpos.source.vdfdsl.serialization.codecs.*
import btpos.source.vdfdsl.tf2.itemattributes.impl.*
import btpos.source.vdfdsl.tf2.tftypes.*
import java.util.*



interface ScattergunAttributes : ShotgunAttributes {
	companion object 

	override val onHit: OnHitAttributes get() = super.onHit
	
	override val reloading: ReloadingAttributes get() = super.reloading

	open class OnHitAttributes : IBlockScoped {
		/**
		 * In-Game: "Knockback on the target and shooter"
		 * 
		 * Note: if `scattergun_knockback_mult` is greater than 1.0, this is not necessary.
		 */
		open val scattergunHasKnockback: ItemAttributeNamed<Boolean> = ItemAttributeNamed("scattergun has knockback")
	
		open val scattergunKnockbackMult: ItemAttributeNamed<Float> = ItemAttributeNamed("scattergun knockback mult")
	}
	
	open class ReloadingAttributes : IBlockScoped {
		/**
		 * If 1, reloads entire clip at once.
		 */
		open val scattergunNoReloadSingle: ItemAttributeNamed<Boolean> = ItemAttributeNamed("scattergun no reload single")
	}
}