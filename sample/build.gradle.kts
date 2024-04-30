val releaseArtifact: String by project

plugins {
  application
}

application.mainClass.set("com.example.CalculatorApp")

dependencies {
  implementation(projects.ktfx)
  implementation(projects.thirdparty.controlsfx)
}
