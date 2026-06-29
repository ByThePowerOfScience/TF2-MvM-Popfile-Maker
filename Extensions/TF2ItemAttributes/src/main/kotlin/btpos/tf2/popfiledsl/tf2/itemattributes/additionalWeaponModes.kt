package btpos.tf2.popfiledsl.tf2.itemattributes

import btpos.tf2.popfiledsl.attributes.SniperWeaponAttributes
import btpos.tf2.popfiledsl.modeling.IKeyValueMap
import btpos.tf2.popfiledsl.serialization.codecs.NumberSelectorCodec

context(attrs: IKeyValueMap)
private fun lunchbox(weaponMode: Int): Boolean? = attrs.getTyped("lunchbox has minicrits", NumberSelectorCodec(weaponMode))

context(attrs: IKeyValueMap)
private fun lunchbox(weaponMode: Int, value: Boolean?) = attrs.setNullable(lunchboxstring, value, NumberSelectorCodec(weaponMode))


private const val lunchboxstring = "lunchbox adds minicrits"

context(attrs: IKeyValueMap)
private var lunchbox: Int?
	get() = attrs.getTyped(lunchboxstring)
	set(value) = attrs.setNullable(lunchboxstring, value)

/**
 * 0 = Stock flame particles
 * 1 = MvM Giant Pyrobot flame particles
 * 2 = Phlog flame particles
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


context(attrs: IKeyValueMap)
var BonesawAttributes.bonesawType: Int?
	get() = lunchbox
	set(value) { lunchbox = value }

/**
 * 0 = standard (note: used for both Bonk and Sandvich)
 * 1 = [adds max health][LunchboxAttributes.lunchboxAddsMaxhealthBonus]
 * 2 = [adds minicrits][LunchboxAttributes.lunchboxAddsMinicrits]
 * 3 = RoboSandvich
 * 4 = Festive Sandvich
 * 5 = Adds ammo
 */
context(attrs: IKeyValueMap)
var LunchboxAttributes.lunchType: Int?
	get() = lunchbox
	set(value) { lunchbox = value }


/**
 * 0 = Stock
 * 1 = Your Eternal Reward
 * 2 = Cloak and Dagger
 * 3 = Spycicle
 */
context(attrs: IKeyValueMap)
var KnifeAttributes.knifeType: Int?
	get() = lunchbox
	set(value) { lunchbox = value }

/**
 * 0 = Stock
 * 1 = Sydney Sleeper
 * 2 = Machina
 * 3 = Classic
 */
context(attrs: IKeyValueMap)
var SniperRifleAttributes.rifleType: Int?
	get() = lunchbox
	set(value) { lunchbox = value }
