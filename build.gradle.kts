plugins {
    id("org.jetbrains.kotlin.js") version Versions.kotlin
    id("io.github.gradle-nexus.publish-plugin") version Versions.nexus
    id("maven-publish")
    id("signing")
}

group = "dev.chriskrueger"
version = Versions.versionName

nexusPublishing {
    repositories {
        sonatype {
            nexusUrl.set(uri("https://s01.oss.sonatype.org/service/local/"))
            snapshotRepositoryUrl.set(uri("https://s01.oss.sonatype.org/content/repositories/snapshots/"))
            username.set(findProperty("SONATYPE_USER") as String?)
            password.set(findProperty("SONATYPE_PASSWORD") as String?)
            stagingProfileId.set(findProperty("SONATYPE_STAGING_PROFILE_ID_CHRISKRUEGER") as String?)
        }
    }
}

repositories {
    google()
    gradlePluginPortal()
    mavenCentral()
    mavenLocal()
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
    implementation("dev.chriskrueger:kotlin-express:1.1.1")
}

val sourcesJar by tasks.creating(Jar::class) {
    archiveClassifier.set("sources")
    from("$projectDir/src")
}

publishing {
    publications {
        create<MavenPublication>("mavenJava") {
            artifact(sourcesJar)
            from(components["kotlin"])

            pom {
                name.set("kotlin-firebase-admin")
                description.set("Kotlin wrapper for Firebase Admin.")
                url.set("https://github.com/chrisnkrueger/kotlin-firebase-admin")
                inceptionYear.set("2021")
                packaging = "jar"

                developers {
                    developer {
                        id.set("chrisnkrueger")
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
                    url.set("https://github.com/chrisnkrueger/kotlin-firebase-admin/issues")
                }
                scm {
                    connection.set("scm:git:https://github.com/chrisnkrueger/kotlin-firebase-admin.git")
                    developerConnection.set("scm:git:git@github.com:chrisnkrueger/kotlin-firebase-admin.git")
                    url.set("https://github.com/chrisnkrueger/kotlin-firebase-admin")
                }
            }
        }
    }
}

signing {
    sign(publishing.publications)
}

