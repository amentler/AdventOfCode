package d8p1.test

import d8p1.transformInput
import org.junit.jupiter.api.Test

import org.junit.jupiter.api.Assertions.*

internal class Part1KtTest {

    @Test
    fun part1() {
        val expected = 26
        val fileContent = object {}.javaClass.getResource("/inputd8")?.readText() as String

        val input = transformInput(fileContent)
        val actual = d8p1.part1(input)

        assertEquals(expected, actual)
    }
}