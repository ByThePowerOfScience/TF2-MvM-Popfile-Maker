package btpos.source.vdfdsl.tf2.itemattributes

import btpos.source.vdfdsl.modeling.*
import btpos.source.vdfdsl.serialization.codecs.*


/**
 * Items: TF_WEAPON_BONESAW, The Ubersaw, The Vita-Saw, Upgradeable TF_WEAPON_BONESAW, The Amputator, The Solemn Vow, Festive Ubersaw, Festive Bonesaw 2014
 */
interface BonesawAttributes : btpos.source.vdfdsl.tf2.itemattributes.BaseMeleeAttributes, btpos.source.vdfdsl.tf2.itemattributes.IBlockScoped {
	companion object : BonesawAttributes
	
	/**
	 * 
	 *
	 * If true, the player will taunt on right click.
	 */
	context(attrs: btpos.source.vdfdsl.modeling.IKeyValueMap)
	var specialTaunt: Boolean?
		get() = attrs.getTyped("special taunt", _root_ide_package_.btpos.source.vdfdsl.serialization.codecs.BinaryIntCodec)
		set(value) = attrs.setNullable("special taunt", value, _root_ide_package_.btpos.source.vdfdsl.serialization.codecs.BinaryIntCodec)
	
	/**
	 * 
	 *
	 * If the player should take a "head" when dealing damage with a melee.
	 */
	context(attrs: btpos.source.vdfdsl.modeling.IKeyValueMap)
	var addHeadOnHit: Boolean?
		get() = attrs.getTyped("add head on hit", _root_ide_package_.btpos.source.vdfdsl.serialization.codecs.BinaryIntCodec)
		set(value) = attrs.setNullable("add head on hit", value, _root_ide_package_.btpos.source.vdfdsl.serialization.codecs.BinaryIntCodec)
	
	/**
	 * In-Game: "Collect the organs of people you hit"
	 *
	 * 
	 */
	context(attrs: btpos.source.vdfdsl.modeling.IKeyValueMap)
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
	context(attrs: btpos.source.vdfdsl.modeling.IKeyValueMap)
	var addHeadOnKill: Boolean?
		get() = attrs.getTyped("add_head_on_kill", _root_ide_package_.btpos.source.vdfdsl.serialization.codecs.BinaryIntCodec)
		set(value) = attrs.setNullable("add_head_on_kill", value, _root_ide_package_.btpos.source.vdfdsl.serialization.codecs.BinaryIntCodec)
}

