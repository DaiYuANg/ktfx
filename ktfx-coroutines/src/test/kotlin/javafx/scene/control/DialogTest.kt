package ktfx.coroutines

import com.hendraanggrian.ktfx.test.BaseDialogTest
import javafx.scene.control.Dialog
import javafx.scene.control.DialogEvent
import kotlin.test.Ignore
import kotlinx.coroutines.Dispatchers

@Ignore
class DialogTest : BaseDialogTest() {
  override fun <E> Dialog<E>.callOnCloseRequest(action: (DialogEvent) -> Unit) =
      onCloseRequest(Dispatchers.Unconfined) { action(it) }

  override fun <E> Dialog<E>.callOnShowing(action: (DialogEvent) -> Unit) =
      onShowing(Dispatchers.Unconfined) { action(it) }

  override fun <E> Dialog<E>.callOnShown(action: (DialogEvent) -> Unit) =
      onShown(Dispatchers.Unconfined) { action(it) }

  override fun <E> Dialog<E>.callOnHiding(action: (DialogEvent) -> Unit) =
      onHiding(Dispatchers.Unconfined) { action(it) }

  override fun <E> Dialog<E>.callOnHidden(action: (DialogEvent) -> Unit) =
      onHidden(Dispatchers.Unconfined) { action(it) }
}
