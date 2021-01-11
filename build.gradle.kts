plugins {
    id("org.jetbrains.kotlin.js") version "1.4.21"
    id("maven-publish")
}

val version_major: String by project
val version_minor: String by project
val version_patch: String by project
val kotlin_version: String by project


group = "dev.chriskrueger"
version = "$version_major.$version_minor.$version_patch"

repositories {
    mavenCentral()
    jcenter()
    maven("https://kotlin.bintray.com/kotlinx")
    maven("https://dl.bintray.com/chriskrueger/maven")
}

base {
    archivesBaseName = "kotlin-firebase-admin"
}

kotlin {
    js {
        nodejs()
    }
}


dependencies {
    implementation(kotlin("stdlib-js"))
    implementation("dev.chriskrueger:kotlin-express:1.0.4")
}

val sourcesJar by tasks.creating(Jar::class) {
    archiveClassifier.set("sources")
    from("$projectDir/src")
}

publishing {
    //    https://github.com/gradle/gradle/issues/11412#issuecomment-555413327
    System.setProperty("org.gradle.internal.publish.checksums.insecure", "true")

    repositories {
        maven {
            name = "bintray"
            setUrl("https://api.bintray.com/maven/chriskrueger/maven/kotlin-firebase-admin/;publish=1;override=1")

            credentials {
                username = findProperty("BINTRAY_USER") as String?
                password = findProperty("BINTRAY_API_KEY") as String?
            }
        }
    }

    publications {
        create<MavenPublication>("mavenJava") {
            groupId = project.group.toString()
            artifactId = "kotlin-firebase-admin"
            version = "$version_major.$version_minor.$version_patch"
            artifact(sourcesJar)
            from(components["kotlin"])

            pom {
                name.set(project.name)
                description.set("Kotlin wrapper for Firebase Admin.")
                url.set("https://github.com/chrisnkrueger/${project.name}")
                inceptionYear.set("2020")
                packaging = "jar"

                developers {
                    developer {
                        id.set("chriskrueger")
                        name.set("Christian Krüger")
                        email.set("christian.krueger@moviebase.app")
                    }
                }
                licenses {
                    license {
                        name.set("The Apache Software License, Version 2.0")
                        url.set("http://www.apache.org/licenses/LICENSE-2.0.txt")
                    }
                }
                issueManagement {
                    system.set("GitHub Issues")
                    url.set("https://github.com/chrisnkrueger/${project.name}/issues")
                }
                scm {
                    connection.set("scm:git:https://github.com/chrisnkrueger/${project.name}.git")
                    developerConnection.set("scm:git:git@github.com:chrisnkrueger/${project.name}.git")
                    url.set("https://github.com/chrisnkrueger/${project.name}")
                }
            }
        }
    }
}
