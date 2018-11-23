@file:Suppress("PackageDirectoryMismatch", "NOTHING_TO_INLINE", "ClassName")

package ktfx.jfoenix

import com.jfoenix.controls.JFXToolbar
import javafx.scene.Node
import ktfx.layouts.HBoxConstraints
import ktfx.layouts.LayoutDsl
import ktfx.layouts.NodeInvokable

open class _JFXToolbar : JFXToolbar() {

    fun leftItems(init: (@LayoutDsl HBoxConstraints).() -> Unit) {
        object : HBoxConstraints {
            override fun <R : Node> R.invoke(): R = also { leftItems += it }
        }.apply(init)
    }

    fun rightItems(init: (@LayoutDsl HBoxConstraints).() -> Unit) {
        object : HBoxConstraints {
            override fun <R : Node> R.invoke(): R = also { rightItems += it }
        }.apply(init)
    }
}

/** Creates a [JFXToolbar]. */
fun jfxToolbar(
    init: ((@LayoutDsl _JFXToolbar).() -> Unit)? = null
): JFXToolbar = _JFXToolbar().also { init?.invoke(it) }

/** Creates a [JFXToolbar] and add it to this manager. */
inline fun NodeInvokable.jfxToolbar(
    noinline init: ((@LayoutDsl _JFXToolbar).() -> Unit)? = null
): JFXToolbar = ktfx.jfoenix.jfxToolbar(init)()