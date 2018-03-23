@file:Suppress("NOTHING_TO_INLINE")

package ktfx.scene.input

import javafx.scene.input.KeyCharacterCombination
import javafx.scene.input.KeyEvent

/** Tests whether this key combination matches the key combination in the given event. */
inline operator fun KeyCharacterCombination.contains(event: KeyEvent): Boolean = match(event)