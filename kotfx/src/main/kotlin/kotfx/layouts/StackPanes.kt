@file:JvmMultifileClass
@file:JvmName("LayoutsKt")
@file:Suppress("NOTHING_TO_INLINE", "UNUSED")

package kotfx.layouts

import javafx.geometry.Insets
import javafx.geometry.Insets.EMPTY
import javafx.geometry.Pos
import javafx.geometry.Pos.TOP_LEFT
import javafx.scene.Node
import javafx.scene.layout.Pane
import javafx.scene.layout.StackPane
import kotfx.internal.ChildManager
import kotfx.internal.LayoutDsl

class _StackPane : StackPane(), _Alignable, _Marginable {

    override val instance: Pane get() = this

    override infix fun <T : Node> T.pos(pos: Pos): T = apply { setAlignment(this, pos) }
    override val Node.pos: Pos get() = getAlignment(this) ?: TOP_LEFT

    override infix fun <T : Node> T.margin(insets: Insets): T = apply { setMargin(this, insets) }
    override val Node.margin2: Insets get() = getMargin(this) ?: EMPTY

    override fun <T : Node> T.clearConstraints(): T = apply { clearConstraints(this) }
}

inline fun stackPane(init: (@LayoutDsl _StackPane).() -> Unit): StackPane = _StackPane().apply(init)
inline fun ChildManager.stackPane(init: (@LayoutDsl _StackPane).() -> Unit): StackPane = _StackPane().apply(init).add()