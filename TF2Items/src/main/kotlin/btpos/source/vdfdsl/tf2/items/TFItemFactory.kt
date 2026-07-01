package btpos.source.vdfdsl.tf2.items

import btpos.source.vdfdsl.tf2.itemattributes.BaseCombatWeaponAttributes
import btpos.source.vdfdsl.tf2.itemattributes.BaseGunAttributes
import btpos.source.vdfdsl.tf2.itemattributes.BaseMeleeAttributes
import btpos.source.vdfdsl.tf2.itemattributes.BatAttributes
import btpos.source.vdfdsl.tf2.itemattributes.BonesawAttributes
import btpos.source.vdfdsl.tf2.itemattributes.BottleAttributes
import btpos.source.vdfdsl.tf2.itemattributes.BuffItemAttributes
import btpos.source.vdfdsl.tf2.itemattributes.BuilderAttributes
import btpos.source.vdfdsl.tf2.itemattributes.ChargedSMGAttributes
import btpos.source.vdfdsl.tf2.itemattributes.CompoundBowAttributes
import btpos.source.vdfdsl.tf2.itemattributes.CrossbowAttributes
import btpos.source.vdfdsl.tf2.itemattributes.FireAxeAttributes
import btpos.source.vdfdsl.tf2.itemattributes.FistsAttributes
import btpos.source.vdfdsl.tf2.itemattributes.FlamethrowerAttributes
import btpos.source.vdfdsl.tf2.itemattributes.FlareGunAttributes
import btpos.source.vdfdsl.tf2.itemattributes.GrenadeLauncherAttributes
import btpos.source.vdfdsl.tf2.itemattributes.impl.IBlockScoped
import btpos.source.vdfdsl.tf2.itemattributes.InvisAttributes
import btpos.source.vdfdsl.tf2.itemattributes.JarAttributes
import btpos.source.vdfdsl.tf2.itemattributes.KnifeAttributes
import btpos.source.vdfdsl.tf2.itemattributes.LunchboxAttributes
import btpos.source.vdfdsl.tf2.itemattributes.MechanicalArmAttributes
import btpos.source.vdfdsl.tf2.itemattributes.MedigunAttributes
import btpos.source.vdfdsl.tf2.itemattributes.MinigunAttributes
import btpos.source.vdfdsl.tf2.itemattributes.PistolAttributes
import btpos.source.vdfdsl.tf2.itemattributes.RayGunAttributes
import btpos.source.vdfdsl.tf2.itemattributes.RevolverAttributes
import btpos.source.vdfdsl.tf2.itemattributes.RocketLauncherAttributes
import btpos.source.vdfdsl.tf2.itemattributes.RocketLauncher_AirStrikeAttributes
import btpos.source.vdfdsl.tf2.itemattributes.RocketPackAttributes
import btpos.source.vdfdsl.tf2.itemattributes.SMGAttributes
import btpos.source.vdfdsl.tf2.itemattributes.SapperAttributes
import btpos.source.vdfdsl.tf2.itemattributes.ScattergunAttributes
import btpos.source.vdfdsl.tf2.itemattributes.ScoutPistolAttributes
import btpos.source.vdfdsl.tf2.itemattributes.ShotgunAttributes
import btpos.source.vdfdsl.tf2.itemattributes.ShotgunRevengeAttributes
import btpos.source.vdfdsl.tf2.itemattributes.ShovelAttributes
import btpos.source.vdfdsl.tf2.itemattributes.SniperRifleAttributes
import btpos.source.vdfdsl.tf2.itemattributes.StickBombAttributes
import btpos.source.vdfdsl.tf2.itemattributes.StickybombLauncherAttributes
import btpos.source.vdfdsl.tf2.itemattributes.SwordAttributes
import btpos.source.vdfdsl.tf2.itemattributes.SyringeGunAttributes
import btpos.source.vdfdsl.tf2.itemattributes.ThrowableAttributes
import btpos.source.vdfdsl.tf2.itemattributes.WeaponBaseAttributes
import btpos.source.vdfdsl.tf2.itemattributes.WearableAttributes
import btpos.source.vdfdsl.tf2.itemattributes.WearableDemoShieldAttributes
import btpos.source.vdfdsl.tf2.itemattributes.WrenchAttributes

/**
 * Helper class for creating weapons
 */
class TFItemFactory<ATTR : IBlockScoped>(val scope: ATTR) {
	operator fun invoke(name: String): TFItem<ATTR> {
		return TFItem(name, null, scope)
	}
	
	companion object {
		val BASE_COMBAT_WEAPON = TFItemFactory(BaseCombatWeaponAttributes)
		val WEAPON_BASE = TFItemFactory(WeaponBaseAttributes)
		val BASE_GUN = TFItemFactory(BaseGunAttributes)
		val BASE_MELEE = TFItemFactory(BaseMeleeAttributes)
		val FLAMETHROWER = TFItemFactory(FlamethrowerAttributes)
		val SMG = TFItemFactory(SMGAttributes)
		val CHARGED_SMG = TFItemFactory(ChargedSMGAttributes)
		val SAPPER = TFItemFactory(SapperAttributes)
		val FISTS = TFItemFactory(FistsAttributes)
		val SHOVEL = TFItemFactory(ShovelAttributes)
		val BOTTLE = TFItemFactory(BottleAttributes)
		val STICKBOMB = TFItemFactory(StickBombAttributes)
		val FIRE_AXE = TFItemFactory(FireAxeAttributes)
		val BONESAW = TFItemFactory(BonesawAttributes)
		val MINIGUN = TFItemFactory(MinigunAttributes)
		val PISTOL = TFItemFactory(PistolAttributes)
		val SCOUT_PISTOL = TFItemFactory(ScoutPistolAttributes)
		val REVOLVER = TFItemFactory(RevolverAttributes)
		val SYRINGE_GUN = TFItemFactory(SyringeGunAttributes)
		val ROCKETPACK = TFItemFactory(RocketPackAttributes)
		val INVIS = TFItemFactory(InvisAttributes)
		val STICKYBOMB_LAUNCHER = TFItemFactory(StickybombLauncherAttributes)
		val BUFF_ITEM = TFItemFactory(BuffItemAttributes)
		val WRENCH = TFItemFactory(WrenchAttributes)
		val ROCKETLAUNCHER = TFItemFactory(RocketLauncherAttributes)
		val ROCKETLAUNCHER_AIRSTRIKE = TFItemFactory(RocketLauncher_AirStrikeAttributes)
		val GRENADE_LAUNCHER = TFItemFactory(GrenadeLauncherAttributes)
		val CROSSBOW = TFItemFactory(CrossbowAttributes)
		val RAYGUN = TFItemFactory(RayGunAttributes)
		val LUNCHBOX = TFItemFactory(LunchboxAttributes)
		val SHOTGUN = TFItemFactory(ShotgunAttributes)
		val SCATTERGUN = TFItemFactory(ScattergunAttributes)
		val SHOTGUN_REVENGE = TFItemFactory(ShotgunRevengeAttributes)
		val KNIFE = TFItemFactory(KnifeAttributes)
		val SWORD = TFItemFactory(SwordAttributes)
		val KATANA get() = SWORD
		val WEARABLE = TFItemFactory(WearableAttributes)
		val WEARABLE_DEMOSHIELD = TFItemFactory(WearableDemoShieldAttributes)
		val FLARE_GUN = TFItemFactory(FlareGunAttributes)
		val JAR = TFItemFactory(JarAttributes)
		val MECHANICAL_ARM = TFItemFactory(MechanicalArmAttributes)
		
		/**
		 * NOTE: Helltower spells are the only things in the SDK to be a "throwable" in this case
		 */
		val THROWABLE = TFItemFactory(ThrowableAttributes)
		val SNIPERRIFLE = TFItemFactory(SniperRifleAttributes)
		val MEDIGUN = TFItemFactory(MedigunAttributes)
		val BUILDER = TFItemFactory(BuilderAttributes)
		val COMPOUND_BOW = TFItemFactory(CompoundBowAttributes)
		val BAT = TFItemFactory(BatAttributes)
		val PARACHUTE get() = BUFF_ITEM
	}
}