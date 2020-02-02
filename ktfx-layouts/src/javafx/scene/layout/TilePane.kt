@file:JvmMultifileClass
@file:JvmName("LayoutsKt")
@file:UseExperimental(ExperimentalContracts::class)
@file:Suppress("NOTHING_TO_INLINE")

package ktfx.layouts

import javafx.geometry.Insets
import javafx.geometry.Orientation
import javafx.geometry.Pos
import javafx.scene.Node
import javafx.scene.layout.TilePane
import kotlin.DeprecationLevel.ERROR
import kotlin.contracts.ExperimentalContracts
import kotlin.contracts.InvocationKind
import kotlin.contracts.contract
import ktfx.internal.KtfxInternals.NO_GETTER
import ktfx.internal.KtfxInternals.noGetter

/**
 * [TilePane] with dynamic-layout dsl support.
 * Invoking dsl will add its children.
 */
open class KtfxTilePane(orientation: Orientation, hgap: Double, vgap: Double) : TilePane(orientation, hgap, vgap),
    NodeManager {

    final override fun <C : Node> addChild(child: C): C = child.also { children += it }

    final override val childCount: Int get() = childrenUnmodifiable.size

    /** Clear children constraints. */
    @JvmName("clearConstraints2")
    inline fun Node.clearConstraints(): Unit = clearConstraints(this)

    /** Children alignment in this layout. */
    inline var Node.alignment: Pos?
        @JvmName("getAlignment2") get() = getAlignment(this)
        @JvmName("setAlignment2") set(value) = setAlignment(this, value)

    /** Configure alignment fluidly using infix operator. */
    inline infix fun <C : Node> C.align(pos: Pos): C = apply { alignment = pos }

    /** Children margin in this layout. */
    inline var Node.margin: Insets?
        @JvmName("getMargin2") get() = getMargin(this)
        @JvmName("setMargin2") set(value) = setMargin(this, value)

    /** Top margin of this children. */
    var Node.topMargin: Double?
        inline get() = margin?.top
        set(value) {
            margin = Insets(value ?: 0.0, rightMargin ?: 0.0, bottomMargin ?: 0.0, leftMargin ?: 0.0)
        }

    /** Right margin of this children. */
    var Node.rightMargin: Double?
        inline get() = margin?.right
        set(value) {
            margin = Insets(topMargin ?: 0.0, value ?: 0.0, bottomMargin ?: 0.0, leftMargin ?: 0.0)
        }

    /** Bottom margin of this children. */
    var Node.bottomMargin: Double?
        inline get() = margin?.bottom
        set(value) {
            margin = Insets(topMargin ?: 0.0, rightMargin ?: 0.0, value ?: 0.0, leftMargin ?: 0.0)
        }

    /** Left margin of this children. */
    var Node.leftMargin: Double?
        inline get() = margin?.left
        set(value) {
            margin = Insets(topMargin ?: 0.0, rightMargin ?: 0.0, bottomMargin ?: 0.0, value ?: 0.0)
        }

    /** Sets left and right margin of this children. */
    var Node.horizontalMargin: Double?
        @Deprecated(NO_GETTER, level = ERROR) get() = noGetter()
        set(value) {
            margin = Insets(topMargin ?: 0.0, value ?: 0.0, bottomMargin ?: 0.0, value ?: 0.0)
        }

    /** Sets top and bottom margin of this children. */
    var Node.verticalMargin: Double?
        @Deprecated(NO_GETTER, level = ERROR) get() = noGetter()
        set(value) {
            margin = Insets(value ?: 0.0, rightMargin ?: 0.0, value ?: 0.0, leftMargin ?: 0.0)
        }

    /** Sets margin to all sides of this children. */
    var Node.allMargin: Double?
        @Deprecated(NO_GETTER, level = ERROR) get() = noGetter()
        set(value) {
            margin = Insets(value ?: 0.0)
        }

    /** Configure margin fluidly using infix operator. */
    inline infix fun <C : Node> C.margin(insets: Insets): C = apply { margin = insets }

    /** Configure top margin fluidly using infix operator. */
    inline infix fun <C : Node> C.topMargin(margin: Double): C = apply { topMargin = margin }

    /** Configure right margin fluidly using infix operator. */
    inline infix fun <C : Node> C.rightMargin(margin: Double): C = apply { rightMargin = margin }

    /** Configure bottom margin fluidly using infix operator. */
    inline infix fun <C : Node> C.bottomMargin(margin: Double): C = apply { bottomMargin = margin }

    /** Configure left margin fluidly using infix operator. */
    inline infix fun <C : Node> C.leftMargin(margin: Double): C = apply { leftMargin = margin }

    /** Configure horizontal margin fluidly using infix operator. */
    inline infix fun <C : Node> C.horizontalMargin(margin: Double): C = apply { horizontalMargin = margin }

    /** Configure vertical margin fluidly using infix operator. */
    inline infix fun <C : Node> C.verticalMargin(margin: Double): C = apply { verticalMargin = margin }

    /** Configure all margin fluidly using infix operator. */
    inline infix fun <C : Node> C.allMargin(margin: Double): C = apply { allMargin = margin }
}

/** Create a [TilePane] with initialization block. */
inline fun tilePane(
    orientation: Orientation = Orientation.HORIZONTAL,
    hgap: Double = 0.0,
    vgap: Double = hgap,
    init: (@LayoutsDslMarker KtfxTilePane).() -> Unit
): TilePane {
    contract { callsInPlace(init, InvocationKind.EXACTLY_ONCE) }
    return KtfxTilePane(orientation, hgap, vgap).apply(init)
}

/** Add a [TilePane] to this manager. */
fun NodeManager.tilePane(
    orientation: Orientation = Orientation.HORIZONTAL,
    hgap: Double = 0.0,
    vgap: Double = hgap
): TilePane = addChild(KtfxTilePane(orientation, hgap, vgap))

/** Add a [TilePane] with initialization block to this manager. */
inline fun NodeManager.tilePane(
    orientation: Orientation = Orientation.HORIZONTAL,
    hgap: Double = 0.0,
    vgap: Double = 0.0,
    init: (@LayoutsDslMarker KtfxTilePane).() -> Unit
): TilePane {
    contract { callsInPlace(init, InvocationKind.EXACTLY_ONCE) }
    return addChild(KtfxTilePane(orientation, hgap, vgap), init)
}
