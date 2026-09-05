package btpos.source.vdfdsl.tf2.rafmod.waveschedule

import btpos.source.vdfdsl.modeling.IExtensibleSubtree.Companion.addField
import btpos.source.vdfdsl.modeling.IExtensibleSubtree.Serializers.flatListWithKey
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
	val customUpgradesFile by addField<String>("CustomUpgradesFile", conditional = SIGSEGV)
	
	/**
	 * If true, upgrade station is permanently disabled for this mission.
	 */
	val disableUpgradeStations by addField<Boolean>("DisableUpgradeStations", conditional = SIGSEGV)
	
	/**
	 * Prevent players from gaining these upgrades.  You can also use the position on the upgrade list, starting from 1.
	 *
	 * Example:
	 * ```kotlin
	 * disallowUpgrades += "fire rate bonus"
	 * ```
	 */
	open var WaveSchedule.disallowUpgrades: List<String> by addField("DisallowUpgrade", conditional = SIGSEGV, serializer = flatListWithKey(), initialValue = ::listOf)
	
	/**
	 * If true, prevents upgrades from changing the player's currently-equipped weapons to the items specified in their loadout.
	 */
	val upgradeStationKeepWeapons by addField<Boolean>("UpgradeStationKeepWeapons", conditional = SIGSEGV)
	
	/**
	 * If true, only shows the extended upgrade menu, and does not show the regular upgrade menu.
	 */
	val extendedUpgradesOnly by addField<Boolean>("ExtendedUpgradesOnly", conditional = SIGSEGV)
	
	/**
	 * If true, prevents players from refunding their upgrades
	 */
	val canRespec by addField<Boolean>("RespecEnabled", conditional = SIGSEGV)
	
	/**
	 * How many times the player can refund their upgrades. If unset, there is no limit.
	 *
	 * Example:
	 * ```kotlin
	 * respecLimit = 1
	 * ```
	 */
	val respecLimit by addField<Int>("RespecLimit", conditional = SIGSEGV)
	
	
	/**
	 * If true, the "Burn Time" upgrade on players increases afterburn _damage frequency_ (i.e. lowers the delay between afterburn ticks) instead of the total afterburn effect length. (Default: true)
	 */
	val burnTimeFasterBurn by addField<Boolean>("BurnTimeFasterBurn", conditional = SIGSEGV)
	
	
}

