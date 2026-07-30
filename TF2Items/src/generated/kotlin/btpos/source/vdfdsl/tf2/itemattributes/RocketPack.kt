package btpos.source.vdfdsl.tf2.itemattributes

import btpos.source.vdfdsl.modeling.*
import btpos.source.vdfdsl.serialization.codecs.*
import btpos.source.vdfdsl.tf2.itemattributes.impl.*
import btpos.source.vdfdsl.tf2.tftypes.*
import java.util.*



interface RocketPackAttributes : BaseMeleeAttributes {
	companion object {
		/**
		 * In-Game: "Able to re-launch while already in-flight"
		 * 
		 * The MvM upgrade that lets you repeatedly launch without a cooldown.
		 */
		val thermalThrusterAirLaunch: ItemAttributeNamed<Boolean> = ItemAttributeNamed("thermal_thruster_air_launch")
	
		private val crits: CritsAttributes = CritsAttributes()
	
		private val damage: DamageAttributes = DamageAttributes()
	
		private val onHit: OnHitAttributes = OnHitAttributes()
	
		private val swapWeapons: SwapWeaponsAttributes = SwapWeaponsAttributes()
	}

	/**
	 * In-Game: "Able to re-launch while already in-flight"
	 * 
	 * The MvM upgrade that lets you repeatedly launch without a cooldown.
	 */
	val thermalThrusterAirLaunch: ItemAttributeNamed<Boolean> get() = RocketPackAttributes.thermalThrusterAirLaunch
	
	override val crits: CritsAttributes get() = RocketPackAttributes.crits
	
	override val damage: DamageAttributes get() = RocketPackAttributes.damage
	
	override val onHit: OnHitAttributes get() = RocketPackAttributes.onHit
	
	override val swapWeapons: SwapWeaponsAttributes get() = RocketPackAttributes.swapWeapons

	open class CritsAttributes : BaseMeleeAttributes.CritsAttributes() 
	
	open class DamageAttributes : BaseMeleeAttributes.DamageAttributes() 
	
	open class OnHitAttributes : BaseMeleeAttributes.OnHitAttributes() 
	
	open class SwapWeaponsAttributes : BaseMeleeAttributes.SwapWeaponsAttributes() 
}