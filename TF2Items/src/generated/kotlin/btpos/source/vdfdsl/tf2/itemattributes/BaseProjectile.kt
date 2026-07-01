package btpos.source.vdfdsl.tf2.itemattributes

import btpos.source.vdfdsl.serialization.codecs.BinaryIntCodec
import btpos.source.vdfdsl.tf2.itemattributes.impl.IBlockScoped


interface BaseProjectileAttributes : IBlockScoped {
	companion object : BaseProjectileAttributes
	
	/**
	 * In-Game: "Syringes deliver a highly concentrated dose of Mad Milk. Duration increases per hit to a max of 4 seconds."
	 *
	 * 
	 *
	 * If true, applies mad milk on hit. Yes, this is in the base projectile.
	 */
	context(attrs: btpos.source.vdfdsl.modeling.IKeyValueMap)
	var madMilkSyringes: Boolean?
		get() = attrs.getTyped("mad milk syringes", BinaryIntCodec)
		set(value) = attrs.setNullable("mad milk syringes", value, BinaryIntCodec)
}

