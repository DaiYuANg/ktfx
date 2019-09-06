@file:Suppress("PackageDirectoryMismatch")

package ktfx.layouts

import javafx.collections.ObservableList
import javafx.scene.chart.Axis
import javafx.scene.chart.BarChart
import javafx.scene.chart.XYChart.Series
import ktfx.collections.mutableObservableListOf

/** Create a [BarChart] with initialization block. */
inline fun <X, Y> barChart(
    x: Axis<X>,
    y: Axis<Y>,
    data: ObservableList<Series<X, Y>> = mutableObservableListOf(),
    gap: Double = 10.0,
    init: (@LayoutDslMarker BarChart<X, Y>).() -> Unit
): BarChart<X, Y> = BarChart(x, y, data, gap).apply(init)

/** Add a [BarChart] to this manager. */
fun <X, Y> NodeManager.barChart(
    x: Axis<X>,
    y: Axis<Y>,
    data: ObservableList<Series<X, Y>> = mutableObservableListOf(),
    gap: Double = 10.0
): BarChart<X, Y> = addNode(ktfx.layouts.barChart(x, y, data, gap) { })

/** Add a [BarChart] with initialization block to this manager. */
inline fun <X, Y> NodeManager.barChart(
    x: Axis<X>,
    y: Axis<Y>,
    data: ObservableList<Series<X, Y>> = mutableObservableListOf(),
    gap: Double = 10.0,
    init: (@LayoutDslMarker BarChart<X, Y>).() -> Unit
): BarChart<X, Y> = addNode(ktfx.layouts.barChart(x, y, data, gap, init))
