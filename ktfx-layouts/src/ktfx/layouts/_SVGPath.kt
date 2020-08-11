@file:JvmMultifileClass
@file:JvmName("LayoutsKt")
@file:OptIn(ExperimentalContracts::class)

package ktfx.layouts

import javafx.scene.shape.SVGPath
import ktfx.internal.KtfxInternals.newChild
import kotlin.String
import kotlin.Unit
import kotlin.contracts.ExperimentalContracts
import kotlin.contracts.InvocationKind.EXACTLY_ONCE
import kotlin.contracts.contract
import kotlin.jvm.JvmMultifileClass
import kotlin.jvm.JvmName

/**
 * Add a [SVGPath] to this manager.
 *
 * @return the control added.
 */
fun NodeManager.svgPath(): SVGPath = svgPath() { }

/**
 * Create a [SVGPath] with configuration block.
 *
 * @param configuration the configuration block.
 * @return the control created.
 */
inline fun svgPath(configuration: (@LayoutDslMarker SVGPath).() -> Unit): SVGPath {
    contract { callsInPlace(configuration, EXACTLY_ONCE) }
    return newChild(SVGPath(), configuration = configuration)
}

/**
 * Add a [SVGPath] with configuration block to this manager.
 *
 * @param configuration the configuration block.
 * @return the control added.
 */
inline fun NodeManager.svgPath(configuration: (@LayoutDslMarker SVGPath).() -> Unit): SVGPath {
    contract { callsInPlace(configuration, EXACTLY_ONCE) }
    return addChild(newChild(SVGPath(), configuration = configuration))
}

/**
 * Create a styled [SVGPath].
 *
 * @param styleClass the CSS style class.
 * @param id the CSS id.
 * @return the styled control created.
 */
fun styledSVGPath(vararg styleClass: String, id: String? = null): SVGPath = styledSVGPath(
    styleClass =
        *styleClass,
    id = id
) { }

/**
 * Add a styled [SVGPath] to this manager.
 *
 * @param styleClass the CSS style class.
 * @param id the CSS id.
 * @return the styled control added.
 */
fun NodeManager.styledSVGPath(vararg styleClass: String, id: String? = null): SVGPath =
    styledSVGPath(styleClass = *styleClass, id = id) { }

/**
 * Create a styled [SVGPath] with configuration block.
 *
 * @param styleClass the CSS style class.
 * @param id the CSS id.
 * @param configuration the configuration block.
 * @return the styled control created.
 */
inline fun styledSVGPath(
    vararg styleClass: String,
    id: String? = null,
    configuration: (@LayoutDslMarker SVGPath).() -> Unit
): SVGPath {
    contract { callsInPlace(configuration, EXACTLY_ONCE) }
    return newChild(SVGPath(), styleClass = *styleClass, id = id, configuration = configuration)
}

/**
 * Add a styled [SVGPath] with configuration block to this manager.
 *
 * @param styleClass the CSS style class.
 * @param id the CSS id.
 * @param configuration the configuration block.
 * @return the styled control added.
 */
inline fun NodeManager.styledSVGPath(
    vararg styleClass: String,
    id: String? = null,
    configuration: (@LayoutDslMarker SVGPath).() -> Unit
): SVGPath {
    contract { callsInPlace(configuration, EXACTLY_ONCE) }
    return addChild(
        newChild(
            SVGPath(), styleClass = *styleClass, id = id,
            configuration =
                configuration
        )
    )
}
