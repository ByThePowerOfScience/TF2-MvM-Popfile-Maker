package btpos.source.vdfdsl.tf2.itemattributes

import btpos.source.vdfdsl.modeling.*
import btpos.source.vdfdsl.serialization.codecs.*


/**
 * Items: Engineer PDA, Sapper
 */
interface BuilderAttributes : btpos.source.vdfdsl.tf2.itemattributes.WeaponBaseAttributes, btpos.source.vdfdsl.tf2.itemattributes.IBlockScoped {
	companion object : BuilderAttributes
	
	/**
	 * In-Game: "Self mark for death when hauling buildings"
	 *
	 * 
	 *
	 * On owner.
	 */
	context(attrs: btpos.source.vdfdsl.modeling.IKeyValueMap)
	var markForDeathOnBuildingPickup: Boolean?
		get() = attrs.getTyped("mark for death on building pickup", _root_ide_package_.btpos.source.vdfdsl.serialization.codecs.BinaryIntCodec)
		set(value) = attrs.setNullable("mark for death on building pickup", value, _root_ide_package_.btpos.source.vdfdsl.serialization.codecs.BinaryIntCodec)
	
	/**
	 * 
	 *
	 * If true.0, it's a wheatley sapper.
	 */
	context(attrs: btpos.source.vdfdsl.modeling.IKeyValueMap)
	var sapperVoicePak: Int?
		get() = attrs.getTyped("sapper voice pak")
		set(value) = attrs.setNullable("sapper voice pak", value)
	
	/**
	 * In-Game: "Increased robot Sapper radius and duration"
	 *
	 * 
	 *
	 * If building an OBJ_ATTACHMENT_SAPPER on a mode that allows upgrades and it's built on a player (or MvM bot):.
	 *
	 * Gives the sapper a radius instead of being single-target.
	 */
	context(attrs: btpos.source.vdfdsl.modeling.IKeyValueMap)
	var roboSapper: Int?
		get() = attrs.getTyped("robo sapper")
		set(value) = attrs.setNullable("robo sapper", value)
}

