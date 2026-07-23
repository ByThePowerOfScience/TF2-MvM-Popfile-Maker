package btpos.source.vdfdsl.tf2.itemattributes

import btpos.source.vdfdsl.modeling.*
import btpos.source.vdfdsl.serialization.codecs.*
import btpos.source.vdfdsl.tf2.itemattributes.impl.*
import java.util.*


interface BaseProjectileAttributes : IBlockScoped {
	companion object : BaseProjectileAttributes
	
	/**
	 * In-Game: "Syringes deliver a highly concentrated dose of Mad Milk. Duration increases per hit to a max of 4 seconds."
	 *
	 * 
	 *
	 * If true, applies mad milk to hit target for 4 seconds, with successive hits adding 0.5 seconds to the effect time per shot.
	 */
	context(attrs: IKeyValueMap)
	var madMilkSyringes: Boolean?
		get() = attrs.getTyped("mad milk syringes", BinaryIntCodec)
		set(value) = attrs.setNullable("mad milk syringes", value, BinaryIntCodec)
}

