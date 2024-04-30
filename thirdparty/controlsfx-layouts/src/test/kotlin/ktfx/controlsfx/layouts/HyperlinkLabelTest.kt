package ktfx.controlsfx.layouts

import com.hendraanggrian.ktfx.test.LayoutsTest
import kotlin.test.assertNull
import ktfx.layouts.KtfxPane
import org.controlsfx.control.HyperlinkLabel

class HyperlinkLabelTest : LayoutsTest<KtfxPane, HyperlinkLabel>() {
  override fun manager(): KtfxPane = KtfxPane()

  override fun KtfxPane.childCount(): Int = children.size

  override fun child1(): HyperlinkLabel = hyperlinkLabel {}

  override fun KtfxPane.child2(): HyperlinkLabel = hyperlinkLabel()

  override fun KtfxPane.child3(): HyperlinkLabel = hyperlinkLabel {}

  override fun HyperlinkLabel.testDefaultValues() {
    assertNull(text)
  }
}
