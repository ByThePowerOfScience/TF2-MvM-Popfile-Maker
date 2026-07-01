package btpos.source.vdfdsl.types.bots

enum class TFClass {
	Scout,
	Soldier,
	Pyro,
	Demoman,
	HeavyWeapons,
	Engineer,
	Medic,
	Sniper,
	Spy;
	
	companion object {
		fun fromString(name: String): TFClass? {
			return when (name.lowercase()) {
				"scout" -> Scout
				"soldier" -> Soldier
				"pyro" -> Pyro
				"demoman" -> Demoman
				"heavy", "heavyweapons" -> HeavyWeapons
				"engineer" -> Engineer
				"medic" -> Medic
				"sniper" -> Sniper
				"spy" -> Spy
				else -> null
			}
		}
	}
	
	override fun toString(): String = name
}