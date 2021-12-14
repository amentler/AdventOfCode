package d10p2

import java.util.*

fun main() {
    val fileContent = object {}.javaClass.getResource("/inputd10")?.readText() as String

    val lines = transformInput(fileContent)
    println(part2(lines))
}

fun transformInput(fileContent: String): List<String> {
    return fileContent.split(System.lineSeparator())
}

val scores = listOf(
    Pair('(', 1),
    Pair('[', 2),
    Pair('{', 3),
    Pair('<', 4)
)

fun part2(lines: List<String>): Long {
    val sums = mutableListOf<Long>()

    lines.forEach {
        var discard = false
        val stack = Stack<Char>()
        it.forEach inner@{
            val char = it
            if (it in "([{<") {
                stack.push(it)
            } else {
                if (!stack.pop().equals(matching(char))) {
                    discard = true
                    return@inner
                }
            }
        }

        if (!discard) {
            var currentSum: Long = 0
            stack.reversed().forEach {
                val char = it
                currentSum *= 5
                currentSum += scores.filter { it.first == char }.map { it.second }.first()
            }
            sums.add(currentSum)
        }
    }

    return sums.sorted().get(sums.size / 2)
}

fun matching(char: Char): Char {
    when (char) {
        ')' -> return '('
        '>' -> return '<'
        '}' -> return '{'
        ']' -> return '['
    }
    return ' '
}

