package btpos.source.vdfdsl.tf2.itemattributes

import btpos.source.vdfdsl.modeling.*
import btpos.source.vdfdsl.serialization.codecs.*
import btpos.source.vdfdsl.tf2.itemattributes.impl.*
import btpos.source.vdfdsl.tf2.tftypes.*
import java.util.*



interface RevolverAttributes : BaseGunAttributes {
	companion object {
		private val ammo: AmmoAttributes = AmmoAttributes()
	
		private val damage: DamageAttributes = DamageAttributes()
	
		private val firing: FiringAttributes = FiringAttributes()
	
		private val projectiles: ProjectilesAttributes = ProjectilesAttributes()
	}

	override val heads: HeadsAttributes get() = super.heads
	
	override val ammo: AmmoAttributes get() = RevolverAttributes.ammo
	
	override val damage: DamageAttributes get() = RevolverAttributes.damage
	
	override val firing: FiringAttributes get() = RevolverAttributes.firing
	
	override val projectiles: ProjectilesAttributes get() = RevolverAttributes.projectiles

	open class HeadsAttributes : IBlockScoped 
	
	open class AmmoAttributes : BaseGunAttributes.AmmoAttributes() 
	
	open class DamageAttributes : BaseGunAttributes.DamageAttributes() 
	
	open class FiringAttributes : BaseGunAttributes.FiringAttributes() {
		override val fireRate: FireRateAttributes = FireRateAttributes()
	
		open class FireRateAttributes : BaseGunAttributes.FiringAttributes.FireRateAttributes() 
	}
	
	open class ProjectilesAttributes : BaseGunAttributes.ProjectilesAttributes() {
		override val bullets: BulletsAttributes = BulletsAttributes()
	
		open class BulletsAttributes : BaseGunAttributes.ProjectilesAttributes.BulletsAttributes() 
	}
}