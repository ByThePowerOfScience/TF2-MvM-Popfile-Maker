package btpos.source.vdfdsl.tf2.rafmod.bot

import btpos.source.vdfdsl.modeling.IExtensibleSubtree.Companion.addField
import btpos.source.vdfdsl.tf2.rafmod.RafmodConstants.SIGSEGV
import btpos.source.vdfdsl.types.spawners.TFBotSpawner

/**
 * If true, this bot will not upgrade over time while carrying the bomb.
 */
var TFBotSpawner.noBombUpgrades: Boolean? by addField("NoBombUpgrades", conditional = SIGSEGV)

