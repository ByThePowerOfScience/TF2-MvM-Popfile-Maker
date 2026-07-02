import dev.clojurephant.plugin.clojure.ClojureExtension
import org.gradle.cache.internal.streams.DefaultValueStore.encoding

plugins {
	id("general-convention")
	id("dev.clojurephant.clojure")
}


repositories {
	maven {
		name = "Clojars"
		url = uri("https://repo.clojars.org/")
	}
}

val clojure: ClojureExtension get() = extensions.getByType()
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

dependencies {
	implementation("org.clojure:clojure:1.11.1")
	testRuntimeOnly("dev.clojurephant:jovial:0.4.2")
	devImplementation("org.clojure:tools.namespace:1.3.0")
	
}
