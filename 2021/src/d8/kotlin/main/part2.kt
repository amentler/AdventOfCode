package d8p2

import kotlin.math.absoluteValue

fun main() {
    val fileContent = object {}.javaClass.getResource("/inputd8")?.readText() as String

    val lines = transformInput(fileContent)
    println(part2(lines))
}

fun transformInput(fileContent: String): List<Pair<Input, Output>> {
    val inputs = fileContent.split(System.lineSeparator(), "|", " ").nonEmptyOrWhitespace()

    return inputs.chunked(14).map { Pair(Input(it.take(10)), Output(it.drop(10).take(4))) }
}

fun part2(pairs: List<Pair<Input, Output>>): Int {
    return pairs.sumOf { solve(it) }
}

fun solve(line: Pair<Input, Output>): Int {
    val digits = identifyDigits(line.first.Inputs)

    var result = 0
    line.second.Outputs.forEachIndexed { index, it ->
        val partial = Math.pow(10.toDouble(), 3-index.toDouble() ).toInt() * digits.indexOfFirst { s -> s == it.ordered() }
        result += partial
    }

    return result
}

fun identifyDigits(numberStrings: List<String>): Array<String> {
    val result = Array<String>(10) { "" }
    result[1] = numberStrings.filter { it.count() == 2 }.first().ordered()
    result[7] = numberStrings.filter { it.count() == 3 }.first().ordered()
    result[8] = "abcdefg"
    result[4] = numberStrings.filter { it.count() == 4 }.first().ordered()


    var upperRightLED = result[1][0]
    var lowerRightLED = result[1][1]
    if (numberStrings.countChar(result[1][0]) > numberStrings.countChar(result[1][1])) {
        upperRightLED = result[1][1]
        lowerRightLED = result[1][0]
    }

    numberStrings.filter { it.count() == 5 }.forEach {
        when {
            !it.contains(lowerRightLED) -> result[2] = it.ordered()
            !it.contains(upperRightLED) -> result[5] = it.ordered()
            it.contains(upperRightLED) && it.contains(lowerRightLED) -> result[3] = it.ordered()
        }
    }

    numberStrings.filter { it.count() == 6 }.forEach {
        when {
            !it.contains(upperRightLED) -> result[6] = it.ordered()
            it.containsAll(result[4]) -> result[9] = it.ordered()
            else -> result[0] = it.ordered()
        }
    }

    return result
}

private fun String.containsAll(s: String): Boolean {
    s.forEach { if (!this.contains(it)) return false }
    return true
}

fun String.ordered(): String {
    return toCharArray().sorted().joinToString("")
}

fun List<String>.countChar(char: Char): Int {
    return this.sumOf { it.count { it == char } }
}

data class Solution(
    val input: Input,
    val output: Output
)

data class Input(
    val Inputs: List<String>
)

data class Output(
    val Outputs: List<String>
)

fun List<String>.nonEmptyOrWhitespace(): List<String> {
    return this.filter { it.trim().length > 0 }
}

fun String.toIntList(): List<Int> {
    return this.split(',').map { it.trim().toInt() }
}
