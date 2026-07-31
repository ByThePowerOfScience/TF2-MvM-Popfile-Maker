package btpos.source.vdfdsl.tf2.itemattributes

import btpos.source.vdfdsl.modeling.*
import btpos.source.vdfdsl.serialization.codecs.*
import btpos.source.vdfdsl.tf2.itemattributes.impl.*
import btpos.source.vdfdsl.tf2.tftypes.*
import java.util.*
import kotlin.time.Duration

interface WearableDemoShieldAttributes : WearableAttributes {
	companion object : IBlockScoped {
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
		companion object : IBlockScoped {
			val attackNotCancelCharge: ItemAttributeNamed<Boolean> = ItemAttributeNamed("Attack not cancel charge")
	
			val chargeTime: VisHidden<Number> = VisHidden(ItemAttributeNamed<Number>("charge time increased"), ItemAttributeNamed<Number>("charge time decreased"))
	
			val chargeImpactDamage: VisHidden<Number> = VisHidden(ItemAttributeNamed<Number>("charge impact damage increased"), ItemAttributeNamed<Number>("charge impact damage decreased"))
		}
	
		context(attrs: IAttributeContainer)
		open var attackNotCancelCharge: Boolean? 
			get() = DemoChargeAttributes.attackNotCancelCharge.get()
			set(value) { DemoChargeAttributes.attackNotCancelCharge.set(value) }
	
		context(attrs: IAttributeContainer)
		open var chargeTime: Number? 
			get() = DemoChargeAttributes.chargeTime.get()
			set(value) { DemoChargeAttributes.chargeTime.set(value) }
	
		context(attrs: IAttributeContainer)
		open var chargeImpactDamage: Number? 
			get() = DemoChargeAttributes.chargeImpactDamage.get()
			set(value) { DemoChargeAttributes.chargeImpactDamage.set(value) }
	}
	
	open class ResistanceAttributes : WearableAttributes.ResistanceAttributes() {
		companion object : IBlockScoped 
	
		/**
		 * In-Game: "Immune to the effects of afterburn."
		 */
		context(attrs: IAttributeContainer)
		override var afterburnImmunity: Boolean? 
			get() = super.afterburnImmunity
			set(value) { super.afterburnImmunity = value }
	}
	
	open class MetaAttributes : WearableAttributes.MetaAttributes() {
		override val player: PlayerAttributes = PlayerAttributes()
	
		override val items: ItemsAttributes = ItemsAttributes()
	
		override val particles: ParticlesAttributes = ParticlesAttributes()
	
		override val killfeed: KillfeedAttributes = KillfeedAttributes()
	
		open class PlayerAttributes : WearableAttributes.MetaAttributes.PlayerAttributes() 
	
		open class ItemsAttributes : WearableAttributes.MetaAttributes.ItemsAttributes() 
	
		open class ParticlesAttributes : WearableAttributes.MetaAttributes.ParticlesAttributes() 
	
		open class KillfeedAttributes : WearableAttributes.MetaAttributes.KillfeedAttributes() 
	}
	
	open class DisguiseAttributes : WearableAttributes.DisguiseAttributes() 
	
	open class CritsAttributes : WearableAttributes.CritsAttributes() 
	
	open class DamageAttributes : WearableAttributes.DamageAttributes() 
	
	open class MeterAttributes : WearableAttributes.MeterAttributes() 
	
	open class KnockbackReceivedAttributes : WearableAttributes.KnockbackReceivedAttributes() 
}