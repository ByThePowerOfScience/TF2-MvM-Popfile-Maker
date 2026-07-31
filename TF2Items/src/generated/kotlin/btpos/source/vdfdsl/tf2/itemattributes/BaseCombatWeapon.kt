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
	
		val meta: MetaAttributes = MetaAttributes()
	
		val disguise: DisguiseAttributes = DisguiseAttributes()
	
		val crits: CritsAttributes = CritsAttributes()
	
		val damage: DamageAttributes = DamageAttributes()
	
		val meter: MeterAttributes = MeterAttributes()
	
		val knockbackReceived: KnockbackReceivedAttributes = KnockbackReceivedAttributes()
	
		val resistance: ResistanceAttributes = ResistanceAttributes()
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
		/**
		 * In-Game: "Uses metal for ammo"
		 * 
		 * Reminder: non-engies start with 100 metal.
		 */
		open val useMetalAmmoType: ItemAttributeNamed<Boolean> = ItemAttributeNamed("mod use metal ammo type")
	
		/**
		 * In-Game: "No reload necessary"
		 * 
		 * In the "DoesReloadSingly" check, this _is_ actually checked, so it's actually _not_ "display-only".
		 * 
		 * If != 1.0 (if present), says the weapon "does not reload one shot at a time".
		 */
		open val noReload_displayOnly: ItemAttributeNamed<Number> = ItemAttributeNamed("mod no reload DISPLAY ONLY")
	
		/**
		 * Checked in the same place.	If true, weapon does not reload one shot at a time. (e.g. FaN).
		 * 
		 * Note that for the most part, this logic is set inside the weapon itself. The scattergun attribute is the only way to control this with attributes.
		 */
		open val scattergunNoReloadSingle: ItemAttributeNamed<Boolean> = ItemAttributeNamed("scattergun no reload single")
	
		open val clipSize: ClipSizeAttributes = ClipSizeAttributes()
	
		open class ClipSizeAttributes : IBlockScoped {
			/**
			 * Overwrites the max clipsize to a flat value. Applied before other multipliers.
			 */
			open val maxPrimaryClipOverride: ItemAttributeNamed<Int> = ItemAttributeNamed("mod max primary clip override")
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