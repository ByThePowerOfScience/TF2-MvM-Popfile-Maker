package btpos.source.vdfdsl.tf2.attributes

import btpos.source.vdfdsl.modeling.IKeyValueMap
import btpos.source.vdfdsl.serialization.codecs.NumberSelectorCodec
import btpos.source.vdfdsl.tf2.itemattributes.FistsAttributes
import btpos.source.vdfdsl.tf2.itemattributes.FlamethrowerAttributes
import btpos.source.vdfdsl.tf2.itemattributes.GrenadeLauncherAttributes
import btpos.source.vdfdsl.tf2.itemattributes.KnifeAttributes
import btpos.source.vdfdsl.tf2.itemattributes.LunchboxAttributes
import btpos.source.vdfdsl.tf2.itemattributes.SMGAttributes
import btpos.source.vdfdsl.tf2.itemattributes.SniperRifleAttributes
import btpos.source.vdfdsl.tf2.itemattributes.StickybombLauncherAttributes

private const val lunchboxstring = "lunchbox adds minicrits"

/**
 * `"lunchbox adds minicrits"` is used all over the place as the the standard "set weapon mode" attribute.
 *
 * Technically any `set_weapon_mode` attribute can be used for any of them, but lunchbox is the standard.
 */
context(attrs: IKeyValueMap)
private fun lunchbox(weaponMode: Int): Boolean? = attrs.getTyped("lunchbox has minicrits", NumberSelectorCodec(weaponMode))


context(attrs: IKeyValueMap)
private fun lunchbox(weaponMode: Int, value: Boolean?) = attrs.setNullable(lunchboxstring, value, NumberSelectorCodec(weaponMode))

context(attrs: IKeyValueMap)
private var lunchbox: Int?
	get() = attrs.getTyped(lunchboxstring)
	set(value) = attrs.setNullable(lunchboxstring, value)

/**
 * 0 = Stock flame particles
 *
 * 1 = MvM Giant Pyrobot flame particles
 *
 * 2 = Phlog flame particles
 *
 * 3 = Rainblower flame particles (also gives pyro a bubble wand when taunting)
 */
context(attrs: IKeyValueMap)
var FlamethrowerAttributes.flameParticles: Int?
    get() = lunchbox
    set(value) { lunchbox = value }


context(attrs: IKeyValueMap)
var SMGAttributes.canHeadshot: Boolean?
    get() = lunchbox(1)
    set(value) = lunchbox(1, value)

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
 * 1 = [adds max health][btpos.source.vdfdsl.tf2.itemattributes.LunchboxAttributes.lunchboxAddsMaxhealthBonus]
 *
 * 2 = [adds minicrits][btpos.source.vdfdsl.tf2.itemattributes.LunchboxAttributes.lunchboxAddsMinicrits]
 *
 * 3 = RoboSandvich
 *
 * 4 = Festive Sandvich
 *
 * 5 = Adds ammo
 */
context(attrs: IKeyValueMap)
var LunchboxAttributes.lunchType: Int?
	get() = lunchbox
	set(value) { lunchbox = value }


/**
 * 0 = Stock
 *
 * 1 = Your Eternal Reward
 *
 * 2 = Cloak and Dagger
 *
 * 3 = Spycicle
 */
context(attrs: IKeyValueMap)
var KnifeAttributes.knifeType: Int?
	get() = lunchbox
	set(value) { lunchbox = value }

/**
 * 0 = Stock
 *
 * 1 = Sydney Sleeper
 *
 * 2 = Machina
 *
 * 3 = Classic
 */
context(attrs: IKeyValueMap)
var SniperRifleAttributes.rifleType: Int?
	get() = lunchbox
	set(value) { lunchbox = value }

/**
 * 0 = Standard (all stickies detonate at once on rclick)
 *
 * 1 = Scottish Resistance's "look at stickies to detonate them"
 *
 * 2 = Old Quickiebomb's "stickies fizzle after 2 seconds"
 */
context(attrs: IKeyValueMap)
var StickybombLauncherAttributes.detonationType: Int?
    get() = attrs.getTyped("set_detonate_mode", )
    set(value) = attrs.setNullable("set_detonate_mode", value, )


context(attrs: IKeyValueMap)
var GrenadeLauncherAttributes.bombsShatterOnSurfaces: Boolean?
    get() = lunchbox(2)
    set(value) = lunchbox(2, value)




/**
 * 0 = No special behavior
 *
 * 1 = [Radial Buff][fistsHaveRadialBuff]
 *
 * 2 = Gloves of Running Urgently (Gives "penalty for spam-equipping gloves". Not present in SDK, but probably implemented.)
 */
context(attrs: IKeyValueMap)
var FistsAttributes.fistsType: Int?
	get() = lunchbox
	set(value) { lunchbox = value }

/**
 * On Kill: +50 health on nearby teammates
 *
 * On Kill: +10% Crit Chance on nearby teammates
 *
 * Also forces the player to taunt after every kill, and does not allow taunting manually.
 */
context(attrs: IKeyValueMap)
var FistsAttributes.fistsHaveRadialBuff: Boolean?
	get() = attrs.getTyped("fists have radial buff", NumberSelectorCodec(1))
	set(value) = attrs.setNullable("fists have radial buff", value, NumberSelectorCodec(1))
	