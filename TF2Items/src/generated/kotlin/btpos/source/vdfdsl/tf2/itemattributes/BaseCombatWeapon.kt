package btpos.source.vdfdsl.tf2.itemattributes

import btpos.source.vdfdsl.modeling.*
import btpos.source.vdfdsl.serialization.codecs.*
import btpos.source.vdfdsl.tf2.itemattributes.impl.*
import btpos.source.vdfdsl.tf2.tftypes.*
import java.util.*
import kotlin.time.Duration

interface BaseCombatWeaponAttributes : EconEntityAttributes {
	companion object : IBlockScoped {
		val ammo: AmmoAttributes = AmmoAttributes()
	
		private val meta: MetaAttributes = MetaAttributes()
	
		private val disguise: DisguiseAttributes = DisguiseAttributes()
	
		private val crits: CritsAttributes = CritsAttributes()
	
		private val damage: DamageAttributes = DamageAttributes()
	
		private val meter: MeterAttributes = MeterAttributes()
	
		private val knockbackReceived: KnockbackReceivedAttributes = KnockbackReceivedAttributes()
	
		private val resistance: ResistanceAttributes = ResistanceAttributes()
	
		/**
		 * In-Game: "Uses metal for ammo"
		 * 
		 * Reminder: non-engies start with 100 metal.
		 */
		val useMetalAmmoType: ItemAttributeNamed<Boolean> = ItemAttributeNamed("mod use metal ammo type")
	
		/**
		 * In-Game: "No reload necessary"
		 * 
		 * In the "DoesReloadSingly" check, this _is_ actually checked, so it's actually _not_ "display-only".
		 * 
		 * If != 1.0 (if present), says the weapon "does not reload one shot at a time".
		 */
		val noReload_displayOnly: ItemAttributeNamed<Number> = ItemAttributeNamed("mod no reload DISPLAY ONLY")
	
		/**
		 * Checked in `DoesReloadSingly`. If true, weapon does not reload one shot at a time. (e.g. FaN).
		 * 
		 * Note that for the most part, this logic is set inside the weapon itself. The scattergun attribute is the only way to control this with attributes.
		 */
		val scattergunNoReloadSingle: ItemAttributeNamed<Boolean> = ItemAttributeNamed("scattergun no reload single")
	
		/**
		 * Overwrites the max clipsize to a flat value. Applied before other multipliers.
		 */
		val maxPrimaryClipOverride: ItemAttributeNamed<Int> = ItemAttributeNamed("mod max primary clip override")
	}

	val ammo: AmmoAttributes get() = BaseCombatWeaponAttributes.ammo
	
	override val meta: MetaAttributes get() = BaseCombatWeaponAttributes.meta
	
	override val disguise: DisguiseAttributes get() = BaseCombatWeaponAttributes.disguise
	
	override val crits: CritsAttributes get() = BaseCombatWeaponAttributes.crits
	
	override val damage: DamageAttributes get() = BaseCombatWeaponAttributes.damage
	
	override val meter: MeterAttributes get() = BaseCombatWeaponAttributes.meter
	
	override val knockbackReceived: KnockbackReceivedAttributes get() = BaseCombatWeaponAttributes.knockbackReceived
	
	override val resistance: ResistanceAttributes get() = BaseCombatWeaponAttributes.resistance

	open class AmmoAttributes : IBlockScoped {
		companion object : IBlockScoped {
			val clipSize: ClipSizeAttributes = ClipSizeAttributes()
		}
	
		/**
		 * In-Game: "Uses metal for ammo"
		 * 
		 * Reminder: non-engies start with 100 metal.
		 */
		context(attrs: IAttributeContainer)
		open var useMetalAmmoType: Boolean? 
			get() = BaseCombatWeaponAttributes.useMetalAmmoType.get()
			set(value) { BaseCombatWeaponAttributes.useMetalAmmoType.set(value) }
	
		/**
		 * In-Game: "No reload necessary"
		 * 
		 * In the "DoesReloadSingly" check, this _is_ actually checked, so it's actually _not_ "display-only".
		 * 
		 * If != 1.0 (if present), says the weapon "does not reload one shot at a time".
		 */
		context(attrs: IAttributeContainer)
		open var noReload_displayOnly: Number? 
			get() = BaseCombatWeaponAttributes.noReload_displayOnly.get()
			set(value) { BaseCombatWeaponAttributes.noReload_displayOnly.set(value) }
	
		/**
		 * Checked in `DoesReloadSingly`. If true, weapon does not reload one shot at a time. (e.g. FaN).
		 * 
		 * Note that for the most part, this logic is set inside the weapon itself. The scattergun attribute is the only way to control this with attributes.
		 */
		context(attrs: IAttributeContainer)
		open var scattergunNoReloadSingle: Boolean? 
			get() = BaseCombatWeaponAttributes.scattergunNoReloadSingle.get()
			set(value) { BaseCombatWeaponAttributes.scattergunNoReloadSingle.set(value) }
	
		open val clipSize: ClipSizeAttributes = ClipSizeAttributes()
	
		open class ClipSizeAttributes : IBlockScoped {
			companion object : IBlockScoped 
	
			/**
			 * Overwrites the max clipsize to a flat value. Applied before other multipliers.
			 */
			context(attrs: IAttributeContainer)
			open var maxPrimaryClipOverride: Int? 
				get() = BaseCombatWeaponAttributes.maxPrimaryClipOverride.get()
				set(value) { BaseCombatWeaponAttributes.maxPrimaryClipOverride.set(value) }
		}
	}
	
	open class MetaAttributes : EconEntityAttributes.MetaAttributes() {
		override val items: ItemsAttributes = ItemsAttributes()
	
		override val particles: ParticlesAttributes = ParticlesAttributes()
	
		override val killfeed: KillfeedAttributes = KillfeedAttributes()
	
		open class ItemsAttributes : EconEntityAttributes.MetaAttributes.ItemsAttributes() 
	
		open class ParticlesAttributes : EconEntityAttributes.MetaAttributes.ParticlesAttributes() 
	
		open class KillfeedAttributes : EconEntityAttributes.MetaAttributes.KillfeedAttributes() 
	}
	
	open class DisguiseAttributes : EconEntityAttributes.DisguiseAttributes() 
	
	open class CritsAttributes : EconEntityAttributes.CritsAttributes() 
	
	open class DamageAttributes : EconEntityAttributes.DamageAttributes() 
	
	open class MeterAttributes : EconEntityAttributes.MeterAttributes() 
	
	open class KnockbackReceivedAttributes : EconEntityAttributes.KnockbackReceivedAttributes() 
	
	open class ResistanceAttributes : EconEntityAttributes.ResistanceAttributes() 
}