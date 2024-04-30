import org.gradle.api.Plugin
import org.gradle.api.Project
import org.gradle.kotlin.dsl.apply
import org.jreleaser.gradle.plugin.JReleaserPlugin

class ReleaseSetting:Plugin<Project> {
  override fun apply(target: Project) {
    target.plugins.apply(JReleaserPlugin::class)
  }
}
