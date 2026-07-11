package btpos.source.vdfdsl.vdfparser

import btpos.source.vdfdsl.vdfparser.antlr.VDFBaseVisitor
import btpos.source.vdfdsl.vdfparser.antlr.VDFLexer
import btpos.source.vdfdsl.vdfparser.antlr.VDFParser
import org.antlr.v4.runtime.CharStreams
import org.antlr.v4.runtime.CommonTokenStream
import java.nio.file.Files
import kotlin.io.path.Path
import kotlin.let

fun main() {
	val testfile = Files.newInputStream(Path("/home/impro_000/IdeaProjects/TF2/PopFileDSL/mvm_coaltown_expert1.pop"))
	
	println(ParseVDF.parse(testfile))
	
	testfile.close()
}