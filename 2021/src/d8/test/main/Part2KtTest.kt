package d8p2.test

import d8p2.transformInput
import org.junit.jupiter.api.Test

import org.junit.jupiter.api.Assertions.*

internal class Part2KtTest {

    @Test
    fun part2() {
        val expected = 61229
        val fileContent = object {}.javaClass.getResource("/inputd8")?.readText() as String

        val input = transformInput(fileContent)
        val actual = d8p2.part2(input)

        assertEquals(expected, actual)
    }
    @Test
    fun part21() {
        val expected = 5353

        val input = transformInput("acedgfb cdfbe gcdfa fbcad dab cefabd cdfgeb eafb cagedb ab | cdfeb fcadb cdfeb cdbaf")
        val actual = d8p2.part2(input)

        assertEquals(expected, actual)
    }
}