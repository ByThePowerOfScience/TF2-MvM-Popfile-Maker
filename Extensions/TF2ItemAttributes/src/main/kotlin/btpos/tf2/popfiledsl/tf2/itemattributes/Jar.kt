package btpos.tf2.popfiledsl.tf2.itemattributes

import btpos.tf2.popfiledsl.modeling.*
import btpos.tf2.popfiledsl.serialization.codecs.*


/**
 * Items: Jarate, Festive Jarate, The Self-Aware Beauty Mark, Mad Milk, Mutated Milk, The Flying Guillotine, The Gas Passer, Unimplemented Spy Decoy Weapon
 * 
 */
abstract class JarAttributes : BaseGunAttributes() {
	companion object : JarAttributes() {
		operator fun invoke(scope: JarAttributes.Companion.() -> Unit) {
			this.apply(scope)
		}
	}
	
	/**
	 * If unset, uses the weapon's default projectile type.
	 * Else use a numbered [projectile type](#ProjectileTypes)
	 * 
	 * Used to select the model
	 * Select between `TF_PROJECTILE_FESTIVE_JAR`, `TF_PROJECTILE_BREADMONSTER_JARATE`, and `TF_PROJECTILE_BREADMONSTER_MADMILK`
	 * Otherwise uses default for its class
	 */
	override context(attrs: IKeyValueMap)
	var overrideProjectileType: Int?
		get() = attrs.getTyped("override projectile type")
		set(value) = attrs.setNullable("override projectile type", value)
	
	/**
	 * Value type: percentage
	 * 
	 * On player
	 * If NOT `1.0`, stun the victim
	 */
	context(attrs: IKeyValueMap)
	var appliesSnareEffect: Float?
		get() = attrs.getTyped("applies snare effect")
		set(value) = attrs.setNullable("applies snare effect", value)
	
	/**
	 * Value type: percentage
	 * 
	 * Subtracts this value from the cooldown
	 */
	context(attrs: IKeyValueMap)
	var extinguishReducesCooldown: Float?
		get() = attrs.getTyped("extinguish reduces cooldown")
		set(value) = attrs.setNullable("extinguish reduces cooldown", value)
}

