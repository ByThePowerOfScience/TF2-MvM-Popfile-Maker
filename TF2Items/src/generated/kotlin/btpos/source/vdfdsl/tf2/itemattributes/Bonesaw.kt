package btpos.source.vdfdsl.tf2.itemattributes

import btpos.source.vdfdsl.modeling.*
import btpos.source.vdfdsl.serialization.codecs.*
import btpos.source.vdfdsl.tf2.itemattributes.impl.*
import btpos.source.vdfdsl.tf2.tftypes.*
import java.util.*



/**
 * Items: TF_WEAPON_BONESAW, The Ubersaw, The Vita-Saw, Upgradeable TF_WEAPON_BONESAW, The Amputator, The Solemn Vow, Festive Ubersaw, Festive Bonesaw 2014
 */
interface BonesawAttributes : IBlockScoped {
	companion object {
		/**
		 * 
		 *
		 * If the player should taunt on right click.
		 */
		val specialTaunt = ItemAttributeNamed<Boolean>("special taunt")
		
		/**
		 * 
		 *
		 * If the player should take a "head" when dealing damage with a melee.
		 */
		val addHeadOnHit = ItemAttributeNamed<Boolean>("add head on hit")
		
		/**
		 * In-Game: "Collect the organs of people you hit"
		 *
		 * 
		 */
		val uberchargePreservedOnSpawnMax = ItemAttributeNamed<Float>("ubercharge_preserved_on_spawn_max")
		
		/**
		 * In-Game: "Collect the organs of your victims"
		 *
		 * 
		 *
		 * On kill, take an organ (uses "heads" field like usual).
		 */
		val addHeadOnKill = ItemAttributeNamed<Boolean>("add_head_on_kill")
	}

	/**
	 * 
	 *
	 * If the player should taunt on right click.
	 */
	val specialTaunt: ItemAttribute<Boolean> get() = BonesawAttributes.specialTaunt
	
	/**
	 * 
	 *
	 * If the player should take a "head" when dealing damage with a melee.
	 */
	val addHeadOnHit: ItemAttribute<Boolean> get() = BonesawAttributes.addHeadOnHit
	
	/**
	 * In-Game: "Collect the organs of people you hit"
	 *
	 * 
	 */
	val uberchargePreservedOnSpawnMax: ItemAttribute<Float> get() = BonesawAttributes.uberchargePreservedOnSpawnMax
	
	/**
	 * In-Game: "Collect the organs of your victims"
	 *
	 * 
	 *
	 * On kill, take an organ (uses "heads" field like usual).
	 */
	val addHeadOnKill: ItemAttribute<Boolean> get() = BonesawAttributes.addHeadOnKill

   
}

