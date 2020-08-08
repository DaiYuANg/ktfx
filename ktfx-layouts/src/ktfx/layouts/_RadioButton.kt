@file:JvmMultifileClass
@file:JvmName("LayoutsKt")
@file:OptIn(ExperimentalContracts::class)

package ktfx.layouts

import javafx.scene.control.RadioButton
import ktfx.internal.KtfxInternals.newChild
import kotlin.String
import kotlin.Unit
import kotlin.contracts.ExperimentalContracts
import kotlin.contracts.InvocationKind.EXACTLY_ONCE
import kotlin.contracts.contract
import kotlin.jvm.JvmMultifileClass
import kotlin.jvm.JvmName

/**
 * Add a [RadioButton] to this manager.
 *
 * @return the control added.
 */
fun NodeManager.radioButton(text: String? = null): RadioButton = radioButton(text = text) { }

/**
 * Add a [RadioButton] to this manager.
 *
 * @return the control added.
 */
fun ToggleButtonManager.radioButton(text: String? = null): RadioButton = radioButton(text = text) {
}

/**
 * Create a [RadioButton] with configuration block.
 * @param configuration the configuration block.
 *
 * @return the control created.
 */
inline fun radioButton(
    text: String? = null,
    configuration: (@LayoutDslMarker RadioButton).() ->    
    Unit
): RadioButton {
    contract { callsInPlace(configuration, EXACTLY_ONCE) }
    return newChild(RadioButton(text), configuration = configuration)
}

/**
 * Add a [RadioButton] with configuration block to this manager.
 * @param configuration the configuration block.
 *
 * @return the control added.
 */
inline fun NodeManager.radioButton(
    text: String? = null,
    configuration: (
        @LayoutDslMarker    
        RadioButton
    ).() -> Unit
): RadioButton {
    contract { callsInPlace(configuration, EXACTLY_ONCE) }
    return addChild(newChild(RadioButton(text), configuration = configuration))
}

/**
 * Add a [RadioButton] with configuration block to this manager.
 * @param configuration the configuration block.
 *
 * @return the control added.
 */
inline fun ToggleButtonManager.radioButton(
    text: String? = null,
    configuration: (
        @LayoutDslMarker    
        RadioButton
    ).() -> Unit
): RadioButton {
    contract { callsInPlace(configuration, EXACTLY_ONCE) }
    return addChild(newChild(RadioButton(text), configuration = configuration))
}

/**
 * Create a styled [RadioButton].
 * @param styleClass the CSS style class.
 * @param id the CSS id.
 *
 * @return the styled control created.
 */
fun styledRadioButton(
    text: String? = null,
    vararg styleClass: String,
    id: String? = null
): RadioButton = styledRadioButton(text = text, styleClass = *styleClass, id = id) { }

/**
 * Add a styled [RadioButton] to this manager.
 * @param styleClass the CSS style class.
 * @param id the CSS id.
 *
 * @return the styled control added.
 */
fun NodeManager.styledRadioButton(
    text: String? = null,
    vararg styleClass: String,
    id: String? = null
): RadioButton = styledRadioButton(text = text, styleClass = *styleClass, id = id) { }

/**
 * Add a styled [RadioButton] to this manager.
 * @param styleClass the CSS style class.
 * @param id the CSS id.
 *
 * @return the styled control added.
 */
fun ToggleButtonManager.styledRadioButton(
    text: String? = null,
    vararg styleClass: String,
    id: String? = null
): RadioButton = styledRadioButton(text = text, styleClass = *styleClass, id = id) { }

/**
 * Create a styled [RadioButton] with configuration block.
 * @param styleClass the CSS style class.
 * @param id the CSS id.
 * @param configuration the configuration block.
 *
 * @return the styled control created.
 */
inline fun styledRadioButton(
    text: String? = null,
    vararg styleClass: String,
    id: String? = null,
    configuration: (@LayoutDslMarker RadioButton).() -> Unit
): RadioButton {
    contract { callsInPlace(configuration, EXACTLY_ONCE) }
    return newChild(
        RadioButton(text), styleClass = *styleClass, id = id,
        configuration =
            configuration
    )
}

/**
 * Add a styled [RadioButton] with configuration block to this manager.
 * @param styleClass the CSS style class.
 * @param id the CSS id.
 * @param configuration the configuration block.
 *
 * @return the styled control added.
 */
inline fun NodeManager.styledRadioButton(
    text: String? = null,
    vararg styleClass: String,
    id: String? = null,
    configuration: (@LayoutDslMarker RadioButton).() -> Unit
): RadioButton {
    contract { callsInPlace(configuration, EXACTLY_ONCE) }
    return addChild(
        newChild(
            RadioButton(text), styleClass = *styleClass, id = id,
            configuration =
                configuration
        )
    )
}

/**
 * Add a styled [RadioButton] with configuration block to this manager.
 * @param styleClass the CSS style class.
 * @param id the CSS id.
 * @param configuration the configuration block.
 *
 * @return the styled control added.
 */
inline fun ToggleButtonManager.styledRadioButton(
    text: String? = null,
    vararg styleClass: String,
    id: String? = null,
    configuration: (@LayoutDslMarker RadioButton).() -> Unit
): RadioButton {
    contract { callsInPlace(configuration, EXACTLY_ONCE) }
    return addChild(
        newChild(
            RadioButton(text), styleClass = *styleClass, id = id,
            configuration =
                configuration
        )
    )
}
