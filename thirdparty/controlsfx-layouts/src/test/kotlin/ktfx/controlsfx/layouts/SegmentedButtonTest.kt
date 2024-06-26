package ktfx.controlsfx.layouts

import com.hendraanggrian.ktfx.test.LayoutsTest
import kotlin.test.Test
import kotlin.test.assertEquals
import ktfx.layouts.KtfxPane
import ktfx.layouts.toggleButton
import org.controlsfx.control.SegmentedButton

class SegmentedButtonTest : LayoutsTest<KtfxPane, SegmentedButton>() {
  override fun manager(): KtfxPane = KtfxPane()

  override fun KtfxPane.childCount(): Int = children.size

  override fun child1(): SegmentedButton = segmentedButton {}

  override fun KtfxPane.child2(): SegmentedButton = segmentedButton()

  override fun KtfxPane.child3(): SegmentedButton = segmentedButton {}

  @Test
  fun stringInvocation() {
    segmentedButton {
      toggleButton("Hello")
      "World" {}
      assertEquals(2, buttons.size)
    }
  }
}
