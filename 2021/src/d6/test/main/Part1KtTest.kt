package d6p1.test

import d6p1.part1
import d6p1.transformInput
import org.junit.jupiter.api.Test

import org.junit.jupiter.api.Assertions.*

internal class Part1KtTest {

    @Test
    fun part1Test() {
        val expected = 5934
        val fileContent = object {}.javaClass.getResource("/input")?.readText() as String

        val input = transformInput(fileContent)
        val actual = part1(input)

        assertEquals(expected, actual)
    }
}