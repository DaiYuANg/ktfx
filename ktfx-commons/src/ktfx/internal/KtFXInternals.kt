package ktfx.internal

import javafx.geometry.HPos
import javafx.geometry.Pos
import javafx.geometry.Pos.CENTER
import javafx.geometry.Pos.valueOf
import javafx.geometry.VPos
import javafx.scene.Node
import javafx.scene.control.ButtonType
import javafx.scene.control.Dialog

@Suppress("NOTHING_TO_INLINE")
object KtFXInternals {

    const val NO_GETTER: String = "Property does not have a getter"

    /** Some mutable backing fields are only used to set value. */
    inline fun noGetter(): Nothing = fail { NO_GETTER }

    inline fun fail(lazyMessage: () -> Any): Nothing = throw UnsupportedOperationException(lazyMessage().toString())

    @PublishedApi
    internal fun posOf(vpos: VPos, hpos: HPos): Pos = "${vpos}_$hpos".let {
        if (it == "CENTER_CENTER") CENTER else valueOf(it)
    }

    @PublishedApi
    internal fun Dialog<*>.addButton(button: ButtonType, init: Node.() -> Unit) = dialogPane.run {
        buttonTypes += button
        lookupButton(button).init()
    }
}