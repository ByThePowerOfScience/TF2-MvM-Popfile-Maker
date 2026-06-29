package btpos.tf2.popfiledsl.tf2.itemattributes

import btpos.tf2.popfiledsl.modeling.*
import btpos.tf2.popfiledsl.serialization.codecs.*


/**
 * 
 */
interface ProjectileFlareAttributes : BaseRocketAttributes {
	companion object : ProjectileFlareAttributes
	
	/**
	 * 
	 * Bonus:
	 * 	- Visible:
	 * 		- Value type: percentage
	 * 		- +N% projectile speed
	 * 	- Hidden:
	 * 		- Value type: percentage
	 * 		- +N% projectile speed
	 * 
	 * Penalty:
	 * 	- Value type: percentage
	 * 	- N% projectile speed
	 * 
	 * Checked on launcher
	 * 
	 * 
	 * Bonus:
	 * 	- Visible:
	 * 		- Value type: percentage
	 * 		- +N% projectile speed
	 * 	- Hidden:
	 * 		- Value type: percentage
	 * 		- +N% projectile speed
	 * 
	 * Penalty:
	 * 	- Value type: percentage
	 * 	- N% projectile speed
	 */
	override val projectileSpeed get() = BonusPenalty_BonusNested<VisHidden<Float, Float>, Float>(VisHidden<Float, Float>("Projectile speed increased", "Projectile speed increased HIDDEN"), "Projectile speed decreased")
	
	/**
	 * 
	 * Bonus:
	 * 	- Value type: percentage
	 * 	- +N% explosion radius
	 * 
	 * Penalty:
	 * 	- Value type: percentage
	 * 	- N% explosion radius
	 * 
	 * Checked on launcher
	 * 
	 * 
	 * Bonus:
	 * 	- Value type: percentage
	 * 	- +N% explosion radius
	 * 
	 * Penalty:
	 * 	- Value type: percentage
	 * 	- N% explosion radius
	 */
	override val blastRadius get() = BonusPenalty<Float, Float>("Blast radius increased", "Blast radius decreased")
}

inline operator fun ProjectileFlareAttributes.invoke(scope: ProjectileFlareAttributes.() -> Unit) {
	this.apply(scope)
}

