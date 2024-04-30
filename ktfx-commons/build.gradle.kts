plugins {
  alias(libs.plugins.dokka)
  alias(libs.plugins.kotlinx.kover)
  alias(libs.plugins.ktlint)
  alias(libs.plugins.maven.publish)
}

dependencies {
  ktlintRuleset(libs.rulebook.ktlint)

  testImplementation(project(":testing:commons"))
}
