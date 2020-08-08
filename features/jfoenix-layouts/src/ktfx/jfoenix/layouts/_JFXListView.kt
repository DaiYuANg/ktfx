@file:JvmMultifileClass
@file:JvmName("JfoenixLayoutsKt")
@file:OptIn(ExperimentalContracts::class)

package ktfx.jfoenix.layouts

import com.jfoenix.controls.JFXListView
import ktfx.internal.KtfxInternals.newChild
import ktfx.layouts.LayoutDslMarker
import ktfx.layouts.NodeManager
import kotlin.String
import kotlin.Unit
import kotlin.contracts.ExperimentalContracts
import kotlin.contracts.InvocationKind.EXACTLY_ONCE
import kotlin.contracts.contract
import kotlin.jvm.JvmMultifileClass
import kotlin.jvm.JvmName

/**
 * Add a [JFXListView] to this manager.
 *
 * @return the control added.
 */
fun <T> NodeManager.jfxListView(): JFXListView<T> = jfxListView() { }

/**
 * Create a [JFXListView] with configuration block.
 *
 * @param configuration the configuration block.
 * @return the control created.
 */
inline fun <T> jfxListView(configuration: (@LayoutDslMarker JFXListView<T>).() -> Unit):
    JFXListView<T> {
        contract { callsInPlace(configuration, EXACTLY_ONCE) }
        return newChild(JFXListView<T>(), configuration = configuration)
    }

/**
 * Add a [JFXListView] with configuration block to this manager.
 *
 * @param configuration the configuration block.
 * @return the control added.
 */
inline fun <T> NodeManager.jfxListView(configuration: (@LayoutDslMarker JFXListView<T>).() -> Unit):
    JFXListView<T> {
        contract { callsInPlace(configuration, EXACTLY_ONCE) }
        return addChild(newChild(JFXListView<T>(), configuration = configuration))
    }

/**
 * Create a styled [JFXListView].
 *
 * @param styleClass the CSS style class.
 * @param id the CSS id.
 * @return the styled control created.
 */
fun <T> styledJFXListView(vararg styleClass: String, id: String? = null): JFXListView<T> =
    styledJFXListView(styleClass = *styleClass, id = id) { }

/**
 * Add a styled [JFXListView] to this manager.
 *
 * @param styleClass the CSS style class.
 * @param id the CSS id.
 * @return the styled control added.
 */
fun <T> NodeManager.styledJFXListView(vararg styleClass: String, id: String? = null): JFXListView<T> =
    styledJFXListView(styleClass = *styleClass, id = id) { }

/**
 * Create a styled [JFXListView] with configuration block.
 *
 * @param styleClass the CSS style class.
 * @param id the CSS id.
 * @param configuration the configuration block.
 * @return the styled control created.
 */
inline fun <T> styledJFXListView(
    vararg styleClass: String,
    id: String? = null,
    configuration: (@LayoutDslMarker JFXListView<T>).() -> Unit
): JFXListView<T> {
    contract { callsInPlace(configuration, EXACTLY_ONCE) }
    return newChild(
        JFXListView<T>(), styleClass = *styleClass, id = id,
        configuration =
            configuration
    )
}

/**
 * Add a styled [JFXListView] with configuration block to this manager.
 *
 * @param styleClass the CSS style class.
 * @param id the CSS id.
 * @param configuration the configuration block.
 * @return the styled control added.
 */
inline fun <T> NodeManager.styledJFXListView(
    vararg styleClass: String,
    id: String? = null,
    configuration: (@LayoutDslMarker JFXListView<T>).() -> Unit
): JFXListView<T> {
    contract { callsInPlace(configuration, EXACTLY_ONCE) }
    return addChild(
        newChild(
            JFXListView<T>(), styleClass = *styleClass, id = id,
            configuration =
                configuration
        )
    )
}
