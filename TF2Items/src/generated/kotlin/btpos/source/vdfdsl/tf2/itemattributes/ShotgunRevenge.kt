package btpos.source.vdfdsl.tf2.itemattributes

import btpos.source.vdfdsl.modeling.*
import btpos.source.vdfdsl.serialization.codecs.*
import btpos.source.vdfdsl.tf2.itemattributes.impl.*
import btpos.source.vdfdsl.tf2.tftypes.*
import java.util.*



interface ShotgunRevengeAttributes : ShotgunAttributes {
	companion object {
		private val ammo: AmmoAttributes = AmmoAttributes()
	
		private val damage: DamageAttributes = DamageAttributes()
	
		private val firing: FiringAttributes = FiringAttributes()
	
		private val projectiles: ProjectilesAttributes = ProjectilesAttributes()
	}

	override val revengeCrits: RevengeCritsAttributes get() = super.revengeCrits
	
	override val ammo: AmmoAttributes get() = ShotgunRevengeAttributes.ammo
	
	override val damage: DamageAttributes get() = ShotgunRevengeAttributes.damage
	
	override val firing: FiringAttributes get() = ShotgunRevengeAttributes.firing
	
	override val projectiles: ProjectilesAttributes get() = ShotgunRevengeAttributes.projectiles

	open class RevengeCritsAttributes : IBlockScoped {
		/**
		 * In-Game: "Gain 2 revenge crits for each sentry kill and 1 for each sentry assist when your sentry is destroyed."
		 * 
		 * Specifically checked here when it tries to gain revenge crits, which means removing this attribute from the Frontier Justice will remove its ability to gain revenge crits.
		 */
		open val canGainRevengeCrits: ItemAttributeNamed<Boolean> = ItemAttributeNamed("mod sentry killed revenge")
	}
	
	open class AmmoAttributes : ShotgunAttributes.AmmoAttributes() 
	
	open class DamageAttributes : ShotgunAttributes.DamageAttributes() 
	
	open class FiringAttributes : ShotgunAttributes.FiringAttributes() {
		override val fireRate: FireRateAttributes = FireRateAttributes()
	
		open class FireRateAttributes : ShotgunAttributes.FiringAttributes.FireRateAttributes() 
	}
	
	open class ProjectilesAttributes : ShotgunAttributes.ProjectilesAttributes() {
		override val bullets: BulletsAttributes = BulletsAttributes()
	
		open class BulletsAttributes : ShotgunAttributes.ProjectilesAttributes.BulletsAttributes() 
	}
}