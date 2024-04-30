package ktfx.controlsfx.layouts

import com.hendraanggrian.ktfx.test.LayoutsTest
import kotlin.test.assertNull
import ktfx.layouts.KtfxPane
import org.controlsfx.control.CheckTreeView

class CheckTreeViewTest : LayoutsTest<KtfxPane, CheckTreeView<String>>() {
  override fun manager(): KtfxPane = KtfxPane()

  override fun KtfxPane.childCount(): Int = children.size

  override fun child1(): CheckTreeView<String> = checkTreeView {}

  override fun KtfxPane.child2(): CheckTreeView<String> = checkTreeView()

  override fun KtfxPane.child3(): CheckTreeView<String> = checkTreeView {}

  override fun CheckTreeView<String>.testDefaultValues() {
    assertNull(root)
  }
}
