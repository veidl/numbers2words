plugins {
    id("java")
    id("info.solidsoft.pitest") version "1.9.0"
    id("jacoco")
}

group = "org.example"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

dependencies {
    testImplementation("org.junit.jupiter:junit-jupiter-params:5.9.2")
    testImplementation("org.junit.jupiter:junit-jupiter-api:5.8.1")
    testRuntimeOnly("org.junit.jupiter:junit-jupiter-engine:5.8.1")
}

tasks.test {
    useJUnitPlatform()
    finalizedBy(tasks.jacocoTestReport)

}

tasks.jacocoTestReport {
    dependsOn(tasks.test)
    reports {
        xml.required.set(false)
        csv.required.set(false)
        html.outputLocation.set(layout.buildDirectory.dir("jacocoHtml"))
    }

    classDirectories.setFrom(files(classDirectories.files.map {
        fileTree(it).apply {
            exclude("**/Main.class")
        }
    }))

}

pitest {
    junit5PluginVersion.set("1.0.0")
}
