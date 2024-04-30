val releaseArtifact: String by project

plugins {
    alias(libs.plugins.kotlinx.kover)
    alias(libs.plugins.ktlint)
}

dependencies {
    ktlintRuleset(libs.rulebook.ktlint)

    implementation(projects.ktfxCommons)
    implementation(libs.controlsfx)

    testImplementation(projects.testing.commons)
    testImplementation(projects.ktfxLayouts)
    testImplementation(libs.kotlinx.coroutines.javafx)
}
