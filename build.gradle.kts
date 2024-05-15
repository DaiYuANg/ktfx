import com.coditory.gradle.manifest.ManifestPlugin
import org.gradle.jvm.tasks.Jar

val developerId: String by project
val developerName: String by project
val developerUrl: String by project
val releaseGroup: String by project
val releaseArtifact: String by project
val releaseVersion: String by project
val releaseDescription: String by project
val releaseUrl: String by project

plugins {
  alias(libs.plugins.dokka)
  alias(libs.plugins.kotlinx.kover) apply false
  alias(libs.plugins.ktlint) apply false
  alias(libs.plugins.maven.publish) apply false
  alias(libs.plugins.versionCheck)
  alias(libs.plugins.manifest)
  alias(libs.plugins.gradleDotenv)
}

allprojects {
  group = releaseGroup
  version = releaseVersion
}

apply<IdeaSetting>()
apply<FormatSetting>()
apply<ReleaseSetting>()

subprojects {
  if (project.name != "website") {
    apply<KotlinSetting>()
    apply<JavaFxSetting>()
    apply<JavaLibraryPlugin>()
    apply<ManifestPlugin>()
    apply<PublishingPlugin>()

    project.extensions.configure<JavaPluginExtension> {
//      withJavadocJar()
      withSourcesJar()
    }

    manifest {
      buildAttributes = true
      implementationAttributes = true
      scmAttributes = true
    }

    plugins.withType<org.jetbrains.kotlin.gradle.plugin.KotlinPluginWrapper>().configureEach {
      the<org.jetbrains.kotlin.gradle.dsl.KotlinJvmProjectExtension>()
        .jvmToolchain(rootProject.libs.versions.jdk.get().toInt())
    }

    plugins.withType<org.jlleitschuh.gradle.ktlint.KtlintPlugin>().configureEach {
      the<org.jlleitschuh.gradle.ktlint.KtlintExtension>()
        .version.set(rootProject.libs.versions.ktlint.get())
    }

    tasks.withType(Jar::class.java) {
      enabled = true
      duplicatesStrategy = DuplicatesStrategy.INCLUDE
    }
  }
}

tasks {
  dokkaHtmlMultiModule {
    outputDirectory.set(project.layout.buildDirectory.get().asFile.resolve("dokka/dokka/"))
  }
}
