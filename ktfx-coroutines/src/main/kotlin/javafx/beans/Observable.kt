@file:JvmMultifileClass
@file:JvmName("KtfxCoroutinesKt")

package ktfx.coroutines

import javafx.beans.InvalidationListener
import javafx.beans.Observable
import kotlin.coroutines.CoroutineContext
import kotlinx.coroutines.*
import kotlinx.coroutines.javafx.JavaFx

/**
 * Adds an [InvalidationListener] which will be notified whenever the [Observable] becomes invalid.
 */
@OptIn(DelicateCoroutinesApi::class)
fun Observable.listener(
    context: CoroutineContext = Dispatchers.JavaFx,
    listener: suspend CoroutineScope.(Observable) -> Unit,
): InvalidationListener =
    InvalidationListener { observable -> GlobalScope.launch(context) { listener(observable) } }
        .also { addListener(it) }
