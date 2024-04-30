plugins {
  alias(libs.plugins.dokka)
  alias(libs.plugins.kotlinx.kover)
  alias(libs.plugins.ktlint)
  alias(libs.plugins.maven.publish)
}

dependencies {
  ktlintRuleset(libs.rulebook.ktlint)
  api(libs.kotlinx.coroutines.core)
  api(libs.kotlinx.coroutines.javafx)
  testImplementation(projects.testing.listeners)
}
