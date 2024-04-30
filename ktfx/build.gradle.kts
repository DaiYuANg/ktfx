val releaseArtifact: String by project

plugins {
  alias(libs.plugins.dokka)
  alias(libs.plugins.maven.publish)
}

dependencies {
  api(projects.ktfxCommons)
  api(projects.ktfxLayouts)
  api(projects.ktfxCoroutines)
}
