package btpos.source.vdfdsl.tf2.filegeneration

import btpos.source.vdfdsl.tf2.filegeneration.TF2ItemGeneration.BuildConfig
import btpos.source.vdfdsl.vdfparser.EmptyLine
import btpos.source.vdfdsl.vdfparser.KeyValueWithEndOfLineComment
import btpos.source.vdfdsl.vdfparser.LineWithOnlyComment
import btpos.source.vdfdsl.vdfparser.ParseVDF
import btpos.source.vdfdsl.vdfparser.PragmaLineWithComment
import btpos.source.vdfdsl.vdfparser.RawKeyValue_TableWithSurroundingComments
import btpos.source.vdfdsl.vdfparser.RawLine
import btpos.source.vdfdsl.vdfparser.RawTable
import java.io.File
import java.nio.file.Files
import java.nio.file.Path
import kotlin.collections.iterator
import kotlin.io.path.Path
import kotlin.io.path.absolutePathString
import kotlin.io.path.bufferedWriter
import kotlin.io.path.createDirectories
import kotlin.io.path.createParentDirectories
import kotlin.io.path.inputStream
import kotlin.io.path.isDirectory
import kotlin.io.path.name
import kotlin.io.path.useDirectoryEntries

fun prompt(msg: String): String? {
	print(msg)
	return readlnOrNull()?.takeIf { it.isNotBlank() }
}

/**
 * @param getError take in response, return either an error that should be displayed to the user before repeating the prompt, or null if response is good
 */
inline fun promptWithCheck(msg: String, allowEmpty: Boolean = true, getError: String.() -> String?): String? {
	var response: String?
	do {
		response = prompt(msg)
		if (response == null) {
			if (allowEmpty) {
				return null;
			}
		}
		else
			getError(response)?.let { println(it) }
				?: return response
	} while (true)
}

inline fun promptWithCheckNotEmpty(msg: String, getError: String.() -> String?): String {
	return promptWithCheck(msg, allowEmpty = false, getError) as String
}

fun emitTemplateString(name: String, fileRef: String): String {
	return BuildConfig.POPFILETEMPLATE_CTOR.replace("{NAME}", "\"$name\"").replace("{BASE}", fileRef)
}

fun Appendable.writeDocComment(lines: Iterable<String>, indent: Int) {
	append("/**")
	val ind = "\t".repeat(indent)
	lines.forEach {
		append("\n").append(ind).append(" * ").append(it)
	}
	append("\n").append(ind).append(" */")
}

fun Appendable.writeComment(comment: String) {
	append("// ").append(comment).appendLine()
}

inline fun MutableList<String>.flush(action: (String) -> Unit) {
	this.forEach { action(it) }
	this.clear()
}


fun main() {
	println("Current working directory: ${Path("").absolutePathString()}")
	val popfileLoc = promptWithCheckNotEmpty("Enter popfile location (or directory for multiple at once): ") {
		runCatching { Path.of(this) }
			.onSuccess {
				if (!Files.exists(it))
					return@promptWithCheckNotEmpty "File not found: $it"
			}
			.exceptionOrNull()?.message
		
	}.let { Path.of(it) }
	
	val popfileName = if (!popfileLoc.isDirectory()) {
		popfileLoc.name.let { defaultFileName ->
			promptWithCheck(
				"What should this popfile be referred to as in #base? (Default: ${defaultFileName}): ",
				allowEmpty = true
			) {
				when {
					contains(Regex("\\s")) -> "Name must not contain whitespace."
					else -> null
				}
			} ?: defaultFileName
		}
	} else null
	
	val outFolder = Path("").let { defaultPath ->
		promptWithCheck("What folder should the file(s) be written to? (Default: ${defaultPath.absolutePathString()}: ", allowEmpty = true) {
			runCatching { Path.of(this) }.exceptionOrNull()?.message
		}?.let { Path.of(it) } ?: defaultPath
	}
	
	val useRobotName: Boolean = (promptWithCheck("Use the name of the robot instead of the template name? (e.g. \"COLONEL_BARRAGE\" instead of \"SLOWBARRAGE\") [Y/n]: ", allowEmpty = true) {
		if (this.lowercase().let { it != "y" && it != "n" }) {
			"Must be 'y' or 'n'."
		} else null
	} ?: "y") == "y"
	
	val prefixToDiscard = run {
		if (useRobotName) {
			""
		} else
			prompt("What prefix should be discarded when generating names? (e.g. `T_TFBot_` turns \"T_TFBot_Sniper_Razorback\" into \"Sniper_Razorback\") [default = none]: ")
	}
	
	val groupByClass: Boolean = (promptWithCheck("Group entries by class? [Y/n]: ", allowEmpty = true) {
		if (this.lowercase().let { it != "y" && it != "n" }) {
			"Must be 'y' or 'n'."
		} else null
	} ?: "y") == "y"
	
	
	
	val pkgName = "${BuildConfig.BASE_PACKAGE}.templates".let { defaultPackage ->
		promptWithCheck("What package (file path but for code) should the files be put in? (defaults to ${defaultPackage}): ", allowEmpty = true) {
			if (any { !it.isLetterOrDigit() } || split(".").any { it[0].isDigit() })
				"Invalid package name. Must only contain letters or digits separated by periods, and may not have a number as the first letter of a package name."
			else null
		} ?: defaultPackage
	}
	
	
//	val templates = parsedPopFile.firstOrNull { it is KeyValueWithEndOfLineComment && it.kv.key == "WaveSchedule" }.let {
//		it?.asSubtree ?: error("No WaveSchedule subtree found.")
//	}["Templates"].let {
//		it?.asSubtree ?: error("No WaveSchedule.Templates subtree found.")
//	}
	
	
	
	
	
	
	if (popfileName == null) {
		// we're working with a folder of files, every one of them has the name they're going to have
		assert(popfileLoc.isDirectory())
		val outfolder = outFolder.resolve(pkgName.replace('.', File.separatorChar)).createDirectories()
		popfileLoc.useDirectoryEntries { seq ->
			seq.forEach { popfileLoc ->
				val popfileName = popfileLoc.name
				val friendlyName = popfileName.substringBefore('.').camelCase().capitalize()
				outfolder.resolve("${friendlyName}Templates.kt").bufferedWriter().use { out ->
					val parsedPopFile = ParseVDF.directRepresentation(popfileLoc.inputStream()).iterator()
					
					context (TemplateGenerationSettings(popfileName, friendlyName, prefixToDiscard.orEmpty(), groupByClass, packageName = pkgName, useRobotName)) {
						out.writeObject(parsedPopFile)
					}
				}
			}
		}
	}
	else {
		val friendlyName = popfileName.substringBefore('.').camelCase().capitalize()
		val outfile = outFolder.resolve(pkgName.replace('.', File.separatorChar)).resolve("${friendlyName}Templates.kt")
		
		prompt("Preparing to write to ${outfile.absolutePathString()}. Continue? [Y/n]").let {
			if (!(it == null || it.lowercase() == "y"))
				println("Cancelling.")
		}
		
		outfile.createParentDirectories().bufferedWriter().use { out ->
			context (TemplateGenerationSettings(popfileName, friendlyName, prefixToDiscard.orEmpty(), groupByClass, packageName = pkgName, useRobotName)) {
				val parsedPopFile = ParseVDF.directRepresentation(popfileLoc.inputStream()).iterator()
				
				out.writeObject(parsedPopFile)
			}
		}
	}
	
	println("\nComplete.")
	/*
	Steps:
		1. Parse a popfile
		2. Extract the "Templates" field
		3. Convert all keys into Template objects, given the name of the base file
	 */
}
data class TemplateGenerationSettings(
	val fileName: String,
	val friendlyName: String,
	val prefixToDiscard: String,
	val groupByClass: Boolean,
	val packageName: String,
	/**
	 * Use the Name field of the robot instead of the template name.  Ignores prefix.
	 */
	val useRobotName: Boolean,
)

data class TemplateEntry(val precedingComments: List<String>, val kv: RawKeyValue_TableWithSurroundingComments) {
	context(settings: TemplateGenerationSettings)
	fun getVariableName(className: String?): String {
		run {
			if (settings.useRobotName) {
				val robotNameField = kv.table.getString("Name")
				                     ?: return@run;
				
				return '`' + robotNameField + '`'
			}
		}
		
		return kv.key.uppercase().removePrefix(settings.prefixToDiscard.uppercase()).let { varName ->
			(if (className != null) {
				val classNameRegex = Regex("""(?:\b|_)${className.uppercase()}(?:\b|_)""")
				varName.replace(classNameRegex, "_")
			} else varName).replace("__", "_").trim('_').ifBlank { varName }
		}
	}
	
	context(settings: TemplateGenerationSettings)
	fun writeVariable(appendable: Appendable, className: String?, indent: Int) = with (appendable) {
		writeDocComment(precedingComments, indent)
		+"\n" + "\t".repeat(indent) + "val " + getVariableName(className) + " = " + emitTemplateString(kv.key, "baseRef")
	}
}

context(settings: TemplateGenerationSettings)
fun Appendable.writeObject(parsedPopFile: Iterator<RawLine>) {
	+"package " + settings.packageName + "\n\n"
	
	var curr: RawLine? = null
	
	// print all top-level comments
	for (line in parsedPopFile) {
		curr = line
		when (curr) {
			is PragmaLineWithComment -> continue;
			is EmptyLine -> appendLine()
			is LineWithOnlyComment -> append("// ").append(curr.comment).appendLine()
			is KeyValueWithEndOfLineComment -> break;
		};
	}
	
	// stopped on first keyvalue:
	if (curr !is KeyValueWithEndOfLineComment // reached EOF
	    || curr.kv.key != "WaveSchedule")
		error("No WaveSchedule found in file.")
	
	val templatesBlock: RawTable = (curr.kv.value.subtreeOrNull().let {
		it ?: error("WaveSchedule is not a subtree.")
	}.firstOrNull { it is KeyValueWithEndOfLineComment && it.kv.key == "Templates" }.let {
		it ?: error("No WaveSchedule.Templates entry found in file.")
	} as KeyValueWithEndOfLineComment).kv.value.subtreeOrNull().let {
		it ?: error("WaveSchedule.Templates is not a subtree.")
	}
	
	val currentConsecutiveComments = mutableListOf<String>()
	
	
	
	val templates = mutableListOf<TemplateEntry>()
	
	for (line in templatesBlock) {
		when (line) {
			is KeyValueWithEndOfLineComment -> {
				line.eolComment?.let {
					currentConsecutiveComments += it
				}
				val kv = line.kv as? RawKeyValue_TableWithSurroundingComments ?: error("Template entry '${line.kv.key}' is not a table")
				
				templates += TemplateEntry(currentConsecutiveComments.toList(), kv)
				currentConsecutiveComments.clear()
			}
			// collect comments for either a doc comment or free-floating comment
			is LineWithOnlyComment -> currentConsecutiveComments += line.comment
			// assume descriptor comments won't be on a newline
			is EmptyLine -> {
				currentConsecutiveComments.flush { append('\t').writeComment(it) }
			}
			is PragmaLineWithComment -> continue;
		}
	}
	
	val seq = templates.asSequence().map { (precedingComments, kv) ->
		val docComment = buildList {
			addAll(precedingComments)
			if (precedingComments.isNotEmpty())
				add("")
			
			kv.keyEOLComment?.let {
				add(it)
				add("")
			}
			
			
			addAll(kv.afterKeyBeforeBraceComments)
			if (kv.afterKeyBeforeBraceComments.isNotEmpty())
				add("")
			
			kv.openBracketEOLComment?.let {
				add(it)
				add("")
			}
			
			add("```")
			addAll(kv.printRaw(0).lines())
			add("```")
		}
		
		TemplateEntry(docComment, kv)
	}
	
	val objectName = settings.friendlyName + "Templates"
	val baseRefName = "baseRef"
	
	append("object ") + objectName + " {\n"
	append("\tprivate const val ") + baseRefName + " = \"" + settings.fileName + "\"\n\n"
	
	if (settings.groupByClass) {
		val byClass = seq.groupBy { it.kv.table.getString("Class")?.lowercase() }
		
		// things without classes go on top level
		byClass[null]?.forEach { v ->
			+"\n\n\t"
			v.writeVariable(this, null, 1)
		}
		
		byClass.forEach { (cls, templates) ->
			if (cls == null)
				return@forEach;
			
			+"\n\n\tobject " + cls.capitalize() + " {"
			templates.forEach {
				+"\n\n\t\t"
				it.writeVariable(this, cls, 2)
			}
			
			+"\n\t}"
		}
	} else {
		seq.forEach { v ->
			+"\n\n\t"
			v.writeVariable(this, null, 1)
		}
	}
	+"\n\t}"
}