package btpos.source.vdfdsl.util

import kotlin.reflect.KClass
import kotlin.reflect.full.superclasses

/**
 * Monodirectional graph from root downward, with multiple possible parents for each child.
 */
class ClassHierarchyGraph() {
	private val navMap = HashMap<KClass<*>, Node>()
	
	private val root = Node(Any::class)
	
	init {
		navMap[Any::class] = root
	}
	
	data class Node(val value: KClass<*>) {
		val parents = mutableSetOf<Node>()
		val children = mutableSetOf<Node>()
		
		fun getAllParents(): Sequence<KClass<*>> {
			return parents.asSequence().map { it.value } + parents.asSequence().flatMap { it.getAllParents() }
		}
	}
	
	private fun getOrCreateNode(cls: KClass<*>): Node {
		navMap[cls]?.let {
			return it;
		}
		
		val newNode = Node(cls)
		navMap[cls] = newNode
		cls.superclasses.forEach { parent ->
			newNode.parents += getOrCreateNode(parent).also {
				it.children += newNode
			}
		}
		return newNode
	}
	
	fun add(cls: KClass<*>) {
		if (cls in navMap)
			return;
		
		getOrCreateNode(cls)
	}
	
	/**
	 * Returns all parent classes of this class in a breadth-first search.
	 */
	fun getParentsRecursive(cls: KClass<*>): Sequence<KClass<*>> {
		return getOrCreateNode(cls).getAllParents()
	}
	
	fun getChildren(cls: KClass<*>): Sequence<KClass<*>> {
		return getOrCreateNode(cls).children.asSequence().map { it.value }
	}
}