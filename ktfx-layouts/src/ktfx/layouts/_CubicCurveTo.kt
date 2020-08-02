@file:JvmMultifileClass
@file:JvmName("LayoutsKt")
@file:OptIn(ExperimentalContracts::class)

package ktfx.layouts

import javafx.scene.shape.CubicCurveTo
import ktfx.internal.KtfxInternals.newChild
import kotlin.Double
import kotlin.Unit
import kotlin.contracts.ExperimentalContracts
import kotlin.contracts.InvocationKind.EXACTLY_ONCE
import kotlin.contracts.contract
import kotlin.jvm.JvmMultifileClass
import kotlin.jvm.JvmName

/**
 * Add a [CubicCurveTo] to this manager.
 */
fun PathElementManager.cubicCurveTo(
    controlX1: Double = 0.0,
    controlY1: Double = 0.0,
    controlX2: Double = 0.0,
    controlY2: Double = 0.0,
    x: Double = 0.0,
    y: Double = 0.0
): CubicCurveTo = cubicCurveTo(
    controlX1 = controlX1, controlY1 = controlY1, controlX2 = controlX2,
    controlY2 = controlY2, x = x, y = y
) { }

/**
 * Create a [CubicCurveTo] with configuration block.
 */
inline fun cubicCurveTo(
    controlX1: Double = 0.0,
    controlY1: Double = 0.0,
    controlX2: Double = 0.0,
    controlY2: Double = 0.0,
    x: Double = 0.0,
    y: Double = 0.0,
    configuration: (@LayoutDslMarker CubicCurveTo).() -> Unit
): CubicCurveTo {
    contract { callsInPlace(configuration, EXACTLY_ONCE) }
    return newChild(
        CubicCurveTo(controlX1, controlY1, controlX2, controlY2, x, y),
        configuration =
            configuration
    )
}

/**
 * Add a [CubicCurveTo] with configuration block to this manager.
 */
inline fun PathElementManager.cubicCurveTo(
    controlX1: Double = 0.0,
    controlY1: Double = 0.0,
    controlX2: Double = 0.0,
    controlY2: Double = 0.0,
    x: Double = 0.0,
    y: Double = 0.0,
    configuration: (@LayoutDslMarker CubicCurveTo).() -> Unit
): CubicCurveTo {
    contract { callsInPlace(configuration, EXACTLY_ONCE) }
    return addChild(
        newChild(
            CubicCurveTo(controlX1, controlY1, controlX2, controlY2, x, y),
            configuration = configuration
        )
    )
}