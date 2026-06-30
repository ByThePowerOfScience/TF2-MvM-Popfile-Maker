package btpos.tf2.popfiledsl.tf2.itemattributes

import btpos.tf2.popfiledsl.modeling.*
import btpos.tf2.popfiledsl.serialization.codecs.*



interface BaseProjectileAttributes : IBlockScoped {
	companion object : BaseProjectileAttributes
	
	/**
	 * In-Game: "Syringes deliver a highly concentrated dose of Mad Milk. Duration increases per hit to a max of 4 seconds."
	 *
	 * 
	 *
	 * If true, applies mad milk on hit. Yes, this is in the base projectile.
	 */
	context(attrs: IKeyValueMap)
	var madMilkSyringes: Boolean?
		get() = attrs.getTyped("mad milk syringes", BinaryIntCodec)
		set(value) = attrs.setNullable("mad milk syringes", value, BinaryIntCodec)
}

