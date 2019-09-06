@file:Suppress("PackageDirectoryMismatch")

package ktfx.layouts

import javafx.scene.shape.Line

/** Create a [Line] with initialization block. */
inline fun line(
    centerX: Double = 0.0,
    centerY: Double = 0.0,
    endX: Double = 0.0,
    endY: Double = 0.0,
    init: (@LayoutDslMarker Line).() -> Unit
): Line = Line(centerX, centerY, endX, endY).apply(init)

/** Add a [Line] to this manager. */
fun NodeManager.line(
    centerX: Double = 0.0,
    centerY: Double = 0.0,
    endX: Double = 0.0,
    endY: Double = 0.0
): Line = addNode(ktfx.layouts.line(centerX, centerY, endX, endY) { })

/** Add a [Line] with initialization block to this manager. */
inline fun NodeManager.line(
    centerX: Double = 0.0,
    centerY: Double = 0.0,
    endX: Double = 0.0,
    endY: Double = 0.0,
    init: (@LayoutDslMarker Line).() -> Unit
): Line = addNode(ktfx.layouts.line(centerX, centerY, endX, endY, init))
