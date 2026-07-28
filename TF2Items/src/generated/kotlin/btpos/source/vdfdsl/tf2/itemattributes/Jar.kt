package btpos.source.vdfdsl.tf2.itemattributes

import btpos.source.vdfdsl.modeling.*
import btpos.source.vdfdsl.serialization.codecs.*
import btpos.source.vdfdsl.tf2.itemattributes.impl.*
import btpos.source.vdfdsl.tf2.tftypes.*
import java.util.*



/**
 * Items: Jarate, Festive Jarate, The Self-Aware Beauty Mark, Mad Milk, Mutated Milk, The Flying Guillotine, The Gas Passer, Unimplemented Spy Decoy Weapon
 */
interface JarAttributes : IBlockScoped {
	companion object {
		/**
		 * In-Game: "Overrides the projectile fired from the weapon. Takes values from 1 to 26, each representing a different projectile, and not all projectiles work on all weapons"
		 *
		 * 
		 *
		 * Used to select the model.
		 *
		 * Select between `TF_PROJECTILE_FESTIVE_JAR`, `TF_PROJECTILE_BREADMONSTER_JARATE`, and `TF_PROJECTILE_BREADMONSTER_MADMILK`.
		 *
		 * Otherwise uses default for its class.
		 */
		val overrideProjectileType = ItemAttributeNamed<TFProjectileType>("override projectile type")
		
		/**
		 * In-Game: "N% movement speed on targets"
		 *
		 * 
		 *
		 * If NOT `1.0`, stun the victim.
		 *
		 * Checked on player.
		 */
		val appliesSnareEffect = ItemAttributeNamed<Float>("applies snare effect")
		
		/**
		 * In-Game: "Extinguishing teammates reduces cooldown by N%"
		 *
		 * 
		 *
		 * Subtracts this value from the cooldown.
		 */
		val extinguishReducesCooldown = ItemAttributeNamed<Float>("extinguish reduces cooldown")
	}

	/**
	 * In-Game: "Overrides the projectile fired from the weapon. Takes values from 1 to 26, each representing a different projectile, and not all projectiles work on all weapons"
	 *
	 * 
	 *
	 * Used to select the model.
	 *
	 * Select between `TF_PROJECTILE_FESTIVE_JAR`, `TF_PROJECTILE_BREADMONSTER_JARATE`, and `TF_PROJECTILE_BREADMONSTER_MADMILK`.
	 *
	 * Otherwise uses default for its class.
	 */
	val overrideProjectileType: ItemAttribute<TFProjectileType> get() = JarAttributes.overrideProjectileType
	
	/**
	 * In-Game: "N% movement speed on targets"
	 *
	 * 
	 *
	 * If NOT `1.0`, stun the victim.
	 *
	 * Checked on player.
	 */
	val appliesSnareEffect: ItemAttribute<Float> get() = JarAttributes.appliesSnareEffect
	
	/**
	 * In-Game: "Extinguishing teammates reduces cooldown by N%"
	 *
	 * 
	 *
	 * Subtracts this value from the cooldown.
	 */
	val extinguishReducesCooldown: ItemAttribute<Float> get() = JarAttributes.extinguishReducesCooldown

   
}

