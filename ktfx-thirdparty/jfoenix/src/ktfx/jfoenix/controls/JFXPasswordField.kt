@file:Suppress("PackageDirectoryMismatch")

package ktfx.jfoenix

import com.jfoenix.controls.JFXPasswordField
import ktfx.layouts.LayoutDslMarker
import ktfx.layouts.NodeManager

/** Create a [JFXPasswordField] with initialization block. */
inline fun jfxPasswordField(
    init: (@LayoutDslMarker JFXPasswordField).() -> Unit
): JFXPasswordField = JFXPasswordField().apply(init)

/** Add a [JFXPasswordField] to this manager. */
fun NodeManager.jfxPasswordField(): JFXPasswordField =
    addNode(ktfx.jfoenix.jfxPasswordField { })

/** Add a [JFXPasswordField] with initialization block to this manager. */
inline fun NodeManager.jfxPasswordField(
    init: (@LayoutDslMarker JFXPasswordField).() -> Unit
): JFXPasswordField = addNode(ktfx.jfoenix.jfxPasswordField(init))
