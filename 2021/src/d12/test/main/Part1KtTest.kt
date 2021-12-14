package d12p1.test

import d12p1.transformInput
import org.junit.jupiter.api.Test

import org.junit.jupiter.api.Assertions.*

internal class Part1KtTest {

    @Test
    fun part1() {
        val expected = 10
        val fileContent = object {}.javaClass.getResource("/inputd12")?.readText() as String

        val edges = transformInput(fileContent)
        val actual = d12p1.part1(edges)

        assertEquals(expected, actual)
    }

    @Test
    fun part1_larger() {
        val expected = 19
        val fileContent = object {}.javaClass.getResource("/inputd12-2")?.readText() as String

        val edges = transformInput(fileContent)
        val actual = d12p1.part1(edges)

        assertEquals(expected, actual)
    }
}