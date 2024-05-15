import org.gradle.api.Plugin
import org.gradle.api.Project
import org.gradle.api.publish.PublishingExtension
import org.gradle.api.publish.maven.MavenPublication
import org.gradle.api.publish.maven.plugins.MavenPublishPlugin
import org.gradle.api.publish.plugins.PublishingPlugin
import org.gradle.kotlin.dsl.apply
import org.gradle.kotlin.dsl.configure
import org.gradle.kotlin.dsl.create
import org.jreleaser.gradle.plugin.JReleaserExtension
import org.jreleaser.gradle.plugin.JReleaserPlugin
import org.jreleaser.model.Active

class ReleaseSetting : Plugin<Project> {
  override fun apply(target: Project) {
    target.plugins.apply(JReleaserPlugin::class)
    target.plugins.apply(MavenPublishPlugin::class)
    target.plugins.getPlugin(MavenPublishPlugin::class.java)

    target.extensions.configure<PublishingExtension> {
      publications {
        create<MavenPublication>("mavenJava") {
          from(target.components.getByName("java"))
          groupId = "io.github.daiyuang"
          artifactId = "ktfx"

          pom {
            name.set("ktfx")
            description.set("Sample application")
            url.set("https://github.com/aalmiray/app")
            inceptionYear.set("2024")
            licenses {
              license {
                name.set("Apache-2.0")
                url.set("https://spdx.org/licenses/Apache-2.0.html")
              }
            }
            developers {
              developer {
                id.set("aalmiray")
                name.set("Andres Almiray")
              }
            }
            scm {
              connection.set("scm:git:https://github.com/aalmiray/app.git")
              developerConnection.set("scm:git:ssh://github.com/aalmiray/app.git")
              url.set("http://github.com/aalmiray/app")
            }
          }
        }
      }
      repositories {
        maven {
          url = target.layout.buildDirectory.dir("staging-deploy").get().asFile.toURI()
        }
      }
    }
    target.extensions.configure<JReleaserExtension> {
      signing {
        active.set(Active.ALWAYS)
        armored.set(true)
      }
      deploy {
        maven {
          mavenCentral {
            create("soant") {
              active.set(Active.ALWAYS)
              url.set("https://central.sonatype.com/api/v1/publisher")
              stagingRepositories.set(listOf("target/staging-deploy"))
            }
//            sonatype {
//              active = 'ALWAYS'
//              url = 'https://central.sonatype.com/api/v1/publisher'
//              stagingRepository('target/staging-deploy')
//            }
          }
        }
      }
    }
  }
}
