package btpos.source.vdfdsl.tf2.itemattributes

import btpos.source.vdfdsl.modeling.*
import btpos.source.vdfdsl.serialization.codecs.*
import btpos.source.vdfdsl.tf2.itemattributes.impl.*
import btpos.source.vdfdsl.tf2.tftypes.*
import java.util.*



interface WearableDemoShieldAttributes : WearableAttributes {
	companion object {
		val demoCharge: DemoChargeAttributes = DemoChargeAttributes()
	
		private val resistance: ResistanceAttributes = ResistanceAttributes()
	
		private val meta: MetaAttributes = MetaAttributes()
	}

	val demoCharge: DemoChargeAttributes get() = WearableDemoShieldAttributes.demoCharge
	
	override val resistance: ResistanceAttributes get() = WearableDemoShieldAttributes.resistance
	
	override val meta: MetaAttributes get() = WearableDemoShieldAttributes.meta

	open class DemoChargeAttributes : IBlockScoped {
		open val attackNotCancelCharge: ItemAttributeNamed<Boolean> = ItemAttributeNamed("Attack not cancel charge")
	
		open val chargeTime: VisHidden<Float> = VisHidden(ItemAttributeNamed<Float>("charge time increased"), ItemAttributeNamed<Float>("charge time decreased"))
	
		open val chargeImpactDamage: VisHidden<Float> = VisHidden(ItemAttributeNamed<Float>("charge impact damage increased"), ItemAttributeNamed<Float>("charge impact damage decreased"))
	}
	
	open class ResistanceAttributes : WearableAttributes.ResistanceAttributes() {
		/**
		 * In-Game: "Immune to the effects of afterburn."
		 */
		override val afterburnImmunity: ItemAttributeNamed<Boolean> get() = super.afterburnImmunity
	}
	
	open class MetaAttributes : WearableAttributes.MetaAttributes() {
		override val player: PlayerAttributes = PlayerAttributes()
	
		override val items: ItemsAttributes = ItemsAttributes()
	
		open class PlayerAttributes : WearableAttributes.MetaAttributes.PlayerAttributes() 
	
		open class ItemsAttributes : WearableAttributes.MetaAttributes.ItemsAttributes() 
	}
}