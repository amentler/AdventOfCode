package d7p2

import kotlin.math.ceil

fun main() {
    val fileContent = object {}.javaClass.getResource("/inputd7")?.readText() as String

    val lines = transformInput(fileContent)
    println(part2(lines))
}

fun transformInput(fileContent: String): List<Int> {
    return fileContent.split(",").map { it.trim() }.map(String::toInt)
}

fun part2(fuels: List<Int>): Int {
    val min = fuels.minOf { it }
    val max = fuels.maxOf { it }

    var minDist = 0

    for (count in min..max) {
        val currentDist = calculateTotalFuel(fuels, count)
        if (currentDist < minDist || minDist == 0) {
            minDist = currentDist
        }
    }

    return minDist
}

fun calculateTotalFuel(fuels: List<Int>, count: Int) =
    fuels.sumOf {
        calculateDeltaFuel(Math.abs(it - count))
    }


fun calculateDeltaFuel(delta: Int): Int {
    return (0..delta).sum()
}