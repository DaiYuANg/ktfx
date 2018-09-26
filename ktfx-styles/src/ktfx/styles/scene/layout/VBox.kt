@file:Suppress("PackageDirectoryMismatch")

/* ktlint-disable package-name */
package ktfx.styles

/* ktlint-enable package-name */

import javafx.geometry.Pos
import ktfx.styles.internal._VBoxStyleBuilder

interface VBoxStyleBuilder {

    var spacing: Number

    var alignment: Pos

    var fillWidth: Boolean
}

inline fun vboxStyle(
    prettyPrint: Boolean = false,
    builder: VBoxStyleBuilder.() -> Unit
): String = _VBoxStyleBuilder(prettyPrint).apply(builder).toString()