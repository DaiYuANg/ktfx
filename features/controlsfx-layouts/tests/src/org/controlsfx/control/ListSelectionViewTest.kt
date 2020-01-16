package ktfx.controlsfx.layouts

import ktfx.layouts.KtfxPane
import ktfx.layouts.NodeManager
import ktfx.test.LayoutsTest
import org.controlsfx.control.ListSelectionView

class ListSelectionViewTest : LayoutsTest<NodeManager, ListSelectionView<String>>() {

    override fun manager() = KtfxPane()
    override fun childCount() = manager.childCount
    override fun child1() = listSelectionView<String> { }
    override fun NodeManager.child2() = listSelectionView<String>()
    override fun NodeManager.child3() = listSelectionView<String> { }
}