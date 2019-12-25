package ktfx.controlsfx.test

import javafx.event.ActionEvent
import ktfx.test.FakeEventTarget
import ktfx.test.initToolkit
import org.controlsfx.control.HyperlinkLabel
import kotlin.test.BeforeTest
import kotlin.test.Test
import kotlin.test.assertEquals

abstract class BaseHyperlinkLabelTest() {

    abstract fun HyperlinkLabel.callOnAction(action: (ActionEvent) -> Unit)

    private lateinit var label: HyperlinkLabel

    @BeforeTest fun create() {
        initToolkit()
        label = HyperlinkLabel()
    }

    @Test fun onAction() {
        label.callOnAction {
            assertEquals(this, it.source)
            assertEquals(FakeEventTarget, it.target)
        }
        label.onAction.handle(ActionEvent(this, FakeEventTarget))
    }
}