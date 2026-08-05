package btpos.source.vdfdsl.tf2.itemattributes

import btpos.source.vdfdsl.modeling.*
import btpos.source.vdfdsl.serialization.*
import btpos.source.vdfdsl.serialization.codecs.*
import btpos.source.vdfdsl.tf2.itemattributes.impl.*
import btpos.source.vdfdsl.tf2.tftypes.*
import java.util.*
import kotlin.time.Duration

interface ProjectileFlareAttributes : IBlockScoped, BaseProjectileAttributes {
	companion object : IBlockScoped {
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
		val multProjectileSpeed: BonusPenaltyHidden<Number, ItemAttributeNamed<Number>> = BonusPenaltyHidden(
		    ItemAttributeNamed<Number>("Projectile speed increased"),
		    ItemAttributeNamed<Number>("Projectile speed decreased"),
		    ItemAttributeNamed<Number>("Projectile speed increased HIDDEN"),
		)
	
		/**
		 * Bonus:
		 * 
		 * 	- In-Game: "+N% explosion radius"
		 * 
		 * Penalty:
		 * 
		 * 	- In-Game: "N% explosion radius"
		 */
		val multExplosionRadius: BonusPenalty<Number> = BonusPenalty(
		    ItemAttributeNamed("Blast radius increased"),
		    ItemAttributeNamed("Blast radius decreased"),
		)
	}
	
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
	val multProjectileSpeed: BonusPenaltyHidden<Number, ItemAttributeNamed<Number>> get() = ProjectileFlareAttributes.multProjectileSpeed
	
	/**
	 * Bonus:
	 * 
	 * 	- In-Game: "+N% explosion radius"
	 * 
	 * Penalty:
	 * 
	 * 	- In-Game: "N% explosion radius"
	 */
	val multExplosionRadius: BonusPenalty<Number> get() = ProjectileFlareAttributes.multExplosionRadius
	
	object Inherited : ProjectileFlareAttributes 
}