package ktfx.coroutines

import com.hendraanggrian.ktfx.test.BaseMediaTest
import javafx.scene.media.Media
import kotlin.test.Ignore
import kotlinx.coroutines.Dispatchers

@Ignore
class MediaTest : BaseMediaTest() {
  override fun Media.callOnError(action: () -> Unit) = onError(Dispatchers.Unconfined) { action() }
}
