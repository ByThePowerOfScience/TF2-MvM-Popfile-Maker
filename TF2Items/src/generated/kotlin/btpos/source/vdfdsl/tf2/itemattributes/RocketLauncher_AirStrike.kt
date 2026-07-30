package btpos.source.vdfdsl.tf2.itemattributes

import btpos.source.vdfdsl.modeling.*
import btpos.source.vdfdsl.serialization.codecs.*
import btpos.source.vdfdsl.tf2.itemattributes.impl.*
import btpos.source.vdfdsl.tf2.tftypes.*
import java.util.*



interface RocketLauncher_AirStrikeAttributes : RocketLauncherAttributes {
	companion object {
		private val projectiles: ProjectilesAttributes = ProjectilesAttributes()
	}

	override val ammo: AmmoAttributes get() = super.ammo
	
	override val projectiles: ProjectilesAttributes get() = RocketLauncher_AirStrikeAttributes.projectiles

	open class AmmoAttributes : IBlockScoped {
		open val clipSize: ClipSizeAttributes = ClipSizeAttributes()
	
		open class ClipSizeAttributes : IBlockScoped {
			/**
			 * In-Game: "Clip size increased on kill"
			 * 
			 * This attribute is on all weapons, but it's specifically checked for on the Air Strike.
			 */
			open val clipsizeIncreaseOnKill: ItemAttributeNamed<Int> = ItemAttributeNamed("clipsize increase on kill")
		}
	}
	
	open class ProjectilesAttributes : RocketLauncherAttributes.ProjectilesAttributes() 
}