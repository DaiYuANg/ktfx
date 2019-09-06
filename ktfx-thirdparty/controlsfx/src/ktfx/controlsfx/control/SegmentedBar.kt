@file:Suppress("PackageDirectoryMismatch")

package ktfx.controlsfx

import ktfx.layouts.LayoutDslMarker
import ktfx.layouts.NodeManager
import org.controlsfx.control.SegmentedBar
import org.controlsfx.control.SegmentedBar.Segment

/** Create a [SegmentedBar] with initialization block. */
inline fun <T : Segment> segmentedBar(
    init: (@LayoutDslMarker SegmentedBar<T>).() -> Unit
): SegmentedBar<T> = SegmentedBar<T>().apply(init)

/** Add a [SegmentedBar] to this manager. */
fun <T : Segment> NodeManager.segmentedBar(): SegmentedBar<T> =
    addNode(ktfx.controlsfx.segmentedBar { })

/** Add a [SegmentedBar] with initialization block to this manager. */
inline fun <T : Segment> NodeManager.segmentedBar(
    init: (@LayoutDslMarker SegmentedBar<T>).() -> Unit
): SegmentedBar<T> = addNode(ktfx.controlsfx.segmentedBar(init))
