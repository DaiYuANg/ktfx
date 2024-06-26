import org.gradle.api.Plugin
import org.gradle.api.Project
import org.gradle.kotlin.dsl.dependencies
import org.openjfx.gradle.JavaFXOptions
import org.openjfx.gradle.JavaFXPlugin

class JavaFxSetting : Plugin<Project> {

  override fun apply(target: Project) {
    val rootLibs = rootLibs(target)
    target.plugins.apply(JavaFXPlugin::class.java)
    target.extensions.configure(JavaFXOptions::class.java) {
      modules(*javafxModules.toTypedArray())
      configurations =
        arrayOf(
          IMPLEMENTATION,
          TEST_IMPLEMENTATION,
        )
    }
    target.dependencies { add(TEST_IMPLEMENTATION, rootLibs.javafxUnitTest) }
  }

}
