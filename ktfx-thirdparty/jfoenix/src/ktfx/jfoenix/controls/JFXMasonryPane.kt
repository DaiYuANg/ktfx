@file:Suppress("PackageDirectoryMismatch", "NOTHING_TO_INLINE")

package ktfx.jfoenix

import com.jfoenix.controls.JFXMasonryPane
import ktfx.layouts.NodeManager
import ktfx.layouts.LayoutDslMarker

/** Creates a [JFXMasonryPane]. */
fun jfxMasonryPane(
    init: ((@LayoutDslMarker JFXMasonryPane).() -> Unit)? = null
): JFXMasonryPane = JFXMasonryPane().also { init?.invoke(it) }

/** Creates a [JFXMasonryPane] and add it to this manager. */
inline fun NodeManager.jfxMasonryPane(
    noinline init: ((@LayoutDslMarker JFXMasonryPane).() -> Unit)? = null
): JFXMasonryPane = ktfx.jfoenix.jfxMasonryPane(init).add()