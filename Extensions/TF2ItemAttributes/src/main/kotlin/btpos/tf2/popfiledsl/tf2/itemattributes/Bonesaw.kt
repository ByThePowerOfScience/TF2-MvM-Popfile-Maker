package btpos.tf2.popfiledsl.tf2.itemattributes

import btpos.tf2.popfiledsl.modeling.*
import btpos.tf2.popfiledsl.serialization.codecs.*


/**
 * Items: TF_WEAPON_BONESAW, The Ubersaw, The Vita-Saw, Upgradeable TF_WEAPON_BONESAW, The Amputator, The Solemn Vow, Festive Ubersaw, Festive Bonesaw 2014
 * 
 */
interface BonesawAttributes : BaseMeleeAttributes {
	companion object : BonesawAttributes
	
	/**
	 * If the player should taunt on right click
	 * 
	 */
	context(attrs: IKeyValueMap)
	var specialTaunt: Boolean?
		get() = attrs.getTyped("special taunt", BinaryIntCodec)
		set(value) = attrs.setNullable("special taunt", value, BinaryIntCodec)
	
	/**
	 * Value type: additive_percentage
	 * 
	 * If the player should take a "head" when dealing damage with a melee
	 * 
	 * Also, is there a "speed modifier" for taking heads??????
	 * 
	 */
	context(attrs: IKeyValueMap)
	var addHeadOnHit: Boolean?
		get() = attrs.getTyped("add head on hit", BinaryIntCodec)
		set(value) = attrs.setNullable("add head on hit", value, BinaryIntCodec)
	
	/**
	 * Value type: additive_percentage
	 * 
	 */
	context(attrs: IKeyValueMap)
	var uberchargePreservedOnSpawnMax: Float?
		get() = attrs.getTyped("ubercharge_preserved_on_spawn_max")
		set(value) = attrs.setNullable("ubercharge_preserved_on_spawn_max", value)
	
	/**
	 * Value type: additive_percentage
	 * 
	 * On kill, take an organ (uses "heads" field like usual)
	 * 
	 */
	context(attrs: IKeyValueMap)
	var addHeadOnKill: Boolean?
		get() = attrs.getTyped("add_head_on_kill", BinaryIntCodec)
		set(value) = attrs.setNullable("add_head_on_kill", value, BinaryIntCodec)
}

inline operator fun BonesawAttributes.invoke(scope: BonesawAttributes.() -> Unit) {
	this.apply(scope)
}

