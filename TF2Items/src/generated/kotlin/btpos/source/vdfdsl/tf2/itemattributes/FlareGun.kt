package btpos.source.vdfdsl.tf2.itemattributes

import btpos.source.vdfdsl.serialization.codecs.NumberSelectorCodec
import btpos.source.vdfdsl.tf2.itemattributes.impl.IBlockScoped


/**
 * Items: The Flare Gun, The Scorch Shot, The Detonator, The Manmelter
 */
interface FlareGunAttributes : BaseGunAttributes, IBlockScoped {
	companion object : FlareGunAttributes
	
	/**
	 * In-Game: "Flare knocks back target on hit and explodes when it hits the ground. Increased knock back on burning players"
	 *
	 * 
	 *
	 * 0: Normal.
	 *
	 * 1: Detonator.
	 *
	 * 2: Manmelter.
	 *
	 * 3: Scorch Shot.
	 */
	context(attrs: btpos.source.vdfdsl.modeling.IKeyValueMap)
	var flaregunFiresPelletsWithKnockback: Boolean?
		get() = attrs.getTyped("mod flaregun fires pellets with knockback", NumberSelectorCodec(3))
		set(value) = attrs.setNullable("mod flaregun fires pellets with knockback", value, NumberSelectorCodec(3))
}

