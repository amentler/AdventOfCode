package d7p1

fun main() {
    val fileContent = object {}.javaClass.getResource("/inputd7")?.readText() as String

    val lines = transformInput(fileContent)
    println(part1(lines))
}

fun transformInput(fileContent: String): List<Int> {
    return fileContent.split(",").map { it.trim() }.map(String::toInt)
}

fun part1(fuels: List<Int>): Int {
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
    fuels.sumOf { Math.abs(it - count) }
