package btpos.source.vdfdsl.workshop.rafmod

object RafmodSerializers {
	val COORD3D = { it: Coord3D -> "${it.x} ${it.y} ${it.z}" }
}