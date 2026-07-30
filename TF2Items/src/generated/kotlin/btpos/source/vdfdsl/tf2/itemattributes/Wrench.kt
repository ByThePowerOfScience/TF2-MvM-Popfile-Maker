package btpos.source.vdfdsl.tf2.itemattributes

import btpos.source.vdfdsl.modeling.*
import btpos.source.vdfdsl.serialization.codecs.*
import btpos.source.vdfdsl.tf2.itemattributes.impl.*
import btpos.source.vdfdsl.tf2.tftypes.*
import java.util.*



interface WrenchAttributes : BaseMeleeAttributes {
	companion object {
		/**
		 * In-Game: "Press your reload key to choose to teleport to spawn or your exit teleporter"
		 * 
		 * If set, pressing reload shows the Eureka Effect teleport menu.
		 */
		val altFireTeleportToSpawn: ItemAttributeNamed<Boolean> = ItemAttributeNamed("alt fire teleport to spawn")
	
		private val crits: CritsAttributes = CritsAttributes()
	
		private val damage: DamageAttributes = DamageAttributes()
	
		private val onHit: OnHitAttributes = OnHitAttributes()
	
		private val swapWeapons: SwapWeaponsAttributes = SwapWeaponsAttributes()
	}

	override val buildings: BuildingsAttributes get() = super.buildings
	
	/**
	 * In-Game: "Press your reload key to choose to teleport to spawn or your exit teleporter"
	 * 
	 * If set, pressing reload shows the Eureka Effect teleport menu.
	 */
	val altFireTeleportToSpawn: ItemAttributeNamed<Boolean> get() = WrenchAttributes.altFireTeleportToSpawn
	
	override val crits: CritsAttributes get() = WrenchAttributes.crits
	
	override val damage: DamageAttributes get() = WrenchAttributes.damage
	
	override val onHit: OnHitAttributes get() = WrenchAttributes.onHit
	
	override val swapWeapons: SwapWeaponsAttributes get() = WrenchAttributes.swapWeapons

	open class BuildingsAttributes : IBlockScoped {
		open val constructionRate: BonusPenalty<Float> = BonusPenalty(
			ItemAttributeNamed("Construction rate increased"),
			ItemAttributeNamed("Construction rate decreased"),
		)
	
		open val repairRate: BonusPenalty<Float> = BonusPenalty(
			ItemAttributeNamed("Repair rate increased"),
			ItemAttributeNamed("Repair rate decreased"),
		)
	
		open val sentryGun: SentryGunAttributes = SentryGunAttributes()
	
		open class SentryGunAttributes : IBlockScoped {
			/**
			 * In-Game: "Replaces the Sentry with a Mini-Sentry"
			 * 
			 * Sentry built is a minisentry.
			 * 
			 * Detonates leveled sentries when equipping a wrench with this attribute.
			 * 
			 * If not in MvM (player is not on team "PVE_DEFENDERS"), detonate minis when unequipping a wrench with this attribute.
			 * 
			 * Removes engineer's glove on his model.
			 */
			open val wrenchBuildsMinisentry: ItemAttributeNamed<Boolean> = ItemAttributeNamed("mod wrench builds minisentry")
		}
	}
	
	open class CritsAttributes : BaseMeleeAttributes.CritsAttributes() 
	
	open class DamageAttributes : BaseMeleeAttributes.DamageAttributes() 
	
	open class OnHitAttributes : BaseMeleeAttributes.OnHitAttributes() 
	
	open class SwapWeaponsAttributes : BaseMeleeAttributes.SwapWeaponsAttributes() 
}