plugins {
  alias(libs.plugins.dokka)
  alias(libs.plugins.kotlinx.kover)
  alias(libs.plugins.ktlint)
  alias(libs.plugins.maven.publish)
}

dependencies {
  ktlintRuleset(libs.rulebook.ktlint)
//
  testImplementation(projects.testing.layouts)
  testImplementation(projects.ktfxCommons)
  testImplementation(libs.commons.lang3)
}
