package btpos.source.vdfdsl.tf2.itemattributes

import btpos.source.vdfdsl.modeling.*
import btpos.source.vdfdsl.serialization.codecs.*
import btpos.source.vdfdsl.tf2.itemattributes.impl.*
import btpos.source.vdfdsl.tf2.tftypes.*
import java.util.*



interface WearableAttributes : BaseEntityAttributes {
	companion object {
		val disguise: DisguiseAttributes = DisguiseAttributes()
	
		val crits: CritsAttributes = CritsAttributes()
	
		val damage: DamageAttributes = DamageAttributes()
	
		val meta: MetaAttributes = MetaAttributes()
	
		val meter: MeterAttributes = MeterAttributes()
	
		val knockbackReceived: KnockbackReceivedAttributes = KnockbackReceivedAttributes()
	
		val resistance: ResistanceAttributes = ResistanceAttributes()
	}

	override val resistance: ResistanceAttributes get() = WearableAttributes.resistance
	
	override val meta: MetaAttributes get() = WearableAttributes.meta
	
	override val disguise: DisguiseAttributes get() = WearableAttributes.disguise
	
	override val crits: CritsAttributes get() = WearableAttributes.crits
	
	override val damage: DamageAttributes get() = WearableAttributes.damage
	
	override val meter: MeterAttributes get() = WearableAttributes.meter
	
	override val knockbackReceived: KnockbackReceivedAttributes get() = WearableAttributes.knockbackReceived

	open class ResistanceAttributes : BaseEntityAttributes.ResistanceAttributes() {
		/**
		 * In-Game: "Immune to the effects of afterburn."
		 * 
		 * For the base "`Wearable`", only checked on Sniper.
		 */
		open val afterburnImmunity: ItemAttributeNamed<Boolean> = ItemAttributeNamed("afterburn immunity")
	}
	
	open class MetaAttributes : BaseEntityAttributes.MetaAttributes() {
		open val player: PlayerAttributes = PlayerAttributes()
	
		open val items: ItemsAttributes = ItemsAttributes()
	
		override val killfeed: KillfeedAttributes = KillfeedAttributes()
	
		open class PlayerAttributes : IBlockScoped {
			/**
			 * Overrides the skin used for the player. (e.g. Zombie).
			 */
			open val playerSkinOverride: ItemAttributeNamed<Int> = ItemAttributeNamed("player skin override")
		}
	
		open class ItemsAttributes : IBlockScoped {
			/**
			 * In-Game: "Duck Power : N / 5"
			 * 
			 * Determines if ***BONUS DUCKSSSS*** should increment the badge level.
			 */
			open val duckBadgeLevel: ItemAttributeNamed<Int> = ItemAttributeNamed("duck badge level")
		}
	
		open class KillfeedAttributes : BaseEntityAttributes.MetaAttributes.KillfeedAttributes() 
	}
	
	open class DisguiseAttributes : BaseEntityAttributes.DisguiseAttributes() 
	
	open class CritsAttributes : BaseEntityAttributes.CritsAttributes() 
	
	open class DamageAttributes : BaseEntityAttributes.DamageAttributes() 
	
	open class MeterAttributes : BaseEntityAttributes.MeterAttributes() 
	
	open class KnockbackReceivedAttributes : BaseEntityAttributes.KnockbackReceivedAttributes() 
}