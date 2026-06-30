package btpos.source.vdfdsl.tf2.itemattributes

import btpos.source.vdfdsl.modeling.*
import btpos.source.vdfdsl.serialization.codecs.*


/**
 * Items: The Flare Gun, The Scorch Shot, The Detonator, The Manmelter
 */
interface FlareGunAttributes : btpos.source.vdfdsl.tf2.itemattributes.BaseGunAttributes, btpos.source.vdfdsl.tf2.itemattributes.IBlockScoped {
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
		get() = attrs.getTyped("mod flaregun fires pellets with knockback", _root_ide_package_.btpos.source.vdfdsl.serialization.codecs.NumberSelectorCodec(3))
		set(value) = attrs.setNullable("mod flaregun fires pellets with knockback", value, _root_ide_package_.btpos.source.vdfdsl.serialization.codecs.NumberSelectorCodec(3))
}

