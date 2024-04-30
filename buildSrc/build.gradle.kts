plugins {
  `kotlin-dsl`
}

repositories {
  mavenLocal()
  mavenCentral()
  gradlePluginPortal()
  google()
}

dependencies {
  implementation(files(libs.javaClass.superclass.protectionDomain.codeSource.location))
  implementation(libs.spotbugsPlugin)
  implementation(libs.kotlinGradlePlugin)
  implementation(libs.kotlinGradleLombokPlugin)
  implementation(libs.kotlinGradleSerializationPlugin)
  implementation(libs.kotlinGradleNoArgPlugin)
  implementation(libs.kotlinGradleAllOpenPlugin)
  implementation(libs.spotlessPlugin)
  implementation(libs.javaFxPlugin)
}
