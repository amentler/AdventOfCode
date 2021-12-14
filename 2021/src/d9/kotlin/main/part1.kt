package d9p1

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

    var sum = 0

    landscape.forEachIndexed { rowIndex, array ->
        array.forEachIndexed { colIndex, number ->
            var lower = true
            if (rowIndex > 0 && number >= landscape[rowIndex - 1][colIndex])
                lower = false
            if (colIndex > 0 && number >= landscape[rowIndex][colIndex - 1])
                lower = false
            if (colIndex < width - 1 && number >= landscape[rowIndex][colIndex + 1])
                lower = false
            if (rowIndex < height - 1 && number >= landscape[rowIndex + 1][colIndex])
                lower = false

            if (lower) {
                sum += number + 1
            }
        }
    }
    return sum
}
