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
	
	override fun toString(): String = name
}