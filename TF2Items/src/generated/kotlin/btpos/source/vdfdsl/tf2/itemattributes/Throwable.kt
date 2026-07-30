package btpos.source.vdfdsl.tf2.itemattributes

import btpos.source.vdfdsl.modeling.*
import btpos.source.vdfdsl.serialization.codecs.*
import btpos.source.vdfdsl.tf2.itemattributes.impl.*
import btpos.source.vdfdsl.tf2.tftypes.*
import java.util.*



interface ThrowableAttributes : JarAttributes {
	companion object {
		val throwableRechargeTime: ItemAttributeNamed<Float> = ItemAttributeNamed("throwable recharge time")
	
		val throwableDetonationTime: ItemAttributeNamed<Float> = ItemAttributeNamed("throwable detonation time")
	
		/**
		 * For timed explosions.
		 */
		val isThrowablePrimable: ItemAttributeNamed<Boolean> = ItemAttributeNamed("is throwable primable")
	
		/**
		 * For things like distance/power increases.
		 */
		val isThrowableChargeable: ItemAttributeNamed<Boolean> = ItemAttributeNamed("is throwable chargeable")
	
		private val projectiles: ProjectilesAttributes = ProjectilesAttributes()
	
		private val meter: MeterAttributes = MeterAttributes()
	
		private val onHit: OnHitAttributes = OnHitAttributes()
	}

	val throwableRechargeTime: ItemAttributeNamed<Float> get() = ThrowableAttributes.throwableRechargeTime
	
	val throwableDetonationTime: ItemAttributeNamed<Float> get() = ThrowableAttributes.throwableDetonationTime
	
	/**
	 * For timed explosions.
	 */
	val isThrowablePrimable: ItemAttributeNamed<Boolean> get() = ThrowableAttributes.isThrowablePrimable
	
	/**
	 * For things like distance/power increases.
	 */
	val isThrowableChargeable: ItemAttributeNamed<Boolean> get() = ThrowableAttributes.isThrowableChargeable
	
	override val projectiles: ProjectilesAttributes get() = ThrowableAttributes.projectiles
	
	override val meter: MeterAttributes get() = ThrowableAttributes.meter
	
	override val onHit: OnHitAttributes get() = ThrowableAttributes.onHit

	open class ProjectilesAttributes : JarAttributes.ProjectilesAttributes() 
	
	open class MeterAttributes : JarAttributes.MeterAttributes() 
	
	open class OnHitAttributes : JarAttributes.OnHitAttributes() 
}