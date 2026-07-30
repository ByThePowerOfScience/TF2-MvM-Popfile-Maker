package btpos.source.vdfdsl.tf2.itemattributes

import btpos.source.vdfdsl.modeling.*
import btpos.source.vdfdsl.serialization.codecs.*
import btpos.source.vdfdsl.tf2.itemattributes.impl.*
import btpos.source.vdfdsl.tf2.tftypes.*
import java.util.*



interface ScattergunAttributes : ShotgunAttributes {
	companion object {
		private val ammo: AmmoAttributes = AmmoAttributes()
	
		private val damage: DamageAttributes = DamageAttributes()
	
		private val firing: FiringAttributes = FiringAttributes()
	
		private val projectiles: ProjectilesAttributes = ProjectilesAttributes()
	}

	override val onHit: OnHitAttributes get() = super.onHit
	
	override val reloading: ReloadingAttributes get() = super.reloading
	
	override val ammo: AmmoAttributes get() = ScattergunAttributes.ammo
	
	override val damage: DamageAttributes get() = ScattergunAttributes.damage
	
	override val firing: FiringAttributes get() = ScattergunAttributes.firing
	
	override val projectiles: ProjectilesAttributes get() = ScattergunAttributes.projectiles

	open class OnHitAttributes : IBlockScoped {
		/**
		 * In-Game: "Knockback on the target and shooter"
		 * 
		 * Note: if `scattergun_knockback_mult` is greater than 1.0, this is not necessary.
		 */
		open val scattergunHasKnockback: ItemAttributeNamed<Boolean> = ItemAttributeNamed("scattergun has knockback")
	
		open val scattergunKnockbackMult: ItemAttributeNamed<Float> = ItemAttributeNamed("scattergun knockback mult")
	}
	
	open class ReloadingAttributes : IBlockScoped {
		/**
		 * If 1, reloads entire clip at once.
		 */
		open val scattergunNoReloadSingle: ItemAttributeNamed<Boolean> = ItemAttributeNamed("scattergun no reload single")
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