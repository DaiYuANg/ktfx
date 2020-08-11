@file:JvmMultifileClass
@file:JvmName("LayoutsKt")
@file:OptIn(ExperimentalContracts::class)

package ktfx.layouts

import javafx.scene.shape.VLineTo
import ktfx.internal.KtfxInternals.newChild
import kotlin.Double
import kotlin.Unit
import kotlin.contracts.ExperimentalContracts
import kotlin.contracts.InvocationKind.EXACTLY_ONCE
import kotlin.contracts.contract
import kotlin.jvm.JvmMultifileClass
import kotlin.jvm.JvmName

/**
 * Add a [VLineTo] to this manager.
 *
 * @return the control added.
 */
fun PathElementManager.vlineTo(y: Double = 0.0): VLineTo = vlineTo(y = y) { }

/**
 * Create a [VLineTo] with configuration block.
 * @param configuration the configuration block.
 *
 * @return the control created.
 */
inline fun vlineTo(y: Double = 0.0, configuration: (@LayoutDslMarker VLineTo).() -> Unit): VLineTo {
    contract { callsInPlace(configuration, EXACTLY_ONCE) }
    return newChild(VLineTo(y), configuration = configuration)
}

/**
 * Add a [VLineTo] with configuration block to this manager.
 * @param configuration the configuration block.
 *
 * @return the control added.
 */
inline fun PathElementManager.vlineTo(
    y: Double = 0.0,
    configuration: (
        @LayoutDslMarker    
        VLineTo
    ).() -> Unit
): VLineTo {
    contract { callsInPlace(configuration, EXACTLY_ONCE) }
    return addChild(newChild(VLineTo(y), configuration = configuration))
}
