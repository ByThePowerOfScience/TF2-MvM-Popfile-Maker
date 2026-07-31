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
		companion object : IBlockScoped {
			val items: ItemsAttributes = ItemsAttributes()
	
			val particles: ParticlesAttributes = ParticlesAttributes()
		}
	
		open val items: ItemsAttributes = ItemsAttributes()
	
		open val particles: ParticlesAttributes = ParticlesAttributes()
	
		override val killfeed: KillfeedAttributes = KillfeedAttributes()
	
		open class ItemsAttributes : IBlockScoped {
			companion object : IBlockScoped {
				/**
				 * In-Game: "Festivized"
				 * 
				 * Attaches festivizer.
				 */
				val isFestivized: ItemAttributeNamed<Boolean> = ItemAttributeNamed("is_festivized")
			}
	
			/**
			 * In-Game: "Festivized"
			 * 
			 * Attaches festivizer.
			 */
			context(attrs: IAttributeContainer)
			open var isFestivized: Boolean? 
				get() = ItemsAttributes.isFestivized.get()
				set(value) { ItemsAttributes.isFestivized.set(value) }
		}
	
		open class ParticlesAttributes : IBlockScoped {
			companion object : IBlockScoped {
				/**
				 * Attaches static particle, such as smoking a pipe.
				 * 
				 * Cosmetics can only have one.
				 */
				val attachParticleEffectStatic: ItemAttributeNamed<Int> = ItemAttributeNamed("attach particle effect static")
	
				/**
				 * In-Game: "★ Unusual Effect: N"
				 * 
				 * Dynamic particle systems, such as unusuals.
				 */
				val attachParticleEffect: ItemAttributeNamed<Int> = ItemAttributeNamed("attach particle effect")
	
				/**
				 * If false, attaches the `set_attached_particle` to the item itself.
				 * 
				 * If true, the particle only applies to the throwable particle trail.
				 */
				val throwableParticleTrailOnly: ItemAttributeNamed<Boolean> = ItemAttributeNamed("throwable particle trail only")
			}
	
			/**
			 * Attaches static particle, such as smoking a pipe.
			 * 
			 * Cosmetics can only have one.
			 */
			context(attrs: IAttributeContainer)
			open var attachParticleEffectStatic: Int? 
				get() = ParticlesAttributes.attachParticleEffectStatic.get()
				set(value) { ParticlesAttributes.attachParticleEffectStatic.set(value) }
	
			/**
			 * In-Game: "★ Unusual Effect: N"
			 * 
			 * Dynamic particle systems, such as unusuals.
			 */
			context(attrs: IAttributeContainer)
			open var attachParticleEffect: Int? 
				get() = ParticlesAttributes.attachParticleEffect.get()
				set(value) { ParticlesAttributes.attachParticleEffect.set(value) }
	
			/**
			 * If false, attaches the `set_attached_particle` to the item itself.
			 * 
			 * If true, the particle only applies to the throwable particle trail.
			 */
			context(attrs: IAttributeContainer)
			open var throwableParticleTrailOnly: Boolean? 
				get() = ParticlesAttributes.throwableParticleTrailOnly.get()
				set(value) { ParticlesAttributes.throwableParticleTrailOnly.set(value) }
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