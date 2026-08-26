package btpos.source.vdfdsl.util.collectionviews.lenses

interface MapView<K1, V1, K2, V2> : Map<K2, V2> {
	val backing: () -> Map<K1, V1>
	
	private val _backing get() = backing()
	
	val readKey: (K1) -> K2
	val writeKey: (K2) -> K1
	
	val readValue: (V1) -> V2
	val writeValue: (V2) -> V1
	
	override val keys: Set<K2>
		get() = SetView(_backing.keys, readKey, writeKey)
	
	override val values: Collection<V2>
		get() = CollectionView(_backing.values, readValue, writeValue)
	
	override val entries: Set<Map.Entry<K2, V2>>
		get() = SetView(_backing.entries, { EntryView(it, this) }, {
			object : Map.Entry<K1, V1> {
				override val key: K1 get() = writeKey(it.key)
				override val value: V1 get() = writeValue(it.value)
			}
		})
	
	override val size: Int get() = _backing.size
	
	override fun isEmpty() = _backing.isEmpty()
	
	override fun containsKey(key: K2) = _backing.containsKey(writeKey(key))
	
	override fun containsValue(value: V2) = _backing.containsValue(writeValue(value))
	
	override fun get(key: K2): V2? = _backing[writeKey(key)]?.let(readValue)
	
	open class EntryView<K1, V1, K2, V2>(val _backing: Map.Entry<K1, V1>, val outer: MapView<K1, V1, K2, V2>) : Map.Entry<K2, V2> {
		override val key: K2 get() = outer.readKey(_backing.key)
		override val value: V2 get() = outer.readValue(_backing.value)
	}
	
	
	companion object {
	    operator fun <K1, V1, K2, V2> invoke(
		    _backing: Map<K1, V1>,
		    readKey: (K1) -> K2, writeKey: (K2) -> K1,
		    readValue: (V1) -> V2, writeValue: (V2) -> V1
		) = object : MapView<K1, V1, K2, V2> {
		    override val backing = { _backing }
		    override val readKey = readKey
		    override val writeKey = writeKey
		    override val readValue = readValue
		    override val writeValue = writeValue
	    }
	}
}