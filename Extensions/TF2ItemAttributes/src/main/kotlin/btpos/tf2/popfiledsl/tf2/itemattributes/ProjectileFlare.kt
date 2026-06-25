package btpos.tf2.popfiledsl.tf2.itemattributes

import btpos.tf2.popfiledsl.modeling.*
import btpos.tf2.popfiledsl.serialization.codecs.*


/**
 * 
 */
abstract class ProjectileFlareAttributes : BaseRocketAttributes() {
	companion object : ProjectileFlareAttributes() {
		operator fun invoke(scope: ProjectileFlareAttributes.Companion.() -> Unit) {
			this.apply(scope)
		}
	}
	
	/**
	 * 
	 * Bonus:
	 * 	Visible:
	 * 		Value type: percentage
	 * 		
	 * 		+N% projectile speed
	 * 		
	 * 	
	 * 	Hidden:
	 * 		Value type: percentage
	 * 		
	 * 		+N% projectile speed
	 * 		
	 * 
	 * Penalty:
	 * 	Value type: percentage
	 * 	
	 * 
	 * Checked on launcher
	 * 
	 * Bonus:
	 * 	Visible:
	 * 		Value type: percentage
	 * 		
	 * 		+N% projectile speed
	 * 		
	 * 	
	 * 	Hidden:
	 * 		Value type: percentage
	 * 		
	 * 		+N% projectile speed
	 * 		
	 * 
	 * Penalty:
	 * 	Value type: percentage
	 * 	
	 */
	override val ProjectileSpeedDecreased = BonusPenalty_BonusNested<VisHidden<Float, Float>, Float>(VisHidden<Float, Float>("Projectile speed increased", "Projectile speed increased HIDDEN"), "Projectile speed decreased")
	
	/**
	 * 
	 * Bonus:
	 * 	Value type: percentage
	 * 	
	 * 
	 * Penalty:
	 * 	Value type: percentage
	 * 	
	 * 
	 * Bonus:
	 * 	Value type: percentage
	 * 	
	 * 
	 * Penalty:
	 * 	Value type: percentage
	 * 	
	 * 
	 * Checked on launcher
	 * 
	 * Bonus:
	 * 	Value type: percentage
	 * 	
	 * 
	 * Penalty:
	 * 	Value type: percentage
	 * 	
	 */
	override val BlastRadiusDecreased = BonusPenalty<Float, Float>("Blast radius increased", "Blast radius decreased")
}

