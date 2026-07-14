package btpos.source.vdfdsl.tf2.templates

object Templates {
	/**
	 * Small robots.
	 */
	val Standard get() = RobotStandardTemplates
	
	/**
	 * Giant robots.
	 */
	val Giant get() = RobotGiantTemplates
	
	val Gatebot get() = RobotGatebotTemplates
	
	val SPY get() = RobotStandardTemplates.SPY
	val SNIPER get() = RobotStandardTemplates.Sniper.SNIPER
	val SENTRY_BUSTER get() = RobotGiantTemplates.SENTRY_BUSTER
}