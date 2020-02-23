@file:JvmMultifileClass
@file:JvmName("LayoutsKt")
@file:UseExperimental(ExperimentalContracts::class)

package ktfx.layouts

import javafx.scene.control.TextField
import kotlin.String
import kotlin.Unit
import kotlin.contracts.ExperimentalContracts
import kotlin.contracts.InvocationKind.EXACTLY_ONCE
import kotlin.contracts.contract
import kotlin.jvm.JvmMultifileClass
import kotlin.jvm.JvmName
import ktfx.internal.KtfxInternals.newChild

/**
 * Create a styled [TextField].
 */
fun styledTextField(text: String? = null, vararg styleClass: String): TextField =
        styledTextField(text = text, styleClass = *styleClass) { }

/**
 * Add a styled [TextField] to this manager.
 */
fun NodeManager.styledTextField(text: String? = null, vararg styleClass: String): TextField =
        styledTextField(text = text, styleClass = *styleClass) { }

/**
 * Create a styled [TextField] with configuration block.
 */
inline fun styledTextField(
    text: String? = null,
    vararg styleClass: String,
    configuration: (@LayoutDslMarker TextField).() -> Unit
): TextField {
    contract { callsInPlace(configuration, EXACTLY_ONCE) }
    return newChild(TextField(text), styleClass = *styleClass, configuration = configuration)
}

/**
 * Add a styled [TextField] with configuration block to this manager.
 */
inline fun NodeManager.styledTextField(
    text: String? = null,
    vararg styleClass: String,
    configuration: (@LayoutDslMarker TextField).() -> Unit
): TextField {
    contract { callsInPlace(configuration, EXACTLY_ONCE) }
    return addChild(newChild(TextField(text), styleClass = *styleClass, configuration =
            configuration))
}

/**
 * Add a [TextField] to this manager.
 */
fun NodeManager.textField(text: String? = null): TextField = textField(text = text) { }

/**
 * Create a [TextField] with configuration block.
 */
inline fun textField(text: String? = null, configuration: (@LayoutDslMarker TextField).() -> Unit):
        TextField {
    contract { callsInPlace(configuration, EXACTLY_ONCE) }
    return newChild(TextField(text), configuration = configuration)
}

/**
 * Add a [TextField] with configuration block to this manager.
 */
inline fun NodeManager.textField(
    text: String? = null,
    configuration: (@LayoutDslMarker    
            TextField).() -> Unit
): TextField {
    contract { callsInPlace(configuration, EXACTLY_ONCE) }
    return addChild(newChild(TextField(text), configuration = configuration))
}
