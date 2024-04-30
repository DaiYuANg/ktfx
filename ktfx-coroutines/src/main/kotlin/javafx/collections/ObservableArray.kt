@file:JvmMultifileClass
@file:JvmName("KtfxCoroutinesKt")

package ktfx.coroutines

import javafx.collections.ArrayChangeListener
import javafx.collections.ObservableArray
import kotlinx.coroutines.*
import kotlinx.coroutines.javafx.JavaFx

/** Add a listener to this observable array. */
@OptIn(DelicateCoroutinesApi::class)
fun <T : ObservableArray<T>> ObservableArray<T>.listener(
    context: kotlin.coroutines.CoroutineContext = Dispatchers.JavaFx,
    listener: suspend CoroutineScope.(array: T, changed: Boolean, from: Int, to: Int) -> Unit,
): ArrayChangeListener<T> =
    ArrayChangeListener<T> { array, changed, from, to ->
          GlobalScope.launch(context) { listener(array, changed, from, to) }
        }
        .also { addListener(it) }
