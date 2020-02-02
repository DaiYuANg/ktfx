@file:JvmMultifileClass
@file:JvmName("BindingKt")

package ktfx

import java.util.concurrent.Callable
import javafx.beans.Observable
import javafx.beans.binding.Bindings
import javafx.beans.binding.DoubleBinding
import javafx.beans.value.ObservableBooleanValue
import javafx.beans.value.ObservableDoubleValue
import javafx.beans.value.ObservableFloatValue
import javafx.beans.value.ObservableIntegerValue
import javafx.beans.value.ObservableLongValue
import javafx.beans.value.ObservableValue

/** Create a [DoubleBinding] with multiple [Observable] dependencies. */
inline fun doubleBindingOf(vararg dependencies: Observable, crossinline valueProvider: () -> Double): DoubleBinding =
    Bindings.createDoubleBinding(Callable { valueProvider() }, *dependencies)

/** Create a [DoubleBinding] with single [ObservableValue] dependency. */
inline fun <V> ObservableValue<V>.toDoubleBinding(crossinline valueProvider: (V?) -> Double): DoubleBinding =
    Bindings.createDoubleBinding(Callable { valueProvider(value) }, this)

/** Create a [DoubleBinding] with single [ObservableBooleanValue] dependency. */
inline fun ObservableBooleanValue.toDoubleBinding(crossinline valueProvider: (Boolean) -> Double): DoubleBinding =
    Bindings.createDoubleBinding(Callable { valueProvider(value) }, this)

/** Create a [DoubleBinding] with single [ObservableDoubleValue] dependency. */
inline fun ObservableDoubleValue.toDoubleBinding(crossinline valueProvider: (Double) -> Double): DoubleBinding =
    Bindings.createDoubleBinding(Callable { valueProvider(value as Double) }, this)

/** Create a [DoubleBinding] with single [ObservableFloatValue] dependency. */
inline fun ObservableFloatValue.toDoubleBinding(crossinline valueProvider: (Float) -> Double): DoubleBinding =
    Bindings.createDoubleBinding(Callable { valueProvider(value as Float) }, this)

/** Create a [DoubleBinding] with single [ObservableIntegerValue] dependency. */
inline fun ObservableIntegerValue.toDoubleBinding(crossinline valueProvider: (Int) -> Double): DoubleBinding =
    Bindings.createDoubleBinding(Callable { valueProvider(value as Int) }, this)

/** Create a [DoubleBinding] with single [ObservableLongValue] dependency. */
inline fun ObservableLongValue.toDoubleBinding(crossinline valueProvider: (Long) -> Double): DoubleBinding =
    Bindings.createDoubleBinding(Callable { valueProvider(value as Long) }, this)
