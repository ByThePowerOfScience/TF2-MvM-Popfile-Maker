package btpos.source.vdfdsl.tf2.itemattributes

import btpos.source.vdfdsl.tf2.attributes.impl.IBlockScoped


/**
 * Items: Jarate, Festive Jarate, The Self-Aware Beauty Mark, Mad Milk, Mutated Milk, The Flying Guillotine, The Gas Passer, Unimplemented Spy Decoy Weapon
 */
interface JarAttributes : BaseGunAttributes, IBlockScoped {
	companion object : JarAttributes
	
	/**
	 * In-Game: "Overrides the projectile fired from the weapon. Takes values from 1 to 26, each representing a different projectile, and not all projectiles work on all weapons"
	 *
	 * 
	 *
	 * If unset, uses the weapon's default projectile type.
	 *
	 * Else use a numbered [btpos.source.vdfdsl.tf2.attributes.impl.ProjectileType].
	 *
	 * Used to select the model.
	 *
	 * Select between `TF_PROJECTILE_FESTIVE_JAR`, `TF_PROJECTILE_BREADMONSTER_JARATE`, and `TF_PROJECTILE_BREADMONSTER_MADMILK`.
	 *
	 * Otherwise uses default for its class.
	 */
	context(attrs: btpos.source.vdfdsl.modeling.IKeyValueMap)
	override var overrideProjectileType: Int?
		get() = super.overrideProjectileType
		set(value) {
			super.overrideProjectileType = value
		}
	
	/**
	 * In-Game: "N% movement speed on targets"
	 *
	 * 
	 *
	 * On player.
	 *
	 * If NOT `1.0`, stun the victim.
	 */
	context(attrs: btpos.source.vdfdsl.modeling.IKeyValueMap)
	var appliesSnareEffect: Float?
		get() = attrs.getTyped("applies snare effect")
		set(value) = attrs.setNullable("applies snare effect", value)
	
	/**
	 * In-Game: "Extinguishing teammates reduces cooldown by N%"
	 *
	 * 
	 *
	 * Subtracts this value from the cooldown.
	 */
	context(attrs: btpos.source.vdfdsl.modeling.IKeyValueMap)
	var extinguishReducesCooldown: Float?
		get() = attrs.getTyped("extinguish reduces cooldown")
		set(value) = attrs.setNullable("extinguish reduces cooldown", value)
}

