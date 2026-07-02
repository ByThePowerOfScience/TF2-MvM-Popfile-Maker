
plugins {
	id("general-convention")
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