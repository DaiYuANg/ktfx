val developerId: String by project
val developerName: String by project
val developerUrl: String by project
val releaseArtifact: String by project
val releaseDescription: String by project
val releaseUrl: String by project

plugins {
  alias(libs.plugins.pages)
  alias(libs.plugins.git.publish)
  alias(libs.plugins.asciidoctorPdf)
  alias(libs.plugins.asciidoctorJvm)
  alias(libs.plugins.asciidoctorEpub)
  alias(libs.plugins.asciidoctorEditconfig)
  alias(libs.plugins.asciidoctorGem)
  idea
}

repositories {
  ruby {
    gems()
  }
}

pages {
  resources.from("$rootDir/build/dokka/")
  styles.add("https://cdnjs.cloudflare.com/ajax/libs/prism/1.29.0/themes/prism-tomorrow.min.css")
  scripts.addAll(
    "https://cdnjs.cloudflare.com/ajax/libs/prism/1.29.0/prism.min.js",
    "https://cdnjs.cloudflare.com/ajax/libs/prism/1.29.0/components/prism-groovy.min.js",
    "https://cdnjs.cloudflare.com/ajax/libs/prism/1.29.0/components/prism-kotlin.min.js",
  )
  minimal {
    authorName = developerName
    authorUrl = developerUrl
    projectName = releaseArtifact
    projectDescription = releaseDescription
    projectUrl = releaseUrl
    button("View\nDocumentation", "dokka")
  }
}

gitPublish {
  repoUri.set("git@github.com:$developerId/$releaseArtifact.git")
  branch.set("gh-pages")
  contents.from(pages.outputDirectory)
}

tasks {
//    register(LifecycleBasePlugin.CLEAN_TASK_NAME) {
//        delete(buildDir)
//    }
  deployPages {
    dependsOn(":dokkaHtmlMultiModule")
  }
}

asciidoctorj {
  modules {
    diagram.use()
  }
}

tasks.asciidoctor {
  parallelMode = true
  languages("en", "zh")
  jvm {
    jvmArgs(
      "--add-opens",
      "java.base/sun.nio.ch=ALL-UNNAMED",
      "--add-opens",
      "java.base/java.io=ALL-UNNAMED",
    )
  }
}

tasks.build {
  dependsOn(tasks.asciidoctor)
}

idea {
  module {
    sourceDirs = project.tasks.asciidoctor.get().sourceFileTree.toMutableSet()
  }
}
