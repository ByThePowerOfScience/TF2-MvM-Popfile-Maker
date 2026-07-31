package btpos.source.vdfdsl.tf2.itemattributes

import btpos.source.vdfdsl.modeling.*
import btpos.source.vdfdsl.serialization.codecs.*
import btpos.source.vdfdsl.tf2.itemattributes.impl.*
import btpos.source.vdfdsl.tf2.tftypes.*
import java.util.*
import kotlin.time.Duration



interface EconEntityAttributes : BaseEntityAttributes {
	companion object : IBlockScoped {
		val disguise: DisguiseAttributes = DisguiseAttributes()
	
		val crits: CritsAttributes = CritsAttributes()
	
		val damage: DamageAttributes = DamageAttributes()
	
		val meta: MetaAttributes = MetaAttributes()
	
		val meter: MeterAttributes = MeterAttributes()
	
		val knockbackReceived: KnockbackReceivedAttributes = KnockbackReceivedAttributes()
	
		val resistance: ResistanceAttributes = ResistanceAttributes()
	}

	override val meta: MetaAttributes get() = EconEntityAttributes.meta
	
	override val disguise: DisguiseAttributes get() = EconEntityAttributes.disguise
	
	override val crits: CritsAttributes get() = EconEntityAttributes.crits
	
	override val damage: DamageAttributes get() = EconEntityAttributes.damage
	
	override val meter: MeterAttributes get() = EconEntityAttributes.meter
	
	override val knockbackReceived: KnockbackReceivedAttributes get() = EconEntityAttributes.knockbackReceived
	
	override val resistance: ResistanceAttributes get() = EconEntityAttributes.resistance

	open class MetaAttributes : BaseEntityAttributes.MetaAttributes() {
		open val items: ItemsAttributes = ItemsAttributes()
	
		open val particles: ParticlesAttributes = ParticlesAttributes()
	
		override val killfeed: KillfeedAttributes = KillfeedAttributes()
	
		open class ItemsAttributes : IBlockScoped {
			/**
			 * In-Game: "Festivized"
			 * 
			 * Attaches festivizer.
			 */
			open val isFestivized: ItemAttributeNamed<Boolean> = ItemAttributeNamed("is_festivized")
		}
	
		open class ParticlesAttributes : IBlockScoped {
			/**
			 * Attaches static particle, such as smoking a pipe.
			 * 
			 * Cosmetics can only have one.
			 */
			open val attachParticleEffectStatic: ItemAttributeNamed<Int> = ItemAttributeNamed("attach particle effect static")
	
			/**
			 * In-Game: "★ Unusual Effect: N"
			 * 
			 * Dynamic particle systems, such as unusuals.
			 */
			open val attachParticleEffect: ItemAttributeNamed<Int> = ItemAttributeNamed("attach particle effect")
	
			/**
			 * If false, attaches the `set_attached_particle` to the item itself.
			 * 
			 * If true, the particle only applies to the throwable particle trail.
			 */
			open val throwableParticleTrailOnly: ItemAttributeNamed<Boolean> = ItemAttributeNamed("throwable particle trail only")
		}
	
		open class KillfeedAttributes : BaseEntityAttributes.MetaAttributes.KillfeedAttributes() 
	}
	
	open class DisguiseAttributes : BaseEntityAttributes.DisguiseAttributes() 
	
	open class CritsAttributes : BaseEntityAttributes.CritsAttributes() 
	
	open class DamageAttributes : BaseEntityAttributes.DamageAttributes() 
	
	open class MeterAttributes : BaseEntityAttributes.MeterAttributes() 
	
	open class KnockbackReceivedAttributes : BaseEntityAttributes.KnockbackReceivedAttributes() 
	
	open class ResistanceAttributes : BaseEntityAttributes.ResistanceAttributes() 
}