package ktfx.controlsfx.controls

import com.hendraanggrian.ktfx.test.initToolkit
import javafx.scene.control.TextField
import kotlin.test.BeforeTest
import kotlin.test.Test
import ktfx.text.buildStringConverter

class TextFieldsTest {
  private lateinit var field: TextField

  @BeforeTest
  fun start() {
    initToolkit()
    field = TextField()
  }

  @Test
  fun bindAutoCompletion() {
    field.bindAutoCompletion("Hello", "World")
    field.bindAutoCompletion(listOf("Hello", "World"))
    field.bindAutoCompletion { listOf("Hello", "World") }
    field.bindAutoCompletion(buildStringConverter {}) { listOf("Hello", "World") }
  }
}
