plugins {
  alias(libs.plugins.dokka)
//  alias(libs.plugins.kotlinx.kover)
//  alias(libs.plugins.ktlint)
  alias(libs.plugins.maven.publish)
}

dependencies {
//  ktlintRuleset(libs.rulebook.ktlint)
  compileOnly(libs.kotlinx.coroutines.core)
  testImplementation(projects.testing.commons)
}
