package btpos.source.vdfdsl.tf2.itemattributes

import btpos.source.vdfdsl.modeling.*
import btpos.source.vdfdsl.serialization.codecs.*
import btpos.source.vdfdsl.tf2.itemattributes.impl.*
import java.util.*

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
	 * Ignites player on hit.
	 *
	 * Ignite enemies on hit.
	 */
	context(attrs: IKeyValueMap)
	override var setDamagetypeIgnite: Boolean?
		get() = super.setDamagetypeIgnite
		set(value) { super.setDamagetypeIgnite = value }
}

