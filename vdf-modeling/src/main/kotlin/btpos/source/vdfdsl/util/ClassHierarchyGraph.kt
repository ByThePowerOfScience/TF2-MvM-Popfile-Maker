package btpos.source.vdfdsl.util

import kotlin.reflect.KClass
import kotlin.reflect.full.isSubclassOf
import kotlin.reflect.full.isSuperclassOf
import kotlin.reflect.full.superclasses

/**
 * Bidirectional graph from root downward, with multiple possible parents for each child.
 */
class ClassHierarchyGraph
{
	private val navMap: MutableMap<KClass<*>, Node> = HashMap()
	
	val entries: Map<KClass<*>, Node> get() = navMap
	
	private val root = Node(Any::class)
	
	init {
		navMap[Any::class] = root
	}
	
	class Node(val cls: KClass<*>) {
		val parents = mutableSetOf<Node>()
		val children = mutableSetOf<Node>()
		
		fun getAllParents(): Sequence<KClass<*>> {
			return parents.asSequence().map { it.cls } + parents.asSequence().flatMap { it.getAllParents() }
		}
		
		override fun hashCode(): Int {
			return cls.hashCode()
		}
		
		override fun equals(other: Any?): Boolean {
			return other != null && (other === this || (other is Node && other.cls == this.cls))
		}
	}
	
	private fun getOrCreateNode(cls: KClass<*>): Node {
		navMap[cls]?.let {
			return it;
		}
		
		// jsut fuckin add all parents all the way up to the root, screw memory im so fucking sick fo making industry grade bullshit for a personal project that tbh not a single fucking person is going to use anyway so what the fuck ever
		fun recurse(currClass: KClass<*>): Node {
			val newNode = Node(currClass)
			navMap[currClass] = newNode
			
			currClass.superclasses.forEach { sup ->
				connect((navMap[sup] ?: recurse(sup)), newNode)
			}
			
			return newNode
		}
		
		return recurse(cls)
	}
	
	private fun connect(parent: Node, child: Node) {
		parent.children += child
		child.parents += parent
	}
	
	private fun getOrCreateNodeOld(cls: KClass<*>): Node {
		navMap[cls]?.let {
			return it;
		}
		
		val newNode = Node(cls)
		navMap[cls] = newNode
		
		/*
		start: insert the node as a child of root
		if its parent is a direct superclass of it, don't move it from the parent. it can have multiple links to it, no worries.
		if none of its siblings are subclasses or superclasses of it, we're good
		if any of its siblings are subclasses of it:
		 - if that sibling is already under its direct parent, copy them from the parent to be children of it
		 - else do the same but remove them from the original parent
		if any of its siblings are superclasses of it, move this from the parent to be a child of those siblings
		 */
		val alreadyChecked = mutableSetOf<Node>()
		
		fun foo(currParent: Node) {
			require(currParent.cls.isSuperclassOf(cls)) {
				"Failed sanity check: currParent was not a parent of the new class"
			}
			
			if (currParent in alreadyChecked)
				return;
			
			alreadyChecked += currParent
			
			if (currParent.children.none { it.cls.isSubclassOf(cls) || it.cls.isSuperclassOf(cls) }) {
				currParent.children.add(newNode)
				newNode.parents.add(currParent)
				return;
			}
			
			if (currParent.cls in cls.superclasses)
				currParent.children.add(newNode)
			
			currParent.children.forEachWithIter {
				if (it.cls == cls)
					return@forEachWithIter;
				else if (it.cls.isSubclassOf(cls)) {
					newNode.children.add(it)
					if (currParent.cls !in it.cls.superclasses)
						remove()
				} else if (it.cls.isSuperclassOf(cls)) {
					foo(it)
				}
			}
		}
		
		foo(root)
		
		if (cls.java.isInterface) {
			// check all currently-added classes to see if they extend it too
			navMap.forEach { (itsClass, itsNode) ->
				if (cls in itsClass.superclasses) {
					itsNode.addParent(newNode)
				}
			}
		}
		
		
		println("After adding ${cls.simpleName}:")
		println(this.toGraph())
		println()
		
		return newNode
	}
	
	private fun Node.addParent(newParent: Node) {
		parents.forEach {
			if (it != root && it.cls.isSuperclassOf(newParent.cls)) {
				// insert between the two
				it.children.remove(this)
				it.children.add(newParent)
				newParent.children.add(this)
			}
		}
		parents.add(newParent)
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
		return getOrCreateNode(cls).children.asSequence().map { it.cls }
	}
	
	inline fun <reified T : Any> get(): Node = get(T::class)
	
	operator fun get(kClass: KClass<*>): Node = entries[kClass] ?: error("No node found for ${kClass.qualifiedName}.")
}

fun ClassHierarchyGraph.toGraph(): String {
	val sb = StringBuilder()
	entries.forEach { entry ->
		entry.value.children.forEach { child ->
			sb.append(entry.key.simpleName).append("->").appendLine(child.cls.simpleName)
		}
	}
	return sb.lineSequence().sorted().joinToString("\n")
}