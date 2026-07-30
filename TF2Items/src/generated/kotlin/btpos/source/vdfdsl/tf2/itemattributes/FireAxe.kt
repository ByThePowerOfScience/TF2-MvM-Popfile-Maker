package btpos.source.vdfdsl.tf2.itemattributes

import btpos.source.vdfdsl.modeling.*
import btpos.source.vdfdsl.serialization.codecs.*
import btpos.source.vdfdsl.tf2.itemattributes.impl.*
import btpos.source.vdfdsl.tf2.tftypes.*
import java.util.*



interface FireAxeAttributes : BaseMeleeAttributes {
	companion object {
		/**
		 * In-Game: "On Hit: target is engulfed in flames"
		 * 
		 * Ignite enemies on hit.
		 */
		val setDamagetypeIgnite: ItemAttributeNamed<Boolean> = ItemAttributeNamed("Set DamageType Ignite")
	
		private val crits: CritsAttributes = CritsAttributes()
	
		private val damage: DamageAttributes = DamageAttributes()
	
		private val onHit: OnHitAttributes = OnHitAttributes()
	
		private val swapWeapons: SwapWeaponsAttributes = SwapWeaponsAttributes()
	}

	/**
	 * In-Game: "On Hit: target is engulfed in flames"
	 * 
	 * Ignite enemies on hit.
	 */
	val setDamagetypeIgnite: ItemAttributeNamed<Boolean> get() = FireAxeAttributes.setDamagetypeIgnite
	
	override val crits: CritsAttributes get() = FireAxeAttributes.crits
	
	override val damage: DamageAttributes get() = FireAxeAttributes.damage
	
	override val onHit: OnHitAttributes get() = FireAxeAttributes.onHit
	
	override val swapWeapons: SwapWeaponsAttributes get() = FireAxeAttributes.swapWeapons

	open class CritsAttributes : BaseMeleeAttributes.CritsAttributes() 
	
	open class DamageAttributes : BaseMeleeAttributes.DamageAttributes() 
	
	open class OnHitAttributes : BaseMeleeAttributes.OnHitAttributes() 
	
	open class SwapWeaponsAttributes : BaseMeleeAttributes.SwapWeaponsAttributes() 
}