@file:Suppress("PackageDirectoryMismatch", "SpellCheckingInspection")

package ktfx.controlsfx

import javafx.scene.Node
import ktfx.layouts.LayoutDslMarker
import ktfx.layouts.NodeManager
import org.controlsfx.control.SnapshotView

open class KtfxSnapshotView : SnapshotView(), NodeManager {

    final override fun <T : Node> addNode(node: T): T =
        node.also { this.node = it }
}

/** Create a [SnapshotView] with initialization block. */
inline fun snapshotView(
    init: (@LayoutDslMarker KtfxSnapshotView).() -> Unit
): SnapshotView = KtfxSnapshotView().apply(init)

/** Add a [SnapshotView] to this manager. */
fun NodeManager.snapshotView(): SnapshotView =
    addNode(ktfx.controlsfx.snapshotView { })

/** Add a [SnapshotView] with initialization block to this manager. */
inline fun NodeManager.snapshotView(
    init: (@LayoutDslMarker KtfxSnapshotView).() -> Unit
): SnapshotView = addNode(ktfx.controlsfx.snapshotView(init))
