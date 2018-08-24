package ru.meetup.patterns.core

import java.util.*


class CollectionsAnalyze

val N = 50
fun main(args: Array<String>) {
    runArrayList()
}


fun runArrayList() {
    val xData = Array(N + 1, { it -> (it + 1).toDouble() })


    ////////////// 1
    val lines1 = ArrayList<Line>()
    lines1.add(Line("ArrayList", fillAllWithAnalyze(ArrayList())))
    lines1.add(Line("LinkedList", fillAllWithAnalyze(LinkedList())))
    Graph("Наполнение коллекции", xData.toDoubleArray(), lines1).showChart()

    ////////////// 2

    val lines2 = ArrayList<Line>()
    lines2.add(Line("ArrayList", findAll(fillAndReturn(ArrayList()))))
    lines2.add(Line("LinkedList", findAll(fillAndReturn(LinkedList()))))
    Graph("Получение по id", xData.toDoubleArray(), lines2).showChart()
//    findAll(list)
//    findAllBackward(list)
//    removeAll(list)
//    fillAll(list)
//    removeAllBackward(list)

}

fun fillAndReturn(list: List<Int>): List<Int> {
    if (list is ArrayList) {
        for (i in 0..N) {
            list.add(i)
        }
    }
    if (list is LinkedList) {
        for (i in 0..N) {
            list.add(i)
        }
    }

    return list
}


fun fillAll(list: List<Int>): DoubleArray {
    val yData = DoubleArray(N + 1)

    if (list is ArrayList) {
        list.add(1)
        for (i in 1..N) {
            val begin = System.nanoTime()
            list.add(i)
            val end = System.nanoTime()
            yData[i] = (end - begin).toDouble()
        }
    }

    if (list is LinkedList) {
        list.add(1)
        for (i in 1..N) {
            val begin = System.nanoTime()
            list.add(i)
            val end = System.nanoTime()
            yData[i] = (end - begin).toDouble()
        }
    }
    return yData
}


fun fillAllWithAnalyze(list: List<Int>): DoubleArray {
    val yData = DoubleArray(N + 1)

    if (list is ArrayList) {
        list.add(1)
        for (i in 1..N) {
            val begin = System.nanoTime()
            list.add(i)
            val end = System.nanoTime()
            yData[i] = (end - begin).toDouble()
        }
    }

    if (list is LinkedList) {
        list.add(1)
        for (i in 1..N) {
            val begin = System.nanoTime()
            list.add(i)
            val end = System.nanoTime()
            yData[i] = (end - begin).toDouble()
        }
    }
    return yData
}


fun findAll(list: List<Int>): DoubleArray {
    val yData = DoubleArray(N + 1)

    if (list is ArrayList) {
        for (i in 0..N) {
            val begin = System.nanoTime()
            list.get(i)
            val end = System.nanoTime()
            yData[i] = (end - begin).toDouble()
        }
    }

    if (list is LinkedList) {
        for (i in 0..N) {
            val begin = System.nanoTime()
            list.get(i)
            val end = System.nanoTime()
            yData[i] = (end - begin).toDouble()
        }
    }
    return yData
}





