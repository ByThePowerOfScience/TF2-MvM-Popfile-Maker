package btpos.source.vdfdsl.tf2.itemattributes

import btpos.source.vdfdsl.modeling.*
import btpos.source.vdfdsl.serialization.codecs.*
import btpos.source.vdfdsl.tf2.itemattributes.impl.*
import btpos.source.vdfdsl.tf2.tftypes.*
import java.util.*



interface WearableDemoShieldAttributes : WearableAttributes {
	companion object {
		val demoCharge: DemoChargeAttributes = DemoChargeAttributes()
	
		val resistance: ResistanceAttributes = ResistanceAttributes()
	
		val meta: MetaAttributes = MetaAttributes()
	
		val disguise: DisguiseAttributes = DisguiseAttributes()
	
		val crits: CritsAttributes = CritsAttributes()
	
		val damage: DamageAttributes = DamageAttributes()
	
		val meter: MeterAttributes = MeterAttributes()
	
		val knockbackReceived: KnockbackReceivedAttributes = KnockbackReceivedAttributes()
	}

	val demoCharge: DemoChargeAttributes get() = WearableDemoShieldAttributes.demoCharge
	
	override val resistance: ResistanceAttributes get() = WearableDemoShieldAttributes.resistance
	
	override val meta: MetaAttributes get() = WearableDemoShieldAttributes.meta
	
	override val disguise: DisguiseAttributes get() = WearableDemoShieldAttributes.disguise
	
	override val crits: CritsAttributes get() = WearableDemoShieldAttributes.crits
	
	override val damage: DamageAttributes get() = WearableDemoShieldAttributes.damage
	
	override val meter: MeterAttributes get() = WearableDemoShieldAttributes.meter
	
	override val knockbackReceived: KnockbackReceivedAttributes get() = WearableDemoShieldAttributes.knockbackReceived

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
	
		override val killfeed: KillfeedAttributes = KillfeedAttributes()
	
		open class PlayerAttributes : WearableAttributes.MetaAttributes.PlayerAttributes() 
	
		open class ItemsAttributes : WearableAttributes.MetaAttributes.ItemsAttributes() 
	
		open class KillfeedAttributes : WearableAttributes.MetaAttributes.KillfeedAttributes() 
	}
	
	open class DisguiseAttributes : WearableAttributes.DisguiseAttributes() 
	
	open class CritsAttributes : WearableAttributes.CritsAttributes() 
	
	open class DamageAttributes : WearableAttributes.DamageAttributes() 
	
	open class MeterAttributes : WearableAttributes.MeterAttributes() 
	
	open class KnockbackReceivedAttributes : WearableAttributes.KnockbackReceivedAttributes() 
}