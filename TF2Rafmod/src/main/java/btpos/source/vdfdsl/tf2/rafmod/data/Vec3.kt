package btpos.source.vdfdsl.tf2.rafmod.data

import btpos.source.vdfdsl.tf2.rafmod.RafmodSerializers


import btpos.source.vdfdsl.backing.VDFKeyValue
import btpos.source.vdfdsl.backing.VDFPrimitive
import btpos.source.vdfdsl.backing.VDFSubtree
import btpos.source.vdfdsl.modeling.AbstractVDFStruct
import btpos.source.vdfdsl.modeling.ExtensibleSubtreeImpl
import btpos.source.vdfdsl.modeling.IExtensibleSubtree.Companion.addField
import btpos.source.vdfdsl.modeling.IExtensibleSubtree_VDFRepresentable
import btpos.source.vdfdsl.serialization.IVDFRepresentableKeyValue
import btpos.source.vdfdsl.serialization.IVDFRepresentableValue_Trivial
import btpos.source.vdfdsl.tf2.rafmod.RafmodConstants.SIGSEGV
import btpos.source.vdfdsl.types.specifics.OutputAction

@JvmRecord
data class Vec3(val x: Number, val y: Number, val z: Number)

@JvmInline value class Rot3(private val vec: Vec3) : IVDFRepresentableValue_Trivial {
	constructor(
		/**
		 * Degrees of rotation about the LEFT/RIGHT axis.
		 *
		 * Imagine a shishkebab, where the stick is the axis.  If you hold it so the stick is pointing from left to right, and then rotate the stick so the top of the meat is spinning away from you, that's pitch.
		 */
		pitch: Number,
		/**
		 * Degrees of rotation about the UP/DOWN axis.
		 *
		 * Imagine a shishkebab, where the stick is the axis.  If you hold it so the stick is pointing straight up, and then rotate the stick so the meat is turning clockwise to your perspective, that's yaw.
		 */
		yaw: Number,
		/**
		 * Degrees of rotation about the FORWARD/BACKWARD axis.
		 *
		 * Imagine a shishkebab, where the stick is the axis.  If you hold it so the stick is pointing away from you, and then spin the kebab so the meat is turning clockwise, that's roll.
		 */
		roll: Number
	) : this(Vec3(pitch, yaw, roll))
	
	/**
	 * Degrees of rotation about the LEFT/RIGHT axis.
	 *
	 * Imagine a shishkebab, where the stick is the axis.  If you hold it so the stick is pointing away from you, and then spin the kebab so the meat is turning clockwise, that's roll.
	 */
	val pitch get() = vec.x
	/**
	 * Degrees of rotation about the UP/DOWN axis.
	 *
	 * Imagine a shishkebab, where the stick is the axis.  If you hold it so the stick is pointing straight up, and then rotate the stick so the meat is turning clockwise to your perspective, that's yaw.
	 */
	val yaw get() = vec.y
	/**
	 * Degrees of rotation about the FORWARD/BACKWARD axis.
	 *
	 * Imagine a shishkebab, where the stick is the axis.  If you hold it so the stick is pointing away from you, and then spin the kebab so the meat is turning clockwise, that's roll.
	 */
	val roll get() = vec.z
	
	override val _vdfRepr: VDFPrimitive
		get() = VDFPrimitive("$pitch $yaw $roll")
}



interface PathNode : IVDFRepresentableKeyValue {
	companion object {
		operator fun invoke(x: Number, y: Number, z: Number) = Simple(Vec3(x, y, z))

		inline operator fun invoke(configure: Tree.() -> Unit): Tree {
			return Tree().apply(configure)
		}
	}

	class Simple(val coord: Vec3) : PathNode {
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
		val target: Vec3? by addField("Target", serializer = RafmodSerializers.COORD3D)

		/**
		 * Look at specified position or entity
		 */
		val aimTarget: Vec3? by addField("AimTarget", serializer = RafmodSerializers.COORD3D)

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

