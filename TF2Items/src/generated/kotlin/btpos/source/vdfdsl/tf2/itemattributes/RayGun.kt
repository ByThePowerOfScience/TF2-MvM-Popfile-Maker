package btpos.source.vdfdsl.tf2.itemattributes

import btpos.source.vdfdsl.modeling.*
import btpos.source.vdfdsl.serialization.codecs.*
import btpos.source.vdfdsl.tf2.itemattributes.impl.*
import btpos.source.vdfdsl.tf2.tftypes.*
import java.util.*



interface RayGunAttributes : RocketLauncherAttributes {
	companion object {
		private val projectiles: ProjectilesAttributes = ProjectilesAttributes()
	}

	override val ammo: AmmoAttributes get() = super.ammo
	
	override val projectiles: ProjectilesAttributes get() = RayGunAttributes.projectiles

	open class AmmoAttributes : IBlockScoped {
		/**
		 * Removes ammo requirement to fire weapon.
		 */
		open val energyWeaponNoDrain: ItemAttributeNamed<Boolean> = ItemAttributeNamed("energy weapon no drain")
	}
	
	open class ProjectilesAttributes : RocketLauncherAttributes.ProjectilesAttributes() 
}