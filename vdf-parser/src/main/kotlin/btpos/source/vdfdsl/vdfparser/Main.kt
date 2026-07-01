package btpos.source.vdfdsl.vdfparser

fun main() {
	val testfile = ClassLoader.getSystemClassLoader().getResourceAsStream("attributes.txt")!!.readAllBytes().toString(Charsets.UTF_8)
	
	VdfParser.parse(testfile).let { println(it) }//.take(12).forEach(::println)
}