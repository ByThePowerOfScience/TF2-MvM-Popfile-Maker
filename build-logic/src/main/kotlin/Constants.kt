
object Constants {
	object Groups {
		const val BASE = "btpos.source.vdfdsl"
		
		const val VDF = BASE + ".vdf"
		
		const val TF2 = BASE + ".tf2"
		
		
		fun vdf(suffix: String) = VDF + "." + suffix
		
		fun tf2(suffix: String) = TF2 + "." + suffix
	}
	
	
	
	const val PROJECT_VERSION = "1.0"
}