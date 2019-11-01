group = RELEASE_GROUP
version = RELEASE_VERSION

plugins {
    kotlin("jvm")
    dokka()
    `bintray-release`
}

sourceSets {
    get("main").java.srcDir("src")
    get("test").java.srcDir("tests/src")
}

ktlint { add ->
    add(project(":ruleset:all"))
}

dependencies {
    api(kotlin("stdlib"))

    testImplementation(project(":testing:fx"))
    testImplementation(kotlinx("coroutines-javafx", VERSION_COROUTINES))
}

tasks {
    withType<org.jetbrains.kotlin.gradle.tasks.KotlinCompile> {
        kotlinOptions {
            freeCompilerArgs = listOf("-Xuse-experimental=kotlin.Experimental")
        }
    }
    withType<org.jetbrains.dokka.gradle.DokkaTask> {
        outputDirectory = "$buildDir/docs"
        doFirst { file(outputDirectory).deleteRecursively() }
    }
}

publishKotlinFix()
publish {
    bintrayUser = BINTRAY_USER
    bintrayKey = BINTRAY_KEY
    dryRun = false
    repoName = RELEASE_ARTIFACT

    userOrg = RELEASE_USER
    groupId = RELEASE_GROUP
    artifactId = "$RELEASE_ARTIFACT-core"
    publishVersion = RELEASE_VERSION
    desc = RELEASE_DESC
    website = RELEASE_WEB
}