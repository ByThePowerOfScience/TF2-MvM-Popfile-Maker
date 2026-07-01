import org.gradle.internal.impldep.org.apache.http.client.methods.RequestBuilder.options
import org.gradle.kotlin.dsl.implementation
import org.gradle.kotlin.dsl.invoke
import org.gradle.kotlin.dsl.kotlin
import org.gradle.kotlin.dsl.testRuntimeOnly
import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
	id("general-convention")
	id("dev.clojurephant.clojure") version "0.9.1"
}

group = "btpos.source.vdfdsl"
version = "1.0-SNAPSHOT"

repositories {
	mavenCentral()
	maven {
		name = "Clojars" // name can be ommitted, but is helpful in troubleshooting
		url = uri("https://repo.clojars.org/")
	}
	maven(url="https://libraries.minecraft.net")
	
}

dependencies {
	implementation ("org.clojure:clojure:1.11.1")
	testRuntimeOnly ("dev.clojurephant:jovial:0.4.2")
	devImplementation("org.clojure:tools.namespace:1.3.0")
	
	
	testImplementation(kotlin("test"))
	api("btpos.source.vdfdsl.vdf:vdf-modeling:1.0-SNAPSHOT")
	api("btpos.source.vdfdsl.vdf:vdf-parser:1.0-SNAPSHOT")
	api("btpos.source.vdfdsl.tf2:TF2Items:1.0-SNAPSHOT")
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
//			aotAll()
			
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