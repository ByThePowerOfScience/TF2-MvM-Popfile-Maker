package btpos.source.vdfdsl.tf2.itemattributes

import btpos.source.vdfdsl.modeling.*
import btpos.source.vdfdsl.serialization.codecs.*
import btpos.source.vdfdsl.tf2.itemattributes.impl.*
import btpos.source.vdfdsl.tf2.tftypes.*
import java.util.*



interface BuffItemAttributes : BaseMeleeAttributes {
	companion object {
		val buffItems: BuffItemsAttributes = BuffItemsAttributes()
	
		private val crits: CritsAttributes = CritsAttributes()
	
		private val damage: DamageAttributes = DamageAttributes()
	
		private val onHit: OnHitAttributes = OnHitAttributes()
	
		private val swapWeapons: SwapWeaponsAttributes = SwapWeaponsAttributes()
	}

	val buffItems: BuffItemsAttributes get() = BuffItemAttributes.buffItems
	
	override val crits: CritsAttributes get() = BuffItemAttributes.crits
	
	override val damage: DamageAttributes get() = BuffItemAttributes.damage
	
	override val onHit: OnHitAttributes get() = BuffItemAttributes.onHit
	
	override val swapWeapons: SwapWeaponsAttributes get() = BuffItemAttributes.swapWeapons

	open class BuffItemsAttributes : IBlockScoped {
		open val buffDuration: VisHidden<Float> = VisHidden(ItemAttributeNamed<Float>("increase buff duration"), ItemAttributeNamed<Float>("increase buff duration HIDDEN"))
	
		open val buffType: BuffTypeAttributes = BuffTypeAttributes()
	
		open class BuffTypeAttributes : IBlockScoped {
			/**
			 * Sets which banner is used.
			 * 
			 * 0 = Buff Banner.
			 * 
			 * 1 = Battalion's Backup.
			 * 
			 * 2 = Concheror.
			 */
			open val soldierBuffType: ItemAttributeNamed<Int> = ItemAttributeNamed("mod soldier buff type")
	
			/**
			 * Sets which banner is used.
			 * 
			 * 0 = Buff Banner.
			 * 
			 * 1 = Battalion's Backup.
			 * 
			 * 2 = Concheror.
			 */
			open val demoBuffType: ItemAttributeNamed<Int> = ItemAttributeNamed("mod demo buff type")
		}
	}
	
	open class CritsAttributes : BaseMeleeAttributes.CritsAttributes() 
	
	open class DamageAttributes : BaseMeleeAttributes.DamageAttributes() 
	
	open class OnHitAttributes : BaseMeleeAttributes.OnHitAttributes() 
	
	open class SwapWeaponsAttributes : BaseMeleeAttributes.SwapWeaponsAttributes() 
}