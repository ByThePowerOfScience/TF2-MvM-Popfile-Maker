package btpos.source.vdfdsl.tf2.itemattributes

import btpos.source.vdfdsl.modeling.*
import btpos.source.vdfdsl.serialization.codecs.*


/**
 * Items: TF_WEAPON_FIREAXE, The Axtinguisher, The Homewrecker, Upgradeable TF_WEAPON_FIREAXE, The Powerjack, The Back Scratcher, Sharpened Volcano Fragment, The Postal Pummeler, The Maul, The Third Degree, The Lollichop, Festive Axtinguisher
 */
interface FireAxeAttributes : btpos.source.vdfdsl.tf2.itemattributes.BaseMeleeAttributes, btpos.source.vdfdsl.tf2.itemattributes.IBlockScoped {
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
	context(attrs: btpos.source.vdfdsl.modeling.IKeyValueMap)
	var setDamagetypeIgnite: Boolean?
		get() = attrs.getTyped("Set DamageType Ignite", _root_ide_package_.btpos.source.vdfdsl.serialization.codecs.BinaryIntCodec)
		set(value) = attrs.setNullable("Set DamageType Ignite", value, _root_ide_package_.btpos.source.vdfdsl.serialization.codecs.BinaryIntCodec)
}

