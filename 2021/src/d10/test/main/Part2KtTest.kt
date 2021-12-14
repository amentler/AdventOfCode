package d10p2.test

import d10p1.transformInput
import org.junit.jupiter.api.Test

import org.junit.jupiter.api.Assertions.*

internal class Part2KtTest {

    @Test
    fun part1() {
        val expected: Long = 288957
        val fileContent = object {}.javaClass.getResource("/inputd10")?.readText() as String

        val lines = transformInput(fileContent)
        val actual = d10p2.part2(lines)

        assertEquals(expected, actual)
    }

    @Test
    fun part12() {
        val expected: Long = 294

        val actual = d10p2.part2(listOf("<{(["))

        assertEquals(expected, actual)
    }
}