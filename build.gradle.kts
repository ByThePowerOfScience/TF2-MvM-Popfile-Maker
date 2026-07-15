
plugins {
	id("general-convention")
	kotlin("plugin.allopen") version libs.versions.kotlin
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

// make every single thing extensible so people can add as many utilities as they want
allOpen {
	annotation("btpos.source.vdfdsl.tf2.PopFileDSL")
}