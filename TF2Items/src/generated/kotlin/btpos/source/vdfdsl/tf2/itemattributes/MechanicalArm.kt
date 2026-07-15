package btpos.source.vdfdsl.tf2.itemattributes

import btpos.source.vdfdsl.modeling.*
import btpos.source.vdfdsl.serialization.codecs.*
import btpos.source.vdfdsl.tf2.itemattributes.impl.*
import java.util.*

/**
 * Items: The Short Circuit
 */
interface MechanicalArmAttributes : BaseGunAttributes, IBlockScoped {
	companion object : MechanicalArmAttributes
	
	/**
	 * In-Game: "Per Shot: -N ammo"
	 *
	 * 
	 *
	 * How much ammo is used per shot. If 0, uses default.
	 */
	context(attrs: IKeyValueMap)
	override var ammoPerShot: Int?
		get() = super.ammoPerShot
		set(value) { super.ammoPerShot = value }
}

