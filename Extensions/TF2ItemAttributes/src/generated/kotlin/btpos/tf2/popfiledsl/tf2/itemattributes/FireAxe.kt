package btpos.tf2.popfiledsl.tf2.itemattributes

import btpos.tf2.popfiledsl.modeling.*
import btpos.tf2.popfiledsl.serialization.codecs.*


/**
 * Items: TF_WEAPON_FIREAXE, The Axtinguisher, The Homewrecker, Upgradeable TF_WEAPON_FIREAXE, The Powerjack, The Back Scratcher, Sharpened Volcano Fragment, The Postal Pummeler, The Maul, The Third Degree, The Lollichop, Festive Axtinguisher
 */
interface FireAxeAttributes : BaseMeleeAttributes, IBlockScoped {
	companion object : FireAxeAttributes
	
	/**
	 * In-Game: "On Hit: target is engulfed in flames"
	 *
	 * 
	 *
	 * Ignite enemies on hit.
	 *
	 * In vanilla, this is indeed only checked on Fire Axes.
	 */
	context(attrs: IKeyValueMap)
	var setDamagetypeIgnite: Boolean?
		get() = attrs.getTyped("Set DamageType Ignite", BinaryIntCodec)
		set(value) = attrs.setNullable("Set DamageType Ignite", value, BinaryIntCodec)
}

