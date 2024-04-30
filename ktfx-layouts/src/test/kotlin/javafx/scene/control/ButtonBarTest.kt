package ktfx.layouts

import com.google.common.truth.Truth.assertThat
import com.hendraanggrian.ktfx.test.LayoutsTest
import javafx.scene.control.ButtonBar
import javafx.scene.control.ButtonBar.BUTTON_ORDER_LINUX
import javafx.scene.control.ButtonBar.BUTTON_ORDER_MAC_OS
import javafx.scene.control.ButtonBar.BUTTON_ORDER_NONE
import javafx.scene.control.ButtonBar.BUTTON_ORDER_WINDOWS
import kotlin.test.Test
import kotlin.test.assertEquals
import org.apache.commons.lang3.SystemUtils.IS_OS_LINUX
import org.apache.commons.lang3.SystemUtils.IS_OS_MAC
import org.apache.commons.lang3.SystemUtils.IS_OS_WINDOWS

class ButtonBarTest : LayoutsTest<KtfxPane, ButtonBar>() {
  override fun manager(): KtfxPane = KtfxPane()

  override fun KtfxPane.childCount(): Int = children.size

  override fun child1(): ButtonBar = buttonBar {}

  override fun KtfxPane.child2(): ButtonBar = buttonBar()

  override fun KtfxPane.child3(): ButtonBar = buttonBar {}

  override fun ButtonBar.testDefaultValues() {
    assertEquals(
        when {
          IS_OS_WINDOWS -> BUTTON_ORDER_WINDOWS
          IS_OS_MAC -> BUTTON_ORDER_MAC_OS
          IS_OS_LINUX -> BUTTON_ORDER_LINUX
          else -> BUTTON_ORDER_NONE
        },
        buttonOrder,
    )
  }

  @Test
  fun stringInvocation() {
    buttonBar {
      assertThat(buttons).isEmpty()
      button("Hello")
      "World" {}
      assertEquals(2, buttons.size)
    }
  }
}
