val releaseArtifact: String by project

plugins {
  application
}

application.mainClass.set("com.example.SampleApplication")
application.applicationDefaultJvmArgs += devJvmArguments

dependencies {
  implementation(projects.ktfx)
  implementation(projects.thirdparty.controlsfx)
}
