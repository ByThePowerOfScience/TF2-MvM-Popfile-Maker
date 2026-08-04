package btpos.source.vdfdsl.tf2.itemattributes

import btpos.source.vdfdsl.tf2.itemattributes.impl.*

interface WearableAttributes : IBlockScoped, EconEntityAttributes {
	companion object : IBlockScoped {
		val resistance: ResistanceAttributes = ResistanceAttributes()
	
		val meta: MetaAttributes = MetaAttributes()
	
		private val disguise: DisguiseAttributes = DisguiseAttributes()
	
		private val crits: CritsAttributes = CritsAttributes()
	
		private val damage: DamageAttributes = DamageAttributes()
	
		private val meter: MeterAttributes = MeterAttributes()
	
		private val knockbackReceived: KnockbackReceivedAttributes = KnockbackReceivedAttributes()
	}

	override val resistance: ResistanceAttributes get() = WearableAttributes.resistance
	
	override val meta: MetaAttributes get() = WearableAttributes.meta
	
	override val disguise: DisguiseAttributes get() = WearableAttributes.disguise
	
	override val crits: CritsAttributes get() = WearableAttributes.crits
	
	override val damage: DamageAttributes get() = WearableAttributes.damage
	
	override val meter: MeterAttributes get() = WearableAttributes.meter
	
	override val knockbackReceived: KnockbackReceivedAttributes get() = WearableAttributes.knockbackReceived

	open class ResistanceAttributes : EconEntityAttributes.ResistanceAttributes() {
		/**
		 * In-Game: "Immune to the effects of afterburn."
		 * 
		 * For the base "`Wearable`", only checked on Sniper.
		 */
		open val afterburnImmunity: ItemAttributeNamed<Boolean> = ItemAttributeNamed("afterburn immunity")
	}
	
	open class MetaAttributes : EconEntityAttributes.MetaAttributes() {
		open val player: PlayerAttributes = PlayerAttributes()
	
		override val items: ItemsAttributes = ItemsAttributes()
	
		override val particles: ParticlesAttributes = ParticlesAttributes()
	
		override val killfeed: KillfeedAttributes = KillfeedAttributes()
	
		open class PlayerAttributes : IBlockScoped {
			/**
			 * Overrides the skin used for the player. (e.g. Zombie).
			 */
			open val playerSkinOverride: ItemAttributeNamed<Int> = ItemAttributeNamed("player skin override")
		}
	
		open class ItemsAttributes : EconEntityAttributes.MetaAttributes.ItemsAttributes() {
			/**
			 * In-Game: "Duck Power : N / 5"
			 * 
			 * Determines if ***BONUS DUCKSSSS*** should increment the badge level.
			 */
			open val duckBadgeLevel: ItemAttributeNamed<Int> = ItemAttributeNamed("duck badge level")
		}
	
		open class ParticlesAttributes : EconEntityAttributes.MetaAttributes.ParticlesAttributes() 
	
		open class KillfeedAttributes : EconEntityAttributes.MetaAttributes.KillfeedAttributes() 
	}
	
	open class DisguiseAttributes : EconEntityAttributes.DisguiseAttributes() 
	
	open class CritsAttributes : EconEntityAttributes.CritsAttributes() 
	
	open class DamageAttributes : EconEntityAttributes.DamageAttributes() 
	
	open class MeterAttributes : EconEntityAttributes.MeterAttributes() 
	
	open class KnockbackReceivedAttributes : EconEntityAttributes.KnockbackReceivedAttributes() 
}