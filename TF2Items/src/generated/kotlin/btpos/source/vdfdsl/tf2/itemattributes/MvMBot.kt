package btpos.source.vdfdsl.tf2.itemattributes

import btpos.source.vdfdsl.modeling.*
import btpos.source.vdfdsl.serialization.codecs.*
import btpos.source.vdfdsl.tf2.itemattributes.impl.*
import btpos.source.vdfdsl.tf2.tftypes.*
import java.util.*




interface MvMBotAttributes : IBlockScoped {
	companion object {
		/**
		 * 
		 *
		 * If true, spawns a rocketjump particle whenever the robot jumps.
		 */
		val customJumpParticle = ItemAttributeNamed<Boolean>("bot custom jump particle")
		
		/**
		 * 
		 *
		 * Defaults to 50, I guess it's a percentage.
		 */
		val medicUberHealthThreshold = ItemAttributeNamed<Int>("bot medic uber health threshold")
		
		/**
		 * 
		 *
		 * Defaults to -1.
		 */
		val medicUberDeployDelayDuration = ItemAttributeNamed<Int>("bot medic uber deploy delay duration")
	}

	/**
	 * 
	 *
	 * If true, spawns a rocketjump particle whenever the robot jumps.
	 */
	val customJumpParticle: ItemAttribute<Boolean> get() = MvMBotAttributes.customJumpParticle
	
	/**
	 * 
	 *
	 * Defaults to 50, I guess it's a percentage.
	 */
	val medicUberHealthThreshold: ItemAttribute<Int> get() = MvMBotAttributes.medicUberHealthThreshold
	
	/**
	 * 
	 *
	 * Defaults to -1.
	 */
	val medicUberDeployDelayDuration: ItemAttribute<Int> get() = MvMBotAttributes.medicUberDeployDelayDuration

   
}

