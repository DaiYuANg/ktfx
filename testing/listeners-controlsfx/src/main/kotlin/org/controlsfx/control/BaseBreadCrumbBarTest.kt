package ktfx.controlsfx.test

import com.hendraanggrian.ktfx.test.initToolkit
import kotlin.test.BeforeTest
import kotlin.test.Test
import kotlin.test.assertEquals
import org.controlsfx.control.BreadCrumbBar

abstract class BaseBreadCrumbBarTest {
  private lateinit var crumbBar: BreadCrumbBar<String>

  abstract fun <E> BreadCrumbBar<E>.callOnCrumbAction(
      action: (BreadCrumbBar.BreadCrumbActionEvent<E>) -> Unit
  )

  @BeforeTest
  fun create() {
    initToolkit()
    crumbBar = BreadCrumbBar()
  }

  @Test
  fun onCrumbAction() {
    crumbBar.callOnCrumbAction { assertEquals("Hello world", it.selectedCrumb.value) }
    crumbBar.onCrumbAction.handle(
        BreadCrumbBar.BreadCrumbActionEvent(BreadCrumbBar.buildTreeModel("Hello world")))
  }
}
