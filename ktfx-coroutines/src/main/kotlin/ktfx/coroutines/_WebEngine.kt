@file:JvmMultifileClass
@file:JvmName("KtfxCoroutinesKt")
@file:Suppress("ktlint")

package ktfx.coroutines

import javafx.geometry.Rectangle2D
import javafx.scene.web.WebEngine
import javafx.scene.web.WebErrorEvent
import javafx.scene.web.WebEvent
import kotlinx.coroutines.*
import kotlin.Boolean
import kotlin.String
import kotlin.Suppress
import kotlin.Unit
import kotlin.coroutines.CoroutineContext
import kotlin.jvm.JvmMultifileClass
import kotlin.jvm.JvmName
import kotlinx.coroutines.javafx.JavaFx

/** @see WebEngine.setOnAlert */
fun WebEngine.onAlert(
    context: CoroutineContext = Dispatchers.JavaFx,
    action: suspend CoroutineScope.(WebEvent<String>) -> Unit
): Unit = setOnAlert { event -> GlobalScope.launch(context) { action(event) } }

/** @see WebEngine.setOnStatusChanged */
fun WebEngine.onStatusChanged(
    context: CoroutineContext = Dispatchers.JavaFx,
    action: suspend CoroutineScope.(WebEvent<String>) -> Unit
): Unit = setOnStatusChanged { event -> GlobalScope.launch(context) { action(event) } }

/** @see WebEngine.setOnResized */
fun WebEngine.onResized(
    context: CoroutineContext = Dispatchers.JavaFx,
    action: suspend CoroutineScope.(WebEvent<Rectangle2D>) -> Unit
): Unit = setOnResized { event -> GlobalScope.launch(context) { action(event) } }

/** @see WebEngine.setOnVisibilityChanged */
fun WebEngine.onVisibilityChanged(
    context: CoroutineContext = Dispatchers.JavaFx,
    action: suspend CoroutineScope.(WebEvent<Boolean>) -> Unit
): Unit = setOnVisibilityChanged { event -> GlobalScope.launch(context) { action(event) } }

/** @see WebEngine.setOnError */
fun WebEngine.onError(
    context: CoroutineContext = Dispatchers.JavaFx,
    action: suspend CoroutineScope.(WebErrorEvent) -> Unit
): Unit = setOnError { event -> GlobalScope.launch(context) { action(event) } }
