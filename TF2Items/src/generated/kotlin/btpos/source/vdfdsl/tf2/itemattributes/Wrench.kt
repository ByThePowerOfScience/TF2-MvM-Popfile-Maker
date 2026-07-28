package btpos.source.vdfdsl.tf2.itemattributes

import btpos.source.vdfdsl.modeling.*
import btpos.source.vdfdsl.serialization.codecs.*
import btpos.source.vdfdsl.tf2.itemattributes.impl.*
import btpos.source.vdfdsl.tf2.tftypes.*
import java.util.*



/**
 * Items: Stock Wrench + Reskins, Golden Wrench, The Southern Hospitality, The Jag, The Eureka Effect, The Gunslinger
 */
interface WrenchAttributes : IBlockScoped {
	companion object {
		/**
		 * In-Game: "Press your reload key to choose to teleport to spawn or your exit teleporter"
		 *
		 * 
		 *
		 * If set, pressing reload shows the Eureka Effect teleport menu.
		 */
		val altFireTeleportToSpawn = ItemAttributeNamed<Boolean>("alt fire teleport to spawn")
		
		/**
		 * In-Game: "Replaces the Sentry with a Mini-Sentry"
		 *
		 * 
		 *
		 * Detonates leveled sentries when equipping a wrench with this attribute.
		 *
		 * If not in MvM (player is not on team "PVE_DEFENDERS"), detonate minis when unequipping a wrench with this attribute.
		 *
		 * Removes engineer's glove on his model.
		 *
		 * Also determines if it's a "PDQ", which obviously builds minisentries.
		 */
		val wrenchBuildsMinisentry = ItemAttributeNamed<Boolean>("mod wrench builds minisentry")
		
		/**
		 * Bonus:
		 *
		 * 	- In-Game: "Construction hit speed boost increased by N%"
		 *
		 * 
		 *
		 * Penalty:
		 *
		 * 	- In-Game: "Construction hit speed boost decreased by N%"
		 *
		 * 
		 *
		 * Passive build-speed multiplier, same as the convar `tf_construction_build_rate_multiplier`.
		 */
		val constructionRate = BonusPenalty(
			ItemAttributeNamed<Float>("Construction rate increased"),
			ItemAttributeNamed<Float>("Construction rate decreased")
		)
		
		/**
		 * Bonus:
		 *
		 * 	- In-Game: "N% faster repair rate"
		 *
		 * 
		 *
		 * Penalty:
		 *
		 * 	- In-Game: "N% slower repair rate"
		 *
		 * 
		 *
		 * Multiplier to how much health is given per wrench hit.
		 */
		val repairRate = BonusPenalty(
			ItemAttributeNamed<Float>("Repair rate increased"),
			ItemAttributeNamed<Float>("Repair rate decreased")
		)
	}

	/**
	 * In-Game: "Press your reload key to choose to teleport to spawn or your exit teleporter"
	 *
	 * 
	 *
	 * If set, pressing reload shows the Eureka Effect teleport menu.
	 */
	val altFireTeleportToSpawn: ItemAttribute<Boolean> get() = WrenchAttributes.altFireTeleportToSpawn
	
	/**
	 * In-Game: "Replaces the Sentry with a Mini-Sentry"
	 *
	 * 
	 *
	 * Detonates leveled sentries when equipping a wrench with this attribute.
	 *
	 * If not in MvM (player is not on team "PVE_DEFENDERS"), detonate minis when unequipping a wrench with this attribute.
	 *
	 * Removes engineer's glove on his model.
	 *
	 * Also determines if it's a "PDQ", which obviously builds minisentries.
	 */
	val wrenchBuildsMinisentry: ItemAttribute<Boolean> get() = WrenchAttributes.wrenchBuildsMinisentry
	
	/**
	 * Bonus:
	 *
	 * 	- In-Game: "Construction hit speed boost increased by N%"
	 *
	 * 
	 *
	 * Penalty:
	 *
	 * 	- In-Game: "Construction hit speed boost decreased by N%"
	 *
	 * 
	 *
	 * Passive build-speed multiplier, same as the convar `tf_construction_build_rate_multiplier`.
	 */
	val constructionRate: ItemAttribute<Float> get() = WrenchAttributes.constructionRate
	
	/**
	 * Bonus:
	 *
	 * 	- In-Game: "N% faster repair rate"
	 *
	 * 
	 *
	 * Penalty:
	 *
	 * 	- In-Game: "N% slower repair rate"
	 *
	 * 
	 *
	 * Multiplier to how much health is given per wrench hit.
	 */
	val repairRate: ItemAttribute<Float> get() = WrenchAttributes.repairRate

   
}

