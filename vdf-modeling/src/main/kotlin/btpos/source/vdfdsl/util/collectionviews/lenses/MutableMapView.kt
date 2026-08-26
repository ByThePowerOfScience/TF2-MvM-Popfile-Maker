package btpos.source.vdfdsl.util.collectionviews.lenses


interface MutableMapView<K1, V1, K2, V2> : MutableMap<K2, V2>, MapView<K1, V1, K2, V2> {
	override val backing: () -> MutableMap<K1, V1>
	
	private val _backing get() = backing()
	
	
	override val keys: MutableSet<K2>
		get() = MutableSetView(_backing.keys, readKey, writeKey)
	
	override val values: MutableCollection<V2>
		get() = MutableCollectionView(_backing.values, readValue, writeValue)
	
	override val entries: MutableSet<MutableMap.MutableEntry<K2, V2>>
		get() = MutableSetView(_backing.entries, { MutableEntryView(it, this) }) {
			object : MutableMap.MutableEntry<K1, V1> {
				override fun setValue(newValue: V1): V1 {
					return this.value.also {
						value = newValue
					}
				}
				
				override val key: K1 = writeKey(it.key)
				override var value: V1 = writeValue(it.value)
			}
		}
	
	
	open class MutableEntryView<K1, V1, K2, V2>(val entry: MutableMap.MutableEntry<K1, V1>, val outer: MutableMapView<K1, V1, K2, V2>) : MutableMap.MutableEntry<K2, V2> {
		override fun setValue(newValue: V2): V2 {
			return entry.setValue(newValue.let(outer.writeValue)).let(outer.readValue)
		}
		
		override val key: K2
			get() = outer.readKey(entry.key)
		override val value: V2
			get() = outer.readValue(entry.value)
		
	}
	
	override fun put(key: K2, value: V2): V2? {
		return _backing.put(writeKey(key), writeValue(value))?.let(readValue)
	}
	
	override fun remove(key: K2): V2? {
		return _backing.remove(writeKey(key))?.let(readValue)
	}
	
	override fun putAll(from: Map<out K2, V2>) {
		return _backing.putAll(MutableMapView(from.toMutableMap(), writeKey, readKey, writeValue, readValue))
	}
	
	override fun clear() = _backing.clear()
	
	companion object {
		operator fun <K1, V1, K2, V2> invoke(
			backing: MutableMap<K1, V1>,
			readKey: (K1) -> K2, writeKey: (K2) -> K1,
			readValue: (V1) -> V2, writeValue: (V2) -> V1
		): MutableMapView<K1, V1, K2, V2> = invoke({ backing }, readKey, writeKey, readValue, writeValue)
		
		operator fun <K1, V1, K2, V2> invoke(
			getBacking: () -> MutableMap<K1, V1>,
			readKey: (K1) -> K2, writeKey: (K2) -> K1,
			readValue: (V1) -> V2, writeValue: (V2) -> V1
		) = object : MutableMapView<K1, V1, K2, V2> {
			override val backing: () -> MutableMap<K1, V1> = getBacking
			override val readKey: (K1) -> K2 = readKey
			override val writeKey: (K2) -> K1 = writeKey
			override val readValue: (V1) -> V2 = readValue
			override val writeValue: (V2) -> V1 = writeValue
		}
	}
}