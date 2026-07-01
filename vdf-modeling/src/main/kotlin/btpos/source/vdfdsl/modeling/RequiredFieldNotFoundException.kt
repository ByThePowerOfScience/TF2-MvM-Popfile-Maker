package btpos.source.vdfdsl.modeling

class RequiredFieldNotFoundException(val originalDeclarationSiteTrace: Array<StackTraceElement>, override val cause: Throwable?) : RuntimeException() {
	override val message: String
		get() = "Required field not found."
	
	override fun getStackTrace(): Array<StackTraceElement> {
		return originalDeclarationSiteTrace
	}
}