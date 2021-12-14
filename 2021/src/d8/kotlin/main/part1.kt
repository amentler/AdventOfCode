package d8p1

fun main() {
    val fileContent = object {}.javaClass.getResource("/inputd8")?.readText() as String

    val lines = transformInput(fileContent)
    println(part1(lines))
}

fun transformInput(fileContent: String): List<Int> {
    val numbersString = fileContent.split(System.lineSeparator())
        .map {
            it.split("|")[1].trim()
                .split(" ")
        }
        .flatten()
    return numbersString.map { it.trim().length }
}

fun part1(numbers: List<Int>): Int {
    val result = numbers.filter { intArrayOf(2, 3, 4, 7).contains(it) }
    return result.count()
}
