package btpos.source.vdfdsl.tf2.rafmod.data

import btpos.source.vdfdsl.tf2.rafmod.RafmodSerializers


import btpos.source.vdfdsl.backing.VDFKeyValue
import btpos.source.vdfdsl.backing.VDFSubtree
import btpos.source.vdfdsl.modeling.AbstractVDFStruct
import btpos.source.vdfdsl.modeling.ExtensibleSubtreeImpl
import btpos.source.vdfdsl.modeling.IExtensibleSubtree.Companion.addField
import btpos.source.vdfdsl.modeling.IExtensibleSubtree_VDFRepresentable
import btpos.source.vdfdsl.serialization.IVDFRepresentableKeyValue
import btpos.source.vdfdsl.tf2.rafmod.RafmodConstants.SIGSEGV
import btpos.source.vdfdsl.types.specifics.OutputAction

@JvmRecord
data class Coord3D(val x: Number, val y: Number, val z: Number)

interface PathNode : IVDFRepresentableKeyValue {
	companion object {
		operator fun invoke(x: Number, y: Number, z: Number) = Simple(Coord3D(x, y, z))

		inline operator fun invoke(configure: Tree.() -> Unit): Tree {
			return Tree().apply(configure)
		}
	}

	class Simple(val coord: Coord3D) : PathNode {
		override fun _serializeInto(input: VDFSubtree) {
			input += VDFKeyValue("Node", RafmodSerializers.COORD3D(coord), SIGSEGV)
		}
	}

	class Tree(_subtree: IExtensibleSubtree_VDFRepresentable = ExtensibleSubtreeImpl()) : PathNode, AbstractVDFStruct(_subtree) {
		override val _structIdentifier: String
			get() = "Node"
		
		override val _conditional: String
			get() = SIGSEGV

		override fun copy(): Tree {
			return Tree(copyInternal())
		}

		/**
		 * Node position or entity
		 */
		val target: Coord3D? by addField("Target", serializer = RafmodSerializers.COORD3D)

		/**
		 * Look at specified position or entity
		 */
		val aimTarget: Coord3D? by addField("AimTarget", serializer = RafmodSerializers.COORD3D)

		/**
		 * Wait this many seconds after approaching this node
		 */
		val wait: Number? by addField("Wait")

		/**
		 * Fire output after approaching this node
		 */
		val output: OutputAction? by addField("Output")

		/**
		 * Next node in path to use instead of the node below
		 */
		val next: PathNode? by addField("Next")
	}
}

