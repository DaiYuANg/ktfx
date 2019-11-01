@file:JvmMultifileClass
@file:JvmName("LayoutsKt")
@file:Suppress("PackageDirectoryMismatch")

package ktfx.layouts

import javafx.scene.control.ProgressBar
import javafx.scene.control.ProgressIndicator

/** Create a [ProgressIndicator] with initialization block. */
inline fun progressIndicator(
    progress: Double = ProgressBar.INDETERMINATE_PROGRESS,
    init: (@LayoutDslMarker ProgressIndicator).() -> Unit
): ProgressIndicator = ProgressIndicator(progress).apply(init)

/** Add a [ProgressIndicator] to this manager. */
fun NodeManager.progressIndicator(
    progress: Double = ProgressBar.INDETERMINATE_PROGRESS
): ProgressIndicator = addNode(ProgressIndicator(progress))

/** Add a [ProgressIndicator] with initialization block to this manager. */
inline fun NodeManager.progressIndicator(
    progress: Double = ProgressBar.INDETERMINATE_PROGRESS,
    init: (@LayoutDslMarker ProgressIndicator).() -> Unit
): ProgressIndicator = addNode(ProgressIndicator(progress), init)