package btpos.source.vdfdsl.tf2.itemattributes

import btpos.source.vdfdsl.modeling.*
import btpos.source.vdfdsl.serialization.codecs.*
import btpos.source.vdfdsl.tf2.itemattributes.impl.*
import java.util.*

/**
 * Items: The Flare Gun, The Detonator, The Manmelter, The Scorch Shot
 */
interface ProjectileFlareAttributes : BaseProjectileAttributes, IBlockScoped {
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
	val projectileSpeed get() = BonusPenalty_BonusNested<VisHidden<Number, Number>, Number>(VisHidden<Number, Number>("Projectile speed increased", "Projectile speed increased HIDDEN"), "Projectile speed decreased")
	
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
	val blastRadius get() = BonusPenalty<Number, Number>("Blast radius increased", "Blast radius decreased")
}

