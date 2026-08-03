package btpos.source.vdfdsl.tf2.filegeneration

import kotlin.collections.iterator

class TFClassHierarchy(map: Map<String, List<String>>) {
	val nodes = HashMap<String, TFClassHierarchyNode>()
	
	init {
		for ((item, children) in map) {
			val newNode = getOrCreateNode(item)
			
			children.forEach { child ->
				newNode.children += getOrCreateNode(child).also {
					it.parents.add(newNode)
				}
			}
		}
	}
	
	
	private fun getOrCreateNode(name: String) = nodes.computeIfAbsent(name.lowercase()) { TFClassHierarchyNode(name) }
	
	fun getNode(name: String): TFClassHierarchyNode? = nodes[name.lowercase()]
	
	class TFClassHierarchyNode(
		val name: String,
		val parents: MutableSet<TFClassHierarchyNode> = mutableSetOf(),
		val children: MutableSet<TFClassHierarchyNode> = mutableSetOf()
	)
	
	fun getAllParents(clsName: String): Sequence<String> {
		val node = getNode(clsName)
		requireNotNull(node) {
			"No entry in hierarchy found for $clsName"
		}
		return generateSequence(sequenceOf(node)) { it.flatMap { it.parents } }
			.flatten()
			.map { it.name }
	}
	
	fun getParent(weaponType: String): String? {
		return this.getNode(weaponType)
			?.parents
			?.let { parents ->
				if (parents.isEmpty())
					null
				else
					parents.singleOrNull()
						?: error("$weaponType has more than one parent: ${parents.map { it.name }}")
			}?.name
	}
	
	
	operator fun contains(string: String): Boolean {
		return string.lowercase() in nodes
	}
	
	fun getDirectChildren(weaponType: String): Collection<String> {
		return getNode(weaponType)?.children?.map { it.name }.orEmpty()
	}
	
	companion object {
	    operator fun invoke(vararg pairs: Pair<String, List<Any>>): TFClassHierarchy {
		    fun List<Any>.recur(rootList: MutableMap<String, MutableList<String>>, outValues: MutableList<String>) {
				for (el in this) {
					if (el is String) {
						outValues += el
					} else if (el is Pair<*, *>) {
						val (key, l) = el as Pair<String, List<Any>>
						outValues += key
						val values = rootList.computeIfAbsent(key) { mutableListOf() }
						l.recur(rootList, values)
					}
				}
			}
		    
		    val rootMap = mutableMapOf<String, MutableList<String>>()
		    pairs.forEach { (key, values) ->
				val x = mutableListOf<String>()
				values.recur(rootMap, x)
			    rootMap[key] = x
		    }
		    
		    return TFClassHierarchy(rootMap)
	    }
	}
}