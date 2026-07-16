import org.jetbrains.kotlin.gradle.utils.extendsFrom

plugins {
	id("general-convention")
	kotlin("plugin.allopen") version libs.versions.kotlin
//	alias(libs.plugins.shadow)
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
//
//publishing {
//	publications {
//		create<MavenPublication>("mavenJava") {
//			from(components["java"])
//		}
//	}
//}


tasks.publishToMavenLocal {
	dependsOn(listOf("TF2Items", "vdf-modeling", "vdf-parser").map { gradle.includedBuild(it).task(":publishToMavenLocal") })
}