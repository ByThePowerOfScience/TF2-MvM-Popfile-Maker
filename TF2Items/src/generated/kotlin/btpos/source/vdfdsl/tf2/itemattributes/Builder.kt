package btpos.source.vdfdsl.tf2.itemattributes

import btpos.source.vdfdsl.modeling.*
import btpos.source.vdfdsl.serialization.codecs.*
import btpos.source.vdfdsl.tf2.itemattributes.impl.*
import btpos.source.vdfdsl.tf2.tftypes.*
import java.util.*



/**
 * Items: Construction PDA, Unimplemented Spy PDA
 */
interface BuilderAttributes : IBlockScoped {
	companion object {
		/**
		 * In-Game: "Self mark for death when hauling buildings"
		 *
		 * 
		 *
		 * Checked on owner.
		 */
		val markForDeathOnBuildingPickup = ItemAttributeNamed<Boolean>("mark for death on building pickup")
		
		/**
		 * 
		 *
		 * If 1.0, it's a wheatley sapper.
		 */
		val sapperVoicePak = ItemAttributeNamed<Float>("sapper voice pak")
		
		/**
		 * In-Game: "Increased robot Sapper radius and duration"
		 *
		 * 
		 *
		 * On base builder: If building an OBJ_ATTACHMENT_SAPPER on a mode that allows upgrades and it's built on a player (or MvM bot), gives the sapper a radius instead of being single-target.
		 */
		val roboSapper = ItemAttributeNamed<Boolean>("robo sapper")
	}

	/**
	 * In-Game: "Self mark for death when hauling buildings"
	 *
	 * 
	 *
	 * Checked on owner.
	 */
	val markForDeathOnBuildingPickup: ItemAttribute<Boolean> get() = BuilderAttributes.markForDeathOnBuildingPickup
	
	/**
	 * 
	 *
	 * If 1.0, it's a wheatley sapper.
	 */
	val sapperVoicePak: ItemAttribute<Float> get() = BuilderAttributes.sapperVoicePak
	
	/**
	 * In-Game: "Increased robot Sapper radius and duration"
	 *
	 * 
	 *
	 * On base builder: If building an OBJ_ATTACHMENT_SAPPER on a mode that allows upgrades and it's built on a player (or MvM bot), gives the sapper a radius instead of being single-target.
	 */
	val roboSapper: ItemAttribute<Boolean> get() = BuilderAttributes.roboSapper

   
}

