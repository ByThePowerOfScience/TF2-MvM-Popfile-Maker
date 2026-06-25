import org.gradle.internal.impldep.org.apache.http.client.methods.RequestBuilder.options
import org.jetbrains.kotlin.gradle.targets.js.npm.importedPackageDir
import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
	kotlin("jvm")
	id("dev.clojurephant.clojure")
	id("com.github.gmazzo.buildconfig") version "6.0.10"
}

group = "btpos.tf2.popfiledsl.itemattributesgenerator"
version = "1.0-SNAPSHOT"

repositories {
	mavenCentral()
	maven {
		name = "Clojars" // name can be ommitted, but is helpful in troubleshooting
		url = uri("https://repo.clojars.org/")
	}
}

dependencies {
	implementation ("org.clojure:clojure:1.11.1")
	// and any other dependencies you want on the compile classpath
	// implementation 'group:artifact:version'
	
	// needed for test integration
	testRuntimeOnly ("dev.clojurephant:jovial:0.4.2")
	// and any other test-specific dependencies
	// testImplementation 'group:artifact:version'
	
	// dependencies for REPL use only
	devImplementation("org.clojure:tools.namespace:1.3.0")
	testImplementation(kotlin("test"))
}

buildConfig {
	buildConfigField("String", "WIKI_TABLE_FILE", projectDir.toPath().resolve("wikitable.txt").toString().let { "\"$it\"" })
	buildConfigField("String", "MY_NOTES_FILE", projectDir.toPath().resolve("mynotes.md").toString().let { "\"$it\"" })
	buildConfigField("String", "GENERATED_FILES_DIR", "\"${rootProject.project(":Extensions:TF2ItemAttributes").projectDir.toPath().resolve("src/main/kotlin")}\"")
	buildConfigField("String", "GENERATED_FILE_PACKAGE", "\"btpos.tf2.popfiledsl.tf2.itemattributes\"")
}

kotlin {
	jvmToolchain(21)
}

clojure {
	builds {
		named("main") {
			// remove java from clojure classpath to prevent circular dependency
			classpath.setFrom(sourceSets.main.map { it.compileClasspath })
			classpath.from(project.layout.buildDirectory.dir("classes/kotlin/main"))
			aotAll()
			
			reflection = "warn"
			
			compiler {
				directLinking = true
			}
		}
	}
}

tasks.test {
	useJUnitPlatform()
}
tasks {
	compileJava {
		// allow importing clojure classes from java
		classpath += files(sourceSets.main.map { it.clojure.classesDirectory })
		
		options.apply {
			encoding = "UTF-8"
		}
	}
	compileKotlin {
	
	}
	checkClojure {
		dependsOn(compileKotlin)
	}
	compileClojure {
		dependsOn(compileKotlin)
	}
}

val compileKotlin: KotlinCompile by tasks
compileKotlin.compilerOptions {
	freeCompilerArgs.set(listOf("-Xcontext-parameters"))
}