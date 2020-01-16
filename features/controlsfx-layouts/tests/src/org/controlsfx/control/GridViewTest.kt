package ktfx.controlsfx.layouts

import com.google.common.truth.Truth.assertThat
import ktfx.layouts.KtfxPane
import ktfx.layouts.NodeManager
import ktfx.test.LayoutsTest
import org.controlsfx.control.GridView

class GridViewTest : LayoutsTest<NodeManager, GridView<String>>() {

    override fun manager() = KtfxPane()
    override fun childCount() = manager.childCount
    override fun child1() = gridView<String> { }
    override fun NodeManager.child2() = gridView<String>()
    override fun NodeManager.child3() = gridView<String> { }

    override fun GridView<String>.testDefaultValues() {
        assertThat(items).isEmpty()
    }
}