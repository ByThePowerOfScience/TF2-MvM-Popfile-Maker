package btpos.tf2.popfiledsl.serialization.codecs

interface Codec<FRONTEND, BACKEND> {
	companion object {
		private val _identity = object : Codec<Any?, Any?> {
			override fun read(data: Any?): Any? {
				return data
			}
			
			override fun write(input: Any?): Any? {
				return input
			}
		}
		
		@Suppress("UNCHECKED_CAST")
		fun <FRONTEND, BACKEND> identity() = _identity as Codec<FRONTEND, BACKEND>
	}
	
	fun read(data: BACKEND): FRONTEND
	
	fun write(input: FRONTEND): BACKEND
}