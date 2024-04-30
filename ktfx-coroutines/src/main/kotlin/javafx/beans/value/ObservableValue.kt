@file:JvmMultifileClass
@file:JvmName("KtfxCoroutinesKt")

package ktfx.coroutines

import javafx.beans.Observable
import javafx.beans.value.ChangeListener
import javafx.beans.value.ObservableValue
import kotlinx.coroutines.*
import kotlin.coroutines.CoroutineContext
import kotlinx.coroutines.javafx.JavaFx

/**
 * Adds a [ChangeListener] which will be notified whenever the value of the [ObservableValue]
 * changes.
 */
@OptIn(DelicateCoroutinesApi::class)
fun <T> ObservableValue<T>.listener(
    context: CoroutineContext = Dispatchers.JavaFx,
    listener: suspend CoroutineScope.(Observable, oldValue: T, value: T) -> Unit,
) =
    ChangeListener { observable, oldValue, newValue ->
          GlobalScope.launch(context) { listener(observable, oldValue, newValue) }
        }
        .also { addListener(it) }
