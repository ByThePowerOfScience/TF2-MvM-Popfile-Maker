package btpos.source.vdfdsl.tf2.itemattributes

import btpos.source.vdfdsl.modeling.*
import btpos.source.vdfdsl.serialization.codecs.*
import btpos.source.vdfdsl.tf2.itemattributes.impl.*
import btpos.source.vdfdsl.tf2.tftypes.*
import java.util.*



interface FistsAttributes : BaseMeleeAttributes {
	companion object {
		/**
		 * Note that despite being present in the item schema, this is explicitly COMMENTED OUT of the code, and has no gameplay effects at least.
		 */
		val breadglovesProperties: ItemAttributeNamed<Boolean> = ItemAttributeNamed("breadgloves properties")
	
		private val crits: CritsAttributes = CritsAttributes()
	
		private val damage: DamageAttributes = DamageAttributes()
	
		private val onHit: OnHitAttributes = OnHitAttributes()
	
		private val swapWeapons: SwapWeaponsAttributes = SwapWeaponsAttributes()
	}

	/**
	 * Note that despite being present in the item schema, this is explicitly COMMENTED OUT of the code, and has no gameplay effects at least.
	 */
	val breadglovesProperties: ItemAttributeNamed<Boolean> get() = FistsAttributes.breadglovesProperties
	
	override val crits: CritsAttributes get() = FistsAttributes.crits
	
	override val damage: DamageAttributes get() = FistsAttributes.damage
	
	override val onHit: OnHitAttributes get() = FistsAttributes.onHit
	
	override val swapWeapons: SwapWeaponsAttributes get() = FistsAttributes.swapWeapons

	open class CritsAttributes : BaseMeleeAttributes.CritsAttributes() 
	
	open class DamageAttributes : BaseMeleeAttributes.DamageAttributes() 
	
	open class OnHitAttributes : BaseMeleeAttributes.OnHitAttributes() 
	
	open class SwapWeaponsAttributes : BaseMeleeAttributes.SwapWeaponsAttributes() 
}