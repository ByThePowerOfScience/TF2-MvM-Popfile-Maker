package btpos.source.vdfdsl.tf2.itemattributes

import btpos.source.vdfdsl.modeling.*
import btpos.source.vdfdsl.serialization.codecs.*
import btpos.source.vdfdsl.tf2.itemattributes.impl.*
import btpos.source.vdfdsl.tf2.tftypes.*
import java.util.*



/**
 * Items: The Buff Banner, The Battalion's Backup, The Concheror, Festive Buff Banner, The B.A.S.E Jumper
 */
interface BuffItemAttributes : IBlockScoped {
	companion object {
		/**
		 * 
		 *
		 * Sets which banner is used.
		 *
		 * 0 = Buff Banner.
		 *
		 * 1 = Battalion's Backup.
		 *
		 * 2 = Concheror.
		 */
		val soldierBuffType = ItemAttributeNamed<Int>("mod soldier buff type")
		
		/**
		 * 
		 *
		 * Sets which banner is used.
		 *
		 * 0 = Buff Banner.
		 *
		 * 1 = Battalion's Backup.
		 *
		 * 2 = Concheror.
		 */
		val demoBuffType = ItemAttributeNamed<Int>("mod demo buff type")
		
		/**
		 * In-Game: "+N% buff duration"
		 *
		 * 
		 *
		 * Multiplier to buff duration.
		 */
		val increaseBuffDuration = ItemAttributeNamed<Float>("increase buff duration")
		
		/**
		 * In-Game: "+N% buff duration"
		 *
		 * 
		 *
		 * Multiplier to buff duration.
		 */
		val increaseBuffDurationHidden = ItemAttributeNamed<Float>("increase buff duration HIDDEN")
	}

	/**
	 * 
	 *
	 * Sets which banner is used.
	 *
	 * 0 = Buff Banner.
	 *
	 * 1 = Battalion's Backup.
	 *
	 * 2 = Concheror.
	 */
	val soldierBuffType: ItemAttribute<Int> get() = BuffItemAttributes.soldierBuffType
	
	/**
	 * 
	 *
	 * Sets which banner is used.
	 *
	 * 0 = Buff Banner.
	 *
	 * 1 = Battalion's Backup.
	 *
	 * 2 = Concheror.
	 */
	val demoBuffType: ItemAttribute<Int> get() = BuffItemAttributes.demoBuffType
	
	/**
	 * In-Game: "+N% buff duration"
	 *
	 * 
	 *
	 * Multiplier to buff duration.
	 */
	val increaseBuffDuration: ItemAttribute<Float> get() = BuffItemAttributes.increaseBuffDuration
	
	/**
	 * In-Game: "+N% buff duration"
	 *
	 * 
	 *
	 * Multiplier to buff duration.
	 */
	val increaseBuffDurationHidden: ItemAttribute<Float> get() = BuffItemAttributes.increaseBuffDurationHidden

   
}

