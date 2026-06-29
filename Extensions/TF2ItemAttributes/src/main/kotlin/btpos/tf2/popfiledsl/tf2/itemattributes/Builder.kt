package btpos.tf2.popfiledsl.tf2.itemattributes

import btpos.tf2.popfiledsl.modeling.*
import btpos.tf2.popfiledsl.serialization.codecs.*


/**
 * Items: Engineer PDA, Sapper
 * 
 */
interface BuilderAttributes : WeaponBaseAttributes {
	companion object : BuilderAttributes
	
	/**
	 * On owner
	 * 
	 */
	context(attrs: IKeyValueMap)
	var markForDeathOnBuildingPickup: Boolean?
		get() = attrs.getTyped("mark for death on building pickup", BinaryIntCodec)
		set(value) = attrs.setNullable("mark for death on building pickup", value, BinaryIntCodec)
	
	/**
	 * If true.0, it's a wheatley sapper
	 * 
	 */
	context(attrs: IKeyValueMap)
	var sapperVoicePak: Int?
		get() = attrs.getTyped("sapper voice pak")
		set(value) = attrs.setNullable("sapper voice pak", value)
	
	/**
	 * If building an OBJ_ATTACHMENT_SAPPER on a mode that allows upgrades and it's built on a player (or MvM bot):
	 * 
	 * Gives the sapper a radius instead of being single-target
	 * 
	 */
	context(attrs: IKeyValueMap)
	var roboSapper: Boolean?
		get() = attrs.getTyped("robo sapper", BinaryIntCodec)
		set(value) = attrs.setNullable("robo sapper", value, BinaryIntCodec)
}

inline operator fun BuilderAttributes.invoke(scope: BuilderAttributes.() -> Unit) {
	this.apply(scope)
}

