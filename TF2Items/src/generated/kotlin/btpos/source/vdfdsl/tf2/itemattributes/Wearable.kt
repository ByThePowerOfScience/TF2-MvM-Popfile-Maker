package btpos.source.vdfdsl.tf2.itemattributes

import btpos.source.vdfdsl.modeling.*
import btpos.source.vdfdsl.serialization.codecs.*
import btpos.source.vdfdsl.tf2.itemattributes.impl.*
import btpos.source.vdfdsl.tf2.tftypes.*
import java.util.*
import kotlin.time.Duration

interface WearableAttributes : EconEntityAttributes {
	companion object : IBlockScoped {
		private val meta: MetaAttributes = MetaAttributes()
	
		private val disguise: DisguiseAttributes = DisguiseAttributes()
	
		private val crits: CritsAttributes = CritsAttributes()
	
		private val damage: DamageAttributes = DamageAttributes()
	
		private val meter: MeterAttributes = MeterAttributes()
	
		private val knockbackReceived: KnockbackReceivedAttributes = KnockbackReceivedAttributes()
	
		private val resistance: ResistanceAttributes = ResistanceAttributes()
	
		/**
		 * In-Game: "Immune to the effects of afterburn."
		 * 
		 * For the base "`Wearable`", only checked on Sniper.
		 */
		val afterburnImmunity: ItemAttributeNamed<Boolean> = ItemAttributeNamed("afterburn immunity")
	
		/**
		 * Overrides the skin used for the player. (e.g. Zombie).
		 */
		val playerSkinOverride: ItemAttributeNamed<Int> = ItemAttributeNamed("player skin override")
	
		/**
		 * In-Game: "Duck Power : N / 5"
		 * 
		 * Determines if ***BONUS DUCKSSSS*** should increment the badge level.
		 */
		val duckBadgeLevel: ItemAttributeNamed<Int> = ItemAttributeNamed("duck badge level")
	}

	override val resistance: ResistanceAttributes get() = WearableAttributes.resistance
	
	override val meta: MetaAttributes get() = WearableAttributes.meta
	
	override val disguise: DisguiseAttributes get() = WearableAttributes.disguise
	
	override val crits: CritsAttributes get() = WearableAttributes.crits
	
	override val damage: DamageAttributes get() = WearableAttributes.damage
	
	override val meter: MeterAttributes get() = WearableAttributes.meter
	
	override val knockbackReceived: KnockbackReceivedAttributes get() = WearableAttributes.knockbackReceived

	open class ResistanceAttributes : EconEntityAttributes.ResistanceAttributes() {
		companion object : IBlockScoped 
	
		/**
		 * In-Game: "Immune to the effects of afterburn."
		 * 
		 * For the base "`Wearable`", only checked on Sniper.
		 */
		context(attrs: IAttributeContainer)
		open var afterburnImmunity: Boolean? 
			get() = WearableAttributes.afterburnImmunity.get()
			set(value) { WearableAttributes.afterburnImmunity.set(value) }
	}
	
	open class MetaAttributes : EconEntityAttributes.MetaAttributes() {
		companion object : IBlockScoped {
			val player: PlayerAttributes = PlayerAttributes()
		}
	
		open val player: PlayerAttributes = PlayerAttributes()
	
		override val items: ItemsAttributes = ItemsAttributes()
	
		override val particles: ParticlesAttributes = ParticlesAttributes()
	
		override val killfeed: KillfeedAttributes = KillfeedAttributes()
	
		open class PlayerAttributes : IBlockScoped {
			companion object : IBlockScoped 
	
			/**
			 * Overrides the skin used for the player. (e.g. Zombie).
			 */
			context(attrs: IAttributeContainer)
			open var playerSkinOverride: Int? 
				get() = WearableAttributes.playerSkinOverride.get()
				set(value) { WearableAttributes.playerSkinOverride.set(value) }
		}
	
		open class ItemsAttributes : EconEntityAttributes.MetaAttributes.ItemsAttributes() {
			companion object : IBlockScoped 
	
			/**
			 * In-Game: "Duck Power : N / 5"
			 * 
			 * Determines if ***BONUS DUCKSSSS*** should increment the badge level.
			 */
			context(attrs: IAttributeContainer)
			open var duckBadgeLevel: Int? 
				get() = WearableAttributes.duckBadgeLevel.get()
				set(value) { WearableAttributes.duckBadgeLevel.set(value) }
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