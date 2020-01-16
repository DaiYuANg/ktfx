@file:JvmMultifileClass
@file:JvmName("JfoenixLayoutsKt")
@file:UseExperimental(ExperimentalContracts::class)

package ktfx.jfoenix.layouts

import com.jfoenix.controls.JFXTreeCell
import kotlin.contracts.ExperimentalContracts
import kotlin.contracts.InvocationKind
import kotlin.contracts.contract
import ktfx.layouts.LayoutsDslMarker
import ktfx.layouts.NodeManager
import ktfx.layouts.addChild

/** Create a [JFXTreeCell] with initialization block. */
inline fun <T> jfxTreeCell(
    configuration: (@LayoutsDslMarker JFXTreeCell<T>).() -> Unit
): JFXTreeCell<T> {
    contract { callsInPlace(configuration, InvocationKind.EXACTLY_ONCE) }
    return JFXTreeCell<T>().apply(configuration)
}

/** Add a [JFXTreeCell] to this manager. */
fun <T> NodeManager.jfxTreeCell(): JFXTreeCell<T> = addChild(JFXTreeCell())

/** Add a [JFXTreeCell] with initialization block to this manager. */
inline fun <T> NodeManager.jfxTreeCell(
    configuration: (@LayoutsDslMarker JFXTreeCell<T>).() -> Unit
): JFXTreeCell<T> {
    contract { callsInPlace(configuration, InvocationKind.EXACTLY_ONCE) }
    return addChild(JFXTreeCell(), configuration)
}