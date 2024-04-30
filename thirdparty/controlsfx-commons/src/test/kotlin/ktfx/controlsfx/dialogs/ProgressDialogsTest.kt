package ktfx.controlsfx.dialogs

import com.hendraanggrian.ktfx.test.DialogShowingTest
import javafx.concurrent.Service
import javafx.stage.Stage
import kotlin.test.Ignore
import kotlin.test.Test
import kotlin.test.assertEquals
import ktfx.buildService

@Ignore
class ProgressDialogsTest : DialogShowingTest() {
  private lateinit var helloWorldService: Service<String>

  override fun start(stage: Stage) {
    super.start(stage)
    helloWorldService = buildService { call { "Hello world" } }
  }

  @Test
  fun exceptionDialog() {
    interact {
      progressDialog("Progress dialog", sampleGraphic, helloWorldService) {
            closeOnShow(this)
            assertEquals("Progress dialog", headerText)
            assertEquals(sampleGraphic, graphic)
          }
          .get()
      progressDialog(helloWorldService) {
            closeOnShow(this)
            assertEquals("Progress dialog", headerText)
            assertEquals(sampleGraphic, graphic)
          }
          .get()
    }
  }
}
