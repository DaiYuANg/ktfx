@file:Suppress("PackageDirectoryMismatch", "NOTHING_TO_INLINE")

package ktfx.layouts

import javafx.collections.ObservableList
import javafx.scene.control.TableView
import ktfx.collections.observableListOf

/** Creates a [TableView]. */
fun <S> tableView(
    items: ObservableList<S> = observableListOf(),
    init: ((@LayoutDsl TableView<S>).() -> Unit)? = null
): TableView<S> = TableView<S>(items).also { init?.invoke(it) }

/** Creates a [TableView] and add it to this manager. */
inline fun <S> NodeInvokable.tableView(
    items: ObservableList<S> = observableListOf(),
    noinline init: ((@LayoutDsl TableView<S>).() -> Unit)? = null
): TableView<S> = ktfx.layouts.tableView(items, init)()