@file:JvmMultifileClass
@file:JvmName("LayoutsKt")
@file:UseExperimental(ExperimentalContracts::class)

package ktfx.layouts

import javafx.scene.Node
import javafx.scene.control.Menu
import javafx.scene.control.MenuBar
import kotlin.contracts.ExperimentalContracts

/**
 * [MenuBar] with dynamic-layout dsl support.
 * Invoking dsl will add its children.
 */
open class KtfxMenuBar : MenuBar(), MenuManager {

    final override fun <C : Menu> addChild(child: C): C = child.also { menus += it }

    /** Call [MenuManager.menu] by string invocation. */
    inline operator fun String.invoke(
        graphic: Node? = null,
        configuration: (@LayoutDslMarker KtfxMenu).() -> Unit
    ): Menu = menu(this, graphic, configuration)
}