package d13p1

fun main() {
    val fileContent = object {}.javaClass.getResource("/inputd13.txt")?.readText() as String
    val fileContentInstructions = object {}.javaClass.getResource("/inputd13-2.txt")?.readText() as String

    val sheet = transformSheetInput(fileContent)
    val instructions = transformFoldInstructions(fileContentInstructions)
    println(part1(sheet, instructions))
}

fun transformSheetInput(fileContent: String): Array<BooleanArray> {
    val coordinates = fileContent.split(System.lineSeparator())
        .map { it.split(",").let { Pair(it[0].toInt(), it[1].toInt()) } }
    val maxX = coordinates.maxOf { it.first } + 1
    val maxY = coordinates.maxOf { it.second } + 1
    val array = Array(maxY) { BooleanArray(maxX) { false } }

    coordinates.forEach {
        array[it.second][it.first] = true
    }

    return array
}

fun transformFoldInstructions(fileContent: String): List<FoldInstruction> {
    return fileContent.split(System.lineSeparator())
        .map {
            it.removePrefix("fold along ").trim()
                .split("=").let { FoldInstruction(it[0], it[1].toInt()) }
        }
}

data class FoldInstruction(
    val type: String,
    val coordinate: Int,
)

fun part1(lines: Array<BooleanArray>, instruction: List<FoldInstruction>): Int {
    var myArray = lines
    lines.forEach { it.forEach { print(if (it) "#" else ".") }.let { println() } }
    instruction.forEach {
        if (it.type == "x") {
            myArray = foldVertical(myArray, it)
        } else {
            myArray = foldHorizontal(myArray, it)
        }
    }

    println("RESULT")
    myArray.forEach { it.forEach { print(if (it) "#" else ".") }.let { println() } }

    return myArray.map { it.toList() }.flatten().count { it }
}

fun foldVertical(lines: Array<BooleanArray>, instruction: FoldInstruction): Array<BooleanArray> {
    val result = Array(lines.size) { BooleanArray(instruction.coordinate) { false } }
    for (lineCount in 0 until lines.size) {
        for (rowCount in 0 until instruction.coordinate) {
            result[lineCount][rowCount] = lines[lineCount][rowCount]
        }
    }
    for (lineCount in 0 until lines.size) {
        for (rowCount in instruction.coordinate + 1 until lines[0].size) {
            result[lineCount][instruction.coordinate * 2 - rowCount] =
                lines[lineCount][rowCount] || result[lineCount][instruction.coordinate * 2 - rowCount]
        }
    }

    return result
}


fun foldHorizontal(lines: Array<BooleanArray>, instruction: FoldInstruction): Array<BooleanArray> {
    val result = Array(instruction.coordinate) { BooleanArray(lines[0].size) { false } }
    for (lineCount in 0 until instruction.coordinate) {
        for (rowCount in 0 until lines[0].size) {
            result[lineCount][rowCount] = lines[lineCount][rowCount]
        }
    }
    for (lineCount in instruction.coordinate + 1 until lines.size) {
        for (rowCount in 0 until lines[0].size) {
            result[instruction.coordinate * 2 - lineCount][rowCount] =
                lines[lineCount][rowCount] || result[instruction.coordinate * 2 - lineCount][rowCount]
        }
    }

    return result
}
