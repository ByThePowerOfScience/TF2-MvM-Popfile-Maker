
plugins {
	id("general-convention")
	kotlin("plugin.allopen") version libs.versions.kotlin
}

group = "btpos.source.vdfdsl"
version = "1.0-SNAPSHOT"

repositories {
	mavenCentral()
	
	flatDir {
		dir("./libs")
	}
}


dependencies {
	api("btpos.source.vdfdsl.vdf:vdf-modeling:1.0-SNAPSHOT")
	api("btpos.source.vdfdsl.vdf:vdf-parser:1.0-SNAPSHOT")
	api("btpos.source.vdfdsl.tf2:TF2Items:1.0-SNAPSHOT")
}

// make every single thing extensible so people can add as many utilities as they want
allOpen {
	annotation("btpos.source.vdfdsl.tf2.PopFileDSL")
	// annotations("com.another.Annotation", "com.third.Annotation")
}