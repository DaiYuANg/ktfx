@file:Suppress("NOTHING_TO_INLINE")

package ktfx.controlsfx

import javafx.scene.Node
import ktfx.layouts.LayoutDsl
import ktfx.layouts.LayoutManager
import org.controlsfx.control.MaskerPane

/** Creates a [MaskerPane]. */
fun maskerPane(
    init: ((@LayoutDsl MaskerPane).() -> Unit)? = null
): MaskerPane = MaskerPane().also {
    init?.invoke(it)
}

/** Creates a [MaskerPane] and add it to this [LayoutManager]. */
inline fun LayoutManager<Node>.maskerPane(
    noinline init: ((@LayoutDsl MaskerPane).() -> Unit)? = null
): MaskerPane = ktfx.controlsfx.maskerPane(init)()

/** Create a styled [MaskerPane]. */
fun styledMaskerPane(
    styleClass: String,
    init: ((@LayoutDsl MaskerPane).() -> Unit)? = null
): MaskerPane = MaskerPane().also {
    it.styleClass += styleClass
    init?.invoke(it)
}

/** Creates a styled [MaskerPane] and add it to this [LayoutManager]. */
inline fun LayoutManager<Node>.styledMaskerPane(
    styleClass: String,
    noinline init: ((@LayoutDsl MaskerPane).() -> Unit)? = null
): MaskerPane = ktfx.controlsfx.styledMaskerPane(styleClass, init)()