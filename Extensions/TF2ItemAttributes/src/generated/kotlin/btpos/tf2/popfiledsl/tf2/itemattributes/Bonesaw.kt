package btpos.tf2.popfiledsl.tf2.itemattributes

import btpos.tf2.popfiledsl.modeling.*
import btpos.tf2.popfiledsl.serialization.codecs.*


/**
 * Items: TF_WEAPON_BONESAW, The Ubersaw, The Vita-Saw, Upgradeable TF_WEAPON_BONESAW, The Amputator, The Solemn Vow, Festive Ubersaw, Festive Bonesaw 2014
 */
interface BonesawAttributes : BaseMeleeAttributes, IBlockScoped {
	companion object : BonesawAttributes
	
	/**
	 * 
	 *
	 * If true, the player will taunt on right click.
	 */
	context(attrs: IKeyValueMap)
	var specialTaunt: Boolean?
		get() = attrs.getTyped("special taunt", BinaryIntCodec)
		set(value) = attrs.setNullable("special taunt", value, BinaryIntCodec)
	
	/**
	 * 
	 *
	 * If the player should take a "head" when dealing damage with a melee.
	 */
	context(attrs: IKeyValueMap)
	var addHeadOnHit: Boolean?
		get() = attrs.getTyped("add head on hit", BinaryIntCodec)
		set(value) = attrs.setNullable("add head on hit", value, BinaryIntCodec)
	
	/**
	 * In-Game: "Collect the organs of people you hit"
	 *
	 * 
	 */
	context(attrs: IKeyValueMap)
	var uberchargePreservedOnSpawnMax: Float?
		get() = attrs.getTyped("ubercharge_preserved_on_spawn_max")
		set(value) = attrs.setNullable("ubercharge_preserved_on_spawn_max", value)
	
	/**
	 * In-Game: "Collect the organs of your victims"
	 *
	 * 
	 *
	 * On kill, take an organ (uses "heads" field like usual).
	 */
	context(attrs: IKeyValueMap)
	var addHeadOnKill: Boolean?
		get() = attrs.getTyped("add_head_on_kill", BinaryIntCodec)
		set(value) = attrs.setNullable("add_head_on_kill", value, BinaryIntCodec)
}

