@file:Suppress("PackageDirectoryMismatch")

package ktfx.layouts

import javafx.scene.control.ScrollBar

/** Create a [ScrollBar] with initialization block. */
inline fun scrollBar(
    init: (@LayoutDslMarker ScrollBar).() -> Unit
): ScrollBar = ScrollBar().apply(init)

/** Add a [ScrollBar] to this manager. */
fun NodeManager.scrollBar(): ScrollBar =
    addNode(ktfx.layouts.scrollBar { })

/** Add a [ScrollBar] with initialization block to this manager. */
inline fun NodeManager.scrollBar(
    init: (@LayoutDslMarker ScrollBar).() -> Unit
): ScrollBar = addNode(ktfx.layouts.scrollBar(init))
