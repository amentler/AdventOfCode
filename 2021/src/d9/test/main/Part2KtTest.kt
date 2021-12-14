package d9p2.test

import org.junit.jupiter.api.Test

import org.junit.jupiter.api.Assertions.*

internal class Part2KtTest {

    @Test
    fun part1() {
        val expected = 1134
        val fileContent = object {}.javaClass.getResource("/inputd9")?.readText() as String

        val actual = d9p2.solve(fileContent)

        assertEquals(expected, actual)
    }
}