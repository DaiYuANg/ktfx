package ktfx.coroutines

import com.hendraanggrian.ktfx.test.BaseMenuTest
import javafx.event.Event
import javafx.scene.control.Menu
import kotlinx.coroutines.Dispatchers

class MenuTest : BaseMenuTest() {
  override fun Menu.callOnShowing(action: (Event) -> Unit) =
      onShowing(Dispatchers.Unconfined) { action(it) }

  override fun Menu.callOnShown(action: (Event) -> Unit) =
      onShown(Dispatchers.Unconfined) { action(it) }

  override fun Menu.callOnHiding(action: (Event) -> Unit) =
      onHiding(Dispatchers.Unconfined) { action(it) }

  override fun Menu.callOnHidden(action: (Event) -> Unit) =
      onHidden(Dispatchers.Unconfined) { action(it) }
}
