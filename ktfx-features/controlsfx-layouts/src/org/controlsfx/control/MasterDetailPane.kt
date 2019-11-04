@file:JvmMultifileClass
@file:JvmName("ControlsFxLayoutsKt")

package ktfx.controlsfx.layouts

import javafx.geometry.Side
import javafx.scene.Node
import ktfx.layouts.LayoutDslMarker
import ktfx.layouts.NodeManager
import ktfx.layouts.addNode
import org.controlsfx.control.MasterDetailPane

open class KtfxMasterDetailPane(side: Side, showDetail: Boolean) : MasterDetailPane(side, showDetail), NodeManager {
    private var nodeCount = 0

    final override fun <T : Node> addNode(node: T): T =
        node.also {
            when (nodeCount++) {
                0 -> masterNode = it
                1 -> detailNode = it
                else -> error("Master and detail node has been set.")
            }
        }
}

/** Create a [MasterDetailPane] with initialization block. */
inline fun masterDetailPane(
    side: Side = Side.RIGHT,
    showDetail: Boolean = true,
    init: (@LayoutDslMarker KtfxMasterDetailPane).() -> Unit
): MasterDetailPane = KtfxMasterDetailPane(side, showDetail).apply(init)

/** Add a [MasterDetailPane] to this manager. */
fun NodeManager.masterDetailPane(
    side: Side = Side.RIGHT,
    showDetail: Boolean = true
): MasterDetailPane = addNode(KtfxMasterDetailPane(side, showDetail))

/** Add a [MasterDetailPane] with initialization block to this manager. */
inline fun NodeManager.masterDetailPane(
    side: Side = Side.RIGHT,
    showDetail: Boolean = true,
    init: (@LayoutDslMarker KtfxMasterDetailPane).() -> Unit
): MasterDetailPane = addNode(KtfxMasterDetailPane(side, showDetail), init)
