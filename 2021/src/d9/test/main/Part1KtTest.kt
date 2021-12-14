package d9p1.test

import org.junit.jupiter.api.Test

import org.junit.jupiter.api.Assertions.*

internal class Part1KtTest {

    @Test
    fun part1() {
        val expected = 15
        val fileContent = object {}.javaClass.getResource("/inputd9")?.readText() as String

        val actual = d9p1.solve(fileContent)

        assertEquals(expected, actual)
    }
}