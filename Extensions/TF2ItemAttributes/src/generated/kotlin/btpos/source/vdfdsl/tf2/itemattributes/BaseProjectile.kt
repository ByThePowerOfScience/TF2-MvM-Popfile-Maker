package btpos.source.vdfdsl.tf2.itemattributes

import btpos.source.vdfdsl.modeling.*
import btpos.source.vdfdsl.serialization.codecs.*



interface BaseProjectileAttributes : btpos.source.vdfdsl.tf2.itemattributes.IBlockScoped {
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
		get() = attrs.getTyped("mad milk syringes", _root_ide_package_.btpos.source.vdfdsl.serialization.codecs.BinaryIntCodec)
		set(value) = attrs.setNullable("mad milk syringes", value, _root_ide_package_.btpos.source.vdfdsl.serialization.codecs.BinaryIntCodec)
}

