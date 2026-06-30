package btpos.tf2.popfiledsl.tf2.itemattributes

import btpos.tf2.popfiledsl.modeling.*
import btpos.tf2.popfiledsl.serialization.codecs.*


/**
 * Items: The Flare Gun, The Scorch Shot, The Detonator, The Manmelter
 */
interface FlareGunAttributes : BaseGunAttributes {
	companion object : FlareGunAttributes
	
	/**
	 * In-Game: "Flare knocks back target on hit and explodes when it hits the ground. Increased knock back on burning players"
	 *
	 * 
	 *
	 * 0: Normal
	 *
	 * 1: Detonator
	 *
	 * 2: UNUSED
	 *
	 * 3: Scorch Shot
	 */
	context(attrs: IKeyValueMap)
	var flaregunFiresPelletsWithKnockback: Boolean?
		get() = attrs.getTyped("mod flaregun fires pellets with knockback", NumberSelectorCodec(3))
		set(value) = attrs.setNullable("mod flaregun fires pellets with knockback", value, NumberSelectorCodec(3))
}

inline operator fun FlareGunAttributes.invoke(scope: FlareGunAttributes.() -> Unit) {
	this.apply(scope)
}

