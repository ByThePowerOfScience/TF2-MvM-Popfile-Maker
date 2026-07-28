package btpos.source.vdfdsl.tf2.itemattributes

import btpos.source.vdfdsl.modeling.*
import btpos.source.vdfdsl.serialization.codecs.*
import btpos.source.vdfdsl.tf2.itemattributes.impl.*
import btpos.source.vdfdsl.tf2.tftypes.*
import java.util.*



/**
 * Items: Spellbook
 */
interface ThrowableAttributes : IBlockScoped {
	companion object {
		/**
		 * 
		 */
		val throwableRechargeTime = ItemAttributeNamed<Float>("throwable recharge time")
		
		/**
		 * 
		 */
		val throwableDetonationTime = ItemAttributeNamed<Float>("throwable detonation time")
		
		/**
		 * 
		 *
		 * For timed explosions.
		 */
		val isThrowablePrimable = ItemAttributeNamed<Boolean>("is throwable primable")
		
		/**
		 * 
		 *
		 * For things like distance/power increases.
		 */
		val isThrowableChargeable = ItemAttributeNamed<Boolean>("is throwable chargeable")
	}

	/**
	 * 
	 */
	val throwableRechargeTime: ItemAttribute<Float> get() = ThrowableAttributes.throwableRechargeTime
	
	/**
	 * 
	 */
	val throwableDetonationTime: ItemAttribute<Float> get() = ThrowableAttributes.throwableDetonationTime
	
	/**
	 * 
	 *
	 * For timed explosions.
	 */
	val isThrowablePrimable: ItemAttribute<Boolean> get() = ThrowableAttributes.isThrowablePrimable
	
	/**
	 * 
	 *
	 * For things like distance/power increases.
	 */
	val isThrowableChargeable: ItemAttribute<Boolean> get() = ThrowableAttributes.isThrowableChargeable

   
}

