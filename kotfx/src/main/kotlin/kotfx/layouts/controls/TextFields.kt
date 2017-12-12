@file:Suppress("NOTHING_TO_INLINE", "UNUSED")

package kotfx.layouts.controls

import javafx.scene.control.TextField
import kotfx.internal.ChildManager
import kotfx.internal.LayoutDsl

class _TextField(text: String?) : TextField(text), _Region<TextField> {

    override val instance: TextField get() = this

}

@JvmOverloads
inline fun textField(
        text: String? = null,
        noinline init: ((@LayoutDsl _TextField).() -> Unit)? = null
): TextField = _TextField(text).apply { if (init != null) init() }

@JvmOverloads
inline fun ChildManager.textField(
        text: String? = null,
        noinline init: ((@LayoutDsl _TextField).() -> Unit)? = null
): TextField = _TextField(text).apply { if (init != null) init() }.add()