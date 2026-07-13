package btpos.source.vdfdsl.tf2.attributes

import btpos.source.vdfdsl.modeling.*
import btpos.source.vdfdsl.serialization.codecs.*
import btpos.source.vdfdsl.tf2.attributes.impl.*
import java.util.*

/**
 * Items: TF_WEAPON_BONESAW, The Ubersaw, The Vita-Saw, Upgradeable TF_WEAPON_BONESAW, The Amputator, The Solemn Vow, Festive Ubersaw, Festive Bonesaw 2014
 */
interface BonesawAttributes : BaseMeleeAttributes, IBlockScoped {
	companion object : BonesawAttributes
	
	/**
	 * 
	 *
	 * If true, prevents holiday taunts from being used.
	 *
	 * If true, the player will taunt on right click.
	 */
	context(attrs: IKeyValueMap)
	override var specialTaunt: Boolean?
		get() = super.specialTaunt
		set(value) { super.specialTaunt = value }
	
	/**
	 * 
	 *
	 * This part is only semi-implemented...
	 *
	 * Gives extra player movespeed the more heads you have.
	 *
	 * Will not work if the player is not a Medic wielding the VitaSaw.
	 *
	 * If the player should take a "head" when dealing damage with a melee.
	 */
	context(attrs: IKeyValueMap)
	override var addHeadOnHit: Boolean?
		get() = super.addHeadOnHit
		set(value) { super.addHeadOnHit = value }
	
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

