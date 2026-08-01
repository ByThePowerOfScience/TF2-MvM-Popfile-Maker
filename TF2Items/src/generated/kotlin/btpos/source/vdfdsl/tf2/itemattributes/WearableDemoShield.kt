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
	
		private val resistance: ResistanceAttributes = ResistanceAttributes()
	
		private val meta: MetaAttributes = MetaAttributes()
	
		private val disguise: DisguiseAttributes = DisguiseAttributes()
	
		private val crits: CritsAttributes = CritsAttributes()
	
		private val damage: DamageAttributes = DamageAttributes()
	
		private val meter: MeterAttributes = MeterAttributes()
	
		private val knockbackReceived: KnockbackReceivedAttributes = KnockbackReceivedAttributes()
	
		val attackNotCancelCharge: ItemAttributeNamed<Boolean> = ItemAttributeNamed("Attack not cancel charge")
	
		val chargeTime: VisHidden<Number> = VisHidden(ItemAttributeNamed<Number>("charge time increased"), ItemAttributeNamed<Number>("charge time decreased"))
	
		val chargeImpactDamage: VisHidden<Number> = VisHidden(ItemAttributeNamed<Number>("charge impact damage increased"), ItemAttributeNamed<Number>("charge impact damage decreased"))
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
		companion object : IBlockScoped 
	
		context(attrs: IAttributeContainer)
		open var attackNotCancelCharge: Boolean? 
			get() = WearableDemoShieldAttributes.attackNotCancelCharge.get()
			set(value) { WearableDemoShieldAttributes.attackNotCancelCharge.set(value) }
	
		context(attrs: IAttributeContainer)
		open var chargeTime: Number? 
			get() = WearableDemoShieldAttributes.chargeTime.get()
			set(value) { WearableDemoShieldAttributes.chargeTime.set(value) }
	
		context(attrs: IAttributeContainer)
		open var chargeImpactDamage: Number? 
			get() = WearableDemoShieldAttributes.chargeImpactDamage.get()
			set(value) { WearableDemoShieldAttributes.chargeImpactDamage.set(value) }
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