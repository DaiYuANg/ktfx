val releaseArtifact: String by project

plugins {
    alias(libs.plugins.kotlinx.kover)
    alias(libs.plugins.ktlint)
}

dependencies {
    ktlintRuleset(libs.rulebook.ktlint)

    implementation(projects.ktfxCoroutines)
    implementation(libs.kotlinx.coroutines.javafx)
    implementation(libs.controlsfx)

    testImplementation(projects.testing.listenersControlsfx)
}
