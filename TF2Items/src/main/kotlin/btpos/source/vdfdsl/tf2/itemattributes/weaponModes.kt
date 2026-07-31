package btpos.source.vdfdsl.tf2.itemattributes

import btpos.source.vdfdsl.serialization.codecs.NumberSelectorCodec

private const val lunchboxstring = "lunchbox adds minicrits"

/**
 * `"lunchbox adds minicrits"` is used all over the place as the the standard "set weapon mode" attribute.
 *
 * Technically any `set_weapon_mode` attribute can be used for any of them, but lunchbox is the standard.
 */
private fun lunchbox(weaponMode: Int) = ItemAttributeNamed<Boolean>(lunchboxstring, NumberSelectorCodec(weaponMode))

private val lunchbox = ItemAttributeNamed<Int>(lunchboxstring)



/**
 * 0 = Stock flame particles
 *
 * 1 = MvM Giant Pyrobot flame particles
 *
 * 2 = Phlog flame particles
 *
 * 3 = Rainblower flame particles (also gives pyro a bubble wand when taunting)
 */
val FlamethrowerAttributes.flameParticles: ItemAttributeNamed<Int> get() = lunchbox


val SMGAttributes.canHeadshot: ItemAttribute<Boolean> by lunchbox(1)

///**
// * Unused
// */
//context(attrs: IKeyValueMap)
//var BonesawAttributes.bonesawType: Int?
//	get() = lunchbox
//	set(value) { lunchbox = value }

/**
 * 0 = standard (note: used for both Bonk and Sandvich)
 *
 * 1 = [adds max health][LunchboxAttributes.lunchboxAddsMaxhealthBonus]
 *
 * 2 = [adds minicrits][LunchboxAttributes.lunchboxAddsMinicrits]
 *
 * 3 = RoboSandvich
 *
 * 4 = Festive Sandvich
 *
 * 5 = Adds ammo
 */
val LunchboxAttributes.lunchType: ItemAttribute<Int> by lunchbox


/**
 * 0 = Stock
 *
 * 1 = Your Eternal Reward
 *
 * 2 = Cloak and Dagger
 *
 * 3 = Spycicle
 */
val KnifeAttributes.knifeType: ItemAttribute<Int> by lunchbox

/**
 * 0 = Stock
 *
 * 1 = Sydney Sleeper
 *
 * 2 = Machina
 *
 * 3 = Classic
 */
val SniperRifleAttributes.rifleType: ItemAttribute<Int> by lunchbox

/**
 * 0 = Standard (all stickies detonate at once on rclick)
 *
 * 1 = Scottish Resistance's "look at stickies to detonate them"
 *
 * 2 = Old Quickiebomb's "stickies fizzle after 2 seconds"
 */
val StickybombLauncherAttributes.detonationType: ItemAttribute<Int> by lunchbox


val GrenadeLauncherAttributes.bombsShatterOnSurfaces: ItemAttribute<Boolean> by lunchbox(2)




/**
 * 0 = No special behavior
 *
 * 1 = [Radial Buff][fistsHaveRadialBuff]
 *
 * 2 = Gloves of Running Urgently (Gives "penalty for spam-equipping gloves". Not present in SDK, but probably implemented.)
 */
val FistsAttributes.fistsType: ItemAttribute<Int> by lunchbox

/**
 * On Kill: +50 health on nearby teammates
 *
 * On Kill: +10% Crit Chance on nearby teammates
 *
 * Also forces the player to taunt after every kill, and does not allow taunting manually.
 */
val FistsAttributes.fistsHaveRadialBuff by ItemAttributeNamed("fists have radial buff", NumberSelectorCodec(1))
	