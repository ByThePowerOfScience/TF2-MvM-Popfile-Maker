package btpos.source.vdfdsl.tf2.itemattributes

import btpos.source.vdfdsl.modeling.*
import btpos.source.vdfdsl.serialization.codecs.*
import btpos.source.vdfdsl.tf2.itemattributes.impl.*
import java.util.*

/**
 * Items: Construction PDA, Unimplemented Spy PDA
 */
interface BuilderAttributes : WeaponBaseAttributes, IBlockScoped {
	companion object : BuilderAttributes
	
	/**
	 * In-Game: "Self mark for death when hauling buildings"
	 *
	 * 
	 *
	 * Checked on owner.
	 */
	context(attrs: IKeyValueMap)
	var markForDeathOnBuildingPickup: Boolean?
		get() = attrs.getTyped("mark for death on building pickup", BinaryIntCodec)
		set(value) = attrs.setNullable("mark for death on building pickup", value, BinaryIntCodec)
	
	/**
	 * 
	 *
	 * If 1.0, it's a wheatley sapper.
	 */
	context(attrs: IKeyValueMap)
	var sapperVoicePak: Int?
		get() = attrs.getTyped("sapper voice pak")
		set(value) = attrs.setNullable("sapper voice pak", value)
	
	/**
	 * In-Game: "Increased robot Sapper radius and duration"
	 *
	 * 
	 *
	 * On base builder: If building an OBJ_ATTACHMENT_SAPPER on a mode that allows upgrades and it's built on a player (or MvM bot), gives the sapper a radius instead of being single-target.
	 */
	context(attrs: IKeyValueMap)
	var roboSapper: Boolean?
		get() = attrs.getTyped("robo sapper", BinaryIntCodec)
		set(value) = attrs.setNullable("robo sapper", value, BinaryIntCodec)
}

