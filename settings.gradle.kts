pluginManagement.repositories {
  mavenLocal()
  mavenCentral()
  gradlePluginPortal()
  google()
}

dependencyResolutionManagement.repositories {
  mavenCentral()
  maven("https://s01.oss.sonatype.org/content/repositories/snapshots/")
}
plugins {
  id("org.gradle.toolchains.foojay-resolver-convention") version "0.5.0"
  id("org.danilopianini.gradle-pre-commit-git-hooks") version "2.0.2"
  id("com.gradle.enterprise") version "3.13.4"
}

enableFeaturePreview("TYPESAFE_PROJECT_ACCESSORS")

buildCache {
  local {
    isEnabled = true
    directory = File(rootProject.projectDir, ".gradle/build-cache")
  }
}

// gitHooks {
//    commitMsg {
//        conventionalCommits {
//            defaultTypes()
//        }
//    }
//    createHooks(true) // actual hooks creation
// }
//
// gradleEnterprise {
//    buildScan {
//        termsOfServiceUrl = "https://gradle.com/terms-of-service"
//        termsOfServiceAgree = "yes"
//    }
// }

rootProject.name = "ktfx-root"

include("ktfx", "ktfx-commons", "ktfx-coroutines", "ktfx-layouts")
include("codegen")
include("sample")
include("website")

includeDir("thirdparty")
includeDir("testing")

fun includeDir(dir: String) =
  include(
    *file(dir).listFiles()!!
      .filter { it.isDirectory }
      .map { "$dir:${it.name}" }
      .toTypedArray(),
  )
