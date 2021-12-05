fun main() {
    val fileContent = object {}.javaClass.getResource("/day5/input")?.readText() as String

    val lines = transformInput(fileContent)
    println(countOverlaps(lines))
}

fun getCoordinatesFromStartToEnd(line: Line): List<Coordinate> {
    val xRange = Math.min(line.from.x, line.to.x)..Math.max(line.to.x, line.from.x)
    val yRange = Math.min(line.from.y, line.to.y)..Math.max(line.to.y, line.from.y)

    val result = listOf(
        xRange.map { Coordinate(it, line.from.y) },
        yRange.map { Coordinate(line.from.x, it) }
    ).flatten().distinct().sortedBy { it.x }.sortedBy { it.y }

    return result
}

fun countOverlaps(lines: List<Line>): Int {
    return lines.filter { it.from.x == it.to.x || it.from.y == it.to.y }.map { getCoordinatesFromStartToEnd(it) }
        .flatten().groupBy { it }.map { it.value.size }.filter { it > 1 }.count()
}

fun transformInput(fileContent: String): List<Line> {
    return getLinesAsString(fileContent).map { getLineFromString(it) }
}

fun getLineFromString(s: String): Line {
    return s.split(" -> ").map { getCoordinateFromString(it) }.let { Line(it[0], it[1]) }
}

fun getCoordinateFromString(s: String): Coordinate {
    return s.split(",").map(String::toInt).let { Coordinate(it[0], it[1]) }
}

fun getLinesAsString(fileContent: String): List<String> {
    return fileContent.split(System.lineSeparator()).filter { it != "" }
}

data class Line(
    val from: Coordinate,
    val to: Coordinate
)

data class Coordinate(
    val x: Int,
    val y: Int,
)
