package btpos.source.vdfdsl.tf2.rafmod.tests

import btpos.source.vdfdsl.tf2.itemattributes.IAttributeContainer
import btpos.source.vdfdsl.tf2.itemattributes.RocketLauncherAttributes
import btpos.source.vdfdsl.tf2.itemattributes.impl.invoke
import btpos.source.vdfdsl.tf2.items.TFItem
import btpos.source.vdfdsl.tf2.items.weapons.Weapons
import btpos.source.vdfdsl.tf2.items.weapons.Weapons.STOCK_ROCKET_LAUNCHER
import btpos.source.vdfdsl.tf2.items.weapons.WeaponsByClass

object RocketLaunchers {
//	fun make(): List<TFItem<*>> {
//
//	}
	
	val stock = itemSettings(STOCK_ROCKET_LAUNCHER) {
		multDmg = 13.5
		firing.fireRate.multPostFireDelay = 0.1
		reloading.multReloadTime = 0.1
		
		ammo {
			clipSize.clipSizeUpgradeAtomic = 96
			multMaxAmmo.primary = 40
		}
	}
}