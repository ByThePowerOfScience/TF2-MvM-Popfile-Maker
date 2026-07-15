package btpos.source.vdfdsl.tf2.itemattributes

import btpos.source.vdfdsl.modeling.*
import btpos.source.vdfdsl.serialization.codecs.*
import btpos.source.vdfdsl.tf2.itemattributes.impl.*
import java.util.*

/**
 * Items: TF_WEAPON_BOTTLE, Upgradeable TF_WEAPON_BOTTLE, The Scottish Handshake
 */
interface BottleAttributes : BaseMeleeAttributes, IBlockScoped {
	companion object : BottleAttributes
	
	
}

