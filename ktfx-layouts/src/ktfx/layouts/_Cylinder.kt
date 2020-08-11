@file:JvmMultifileClass
@file:JvmName("LayoutsKt")
@file:OptIn(ExperimentalContracts::class)

package ktfx.layouts

import javafx.scene.shape.Cylinder
import ktfx.internal.KtfxInternals.newChild
import kotlin.Double
import kotlin.Int
import kotlin.String
import kotlin.Unit
import kotlin.contracts.ExperimentalContracts
import kotlin.contracts.InvocationKind.EXACTLY_ONCE
import kotlin.contracts.contract
import kotlin.jvm.JvmMultifileClass
import kotlin.jvm.JvmName

/**
 * Add a [Cylinder] to this manager.
 *
 * @return the control added.
 */
fun NodeManager.cylinder(
    radius: Double = 1.0,
    height: Double = 2.0,
    division: Int = 64
): Cylinder = cylinder(radius = radius, height = height, division = division) { }

/**
 * Create a [Cylinder] with configuration block.
 * @param configuration the configuration block.
 *
 * @return the control created.
 */
inline fun cylinder(
    radius: Double = 1.0,
    height: Double = 2.0,
    division: Int = 64,
    configuration: (@LayoutDslMarker Cylinder).() -> Unit
): Cylinder {
    contract { callsInPlace(configuration, EXACTLY_ONCE) }
    return newChild(Cylinder(radius, height, division), configuration = configuration)
}

/**
 * Add a [Cylinder] with configuration block to this manager.
 * @param configuration the configuration block.
 *
 * @return the control added.
 */
inline fun NodeManager.cylinder(
    radius: Double = 1.0,
    height: Double = 2.0,
    division: Int = 64,
    configuration: (@LayoutDslMarker Cylinder).() -> Unit
): Cylinder {
    contract { callsInPlace(configuration, EXACTLY_ONCE) }
    return addChild(newChild(Cylinder(radius, height, division), configuration = configuration))
}

/**
 * Create a styled [Cylinder].
 * @param styleClass the CSS style class.
 * @param id the CSS id.
 *
 * @return the styled control created.
 */
fun styledCylinder(
    radius: Double = 1.0,
    height: Double = 2.0,
    division: Int = 64,
    vararg styleClass: String,
    id: String? = null
): Cylinder = styledCylinder(
    radius = radius, height = height, division = division,
    styleClass =
        *styleClass,
    id = id
) { }

/**
 * Add a styled [Cylinder] to this manager.
 * @param styleClass the CSS style class.
 * @param id the CSS id.
 *
 * @return the styled control added.
 */
fun NodeManager.styledCylinder(
    radius: Double = 1.0,
    height: Double = 2.0,
    division: Int = 64,
    vararg styleClass: String,
    id: String? = null
): Cylinder = styledCylinder(
    radius = radius, height = height, division = division,
    styleClass =
        *styleClass,
    id = id
) { }

/**
 * Create a styled [Cylinder] with configuration block.
 * @param styleClass the CSS style class.
 * @param id the CSS id.
 * @param configuration the configuration block.
 *
 * @return the styled control created.
 */
inline fun styledCylinder(
    radius: Double = 1.0,
    height: Double = 2.0,
    division: Int = 64,
    vararg styleClass: String,
    id: String? = null,
    configuration: (@LayoutDslMarker Cylinder).() -> Unit
): Cylinder {
    contract { callsInPlace(configuration, EXACTLY_ONCE) }
    return newChild(
        Cylinder(radius, height, division), styleClass = *styleClass, id = id,
        configuration = configuration
    )
}

/**
 * Add a styled [Cylinder] with configuration block to this manager.
 * @param styleClass the CSS style class.
 * @param id the CSS id.
 * @param configuration the configuration block.
 *
 * @return the styled control added.
 */
inline fun NodeManager.styledCylinder(
    radius: Double = 1.0,
    height: Double = 2.0,
    division: Int = 64,
    vararg styleClass: String,
    id: String? = null,
    configuration: (@LayoutDslMarker Cylinder).() -> Unit
): Cylinder {
    contract { callsInPlace(configuration, EXACTLY_ONCE) }
    return addChild(
        newChild(
            Cylinder(radius, height, division), styleClass = *styleClass, id = id,
            configuration = configuration
        )
    )
}
