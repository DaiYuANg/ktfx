package ktfx.controlsfx.layouts

import com.hendraanggrian.ktfx.test.LayoutsTest
import kotlin.test.assertNull
import ktfx.layouts.KtfxPane
import org.controlsfx.control.InfoOverlay

class InfoOverlayTest : LayoutsTest<KtfxPane, InfoOverlay>() {
  override fun manager(): KtfxPane = KtfxPane()

  override fun KtfxPane.childCount(): Int = children.size

  override fun child1(): InfoOverlay = infoOverlay {}

  override fun KtfxPane.child2(): InfoOverlay = infoOverlay()

  override fun KtfxPane.child3(): InfoOverlay = infoOverlay {}

  override fun InfoOverlay.testDefaultValues() {
    assertNull(content)
    assertNull(text)
  }
}
