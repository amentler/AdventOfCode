package d10p1.test

import d10p1.transformInput
import org.junit.jupiter.api.Test

import org.junit.jupiter.api.Assertions.*

internal class Part1KtTest {

    @Test
    fun part1() {
        val expected = 26397
        val fileContent = object {}.javaClass.getResource("/inputd10")?.readText() as String

        val lines = transformInput(fileContent)
        val actual = d10p1.part1(lines)

        assertEquals(expected, actual)
    }
}