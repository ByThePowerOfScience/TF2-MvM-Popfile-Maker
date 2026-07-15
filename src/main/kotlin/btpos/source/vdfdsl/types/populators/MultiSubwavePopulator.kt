package btpos.source.vdfdsl.types.populators

import btpos.source.vdfdsl.backing.VDFSubtree
import btpos.source.vdfdsl.modeling.AbstractVDFStruct
import btpos.source.vdfdsl.modeling.ExtensibleSubtreeImpl
import btpos.source.vdfdsl.modeling.IExtensibleSubtree
import btpos.source.vdfdsl.modeling.IExtensibleSubtree_VDFRepresentable
import btpos.source.vdfdsl.serialization.IVDFRepresentableKeyValue
import btpos.source.vdfdsl.utils.ReadOnlyConstant
import kotlin.properties.PropertyDelegateProvider
import kotlin.properties.ReadOnlyProperty

class MultiSubtreeMap(val items: List<MutableMap<Any, IVDFRepresentableKeyValue>>) : MutableMap<Any, IVDFRepresentableKeyValue> {
	override val keys: MutableSet<Any>
		get() = items.flatMap { it.keys }.toMutableSet()
	
	override val values: MutableCollection<IVDFRepresentableKeyValue>
		get() = items.flatMap { it.values }.toMutableList()
	
	override val entries: MutableSet<MutableMap.MutableEntry<Any, IVDFRepresentableKeyValue>>
		get() = items.flatMap { it.entries }.toMutableSet()
	
	override fun put(key: Any, value: IVDFRepresentableKeyValue): IVDFRepresentableKeyValue? {
		items.forEach {
			it[key] = value
		}
		return null;
	}
	
	override fun remove(key: Any): IVDFRepresentableKeyValue? {
		items.forEach {
			it.remove(key)
		}
		return null;
	}
	
	override fun putAll(from: Map<out Any, IVDFRepresentableKeyValue>) {
		items.forEach {
			it.putAll(from)
		}
	}
	
	override fun clear() {
		items.forEach {
			it.clear()
		}
	}
	
	override val size: Int
		get() = entries.size
	
	override fun isEmpty(): Boolean {
		return items.all { it.isEmpty() }
	}
	
	override fun containsKey(key: Any): Boolean {
		return items.any { it.containsKey(key) }
	}
	
	override fun containsValue(value: IVDFRepresentableKeyValue): Boolean {
		return items.any { it.containsValue(value) }
	}
	
	override fun get(key: Any): IVDFRepresentableKeyValue? {
		return items.firstNotNullOfOrNull { it[key] }
	}
}

/**
 * A number of WaveSpawns bundled together to go off at once.
 * Any settings (name, where, etc.) applied to this root object will be applied to all of its constituent wavespawns.
 *
 * Does not actually exist in the VDF.
 */
class MultiSubwavePopulator(
	_subtree: IExtensibleSubtree_VDFRepresentable = ExtensibleSubtreeImpl()
) : WaveSpawnPopulator(_subtree) {
	val items: MutableList<WaveSpawnPopulator> = mutableListOf()
	
	override fun _serializeInto(input: VDFSubtree) {
		return items.forEach {
			// allow stuff set in this to overwrite stuff set in each item
			VDFStructWithPrototype(it, this)._serializeInto(input)
		}
	}
	
	operator fun WaveSpawnPopulator.unaryPlus() {
		this@MultiSubwavePopulator.items += this
	}
	
	override fun copy() = MultiSubwavePopulator(copyInternal()).also {
		items.mapTo(it.items, WaveSpawnPopulator::copy)
	}
}

class MapWithPrototype<K, V>(val prototype: Map<K, V>, val backingMap: MutableMap<K, V> = mutableMapOf()) : MutableMap<K, V> by backingMap {
	override fun get(key: K): V? {
		return backingMap[key] ?: prototype[key]
	}
	
	override fun getOrDefault(key: K, defaultValue: V): V {
		return backingMap[key] ?: prototype[key] ?: defaultValue
	}
	
	override val keys: MutableSet<K>
		get() = backingMap.keys.toMutableSet().also { it.addAll(prototype.keys) }
	
	override val values: MutableCollection<V>
		get() = this.keys.mapTo(mutableListOf()) { this[it]!! }
}


class VDFStructWithPrototype(
	proto: IExtensibleSubtree,
	val struct: AbstractVDFStruct,
) : AbstractVDFStruct(ExtensibleSubtreeImpl(MapWithPrototype(proto._rawEntries, struct._rawEntries), struct._instantiationSite)) {
	override val _structIdentifier: String
		get() = struct._structIdentifier
	
	override fun copy() = struct.copy()
}
// TODO test all of this overengineered garbage AAAAAAAAAAA

