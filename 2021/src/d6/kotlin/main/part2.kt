package d6p2

import java.math.BigInteger

fun main() {
    val fileContent = object {}.javaClass.getResource("/inputd6")?.readText() as String

    val lines = transformInput(fileContent)
    println(part2(lines, 256))
}

fun transformInput(fileContent: String): List<Int> {
    return fileContent.split(",").map { it.trim() }.map(String::toInt)
}


fun part2(input: List<Int>, days: Int): Long {
    val interval = 10
    var reproductions = LongArray(interval)
    input.forEach {
        reproductions[it] = reproductions[it] + 1
    }
    var intervalDay = 0

    for (day in 0 until days) {
        val newFishReproductionIndex = (intervalDay + 9) % interval
        reproductions[newFishReproductionIndex] += reproductions[intervalDay] + reproductions[newFishReproductionIndex]
        val nextCycleDayIndex = (intervalDay + 7) % interval
        reproductions[nextCycleDayIndex] = reproductions[intervalDay] + reproductions[nextCycleDayIndex]
        reproductions[intervalDay] = 0
        intervalDay = (intervalDay + 1) % interval
    }

    return reproductions.sum()
}