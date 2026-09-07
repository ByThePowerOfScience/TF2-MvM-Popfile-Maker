package btpos.source.vdfdsl.util

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test
import kotlin.random.Random
import kotlin.reflect.KClass
import kotlin.reflect.full.superclasses
import kotlin.test.assertNotNull

class ClassHierarchyGraphTest {
	interface IItf
	interface IItf2 : IItf
	
	interface IUnrelated
	
	open class Foo
	open class Bar : Foo(), IItf, IItf2
	open class Baz : Foo(), IUnrelated
	open class Qux : Baz(), IItf2
	
	
	/*
	Expected:
	Any->Foo
	Any->IItf
	Any->IItf2
	Any->IUnrelated
	IItf->IItf2
	IItf->Bar
	IItf2->Bar, Qux
	IUnrelated->Baz
	Foo->Bar
	Foo->Baz
	Baz->Qux
	 */
	
	val iitf = IItf::class
	val iitf2 = IItf2::class
	val iunrelated = IUnrelated::class
	val foo = Foo::class
	val bar = Bar::class
	val baz = Baz::class
	val qux = Qux::class
	val any = Any::class
	
	
	val items = listOf(iitf, iitf2, iunrelated, foo, bar, baz, qux)
	
	@Test
	fun add() {
		val x = ClassHierarchyGraph()
		
		items.shuffled(Random(1)).forEach(x::add)
		
		validate(x)
	}
	
	@Test
	fun add2() {
		val x = ClassHierarchyGraph()
		
		items.shuffled(Random(2)).forEach(x::add)
		
		validate(x)
	}
	
	@Test
	fun add3() {
		val x = ClassHierarchyGraph()
		
		items.shuffled(Random(3)).forEach(x::add)
		
		validate(x)
	}
	
	@Test
	fun add4() {
		val x = ClassHierarchyGraph()
		
		items.shuffled(Random(4)).forEach(x::add)
		
		validate(x)
	}
	
	private fun validate(x: ClassHierarchyGraph) {
		println(x.toGraph())
		
		x.checkChildren(
			any,
			iitf,
			foo,
			iunrelated,
			iitf2
		)
		x.checkChildren(
			iitf,
			iitf2, bar
		)
		x.checkChildren(
			iitf2,
			bar, qux
		)
		x.checkChildren(
			iunrelated,
			baz
		)
		x.checkChildren(
			foo,
			bar, baz
		)
		x.checkChildren(
			bar
		)
		x.checkChildren(
			baz,
			qux
		)
		
		
		x.checkParents(
			iitf,
			any
		)
		x.checkParents(
			iitf2,
			iitf,
			any
		)
		x.checkParents(
			iunrelated,
			any
		)
		x.checkParents(
			foo,
			any
		)
		x.checkParents(
			bar,
			foo, iitf, iitf2
		)
		x.checkParents(
			baz,
			foo, iunrelated
		)
		x.checkParents(
			qux,
			baz, iitf2
		)
	}
	
	fun ClassHierarchyGraph.checkChildren(cls: KClass<*>, vararg classes: KClass<*>) {
		assertEquals(
			setOf(*classes),
			assertNotNull(this[cls], "${cls.simpleName} Node").children.classes,
			"Children of ${cls.simpleName}"
		)
	}
	fun ClassHierarchyGraph.checkParents(cls: KClass<*>, vararg classes: KClass<*>) {
		assertEquals(
			setOf(*classes),
			assertNotNull(this[cls], "${cls.simpleName} Node").parents.classes,
			"Parents of ${cls.simpleName}"
		)
	}
	
	val Set<ClassHierarchyGraph.Node>.classes get() = this.mapTo(mutableSetOf()) { it.cls }
	
	
	
	@Test
	fun getParentsRecursive() {
	}
	
	@Test
	fun getChildren() {
	}
	
}