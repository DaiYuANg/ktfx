@file:Suppress("PackageDirectoryMismatch")

package ktfx.layouts

import javafx.geometry.Orientation
import javafx.geometry.Orientation.HORIZONTAL
import javafx.scene.control.Separator

/** Create a [Separator] with initialization block. */
inline fun separator(
    orientation: Orientation = HORIZONTAL,
    init: (@LayoutDslMarker Separator).() -> Unit
): Separator = Separator(orientation).apply(init)

/** Add a [Separator] to this manager. */
fun NodeManager.separator(
    orientation: Orientation = HORIZONTAL
): Separator = addNode(ktfx.layouts.separator(orientation) { })

/** Add a [Separator] with initialization block to this manager. */
inline fun NodeManager.separator(
    orientation: Orientation = HORIZONTAL,
    init: (@LayoutDslMarker Separator).() -> Unit
): Separator = addNode(ktfx.layouts.separator(orientation, init))
