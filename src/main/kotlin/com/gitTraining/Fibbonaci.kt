package com.gitTraining

fun computeFibbonaciNumber(position: Int, recursion: Boolean = false): Int {
    if (recursion) return recursiveFibbonachi(position)

    if (position == 0) return 0
    if (position < 0) {
        val positionIsOdd = position % 2 == -1
        return if (positionIsOdd) computeFibbonaciNumber(-position) else (computeFibbonaciNumber(-position) * -1)
    }

    if (position == 1 || position == 2) return 1

    var smallFibbonachiNumber = 1
    var largeFibbonachiNumber = 1



    var currentPosition = 2
    while (currentPosition < position) {
        val nextFibbonachiNumber = smallFibbonachiNumber + largeFibbonachiNumber
        smallFibbonachiNumber = largeFibbonachiNumber
        largeFibbonachiNumber = nextFibbonachiNumber
        currentPosition ++
    }
    return largeFibbonachiNumber
}

fun computeFibbonachiArray(start: Int, end: Int, efficient: Boolean = false): List<Int> {
    if (!efficient) return (start..end).map { computeFibbonaciNumber(it) }
    if (start > end) return listOf()
    if (start == end) return listOf(computeFibbonaciNumber(start))
    val output = mutableListOf(computeFibbonaciNumber(start), computeFibbonaciNumber(start + 1))
    (2..(end-start)).forEach { output.add(output[it-2] + output[it-1]) }
    return output
}
fun recursiveFibbonachi(initialPosition: Int, left: Int = 0, right: Int = 1, position: Int = initialPosition): Int {
    if (initialPosition == 0) return 0
    if (position == 0) return left
    if (initialPosition > 0) {
        return recursiveFibbonachi(initialPosition, right, left + right, position - 1)
    } else {
        return recursiveFibbonachi(initialPosition, right - left, left, position + 1)
    }
}

