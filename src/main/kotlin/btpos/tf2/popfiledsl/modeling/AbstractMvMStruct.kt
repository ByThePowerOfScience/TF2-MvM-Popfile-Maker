package btpos.tf2.popfiledsl.modeling

import btpos.tf2.popfiledsl.serialization.IPopFileRepresentable
import btpos.tf2.popfiledsl.serialization.PopFileEntry
import kotlin.properties.PropertyDelegateProvider
import kotlin.properties.ReadOnlyProperty
import kotlin.properties.ReadWriteProperty
import kotlin.reflect.KProperty

/**
 * A structure in an MvM popfile, modeled as an extensible map that can contain multiple mappings for a single key.
 *
 * Structs resolve to a [PopFileEntry] that is a pair of its _identifier_ and its _map_.
 * Structs essentially only differ from maps in that they have a name.
 */
abstract class AbstractMvMStruct : IPopFileRepresentable<PopFileEntry> {
	companion object {
		/**
		 * Extend a struct with a field that can only be in that struct once.
		 *
		 * Also offers conversion functions to allow the user to input one thing and then serialize another.
		 */
		fun <EXPOSED : Any, SERIALIZED : Any> singleKeyedValue(key: Any, transformForWrite: (EXPOSED) -> SERIALIZED, transformForRead: (SERIALIZED) -> EXPOSED): ReadWriteProperty<AbstractMvMStruct, EXPOSED?> {
			return object : ReadWriteProperty<AbstractMvMStruct, EXPOSED?> {
				override fun getValue(thisRef: AbstractMvMStruct, property: KProperty<*>): EXPOSED? {
					return thisRef.uniqueFields[key]?.let { transformForRead(it as SERIALIZED) }
				}
				
				override fun setValue(thisRef: AbstractMvMStruct, property: KProperty<*>, value: EXPOSED?) {
					if (value == null)
						thisRef.uniqueFields.remove(key)
					else
						thisRef.uniqueFields[key] = transformForWrite(value)
				}
			}
		}
		
		/**
		 * Extend a struct with a field that can only exist a single time per struct.
		 */
		fun <T : Any> singleKeyedValue(key: Any): ReadWriteProperty<AbstractMvMStruct, T?> {
			return object : ReadWriteProperty<AbstractMvMStruct, T?> {
				override fun getValue(thisRef: AbstractMvMStruct, property: KProperty<*>): T? {
					return thisRef.uniqueFields[key] as T?
				}
				
				override fun setValue(thisRef: AbstractMvMStruct, property: KProperty<*>, value: T?) {
					if (value == null)
						thisRef.uniqueFields.remove(key)
					else
						thisRef.uniqueFields[key] = value
				}
			}
		}
		
		/**
		 * A struct that may only appear once in the subtree.
		 *
		 * Note that the only difference between a struct and a named map is that structs have their _own_ names.
		 * As such, there is no way to name these.
		 * If a structure doesn't use its name to determine what kind of structure it is (e.g. [btpos.tf2.popfiledsl.types.spawners.BaseSpawner] and its subclasses),
		 * use [singleKeyedValue] with a [PopFileMap][btpos.tf2.popfiledsl.serialization.PopFileMap]
		 * as its value to allow the parent scope to decide its name.
		 */
		fun <T : IPopFileRepresentable<PopFileEntry>> singleStruct() = object : ReadWriteProperty<AbstractMvMStruct, T?> {
			override fun getValue(thisRef: AbstractMvMStruct, property: KProperty<*>): T? {
				return thisRef.subtrees[property] as T?
			}
			
			override fun setValue(thisRef: AbstractMvMStruct, property: KProperty<*>, value: T?) {
				if (value == null)
					thisRef.subtrees.remove(property)
				else
					thisRef.subtrees[property] = mutableListOf(value)
			}
		}
		
		/**
		 * A struct type that may have multiple instances in this subtree.
		 *
		 * For example:
		 * ```
		 * TFBot
		 * {
		 *  ...
		 * }
		 *
		 * TFBot
		 * {
		 *  ...
		 * }
		 * ```
		 *
		 * Note that the only difference between a struct and a named map is that structs have their _own_ names.
		 * As such, there is no way to name these.
		 * If a structure doesn't use its name to determine what kind of structure it is (e.g. [btpos.tf2.popfiledsl.types.spawners.BaseSpawner] and its subclasses),
		 * use [singleKeyedValue] with a [PopFileMap][btpos.tf2.popfiledsl.serialization.PopFileMap]
		 * as its value to allow the parent scope to decide its name.
		 */
		fun <T : IPopFileRepresentable<PopFileEntry>> multiStruct() = PropertyDelegateProvider<AbstractMvMStruct, ReadOnlyProperty<AbstractMvMStruct, MutableList<T>>> { thisRef, prop ->
			// key not used for serialization, the subtree will have its own identifier
			thisRef.subtrees[prop] = mutableListOf()
			
			ReadOnlyProperty<AbstractMvMStruct, MutableList<T>> { thisRef, prop ->
				thisRef.subtrees[prop] as MutableList<T>
			}
		}
	}
	
	val uniqueFields: MutableMap<Any, Any> = mutableMapOf()
	
	val multiValuePerKeyFields: MutableMap<Any, MutableList<Any>> = mutableMapOf()
	
	val subtrees: MutableMap<KProperty<*>, MutableList<IPopFileRepresentable<PopFileEntry>>> = mutableMapOf()
	
	final override val popFileRepr: PopFileEntry
		get() {
			val mappedUniqueFields = uniqueFields.map { (k, v) ->
				PopFileEntry(k, v)
			}
			
			val mappedMultiFields = multiValuePerKeyFields.flatMap { (key, values) ->
				values.map { PopFileEntry(key, it) }
			}
			
			val mappedSubtrees = subtrees.values.flatten().map { it.popFileRepr }
			
			return PopFileEntry(
				popFileStructIdentifier,
				mappedUniqueFields + mappedMultiFields + mappedSubtrees
			)
		}
	
	abstract val popFileStructIdentifier: Any
}