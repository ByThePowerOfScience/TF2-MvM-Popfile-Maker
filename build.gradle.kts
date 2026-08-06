import org.gradle.kotlin.dsl.kotlin
import org.gradle.kotlin.dsl.`maven-publish`
import org.jetbrains.kotlin.gradle.utils.extendsFrom

plugins {
	id("general-convention")
	kotlin("plugin.allopen") version libs.versions.kotlin
	kotlin("plugin.assignment") version libs.versions.kotlin
	`maven-publish`
}

group = "btpos.source.vdfdsl"
version = Constants.PROJECT_VERSION

repositories {
	mavenCentral()
	
	flatDir {
		dir("./libs")
	}
}


dependencies {
	api("btpos.source.vdfdsl.vdf:vdf-modeling:${Constants.PROJECT_VERSION}")
	api("btpos.source.vdfdsl.vdf:vdf-parser:${Constants.PROJECT_VERSION}")
	api("btpos.source.vdfdsl.tf2:TF2Items:${Constants.PROJECT_VERSION}")
	implementation(kotlin("reflect"))
}
/*

configurations {
	compileClasspath.extendsFrom(shadow)
	runtimeClasspath.extendsFrom(shadow)
	testCompileClasspath.extendsFrom(compileClasspath)
	testRuntimeClasspath.extendsFrom(runtimeClasspath)
	
	runtimeElements {
		outgoing.artifacts.clear()
	}
}

artifacts {
	add(configurations.runtimeElements.name, tasks.shadowJar)
}
*/

// make every single thing extensible so people can add as many utilities as they want
allOpen {
	annotation("btpos.source.vdfdsl.tf2.PopFileDSL")
}

assignment {
	annotation("btpos.source.vdfdsl.tf2.itemattributes.SupportsCustomAssignment")
}
//
//publishing {
//	publications {
//		create<MavenPublication>("mavenJava") {
//			from(components["java"])
//		}
//	}
//}

assignment {
	annotations("btpos.source.vdfdsl.SupportsCustomAssignment")
}


tasks.publishToMavenLocal {
	dependsOn(listOf("TF2Items", "vdf-modeling", "vdf-parser").map { gradle.includedBuild(it).task(":publishToMavenLocal") })
}