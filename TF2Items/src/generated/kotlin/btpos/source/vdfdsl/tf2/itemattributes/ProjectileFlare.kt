package btpos.source.vdfdsl.tf2.itemattributes

import btpos.source.vdfdsl.modeling.*
import btpos.source.vdfdsl.serialization.codecs.*
import btpos.source.vdfdsl.tf2.itemattributes.impl.*
import btpos.source.vdfdsl.tf2.tftypes.*
import java.util.*
import kotlin.time.Duration

interface ProjectileFlareAttributes : BaseProjectileAttributes {
	companion object : IBlockScoped 

	/**
	 * Bonus:
	 * 
	 * 	- In-Game: "+N% projectile speed"
	 * 
	 * Penalty:
	 * 
	 * 	- In-Game: "N% projectile speed"
	 * 
	 * Hidden:
	 * 
	 * 	- In-Game: "+N% projectile speed"
	 */
	val projectileSpeed: BonusPenaltyHidden<Number, ItemAttributeNamed<Number>> get() = ProjectileFlareAttributes.projectileSpeed.get()
	
	/**
	 * Bonus:
	 * 
	 * 	- In-Game: "+N% explosion radius"
	 * 
	 * Penalty:
	 * 
	 * 	- In-Game: "N% explosion radius"
	 */
	val blastRadius: BonusPenalty<Number> get() = ProjectileFlareAttributes.blastRadius.get()
}