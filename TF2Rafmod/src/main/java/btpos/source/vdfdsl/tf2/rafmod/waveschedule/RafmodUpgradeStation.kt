package btpos.source.vdfdsl.tf2.rafmod.waveschedule

import btpos.source.vdfdsl.modeling.IExtensibleSubtree.Companion.addField
import btpos.source.vdfdsl.modeling.IExtensibleSubtree.Serializers.flatListWithKey
import btpos.source.vdfdsl.serialization.codecs.BinaryIntCodec
import btpos.source.vdfdsl.tf2.rafmod.RafmodConstants.SIGSEGV
import btpos.source.vdfdsl.tf2.rafmod.RafmodSerializers.BOOL_SER_INVERT
import btpos.source.vdfdsl.types.WaveSchedule

abstract class RafmodUpgradeStation {
	companion object {
		@PublishedApi @JvmField internal val INSTANCE = object : RafmodUpgradeStation() {}
	}
	
	/**
	 * Custom upgrades file. File must be named `mvm_upgrades_x.txt` and must be uploaded to the servers.
	 * 
	 * Example:
	 * ```kotlin
	 * customUpgradesFile = "mvm_upgrades_sigsegv_extra_v19.txt"
	 * ```
	 */
	var WaveSchedule.customUpgradesFile: String? by addField("CustomUpgradesFile", conditional = SIGSEGV)
	
	/**
	 * If true, upgrade station is permanently disabled for this mission.
	 */
	var WaveSchedule.disableUpgradeStations: Boolean? by addField("DisableUpgradeStations", conditional = SIGSEGV, serializer = BinaryIntCodec::write)
	
	/**
	 * Prevent players from gaining these upgrades.  You can also use the position on the upgrade list, starting from 1.
	 *
	 * Example:
	 * ```kotlin
	 * disallowUpgrades += "fire rate bonus"
	 * ```
	 */
	var WaveSchedule.disallowUpgrades: List<String> by addField("DisallowUpgrade", conditional = SIGSEGV, serializer = flatListWithKey(), initialValue = ::listOf)
	
	/**
	 * If true, prevents upgrades from changing the player's currently-equipped weapons to the items specified in their loadout.
	 */
	var WaveSchedule.upgradeStationKeepWeapons: Boolean? by addField("UpgradeStationKeepWeapons", conditional = SIGSEGV, serializer = BinaryIntCodec::write)
	
	/**
	 * If true, only shows the extended upgrade menu, and does not show the regular upgrade menu.
	 */
	var WaveSchedule.extendedUpgradesOnly: Boolean? by addField("ExtendedUpgradesOnly", conditional = SIGSEGV, serializer = BinaryIntCodec::write)
	
	/**
	 * If true, prevents players from refunding their upgrades
	 */
	var WaveSchedule.disableRespec: Boolean? by addField("RespecEnabled", conditional = SIGSEGV, serializer = BOOL_SER_INVERT)
	
	/**
	 * How many times the player can refund their upgrades. If unset, there is no limit.
	 *
	 * Example:
	 * ```kotlin
	 * respecLimit = 1
	 * ```
	 */
	var WaveSchedule.respecLimit: Int? by addField("RespecLimit", conditional = SIGSEGV)
}

