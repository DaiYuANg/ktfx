package ktfx.controlsfx.dialogs

import com.hendraanggrian.ktfx.test.DialogShowingTest
import kotlin.test.Ignore
import kotlin.test.Test
import kotlin.test.assertEquals
import ktfx.toFxPair

@Ignore
class LoginDialogsTest : DialogShowingTest() {
  private val userInfo = "Hello" to "World"

  @Test
  fun exceptionDialog() {
    interact {
      assertEquals(
          userInfo.toFxPair(),
          loginDialog("Login dialog", sampleGraphic, userInfo, {}) {
                closeOnShow(this)
                assertEquals("Login dialog", headerText)
                assertEquals(sampleGraphic, graphic)
              }
              .get(),
      )
      assertEquals(
          userInfo.toFxPair(),
          loginDialog(userInfo, {}) { closeOnShow(this) }.get(),
      )
    }
  }
}
