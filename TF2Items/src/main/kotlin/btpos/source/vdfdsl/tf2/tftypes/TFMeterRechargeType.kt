package btpos.source.vdfdsl.tf2.tftypes

/**
 * What makes a meter recharge: time, damage, or both.
 */
enum class TFMeterRechargeType {
	/** Meter solely recharges over time, like most throwables. */
	TIME,
	/** Meter solely recharges with damage dealt/healed, like with the banners. */
	DAMAGE,
	/** AKA "Combo": recharges both over time and with damage dealt/healed/etc depending on the buff type. */
	BOTH;
}