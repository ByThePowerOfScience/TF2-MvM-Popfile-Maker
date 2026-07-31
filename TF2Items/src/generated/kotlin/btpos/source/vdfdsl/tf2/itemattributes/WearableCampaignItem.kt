package btpos.source.vdfdsl.tf2.itemattributes

import btpos.source.vdfdsl.modeling.*
import btpos.source.vdfdsl.serialization.codecs.*
import btpos.source.vdfdsl.tf2.itemattributes.impl.*
import btpos.source.vdfdsl.tf2.tftypes.*
import java.util.*
import kotlin.time.Duration

interface WearableCampaignItemAttributes : WearableAttributes {
	companion object : IBlockScoped {
		val resistance: ResistanceAttributes = ResistanceAttributes()
	
		val meta: MetaAttributes = MetaAttributes()
	
		val disguise: DisguiseAttributes = DisguiseAttributes()
	
		val crits: CritsAttributes = CritsAttributes()
	
		val damage: DamageAttributes = DamageAttributes()
	
		val meter: MeterAttributes = MeterAttributes()
	
		val knockbackReceived: KnockbackReceivedAttributes = KnockbackReceivedAttributes()
	}

	override val resistance: ResistanceAttributes get() = WearableCampaignItemAttributes.resistance
	
	override val meta: MetaAttributes get() = WearableCampaignItemAttributes.meta
	
	override val disguise: DisguiseAttributes get() = WearableCampaignItemAttributes.disguise
	
	override val crits: CritsAttributes get() = WearableCampaignItemAttributes.crits
	
	override val damage: DamageAttributes get() = WearableCampaignItemAttributes.damage
	
	override val meter: MeterAttributes get() = WearableCampaignItemAttributes.meter
	
	override val knockbackReceived: KnockbackReceivedAttributes get() = WearableCampaignItemAttributes.knockbackReceived

	open class ResistanceAttributes : WearableAttributes.ResistanceAttributes() 
	
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