package ru.meetup.patterns.core

import org.knowm.xchart.BitmapEncoder
import org.knowm.xchart.QuickChart
import org.knowm.xchart.SwingWrapper

class Graph(val graphName: String, val xData: DoubleArray, val lines: List<Line>) {


    fun showChart() {


        val chart = QuickChart.getChart(graphName, "Элемент", "Время", lines.get(0).entityName, xData, removeNoise(lines.get(0).yData))
        for (i in 1..lines.size - 1) {
            chart.addSeries(lines.get(i).entityName, removeNoise(lines.get(i).yData))
        }
        SwingWrapper(chart).displayChart()

        BitmapEncoder.saveBitmap(chart, "./Sample_Chart", BitmapEncoder.BitmapFormat.PNG)

        BitmapEncoder.saveBitmapWithDPI(chart, "./Sample_Chart_300_DPI", BitmapEncoder.BitmapFormat.PNG, 300)
    }

    private fun removeNoise(yData: DoubleArray): DoubleArray? {
        val average = yData.average()
        return yData.map { it -> if (it > average) 0.0 else it }.toDoubleArray()
    }

}