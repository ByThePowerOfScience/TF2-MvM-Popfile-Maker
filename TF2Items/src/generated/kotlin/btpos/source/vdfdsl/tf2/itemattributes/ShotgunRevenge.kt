package btpos.source.vdfdsl.tf2.itemattributes

import btpos.source.vdfdsl.modeling.*
import btpos.source.vdfdsl.serialization.codecs.*
import btpos.source.vdfdsl.tf2.itemattributes.impl.*
import btpos.source.vdfdsl.tf2.tftypes.*
import java.util.*



interface ShotgunRevengeAttributes : ShotgunAttributes {
	companion object 

	override val revengeCrits: RevengeCritsAttributes get() = super.revengeCrits

	open class RevengeCritsAttributes : IBlockScoped {
		/**
		 * In-Game: "Gain 2 revenge crits for each sentry kill and 1 for each sentry assist when your sentry is destroyed."
		 * 
		 * Specifically checked here when it tries to gain revenge crits, which means removing this attribute from the Frontier Justice will remove its ability to gain revenge crits.
		 */
		open val canGainRevengeCrits: ItemAttributeNamed<Boolean> = ItemAttributeNamed("mod sentry killed revenge")
	}
}