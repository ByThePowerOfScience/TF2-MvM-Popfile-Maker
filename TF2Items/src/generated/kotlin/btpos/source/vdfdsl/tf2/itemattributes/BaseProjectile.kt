package btpos.source.vdfdsl.tf2.itemattributes

import btpos.source.vdfdsl.modeling.*
import btpos.source.vdfdsl.serialization.*
import btpos.source.vdfdsl.serialization.codecs.*
import btpos.source.vdfdsl.tf2.itemattributes.impl.*
import btpos.source.vdfdsl.tf2.tftypes.*
import java.util.*
import kotlin.time.Duration

interface BaseProjectileAttributes : IBlockScoped {
	companion object : IBlockScoped {
		/**
		 * In-Game: "Syringes deliver a highly concentrated dose of Mad Milk. Duration increases per hit to a max of 4 seconds."
		 * 
		 * If true, applies mad milk to hit target for 4 seconds, with successive hits adding 0.5 seconds to the effect time per shot.
		 */
		val madMilkSyringes: ItemAttributeNamed<Boolean> = ItemAttributeNamed("mad milk syringes")
	}
	
	/**
	 * In-Game: "Syringes deliver a highly concentrated dose of Mad Milk. Duration increases per hit to a max of 4 seconds."
	 * 
	 * If true, applies mad milk to hit target for 4 seconds, with successive hits adding 0.5 seconds to the effect time per shot.
	 */
	val madMilkSyringes: ItemAttributeNamed<Boolean> get() = BaseProjectileAttributes.madMilkSyringes
	
	object Inherited : BaseProjectileAttributes 
}