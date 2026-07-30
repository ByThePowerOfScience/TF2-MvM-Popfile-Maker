package btpos.source.vdfdsl.tf2.itemattributes

import btpos.source.vdfdsl.modeling.*
import btpos.source.vdfdsl.serialization.codecs.*
import btpos.source.vdfdsl.tf2.itemattributes.impl.*
import btpos.source.vdfdsl.tf2.tftypes.*
import java.util.*



interface CrossbowAttributes : RocketLauncherAttributes {
	companion object {
		private val projectiles: ProjectilesAttributes = ProjectilesAttributes()
	}

	override val reloading: ReloadingAttributes get() = super.reloading
	
	override val projectiles: ProjectilesAttributes get() = CrossbowAttributes.projectiles

	open class ReloadingAttributes : IBlockScoped {
		open val reloadTime: BonusPenalty<Float> = BonusPenalty(
			ItemAttributeNamed("Reload time decreased"),
			ItemAttributeNamed("Reload time increased"),
		)
	
		/**
		 * In-Game: "N% slower reload time"
		 */
		open val reloadTimeIncreasedHidden: ItemAttributeNamed<Float> = ItemAttributeNamed("reload time increased hidden")
	
		/**
		 * In-Game: "+N% faster reload time"
		 */
		open val fasterReloadRate: ItemAttributeNamed<Float> = ItemAttributeNamed("faster reload rate")
	}
	
	open class ProjectilesAttributes : RocketLauncherAttributes.ProjectilesAttributes() 
}