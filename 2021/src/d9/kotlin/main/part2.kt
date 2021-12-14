package d9p2

import parsing.to2dIntArray

fun main() {
    val fileContent = object {}.javaClass.getResource("/inputd9")?.readText() as String

    val sum = solve(fileContent)

    println(sum)
}

fun solve(fileContent: String): Int {
    val landscape = fileContent.to2dIntArray()
    val width = landscape[0].size
    val height = landscape.count()

    val basins =
        Array(landscape.size) { IntArray(landscape.first().size) { 0 } } //0 -> 9er landscape, -1 ungesetztes feld und alles drüber ist ne basinID

    val basinSizes = HashMap<Int, Int>()

    var newBasinId = 1

    landscape.forEachIndexed { rowIndex, array ->
        array.forEachIndexed { colIndex, number ->
            newBasinId = mark(landscape, basins, rowIndex, colIndex, newBasinId, width, height, basinSizes)
        }
    }

    val items = basinSizes.toList().sortedBy { it.second }.reversed()
    return items[0].second * items[1].second * items[2].second
}

private fun mark(
    landscape: Array<Array<Int>>,
    basins: Array<IntArray>,
    rowIndex: Int,
    colIndex: Int,
    currentBasinId: Int,
    width: Int,
    height: Int,
    basinSizes: HashMap<Int, Int>
): Int {
    var newBasinId = currentBasinId

    val number = landscape[rowIndex][colIndex]
    if (basins[rowIndex][colIndex] > 0) {
        return newBasinId
    }
    if (number == 9) {
        basins[rowIndex][colIndex] = -1
    } else {
        val basinId = currentBasinId

        basins[rowIndex][colIndex] = basinId
        basinSizes.set(basinId, basinSizes.get(basinId)?.plus(1) ?: 1)

        if (rowIndex > 0 && 0 == basins[rowIndex - 1][colIndex])
            mark(landscape, basins, rowIndex - 1, colIndex, basinId, width, height, basinSizes)
        if (colIndex > 0 && 0 == basins[rowIndex][colIndex - 1])
            mark(landscape, basins, rowIndex, colIndex - 1, basinId, width, height, basinSizes)
        if (colIndex < width - 1 && 0 == basins[rowIndex][colIndex + 1])
            mark(landscape, basins, rowIndex, colIndex + 1, basinId, width, height, basinSizes)
        if (rowIndex < height - 1 && 0 == basins[rowIndex + 1][colIndex])
            mark(landscape, basins, rowIndex + 1, colIndex, basinId, width, height, basinSizes)

        if (basinId == currentBasinId)
            newBasinId += 1

    }

    return newBasinId
}

