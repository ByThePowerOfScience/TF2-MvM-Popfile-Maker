package btpos.source.vdfdsl.tf2.itemattributes

import btpos.source.vdfdsl.tf2.itemattributes.impl.IBlockScoped


interface ProjectileFlareAttributes : BaseRocketAttributes, IBlockScoped {
	companion object : ProjectileFlareAttributes
	
	/**
	 * Bonus:
	 *
	 * 	- Visible:
	 *
	 * 		- In-Game: "+N% projectile speed"
	 *
	 * 	- Hidden:
	 *
	 * 		- In-Game: "+N% projectile speed"
	 *
	 * 
	 *
	 * Penalty:
	 *
	 * 	- In-Game: "N% projectile speed"
	 *
	 * 
	 *
	 * Checked on launcher.
	 */
	override val projectileSpeed get() = super.projectileSpeed
	
	/**
	 * Bonus:
	 *
	 * 	- In-Game: "+N% explosion radius"
	 *
	 * 
	 *
	 * Penalty:
	 *
	 * 	- In-Game: "N% explosion radius"
	 *
	 * 
	 *
	 * Checked on launcher.
	 */
	override val blastRadius get() = super.blastRadius
}

