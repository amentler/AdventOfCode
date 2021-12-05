import kotlin.ranges.IntProgression.Companion.fromClosedRange

fun main() {
    val fileContent = object {}.javaClass.getResource("/day5/input")?.readText() as String

    val lines = transformInput(fileContent)
    println(countOverlapsPart2(lines))
}

fun getCoordinatesFromStartToEndPart2(line: Line): List<Coordinate> {
    val result1: List<Coordinate>
    if (line.from.x == line.to.x || line.from.y == line.to.y) {
        val xRange = Math.min(line.from.x, line.to.x)..Math.max(line.to.x, line.from.x)
        val yRange = Math.min(line.from.y, line.to.y)..Math.max(line.to.y, line.from.y)

        result1 = listOf(
            xRange.map { Coordinate(it, line.from.y) },
            yRange.map { Coordinate(line.from.x, it) },
        ).flatten()

    } else {
        var xRange = fromClosedRange(line.from.x, line.to.x, 1)
        var yRange = fromClosedRange(line.from.y, line.to.y, 1)

        if (line.from.x > line.to.x)
            xRange = line.from.x downTo line.to.x

        if (line.from.y > line.to.y)
            yRange = line.from.y downTo line.to.y

        result1 = xRange.mapIndexed{index,_ ->
            Coordinate(xRange.elementAt(index), yRange.elementAt(index))
        }
    }
    return listOf(listOf(line.from), result1, listOf(line.to)).flatten().distinct()
}

fun countOverlapsPart2(lines: List<Line>): Int {
    return lines.map { getCoordinatesFromStartToEndPart2(it) }
        .flatten().groupBy { it }.map { it.value.size }.filter { it > 1 }.count()
}
