package d10p1

import java.util.*

fun main() {
    val fileContent = object {}.javaClass.getResource("/inputd10")?.readText() as String

    val lines = transformInput(fileContent)
    println(part1(lines))
}

fun transformInput(fileContent: String): List<String> {
    return fileContent.split(System.lineSeparator())
}

val scores = listOf(
    Pair(')', 3),
    Pair(']', 57),
    Pair('}', 1197),
    Pair('>', 25137)
)

fun part1(lines: List<String>): Int {
    var sum = 0

    val stack = Stack<Char>()
    lines.forEach outer@{
        it.forEach {
            val char = it
            if (it in "([{<") {
                stack.push(it)
            } else {
                if (!stack.pop().equals(matching(char))) {
                    sum += scores.filter { it.first == char }.map { it.second }.first()
                    return@outer
                }
            }
        }
    }

    return sum
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

