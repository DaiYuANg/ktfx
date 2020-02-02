@file:JvmMultifileClass
@file:JvmName("LayoutsKt")
@file:UseExperimental(ExperimentalContracts::class)

package ktfx.layouts

import javafx.scene.Node
import javafx.scene.control.Menu
import javafx.scene.control.MenuBar
import kotlin.contracts.ExperimentalContracts
import kotlin.contracts.InvocationKind
import kotlin.contracts.contract

/**
 * [MenuBar] with dynamic-layout dsl support.
 * Invoking dsl will add its children.
 */
open class KtfxMenuBar : MenuBar(), MenuManager {

    final override fun <C : Menu> addChild(child: C): C = child.also { menus += it }

    final override val childCount: Int get() = menus.size

    /** Call [MenuManager.menu] by string invocation. */
    inline operator fun String.invoke(
        graphic: Node? = null,
        init: (@LayoutsDslMarker KtfxMenu).() -> Unit
    ): Menu = menu(this, graphic, init)
}

/** Create a [MenuBar] with initialization block. */
inline fun menuBar(
    init: (@LayoutsDslMarker KtfxMenuBar).() -> Unit
): MenuBar {
    contract { callsInPlace(init, InvocationKind.EXACTLY_ONCE) }
    return KtfxMenuBar().apply(init)
}

/** Add a [MenuBar] to this manager. */
fun NodeManager.menuBar(): MenuBar = addChild(KtfxMenuBar())

/** Add a [MenuBar] with initialization block to this manager. */
inline fun NodeManager.menuBar(
    init: (@LayoutsDslMarker KtfxMenuBar).() -> Unit
): MenuBar {
    contract { callsInPlace(init, InvocationKind.EXACTLY_ONCE) }
    return addChild(KtfxMenuBar(), init)
}
