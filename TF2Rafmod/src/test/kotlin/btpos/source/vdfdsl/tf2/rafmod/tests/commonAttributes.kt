package btpos.source.vdfdsl.tf2.rafmod.tests

import btpos.source.vdfdsl.tf2.itemattributes.BaseGunAttributes
import btpos.source.vdfdsl.tf2.itemattributes.ItemAttributeNamed
import btpos.source.vdfdsl.tf2.itemattributes.WeaponBaseAttributes
import btpos.source.vdfdsl.tf2.items.AttributeConfigurationScope
import btpos.source.vdfdsl.tf2.items.TFItem
import btpos.source.vdfdsl.tf2.rafmod.attributes.RafmodVanillaAttributes.damage

val multDmg = WeaponBaseAttributes.damage.multDmg
val modBulletsPerShot = BaseGunAttributes.projectiles.bullets.modBulletsPerShot

val healthOnKillPercent = WeaponBaseAttributes.onKill.restoreHealthPercent

val voicePitch: ItemAttributeNamed<Number> = TODO()


/**
 * By going through this, we ensure every item has the same root settings
 */
inline fun <T : WeaponBaseAttributes> itemSettings(item: TFItem<T>, configure: AttributeConfigurationScope<T>): TFItem<T> {
	return item.withAttributes {
		taunting.specialTaunt = true
		
		configure()
	}
}